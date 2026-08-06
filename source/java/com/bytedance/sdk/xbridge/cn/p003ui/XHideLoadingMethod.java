package com.bytedance.sdk.xbridge.cn.p003ui;

import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.container.util.AnnieXUtilsKt;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.MethodModelBean;
import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.p003ui.AbsXHideLoadingMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XHideLoadingMethod.kt */
@XBridgeMethod(name = "x.hideLoading")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XHideLoadingMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXHideLoadingMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXHideLoadingMethodIDL$XHideLoadingParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXHideLoadingMethodIDL$XHideLoadingResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XHideLoadingMethod extends AbsXHideLoadingMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XHideLoadingMethod() {
        XBridgeDynamicModel.INSTANCE.addMethodModelMap(getClass(), new MethodModelBean(AbsXHideLoadingMethodIDL.XHideLoadingParamModel.class, AbsXHideLoadingMethodIDL.XHideLoadingResultModel.class));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXHideLoadingMethodIDL.XHideLoadingParamModel params, CompletionBlock<AbsXHideLoadingMethodIDL.XHideLoadingResultModel> callback) {
        Boolean hideLoading;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IContainer isAnnieXLite = AnnieXLiteUtilsKt.isAnnieXLite(bridgeContext);
        Unit unit = null;
        if (isAnnieXLite != null) {
            isAnnieXLite.hideLoading();
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(AbsXHideLoadingMethodIDL.XHideLoadingResultModel.class), null, 2, null);
            return;
        }
        IContainer isAnnieX = AnnieXUtilsKt.isAnnieX(bridgeContext);
        if (isAnnieX != null) {
            isAnnieX.hideLoading();
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(AbsXHideLoadingMethodIDL.XHideLoadingResultModel.class), null, 2, null);
            return;
        }
        IHostStyleUIDepend uIDependInstance = RuntimeHelper.INSTANCE.getUIDependInstance(bridgeContext);
        if (uIDependInstance != null && (hideLoading = uIDependInstance.hideLoading(bridgeContext)) != null) {
            hideLoading.booleanValue();
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXHideLoadingMethodIDL.XHideLoadingResultModel.class)), null, 2, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, null, null, 6, null);
        }
    }
}
