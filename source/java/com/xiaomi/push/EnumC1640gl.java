package com.xiaomi.push;

/* renamed from: com.xiaomi.push.gl */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public enum EnumC1640gl {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* renamed from: a */
    private final int f2129a;

    EnumC1640gl(int i) {
        this.f2129a = i;
    }

    /* renamed from: a */
    public static EnumC1640gl m2763a(int i) {
        if (i == 1) {
            return INT;
        }
        if (i == 2) {
            return LONG;
        }
        if (i == 3) {
            return STRING;
        }
        if (i != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
