package com.bytedance.ies.bullet.preloadv2.jsb;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.preloadv2.PreloadConfig;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.ies.bullet.preloadv2.jsb.AbsBulletPreloadResourceMethodIDL;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* compiled from: BulletPreloadResourceBridge.kt */
@XBridgeMethod(name = "bullet.preloadResource", owner = "liushaocong")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/jsb/BulletPreloadResourceBridge;", "Lcom/bytedance/ies/bullet/preloadv2/jsb/AbsBulletPreloadResourceMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/ies/bullet/preloadv2/jsb/AbsBulletPreloadResourceMethodIDL$BulletPreloadResourceParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/ies/bullet/preloadv2/jsb/AbsBulletPreloadResourceMethodIDL$BulletPreloadResourceResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletPreloadResourceBridge extends AbsBulletPreloadResourceMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsBulletPreloadResourceMethodIDL.BulletPreloadResourceParamModel) xBaseParamModel, (CompletionBlock<AbsBulletPreloadResourceMethodIDL.BulletPreloadResourceResultModel>) completionBlock);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[Catch: Exception -> 0x0089, TryCatch #0 {Exception -> 0x0089, blocks: (B:3:0x0010, B:5:0x001b, B:10:0x0027, B:12:0x003b, B:14:0x0041, B:18:0x004a, B:20:0x0053, B:23:0x005c, B:24:0x0077, B:28:0x0062, B:30:0x0068), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c A[Catch: Exception -> 0x0089, TryCatch #0 {Exception -> 0x0089, blocks: (B:3:0x0010, B:5:0x001b, B:10:0x0027, B:12:0x003b, B:14:0x0041, B:18:0x004a, B:20:0x0053, B:23:0x005c, B:24:0x0077, B:28:0x0062, B:30:0x0068), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[Catch: Exception -> 0x0089, TryCatch #0 {Exception -> 0x0089, blocks: (B:3:0x0010, B:5:0x001b, B:10:0x0027, B:12:0x003b, B:14:0x0041, B:18:0x004a, B:20:0x0053, B:23:0x005c, B:24:0x0077, B:28:0x0062, B:30:0x0068), top: B:2:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(IBDXBridgeContext bridgeContext, AbsBulletPreloadResourceMethodIDL.BulletPreloadResourceParamModel params, CompletionBlock<AbsBulletPreloadResourceMethodIDL.BulletPreloadResourceResultModel> callback) {
        boolean z;
        String str;
        String str2;
        BulletContext bulletContext;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            String bid = params.getBid();
            String str3 = bid;
            if (str3 != null && str3.length() != 0) {
                z = false;
                if (z) {
                    IBulletContainer iBulletContainer = (IBulletContainer) ContextProviderManager.INSTANCE.getProviderFactory(bridgeContext.getContainerID()).provideInstance(IBulletContainer.class);
                    if (iBulletContainer == null || (bulletContext = iBulletContainer.getBulletContext()) == null || (str2 = bulletContext.getBid()) == null) {
                        str2 = "default_bid";
                    }
                    bid = str2;
                }
                String schema = params.getSchema();
                str = schema;
                if (str != null || str.length() == 0) {
                    PreloadV2.INSTANCE.preload(schema, bid);
                } else {
                    Map<String, Object> config = params.getConfig();
                    if (config != null) {
                        PreloadV2.INSTANCE.preload(new PreloadConfig(new JSONObject(config)), bid);
                    }
                }
                CompletionBlock.DefaultImpls.onSuccess$default(callback, XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsBulletPreloadResourceMethodIDL.BulletPreloadResourceResultModel.class)), (String) null, 2, (Object) null);
            }
            z = true;
            if (z) {
            }
            String schema2 = params.getSchema();
            str = schema2;
            if (str != null || str.length() == 0) {
            }
            CompletionBlock.DefaultImpls.onSuccess$default(callback, XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsBulletPreloadResourceMethodIDL.BulletPreloadResourceResultModel.class)), (String) null, 2, (Object) null);
        } catch (Exception e) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -1, e.toString(), (XBaseResultModel) null, 4, (Object) null);
        }
    }
}
