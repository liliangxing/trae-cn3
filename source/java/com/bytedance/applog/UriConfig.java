package com.bytedance.applog;

import com.bytedance.applog.util.UriConstants;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallUrl;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes3.dex */
public class UriConfig {
    public static final String PATH_AB = "/service/2/abtest_config/";
    public static final String PATH_CONFIG = "/service/2/log_settings/";
    public static final String PATH_MONITOR = "/service/2/app_log_monitor/";
    public static final String PATH_SEND = "/service/2/app_log/";
    private static boolean optMultiUri;
    private static boolean sSendPathOverrideMonitorPath;
    private final Map<String, String> mCommonHttpHeaders;
    private final Env mInstallEnv;
    private final String mMonitorUri;
    private final String[] mRealUris;
    private final String[] mSendUris;
    private final String mSettingUri;

    public static void setOptMultiUri(boolean z) {
        optMultiUri = z;
    }

    public static void setMonitorPathOverrideBySendPath(boolean z) {
        sSendPathOverrideMonitorPath = z;
    }

    public static String getMonitorPath() {
        return sSendPathOverrideMonitorPath ? "/service/2/app_log/" : PATH_MONITOR;
    }

    private UriConfig(Builder builder) {
        this.mInstallEnv = builder.mInstallEnv;
        this.mSendUris = builder.mSendUris;
        this.mRealUris = builder.mRealUris;
        this.mSettingUri = builder.mSettingUri;
        this.mMonitorUri = builder.mMonitorUri;
        this.mCommonHttpHeaders = builder.mCommonHttpHeaders;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private Map<String, String> mCommonHttpHeaders = null;
        private Env mInstallEnv;
        private String mMonitorUri;
        private String[] mRealUris;
        private String[] mSendUris;
        private String mSettingUri;

        public Builder setInstallEnv(Env env) {
            this.mInstallEnv = env;
            return this;
        }

        public Builder setSendUris(String[] strArr) {
            if (UriConfig.optMultiUri) {
                this.mSendUris = (String[]) new HashSet(Arrays.asList(strArr)).toArray(new String[0]);
            } else {
                this.mSendUris = strArr;
            }
            return this;
        }

        public Builder setRealUris(String[] strArr) {
            if (UriConfig.optMultiUri) {
                this.mRealUris = (String[]) new HashSet(Arrays.asList(strArr)).toArray(new String[0]);
            } else {
                this.mRealUris = strArr;
            }
            return this;
        }

        public Builder setSettingUri(String str) {
            this.mSettingUri = str;
            return this;
        }

        public Builder setMonitor(String str) {
            this.mMonitorUri = str;
            return this;
        }

        public Builder setCommonHttpHeaders(Map<String, String> map) {
            this.mCommonHttpHeaders = map;
            return this;
        }

        public UriConfig build() {
            return new UriConfig(this);
        }
    }

    public Env getInstallEnv() {
        return this.mInstallEnv;
    }

    public String[] getSendUris() {
        return this.mSendUris;
    }

    public String[] getRealUris() {
        return this.mRealUris;
    }

    public String getSettingUri() {
        return this.mSettingUri;
    }

    public String getMonitorUri() {
        return this.mMonitorUri;
    }

    public Map<String, String> getCommonHttpHeaders() {
        return this.mCommonHttpHeaders;
    }

    public static UriConfig createUriConfig(int i) {
        return UriConstants.createUriConfig(i);
    }

    public static UriConfig createByDomain(String str, String[] strArr) {
        return createByDomain(str, strArr, false, false);
    }

    public static UriConfig createByDomain(String str, String[] strArr, boolean z, boolean z2) {
        return createByDomain(str, strArr, false, z2, null);
    }

    public static UriConfig createByDomain(String str, String[] strArr, boolean z, boolean z2, Map<String, String> map) {
        Builder builder = new Builder();
        builder.setInstallEnv(new Env(InstallUrl.createUriByDomain(str), z, z2));
        if (strArr == null || strArr.length == 0) {
            builder.setSendUris(new String[]{str + "/service/2/app_log/"});
        } else {
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            strArr2[0] = str + "/service/2/app_log/";
            for (int i = 1; i < length; i++) {
                strArr2[i] = strArr[i - 1] + "/service/2/app_log/";
            }
            builder.setSendUris(strArr2);
        }
        builder.setMonitor(str + getMonitorPath());
        builder.setSettingUri(str + "/service/2/log_settings/");
        builder.setCommonHttpHeaders(map);
        return builder.build();
    }
}
