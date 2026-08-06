package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.setting.SettingsManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NoCaptchaSetting {
    private static final long DEFAULT_COLLECT_TIME_OUT = 10000;
    private static final long DEFAULT_REPORT_TIME_OUT = 2000;
    private static final String KEY_COLLECT_TIME_OUT = "async_collect_time_out";
    private static final String KEY_PAGE_HISTORY = "collect_page_history";
    private static final String KEY_PAGE_HISTORY_PRE = "collect_page_history_pre";
    private static final String KEY_REPORT_TIME_OUT = "report_time_out";
    private static final String KEY_TOUCH_EVENT = "collect_touch_event";
    private static final String KEY_TOUCH_EVENT_PRE = "collect_touch_event_pre";
    private static final String KEY_TRIGGER_SEC = "trigger_sec_sdk";
    private static JSONObject mInitConfig;

    public static boolean triggerSecSdk() {
        JSONObject noCaptchaCfg = noCaptchaCfg();
        if (noCaptchaCfg != null) {
            return noCaptchaCfg.optBoolean(KEY_TRIGGER_SEC, false);
        }
        return false;
    }

    public static boolean collectTouchEventPre() {
        JSONObject noCaptchaCfg = noCaptchaCfg();
        if (noCaptchaCfg != null) {
            return noCaptchaCfg.optBoolean(KEY_TOUCH_EVENT_PRE, false);
        }
        return false;
    }

    public static boolean collectTouchEvent() {
        JSONObject noCaptchaCfg = noCaptchaCfg();
        if (noCaptchaCfg != null) {
            return noCaptchaCfg.optBoolean(KEY_TOUCH_EVENT, false);
        }
        return false;
    }

    public static boolean collectPageHistory() {
        JSONObject noCaptchaCfg = noCaptchaCfg();
        if (noCaptchaCfg != null) {
            return noCaptchaCfg.optBoolean(KEY_PAGE_HISTORY, false);
        }
        return false;
    }

    public static boolean collectPageHistoryPre() {
        JSONObject noCaptchaCfg = noCaptchaCfg();
        if (noCaptchaCfg != null) {
            return noCaptchaCfg.optBoolean(KEY_PAGE_HISTORY_PRE, false);
        }
        return false;
    }

    public static long reportTimeOut() {
        JSONObject noCaptchaCfg = noCaptchaCfg();
        long optLong = noCaptchaCfg != null ? noCaptchaCfg.optLong(KEY_REPORT_TIME_OUT, DEFAULT_REPORT_TIME_OUT) : 2000L;
        return optLong > 0 ? optLong : DEFAULT_REPORT_TIME_OUT;
    }

    public static long asyncCollectTimeOut() {
        JSONObject noCaptchaCfg = noCaptchaCfg();
        long optLong = noCaptchaCfg != null ? noCaptchaCfg.optLong(KEY_COLLECT_TIME_OUT) : 10000L;
        if (optLong > 0) {
            return optLong;
        }
        return 10000L;
    }

    public static JSONObject noCaptchaCfg() {
        JSONObject jSONObject = mInitConfig;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject serviceSettings = SettingsManager.INSTANCE.getServiceSettings("nocaptcha");
        mInitConfig = serviceSettings;
        return serviceSettings;
    }
}
