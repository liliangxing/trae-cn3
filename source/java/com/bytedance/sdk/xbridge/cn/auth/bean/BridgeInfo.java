package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J'\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006&"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/BridgeInfo;", "", "bridgeName", "", "auth", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;Lorg/json/JSONObject;)V", "getAuth", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "authFeId", "getAuthFeId", "()Ljava/lang/String;", "setAuthFeId", "(Ljava/lang/String;)V", "getBridgeName", "containerType", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;", "getContainerType", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;", "setContainerType", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;)V", "getParams", "()Lorg/json/JSONObject;", "url", "getUrl", "setUrl", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BridgeInfo {
    private final AuthBridgeAccess auth;
    private String authFeId;
    private final String bridgeName;
    private AuthConfigType containerType;
    private final JSONObject params;
    private String url;

    public static /* synthetic */ BridgeInfo copy$default(BridgeInfo bridgeInfo, String str, AuthBridgeAccess authBridgeAccess, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bridgeInfo.bridgeName;
        }
        if ((i & 2) != 0) {
            authBridgeAccess = bridgeInfo.auth;
        }
        if ((i & 4) != 0) {
            jSONObject = bridgeInfo.params;
        }
        return bridgeInfo.copy(str, authBridgeAccess, jSONObject);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBridgeName() {
        return this.bridgeName;
    }

    /* renamed from: component2, reason: from getter */
    public final AuthBridgeAccess getAuth() {
        return this.auth;
    }

    /* renamed from: component3, reason: from getter */
    public final JSONObject getParams() {
        return this.params;
    }

    public final BridgeInfo copy(String bridgeName, AuthBridgeAccess auth, JSONObject params) {
        Intrinsics.checkNotNullParameter(bridgeName, "bridgeName");
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(params, "params");
        return new BridgeInfo(bridgeName, auth, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BridgeInfo)) {
            return false;
        }
        BridgeInfo bridgeInfo = (BridgeInfo) other;
        return Intrinsics.areEqual(this.bridgeName, bridgeInfo.bridgeName) && this.auth == bridgeInfo.auth && Intrinsics.areEqual(this.params, bridgeInfo.params);
    }

    public int hashCode() {
        return (((this.bridgeName.hashCode() * 31) + this.auth.hashCode()) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "BridgeInfo(bridgeName=" + this.bridgeName + ", auth=" + this.auth + ", params=" + this.params + ')';
    }

    public BridgeInfo(String bridgeName, AuthBridgeAccess auth, JSONObject params) {
        Intrinsics.checkNotNullParameter(bridgeName, "bridgeName");
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(params, "params");
        this.bridgeName = bridgeName;
        this.auth = auth;
        this.params = params;
        this.containerType = AuthConfigType.UNKNOWN;
        this.authFeId = "-1";
    }

    public final String getBridgeName() {
        return this.bridgeName;
    }

    public /* synthetic */ BridgeInfo(String str, AuthBridgeAccess authBridgeAccess, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? AuthBridgeAccess.PRIVATE : authBridgeAccess, jSONObject);
    }

    public final AuthBridgeAccess getAuth() {
        return this.auth;
    }

    public final JSONObject getParams() {
        return this.params;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final AuthConfigType getContainerType() {
        return this.containerType;
    }

    public final void setContainerType(AuthConfigType authConfigType) {
        Intrinsics.checkNotNullParameter(authConfigType, "<set-?>");
        this.containerType = authConfigType;
    }

    public final String getAuthFeId() {
        return this.authFeId;
    }

    public final void setAuthFeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authFeId = str;
    }
}
