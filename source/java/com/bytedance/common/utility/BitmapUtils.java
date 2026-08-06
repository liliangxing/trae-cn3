package com.bytedance.common.utility;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;
import java.io.IOException;

@Deprecated
/* loaded from: classes3.dex */
public final class BitmapUtils {
    private static final int COMPRESS_QUALITY = 100;
    private static final int LOAD_QUALITY = 80;
    private static final int MAX_BYTE = 8192;
    private static final int MAX_OUT_HEIGHT = 4000;
    private static final int MAX_RATIO = 4;
    private static final int ROTATE_180 = 180;
    private static final int ROTATE_270 = 270;
    private static final int ROTATE_90 = 90;
    private static final int ROTATE_QUALITY = 50;
    private static final int SD_QUALITY = 100;
    private static final String TAG = "BitmapUtils";
    private static final int WIDTH_RANGE = 150;

    private BitmapUtils() {
    }

    public static Bitmap decodeBitmap(byte[] bArr, int i, int i2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(bArr, i, i2);
    }

    public static Bitmap decodeBitmap(File file, int i, int i2, Bitmap.Config config) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(file, i, i2, config);
    }

    public static Bitmap decodeBitmap(File file, int i) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(file, i);
    }

    public static Bitmap decodeBitmap(File file, int i, boolean z) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(file, i, z);
    }

    public static Bitmap decodeBitmap(File file) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(file);
    }

    public static boolean saveBitmapToSD(Bitmap bitmap, String str, String str2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.saveBitmapToSD(bitmap, str, str2);
    }

    public static boolean saveImageData(byte[] bArr, String str, String str2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.saveImageData(bArr, str, str2);
    }

    @Deprecated
    public static void rotateImage(String str) {
        com.bytedance.android.standard.tools.file.BitmapUtils.rotateImage(str);
    }

    public static int readPictureDegree(String str) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.readPictureDegree(str);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.rotateBitmap(bitmap, i);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, int i3) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(str, i, i2, i3);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, int i3, Bitmap.Config config) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(str, i, i2, i3, config);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(str, i, i2);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, Bitmap.Config config) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(str, i, i2, config);
    }

    public static Bitmap getBitmapFromSD(String str, int i) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(str, i);
    }

    public static Bitmap getBitmapFromSD(String str, int i, boolean z) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(str, i, z);
    }

    public static Bitmap getBitmapFromSD(String str) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.getBitmapFromSD(str);
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.resizeBitmap(bitmap, i, i2);
    }

    public static Bitmap loadBitmap(int i, String str) throws IOException {
        return com.bytedance.android.standard.tools.file.BitmapUtils.loadBitmap(i, str);
    }

    public static Bitmap loadBitmap(int i, String str, boolean z) throws IOException {
        return com.bytedance.android.standard.tools.file.BitmapUtils.loadBitmap(i, str, z);
    }

    public static Bitmap decodeBitmap(ContentResolver contentResolver, Uri uri, int i, int i2) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(contentResolver, uri, i, i2);
    }

    public static Bitmap decodeBitmap(Context context, int i, int i2, int i3) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.decodeBitmap(context, i, i2, i3);
    }

    public static Bitmap compressBitmap(Bitmap bitmap, long j) {
        return com.bytedance.android.standard.tools.file.BitmapUtils.compressBitmap(bitmap, j);
    }
}
