package com.bytedance.push.settings.depths;

import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.push.BaseJson;
import com.bytedance.push.utils.Logger;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DepthsI18nSettingsModel extends BaseJson {
    public DepthsAccountConfig mDepthsAccountConfig;
    public DepthsInstrKaConfig mDepthsInstrKaConfig;
    public final String DEPTHS_ACCOUNT_CONFIG = "depths_account_config";
    public final String DEPTHS_INSTR_KA_CONFIG = "depths_instr_ka_config";
    public final String ENABLE = "enable";
    public final String POLL_FREQUENCY = "poll_frequency";
    public final String ACCOUNT_PROCESS = "account_process";
    public final String ENABLE_ACCOUNT_RETRY_ALIVE = "enable_account_retry_alive";
    public final String ACCOUNT_RETRY_INTERVAL = "account_retry_interval";
    public final String ONLY_RETRY_IN_BACKGROUND = "only_retry_in_background";
    public final long DEFAULT_POLL_FREQUENCY = 60000;

    /* loaded from: classes4.dex */
    public class DepthsAccountConfig {
        public String accountProcess;
        public boolean enableAccountRetryAlive;
        public boolean onlyRetryInBackground;
        public long pollFrequency;
        public long retryInterval;

        public DepthsAccountConfig() {
            this.pollFrequency = 60000L;
            this.accountProcess = ProcessEnum.UNKNOWN.processSuffix;
            this.enableAccountRetryAlive = false;
            this.onlyRetryInBackground = false;
            this.retryInterval = 0L;
        }

        public DepthsAccountConfig(JSONObject jSONObject) {
            this.pollFrequency = 60000L;
            this.accountProcess = ProcessEnum.UNKNOWN.processSuffix;
            this.enableAccountRetryAlive = false;
            this.onlyRetryInBackground = false;
            this.retryInterval = 0L;
            if (jSONObject != null) {
                try {
                    this.pollFrequency = jSONObject.optLong("poll_frequency", 60000L);
                    this.accountProcess = jSONObject.optString("account_process", ProcessEnum.UNKNOWN.processSuffix);
                    this.enableAccountRetryAlive = jSONObject.optBoolean("enable_account_retry_alive", false);
                    this.onlyRetryInBackground = jSONObject.optBoolean("only_retry_in_background", false);
                    this.retryInterval = jSONObject.optLong("account_retry_interval", 0L);
                } catch (Throwable th) {
                    Logger.e("AccountDepthsConfig", "error when init AccountDepthsConfig ", th);
                }
            }
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            DepthsI18nSettingsModel.this.add(jSONObject, "poll_frequency", this.pollFrequency);
            DepthsI18nSettingsModel.this.add(jSONObject, "account_process", this.accountProcess);
            DepthsI18nSettingsModel.this.add(jSONObject, "enable_account_retry_alive", this.enableAccountRetryAlive);
            DepthsI18nSettingsModel.this.add(jSONObject, "account_retry_interval", this.retryInterval);
            DepthsI18nSettingsModel.this.add(jSONObject, "only_retry_in_background", this.onlyRetryInBackground);
            return jSONObject.toString();
        }
    }

    /* loaded from: classes4.dex */
    public class DepthsInstrKaConfig {
        public boolean enable;

        public DepthsInstrKaConfig() {
        }

        public DepthsInstrKaConfig(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.enable = jSONObject.optBoolean("enable", false);
                } catch (Throwable th) {
                    Logger.e("InstrKaDepthsConfig", "error when init AccountDepthsConfig ", th);
                }
            }
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            DepthsI18nSettingsModel.this.add(jSONObject, "enable", this.enable);
            return jSONObject.toString();
        }
    }

    public DepthsI18nSettingsModel() {
        init();
    }

    public DepthsI18nSettingsModel(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mDepthsAccountConfig = new DepthsAccountConfig(jSONObject.optJSONObject("depths_account_config"));
            this.mDepthsInstrKaConfig = new DepthsInstrKaConfig(jSONObject.optJSONObject("depths_instr_ka_config"));
        } catch (Throwable unused) {
            init();
        }
    }

    private void init() {
        this.mDepthsAccountConfig = new DepthsAccountConfig();
        this.mDepthsInstrKaConfig = new DepthsInstrKaConfig();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "depths_account_config", this.mDepthsAccountConfig.toString());
        return jSONObject.toString();
    }
}
