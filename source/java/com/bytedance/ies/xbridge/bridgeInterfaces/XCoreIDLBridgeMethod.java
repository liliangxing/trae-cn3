package com.bytedance.ies.xbridge.bridgeInterfaces;

import com.bytedance.ies.xbridge.IDLAnnotationData;
import com.bytedance.ies.xbridge.IDLParamField;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.IDLXBridgeRegistryCache;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.exception.XBridgeException;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.bytedance.ies.xbridge.model.idl.IDLXDynamicKt;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.ies.xbridge.utils.IDLJSONUtils;
import com.bytedance.ies.xbridge.utils.JsonUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0010\"\b\b\u0002\u0010\u0003*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J%\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H\u0002¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0019J$\u0010 \u001a\u0004\u0018\u00010\u00192\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010#\u001a\u00020\u0018J+\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010'\u001a\u00020(H&¢\u0006\u0002\u0010)J6\u0010*\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00182\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017J,\u0010.\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\b\b\u0002\u0010-\u001a\u00020\u0018J#\u0010/\u001a\u0004\u0018\u0001H0\"\u0004\b\u0002\u001002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u001cH\u0016¢\u0006\u0002\u00102J.\u00103\u001a\u00020%2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u00104\u001a\u00020%2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u00105\u001a\u0002062\b\u0010!\u001a\u0004\u0018\u000107J\u0014\u00105\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00190:J\u001a\u00105\u001a\u0002062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006;"}, d2 = {"Lcom/bytedance/ies/xbridge/bridgeInterfaces/XCoreIDLBridgeMethod;", "INPUT", "Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;", "OUTPUT", "Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "()V", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;)V", "canRunInBackground", "", "createCompletionBlockProxy", "Lcom/bytedance/ies/xbridge/model/idl/CompletionBlock;", "classLoader", "Ljava/lang/ClassLoader;", "callback", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Callback;", "createParamModelProxy", "dataSource", "", "", "", "(Ljava/util/Map;)Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;", "getParamsClazz", "Ljava/lang/Class;", "getPropertyName", "method", "Ljava/lang/reflect/Method;", "getXValue", "data", "map", "key", "handle", "", "params", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "(Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;Lcom/bytedance/ies/xbridge/model/idl/CompletionBlock;Lcom/bytedance/ies/xbridge/XBridgePlatformType;)V", "onFailure", "code", "", "msg", "onSuccess", "provideContext", "T", "clz", "(Ljava/lang/Class;)Ljava/lang/Object;", "realHandle", "setProviderFactory", "toJSON", "Lorg/json/JSONObject;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "Lorg/json/JSONArray;", "list", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class XCoreIDLBridgeMethod<INPUT extends XBaseParamModel, OUTPUT extends XBaseResultModel> implements IDLXBridgeMethod {
    private XContextProviderFactory contextProviderFactory;

    public boolean canRunInBackground() {
        return false;
    }

    public abstract void handle(INPUT params, CompletionBlock<OUTPUT> callback, XBridgePlatformType type);

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public double asDouble(Number number) {
        return IDLXBridgeMethod.DefaultImpls.asDouble(this, number);
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return IDLXBridgeMethod.DefaultImpls.getAccess(this);
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public Class<? extends XBaseParamModel> provideParamModel() {
        return IDLXBridgeMethod.DefaultImpls.provideParamModel(this);
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public Class<? extends XBaseResultModel> provideResultModel() {
        return IDLXBridgeMethod.DefaultImpls.provideResultModel(this);
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public void release() {
        IDLXBridgeMethod.DefaultImpls.release(this);
    }

    public final XContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public final void setContextProviderFactory(XContextProviderFactory xContextProviderFactory) {
        this.contextProviderFactory = xContextProviderFactory;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public void setProviderFactory(XContextProviderFactory contextProviderFactory) {
        this.contextProviderFactory = contextProviderFactory;
    }

    public <T> T provideContext(Class<T> clz) {
        Intrinsics.checkNotNullParameter(clz, "clz");
        XContextProviderFactory xContextProviderFactory = this.contextProviderFactory;
        if (xContextProviderFactory != null) {
            return (T) xContextProviderFactory.provideInstance(clz);
        }
        return null;
    }

    public final Object getXValue(Object data) {
        return data instanceof IDLXDynamic ? IDLXDynamicKt.getValue((IDLXDynamic) data) : data;
    }

    public final Object getXValue(Map<String, ? extends Object> map, String key) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = map.get(key);
        return obj instanceof IDLXDynamic ? IDLXDynamicKt.getValue((IDLXDynamic) obj) : obj;
    }

    public final JSONArray toJSON(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return JsonUtils.INSTANCE.listToJSON(list);
    }

    public final JSONObject toJSON(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return JsonUtils.INSTANCE.mapToJSON(map);
    }

    public final JSONObject toJSON(XBaseModel data) {
        if (data == null) {
            return new JSONObject();
        }
        return data.toJSON();
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

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public void realHandle(Map<String, ? extends Object> params, IDLXBridgeMethod.Callback callback, XBridgePlatformType type) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(type, "type");
        INPUT createParamModelProxy = createParamModelProxy(params);
        if (createParamModelProxy == null) {
            onFailure$default(this, callback, -3, "", null, 8, null);
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        Intrinsics.checkNotNull(classLoader);
        handle(createParamModelProxy, createCompletionBlockProxy(classLoader, callback), type);
    }

    private final INPUT createParamModelProxy(final Map<String, ? extends Object> dataSource) throws IllegalStateException, XBridgeException {
        Class<?> paramsClazz = getParamsClazz();
        if (paramsClazz == null) {
            throw new IllegalStateException("params class is null");
        }
        Object newProxyInstance = Proxy.newProxyInstance(paramsClazz.getClassLoader(), new Class[]{paramsClazz}, new InvocationHandler(this) { // from class: com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod$createParamModelProxy$1
            final /* synthetic */ XCoreIDLBridgeMethod<INPUT, OUTPUT> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                String propertyName;
                Object obj2;
                Object obj3;
                if (method.getName().equals("toJSON")) {
                    Map<String, Object> map = dataSource;
                    try {
                        Result.Companion companion = Result.Companion;
                        JSONObject jSONObject = new JSONObject();
                        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                        for (Object obj4 : map.entrySet()) {
                            Object key = ((Map.Entry) obj4).getKey();
                            Map.Entry entry = (Map.Entry) obj4;
                            Object value = entry.getValue();
                            if (value instanceof Long) {
                                obj3 = entry.getValue();
                            } else if (value instanceof Integer) {
                                obj3 = entry.getValue();
                            } else if (value instanceof Double) {
                                obj3 = entry.getValue();
                            } else if (value instanceof String) {
                                obj3 = entry.getValue();
                            } else if (value instanceof Boolean) {
                                obj3 = entry.getValue();
                            } else if (value instanceof List) {
                                Object value2 = entry.getValue();
                                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                                obj3 = IDLJSONUtils.toJSONArray((List) value2);
                            } else if (value instanceof Map) {
                                Object value3 = entry.getValue();
                                Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                                obj3 = IDLJSONUtils.toJSONObject((Map) value3);
                            } else if (value instanceof IDLXDynamic) {
                                Object value4 = entry.getValue();
                                Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type com.bytedance.ies.xbridge.model.idl.IDLXDynamic");
                                obj3 = IDLXDynamicKt.toPrimitiveOrJSON((IDLXDynamic) value4);
                            } else if (entry.getValue() instanceof XBaseModel) {
                                Object value5 = entry.getValue();
                                Intrinsics.checkNotNull(value5, "null cannot be cast to non-null type com.bytedance.ies.xbridge.model.idl.XBaseModel");
                                obj3 = ((XBaseModel) value5).toJSON();
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
                XCoreIDLBridgeMethod<INPUT, OUTPUT> xCoreIDLBridgeMethod = this.this$0;
                Intrinsics.checkNotNullExpressionValue(method, "method");
                propertyName = xCoreIDLBridgeMethod.getPropertyName(method);
                return dataSource.get(propertyName);
            }
        });
        Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type INPUT of com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod");
        return (INPUT) newProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPropertyName(Method method) {
        IDLAnnotationData iDLAnnotationData = IDLXBridgeRegistryCache.INSTANCE.getBRIDGE_ANNOTATION_MAP().get(getClass());
        if (iDLAnnotationData != null) {
            IDLParamField iDLParamField = iDLAnnotationData.getXBridgeParamModel().getMethodModel().get(method);
            String keyPath = iDLParamField != null ? iDLParamField.getKeyPath() : null;
            if (keyPath != null) {
                return keyPath;
            }
        }
        return ((XBridgeParamField) method.getAnnotation(XBridgeParamField.class)).keyPath();
    }

    private final Class<?> getParamsClazz() {
        IDLAnnotationData iDLAnnotationData = IDLXBridgeRegistryCache.INSTANCE.getBRIDGE_ANNOTATION_MAP().get(getClass());
        Class<?> paramClass = iDLAnnotationData != null ? iDLAnnotationData.getParamClass() : null;
        if (paramClass != null) {
            return paramClass;
        }
        System.out.println((Object) "idl Map->Model. no cache");
        Class<?>[] declaredClasses = getClass().getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "this.javaClass.declaredClasses");
        Class<?>[] clsArr = declaredClasses;
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
            Class<?>[] declaredClasses2 = getClass().getSuperclass().getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(declaredClasses2, "this.javaClass.superclass.declaredClasses");
            ArrayList arrayList3 = new ArrayList();
            for (Class<?> cls2 : declaredClasses2) {
                if (cls2.getAnnotation(XBridgeParamModel.class) != null) {
                    arrayList3.add(cls2);
                }
            }
            arrayList2 = arrayList3;
            if (arrayList2.isEmpty()) {
                throw new IllegalStateException("Illegal class format, no param model is defined in class");
            }
        }
        return (Class) CollectionsKt.first(arrayList2);
    }

    public final <OUTPUT extends XBaseResultModel> CompletionBlock<OUTPUT> createCompletionBlockProxy(ClassLoader classLoader, final IDLXBridgeMethod.Callback callback) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return (CompletionBlock) new CompletionBlock<OUTPUT>(this) { // from class: com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod$createCompletionBlockProxy$1
            final /* synthetic */ XCoreIDLBridgeMethod<INPUT, OUTPUT> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect types in method signature: (TOUTPUT;Ljava/lang/String;)V */
            @Override // com.bytedance.ies.xbridge.model.idl.CompletionBlock
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
            @Override // com.bytedance.ies.xbridge.model.idl.CompletionBlock
            public void onFailure(int code, String msg, XBaseResultModel data) {
                Map<String, ? extends Object> linkedHashMap;
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (data == null || (linkedHashMap = data.convert()) == null) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                this.this$0.onFailure(callback, code, msg, linkedHashMap);
            }

            /* JADX WARN: Incorrect types in method signature: (TOUTPUT;)V */
            @Override // com.bytedance.ies.xbridge.model.idl.CompletionBlock
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
