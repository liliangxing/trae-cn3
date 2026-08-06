package com.ss.alive.monitor.services.impl;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alive.monitor.IMonitorCallback;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.android.ManifestData;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.proxy.AbsMethodInvokeProxy;
import com.bytedance.push.proxy.ActivityManagerHooker;
import com.bytedance.push.proxy.ActivityTaskManagerHooker;
import com.bytedance.push.proxy.MethodProxyResult;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.LocalSettings$;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.PushOnlineSettings$;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.assosiation.start.AssociationStartSettingsModel;
import com.bytedance.push.settings.assosiation.start.ComponentProcessInfo;
import com.bytedance.push.settings.storage.SharedPreferenceStorage;
import com.bytedance.push.utils.Logger;
import com.ss.alive.monitor.interfaze.OnComponentStartListener;
import com.ss.alive.monitor.model.StartRecord;
import com.ss.alive.monitor.model.StartType;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorService;
import com.ss.alive.monitor.support.AliveMonitoringSupport;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AssociationStartMonitorServiceImpl extends AbsMethodInvokeProxy implements IAssociationStartMonitorService, OnComponentStartListener {
    private static boolean sMonitorChildProcessStart;
    private AssociationStartSettingsModel mAssociationStartSettingsModel;
    private final Context mContext;
    private final boolean mCurIsSmpProcess;
    private int mHasTryHookActivityManagerTimes;
    private int mHasTryHookActivityTaskManagerTimes;
    private IMonitorCallback mIMonitorCallback;
    private long mInitTimeStamp;
    private final String mPkgName;
    private final ProcessEnum mProcessEnum;
    List<String> mPushComponents;
    List<String> mPushServiceComponents;
    List<String> mSmpComponents;
    private final String TAG = "AssociationStartMonitorService";
    private final String ORIGIN_TAG = "AssociationStartMonitorServiceImpl_Origin";
    private final boolean PRINT_STACK = false;
    private final String HOOK_NAME_ACTIVITY_MANAGER = "ActivityManager";
    private final String HOOK_NAME_ACTIVITY_TASK_MANAGER = "ActivityTaskManager";
    private final String METHOD_NAME_START_SERVICE_FOREGROUND = "setServiceForeground";
    private final String METHOD_NAME_GET_INTENT_SENDER_WITH_FEATURE = "getIntentSenderWithFeature";
    private final int MSG_WHAT_HOOK_ACTIVITY_MANAGER_SUCCESS = 10141757;
    private final int MSG_WHAT_HOOK_ACTIVITY_TASK_MANAGER_SUCCESS = 10141758;
    private final int NEXT_TRY_INTERVAL_IN_MILL = 1000;
    private final int MAX_TRY_HOOK_TIMES = 5;
    private final AtomicBoolean mStartEd = new AtomicBoolean(false);
    private Map<String, String> mReplaceComponentMap = new HashMap();
    private boolean mHookActivityManagerSuccess = false;
    private boolean mHookActivityTaskManagerSuccess = false;
    private boolean mEnableMonitorNotificationShow = false;
    private Handler mHandler = new Handler(PushThreadHandlerManager.inst().getLooper(), new Handler.Callback() { // from class: com.ss.alive.monitor.services.impl.AssociationStartMonitorServiceImpl.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Logger.d("AssociationStartMonitorService", "handle msg:" + message.what);
            switch (message.what) {
                case 10141757:
                    AssociationStartMonitorServiceImpl.this.mHookActivityManagerSuccess = true;
                    if (AssociationStartMonitorServiceImpl.this.mIMonitorCallback != null) {
                        AssociationStartMonitorServiceImpl.this.mIMonitorCallback.onHookActivityManagerResult(true);
                    }
                    return true;
                case 10141758:
                    AssociationStartMonitorServiceImpl.this.mHookActivityTaskManagerSuccess = true;
                    if (AssociationStartMonitorServiceImpl.this.mIMonitorCallback != null) {
                        AssociationStartMonitorServiceImpl.this.mIMonitorCallback.onHookActivityTaskManagerResult(true);
                    }
                    return true;
                default:
                    return false;
            }
        }
    });

    public AssociationStartMonitorServiceImpl(Context context) {
        this.mSmpComponents = new ArrayList();
        this.mPushComponents = new ArrayList();
        this.mPushServiceComponents = new ArrayList();
        this.mContext = context;
        this.mPkgName = context.getPackageName();
        ProcessEnum curProcess = ToolUtils.getCurProcess(context);
        this.mProcessEnum = curProcess;
        this.mInitTimeStamp = ToolUtils.currentTimeMillis();
        this.mCurIsSmpProcess = ToolUtils.isSmpProcess(context);
        this.mHasTryHookActivityManagerTimes = 0;
        this.mHasTryHookActivityTaskManagerTimes = 0;
        String curProcessName = ToolUtils.getCurProcessName(context);
        if (!TextUtils.isEmpty(curProcessName)) {
            if (curProcessName.endsWith(ToolUtils.SMP_PROCESS_SUFFIX)) {
                this.mReplaceComponentMap.put("com.xiaomi.mipush.sdk.MessageHandleService", "com.xiaomi.mipush.sdk.SmpMessageHandleService");
                this.mReplaceComponentMap.put("com.xiaomi.mipush.sdk.MIPushMessageHandler", "com.xiaomi.mipush.sdk.SmpMIPushMessageHandler");
                this.mReplaceComponentMap.put("com.xiaomi.mipush.sdk.PushMessageHandler", "com.xiaomi.mipush.sdk.SmpPushMessageHandler");
                this.mSmpComponents = getTargetProcessComponent(ToolUtils.SMP_PROCESS_SUFFIX);
            } else if (curProcessName.endsWith(ToolUtils.SMP_PROCESS_SUFFIX_V2)) {
                this.mReplaceComponentMap.put("com.xiaomi.mipush.sdk.MessageHandleService", "com.xiaomi.mipush.sdk.WidgetProviderMessageHandleService");
                this.mReplaceComponentMap.put("com.xiaomi.mipush.sdk.MIPushMessageHandler", "com.xiaomi.mipush.sdk.WidgetProviderMIPushMessageHandler");
                this.mReplaceComponentMap.put("com.xiaomi.mipush.sdk.PushMessageHandler", "com.xiaomi.mipush.sdk.WidgetProviderPushMessageHandler");
                this.mSmpComponents = getTargetProcessComponent(ToolUtils.SMP_PROCESS_SUFFIX_V2);
            }
        }
        if ((!ToolUtils.isMainProcess(context) || PushServiceManager.get().getPushExternalService().allowStartNonMainProcess()) && !sMonitorChildProcessStart) {
            return;
        }
        if (curProcess != ProcessEnum.PUSH) {
            this.mPushComponents = getTargetProcessComponent(TTProcessUtils.MESSAGE_PROCESS_SUFFIX);
        }
        if (curProcess != ProcessEnum.PUSH_SERVICE) {
            this.mPushServiceComponents = getTargetProcessComponent(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX);
        }
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorService
    public void startMonitor(IMonitorCallback iMonitorCallback) {
        this.mIMonitorCallback = iMonitorCallback;
        if (hasHookActivityManagerSuccess()) {
            this.mIMonitorCallback.onHookActivityManagerResult(true);
        }
        if (hasHookActivityTaskManagerSuccess()) {
            this.mIMonitorCallback.onHookActivityTaskManagerResult(true);
        }
        startMonitor();
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorService
    public boolean hasHookActivityManagerSuccess() {
        return this.mHookActivityManagerSuccess;
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorService
    public boolean hasHookActivityTaskManagerSuccess() {
        return this.mHookActivityTaskManagerSuccess;
    }

    public static void monitorChildProcessStart() {
        sMonitorChildProcessStart = true;
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorService
    public void startMonitor() {
        PushOnlineSettings pushOnlineSettings;
        if (this.mStartEd.getAndSet(true)) {
            return;
        }
        ProcessEnum curProcess = ToolUtils.getCurProcess(this.mContext);
        if (this.mCurIsSmpProcess) {
            pushOnlineSettings = getPushOnlineSettingsOnSmp(this.mContext);
        } else {
            pushOnlineSettings = getPushOnlineSettings(this.mContext);
        }
        this.mAssociationStartSettingsModel = pushOnlineSettings.getAssociationStartSettings();
        Logger.d("AssociationStartMonitorService", "[" + curProcess.processSuffix + "] on monitorAssociationStart enableAssociationHook is " + this.mAssociationStartSettingsModel.enableAssociationHook + " enableAssociationStartMonitor is " + this.mAssociationStartSettingsModel.enableAssociationStartMonitor + " enableAssociationStartIntercept is " + this.mAssociationStartSettingsModel.enableAssociationStartIntercept + " interceptComponentWhiteList is " + this.mAssociationStartSettingsModel.interceptComponentWhiteList + " interceptComponentBlackList is " + this.mAssociationStartSettingsModel.interceptComponentBlackList + " isolationInterceptComponentBlackList is " + this.mAssociationStartSettingsModel.isolationInterceptComponentBlackList + " monitorComponentWhiteList is " + this.mAssociationStartSettingsModel.monitorComponentBlackList + " smpRedirectMap is " + this.mAssociationStartSettingsModel.isolationRedirectMap);
        if (this.mAssociationStartSettingsModel.enableAssociationStartMonitor && !this.mCurIsSmpProcess) {
            AliveMonitoringSupport.getSupport().getAssociationStartMonitorEventService().enableReport(true);
        }
        if (this.mCurIsSmpProcess) {
            this.mReplaceComponentMap.putAll(this.mAssociationStartSettingsModel.isolationRedirectMap);
        }
        if (this.mCurIsSmpProcess && !PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp()) {
            Logger.d("AssociationStartMonitorService", "[" + curProcess.processSuffix + "] enable hook because mCurIsSmpProcess and allowStartOthersProcessFromSmp is false");
            this.mAssociationStartSettingsModel.enableAssociationHook = true;
        }
        if (ToolUtils.isMainProcess(this.mContext) && !PushServiceManager.get().getPushExternalService().allowStartNonMainProcess()) {
            Logger.d("AssociationStartMonitorService", "[" + curProcess.processSuffix + "] enable hook because allowStartNonMainProcess is false");
            this.mAssociationStartSettingsModel.enableAssociationHook = true;
        }
        if (sMonitorChildProcessStart) {
            Logger.d("AssociationStartMonitorService", "[" + curProcess.processSuffix + "] enable hook because mMonitorChildProcessStart is true");
            this.mAssociationStartSettingsModel.enableAssociationHook = true;
        }
        if (!this.mCurIsSmpProcess) {
            this.mEnableMonitorNotificationShow = pushOnlineSettings.getNotificationMonitorSettings().enableMonitorNotificationShow;
        }
        if (this.mEnableMonitorNotificationShow) {
            Logger.d("AssociationStartMonitorService", "[" + curProcess.processSuffix + "] enable hook because enableMonitorNotificationShow is true");
            this.mAssociationStartSettingsModel.enableAssociationHook = true;
        }
        if (this.mAssociationStartSettingsModel.enableAssociationHook) {
            hookActivityManager(this.mHasTryHookActivityManagerTimes);
            hookActivityTaskManager(this.mHasTryHookActivityTaskManagerTimes);
        }
    }

    private PushOnlineSettings getPushOnlineSettings(Context context) {
        return (PushOnlineSettings) SettingsManager.obtain(context, PushOnlineSettings.class);
    }

    private PushOnlineSettings getPushOnlineSettingsOnSmp(Context context) {
        return new PushOnlineSettings$.SettingImpl(new SharedPreferenceStorage(context, PushMultiProcessSharedProvider.SP_CONFIG_NAME));
    }

    private LocalSettings getPushLocalSettingsOnSmp(Context context) {
        return new LocalSettings$.SettingImpl(context, new SharedPreferenceStorage(context, PushMultiProcessSharedProvider.SP_CONFIG_NAME));
    }

    private List<String> getTargetProcessComponent(String str) {
        LocalSettings localSettings;
        ArrayList arrayList = new ArrayList();
        String str2 = "[get " + str + " ProcessComponent]";
        try {
            if (this.mCurIsSmpProcess) {
                localSettings = getPushLocalSettingsOnSmp(this.mContext);
            } else {
                localSettings = (LocalSettings) SettingsManager.obtain(this.mContext, LocalSettings.class);
            }
            ComponentProcessInfo componentProcessInfo = localSettings.getComponentProcessInfo();
            int i = ManifestData.getInt(this.mContext, "UPDATE_VERSION_CODE");
            Logger.d("AssociationStartMonitorService", str2 + " updateVersionCode:" + i + " componentProcessInfo：" + componentProcessInfo);
            if (i == componentProcessInfo.updateVersionCode) {
                List<String> targetProcessComponents = componentProcessInfo.getTargetProcessComponents(str);
                if (targetProcessComponents != null) {
                    Logger.d("AssociationStartMonitorService", str2 + " use cache component info,component size:" + targetProcessComponents.size());
                    return targetProcessComponents;
                }
            } else {
                Logger.d("AssociationStartMonitorService", str2 + "update version code changed,get new component info");
            }
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 15);
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (serviceInfo.processName.endsWith(str)) {
                        Logger.d("AssociationStartMonitorService", str2 + " service:" + serviceInfo.name);
                        arrayList.add(serviceInfo.name);
                    }
                }
            }
            ActivityInfo[] activityInfoArr = packageInfo.activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (activityInfo.processName.endsWith(str)) {
                        Logger.d("AssociationStartMonitorService", str2 + " activity: " + activityInfo.name);
                        arrayList.add(activityInfo.name);
                    }
                }
            }
            ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
            if (activityInfoArr2 != null) {
                for (ActivityInfo activityInfo2 : activityInfoArr2) {
                    if (activityInfo2.processName.endsWith(str)) {
                        Logger.d("AssociationStartMonitorService", str2 + " receiver: " + activityInfo2.name);
                        arrayList.add(activityInfo2.name);
                    }
                }
            }
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (providerInfo.processName.endsWith(str)) {
                        Logger.d("AssociationStartMonitorService", str2 + " provider: " + providerInfo.authority);
                        arrayList.add(providerInfo.authority);
                    }
                }
            }
            String listToStringDivideByComma = ToolUtils.listToStringDivideByComma(arrayList);
            Logger.d("AssociationStartMonitorService", str2 + " save cur component info,updateVersionCode:" + i + " componentInfo size:" + arrayList.size());
            if (componentProcessInfo.componentInfo == null) {
                componentProcessInfo.componentInfo = new HashMap();
            }
            componentProcessInfo.componentInfo.put(str, listToStringDivideByComma);
            componentProcessInfo.updateVersionCode = i;
            localSettings.setComponentProcessInfo(componentProcessInfo);
        } catch (Throwable th) {
            Logger.e("AssociationStartMonitorService", str2 + " exception ", th);
        }
        return arrayList;
    }

    private void hookActivityManager(int i) {
        if (ActivityManagerHooker.getInstance().addMethodInvokeProxy(this)) {
            AliveMonitoringSupport.getSupport().getAssociationStartMonitorEventService().onHookResult("ActivityManager", true, "success", ToolUtils.currentTimeMillis() - this.mInitTimeStamp);
            this.mHandler.sendEmptyMessage(10141757);
        } else {
            Logger.e("AssociationStartMonitorService", "error when hook IActivityManager for AssociationStartMonitor");
            AliveMonitoringSupport.getSupport().getAssociationStartMonitorEventService().onHookResult("ActivityManager", false, "hook failed", ToolUtils.currentTimeMillis() - this.mInitTimeStamp);
        }
    }

    private void hookActivityTaskManager(int i) {
        if (ActivityTaskManagerHooker.getInstance().addMethodInvokeProxy(this)) {
            AliveMonitoringSupport.getSupport().getAssociationStartMonitorEventService().onHookResult("ActivityTaskManager", true, "success", ToolUtils.currentTimeMillis() - this.mInitTimeStamp);
            this.mHandler.sendEmptyMessage(10141758);
        } else {
            AliveMonitoringSupport.getSupport().getAssociationStartMonitorEventService().onHookResult("ActivityTaskManager", false, "hook failed", ToolUtils.currentTimeMillis() - this.mInitTimeStamp);
        }
    }

    @Override // com.ss.alive.monitor.interfaze.OnComponentStartListener
    public void onComponentStart(final StartRecord startRecord) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.services.impl.AssociationStartMonitorServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    AssociationStartMonitorServiceImpl.this.onComponentStartInternal(startRecord);
                }
            });
        } else {
            onComponentStartInternal(startRecord);
        }
    }

    public void onComponentStartInternal(StartRecord startRecord) {
        if (startRecord != null) {
            try {
                String stackTraceStr = startRecord.getStackTraceStr();
                if (!TextUtils.equals(startRecord.getTargetPkg(), this.mPkgName)) {
                    if (!TextUtils.isEmpty(stackTraceStr) && !stackTraceStr.contains("com.ss.alive.monitor.services.impl.AssociationStartMonitorEventServiceImpl.onAssociationStartEvent")) {
                        AliveMonitoringSupport.getSupport().getAssociationStartMonitorEventService().onAssociationStartEvent(startRecord);
                    } else {
                        Logger.e("AssociationStartMonitorService", "[onComponentStartInternal]not invoke onAssociationStartEvent because loop invoke");
                    }
                } else {
                    Logger.e("AssociationStartMonitorService", "[onComponentStartInternal]not invoke onAssociationStartEvent because cur startRecord is not cross app");
                }
                if ((!ToolUtils.isMainProcess(this.mContext) || PushServiceManager.get().getPushExternalService().allowStartNonMainProcess()) && !sMonitorChildProcessStart) {
                    return;
                }
                if (this.mPushComponents.contains(startRecord.getTargetComponent())) {
                    onDelayStartChildProcessFailed(startRecord, ProcessEnum.PUSH.processSuffix);
                } else if (this.mPushServiceComponents.contains(startRecord.getTargetComponent())) {
                    onDelayStartChildProcessFailed(startRecord, ProcessEnum.PUSH_SERVICE.processSuffix);
                }
            } catch (Throwable th) {
                Logger.e("AssociationStartMonitorService", "onComponentStart error:" + th.getMessage());
                Logger.e("AssociationStartMonitorService", Log.getStackTraceString(th));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #0 {all -> 0x00c8, blocks: (B:3:0x0003, B:5:0x000e, B:14:0x001a, B:16:0x0025, B:17:0x0031, B:19:0x003b, B:20:0x0048, B:22:0x0052, B:25:0x005a, B:27:0x0064, B:29:0x0074, B:31:0x007a, B:41:0x006a, B:43:0x0070, B:45:0x008e, B:47:0x0098, B:48:0x00a3, B:50:0x00ad, B:52:0x00b4, B:53:0x00c1, B:54:0x00b7, B:56:0x00bd), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private StartRecord parseStartRecord(String str, Object[] objArr, boolean z) {
        StartRecord startRecord;
        StartRecord startRecord2;
        Intent intent;
        String str2;
        String str3;
        try {
        } catch (Throwable th) {
            th = th;
            startRecord = null;
        }
        if (TextUtils.equals(str, StartType.START_SERVICE.methodName)) {
            startRecord2 = parseStartRecordFromIntent(StartType.START_SERVICE, (Intent) objArr[1], z);
        } else if (TextUtils.equals(str, StartType.BIND_SERVICE.methodName)) {
            startRecord2 = parseStartRecordFromIntent(StartType.BIND_SERVICE, (Intent) objArr[2], z);
        } else if (TextUtils.equals(str, StartType.PROVIDER_GET_TYPE.methodName)) {
            startRecord2 = parseStartRecordFromUri(StartType.PROVIDER_GET_TYPE, (Uri) objArr[0], z);
        } else {
            if (TextUtils.equals(str, StartType.PROVIDER_QUERY.methodName)) {
                Object obj = objArr[2];
                String str4 = "";
                if (obj instanceof String) {
                    str3 = (String) obj;
                    if (TextUtils.equals(str3, this.mPkgName)) {
                        str4 = this.mPkgName;
                    }
                } else {
                    Object obj2 = objArr[1];
                    if (obj2 instanceof String) {
                        str3 = (String) obj2;
                    } else {
                        str2 = "";
                        if (!TextUtils.isEmpty(str4)) {
                            startRecord = parseStartRecordFromProviderName(StartType.PROVIDER_QUERY, str4, z);
                            try {
                                if (!TextUtils.isEmpty(str2)) {
                                    startRecord.setTargetPkg(str2);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                Logger.e("AssociationStartMonitorService", "error when parse startRecord ", th);
                                startRecord2 = startRecord;
                                if (startRecord2 != null) {
                                }
                                return startRecord2;
                            }
                            startRecord2 = startRecord;
                        }
                    }
                }
                String str5 = str4;
                str4 = str3;
                str2 = str5;
                if (!TextUtils.isEmpty(str4)) {
                }
            } else if (TextUtils.equals(str, StartType.SEND_BROADCAST.methodName)) {
                startRecord2 = parseStartRecordFromIntent(StartType.SEND_BROADCAST, (Intent) objArr[1], z);
            } else if (TextUtils.equals(str, StartType.START_ACTIVITY.methodName)) {
                Object obj3 = objArr[3];
                if (obj3 instanceof Intent) {
                    intent = (Intent) obj3;
                } else {
                    Object obj4 = objArr[2];
                    intent = obj4 instanceof Intent ? (Intent) obj4 : null;
                }
                startRecord2 = parseStartRecordFromIntent(StartType.START_ACTIVITY, intent, z);
            }
            startRecord2 = null;
        }
        if (startRecord2 != null || !this.mAssociationStartSettingsModel.monitorComponentBlackList.contains(startRecord2.getTargetComponent())) {
            return startRecord2;
        }
        Logger.d("AssociationStartMonitorService", startRecord2.getTargetComponent() + " is in monitorComponentWhiteList so not monitor it , monitorComponentWhiteList is " + this.mAssociationStartSettingsModel.monitorComponentBlackList.toString());
        return null;
    }

    private StartRecord parseStartRecordFromProviderName(StartType startType, String str, boolean z) {
        if (!z && (TextUtils.isEmpty(str) || str.startsWith(this.mPkgName))) {
            return null;
        }
        StartRecord startRecord = new StartRecord();
        startRecord.setStartType(startType);
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String stackTraceString = Log.getStackTraceString(new Throwable());
        startRecord.setClientTime(ToolUtils.currentTimeMillis());
        startRecord.setTargetComponent(str);
        startRecord.setProcess(this.mProcessEnum.processSuffix);
        startRecord.setStackTrace(stackTrace, stackTraceString);
        return startRecord;
    }

    private StartRecord parseStartRecordFromUri(StartType startType, Uri uri, boolean z) {
        if (uri != null) {
            String host = uri.getHost();
            if (z || (host != null && !host.startsWith(this.mPkgName))) {
                StartRecord startRecord = new StartRecord();
                startRecord.setStartType(startType);
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                String stackTraceString = Log.getStackTraceString(new Throwable());
                startRecord.setClientTime(ToolUtils.currentTimeMillis());
                startRecord.setIsForeGround(isForeGround());
                startRecord.setTargetComponent(uri.toString());
                startRecord.setProcess(this.mProcessEnum.processSuffix);
                startRecord.setStackTrace(stackTrace, stackTraceString);
                return startRecord;
            }
        }
        return null;
    }

    private StartRecord parseStartRecordFromIntent(StartType startType, Intent intent, boolean z) {
        if (intent != null) {
            String str = intent.getPackage();
            ComponentName component = intent.getComponent();
            if (component != null) {
                if (z || (!TextUtils.equals(str, this.mPkgName) && !TextUtils.equals(component.getPackageName(), this.mPkgName))) {
                    StartRecord startRecord = new StartRecord();
                    startRecord.setStartType(startType);
                    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                    String stackTraceString = Log.getStackTraceString(new Throwable());
                    startRecord.setClientTime(ToolUtils.currentTimeMillis());
                    startRecord.setIsForeGround(isForeGround());
                    startRecord.setTargetPkg(str);
                    startRecord.setTargetComponent(component.getClassName());
                    startRecord.setProcess(this.mProcessEnum.processSuffix);
                    startRecord.setStackTrace(stackTrace, stackTraceString);
                    return startRecord;
                }
            } else if (!TextUtils.isEmpty(intent.getAction())) {
                StartRecord startRecord2 = new StartRecord();
                startRecord2.setStartType(startType);
                StackTraceElement[] stackTrace2 = new Throwable().getStackTrace();
                String stackTraceString2 = Log.getStackTraceString(new Throwable());
                startRecord2.setClientTime(ToolUtils.currentTimeMillis());
                startRecord2.setIsForeGround(isForeGround());
                startRecord2.setTargetPkg(str);
                startRecord2.setTargetComponent(intent.getAction());
                startRecord2.setProcess(this.mProcessEnum.processSuffix);
                startRecord2.setStackTrace(stackTrace2, stackTraceString2);
                return startRecord2;
            }
        }
        return null;
    }

    private boolean isForeGround() {
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        Logger.d("AssociationStartMonitorService", "[isForeGround]allowReadFile:" + ((pushCommonConfiguration == null || pushCommonConfiguration.mIPushCommonConfiguration == null || pushCommonConfiguration.mIPushCommonConfiguration.fixAssociationStartMonitorServiceAnr()) ? false : true));
        return !AppStatusObserverForChildProcess.sIsInBackGround(r0);
    }

    public MethodProxyResult proxyMethodInvoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        List<String> list;
        final StartRecord parseStartRecord = parseStartRecord(method.getName(), objArr, true);
        onComponentStart(parseStartRecord);
        MethodProxyResult methodProxyResult = new MethodProxyResult();
        Intent intent = null;
        if (parseStartRecord != null) {
            if (this.mCurIsSmpProcess && !PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp() && ((list = this.mSmpComponents) == null || list.size() == 0 || !this.mSmpComponents.contains(parseStartRecord.getTargetComponent()))) {
                Logger.d("AssociationStartMonitorService", "find non smp component on smp process:" + method.getName() + " " + parseStartRecord.getTargetComponent() + " " + Log.getStackTraceString(new Throwable()));
                Boolean isMainProcessStart = ToolUtils.isMainProcessStart(this.mContext);
                if (isMainProcessStart == null || !isMainProcessStart.booleanValue()) {
                    if (redirect(method.getName(), objArr)) {
                        return methodProxyResult;
                    }
                    if (this.mAssociationStartSettingsModel.isolationInterceptComponentBlackList.contains(parseStartRecord.getTargetComponent())) {
                        Logger.d("AssociationStartMonitorService", "intercept ：" + parseStartRecord.getTargetComponent() + " because it's in smpInterceptComponentBlackList");
                        String name = method.getName();
                        if (TextUtils.equals(name, StartType.START_SERVICE.methodName)) {
                            Intent intent2 = (Intent) objArr[1];
                            methodProxyResult.intercept = true;
                            methodProxyResult.result = intent2.getComponent();
                        } else {
                            if (TextUtils.equals(name, StartType.BIND_SERVICE.methodName)) {
                                methodProxyResult.result = 1;
                                methodProxyResult.intercept = true;
                                return methodProxyResult;
                            }
                            if (TextUtils.equals(name, StartType.PROVIDER_GET_TYPE.methodName)) {
                                methodProxyResult.result = null;
                                methodProxyResult.intercept = true;
                                return methodProxyResult;
                            }
                            if (TextUtils.equals(name, StartType.PROVIDER_QUERY.methodName)) {
                                methodProxyResult.result = null;
                                methodProxyResult.intercept = true;
                                return methodProxyResult;
                            }
                            if (TextUtils.equals(name, StartType.SEND_BROADCAST.methodName)) {
                                methodProxyResult.result = 0;
                                methodProxyResult.intercept = true;
                                return methodProxyResult;
                            }
                            if (TextUtils.equals(name, StartType.START_ACTIVITY.methodName)) {
                                methodProxyResult.result = 0;
                                methodProxyResult.intercept = true;
                                return methodProxyResult;
                            }
                            Logger.e("AssociationStartMonitorService", "intercept ：" + parseStartRecord.getTargetComponent() + " failed");
                        }
                    }
                    Logger.d("AssociationStartMonitorService", "smpProcessMonitor: redirectSuccess is false , report alliance_process_isolation_error event");
                    ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.services.impl.AssociationStartMonitorServiceImpl.3
                        @Override // java.lang.Runnable
                        public void run() {
                            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("alliance_process_isolation_error", parseStartRecord.toJson());
                        }
                    });
                }
            }
            if (this.mAssociationStartSettingsModel.interceptComponentBlackList.contains(parseStartRecord.getTargetComponent())) {
                Logger.d("AssociationStartMonitorService", "intercept ：" + parseStartRecord.getTargetComponent() + " because it's in interceptComponentBlackList");
                return null;
            }
            if (!this.mAssociationStartSettingsModel.enableAssociationStartIntercept) {
                return methodProxyResult;
            }
            Logger.d("AssociationStartMonitorService", "enableAssociationStartIntercept is true, try intercept it: " + parseStartRecord.getTargetComponent());
            if (this.mAssociationStartSettingsModel.interceptComponentWhiteList.contains(parseStartRecord.getTargetComponent())) {
                Logger.d("AssociationStartMonitorService", "try intercept it：" + parseStartRecord.getTargetComponent() + " is in interceptComponentWhiteList so not intercept");
                return methodProxyResult;
            }
            Logger.d("AssociationStartMonitorService", "try intercept it：" + parseStartRecord.getTargetComponent() + " is not in interceptComponentWhiteList so intercept");
            methodProxyResult.intercept = true;
            return methodProxyResult;
        }
        if (TextUtils.equals(method.getName(), "setServiceForeground")) {
            if (this.mEnableMonitorNotificationShow && objArr != null) {
                Notification notification = null;
                ComponentName componentName = null;
                for (Object obj2 : objArr) {
                    if (componentName == null && (obj2 instanceof ComponentName)) {
                        componentName = (ComponentName) obj2;
                    }
                    if (notification == null && (obj2 instanceof Notification)) {
                        notification = (Notification) obj2;
                    }
                }
                if (notification != null && !PushServiceManager.get().getPushExternalService().getNotificationMonitorService().onForeGroundNotificationShow(componentName, notification)) {
                    return null;
                }
            }
        } else if (TextUtils.equals(method.getName(), "getIntentSenderWithFeature") && this.mEnableMonitorNotificationShow) {
            if (objArr != null) {
                try {
                    Intent[] intentArr = (Intent[]) objArr[6];
                    if (intentArr.length > 0) {
                        intent = intentArr[0];
                    }
                } catch (Throwable th) {
                    Logger.e("AssociationStartMonitorService", "error when parse intent ", th);
                }
            }
            if (intent != null && obj != null) {
                Object invoke = method.invoke(obj, objArr);
                PushServiceManager.get().getPushExternalService().getNotificationMonitorService().onPendingIntent(invoke, intent);
                methodProxyResult.intercept = true;
                methodProxyResult.result = invoke;
            }
        }
        return methodProxyResult;
    }

    private boolean redirect(String str, Object[] objArr) {
        Intent intent;
        ComponentName component;
        String str2;
        String str3;
        ComponentName component2;
        String str4;
        ComponentName component3;
        String str5;
        try {
            if (TextUtils.equals(str, StartType.START_SERVICE.methodName)) {
                Intent intent2 = (Intent) objArr[1];
                if (intent2 != null && (component3 = intent2.getComponent()) != null && (str5 = this.mReplaceComponentMap.get(component3.getClassName())) != null && !TextUtils.isEmpty(str5)) {
                    intent2.setComponent(new ComponentName(this.mContext.getPackageName(), str5));
                    objArr[1] = intent2;
                    Logger.d("AssociationStartMonitorService", "smpProcessMonitor: replace " + component3.getClassName() + " to " + str5);
                    return true;
                }
            } else if (TextUtils.equals(str, StartType.BIND_SERVICE.methodName)) {
                Intent intent3 = (Intent) objArr[2];
                if (intent3 != null && (component2 = intent3.getComponent()) != null && (str4 = this.mReplaceComponentMap.get(component2.getClassName())) != null && !TextUtils.isEmpty(str4)) {
                    intent3.setComponent(new ComponentName(this.mContext.getPackageName(), str4));
                    objArr[2] = intent3;
                    Logger.d("AssociationStartMonitorService", "smpProcessMonitor: replace " + component2.getClassName() + " to " + str4);
                    return true;
                }
            } else if (TextUtils.equals(str, StartType.PROVIDER_GET_TYPE.methodName)) {
                Uri uri = (Uri) objArr[0];
                if (uri != null) {
                    String str6 = this.mReplaceComponentMap.get(uri.toString());
                    if (!TextUtils.isEmpty(str6)) {
                        objArr[0] = Uri.parse(str6).buildUpon().build();
                        Logger.d("AssociationStartMonitorService", "smpProcessMonitor: replace " + uri + " to " + str6);
                        return true;
                    }
                }
            } else if (TextUtils.equals(str, StartType.PROVIDER_QUERY.methodName)) {
                String str7 = "";
                Object obj = objArr[2];
                if (obj instanceof String) {
                    str7 = (String) obj;
                } else {
                    Object obj2 = objArr[1];
                    if (obj2 instanceof String) {
                        str7 = (String) obj2;
                    }
                }
                if (!TextUtils.isEmpty(str7)) {
                    String str8 = this.mReplaceComponentMap.get(str7);
                    if (!TextUtils.isEmpty(str8)) {
                        if (objArr[2] instanceof String) {
                            objArr[2] = str8;
                        } else if (objArr[1] instanceof String) {
                            objArr[1] = str8;
                        }
                        Logger.d("AssociationStartMonitorService", "smpProcessMonitor: replace " + str7 + " to " + str8);
                        return true;
                    }
                }
            } else if (TextUtils.equals(str, StartType.SEND_BROADCAST.methodName)) {
                Intent intent4 = (Intent) objArr[1];
                ComponentName component4 = intent4.getComponent();
                if (component4 != null && (str3 = this.mReplaceComponentMap.get(component4.getClassName())) != null && !TextUtils.isEmpty(str3)) {
                    intent4.setComponent(new ComponentName(this.mContext.getPackageName(), str3));
                    objArr[1] = intent4;
                    Logger.d("AssociationStartMonitorService", "smpProcessMonitor: replace " + component4.getClassName() + " to " + str3);
                    return true;
                }
            } else if (TextUtils.equals(str, StartType.START_ACTIVITY.methodName)) {
                Object obj3 = objArr[3];
                if (obj3 instanceof Intent) {
                    intent = (Intent) obj3;
                } else {
                    Object obj4 = objArr[2];
                    intent = obj4 instanceof Intent ? (Intent) obj4 : null;
                }
                if (intent != null && (component = intent.getComponent()) != null && (str2 = this.mReplaceComponentMap.get(component.getClassName())) != null && !TextUtils.isEmpty(str2)) {
                    intent.setComponent(new ComponentName(this.mContext.getPackageName(), str2));
                    if (objArr[3] instanceof Intent) {
                        objArr[3] = intent;
                    } else if (objArr[2] instanceof Intent) {
                        objArr[2] = intent;
                    }
                    Logger.d("AssociationStartMonitorService", "smpProcessMonitor: replace " + component.getClassName() + " to " + str2);
                    return true;
                }
            }
        } catch (Throwable th) {
            Logger.e("AssociationStartMonitorService", "error when redirect ", th);
        }
        return false;
    }

    private void onDelayStartChildProcessFailed(final StartRecord startRecord, final String str) {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.services.impl.AssociationStartMonitorServiceImpl.4
            @Override // java.lang.Runnable
            public void run() {
                JSONObject json = startRecord.toJson();
                try {
                    json.put("target_process", str);
                    json.put("delay_time", ToolUtils.currentTimeMillis() - AssociationStartMonitorServiceImpl.this.mInitTimeStamp);
                } catch (Throwable th) {
                    Logger.e("AssociationStartMonitorService", "[onDelayStartChildProcessFailed]error when add json ", th);
                }
                PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_delay_start_child_process_error", json);
            }
        });
    }
}
