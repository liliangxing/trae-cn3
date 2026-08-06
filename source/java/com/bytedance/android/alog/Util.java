package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: classes2.dex */
class Util {
    Util() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAppVersion(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        if (r0 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getProcessName(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    String trim = readLine.trim();
                    if (!TextUtils.isEmpty(trim)) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused) {
                        }
                        return trim;
                    }
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
            bufferedReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
        try {
            bufferedReader.close();
        } catch (Exception unused5) {
            return null;
        }
    }
}
