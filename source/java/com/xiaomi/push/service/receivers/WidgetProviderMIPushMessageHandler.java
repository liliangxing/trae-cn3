package com.xiaomi.push.service.receivers;

import android.content.Context;
import com.bytedance.push.PushSupporter;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class WidgetProviderMIPushMessageHandler extends MIPushMessageHandler {
    @Override // com.xiaomi.push.service.receivers.MIPushMessageHandler, com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        PushSupporter.logger().i("MiPush", "onCommandResult on widgetProvider");
        super.onCommandResult(context, miPushCommandMessage);
    }
}
