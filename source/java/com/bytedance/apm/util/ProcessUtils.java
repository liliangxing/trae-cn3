package com.bytedance.apm.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class ProcessUtils {
    private static String sCurProcessName;

    public static String getCurProcessName(Context context) {
        String str = sCurProcessName;
        if (!TextUtils.isEmpty(str)) {
            return str;
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
            StringBuilder sb = new StringBuilder(32);
            while (true) {
                int read = bufferedReader.read();
                if (read > 0) {
                    sb.append((char) read);
                } else {
                    String sb2 = sb.toString();
                    IoUtil.safeClose(bufferedReader);
                    return sb2;
                }
            }
        } catch (Throwable unused2) {
            IoUtil.safeClose(bufferedReader);
            return null;
        }
    }
}
