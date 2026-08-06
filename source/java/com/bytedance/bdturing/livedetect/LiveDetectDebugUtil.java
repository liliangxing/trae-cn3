package com.bytedance.bdturing.livedetect;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import com.bytedance.bdturing.livedetect.camera.ImageUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public class LiveDetectDebugUtil {
    private static final String DEBUG_CACHE_DIR = "turing_debug_info_cache";
    private static final String IMG_CACHE_DIR = "turing_img_cache";
    private static final String TAG = "LiveDetectDebugUtil";
    static int currentNum = 0;
    static int max_cache_size = 2;

    public static void testSaveDetectResult(Context context, String str) {
        FileWriter fileWriter;
        File file = new File(context.getCacheDir(), DEBUG_CACHE_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "debug_info.txt");
        FileWriter fileWriter2 = null;
        try {
            try {
                try {
                    fileWriter = new FileWriter(file2);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(str);
            fileWriter.close();
        } catch (Exception e3) {
            e = e3;
            fileWriter2 = fileWriter;
            e.printStackTrace();
            if (fileWriter2 != null) {
                fileWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void saveBitmapForTest(Context context, Bitmap bitmap) {
        int i;
        System.currentTimeMillis();
        if (bitmap != null && (i = currentNum) < max_cache_size) {
            currentNum = i + 1;
            File file = new File(context.getCacheDir(), IMG_CACHE_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            ImageUtil.saveBitmap(bitmap, new File(file, "_" + System.currentTimeMillis() + ".jpeg").getAbsolutePath());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveBmpData(Context context, ImageDataWrapper imageDataWrapper) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        int i = currentNum;
        if (i >= max_cache_size) {
            return;
        }
        currentNum = i + 1;
        ?? file = new File(context.getCacheDir(), IMG_CACHE_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    String str = System.currentTimeMillis() + "";
                    String str2 = "_" + str;
                    ImageUtil.saveBitmap(imageDataWrapper.bitmap, new File((File) file, "_" + str + ".jpg").getAbsolutePath());
                    if (imageDataWrapper.rgbBytes != null && imageDataWrapper.rgbBytes.length > 0) {
                        fileOutputStream = new FileOutputStream(new File((File) file, str2));
                        try {
                            fileOutputStream.write(imageDataWrapper.rgbBytes);
                            fileOutputStream.close();
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (file != 0) {
                        try {
                            file.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                fileOutputStream = null;
                e = e4;
            } catch (Throwable th3) {
                file = 0;
                th = th3;
                if (file != 0) {
                }
                throw th;
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static void deleteFileOrDir(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        for (File file2 : file.listFiles()) {
            deleteFileOrDir(file2);
        }
    }
}
