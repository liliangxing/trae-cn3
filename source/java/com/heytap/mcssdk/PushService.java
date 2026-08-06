package com.heytap.mcssdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C0879b;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.p010a.C0871a;
import com.heytap.mcssdk.p011b.C0874a;
import com.heytap.mcssdk.p012c.C0876a;
import com.heytap.mcssdk.p012c.C0877b;
import com.heytap.mcssdk.p014e.C0884a;
import com.heytap.mcssdk.p014e.C0885b;
import com.heytap.mcssdk.p014e.InterfaceC0887d;
import com.heytap.mcssdk.p015f.C0888a;
import com.heytap.mcssdk.p015f.C0889b;
import com.heytap.mcssdk.p015f.InterfaceC0890c;
import com.heytap.mcssdk.utils.C0895d;
import com.heytap.mcssdk.utils.C0898g;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.statis.StatisticUtils;
import com.mcs.aidl.IMcsSdkService;
import com.mcs.aidl.INotifiPermissionCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PushService implements InterfaceC0873b {
    private static final String ACTION_NOTIFICATION_ADVANCE = "com.heytap.mcs.action.NOTIFICATION_ADVANCE";
    private static final int ANDROID_T_SDK_VERSION_CODE = 32;
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_VERSION_CODE = "versionCode";
    private static final String APP_VERSION_NAME = "versionName";
    private static final int DEFAULT_API_MAX_COUNT = 2;
    private static final String EVENT_ID = "eventID";
    private static final String EXTRA = "extra";
    private static final String GLOBAL_ID = "globalID";
    private static final String KEY_CALLBACK = "result_callback";
    private static final int MAX_HOUR_IN_DAY = 23;
    private static final int MAX_MIN_IN_HOUR = 59;
    private static final int MCS_SUPPORT_VERSION = 1019;
    private static final String MESSAGE_ID = "messageID";
    private static final String MESSAGE_TYPE = "messageType";
    public static final String MINI_PROGRAM_PKG = "miniProgramPkg";
    private static final String NEW_MCS_RECEIVE_SDK_ACTION_Base64 = "Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ==";
    private static final String PUSH_SDK_VERSION = "pushSdkVersion";
    private static final int SDK_INT_24 = 24;
    private static final String SUPPORT_OPEN_PUSH = "supportOpenPush";
    private static final int SYSTEM_UID = 1000;
    private static final String TAG = "PushService";
    private static final String TASK_ID = "taskID";
    private static final String TYPE = "type";
    private static boolean sIsNewMcsPkg;
    private static String sMcsPkgName;
    private ConcurrentHashMap<Integer, C0876a> mAppLimitMap;
    private String mAuthCode;
    private Context mContext;
    private ICallBackResultService mICallBackResultService;
    private IGetAppNotificationCallBackService mIGetAppNotificationCallBackService;
    private ISetAppNotificationCallBackService mISetAppNotificationCallBackService;
    private List<InterfaceC0887d> mParsers;
    private PermissionCallbackProxy mPermissionCallback;
    private List<InterfaceC0890c> mProcessors;
    private String mRegisterID;
    private String mVerifyCode;
    private boolean needStaticRegister;
    private static final int[] OLD_MCS_PACKAGE = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] OLD_MCS_RECEIVE_SDK_ACTION = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static final int[] NEW_MCS_PACKAGE = {99, 111, 109, 46, 104, 101, 121, 116, 97, 112, 46, 109, 99, 115};
    private static String NEW_MCS_RECEIVE_SDK_ACTION = "";
    private static int sCount = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class PermissionCallbackProxy extends INotifiPermissionCallback.Stub {

        /* renamed from: a */
        private static final long f456a = 2000;

        /* renamed from: b */
        private INotificationPermissionCallback f457b;

        /* renamed from: c */
        private long f458c = 0;

        /* renamed from: b */
        private boolean m537b() {
            return SystemClock.elapsedRealtime() - this.f458c <= f456a;
        }

        /* renamed from: c */
        private void m538c() {
            this.f458c = SystemClock.elapsedRealtime();
        }

        /* renamed from: d */
        private void m539d() {
            this.f458c = 0L;
        }

        /* renamed from: a */
        public void m540a() {
            m539d();
            this.f457b = null;
        }

        /* renamed from: a */
        public boolean m541a(INotificationPermissionCallback iNotificationPermissionCallback) {
            if (m537b()) {
                return false;
            }
            m538c();
            this.f457b = iNotificationPermissionCallback;
            return true;
        }

        public void onFail(int i, String str) {
            m539d();
            INotificationPermissionCallback iNotificationPermissionCallback = this.f457b;
            if (iNotificationPermissionCallback != null) {
                iNotificationPermissionCallback.onFail(i, str);
            }
            this.f457b = null;
        }

        public void onSuccess() {
            m539d();
            INotificationPermissionCallback iNotificationPermissionCallback = this.f457b;
            if (iNotificationPermissionCallback != null) {
                iNotificationPermissionCallback.onSuccess();
            }
            this.f457b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.heytap.mcssdk.PushService$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class C0868a {

        /* renamed from: a */
        private static final PushService f459a = new PushService();

        private C0868a() {
        }
    }

    private PushService() {
        this.mProcessors = new ArrayList();
        this.mParsers = new ArrayList();
        this.mRegisterID = null;
        this.needStaticRegister = true;
        this.mPermissionCallback = new PermissionCallbackProxy();
        synchronized (PushService.class) {
            int i = sCount;
            if (i > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            sCount = i + 1;
        }
        addParser(new C0885b());
        addParser(new C0884a());
        addProcessor(new C0889b());
        addProcessor(new C0888a());
        this.mAppLimitMap = new ConcurrentHashMap<>();
    }

    private C0876a addCommandToMap(int i) {
        String str;
        if (!this.mAppLimitMap.containsKey(Integer.valueOf(i))) {
            C0876a c0876a = new C0876a(System.currentTimeMillis(), 1);
            this.mAppLimitMap.put(Integer.valueOf(i), c0876a);
            C0895d.m661b("addCommandToMap :appBean is null");
            return c0876a;
        }
        C0876a c0876a2 = this.mAppLimitMap.get(Integer.valueOf(i));
        if (checkTimeNeedUpdate(c0876a2)) {
            c0876a2.m584a(1);
            c0876a2.m585a(System.currentTimeMillis());
            str = "addCommandToMap : appLimitBean.setCount(1)";
        } else {
            c0876a2.m584a(c0876a2.m586b() + 1);
            str = "addCommandToMap :appLimitBean.getCount() + 1";
        }
        C0895d.m661b(str);
        return c0876a2;
    }

    private synchronized void addParser(InterfaceC0887d interfaceC0887d) {
        if (interfaceC0887d != null) {
            this.mParsers.add(interfaceC0887d);
        }
    }

    private synchronized void addProcessor(InterfaceC0890c interfaceC0890c) {
        if (interfaceC0890c != null) {
            this.mProcessors.add(interfaceC0890c);
        }
    }

    private boolean checkAll() {
        return checkContext() && checkRegisterID();
    }

    private boolean checkContext() {
        return this.mContext != null;
    }

    private boolean checkRegisterID() {
        return this.mRegisterID != null;
    }

    private boolean checkTimeNeedUpdate(C0876a c0876a) {
        long m583a = c0876a.m583a();
        long currentTimeMillis = System.currentTimeMillis();
        C0895d.m661b("checkTimeNeedUpdate : lastedTime " + m583a + " currentTime:" + currentTimeMillis);
        return currentTimeMillis - m583a > 1000;
    }

    private boolean checkTop(Activity activity) {
        String name;
        ComponentName componentName;
        ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
        List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
        if (appTasks != null && appTasks.size() > 0) {
            ActivityManager.AppTask appTask = appTasks.get(0);
            if (appTask.getTaskInfo().topActivity != null) {
                name = activity.getClass().getName();
                componentName = appTask.getTaskInfo().topActivity;
                return name.equals(componentName.getClassName());
            }
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        name = activity.getClass().getName();
        componentName = runningTaskInfo.topActivity;
        return name.equals(componentName.getClassName());
    }

    public static PushService getInstance() {
        return C0868a.f459a;
    }

    private Intent getIntent(int i, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(getReceiveSdkAction(this.mContext));
        intent.setPackage(getMcsPackageName(this.mContext));
        intent.putExtra("type", i);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.mContext;
            jSONObject2.putOpt(APP_VERSION_NAME, Utils.getVersionName(context, context.getPackageName()));
            Context context2 = this.mContext;
            jSONObject2.putOpt(APP_VERSION_CODE, Integer.valueOf(Utils.getVersionCode(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.mContext.getPackageName());
        intent.putExtra(C0879b.f582z, this.mAuthCode);
        intent.putExtra(C0879b.f552A, this.mVerifyCode);
        intent.putExtra(C0879b.f553B, this.mRegisterID);
        intent.putExtra(C0879b.f554C, getSDKVersionName());
        intent.putExtra(C0879b.f556E, getUserId(this.mContext));
        return intent;
    }

    private String getMcsPackageNameInner(Context context) {
        String str = TAG;
        C0895d.m662b(str, "getMcsPackageNameInner -- ");
        PackageManager packageManager = context.getPackageManager();
        try {
            try {
                try {
                    String string = Utils.getString(NEW_MCS_PACKAGE);
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(string, 0);
                    if (applicationInfo != null) {
                        boolean z = (applicationInfo.flags & 1) == 1;
                        int packageUid = packageManager.getPackageUid("android", 0);
                        int i = applicationInfo.uid;
                        int m692a = C0898g.m692a();
                        r4 = (z || (C0898g.m693a(i, m692a) == packageUid)) ? string : null;
                        C0895d.m662b(str, "getMcsPackageNameInner packageUid = " + i + ", systemUid = " + packageUid + ", userId = " + m692a);
                    }
                    return r4;
                } catch (Exception e) {
                    C0895d.m674e(TAG, "Error in get mcs package name:" + e.getMessage());
                    return r4;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                C0895d.m674e(TAG, "NameNotFoundException in get mcs package name:" + e2.getMessage());
                return r4;
            }
        } catch (Throwable unused) {
            return r4;
        }
    }

    public static int getSDKVersionCode() {
        return C0870a.f465f;
    }

    public static String getSDKVersionName() {
        return C0870a.f466g;
    }

    private int getUserId(Context context) {
        try {
            return ((Integer) Context.class.getMethod("getUserId", new Class[0]).invoke(context, new Object[0])).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private boolean isSupportPushInner(Context context) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        String mcsPackageName = getMcsPackageName(this.mContext);
        boolean z = Utils.isExistPackage(this.mContext, mcsPackageName) && Utils.getVersionCode(this.mContext, mcsPackageName) >= 1019 && Utils.isSupportPush(this.mContext, mcsPackageName, SUPPORT_OPEN_PUSH);
        C0895d.m662b(TAG, "isSupportPushInner -- " + z);
        return z;
    }

    @Deprecated
    private static void onAppStart(Context context) {
        StatUtil.statisticMessage(context, new MessageStat(context.getPackageName(), "app_start", null));
    }

    private void startMcsService(int i, String str, JSONObject jSONObject) {
        if (checkCommandLimit(i)) {
            if (this.mICallBackResultService != null) {
                this.mICallBackResultService.onError(getErrorCode(i), "api_call_too_frequently", this.mContext.getPackageName(), getMiniProgramPkgFromJSON(jSONObject));
                return;
            }
            return;
        }
        try {
            this.mContext.startService(getIntent(i, str, jSONObject));
        } catch (Exception e) {
            C0895d.m673e("startMcsService--Exception" + e.getMessage());
        }
    }

    private void startMcsService(int i, JSONObject jSONObject) {
        startMcsService(i, "", jSONObject);
    }

    public void bindMcsService(int i) {
        if (!checkCommandLimit(i)) {
            final Intent intent = getIntent(i, "", null);
            this.mContext.bindService(intent, new ServiceConnection() { // from class: com.heytap.mcssdk.PushService.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Bundle bundle = new Bundle();
                    bundle.putAll(intent.getExtras());
                    try {
                        IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
                    } catch (Exception e) {
                        C0895d.m661b("bindMcsService exception:" + e);
                    }
                    PushService.this.mContext.unbindService(this);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }
            }, 1);
        } else {
            ICallBackResultService iCallBackResultService = this.mICallBackResultService;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(getErrorCode(i), "api_call_too_frequently", this.mContext.getPackageName(), "");
            }
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void cancelNotification(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_CANCEL_NOTIFICATION, jSONObject);
        } else {
            C0895d.m674e(C0895d.f621a, "please call the register first!");
        }
    }

    public boolean checkCommandLimit(int i) {
        return (i == 12291 || i == 12312 || addCommandToMap(i).m586b() <= 2) ? false : true;
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void clearNotificationAdvanceCallback() {
        this.mPermissionCallback.m540a();
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void clearNotificationType() {
        clearNotificationType(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void clearNotificationType(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } else {
            C0895d.m674e(C0895d.f621a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void clearNotifications() {
        clearNotifications(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void clearNotifications(JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } else {
            C0895d.m674e(C0895d.f621a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mISetAppNotificationCallBackService = iSetAppNotificationCallBackService;
            startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        } else if (getPushCallback() != null) {
            this.mISetAppNotificationCallBackService.onSetAppNotificationSwitch(-2);
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mISetAppNotificationCallBackService = iSetAppNotificationCallBackService;
            startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
        } else {
            ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.mISetAppNotificationCallBackService;
            if (iSetAppNotificationCallBackService2 != null) {
                iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
            }
        }
    }

    public Map<Integer, C0876a> getAppLimitMap() {
        return this.mAppLimitMap;
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        if (checkContext()) {
            this.mIGetAppNotificationCallBackService = iGetAppNotificationCallBackService;
            startMcsService(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET, null);
        } else {
            IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.mIGetAppNotificationCallBackService;
            if (iGetAppNotificationCallBackService2 != null) {
                iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
            }
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getErrorCode(int i) {
        switch (i) {
            case MessageConstant.CommandId.COMMAND_REGISTER /* 12289 */:
                return -1;
            case MessageConstant.CommandId.COMMAND_UNREGISTER /* 12290 */:
                return -2;
            case MessageConstant.CommandId.COMMAND_STATISTIC /* 12291 */:
                return -14;
            default:
                switch (i) {
                    case MessageConstant.CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                        return -11;
                    case MessageConstant.CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                        return -3;
                    case MessageConstant.CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                        return -4;
                    default:
                        switch (i) {
                            case MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS /* 12306 */:
                                return -10;
                            case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                                return -6;
                            case MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                                return -7;
                            case MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                                return -5;
                            case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS /* 12310 */:
                                return -8;
                            case MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION /* 12311 */:
                                return -9;
                            case MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK /* 12312 */:
                                return -13;
                            case MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE /* 12313 */:
                                return -12;
                            default:
                                switch (i) {
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                        return -15;
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                        return -16;
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                        return -17;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    public String getMcsPackageName(Context context) {
        boolean z;
        if (sMcsPkgName == null) {
            String mcsPackageNameInner = getMcsPackageNameInner(context);
            if (mcsPackageNameInner == null) {
                sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
                z = false;
            } else {
                sMcsPkgName = mcsPackageNameInner;
                z = true;
            }
            sIsNewMcsPkg = z;
        }
        return sMcsPkgName;
    }

    public String getMiniProgramPkgFromJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            try {
                return jSONObject.optString("miniProgramPkg");
            } catch (Exception e) {
                C0895d.m661b("Error happened in getMiniProgramPkgFromJSON() :" + e.getMessage());
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void getNotificationStatus() {
        getNotificationStatus(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void getNotificationStatus(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onGetNotificationStatus(-2, 0);
        }
    }

    public List<InterfaceC0887d> getParsers() {
        return this.mParsers;
    }

    public List<InterfaceC0890c> getProcessors() {
        return this.mProcessors;
    }

    public ICallBackResultService getPushCallback() {
        return this.mICallBackResultService;
    }

    public IGetAppNotificationCallBackService getPushGetAppNotificationCallBack() {
        return this.mIGetAppNotificationCallBackService;
    }

    public ISetAppNotificationCallBackService getPushSetAppNotificationCallBack() {
        return this.mISetAppNotificationCallBackService;
    }

    public void getPushStatus() {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS, null);
        } else if (getPushCallback() != null) {
            getPushCallback().onGetPushStatus(-2, 0);
        }
    }

    public int getPushVersionCode() {
        if (!checkContext()) {
            return 0;
        }
        Context context = this.mContext;
        return Utils.getVersionCode(context, getMcsPackageName(context));
    }

    public String getPushVersionName() {
        if (!checkContext()) {
            return "";
        }
        Context context = this.mContext;
        return Utils.getVersionName(context, getMcsPackageName(context));
    }

    public String getReceiveSdkAction(Context context) {
        if (sMcsPkgName == null) {
            getMcsPackageNameInner(context);
        }
        if (!sIsNewMcsPkg) {
            return Utils.getString(OLD_MCS_RECEIVE_SDK_ACTION);
        }
        if (TextUtils.isEmpty(NEW_MCS_RECEIVE_SDK_ACTION)) {
            NEW_MCS_RECEIVE_SDK_ACTION = new String(C0871a.m551b(NEW_MCS_RECEIVE_SDK_ACTION_Base64));
        }
        return NEW_MCS_RECEIVE_SDK_ACTION;
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void getRegister() {
        getRegister(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void getRegister(JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onRegister(-2, null, null, null);
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public String getRegisterID() {
        return this.mRegisterID;
    }

    public PushService init(Context context, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        innerInit(context);
        new C0874a().m581a(this.mContext);
        C0895d.m678f(z);
        return this;
    }

    public void innerInit(Context context) {
        boolean z;
        this.mContext = context.getApplicationContext();
        if (sMcsPkgName == null) {
            String mcsPackageNameInner = getMcsPackageNameInner(context);
            if (mcsPackageNameInner == null) {
                sMcsPkgName = Utils.getString(OLD_MCS_PACKAGE);
                z = false;
            } else {
                sMcsPkgName = mcsPackageNameInner;
                z = true;
            }
            sIsNewMcsPkg = z;
        }
    }

    public boolean isSupportPushByClient(Context context) {
        return isSupportPushInner(context);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void openNotificationSettings() {
        openNotificationSettings(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void openNotificationSettings(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } else {
            C0895d.m674e(C0895d.f621a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void pausePush() {
        pausePush(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void pausePush(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_PAUSE_PUSH, jSONObject);
        } else {
            C0895d.m674e(C0895d.f621a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null, null, null);
                return;
            }
            return;
        }
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        if (!Utils.isSupportPushByClient(this.mContext)) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null, null, null);
                return;
            }
            return;
        }
        if (this.needStaticRegister) {
            C0895d.m662b("registerAction:", "Will static push_register event :");
            StatisticUtils.statisticEvent(this.mContext, "push_register");
            this.needStaticRegister = false;
        }
        this.mAuthCode = str;
        this.mVerifyCode = str2;
        this.mICallBackResultService = iCallBackResultService;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.putOpt("appVersionCode", Integer.valueOf(Utils.getVersionCode(context)));
            jSONObject.putOpt("appVersionName", Utils.getVersionName(context));
        } catch (JSONException e) {
            C0895d.m673e("register-Exception:" + e.getMessage());
        }
        startMcsService(MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void requestNotificationAdvance(Activity activity, INotificationPermissionCallback iNotificationPermissionCallback, int i) {
        if (activity == null) {
            if (iNotificationPermissionCallback != null) {
                iNotificationPermissionCallback.onFail(2000, null);
                return;
            }
            return;
        }
        if (checkCommandLimit(MessageConstant.CommandId.COMMAND_NOTIFICATION_ADVANCE)) {
            if (iNotificationPermissionCallback != null) {
                iNotificationPermissionCallback.onFail(2004, null);
                return;
            }
            return;
        }
        if (!checkTop(activity)) {
            if (iNotificationPermissionCallback != null) {
                iNotificationPermissionCallback.onFail(2001, null);
                return;
            }
            return;
        }
        if (activity.checkPermission("android.permission.POST_NOTIFICATIONS", Process.myPid(), Process.myUid()) == 0) {
            if (iNotificationPermissionCallback != null) {
                iNotificationPermissionCallback.onFail(2002, null);
                return;
            }
            return;
        }
        if (!this.mPermissionCallback.m541a(iNotificationPermissionCallback)) {
            if (iNotificationPermissionCallback != null) {
                iNotificationPermissionCallback.onFail(2003, null);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction(ACTION_NOTIFICATION_ADVANCE);
        intent.setPackage(getMcsPackageName(activity));
        Bundle bundle = new Bundle();
        bundle.putBinder(KEY_CALLBACK, this.mPermissionCallback);
        intent.putExtras(bundle);
        intent.putExtra(C0879b.f556E, getUserId(this.mContext));
        try {
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException unused) {
            if (iNotificationPermissionCallback != null) {
                iNotificationPermissionCallback.onFail(2005, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 32) {
            C0895d.m662b(TAG, "requestNotificationPermission() will return due to Android T device , current device Android SDK version code is :" + Build.VERSION.SDK_INT);
        } else if (checkContext()) {
            bindMcsService(MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
        } else {
            C0895d.m674e(C0895d.f621a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void resumePush() {
        resumePush(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void resumePush(JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_RESUME_PUSH, jSONObject);
        } else {
            C0895d.m674e(C0895d.f621a, "please call the register first!");
        }
    }

    public void setAppKeySecret(String str, String str2) {
        this.mAuthCode = str;
        this.mVerifyCode = str2;
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void setNotificationType(int i, JSONObject jSONObject) {
        if (checkAll()) {
            startMcsService(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE, i + "", jSONObject);
        } else {
            C0895d.m674e(C0895d.f621a, "please call the register first!");
        }
    }

    public void setPushCallback(ICallBackResultService iCallBackResultService) {
        this.mICallBackResultService = iCallBackResultService;
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        if (!checkAll()) {
            if (getPushCallback() != null) {
                getPushCallback().onSetPushTime(-2, "please call the register first!");
                return;
            }
            return;
        }
        if (list == null || list.size() <= 0 || i < 0 || i2 < 0 || i3 < i || i3 > 23 || i4 < i2 || i4 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("weekDays", C0877b.m587a(list));
            jSONObject2.put("startHour", i);
            jSONObject2.put("startMin", i2);
            jSONObject2.put("endHour", i3);
            jSONObject2.put("endMin", i4);
            startMcsService(MessageConstant.CommandId.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
        } catch (JSONException e) {
            C0895d.m674e(C0895d.f621a, e.getLocalizedMessage());
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void setRegisterID(String str) {
        this.mRegisterID = str;
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void unRegister() {
        unRegister(null);
    }

    public void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.mAuthCode = str;
        this.mVerifyCode = str2;
        this.mContext = context.getApplicationContext();
        this.mICallBackResultService = iCallBackResultService;
        unRegister(jSONObject);
    }

    @Override // com.heytap.mcssdk.InterfaceC0873b
    public void unRegister(JSONObject jSONObject) {
        if (checkContext()) {
            startMcsService(MessageConstant.CommandId.COMMAND_UNREGISTER, jSONObject);
        } else if (getPushCallback() != null) {
            getPushCallback().onUnRegister(-2, this.mContext.getPackageName(), getMiniProgramPkgFromJSON(jSONObject));
        }
    }
}
