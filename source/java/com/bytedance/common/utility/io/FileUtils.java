package com.bytedance.common.utility.io;

import android.content.Context;
import com.bytedance.android.standard.tools.file.FileUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Set;

@Deprecated
/* loaded from: classes3.dex */
public final class FileUtils {
    private static final byte[] GIF87A = {71, 73, 70, 56, 55, 97};
    private static final byte[] GIF89A = {71, 73, 70, 56, 57, 97};
    private static final byte[] JPEG = {-1, -40, -1};
    private static final byte[] PNG = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final String TAG = "FileUtils";

    /* loaded from: classes3.dex */
    public enum ImageType {
        UNKNOWN,
        JPG,
        PNG,
        GIF
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.common.utility.io.FileUtils$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType;

        static {
            int[] iArr = new int[FileUtils.ImageType.values().length];
            $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType = iArr;
            try {
                iArr[FileUtils.ImageType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType[FileUtils.ImageType.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType[FileUtils.ImageType.PNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType[FileUtils.ImageType.GIF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static ImageType getOldImageType(FileUtils.ImageType imageType) {
        ImageType imageType2 = ImageType.UNKNOWN;
        int i = AnonymousClass1.$SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType[imageType.ordinal()];
        if (i == 1) {
            return ImageType.UNKNOWN;
        }
        if (i == 2) {
            return ImageType.JPG;
        }
        if (i != 3) {
            return i != 4 ? imageType2 : ImageType.GIF;
        }
        return ImageType.PNG;
    }

    private FileUtils() {
    }

    public static InputStream getInputStream(String str) {
        return com.bytedance.android.standard.tools.file.FileUtils.getInputStream(str);
    }

    public static byte[] getByteArray(String str) {
        return com.bytedance.android.standard.tools.file.FileUtils.getByteArray(str);
    }

    public static boolean copyFile(String str, String str2, String str3) {
        return com.bytedance.android.standard.tools.file.FileUtils.copyFile(str, str2, str3);
    }

    public static boolean saveInputStream(InputStream inputStream, String str, String str2) {
        return com.bytedance.android.standard.tools.file.FileUtils.saveInputStream(inputStream, str, str2);
    }

    public static ImageType getImageType(String str) {
        return getOldImageType(com.bytedance.android.standard.tools.file.FileUtils.getImageType(str));
    }

    public static ImageType getImageType(File file) {
        return getOldImageType(com.bytedance.android.standard.tools.file.FileUtils.getImageType(file));
    }

    public static boolean isGif(File file) {
        return com.bytedance.android.standard.tools.file.FileUtils.isGif(file);
    }

    public static boolean exists(String str) {
        return com.bytedance.android.standard.tools.file.FileUtils.exists(str);
    }

    private static boolean checkSignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void chmod(String str, int i) {
        com.bytedance.android.standard.tools.file.FileUtils.chmod(str, i);
    }

    public static String getFileNameWithoutExtension(String str) {
        return com.bytedance.android.standard.tools.file.FileUtils.getFileNameWithoutExtension(str);
    }

    public static String getExtension(String str) {
        return com.bytedance.android.standard.tools.file.FileUtils.getExtension(str);
    }

    public static void clearDir(String str) throws Exception {
        com.bytedance.android.standard.tools.file.FileUtils.clearDir(str);
    }

    public static void removeDir(String str) throws Exception {
        com.bytedance.android.standard.tools.file.FileUtils.removeDir(str);
    }

    public static void clearDir(String str, Set<String> set) throws Exception {
        com.bytedance.android.standard.tools.file.FileUtils.clearDir(str, set);
    }

    public static void removeDir(String str, Set<String> set) throws Exception {
        com.bytedance.android.standard.tools.file.FileUtils.removeDir(str, set);
    }

    public static long getDirectorySize(File file, boolean z) {
        return com.bytedance.android.standard.tools.file.FileUtils.getDirectorySize(file, z);
    }

    public static String getCacheDirPath(Context context) throws NullPointerException {
        return com.bytedance.android.standard.tools.file.FileUtils.getCacheDirPath(context);
    }

    public static String getFilesDirPath(Context context) throws NullPointerException {
        return com.bytedance.android.standard.tools.file.FileUtils.getFilesDirPath(context);
    }

    public static boolean isExternalStorageWritable() {
        return com.bytedance.android.standard.tools.file.FileUtils.isExternalStorageWritable();
    }

    public static boolean isExternalStorageReadable() {
        return com.bytedance.android.standard.tools.file.FileUtils.isExternalStorageReadable();
    }
}
