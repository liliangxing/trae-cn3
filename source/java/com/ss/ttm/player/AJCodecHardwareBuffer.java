package com.ss.ttm.player;

import android.hardware.HardwareBuffer;

/* loaded from: classes7.dex */
public class AJCodecHardwareBuffer {
    public int colorSpace;
    public HardwareBuffer hardwareBuffer;
    public int[] roi;
    public int rotation;

    public AJCodecHardwareBuffer(HardwareBuffer hardwareBuffer, int[] roi, int rotation, int colorSpace) {
        this.hardwareBuffer = hardwareBuffer;
        this.roi = roi;
        this.rotation = rotation;
        this.colorSpace = colorSpace;
    }
}
