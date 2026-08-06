package com.bytedance.android.anniex.worker;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.protocol.IPlatformDataProcessor;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLAnnotationData;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.ParamModelFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.XBridgeAnnotationCache;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* compiled from: WorkerPlatformDataProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003Jh\u0010\u0004\u001a\u00020\u00052:\u0010\u0006\u001a6\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u0007j\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t`\f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`\fH\u0002J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0002JL\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00162\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`\f2\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018H\u0002Jb\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001`\f2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u00182\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`\fH\u0002J\u001c\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002Jv\u0010\"\u001a:\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0018\u00010\u0007j\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0018\u0001`\f2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u00182\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`\fH\u0002J@\u0010#\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u00182\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e`\fH\u0002J>\u0010$\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00162\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0\u00182\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'H\u0016J0\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u00022\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0\u0018H\u0016J\u001e\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00162\u0006\u0010\r\u001a\u00020\u0002H\u0016J8\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u00022\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0\u00182\u0006\u0010+\u001a\u00020\bH\u0016¨\u0006,"}, d2 = {"Lcom/bytedance/android/anniex/worker/WorkerPlatformDataProcessor;", "Lcom/bytedance/sdk/xbridge/cn/protocol/IPlatformDataProcessor;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "()V", "checkValue", "", "classMap", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "Ljava/lang/reflect/Method;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/annotation/XBridgeParamField;", "Lkotlin/collections/HashMap;", "params", "", "convertValueWithAnnotation", StrategyConstants.VALUE, "annotation", "getInt", "", Constants.KEY_DATA, "getJavaOnlyMapParams", "", "clazz", "Ljava/lang/Class;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "getMapWithDefault", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "map", "isNestClass", "", "isNestListClass", "parseStringByReturnType", "method", "preCheck", "proxyValue", "transformMapToPlatformData", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", NotificationCompat.CATEGORY_CALL, "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "transformPlatformDataToMap", "transformPlatformDataToMapCompat", "transformPlatformDataToMapWithNamespace", "nameSpace", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WorkerPlatformDataProcessor implements IPlatformDataProcessor<ReadableMap, ReadableMap> {

    /* compiled from: WorkerPlatformDataProcessor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DefaultType.values().length];
            try {
                iArr[DefaultType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DefaultType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DefaultType.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: transformMapToPlatformData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3468transformMapToPlatformData(Map map, Class cls, BaseBridgeCall baseBridgeCall) {
        return transformMapToPlatformData((Map<String, ? extends Object>) map, (Class<? extends IDLXBridgeMethod>) cls, (BaseBridgeCall<ReadableMap>) baseBridgeCall);
    }

    public /* bridge */ /* synthetic */ Map transformPlatformDataToMap(Object obj, Class cls) {
        return transformPlatformDataToMap((ReadableMap) obj, (Class<? extends IDLXBridgeMethod>) cls);
    }

    public /* bridge */ /* synthetic */ Map transformPlatformDataToMapWithNamespace(Object obj, Class cls, String str) {
        return transformPlatformDataToMapWithNamespace((ReadableMap) obj, (Class<? extends IDLXBridgeMethod>) cls, str);
    }

    public Map<String, Object> transformPlatformDataToMapWithNamespace(ReadableMap params, Class<? extends IDLXBridgeMethod> clazz, String nameSpace) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(nameSpace, "nameSpace");
        return transformPlatformDataToMap(params, clazz);
    }

    public Map<String, Object> transformPlatformDataToMap(ReadableMap params, Class<? extends IDLXBridgeMethod> clazz) throws IllegalInputParamException {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IDLAnnotationData iDLAnnotationData = (IDLAnnotationData) XBridgeAnnotationCache.INSTANCE.getBRIDGE_ANNOTATION_MAP().get(clazz);
        if (iDLAnnotationData != null) {
            WorkerDataProcessorForMap workerDataProcessorForMap = WorkerDataProcessorForMap.INSTANCE;
            HashMap<String, Object> hashMap = params.toHashMap();
            Intrinsics.checkNotNullExpressionValue(hashMap, "params.toHashMap()");
            return workerDataProcessorForMap.getJavaOnlyMapParams(hashMap, iDLAnnotationData);
        }
        Class<? extends XBaseParamModel> retrieveParamModel = ParamModelFinder.INSTANCE.retrieveParamModel(clazz);
        if (retrieveParamModel == null && (retrieveParamModel = XBridgeDynamicModel.INSTANCE.findParamModelByAnnotation(clazz)) == null) {
            return null;
        }
        HashMap<String, Object> hashMap2 = params.toHashMap();
        Intrinsics.checkNotNullExpressionValue(hashMap2, "params.toHashMap()");
        return getJavaOnlyMapParams(hashMap2, retrieveParamModel);
    }

    private final Map<String, Object> getJavaOnlyMapParams(HashMap<String, Object> params, Class<? extends XBaseParamModel> clazz) {
        HashMap<String, Pair<Method, XBridgeParamField>> preCheck = preCheck(clazz, params);
        if (preCheck == null) {
            return null;
        }
        HashMap<String, Object> hashMap = params;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(hashMap.size()));
        Iterator<T> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Pair<Method, XBridgeParamField> pair = preCheck.get(entry.getKey());
            linkedHashMap.put(key, convertValueWithAnnotation(entry.getValue(), pair != null ? (XBridgeParamField) pair.getSecond() : null));
        }
        return linkedHashMap;
    }

    private final Object proxyValue(final Class<? extends XBaseModel> clazz, final HashMap<String, Object> map) throws IllegalInputParamException {
        if (clazz == null || preCheck(clazz, map) == null) {
            return null;
        }
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() { // from class: com.bytedance.android.anniex.worker.WorkerPlatformDataProcessor$proxyValue$1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object convertValueWithAnnotation;
                HashMap mapWithDefault;
                if (Intrinsics.areEqual(method.getName(), "toJSON")) {
                    mapWithDefault = WorkerPlatformDataProcessor.this.getMapWithDefault(clazz, map);
                    return new JSONObject(mapWithDefault);
                }
                XBridgeParamField annotation = method.getAnnotation(XBridgeParamField.class);
                convertValueWithAnnotation = WorkerPlatformDataProcessor.this.convertValueWithAnnotation(map.get(annotation.keyPath()), annotation);
                return convertValueWithAnnotation;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object convertValueWithAnnotation(Object value, XBridgeParamField annotation) {
        if (isNestClass(value, annotation)) {
            Class<? extends XBaseModel> nestedClassType = annotation != null ? annotation.nestedClassType() : null;
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
            HashMap<String, Object> hashMap = ((ReadableMap) value).toHashMap();
            Intrinsics.checkNotNullExpressionValue(hashMap, "value as ReadableMap).toHashMap()");
            return proxyValue(nestedClassType, hashMap);
        }
        if (isNestListClass(value, annotation)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) value;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Object obj : list) {
                Class<? extends XBaseModel> nestedClassType2 = annotation != null ? annotation.nestedClassType() : null;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
                HashMap<String, Object> hashMap2 = ((ReadableMap) obj).toHashMap();
                Intrinsics.checkNotNullExpressionValue(hashMap2, "it as ReadableMap).toHashMap()");
                arrayList.add(proxyValue(nestedClassType2, hashMap2));
            }
            return arrayList;
        }
        return WorkerConvertUtils.INSTANCE.getValue(value);
    }

    private final void checkValue(HashMap<String, Pair<Method, XBridgeParamField>> classMap, HashMap<String, Object> params) {
        for (Map.Entry<String, Pair<Method, XBridgeParamField>> entry : classMap.entrySet()) {
            XBridgeParamField xBridgeParamField = (XBridgeParamField) entry.getValue().getSecond();
            Method method = (Method) entry.getValue().getFirst();
            Object obj = params.get(entry.getKey());
            if (xBridgeParamField.required() && obj == null) {
                throw new IllegalInputParamException(entry.getKey() + " param is missing from input");
            }
            Class<?> returnType = method.getReturnType();
            boolean z = true;
            if (Intrinsics.areEqual(returnType, String.class)) {
                if (obj != null && !(obj instanceof String)) {
                    throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except string,but " + obj.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Number.class)) {
                if (obj != null && !(obj instanceof Number)) {
                    throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except number,but " + obj.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Boolean.class) ? true : Intrinsics.areEqual(returnType, Boolean.TYPE)) {
                if (obj != null && !(obj instanceof Boolean)) {
                    throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except boolean,but " + obj.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, List.class)) {
                if (obj != null && !(obj instanceof List)) {
                    throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except List ,but " + obj.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Map.class) && obj != null && !(obj instanceof Map)) {
                throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except Map ,but " + obj.getClass());
            }
            if (obj != null && xBridgeParamField.isEnum()) {
                Class<?> returnType2 = method.getReturnType();
                if (Intrinsics.areEqual(returnType2, String.class)) {
                    String[] option = method.getAnnotation(XBridgeStringEnum.class).option();
                    if (!ArraysKt.contains(option, obj)) {
                        throw new IllegalInputParamException(entry.getKey() + " has wrong type.should be one of " + ArraysKt.asList(option) + " but got " + obj);
                    }
                } else if (Intrinsics.areEqual(returnType2, Number.class)) {
                    int[] option2 = method.getAnnotation(XBridgeIntEnum.class).option();
                    if (!ArraysKt.contains(option2, getInt(obj))) {
                        throw new IllegalInputParamException(entry.getKey() + " has wrong value.should be one of " + ArraysKt.asList(option2) + " but got " + obj);
                    }
                } else if (Intrinsics.areEqual(returnType2, Map.class)) {
                    XBridgeStringEnum annotation = method.getAnnotation(XBridgeStringEnum.class);
                    if (annotation != null) {
                        String[] option3 = annotation.option();
                        Map map = (Map) obj;
                        if (!map.isEmpty()) {
                            Iterator it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                if (!ArraysKt.contains(option3, ((Map.Entry) it.next()).getValue())) {
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            throw new IllegalInputParamException(entry.getKey() + " has wrong type.should be one of " + ArraysKt.asList(option3) + " but got " + obj);
                        }
                    } else {
                        XBridgeIntEnum annotation2 = method.getAnnotation(XBridgeIntEnum.class);
                        if (annotation2 != null) {
                            int[] option4 = annotation2.option();
                            Map map2 = (Map) obj;
                            if (!map2.isEmpty()) {
                                Iterator it2 = map2.entrySet().iterator();
                                while (it2.hasNext()) {
                                    if (!ArraysKt.contains(option4, getInt(((Map.Entry) it2.next()).getValue()))) {
                                        break;
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                                throw new IllegalInputParamException(entry.getKey() + " has wrong value.should be one of " + ArraysKt.asList(option4) + " but got " + obj);
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private final int getInt(Object data) {
        if (data instanceof Number) {
            return ((Number) data).intValue();
        }
        if (data == null) {
            throw new IllegalInputParamException("the key is null");
        }
        throw new IllegalInputParamException("the key is not a number");
    }

    private final boolean isNestClass(Object value, XBridgeParamField annotation) {
        if (value instanceof Map) {
            if (!Intrinsics.areEqual(annotation != null ? Reflection.getOrCreateKotlinClass(annotation.nestedClassType()) : null, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class))) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNestListClass(Object value, XBridgeParamField annotation) {
        if (value instanceof List) {
            if (!Intrinsics.areEqual(annotation != null ? Reflection.getOrCreateKotlinClass(annotation.nestedClassType()) : null, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class))) {
                return true;
            }
        }
        return false;
    }

    private final HashMap<String, Pair<Method, XBridgeParamField>> preCheck(Class<? extends XBaseModel> clazz, HashMap<String, Object> map) {
        Method[] declaredMethods;
        if (clazz == null || (declaredMethods = clazz.getDeclaredMethods()) == null) {
            return null;
        }
        HashMap<String, Pair<Method, XBridgeParamField>> hashMap = new HashMap<>();
        for (Method method : declaredMethods) {
            XBridgeParamField annotation = method.getAnnotation(XBridgeParamField.class);
            if (annotation != null) {
                String keyPath = annotation.keyPath();
                Intrinsics.checkNotNullExpressionValue(method, "method");
                hashMap.put(keyPath, new Pair<>(method, annotation));
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Pair<Method, XBridgeParamField>> entry : hashMap.entrySet()) {
            if (map.get(entry.getKey()) == null && ((XBridgeParamField) entry.getValue().getSecond()).defaultValue().type() != DefaultType.NONE) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            map.put(entry2.getKey(), parseStringByReturnType((Method) ((Pair) entry2.getValue()).getFirst(), (XBridgeParamField) ((Pair) entry2.getValue()).getSecond()));
        }
        checkValue(hashMap, map);
        return hashMap;
    }

    private final Object parseStringByReturnType(Method method, XBridgeParamField annotation) {
        Class<?> returnType = method.getReturnType();
        if (!Intrinsics.areEqual(returnType, Number.class)) {
            return Intrinsics.areEqual(returnType, Boolean.TYPE) ? true : Intrinsics.areEqual(returnType, Boolean.class) ? Boolean.valueOf(annotation.defaultValue().boolValue()) : annotation.defaultValue().stringValue();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[annotation.defaultValue().type().ordinal()];
        if (i == 1) {
            return Double.valueOf(annotation.defaultValue().doubleValue());
        }
        if (i == 2) {
            return Long.valueOf(annotation.defaultValue().longValue());
        }
        if (i == 3) {
            return Integer.valueOf(annotation.defaultValue().intValue());
        }
        return Integer.valueOf(annotation.defaultValue().intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r6.isGetter() == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HashMap<String, Object> getMapWithDefault(Class<? extends XBaseModel> clazz, HashMap<String, Object> map) {
        ArrayList<Method> arrayList;
        ArrayList arrayList2;
        Method[] declaredMethods;
        HashMap<String, Object> hashMap = null;
        if (clazz == null || (declaredMethods = clazz.getDeclaredMethods()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (Method method : declaredMethods) {
                XBridgeParamField annotation = method.getAnnotation(XBridgeParamField.class);
                boolean z = annotation != null;
                if (z) {
                    arrayList3.add(method);
                }
            }
            arrayList = arrayList3;
        }
        if (arrayList != null) {
            hashMap = new HashMap<>();
            for (Method method2 : arrayList) {
                XBridgeParamField xBridgeParamField = (XBridgeParamField) method2.getAnnotation(XBridgeParamField.class);
                Object obj = map.get(xBridgeParamField.keyPath());
                if (obj == null && xBridgeParamField.defaultValue().type() != DefaultType.NONE) {
                    Intrinsics.checkNotNullExpressionValue(method2, "method");
                    Intrinsics.checkNotNullExpressionValue(xBridgeParamField, "annotation");
                    map.put(xBridgeParamField.keyPath(), parseStringByReturnType(method2, xBridgeParamField));
                }
                HashMap<String, Object> hashMap2 = hashMap;
                String keyPath = xBridgeParamField.keyPath();
                if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(xBridgeParamField.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && (obj instanceof ReadableMap)) {
                    Class<? extends XBaseModel> nestedClassType = xBridgeParamField.nestedClassType();
                    HashMap<String, Object> hashMap3 = ((ReadableMap) obj).toHashMap();
                    Intrinsics.checkNotNullExpressionValue(hashMap3, "value.toHashMap()");
                    arrayList2 = getMapWithDefault(nestedClassType, hashMap3);
                } else if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(xBridgeParamField.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && (obj instanceof ReadableArray)) {
                    ArrayList arrayList4 = ((ReadableArray) obj).toArrayList();
                    Intrinsics.checkNotNullExpressionValue(arrayList4, "value.toArrayList()");
                    ArrayList arrayList5 = arrayList4;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                    for (Object obj2 : arrayList5) {
                        Class<? extends XBaseModel> nestedClassType2 = xBridgeParamField.nestedClassType();
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
                        HashMap<String, Object> hashMap4 = ((ReadableMap) obj2).toHashMap();
                        Intrinsics.checkNotNullExpressionValue(hashMap4, "it as ReadableMap).toHashMap()");
                        arrayList6.add(getMapWithDefault(nestedClassType2, hashMap4));
                    }
                    arrayList2 = arrayList6;
                } else {
                    arrayList2 = map.get(xBridgeParamField.keyPath());
                }
                hashMap2.put(keyPath, arrayList2);
            }
        }
        return hashMap;
    }

    public ReadableMap transformMapToPlatformData(Map<String, ? extends Object> params, Class<? extends IDLXBridgeMethod> clazz, BaseBridgeCall<ReadableMap> call) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object obj = params.get("__jsb2__data__");
        if (obj != null) {
            return WorkerConvertUtils.convertJsonToJavaOnlyMap((JSONObject) obj);
        }
        return WorkerConvertUtils.convertMapToJavaOnlyMap(params);
    }

    public Map<String, Object> transformPlatformDataToMapCompat(ReadableMap params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return WorkerConvertUtils.convertJavaOnlyMapToMap((JavaOnlyMap) params);
    }
}
