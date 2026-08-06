package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.C1649gu;
import com.xiaomi.push.C1650gv;
import com.xiaomi.push.C1654gz;
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

/* renamed from: com.xiaomi.push.service.bc */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1772bc {
    /* renamed from: a */
    public static InterfaceC1671hp m3819a(Context context, C1656ha c1656ha) {
        if (c1656ha.m3027b()) {
            return null;
        }
        byte[] m3022a = c1656ha.m3022a();
        InterfaceC1671hp m3820a = m3820a(c1656ha.m3009a(), c1656ha.f2445b);
        if (m3820a != null) {
            C1670ho.m3312a(m3820a, m3022a);
        }
        return m3820a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.bc$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3132a;

        static {
            int[] iArr = new int[EnumC1633ge.values().length];
            f3132a = iArr;
            try {
                iArr[EnumC1633ge.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3132a[EnumC1633ge.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3132a[EnumC1633ge.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3132a[EnumC1633ge.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3132a[EnumC1633ge.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3132a[EnumC1633ge.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3132a[EnumC1633ge.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3132a[EnumC1633ge.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3132a[EnumC1633ge.Notification.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3132a[EnumC1633ge.Command.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: a */
    private static InterfaceC1671hp m3820a(EnumC1633ge enumC1633ge, boolean z) {
        switch (AnonymousClass1.f3132a[enumC1633ge.ordinal()]) {
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
