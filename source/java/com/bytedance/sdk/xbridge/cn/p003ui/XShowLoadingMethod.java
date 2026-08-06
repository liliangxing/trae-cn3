package com.bytedance.sdk.xbridge.cn.p003ui;

import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.container.util.AnnieXUtilsKt;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.base.runtime.model.XShowLoadingParams;
import com.bytedance.sdk.xbridge.cn.p003ui.AbsXShowLoadingMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XShowLoadingMethod.kt */
@XBridgeMethod(name = "x.showLoading")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XShowLoadingMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowLoadingMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowLoadingMethodIDL$XShowLoadingParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowLoadingMethodIDL$XShowLoadingResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XShowLoadingMethod extends AbsXShowLoadingMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXShowLoadingMethodIDL.XShowLoadingParamModel params, CompletionBlock<AbsXShowLoadingMethodIDL.XShowLoadingResultModel> callback) {
        Boolean showLoading;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new XShowLoadingParams().setText(params.getText());
        IContainer isAnnieXLite = AnnieXLiteUtilsKt.isAnnieXLite(bridgeContext);
        Unit unit = null;
        if (isAnnieXLite != null) {
            isAnnieXLite.showLoading();
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(AbsXShowLoadingMethodIDL.XShowLoadingResultModel.class), null, 2, null);
            return;
        }
        IContainer isAnnieX = AnnieXUtilsKt.isAnnieX(bridgeContext);
        if (isAnnieX != null) {
            isAnnieX.showLoading();
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(AbsXShowLoadingMethodIDL.XShowLoadingResultModel.class), null, 2, null);
            return;
        }
        IHostStyleUIDepend uIDependInstance = RuntimeHelper.INSTANCE.getUIDependInstance(bridgeContext);
        if (uIDependInstance != null && (showLoading = uIDependInstance.showLoading(bridgeContext)) != null) {
            showLoading.booleanValue();
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(AbsXShowLoadingMethodIDL.XShowLoadingResultModel.class), null, 2, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, null, null, 6, null);
        }
    }
}
