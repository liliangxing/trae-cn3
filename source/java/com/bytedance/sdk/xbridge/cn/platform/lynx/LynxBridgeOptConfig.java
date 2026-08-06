package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxBridgeOptConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeOptConfig;", "", "needAuth", "", "(Z)V", "getNeedAuth", "()Z", "component1", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LynxBridgeOptConfig {
    private final boolean needAuth;

    public LynxBridgeOptConfig() {
        this(false, 1, null);
    }

    public static /* synthetic */ LynxBridgeOptConfig copy$default(LynxBridgeOptConfig lynxBridgeOptConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = lynxBridgeOptConfig.needAuth;
        }
        return lynxBridgeOptConfig.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getNeedAuth() {
        return this.needAuth;
    }

    public final LynxBridgeOptConfig copy(boolean needAuth) {
        return new LynxBridgeOptConfig(needAuth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LynxBridgeOptConfig) && this.needAuth == ((LynxBridgeOptConfig) other).needAuth;
    }

    public int hashCode() {
        return Boolean.hashCode(this.needAuth);
    }

    public String toString() {
        return "LynxBridgeOptConfig(needAuth=" + this.needAuth + ')';
    }

    public LynxBridgeOptConfig(boolean z) {
        this.needAuth = z;
    }

    public /* synthetic */ LynxBridgeOptConfig(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final boolean getNeedAuth() {
        return this.needAuth;
    }
}
