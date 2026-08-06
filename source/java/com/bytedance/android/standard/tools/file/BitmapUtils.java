package com.bytedance.android.standard.tools.file;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import com.bytedance.android.standard.tools.logging.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
        if (bArr != null && i >= 1 && i2 >= 1) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                int i5 = 1;
                while (true) {
                    if (i3 / 2 < i && i4 / 2 < i2) {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = i5;
                        options2.inPurgeable = true;
                        options2.inPreferredConfig = Bitmap.Config.RGB_565;
                        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
                    }
                    i3 /= 2;
                    i4 /= 2;
                    i5 *= 2;
                }
            } catch (Exception e) {
                Logger.d(TAG, "decode image error: " + e);
            }
        }
        return null;
    }

    public static Bitmap decodeBitmap(File file, int i, int i2, Bitmap.Config config) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && i > 0 && i2 > 0) {
            try {
                if (!file.isFile()) {
                    return null;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                fileInputStream = new FileInputStream(file);
                try {
                    BitmapFactory.decodeStream(fileInputStream, null, options);
                    fileInputStream.close();
                    int i3 = options.outWidth;
                    int i4 = options.outHeight;
                    int i5 = 1;
                    while (true) {
                        if (i3 / 2 < i && i4 / 2 < i2) {
                            break;
                        }
                        i3 /= 2;
                        i4 /= 2;
                        i5 *= 2;
                    }
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inSampleSize = i5;
                    options2.inPurgeable = true;
                    if (config != null) {
                        options2.inPreferredConfig = config;
                    } else {
                        options2.inPreferredConfig = Bitmap.Config.RGB_565;
                    }
                    FileInputStream fileInputStream3 = new FileInputStream(file);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream3, null, options2);
                        fileInputStream3.close();
                        return decodeStream;
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream3;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                }
            } catch (Exception unused5) {
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public static Bitmap decodeBitmap(File file, int i) {
        return decodeBitmap(file, i, false);
    }

    public static Bitmap decodeBitmap(File file, int i, boolean z) {
        BitmapFactory.Options options;
        Bitmap bitmap = null;
        try {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            FileInputStream fileInputStream = new FileInputStream(file);
            BitmapFactory.decodeStream(fileInputStream, null, options);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (options.outWidth > 0 && options.outHeight > 0) {
            int i2 = 1;
            while (options.outWidth >= i * 2 && options.outHeight >= 4000) {
                options.outWidth /= 2;
                options.outHeight /= 2;
                i2 *= 2;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i2;
            options2.inPurgeable = true;
            options2.inPreferredConfig = z ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            FileInputStream fileInputStream2 = new FileInputStream(file);
            bitmap = BitmapFactory.decodeStream(fileInputStream2, null, options2);
            fileInputStream2.close();
            if (bitmap == null) {
                file.delete();
            }
            return bitmap;
        }
        file.delete();
        return null;
    }

    public static Bitmap decodeBitmap(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return decodeStream;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                try {
                    fileInputStream2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2.close();
            throw th;
        }
    }

    public static boolean saveBitmapToSD(Bitmap bitmap, String str, String str2) {
        FileOutputStream fileOutputStream;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file + "/" + str2);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            try {
                fileOutputStream2.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                fileOutputStream2.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            throw th;
        }
    }

    public static boolean saveImageData(byte[] bArr, String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs() && !file.exists()) {
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    return true;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Logger.d(TAG, "save image exception " + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Deprecated
    public static void rotateImage(String str) {
        FileOutputStream fileOutputStream;
        int i = -1;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                i = 180;
            } else if (attributeInt == 6) {
                i = 90;
            } else if (attributeInt == 8) {
                i = 270;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (i > 0) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
            decodeFile.recycle();
            ?? r1 = 0;
            FileOutputStream fileOutputStream2 = null;
            FileOutputStream fileOutputStream3 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
            try {
                r1 = 50;
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    createBitmap.recycle();
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                r1 = fileOutputStream2;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        r1 = fileOutputStream2;
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        createBitmap.recycle();
                    }
                }
                createBitmap.recycle();
            } catch (IOException e7) {
                e = e7;
                fileOutputStream3 = fileOutputStream;
                e.printStackTrace();
                r1 = fileOutputStream3;
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                        r1 = fileOutputStream3;
                    } catch (IOException e8) {
                        e = e8;
                        e.printStackTrace();
                        createBitmap.recycle();
                    }
                }
                createBitmap.recycle();
            } catch (Throwable th2) {
                th = th2;
                r1 = fileOutputStream;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                createBitmap.recycle();
                throw th;
            }
            createBitmap.recycle();
        }
    }

    public static int readPictureDegree(String str) {
        int i;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                i = 180;
            } else if (attributeInt == 6) {
                i = 90;
            } else {
                if (attributeInt != 8) {
                    return 0;
                }
                i = 270;
            }
            return i;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, int i3) {
        return getBitmapFromSD(str, i, i2, i3, null);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, int i3, Bitmap.Config config) {
        try {
            File file = new File(str);
            if (!file.isFile()) {
                return null;
            }
            if (i3 > 0 && file.length() > i3) {
                file.delete();
                return null;
            }
            try {
                file.setLastModified(System.currentTimeMillis());
            } catch (Exception unused) {
            }
            return decodeBitmap(file, i, i2, config);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2) {
        return getBitmapFromSD(str, i, i2, -1, null);
    }

    public static Bitmap getBitmapFromSD(String str, int i, int i2, Bitmap.Config config) {
        return getBitmapFromSD(str, i, i2, -1, config);
    }

    public static Bitmap getBitmapFromSD(String str, int i) {
        return getBitmapFromSD(str, i, false);
    }

    public static Bitmap getBitmapFromSD(String str, int i, boolean z) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            file.setLastModified(System.currentTimeMillis());
        } catch (Exception unused) {
        }
        try {
            return decodeBitmap(file, i, z);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap getBitmapFromSD(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return decodeBitmap(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2) {
        boolean z;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > i || height > i2) {
            if (width <= height || width <= i) {
                i = (int) (width * (i2 / height));
            } else {
                i2 = (int) (height * (i / width));
            }
            width = i;
            z = true;
        } else {
            z = false;
            i2 = height;
        }
        return z ? Bitmap.createScaledBitmap(bitmap, width, i2, true) : bitmap;
    }

    public static Bitmap loadBitmap(int i, String str) throws IOException {
        return loadBitmap(i, str, false);
    }

    public static Bitmap loadBitmap(int i, String str, boolean z) throws IOException {
        Bitmap bitmapFromSD = getBitmapFromSD(str, i, z);
        if (bitmapFromSD == null) {
            return null;
        }
        int width = bitmapFromSD.getWidth();
        int height = bitmapFromSD.getHeight();
        if (width > i + 150 || (width > i && height > 4000)) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapFromSD, i, (int) (((i * 1.0f) * height) / width), true);
            bitmapFromSD.recycle();
            if (createScaledBitmap == null) {
                return null;
            }
            bitmapFromSD = createScaledBitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapFromSD.compress(z ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        bitmapFromSD.recycle();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inPreferredConfig = z ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap decodeBitmap(ContentResolver contentResolver, Uri uri, int i, int i2) {
        InputStream openInputStream;
        byte[] bArr = null;
        if (contentResolver == null || uri == null || i < 1 || i2 < 1) {
            return null;
        }
        try {
            openInputStream = contentResolver.openInputStream(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (openInputStream == null) {
            return null;
        }
        byte[] bArr2 = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = openInputStream.read(bArr2);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
        bArr = byteArrayOutputStream.toByteArray();
        return decodeBitmap(bArr, i, i2);
    }

    public static Bitmap decodeBitmap(Context context, int i, int i2, int i3) {
        if (context != null && i != 0 && i2 > 0 && i3 > 0) {
            Resources resources = context.getResources();
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(resources, i, options);
                int i4 = options.outWidth;
                int i5 = options.outHeight;
                int i6 = 1;
                while (true) {
                    if (i4 / 2 < i2 && i5 / 2 < i3) {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = i6;
                        options2.inPurgeable = true;
                        options2.inPreferredConfig = Bitmap.Config.RGB_565;
                        return BitmapFactory.decodeResource(resources, i, options2);
                    }
                    i4 /= 2;
                    i5 /= 2;
                    i6 *= 2;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        if (r7 == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap compressBitmap(Bitmap bitmap, long j) {
        int sqrt;
        if (bitmap == null) {
            return null;
        }
        if (j <= 0) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Logger.d(TAG, "bitmap size is " + (bitmap.getRowBytes() * bitmap.getHeight()));
        double round = Math.round(r1 / j);
        if (round >= 2.0d && round < 4.0d) {
            config = Bitmap.Config.RGB_565;
        } else {
            sqrt = (int) Math.sqrt(round);
        }
        sqrt = 1;
        if (sqrt == 1 && config == Bitmap.Config.ARGB_8888) {
            return bitmap;
        }
        Logger.d(TAG, "compress sample size is " + sqrt);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sqrt;
        options.inPurgeable = true;
        options.inPreferredConfig = config;
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap compressBitmap(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0038: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:43:0x0038 */
    public static String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream2);
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        encodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 0);
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

    public static boolean saveBitmap2cache(Bitmap bitmap, String str, String str2) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file + "/" + str2);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            try {
                fileOutputStream2.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                fileOutputStream2.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            throw th;
        }
    }
}
