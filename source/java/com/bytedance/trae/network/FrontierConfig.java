package com.bytedance.trae.network;

import com.bytedance.forest.model.PreloadConfig;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrontierConfig.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/network/FrontierConfig;", "", "productId", "", "appId", b.z, "", "url", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getProductId", "()I", "getAppId", "getAppKey", "()Ljava/lang/String;", "getUrl", "isConnectable", "", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FrontierConfig {
    private final int appId;
    private final String appKey;
    private final int productId;
    private final String url;

    public static /* synthetic */ FrontierConfig copy$default(FrontierConfig frontierConfig, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = frontierConfig.productId;
        }
        if ((i3 & 2) != 0) {
            i2 = frontierConfig.appId;
        }
        if ((i3 & 4) != 0) {
            str = frontierConfig.appKey;
        }
        if ((i3 & 8) != 0) {
            str2 = frontierConfig.url;
        }
        return frontierConfig.copy(i, i2, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final FrontierConfig copy(int productId, int appId, String appKey, String url) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(url, "url");
        return new FrontierConfig(productId, appId, appKey, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrontierConfig)) {
            return false;
        }
        FrontierConfig frontierConfig = (FrontierConfig) other;
        return this.productId == frontierConfig.productId && this.appId == frontierConfig.appId && Intrinsics.areEqual(this.appKey, frontierConfig.appKey) && Intrinsics.areEqual(this.url, frontierConfig.url);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.productId) * 31) + Integer.hashCode(this.appId)) * 31) + this.appKey.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "FrontierConfig(productId=" + this.productId + ", appId=" + this.appId + ", appKey=" + this.appKey + ", url=" + this.url + ')';
    }

    public FrontierConfig(int i, int i2, String appKey, String url) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(url, "url");
        this.productId = i;
        this.appId = i2;
        this.appKey = appKey;
        this.url = url;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isConnectable() {
        if (this.productId <= 0) {
            return false;
        }
        if (this.appKey.length() > 0) {
            return this.url.length() > 0;
        }
        return false;
    }
}
