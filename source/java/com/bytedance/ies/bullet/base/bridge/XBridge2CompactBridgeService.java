package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.core.kit.service.BaseBridgeService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridge2CompactBridgeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/base/bridge/XBridge2CompactBridgeService;", "Lcom/bytedance/ies/bullet/core/kit/service/BaseBridgeService;", "()V", "createMethodFinder", "", "Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class XBridge2CompactBridgeService extends BaseBridgeService {
    @Override // com.bytedance.ies.bullet.core.kit.service.BaseBridgeService, com.bytedance.ies.bullet.core.kit.service.IBridgeService
    public List<MethodFinder> createMethodFinder(ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        return CollectionsKt.listOf(new MethodFinder[]{new XBridge2MethodFinder(providerFactory), new BulletMethodFinder(providerFactory), new OriginXBridgeMethodFinder(providerFactory)});
    }
}
