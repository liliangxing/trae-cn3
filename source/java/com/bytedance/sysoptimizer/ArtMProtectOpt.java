package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes5.dex */
public class ArtMProtectOpt {
    private static String TAG = "ArtMProtectOpt";

    private static native int nMemmapSetDebugNameOpt();

    private static native int nStartPharse1(int i, int i2);

    private static native int nStartPharse2();

    public static int startPharse1(Context context, int i, int i2) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ByteHook.init();
        return nStartPharse1(i, i2);
    }

    public static int startPharse1(Context context) {
        String str;
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            String str2 = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
                str = null;
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.contains("dalvik-main space")) {
                            String[] split = readLine.split("\\s+")[0].split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            if (!z) {
                                str2 = split[0];
                                z = true;
                            }
                            str = split[1];
                        } else if (z) {
                            break;
                        }
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        ByteHook.init();
                        if (str2 != null) {
                        }
                        Log.e("ArtMProtectOpt", "Failed to find mainSpaceStartAddr or mainSpaceEndAddr");
                        return -1;
                    }
                }
                bufferedReader.close();
            } catch (IOException e2) {
                e = e2;
                str = null;
            }
            ByteHook.init();
            if (str2 != null || str == null) {
                Log.e("ArtMProtectOpt", "Failed to find mainSpaceStartAddr or mainSpaceEndAddr");
            } else {
                if (str2.startsWith("0x")) {
                    str2 = str2.substring(2);
                }
                if (str.startsWith("0x")) {
                    str = str.substring(2);
                }
                Log.i("ArtMProtectOpt", "Java main space start: " + str2 + " end: " + str);
                return nStartPharse1((int) Long.parseLong(str2, 16), (int) Long.parseLong(str, 16));
            }
        }
        return -1;
    }

    public static int startPharse2(Context context) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            return nStartPharse2();
        }
        return -1;
    }

    public static int memmapSetDebugNameOpt(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
        return nMemmapSetDebugNameOpt();
    }
}
