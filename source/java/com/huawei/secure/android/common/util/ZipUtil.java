package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCacheKt;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

@Deprecated
/* loaded from: classes6.dex */
public class ZipUtil {
    private static final String a = "ZipUtil";
    private static final int b = 104857600;
    private static final int c = 100;
    private static final int d = 6000;
    private static final int e = 4096;
    private static final String[] f = {"\\..", "/..", "..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    private static void a(boolean z, File file) {
        if (z && file.exists() && file.isFile()) {
            f(file);
        }
    }

    private static ZipFile b(boolean z, File file) throws IOException {
        if (!z) {
            return new ZipFile(file);
        }
        LogsUtil.i(a, "not a utf8 zip file, use gbk open zip file : " + file);
        return new ZipFile(file, Charset.forName("GBK"));
    }

    private static boolean c(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!b(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(str);
    }

    private static String e(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(lastIndexOf + 1);
    }

    private static String f(String str) {
        return str.replaceAll("\\\\", "/");
    }

    private static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(a, "isContainInvalidStr: name is null");
            return false;
        }
        for (String str2 : f) {
            if (str.toUpperCase(Locale.ROOT).contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static String h(String str) {
        return (!str.endsWith(File.separator) || str.length() <= File.separator.length()) ? str : str.substring(0, str.length() - File.separator.length());
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, ArtifactDiskCacheKt.ARTIFACT_CACHE_MAX_BYTES, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, ArtifactDiskCacheKt.ARTIFACT_CACHE_MAX_BYTES, 100, z);
    }

    public static List<File> unZipWithFilter(String str, String str2, boolean z, FilenameFilter filenameFilter) throws SecurityCommonException {
        return unZipWithFilter(str, str2, ArtifactDiskCacheKt.ARTIFACT_CACHE_MAX_BYTES, 100, z, filenameFilter, 6000);
    }

    private static void d(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(a, "delete file error");
    }

    private static void f(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            d(file);
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    f(file2);
                }
                d(file);
                return;
            }
            d(file);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unZip(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        ZipInputStream zipInputStream;
        boolean z2 = false;
        if (!a(str, str2, j, i, (FilenameFilter) null, i)) {
            return false;
        }
        String h = h(str2);
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream2));
                long j2 = 0;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            z2 = true;
                            break;
                        }
                        String replaceAll = nextEntry.getName().replaceAll("\\\\", "/");
                        if (!a(replaceAll)) {
                            break;
                        }
                        File file = new File(h, replaceAll);
                        if (z || !file.exists() || !file.isFile()) {
                            a(z, file);
                            if (!a(nextEntry, file, arrayList)) {
                                a(file);
                                j2 = a(file, zipInputStream, j2, j, arrayList);
                                zipInputStream.closeEntry();
                                if (j2 < 0) {
                                    break;
                                }
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            LogsUtil.e(a, "Unzip IOException : " + e.getMessage());
                            a(fileInputStream, zipInputStream);
                            if (!z2) {
                            }
                            return z2;
                        } catch (Throwable th) {
                            th = th;
                            a(fileInputStream, zipInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream, zipInputStream);
                        throw th;
                    }
                }
                a(fileInputStream2, zipInputStream);
            } catch (IOException e3) {
                e = e3;
                zipInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                zipInputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            zipInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipInputStream = null;
        }
        if (!z2) {
            a(arrayList);
        }
        return z2;
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        return unZipWithFilter(str, str2, j, i, z, null, i);
    }

    public static List<File> unZipWithFilter(String str, String str2, long j, int i, boolean z, FilenameFilter filenameFilter, int i2) throws SecurityCommonException {
        if (!a(str, str2, j, i, filenameFilter, i2)) {
            return null;
        }
        if (str2.endsWith(File.separator) && str2.length() > File.separator.length()) {
            str2 = str2.substring(0, str2.length() - File.separator.length());
        }
        File d2 = d(str);
        File d3 = d(str2);
        if (d2 == null || d3 == null) {
            return null;
        }
        return a(d2, d3, j, z, false, filenameFilter);
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return;
        }
        e(parentFile);
    }

    private static void b(String str) {
        if (TextUtils.isEmpty(str) || !g(str)) {
            return;
        }
        Log.e(a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static boolean a(ZipEntry zipEntry, File file, List<File> list) {
        if (!zipEntry.isDirectory()) {
            return false;
        }
        e(file);
        list.add(file);
        return true;
    }

    private static void e(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(a, "mkdirs error , files exists or IOException.");
    }

    private static boolean a(String str) {
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFKC);
        if (!g(normalize)) {
            return true;
        }
        Log.e(a, "zipPath is a invalid path: " + e(normalize));
        return false;
    }

    private static boolean b(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static File c(String str) {
        b(str);
        return new File(str);
    }

    private static long a(File file, ZipInputStream zipInputStream, long j, long j2, List<File> list) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        List<File> list2;
        byte[] bArr = new byte[4096];
        long j3 = -1;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                long j4 = j;
                while (true) {
                    try {
                        int read = zipInputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            list2 = list;
                            break;
                        }
                        j4 += read;
                        if (j4 > j2) {
                            Log.e(a, "unzip  over than top size");
                            list2 = list;
                            j4 = -1;
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            LogsUtil.e(a, "Unzip IOException : " + e.getMessage());
                            fileOutputStream = fileOutputStream2;
                            IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                            IOUtil.closeSecure((OutputStream) fileOutputStream);
                            return j3;
                        } catch (Throwable th) {
                            th = th;
                            IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                            IOUtil.closeSecure((OutputStream) fileOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                        IOUtil.closeSecure((OutputStream) fileOutputStream2);
                        throw th;
                    }
                }
                list2.add(file);
                bufferedOutputStream.flush();
                j3 = j4;
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
        return j3;
    }

    private static String a(ZipEntry zipEntry) {
        return Normalizer.normalize(zipEntry.getName(), Normalizer.Form.NFKC);
    }

    private static int a(ZipEntry zipEntry, List<File> list, File file, boolean z, FilenameFilter filenameFilter) {
        if (TextUtils.isEmpty(zipEntry.getName())) {
            return 1;
        }
        String a2 = a(zipEntry);
        if (g(a2)) {
            Log.e(a, "zipPath is a invalid path: " + e(a2));
            return -1;
        }
        String f2 = f(a2);
        if (filenameFilter != null && !filenameFilter.accept(file, f2)) {
            return 1;
        }
        File file2 = new File(file, f2);
        if (!z && file2.exists() && file2.isFile()) {
            return 1;
        }
        if (z && file2.exists() && file2.isFile()) {
            f(file2);
        }
        list.add(file2);
        return 0;
    }

    private static long a(ZipEntry zipEntry, File file, long j, long j2, ZipFile zipFile) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        File file2 = new File(file, f(a(zipEntry)));
        if (zipEntry.isDirectory()) {
            if (!b(file2)) {
                return 1L;
            }
        } else {
            if (!c(file2)) {
                return 1L;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    } catch (Throwable th) {
                        bufferedOutputStream = null;
                        fileOutputStream2 = fileOutputStream;
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                        IOUtil.closeSecure((OutputStream) fileOutputStream);
                        break;
                    }
                    j += read;
                    if (j > j2) {
                        Log.e(a, "unzipFileNew: over than top size");
                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                        IOUtil.closeSecure((OutputStream) fileOutputStream);
                        return -1L;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th4) {
                fileOutputStream2 = fileOutputStream;
                th = th4;
                IOUtil.closeSecure((InputStream) bufferedInputStream);
                IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                IOUtil.closeSecure((OutputStream) fileOutputStream2);
                throw th;
            }
        }
        return j;
    }

    private static void a(boolean z, List<File> list) {
        if (z) {
            return;
        }
        a(list);
        list.clear();
    }

    private static List<File> a(File file, File file2, long j, boolean z, boolean z2, FilenameFilter filenameFilter) {
        ZipFile b2;
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        ZipFile zipFile = null;
        try {
            b2 = b(z2, file);
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th) {
            th = th;
            z3 = true;
        }
        try {
            Enumeration<? extends ZipEntry> entries = b2.entries();
            long j2 = 0;
            while (true) {
                if (!entries.hasMoreElements()) {
                    z3 = true;
                    break;
                }
                try {
                    ZipEntry nextElement = entries.nextElement();
                    int a2 = a(nextElement, arrayList, file2, z, filenameFilter);
                    if (a2 == -1) {
                        break;
                    }
                    if (a2 != 1) {
                        j2 = a(nextElement, file2, j2, j, b2);
                        if (j2 == 1) {
                            IOUtil.closeSecure(b2);
                            a(false, (List<File>) arrayList);
                            return null;
                        }
                        if (j2 == -1) {
                            break;
                        }
                    }
                } catch (IllegalArgumentException e3) {
                    LogsUtil.i(a, "not a utf8 zip file, IllegalArgumentException : " + e3.getMessage());
                    List<File> a3 = a(file, file2, j, z, true, filenameFilter);
                    IOUtil.closeSecure(b2);
                    a(true, (List<File>) arrayList);
                    return a3;
                }
            }
            IOUtil.closeSecure(b2);
            a(z3, arrayList);
        } catch (IOException e4) {
            e = e4;
            zipFile = b2;
            try {
                Log.e(a, "unzip new IOException : " + e.getMessage());
                IOUtil.closeSecure(zipFile);
                a(false, (List<File>) arrayList);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                IOUtil.closeSecure(zipFile);
                a(z3, arrayList);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            z3 = true;
            zipFile = b2;
            IOUtil.closeSecure(zipFile);
            a(z3, arrayList);
            throw th;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007d, code lost:
    
        if (r2 > r22) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(String str, File file, long j, int i, boolean z, FilenameFilter filenameFilter, int i2) {
        boolean z2;
        ZipFile zipFile;
        ZipFile zipFile2;
        ZipEntry nextElement;
        ZipFile zipFile3 = null;
        try {
            try {
                if (!z) {
                    zipFile = new ZipFile(str);
                } else {
                    LogsUtil.i(a, "not a utf8 zip file, use gbk open zip file : " + str);
                    zipFile = new ZipFile(str, Charset.forName("GBK"));
                }
                zipFile2 = zipFile;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile2.entries();
            long j2 = 0;
            int i3 = 0;
            int i4 = 0;
            do {
                boolean z3 = true;
                if (!entries.hasMoreElements()) {
                    z2 = true;
                    break;
                }
                try {
                    nextElement = entries.nextElement();
                    long size = nextElement.getSize();
                    String name = nextElement.getName();
                    if (filenameFilter != null) {
                        if (filenameFilter.accept(file, name)) {
                        }
                        i3++;
                        if (!g(name) && i3 < i2 && i4 < i) {
                            z3 = false;
                        }
                        break;
                    }
                    j2 += size;
                    i4++;
                    i3++;
                    if (!g(name)) {
                        z3 = false;
                    }
                    break;
                    break;
                } catch (IllegalArgumentException e3) {
                    LogsUtil.i(a, "not a utf8 zip file, IllegalArgumentException : " + e3.getMessage());
                    z2 = a(str, file, j, i, true, filenameFilter, i2);
                }
            } while (nextElement.getSize() != -1);
            LogsUtil.e(a, "File name is invalid or too many files or too big");
            z2 = false;
            try {
                zipFile2.close();
                return z2;
            } catch (IOException unused) {
                LogsUtil.e(a, "close zipFile IOException ");
                return z2;
            }
        } catch (IOException e4) {
            e = e4;
            zipFile3 = zipFile2;
            LogsUtil.e(a, "not a valid zip file, IOException : " + e.getMessage());
            if (zipFile3 != null) {
                try {
                    zipFile3.close();
                } catch (IOException unused2) {
                    z2 = false;
                    LogsUtil.e(a, "close zipFile IOException ");
                    return z2;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipFile3 = zipFile2;
            if (zipFile3 != null) {
                try {
                    zipFile3.close();
                } catch (IOException unused3) {
                    LogsUtil.e(a, "close zipFile IOException ");
                }
            }
            throw th;
        }
    }

    private static boolean a(String str, String str2, long j, int i, FilenameFilter filenameFilter, int i2) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !g(str)) {
            if (!TextUtils.isEmpty(str2) && !g(str2)) {
                if (a(str, new File(str2), j, i, false, filenameFilter, i2)) {
                    return true;
                }
                LogsUtil.e(a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, ZipInputStream zipInputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
    }
}
