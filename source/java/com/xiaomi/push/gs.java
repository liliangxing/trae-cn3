package com.xiaomi.push;

/* loaded from: classes7.dex */
public enum gs {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f632a;

    gs(int i) {
        this.f632a = i;
    }

    public int a() {
        return this.f632a;
    }

    public static gs a(int i) {
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
