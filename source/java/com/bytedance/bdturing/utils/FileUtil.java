package com.bytedance.bdturing.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.LogUtil;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    public static boolean deleteFile(String str) {
        return deleteFile(new File(str));
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        return file.delete();
    }

    public static boolean decompress(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogUtil.e(TAG, "decompress failed src ,dest path can not be null");
            return false;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            return false;
        }
        try {
            ZipFile zipFile = new ZipFile(file2);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (nextElement.getName() == null || !nextElement.getName().contains(DownloadConstants.VULNERABILITY_PATH + File.separator)) {
                    if (!nextElement.isDirectory()) {
                        File file3 = new File(str2, nextElement.getName());
                        File parentFile = file3.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (file3.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                            copyFile(zipFile.getInputStream(nextElement), file3);
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String fileMd5Hex(String str) {
        return TextUtils.isEmpty(str) ? "" : fileMd5Hex(new File(str));
    }

    public static String fileMd5Hex(File file) {
        if (file == null || !file.exists() || !file.isFile()) {
            return "";
        }
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Exception e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                String byteArrayToHex = byteArrayToHex(messageDigest.digest());
                try {
                    bufferedInputStream2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return byteArrayToHex;
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String byteArrayToHex(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static File copyFile(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str) || inputStream == null) {
            return null;
        }
        return copyFile(inputStream, new File(str));
    }

    private static File copyFile(InputStream inputStream, File file) {
        if (inputStream == null || file == null || file.exists()) {
            return file;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            try {
                byte[] bArr = new byte[8192];
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        inputStream.close();
                        fileOutputStream.close();
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            inputStream.close();
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                }
                inputStream.close();
                fileOutputStream2.close();
            } catch (Exception e4) {
                e = e4;
            }
            return file;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Pair<Boolean, String> flatCopyFolder(File file, File file2) {
        if (!file.exists() || !file.isDirectory()) {
            return new Pair<>(false, "sourceDir not exists");
        }
        if (!file2.exists() && !file2.mkdirs()) {
            return new Pair<>(false, "make target dir fail");
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return new Pair<>(true, "sourceDir is Empty");
        }
        for (File file3 : listFiles) {
            File file4 = new File(file2, file3.getName());
            if (file3.isDirectory()) {
                if (!((Boolean) flatCopyFolder(file3, file2).first).booleanValue()) {
                    return new Pair<>(false, "copy dir fail");
                }
            } else if (!copyFileWithStream(file3, file4)) {
                return new Pair<>(false, "copy file fail");
            }
        }
        return new Pair<>(true, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006c A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #4 {Exception -> 0x0068, blocks: (B:47:0x0064, B:40:0x006c), top: B:46:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean copyFileWithStream(File file, File file2) {
        FileOutputStream fileOutputStream;
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read > 0) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileInputStream2.close();
                                fileOutputStream.close();
                                fileInputStream2.close();
                                fileOutputStream.close();
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream == null) {
                                return true;
                            }
                            fileOutputStream.close();
                            return true;
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return true;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }
}
