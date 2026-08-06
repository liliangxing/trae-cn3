package com.bytedance.ies.bullet.service.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ResourceLoaderSettingsConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR,\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001e\u0010.\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001a¨\u00061"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/ResourceLoaderSettingsConfig;", "", "()V", "enableMemCache", "", "getEnableMemCache", "()Z", "setEnableMemCache", "(Z)V", "enablePreload", "getEnablePreload", "setEnablePreload", "enableRedirectCache", "getEnableRedirectCache", "setEnableRedirectCache", "enableRedirectDefaultCache", "getEnableRedirectDefaultCache", "setEnableRedirectDefaultCache", "enableRemoteConfig", "getEnableRemoteConfig", "setEnableRemoteConfig", "globalRedirectCacheSize", "", "getGlobalRedirectCacheSize", "()I", "setGlobalRedirectCacheSize", "(I)V", "memorySize", "getMemorySize", "setMemorySize", "prefix2ak", "", "", "getPrefix2ak", "()Ljava/util/Map;", "setPrefix2ak", "(Ljava/util/Map;)V", "preloadMemWarningProportion", "", "getPreloadMemWarningProportion", "()D", "setPreloadMemWarningProportion", "(D)V", "preloadSubResMemSize", "getPreloadSubResMemSize", "setPreloadSubResMemSize", "preloadTemplateSize", "getPreloadTemplateSize", "setPreloadTemplateSize", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ResourceLoaderSettingsConfig {

    @SerializedName("enable_redirect_default_cache")
    private boolean enableRedirectDefaultCache;

    @SerializedName("enable_mem")
    private boolean enableMemCache = true;

    @SerializedName("mem_size")
    private int memorySize = 3000000;

    @SerializedName("enable_remote_config")
    private boolean enableRemoteConfig = true;

    @SerializedName("prefix2ak")
    private Map<String, String> prefix2ak = new LinkedHashMap();

    @SerializedName("enable_preload")
    private boolean enablePreload = true;

    @SerializedName("preload_template_size")
    private int preloadTemplateSize = 10;

    @SerializedName("preload_sub_res_mem_size")
    private int preloadSubResMemSize = 10;

    @SerializedName("preload_memory_warning_proportion")
    private double preloadMemWarningProportion = 0.1d;

    @SerializedName("enable_redirect_cache")
    private boolean enableRedirectCache = true;

    @SerializedName("global_redirect_cache_size")
    private int globalRedirectCacheSize = 1000;

    public final boolean getEnableMemCache() {
        return this.enableMemCache;
    }

    public final void setEnableMemCache(boolean z) {
        this.enableMemCache = z;
    }

    public final int getMemorySize() {
        return this.memorySize;
    }

    public final void setMemorySize(int i) {
        this.memorySize = i;
    }

    public final boolean getEnableRemoteConfig() {
        return this.enableRemoteConfig;
    }

    public final void setEnableRemoteConfig(boolean z) {
        this.enableRemoteConfig = z;
    }

    public final Map<String, String> getPrefix2ak() {
        return this.prefix2ak;
    }

    public final void setPrefix2ak(Map<String, String> map) {
        this.prefix2ak = map;
    }

    public final boolean getEnablePreload() {
        return this.enablePreload;
    }

    public final void setEnablePreload(boolean z) {
        this.enablePreload = z;
    }

    public final int getPreloadTemplateSize() {
        return this.preloadTemplateSize;
    }

    public final void setPreloadTemplateSize(int i) {
        this.preloadTemplateSize = i;
    }

    public final int getPreloadSubResMemSize() {
        return this.preloadSubResMemSize;
    }

    public final void setPreloadSubResMemSize(int i) {
        this.preloadSubResMemSize = i;
    }

    public final double getPreloadMemWarningProportion() {
        return this.preloadMemWarningProportion;
    }

    public final void setPreloadMemWarningProportion(double d) {
        this.preloadMemWarningProportion = d;
    }

    public final boolean getEnableRedirectCache() {
        return this.enableRedirectCache;
    }

    public final void setEnableRedirectCache(boolean z) {
        this.enableRedirectCache = z;
    }

    public final boolean getEnableRedirectDefaultCache() {
        return this.enableRedirectDefaultCache;
    }

    public final void setEnableRedirectDefaultCache(boolean z) {
        this.enableRedirectDefaultCache = z;
    }

    public final int getGlobalRedirectCacheSize() {
        return this.globalRedirectCacheSize;
    }

    public final void setGlobalRedirectCacheSize(int i) {
        this.globalRedirectCacheSize = i;
    }
}
