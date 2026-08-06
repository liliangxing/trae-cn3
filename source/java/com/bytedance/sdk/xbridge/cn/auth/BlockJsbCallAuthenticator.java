package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.jsbridge.BlockJsbCallResult;
import com.bytedance.ies.bullet.kit.web.jsbridge.IShouldBlockJsbCallListener;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlockJsbCallAuthenticator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/BlockJsbCallAuthenticator;", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/Authenticator;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "listener", "", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IShouldBlockJsbCallListener;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;Ljava/util/List;)V", "doAuth", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "method", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BlockJsbCallAuthenticator implements Authenticator {
    private final List<IShouldBlockJsbCallListener> listener;
    private final ContextProviderFactory providerFactory;

    public BlockJsbCallAuthenticator(ContextProviderFactory contextProviderFactory, List<? extends IShouldBlockJsbCallListener> list) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        Intrinsics.checkNotNullParameter(list, "listener");
        this.providerFactory = contextProviderFactory;
        this.listener = list;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator
    public AuthResult doAuth(BaseBridgeCall<?> call, IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(method, "method");
        if (call.getPlatformType() == PlatformType.WEB) {
            for (IShouldBlockJsbCallListener iShouldBlockJsbCallListener : this.listener) {
                BlockJsbCallResult shouldBlockJsbCall = iShouldBlockJsbCallListener.shouldBlockJsbCall(call, method, this.providerFactory);
                if (shouldBlockJsbCall.getShouldBlock()) {
                    call.setCode(-1);
                    call.setMessage("blocked by biz service " + iShouldBlockJsbCallListener.name() + ", msg: " + shouldBlockJsbCall.getMsg());
                    return new AuthResult(false, false, "blocked by biz service " + iShouldBlockJsbCallListener.name() + ", msg: " + shouldBlockJsbCall.getMsg(), AuthErrorCode.BLOCK_BY_BIZ_SERVICE, null, false, 50, null);
                }
            }
        }
        return new AuthResult(true, false, null, null, null, false, 62, null);
    }
}
