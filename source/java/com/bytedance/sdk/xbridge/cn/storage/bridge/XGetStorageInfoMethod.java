package com.bytedance.sdk.xbridge.cn.storage.bridge;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.storage.bridge.AbsXGetStorageInfoMethodIDL;
import com.bytedance.sdk.xbridge.cn.storage.utils.NativeProviderFactory;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XGetStorageInfoMethod.kt */
@XBridgeMethod(name = "x.getStorageInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/bridge/XGetStorageInfoMethod;", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXGetStorageInfoMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXGetStorageInfoMethodIDL$XGetStorageInfoParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/storage/bridge/AbsXGetStorageInfoMethodIDL$XGetStorageInfoResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetStorageInfoMethod extends AbsXGetStorageInfoMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetStorageInfoMethodIDL.XGetStorageInfoParamModel params, CompletionBlock<AbsXGetStorageInfoMethodIDL.XGetStorageInfoResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        Set<String> storageInfo = NativeProviderFactory.providerNativeStorage(ownerActivity).getStorageInfo();
        XBaseModel createModel = XBridgeResultModelArguments.INSTANCE.createModel(AbsXGetStorageInfoMethodIDL.XGetStorageInfoResultModel.class);
        ((AbsXGetStorageInfoMethodIDL.XGetStorageInfoResultModel) createModel).setKeys(CollectionsKt.toList(storageInfo));
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createModel, null, 2, null);
    }
}
