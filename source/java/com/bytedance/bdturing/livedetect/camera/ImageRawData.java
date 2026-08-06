package com.bytedance.bdturing.livedetect.camera;

/* loaded from: classes3.dex */
public class ImageRawData {
    public static final int COLOR_FORMAT_I420 = 2;
    public static final int COLOR_FORMAT_NV21 = 1;
    private int colorFormat;
    private int height;
    private int rotateDegree;
    private int width;
    private byte[] yuvData;

    public ImageRawData(int i, int i2, byte[] bArr, int i3, int i4) {
        this.yuvData = bArr;
        this.width = i;
        this.height = i2;
        this.rotateDegree = i4;
        this.colorFormat = i3;
    }

    public byte[] getYuvData() {
        return this.yuvData;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getRotateDegree() {
        return this.rotateDegree;
    }

    public int getColorFormat() {
        return this.colorFormat;
    }
}
