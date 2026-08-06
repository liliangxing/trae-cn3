package com.ss.ttm.player;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.ss.ttm.utils.AVTime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes7.dex */
public final class TTCrashUtil {
    public static void deleteCrashFile(Context context, String path) {
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

    public static final String existsCrashFilePath(Context context) {
        if (TTPlayerConfiger.getValue(18, 1) == 1) {
            String appCrashFilePath = TTPlayerConfiger.getAppCrashFilePath(context);
            if (appCrashFilePath == null || !new File(appCrashFilePath).exists()) {
                return null;
            }
            return appCrashFilePath;
        }
        String appCrashFilePath2 = TTPlayerConfiger.getAppCrashFilePath2(context);
        if (appCrashFilePath2 != null && new File(appCrashFilePath2).exists()) {
            return appCrashFilePath2;
        }
        String plugerCrashFilePath = TTPlayerConfiger.getPlugerCrashFilePath(context);
        if (plugerCrashFilePath != null && new File(plugerCrashFilePath).exists()) {
            return plugerCrashFilePath;
        }
        String externalStorageDirectoryCrashFilePath = TTPlayerConfiger.getExternalStorageDirectoryCrashFilePath(context);
        if (externalStorageDirectoryCrashFilePath == null || new File(externalStorageDirectoryCrashFilePath).exists()) {
            return externalStorageDirectoryCrashFilePath;
        }
        return null;
    }

    public static String getBase64SampleCrash(String simpleCrash) {
        return Base64.encodeToString(simpleCrash.getBytes(), 0);
    }

    public static String getCrashFileContext(Context context, String path, StringBuilder builder) {
        FileInputStream fileInputStream;
        if (context == null && path == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:59:0x0082 A[Catch: IOException -> 0x007e, TRY_LEAVE, TryCatch #12 {IOException -> 0x007e, blocks: (B:66:0x007a, B:59:0x0082), top: B:65:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (deleteSrc) {
                    file.delete();
                }
                try {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return true;
                }
            } catch (FileNotFoundException unused3) {
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
            } catch (IOException unused4) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return false;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
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

    public static final void saveException(Throwable ex, String path) {
        FileOutputStream fileOutputStream;
        if (path == null) {
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            return;
        }
        PrintStream printStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    PrintStream printStream2 = new PrintStream(fileOutputStream);
                    try {
                        printStream2.write("EXCE".getBytes());
                        ex.printStackTrace(printStream2);
                        printStream2.close();
                        fileOutputStream.close();
                    } catch (Exception unused) {
                        printStream = printStream2;
                        if (printStream != null) {
                            printStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        printStream = printStream2;
                        if (printStream != null) {
                            printStream.close();
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused3) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void saveLowMemoryInfo(int level, String path) {
        FileWriter fileWriter;
        File file = new File(path);
        if (file.exists()) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                try {
                    fileWriter = new FileWriter(file);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write("LOWM\r\nrecv low memory warring info.level:" + level);
            fileWriter.close();
        } catch (IOException e3) {
            e = e3;
            fileWriter2 = fileWriter;
            e.printStackTrace();
            if (fileWriter2 != null) {
                fileWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x004f -> B:12:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveStopInfo(String path, String info) {
        Throwable th;
        FileWriter fileWriter;
        IOException e;
        File file = new File(path);
        if (file.exists()) {
            return;
        }
        try {
            try {
                try {
                    fileWriter = new FileWriter(file);
                    try {
                        fileWriter.write("STOP recv stop info:" + info + ".time:" + AVTime.getFormatNow() + "\r\n");
                        fileWriter.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                fileWriter = null;
                e = e4;
            } catch (Throwable th3) {
                fileWriter = null;
                th = th3;
                if (fileWriter != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private static void appendTrackInfo(String path, boolean append, String info) {
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(path, append);
                try {
                    fileWriter2.write(info);
                    fileWriter2.close();
                } catch (Exception unused) {
                    fileWriter = fileWriter2;
                    fileWriter.close();
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    try {
                        fileWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void addTrackInfo(long playerId, String dir, String info) {
        appendTrackInfo(getTrackFilePath(playerId, dir), true, info);
    }

    public static void addTrackInfo(long playerId, String dir, String info, boolean replace) {
        appendTrackInfo(getTrackFilePath(playerId, dir), replace, info);
    }

    public static void addDebugTrackInfo(long playerId, String dir, String info, boolean append) {
        appendTrackInfo(getDebugTrackFilePath(playerId, dir), append, info);
    }

    private static boolean getTrackFileInfos(File file, StringBuilder info) {
        int read;
        FileReader fileReader = null;
        try {
            if (!file.exists()) {
                return false;
            }
            char[] cArr = new char[1024];
            FileReader fileReader2 = new FileReader(file);
            do {
                try {
                    read = fileReader2.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    info.append(cArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    info.append("track message:").append(th.getMessage()).append("\r\n");
                    return true;
                }
            } while (read >= 1024);
            fileReader2.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean getTrackFileInfos(String path, StringBuilder info) {
        int read;
        FileReader fileReader = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                info.append("path").append(path).append(" not exists.\r\n");
                return false;
            }
            char[] cArr = new char[1024];
            FileReader fileReader2 = new FileReader(file);
            do {
                try {
                    read = fileReader2.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    info.append(cArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    info.append("track message:").append(th.getMessage()).append("\r\n");
                    return true;
                }
            } while (read >= 1024);
            fileReader2.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean readTrackInfos(long playerId, String dir, StringBuilder info) {
        return getTrackFileInfos(getTrackFilePath(playerId, dir), info);
    }

    public static boolean readDebugTrackInfos(long playerId, String dir, StringBuilder info) {
        return getTrackFileInfos(getDebugTrackFilePath(playerId, dir), info);
    }

    private static String getDebugTrackFilePath(long playerId, String dir) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d_d.log", dir, Long.valueOf(playerId));
    }

    public static String getTrackFilePath(long playerId, String dir) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d.log", dir, Long.valueOf(playerId));
    }

    private static void deleteTrackFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void deleteDebugTrackFile(long playerId, String dir) {
        deleteTrackFile(getDebugTrackFilePath(playerId, dir));
    }

    public static void deleteTrackFile(long playerId, String dir) {
        deleteTrackFile(getTrackFilePath(playerId, dir));
    }

    public static boolean existsTrackFile(long playerId, String dir) {
        return new File(getTrackFilePath(playerId, dir)).exists();
    }

    public static boolean moveTrackFile(long src, long dst, String dir) {
        return new File(getTrackFilePath(src, dir)).renameTo(new File(getTrackFilePath(dst, dir)));
    }

    public static void checkTrackDir(String dir) {
        File file = new File(String.format("%s/ttplayer_logs", dir));
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public static boolean existLogsFile(long handle, String dir) {
        File[] listFiles;
        String valueOf = String.valueOf(handle);
        File file = new File(String.format("%s/ttplayer_logs", dir));
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            Log.i("ttmp", "<TTCrashUtils,existLogsFile,375>file:" + name + ",pname:" + valueOf);
            if (name != null && !name.startsWith(valueOf)) {
                return true;
            }
        }
        return false;
    }

    public static boolean readLogsInfo(long handle, String dir, StringBuilder builder) {
        File[] listFiles;
        String valueOf = String.valueOf(handle);
        File file = new File(String.format("%s/ttplayer_logs", dir));
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (name != null && !name.startsWith(valueOf) && getTrackFileInfos(file2, builder)) {
                boolean delete = file2.delete();
                if (!delete) {
                    Log.d("ttmp", "delete file:" + file2.getName() + "," + delete);
                }
                return delete;
            }
        }
        return false;
    }

    public static void checkLogDir(String dir) {
        File file = new File(String.format("%s/ttplayer_logs", dir));
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        boolean delete = file2.delete();
                        if (!delete) {
                            Log.d("ttmp", "delete file:" + file2.getName() + "," + delete);
                        }
                    }
                }
                boolean delete2 = file.delete();
                if (delete2) {
                    return;
                }
                Log.d("ttmp", "delete dir file:" + file.getName() + "," + delete2);
                return;
            }
            return;
        }
        boolean mkdir = file.mkdir();
        if (mkdir) {
            return;
        }
        Log.d("ttmp", "mkdir:" + file.getName() + "," + mkdir);
    }
}
