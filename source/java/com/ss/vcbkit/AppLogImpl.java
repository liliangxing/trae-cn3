package com.ss.vcbkit;

import com.bytedance.applog.AppLog;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.common.util.TeaLog;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class AppLogImpl {
    private static boolean sAppLogLoaded;
    private static boolean sBDTrackerLoaded;

    static {
        setup();
    }

    public static void setup() {
        if (sBDTrackerLoaded) {
            return;
        }
        try {
            AppLog.getAppId();
            sBDTrackerLoaded = true;
        } catch (Throwable unused) {
            sBDTrackerLoaded = false;
        }
        try {
            TeaLog.Task.m84i("applog");
            sAppLogLoaded = true;
        } catch (Throwable unused2) {
            sAppLogLoaded = false;
        }
    }

    public static void onEvent(String str, String str2) {
        if (sBDTrackerLoaded || sAppLogLoaded) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (sBDTrackerLoaded && AppLog.hasStarted()) {
                    AppLog.onEventV3(str, jSONObject);
                } else if (sAppLogLoaded) {
                    AppLogNewUtils.onEventV3(str, jSONObject);
                }
            } catch (Throwable th) {
                VLog.m251w("vcbkit", "jsonErr:" + th.getMessage());
            }
        }
    }

    private AppLogImpl() {
    }
}
