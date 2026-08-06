package com.bytedance.sdk.xbridge.cn.web;

import android.view.View;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.services.IPiaBridgeService;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.web.AbsPiaInternalTriggerMethodIDL;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PiaTriggerMethod.kt */
@XBridgeMethod(name = "pia.internal.trigger")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/web/PiaTriggerMethod;", "Lcom/bytedance/sdk/xbridge/cn/web/AbsPiaInternalTriggerMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/web/AbsPiaInternalTriggerMethodIDL$PiaInternalTriggerParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/web/AbsPiaInternalTriggerMethodIDL$PiaInternalTriggerResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PiaTriggerMethod extends AbsPiaInternalTriggerMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsPiaInternalTriggerMethodIDL.PiaInternalTriggerParamModel params, final CompletionBlock<AbsPiaInternalTriggerMethodIDL.PiaInternalTriggerResultModel> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        View engineView = bridgeContext.getEngineView();
        if (engineView != null) {
            IPiaBridgeService inst = IPiaBridgeService.inst();
            String name = params.getName();
            Map<String, Object> data = params.getData();
            inst.call(engineView, name, data == null || data.isEmpty() ? (JsonElement) new JsonObject() : new Gson().toJsonTree(params.getData()), new IConsumer() { // from class: com.bytedance.sdk.xbridge.cn.web.PiaTriggerMethod$handle$1$1
                /* JADX WARN: Type inference failed for: r6v1, types: [com.bytedance.sdk.xbridge.cn.web.PiaTriggerMethod$handle$1$1$1$2] */
                /* JADX WARN: Type inference failed for: r6v3, types: [com.bytedance.sdk.xbridge.cn.web.PiaTriggerMethod$handle$1$1$1$1] */
                public final void accept(Object obj) {
                    CompletionBlock<AbsPiaInternalTriggerMethodIDL.PiaInternalTriggerResultModel> completionBlock = callback;
                    XBaseModel createXModel = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsPiaInternalTriggerMethodIDL.PiaInternalTriggerResultModel.class);
                    AbsPiaInternalTriggerMethodIDL.PiaInternalTriggerResultModel piaInternalTriggerResultModel = (AbsPiaInternalTriggerMethodIDL.PiaInternalTriggerResultModel) createXModel;
                    if (obj instanceof JsonObject) {
                        piaInternalTriggerResultModel.setData((Map) new Gson().fromJson((JsonElement) obj, new TypeToken<Map<String, ? extends Object>>() { // from class: com.bytedance.sdk.xbridge.cn.web.PiaTriggerMethod$handle$1$1$1$1
                        }.getType()));
                        piaInternalTriggerResultModel.setCode((Number) 1);
                        piaInternalTriggerResultModel.setMsg("success");
                    } else {
                        piaInternalTriggerResultModel.setData((Map) new Gson().fromJson(new Gson().toJsonTree(obj), new TypeToken<Map<String, ? extends Object>>() { // from class: com.bytedance.sdk.xbridge.cn.web.PiaTriggerMethod$handle$1$1$1$2
                        }.getType()));
                        piaInternalTriggerResultModel.setCode((Number) 1);
                        piaInternalTriggerResultModel.setMsg("success");
                    }
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                }
            }, new IConsumer() { // from class: com.bytedance.sdk.xbridge.cn.web.PiaTriggerMethod$handle$1$2
                public final void accept(PiaMethod.Error error) {
                    String str;
                    CompletionBlock<AbsPiaInternalTriggerMethodIDL.PiaInternalTriggerResultModel> completionBlock = callback;
                    int code = error != null ? error.getCode() : 0;
                    if (error == null || (str = error.getMessage()) == null) {
                        str = "";
                    }
                    CompletionBlock.DefaultImpls.onFailure$default(completionBlock, code, str, null, 4, null);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "lack of engineView", null, 4, null);
        }
    }
}
