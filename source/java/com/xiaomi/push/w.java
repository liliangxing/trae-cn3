package com.xiaomi.push;

/* loaded from: classes7.dex */
public class w {
    private static int a;

    /* renamed from: a, reason: collision with other field name */
    public static final String f1095a;

    /* renamed from: a, reason: collision with other field name */
    public static boolean f1096a;

    static {
        String str = z.a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f1095a = str;
        f1096a = false;
        a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            a = 3;
        } else {
            a = 1;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m10244a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }

    public static int a() {
        return a;
    }

    public static void a(int i) {
        a = i;
    }
}
