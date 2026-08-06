package com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLAnnotationData;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.XBridgeAnnotationCache;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.XBridgeException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.IDLJSONUtils;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XCoreIDLBridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00030\f\"\b\b\u0002\u0010\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J-\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00132\u0006\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J+\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\fH&¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J6\u0010$\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00142\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013J,\u0010)\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\b\u0002\u0010'\u001a\u00020\u0014J.\u0010*\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020/2\b\u0010(\u001a\u0004\u0018\u000100J\u0014\u0010.\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001503J\u001a\u0010.\u001a\u00020/2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;", "INPUT", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "OUTPUT", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "()V", "handler", "Landroid/os/Handler;", "canRunInBackground", "", "createCompletionBlockProxy", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "classLoader", "Ljava/lang/ClassLoader;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Callback;", "createParamModelProxy", "dataSource", "", "", "", "enableProxyEnhancement", "(Ljava/util/Map;Z)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "getParamsClazz", "Ljava/lang/Class;", "getPropertyName", "method", "Ljava/lang/reflect/Method;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;)V", "isProperty", "onFailure", "code", "", "msg", "data", "onSuccess", "realHandle", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "toJSON", "Lorg/json/JSONObject;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "Lorg/json/JSONArray;", "list", "", "map", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class XCoreIDLBridgeMethod<INPUT extends XBaseParamModel, OUTPUT extends XBaseResultModel> implements IDLXBridgeMethod {
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    public abstract void handle(IBDXBridgeContext bridgeContext, INPUT params, CompletionBlock<OUTPUT> callback);

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return IDLXBridgeMethod.DefaultImpls.getAccess(this);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.DefaultImpls.getCompatibility(this);
    }

    public final JSONArray toJSON(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return ConvertUtils.listToJSON$default(ConvertUtils.INSTANCE, list, 0, 2, null);
    }

    public final JSONObject toJSON(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, map, 0, 2, null);
    }

    public final JSONObject toJSON(XBaseModel data) {
        if (data == null) {
            return new JSONObject();
        }
        return data.toJSON();
    }

    public final void runOnUIThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.handler.post(runnable);
    }

    public static /* synthetic */ void onSuccess$default(XCoreIDLBridgeMethod xCoreIDLBridgeMethod, IDLXBridgeMethod.Callback callback, Map map, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
        }
        if ((i & 4) != 0) {
            str = "";
        }
        xCoreIDLBridgeMethod.onSuccess(callback, map, str);
    }

    public final void onSuccess(IDLXBridgeMethod.Callback callback, Map<String, ? extends Object> data, String msg) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("code", 1);
        linkedHashMap.put("msg", msg);
        linkedHashMap.put("data", data);
        callback.invoke(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onFailure$default(XCoreIDLBridgeMethod xCoreIDLBridgeMethod, IDLXBridgeMethod.Callback callback, int i, String str, Map map, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
        }
        if ((i2 & 4) != 0) {
            str = "";
        }
        if ((i2 & 8) != 0) {
            map = new LinkedHashMap();
        }
        xCoreIDLBridgeMethod.onFailure(callback, i, str, map);
    }

    public final void onFailure(IDLXBridgeMethod.Callback callback, int code, String msg, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("code", Integer.valueOf(code));
        linkedHashMap.put("msg", msg);
        linkedHashMap.put("data", data);
        callback.invoke(linkedHashMap);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public void realHandle(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> params, IDLXBridgeMethod.Callback callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        INPUT createParamModelProxy = createParamModelProxy(params, Intrinsics.areEqual(bridgeContext.getBridgeCall().getExtraMap().get(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT()), true));
        if (createParamModelProxy == null) {
            onFailure$default(this, callback, -3, "", null, 8, null);
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        Intrinsics.checkNotNull(classLoader);
        handle(bridgeContext, createParamModelProxy, createCompletionBlockProxy(classLoader, callback));
    }

    private final INPUT createParamModelProxy(final Map<String, ? extends Object> dataSource, final boolean enableProxyEnhancement) throws IllegalStateException, XBridgeException {
        Class<?> paramsClazz = getParamsClazz();
        if (paramsClazz == null) {
            throw new IllegalStateException("params class is null");
        }
        Object newProxyInstance = Proxy.newProxyInstance(paramsClazz.getClassLoader(), new Class[]{paramsClazz}, new InvocationHandler() { // from class: com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod$createParamModelProxy$1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                String propertyName;
                boolean isProperty;
                String propertyName2;
                Object obj2;
                Object obj3;
                Object obj4 = null;
                if (method.getName().equals("toJSON")) {
                    Map<String, Object> map = dataSource;
                    try {
                        Result.Companion companion = Result.Companion;
                        JSONObject jSONObject = new JSONObject();
                        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                        for (Object obj5 : map.entrySet()) {
                            Object key = ((Map.Entry) obj5).getKey();
                            Map.Entry entry = (Map.Entry) obj5;
                            Object value = entry.getValue();
                            boolean z = true;
                            if (!(value instanceof Long ? true : value instanceof Integer ? true : value instanceof Double ? true : value instanceof String)) {
                                z = value instanceof Boolean;
                            }
                            if (z) {
                                obj3 = entry.getValue();
                            } else if (value instanceof List) {
                                Object value2 = entry.getValue();
                                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                                obj3 = IDLJSONUtils.toJSONArray((List) value2);
                            } else if (value instanceof Map) {
                                Object value3 = entry.getValue();
                                Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                                obj3 = IDLJSONUtils.toJSONObject((Map) value3);
                            } else if (entry.getValue() instanceof XBaseModel) {
                                Object value4 = entry.getValue();
                                Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel");
                                obj3 = ((XBaseModel) value4).toJSON();
                            } else {
                                obj3 = null;
                            }
                            linkedHashMap.put(key, obj3);
                        }
                        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                            if (entry2.getValue() != null) {
                                jSONObject.put((String) entry2.getKey(), entry2.getValue());
                            }
                        }
                        obj2 = Result.constructor-impl(jSONObject);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    return Result.isFailure-impl(obj2) ? new JSONObject() : obj2;
                }
                if (enableProxyEnhancement) {
                    XCoreIDLBridgeMethod<INPUT, OUTPUT> xCoreIDLBridgeMethod = this;
                    Intrinsics.checkNotNullExpressionValue(method, "method");
                    isProperty = xCoreIDLBridgeMethod.isProperty(method);
                    if (isProperty) {
                        propertyName2 = this.getPropertyName(method);
                        return dataSource.get(propertyName2);
                    }
                    try {
                        Map<String, Object> map2 = dataSource;
                        if (objArr == null) {
                            objArr = new Object[0];
                        }
                        obj4 = method.invoke(map2, Arrays.copyOf(objArr, objArr.length));
                    } catch (Exception e) {
                        Log.e("XBridge", "createParamModelProxy InvocationHandler invoke method failed", e);
                    }
                    return obj4;
                }
                XCoreIDLBridgeMethod<INPUT, OUTPUT> xCoreIDLBridgeMethod2 = this;
                Intrinsics.checkNotNullExpressionValue(method, "method");
                propertyName = xCoreIDLBridgeMethod2.getPropertyName(method);
                return dataSource.get(propertyName);
            }
        });
        Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type INPUT of com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod");
        return (INPUT) newProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPropertyName(Method method) {
        IDLAnnotationData iDLAnnotationData = XBridgeAnnotationCache.INSTANCE.getBRIDGE_ANNOTATION_MAP().get(getClass());
        if (iDLAnnotationData != null) {
            IDLParamField iDLParamField = iDLAnnotationData.getXBridgeParamModel().getMethodModel().get(method);
            String keyPath = iDLParamField != null ? iDLParamField.getKeyPath() : null;
            if (keyPath != null) {
                return keyPath;
            }
        }
        XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
        String keyPath2 = xBridgeParamField != null ? xBridgeParamField.keyPath() : null;
        return keyPath2 == null ? "" : keyPath2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isProperty(Method method) {
        IDLAnnotationData iDLAnnotationData = XBridgeAnnotationCache.INSTANCE.getBRIDGE_ANNOTATION_MAP().get(getClass());
        if (iDLAnnotationData != null) {
            return iDLAnnotationData.getXBridgeParamModel().getMethodModel().containsKey(method);
        }
        return ((XBridgeParamField) method.getAnnotation(XBridgeParamField.class)) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Class<?> getParamsClazz() {
        Class<?>[] declaredClasses;
        IDLAnnotationData iDLAnnotationData = XBridgeAnnotationCache.INSTANCE.getBRIDGE_ANNOTATION_MAP().get(getClass());
        Class<?> paramClass = iDLAnnotationData != null ? iDLAnnotationData.getParamClass() : null;
        if (paramClass != null) {
            return paramClass;
        }
        if (XBridgeDynamicModel.INSTANCE.findParamModelByAnnotation(getClass()) != null) {
            return XBridgeDynamicModel.INSTANCE.findParamModelByAnnotation(getClass());
        }
        Class<?>[] declaredClasses2 = getClass().getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses2, "this.javaClass.declaredClasses");
        Class<?>[] clsArr = declaredClasses2;
        ArrayList arrayList = new ArrayList();
        int length = clsArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Class<?> cls = clsArr[i];
            if (cls.getAnnotation(XBridgeParamModel.class) != null) {
                arrayList.add(cls);
            }
            i++;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            Class<? super Object> superclass = getClass().getSuperclass();
            if (superclass == null || (declaredClasses = superclass.getDeclaredClasses()) == null) {
                arrayList2 = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (Class<?> cls2 : declaredClasses) {
                    if (cls2.getAnnotation(XBridgeParamModel.class) != null) {
                        arrayList3.add(cls2);
                    }
                }
                arrayList2 = arrayList3;
            }
            if (arrayList2.isEmpty()) {
                throw new IllegalStateException("Illegal class format, no param model is defined in class");
            }
        }
        return (Class) CollectionsKt.first(arrayList2);
    }

    public final <OUTPUT extends XBaseResultModel> CompletionBlock<OUTPUT> createCompletionBlockProxy(ClassLoader classLoader, final IDLXBridgeMethod.Callback callback) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return (CompletionBlock) new CompletionBlock<OUTPUT>(this) { // from class: com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod$createCompletionBlockProxy$1
            final /* synthetic */ XCoreIDLBridgeMethod<INPUT, OUTPUT> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect types in method signature: (TOUTPUT;Ljava/lang/String;)V */
            @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
            public void onSuccess(XBaseResultModel result, String msg) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Map<String, ? extends Object> convert = result.convert();
                if (convert == null) {
                    convert = new LinkedHashMap<>();
                }
                this.this$0.onSuccess(callback, convert, msg);
            }

            /* JADX WARN: Incorrect types in method signature: (ILjava/lang/String;TOUTPUT;)V */
            @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
            public void onFailure(int code, String msg, XBaseResultModel data) {
                Map<String, ? extends Object> linkedHashMap;
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (data == null || (linkedHashMap = data.convert()) == null) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                this.this$0.onFailure(callback, code, msg, linkedHashMap);
            }

            /* JADX WARN: Incorrect types in method signature: (TOUTPUT;)V */
            @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
            public void onRawSuccess(XBaseResultModel data) {
                LinkedHashMap linkedHashMap;
                if (data == null || (linkedHashMap = data.convert()) == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                callback.invoke(linkedHashMap);
            }
        };
    }
}
