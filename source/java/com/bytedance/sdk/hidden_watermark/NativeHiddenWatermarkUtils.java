package com.bytedance.sdk.hidden_watermark;

import android.graphics.Bitmap;

/* loaded from: classes5.dex */
public class NativeHiddenWatermarkUtils {
    public static native int addWatermarkWithString(Bitmap bitmap, String str, int i, int i2);

    public static native int retrieveString(Bitmap bitmap, int i, byte[] bArr, int[] iArr);
}
