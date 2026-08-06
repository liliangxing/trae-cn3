package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* renamed from: com.xiaomi.push.cr */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1538cr {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.cr$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1229a;

        static {
            int[] iArr = new int[EnumC1633ge.values().length];
            f1229a = iArr;
            try {
                iArr[EnumC1633ge.Registration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1229a[EnumC1633ge.UnRegistration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1229a[EnumC1633ge.Subscription.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1229a[EnumC1633ge.UnSubscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1229a[EnumC1633ge.SendMessage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1229a[EnumC1633ge.AckMessage.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1229a[EnumC1633ge.SetConfig.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1229a[EnumC1633ge.ReportFeedback.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1229a[EnumC1633ge.MultiConnectionBroadcast.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1229a[EnumC1633ge.MultiConnectionResult.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1229a[EnumC1633ge.Notification.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1229a[EnumC1633ge.Command.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* renamed from: a */
    public static int m1925a(InterfaceC1671hp interfaceC1671hp, EnumC1633ge enumC1633ge) {
        int m2259a;
        switch (AnonymousClass1.f1229a[enumC1633ge.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return C1565dr.m2259a(enumC1633ge.m2714a());
            case 11:
                m2259a = C1565dr.m2259a(enumC1633ge.m2714a());
                if (interfaceC1671hp != null) {
                    try {
                        if (interfaceC1671hp instanceof C1650gv) {
                            String str = ((C1650gv) interfaceC1671hp).f2370d;
                            if (!TextUtils.isEmpty(str) && C1565dr.m2260a(C1565dr.m2267a(str)) != -1) {
                                m2259a = C1565dr.m2260a(C1565dr.m2267a(str));
                                break;
                            }
                        } else if (interfaceC1671hp instanceof C1659hd) {
                            String str2 = ((C1659hd) interfaceC1671hp).f2478d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (C1565dr.m2260a(C1565dr.m2267a(str2)) != -1) {
                                    m2259a = C1565dr.m2260a(C1565dr.m2267a(str2));
                                }
                                if (EnumC1643go.UploadTinyData.equals(C1565dr.m2267a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        AbstractC1417b.m1103d("PERF_ERROR : parse Notification type error");
                        return m2259a;
                    }
                }
                break;
            case 12:
                m2259a = C1565dr.m2259a(enumC1633ge.m2714a());
                if (interfaceC1671hp != null) {
                    try {
                        if (interfaceC1671hp instanceof C1654gz) {
                            String m2993b = ((C1654gz) interfaceC1671hp).m2993b();
                            if (!TextUtils.isEmpty(m2993b) && EnumC1577ec.m2340a(m2993b) != -1) {
                                m2259a = EnumC1577ec.m2340a(m2993b);
                                break;
                            }
                        } else if (interfaceC1671hp instanceof C1653gy) {
                            String m2965a = ((C1653gy) interfaceC1671hp).m2965a();
                            if (!TextUtils.isEmpty(m2965a) && EnumC1577ec.m2340a(m2965a) != -1) {
                                return EnumC1577ec.m2340a(m2965a);
                            }
                        }
                    } catch (Exception unused2) {
                        AbstractC1417b.m1103d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return m2259a;
    }

    /* renamed from: a */
    public static int m1923a(Context context, int i) {
        int m2654a = C1626fy.m2654a(context);
        if (-1 == m2654a) {
            return -1;
        }
        return (i * (m2654a == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a */
    public static int m1924a(EnumC1633ge enumC1633ge) {
        return C1565dr.m2259a(enumC1633ge.m2714a());
    }

    /* renamed from: a */
    public static void m1929a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        C1656ha c1656ha = new C1656ha();
        try {
            C1670ho.m3312a(c1656ha, bArr);
            m1927a(str, context, c1656ha, bArr.length);
        } catch (C1675ht unused) {
            AbstractC1417b.m1089a("fail to convert bytes to container");
        }
    }

    /* renamed from: a */
    public static void m1927a(String str, Context context, C1656ha c1656ha, int i) {
        EnumC1633ge m3009a;
        if (context == null || c1656ha == null || (m3009a = c1656ha.m3009a()) == null) {
            return;
        }
        int m1924a = m1924a(m3009a);
        if (i <= 0) {
            byte[] m3313a = C1670ho.m3313a(c1656ha);
            i = m3313a != null ? m3313a.length : 0;
        }
        m1926a(str, context, m1924a, i);
    }

    /* renamed from: a */
    public static void m1926a(String str, Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int m1923a = m1923a(context, i2);
        if (i != C1565dr.m2260a(EnumC1643go.UploadTinyData)) {
            C1566ds.m2275a(context.getApplicationContext()).m2277a(str, i, 1L, m1923a);
        }
    }

    /* renamed from: a */
    public static void m1928a(String str, Context context, InterfaceC1671hp interfaceC1671hp, EnumC1633ge enumC1633ge, int i) {
        m1926a(str, context, m1925a(interfaceC1671hp, enumC1633ge), i);
    }
}
