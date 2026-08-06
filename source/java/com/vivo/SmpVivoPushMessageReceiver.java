package com.vivo;

import android.content.Context;
import com.bytedance.push.PushSupporter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SmpVivoPushMessageReceiver extends VivoPushMessageReceiver {
    @Override // com.vivo.VivoPushMessageReceiver, com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        PushSupporter.logger().i("VivoPushMessageReceiver", "SmpVivoPushMessageReceiver#onReceiveRegId token = " + str);
        super.onReceiveRegId(context, str);
    }
}
