package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.bridge.abs.AbsUpcGetApiRecordStatusMethodIDL;
import com.bytedance.upc.cache.ApiHookRecord;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UpcGetApiRecordStatusMethodIDLImpl.kt */
@XBridgeMethod(name = "upc.getApiRecordStatus", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/upc/bridge/impl/UpcGetApiRecordStatusMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetApiRecordStatusMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetApiRecordStatusMethodIDL$UpcGetApiRecordStatusParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetApiRecordStatusMethodIDL$UpcGetApiRecordStatusResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcGetApiRecordStatusMethodIDLImpl extends AbsUpcGetApiRecordStatusMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsUpcGetApiRecordStatusMethodIDL.UpcGetApiRecordStatusParamModel) xBaseParamModel, (CompletionBlock<AbsUpcGetApiRecordStatusMethodIDL.UpcGetApiRecordStatusResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsUpcGetApiRecordStatusMethodIDL.UpcGetApiRecordStatusParamModel params, final CompletionBlock<AbsUpcGetApiRecordStatusMethodIDL.UpcGetApiRecordStatusResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            ApiHookRecord apiHookRecord = ApiHookRecord.INSTANCE;
            Number limit = params.getLimit();
            if (limit == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            apiHookRecord.getApiRecord(((Integer) limit).intValue(), new Function1<JSONArray, Unit>() { // from class: com.bytedance.upc.bridge.impl.UpcGetApiRecordStatusMethodIDLImpl$handle$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((JSONArray) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(final JSONArray jSONArray) {
                    Intrinsics.checkParameterIsNotNull(jSONArray, "it");
                    CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsUpcGetApiRecordStatusMethodIDL.UpcGetApiRecordStatusResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcGetApiRecordStatusMethodIDLImpl$handle$1.1
                        public Map<String, Object> convert() {
                            return MapsKt.mapOf(TuplesKt.to("stats", jSONArray));
                        }

                        public JSONObject toJSON() {
                            return new JSONObject();
                        }
                    }, (String) null, 2, (Object) null);
                }
            });
        } catch (Throwable unused) {
        }
    }
}
