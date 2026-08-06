package com.bytedance.reparo.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.crash.util.NpthLog;

/* loaded from: classes4.dex */
public class CpuUtils {
    private static final String UNKNOWN = "unknown";
    private static String sCpuABI = null;
    private static int sIs64Bit = -1;
    private static int sIsX86 = -1;

    private static String getCpuAbi() {
        if (sCpuABI == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                        sb.append(Build.SUPPORTED_ABIS[i]);
                        if (i != Build.SUPPORTED_ABIS.length - 1) {
                            sb.append(", ");
                        }
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    sCpuABI = "unknown";
                }
                sCpuABI = sb.toString();
            } catch (Exception e) {
                NpthLog.w(e);
                sCpuABI = "unknown";
            }
        }
        return sCpuABI;
    }

    public static boolean is64BitDevice() {
        if (sIs64Bit == -1) {
            sIs64Bit = getCpuAbi().contains("64") ? 1 : 0;
        }
        return sIs64Bit == 1;
    }

    public static boolean isX86Device() {
        if (sIsX86 == -1) {
            sIsX86 = getCpuAbi().contains("86") ? 1 : 0;
        }
        return sIsX86 == 1;
    }
}
