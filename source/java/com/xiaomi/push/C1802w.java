package com.xiaomi.push;

/* renamed from: com.xiaomi.push.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1802w {

    /* renamed from: a */
    private static int f3271a;

    /* renamed from: a */
    public static final String f3272a;

    /* renamed from: a */
    public static boolean f3273a;

    static {
        String str = C1805z.f3274a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f3272a = str;
        f3273a = false;
        f3271a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            f3271a = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            f3271a = 3;
        } else {
            f3271a = 1;
        }
    }

    /* renamed from: a */
    public static boolean m4115a() {
        return f3271a == 2;
    }

    /* renamed from: b */
    public static boolean m4116b() {
        return f3271a == 3;
    }

    /* renamed from: a */
    public static int m4113a() {
        return f3271a;
    }

    /* renamed from: a */
    public static void m4114a(int i) {
        f3271a = i;
    }
}
