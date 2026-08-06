package com.bytedance.geckox.settings.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GlobalConfigSettings {

    @SerializedName("req_meta")
    private ReqMeta reqMeta;

    @SerializedName("resource_meta")
    private ResourceMeta resourceMeta;

    @SerializedName("settings_config")
    private SettingsConfig settingsConfig;

    @SerializedName("version")
    private String version;

    public String getVersion() {
        return this.version;
    }

    public ResourceMeta getResourceMeta() {
        return this.resourceMeta;
    }

    public ReqMeta getReqMeta() {
        return this.reqMeta;
    }

    public void setReqMeta(ReqMeta reqMeta) {
        this.reqMeta = reqMeta;
    }

    public SettingsConfig getSettingsConfig() {
        return this.settingsConfig;
    }

    /* loaded from: classes3.dex */
    public static class SettingsConfig {

        @SerializedName("polling_interval")
        private long polling_interval;

        public long getPollingInterval() {
            return this.polling_interval;
        }
    }

    /* loaded from: classes3.dex */
    public static class ResourceMeta {

        @SerializedName("access_keys")
        private Map<String, AccessKeyMetaInfo> accessKeys;

        @SerializedName("config")
        private CurrentLevelConfig config;

        public Map<String, AccessKeyMetaInfo> getAccessKeys() {
            return this.accessKeys;
        }

        public void setAccessKeys(Map<String, AccessKeyMetaInfo> map) {
            this.accessKeys = map;
        }

        public CurrentLevelConfig getConfig() {
            return this.config;
        }
    }

    /* loaded from: classes3.dex */
    public static class AccessKeyMetaInfo {

        @SerializedName("channels")
        private Map<String, ChannelMetaInfo> channels;

        @SerializedName("config")
        private CurrentLevelConfig config;

        public Map<String, ChannelMetaInfo> getChannels() {
            return this.channels;
        }

        public CurrentLevelConfig getConfig() {
            return this.config;
        }
    }

    /* loaded from: classes3.dex */
    public static class CDNMultiVersion {

        @SerializedName("domains")
        private List<String> domains;

        public List<String> getDomains() {
            return this.domains;
        }
    }

    /* loaded from: classes3.dex */
    public static class ChannelMetaInfo {

        @SerializedName("config")
        private CurrentLevelConfig config;

        public CurrentLevelConfig getConfig() {
            return this.config;
        }
    }

    /* loaded from: classes3.dex */
    public static class CurrentLevelConfig {

        @SerializedName("cdn_fallback")
        private CDNFallBackConfig cdnFallback;

        @SerializedName("cdn_multi_version")
        private CDNMultiVersion cdnMultiVersion;

        @SerializedName("pipeline")
        private List<PipelineStep> pipeline;

        @SerializedName("prefix_2_ak")
        private Map<String, String> prefix2AccessKey;

        public List<PipelineStep> getPipeline() {
            return this.pipeline;
        }

        public CDNFallBackConfig getCdnFallback() {
            return this.cdnFallback;
        }

        public CDNMultiVersion getCDNMultiVersion() {
            return this.cdnMultiVersion;
        }

        public Map<String, String> getPrefix2AccessKey() {
            return this.prefix2AccessKey;
        }
    }

    /* loaded from: classes3.dex */
    public static class CDNFallBackConfig {

        @SerializedName("domains")
        private List<String> domains;

        @SerializedName("max_attempts")
        private int maxAttempts;

        @SerializedName("shuffle")
        private int shuffle;

        public List<String> getDomains() {
            return this.domains;
        }

        public int getMaxAttempts() {
            return this.maxAttempts;
        }

        public int getShuffle() {
            return this.shuffle;
        }
    }

    /* loaded from: classes3.dex */
    public static class PipelineStep {

        @SerializedName("no_cache")
        private int noCache;

        @SerializedName("type")
        private int type;

        @SerializedName("update")
        private int update;

        public int getType() {
            return this.type;
        }

        public int getUpdate() {
            return this.update;
        }

        public int getNoCache() {
            return this.noCache;
        }
    }

    /* loaded from: classes3.dex */
    public static class ReqMeta {

        @SerializedName("aks")
        private List<String> aks;

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("polling_interval")
        private int pollingInterval;

        public boolean getEnable() {
            return this.enable;
        }

        public int getPollingInterval() {
            return this.pollingInterval;
        }

        public List<String> getAks() {
            return this.aks;
        }
    }
}
