package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.C1494ba;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1782k {

    /* renamed from: a */
    private static final Map<String, Long> f3151a = new HashMap();

    /* renamed from: a */
    public static boolean m3865a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String m1629a = C1494ba.m1629a(bArr);
            if (!TextUtils.isEmpty(m1629a)) {
                Map<String, Long> map = f3151a;
                synchronized (map) {
                    if (map.get(m1629a + str) != null) {
                        z = true;
                    } else {
                        map.put(m1629a + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    m3864a();
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private static void m3864a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Long> map = f3151a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > 60000) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f3151a.remove((String) it.next());
        }
    }
}
