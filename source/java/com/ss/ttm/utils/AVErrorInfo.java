package com.ss.ttm.utils;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

/* loaded from: classes7.dex */
public class AVErrorInfo {
    public static final String CRASH = "crash";
    public static final String ERROR = "error";
    private static StringBuilder PHONE_INFO;

    public static final void setupPhoneInfo(Context context, StringBuilder builder) {
        String[] version = VersionInfo.getVersion();
        if (version != null) {
            builder.append(String.format("version:%s,%s,%s\r\n", version[0], version[1], version[2])).append("\r\n");
        }
        long[] romMemroy = MemoryInfo.getRomMemroy();
        if (romMemroy != null) {
            builder.append(String.format(Locale.US, "rom memory totle:%d,availe:%d\r\n", Long.valueOf(romMemroy[0]), Long.valueOf(romMemroy[1]))).append("\r\n");
        }
        long availMemory = MemoryInfo.getAvailMemory(context);
        builder.append(String.format(Locale.US, "ram memory totle:%d,availe:%d\r\n", Long.valueOf(MemoryInfo.getTolalMemory()), Long.valueOf(availMemory))).append("\r\n");
        long[] sDCardSize = HardWareInfo.getSDCardSize(context);
        if (sDCardSize != null) {
            builder.append(String.format(Locale.US, "sdcard totle:%d,availe:%d\r\n", Long.valueOf(sDCardSize[0]), Long.valueOf(sDCardSize[1]))).append("\r\n");
        }
    }

    public static void setupErrorInfo(Context context, StringBuilder logInfo, String errName, String errorInfo, String url) {
        if (PHONE_INFO == null) {
            StringBuilder sb = new StringBuilder();
            PHONE_INFO = sb;
            setupPhoneInfo(context, sb);
        }
        logInfo.append((CharSequence) PHONE_INFO);
        logInfo.append("\r\n").append(errName).append(Constants.COLON_SEPARATOR).append(errorInfo);
    }
}
