package com.lynx.tasm.utils;

import android.graphics.Bitmap;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes7.dex */
public class BitmapUtils {
    public static String bitmapToBase64WithQuality(Bitmap bitmap, int i) {
        return bitmapToBase64(bitmap, Bitmap.CompressFormat.JPEG, i, 0);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:43:0x0033 */
    public static String bitmapToBase64(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(compressFormat, i, byteArrayOutputStream2);
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        encodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), i2);
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 == null) {
                            return null;
                        }
                        try {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                            return null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                encodeToString = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return encodeToString;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }
}
