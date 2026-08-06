package com.ss.ttm.player;

import android.hardware.HardwareBuffer;

/* loaded from: classes7.dex */
public abstract class RenderTrait extends TraitObject {
    public static final int Version0 = 0;

    public abstract void onClose();

    public abstract int onDrawFrame(HardwareBuffer hardwareBuffer, int[] rect, int rotation);

    public int onDrawFrame(AJCodecHardwareBuffer hardwareBuffer) {
        return 0;
    }

    public abstract int onOpen();

    public int onOpen(int renderDevice) {
        return -1;
    }

    public RenderTrait(int version) {
        super(6, version, 0L);
    }
}
