package com.bytedance.bdinstall;

/* loaded from: classes3.dex */
public enum Level {
    L0(0),
    L1(1);

    private final int mLevel;

    Level(int i) {
        this.mLevel = i;
    }

    public int value() {
        return this.mLevel;
    }
}
