package com.xiaomi.push.service.receivers;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Logger;
import com.p026xm.HostMiPushMessageHandler;
import com.p026xm.MiPushAdapter;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MIPushMessageHandler extends PushMessageReceiver {
    private static final String TAG = "MiPush";

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        if (context == null || miPushCommandMessage == null) {
            return;
        }
        try {
            String command = miPushCommandMessage.getCommand();
            List<String> commandArguments = miPushCommandMessage.getCommandArguments();
            String str = null;
            String str2 = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
            String str3 = (commandArguments == null || commandArguments.size() <= 1) ? null : commandArguments.get(1);
            PushSupporter.logger().i(TAG, "command:" + command);
            if (MiPushClient.COMMAND_REGISTER.equals(command)) {
                if (miPushCommandMessage.getResultCode() == 0) {
                    PushSupporter.logger().d(TAG, "mRegId = " + str2);
                    if (!TextUtils.isEmpty(str2)) {
                        PushSupporter.thirdService().registerSenderSuccessAndUploadToken(context, MiPushAdapter.getMiPush(), str2);
                    } else {
                        PushSupporter.monitor().monitorRegisterSenderFailed(MiPushAdapter.getMiPush(), 102, "0", "token is empty");
                    }
                } else {
                    PushSupporter.monitor().monitorRegisterSenderFailed(MiPushAdapter.getMiPush(), 104, String.valueOf(miPushCommandMessage.getResultCode()), miPushCommandMessage.getReason());
                    PushSupporter.thirdService().registerSenderFailed(MiPushAdapter.getMiPush(), String.valueOf(miPushCommandMessage.getResultCode()), miPushCommandMessage.getReason());
                }
            } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
                if (miPushCommandMessage.getResultCode() == 0) {
                    PushSupporter.logger().d(TAG, "set alias success, mAlias = " + str2);
                }
            } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
                if (miPushCommandMessage.getResultCode() == 0) {
                    PushSupporter.logger().d(TAG, "unSet alias success, mAlias = " + str2);
                }
            } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
                if (miPushCommandMessage.getResultCode() == 0) {
                    PushSupporter.logger().d(TAG, "subscribe topic success, mTopic = " + str2);
                }
            } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
                if (miPushCommandMessage.getResultCode() == 0) {
                    PushSupporter.logger().d(TAG, "unSubscribe topic success, mTopic = " + str2);
                }
            } else if (MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command) && miPushCommandMessage.getResultCode() == 0) {
                PushSupporter.logger().d(TAG, "mStartTime = " + str2 + " mEndTime = " + str3);
            }
            if (miPushCommandMessage.getResultCode() != 0) {
                if (70000002 == miPushCommandMessage.getResultCode()) {
                    str = "push connection certification failed";
                } else if (70000001 == miPushCommandMessage.getResultCode()) {
                    str = "the push connection failed due to network failure";
                } else if (70000004 == miPushCommandMessage.getResultCode()) {
                    str = "push internal status error, please contact developers if you encounter such errors";
                } else if (70000003 == miPushCommandMessage.getResultCode()) {
                    str = "The message format sent by the client to the push channel is invalid";
                }
                if (TextUtils.equals(command, "Registration")) {
                    PushSupporter.monitor().monitorRegisterSenderFailed(MiPushAdapter.getMiPush(), 104, String.valueOf(miPushCommandMessage.getResultCode()), str);
                }
                PushSupporter.logger().i(TAG, command + " -> " + str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        super.onReceivePassThroughMessage(context, miPushMessage);
        PushSupporter.logger().d(TAG, "Get MiPush Message " + (miPushMessage != null ? miPushMessage.toString() : String.valueOf((char[]) null)));
        if (context == null || miPushMessage == null) {
            return;
        }
        try {
            String content = miPushMessage.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(PushSupporter.thirdService().getMessageV2(MiPushAdapter.getMiPush(), content.getBytes(), true));
            jSONObject.put("pass_through", miPushMessage.getPassThrough());
            PushSupporter.pushHandler().handlePassThroughMsg(jSONObject.toString(), MiPushAdapter.getMiPush(), (String) null);
        } catch (Throwable th) {
            Logger.e(Log.getStackTraceString(th));
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageClicked(context, miPushMessage);
        PushSupporter.logger().d(TAG, "Get MiPush Message " + (miPushMessage != null ? miPushMessage.toString() : String.valueOf((char[]) null)));
        if (context != null && miPushMessage != null) {
            try {
                String content = miPushMessage.getContent();
                if (TextUtils.isEmpty(content)) {
                    return;
                }
                String messageV2 = PushSupporter.thirdService().getMessageV2(MiPushAdapter.getMiPush(), content.getBytes(), true);
                if (TextUtils.isEmpty(messageV2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(messageV2);
                jSONObject.put("pass_through", miPushMessage.getPassThrough());
                PushSupporter.thirdService().onClickNotPassThroughNotification(context, jSONObject.toString(), MiPushAdapter.getMiPush(), (String) null);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageArrived(context, miPushMessage);
        PushSupporter.logger().i(TAG, "onNotificationMessageArrived");
        PushMessageReceiver hostPushMessageReceiver = HostMiPushMessageHandler.getInstance().getHostPushMessageReceiver();
        if (hostPushMessageReceiver != null) {
            hostPushMessageReceiver.onNotificationMessageArrived(context, miPushMessage);
        }
    }
}
