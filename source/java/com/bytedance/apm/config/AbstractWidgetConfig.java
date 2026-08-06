package com.bytedance.apm.config;

/* loaded from: classes3.dex */
public abstract class AbstractWidgetConfig {
    private boolean mSwitchOn = false;

    public AbstractWidgetConfig setSwitch(boolean z) {
        this.mSwitchOn = z;
        return this;
    }

    public boolean isSwitchOn() {
        return this.mSwitchOn;
    }
}
