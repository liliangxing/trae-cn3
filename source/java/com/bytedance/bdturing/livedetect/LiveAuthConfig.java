package com.bytedance.bdturing.livedetect;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.domain.UrlBuilder;
import com.bytedance.bdturing.live.Config;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.utils.SPUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LiveAuthConfig {
    private static final String APP_LAUNCH_STATE = "app_lunch_state";
    private static final long DEFAULT_TIME_OUT = 10000;
    private static final String DETECT_CANCELLABLE = "1";
    public static String DETECT_MODEL_MD5 = "detect_md5";
    private static final String HTTPS_SCHEME = "https://";
    public static String KPT_MODEL_MD5 = "kpt_md5";
    private static final String PATH_LIVE_AGREEMENT = "auth/live/agreement";
    private static final String PATH_LIVE_DISPATCH = "live_dispatch";
    private static final String PATH_LIVE_DISPATCH_NOTIFY = "live_dispatch_notify";
    private static final String PATH_LIVE_GET = "auth/live/get";
    private static final String PATH_LIVE_VERIFY = "auth/live/verify";
    public static final String SP_FILE_NAME = "turing_live_detect_cfg";
    private static final String STATE_APP_LAUNCHED = "1";
    private static Boolean mIsFirstLaunch;
    public static boolean mPtyHostEnable;

    public static String getLiveHost() {
        String host = SettingsManager.INSTANCE.getHost(SettingsManager.AUTH_SERVICE);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(host)) {
            if (!host.startsWith("https://")) {
                sb.append("https://");
            }
            sb.append(host);
            if (!host.endsWith("/")) {
                sb.append("/");
            }
        }
        return sb.toString();
    }

    public static String getAgreementH5Url() {
        String settingConfig = SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "agreement_url");
        if (TextUtils.isEmpty(settingConfig)) {
            settingConfig = "";
        }
        StringBuilder sb = new StringBuilder(settingConfig);
        sb.append("?os_type=0");
        UrlBuilder.INSTANCE.appendCommon(null, sb);
        return sb.toString();
    }

    public static String getAgreementTitle() {
        return SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "agreement_title");
    }

    public static String getHelpH5Url() {
        String settingConfig = SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "help_url");
        if (settingConfig == null) {
            settingConfig = "";
        }
        StringBuilder sb = new StringBuilder(settingConfig);
        sb.append("?os_type=0");
        UrlBuilder.INSTANCE.appendCommon(null, sb);
        return sb.toString();
    }

    public static String getAgreementVersion() {
        String settingConfig = SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "agreement_version");
        return settingConfig != null ? settingConfig : "";
    }

    public static String getLiveAgreementUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLiveHost()).append(PATH_LIVE_AGREEMENT);
        return sb.toString();
    }

    public static String getLiveGetUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLiveHost()).append(PATH_LIVE_GET);
        return sb.toString();
    }

    public static String getLiveVerifyUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLiveHost()).append(PATH_LIVE_VERIFY);
        return sb.toString();
    }

    public static String getLiveDispatchUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLiveHost()).append(PATH_LIVE_DISPATCH);
        return sb.toString();
    }

    public static String getPathLiveDispatchNotify() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLiveHost()).append(PATH_LIVE_DISPATCH_NOTIFY);
        return sb.toString();
    }

    public static boolean liveDetectCancellable() {
        String settingConfig = SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "cancellable");
        if (TextUtils.isEmpty(settingConfig)) {
            settingConfig = "1";
        }
        return "1".equals(settingConfig);
    }

    public static long liveDetectTimeOut() {
        long j;
        try {
            j = Long.parseLong(SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "timeout"));
        } catch (Exception e) {
            e.printStackTrace();
            j = 0;
        }
        if (j > 0) {
            return j;
        }
        return 10000L;
    }

    private static boolean queryAppLaunchState() {
        boolean z = false;
        try {
            BdTuringConfig config = BdTuring.getInstance().getConfig();
            if (config != null && config.getApplicationContext() != null && (!"1".equals(SPUtil.getString(config.getApplicationContext(), SP_FILE_NAME, APP_LAUNCH_STATE, "")))) {
                SPUtil.puString(config.getApplicationContext(), SP_FILE_NAME, APP_LAUNCH_STATE, "1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public static boolean isAppFirstLaunch() {
        Boolean bool = mIsFirstLaunch;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(queryAppLaunchState());
        mIsFirstLaunch = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean useByteNN() {
        String settingConfig = SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "use_bytenn");
        return !TextUtils.isEmpty(settingConfig) && "1".equals(settingConfig);
    }

    public static boolean liveDispatchEnable() {
        String settingConfig = SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "live_dispatch_enable");
        return !TextUtils.isEmpty(settingConfig) && "1".equals(settingConfig);
    }

    private static JSONObject modelCfg() {
        String settingConfig = SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "model");
        if (!TextUtils.isEmpty(settingConfig)) {
            try {
                return new JSONObject(settingConfig);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String liveModelUrl(int i) {
        JSONArray optJSONArray;
        int max = Math.max(0, i);
        JSONObject modelCfg = modelCfg();
        if (modelCfg == null || (optJSONArray = modelCfg.optJSONArray("url_list")) == null || optJSONArray.length() <= 0) {
            return null;
        }
        return optJSONArray.optString(max % optJSONArray.length());
    }

    public static String modelFileMd5(String str) {
        JSONObject modelCfg;
        if (TextUtils.isEmpty(str) || (modelCfg = modelCfg()) == null) {
            return null;
        }
        return modelCfg.optString(str, "").toLowerCase();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Config modelConfig() {
        Config config;
        String settingConfig = SettingsManager.INSTANCE.getSettingConfig(SettingsManager.AUTH_SERVICE, "model_threshold");
        Config config2 = null;
        if (!TextUtils.isEmpty(settingConfig)) {
            try {
                config = new Config(new JSONObject(settingConfig));
            } catch (Exception e) {
                e = e;
            }
            try {
                config.kpt_model_path = LiveModelResManager.getInstance().kptModelPath();
                config.detect_model_path = LiveModelResManager.getInstance().detectModelPath();
                config2 = config;
            } catch (Exception e2) {
                e = e2;
                config2 = config;
                e.printStackTrace();
                if (config2 == null) {
                }
            }
        }
        if (config2 == null) {
            return config2;
        }
        Config config3 = new Config();
        config3.detect_model_path = LiveModelResManager.getInstance().detectModelPath();
        config3.kpt_model_path = LiveModelResManager.getInstance().kptModelPath();
        return config3;
    }
}
