package com.bytedance.sdk.account.platform.onekey;

import com.bytedance.account.OneKeyLoginKey;
import com.bytedance.account.TestOneKeyLoginKey;
import com.bytedance.common.utility.Logger;

/* loaded from: classes5.dex */
public class OnekeyLoginConfig {
    public static final long OVER_TIME = 4000;
    private CMSettingConfig mCMSettingConfig;
    private CTSettingConfig mCTSettingConfig;
    private CUSettingConfig mCUSettingConfig;
    private final IOnekeyMonitor mMonitor;

    public OnekeyLoginConfig(IOnekeyMonitor iOnekeyMonitor) {
        this.mMonitor = iOnekeyMonitor;
    }

    public OnekeyLoginConfig getDefault(boolean z) {
        try {
            if (z) {
                if (this.mCMSettingConfig == null) {
                    this.mCMSettingConfig = new CMSettingConfig(TestOneKeyLoginKey.CM_APP_KEY, TestOneKeyLoginKey.CM_APP_SECRET);
                }
                if (this.mCTSettingConfig == null) {
                    this.mCTSettingConfig = new CTSettingConfig(TestOneKeyLoginKey.CT_APP_KEY, TestOneKeyLoginKey.CT_APP_SECRET);
                }
                if (this.mCUSettingConfig == null) {
                    this.mCUSettingConfig = new CUSettingConfig(TestOneKeyLoginKey.CU_APP_KEY, TestOneKeyLoginKey.CU_APP_SECRET);
                }
            } else {
                if (this.mCMSettingConfig == null) {
                    this.mCMSettingConfig = new CMSettingConfig(OneKeyLoginKey.CM_APP_KEY, OneKeyLoginKey.CM_APP_SECRET);
                }
                if (this.mCTSettingConfig == null) {
                    this.mCTSettingConfig = new CTSettingConfig(OneKeyLoginKey.CT_APP_KEY, OneKeyLoginKey.CT_APP_SECRET);
                }
                if (this.mCUSettingConfig == null) {
                    this.mCUSettingConfig = new CUSettingConfig(OneKeyLoginKey.CU_APP_KEY, OneKeyLoginKey.CU_APP_SECRET);
                }
            }
        } catch (Throwable unused) {
            Logger.d("OnekeyLoginConfig", " auto set config fail");
        }
        return this;
    }

    public OnekeyLoginConfig setCTSetting(String str, String str2) {
        this.mCTSettingConfig = new CTSettingConfig(str, str2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IOnekeyMonitor getMonitor() {
        return this.mMonitor;
    }

    public OnekeyLoginConfig setCMSetting(String str, String str2) {
        this.mCMSettingConfig = new CMSettingConfig(str, str2);
        return this;
    }

    public OnekeyLoginConfig setCUSetting(String str, String str2) {
        this.mCUSettingConfig = new CUSettingConfig(str, str2);
        return this;
    }

    public CTSettingConfig getCTSettingConfig() {
        return this.mCTSettingConfig;
    }

    public CMSettingConfig getCMSettingConfig() {
        return this.mCMSettingConfig;
    }

    public CUSettingConfig getCUSettingConfig() {
        return this.mCUSettingConfig;
    }

    /* loaded from: classes5.dex */
    public static class CMSettingConfig {
        public String mCMAppId;
        public String mCMAppKey;
        public long mOverTime;

        public CMSettingConfig(String str, String str2) {
            this.mCMAppId = str;
            this.mCMAppKey = str2;
        }
    }

    /* loaded from: classes5.dex */
    public static class CTSettingConfig {
        public String mCTAppKey;
        public String mCTAppSecret;
        private boolean mIsShowLog;
        private String mLogTag;

        public CTSettingConfig(String str, String str2) {
            this.mCTAppKey = str;
            this.mCTAppSecret = str2;
        }

        public boolean isShowLog() {
            return this.mIsShowLog;
        }

        public void setShowLog(boolean z) {
            this.mIsShowLog = z;
        }

        public String getLogTag() {
            return this.mLogTag;
        }

        public void setLogTag(String str) {
            this.mLogTag = str;
        }
    }

    /* loaded from: classes5.dex */
    public static class CUSettingConfig {
        public String mCUAppId;
        public String mCUAppSecret;

        public CUSettingConfig(String str, String str2) {
            this.mCUAppId = str;
            this.mCUAppSecret = str2;
        }
    }
}
