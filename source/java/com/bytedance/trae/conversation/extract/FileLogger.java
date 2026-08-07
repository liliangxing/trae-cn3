package com.bytedance.trae.conversation.extract;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.bytedance.trae.TraeApplication;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class FileLogger {

    private static File cachedLogFile = null;

    public static void log(String tag, String message) {
        log(tag, message, null);
    }

    public static void log(String tag, String message, Throwable throwable) {
        try {
            Log.e(tag, message, throwable);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String timestamp = sdf.format(new Date());

            StringBuilder sb = new StringBuilder();
            sb.append(timestamp);
            sb.append(" [");
            sb.append(tag);
            sb.append("] ");
            sb.append(message);

            if (throwable != null) {
                sb.append("\n");
                sb.append(Log.getStackTraceString(throwable));
            }
            sb.append("\n");

            File logFile = getLogFile();
            if (logFile != null) {
                FileWriter writer = new FileWriter(logFile, true);
                writer.write(sb.toString());
                writer.flush();
                writer.close();
            }
        } catch (Throwable t) {
            Log.e("FileLogger", "write failed", t);
        }
    }

    private static File getLogFile() {
        if (cachedLogFile != null) {
            return cachedLogFile;
        }

        // 优先使用 app 专属目录（任何 Android 版本都能写，不需要权限）
        // 路径: /storage/emulated/0/Android/data/com.bytedance.trae.cn3/files/trae-cn3.log
        try {
            Context context = (Context) TraeApplication.Companion.getInst();
            if (context != null) {
                File externalDir = context.getExternalFilesDir(null);
                if (externalDir != null) {
                    File logFile = new File(externalDir, "trae-cn3.log");
                    // 测试写入
                    FileWriter testWriter = new FileWriter(logFile, true);
                    testWriter.write("");
                    testWriter.flush();
                    testWriter.close();
                    cachedLogFile = logFile;
                    Log.i("FileLogger", "Log file: " + logFile.getAbsolutePath());
                    return logFile;
                }
            }
        } catch (Throwable t) {
            Log.e("FileLogger", "app-specific dir failed", t);
        }

        // 备用: cacheDir（绝对能写）
        try {
            Context context = (Context) TraeApplication.Companion.getInst();
            if (context != null) {
                File cacheDir = context.getCacheDir();
                if (cacheDir != null) {
                    File logFile = new File(cacheDir, "trae-cn3.log");
                    cachedLogFile = logFile;
                    Log.i("FileLogger", "Log file (cache): " + logFile.getAbsolutePath());
                    return logFile;
                }
            }
        } catch (Throwable t) {
            Log.e("FileLogger", "cache dir failed", t);
        }

        // 最后尝试: 公共 /sdcard 目录（Android 10 以下或已授权）
        try {
            File extRoot = Environment.getExternalStorageDirectory();
            if (extRoot != null) {
                File dir = new File(extRoot, "douyinguanjia/Log");
                File logFile = new File(dir, "trae-cn3.log");
                if (dir.exists() || dir.mkdirs()) {
                    FileWriter testWriter = new FileWriter(logFile, true);
                    testWriter.write("");
                    testWriter.flush();
                    testWriter.close();
                    cachedLogFile = logFile;
                    return logFile;
                }
            }
        } catch (Throwable t) {
            Log.e("FileLogger", "public dir failed", t);
        }

        return null;
    }
}
