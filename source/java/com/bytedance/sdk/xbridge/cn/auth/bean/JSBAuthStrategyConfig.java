package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSBAuthStrategyConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/JSBAuthStrategyConfig;", "", "webAuthStrategy", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/WebAuthStrategyConfig;", "lynxAuthStrategy", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthStrategyConfig;", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/WebAuthStrategyConfig;Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthStrategyConfig;)V", "getLynxAuthStrategy", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthStrategyConfig;", "getWebAuthStrategy", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/WebAuthStrategyConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class JSBAuthStrategyConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LynxAuthStrategyConfig lynxAuthStrategy;
    private final WebAuthStrategyConfig webAuthStrategy;

    /* JADX WARN: Multi-variable type inference failed */
    public JSBAuthStrategyConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ JSBAuthStrategyConfig copy$default(JSBAuthStrategyConfig jSBAuthStrategyConfig, WebAuthStrategyConfig webAuthStrategyConfig, LynxAuthStrategyConfig lynxAuthStrategyConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            webAuthStrategyConfig = jSBAuthStrategyConfig.webAuthStrategy;
        }
        if ((i & 2) != 0) {
            lynxAuthStrategyConfig = jSBAuthStrategyConfig.lynxAuthStrategy;
        }
        return jSBAuthStrategyConfig.copy(webAuthStrategyConfig, lynxAuthStrategyConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final WebAuthStrategyConfig getWebAuthStrategy() {
        return this.webAuthStrategy;
    }

    /* renamed from: component2, reason: from getter */
    public final LynxAuthStrategyConfig getLynxAuthStrategy() {
        return this.lynxAuthStrategy;
    }

    public final JSBAuthStrategyConfig copy(WebAuthStrategyConfig webAuthStrategy, LynxAuthStrategyConfig lynxAuthStrategy) {
        Intrinsics.checkNotNullParameter(webAuthStrategy, "webAuthStrategy");
        Intrinsics.checkNotNullParameter(lynxAuthStrategy, "lynxAuthStrategy");
        return new JSBAuthStrategyConfig(webAuthStrategy, lynxAuthStrategy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSBAuthStrategyConfig)) {
            return false;
        }
        JSBAuthStrategyConfig jSBAuthStrategyConfig = (JSBAuthStrategyConfig) other;
        return Intrinsics.areEqual(this.webAuthStrategy, jSBAuthStrategyConfig.webAuthStrategy) && Intrinsics.areEqual(this.lynxAuthStrategy, jSBAuthStrategyConfig.lynxAuthStrategy);
    }

    public int hashCode() {
        return (this.webAuthStrategy.hashCode() * 31) + this.lynxAuthStrategy.hashCode();
    }

    public String toString() {
        return "JSBAuthStrategyConfig(webAuthStrategy=" + this.webAuthStrategy + ", lynxAuthStrategy=" + this.lynxAuthStrategy + ')';
    }

    public JSBAuthStrategyConfig(WebAuthStrategyConfig webAuthStrategyConfig, LynxAuthStrategyConfig lynxAuthStrategyConfig) {
        Intrinsics.checkNotNullParameter(webAuthStrategyConfig, "webAuthStrategy");
        Intrinsics.checkNotNullParameter(lynxAuthStrategyConfig, "lynxAuthStrategy");
        this.webAuthStrategy = webAuthStrategyConfig;
        this.lynxAuthStrategy = lynxAuthStrategyConfig;
    }

    public /* synthetic */ JSBAuthStrategyConfig(WebAuthStrategyConfig webAuthStrategyConfig, LynxAuthStrategyConfig lynxAuthStrategyConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new WebAuthStrategyConfig(false, null, false, 7, null) : webAuthStrategyConfig, (i & 2) != 0 ? new LynxAuthStrategyConfig(null, null, 3, null) : lynxAuthStrategyConfig);
    }

    public final WebAuthStrategyConfig getWebAuthStrategy() {
        return this.webAuthStrategy;
    }

    public final LynxAuthStrategyConfig getLynxAuthStrategy() {
        return this.lynxAuthStrategy;
    }

    /* compiled from: JSBAuthStrategyConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/JSBAuthStrategyConfig$Companion;", "", "()V", "parseMatchNamespace", "", LynxBridgeCall.NAME_SPACE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String parseMatchNamespace(String namespace) {
            Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
            return Intrinsics.areEqual(namespace, "") ? PermissionConfigParser.WEBCAST_HOST_NAMESPACE : namespace;
        }
    }
}
