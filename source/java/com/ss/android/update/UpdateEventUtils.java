package com.ss.android.update;

import android.text.TextUtils;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.ss.android.update.UpdateDownloadHelper;
import com.vivo.push.PushClient;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateEventUtils {
    public static final int DEFAULT_BETA = -1;
    public static final String EVENT_APK_INSTALL_STATUS = "test_apk_install_status";
    public static final String EVENT_CHECK_IN_HOUSE_NET = "test_inhouse_network";
    public static final String EVENT_CHECK_PACKAGE_TYPE = "test_current_package_type";
    public static final String EVENT_CHECK_VERSION_V7_RESULT = "test_request_checkversion_v7";
    public static final String EVENT_CHECK_WHITE_LIST = "test_inhouse_wifi_list";
    public static final String EVENT_DOWNLOAD = "test_invitation_download";
    public static final String EVENT_FORMAL_TO_LOCAL_ENABLE = "test_settings_inhouse_switch";
    public static final String EVENT_LOCAL_INSTALLED = "test_is_local_installed";
    public static final String EVENT_LOCAL_TEST_ON_CHECK_UPDATE = "local_test_before_check_update";
    public static final String EVENT_NORMAL_UPDATE_ENABLE = "test_request_settings_normal_switch";
    public static final String EVENT_PACKAGE_DOWNLOAD_RESULT = "test_package_download_state";
    public static final String EVENT_POPUP_CLICK = "test_invitation_popup_click";
    public static final String EVENT_POPUP_CLOSE = "test_invitation_popup_close";
    public static final String EVENT_POPUP_DIALOG = "test_popup";
    public static final String EVENT_POPUP_NOT_SHOW = "test_invitation_popup_not_show";
    public static final String EVENT_POPUP_NOT_SHOW_REASON = "test_popup_not_show_reason";
    public static final String EVENT_POPUP_SHOW = "test_invitation_popup_show";
    private static final String EVENT_SIGN = "_event_v3";
    private static final String EVENT_V3_CATEGORY = "event_v3";
    public static final int INSTALL_ALPHA_DIALOG_ACTION_CANCEL = 2;
    public static final int INSTALL_ALPHA_DIALOG_ACTION_IGNORE = 5;
    public static final int INSTALL_ALPHA_DIALOG_ACTION_INSTALL = 3;
    public static final int INSTALL_ALPHA_DIALOG_ACTION_NEXT_TIME = 4;
    public static final int INSTALL_ALPHA_DIALOG_ACTION_NOT_SHOW = 6;
    public static final int INSTALL_ALPHA_DIALOG_ACTION_SHOW = 1;
    public static final int INSTALL_ALPHA_DIALOG_INSTALL_FAILED = 10;
    public static final int INSTALL_ALPHA_DIALOG_INSTALL_SUCCESS = 9;
    private static final String PARAMS_DIALOG_NOT_SHOW_REASON = "not_show_reason";
    private static final String PARAMS_DOWNLOAD_URL = "download_url";
    private static final String PARAMS_ERROR_MSG = "error_msg";
    private static final String PARAMS_INTRANET_GUIDE_SWITCH = "enable_intranet_guide";
    private static final String PARAMS_IN_HOUSE_NET_STATE = "inhouse_network";
    private static final String PARAMS_IS_ALPHA_UPDATE_BG_DOWNLOAD = "is_alpha_update_bg_dl";
    private static final String PARAMS_IS_BETA = "is_beta";
    private static final String PARAMS_IS_FORCE = "is_force";
    private static final String PARAMS_IS_LOCAL_APP = "is_local_app";
    private static final String PARAMS_IS_MONKEY = "is_monkey";
    private static final String PARAMS_LOCAL_INSTALLED = "is_local_installed";
    private static final String PARAMS_NORMAL_UPDATE_SWITCH = "enable_normal_popup";
    private static final String PARAMS_PACKAGE_DOWNLOAD_FAIL_REASON = "fail_reason_download";
    private static final String PARAMS_PACKAGE_DOWNLOAD_STATE = "package_download_state";
    private static final String PARAMS_PACKAGE_TYPE = "package_type";
    private static final String PARAMS_POPUP_ACTION = "popup_action";
    private static final String PARAMS_POPUP_TYPE = "popup_type_test";
    private static final String PARAMS_PRELOAD = "preload";
    private static final String PARAMS_REASON = "reason";
    private static final String PARAMS_RELEASE_SCENE = "release_scene";
    private static final String PARAMS_REQUEST_FAIL_REASON = "fail_reason_test";
    private static final String PARAMS_REQUEST_STATE = "request_state";
    private static final String PARAMS_SCENE_ID = "scene_id";
    private static final String PARAMS_SOURCE = "source";
    private static final String PARAMS_STATUS = "status";
    private static final String PARAMS_STRATEGY = "strategy";
    private static final String PARAMS_VERSION_TO = "version_to";
    private static final String PARAMS_WIFI_LIST_STATE = "inhouse_network_attr";
    private static final String PARAM_REAL_VERSION_CODE = "real_version_code";
    public static final String SOURCE_AUTO = "auto";
    public static final String SOURCE_TRIGGER = "trigger";
    private static final String TAG = "UpdateEventUtils";
    public static final int UPDATE_ALPHA_DIALOG_CANCEL_BUT_CLICK = 8;
    public static final int UPDATE_ALPHA_DIALOG_OK_BUT_CLICK = 7;
    private static String sIsMonkey;

    public static void popupEvent(String str, String str2, int i, String str3, int i2, boolean z) {
        IUpdateConfig config = UpdateSDK.getConfig();
        JSONObject jSONObject = new JSONObject();
        try {
            if (i2 >= 0) {
                jSONObject.put(PARAMS_IS_BETA, i2 + "");
            } else if (config != null) {
                jSONObject.put(PARAMS_IS_BETA, config.getUpdateConfig().isLocalApp() ? "0" : (UpdateHelper.getInstance().getOfficial() + 1) + "");
            }
            jSONObject.put("download_url", str2);
            jSONObject.put(PARAMS_VERSION_TO, i + "");
            jSONObject.put(PARAMS_SOURCE, str3);
            jSONObject.put(PARAMS_SCENE_ID, 1);
            jSONObject.put("_event_v3", 1);
            jSONObject.put(PARAMS_STRATEGY, UpdateStrategyManager.getInstance().isUpdateNewStrategyEnable() ? PushClient.DEFAULT_REQUEST_ID : "0");
            jSONObject.put("is_force", z ? PushClient.DEFAULT_REQUEST_ID : "0");
            jSONObject.put(UpdateHelper.KEY_RELEASE_RULE_ID, UpdateHelper.getInstance().getReleaseRuleId());
            jSONObject.put(UpdateHelper.KEY_STRATEGY_ID, UpdateHelper.getInstance().getStrategyId());
            jSONObject.put(PARAMS_RELEASE_SCENE, 0);
            jSONObject.put(PARAMS_IS_LOCAL_APP, getLocalAppParam());
            jSONObject.put("package_type", UpdateHelper.getInstance().getPackageType());
            jSONObject.put(PARAMS_IS_MONKEY, getIsMonkeyParam());
            jSONObject.put(PARAMS_POPUP_TYPE, getPopupTypeParam());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        useApplogServiceForEvent(str, jSONObject);
    }

    public static void downloadResultEvent(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(PARAMS_PACKAGE_DOWNLOAD_STATE, 0);
                jSONObject.put(PARAMS_PACKAGE_DOWNLOAD_FAIL_REASON, str);
            } else {
                jSONObject.put(PARAMS_PACKAGE_DOWNLOAD_STATE, 1);
            }
            jSONObject.put(PARAMS_SCENE_ID, 1);
            jSONObject.put("_event_v3", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        useApplogServiceForEvent(EVENT_PACKAGE_DOWNLOAD_RESULT, jSONObject);
    }

    public static void downloadEvent(String str, int i, boolean z, String str2, String str3) {
        UpdateDownloadHelper.DownloadExtraInfo extraInfo;
        IUpdateConfig config = UpdateSDK.getConfig();
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        if (config != null) {
            try {
                jSONObject.put(PARAMS_IS_BETA, config.getUpdateConfig().isLocalApp() ? "0" : (UpdateHelper.getInstance().getOfficial() + 1) + "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("download_url", str);
        jSONObject.put(PARAMS_VERSION_TO, i + "");
        jSONObject.put(PARAMS_PRELOAD, z ? PushClient.DEFAULT_REQUEST_ID : "0");
        jSONObject.put(PARAMS_SCENE_ID, 1);
        jSONObject.put("_event_v3", 1);
        jSONObject.put("status", str2);
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("error_msg", str3);
        }
        jSONObject.put(PARAMS_STRATEGY, UpdateStrategyManager.getInstance().isUpdateNewStrategyEnable() ? PushClient.DEFAULT_REQUEST_ID : "0");
        jSONObject.put(PARAMS_IS_LOCAL_APP, getLocalAppParam());
        jSONObject.put("package_type", UpdateHelper.getInstance().getPackageType());
        jSONObject.put(PARAMS_IS_MONKEY, getIsMonkeyParam());
        jSONObject.put(PARAMS_POPUP_TYPE, getPopupTypeParam());
        if (isLocalApp()) {
            jSONObject.put("real_version_code", UpdateHelper.getInstance().getRealVersionCode());
            if (UpdateHelper.getInstance().getDownloadHelper() != null && (extraInfo = UpdateHelper.getInstance().getDownloadHelper().getExtraInfo()) != null) {
                if (!extraInfo.isAlphaUpdateBgDownload) {
                    i2 = 0;
                }
                jSONObject.put(PARAMS_IS_ALPHA_UPDATE_BG_DOWNLOAD, i2);
            }
        }
        useApplogServiceForEvent(EVENT_DOWNLOAD, jSONObject);
    }

    public static void noShowDialogEvent(String str) {
        simpleNoShowDialogEvent(str);
        IUpdateConfig config = UpdateSDK.getConfig();
        JSONObject jSONObject = new JSONObject();
        if (config != null) {
            try {
                jSONObject.put(PARAMS_IS_BETA, config.getUpdateConfig().isLocalApp() ? "0" : (UpdateHelper.getInstance().getOfficial() + 1) + "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put(PARAMS_SCENE_ID, 1);
        jSONObject.put("_event_v3", 1);
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("reason", str);
        }
        jSONObject.put(PARAMS_STRATEGY, UpdateStrategyManager.getInstance().isUpdateNewStrategyEnable() ? PushClient.DEFAULT_REQUEST_ID : "0");
        jSONObject.put(PARAMS_IS_LOCAL_APP, getLocalAppParam());
        jSONObject.put("package_type", UpdateHelper.getInstance().getPackageType());
        jSONObject.put(PARAMS_IS_MONKEY, getIsMonkeyParam());
        jSONObject.put(PARAMS_POPUP_TYPE, getPopupTypeParam());
        useApplogServiceForEvent(EVENT_POPUP_NOT_SHOW, jSONObject);
    }

    private static void simpleNoShowDialogEvent(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAMS_SCENE_ID, 1);
            jSONObject.put("_event_v3", 1);
            jSONObject.put(PARAMS_DIALOG_NOT_SHOW_REASON, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        useApplogServiceForEvent(EVENT_POPUP_NOT_SHOW_REASON, jSONObject);
    }

    private static void commonReportMethod(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAMS_SCENE_ID, 1);
            jSONObject.put("_event_v3", 1);
            jSONObject.put(str2, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        useApplogServiceForEvent(str, jSONObject);
    }

    public static void reportPackageType(int i) {
        commonReportMethod(EVENT_CHECK_PACKAGE_TYPE, "package_type", i);
    }

    public static void reportLocalInstalled(int i) {
        commonReportMethod(EVENT_LOCAL_INSTALLED, PARAMS_LOCAL_INSTALLED, i);
    }

    public static void reportIntranetGuideState(int i) {
        commonReportMethod(EVENT_FORMAL_TO_LOCAL_ENABLE, PARAMS_INTRANET_GUIDE_SWITCH, i);
    }

    public static void reportNormalUpdateState(int i) {
        commonReportMethod(EVENT_NORMAL_UPDATE_ENABLE, PARAMS_NORMAL_UPDATE_SWITCH, i);
    }

    public static void reportWifiListState(int i) {
        commonReportMethod(EVENT_CHECK_WHITE_LIST, PARAMS_WIFI_LIST_STATE, i);
    }

    public static void reportInHouseNetState(int i) {
        commonReportMethod(EVENT_CHECK_IN_HOUSE_NET, PARAMS_IN_HOUSE_NET_STATE, i);
    }

    public static void popupDialogEvent(int i) {
        int popupType = UpdateHelper.getInstance().getPopupType();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAMS_SCENE_ID, 1);
            jSONObject.put("_event_v3", 1);
            jSONObject.put(PARAMS_POPUP_TYPE, popupType);
            jSONObject.put(PARAMS_POPUP_ACTION, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        useApplogServiceForEvent(EVENT_POPUP_DIALOG, jSONObject);
    }

    public static void checkVersionV7Event(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (i != -1) {
                jSONObject.put(PARAMS_REQUEST_STATE, 1);
                jSONObject.put(PARAMS_REQUEST_FAIL_REASON, i);
            } else {
                jSONObject.put(PARAMS_REQUEST_STATE, 0);
            }
            jSONObject.put(PARAMS_SCENE_ID, 1);
            jSONObject.put("_event_v3", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        useApplogServiceForEvent(EVENT_CHECK_VERSION_V7_RESULT, jSONObject);
    }

    private static void useApplogServiceForEvent(String str, JSONObject jSONObject) {
        EventReporter.onEvent(str, jSONObject);
    }

    public static void localTestOnCheckUpdateEvent() {
        if (isLocalApp()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PARAMS_SCENE_ID, 1);
                jSONObject.put("_event_v3", 1);
                jSONObject.put(PARAMS_IS_LOCAL_APP, getLocalAppParam());
                jSONObject.put(PARAMS_IS_MONKEY, getIsMonkeyParam());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            useApplogServiceForEvent(EVENT_LOCAL_TEST_ON_CHECK_UPDATE, jSONObject);
        }
    }

    public static void installStatusEvent(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAMS_SCENE_ID, 1);
            jSONObject.put("_event_v3", 1);
            jSONObject.put(PARAMS_IS_LOCAL_APP, getLocalAppParam());
            jSONObject.put("package_type", UpdateHelper.getInstance().getPackageType());
            jSONObject.put(PARAMS_IS_MONKEY, getIsMonkeyParam());
            jSONObject.put("status", String.valueOf(i));
            jSONObject.put(PARAMS_POPUP_TYPE, getPopupTypeParam());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("error_msg", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        useApplogServiceForEvent(EVENT_APK_INSTALL_STATUS, jSONObject);
    }

    private static String getLocalAppParam() {
        return isLocalApp() ? PushClient.DEFAULT_REQUEST_ID : "0";
    }

    private static boolean isLocalApp() {
        IUpdateConfig config = UpdateSDK.getConfig();
        if (config == null || config.getUpdateConfig() == null) {
            return false;
        }
        return config.getUpdateConfig().isLocalApp();
    }

    private static String getIsMonkeyParam() {
        if (sIsMonkey == null) {
            try {
                AppCommonContext appCommonContext = UpdateSDK.getAppCommonContext();
                sIsMonkey = new File((appCommonContext != null ? appCommonContext.getContext() : null).getExternalFilesDir(null).getParentFile(), "AutomationTestInfo.json").exists() ? PushClient.DEFAULT_REQUEST_ID : "0";
            } catch (Throwable unused) {
                sIsMonkey = "0";
            }
        }
        return sIsMonkey;
    }

    private static String getPopupTypeParam() {
        return String.valueOf(UpdateHelper.getInstance().getPopupType());
    }

    public static void alphaUpdateBgDownloadEvent(int i) {
        alphaUpdateBgDownloadEvent(i, null, null);
    }

    public static void alphaUpdateBgDownloadEvent(int i, String str) {
        alphaUpdateBgDownloadEvent(i, str, null);
    }

    public static void alphaUpdateBgDownloadEvent(int i, String str, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAMS_POPUP_ACTION, i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            jSONObject.put(PARAMS_IS_LOCAL_APP, getLocalAppParam());
            jSONObject.put("package_type", UpdateHelper.getInstance().getPackageType());
            jSONObject.put(PARAMS_IS_MONKEY, getIsMonkeyParam());
            jSONObject.put(PARAMS_POPUP_TYPE, getPopupTypeParam());
            jSONObject.put("real_version_code", UpdateHelper.getInstance().getRealVersionCode());
            if (map != null) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put(str2, str3);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        useApplogServiceForEvent("test_install_alpha_dialog_event", jSONObject);
        com.bytedance.common.utility.Logger.d("installAlphaDialogEvent:action" + i + ", reason=" + str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ParamsBuilder {
        private HashMap<String, String> map = new HashMap<>();

        private ParamsBuilder() {
        }

        public static ParamsBuilder begin() {
            return new ParamsBuilder();
        }

        public ParamsBuilder add(String str, String str2) {
            this.map.put(str, str2);
            return this;
        }

        public HashMap<String, String> end() {
            return this.map;
        }
    }
}
