package com.lynx.tasm.behavior.ui.background;

import com.lynx.react.bridge.Dynamic;
import com.lynx.tasm.behavior.ui.utils.PlatformLength;

/* loaded from: classes7.dex */
public class BackgroundSize {
    private final PlatformLength mLength;

    public boolean isCover() {
        return this.mLength.asNumber() == -33.0f;
    }

    public boolean isContain() {
        return this.mLength.asNumber() == -34.0f;
    }

    public boolean isAuto() {
        return this.mLength.asNumber() == -32.0f;
    }

    public BackgroundSize(Dynamic dynamic, int i) {
        this.mLength = new PlatformLength(dynamic, i);
    }

    public float apply(float f, float f2) {
        return isAuto() ? f2 : this.mLength.getValue(f);
    }
}
