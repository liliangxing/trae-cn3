package com.bytedance.bdturing.livedetect.yuv;

import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;

/* loaded from: classes3.dex */
public class TuringYuv {
    public static native ImageDataWrapper I420ToBitmap(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native String readMsg(byte[] bArr);

    static {
        System.loadLibrary("yuv");
        System.loadLibrary("TuringYuvUtils");
    }
}
