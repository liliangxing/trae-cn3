package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.json.JSONArray;

/* compiled from: AnnieXRedirectSettingsConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/AnnieXRedirectSettingsConfig;", "", "()V", "configUrl", "", "getConfigUrl", "()Ljava/lang/String;", "setConfigUrl", "(Ljava/lang/String;)V", "pollInterval", "", "getPollInterval", "()Ljava/lang/Long;", "setPollInterval", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "redirectInCurRouteWhiteList", "Lorg/json/JSONArray;", "getRedirectInCurRouteWhiteList", "()Lorg/json/JSONArray;", "setRedirectInCurRouteWhiteList", "(Lorg/json/JSONArray;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnieXRedirectSettingsConfig {

    @SerializedName("config_url")
    private String configUrl;

    @SerializedName("poll_interval")
    private Long pollInterval = 0L;

    @SerializedName("android_redirect_in_cur_route_white_list")
    private JSONArray redirectInCurRouteWhiteList;

    public final String getConfigUrl() {
        return this.configUrl;
    }

    public final void setConfigUrl(String str) {
        this.configUrl = str;
    }

    public final Long getPollInterval() {
        return this.pollInterval;
    }

    public final void setPollInterval(Long l) {
        this.pollInterval = l;
    }

    public final JSONArray getRedirectInCurRouteWhiteList() {
        return this.redirectInCurRouteWhiteList;
    }

    public final void setRedirectInCurRouteWhiteList(JSONArray jSONArray) {
        this.redirectInCurRouteWhiteList = jSONArray;
    }
}
