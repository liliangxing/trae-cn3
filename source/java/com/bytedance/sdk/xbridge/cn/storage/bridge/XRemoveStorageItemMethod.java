package com.bytedance.sdk.xbridge.cn.storage.bridge;

import android.app.Activity;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.storage.bridge.AbsXRemoveStorageItemMethodIDL;
import com.bytedance.sdk.xbridge.cn.storage.utils.NativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XRemoveStorageItemMethod.kt */
@XBridgeMethod(name = "x.removeStorageItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/bridge/XRemoveStorageItemMethod;", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXRemoveStorageItemMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXRemoveStorageItemMethodIDL$XRemoveStorageItemParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXRemoveStorageItemMethodIDL$XRemoveStorageItemResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XRemoveStorageItemMethod extends AbsXRemoveStorageItemMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXRemoveStorageItemMethodIDL.XRemoveStorageItemParamModel params, CompletionBlock<AbsXRemoveStorageItemMethodIDL.XRemoveStorageItemResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage("session_id", bridgeContext.getContainerID());
        loggerContext.pushStage(XBridgeInjectLogger.CALL_ID, bridgeContext.getCallId());
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        String key = params.getKey();
        String biz = params.getBiz();
        HybridLogger.INSTANCE.i("BridgeParam", "x.removeStorageItem param", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("biz", biz)}), loggerContext);
        String str = key;
        if (str == null || str.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "", null, 4, null);
            return;
        }
        String str2 = biz;
        if (str2 == null || str2.length() == 0) {
            IHostExternalStorageDepend externalStorageDependInstance = RuntimeHelper.INSTANCE.getExternalStorageDependInstance();
            HybridLogger.INSTANCE.i("BridgeResult", "x.removeStorageItem removeHostDepend data", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("result", externalStorageDependInstance != null ? Boolean.valueOf(externalStorageDependInstance.removeStorageValue(key)) : null)}), loggerContext);
        }
        boolean tryRemoveBizStorageItem = INativeStorageExtensionsKt.tryRemoveBizStorageItem(NativeProviderFactory.providerNativeStorage(ownerActivity), biz, key);
        HybridLogger.INSTANCE.i("BridgeResult", "x.removeStorageItem data", MapsKt.mapOf(new Pair[]{TuplesKt.to("key", key), TuplesKt.to("result", Boolean.valueOf(tryRemoveBizStorageItem))}), loggerContext);
        if (tryRemoveBizStorageItem) {
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(AbsXRemoveStorageItemMethodIDL.XRemoveStorageItemResultModel.class), null, 2, null);
        } else {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 2, "Key is not found in certain storage", null, 4, null);
        }
    }
}
