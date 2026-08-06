package com.xiaomi.push;

/* renamed from: com.xiaomi.push.gk */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public enum EnumC1639gk {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* renamed from: a */
    private final int f2123a;

    EnumC1639gk(int i) {
        this.f2123a = i;
    }

    /* renamed from: a */
    public int m2762a() {
        return this.f2123a;
    }

    /* renamed from: a */
    public static EnumC1639gk m2761a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
