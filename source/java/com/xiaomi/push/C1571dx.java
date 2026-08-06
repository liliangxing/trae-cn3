package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.dx */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1571dx {

    /* renamed from: a */
    private static Vector<Pair<String, Long>> f1498a = new Vector<>();

    /* renamed from: a */
    private static ConcurrentHashMap<String, Long> f1499a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static String m2323a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f1498a) {
            for (int i = 0; i < f1498a.size(); i++) {
                Pair<String, Long> elementAt = f1498a.elementAt(i);
                sb.append((String) elementAt.first).append(Constants.COLON_SEPARATOR).append(elementAt.second);
                if (i < f1498a.size() - 1) {
                    sb.append(";");
                }
            }
            f1498a.clear();
        }
        return sb.toString();
    }
}
