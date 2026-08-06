package com.lynx.tasm;

/* loaded from: classes6.dex */
public enum ThreadStrategyForRendering {
    ALL_ON_UI(0),
    MOST_ON_TASM(1),
    PART_ON_LAYOUT(2),
    MULTI_THREADS(3);

    private int mId;

    ThreadStrategyForRendering(int i) {
        this.mId = i;
    }

    public int id() {
        return this.mId;
    }
}
