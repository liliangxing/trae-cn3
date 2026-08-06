package com.ss.bytertc.engine.utils;

import androidx.core.content.ContextCompat;
import com.ss.bytertc.base.utils.RtcContextUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PermissionChecker {
    public static boolean checkAudioPermission() {
        return ContextCompat.checkSelfPermission(RtcContextUtils.getApplicationContext(), "android.permission.RECORD_AUDIO") == 0;
    }

    public static boolean checkCameraPermission() {
        return ContextCompat.checkSelfPermission(RtcContextUtils.getApplicationContext(), "android.permission.CAMERA") == 0;
    }
}
