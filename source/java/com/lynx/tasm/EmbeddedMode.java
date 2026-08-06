package com.lynx.tasm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public final class EmbeddedMode {
    public static final int EMBEDDED_MODE_ALL = 7;
    public static final int EMBEDDED_MODE_BASE = 1;
    public static final int ENGINE_POOL = 2;
    public static final int FRAGMENT_LAYER_RENDER = 8;
    public static final int LAYOUT_IN_ELEMENT = 4;
    public static final int UNSET = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface Mode {
    }

    public static boolean isBaseModeEnable(int i) {
        return (i & 1) > 0;
    }

    private EmbeddedMode() {
    }

    public static boolean isEnginePoolEnable(int i) {
        return (i & 2) > 0 && isBaseModeEnable(i);
    }
}
