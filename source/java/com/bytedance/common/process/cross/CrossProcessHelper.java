package com.bytedance.common.process.cross;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.common.model.MethodCallRecord;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.service.BaseCrossProcessService;
import com.bytedance.common.process.service.CrossProcessServiceForMain;
import com.bytedance.common.process.service.CrossProcessServiceForPush;
import com.bytedance.common.process.service.CrossProcessServiceForPushService;
import com.bytedance.common.process.service.CrossProcessServiceForSmp;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IPushCommonInitConfigProvider;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.push_common_lib.ICrossProcessAIDL;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrossProcessHelper {
    public static final String CALL_METHOD_RESULT_ERROR = "error";
    public static final String CALL_METHOD_RESULT_LATER_SUCCESS = "later_success";
    public static final String CROSS_METHOD_ON_APP_STATUS_CHANGED = "onAppStatusChanged";
    private static volatile CrossProcessHelper instance = null;
    private static boolean sEnableCrossProcess = true;
    private Context mContext;
    private ProcessEnum mCurProcess;
    private volatile Map<String, IMethodObserver> mMethodObserverMap;
    private Map<ProcessEnum, String> mTargetProcessServiceMap;
    private final String TAG = "CrossProcessHelper";
    private final AtomicBoolean mInit = new AtomicBoolean(false);
    private ServiceConnection mServiceConnection = new DefaultServiceConnection();
    private final Map<ProcessEnum, Set<ICrossProcessAbilityInitListener>> crossProcessAbilityInitListenerMap = new HashMap();
    private Map<ProcessEnum, ICrossProcessAIDL> mICrossProcessAIDLMap = new HashMap();
    private Map<ProcessEnum, List<MethodCallRecord>> mNeedToCallMethod = new HashMap();

    public static CrossProcessHelper getInstance() {
        if (instance == null) {
            synchronized (CrossProcessHelper.class) {
                if (instance == null) {
                    instance = new CrossProcessHelper();
                }
            }
        }
        return instance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    class DefaultServiceConnection implements ServiceConnection {
        DefaultServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                CrossProcessHelper.this.handleServiceConnectedOnChildThread(componentName, iBinder);
            } else {
                ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.process.cross.CrossProcessHelper.DefaultServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CrossProcessHelper.this.handleServiceConnectedOnChildThread(componentName, iBinder);
                    }
                });
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            String actualComponentName = CrossProcessHelper.this.getActualComponentName(componentName);
            for (Map.Entry entry : CrossProcessHelper.this.mTargetProcessServiceMap.entrySet()) {
                if (TextUtils.equals((CharSequence) entry.getValue(), actualComponentName)) {
                    Logger.d("CrossProcessHelper", CrossProcessHelper.this.mCurProcess + " process delete" + entry.getKey() + " process handle");
                    CrossProcessHelper.this.mICrossProcessAIDLMap.remove(entry.getKey());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getActualComponentName(ComponentName componentName) {
        String className = componentName.getClassName();
        if (this.mTargetProcessServiceMap.values().contains(className)) {
            return className;
        }
        try {
            ServiceInfo[] serviceInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 4).services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (TextUtils.equals(className, serviceInfo.name)) {
                        ProcessEnum parseProcess = ProcessEnum.parseProcess(serviceInfo.processName, this.mContext.getPackageName());
                        String str = this.mTargetProcessServiceMap.get(parseProcess);
                        Logger.d("CrossProcessHelper", "[getActualComponentName]actualComponent process:" + parseProcess + " actualComponentName:" + str);
                        return str;
                    }
                }
            }
        } catch (Throwable th) {
            Logger.e("CrossProcessHelper", "[getActualComponentName]exception:" + th.getLocalizedMessage());
        }
        return className;
    }

    public void addTargetProcessAbilityInitListener(ProcessEnum processEnum, ICrossProcessAbilityInitListener iCrossProcessAbilityInitListener) {
        Logger.d("CrossProcessHelper", "addTargetProcessAbilityInitListener for " + processEnum);
        if (this.mICrossProcessAIDLMap.get(processEnum) != null) {
            iCrossProcessAbilityInitListener.initFinished();
            return;
        }
        synchronized (this.crossProcessAbilityInitListenerMap) {
            Set<ICrossProcessAbilityInitListener> set = this.crossProcessAbilityInitListenerMap.get(processEnum);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(iCrossProcessAbilityInitListener);
            this.crossProcessAbilityInitListenerMap.put(processEnum, set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServiceConnectedOnChildThread(ComponentName componentName, IBinder iBinder) {
        String actualComponentName = getActualComponentName(componentName);
        for (Map.Entry<ProcessEnum, String> entry : this.mTargetProcessServiceMap.entrySet()) {
            if (TextUtils.equals(entry.getValue(), actualComponentName)) {
                ProcessEnum key = entry.getKey();
                Logger.d("CrossProcessHelper", this.mCurProcess + " process holds " + key + " process handle");
                this.mICrossProcessAIDLMap.put(key, ICrossProcessAIDL.Stub.asInterface(iBinder));
                synchronized (this.crossProcessAbilityInitListenerMap) {
                    Set<ICrossProcessAbilityInitListener> set = this.crossProcessAbilityInitListenerMap.get(key);
                    Logger.d("CrossProcessHelper", "callback InitListener for " + key + ",listener size:" + (set == null ? 0 : set.size()));
                    if (set != null) {
                        Iterator<ICrossProcessAbilityInitListener> it = set.iterator();
                        while (it.hasNext()) {
                            it.next().initFinished();
                        }
                    }
                    this.crossProcessAbilityInitListenerMap.remove(key);
                }
                handlePreMethodCall(this.mCurProcess, key);
                return;
            }
        }
    }

    private void handlePreMethodCall(ProcessEnum processEnum, ProcessEnum processEnum2) {
        List<MethodCallRecord> nextBatchRecords = CrossProcessDatabaseHelper.getInstance(this.mContext).getNextBatchRecords(processEnum, processEnum2);
        String str = "error";
        while (nextBatchRecords != null && nextBatchRecords.size() > 0) {
            Iterator<MethodCallRecord> it = nextBatchRecords.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MethodCallRecord next = it.next();
                Logger.d("CrossProcessHelper", "handlePreMethodCall :" + next.toString());
                String callMethod = callMethod(processEnum2, next.getMethodName(), next.getListArgs());
                if (TextUtils.equals(callMethod, "error")) {
                    str = callMethod;
                    break;
                } else {
                    CrossProcessDatabaseHelper.getInstance(this.mContext).deleteRecord(next.getId());
                    str = callMethod;
                }
            }
            if (TextUtils.equals(str, "error")) {
                return;
            } else {
                nextBatchRecords = CrossProcessDatabaseHelper.getInstance(this.mContext).getNextBatchRecords(processEnum, processEnum2);
            }
        }
    }

    private CrossProcessHelper() {
        HashMap hashMap = new HashMap();
        this.mTargetProcessServiceMap = hashMap;
        hashMap.put(ProcessEnum.MAIN, CrossProcessServiceForMain.class.getName());
        this.mTargetProcessServiceMap.put(ProcessEnum.PUSH, CrossProcessServiceForPush.class.getName());
        this.mTargetProcessServiceMap.put(ProcessEnum.PUSH_SERVICE, CrossProcessServiceForPushService.class.getName());
        this.mTargetProcessServiceMap.put(ProcessEnum.SMP, CrossProcessServiceForSmp.class.getName());
        Application app = AppProvider.getApp();
        this.mContext = app;
        this.mCurProcess = ToolUtils.getCurProcess(app);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.common.process.cross.CrossProcessHelper.1
            @Override // java.lang.Runnable
            public void run() {
                CrossProcessHelper.this.init();
            }
        });
    }

    public static void disableCrossProcess() {
        sEnableCrossProcess = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        if (this.mInit.getAndSet(true)) {
            return;
        }
        Logger.d("CrossProcessHelper", "init is called in " + this.mCurProcess);
        if (!sEnableCrossProcess) {
            Logger.d("CrossProcessHelper", "sEnableCrossProcess is false,do nothing");
            return;
        }
        if (this.mTargetProcessServiceMap.keySet().contains(this.mCurProcess)) {
            List<String> processList = getProcessList(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
            String packageName = this.mContext.getPackageName();
            Logger.d("CrossProcessHelper", "process list size:" + processList.size());
            Iterator<String> it = processList.iterator();
            while (it.hasNext()) {
                ProcessEnum parseProcess = ProcessEnum.parseProcess(it.next(), packageName);
                Logger.d("CrossProcessHelper", "itemProcess is " + parseProcess);
                if (this.mCurProcess != parseProcess) {
                    bindTargetProcess(parseProcess, false);
                }
            }
        }
    }

    private void bindTargetProcess(ProcessEnum processEnum, boolean z) {
        try {
            String str = this.mTargetProcessServiceMap.get(processEnum);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            boolean z2 = false;
            try {
                if (Class.forName(str) != null) {
                    z2 = true;
                }
            } catch (Throwable unused) {
            }
            if (!z2) {
                Logger.e("CrossProcessHelper", str + " is invalid,not bind");
                return;
            }
            ServiceConnection serviceConnection = this.mServiceConnection;
            if (processEnum == ProcessEnum.MAIN) {
                serviceConnection = new DefaultServiceConnection() { // from class: com.bytedance.common.process.cross.CrossProcessHelper.2
                    @Override // com.bytedance.common.process.cross.CrossProcessHelper.DefaultServiceConnection, android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
                        super.onServiceConnected(componentName, iBinder);
                        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.common.process.cross.CrossProcessHelper.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ToolUtils.isSmpProcess(CrossProcessHelper.this.mContext)) {
                                    return;
                                }
                                PushCommonSupport.getInstance().getSecurityService().onHoldMainProcessBinder(iBinder);
                            }
                        });
                    }
                };
            }
            Logger.d("CrossProcessHelper", this.mCurProcess + " process bind the " + processEnum + " of service , targetService is " + str);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(this.mContext.getPackageName(), str));
            intent.putExtra("process", this.mCurProcess.processSuffix);
            intent.putExtra(BaseCrossProcessService.EXTRA_KEY_IS_FROM_ON_BIND, z);
            intent.setType(this.mCurProcess.processSuffix);
            this.mContext.bindService(intent, serviceConnection, 1);
        } catch (Throwable th) {
            Logger.e("CrossProcessHelper", "error to bindTargetProcess" + th.getMessage());
        }
    }

    public List<String> getProcessList(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Throwable th) {
            Logger.e("CrossProcessHelper", "[getProcessList]exception ", th);
            th.printStackTrace();
        }
        if (!ToolUtils.isActiveUser(context)) {
            Logger.d("CrossProcessHelper", "[getProcessList]return empty list because cur is not active user");
            return arrayList;
        }
        List runningAppProcesses = ToolUtils.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return arrayList;
        }
        Iterator it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            arrayList.add(((ActivityManager.RunningAppProcessInfo) it.next()).processName);
        }
        return arrayList;
    }

    private Map<String, IMethodObserver> getMethodObserverMap() {
        if (this.mMethodObserverMap == null) {
            synchronized (this) {
                if (this.mMethodObserverMap == null) {
                    this.mMethodObserverMap = new HashMap();
                    IPushCommonInitConfigProvider iPushCommonInitConfigProvider = (IPushCommonInitConfigProvider) UgBusFramework.getService(IPushCommonInitConfigProvider.class);
                    if (iPushCommonInitConfigProvider != null && iPushCommonInitConfigProvider.getMethodObservers() != null) {
                        for (IMethodObserver iMethodObserver : iPushCommonInitConfigProvider.getMethodObservers()) {
                            this.mMethodObserverMap.put(iMethodObserver.getMethodName(), iMethodObserver);
                        }
                    }
                }
            }
        }
        return this.mMethodObserverMap;
    }

    public void registerMethodObserver(IMethodObserver iMethodObserver) {
        Logger.d("CrossProcessHelper", this.mCurProcess + " register " + iMethodObserver.getMethodName() + " observer:" + iMethodObserver.toString());
        getMethodObserverMap().put(iMethodObserver.getMethodName(), iMethodObserver);
    }

    public void unRegisterMethodObserver(IMethodObserver iMethodObserver) {
        Logger.d("CrossProcessHelper", this.mCurProcess + " unregister " + iMethodObserver.getMethodName() + " observer:" + iMethodObserver.toString());
        getMethodObserverMap().remove(iMethodObserver.getMethodName());
    }

    public String onMethodCall(ProcessEnum processEnum, String str, List list) {
        Logger.d("CrossProcessHelper", this.mCurProcess + " receive method call " + str + " from " + processEnum);
        IMethodObserver iMethodObserver = getMethodObserverMap().get(str);
        return iMethodObserver != null ? iMethodObserver.onMethodCall(processEnum, list) : "error";
    }

    public String callMethod(ProcessEnum processEnum, String str, List list, boolean z) {
        return callMethodInternal(processEnum, str, list, z);
    }

    private String callMethodInternal(ProcessEnum processEnum, String str, List list, boolean z) {
        String callMethod = callMethod(processEnum, str, list);
        if (!z || !TextUtils.equals(callMethod, "error")) {
            return callMethod;
        }
        Logger.d("CrossProcessHelper", "callMethod Failed , write it to database");
        CrossProcessDatabaseHelper.getInstance(this.mContext).insertMethodRecord(new MethodCallRecord(this.mCurProcess.processSuffix, processEnum.processSuffix, str, list));
        return CALL_METHOD_RESULT_LATER_SUCCESS;
    }

    public String callMethod(ProcessEnum processEnum, String str, List list) {
        if (processEnum == this.mCurProcess) {
            Logger.d("CrossProcessHelper", "[callMethod]targetProcess==mCurProcess,invoke onMethodCall,method:" + str);
            return onMethodCall(this.mCurProcess, str, list);
        }
        ICrossProcessAIDL iCrossProcessAIDL = this.mICrossProcessAIDLMap.get(processEnum);
        if (iCrossProcessAIDL == null) {
            Logger.w("CrossProcessHelper", this.mCurProcess + " process callMethod failed because iCrossProcessAIDL is null, targetProcess is " + processEnum + " method is " + str);
            return "error";
        }
        try {
            return iCrossProcessAIDL.invoke(str, this.mCurProcess.processSuffix, list);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public void onServiceBind(String str) {
        ProcessEnum parseProcess = ProcessEnum.parseProcess(str);
        boolean contains = this.mTargetProcessServiceMap.keySet().contains(parseProcess);
        Logger.d("CrossProcessHelper", this.mCurProcess.processSuffix + " process be bind by " + str + " processEnumsContainsOriginProcess is " + contains + " aidl is " + this.mICrossProcessAIDLMap.get(parseProcess));
        if (contains && this.mICrossProcessAIDLMap.get(parseProcess) == null) {
            bindTargetProcess(parseProcess, true);
        }
    }
}
