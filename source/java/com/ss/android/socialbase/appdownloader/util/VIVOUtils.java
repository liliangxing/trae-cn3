package com.ss.android.socialbase.appdownloader.util;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class VIVOUtils {
    private static final String SHOULD_INSERT_PASSWORD = "persist.vivo.install.account.verify";

    public static boolean shouldInsertInstallPassword() {
        if (TextUtils.isEmpty(RomUtils.getProp(SHOULD_INSERT_PASSWORD))) {
            return true;
        }
        return !"0".equals(r0);
    }
}
