package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IPrivacyService;
import com.bytedance.upc.bridge.abs.AbsUpcChangePrivacyStatusMethodIDL;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpcChangePrivacyStatusMethodIDLImpl.kt */
@XBridgeMethod(name = "upc.changePrivacyStatus", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/upc/bridge/impl/UpcChangePrivacyStatusMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsUpcChangePrivacyStatusMethodIDL;", "()V", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "getMConfiguration", "()Lcom/bytedance/upc/Configuration;", "mConfiguration$delegate", "Lkotlin/Lazy;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/bridge/abs/AbsUpcChangePrivacyStatusMethodIDL$UpcChangePrivacyStatusParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsUpcChangePrivacyStatusMethodIDL$UpcChangePrivacyStatusResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcChangePrivacyStatusMethodIDLImpl extends AbsUpcChangePrivacyStatusMethodIDL {

    /* renamed from: mConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy mConfiguration = LazyKt.lazy(new Function0<Configuration>() { // from class: com.bytedance.upc.bridge.impl.UpcChangePrivacyStatusMethodIDLImpl$mConfiguration$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Configuration m3479invoke() {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        }
    });

    private final Configuration getMConfiguration() {
        return (Configuration) this.mConfiguration.getValue();
    }

    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusParamModel) xBaseParamModel, (CompletionBlock<AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusParamModel params, CompletionBlock<AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            IPrivacyService.DefaultImpls.setPrivacyStatus$default(getMConfiguration().mIPrivacyService, params.getType(), params.getStatus() ? "on" : "off", 0, 4, (Object) null);
            CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcChangePrivacyStatusMethodIDLImpl$handle$1
                @Override // com.bytedance.upc.bridge.abs.AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusResultModel
                public void setStatus(Boolean bool) {
                }

                @Override // com.bytedance.upc.bridge.abs.AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusResultModel
                public Boolean getStatus() {
                    return true;
                }

                public Map<String, Object> convert() {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("status", true);
                    return linkedHashMap;
                }

                public JSONObject toJSON() {
                    return new JSONObject();
                }
            }, (String) null, 2, (Object) null);
        } catch (Throwable unused) {
            callback.onFailure(-1, "", new AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcChangePrivacyStatusMethodIDLImpl$handle$2
                @Override // com.bytedance.upc.bridge.abs.AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusResultModel
                public void setStatus(Boolean bool) {
                }

                @Override // com.bytedance.upc.bridge.abs.AbsUpcChangePrivacyStatusMethodIDL.UpcChangePrivacyStatusResultModel
                public Boolean getStatus() {
                    return false;
                }

                public Map<String, Object> convert() {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("status", false);
                    return linkedHashMap;
                }

                public JSONObject toJSON() {
                    return new JSONObject();
                }
            });
        }
    }
}
