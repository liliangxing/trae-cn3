package com.bytedance.watson.assist.utils;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes6.dex */
public class FileUtils {

    /* loaded from: classes6.dex */
    public interface ReadLineCallback {
        boolean onReadLine(String str);
    }

    public static BufferedReader openFile(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            DebugLog.w("file:" + file.getName() + " not exist");
            return null;
        }
        if (!file.canRead()) {
            DebugLog.w("file:" + file.getName() + " can not read");
            return null;
        }
        try {
            return new BufferedReader(new FileReader(file), 10000);
        } catch (Exception e) {
            DebugLog.e(Log.getStackTraceString(e));
            return null;
        }
    }

    public static void closeFile(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                DebugLog.e(Log.getStackTraceString(e));
            }
        }
    }

    public static void readFile(File file, ReadLineCallback readLineCallback) {
        BufferedReader openFile;
        if (file == null || readLineCallback == null || (openFile = openFile(file)) == null) {
            return;
        }
        boolean z = true;
        while (z) {
            try {
                String readLine = openFile.readLine();
                if (readLine == null) {
                    break;
                } else {
                    z = readLineCallback.onReadLine(readLine);
                }
            } catch (IOException e) {
                DebugLog.e(Log.getStackTraceString(e));
            }
        }
        closeFile(openFile);
    }

    public static void readFile(String str, ReadLineCallback readLineCallback) {
        if (str == null || readLineCallback == null) {
            return;
        }
        readFile(new File(str), readLineCallback);
    }

    public static void createFile(String str, boolean z) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            DebugLog.i(str + " already exist");
            return;
        }
        if (z) {
            file.mkdir();
            DebugLog.i(str + " created");
            return;
        }
        File file2 = new File(file.getParent());
        if (!file2.exists()) {
            file2.mkdir();
        }
        try {
            file.createNewFile();
            DebugLog.i(str + " created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDir(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteDir(file2);
            }
        }
        file.delete();
    }
}
