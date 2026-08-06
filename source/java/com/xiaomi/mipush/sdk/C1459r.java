package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1490ax;
import com.xiaomi.push.C1648gt;
import com.xiaomi.push.C1649gu;
import com.xiaomi.push.C1650gv;
import com.xiaomi.push.C1654gz;
import com.xiaomi.push.C1655h;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1661hf;
import com.xiaomi.push.C1662hg;
import com.xiaomi.push.C1663hh;
import com.xiaomi.push.C1665hj;
import com.xiaomi.push.C1667hl;
import com.xiaomi.push.C1669hn;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.InterfaceC1671hp;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.mipush.sdk.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1459r {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static <T extends InterfaceC1671hp<T, ?>> C1656ha m1341a(Context context, T t, EnumC1633ge enumC1633ge) {
        return m1342a(context, t, enumC1633ge, !enumC1633ge.equals(EnumC1633ge.Registration), context.getPackageName(), C1443b.m1222a(context).m1226a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static <T extends InterfaceC1671hp<T, ?>> C1656ha m1342a(Context context, T t, EnumC1633ge enumC1633ge, boolean z, String str, String str2) {
        return m1343a(context, t, enumC1633ge, z, str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static <T extends InterfaceC1671hp<T, ?>> C1656ha m1346b(Context context, T t, EnumC1633ge enumC1633ge, boolean z, String str, String str2) {
        return m1343a(context, t, enumC1633ge, z, str, str2, false);
    }

    /* renamed from: a */
    protected static <T extends InterfaceC1671hp<T, ?>> C1656ha m1343a(Context context, T t, EnumC1633ge enumC1633ge, boolean z, String str, String str2, boolean z2) {
        byte[] m3313a = C1670ho.m3313a(t);
        if (m3313a == null) {
            AbstractC1417b.m1089a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        C1656ha c1656ha = new C1656ha();
        if (z) {
            String m1243d = C1443b.m1222a(context).m1243d();
            if (TextUtils.isEmpty(m1243d)) {
                AbstractC1417b.m1089a("regSecret is empty, return null");
                return null;
            }
            try {
                m3313a = C1655h.m3007b(C1490ax.m1586a(m1243d), m3313a);
            } catch (Exception unused) {
                AbstractC1417b.m1103d("encryption error. ");
            }
        }
        C1648gt c1648gt = new C1648gt();
        c1648gt.f2303a = 5L;
        c1648gt.f2304a = "fakeid";
        c1656ha.m3013a(c1648gt);
        c1656ha.m3015a(ByteBuffer.wrap(m3313a));
        c1656ha.m3011a(enumC1633ge);
        c1656ha.m3024b(z2);
        c1656ha.m3023b(str);
        c1656ha.m3016a(z);
        c1656ha.m3014a(str2);
        return c1656ha;
    }

    /* renamed from: a */
    public static InterfaceC1671hp m1344a(Context context, C1656ha c1656ha) {
        byte[] m3022a;
        if (c1656ha.m3027b()) {
            byte[] m1292a = C1447f.m1292a(context, c1656ha, EnumC1445d.ASSEMBLE_PUSH_FCM);
            if (m1292a == null) {
                m1292a = C1490ax.m1586a(C1443b.m1222a(context).m1243d());
            }
            try {
                m3022a = C1655h.m3006a(m1292a, c1656ha.m3022a());
            } catch (Exception e) {
                throw new C1453l("the aes decrypt failed.", e);
            }
        } else {
            m3022a = c1656ha.m3022a();
        }
        InterfaceC1671hp m1345a = m1345a(c1656ha.m3009a(), c1656ha.f2445b);
        if (m1345a != null) {
            C1670ho.m3312a(m1345a, m3022a);
        }
        return m1345a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.r$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f879a;

        static {
            int[] iArr = new int[EnumC1633ge.values().length];
            f879a = iArr;
            try {
                iArr[EnumC1633ge.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f879a[EnumC1633ge.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f879a[EnumC1633ge.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f879a[EnumC1633ge.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f879a[EnumC1633ge.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f879a[EnumC1633ge.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f879a[EnumC1633ge.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f879a[EnumC1633ge.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f879a[EnumC1633ge.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f879a[EnumC1633ge.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: a */
    private static InterfaceC1671hp m1345a(EnumC1633ge enumC1633ge, boolean z) {
        switch (AnonymousClass1.f879a[enumC1633ge.ordinal()]) {
            case 1:
                return new C1661hf();
            case 2:
                return new C1667hl();
            case 3:
                return new C1665hj();
            case 4:
                return new C1669hn();
            case 5:
                return new C1663hh();
            case 6:
                return new C1649gu();
            case 7:
                return new C1654gz();
            case 8:
                return new C1662hg();
            case 9:
                if (z) {
                    return new C1659hd();
                }
                C1650gv c1650gv = new C1650gv();
                c1650gv.m2932a(true);
                return c1650gv;
            case 10:
                return new C1654gz();
            default:
                return null;
        }
    }
}
