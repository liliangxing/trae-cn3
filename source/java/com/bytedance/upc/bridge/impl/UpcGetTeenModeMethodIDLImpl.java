package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IUpcTeenModeService;
import com.bytedance.upc.bridge.abs.AbsUpcGetTeenModeMethodIDL;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpcGetTeenModeMethodIDLImpl.kt */
@XBridgeMethod(name = "upc.getTeenMode", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/upc/bridge/impl/UpcGetTeenModeMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetTeenModeMethodIDL;", "()V", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "getMConfiguration", "()Lcom/bytedance/upc/Configuration;", "mConfiguration$delegate", "Lkotlin/Lazy;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetTeenModeMethodIDL$UpcGetTeenModeParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsUpcGetTeenModeMethodIDL$UpcGetTeenModeResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcGetTeenModeMethodIDLImpl extends AbsUpcGetTeenModeMethodIDL {

    /* renamed from: mConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy mConfiguration = LazyKt.lazy(new Function0<Configuration>() { // from class: com.bytedance.upc.bridge.impl.UpcGetTeenModeMethodIDLImpl$mConfiguration$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Configuration m3482invoke() {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        }
    });

    private final Configuration getMConfiguration() {
        return (Configuration) this.mConfiguration.getValue();
    }

    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeParamModel) xBaseParamModel, (CompletionBlock<AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeParamModel params, final CompletionBlock<AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            IUpcTeenModeService iUpcTeenModeService = getMConfiguration().mIUpcTeenModeService;
            if (iUpcTeenModeService != null) {
                iUpcTeenModeService.getTeenModeEnable(new Function1<Boolean, Unit>() { // from class: com.bytedance.upc.bridge.impl.UpcGetTeenModeMethodIDLImpl$handle$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Boolean) obj).booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final boolean z) {
                        if (z) {
                            CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcGetTeenModeMethodIDLImpl$handle$1.1
                                @Override // com.bytedance.upc.bridge.abs.AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeResultModel
                                public void setStatus(Boolean bool) {
                                }

                                @Override // com.bytedance.upc.bridge.abs.AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeResultModel
                                public Boolean getStatus() {
                                    return Boolean.valueOf(z);
                                }

                                public Map<String, Object> convert() {
                                    return MapsKt.mapOf(TuplesKt.to("status", Boolean.valueOf(z)));
                                }

                                public JSONObject toJSON() {
                                    return new JSONObject();
                                }
                            }, (String) null, 2, (Object) null);
                        } else {
                            callback.onFailure(-1, "", new AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcGetTeenModeMethodIDLImpl$handle$1.2
                                @Override // com.bytedance.upc.bridge.abs.AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeResultModel
                                public void setStatus(Boolean bool) {
                                }

                                @Override // com.bytedance.upc.bridge.abs.AbsUpcGetTeenModeMethodIDL.UpcGetTeenModeResultModel
                                public Boolean getStatus() {
                                    return Boolean.valueOf(z);
                                }

                                public Map<String, Object> convert() {
                                    return MapsKt.mapOf(TuplesKt.to("status", Boolean.valueOf(z)));
                                }

                                public JSONObject toJSON() {
                                    return new JSONObject();
                                }
                            });
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
