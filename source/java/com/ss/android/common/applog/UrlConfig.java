package com.ss.android.common.applog;

/* loaded from: classes7.dex */
public class UrlConfig {
    public static final UrlConfig CHINA;
    public static final String CHINA_BACKUP_HOST_LOG = "applog.zijieapi.com";
    public static final String CHINA_HOST_ACTIVE = "ichannel.snssdk.com";
    public static final String CHINA_HOST_DEVICE = "log.snssdk.com";
    public static final String CHINA_HOST_LOG = "log.zijieapi.com";
    public static final String CHINA_HOST_LOG_SETTINGS = "log.zijieapi.com";
    public static final String CHINA_HOST_TIMELY = "rtlog.zijieapi.com";
    public static final String CHINA_USER_PROFILE = "dpprofile.snssdk.com";
    public static final UrlConfig DEFAULT;
    public static final String HTTPS = "https://";
    public static final String PATH_ACTIVE = "/service/2/app_alert_check/";
    public static final String PATH_APP_LOG = "/service/2/app_log/";
    public static final String PATH_DEVICE_REGISTER = "/service/2/device_register/";
    public static final String PATH_LOG_SETTINGS = "/service/2/log_settings/";
    public static final String URL_EVENT_VERIFY = "https://data.bytedance.net/et_api/logview/android_sdk_verify/";
    final String[] mAppActiveUrl;
    final String[] mApplogFallbackUrl;
    final String mApplogSettingsFallbackUrl;
    final String mApplogSettingsUrl;
    final String[] mApplogTimelyUrl;
    final String[] mApplogURL;
    final String[] mDeviceRegisterUrl;
    final String mUserProfileUrl;

    static {
        UrlConfig urlConfig = new UrlConfig(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}, new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}, new String[]{"https://log.snssdk.com/service/2/device_register/", "https://log.snssdk.com/service/2/device_register/"}, new String[]{"https://ichannel.snssdk.com/service/2/app_alert_check/"}, "https://log.zijieapi.com/service/2/log_settings/", new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}, "https://log.zijieapi.com/service/2/log_settings/", "https://dpprofile.snssdk.com");
        CHINA = urlConfig;
        DEFAULT = urlConfig;
    }

    public UrlConfig(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String str, String[] strArr5, String str2, String str3) {
        this.mApplogURL = strArr;
        this.mApplogSettingsUrl = str;
        this.mApplogTimelyUrl = strArr2;
        this.mAppActiveUrl = strArr4;
        this.mDeviceRegisterUrl = strArr3;
        this.mApplogFallbackUrl = strArr5;
        this.mApplogSettingsFallbackUrl = str2;
        this.mUserProfileUrl = str3;
    }

    public UrlConfig(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, String[] strArr4, String str3, String str4) {
        this.mApplogURL = strArr;
        this.mApplogSettingsUrl = str2;
        this.mApplogTimelyUrl = strArr2;
        this.mAppActiveUrl = new String[]{str};
        this.mDeviceRegisterUrl = strArr3;
        this.mApplogFallbackUrl = strArr4;
        this.mApplogSettingsFallbackUrl = str3;
        this.mUserProfileUrl = str4;
    }

    public String toString() {
        return super.toString() + ":\nmApplogURL : " + this.mApplogURL + "\nmApplogTimelyUrl : " + this.mApplogTimelyUrl + "\nmDeviceRegisterUrl : " + this.mDeviceRegisterUrl + "\nmAppActiveUrl : " + this.mAppActiveUrl + "\nmApplogSettingsUrl : " + this.mApplogSettingsUrl + "\n\nmApplogFallbackUrl : " + this.mApplogFallbackUrl + "\nmApplogSettingsFallbackUrl : " + this.mApplogSettingsFallbackUrl + "\nmUserProfileUrl : " + this.mUserProfileUrl + "\n\n\n\n";
    }
}
