package com.bytedance.upc.bridge.impl;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IUpcTeenModeService;
import com.bytedance.upc.bridge.abs.AbsUpcSetTeenModeMethodIDL;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
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

/* compiled from: UpcSetTeenModeMethodIDLImpl.kt */
@XBridgeMethod(name = "upc.setTeenMode", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001e\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/upc/bridge/impl/UpcSetTeenModeMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsUpcSetTeenModeMethodIDL;", "()V", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "getMConfiguration", "()Lcom/bytedance/upc/Configuration;", "mConfiguration$delegate", "Lkotlin/Lazy;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/bridge/abs/AbsUpcSetTeenModeMethodIDL$UpcSetTeenModeParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsUpcSetTeenModeMethodIDL$UpcSetTeenModeResultModel;", "showToast", "bridgeContextRef", "Ljava/lang/ref/WeakReference;", StrategyConstants.RESULT, "", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcSetTeenModeMethodIDLImpl extends AbsUpcSetTeenModeMethodIDL {
    public static final String TOAST_FAILED_MSG = "密码错误，请重新输入";
    public static final String TOAST_SUCCESS_MSG = "设置密码成功";

    /* renamed from: mConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy mConfiguration = LazyKt.lazy(new Function0<Configuration>() { // from class: com.bytedance.upc.bridge.impl.UpcSetTeenModeMethodIDLImpl$mConfiguration$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Configuration m3483invoke() {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        }
    });

    private final Configuration getMConfiguration() {
        return (Configuration) this.mConfiguration.getValue();
    }

    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsUpcSetTeenModeMethodIDL.UpcSetTeenModeParamModel) xBaseParamModel, (CompletionBlock<AbsUpcSetTeenModeMethodIDL.UpcSetTeenModeResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsUpcSetTeenModeMethodIDL.UpcSetTeenModeParamModel params, final CompletionBlock<AbsUpcSetTeenModeMethodIDL.UpcSetTeenModeResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            IUpcTeenModeService iUpcTeenModeService = getMConfiguration().mIUpcTeenModeService;
            if (iUpcTeenModeService != null) {
                iUpcTeenModeService.setTeenModeEnable(params.getStatus(), params.getPassword(), new Function1<Boolean, Unit>() { // from class: com.bytedance.upc.bridge.impl.UpcSetTeenModeMethodIDLImpl$handle$1
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
                            CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsUpcSetTeenModeMethodIDL.UpcSetTeenModeResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcSetTeenModeMethodIDLImpl$handle$1.1
                                public Map<String, Object> convert() {
                                    return MapsKt.mapOf(TuplesKt.to("status", Boolean.valueOf(z)));
                                }

                                public JSONObject toJSON() {
                                    return new JSONObject();
                                }
                            }, (String) null, 2, (Object) null);
                        } else {
                            callback.onFailure(-1, "", new AbsUpcSetTeenModeMethodIDL.UpcSetTeenModeResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcSetTeenModeMethodIDLImpl$handle$1.2
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
        } catch (Throwable th) {
            LogUtils.e(th);
        }
    }

    private final void showToast(WeakReference<IBDXBridgeContext> bridgeContextRef, boolean result) {
        View engineView;
        Context context;
        if (result) {
            return;
        }
        try {
            IBDXBridgeContext iBDXBridgeContext = bridgeContextRef.get();
            if (iBDXBridgeContext == null || (engineView = iBDXBridgeContext.getEngineView()) == null || (context = engineView.getContext()) == null) {
                return;
            }
            Toast.makeText(context, TOAST_FAILED_MSG, 0).show();
        } catch (Throwable unused) {
        }
    }
}
