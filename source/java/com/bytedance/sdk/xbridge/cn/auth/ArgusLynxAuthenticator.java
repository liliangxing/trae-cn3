package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.ies.argus.api.params.JSBCallParams;
import com.bytedance.ies.argus.api.params.JSBCallRewritePayload;
import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusLynxAuthenticator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/ArgusLynxAuthenticator;", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/Authenticator;", "authVerifier", "Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;", "(Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;)V", "doAuth", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "method", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArgusLynxAuthenticator implements Authenticator {
    private final ArgusLynxDelegate authVerifier;

    public ArgusLynxAuthenticator(ArgusLynxDelegate argusLynxDelegate) {
        Intrinsics.checkNotNullParameter(argusLynxDelegate, "authVerifier");
        this.authVerifier = argusLynxDelegate;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator
    public AuthResult doAuth(BaseBridgeCall<?> call, IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(method, "method");
        if (call.getPlatformType() == PlatformType.LYNX) {
            AspectVerifyResult verifyJSBCall = this.authVerifier.verifyJSBCall(new JSBCallParams(method.getName(), AuthBridgeAccess.INSTANCE.getAccess(method.getAccess().getValue()), call.getNamespace(), ArgusContainerType.LYNX, call.getUrl()));
            if (verifyJSBCall.isBlock()) {
                call.setCode(-1);
                call.setMessage("not authorized by LynxAuthenticator, reason: " + verifyJSBCall.getReason());
            }
            AuthResult authResult = new AuthResult(verifyJSBCall.isPass(), false, null, null, null, false, 62, null);
            JSBCallRewritePayload rewritePayload = verifyJSBCall.getRewritePayload();
            authResult.setAuthUrl(rewritePayload != null ? rewritePayload.getAuthUrl() : null);
            JSBCallRewritePayload rewritePayload2 = verifyJSBCall.getRewritePayload();
            authResult.setAuthFeId(rewritePayload2 != null ? rewritePayload2.getAuthFeId() : null);
            authResult.setNeedReport(false);
            return authResult;
        }
        return new AuthResult(true, false, null, null, null, false, 62, null);
    }
}
