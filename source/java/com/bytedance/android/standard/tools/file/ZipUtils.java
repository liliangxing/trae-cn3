package com.bytedance.android.standard.tools.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: classes3.dex */
public final class ZipUtils {
    private static final String TEMP_SUFFIX = ".temp";

    private ZipUtils() {
    }

    public static void unzipRenameToFile(String str, String str2) throws IOException {
        unzipRenameToFile(new File(str), new File(str2));
    }

    public static void unzipRenameToFile(File file, File file2) throws IOException {
        if (!file.isDirectory() || file2.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            try {
                renameToOrigin(unzipTempFile(file2.getAbsolutePath(), zipInputStream));
            } finally {
                zipInputStream.close();
                fileInputStream.close();
            }
        }
    }

    private static List<File> unzipTempFile(String str, ZipInputStream zipInputStream) throws IOException {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        if (!file.isDirectory()) {
            return null;
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        ArrayList arrayList = new ArrayList();
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (!name.contains("../")) {
                if (name.endsWith("/")) {
                    File file2 = new File(str + name);
                    file2.mkdir();
                    if (!file2.isDirectory()) {
                        return null;
                    }
                } else {
                    File file3 = new File(str + name + TEMP_SUFFIX);
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file3.createNewFile();
                    if (!file3.isFile()) {
                        return null;
                    }
                    arrayList.add(file3);
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    } finally {
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                    }
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
        }
        return arrayList;
    }

    private static void renameToOrigin(List<File> list) {
        if (list == null) {
            return;
        }
        for (File file : list) {
            if (file != null) {
                String absolutePath = file.getAbsolutePath();
                File file2 = new File(absolutePath.substring(0, absolutePath.indexOf(TEMP_SUFFIX)));
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
        }
    }

    public static void unZipFolder(String str, String str2) {
        ZipInputStream zipInputStream = null;
        try {
            try {
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(str));
                    while (true) {
                        try {
                            try {
                                ZipEntry nextEntry = zipInputStream2.getNextEntry();
                                if (nextEntry == null) {
                                    break;
                                }
                                String name = nextEntry.getName();
                                if (!name.contains("../")) {
                                    if (nextEntry.isDirectory()) {
                                        new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                                    } else {
                                        File file = new File(str2 + File.separator + name);
                                        if (!file.exists()) {
                                            file.getParentFile().mkdirs();
                                            file.createNewFile();
                                        }
                                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = zipInputStream2.read(bArr);
                                            if (read != -1) {
                                                fileOutputStream.write(bArr, 0, read);
                                                fileOutputStream.flush();
                                            } else {
                                                try {
                                                    break;
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        fileOutputStream.close();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                zipInputStream = zipInputStream2;
                                if (zipInputStream != null) {
                                    try {
                                        zipInputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            zipInputStream = zipInputStream2;
                            e.printStackTrace();
                            if (zipInputStream != null) {
                                zipInputStream.close();
                            }
                            return;
                        }
                    }
                    zipInputStream2.close();
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static void zipDirectory(File file, File file2) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
        zip(file, file, zipOutputStream);
        zipOutputStream.close();
    }

    private static void zip(File file, File file2, ZipOutputStream zipOutputStream) throws IOException {
        byte[] bArr = new byte[8192];
        for (File file3 : file.listFiles()) {
            if (file3.isDirectory()) {
                zip(file3, file2, zipOutputStream);
            } else {
                FileInputStream fileInputStream = new FileInputStream(file3);
                zipOutputStream.putNextEntry(new ZipEntry(file3.getPath().substring(file2.getPath().length() + 1)));
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (-1 == read) {
                        break;
                    } else {
                        zipOutputStream.write(bArr, 0, read);
                    }
                }
                fileInputStream.close();
            }
        }
    }

    public static void unzip(File file, File file2) throws IOException {
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.getName().contains("../")) {
                File file3 = new File(file2, nextElement.getName());
                if (nextElement.isDirectory() && !file3.exists()) {
                    file3.mkdirs();
                } else {
                    if (!file3.getParentFile().exists()) {
                        file3.getParentFile().mkdirs();
                    }
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (-1 == read) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    }
                    inputStream.close();
                    bufferedOutputStream.close();
                }
            }
        }
        zipFile.close();
    }
}
