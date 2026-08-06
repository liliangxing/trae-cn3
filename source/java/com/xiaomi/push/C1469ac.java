package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* renamed from: com.xiaomi.push.ac */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1469ac {
    /* renamed from: a */
    public static boolean m1441a(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m1442b(Context context) {
        Intent intent = null;
        try {
            intent = C1696l.m3448a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        } catch (Exception unused) {
        }
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }
}
