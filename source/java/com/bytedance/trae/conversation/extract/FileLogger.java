package com.bytedance.trae.conversation.extract;

import android.content.Context;
import android.util.Log;
import com.bytedance.trae.TraeApplication;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class FileLogger {

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
        try {
            Context context = (Context) TraeApplication.Companion.getInst();
            File externalDir = context.getExternalFilesDir(null);
            if (externalDir != null) {
                return new File(externalDir, "trae-cn3.log");
            }
            File cacheDir = context.getCacheDir();
            if (cacheDir != null) {
                return new File(cacheDir, "trae-cn3.log");
            }
            return null;
        } catch (Throwable t) {
            Log.e("FileLogger", "getLogFile failed", t);
            return null;
        }
    }
}
