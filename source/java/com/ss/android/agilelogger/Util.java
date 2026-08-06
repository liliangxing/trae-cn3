package com.ss.android.agilelogger;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class Util {
    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean isMainProcess(Context context) {
        String processName = getProcessName();
        if (processName == null || processName.contains(Constants.COLON_SEPARATOR)) {
            return false;
        }
        return processName.equals(context.getPackageName()) || processName.equals(context.getApplicationInfo().processName);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getProcessName() {
        BufferedReader bufferedReader;
        Throwable th;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentProcessName", new Class[0]);
                method.setAccessible(true);
                return (String) method.invoke(null, new Object[0]);
            } catch (Exception unused) {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/cmdline"));
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        String trim = readLine.trim();
                        if (!TextUtils.isEmpty(trim)) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                            return trim;
                        }
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                    return null;
                }
            }
        } catch (Exception unused6) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }
}
