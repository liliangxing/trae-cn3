package com.bytedance.trae.utils;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes4.dex */
public class AppUtils {
    public static String sProcessName;

    public static String getCurrentProcessName() {
        if (TextUtils.isEmpty(sProcessName)) {
            sProcessName = getProcessName(Process.myPid());
        }
        return sProcessName;
    }

    public static Application getApplication(Context context) {
        if (context == null) {
            return null;
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        return (Application) context;
    }

    public static String getProcessName(int i) {
        BufferedReader bufferedReader;
        if (!TextUtils.isEmpty(sProcessName)) {
            return sProcessName;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                sProcessName = readLine;
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return readLine;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static boolean isMainProcess(Context context) {
        String processName = getProcessName(Process.myPid());
        return (processName == null || !processName.contains(Constants.COLON_SEPARATOR)) && processName != null && processName.equals(context.getPackageName());
    }
}
