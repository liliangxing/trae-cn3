package com.huawei.multimedia.audiokit.interfaces;

import com.huawei.multimedia.audiokit.utils.LogUtils;

/* loaded from: classes6.dex */
public class UnsupportedVersionException extends Exception {
    private static final String TAG = "HwAudioKit.UnsupportedVersionException";

    public UnsupportedVersionException() {
        LogUtils.error(TAG, "getEnhancedDeviceInfo UnsupportedVersionException");
    }
}
