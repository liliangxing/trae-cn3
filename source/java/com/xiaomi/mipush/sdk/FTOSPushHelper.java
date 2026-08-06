package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FTOSPushHelper {

    /* renamed from: a */
    private static long f784a;

    /* renamed from: a */
    private static volatile boolean f785a;

    public static boolean hasNetwork(Context context) {
        return C1447f.m1288a(context);
    }

    public static void uploadToken(Context context, String str) {
        C1447f.m1284a(context, EnumC1445d.ASSEMBLE_PUSH_FTOS, str);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f784a;
            if (j <= 0 || j + Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL <= elapsedRealtime) {
                f784a = elapsedRealtime;
                m1170a(context);
            }
        }
    }

    /* renamed from: a */
    private static void m1170a(Context context) {
        AbstractPushManager m1268a = C1446e.m1264a(context).m1268a(EnumC1445d.ASSEMBLE_PUSH_FTOS);
        if (m1268a != null) {
            AbstractC1417b.m1089a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            m1268a.register();
        }
    }

    public static void setNeedRegister(boolean z) {
        f785a = z;
    }

    public static boolean getNeedRegister() {
        return f785a;
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver m1277a;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (m1277a = C1447f.m1277a(context)) == null) {
            return;
        }
        MiPushMessage m1276a = C1447f.m1276a(str);
        if (m1276a.getExtra().containsKey("notify_effect")) {
            return;
        }
        m1277a.onNotificationMessageClicked(context, m1276a);
    }
}
