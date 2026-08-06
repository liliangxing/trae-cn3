package com.bytedance.sdk.hidden_watermark;

import android.graphics.Bitmap;

/* loaded from: classes5.dex */
public class HiddenWartermarkUtils {
    static {
        System.loadLibrary("hidden_watermark_lib");
    }

    public static String getHiddenString(Bitmap bitmap) {
        try {
            byte[] bArr = new byte[128];
            int[] iArr = new int[1];
            if (NativeHiddenWatermarkUtils.retrieveString(bitmap, 1, bArr, iArr) != 0) {
                return null;
            }
            int i = iArr[0];
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return new String(bArr2, "UTF-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean addHiddenString(Bitmap bitmap, String str) {
        try {
            return NativeHiddenWatermarkUtils.addWatermarkWithString(bitmap, str, str.length(), 1) == 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
