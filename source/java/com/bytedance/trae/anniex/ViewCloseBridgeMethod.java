package com.bytedance.trae.anniex;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.trae.anniex.AbsViewCloseMethodIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewCloseBridgeMethod.kt */
@XBridgeMethod(name = "view.close")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/anniex/ViewCloseBridgeMethod;", "Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL;", "<init>", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL$ViewCloseParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/trae/anniex/AbsViewCloseMethodIDL$ViewCloseResultModel;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ViewCloseBridgeMethod extends AbsViewCloseMethodIDL {
    public static final int $stable = 0;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsViewCloseMethodIDL.ViewCloseParamModel params, CompletionBlock<AbsViewCloseMethodIDL.ViewCloseResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Activity ownerActivity = bridgeContext.getOwnerActivity();
            if (ownerActivity == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "no activity context", null, 4, null);
                return;
            }
            ownerActivity.finish();
            AbsViewCloseMethodIDL.ViewCloseResultModel viewCloseResultModel = (AbsViewCloseMethodIDL.ViewCloseResultModel) XBridgeKTXKt.createXModel(AbsViewCloseMethodIDL.ViewCloseResultModel.class);
            viewCloseResultModel.setCode((Number) 0);
            CompletionBlock.DefaultImpls.onSuccess$default(callback, viewCloseResultModel, null, 2, null);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "failed to close";
            }
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, message, null, 4, null);
        }
    }
}
