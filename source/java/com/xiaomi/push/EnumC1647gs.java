package com.xiaomi.push;

/* renamed from: com.xiaomi.push.gs */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public enum EnumC1647gs {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a */
    private final int f2295a;

    EnumC1647gs(int i) {
        this.f2295a = i;
    }

    /* renamed from: a */
    public int m2879a() {
        return this.f2295a;
    }

    /* renamed from: a */
    public static EnumC1647gs m2878a(int i) {
        if (i == 0) {
            return RegIdExpired;
        }
        if (i == 1) {
            return PackageUnregistered;
        }
        if (i != 2) {
            return null;
        }
        return Init;
    }
}
