package com.lynx.tasm.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextPaint;
import android.view.Display;
import android.widget.TextView;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DeviceUtils {
    public static final int DEFAULT_DEVICE_REFRESH_RATE = 60;
    private static final int DEVICE_ARCH_TYPE_32IT = 0;
    private static final int DEVICE_ARCH_TYPE_64BIT = 1;
    private static final int DEVICE_ARCH_TYPE_UNDEFINED = -1;
    private static final String TAG = "DeviceUtils";
    private static final String UNKNOWN_CPU_ABI = "unknown";
    private static String sCpuABI = null;
    private static Typeface sDefaultTypeface = null;
    private static int sIs64Bit = -1;
    private static boolean sIsMiui;
    private static boolean sIsMiuiInited;
    private static boolean sIsTypefaceInit;

    public static synchronized boolean isMiui() {
        boolean z;
        synchronized (DeviceUtils.class) {
            if (!sIsMiuiInited) {
                try {
                    if (Class.forName("miui.os.Build") != null) {
                        sIsMiui = true;
                    }
                } catch (Exception unused) {
                }
                sIsMiuiInited = true;
            }
            z = sIsMiui;
        }
        return z;
    }

    public static synchronized Typeface getDefaultTypeface() {
        synchronized (DeviceUtils.class) {
            if (!isMiui()) {
                return null;
            }
            if (sIsTypefaceInit) {
                return sDefaultTypeface;
            }
            try {
                TextPaint paint = new TextView(LynxEnv.inst().getAppContext()).getPaint();
                if (paint != null) {
                    sDefaultTypeface = paint.getTypeface();
                }
            } catch (Exception unused) {
                LLog.e(LynxConstants.TAG, "get default typeface failed");
            }
            sIsTypefaceInit = true;
            return sDefaultTypeface;
        }
    }

    public static boolean isHuaWei() {
        return "HUAWEI".equals(Build.MANUFACTURER);
    }

    public static boolean isMeizu() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase(Locale.ENGLISH).indexOf("meizu") > -1;
    }

    public static boolean isMeizu15() {
        if (!isMeizu() || android.text.TextUtils.isEmpty(Build.DEVICE)) {
            return false;
        }
        return Build.DEVICE.contains("15");
    }

    public static boolean isHonor() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase(Locale.ENGLISH).indexOf(RomUtils.BRAND_HONOR) > -1;
    }

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
                if (android.text.TextUtils.isEmpty(sb.toString())) {
                    sCpuABI = UNKNOWN_CPU_ABI;
                }
                sCpuABI = sb.toString();
            } catch (Exception unused) {
                LLog.e(TAG, "Lynx get unknown CPU ABIs");
                sCpuABI = UNKNOWN_CPU_ABI;
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

    public static float getRefreshRate(LynxContext lynxContext) {
        if (lynxContext == null) {
            return 60.0f;
        }
        return getRefreshRate(lynxContext.getContext());
    }

    public static float getRefreshRate(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display != null) {
            return display.getRefreshRate();
        }
        return 60.0f;
    }
}
