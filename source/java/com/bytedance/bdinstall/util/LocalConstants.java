package com.bytedance.bdinstall.util;

import com.bytedance.bdinstall.BuildConfig;

/* loaded from: classes3.dex */
public class LocalConstants extends Constants {
    public static int getVersionCode() {
        return BuildConfig.BDINSTALL_VERSION_CODE;
    }

    public static String getOldSpName() {
        return StringEncryptUtils.base64DecodeToString("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA==");
    }
}
