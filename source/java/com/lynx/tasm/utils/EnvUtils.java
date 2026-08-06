package com.lynx.tasm.utils;

import android.content.Context;
import com.lynx.tasm.LynxEnv;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EnvUtils {
    private static final String TAG = "EnvUtils";

    public static String getCacheDir() {
        Context appContext = LynxEnv.inst().getAppContext();
        return appContext != null ? appContext.getCacheDir().getAbsolutePath() : "";
    }
}
