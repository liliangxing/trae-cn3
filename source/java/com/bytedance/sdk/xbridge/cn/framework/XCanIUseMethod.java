package com.bytedance.sdk.xbridge.cn.framework;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.framework.AbsXCanIUseMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.service.BridgeLoader;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XCanIUseMethod.kt */
@XBridgeMethod(name = "x.canIUse")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/framework/XCanIUseMethod;", "Lcom/bytedance/sdk/xbridge/cn/framework/AbsXCanIUseMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/framework/AbsXCanIUseMethodIDL$XCanIUseParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/framework/AbsXCanIUseMethodIDL$XCanIUseResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCanIUseMethod extends AbsXCanIUseMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXCanIUseMethodIDL.XCanIUseParamModel params, CompletionBlock<AbsXCanIUseMethodIDL.XCanIUseResultModel> callback) {
        Class<? super Object> superclass;
        Field[] declaredFields;
        Field field;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String method = params.getMethod();
        int i = 0;
        if (method == null || method.length() == 0) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
            return;
        }
        String method2 = params.getMethod();
        BridgeLoader bridgeLoader = (BridgeLoader) bridgeContext.getService(BridgeLoader.class);
        IDLXBridgeMethod findMethod = bridgeLoader != null ? bridgeLoader.findMethod(bridgeContext.getBridgeCall().getNamespace(), method2) : null;
        if (findMethod != null) {
            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCanIUseMethodIDL.XCanIUseResultModel.class));
            AbsXCanIUseMethodIDL.XCanIUseResultModel xCanIUseResultModel = (AbsXCanIUseMethodIDL.XCanIUseResultModel) createXModel;
            xCanIUseResultModel.setAvailable(true);
            try {
                superclass = findMethod.getClass().newInstance().getClass().getSuperclass();
            } catch (Exception unused) {
            }
            if (superclass == null || (declaredFields = superclass.getDeclaredFields()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
            int length = declaredFields.length;
            while (true) {
                if (i >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i];
                if (field.isAnnotationPresent(XBridgeMethodName.class)) {
                    break;
                } else {
                    i++;
                }
            }
            if (field == null) {
                return;
            }
            field.setAccessible(true);
            if (field.isAnnotationPresent(XBridgeMethodName.class)) {
                XBridgeMethodName xBridgeMethodName = (XBridgeMethodName) field.getAnnotation(XBridgeMethodName.class);
                xCanIUseResultModel.setParams(ArraysKt.asList(xBridgeMethodName.params()));
                xCanIUseResultModel.setResults(ArraysKt.asList(xBridgeMethodName.results()));
            }
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            return;
        }
        XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCanIUseMethodIDL.XCanIUseResultModel.class));
        ((AbsXCanIUseMethodIDL.XCanIUseResultModel) createXModel2).setAvailable(false);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel2, null, 2, null);
    }
}
