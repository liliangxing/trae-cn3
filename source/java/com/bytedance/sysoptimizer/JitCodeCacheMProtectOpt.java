package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public class JitCodeCacheMProtectOpt {
    private static final int SDK_INT = Build.VERSION.SDK_INT;

    private static native void nStartPharse1(long j, long j2);

    private static native void nStartPharse2();

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
    
        r2 = r10.split("\\s+")[0].split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        r3 = r2[0];
        r2 = r2[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r3.startsWith("0x") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        r3 = r3.substring(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        if (r2.startsWith("0x") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        r2 = r2.substring(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0108, code lost:
    
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void startPharse1(Context context) {
        String str;
        String str2;
        int i = SDK_INT;
        int i2 = 24;
        if (i < 24 || i > 30 || !Process.is64Bit() || !SysOptimizer.loadOptimizerLibrary(context)) {
            return;
        }
        String str3 = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
            str = null;
            boolean z = false;
            int i3 = 0;
            boolean z2 = false;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    int i4 = SDK_INT;
                    if (i4 < i2 || i4 > 25) {
                        if (i4 < 26 || i4 > 28) {
                            if (z && (i3 = i3 + 1) == 2) {
                                break;
                            }
                            if (readLine.contains("jit-cache")) {
                                String[] split = readLine.split("\\s+")[0].split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                str3 = split[0];
                                str2 = split[1];
                                try {
                                    if (str3.startsWith("0x")) {
                                        str3 = str3.substring(2);
                                    }
                                    if (str2.startsWith("0x")) {
                                        str2 = str2.substring(2);
                                    }
                                    str = str2;
                                    if (Long.parseLong(str3, 16) > BodyPartID.bodyIdMax) {
                                        Log.e("JitCodeCacheMProtectOpt", "" + Long.parseLong(str3, 16));
                                        z = true;
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    str = str2;
                                    e.printStackTrace();
                                    str2 = str;
                                    ByteHook.init();
                                    if (str3 != null) {
                                    }
                                    Log.e("JitCodeCacheMProtectOpt", "Failed to find JitCodeCacheStartAddrStr or JitCodeCacheEndAddrStr");
                                }
                            }
                        } else if (readLine.contains("dalvik-jit-code-cache")) {
                            String[] split2 = readLine.split("\\s+")[0].split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            if (!z2) {
                                str3 = split2[0];
                                if (str3.startsWith("0x")) {
                                    str3 = str3.substring(2);
                                }
                                z2 = true;
                            }
                            str = split2[1];
                            if (str.startsWith("0x")) {
                                str = str.substring(2);
                            }
                        } else if (z2) {
                            break;
                        }
                    } else if (readLine.contains("dalvik-jit-code-cache")) {
                        break;
                    }
                    i2 = 24;
                } catch (IOException e2) {
                    e = e2;
                }
            }
            bufferedReader.close();
        } catch (IOException e3) {
            e = e3;
            str = null;
        }
        ByteHook.init();
        if (str3 != null || str2 == null) {
            Log.e("JitCodeCacheMProtectOpt", "Failed to find JitCodeCacheStartAddrStr or JitCodeCacheEndAddrStr");
        } else {
            Log.i("JitCodeCacheMProtectOpt", "JitCodeCache startAddr: " + str3 + " endAddr: " + str2);
            nStartPharse1(Long.parseLong(str3, 16), Long.parseLong(str2, 16));
        }
    }

    public static void startPharse2(Context context) {
        int i = SDK_INT;
        if (i < 24 || i > 30 || !SysOptimizer.loadOptimizerLibrary(context)) {
            return;
        }
        nStartPharse2();
    }
}
