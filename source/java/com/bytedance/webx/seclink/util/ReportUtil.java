package com.bytedance.webx.seclink.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.webx.base.WebXConfig;
import com.bytedance.webx.base.report.IReportAgent;
import com.bytedance.webx.seclink.BuildConfig;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.config.AppSecConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ReportUtil {
    private static final String APP_LOG_KEY = "seclink_sdk_log";
    private static final String KEY_EVENT_KEY = "key";
    private static final String KEY_INIT_DATE = "init_date";
    private static final String KEY_SETTING_DATE = "setting_date";
    private static final String NORMAL_EVENT_KEY = "seclink_normal_event";
    private static final String SPECIAL_EVENT_KEY = "seclink_special_event";
    private static final String SP_FILE_NAME = "sec_link_config";
    private static final String TAG = "ReportUtil";
    private static boolean needSaveInitState = true;
    private static boolean needSaveSettingState = true;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private interface Event {
        public static final String EVENT_BUILD_MIDDLE_PAGE = "build_middle_page";
        public static final String EVENT_ERROR_SCHEME = "error_scheme";
        public static final String EVENT_EXCEPTION = "exception";
        public static final String EVENT_HANDLE_LOAD_URL = "handle_load_url";
        public static final String EVENT_HANDLE_OVERRIDE_URL_LOADING = "handle_override_url_loading";
        public static final String EVENT_HIT_CACHE = "hit_cache";
        public static final String EVENT_HOST_SCHEDULE = "host_schedule";
        public static final String EVENT_INIT = "init";
        public static final String EVENT_SETTING = "setting";
        public static final String EVENT_SHIELD = "shield";
        public static final String EVENT_START_PULL_SETTING = "start_pull_setting";
        public static final String EVENT_VERIFY = "verify";
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private interface Params {
        public static final String APP_ID = "app_id";
        public static final String APP_VERSION = "app_version";
        public static final String BIZ_TAG = "biz_tag";
        public static final String CUSTOM = "custom";
        public static final String DEVICE_ID = "device_id";
        public static final String DURATION = "duration";
        public static final String HOST = "host";
        public static final String MODE = "mode";
        public static final String PLATFORM = "platform";
        public static final String RESULT = "result";
        public static final String RISK = "risk";
        public static final String SCENE = "scene";
        public static final String SDK_VERSION = "sdk_version";
        public static final String SHOW_MID_PAGE = "show_mid_page";
        public static final String TYPE = "type";
        public static final String URL = "url";
    }

    static /* synthetic */ boolean access$000() {
        return isFirstInit();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum ERROR_TYPE {
        ApiFail("ApiRequest"),
        ApiResultError("ApiResultError"),
        Other("other");

        private String type;

        ERROR_TYPE(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onEvent(String str, JSONObject jSONObject) {
        try {
            IReportAgent reportAgent = WebXConfig.getReportAgent();
            if (reportAgent == null) {
                return;
            }
            AppSecConfig linkConfig = SecLinkFacade.getLinkConfig();
            if (linkConfig != null) {
                jSONObject.put("app_id", linkConfig.getAid());
                jSONObject.put(Params.APP_VERSION, linkConfig.getAppVersion());
                String did = linkConfig.getDid();
                if (TextUtils.isEmpty(did) && linkConfig.getDeviceProvider() != null) {
                    did = linkConfig.getDeviceProvider().deviceId();
                }
                jSONObject.put(Params.DEVICE_ID, did);
            }
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put(Params.PLATFORM, "android");
            jSONObject.put("params_for_special", APP_LOG_KEY);
            reportAgent.report(str, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init(final long j, final String str, final String str2) {
        try {
            if (WebXConfig.getReportAgent() == null) {
                return;
            }
            SecLinkTaskExecutor.getInstance().execute(new Runnable() { // from class: com.bytedance.webx.seclink.util.ReportUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ReportUtil.access$000()) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(ReportUtil.KEY_EVENT_KEY, Event.EVENT_INIT);
                            jSONObject.put(Params.SCENE, str);
                            jSONObject.put(Params.CUSTOM, str2);
                            jSONObject.put(Params.DURATION, j);
                            ReportUtil.onEvent(ReportUtil.SPECIAL_EVENT_KEY, jSONObject);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isFirstInit() {
        if (needSaveInitState) {
            needSaveInitState = saveSate(KEY_INIT_DATE);
        }
        return needSaveInitState;
    }

    private static boolean saveSate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Context applicationContext = SecLinkFacade.getContext() != null ? SecLinkFacade.getContext().getApplicationContext() : null;
            if (applicationContext == null) {
                return false;
            }
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(str, "");
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (string == null || string.equals(format)) {
                return false;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, format);
            edit.commit();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void setting(boolean z, long j, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_EVENT_KEY, "setting");
            jSONObject.put(Params.DURATION, j);
            jSONObject.put("result", z ? 1 : 0);
            jSONObject.put(Params.HOST, str);
            jSONObject.put(Params.CUSTOM, str2);
            onEvent(SPECIAL_EVENT_KEY, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hitCache(String str, String str2, String str3, boolean z, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", str);
            jSONObject.put(Params.SCENE, str2);
            jSONObject.put("result", z ? 1 : 0);
            jSONObject.put(Params.CUSTOM, str4);
            jSONObject.put(Params.BIZ_TAG, str3);
            jSONObject.put(KEY_EVENT_KEY, Event.EVENT_HIT_CACHE);
            onEvent(NORMAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void reportError(String str, int i, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder("errorType:");
            sb.append(str).append(";error_code:").append(i).append(";errorMsg:").append(str2);
            jSONObject.put(Params.CUSTOM, sb.toString());
            jSONObject.put(KEY_EVENT_KEY, "exception");
            onEvent(SPECIAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void verifyResult(String str, boolean z, String str2, String str3, String str4, boolean z2, long j, int i, String str5, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Params.HOST, str);
            jSONObject.put("url", str3);
            jSONObject.put(Params.SCENE, str2);
            jSONObject.put(Params.BIZ_TAG, str4);
            int i3 = 1;
            jSONObject.put("result", z ? 1 : 0);
            jSONObject.put(Params.MODE, i);
            if (!z2) {
                i3 = 0;
            }
            jSONObject.put(Params.SHOW_MID_PAGE, i3);
            jSONObject.put(Params.RISK, i2);
            jSONObject.put(Params.CUSTOM, str5);
            jSONObject.put(Params.DURATION, j);
            jSONObject.put(KEY_EVENT_KEY, "verify");
            onEvent(NORMAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void hostSchedule(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", str);
            jSONObject.put(Params.CUSTOM, "index=" + i);
            jSONObject.put(KEY_EVENT_KEY, "host_schedule");
            onEvent(SPECIAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void shield(String str, String str2, long j, long j2, long j3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Params.CUSTOM, "maxErrorNum=" + j + ",errorDurationTime=" + j2 + ",shieldDurationTime=" + j3);
            jSONObject.put(KEY_EVENT_KEY, "shield");
            jSONObject.put("url", str);
            jSONObject.put(Params.SCENE, str2);
            onEvent(SPECIAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void handleLoadUrl(String str, String str2, int i, String str3, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i);
            jSONObject.put(Params.BIZ_TAG, str3);
            jSONObject.put(Params.MODE, i2);
            jSONObject.put(KEY_EVENT_KEY, Event.EVENT_HANDLE_LOAD_URL);
            jSONObject.put("url", str);
            jSONObject.put(Params.SCENE, str2);
            onEvent(NORMAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void handleOverrideUrlLoading(String str, String str2, int i, String str3, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i);
            jSONObject.put(Params.BIZ_TAG, str3);
            jSONObject.put(Params.MODE, i2);
            jSONObject.put(KEY_EVENT_KEY, Event.EVENT_HANDLE_OVERRIDE_URL_LOADING);
            jSONObject.put("url", str);
            jSONObject.put(Params.SCENE, str2);
            onEvent(NORMAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void startPullSetting(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Params.CUSTOM, str2);
            jSONObject.put(Params.SCENE, str);
            jSONObject.put(KEY_EVENT_KEY, Event.EVENT_START_PULL_SETTING);
            onEvent(SPECIAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final void buildMiddlePage(boolean z, String str, String str2, String str3, String str4, String str5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Params.CUSTOM, str5);
            jSONObject.put(Params.SCENE, str3);
            jSONObject.put(Params.BIZ_TAG, str4);
            jSONObject.put(Params.HOST, str);
            jSONObject.put("result", z ? 1 : 0);
            jSONObject.put("url", str2);
            jSONObject.put(KEY_EVENT_KEY, Event.EVENT_BUILD_MIDDLE_PAGE);
            onEvent(NORMAL_EVENT_KEY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
