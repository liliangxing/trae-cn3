package com.bytedance.ies.argus.api.params;

import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSBCallParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/api/params/JSBCallRewritePayload;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "methodAuthType", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "authUrl", "", "authFeId", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;Ljava/lang/String;Ljava/lang/String;)V", "getAuthFeId", "()Ljava/lang/String;", "setAuthFeId", "(Ljava/lang/String;)V", "getAuthUrl", "setAuthUrl", "getMethodAuthType", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "setMethodAuthType", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;)V", "ttmSetValue", "", Api.KEY_ENCRYPT_RESP_KEY, "value", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class JSBCallRewritePayload extends BaseRewritePayload {
    private String authFeId;
    private String authUrl;
    private AuthBridgeAccess methodAuthType;

    @Override // com.bytedance.ies.argus.strategy.BaseRewritePayload, com.bytedance.ies.argus.strategy.BaseStrategyParams
    public boolean ttmSetValue(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        return false;
    }

    public /* synthetic */ JSBCallRewritePayload(AuthBridgeAccess authBridgeAccess, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(authBridgeAccess, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final AuthBridgeAccess getMethodAuthType() {
        return this.methodAuthType;
    }

    public final void setMethodAuthType(AuthBridgeAccess authBridgeAccess) {
        Intrinsics.checkNotNullParameter(authBridgeAccess, "<set-?>");
        this.methodAuthType = authBridgeAccess;
    }

    public final String getAuthUrl() {
        return this.authUrl;
    }

    public final void setAuthUrl(String str) {
        this.authUrl = str;
    }

    public final String getAuthFeId() {
        return this.authFeId;
    }

    public final void setAuthFeId(String str) {
        this.authFeId = str;
    }

    public JSBCallRewritePayload(AuthBridgeAccess authBridgeAccess, String str, String str2) {
        Intrinsics.checkNotNullParameter(authBridgeAccess, "methodAuthType");
        this.methodAuthType = authBridgeAccess;
        this.authUrl = str;
        this.authFeId = str2;
    }
}
