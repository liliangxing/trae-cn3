package com.ss.ttm.utils;

import android.content.Context;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

@Deprecated
/* loaded from: classes7.dex */
public final class AVCrashUtil {
    public static void deleteCrashFile(Context context, String path) {
        if (path == null) {
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean existsCrashFile(Context context, String path) {
        if (context == null && path == null) {
            return false;
        }
        return new File(path).exists();
    }

    public static String getBase64SampleCrash(String simpleCrash) {
        return Base64.encodeToString(simpleCrash.getBytes(), 0);
    }

    public static String getCrashFileContext(Context context, String path, StringBuilder builder) {
        FileInputStream fileInputStream;
        if (context == null || path == null) {
            builder.append("context or path is null.\r\n");
            return null;
        }
        File file = new File(path);
        if (!file.exists()) {
            builder.append("file not exist.path:").append(path).append("\r\n");
            return null;
        }
        if (file.length() == 0) {
            builder.append("file size is zore.").append("\r\n");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        }
        try {
            compress(fileInputStream, byteArrayOutputStream);
            fileInputStream.close();
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            byteArrayOutputStream.close();
            return encodeToString;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
            builder.append("gzip file is error.error:").append(e.getMessage());
            return null;
        }
    }

    public static void compress(InputStream is, OutputStream os) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(os);
        byte[] bArr = new byte[10240];
        while (true) {
            int read = is.read(bArr, 0, 10240);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0088 A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #10 {IOException -> 0x0084, blocks: (B:67:0x0080, B:60:0x0088), top: B:66:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean copyFile(String destFileName, String srcFileName, boolean overlay, boolean deleteSrc) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(srcFileName);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(destFileName);
        if (file2.exists()) {
            if (overlay) {
                new File(destFileName).delete();
            }
        } else if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    fileInputStream.close();
                    if (deleteSrc) {
                        file.delete();
                    }
                    try {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (FileNotFoundException unused) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                th = th;
                if (fileOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            fileInputStream = null;
        } catch (IOException unused6) {
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            fileOutputStream = null;
        }
    }

    public static final boolean moveFile(String destFileName, String srcFileName, boolean overlay) {
        return copyFile(destFileName, srcFileName, overlay, true);
    }
}
