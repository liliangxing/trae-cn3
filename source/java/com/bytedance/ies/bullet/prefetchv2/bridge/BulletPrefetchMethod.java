package com.bytedance.ies.bullet.prefetchv2.bridge;

import android.net.Uri;
import com.bytedance.ies.bullet.prefetchv2.PrefetchV2;
import com.bytedance.ies.bullet.prefetchv2.bridge.AbsBulletPrefetchV2MethodIDL;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: BulletPrefetchMethod.kt */
@XBridgeMethod(biz = "bullet", name = "bullet.prefetchV2", owner = "yujingbo.luke")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/bridge/BulletPrefetchMethod;", "Lcom/bytedance/ies/bullet/prefetchv2/bridge/AbsBulletPrefetchV2MethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/ies/bullet/prefetchv2/bridge/AbsBulletPrefetchV2MethodIDL$BulletPrefetchV2ParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/ies/bullet/prefetchv2/bridge/AbsBulletPrefetchV2MethodIDL$BulletPrefetchV2ResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletPrefetchMethod extends AbsBulletPrefetchV2MethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsBulletPrefetchV2MethodIDL.BulletPrefetchV2ParamModel) xBaseParamModel, (CompletionBlock<AbsBulletPrefetchV2MethodIDL.BulletPrefetchV2ResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, final AbsBulletPrefetchV2MethodIDL.BulletPrefetchV2ParamModel params, CompletionBlock<AbsBulletPrefetchV2MethodIDL.BulletPrefetchV2ResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PrefetchV2.INSTANCE.executeInWorker$anniex_release(new Runnable() { // from class: com.bytedance.ies.bullet.prefetchv2.bridge.BulletPrefetchMethod$handle$1
            @Override // java.lang.Runnable
            public final void run() {
                String schema = AbsBulletPrefetchV2MethodIDL.BulletPrefetchV2ParamModel.this.getSchema();
                String bid = AbsBulletPrefetchV2MethodIDL.BulletPrefetchV2ParamModel.this.getBid();
                Uri parse = Uri.parse(schema);
                Unit unit = null;
                if (bid != null) {
                    PrefetchV2 prefetchV2 = PrefetchV2.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(parse, "uri");
                    prefetchV2.prefetchBySchemaUri(parse, null, bid);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    PrefetchV2 prefetchV22 = PrefetchV2.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(parse, "uri");
                    PrefetchV2.prefetchBySchemaUri$default(prefetchV22, parse, null, null, 6, null);
                }
            }
        });
        CompletionBlock.DefaultImpls.onSuccess$default(callback, XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsBulletPrefetchV2MethodIDL.BulletPrefetchV2ResultModel.class)), (String) null, 2, (Object) null);
    }
}
