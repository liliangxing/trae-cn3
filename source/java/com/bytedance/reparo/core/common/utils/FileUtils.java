package com.bytedance.reparo.core.common.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FileUtils {
    private static final int BUFFER_SIZE_4_KB = 4096;

    public static void ensureParentFileExist(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IllegalArgumentException("it's parent file is null. " + file.getAbsolutePath());
        }
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean isExist(File file) {
        return file != null && file.exists();
    }

    public static File write(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (file.exists()) {
            file.delete();
        }
        ensureFileExist(file);
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 4096);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            if (read != -1) {
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                bufferedOutputStream.flush();
                                closeSafely(bufferedInputStream2);
                                closeSafely(fileOutputStream);
                                closeSafely(bufferedOutputStream);
                                return file;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        closeSafely(bufferedInputStream);
                        closeSafely(fileOutputStream);
                        closeSafely(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                bufferedOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
    }

    public static void copy(File file, File file2) throws IOException {
        if (file == null || file2 == null || TextUtils.equals(file.getAbsolutePath(), file2.getAbsolutePath())) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                write(fileInputStream2, file2);
                closeSafely(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                closeSafely(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void delete(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    delete(file2);
                }
            }
            file.delete();
        }
    }

    public static void deleteChildren(File file) {
        File[] listFiles;
        if (isEmpty(file) || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            delete(file2);
        }
    }

    public static void ensureFileExist(File file) throws IOException {
        if (file.exists()) {
            return;
        }
        ensureParentFileExist(file);
        file.createNewFile();
    }

    public static void ensureDirExist(File file) {
        if (file.exists()) {
            return;
        }
        ensureParentFileExist(file);
        file.mkdirs();
    }

    public static boolean isEmpty(File file) {
        if (file == null) {
            return true;
        }
        if (file.isFile()) {
            return !isExist(file);
        }
        File[] listFiles = file.listFiles();
        return listFiles == null || listFiles.length == 0;
    }

    public static long sizeOf(File file) {
        if (isExist(file)) {
            return file.length();
        }
        return 0L;
    }

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean equals(File file, File file2) {
        if (file == file2) {
            return true;
        }
        if (file == null || file2 == null) {
            return false;
        }
        return TextUtils.equals(file.getAbsolutePath(), file2.getAbsolutePath());
    }

    public static void writeFile(File file, String str, boolean z) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                IOUtils.close(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                IOUtils.close(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String readStr(File file) {
        return new String(read(file));
    }

    public static byte[] read(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            fileInputStream.close();
                            return byteArray;
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read file " + file, e);
        }
    }

    public static List<String> readAsArray(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (!TextUtils.isEmpty(readLine)) {
                            arrayList.add(readLine);
                        }
                    } else {
                        bufferedReader.close();
                        return arrayList;
                    }
                }
            } finally {
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void copyToFile(InputStream inputStream, File file) throws IOException {
        try {
            FileOutputStream openOutputStream = openOutputStream(file);
            try {
                IOUtils.copy(inputStream, openOutputStream);
                if (openOutputStream != null) {
                    openOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        return openOutputStream(file, false);
    }

    public static FileOutputStream openOutputStream(File file, boolean z) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        }
        return new FileOutputStream(file, z);
    }
}
