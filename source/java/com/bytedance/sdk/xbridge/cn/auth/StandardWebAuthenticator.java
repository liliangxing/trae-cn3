package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StandardWebAuthenticator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/StandardWebAuthenticator;", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/Authenticator;", "authVerifier", "Lcom/bytedance/sdk/xbridge/cn/auth/WebAuthVerifierWrapper;", "(Lcom/bytedance/sdk/xbridge/cn/auth/WebAuthVerifierWrapper;)V", "getAuthVerifier", "()Lcom/bytedance/sdk/xbridge/cn/auth/WebAuthVerifierWrapper;", "doAuth", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "method", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StandardWebAuthenticator implements Authenticator {
    private final WebAuthVerifierWrapper authVerifier;

    public StandardWebAuthenticator(WebAuthVerifierWrapper webAuthVerifierWrapper) {
        Intrinsics.checkNotNullParameter(webAuthVerifierWrapper, "authVerifier");
        this.authVerifier = webAuthVerifierWrapper;
    }

    public final WebAuthVerifierWrapper getAuthVerifier() {
        return this.authVerifier;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator
    public AuthResult doAuth(BaseBridgeCall<?> call, IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(method, "method");
        if (call.getPlatformType() == PlatformType.WEB) {
            AuthResult doAuth = this.authVerifier.doAuth(call, method);
            if (!doAuth.getPassed()) {
                call.setCode(-1);
                call.setMessage("not authorized by WebAuthenticator, reason: " + doAuth.getAuthMsg());
            }
            return doAuth;
        }
        return new AuthResult(true, false, null, null, null, false, 62, null);
    }
}
