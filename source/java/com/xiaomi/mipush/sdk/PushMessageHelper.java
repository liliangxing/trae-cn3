package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1663hh;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            if (isUseCallbackPushMode(context)) {
                setPushMode(1);
            } else {
                setPushMode(2);
            }
        }
        return pushMode;
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(MESSAGE_TYPE, 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(MESSAGE_TYPE, 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3, List<String> list2) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(C1663hh c1663hh, C1646gr c1646gr, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(c1663hh.m3185a());
        if (!TextUtils.isEmpty(c1663hh.m3194d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(c1663hh.m3194d());
        } else if (!TextUtils.isEmpty(c1663hh.m3192c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(c1663hh.m3192c());
        } else if (!TextUtils.isEmpty(c1663hh.m3198f())) {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(c1663hh.m3198f());
        } else {
            miPushMessage.setMessageType(0);
        }
        miPushMessage.setCategory(c1663hh.m3196e());
        if (c1663hh.m3184a() != null) {
            miPushMessage.setContent(c1663hh.m3184a().m2816c());
        }
        if (c1646gr != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(c1646gr.m2842a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(c1646gr.m2852b());
            }
            miPushMessage.setDescription(c1646gr.m2864d());
            miPushMessage.setTitle(c1646gr.m2860c());
            miPushMessage.setNotifyType(c1646gr.m2835a());
            miPushMessage.setNotifyId(c1646gr.m2857c());
            miPushMessage.setPassThrough(c1646gr.m2849b());
            miPushMessage.setExtra(c1646gr.m2843a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static C1646gr generateMessage(MiPushMessage miPushMessage) {
        C1646gr c1646gr = new C1646gr();
        c1646gr.m2840a(miPushMessage.getMessageId());
        c1646gr.m2851b(miPushMessage.getTopic());
        c1646gr.m2863d(miPushMessage.getDescription());
        c1646gr.m2859c(miPushMessage.getTitle());
        c1646gr.m2858c(miPushMessage.getNotifyId());
        c1646gr.m2839a(miPushMessage.getNotifyType());
        c1646gr.m2850b(miPushMessage.getPassThrough());
        c1646gr.m2841a(miPushMessage.getExtra());
        return c1646gr;
    }
}
