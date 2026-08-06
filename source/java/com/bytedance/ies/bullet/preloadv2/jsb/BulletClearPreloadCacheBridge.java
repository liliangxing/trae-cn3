package com.bytedance.ies.bullet.preloadv2.jsb;

import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.ies.bullet.preloadv2.jsb.AbsBulletClearPreloadCacheMethodIDL;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: BulletClearPreloadCacheBridge.kt */
@XBridgeMethod(name = "bullet.clearPreloadCache", owner = "liushaocong")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/jsb/BulletClearPreloadCacheBridge;", "Lcom/bytedance/ies/bullet/preloadv2/jsb/AbsBulletClearPreloadCacheMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/ies/bullet/preloadv2/jsb/AbsBulletClearPreloadCacheMethodIDL$BulletClearPreloadCacheParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/ies/bullet/preloadv2/jsb/AbsBulletClearPreloadCacheMethodIDL$BulletClearPreloadCacheResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletClearPreloadCacheBridge extends AbsBulletClearPreloadCacheMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsBulletClearPreloadCacheMethodIDL.BulletClearPreloadCacheParamModel) xBaseParamModel, (CompletionBlock<AbsBulletClearPreloadCacheMethodIDL.BulletClearPreloadCacheResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsBulletClearPreloadCacheMethodIDL.BulletClearPreloadCacheParamModel params, CompletionBlock<AbsBulletClearPreloadCacheMethodIDL.BulletClearPreloadCacheResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Boolean highPriority = params.getHighPriority();
        PreloadV2.INSTANCE.clearCache(highPriority != null ? highPriority.booleanValue() : false, true, "bullet.clearPreloadCache");
        CompletionBlock.DefaultImpls.onSuccess$default(callback, XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsBulletClearPreloadCacheMethodIDL.BulletClearPreloadCacheResultModel.class)), (String) null, 2, (Object) null);
    }
}
