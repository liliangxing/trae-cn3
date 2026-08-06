package com.bytedance.sdk.xbridge.cn.auth.bean;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSBAuthStrategyConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR,\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/WebAuthStrategyConfig;", "", "enableJSBAuthV3", "", "privateDomains", "", "", "", "enableAutoMatchUrl", "(ZLjava/util/Map;Z)V", "getEnableAutoMatchUrl", "()Z", "setEnableAutoMatchUrl", "(Z)V", "getEnableJSBAuthV3", "setEnableJSBAuthV3", "getPrivateDomains", "()Ljava/util/Map;", "setPrivateDomains", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class WebAuthStrategyConfig {
    private boolean enableAutoMatchUrl;
    private boolean enableJSBAuthV3;
    private Map<String, String[]> privateDomains;

    public WebAuthStrategyConfig() {
        this(false, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebAuthStrategyConfig copy$default(WebAuthStrategyConfig webAuthStrategyConfig, boolean z, Map map, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webAuthStrategyConfig.enableJSBAuthV3;
        }
        if ((i & 2) != 0) {
            map = webAuthStrategyConfig.privateDomains;
        }
        if ((i & 4) != 0) {
            z2 = webAuthStrategyConfig.enableAutoMatchUrl;
        }
        return webAuthStrategyConfig.copy(z, map, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableJSBAuthV3() {
        return this.enableJSBAuthV3;
    }

    public final Map<String, String[]> component2() {
        return this.privateDomains;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableAutoMatchUrl() {
        return this.enableAutoMatchUrl;
    }

    public final WebAuthStrategyConfig copy(boolean enableJSBAuthV3, Map<String, String[]> privateDomains, boolean enableAutoMatchUrl) {
        Intrinsics.checkNotNullParameter(privateDomains, "privateDomains");
        return new WebAuthStrategyConfig(enableJSBAuthV3, privateDomains, enableAutoMatchUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebAuthStrategyConfig)) {
            return false;
        }
        WebAuthStrategyConfig webAuthStrategyConfig = (WebAuthStrategyConfig) other;
        return this.enableJSBAuthV3 == webAuthStrategyConfig.enableJSBAuthV3 && Intrinsics.areEqual(this.privateDomains, webAuthStrategyConfig.privateDomains) && this.enableAutoMatchUrl == webAuthStrategyConfig.enableAutoMatchUrl;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.enableJSBAuthV3) * 31) + this.privateDomains.hashCode()) * 31) + Boolean.hashCode(this.enableAutoMatchUrl);
    }

    public String toString() {
        return "WebAuthStrategyConfig(enableJSBAuthV3=" + this.enableJSBAuthV3 + ", privateDomains=" + this.privateDomains + ", enableAutoMatchUrl=" + this.enableAutoMatchUrl + ')';
    }

    public WebAuthStrategyConfig(boolean z, Map<String, String[]> map, boolean z2) {
        Intrinsics.checkNotNullParameter(map, "privateDomains");
        this.enableJSBAuthV3 = z;
        this.privateDomains = map;
        this.enableAutoMatchUrl = z2;
    }

    public final boolean getEnableJSBAuthV3() {
        return this.enableJSBAuthV3;
    }

    public final void setEnableJSBAuthV3(boolean z) {
        this.enableJSBAuthV3 = z;
    }

    public /* synthetic */ WebAuthStrategyConfig(boolean z, Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? false : z2);
    }

    public final Map<String, String[]> getPrivateDomains() {
        return this.privateDomains;
    }

    public final void setPrivateDomains(Map<String, String[]> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.privateDomains = map;
    }

    public final boolean getEnableAutoMatchUrl() {
        return this.enableAutoMatchUrl;
    }

    public final void setEnableAutoMatchUrl(boolean z) {
        this.enableAutoMatchUrl = z;
    }
}
