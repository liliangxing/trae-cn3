package com.bytedance.security.android.aopcheck.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.util.IoUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: classes5.dex */
public class ProcessUtil {
    private static String sCurProcessName;
    private static boolean sIsMainProcess;

    public static boolean isMainProcess(Context context) {
        if (sIsMainProcess) {
            return true;
        }
        String curProcessName = getCurProcessName(context);
        if (curProcessName != null && curProcessName.contains(Constants.COLON_SEPARATOR)) {
            sIsMainProcess = false;
        } else {
            sIsMainProcess = curProcessName != null && curProcessName.equals(context.getPackageName());
        }
        return sIsMainProcess;
    }

    public static boolean isMainProcess(Context context, String str) {
        if (str == null || !str.equals(context.getPackageName())) {
            return str != null && str.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static void setCurProcessName(String str) {
        sCurProcessName = str;
    }

    public static String getCurProcessName(Context context) {
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurProcessName = curProcessNameFromProc;
        return curProcessNameFromProc == null ? "" : curProcessNameFromProc;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read > 0) {
                    sb.append((char) read);
                } else {
                    String sb2 = sb.toString();
                    IoUtil.close(bufferedReader);
                    return sb2;
                }
            }
        } catch (Throwable unused2) {
            IoUtil.close(bufferedReader);
            return null;
        }
    }
}
