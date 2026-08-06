package com.bytedance.sdk.xbridge.cn.p003ui;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.p003ui.AbsXShowToastMethodIDL;
import com.bytedance.sdk.xbridge.cn.p003ui.impl.DefaultHostSytleUIDependImpl;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.trae.conversation.fileupload.FileUploadService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XShowToastMethod.kt */
@XBridgeMethod(name = "x.showToast")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XShowToastMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowToastMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowToastMethodIDL$XShowToastParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowToastMethodIDL$XShowToastResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XShowToastMethod extends AbsXShowToastMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXShowToastMethodIDL.XShowToastParamModel params, CompletionBlock<AbsXShowToastMethodIDL.XShowToastResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            callback.onFailure(0, "context not provided in host", (XBaseResultModel) XBridgeKTXKt.createXModel(AbsXShowToastMethodIDL.XShowToastResultModel.class));
            return;
        }
        if (params.getType() == null && params.getIcon() == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "either type or icon should have value", null, 4, null);
            return;
        }
        if (params.getMessage().length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "message can not be empty", null, 4, null);
            return;
        }
        Number duration = params.getDuration();
        ToastBuilder toastBuilder = new ToastBuilder(ownerActivity, params.getMessage(), params.getType(), Integer.valueOf(duration != null ? duration.intValue() : FileUploadService.LOG_CHUNK_SIZE), params.getIcon(), params.getCustomIcon());
        IHostStyleUIDepend uIDependInstance = RuntimeHelper.INSTANCE.getUIDependInstance(bridgeContext);
        if (!Intrinsics.areEqual(uIDependInstance != null ? uIDependInstance.showToast(toastBuilder) : null, true)) {
            new DefaultHostSytleUIDependImpl().showToast(toastBuilder);
        }
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(AbsXShowToastMethodIDL.XShowToastResultModel.class), null, 2, null);
    }
}
