package com.bytedance.pitaya.api.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYNativeTaskConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYNativeTaskConfig;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "service", "Lcom/bytedance/pitaya/api/bean/PTYNativeService;", "aid", "", "appVersion", "pluginVersion", "(Lcom/bytedance/pitaya/api/bean/PTYNativeService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAid", "()Ljava/lang/String;", "getAppVersion", "getPluginVersion", "getService", "()Lcom/bytedance/pitaya/api/bean/PTYNativeService;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYNativeTaskConfig implements ReflectionCall {
    private final String aid;
    private final String appVersion;
    private final String pluginVersion;
    private final PTYNativeService service;

    public static /* synthetic */ PTYNativeTaskConfig copy$default(PTYNativeTaskConfig pTYNativeTaskConfig, PTYNativeService pTYNativeService, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            pTYNativeService = pTYNativeTaskConfig.service;
        }
        if ((i & 2) != 0) {
            str = pTYNativeTaskConfig.aid;
        }
        if ((i & 4) != 0) {
            str2 = pTYNativeTaskConfig.appVersion;
        }
        if ((i & 8) != 0) {
            str3 = pTYNativeTaskConfig.pluginVersion;
        }
        return pTYNativeTaskConfig.copy(pTYNativeService, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final PTYNativeService getService() {
        return this.service;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAid() {
        return this.aid;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPluginVersion() {
        return this.pluginVersion;
    }

    public final PTYNativeTaskConfig copy(PTYNativeService service, String aid, String appVersion, String pluginVersion) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(aid, "aid");
        return new PTYNativeTaskConfig(service, aid, appVersion, pluginVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYNativeTaskConfig)) {
            return false;
        }
        PTYNativeTaskConfig pTYNativeTaskConfig = (PTYNativeTaskConfig) other;
        return this.service == pTYNativeTaskConfig.service && Intrinsics.areEqual(this.aid, pTYNativeTaskConfig.aid) && Intrinsics.areEqual(this.appVersion, pTYNativeTaskConfig.appVersion) && Intrinsics.areEqual(this.pluginVersion, pTYNativeTaskConfig.pluginVersion);
    }

    public int hashCode() {
        int hashCode = ((this.service.hashCode() * 31) + this.aid.hashCode()) * 31;
        String str = this.appVersion;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.pluginVersion;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PTYNativeTaskConfig(service=" + this.service + ", aid=" + this.aid + ", appVersion=" + this.appVersion + ", pluginVersion=" + this.pluginVersion + ')';
    }

    public PTYNativeTaskConfig(PTYNativeService service, String aid, String str, String str2) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(aid, "aid");
        this.service = service;
        this.aid = aid;
        this.appVersion = str;
        this.pluginVersion = str2;
    }

    public /* synthetic */ PTYNativeTaskConfig(PTYNativeService pTYNativeService, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pTYNativeService, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final PTYNativeService getService() {
        return this.service;
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getPluginVersion() {
        return this.pluginVersion;
    }
}
