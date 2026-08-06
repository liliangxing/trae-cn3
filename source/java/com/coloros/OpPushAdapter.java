package com.coloros;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.helper.SysDialogActivityLifecycleObserver;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.interfaze.ITokenService;
import com.bytedance.push.third.BasePushAdapter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.webx.addr.AddressParam;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class OpPushAdapter extends BasePushAdapter implements IPushAdapter, ICallBackResultService, ITokenService {
    private static int OP_PUSH = -1;
    private static final String TAG = "OpPush";
    private IPushService.PushTokenCallback mCallback;
    private Context mContext;
    private String mRegisterId;
    private volatile boolean appStatusHasChange = false;
    private boolean hasShowing = false;
    private final long DIALOG_SHOW_TIME_OUT = 2000;
    private final long RESULT_CODE_USER_DISAGREE = 1000;

    public int getPushType() {
        return 10;
    }

    public boolean requestRemoveVoipNotification(Context context, int i) {
        return false;
    }

    public void setAlias(Context context, String str, int i) {
    }

    public void trackPush(Context context, int i, Object obj) {
    }

    public static int getOpPush() {
        if (OP_PUSH == -1) {
            OP_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(OpPushAdapter.class.getName());
        }
        return OP_PUSH;
    }

    public boolean isPushAvailable(Context context, int i) {
        try {
            return HeytapPushManager.isSupportPush(context);
        } catch (Throwable th) {
            PushSupporter.logger().i(TAG, "register onSuccess registerId = " + Log.getStackTraceString(th));
            return false;
        }
    }

    public void registerPush(Context context, int i) {
        String str;
        if (context == null || i != getOpPush() || !HeytapPushManager.isSupportPush(context)) {
            if (context == null) {
                str = "context is null";
            } else {
                str = i != getOpPush() ? "register channel error" : "the phone does not support OP Push";
            }
            PushSupporter.monitor().monitorRegisterSenderFailed(i, 101, AddressParam.TYPE_DISAPPROVE, str);
            return;
        }
        this.mContext = context.getApplicationContext();
        if (ToolUtils.isSmpProcess(context)) {
            ToolUtils.setComponentEnable(context, "com.heytap.msp.push.service.DataMessageCallbackService", false);
            ToolUtils.setComponentEnable(context, "com.heytap.msp.push.service.SmpDataMessageCallbackService", true);
            ToolUtils.setComponentEnable(context, "com.heytap.msp.push.service.CompatibleDataMessageCallbackService", false);
            ToolUtils.setComponentEnable(context, "com.heytap.msp.push.service.SmpCompatibleDataMessageCallbackService", true);
        }
        PushSupporter.logger().i(TAG, "registerOpPush");
        Pair pushConfig = PushSupporter.thirdService().getPushConfig(getOpPush());
        if (pushConfig == null) {
            PushSupporter.monitor().monitorRegisterSenderFailed(i, 106, AddressParam.TYPE_DISAPPROVE, "configuration error");
            PushSupporter.logger().i(TAG, "registerOpPush but config is null");
            return;
        }
        try {
            HeytapPushManager.init(context.getApplicationContext(), PushSupporter.logger().debug());
            HeytapPushManager.register(context, (String) pushConfig.first, (String) pushConfig.second, this);
        } catch (Throwable th) {
            PushSupporter.logger().d("mcssdk", "op register push get exception=" + th.getMessage());
        }
        HeytapPushManager.resumePush();
        PushSupporter.logger().i(TAG, "resumePush");
    }

    public void unregisterPush(Context context, int i) {
        PushSupporter.logger().i(TAG, "unregisterOpPush start");
        if (context != null && i == getOpPush() && HeytapPushManager.isSupportPush(context)) {
            PushSupporter.logger().i(TAG, "unregisterOpPush");
            try {
                HeytapPushManager.pausePush();
                HeytapPushManager.unRegister();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetPushStatus(int i, int i2) {
        PushSupporter.logger().i(TAG, "onSetPushTime and i= " + i + " i1= " + i2);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onRegister(int i, String str, String str2, String str3) {
        PushSupporter.logger().i(TAG, "onRegister and resultCode= " + i + " registerId = " + str);
        if (i == 0 && !TextUtils.isEmpty(str)) {
            PushSupporter.logger().i(TAG, "register onSuccess registerId = " + str);
            IPushService.PushTokenCallback pushTokenCallback = this.mCallback;
            if (pushTokenCallback != null) {
                pushTokenCallback.onTokenReceived(str);
            }
            this.mRegisterId = str;
            PushSupporter.thirdService().registerSenderSuccessAndUploadToken(this.mContext, getOpPush(), str);
            return;
        }
        if (i != 0) {
            PushSupporter.logger().e(TAG, "register onFailure resultCode " + i + " registerId = " + str);
            String str4 = i + " " + str;
            PushSupporter.thirdService().registerSenderFailed(getOpPush(), String.valueOf(i), str4);
            PushSupporter.monitor().monitorRegisterSenderFailed(getOpPush(), 104, String.valueOf(i), str4);
            return;
        }
        PushSupporter.monitor().monitorRegisterSenderFailed(getOpPush(), 102, AddressParam.TYPE_DISAPPROVE, "token is empty");
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onUnRegister(int i, String str, String str2) {
        PushSupporter.logger().i(TAG, "onUnRegister and responseCode= " + i + " packageName=" + str + " miniPackageName=" + str2);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onSetPushTime(int i, String str) {
        PushSupporter.logger().i(TAG, "onSetPushTime and i= " + i + " s= " + str);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onGetNotificationStatus(int i, int i2) {
        PushSupporter.logger().i(TAG, "onGetNotificationStatus and i= " + i + " i1= " + i2);
    }

    @Override // com.heytap.msp.push.callback.ICallBackResultService
    public void onError(int i, String str, String str2, String str3) {
        PushSupporter.logger().e(TAG, "onError errorCode = " + i + "  message=" + str + " packageName=" + str2 + " miniProgramPkg=" + str3);
    }

    public boolean checkThirdPushConfig(String str, Context context) throws Exception {
        return ManifestChecker.checkManifest(str, context);
    }

    public boolean requestOpNotificationPermission(int i) {
        try {
            PushSupporter.statisticsService().onEventV3("push_guide_request_oppo", (JSONObject) null);
        } catch (Throwable unused) {
        }
        if (i != getOpPush()) {
            PushSupporter.logger().d(TAG, "OpPushAdapter.requestNotificationPermission error, push_type is not " + getOpPush());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result_value", AddressParam.TYPE_DISAPPROVE);
                jSONObject.put("error_msg", "push_type is not for oppo");
                PushSupporter.statisticsService().onEventV3("push_guide_show_oppo", jSONObject);
            } catch (Throwable unused2) {
            }
            return false;
        }
        if (TextUtils.isEmpty(this.mRegisterId)) {
            PushSupporter.logger().d(TAG, "OpPushAdapter.requestNotificationPermission op register failed or not registered");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result_value", AddressParam.TYPE_DISAPPROVE);
                jSONObject2.put("error_msg", "oppo register failed or not registered");
                PushSupporter.statisticsService().onEventV3("push_guide_show_oppo", jSONObject2);
            } catch (Throwable unused3) {
            }
            return false;
        }
        if (1 != ToolUtils.areNotificationsEnabled(this.mContext)) {
            HeytapPushManager.requestNotificationPermission();
            PushSupporter.logger().d(TAG, "OpPushAdapter.requestNotificationPermission no permission, request");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("result_value", "1");
                jSONObject3.put("error_msg", "success");
                PushSupporter.statisticsService().onEventV3("push_guide_show_oppo", jSONObject3);
            } catch (Throwable unused4) {
            }
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.coloros.OpPushAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("notification_status", 1 == ToolUtils.areNotificationsEnabled(OpPushAdapter.this.mContext) ? "1" : AddressParam.TYPE_DISAPPROVE);
                        PushSupporter.statisticsService().onEventV3("push_guide_status_change_oppo", jSONObject4);
                    } catch (Throwable unused5) {
                    }
                }
            }, TimeUnit.SECONDS.toMillis(15L));
        } else {
            PushSupporter.logger().d(TAG, "OpPushAdapter.requestNotificationPermission already has permission");
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("result_value", AddressParam.TYPE_DISAPPROVE);
                jSONObject4.put("error_msg", "already has permission");
                PushSupporter.statisticsService().onEventV3("push_guide_show_oppo", jSONObject4);
            } catch (Throwable unused5) {
            }
        }
        return true;
    }

    public String isBusinessAlertDialogAvailable(Context context, boolean z) {
        if (!isPushAvailable(context, 10)) {
            Logger.i(TAG, "[isBusinessAlertDialogAvailable]return false because push is not available");
            return "push is not available";
        }
        Logger.i(TAG, "[isBusinessAlertDialogAvailable]return true");
        return "1";
    }

    public synchronized boolean requestNotificationPermission(final String str, final int i, int i2, final RequestResultCallback requestResultCallback) {
        PushSupporter.logger().d(TAG, "[requestNotificationPermission]");
        if (i != getOpPush()) {
            Logger.e(TAG, "invalid push_type:" + i);
            onGuideRequestResult(str, i, "op", false, "invalid push_type:" + i, requestResultCallback);
            return false;
        }
        Activity topActivity = ActivityLifecycleObserver.getIns().getTopActivity();
        if (topActivity == null) {
            Logger.e(TAG, "can't requestNotificationPermission on op device because topActivity is null");
            onGuideRequestResult(str, i, "op", false, "topActivity is null,app is not in the foreground!", requestResultCallback);
            return false;
        }
        if (this.hasShowing) {
            Logger.e(TAG, "can't requestNotificationPermission because cur has showing");
            return false;
        }
        this.hasShowing = true;
        this.appStatusHasChange = false;
        this.hasCallbackShowResult = false;
        final long[] jArr = {0};
        SysDialogActivityLifecycleObserver.getIns().addObserver(new Observer() { // from class: com.coloros.OpPushAdapter.2
            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                Logger.d(OpPushAdapter.TAG, "app status changed,isInBackGround:" + booleanValue);
                if (booleanValue) {
                    jArr[0] = System.currentTimeMillis();
                    PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.coloros.OpPushAdapter.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (jArr[0] > 0) {
                                Logger.d(OpPushAdapter.TAG, "find valid app status change");
                                OpPushAdapter.this.appStatusHasChange = true;
                                if (OpPushAdapter.this.hasShowing) {
                                    OpPushAdapter.this.onGuideRequestResult(str, i, "op", true, "success", requestResultCallback);
                                    return;
                                }
                                return;
                            }
                            Logger.d(OpPushAdapter.TAG, "invalid app status change,sys dialog show failed");
                            OpPushAdapter.this.onGuideRequestResult(str, i, "op", false, "invalid app status change", requestResultCallback);
                            OpPushAdapter.this.hasShowing = false;
                        }
                    }, 1000L);
                } else {
                    jArr[0] = 0;
                }
            }
        });
        HeytapPushManager.requestNotificationAdvance(topActivity, new INotificationPermissionCallback() { // from class: com.coloros.OpPushAdapter.3
            @Override // com.heytap.msp.push.callback.INotificationPermissionCallback
            public void onSuccess() {
                Logger.d(OpPushAdapter.TAG, "requestNotificationAdvance success");
                OpPushAdapter.this.onUserClickResult(str, true, 0, "", requestResultCallback);
            }

            @Override // com.heytap.msp.push.callback.INotificationPermissionCallback
            public void onFail(int i3, String str2) {
                Logger.d(OpPushAdapter.TAG, "requestNotificationAdvance onFail,errorCode:" + i3 + " errorMsg:" + str2);
                if (i3 == 1000) {
                    OpPushAdapter.this.onUserClickResult(str, false, i3, str2, requestResultCallback);
                } else {
                    OpPushAdapter.this.onGuideRequestResult(str, i, "op", false, "onFail:{errorCode:" + i3 + ",errorMsg:" + str2 + "}", requestResultCallback);
                }
                OpPushAdapter.this.hasShowing = false;
            }
        }, 61520);
        Logger.d(TAG, "backup detect dialog show result after 2000");
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.coloros.OpPushAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                Logger.d(OpPushAdapter.TAG, "backup detect dialog show result now, hasShown:" + OpPushAdapter.this.hasShowing + " appStatusHasChanged:" + OpPushAdapter.this.appStatusHasChange);
                if (OpPushAdapter.this.hasShowing) {
                    if (OpPushAdapter.this.appStatusHasChange) {
                        OpPushAdapter.this.onGuideRequestResult(str, i, "op", true, "success", requestResultCallback);
                    } else {
                        OpPushAdapter.this.onGuideRequestResult(str, i, "op", false, "time out", requestResultCallback);
                    }
                }
                OpPushAdapter.this.hasShowing = false;
            }
        }, 2000L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUserClickResult(final String str, final boolean z, final int i, String str2, final RequestResultCallback requestResultCallback) {
        Logger.i(TAG, "on request op notification permission result,hasAgree:" + z);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.coloros.OpPushAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result_code", i);
                    PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogClickResult(str, "op", OpPushAdapter.getOpPush(), 0, z, "", ToolUtils.areNotificationsEnabled(AppProvider.getApp()), jSONObject);
                    RequestResultCallback requestResultCallback2 = requestResultCallback;
                    if (requestResultCallback2 != null) {
                        if (z) {
                            requestResultCallback2.onUserAgree(true);
                        } else {
                            requestResultCallback2.onUserReject();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void setPushTokenListener(IPushService.PushTokenCallback pushTokenCallback) {
        PushSupporter.logger().d(TAG, "OpPushAdapter.setPushTokenListener");
        this.mCallback = pushTokenCallback;
        if (this.mRegisterId != null) {
            PushSupporter.logger().d(TAG, "OpPushAdapter.onTokenReceived:" + this.mRegisterId);
            IPushService.PushTokenCallback pushTokenCallback2 = this.mCallback;
            if (pushTokenCallback2 != null) {
                pushTokenCallback2.onTokenReceived(this.mRegisterId);
            }
        }
    }
}
