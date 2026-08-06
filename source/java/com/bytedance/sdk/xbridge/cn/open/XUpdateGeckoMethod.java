package com.bytedance.sdk.xbridge.cn.open;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.open.AbsXUpdateGeckoMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IUpdateGeckoCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XUpdateGeckoMethod.kt */
@XBridgeMethod(name = "x.updateGecko")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/open/XUpdateGeckoMethod;", "Lcom/bytedance/sdk/xbridge/cn/open/AbsXUpdateGeckoMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/open/AbsXUpdateGeckoMethodIDL$XUpdateGeckoParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/open/AbsXUpdateGeckoMethodIDL$XUpdateGeckoResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XUpdateGeckoMethod extends AbsXUpdateGeckoMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXUpdateGeckoMethodIDL.XUpdateGeckoParamModel params, final CompletionBlock<AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String channel = params.getChannel();
        if (XBaseRuntime.INSTANCE.getGeckoDepend().updateGecko(params.getAccessKey(), channel, new IUpdateGeckoCallback() { // from class: com.bytedance.sdk.xbridge.cn.open.XUpdateGeckoMethod$handle$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IUpdateGeckoCallback
            public void onNeedUpdate() {
                CompletionBlock<AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel.class));
                ((AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel) createXModel).setStatusCode((Number) 1);
                completionBlock.onSuccess((XBaseResultModel) createXModel, "needUpdate");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IUpdateGeckoCallback
            public void onSkipUpdate() {
                CompletionBlock<AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel.class));
                ((AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel) createXModel).setStatusCode((Number) 0);
                completionBlock.onSuccess((XBaseResultModel) createXModel, "skipUpdate for local version is already up-to-date");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IUpdateGeckoCallback
            public void onAbortUpdate() {
                CompletionBlock<AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel.class));
                ((AbsXUpdateGeckoMethodIDL.XUpdateGeckoResultModel) createXModel).setStatusCode((Number) 2);
                completionBlock.onSuccess((XBaseResultModel) createXModel, "abortUpdate for requested channel is not in lazy channels or doesn't exist with host accesskey");
            }
        }, params.getEnableDownloadAutoRetry()) == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "updateGecko failed, accessKey maybe not register", null, 4, null);
        }
    }
}
