package bytedance.io;

import android.text.TextUtils;
import bytedance.io.exception.IllegalPathException;
import bytedance.util.DtfsUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: classes2.dex */
public class BdCompressFileSystem {
    public static BdFile compress(String str, String str2, List<String> list) throws IOException, IllegalPathException {
        ZipOutputStream zipOutputStream = null;
        if (list.isEmpty()) {
            return null;
        }
        BdFile bdFile = new BdFile(str + File.separator + str2);
        if (bdFile.getParentFile() != null) {
            bdFile.getParentFile().mkdirs();
        }
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new BdFileOutputStream(bdFile)));
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    BdFile bdFile2 = new BdFile(it.next());
                    if (bdFile2.exists()) {
                        if (bdFile2.isDirectory()) {
                            recursionZip(zipOutputStream2, bdFile2, bdFile2.getName() + File.separator);
                        } else {
                            recursionZip(zipOutputStream2, bdFile2, "");
                        }
                    }
                }
                zipOutputStream2.flush();
                try {
                    zipOutputStream2.closeEntry();
                    zipOutputStream2.close();
                } catch (IOException unused) {
                }
                return new BdFile(bdFile.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.closeEntry();
                        zipOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static BdFile decompress(BdFile bdFile, BdFile bdFile2) throws IOException, IllegalPathException {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                bdFile2.mkdirs();
                zipFile = new ZipFile(bdFile);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[2048];
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            BufferedInputStream bufferedInputStream = null;
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                BdFile bdFile3 = new BdFile(bdFile2.getPath() + File.separator + nextElement.getName());
                if (nextElement.isDirectory()) {
                    bdFile3.mkdirs();
                } else {
                    File parentFile = bdFile3.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    } else {
                        bdFile3.createNewFile();
                    }
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(bdFile3), 2048);
                            while (true) {
                                try {
                                    int read = bufferedInputStream2.read(bArr, 0, 2048);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream2.write(bArr, 0, read);
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    bufferedInputStream = bufferedInputStream2;
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    throw th;
                                }
                            }
                            bufferedOutputStream2.flush();
                            bufferedOutputStream2.close();
                            bufferedInputStream2.close();
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
            zipFile.close();
            return new BdFile(bdFile2.getPath());
        } catch (Exception e2) {
            e = e2;
            DtfsUtils.uploadEvent(400);
            if (e instanceof IOException) {
                deleteDir(bdFile2);
                throw e;
            }
            deleteDir(bdFile2);
            throw new IOException("Error when decompressing zip file.", e);
        } catch (Throwable th5) {
            th = th5;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                zipFile2.close();
            }
            throw th;
        }
    }

    public static void decompressFolder(InputStream inputStream, BdFile bdFile) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (!TextUtils.isEmpty(name) && !name.contains("../")) {
                    if (nextEntry.isDirectory()) {
                        new BdFile(bdFile.getAbsolutePath() + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                    } else {
                        BdFile bdFile2 = new BdFile(bdFile.getAbsolutePath() + File.separator + name);
                        if (!bdFile2.getParentFile().exists()) {
                            bdFile2.getParentFile().mkdirs();
                        }
                        bdFile2.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(bdFile2);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        fileOutputStream.close();
                    }
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }

    private static void recursionZip(ZipOutputStream zipOutputStream, BdFile bdFile, String str) throws IOException {
        if (bdFile.isDirectory()) {
            for (BdFile bdFile2 : bdFile.listFiles()) {
                if (bdFile2 != null) {
                    if (bdFile2.isDirectory()) {
                        recursionZip(zipOutputStream, bdFile2, bdFile.getName() + File.separator + bdFile2.getName() + File.separator);
                    } else {
                        recursionZip(zipOutputStream, bdFile2, str);
                    }
                }
            }
            return;
        }
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(bdFile));
        zipOutputStream.putNextEntry(new ZipEntry(str + bdFile.getName()));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                return;
            }
        }
    }

    private static boolean deleteDir(BdFile bdFile) {
        if (bdFile == null) {
            return false;
        }
        if (!bdFile.exists()) {
            return true;
        }
        if (!bdFile.isDirectory()) {
            return false;
        }
        BdFile[] listFiles = bdFile.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (BdFile bdFile2 : listFiles) {
                if (bdFile2.isFile()) {
                    if (!bdFile2.delete()) {
                        return false;
                    }
                } else if (bdFile2.isDirectory() && !deleteDir(bdFile2)) {
                    return false;
                }
            }
        }
        return bdFile.delete();
    }
}
