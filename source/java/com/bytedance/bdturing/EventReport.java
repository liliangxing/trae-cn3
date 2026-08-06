package com.bytedance.bdturing;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.android.standard.tools.date.DateUtils;
import com.bytedance.bdturing.cache.ResourceManager;
import com.bytedance.bdturing.livedetect.LiveAuthConfig;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.livedetect.pty.DetectRecord;
import com.bytedance.bdturing.senseless.PageTracer;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventReport {
    public static final int CACHE_STATE_CONFLICT = 2;
    public static final int CACHE_STATE_DISAVAILABLE = 3;
    public static final int CACHE_STATE_LOAD_FAILED = 1;
    public static final int CACHE_STATE_LOAD_INDEX_FILE_FAIL = 4;
    public static final String DIALOG_BACKGROUND = "background";
    public static final String DIALOG_CLOSE = "close";
    public static final String DIALOG_POP = "pop";
    public static final String FINAL_TWICE_VERIFY_RESULT = "twice_verify_result";
    public static final String FINAL_TWICE_VERIFY_START = "twice_verify_start";
    public static final String FINAL_VERIFY_RESULT = "final_verify_result";
    public static final String IDENTITY_VERIFY_CONFIRM_DIALOG_AGREE = "agree";
    public static final String IDENTITY_VERIFY_CONFIRM_DIALOG_POP = "front_pop";
    public static final String IDENTITY_VERIFY_LOAD_CERT_SDK = "load_real_name";
    public static final String IDENTITY_VERIFY_RESULT = "real_name_result";
    private static final String KEY_AGREEMENT_CHECK = "turing_agreement_check";
    private static final String KEY_APP_ALIVE_TIME = "app_alive_time";
    private static final String KEY_CACHE_SATE = "cache_sate";
    private static final String KEY_CACHE_STATE = "local_cache_state";
    private static final String KEY_CALL_TYPE = "call_type";
    private static final String KEY_CHALLENGE_CODE = "challenge_code";
    private static final String KEY_CLIENT_STATUS_REPORT_RESULT = "client_status_report_result";
    private static final String KEY_CODE = "code";
    private static final String KEY_COMMON_WEB_CLOSE = "common_web_close";
    private static final String KEY_COMMON_WEB_ERROR = "common_web_error";
    private static final String KEY_COMMON_WEB_LOAD_FAIL = "common_web_load_fail";
    private static final String KEY_COMMON_WEB_LOAD_SUCCESS = "common_web_load_success";
    private static final String KEY_COMMON_WEB_SHOW = "common_web_show";
    private static final String KEY_CONFIRM_DIALOG_CLOSE = "confirm_dialog_close";
    private static final String KEY_CONFIRM_DIALOG_DISPLAY = "confirm_dialog_display";
    private static final String KEY_CONFIRM_DIALOG_ERROR = "confirm_dialog_error";
    private static final String KEY_CONFIRM_DIALOG_LOAD_FAIL = "confirm_dialog_load_fail";
    private static final String KEY_CONFIRM_DIALOG_LOAD_SUCCESS = "confirm_dialog_load_success";
    private static final String KEY_CONFIRM_RESULT = "confirm_result";
    private static final String KEY_CREATE_SESSION = "turing_live_create_session";
    private static final String KEY_CREATE_SESSION_RESULT = "turing_live_create_session_result";
    private static final String KEY_CUSTOM = "custom";
    private static final String KEY_DATA = "data";
    private static final String KEY_DEFAULT_EVENT = "turing_verify_sdk";
    private static final String KEY_DISPATCH_VERIFY = "handle_verify";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_EVENT = "event";
    private static final String KEY_EVENT_KEY = "key";
    private static final String KEY_H5_LOAD_RETRY_ENABLE = "h5_load_retry_enable";
    private static final String KEY_HIT_CACHE = "hit_cache";
    private static final String KEY_INIT_DATE = "turing_init_date";
    private static final String KEY_LIVE_CAMERA_STATE = "live_camera_state";
    private static final String KEY_LIVE_CHECK_RESULT = "live_available_check";
    private static final String KEY_LIVE_DETECT_AGREEMENT_LOAD_RESULT = "live_agreement_load_result";
    private static final String KEY_LIVE_DETECT_CAMERA_PERMISSION = "turing_live_detect_camera_permission";
    private static final String KEY_LIVE_DETECT_FRAME_RESULTS = "turing_live_detect_frame_results";
    private static final String KEY_LIVE_DETECT_PAGE_CLOSE = "turing_live_detect_page_close";
    private static final String KEY_LIVE_DETECT_PAGE_DISPLAY = "turing_live_detect_page_display";
    private static final String KEY_LIVE_DETECT_RESULT = "live_detect_result";
    private static final String KEY_LIVE_DIALOG_STATE = "turing_live_dialog_state";
    private static final String KEY_LIVE_DISPATCH = "live_dispatch";
    private static final String KEY_LIVE_DISPATCH_REASON = "live_dispatch_reason";
    private static final String KEY_LIVE_DISPATCH_RESULT = "live_dispatch_result";
    private static final String KEY_LIVE_DISPATCH_TYPE = "live_dispatch_type";
    private static final String KEY_LIVE_ENGINE_INIT_RESULT = "bytenn_init_result";
    private static final String KEY_LIVE_ENGINE_TYPE = "engine_type";
    private static final String KEY_LIVE_ERROR = "live_detect_error";
    private static final String KEY_LIVE_GUIDE_PAGE_SHOW = "live_guide_page_show";
    private static final String KEY_LIVE_H5_REQUEST_PERMISSION = "live_h5_request_permission";
    private static final String KEY_LIVE_LOAD_BYTENN_PLUGIN = "load_bytenn_plugin";
    private static final String KEY_LIVE_LOAD_MODEL = "load_model";
    private static final String KEY_LIVE_LOCAL_RESULT = "turing_live_local_result";
    private static final String KEY_LIVE_PREHEAT_RESULT = "live_preheat_result";
    private static final String KEY_LIVE_REMOTE_RESULT = "turing_live_remote_result";
    private static final String KEY_LIVE_START_BTN_CLICK = "live_start_btn_click";
    private static final String KEY_LIVE_START_DETECT = "turing_live_detect_start";
    private static final String KEY_LOADFAIL = "loadFail";
    private static final String KEY_LOGID = "shark_log_id";
    private static final String KEY_MODE = "mode";
    private static final String KEY_MSG = "msg";
    private static final String KEY_ONATTACHEDTOWINDOW = "onAttachedToWindow";
    private static final String KEY_ONDETACHEDFROMWINDOW = "onDetachedFromWindow";
    private static final String KEY_ORIENTATION = "orientation";
    private static final String KEY_OS_VERSION = "os_version";
    private static final String KEY_PAGEFINISHED = "pageFinished";
    private static final String KEY_PARAMAS = "params";
    private static final String KEY_POP_H5_URL = "pop_h5_url";
    private static final String KEY_PROTECT_NOTIFY_RESULT = "verify_protect_notify_result";
    private static final String KEY_PROTECT_RESULT = "verify_protect_result";
    private static final String KEY_PROTECT_START = "verify_protect_start";
    private static final String KEY_PTY_INIT_DATE = "turing_pty_init_date";
    private static final String KEY_PTY_INT = "pty_init";
    private static final String KEY_REPORT_NO_CAPTCHA_DATA = "report_no_captcha_data";
    private static final String KEY_REQUEST_PATH = "request_path";
    private static final String KEY_RESULT = "result";
    private static final String KEY_SEND_REQUEST_RETRY = "send_request_retry";
    private static final String KEY_SENSELESS_DIALOG_CLOSE = "senseless_dialog_close";
    private static final String KEY_SENSELESS_DIALOG_DISPLAY = "senseless_dialog_display";
    private static final String KEY_SENSELESS_REPORT_RESULT = "senseless_report_result";
    private static final String KEY_SENSELESS_REPORT_TIMEOUT = "senseless_report_timeout";
    private static final String KEY_SENSELESS_TRIGGER_SEC = "senseless_trigger_sec";
    private static final String KEY_SENSOR_COLLECT_START = "sensor_collect_start";
    private static final String KEY_SENSOR_DETAIL = "sensor_detail";
    private static final String KEY_SENSOR_STATE = "sensor_state";
    private static final String KEY_SETTING_REQUEST_DATE = "turing_setting_request_date";
    private static final String KEY_START_ACTIVITY = "start_activity";
    private static final String KEY_START_CREATE_SESSION = "turing_live_start_create_session";
    private static final String KEY_START_VERIFY = "verify_start";
    private static final String KEY_TOUCH_HOOK_FAIL = "touch_intercept_fail";
    private static final String KEY_TYPE = "type";
    private static final String KEY_UC_TWICE_VERIFY_RESULT = "uc_twice_verify_result";
    private static final String KEY_UC_TWICE_VERIFY_START = "uc_twice_verify_start";
    private static final String KEY_VERIFY_CANCELLABLE = "verify_cancellable";
    private static final String KEY_VERIFY_MODE = "mode";
    private static final String KEY_VERIFY_STATE = "turing_verify_state";
    private static final String KEY_VERIFY_USE_DIALOG_V2 = "verify_use_dialog_v2";
    private static final String KEY_WEB_LIVE_AVAILABLE = "live_h5_available";
    private static final String KEY_WEB_LOAD_FINISH = "web_load_finish";
    private static final String KE_H5_POPUP = "h5_popup";
    public static final String LOAD_WEBVIEW = "load_webview";
    public static final String LOGIN_VERIFY_RESULT = "login_result";
    public static final String LOGIN_VERIFY_START = "login_start";
    public static final String PRE_CREATE_LOAD_SUCCESS = "pre_create_load_success";
    public static final String PRE_CREATE_SUCCESS = "pre_create_success";
    private static final String RECEIVE_VERIFY_PARAMS = "verify_param_received";
    private static final String REQUEST_TYPE = "request_type";
    public static final String SCREEN_ORIENTATION = "orientation";
    public static final String SCREEN_ORIENTATION_CHANGE = "orientation_change";
    public static final String SDK_INIT = "init";
    private static final String SDK_STATE_ERROR = "sdk_sate_error";
    public static final String SETTING = "setting";
    private static final String SP_FILE_NAME = "turing_log_config";
    public static final String SYSTEM_TOO_LOW = "system_low";
    private static final String TAG = "EventReport";
    private static final String UC_VERIFY_PARAMS = "uc_twice_verify_received";
    private static final String VERIFY_CONFLICT = "verify_conflict";
    public static final String VERIFY_RESULT = "result";
    private static int callType = 0;
    private static boolean h5Popup = false;
    private static String mLogId = null;
    private static long mStartTime = 0;
    private static String mVerifyScene = null;
    private static String mVerifyType = null;
    private static int requestType = -1;
    public static long sAppLaunchTime;
    private static String verifySubType;
    private static Long verifyTypeCode;

    public static void resetLogInfo(AbstractRequest abstractRequest) {
        mLogId = abstractRequest != null ? abstractRequest.getLogId() : "";
        mVerifyType = abstractRequest != null ? abstractRequest.getVerifyType() : "";
        requestType = abstractRequest != null ? abstractRequest.getType() : -1;
        mVerifyScene = abstractRequest != null ? abstractRequest.getVerifyScene() : "";
        h5Popup = abstractRequest != null && abstractRequest.getH5PopUp();
        callType = abstractRequest != null ? abstractRequest.getCallType() : -1;
        verifySubType = abstractRequest != null ? abstractRequest.getVerifySubType() : "";
        verifyTypeCode = Long.valueOf(abstractRequest != null ? abstractRequest.getVerifyTypeCode() : 0L);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum CloseType {
        CLOSE_REASON_MASK("mask_click_close"),
        CLOSE_REASON_BACK("back_close"),
        CLOSE_REASON_APP("app_close"),
        CLOSE_REASON_PAGE_LOAD_FAILED("page_load_failed_close"),
        CLOSE_FB_MASK("close_fb_mask"),
        CLOSE_FB_CLOSE("close_fb_close"),
        CLOSE_FB_FEEDBACK("close_fb_feedback"),
        CLOSE_FB_SYSTEM("close_fb_system");

        private String name;

        CloseType(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void verifyStart(AbstractRequest abstractRequest) {
        mStartTime = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_START_VERIFY);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, AbstractRequest abstractRequest) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put("params_for_special", "turing");
            appendCommonParam(jSONObject, abstractRequest);
            BdTuringConfig config = BdTuring.getInstance().getConfig();
            EventClient eventClient = config != null ? config.getEventClient() : null;
            if (eventClient != null) {
                eventClient.onEvent(str, jSONObject);
            }
            if (LogUtil.isDebug()) {
                LogUtil.m160d("event", jSONObject.toString());
            }
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    private static void appendCommonParam(JSONObject jSONObject, AbstractRequest abstractRequest) {
        if (jSONObject == null) {
            return;
        }
        try {
            BdTuringConfig config = BdTuring.getInstance().getConfig();
            if (config != null) {
                jSONObject.put("sdk_version", "4.1.1.cn");
                jSONObject.put("host_app_id", config.getAppId());
            }
            jSONObject.put("is_back_ground", PageTracer.getInstance().isBackGround());
            jSONObject.put("app_first_launch", LiveAuthConfig.isAppFirstLaunch());
            if (sAppLaunchTime > 0) {
                jSONObject.put(KEY_APP_ALIVE_TIME, System.currentTimeMillis() - sAppLaunchTime);
            }
            String str = "1";
            if (!jSONObject.has(KEY_VERIFY_USE_DIALOG_V2)) {
                jSONObject.put(KEY_VERIFY_USE_DIALOG_V2, SettingsManager.INSTANCE.getVerifyUseDialogV2() ? "1" : "0");
            }
            if (!jSONObject.has(KEY_H5_LOAD_RETRY_ENABLE)) {
                jSONObject.put(KEY_H5_LOAD_RETRY_ENABLE, SettingsManager.INSTANCE.getH5loadRetryEnable() ? "1" : "0");
            }
            if (!jSONObject.has(KEY_VERIFY_CANCELLABLE)) {
                if (!SettingsManager.INSTANCE.getVerifyCancellable()) {
                    str = "0";
                }
                jSONObject.put(KEY_VERIFY_CANCELLABLE, str);
            }
            if (abstractRequest != null) {
                if (!jSONObject.has(KEY_LOGID)) {
                    jSONObject.put(KEY_LOGID, abstractRequest.getLogId());
                }
                jSONObject.put("mode", abstractRequest.getVerifyType());
                jSONObject.put(REQUEST_TYPE, abstractRequest.getType());
                jSONObject.put(KEY_CALL_TYPE, abstractRequest.getCallType());
                jSONObject.put(KE_H5_POPUP, abstractRequest.getH5PopUp());
                jSONObject.put("verify_scene", abstractRequest.getVerifyScene());
                jSONObject.put("verify_type_code", abstractRequest.getVerifyTypeCode());
                jSONObject.put("verify_sub_type", abstractRequest.getVerifySubType());
                if (abstractRequest.getType() == 16) {
                    jSONObject.put("engine_type", LiveDetectService.getInstance().useByteNN() ? "byteNN" : IClientFeatureService.INVOKE_SCENE_PITAYA);
                    return;
                }
                return;
            }
            if (!jSONObject.has(KEY_LOGID)) {
                jSONObject.put(KEY_LOGID, mLogId);
            }
            jSONObject.put("mode", mVerifyType);
            jSONObject.put(REQUEST_TYPE, requestType);
            jSONObject.put(KEY_CALL_TYPE, callType);
            jSONObject.put(KE_H5_POPUP, h5Popup);
            jSONObject.put("verify_scene", mVerifyScene);
            jSONObject.put("verify_type_code", verifyTypeCode);
            jSONObject.put("verify_sub_type", verifySubType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void statisticDialogPop(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", DIALOG_POP);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void statisticSdkInit(long j, BdTuringConfig bdTuringConfig) {
        if (isFirstInit()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", j);
                jSONObject.put("key", "init");
                if (bdTuringConfig != null) {
                    jSONObject.put("custom", bdTuringConfig.toString());
                }
                onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
            } catch (JSONException e) {
                LogUtil.printException(e);
            }
        }
    }

    private static boolean isFirstInit() {
        return isFirstTime(KEY_INIT_DATE);
    }

    private static boolean isFirstTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Context applicationContext = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getApplicationContext() : null;
            if (applicationContext == null) {
                return false;
            }
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(str, "");
            String format = new SimpleDateFormat(DateUtils.PATTERN_YEAR).format(new Date());
            LogUtil.m160d(TAG, "isFirstInit cacheDateStr=" + string + ":dateStr=" + format);
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

    public static void statisticDialogBackground(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", DIALOG_BACKGROUND);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
    }

    public static void statisticSetting(long j, int i) {
        if (isFirstSetting()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", j);
                jSONObject.put("result", i);
                jSONObject.put("key", SETTING);
                onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
            } catch (JSONException e) {
                LogUtil.printException(e);
            }
        }
    }

    private static boolean isFirstSetting() {
        return isFirstTime(KEY_SETTING_REQUEST_DATE);
    }

    public static void statisticPreCreateSuccess(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", j);
            jSONObject.put("key", PRE_CREATE_SUCCESS);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void statisticPreCreateLoadSuccess(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", j);
            jSONObject.put("key", PRE_CREATE_LOAD_SUCCESS);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void statisticCloseReason(CloseType closeType, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", System.currentTimeMillis() - mStartTime);
            jSONObject.put("result", closeType.getName());
            jSONObject.put("key", DIALOG_CLOSE);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void statisticSystemTooLow(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", SYSTEM_TOO_LOW);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void statisticLoadPage(int i, String str, int i2, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", System.currentTimeMillis() - mStartTime);
            jSONObject.put("result", i);
            jSONObject.put("custom", str);
            jSONObject.put("key", LOAD_WEBVIEW);
            jSONObject.put("hit_cache", i2);
            jSONObject.put(KEY_CACHE_SATE, ResourceManager.getInstance().getSate());
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void statisticVerifyResult(int i, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", System.currentTimeMillis() - mStartTime);
            jSONObject.put("result", i);
            jSONObject.put("key", "result");
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void statisticOrientation(int i, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            jSONObject.put("key", "orientation");
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void statisticOrientationChange(int i, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            jSONObject.put("key", SCREEN_ORIENTATION_CHANGE);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void identity_confirm_dialog_pop(int i, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_success", i);
            jSONObject.put("key", IDENTITY_VERIFY_CONFIRM_DIALOG_POP);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void identity_confirm_dialog_agree(int i, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            jSONObject.put("key", IDENTITY_VERIFY_CONFIRM_DIALOG_AGREE);
            jSONObject.put(KEY_VERIFY_USE_DIALOG_V2, SettingsManager.INSTANCE.getIdentityUseDialogV2() ? "1" : "0");
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void identity_load_cert_sdk(int i, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_success", i);
            jSONObject.put("key", IDENTITY_VERIFY_LOAD_CERT_SDK);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void identity_verify_result(boolean z, JSONObject jSONObject, AbstractRequest abstractRequest) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", z ? 0 : 1);
            jSONObject2.put("detail", jSONObject);
            jSONObject2.put("error_code", jSONObject != null ? jSONObject.optInt("error_code") : -1);
            jSONObject2.put("error_msg", jSONObject != null ? jSONObject.optString("error_msg", "") : "");
            jSONObject2.put("return_code", jSONObject != null ? jSONObject.optInt("return_code") : -1);
            JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("ext_data") : null;
            jSONObject2.put("is_finish", optJSONObject != null ? optJSONObject.optInt("is_finish") : -1);
            jSONObject2.put("all_module", optJSONObject != null ? optJSONObject.optString("all_module", "") : "");
            jSONObject2.put("req_order_no", optJSONObject != null ? optJSONObject.optString("req_order_no", "") : "");
            jSONObject2.put("ticket", optJSONObject != null ? optJSONObject.optString("ticket", "") : "");
            jSONObject2.put("name", optJSONObject != null ? optJSONObject.optString("name", "") : "");
            jSONObject2.put("idNumber", optJSONObject != null ? optJSONObject.optString("idNumber", "") : "");
            jSONObject2.put("mode", optJSONObject != null ? optJSONObject.optInt("mode") : -1);
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("error") : null;
            jSONObject2.put("message", optJSONObject2 != null ? optJSONObject2.optString("message", "") : null);
            JSONObject optJSONObject3 = optJSONObject != null ? optJSONObject.optJSONObject("state") : null;
            if (optJSONObject3 != null) {
                Iterator<String> keys = optJSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, optJSONObject3.opt(next));
                }
            }
            jSONObject2.put("key", IDENTITY_VERIFY_RESULT);
            onEvent(KEY_DEFAULT_EVENT, jSONObject2, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void loginVerifyStart(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getDeviceId() : "");
            jSONObject.put("key", LOGIN_VERIFY_START);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void loginVerifyResult(boolean z, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getDeviceId() : "");
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("key", LOGIN_VERIFY_RESULT);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void webViewDetachedFromWindow(boolean z, boolean z2, long j, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        int i = 1;
        try {
            jSONObject.put(KEY_PAGEFINISHED, z ? 1 : 0);
            if (!z2) {
                i = 0;
            }
            jSONObject.put(KEY_LOADFAIL, i);
            jSONObject.put("duration", j);
            jSONObject.put("key", KEY_ONDETACHEDFROMWINDOW);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void webViewOnAttachedToWindow(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_ONATTACHEDTOWINDOW);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void onVerifyParamReceive(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", RECEIVE_VERIFY_PARAMS);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void ucTwiceParamReceive(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", UC_VERIFY_PARAMS);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void verifyConflict(AbstractRequest abstractRequest, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", VERIFY_CONFLICT);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void sdkStateError(AbstractRequest abstractRequest, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", SDK_STATE_ERROR);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void verifyActivityOnCreate(String str, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("duration", System.currentTimeMillis() - mStartTime);
                jSONObject.put("key", str + "_onCreate");
            } catch (JSONException e) {
                LogUtil.printException(e);
                return;
            }
        }
        onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
    }

    public static void turingH5LoadResult(int i, long j, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", j);
            jSONObject.put("result", i);
            jSONObject.put("key", "turingH5LoadResult");
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void turingVerifyActivityOnDestroy(long j, String str, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("duration", j);
                jSONObject.put("key", str + "_onDestroy");
            } catch (JSONException e) {
                LogUtil.printException(e);
                return;
            }
        }
        onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
    }

    public static void webViewLoadFinish(boolean z, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_WEB_LOAD_FINISH);
            jSONObject.put("duration", System.currentTimeMillis() - mStartTime);
            jSONObject.put("result", z ? 1 : 0);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void initPTY(boolean z, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!BdTuring.class.getName().equals(str) || isFirstTime(KEY_PTY_INIT_DATE)) {
                jSONObject.put("key", KEY_PTY_INT);
                jSONObject.put("result", z ? 0 : 1);
                jSONObject.put("custom", str);
                onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
            }
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void createSession(boolean z, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CREATE_SESSION);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startCreateSession(String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_START_CREATE_SESSION);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("custom", str);
            }
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createSessionResult(boolean z, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CREATE_SESSION_RESULT);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void liveDialogState(int i, int i2, String str, String str2, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_DIALOG_STATE);
            jSONObject.put("custom", "type=" + i + ":state=" + i2 + ":scene=" + str + ":msg=" + str2);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void LiveRemoteVerifyResult(boolean z, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_REMOTE_RESULT);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void LiveLocalVerifyResult(boolean z, long j, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_LOCAL_RESULT);
            jSONObject.put("duration", j);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void LiveStartDetect(AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_START_DETECT);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void onLivePageCreate(String str, boolean z, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_DETECT_PAGE_DISPLAY);
            jSONObject.put("custom", str);
            jSONObject.put("result", z ? 0 : 1);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void onLivePageClose(String str, int i, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_DETECT_PAGE_CLOSE);
            jSONObject.put("custom", str);
            jSONObject.put("result", i);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void LiveCameraPermission(int i, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_DETECT_CAMERA_PERMISSION);
            jSONObject.put("result", i);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendDetectDetail(List<DetectRecord> list, boolean z, JSONObject jSONObject, AbstractRequest abstractRequest) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", KEY_LIVE_DETECT_FRAME_RESULTS);
                    JSONArray jSONArray = new JSONArray();
                    int i = 0;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        DetectRecord detectRecord = list.get(i2);
                        if (detectRecord != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("status", detectRecord.status);
                            jSONObject3.put("ts", detectRecord.f101ts);
                            jSONObject3.put("engineTime", detectRecord.engineTime);
                            jSONObject3.put("dataConvertTime", detectRecord.dataConvertTime);
                            jSONObject3.put("log", detectRecord.log);
                            jSONArray.put(jSONObject3);
                        }
                    }
                    jSONObject2.put("last_frame_result", jSONObject);
                    jSONObject2.put("result", jSONArray);
                    if (!z) {
                        i = 1;
                    }
                    jSONObject2.put("custom", i);
                    onEvent(KEY_DEFAULT_EVENT, jSONObject2, abstractRequest);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void agreementPageLoadResult(boolean z, long j, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_DETECT_AGREEMENT_LOAD_RESULT);
            jSONObject.put("duration", j);
            jSONObject.put("result", z ? 0 : 1);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void liveDetectStartBtnClick(boolean z, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_START_BTN_CLICK);
            jSONObject.put("result", z ? 1 : 0);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void liveDetectResult(int i, long j, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_DETECT_RESULT);
            jSONObject.put("result", i);
            jSONObject.put("duration", j);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void liveDetectError(int i, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_ERROR);
            jSONObject.put("result", i);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void liveCameraState(String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_CAMERA_STATE);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void byteNNInitResult(int i, AbstractRequest abstractRequest, long j, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", KEY_LIVE_ENGINE_INIT_RESULT);
            jSONObject2.put("result", i);
            jSONObject2.put("duration", j);
            jSONObject2.put("custom", jSONObject);
            onEvent(KEY_DEFAULT_EVENT, jSONObject2, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void preheatResult(boolean z, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_PREHEAT_RESULT);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void localCacheState(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CACHE_STATE);
            jSONObject.put("result", i);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifyProtectStart(String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_PROTECT_START);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifyProtectResult(int i, JSONObject jSONObject, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", KEY_PROTECT_RESULT);
            jSONObject2.put("result", i);
            jSONObject2.put("custom", jSONObject);
            onEvent(KEY_DEFAULT_EVENT, jSONObject2, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifyProtectNotify(int i, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_PROTECT_NOTIFY_RESULT);
            jSONObject.put("result", i);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ucTwiceVerifyStart(int i, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_UC_TWICE_VERIFY_START);
            jSONObject.put("result", i);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ucTwiceVerifyEnd(int i, JSONObject jSONObject, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", KEY_UC_TWICE_VERIFY_RESULT);
            jSONObject2.put("result", i);
            jSONObject2.put("custom", jSONObject);
            onEvent(KEY_DEFAULT_EVENT, jSONObject2, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sensorCollectStart(boolean z, boolean z2, boolean z3, double d, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_SENSOR_COLLECT_START);
            jSONObject.put("h5AccEnable", z);
            jSONObject.put("h5GyroEnable", z2);
            jSONObject.put("privacyPolicyAgree", z3);
            jSONObject.put("updateInterval", d);
            jSONObject.put("eventMaxNum", j);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sensorState(int i, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_SENSOR_STATE);
            jSONObject.put("type", i);
            jSONObject.put("result", z ? 0 : 1);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reportSensorDetail(int i, int i2, JSONObject jSONObject, int i3, int i4, JSONObject jSONObject2, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        boolean z;
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("key", KEY_SENSOR_DETAIL);
            StringBuilder sb = new StringBuilder("gryDataSize=");
            sb.append(i).append(":gryInitDataSize=").append(i2).append(":grySampleData=").append(jSONObject).append(":accDataSize=").append(i3).append(":accInitDataSize=").append(i4).append(":accSampleData=").append(jSONObject2);
            if (jSONArray != null && jSONArray.length() > 0) {
                sb.append(":gryAccuracy=").append(jSONArray);
            }
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                sb.append(":accAccuracy=").append(jSONArray2);
            }
            sb.append(":stateRecord=").append(jSONObject3).append(":accSateRecord=").append(jSONObject4).append(":gyroStateRecord=").append(jSONObject5);
            int i5 = 0;
            if (i <= 0 && i3 <= 0) {
                z = false;
                if (z) {
                    i5 = 1;
                }
                jSONObject6.put("result", i5);
                jSONObject6.put("custom", sb.toString());
                onEvent(KEY_DEFAULT_EVENT, jSONObject6, null);
            }
            z = true;
            if (z) {
            }
            jSONObject6.put("result", i5);
            jSONObject6.put("custom", sb.toString());
            onEvent(KEY_DEFAULT_EVENT, jSONObject6, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void liveDispatch(boolean z, String str, String str2, String str3, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_DISPATCH);
            jSONObject.put("custom", str + ":errorMessage=" + str3);
            jSONObject.put(KEY_LIVE_DISPATCH_TYPE, str2);
            jSONObject.put("result", z ? 0 : 1);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void liveAvailableCheck(boolean z, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_CHECK_RESULT);
            jSONObject.put("custom", str);
            jSONObject.put("result", z ? 0 : 1);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doVerify(boolean z, Object obj, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_DISPATCH_VERIFY);
            jSONObject.put("custom", obj != null ? obj.getClass().getName() : "");
            jSONObject.put("result", z ? 0 : 1);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void liveDispatchResult(boolean z, String str, String str2, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_DISPATCH_RESULT);
            jSONObject.put("custom", str2);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put(KEY_LIVE_DISPATCH_TYPE, str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void VerifyStateChange(boolean z, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_VERIFY_STATE);
            jSONObject.put("custom", str);
            jSONObject.put("result", z ? 0 : 1);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void confirmDialogShow(boolean z, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CONFIRM_DIALOG_DISPLAY);
            jSONObject.put("result", z ? 0 : 1);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void confirmDialogLoadSuccess(long j, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CONFIRM_DIALOG_LOAD_SUCCESS);
            jSONObject.put("duration", j);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void confirmDialogLoadFail(int i, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CONFIRM_DIALOG_LOAD_FAIL);
            jSONObject.put("custom", "errorCode:" + i + ";errorMessage:" + str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void confirmDialogError(int i, String str, String str2, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CONFIRM_DIALOG_ERROR);
            jSONObject.put("custom", "errorCode:" + i + ";errorMessage:" + str2 + ";url=" + str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void confirmResult(int i, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CONFIRM_RESULT);
            jSONObject.put("result", i);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void confirmDialogClose(int i, AbstractRequest abstractRequest, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_CONFIRM_DIALOG_CLOSE);
            jSONObject.put("result", i);
            jSONObject.put("custom", "url=" + str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commonWebShow(String str, String str2, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_COMMON_WEB_SHOW);
            jSONObject.put("custom", "title:" + str + ";url:" + str2);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commonWebLoadSuccess(long j, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_COMMON_WEB_LOAD_SUCCESS);
            jSONObject.put("duration", j);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commonWebError(int i, String str, String str2, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_COMMON_WEB_ERROR);
            jSONObject.put("custom", "errorCode:" + i + ";errorMessage:" + str2 + ";url=" + str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commonWebLoadFail(int i, String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_COMMON_WEB_LOAD_FAIL);
            jSONObject.put("custom", "errorCode:" + i + ";errorMessage:" + str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commonWebClose(String str, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_COMMON_WEB_CLOSE);
            jSONObject.put("custom", "webResult=" + str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void popH5Url(String str, String str2, AbstractRequest abstractRequest) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_POP_H5_URL);
            jSONObject.put("custom", "popupUrl:" + str + ";region:" + str2);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void finalVerifyResult(int i, JSONObject jSONObject, AbstractRequest abstractRequest) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("duration", System.currentTimeMillis() - mStartTime);
            jSONObject2.put("result", i);
            jSONObject2.put("key", FINAL_VERIFY_RESULT);
            jSONObject2.put("custom", jSONObject != null ? jSONObject.toString() : "");
            onEvent(KEY_DEFAULT_EVENT, jSONObject2, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void twiceVerifyStart(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", FINAL_TWICE_VERIFY_START);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void twiceVerifyResult(boolean z, JSONObject jSONObject, AbstractRequest abstractRequest) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("duration", System.currentTimeMillis() - mStartTime);
            jSONObject2.put("result", z ? 0 : 1);
            jSONObject2.put("key", FINAL_TWICE_VERIFY_RESULT);
            jSONObject2.put("custom", jSONObject != null ? jSONObject.toString() : "");
            onEvent(KEY_DEFAULT_EVENT, jSONObject2, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void senselessReportResult(AbstractRequest abstractRequest, int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            jSONObject.put("key", KEY_SENSELESS_REPORT_RESULT);
            jSONObject.put("type", str);
            StringBuilder sb = new StringBuilder("lifeCycleRegister result:");
            sb.append(TuringLifeCycleListener.getInstance().isInit()).append(";").append(str2);
            jSONObject.put("custom", sb.toString());
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void senselessReportTimeOut(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_SENSELESS_REPORT_TIMEOUT);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void verifyStateReportResult(boolean z, String str, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("key", KEY_CLIENT_STATUS_REPORT_RESULT);
            if (!TextUtils.isEmpty(str)) {
                if (str == null) {
                    str = "";
                }
                jSONObject.put("custom", str);
            }
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void senselessDialogDisplay(String str, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_SENSELESS_DIALOG_DISPLAY);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("custom", str);
            }
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void senselessDialogClose(int i, String str, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_SENSELESS_DIALOG_CLOSE);
            jSONObject.put("result", i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("custom", str);
            }
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void triggerSec(boolean z, String str, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_SENSELESS_TRIGGER_SEC);
            jSONObject.put("result", z ? 0 : 1);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("custom", str);
            }
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void hookTouchFail(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_TOUCH_HOOK_FAIL);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void reportNoCaptchaData(AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_REPORT_NO_CAPTCHA_DATA);
            jSONObject.put("custom", "tracer_init:" + PageTracer.getInstance().inited() + ";" + TuringLifeCycleListener.sInitTime);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void startActivity(boolean z, String str, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_START_ACTIVITY);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", str);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void sendRequestRetry(AbstractRequest abstractRequest, String str, int i, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_SEND_REQUEST_RETRY);
            StringBuilder sb = new StringBuilder("retry_num=");
            sb.append(i);
            if (!TextUtils.isEmpty(str3)) {
                sb.append(";errorMessage=").append(str3);
            }
            jSONObject.put(KEY_REQUEST_PATH, str);
            jSONObject.put("type", str2);
            jSONObject.put("custom", sb.toString());
            onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
        } catch (JSONException e) {
            LogUtil.printException(e);
        }
    }

    public static void webLiveRequestPermission(String str, String str2, boolean z, AbstractRequest abstractRequest) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_LIVE_H5_REQUEST_PERMISSION);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", "permission=" + str2 + ";url=" + str);
        } catch (Exception e) {
            LogUtil.printException(e);
        }
        onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
    }

    public static void webLiveAvailable(AbstractRequest abstractRequest, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", KEY_WEB_LIVE_AVAILABLE);
            jSONObject.put("duration", j);
        } catch (Exception e) {
            LogUtil.printException(e);
        }
        onEvent(KEY_DEFAULT_EVENT, jSONObject, abstractRequest);
    }

    public static void loadLiveMode(String str, boolean z, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_LOAD_MODEL);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", str);
            jSONObject.put("duration", j);
            jSONObject.put(KEY_MSG, str2);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void LoadByteNNPlugin(String str, boolean z, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", KEY_LIVE_LOAD_BYTENN_PLUGIN);
            jSONObject.put("result", z ? 0 : 1);
            jSONObject.put("custom", str);
            jSONObject.put("duration", j);
            jSONObject.put(KEY_MSG, str2);
            onEvent(KEY_DEFAULT_EVENT, jSONObject, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
