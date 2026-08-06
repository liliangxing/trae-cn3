package com.bytedance.pia.core.setting;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: PIAConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R4\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\"\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/pia/core/setting/PIAConfig;", "", "()V", "disableFeatures", "", "", "", "getDisableFeatures", "()Ljava/util/Map;", "setDisableFeatures", "(Ljava/util/Map;)V", "openCancelUselessWarmup", "", "getOpenCancelUselessWarmup", "()Ljava/lang/Boolean;", "setOpenCancelUselessWarmup", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "openDefaultResourcePreload", "getOpenDefaultResourcePreload", "setOpenDefaultResourcePreload", "openManifestCacheInt", "", "getOpenManifestCacheInt", "()Ljava/lang/Integer;", "setOpenManifestCacheInt", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "openManifestCachePages", "", "getOpenManifestCachePages", "()Ljava/util/List;", "setOpenManifestCachePages", "(Ljava/util/List;)V", "openOnlineMonitor", "getOpenOnlineMonitor", "setOpenOnlineMonitor", "openParseLink", "getOpenParseLink", "setOpenParseLink", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PIAConfig {

    @SerializedName("disable_features")
    private Map<String, String[]> disableFeatures;

    @SerializedName("open_online_monitor")
    private Boolean openOnlineMonitor = true;

    @SerializedName("open_manifest_cache_int")
    private Integer openManifestCacheInt = 5000;

    @SerializedName("open_manifest_cache_pages")
    private List<String> openManifestCachePages = CollectionsKt.listOf((Object[]) new String[]{"lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/wallet/webcast/webview/caijing_h5_coupon/template/pages/list/index.html", "lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/wallet/h5/webcast/caijing_h5_point/template/home/index.html"});

    @SerializedName("open_cancel_useless_warmup")
    private Boolean openCancelUselessWarmup = true;

    @SerializedName("open_default_resource_preload")
    private Boolean openDefaultResourcePreload = true;

    @SerializedName("open_parse_link")
    private Boolean openParseLink = true;

    public final Boolean getOpenOnlineMonitor() {
        return this.openOnlineMonitor;
    }

    public final void setOpenOnlineMonitor(Boolean bool) {
        this.openOnlineMonitor = bool;
    }

    public final Map<String, String[]> getDisableFeatures() {
        return this.disableFeatures;
    }

    public final void setDisableFeatures(Map<String, String[]> map) {
        this.disableFeatures = map;
    }

    public final Integer getOpenManifestCacheInt() {
        return this.openManifestCacheInt;
    }

    public final void setOpenManifestCacheInt(Integer num) {
        this.openManifestCacheInt = num;
    }

    public final List<String> getOpenManifestCachePages() {
        return this.openManifestCachePages;
    }

    public final void setOpenManifestCachePages(List<String> list) {
        this.openManifestCachePages = list;
    }

    public final Boolean getOpenCancelUselessWarmup() {
        return this.openCancelUselessWarmup;
    }

    public final void setOpenCancelUselessWarmup(Boolean bool) {
        this.openCancelUselessWarmup = bool;
    }

    public final Boolean getOpenDefaultResourcePreload() {
        return this.openDefaultResourcePreload;
    }

    public final void setOpenDefaultResourcePreload(Boolean bool) {
        this.openDefaultResourcePreload = bool;
    }

    public final Boolean getOpenParseLink() {
        return this.openParseLink;
    }

    public final void setOpenParseLink(Boolean bool) {
        this.openParseLink = bool;
    }
}
