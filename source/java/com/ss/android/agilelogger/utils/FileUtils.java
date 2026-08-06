package com.ss.android.agilelogger.utils;

import android.content.Context;
import java.io.File;

/* loaded from: classes7.dex */
public class FileUtils {
    public static File getDefaultLogDir(Context context) {
        File file = new File(context.getFilesDir(), "logs");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static String getBufferDirPath(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            return null;
        }
        File file = new File(filesDir.getAbsolutePath(), "ALOG");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }
}
