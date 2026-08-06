package com.bytedance.upc.bridge.impl;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IPrivacyService;
import com.bytedance.upc.IUpcCertBusinessService;
import com.bytedance.upc.IUpcCertInitServive;
import com.bytedance.upc.IUpcCertService;
import com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpcCheckFaceMethodIDLImpl.kt */
@XBridgeMethod(name = "upc.checkFace", owner = "wanglijie.skin")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J&\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/upc/bridge/impl/UpcCheckFaceMethodIDLImpl;", "Lcom/bytedance/upc/bridge/abs/AbsUpcCheckFaceMethodIDL;", "()V", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "getMConfiguration", "()Lcom/bytedance/upc/Configuration;", "mConfiguration$delegate", "Lkotlin/Lazy;", "mDefaultCertBusinessService", "", "getMDefaultCertBusinessService", "()Ljava/lang/Object;", "mDefaultCertBusinessService$delegate", "mDefaultCertInitService", "getMDefaultCertInitService", "mDefaultCertInitService$delegate", "callFailure", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/bridge/abs/AbsUpcCheckFaceMethodIDL$UpcCheckFaceResultModel;", "handle", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/bridge/abs/AbsUpcCheckFaceMethodIDL$UpcCheckFaceParamModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcCheckFaceMethodIDLImpl extends AbsUpcCheckFaceMethodIDL {

    /* renamed from: mConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy mConfiguration = LazyKt.lazy(new Function0<Configuration>() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$mConfiguration$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Configuration m3480invoke() {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        }
    });

    /* renamed from: mDefaultCertBusinessService$delegate, reason: from kotlin metadata */
    private final Lazy mDefaultCertBusinessService = LazyKt.lazy(new Function0<Object>() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$mDefaultCertBusinessService$2
        public final Object invoke() {
            try {
                return Class.forName("com.bytedance.upc.cert.UpcCertBusinessService").newInstance();
            } catch (Throwable unused) {
                return null;
            }
        }
    });

    /* renamed from: mDefaultCertInitService$delegate, reason: from kotlin metadata */
    private final Lazy mDefaultCertInitService = LazyKt.lazy(new Function0<Object>() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$mDefaultCertInitService$2
        public final Object invoke() {
            try {
                return Class.forName("com.bytedance.upc.cert.UpcCertInitService").newInstance();
            } catch (Throwable unused) {
                return null;
            }
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final Configuration getMConfiguration() {
        return (Configuration) this.mConfiguration.getValue();
    }

    private final Object getMDefaultCertBusinessService() {
        return this.mDefaultCertBusinessService.getValue();
    }

    private final Object getMDefaultCertInitService() {
        return this.mDefaultCertInitService.getValue();
    }

    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsUpcCheckFaceMethodIDL.UpcCheckFaceParamModel) xBaseParamModel, (CompletionBlock<AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsUpcCheckFaceMethodIDL.UpcCheckFaceParamModel params, final CompletionBlock<AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        try {
            String name = params.getName();
            String idCard = params.getIdCard();
            IUpcCertService iUpcCertService = getMConfiguration().mIUpcCertService;
            if ((iUpcCertService != null ? iUpcCertService.initService() : null) != null) {
                IUpcCertInitServive initService = iUpcCertService.initService();
                if (initService != null) {
                    initService.init();
                }
            } else {
                Object mDefaultCertInitService = getMDefaultCertInitService();
                if (mDefaultCertInitService == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.upc.IUpcCertInitServive");
                }
                ((IUpcCertInitServive) mDefaultCertInitService).init();
            }
            if ((iUpcCertService != null ? iUpcCertService.businessService() : null) != null) {
                IUpcCertBusinessService businessService = iUpcCertService.businessService();
                if (businessService != null) {
                    businessService.setCertCallback(new Function1<JSONObject, Unit>() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$1
                        public final void invoke(JSONObject jSONObject) {
                            Intrinsics.checkParameterIsNotNull(jSONObject, "it");
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((JSONObject) obj);
                            return Unit.INSTANCE;
                        }
                    });
                }
                IUpcCertBusinessService businessService2 = iUpcCertService.businessService();
                if (businessService2 != null) {
                    businessService2.startCert(name, idCard, new Function1<Long, Unit>() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long j) {
                            Configuration mConfiguration;
                            if (j == 0) {
                                try {
                                    mConfiguration = UpcCheckFaceMethodIDLImpl.this.getMConfiguration();
                                    IPrivacyService.DefaultImpls.setPrivacyStatus$default(mConfiguration.mIPrivacyService, "key_upc_privacy_teen_mode_status", "off", 0, 4, (Object) null);
                                } catch (Throwable unused) {
                                }
                                CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$2.1
                                    @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
                                    /* renamed from: getErrorMsg */
                                    public String get$msg() {
                                        return "验证成功";
                                    }

                                    @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
                                    public void setErrorCode(Number number) {
                                    }

                                    @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
                                    public void setErrorMsg(String str) {
                                    }

                                    @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
                                    public Number getErrorCode() {
                                        return (Number) 0;
                                    }

                                    public Map<String, Object> convert() {
                                        return MapsKt.mapOf(new Pair[]{TuplesKt.to("errorCode", 0), TuplesKt.to("errorMsg", "sucess")});
                                    }

                                    public JSONObject toJSON() {
                                        return new JSONObject();
                                    }
                                }, (String) null, 2, (Object) null);
                                return;
                            }
                            UpcCheckFaceMethodIDLImpl.this.callFailure((int) j, "", callback);
                        }
                    });
                    return;
                }
                return;
            }
            Object mDefaultCertBusinessService = getMDefaultCertBusinessService();
            if (mDefaultCertBusinessService == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.upc.IUpcCertBusinessService");
            }
            ((IUpcCertBusinessService) mDefaultCertBusinessService).setCertCallback(new Function1<JSONObject, Unit>() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$3
                public final void invoke(JSONObject jSONObject) {
                    Intrinsics.checkParameterIsNotNull(jSONObject, "it");
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((JSONObject) obj);
                    return Unit.INSTANCE;
                }
            });
            Object mDefaultCertBusinessService2 = getMDefaultCertBusinessService();
            if (mDefaultCertBusinessService2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.bytedance.upc.IUpcCertBusinessService");
            }
            ((IUpcCertBusinessService) mDefaultCertBusinessService2).startCert(name, idCard, new Function1<Long, Unit>() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j) {
                    Configuration mConfiguration;
                    if (j == 0) {
                        try {
                            mConfiguration = UpcCheckFaceMethodIDLImpl.this.getMConfiguration();
                            IPrivacyService.DefaultImpls.setPrivacyStatus$default(mConfiguration.mIPrivacyService, "key_upc_privacy_teen_mode_status", "off", 0, 4, (Object) null);
                        } catch (Throwable unused) {
                        }
                        CompletionBlock.DefaultImpls.onSuccess$default(callback, new AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$handle$4.1
                            @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
                            /* renamed from: getErrorMsg */
                            public String get$msg() {
                                return "";
                            }

                            @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
                            public void setErrorCode(Number number) {
                            }

                            @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
                            public void setErrorMsg(String str) {
                            }

                            @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
                            public Number getErrorCode() {
                                return (Number) 0;
                            }

                            public Map<String, Object> convert() {
                                return MapsKt.mapOf(new Pair[]{TuplesKt.to("errorCode", 0), TuplesKt.to("errorMsg", "sucess")});
                            }

                            public JSONObject toJSON() {
                                return new JSONObject();
                            }
                        }, (String) null, 2, (Object) null);
                        return;
                    }
                    UpcCheckFaceMethodIDLImpl.this.callFailure((int) j, "", callback);
                }
            });
        } catch (Throwable th) {
            LogUtils.e(th);
            callFailure(-1, "", callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callFailure(final int code, final String msg, CompletionBlock<AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel> callback) {
        callback.onFailure(-1, msg, new AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel() { // from class: com.bytedance.upc.bridge.impl.UpcCheckFaceMethodIDLImpl$callFailure$1
            @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
            public void setErrorCode(Number number) {
            }

            @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
            public void setErrorMsg(String str) {
            }

            @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
            public Number getErrorCode() {
                return Integer.valueOf(code);
            }

            @Override // com.bytedance.upc.bridge.abs.AbsUpcCheckFaceMethodIDL.UpcCheckFaceResultModel
            /* renamed from: getErrorMsg, reason: from getter */
            public String get$msg() {
                return msg;
            }

            public Map<String, Object> convert() {
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("errorCode", Integer.valueOf(code)), TuplesKt.to("errorMsg", msg)});
            }

            public JSONObject toJSON() {
                return new JSONObject();
            }
        });
    }
}
