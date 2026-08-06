package com.bytedance.ies.bullet.service.base.settings;

import com.bytedance.ies.xbridge.XBridge;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MonitorSettingsConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR(\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0018\u0010\u0007R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR,\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R(\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/MonitorSettingsConfig;", "", "()V", "channelWhiteList", "", "", "getChannelWhiteList", "()[Ljava/lang/String;", "setChannelWhiteList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "containerABConfig", "", "getContainerABConfig", "()Ljava/util/Map;", "setContainerABConfig", "(Ljava/util/Map;)V", "eventBlackList", "getEventBlackList", "setEventBlackList", "eventWhiteList", "getEventWhiteList", "setEventWhiteList", "jsSdkDisallowList", "getJsSdkDisallowList", "logSwitch", "", "getLogSwitch", "()Z", "setLogSwitch", "(Z)V", "matchRules", "getMatchRules", "setMatchRules", "urlWhiteList", "getUrlWhiteList", "setUrlWhiteList", "webSSPReport", "getWebSSPReport", "setWebSSPReport", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class MonitorSettingsConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MonitorSettingsConfig DEFAULT = new MonitorSettingsConfig();

    @SerializedName("log_switch")
    private boolean logSwitch = true;

    @SerializedName("event_blacklist")
    private String[] eventBlackList = new String[0];

    @SerializedName("event_whitelist")
    private String[] eventWhiteList = new String[0];

    @SerializedName("url_whitelist")
    private String[] urlWhiteList = new String[0];

    @SerializedName("channel_whitelist")
    private String[] channelWhiteList = new String[0];

    @SerializedName("match_rules")
    private Map<String, String> matchRules = new LinkedHashMap();

    @SerializedName("container_ab_config")
    private Map<String, String> containerABConfig = new LinkedHashMap();

    @SerializedName("jssdk_disallow_list")
    private final String[] jsSdkDisallowList = new String[0];

    @SerializedName("web_ssp_report")
    private boolean webSSPReport = true;

    public final boolean getLogSwitch() {
        return this.logSwitch;
    }

    public final void setLogSwitch(boolean z) {
        this.logSwitch = z;
    }

    public final String[] getEventBlackList() {
        return this.eventBlackList;
    }

    public final void setEventBlackList(String[] strArr) {
        this.eventBlackList = strArr;
    }

    public final String[] getEventWhiteList() {
        return this.eventWhiteList;
    }

    public final void setEventWhiteList(String[] strArr) {
        this.eventWhiteList = strArr;
    }

    public final String[] getUrlWhiteList() {
        return this.urlWhiteList;
    }

    public final void setUrlWhiteList(String[] strArr) {
        this.urlWhiteList = strArr;
    }

    public final String[] getChannelWhiteList() {
        return this.channelWhiteList;
    }

    public final void setChannelWhiteList(String[] strArr) {
        this.channelWhiteList = strArr;
    }

    public final Map<String, String> getMatchRules() {
        return this.matchRules;
    }

    public final void setMatchRules(Map<String, String> map) {
        this.matchRules = map;
    }

    public final Map<String, String> getContainerABConfig() {
        return this.containerABConfig;
    }

    public final void setContainerABConfig(Map<String, String> map) {
        this.containerABConfig = map;
    }

    public final String[] getJsSdkDisallowList() {
        return this.jsSdkDisallowList;
    }

    public final boolean getWebSSPReport() {
        return this.webSSPReport;
    }

    public final void setWebSSPReport(boolean z) {
        this.webSSPReport = z;
    }

    /* compiled from: MonitorSettingsConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/MonitorSettingsConfig$Companion;", "", "()V", XBridge.DEFAULT_NAMESPACE, "Lcom/bytedance/ies/bullet/service/base/settings/MonitorSettingsConfig;", "getDEFAULT", "()Lcom/bytedance/ies/bullet/service/base/settings/MonitorSettingsConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MonitorSettingsConfig getDEFAULT() {
            return MonitorSettingsConfig.DEFAULT;
        }
    }
}
