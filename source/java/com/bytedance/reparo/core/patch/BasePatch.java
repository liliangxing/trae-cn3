package com.bytedance.reparo.core.patch;

/* loaded from: classes4.dex */
public class BasePatch {
    private static final int LOAD_STATE_FAILED = 1;
    private static final int LOAD_STATE_SUCCESS = 0;
    protected int loadState = -1;
    private boolean isOnline = false;

    public boolean isLegal() {
        return true;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public void setOnline(boolean z) {
        this.isOnline = z;
    }

    public void loadSuccess() {
        this.loadState = 0;
    }

    public void loadFailed() {
        this.loadState = 1;
    }

    public boolean isLoadFailed() {
        return this.loadState == 1;
    }

    public boolean isLoadSuccess() {
        return this.loadState == 0;
    }
}
