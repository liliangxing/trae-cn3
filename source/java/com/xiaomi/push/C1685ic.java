package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ic */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1685ic {

    /* renamed from: a */
    private static int f2789a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m3406a(AbstractC1681hz abstractC1681hz, byte b) {
        m3407a(abstractC1681hz, b, f2789a);
    }

    /* renamed from: a */
    public static void m3407a(AbstractC1681hz abstractC1681hz, byte b, int i) {
        if (i <= 0) {
            throw new C1675ht("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                abstractC1681hz.mo3361a();
                return;
            case 3:
                abstractC1681hz.mo3336a();
                return;
            case 4:
                abstractC1681hz.mo3337a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                abstractC1681hz.mo3348a();
                return;
            case 8:
                abstractC1681hz.mo3338a();
                return;
            case 10:
                abstractC1681hz.mo3339a();
                return;
            case 11:
                abstractC1681hz.mo3347a();
                return;
            case 12:
                abstractC1681hz.mo3344a();
                while (true) {
                    C1678hw mo3340a = abstractC1681hz.mo3340a();
                    if (mo3340a.f2770a != 0) {
                        m3407a(abstractC1681hz, mo3340a.f2770a, i - 1);
                        abstractC1681hz.mo3369g();
                    } else {
                        abstractC1681hz.mo3368f();
                        return;
                    }
                }
            case 13:
                C1680hy mo3342a = abstractC1681hz.mo3342a();
                while (i2 < mo3342a.f2776a) {
                    int i3 = i - 1;
                    m3407a(abstractC1681hz, mo3342a.f2775a, i3);
                    m3407a(abstractC1681hz, mo3342a.f2777b, i3);
                    i2++;
                }
                abstractC1681hz.mo3370h();
                return;
            case 14:
                C1686id mo3343a = abstractC1681hz.mo3343a();
                while (i2 < mo3343a.f2791a) {
                    m3407a(abstractC1681hz, mo3343a.f2790a, i - 1);
                    i2++;
                }
                abstractC1681hz.mo3372j();
                return;
            case 15:
                C1679hx mo3341a = abstractC1681hz.mo3341a();
                while (i2 < mo3341a.f2774a) {
                    m3407a(abstractC1681hz, mo3341a.f2773a, i - 1);
                    i2++;
                }
                abstractC1681hz.mo3371i();
                return;
        }
    }
}
