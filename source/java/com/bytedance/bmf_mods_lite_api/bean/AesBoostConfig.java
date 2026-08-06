package com.bytedance.bmf_mods_lite_api.bean;

import android.text.TextUtils;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;
import com.heytap.mcssdk.constant.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AesBoostConfig {
    private int downsample;
    private int[] groupIds;
    private String modelNamePrefix;
    private final Map<String, String> paramMap;

    private AesBoostConfig(Map<String, String> map) {
        this.modelNamePrefix = "";
        this.downsample = 1;
        this.paramMap = map;
    }

    public Map<String, String> getParamMap() {
        return this.paramMap;
    }

    public String getModelNamePrefix() {
        return this.modelNamePrefix;
    }

    public int[] getGroupIds() {
        return this.groupIds;
    }

    public int getDownsample() {
        return this.downsample;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{ modelNamePrefix: ");
        sb.append(this.modelNamePrefix);
        sb.append(", groupIds: ").append(Arrays.toString(this.groupIds));
        sb.append(", downsample: ").append(this.downsample);
        sb.append(", host: ").append(this.paramMap.get("host"));
        sb.append(", accessKey: ").append(this.paramMap.get("accessKey"));
        sb.append(", deviceId: ").append(this.paramMap.get("deviceId"));
        sb.append(", appVersion: ").append(this.paramMap.get("appVersion"));
        sb.append(", appID: ").append(this.paramMap.get(b.u));
        sb.append(", platformSdkVersion: ").append(this.paramMap.get("platformSdkVersion"));
        sb.append(" }");
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private int[] groupIds;
        private final Map<String, String> paramMap = new HashMap();
        private String modelNamePrefix = "";
        private int downsample = 1;

        public Builder setHostAndAccessKey(String host, String accessKey) {
            this.paramMap.put("host", host);
            this.paramMap.put("accessKey", accessKey);
            return this;
        }

        public Builder setDeviceId(String deviceId) {
            this.paramMap.put("deviceId", deviceId);
            return this;
        }

        public Builder setAppVersion(String appVersion) {
            this.paramMap.put("appVersion", appVersion);
            return this;
        }

        public Builder setAppId(String appId) {
            this.paramMap.put(b.u, appId);
            return this;
        }

        public Builder setPlatformSdkVersion(String platformSdkVersion) {
            this.paramMap.put("platformSdkVersion", platformSdkVersion);
            return this;
        }

        public Builder setModelNamePrefix(String modelNamePrefix) {
            this.modelNamePrefix = modelNamePrefix;
            return this;
        }

        public Builder setGroupIds(int[] groupIds) {
            this.groupIds = groupIds;
            return this;
        }

        public Builder setDownsample(int downsample) {
            this.downsample = downsample;
            return this;
        }

        public AesBoostConfig build() throws BmfException {
            if (!this.paramMap.containsKey("host") || !this.paramMap.containsKey("accessKey") || TextUtils.isEmpty(this.paramMap.get("host")) || TextUtils.isEmpty(this.paramMap.get("accessKey"))) {
                throw new BmfException(-100020, "host or accessKey is null");
            }
            int[] iArr = this.groupIds;
            if (iArr == null || iArr.length == 0) {
                throw new BmfException(-100020, "groupIds is null");
            }
            String str = this.modelNamePrefix;
            if (str == null || str.isEmpty()) {
                throw new BmfException(-100020, "modelNamePrefix is null");
            }
            AesBoostConfig aesBoostConfig = new AesBoostConfig(this.paramMap);
            aesBoostConfig.modelNamePrefix = this.modelNamePrefix;
            aesBoostConfig.groupIds = this.groupIds;
            aesBoostConfig.downsample = this.downsample;
            return aesBoostConfig;
        }
    }
}
