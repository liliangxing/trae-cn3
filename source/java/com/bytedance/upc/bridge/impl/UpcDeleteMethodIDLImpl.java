package com.bytedance.upc.bridge.impl;

import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.upc.IDeleteEventService;
import com.bytedance.upc.bridge.abs.AbsUpcDeleteMethodIDL;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpcDeleteMethodIDLImpl.kt */
@XBridgeMethod(name = "upc.delete", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/upc/bridge/impl/UpcDeleteMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsUpcDeleteMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/bridge/abs/AbsUpcDeleteMethodIDL$UpcDeleteParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsUpcDeleteMethodIDL$UpcDeleteResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcDeleteMethodIDLImpl extends AbsUpcDeleteMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsUpcDeleteMethodIDL.UpcDeleteParamModel) xBaseParamModel, (CompletionBlock<AbsUpcDeleteMethodIDL.UpcDeleteResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsUpcDeleteMethodIDL.UpcDeleteParamModel params, CompletionBlock<AbsUpcDeleteMethodIDL.UpcDeleteResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        IDeleteEventService iDeleteEventService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIDeleteEventService;
        if (iDeleteEventService == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -1, "business don't set deleteEventService", (XBaseResultModel) null, 4, (Object) null);
            return;
        }
        try {
            Number type = params.getType();
            if (type == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            if (iDeleteEventService.onDeleteEvent(((Integer) type).intValue())) {
                CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsUpcDeleteMethodIDL.UpcDeleteResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcDeleteMethodIDLImpl$handle$1
                    public Map<String, Object> convert() {
                        return MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to(Constants.KEY_DATA, "success")});
                    }

                    public JSONObject toJSON() {
                        return new JSONObject();
                    }
                }, (String) null, 2, (Object) null);
            } else {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -1, "business return false, delete failed", (XBaseResultModel) null, 4, (Object) null);
            }
        } catch (Throwable th) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -1, "business be called, and throw a exception " + th, (XBaseResultModel) null, 4, (Object) null);
        }
    }
}
