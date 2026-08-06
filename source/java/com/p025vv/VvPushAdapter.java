package com.p025vv;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.helper.SysDialogActivityLifecycleObserver;
import com.bytedance.push.third.BasePushAdapter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.PushUtils;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.VivoPushException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VvPushAdapter extends BasePushAdapter implements IPushAdapter {
    private static final String TAG = "VivoPush";
    private static int VV_PUSH = -1;
    private static boolean hasSendValidToken;
    private static boolean sHasRegistered;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private volatile boolean appStatusHasChanged = false;
    private boolean hasShown = false;
    private final long DIALOG_SHOW_TIME_OUT = 2000;
    private final String SUCCESS = "success";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface VivoGuideCallback {
        void onResult(boolean z);
    }

    public int getPushType() {
        return 11;
    }

    public boolean requestRemoveVoipNotification(Context context, int i) {
        return false;
    }

    public void trackPush(Context context, int i, Object obj) {
    }

    public static int getVvPush() {
        if (VV_PUSH == -1) {
            VV_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(VvPushAdapter.class.getName());
        }
        return VV_PUSH;
    }

    public static boolean hasTryRegistered() {
        return sHasRegistered;
    }

    public boolean isPushAvailable(Context context, int i) {
        return PushUtils.isVivo() && PushClient.getInstance(context.getApplicationContext()).isSupport();
    }

    private void setComponentStatus(Context context, Class cls, boolean z) {
        ComponentName componentName = new ComponentName(context, (Class<?>) cls);
        PushSupporter.logger().i(TAG, "set " + cls.getName() + " to:" + z);
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, z ? 1 : 2, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerPush(Context context, int i) {
        try {
            PushSupporter.logger().i(TAG, "registerVivoPush");
            if (PushSupporter.logger().debug()) {
                PushClient.getInstance(context).checkManifest();
            }
            sHasRegistered = true;
            PushClient.getInstance(context.getApplicationContext()).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());
            PushClient.getInstance(context).turnOnPush(new C14051(i, context));
        } catch (Exception e) {
            PushSupporter.logger().e(TAG, "error when register vv push ", e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.vv.VvPushAdapter$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class C14051 implements IPushActionListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$push_type;

        C14051(int i, Context context) {
            this.val$push_type = i;
            this.val$context = context;
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            if (i != 0) {
                PushSupporter.monitor().monitorRegisterSenderFailed(this.val$push_type, 104, String.valueOf(i), "vivo channel register failed");
                PushSupporter.logger().e(VvPushAdapter.TAG, "open push error [" + i + "] ，please check the official documentation of the vendor");
            } else {
                PushSupporter.logger().i(VvPushAdapter.TAG, "open push success");
            }
            PushClient.getInstance(this.val$context).getRegId(new IPushQueryActionListener() { // from class: com.vv.VvPushAdapter.1.1
                @Override // com.vivo.push.listener.IPushRequestListener
                public void onSuccess(final String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    PushSupporter.logger().i(VvPushAdapter.TAG, "success get token");
                    PushSupporter.logger().d(VvPushAdapter.TAG, "token = " + str);
                    VvPushAdapter.this.mHandler.post(new Runnable() { // from class: com.vv.VvPushAdapter.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            VvPushAdapter.sendToken(C14051.this.val$context, str);
                        }
                    });
                }

                @Override // com.vivo.push.listener.IPushRequestListener
                public void onFail(Integer num) {
                    PushSupporter.logger().e(VvPushAdapter.TAG, "onFail,error code: " + num);
                }
            });
        }
    }

    public void setAlias(Context context, String str, int i) {
        try {
            PushSupporter.logger().i(TAG, "setAlias alias = " + str);
            PushClient.getInstance(context).bindAlias(str, new IPushActionListener() { // from class: com.vv.VvPushAdapter.2
                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i2) {
                    Logger.d(VvPushAdapter.TAG, "onStateChanged() called with: i = [" + i2 + "]");
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void unregisterPush(Context context, int i) {
        try {
            PushClient.getInstance(context).turnOffPush(new IPushActionListener() { // from class: com.vv.VvPushAdapter.3
                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i2) {
                    Logger.d(VvPushAdapter.TAG, "onStateChanged() called with: i = [" + i2 + "]");
                }
            });
            PushSupporter.logger().i(TAG, "unregisterPush");
        } catch (Throwable unused) {
        }
    }

    public static void sendToken(Context context, String str) {
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Logger.d(TAG, "[sendToken]hasSendValidToken:" + hasSendValidToken);
            if (hasSendValidToken) {
                return;
            }
            hasSendValidToken = true;
            PushSupporter.thirdService().registerSenderSuccessAndUploadToken(context, getVvPush(), str);
            return;
        }
        if (PushSupporter.thirdService().isMainProcess(context)) {
            PushSupporter.monitor().monitorRegisterSenderFailed(getVvPush(), 102, "0", "token is empty");
        }
    }

    public boolean checkThirdPushConfig(String str, Context context) throws Exception {
        try {
            PushClient.getInstance(context).checkManifest();
            return true;
        } catch (VivoPushException e) {
            Logger.e(str, "VivoPush Errcode = " + e.getCode() + " " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean setProfileId(final Context context, final String str) {
        int i;
        String localizedMessage;
        int isSupportSyncProfileInfo;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            isSupportSyncProfileInfo = PushClient.getInstance(context).isSupportSyncProfileInfo();
            PushSupporter.logger().i(TAG, "[setProfileId]supportProfile:" + isSupportSyncProfileInfo + " profileId len:" + str.length() + " profileId：" + str);
        } catch (Throwable th) {
            i = 5;
            localizedMessage = th.getLocalizedMessage();
        }
        if (isSupportSyncProfileInfo == 0) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Boolean[] boolArr = {null};
            final String[] strArr = {""};
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.vv.VvPushAdapter.4
                @Override // java.lang.Runnable
                public void run() {
                    PushClient.getInstance(context).addProfileId(str, new IPushRequestCallback<Integer>() { // from class: com.vv.VvPushAdapter.4.1
                        @Override // com.vivo.push.restructure.request.IPushRequestCallback
                        public void onSuccess(Integer num) {
                            PushSupporter.logger().d(VvPushAdapter.TAG, "[setProfileId]success set profile id:" + num);
                            boolArr[0] = true;
                            countDownLatch.countDown();
                        }

                        @Override // com.vivo.push.restructure.request.IPushRequestCallback
                        public void onError(int i2) {
                            boolArr[0] = false;
                            PushSupporter.logger().e(VvPushAdapter.TAG, "[setProfileId]failed set profile id:" + i2);
                            strArr[0] = "vv error:" + i2;
                            countDownLatch.countDown();
                        }
                    });
                }
            });
            try {
                countDownLatch.await(10000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Boolean bool = boolArr[0];
            if (bool == null) {
                i = 4;
            } else {
                if (!bool.booleanValue()) {
                    Logger.d(TAG, "error msg is :" + strArr[0]);
                    i = 6;
                    str2 = strArr[0];
                    localizedMessage = str2;
                    Logger.d(TAG, "onSetProfileIdResult,resultStatus:" + i + " extra:" + localizedMessage);
                    onSetProfileIdResult(getVvPush(), currentTimeMillis, i, localizedMessage);
                    return i != 1;
                }
                i = 1;
            }
        } else {
            i = 3;
        }
        str2 = null;
        localizedMessage = str2;
        Logger.d(TAG, "onSetProfileIdResult,resultStatus:" + i + " extra:" + localizedMessage);
        onSetProfileIdResult(getVvPush(), currentTimeMillis, i, localizedMessage);
        if (i != 1) {
        }
    }

    public boolean deleteProfileId(Context context, String str) {
        int i;
        String localizedMessage;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            int isSupportSyncProfileInfo = PushClient.getInstance(context).isSupportSyncProfileInfo();
            PushSupporter.logger().i(TAG, "[deleteProfileId]supportProfile:" + isSupportSyncProfileInfo + " profileId:" + str);
            String str2 = null;
            if (isSupportSyncProfileInfo == 0) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final Boolean[] boolArr = {null};
                final String[] strArr = {""};
                PushClient.getInstance(context).deleteProfileId(str, new IPushRequestCallback<Integer>() { // from class: com.vv.VvPushAdapter.5
                    @Override // com.vivo.push.restructure.request.IPushRequestCallback
                    public void onSuccess(Integer num) {
                        PushSupporter.logger().d(VvPushAdapter.TAG, "[deleteProfileId]success delete profile id:" + num);
                        boolArr[0] = true;
                        countDownLatch.countDown();
                    }

                    @Override // com.vivo.push.restructure.request.IPushRequestCallback
                    public void onError(int i2) {
                        boolArr[0] = false;
                        PushSupporter.logger().d(VvPushAdapter.TAG, "[deleteProfileId]failed set profile id:" + i2);
                        strArr[0] = "vv error:" + i2;
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await(10000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Boolean bool = boolArr[0];
                if (bool == null) {
                    i = 4;
                } else if (bool.booleanValue()) {
                    i = 1;
                } else {
                    Logger.d(TAG, "error msg is :" + strArr[0]);
                    i = 6;
                    str2 = strArr[0];
                }
            } else {
                i = 3;
            }
            localizedMessage = str2;
        } catch (Throwable th) {
            i = 5;
            localizedMessage = th.getLocalizedMessage();
        }
        onDeleteProfileIdResult(getVvPush(), currentTimeMillis, i, localizedMessage);
        return i == 1;
    }

    public synchronized boolean requestNotificationPermission(final String str, final int i, int i2, final RequestResultCallback requestResultCallback) {
        PushSupporter.logger().d(TAG, "[requestNotificationPermission]");
        if (i != getVvPush()) {
            Logger.e(TAG, "invalid push_type:" + i);
            onGuideRequestResult(str, i, "vv", false, "invalid push_type:" + i, requestResultCallback);
            return false;
        }
        if (ToolUtils.areNotificationsEnabled(AppProvider.getApp()) == 1) {
            Logger.e(TAG, "cur notification are enabled,needn't request");
            onGuideRequestResult(str, i, "vv", false, "cur notification are enabled,needn't request", requestResultCallback);
            return false;
        }
        if (ActivityLifecycleObserver.getIns().getTopActivity() == null) {
            Logger.e(TAG, "can't requestNotificationPermission on vv device because topActivity is null");
            onGuideRequestResult(str, i, "vv", false, "topActivity is null,app is not in the foreground!", requestResultCallback);
            return false;
        }
        this.hasCallbackShowResult = false;
        this.hasCallbackClickResult = false;
        if (Build.VERSION.SDK_INT >= 30 && Build.VERSION.SDK_INT <= 32) {
            requestNotificationHook(str, i, i2, requestResultCallback);
        } else if (Build.VERSION.SDK_INT >= 28 && isPushServiceAvailable().booleanValue()) {
            requestNotificationOfficial(new VivoGuideCallback() { // from class: com.vv.VvPushAdapter.6
                @Override // com.vv.VvPushAdapter.VivoGuideCallback
                public void onResult(boolean z) {
                    if (z) {
                        Logger.d(VvPushAdapter.TAG, "requestNotificationOfficial show success");
                        VvPushAdapter.this.onGuideRequestResult(str, i, "vv", true, "success", requestResultCallback);
                        VvPushGuideHelper.getInstance().setOnPushGuideClickListener(new OnPushGuideClickListener() { // from class: com.vv.VvPushAdapter.6.1
                            @Override // com.p025vv.OnPushGuideClickListener
                            public void onNotifyGuideDialogResult(int i3) {
                                PushSupporter.logger().i(VvPushAdapter.TAG, "onNotifyGuideDialogResult: message = " + i3);
                                VvPushAdapter.this.onUserClickResult(str, i3 == 1, requestResultCallback);
                            }
                        });
                    } else {
                        Logger.d(VvPushAdapter.TAG, "requestNotificationOfficial show failed");
                        VvPushAdapter.this.onGuideRequestResult(str, i, "vv", false, "failed", requestResultCallback);
                        VvPushGuideHelper.getInstance().setOnPushGuideClickListener(null);
                    }
                }
            });
        }
        return true;
    }

    private Boolean isPushServiceAvailable() {
        try {
            PackageInfo packageInfo = AppProvider.getApp().getPackageManager().getPackageInfo("com.vivo.pushservice", 0);
            Logger.e(TAG, "com.vivo.pushservice versionName: " + packageInfo.versionName);
            if (packageInfo.versionCode >= 5380000) {
                Logger.e(TAG, "com.vivo.pushservice versionCode: " + packageInfo.versionCode + " is available!");
                return true;
            }
            Logger.e(TAG, "com.vivo.pushservice versionCode: " + packageInfo.versionCode + " version not supported!");
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void requestNotificationHook(final String str, final int i, int i2, final RequestResultCallback requestResultCallback) {
        final Application app = AppProvider.getApp();
        if (this.hasShown) {
            Logger.e(TAG, "can't requestNotificationPermission because cur has showing");
        }
        this.hasShown = true;
        this.appStatusHasChanged = false;
        this.hasCallbackShowResult = false;
        SysDialogActivityLifecycleObserver.getIns().addObserver(new Observer() { // from class: com.vv.VvPushAdapter.7
            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                Logger.d(VvPushAdapter.TAG, "app status changed,isInBackGround:" + booleanValue + " appStatusHasChange：" + VvPushAdapter.this.appStatusHasChanged);
                if (booleanValue) {
                    VvPushAdapter.this.appStatusHasChanged = true;
                    if (VvPushAdapter.this.hasShown) {
                        VvPushAdapter.this.onGuideRequestResult(str, i, "vv", true, "success", requestResultCallback);
                    }
                }
                if (booleanValue || !VvPushAdapter.this.appStatusHasChanged) {
                    return;
                }
                if (ToolUtils.areNotificationsEnabled(app) == ToolUtils.TRUE) {
                    VvPushAdapter.this.onUserClickResult(str, true, requestResultCallback);
                } else {
                    VvPushAdapter.this.onUserClickResult(str, false, requestResultCallback);
                }
                SysDialogActivityLifecycleObserver.getIns().deleteObserver(this);
            }
        });
        String requestNotificationInternal = requestNotificationInternal();
        if (!TextUtils.equals(requestNotificationInternal, "success")) {
            onGuideRequestResult(str, i, "vv", false, requestNotificationInternal, requestResultCallback);
            this.hasShown = false;
        } else {
            Logger.d(TAG, "backup detect dialog show result after 2000");
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.vv.VvPushAdapter.8
                @Override // java.lang.Runnable
                public void run() {
                    Logger.d(VvPushAdapter.TAG, "backup detect dialog show result now, hasShown:" + VvPushAdapter.this.hasShown + " appStatusHasChanged:" + VvPushAdapter.this.appStatusHasChanged);
                    if (VvPushAdapter.this.hasShown) {
                        if (VvPushAdapter.this.appStatusHasChanged) {
                            VvPushAdapter.this.onGuideRequestResult(str, i, "vv", true, "success", requestResultCallback);
                        } else {
                            VvPushAdapter.this.onGuideRequestResult(str, i, "vv", false, "time out", requestResultCallback);
                        }
                    }
                    VvPushAdapter.this.hasShown = false;
                }
            }, 2000L);
        }
    }

    private void requestNotificationOfficial(final VivoGuideCallback vivoGuideCallback) {
        PushSupporter.logger().d(TAG, "requestNotificationOfficial");
        final Application app = AppProvider.getApp();
        try {
            final Activity topActivity = ActivityLifecycleObserver.getIns().getTopActivity();
            PushClient.getInstance(app).isNotifyGuideDialogAllowed(topActivity, new IPushActionListener() { // from class: com.vv.VvPushAdapter.9
                @Override // com.vivo.push.IPushActionListener
                public void onStateChanged(int i) {
                    if (i == 0) {
                        PushClient.getInstance(app).showNotifyGuideDialog(topActivity, new IPushActionListener() { // from class: com.vv.VvPushAdapter.9.1
                            @Override // com.vivo.push.IPushActionListener
                            public void onStateChanged(int i2) {
                                if (i2 == 0) {
                                    if (vivoGuideCallback != null) {
                                        vivoGuideCallback.onResult(true);
                                    }
                                } else {
                                    Logger.e(VvPushAdapter.TAG, "NotifyGuideDialog show failed");
                                    if (vivoGuideCallback != null) {
                                        vivoGuideCallback.onResult(false);
                                    }
                                }
                            }
                        });
                        return;
                    }
                    Logger.e(VvPushAdapter.TAG, "NotifyGuideDialog is not allowed: " + i);
                    VivoGuideCallback vivoGuideCallback2 = vivoGuideCallback;
                    if (vivoGuideCallback2 != null) {
                        vivoGuideCallback2.onResult(false);
                    }
                }
            });
        } catch (Exception e) {
            Logger.e(TAG, "requestNotificationOfficial error ", e);
            if (vivoGuideCallback != null) {
                vivoGuideCallback.onResult(false);
            }
        }
    }

    public String isBusinessAlertDialogAvailable(Context context, boolean z) {
        if (!isPushAvailable(context, VV_PUSH)) {
            Logger.i(TAG, "[isBusinessAlertDialogAvailable]return false because push is not available");
            return "push is not available";
        }
        if (!PushSetting.getInstance().getPushOnLineSettings().enableVvBusinessNotificationDialog()) {
            Logger.i(TAG, "[isBusinessAlertDialogAvailable]return false because enableVvBusinessNotificationDialog is false");
            return "enableVvBusinessNotificationDialog is false";
        }
        Logger.i(TAG, "[isBusinessAlertDialogAvailable]return true");
        return PushClient.DEFAULT_REQUEST_ID;
    }

    private String requestNotificationInternal() {
        PushSupporter.logger().d(TAG, "requestNotificationInternal");
        Application app = AppProvider.getApp();
        try {
            IBinder iBinder = (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "notification");
            if (iBinder == null) {
                PushSupporter.logger().e(TAG, "get service failed.");
                return "notification service is null";
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            iBinder.transact(1598968902, obtain, obtain2, 0);
            String readString = obtain2.readString();
            if (readString == null || readString.equals("")) {
                return "readString is null";
            }
            Object invoke = Class.forName(readString + "$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            if (invoke == null) {
                return "asInterface is null";
            }
            invoke.getClass().getDeclaredMethod("requestNotificationPermission", String.class).invoke(invoke, app.getPackageName());
            return "success";
        } catch (NoSuchMethodException e) {
            return "not support device:" + e.getLocalizedMessage();
        } catch (Throwable th) {
            Logger.e(TAG, "requestNotificationInternal error ", th);
            return "exception:" + th.getLocalizedMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUserClickResult(final String str, final boolean z, final RequestResultCallback requestResultCallback) {
        Logger.i(TAG, "on request vv notification permission result,report click event,hasAgree:" + z);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.vv.VvPushAdapter.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogClickResult(str, "vv", VvPushAdapter.getVvPush(), 0, z, "", ToolUtils.areNotificationsEnabled(AppProvider.getApp()), (JSONObject) null);
                    RequestResultCallback requestResultCallback2 = requestResultCallback;
                    if (requestResultCallback2 != null) {
                        if (z) {
                            requestResultCallback2.onUserAgree(true);
                        } else {
                            requestResultCallback2.onUserReject();
                        }
                    }
                } catch (Throwable th) {
                    Logger.e(VvPushAdapter.TAG, "onUserClickResult error ", th);
                }
            }
        });
    }
}
