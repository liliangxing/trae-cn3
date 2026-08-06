package com.huawei.hms.common;

/* loaded from: classes6.dex */
public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);

    private final int a;

    HmsCheckedState(int i) {
        this.a = i;
    }

    public int getState() {
        return this.a;
    }
}
