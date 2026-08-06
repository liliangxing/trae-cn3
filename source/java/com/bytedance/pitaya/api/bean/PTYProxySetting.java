package com.bytedance.pitaya.api.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYProxySetting.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0013HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u0004¨\u0006#"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYProxySetting;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "provideAppLog", "", "(Z)V", "applogProxyEnabled", "getApplogProxyEnabled", "()Z", "setApplogProxyEnabled", "customApplogEvents", "", "getCustomApplogEvents", "()Ljava/lang/String;", "setCustomApplogEvents", "(Ljava/lang/String;)V", "featureStoreProxyEnabled", "getFeatureStoreProxyEnabled", "setFeatureStoreProxyEnabled", "maxApplogEventCacheNum", "", "getMaxApplogEventCacheNum", "()I", "setMaxApplogEventCacheNum", "(I)V", "getProvideAppLog", "useCustomApplogEvents", "getUseCustomApplogEvents", "setUseCustomApplogEvents", "component1", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYProxySetting implements ReflectionCall {
    private boolean applogProxyEnabled;
    private boolean featureStoreProxyEnabled;
    private final boolean provideAppLog;
    private boolean useCustomApplogEvents;
    private String customApplogEvents = "";
    private int maxApplogEventCacheNum = 100;

    public static /* synthetic */ PTYProxySetting copy$default(PTYProxySetting pTYProxySetting, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pTYProxySetting.provideAppLog;
        }
        return pTYProxySetting.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getProvideAppLog() {
        return this.provideAppLog;
    }

    public final PTYProxySetting copy(boolean provideAppLog) {
        return new PTYProxySetting(provideAppLog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PTYProxySetting) && this.provideAppLog == ((PTYProxySetting) other).provideAppLog;
    }

    public int hashCode() {
        boolean z = this.provideAppLog;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "PTYProxySetting(provideAppLog=" + this.provideAppLog + ')';
    }

    public PTYProxySetting(boolean z) {
        this.provideAppLog = z;
    }

    public final boolean getProvideAppLog() {
        return this.provideAppLog;
    }

    public final boolean getApplogProxyEnabled() {
        return this.applogProxyEnabled;
    }

    public final void setApplogProxyEnabled(boolean z) {
        this.applogProxyEnabled = z;
    }

    public final boolean getFeatureStoreProxyEnabled() {
        return this.featureStoreProxyEnabled;
    }

    public final void setFeatureStoreProxyEnabled(boolean z) {
        this.featureStoreProxyEnabled = z;
    }

    public final boolean getUseCustomApplogEvents() {
        return this.useCustomApplogEvents;
    }

    public final void setUseCustomApplogEvents(boolean z) {
        this.useCustomApplogEvents = z;
    }

    public final String getCustomApplogEvents() {
        return this.customApplogEvents;
    }

    public final void setCustomApplogEvents(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.customApplogEvents = str;
    }

    public final int getMaxApplogEventCacheNum() {
        return this.maxApplogEventCacheNum;
    }

    public final void setMaxApplogEventCacheNum(int i) {
        this.maxApplogEventCacheNum = i;
    }
}
