package com.bytedance.upc.bridge.impl;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.upc.bridge.abs.AbsCopyToClipboardMethodIDL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CopyToClipboardMethodIDLImpl.kt */
@XBridgeMethod(name = "copyToClipboard", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/upc/bridge/impl/CopyToClipboardMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsCopyToClipboardMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/bridge/abs/AbsCopyToClipboardMethodIDL$CopyToClipboardParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsCopyToClipboardMethodIDL$CopyToClipboardResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class CopyToClipboardMethodIDLImpl extends AbsCopyToClipboardMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsCopyToClipboardMethodIDL.CopyToClipboardParamModel) xBaseParamModel, (CompletionBlock<AbsCopyToClipboardMethodIDL.CopyToClipboardResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsCopyToClipboardMethodIDL.CopyToClipboardParamModel params, CompletionBlock<AbsCopyToClipboardMethodIDL.CopyToClipboardResultModel> callback) {
        Context context;
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            View engineView = bridgeContext.getEngineView();
            if (engineView == null || (context = engineView.getContext()) == null) {
                CopyToClipboardMethodIDLImpl copyToClipboardMethodIDLImpl = this;
                CompletionBlock.DefaultImpls.onFailure$default(callback, -1, "context is null", (XBaseResultModel) null, 4, (Object) null);
                return;
            }
            Object systemService = context.getSystemService("clipboard");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("upc_webview_clip", params.getContent()));
            CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsCopyToClipboardMethodIDL.CopyToClipboardResultModel() { // from class: com.bytedance.upc.bridge.impl.CopyToClipboardMethodIDLImpl$handle$1
                @Override // com.bytedance.upc.bridge.abs.AbsCopyToClipboardMethodIDL.CopyToClipboardResultModel
                public void setCode(Number number) {
                }

                @Override // com.bytedance.upc.bridge.abs.AbsCopyToClipboardMethodIDL.CopyToClipboardResultModel
                public Number getCode() {
                    return (Number) 0;
                }

                public Map<String, Object> convert() {
                    return MapsKt.mapOf(TuplesKt.to("code", 0));
                }

                public JSONObject toJSON() {
                    return new JSONObject();
                }
            }, (String) null, 2, (Object) null);
        } catch (Throwable unused) {
        }
    }
}
