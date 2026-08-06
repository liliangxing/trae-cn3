package com.lynx.tasm;

/* loaded from: classes6.dex */
public enum LynxLoadMode {
    NORMAL(0),
    PRE_PAINTING(1),
    PRE_PAINTING_DRAW(2),
    RENDER_SSR(3),
    HYDRATE_SSR(4);

    private int mId;

    LynxLoadMode(int i) {
        this.mId = i;
    }

    public int id() {
        return this.mId;
    }
}
