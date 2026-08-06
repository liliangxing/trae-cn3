package com.vivo.push.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: BitmapUtil.java */
/* renamed from: com.vivo.push.util.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1377d {
    /* renamed from: a */
    public static Bitmap m993a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i / width;
        float f2 = i2 / height;
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f2);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception unused) {
            return bitmap;
        }
    }
}
