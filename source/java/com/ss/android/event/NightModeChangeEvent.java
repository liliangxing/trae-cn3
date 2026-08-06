package com.ss.android.event;

/* loaded from: classes7.dex */
public class NightModeChangeEvent {
    private boolean mChecked;

    public NightModeChangeEvent(boolean z) {
        this.mChecked = z;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public boolean isChecked() {
        return this.mChecked;
    }
}
