package com.bytedance.crash.util;

import java.util.concurrent.Callable;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public final class ActivityUtils {
    private static Callable<JSONArray> sActivityImpl;

    public static JSONArray getActivityTrack() {
        Callable<JSONArray> callable = sActivityImpl;
        if (callable == null) {
            return null;
        }
        try {
            return callable.call();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void setActivityImpl(Callable<JSONArray> callable) {
        sActivityImpl = callable;
    }
}
