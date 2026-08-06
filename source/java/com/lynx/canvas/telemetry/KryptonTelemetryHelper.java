package com.lynx.canvas.telemetry;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class KryptonTelemetryHelper {
    private static final String SEPARATOR_PARAM = ",";
    private static final String TAG = "KryptonTelemetryHelper";

    public static void reportEvent(KryptonApp kryptonApp, String str, String str2) {
        KryptonTelemetryService kryptonTelemetryService = (KryptonTelemetryService) kryptonApp.getService(KryptonTelemetryService.class);
        if (kryptonTelemetryService == null) {
            KryptonLLog.m2560e(TAG, "no service found");
            return;
        }
        HashMap hashMap = new HashMap();
        if (str2 != null && !str2.isEmpty()) {
            String[] split = str2.split(SEPARATOR_PARAM);
            if (split.length % 2 == 0) {
                for (int i = 0; i < split.length; i += 2) {
                    hashMap.put(split[i], split[i + 1]);
                }
            } else {
                KryptonLLog.m2560e(TAG, "params format error, length should be even");
                return;
            }
        }
        kryptonTelemetryService.reportEvent(str, hashMap);
    }
}
