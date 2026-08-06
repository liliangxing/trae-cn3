package com.huawei.hms.framework.network.grs.p026h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.h.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1115d {

    /* renamed from: a */
    private static final Map<String, a> f1378a = new ConcurrentHashMap(16);

    /* renamed from: com.huawei.hms.framework.network.grs.h.d$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class a {

        /* renamed from: a */
        private final long f1379a;

        /* renamed from: b */
        private final long f1380b;

        public a(long j, long j2) {
            this.f1379a = j;
            this.f1380b = j2;
        }

        /* renamed from: a */
        public boolean m1374a() {
            return SystemClock.elapsedRealtime() - this.f1380b <= this.f1379a;
        }
    }

    /* renamed from: a */
    public static a m1372a(String str) {
        StringBuilder sb = new StringBuilder("map size of get is before: ");
        Map<String, a> map = f1378a;
        Logger.m1187v("RequestUtil", sb.append(map.size()).toString());
        a aVar = map.get(str);
        Logger.m1187v("RequestUtil", "map size of get is after: " + map.size());
        return aVar;
    }

    /* renamed from: a */
    public static void m1373a(String str, a aVar) {
        StringBuilder sb = new StringBuilder("map size of put is before: ");
        Map<String, a> map = f1378a;
        Logger.m1187v("RequestUtil", sb.append(map.size()).toString());
        map.put(str, aVar);
        Logger.m1187v("RequestUtil", "map size of put is after: " + map.size());
    }
}
