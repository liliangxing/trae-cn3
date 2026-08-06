package com.lynx.canvas;

import android.os.Build;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class DeviceUtil {
    private static final String sDeviceModel;
    private static final String sManufacturer = Build.MANUFACTURER.toLowerCase();
    private static final boolean sTextureDestroyWorkaround;

    static {
        String lowerCase = Build.MODEL.toLowerCase();
        sDeviceModel = lowerCase;
        sTextureDestroyWorkaround = Arrays.asList("m6 note", "m721c").contains(lowerCase);
    }

    public static boolean needTextureDestroyWorkaround() {
        return sTextureDestroyWorkaround;
    }
}
