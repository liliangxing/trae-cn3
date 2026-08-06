package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethodKt;
import com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IDLBridgeTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000]\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u001b\u001a\u00020\u001cH\u0016J.\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00100\"2\u0006\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR/\u0010\u000e\u001a \u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\u0004\u0018\u0001`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u0019\u001a \u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\u0004\u0018\u0001`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006%"}, d2 = {"com/bytedance/ies/bullet/base/bridge/IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "access", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "compatibility", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "getCompatibility", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "idlGenericBridgeMethod", "Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod;", "getIdlGenericBridgeMethod", "()Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod;", "inputParamConverter", "Lkotlin/Function2;", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/TypeConverter;", "getInputParamConverter", "()Lkotlin/jvm/functions/Function2;", "name", "", "getName", "()Ljava/lang/String;", "outputParamConverter", "getOutputParamConverter", "canRunInBackground", "", "realHandle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Callback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1 implements IDLXBridgeMethod {
    final /* synthetic */ IGenericBridgeMethod $method;
    private final IIDLGenericBridgeMethod<?, ?> idlGenericBridgeMethod;
    private final Function2<Object, Class<?>, Object> inputParamConverter;
    private final Function2<Object, Class<?>, Object> outputParamConverter;

    public boolean canRunInBackground() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1(IGenericBridgeMethod iGenericBridgeMethod) {
        this.$method = iGenericBridgeMethod;
        Intrinsics.checkNotNull(iGenericBridgeMethod, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod<*, *>");
        this.idlGenericBridgeMethod = (IIDLGenericBridgeMethod) iGenericBridgeMethod;
        this.inputParamConverter = BridgeDataConverterHolder.provideTypeConverter(JSONObject.class, Map.class);
        this.outputParamConverter = BridgeDataConverterHolder.provideTypeConverter(Map.class, JSONObject.class);
    }

    public String getName() {
        return this.$method.getName();
    }

    public IDLXBridgeMethod.Access getAccess() {
        IDLXBridgeMethod.Access bulletPermissionAdapt = IDLBridgeTransformerKt.bulletPermissionAdapt(this.$method.getAccess());
        return bulletPermissionAdapt == null ? IDLXBridgeMethod.DefaultImpls.getAccess(this) : bulletPermissionAdapt;
    }

    public IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.Compatible;
    }

    public final IIDLGenericBridgeMethod<?, ?> getIdlGenericBridgeMethod() {
        return this.idlGenericBridgeMethod;
    }

    public final Function2<Object, Class<?>, Object> getInputParamConverter() {
        return this.inputParamConverter;
    }

    public final Function2<Object, Class<?>, Object> getOutputParamConverter() {
        return this.outputParamConverter;
    }

    public void realHandle(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> params, final IDLXBridgeMethod.Callback callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            IIDLGenericBridgeMethod<?, ?> iIDLGenericBridgeMethod = this.idlGenericBridgeMethod;
            if (iIDLGenericBridgeMethod != null) {
                iIDLGenericBridgeMethod.setLocalInputConverter(new Function1<Object, Object>() { // from class: com.bytedance.ies.bullet.base.bridge.IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1$realHandle$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final Object invoke(Object obj) {
                        Intrinsics.checkNotNullParameter(obj, "it");
                        Function2<Object, Class<?>, Object> inputParamConverter = IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1.this.getInputParamConverter();
                        if (inputParamConverter != null) {
                            Class<?> innerClassType = IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1.this.getIdlGenericBridgeMethod().getInnerClassType();
                            if (innerClassType == null) {
                                innerClassType = Object.class;
                            }
                            Object invoke = inputParamConverter.invoke(obj, innerClassType);
                            if (invoke != null) {
                                return invoke;
                            }
                        }
                        return MapsKt.emptyMap();
                    }
                });
            }
            IIDLGenericBridgeMethod<?, ?> iIDLGenericBridgeMethod2 = this.idlGenericBridgeMethod;
            if (iIDLGenericBridgeMethod2 != null) {
                iIDLGenericBridgeMethod2.setLocalOutputConverter(new Function1<Object, Object>() { // from class: com.bytedance.ies.bullet.base.bridge.IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1$realHandle$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final Object invoke(Object obj) {
                        Intrinsics.checkNotNullParameter(obj, "it");
                        Function2<Object, Class<?>, Object> outputParamConverter = IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1.this.getOutputParamConverter();
                        if (outputParamConverter != null) {
                            Class<?> innerClassType = IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1.this.getIdlGenericBridgeMethod().getInnerClassType();
                            if (innerClassType == null) {
                                innerClassType = Object.class;
                            }
                            Object invoke = outputParamConverter.invoke(obj, innerClassType);
                            if (invoke != null) {
                                return invoke;
                            }
                        }
                        return MapsKt.emptyMap();
                    }
                });
            }
            IIDLGenericBridgeMethod<?, ?> iIDLGenericBridgeMethod3 = this.idlGenericBridgeMethod;
            JSONObject mapToJSON$default = ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, params, 0, 2, (Object) null);
            final IGenericBridgeMethod iGenericBridgeMethod = this.$method;
            BridgeMethodKt.actualHandle(iIDLGenericBridgeMethod3, mapToJSON$default, new IIDLGenericBridgeMethod.ICallback<JSONObject>() { // from class: com.bytedance.ies.bullet.base.bridge.IDLBridgeTransformer$oldXBridge2IDLXBridgeMethod$1$realHandle$3
                @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                public void onComplete(JSONObject data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    callback.invoke(ConvertUtils.INSTANCE.jsonToMap(data));
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                public void onError(int code, String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    HashMap hashMap = new HashMap();
                    IGenericBridgeMethod iGenericBridgeMethod2 = iGenericBridgeMethod;
                    hashMap.put("code", Integer.valueOf(code));
                    hashMap.put("message", message);
                    hashMap.put("func", iGenericBridgeMethod2.getName());
                    callback.invoke(hashMap);
                }

                @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
                public void onError(int code, String message, JSONObject data) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Intrinsics.checkNotNullParameter(data, "data");
                    HashMap hashMap = new HashMap();
                    IGenericBridgeMethod iGenericBridgeMethod2 = iGenericBridgeMethod;
                    hashMap.put("code", Integer.valueOf(code));
                    hashMap.put("message", message);
                    hashMap.put("func", iGenericBridgeMethod2.getName());
                    hashMap.put("data", data);
                    callback.invoke(hashMap);
                }
            });
        } catch (Exception unused) {
        }
    }
}
