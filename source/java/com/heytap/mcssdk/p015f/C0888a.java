package com.heytap.mcssdk.p015f;

import android.content.Context;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.p012c.C0877b;
import com.heytap.mcssdk.utils.C0895d;
import com.heytap.mcssdk.utils.C0897f;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* renamed from: com.heytap.mcssdk.f.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0888a implements InterfaceC0890c {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m636a(C0877b c0877b, PushService pushService) {
        int i;
        String str;
        if (c0877b == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (pushService == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else {
            if (pushService.getPushCallback() != null) {
                int m598e = c0877b.m598e();
                if (m598e == 12287) {
                    ICallBackResultService pushCallback = pushService.getPushCallback();
                    if (pushCallback != null) {
                        pushCallback.onError(c0877b.m602g(), c0877b.m600f(), c0877b.m605i(), c0877b.m604h());
                        return;
                    }
                    return;
                }
                if (m598e == 12298) {
                    pushService.getPushCallback().onSetPushTime(c0877b.m602g(), c0877b.m600f());
                    return;
                }
                if (m598e == 12306) {
                    pushService.getPushCallback().onGetPushStatus(c0877b.m602g(), Utils.parseInt(c0877b.m600f()));
                    return;
                }
                if (m598e == 12309) {
                    pushService.getPushCallback().onGetNotificationStatus(c0877b.m602g(), Utils.parseInt(c0877b.m600f()));
                    return;
                }
                if (m598e == 12289) {
                    if (c0877b.m602g() == 0) {
                        pushService.setRegisterID(c0877b.m600f());
                    }
                    pushService.getPushCallback().onRegister(c0877b.m602g(), c0877b.m600f(), c0877b.m605i(), c0877b.m604h());
                    return;
                }
                if (m598e == 12290) {
                    pushService.getPushCallback().onUnRegister(c0877b.m602g(), c0877b.m605i(), c0877b.m604h());
                    return;
                }
                switch (m598e) {
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                        ISetAppNotificationCallBackService pushSetAppNotificationCallBack = pushService.getPushSetAppNotificationCallBack();
                        if (pushSetAppNotificationCallBack != null) {
                            pushSetAppNotificationCallBack.onSetAppNotificationSwitch(c0877b.m602g());
                            return;
                        }
                        return;
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                        try {
                            i = Integer.parseInt(c0877b.m600f());
                        } catch (Exception unused) {
                            i = 0;
                        }
                        IGetAppNotificationCallBackService pushGetAppNotificationCallBack = pushService.getPushGetAppNotificationCallBack();
                        if (pushGetAppNotificationCallBack != null) {
                            pushGetAppNotificationCallBack.onGetAppNotificationSwitch(c0877b.m602g(), i);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        C0895d.m673e(str);
    }

    @Override // com.heytap.mcssdk.p015f.InterfaceC0890c
    /* renamed from: a */
    public void mo638a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            final C0877b c0877b = (C0877b) baseMode;
            C0895d.m661b("mcssdk-CallBackResultProcessor:" + c0877b.toString());
            C0897f.m690a(new Runnable() { // from class: com.heytap.mcssdk.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    C0888a.this.m636a(c0877b, PushService.getInstance());
                }
            });
        }
    }
}
