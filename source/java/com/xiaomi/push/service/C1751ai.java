package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1642gn;
import com.xiaomi.push.C1644gp;
import com.xiaomi.push.C1657hb;
import com.xiaomi.push.C1658hc;
import com.xiaomi.push.C1804y;
import com.xiaomi.push.EnumC1639gk;
import com.xiaomi.push.EnumC1640gl;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.ai */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1751ai {
    /* renamed from: a */
    public static void m3691a(C1750ah c1750ah, C1658hc c1658hc) {
        AbstractC1417b.m1100b("OnlineConfigHelper", "-->updateNormalConfigs(): onlineConfig=", c1750ah, ", configMessage=", c1658hc);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C1642gn c1642gn : c1658hc.m3041a()) {
            arrayList.add(new Pair<>(c1642gn.m2777a(), Integer.valueOf(c1642gn.m2775a())));
            List<Pair<Integer, Object>> m3689a = m3689a(c1642gn.f2145a, false);
            if (!C1804y.m4119a(m3689a)) {
                arrayList2.addAll(m3689a);
            }
        }
        c1750ah.m3685a(arrayList, arrayList2);
        c1750ah.m3687b();
    }

    /* renamed from: a */
    public static void m3690a(C1750ah c1750ah, C1657hb c1657hb) {
        AbstractC1417b.m1100b("OnlineConfigHelper", "-->updateCustomConfigs(): onlineConfig=", c1750ah, ", configMessage=", c1657hb);
        c1750ah.m3684a(m3689a(c1657hb.m3036a(), true));
        c1750ah.m3687b();
    }

    /* renamed from: a */
    public static int m3688a(C1750ah c1750ah, EnumC1639gk enumC1639gk) {
        return c1750ah.m3679a(enumC1639gk, AnonymousClass1.f2977a[enumC1639gk.ordinal()] != 1 ? 0 : 1);
    }

    /* renamed from: a */
    private static List<Pair<Integer, Object>> m3689a(List<C1644gp> list, boolean z) {
        Pair pair;
        if (C1804y.m4119a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C1644gp c1644gp : list) {
            int m2784a = c1644gp.m2784a();
            EnumC1640gl m2763a = EnumC1640gl.m2763a(c1644gp.m2792b());
            if (m2763a != null) {
                if (z && c1644gp.f2221a) {
                    arrayList.add(new Pair(Integer.valueOf(m2784a), null));
                } else {
                    int i = AnonymousClass1.f2978b[m2763a.ordinal()];
                    if (i == 1) {
                        pair = new Pair(Integer.valueOf(m2784a), Integer.valueOf(c1644gp.m2795c()));
                    } else if (i == 2) {
                        pair = new Pair(Integer.valueOf(m2784a), Long.valueOf(c1644gp.m2786a()));
                    } else if (i == 3) {
                        pair = new Pair(Integer.valueOf(m2784a), c1644gp.m2787a());
                    } else {
                        pair = i != 4 ? null : new Pair(Integer.valueOf(m2784a), Boolean.valueOf(c1644gp.m2804g()));
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.ai$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2977a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2978b;

        static {
            int[] iArr = new int[EnumC1640gl.values().length];
            f2978b = iArr;
            try {
                iArr[EnumC1640gl.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2978b[EnumC1640gl.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2978b[EnumC1640gl.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2978b[EnumC1640gl.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EnumC1639gk.values().length];
            f2977a = iArr2;
            try {
                iArr2[EnumC1639gk.MISC_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2977a[EnumC1639gk.PLUGIN_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
