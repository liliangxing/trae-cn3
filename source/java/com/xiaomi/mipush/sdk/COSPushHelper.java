package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class COSPushHelper {

    /* renamed from: a */
    private static long f782a;

    /* renamed from: a */
    private static volatile boolean f783a;

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static boolean hasNetwork(Context context) {
        return C1447f.m1288a(context);
    }

    public static void uploadToken(Context context, String str) {
        C1447f.m1284a(context, EnumC1445d.ASSEMBLE_PUSH_COS, str);
    }

    public static boolean getNeedRegister() {
        return f783a;
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f783a = z;
        }
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager m1268a = C1446e.m1264a(context).m1268a(EnumC1445d.ASSEMBLE_PUSH_COS);
        if (m1268a != null) {
            AbstractC1417b.m1089a("ASSEMBLE_PUSH :  register cos when network change!");
            m1268a.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f782a;
            if (j <= 0 || j + Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL <= elapsedRealtime) {
                f782a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static void convertMessage(Intent intent) {
        C1447f.m1286a(intent);
    }
}
