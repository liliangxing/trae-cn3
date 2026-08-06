package com.lynx.tasm.behavior.p000ui.background;

import com.lynx.react.bridge.Dynamic;
import com.lynx.tasm.behavior.p000ui.utils.PlatformLength;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BackgroundPosition {
    private final PlatformLength mLength;

    public BackgroundPosition(Dynamic dynamic, int i) {
        this.mLength = new PlatformLength(dynamic, i);
    }

    public float apply(float f) {
        return this.mLength.getValue(f);
    }
}
