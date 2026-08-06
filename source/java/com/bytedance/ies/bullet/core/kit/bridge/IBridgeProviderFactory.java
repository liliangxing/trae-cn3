package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.model.pipeline.IProcessor;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: BridgeRegistry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R(\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0002`\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR,\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR$\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeProviderFactory;", "", "bridgeProvider", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeProvider;", "getBridgeProvider", "()Lkotlin/jvm/functions/Function1;", "bridgeRegistryTransformerProvider", "Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeHandleUnit;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeRegistryTransformer;", "getBridgeRegistryTransformerProvider", "scopeProviderProviderFactory", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScopeProviderFactory;", "getScopeProviderProviderFactory", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IBridgeProviderFactory {
    Function1<ContextProviderFactory, List<IGenericBridgeMethod>> getBridgeProvider();

    Function1<ContextProviderFactory, IProcessor<BridgeHandleUnit>> getBridgeRegistryTransformerProvider();

    Function1<ContextProviderFactory, List<IBridgeScopeProviderFactory>> getScopeProviderProviderFactory();
}
