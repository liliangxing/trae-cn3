package com.bytedance.sdk.xbridge.cn.p003ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.p003ui.AbsXShowModalMethodIDL;
import com.bytedance.sdk.xbridge.cn.p003ui.impl.DefaultHostSytleUIDependImpl;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XShowModalMethod.kt */
@XBridgeMethod(name = "x.showModal")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/XShowModalMethod;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowModalMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowModalMethodIDL$XShowModalParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/ui/AbsXShowModalMethodIDL$XShowModalResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XShowModalMethod extends AbsXShowModalMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004f  */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(IBDXBridgeContext bridgeContext, AbsXShowModalMethodIDL.XShowModalParamModel params, final CompletionBlock<AbsXShowModalMethodIDL.XShowModalResultModel> callback) {
        boolean z;
        String str;
        DialogInterface.OnClickListener onClickListener;
        DialogBuilder dialogBuilder;
        IHostStyleUIDepend uIDependInstance;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        boolean tapMaskToDismiss = params.getTapMaskToDismiss();
        String confirmText = params.getConfirmText();
        boolean z2 = false;
        if (confirmText != null) {
            if (confirmText.length() > 0) {
                z = true;
                String confirmText2 = !z ? params.getConfirmText() : "confirm";
                String content = params.getContent();
                String title = params.getTitle();
                DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.xbridge.cn.ui.XShowModalMethod$handle$positiveClickListener$1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CompletionBlock<AbsXShowModalMethodIDL.XShowModalResultModel> completionBlock = callback;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXShowModalMethodIDL.XShowModalResultModel.class));
                        ((AbsXShowModalMethodIDL.XShowModalResultModel) createXModel).setAction("confirm");
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                    }
                };
                if (params.getShowCancel()) {
                    str = null;
                    onClickListener = null;
                } else {
                    String cancelText = params.getCancelText();
                    if (cancelText != null) {
                        if (cancelText.length() > 0) {
                            z2 = true;
                        }
                    }
                    str = z2 ? params.getCancelText() : "cancel";
                    onClickListener = new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.xbridge.cn.ui.XShowModalMethod$handle$1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            CompletionBlock<AbsXShowModalMethodIDL.XShowModalResultModel> completionBlock = callback;
                            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXShowModalMethodIDL.XShowModalResultModel.class));
                            ((AbsXShowModalMethodIDL.XShowModalResultModel) createXModel).setAction("cancel");
                            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                        }
                    };
                }
                dialogBuilder = new DialogBuilder(ownerActivity, title, content, confirmText2, onClickListener2, str, onClickListener, !tapMaskToDismiss ? new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.xbridge.cn.ui.XShowModalMethod$handle$cancelListener$1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        CompletionBlock<AbsXShowModalMethodIDL.XShowModalResultModel> completionBlock = callback;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXShowModalMethodIDL.XShowModalResultModel.class));
                        ((AbsXShowModalMethodIDL.XShowModalResultModel) createXModel).setAction("mask");
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                    }
                } : null, tapMaskToDismiss);
                uIDependInstance = RuntimeHelper.INSTANCE.getUIDependInstance(bridgeContext);
                if (Intrinsics.areEqual(uIDependInstance != null ? uIDependInstance.showDialog(dialogBuilder) : null, true)) {
                    new DefaultHostSytleUIDependImpl().showDialog(dialogBuilder);
                    return;
                }
                return;
            }
        }
        z = false;
        String confirmText22 = !z ? params.getConfirmText() : "confirm";
        String content2 = params.getContent();
        String title2 = params.getTitle();
        DialogInterface.OnClickListener onClickListener22 = new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.xbridge.cn.ui.XShowModalMethod$handle$positiveClickListener$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CompletionBlock<AbsXShowModalMethodIDL.XShowModalResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXShowModalMethodIDL.XShowModalResultModel.class));
                ((AbsXShowModalMethodIDL.XShowModalResultModel) createXModel).setAction("confirm");
                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
            }
        };
        if (params.getShowCancel()) {
        }
        dialogBuilder = new DialogBuilder(ownerActivity, title2, content2, confirmText22, onClickListener22, str, onClickListener, !tapMaskToDismiss ? new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.xbridge.cn.ui.XShowModalMethod$handle$cancelListener$1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                CompletionBlock<AbsXShowModalMethodIDL.XShowModalResultModel> completionBlock = callback;
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXShowModalMethodIDL.XShowModalResultModel.class));
                ((AbsXShowModalMethodIDL.XShowModalResultModel) createXModel).setAction("mask");
                CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
            }
        } : null, tapMaskToDismiss);
        uIDependInstance = RuntimeHelper.INSTANCE.getUIDependInstance(bridgeContext);
        if (Intrinsics.areEqual(uIDependInstance != null ? uIDependInstance.showDialog(dialogBuilder) : null, true)) {
        }
    }
}
