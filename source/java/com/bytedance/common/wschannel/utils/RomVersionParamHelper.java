package com.bytedance.common.wschannel.utils;

import com.ss.android.common.util.ToolUtils;

/* loaded from: classes3.dex */
public class RomVersionParamHelper {
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    private static final SystemPropertiesProxy sPropertiesProxy = new SystemPropertiesProxy();

    public static boolean isMIUI12() {
        if (!ToolUtils.isMiui()) {
            return false;
        }
        try {
            return Integer.parseInt(getSystemProperty("ro.miui.ui.version.name").substring(1)) >= 12;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String getSystemProperty(String str) {
        return sPropertiesProxy.get(str);
    }
}
