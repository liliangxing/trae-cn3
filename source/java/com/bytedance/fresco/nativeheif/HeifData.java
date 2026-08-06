package com.bytedance.fresco.nativeheif;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class HeifData {
    public final byte[] data;
    public final float displayRatioForFullHdr;
    public final float[] epsilonHdr;
    public final float[] epsilonSdr;
    public final int error;
    public final byte[] gainMapData;
    public final int gainMapHeight;
    public final int gainMapWidth;
    public final float[] gamma;
    public final int height;
    public final boolean isVvif;
    public final float minDisplayRatioForHdrTransition;
    public final float[] ratioMax;
    public final float[] ratioMin;
    public final int width;

    public HeifData(int i) {
        this.data = null;
        this.gainMapData = null;
        this.width = 0;
        this.height = 0;
        this.gainMapWidth = 0;
        this.gainMapHeight = 0;
        this.isVvif = false;
        this.error = i;
        this.gamma = null;
        this.epsilonSdr = null;
        this.epsilonHdr = null;
        this.ratioMax = null;
        this.ratioMin = null;
        this.displayRatioForFullHdr = 0.0f;
        this.minDisplayRatioForHdrTransition = 0.0f;
    }

    public HeifData(byte[] bArr, int i, int i2, boolean z) {
        this.data = bArr;
        this.gainMapData = null;
        this.width = i;
        this.height = i2;
        this.gainMapWidth = 0;
        this.gainMapHeight = 0;
        this.isVvif = z;
        this.error = 0;
        this.gamma = null;
        this.epsilonSdr = null;
        this.epsilonHdr = null;
        this.ratioMax = null;
        this.ratioMin = null;
        this.displayRatioForFullHdr = 0.0f;
        this.minDisplayRatioForHdrTransition = 0.0f;
    }

    public HeifData(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, boolean z, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float f, float f2) {
        this.data = bArr;
        this.gainMapData = bArr2;
        this.width = i;
        this.height = i2;
        this.gainMapWidth = i3;
        this.gainMapHeight = i4;
        this.isVvif = z;
        this.error = 0;
        this.gamma = fArr;
        this.epsilonSdr = fArr2;
        this.epsilonHdr = fArr3;
        this.ratioMax = fArr4;
        this.ratioMin = fArr5;
        this.displayRatioForFullHdr = f;
        this.minDisplayRatioForHdrTransition = f2;
    }

    public Bitmap newBitmap(Bitmap.Config config) {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length <= 0 || this.width <= 0 || this.height <= 0) {
            return null;
        }
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, config);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(this.data));
        return createBitmap;
    }

    public Bitmap newBitmapWithGainMap(Bitmap.Config config, boolean z) {
        int i;
        int i2;
        Bitmap createBitmap;
        int i3;
        byte[] bArr = this.data;
        if (bArr == null || bArr.length <= 0 || (i = this.width) <= 0 || (i2 = this.height) <= 0) {
            return null;
        }
        if (z) {
            createBitmap = GainmapReflectionHelper.createBitmapWithConfig(i, i2, "RGBA_1010102");
            if (Build.VERSION.SDK_INT >= 34) {
                GainmapReflectionHelper.setBT2020HLGColorSpace(createBitmap);
            }
        } else {
            createBitmap = Bitmap.createBitmap(i, i2, config);
        }
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(this.data));
        if (Build.VERSION.SDK_INT >= 26) {
            Log.d("debug_hdr", "newBitmapWithGainMap: gainMapWidth = " + this.gainMapWidth + ", gainMapHeight = " + this.gainMapHeight + ", config = " + createBitmap.getConfig() + ", getColorSpace = " + createBitmap.getColorSpace());
        }
        int i4 = this.gainMapWidth;
        if (i4 > 0 && (i3 = this.gainMapHeight) > 0 && this.gainMapData != null) {
            Bitmap createBitmap2 = Bitmap.createBitmap(i4, i3, Bitmap.Config.ARGB_8888);
            createBitmap2.copyPixelsFromBuffer(ByteBuffer.wrap(this.gainMapData));
            if (Build.VERSION.SDK_INT >= 34) {
                GainmapReflectionHelper.safeSetGainmap(createBitmap, GainmapReflectionHelper.createGainmapWithMeta(createBitmap2, this.gamma, this.epsilonSdr, this.epsilonHdr, this.ratioMax, this.ratioMin, this.displayRatioForFullHdr, this.minDisplayRatioForHdrTransition));
            }
        }
        return createBitmap;
    }
}
