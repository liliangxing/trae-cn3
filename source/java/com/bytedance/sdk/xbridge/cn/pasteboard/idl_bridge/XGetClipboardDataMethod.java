package com.bytedance.sdk.xbridge.cn.pasteboard.idl_bridge;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.MethodModelBean;
import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.pasteboard.idl.AbsXGetClipboardDataMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostSystemActionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XGetClipboardDataMethod.kt */
@XBridgeMethod(name = "x.getClipboardData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/pasteboard/idl_bridge/XGetClipboardDataMethod;", "Lcom/bytedance/sdk/xbridge/cn/pasteboard/idl/AbsXGetClipboardDataMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/pasteboard/idl/AbsXGetClipboardDataMethodIDL$XGetClipboardDataParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/pasteboard/idl/AbsXGetClipboardDataMethodIDL$XGetClipboardDataResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetClipboardDataMethod extends AbsXGetClipboardDataMethodIDL {
    /* JADX WARN: Multi-variable type inference failed */
    public XGetClipboardDataMethod() {
        XBridgeDynamicModel.INSTANCE.addMethodModelMap(getClass(), new MethodModelBean(AbsXGetClipboardDataMethodIDL.XGetClipboardDataParamModel.class, AbsXGetClipboardDataMethodIDL.XGetClipboardDataResultModel.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetClipboardDataMethodIDL.XGetClipboardDataParamModel params, CompletionBlock<AbsXGetClipboardDataMethodIDL.XGetClipboardDataResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Activity ownerActivity = bridgeContext.getOwnerActivity();
            if (ownerActivity == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context is null", null, 4, null);
                return;
            }
            IHostSystemActionDepend hostSystemActionDepend = XBaseRuntime.INSTANCE.getHostSystemActionDepend();
            ClipData primaryClip = hostSystemActionDepend != null ? hostSystemActionDepend.getPrimaryClip(ownerActivity, bridgeContext, getName()) : null;
            Integer valueOf = primaryClip != null ? Integer.valueOf(primaryClip.getItemCount()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(AbsXGetClipboardDataMethodIDL.XGetClipboardDataResultModel.class), "success");
            }
            ClipData.Item itemAt = primaryClip != null ? primaryClip.getItemAt(0) : null;
            CharSequence text = itemAt != null ? itemAt.getText() : null;
            if (Intrinsics.areEqual("", text)) {
                text = null;
            }
            XBaseModel createXModel = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsXGetClipboardDataMethodIDL.XGetClipboardDataResultModel.class);
            ((AbsXGetClipboardDataMethodIDL.XGetClipboardDataResultModel) createXModel).setText(text != null ? text.toString() : null);
            callback.onSuccess((XBaseResultModel) createXModel, "success");
        } catch (Exception e) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, String.valueOf(e.getMessage()), null, 4, null);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return Build.VERSION.SDK_INT >= 26;
    }
}
