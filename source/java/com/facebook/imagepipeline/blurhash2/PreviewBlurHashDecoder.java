package com.facebook.imagepipeline.blurhash2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.fresco.nativeheif.Heif;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer;
import java.io.UnsupportedEncodingException;

/* loaded from: classes6.dex */
public final class PreviewBlurHashDecoder {
    private static final String TAG = "PreviewBlur";

    public static Bitmap getBlurhashBitmap(String str, String str2, int i, int i2) {
        return getBlurhashBitmap(false, str, str2, i, i2, null);
    }

    public static Bitmap getBlurhashBitmap(boolean z, String str, String str2, int i, int i2, PreviewBlurHashProducer.PreviewDealFailCallBack previewDealFailCallBack) {
        Bitmap decodeByteArray;
        String recoverVvicMetaData = z ? recoverVvicMetaData(str, str2) : recoverMetaData(str, str2);
        if (TextUtils.isEmpty(recoverVvicMetaData)) {
            FLog.d(TAG, "getBlurhashBitmap: totalImgStr is null!");
            previewDealFailCallBack.decodeFailed("getBlurhashBitmap: totalImgStr is null!");
            return null;
        }
        try {
            byte[] bytes = recoverVvicMetaData.getBytes("ISO-8859-1");
            if (z) {
                int[] iArr = new int[1];
                decodeByteArray = Heif.previewToRgbaBitmap(bytes, bytes.length, 64, 64, iArr);
                if (decodeByteArray == null) {
                    previewDealFailCallBack.decodeFailed("previewToRgbaBitmap failed: errCode is " + iArr[0]);
                    return null;
                }
            } else {
                decodeByteArray = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                if (decodeByteArray == null) {
                    previewDealFailCallBack.decodeFailed("BitmapFactory decodeByteArray failed ");
                    return null;
                }
            }
            try {
                Class<?> cls = Class.forName("com.facebook.imagepipeline.nativecode.NativeBlurFilter");
                cls.getDeclaredMethod("iterativeBoxBlur", Bitmap.class, Integer.TYPE, Integer.TYPE).invoke(cls, decodeByteArray, Integer.valueOf(i), Integer.valueOf(i2));
                return decodeByteArray;
            } catch (Exception e) {
                e.printStackTrace();
                previewDealFailCallBack.decodeFailed("NativeBlurFilter deal failed! " + e.getMessage());
                return decodeByteArray;
            }
        } catch (UnsupportedEncodingException e2) {
            previewDealFailCallBack.decodeFailed("getBlurhashBitmap deal failed! UnsupportedEncodingException " + e2.getMessage());
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            previewDealFailCallBack.decodeFailed("getBlurhashBitmap deal failed! " + th.getMessage());
            th.printStackTrace();
            return null;
        }
    }

    public static String recoverMetaData(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            FLog.d(TAG, "recoverMetaData: base64data or metaData is null!");
            return null;
        }
        try {
            String base64Decode = base64Decode(str, "ISO-8859-1");
            String base64Decode2 = base64Decode(str2, "ISO-8859-1");
            char charAt = base64Decode.charAt(0);
            char charAt2 = base64Decode.charAt(1);
            StringBuilder sb = new StringBuilder(base64Decode2);
            sb.setCharAt(166, charAt);
            sb.setCharAt(164, charAt2);
            sb.append(base64Decode.substring(2));
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String recoverVvicMetaData(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            FLog.d(TAG, "recoverMetaData: base64data or metaData is null!");
            return null;
        }
        try {
            return base64Decode(str2, "ISO-8859-1") + base64Decode(str, "ISO-8859-1");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String base64Decode(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            return new String(Base64.decode(str, 0), str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
