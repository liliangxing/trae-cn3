package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0010HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/ConfigWithSwitch;", "", ReportConstant.COMMON_CONTENT, "", "", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigV1Bean;", "contentV2", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigBean;", "settings", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthSwitch;", "(Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthSwitch;)V", "getContent", "()Ljava/util/Map;", "getContentV2", "packageVersion", "", "getPackageVersion", "()I", "setPackageVersion", "(I)V", "getSettings", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthSwitch;", "setSettings", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthSwitch;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ConfigWithSwitch {
    private final Map<String, List<AuthConfigV1Bean>> content;
    private final Map<String, AuthConfigBean> contentV2;
    private int packageVersion;
    private LynxAuthSwitch settings;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigWithSwitch copy$default(ConfigWithSwitch configWithSwitch, Map map, Map map2, LynxAuthSwitch lynxAuthSwitch, int i, Object obj) {
        if ((i & 1) != 0) {
            map = configWithSwitch.content;
        }
        if ((i & 2) != 0) {
            map2 = configWithSwitch.contentV2;
        }
        if ((i & 4) != 0) {
            lynxAuthSwitch = configWithSwitch.settings;
        }
        return configWithSwitch.copy(map, map2, lynxAuthSwitch);
    }

    public final Map<String, List<AuthConfigV1Bean>> component1() {
        return this.content;
    }

    public final Map<String, AuthConfigBean> component2() {
        return this.contentV2;
    }

    /* renamed from: component3, reason: from getter */
    public final LynxAuthSwitch getSettings() {
        return this.settings;
    }

    public final ConfigWithSwitch copy(Map<String, ? extends List<AuthConfigV1Bean>> content, Map<String, AuthConfigBean> contentV2, LynxAuthSwitch settings) {
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        Intrinsics.checkNotNullParameter(contentV2, "contentV2");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new ConfigWithSwitch(content, contentV2, settings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigWithSwitch)) {
            return false;
        }
        ConfigWithSwitch configWithSwitch = (ConfigWithSwitch) other;
        return Intrinsics.areEqual(this.content, configWithSwitch.content) && Intrinsics.areEqual(this.contentV2, configWithSwitch.contentV2) && Intrinsics.areEqual(this.settings, configWithSwitch.settings);
    }

    public int hashCode() {
        return (((this.content.hashCode() * 31) + this.contentV2.hashCode()) * 31) + this.settings.hashCode();
    }

    public String toString() {
        return "ConfigWithSwitch(content=" + this.content + ", contentV2=" + this.contentV2 + ", settings=" + this.settings + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConfigWithSwitch(Map<String, ? extends List<AuthConfigV1Bean>> map, Map<String, AuthConfigBean> map2, LynxAuthSwitch lynxAuthSwitch) {
        Intrinsics.checkNotNullParameter(map, ReportConstant.COMMON_CONTENT);
        Intrinsics.checkNotNullParameter(map2, "contentV2");
        Intrinsics.checkNotNullParameter(lynxAuthSwitch, "settings");
        this.content = map;
        this.contentV2 = map2;
        this.settings = lynxAuthSwitch;
        this.packageVersion = -1;
    }

    public final Map<String, List<AuthConfigV1Bean>> getContent() {
        return this.content;
    }

    public final Map<String, AuthConfigBean> getContentV2() {
        return this.contentV2;
    }

    public final LynxAuthSwitch getSettings() {
        return this.settings;
    }

    public final void setSettings(LynxAuthSwitch lynxAuthSwitch) {
        Intrinsics.checkNotNullParameter(lynxAuthSwitch, "<set-?>");
        this.settings = lynxAuthSwitch;
    }

    public final int getPackageVersion() {
        return this.packageVersion;
    }

    public final void setPackageVersion(int i) {
        this.packageVersion = i;
    }
}
