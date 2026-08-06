package com.bytedance.platform.godzilla.utils;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class RomUtils {
    private static final CharSequence AMIGO = "amigo";

    private RomUtils() {
    }

    public static boolean isColorOS() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean isAmigo() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(AMIGO);
    }
}
