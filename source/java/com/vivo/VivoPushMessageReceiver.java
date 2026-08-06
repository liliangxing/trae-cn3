package com.vivo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.push.PushSupporter;
import com.p025vv.VvPushAdapter;
import com.p025vv.VvPushGuideHelper;
import com.ss.android.pushmanager.PushCommonConstants;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VivoPushMessageReceiver extends OpenClientPushMessageReceiver {
    private static final String TAG = "VivoPushMessageReceiver";
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        if (context == null || uPSNotificationMessage == null) {
            return;
        }
        Logger.i(TAG, "onNotificationMessageClicked: message = " + uPSNotificationMessage.getSkipContent());
        try {
            String skipContent = uPSNotificationMessage.getSkipContent();
            if (TextUtils.isEmpty(skipContent)) {
                return;
            }
            String messageV2 = PushSupporter.thirdService().getMessageV2(VvPushAdapter.getVvPush(), skipContent.getBytes(), true);
            if (TextUtils.isEmpty(messageV2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(messageV2);
            jSONObject.put("pass_through", 0);
            PushSupporter.thirdService().onClickNotPassThroughNotification(context, jSONObject.toString(), VvPushAdapter.getVvPush(), (String) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
        super.onTransmissionMessage(context, unvarnishedMessage);
        com.bytedance.push.utils.Logger.i(TAG, "onMessageReceived is called");
        if (unvarnishedMessage == null) {
            com.bytedance.push.utils.Logger.e(TAG, "Received message entity is null!");
            return;
        }
        String message = unvarnishedMessage.getMessage();
        com.bytedance.push.utils.Logger.i(TAG, "get message: " + message);
        if (TextUtils.isEmpty(message)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(message);
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("android_payload"));
            jSONObject2.put("voip_params", jSONObject.optString("voip_params"));
            jSONObject2.put(PushCommonConstants.KEY_PUSH_SHOW_TYPE, jSONObject.optInt(PushCommonConstants.KEY_PUSH_SHOW_TYPE));
            PushSupporter.pushHandler().handlePassThroughMsg(jSONObject2, VvPushAdapter.getVvPush(), (String) null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(final Context context, final String str) {
        this.mHandler.post(new Runnable() { // from class: com.vivo.VivoPushMessageReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                PushSupporter.logger().i(VivoPushMessageReceiver.TAG, "onReceiveRegId token = " + str);
                VvPushAdapter.sendToken(context, str);
            }
        });
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotifyGuideDialogResult(int i) {
        super.onNotifyGuideDialogResult(i);
        VvPushGuideHelper.getInstance().onNotifyGuideDialogResult(i);
    }
}
