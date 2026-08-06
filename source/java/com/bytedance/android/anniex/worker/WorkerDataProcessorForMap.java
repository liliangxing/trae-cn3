package com.bytedance.android.anniex.worker;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLAnnotationData;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLAnnotationModel;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* compiled from: WorkerDataProcessorForMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\nH\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002JB\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00142\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u0015\u001a\u00020\u0010JN\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00142\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0019\u001a\u00020\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\u001b\u001a\u00020\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\u001c\u001a\u00020\u00012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J8\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\nH\u0002JH\u0010 \u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020!\u0018\u00010\u001e2\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\""}, d2 = {"Lcom/bytedance/android/anniex/worker/WorkerDataProcessorForMap;", "", "()V", "checkValue", "", "classMap", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationModel;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "convertValueWithAnnotation", StrategyConstants.VALUE, "annotation", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLParamField;", Constants.KEY_DATA, "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationData;", "getInt", "", "getJavaOnlyMapParams", "", "clazz", "getMapWithDefault", "map", StrategyConstants.MODEL, "isNestClass", "", "isNestListClass", "parseStringByReturnType", "returnType", "Ljava/lang/Class;", "preCheck", "proxyValue", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WorkerDataProcessorForMap {
    public static final WorkerDataProcessorForMap INSTANCE = new WorkerDataProcessorForMap();

    /* compiled from: WorkerDataProcessorForMap.kt */
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

    private WorkerDataProcessorForMap() {
    }

    public final Map<String, Object> getJavaOnlyMapParams(HashMap<String, Object> params, IDLAnnotationData clazz) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IDLAnnotationModel preCheck = preCheck(clazz.getXBridgeParamModel(), params);
        if (preCheck == null) {
            return null;
        }
        HashMap<String, Object> hashMap = params;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(hashMap.size()));
        Iterator<T> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            IDLParamField iDLParamField = (IDLParamField) preCheck.getStringModel().get(entry.getKey());
            linkedHashMap.put(key, INSTANCE.convertValueWithAnnotation(entry.getValue(), iDLParamField, clazz));
        }
        return linkedHashMap;
    }

    private final Object proxyValue(final Class<? extends XBaseModel> clazz, final HashMap<String, Object> map, final IDLAnnotationData data) throws IllegalInputParamException {
        final IDLAnnotationModel preCheck;
        if (clazz == null || (preCheck = preCheck((IDLAnnotationModel) data.getModels().get(clazz), map)) == null) {
            return null;
        }
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() { // from class: com.bytedance.android.anniex.worker.WorkerDataProcessorForMap$proxyValue$1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object convertValueWithAnnotation;
                Map mapWithDefault;
                if (Intrinsics.areEqual(method.getName(), "toJSON")) {
                    mapWithDefault = WorkerDataProcessorForMap.INSTANCE.getMapWithDefault(map, (IDLAnnotationModel) data.getModels().get(clazz), data);
                    return new JSONObject(mapWithDefault);
                }
                IDLParamField iDLParamField = (IDLParamField) preCheck.getMethodModel().get(method);
                convertValueWithAnnotation = WorkerDataProcessorForMap.INSTANCE.convertValueWithAnnotation(map.get(iDLParamField != null ? iDLParamField.getKeyPath() : null), iDLParamField, data);
                return convertValueWithAnnotation;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object convertValueWithAnnotation(Object value, IDLParamField annotation, IDLAnnotationData data) {
        KClass nestedClassType;
        KClass nestedClassType2;
        Class<? extends XBaseModel> cls = null;
        if (isNestClass(value, annotation)) {
            if (annotation != null && (nestedClassType2 = annotation.getNestedClassType()) != null) {
                cls = JvmClassMappingKt.getJavaClass(nestedClassType2);
            }
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
            HashMap<String, Object> hashMap = ((ReadableMap) value).toHashMap();
            Intrinsics.checkNotNullExpressionValue(hashMap, "value as ReadableMap).toHashMap()");
            return proxyValue(cls, hashMap, data);
        }
        if (isNestListClass(value, annotation)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) value;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Object obj : list) {
                WorkerDataProcessorForMap workerDataProcessorForMap = INSTANCE;
                Class<? extends XBaseModel> javaClass = (annotation == null || (nestedClassType = annotation.getNestedClassType()) == null) ? null : JvmClassMappingKt.getJavaClass(nestedClassType);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
                HashMap<String, Object> hashMap2 = ((ReadableMap) obj).toHashMap();
                Intrinsics.checkNotNullExpressionValue(hashMap2, "it as ReadableMap).toHashMap()");
                arrayList.add(workerDataProcessorForMap.proxyValue(javaClass, hashMap2, data));
            }
            return arrayList;
        }
        return WorkerConvertUtils.INSTANCE.getValue(value);
    }

    private final void checkValue(IDLAnnotationModel classMap, HashMap<String, Object> params) {
        for (Map.Entry entry : classMap.getStringModel().entrySet()) {
            String str = (String) entry.getKey();
            IDLParamField iDLParamField = (IDLParamField) entry.getValue();
            Object obj = params.get(str);
            if (iDLParamField.getRequired() && obj == null) {
                throw new IllegalInputParamException(((String) entry.getKey()) + " param is missing from input");
            }
            Class returnType = iDLParamField.getReturnType();
            boolean z = true;
            if (Intrinsics.areEqual(returnType, String.class)) {
                if (obj != null && !(obj instanceof String)) {
                    throw new IllegalInputParamException(((String) entry.getKey()) + " param has wrong declared type. except string,but " + obj.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Number.class)) {
                if (obj != null && !(obj instanceof Number)) {
                    throw new IllegalInputParamException(((String) entry.getKey()) + " param has wrong declared type. except number,but " + obj.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Boolean.class) ? true : Intrinsics.areEqual(returnType, Boolean.TYPE)) {
                if (obj != null && !(obj instanceof Boolean)) {
                    throw new IllegalInputParamException(((String) entry.getKey()) + " param has wrong declared type. except boolean,but " + obj.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, List.class)) {
                if (obj != null && !(obj instanceof List)) {
                    throw new IllegalInputParamException(((String) entry.getKey()) + " param has wrong declared type. except List ,but " + obj.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Map.class) && obj != null && !(obj instanceof Map)) {
                throw new IllegalInputParamException(((String) entry.getKey()) + " param has wrong declared type. except Map ,but " + obj.getClass());
            }
            if (obj != null && iDLParamField.isEnum()) {
                Class returnType2 = iDLParamField.getReturnType();
                if (Intrinsics.areEqual(returnType2, String.class)) {
                    List stringEnum = iDLParamField.getStringEnum();
                    if (!CollectionsKt.contains(stringEnum, obj)) {
                        throw new IllegalInputParamException(((String) entry.getKey()) + " has wrong type.should be one of " + stringEnum + " but got " + obj);
                    }
                } else if (Intrinsics.areEqual(returnType2, Number.class)) {
                    List intEnum = iDLParamField.getIntEnum();
                    if (!intEnum.contains(Integer.valueOf(INSTANCE.getInt(obj)))) {
                        throw new IllegalInputParamException(((String) entry.getKey()) + " has wrong value.should be one of " + intEnum + " but got " + obj);
                    }
                } else if (Intrinsics.areEqual(returnType2, Map.class)) {
                    List stringEnum2 = iDLParamField.getStringEnum();
                    if (!stringEnum2.isEmpty()) {
                        Map map = (Map) obj;
                        if (!map.isEmpty()) {
                            Iterator it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                if (!CollectionsKt.contains(stringEnum2, ((Map.Entry) it.next()).getValue())) {
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            throw new IllegalInputParamException(((String) entry.getKey()) + " has wrong type.should be one of " + stringEnum2 + " but got " + obj);
                        }
                    } else {
                        List intEnum2 = iDLParamField.getIntEnum();
                        if (!intEnum2.isEmpty()) {
                            Map map2 = (Map) obj;
                            if (!map2.isEmpty()) {
                                Iterator it2 = map2.entrySet().iterator();
                                while (it2.hasNext()) {
                                    if (!intEnum2.contains(Integer.valueOf(INSTANCE.getInt(((Map.Entry) it2.next()).getValue())))) {
                                        break;
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                                throw new IllegalInputParamException(((String) entry.getKey()) + " has wrong value.should be one of " + intEnum2 + " but got " + obj);
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

    private final boolean isNestClass(Object value, IDLParamField annotation) {
        if (value instanceof Map) {
            if (!Intrinsics.areEqual(annotation != null ? annotation.getNestedClassType() : null, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class))) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNestListClass(Object value, IDLParamField annotation) {
        if (value instanceof List) {
            if (!Intrinsics.areEqual(annotation != null ? annotation.getNestedClassType() : null, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class))) {
                return true;
            }
        }
        return false;
    }

    private final IDLAnnotationModel preCheck(IDLAnnotationModel classMap, HashMap<String, Object> map) {
        if (classMap == null) {
            return null;
        }
        HashMap stringModel = classMap.getStringModel();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : stringModel.entrySet()) {
            if (map.get(entry.getKey()) == null && ((IDLParamField) entry.getValue()).getDefaultValue().getType() != DefaultType.NONE) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            IDLParamField iDLParamField = (IDLParamField) entry2.getValue();
            map.put(entry2.getKey(), INSTANCE.parseStringByReturnType(iDLParamField.getReturnType(), iDLParamField));
        }
        checkValue(classMap, map);
        return classMap;
    }

    private final Object parseStringByReturnType(Class<?> returnType, IDLParamField annotation) {
        if (!Intrinsics.areEqual(returnType, Number.class)) {
            return Intrinsics.areEqual(returnType, Boolean.TYPE) ? true : Intrinsics.areEqual(returnType, Boolean.class) ? Boolean.valueOf(annotation.getDefaultValue().getBoolValue()) : annotation.getDefaultValue().getStringValue();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[annotation.getDefaultValue().getType().ordinal()];
        if (i == 1) {
            return Double.valueOf(annotation.getDefaultValue().getDoubleValue());
        }
        if (i == 2) {
            return Long.valueOf(annotation.getDefaultValue().getLongValue());
        }
        if (i == 3) {
            return Integer.valueOf(annotation.getDefaultValue().getIntValue());
        }
        return Integer.valueOf(annotation.getDefaultValue().getIntValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getMapWithDefault(HashMap<String, Object> map, IDLAnnotationModel model, IDLAnnotationData data) {
        ArrayList arrayList;
        if (model == null) {
            return null;
        }
        HashMap stringModel = model.getStringModel();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(stringModel.size()));
        for (Map.Entry entry : stringModel.entrySet()) {
            Object key = entry.getKey();
            Object obj = map.get(((IDLParamField) entry.getValue()).getKeyPath());
            if (obj == null && ((IDLParamField) entry.getValue()).getDefaultValue().getType() != DefaultType.NONE) {
                map.put(((IDLParamField) entry.getValue()).getKeyPath(), INSTANCE.parseStringByReturnType(((IDLParamField) entry.getValue()).getReturnType(), (IDLParamField) entry.getValue()));
            }
            if (!Intrinsics.areEqual(((IDLParamField) entry.getValue()).getNestedClassType(), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && (obj instanceof ReadableMap)) {
                WorkerDataProcessorForMap workerDataProcessorForMap = INSTANCE;
                HashMap<String, Object> hashMap = ((ReadableMap) obj).toHashMap();
                Intrinsics.checkNotNullExpressionValue(hashMap, "value.toHashMap()");
                Object obj2 = data.getModels().get(JvmClassMappingKt.getJavaClass(((IDLParamField) entry.getValue()).getNestedClassType()));
                Intrinsics.checkNotNull(obj2);
                arrayList = workerDataProcessorForMap.getMapWithDefault(hashMap, (IDLAnnotationModel) obj2, data);
            } else if (!Intrinsics.areEqual(((IDLParamField) entry.getValue()).getNestedClassType(), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && (obj instanceof ReadableArray)) {
                ArrayList arrayList2 = ((ReadableArray) obj).toArrayList();
                Intrinsics.checkNotNullExpressionValue(arrayList2, "value.toArrayList()");
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (Object obj3 : arrayList3) {
                    WorkerDataProcessorForMap workerDataProcessorForMap2 = INSTANCE;
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
                    HashMap<String, Object> hashMap2 = ((ReadableMap) obj3).toHashMap();
                    Intrinsics.checkNotNullExpressionValue(hashMap2, "v as ReadableMap).toHashMap()");
                    Object obj4 = data.getModels().get(JvmClassMappingKt.getJavaClass(((IDLParamField) entry.getValue()).getNestedClassType()));
                    Intrinsics.checkNotNull(obj4);
                    arrayList4.add(workerDataProcessorForMap2.getMapWithDefault(hashMap2, (IDLAnnotationModel) obj4, data));
                }
                arrayList = arrayList4;
            } else {
                arrayList = map.get(((IDLParamField) entry.getValue()).getKeyPath());
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }
}
