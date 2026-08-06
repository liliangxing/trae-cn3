package com.bytedance.ug.sdk.share.impl.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public class ImageUtils {
    public static Bitmap compressBitmap(Bitmap bitmap) {
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, new ByteArrayOutputStream());
        float sqrt = (float) Math.sqrt(512000.0f / r0.toByteArray().length);
        Matrix matrix = new Matrix();
        if (sqrt >= 1.0f) {
            return bitmap;
        }
        matrix.setScale(sqrt, sqrt);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public static byte[] compressBitmapToByteArray(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap != null) {
            ?? isRecycled = bitmap.isRecycled();
            try {
                if (isRecycled == 0) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            int i2 = 100;
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            int i3 = i * 1024;
                            if (byteArrayOutputStream.toByteArray().length <= i3) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e) {
                                    Logger.e(e.toString());
                                }
                                return byteArray;
                            }
                            byteArrayOutputStream.reset();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                            if (byteArrayOutputStream.toByteArray().length > i3) {
                                float sqrt = (float) Math.sqrt(i3 / byteArrayOutputStream.toByteArray().length);
                                Matrix matrix = new Matrix();
                                matrix.setScale(sqrt, sqrt);
                                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                byteArrayOutputStream.reset();
                                createBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                                Bitmap bitmap2 = createBitmap;
                                while (byteArrayOutputStream.toByteArray().length > i3) {
                                    matrix.setScale(0.9f, 0.9f);
                                    bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                                    byteArrayOutputStream.reset();
                                    bitmap2.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                                }
                                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
                                    Logger.e(e2.toString());
                                }
                                return byteArray2;
                            }
                            do {
                                byteArrayOutputStream.reset();
                                i2 -= 10;
                                bitmap.compress(Bitmap.CompressFormat.PNG, i2, byteArrayOutputStream);
                            } while (byteArrayOutputStream.toByteArray().length > i3);
                            byte[] byteArray3 = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                Logger.e(e3.toString());
                            }
                            return byteArray3;
                        } catch (Exception e4) {
                            e = e4;
                            Logger.throwException(e);
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e5) {
                                    Logger.e(e5.toString());
                                }
                            }
                            return null;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        byteArrayOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e7) {
                                Logger.e(e7.toString());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = isRecycled;
            }
        }
        return null;
    }
}
