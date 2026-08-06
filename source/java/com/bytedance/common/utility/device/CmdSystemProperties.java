package com.bytedance.common.utility.device;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Deprecated
/* loaded from: classes3.dex */
public final class CmdSystemProperties {
    private static final int DEFAULT_CACHE_SIZE = 1024;
    private static final String TAG = "CmdSystemProperties";

    private CmdSystemProperties() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0062: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:25:0x0062 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSystemProperty(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream(), "UTF-8"), 1024);
                try {
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        Log.e(TAG, "Exception while closing InputStream", e);
                    }
                    return readLine;
                } catch (IOException e2) {
                    e = e2;
                    Log.e(TAG, "Unable to read sysprop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            Log.e(TAG, "Exception while closing InputStream", e3);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e4) {
                        Log.e(TAG, "Exception while closing InputStream", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
            }
            throw th;
        }
    }
}
