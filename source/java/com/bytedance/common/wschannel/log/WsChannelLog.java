package com.bytedance.common.wschannel.log;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.message.log.PushLog;

/* loaded from: classes3.dex */
public class WsChannelLog {
    public static void onEventV3Bundle(Context context, String str, Bundle bundle) {
        try {
            PushLog.onEventV3Bundle(context, str, bundle);
        } catch (Throwable unused) {
        }
    }
}
