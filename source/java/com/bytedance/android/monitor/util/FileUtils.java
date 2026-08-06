package com.bytedance.android.monitor.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public static boolean hasSDCardMounted() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean renameFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.renameTo(new File(str2));
    }

    public static boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isFile() && file.exists();
    }

    public static boolean isDirectoryExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isDirectory() && file.exists();
    }

    public static synchronized void writeFile(String str, String str2, boolean z) {
        FileWriter fileWriter;
        synchronized (FileUtils.class) {
            if (str == null) {
                return;
            }
            if (str2 == null) {
                return;
            }
            File file = new File(str);
            FileWriter fileWriter2 = null;
            try {
                if (!file.exists()) {
                    makeSureFileExist(file);
                }
                fileWriter = new FileWriter(file, z);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(str2);
                fileWriter.flush();
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (IOException unused2) {
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    private static void makesureParentExist(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return;
        }
        mkdirs(parentFile);
    }

    private static boolean makesureParentDirExist(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return true;
        }
        return mkdirs(parentFile);
    }

    public static boolean mkdirs(File file) {
        if (file == null) {
            return false;
        }
        return file.mkdirs();
    }

    public static void deleteFiles(File file) {
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        delete(file2);
                    } else if (file2.isDirectory()) {
                        deleteFiles(file2);
                    }
                }
            }
            delete(file);
            return;
        }
        if (file.exists() && file.isFile()) {
            delete(file);
        }
    }

    public static void clearDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        delete(file2);
                    } else if (file2.isDirectory()) {
                        deleteFiles(file2);
                    }
                }
                return;
            }
            return;
        }
        if (file.exists() && file.isFile()) {
            delete(file);
        }
    }

    public static void delete(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    public static void delete(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean createNewFile(File file) {
        makesureParentExist(file);
        if (file.exists()) {
            delete(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    public static boolean makeSureFileExist(File file) {
        if (!makesureParentDirExist(file)) {
            return false;
        }
        try {
            if (file.exists()) {
                return true;
            }
            return file.createNewFile();
        } catch (IOException e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    public static void makeSureFileExist(String str) {
        makeSureFileExist(new File(str));
    }

    public static boolean closeStream(Closeable closeable) {
        if (closeable == null) {
            return false;
        }
        try {
            closeable.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static File getExternalAppDir(Context context, String str) {
        if (context == null || !isSdcardAvailable() || !isSdcardWritable()) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(str);
        ensureDirExists(externalFilesDir);
        return externalFilesDir;
    }

    public static boolean isSdcardAvailable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static boolean isSdcardWritable() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static void ensureDirExists(File file) {
        if (file == null || file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private static boolean checkFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean saveInputStream(InputStream inputStream, String str, String str2) {
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
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
            } catch (Exception unused3) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused6) {
                    }
                }
                if (inputStream == null) {
                    throw th;
                }
                try {
                    inputStream.close();
                    throw th;
                } catch (Exception unused7) {
                    throw th;
                }
            }
        } catch (Exception unused8) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
