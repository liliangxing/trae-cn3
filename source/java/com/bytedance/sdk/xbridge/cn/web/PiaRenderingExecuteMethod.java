package com.bytedance.sdk.xbridge.cn.web;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.web.pia.PiaHelper;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.BidConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.web.AbsPiaRenderingExecuteMethodIDL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: PiaRenderingExecuteMethod.kt */
@XBridgeMethod(name = "pia.rendering.execute")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/web/PiaRenderingExecuteMethod;", "Lcom/bytedance/sdk/xbridge/cn/web/AbsPiaRenderingExecuteMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/web/AbsPiaRenderingExecuteMethodIDL$PiaRenderingExecuteParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/web/AbsPiaRenderingExecuteMethodIDL$PiaRenderingExecuteResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PiaRenderingExecuteMethod extends AbsPiaRenderingExecuteMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsPiaRenderingExecuteMethodIDL.PiaRenderingExecuteParamModel params, final CompletionBlock<AbsPiaRenderingExecuteMethodIDL.PiaRenderingExecuteResultModel> callback) {
        String str;
        BulletContext bulletContext;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String url = params.getUrl();
        if (url == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
            return;
        }
        ContextProviderFactory contextProviderFactory = (ContextProviderFactory) bridgeContext.getService(ContextProviderFactory.class);
        if (contextProviderFactory == null || (bulletContext = (BulletContext) contextProviderFactory.provideInstance(BulletContext.class)) == null || (str = bulletContext.getBid()) == null) {
            str = BidConstants.DEFAULT;
        }
        PiaHelper.INSTANCE.rendering(str, url, params.getContext(), new IConsumer() { // from class: com.bytedance.sdk.xbridge.cn.web.PiaRenderingExecuteMethod$handle$1
            public final void accept(Map<String, ?> map) {
                CompletionBlock<AbsPiaRenderingExecuteMethodIDL.PiaRenderingExecuteResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsPiaRenderingExecuteMethodIDL.PiaRenderingExecuteResultModel.class));
                ((AbsPiaRenderingExecuteMethodIDL.PiaRenderingExecuteResultModel) createXModel).setResult(map);
                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
            }
        }, new IConsumer() { // from class: com.bytedance.sdk.xbridge.cn.web.PiaRenderingExecuteMethod$handle$2
            public final void accept(PiaMethod.Error error) {
                CompletionBlock<AbsPiaRenderingExecuteMethodIDL.PiaRenderingExecuteResultModel> completionBlock = callback;
                int code = error.getCode();
                String message = error.getMessage();
                if (message == null) {
                    message = "";
                }
                CompletionBlock.DefaultImpls.onFailure$default(completionBlock, code, message, null, 4, null);
            }
        });
    }
}
