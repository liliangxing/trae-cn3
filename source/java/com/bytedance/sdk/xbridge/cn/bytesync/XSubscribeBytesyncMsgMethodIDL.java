package com.bytedance.sdk.xbridge.cn.bytesync;

import com.bytedance.ies.bullet.bytesync.BytesyncManager;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.bytesync.AbsXSubscribeBytesyncMsgMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sync.SyncSDK;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: XSubscribeBytesyncMsgMethodIDL.kt */
@XBridgeMethod(name = "x.subscribeBytesyncMsg")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/bytesync/XSubscribeBytesyncMsgMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/bytesync/AbsXSubscribeBytesyncMsgMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/bytesync/AbsXSubscribeBytesyncMsgMethodIDL$XSubscribeBytesyncMsgParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/bytesync/AbsXSubscribeBytesyncMsgMethodIDL$XSubscribeBytesyncMsgResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XSubscribeBytesyncMsgMethodIDL extends AbsXSubscribeBytesyncMsgMethodIDL {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXSubscribeBytesyncMsgMethodIDL.XSubscribeBytesyncMsgParamModel params, CompletionBlock<AbsXSubscribeBytesyncMsgMethodIDL.XSubscribeBytesyncMsgResultModel> callback) {
        Object obj;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!SyncSDK.hasInit()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "bytesync has not init !!!", null, 4, null);
            return;
        }
        if (StringsKt.isBlank(params.getBusinessId())) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "businessId is blank !!!", null, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            XSubscribeBytesyncMsgMethodIDL xSubscribeBytesyncMsgMethodIDL = this;
            obj = Result.constructor-impl(Long.valueOf(Long.parseLong(params.getBusinessId())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "businessId type must be Long !!!", null, 4, null);
            return;
        }
        ContextProviderFactory contextProviderFactory = (ContextProviderFactory) bridgeContext.getService(ContextProviderFactory.class);
        IBulletContainer iBulletContainer = contextProviderFactory != null ? (IBulletContainer) contextProviderFactory.provideInstance(IBulletContainer.class) : null;
        if (iBulletContainer == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "bulletContainer is null !!!", null, 4, null);
        } else {
            BytesyncManager.INSTANCE.registerBusiness(Long.parseLong(params.getBusinessId()), iBulletContainer);
            callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(AbsXSubscribeBytesyncMsgMethodIDL.XSubscribeBytesyncMsgResultModel.class), "subscribe bytesync msg success !!!");
        }
    }
}
