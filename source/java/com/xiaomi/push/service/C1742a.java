package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.service.C1749ag;

/* renamed from: com.xiaomi.push.service.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1742a {

    /* renamed from: a */
    private static final SparseArray<C1749ag.a<String, String, String>> f2936a = new SparseArray<C1749ag.a<String, String, String>>(6) { // from class: com.xiaomi.push.service.a.1
        {
            put(1, C1749ag.f2968g);
            put(2, C1749ag.f2967f);
            put(4, C1749ag.f2966e);
            put(8, C1749ag.f2963b);
            put(16, C1749ag.f2964c);
            put(32, C1749ag.f2969h);
        }
    };

    /* renamed from: a */
    private static int m3571a(String str, int i) {
        return C1749ag.m3652a(C1702q.m3462a(), str, null, f2936a.get(i));
    }

    /* renamed from: a */
    private static Bundle m3572a(String str) {
        return C1749ag.m3653a(C1702q.m3462a(), str, (String) null);
    }

    /* renamed from: a */
    public static int m3570a(Context context, String str) {
        int i;
        int i2 = 0;
        if (context != null && !TextUtils.isEmpty(str)) {
            C1628g.b m2681a = C1628g.m2681a(context, str, true);
            if (m2681a == C1628g.b.ALLOWED) {
                i2 = 1;
            } else if (m2681a == C1628g.b.NOT_ALLOWED) {
                i2 = 2;
            }
            if (C1749ag.m3665a()) {
                Bundle m3572a = m3572a(str);
                if (m3572a.containsKey(C1749ag.f2968g.f2972c)) {
                    i2 |= m3572a.getBoolean(C1749ag.f2968g.f2972c) ? 4 : 8;
                }
                if (m3572a.containsKey(C1749ag.f2966e.f2972c)) {
                    i2 |= m3572a.getBoolean(C1749ag.f2966e.f2972c) ? 16 : 32;
                }
                if (m3572a.containsKey(C1749ag.f2967f.f2972c)) {
                    i2 |= m3572a.getBoolean(C1749ag.f2967f.f2972c) ? 64 : 128;
                }
                if (m3572a.containsKey(C1749ag.f2963b.f2972c)) {
                    i2 |= m3572a.getBoolean(C1749ag.f2963b.f2972c) ? 256 : 512;
                }
                if (m3572a.containsKey(C1749ag.f2964c.f2972c)) {
                    i2 |= m3572a.getBoolean(C1749ag.f2964c.f2972c) ? 1024 : 2048;
                }
                if (m3572a.containsKey(C1749ag.f2969h.f2972c)) {
                    return i2 | (m3572a.getBoolean(C1749ag.f2969h.f2972c) ? 4096 : 8192);
                }
                return i2;
            }
            int m3571a = m3571a(str, 1);
            if (m3571a == 1) {
                i2 |= 4;
            } else if (m3571a == 0) {
                i2 |= 8;
            }
            int m3571a2 = m3571a(str, 4);
            if (m3571a2 == 1) {
                i2 |= 16;
            } else if (m3571a2 == 0) {
                i2 |= 32;
            }
            int m3571a3 = m3571a(str, 2);
            if (m3571a3 == 1) {
                i2 |= 64;
            } else if (m3571a3 == 0) {
                i2 |= 128;
            }
            int m3571a4 = m3571a(str, 8);
            if (m3571a4 == 1) {
                i2 |= 256;
            } else if (m3571a4 == 0) {
                i2 |= 512;
            }
            int m3571a5 = m3571a(str, 16);
            if (m3571a5 == 1) {
                i2 |= 1024;
            } else if (m3571a5 == 0) {
                i2 |= 2048;
            }
            int m3571a6 = m3571a(str, 32);
            if (m3571a6 == 1) {
                i = i2 | 4096;
            } else {
                if (m3571a6 != 0) {
                    return i2;
                }
                i = i2 | 8192;
            }
            return i;
        }
        AbstractC1417b.m1089a("context | packageName must not be null");
        return 0;
    }
}
