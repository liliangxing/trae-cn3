package com.bytedance.ug.sdk.share.image.manager;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public class HiddenWartermarkDepend {
    public static String getHiddenString(Bitmap bitmap) {
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.hidden_watermark.HiddenWartermarkUtils");
            return (String) cls.getDeclaredMethod("getHiddenString", Bitmap.class).invoke(cls, bitmap);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean addHiddenString(Bitmap bitmap, String str) {
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.hidden_watermark.HiddenWartermarkUtils");
            return ((Boolean) cls.getDeclaredMethod("addHiddenString", Bitmap.class, String.class).invoke(cls, bitmap, str)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }
}
