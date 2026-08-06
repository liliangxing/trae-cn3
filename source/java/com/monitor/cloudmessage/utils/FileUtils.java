package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm6.util.IOUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes7.dex */
public class FileUtils {
    static final int BUFFER = 8192;
    private static final String TAG = "FileUtils";

    public static File getCloudMsgDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir("cloudMessage");
        if (externalFilesDir == null) {
            externalFilesDir = new File(context.getFilesDir(), "cloudMessage");
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdir();
        }
        return externalFilesDir;
    }

    public static void ensureDirectoryClean(File file) {
        if (file.exists()) {
            removeDir(file.getAbsolutePath());
        }
        file.mkdirs();
    }

    public static String getFormatSize(double d) {
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            return d + "Byte(s)";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return new BigDecimal(Double.toString(d2)).setScale(2, 4).toPlainString() + "KB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(2, 4).toPlainString() + "MB";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d5).setScale(2, 4).toPlainString() + "TB";
    }

    public static boolean removeDir(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        boolean z = true;
        for (int i = 0; i < length; i++) {
            z = !listFiles[i].isDirectory() ? !(z && listFiles[i].delete()) : !(z && removeDir(listFiles[i].getAbsolutePath()));
        }
        return z && file.delete();
    }

    public static void deleteFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file.isDirectory()) {
                    deleteFile(file2);
                }
            }
        }
        file.delete();
    }

    public static boolean copyFile(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean saveInputStream = saveInputStream(fileInputStream, str2, str3);
            try {
                fileInputStream.close();
            } catch (Exception unused) {
            }
            return saveInputStream;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused2) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    public static boolean copyFile(String str, String str2) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            boolean saveInputStream = saveInputStream(fileInputStream, str2);
            try {
                fileInputStream.close();
            } catch (Exception unused) {
            }
            return saveInputStream;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused2) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    public static boolean saveInputStream(InputStream inputStream, String str, String str2) {
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream == null) {
                        return true;
                    }
                    try {
                        inputStream.close();
                        return true;
                    } catch (Exception unused2) {
                        return true;
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Log.d(TAG, "save inputstream error: " + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception unused6) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean saveInputStream(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();
            if (inputStream == null) {
                return true;
            }
            try {
                inputStream.close();
                return true;
            } catch (Exception unused) {
                return true;
            }
        } catch (Exception e2) {
            fileOutputStream2 = fileOutputStream;
            e = e2;
            Log.d(TAG, "save inputstream error: " + e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused2) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
            }
            return false;
        } catch (Throwable th2) {
            fileOutputStream2 = fileOutputStream;
            th = th2;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused4) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    throw th;
                } catch (Exception unused5) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public static void zip(String str, String str2) throws Exception {
        zip(str2, new File(str));
    }

    private static void zip(String str, File file) throws Exception {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                zip(zipOutputStream2, file, "");
                IOUtils.closeQuietly(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                IOUtils.closeQuietly(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void zip(ZipOutputStream zipOutputStream, File file, String str) throws Exception {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
            String str2 = str.length() == 0 ? "" : str + "/";
            for (int i = 0; i < listFiles.length; i++) {
                zip(zipOutputStream, listFiles[i], str2 + listFiles[i].getName());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            while (true) {
                try {
                    int read = fileInputStream2.read();
                    if (read != -1) {
                        zipOutputStream.write(read);
                    } else {
                        IOUtils.closeQuietly(fileInputStream2);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    IOUtils.closeQuietly(fileInputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static void compress(String str, String... strArr) {
        FileOutputStream fileOutputStream;
        Closeable closeable;
        Exception e;
        ?? file = new File(str);
        try {
            try {
                fileOutputStream = new FileOutputStream((File) file);
                try {
                    CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());
                    try {
                        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
                        try {
                            for (String str2 : strArr) {
                                File file2 = new File(str2);
                                if (!file2.exists()) {
                                    throw new RuntimeException(str2 + "不存在！");
                                }
                                compress(file2, zipOutputStream, "");
                            }
                            IOUtils.closeQuietly(zipOutputStream);
                            IOUtils.closeQuietly(checkedOutputStream);
                            IOUtils.closeQuietly(fileOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            throw new RuntimeException(e);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e = e;
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                        file = checkedOutputStream;
                        th = th;
                        IOUtils.closeQuietly(closeable);
                        IOUtils.closeQuietly(file);
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                    file = 0;
                    closeable = null;
                }
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly(closeable);
                IOUtils.closeQuietly(file);
                IOUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th4) {
            th = th4;
            file = 0;
            fileOutputStream = null;
            closeable = null;
        }
    }

    private static void compress(File file, ZipOutputStream zipOutputStream, String str) {
        if (file.isDirectory()) {
            compressDirectory(file, zipOutputStream, str + file.getName() + File.separator);
            return;
        }
        if (ApmContext.isDebugMode()) {
            Logger.d("cloudmessage", "压缩：" + str + file.getName());
        }
        compressFile(file, zipOutputStream, str);
    }

    private static void compressDirectory(File file, ZipOutputStream zipOutputStream, String str) {
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                compress(file2, zipOutputStream, str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedInputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    private static void compressFile(File file, ZipOutputStream zipOutputStream, String str) {
        FileInputStream fileInputStream;
        ?? r2;
        if (!file.exists()) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            r2 = 0;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            r2 = new BufferedInputStream(fileInputStream);
        } catch (Exception e2) {
            e = e2;
            r2 = 0;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(fileInputStream2);
            IOUtils.closeQuietly(fileInputStream);
            throw th;
        }
        try {
            zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
            byte[] bArr = new byte[8192];
            while (true) {
                int read = r2.read(bArr, 0, 8192);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    IOUtils.closeQuietly(r2);
                    IOUtils.closeQuietly(fileInputStream);
                    return;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            r2 = r2;
            try {
                throw new RuntimeException(e);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                fileInputStream2 = r2;
                IOUtils.closeQuietly(fileInputStream2);
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = r2;
            IOUtils.closeQuietly(fileInputStream2);
            IOUtils.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static File joinFile(String str, String str2) {
        Context context = CloudMessageManager.getInstance().getContext();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1481211727:
                if (str.equals("data_package")) {
                    c = 0;
                    break;
                }
                break;
            case -1427366653:
                if (str.equals("sd_package_file")) {
                    c = 1;
                    break;
                }
                break;
            case -1301710629:
                if (str.equals("sd_package_cache")) {
                    c = 2;
                    break;
                }
                break;
            case -540898700:
                if (str.equals("data_package_cache")) {
                    c = 3;
                    break;
                }
                break;
            case 70125656:
                if (str.equals("sd_package")) {
                    c = 4;
                    break;
                }
                break;
            case 1506669642:
                if (str.equals("data_package_file")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new File(context.getFilesDir().getParentFile(), str2);
            case 1:
                return new File(context.getExternalFilesDir(null), str2);
            case 2:
                return new File(context.getExternalCacheDir(), str2);
            case 3:
                return new File(context.getCacheDir(), str2);
            case 4:
                return new File(context.getExternalFilesDir(null).getParentFile(), str2);
            case 5:
                return new File(context.getFilesDir(), str2);
            default:
                return null;
        }
    }

    public static String getFullPath(String str, String str2) {
        Context context = CloudMessageManager.getInstance().getContext();
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1481211727:
                if (str.equals("data_package")) {
                    c = 0;
                    break;
                }
                break;
            case -1427366653:
                if (str.equals("sd_package_file")) {
                    c = 1;
                    break;
                }
                break;
            case -1301710629:
                if (str.equals("sd_package_cache")) {
                    c = 2;
                    break;
                }
                break;
            case -540898700:
                if (str.equals("data_package_cache")) {
                    c = 3;
                    break;
                }
                break;
            case 70125656:
                if (str.equals("sd_package")) {
                    c = 4;
                    break;
                }
                break;
            case 1506669642:
                if (str.equals("data_package_file")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new File(context.getFilesDir().getParentFile(), str2).getAbsolutePath();
            case 1:
                return new File(context.getExternalFilesDir(null), str2).getAbsolutePath();
            case 2:
                return new File(context.getExternalCacheDir(), str2).getAbsolutePath();
            case 3:
                return new File(context.getCacheDir(), str2).getAbsolutePath();
            case 4:
                return new File(context.getExternalFilesDir(null).getParentFile(), str2).getAbsolutePath();
            case 5:
                return new File(context.getFilesDir(), str2).getAbsolutePath();
            default:
                return null;
        }
    }
}
