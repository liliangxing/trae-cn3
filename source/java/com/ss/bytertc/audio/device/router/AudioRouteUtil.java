package com.ss.bytertc.audio.device.router;

import android.content.Context;
import com.bytedance.realx.base.ContextUtils;

/* loaded from: classes7.dex */
public class AudioRouteUtil {
    public static String modeString(int mode) {
        return mode != 0 ? mode != 1 ? mode != 2 ? mode != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION" : "MODE_IN_CALL" : "MODE_RINGTONE" : "MODE_NORMAL";
    }

    public static Context getContext() {
        return ContextUtils.getApplicationContext();
    }
}
