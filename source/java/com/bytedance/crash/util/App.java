package com.bytedance.crash.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileInputStream;

/* loaded from: classes3.dex */
public final class App {
    private static String sCurProcessName;

    public static String getProcessName() {
        if (TextUtils.isEmpty(sCurProcessName)) {
            sCurProcessName = getProcessNameFromCmdline();
        }
        return sCurProcessName;
    }

    public static void setCurProcessName(String str) {
        sCurProcessName = str;
    }

    public static boolean isMainProcess(Context context, String str) {
        if (str == null || str.contains(Constants.COLON_SEPARATOR)) {
            return false;
        }
        if (context == null) {
            context = Global.getContext();
        }
        if (context == null) {
            return false;
        }
        if (str.equals(context.getPackageName())) {
            return true;
        }
        return str.equals(context.getApplicationInfo().processName);
    }

    public static boolean isMainProcess() {
        return isMainProcess(Global.getContext());
    }

    public static boolean isMainProcess(Context context) {
        return isMainProcess(context, getProcessName());
    }

    private static String getProcessNameFromCmdline() {
        FileInputStream fileInputStream;
        int read;
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream("/proc/self/cmdline");
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[64];
            do {
                read = fileInputStream.read(bArr, 0, 64);
                for (int i = 0; i < read; i++) {
                    char c = (char) bArr[i];
                    if (c != 0 && c != '\n') {
                        sb.append(c);
                    }
                    read = -1;
                    break;
                }
            } while (read > 0);
            FileSystemUtils.close(fileInputStream);
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            FileSystemUtils.close(fileInputStream2);
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            FileSystemUtils.close(fileInputStream2);
            throw th;
        }
        return sb.toString();
    }

    public static String getCurProcessName(Context context) {
        if (!TextUtils.isEmpty(sCurProcessName)) {
            return sCurProcessName;
        }
        String processNameFromCmdline = getProcessNameFromCmdline();
        sCurProcessName = processNameFromCmdline;
        return processNameFromCmdline == null ? "" : processNameFromCmdline;
    }

    public static String getCurProcessName() {
        String str = sCurProcessName;
        return str != null ? str : "";
    }
}
