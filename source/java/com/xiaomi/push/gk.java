package com.xiaomi.push;

/* loaded from: classes7.dex */
public enum gk {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f572a;

    gk(int i) {
        this.f572a = i;
    }

    public int a() {
        return this.f572a;
    }

    public static gk a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
