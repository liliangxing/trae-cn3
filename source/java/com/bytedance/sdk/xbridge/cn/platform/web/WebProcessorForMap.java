package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLAnnotationData;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLAnnotationModel;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtilsKt;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebProcessorForMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000eJ$\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\u001a\u001a\u00020\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\u001b\u001a\u00020\u00012\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0002J,\u0010\u001f\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020 \u0018\u00010\u001d2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J>\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u0002H\"0\u0012\"\u0004\b\u0000\u0010\"*\u00020\b2\u001e\u0010#\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010%\u0012\u0004\u0012\u0002H\"0$H\u0002¨\u0006&"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/WebProcessorForMap;", "", "()V", "checkValue", "", "classMap", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationModel;", "params", "Lorg/json/JSONObject;", "convertValueWithAnnotation", "value", "annotation", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLParamField;", "data", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationData;", "getInt", "", "getJavaOnlyMapParams", "", "", "clazz", "getMapWithDefault", "map", "model", "isNestClass", "", "isNestListClass", "parseStringByReturnType", "returnType", "Ljava/lang/Class;", "preCheck", "proxyValue", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "mapValues", "R", "op", "Lkotlin/Function1;", "Lkotlin/Pair;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WebProcessorForMap {
    public static final WebProcessorForMap INSTANCE = new WebProcessorForMap();

    /* compiled from: WebProcessorForMap.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
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

    private WebProcessorForMap() {
    }

    public final Map<String, Object> getJavaOnlyMapParams(JSONObject params, final IDLAnnotationData clazz) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        final IDLAnnotationModel preCheck = preCheck(clazz.getXBridgeParamModel(), params);
        if (preCheck == null) {
            return null;
        }
        return mapValues(params, new Function1<Pair<? extends String, ? extends Object>, Object>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebProcessorForMap$getJavaOnlyMapParams$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(Pair<String, ? extends Object> pair) {
                Object convertValueWithAnnotation;
                Intrinsics.checkNotNullParameter(pair, "it");
                IDLParamField iDLParamField = IDLAnnotationModel.this.getStringModel().get(pair.getFirst());
                convertValueWithAnnotation = WebProcessorForMap.INSTANCE.convertValueWithAnnotation(pair.getSecond(), iDLParamField, clazz);
                return convertValueWithAnnotation;
            }
        });
    }

    private final <R> Map<String, R> mapValues(JSONObject jSONObject, Function1<? super Pair<String, ? extends Object>, ? extends R> function1) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "it");
            hashMap.put(next, function1.invoke(new Pair(next, jSONObject.opt(next))));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object proxyValue(final Class<? extends XBaseModel> clazz, final JSONObject map, final IDLAnnotationData data) throws IllegalInputParamException {
        final IDLAnnotationModel preCheck;
        if (clazz == null || (preCheck = preCheck(data.getModels().get(clazz), map)) == null) {
            return null;
        }
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebProcessorForMap$proxyValue$1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object convertValueWithAnnotation;
                JSONObject mapWithDefault;
                if (Intrinsics.areEqual(method.getName(), "toJSON")) {
                    mapWithDefault = WebProcessorForMap.INSTANCE.getMapWithDefault(map, data.getModels().get(clazz), data);
                    return mapWithDefault;
                }
                IDLParamField iDLParamField = preCheck.getMethodModel().get(method);
                convertValueWithAnnotation = WebProcessorForMap.INSTANCE.convertValueWithAnnotation(map.opt(iDLParamField != null ? iDLParamField.getKeyPath() : null), iDLParamField, data);
                return convertValueWithAnnotation;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object convertValueWithAnnotation(Object value, final IDLParamField annotation, final IDLAnnotationData data) {
        KClass<? extends XBaseModel> nestedClassType;
        Class<? extends XBaseModel> cls = null;
        if (isNestClass(value, annotation)) {
            if (annotation != null && (nestedClassType = annotation.getNestedClassType()) != null) {
                cls = JvmClassMappingKt.getJavaClass(nestedClassType);
            }
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type org.json.JSONObject");
            return proxyValue(cls, (JSONObject) value, data);
        }
        if (isNestListClass(value, annotation)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type org.json.JSONArray");
            return ConvertUtilsKt.map((JSONArray) value, new Function1<Object, Object>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebProcessorForMap$convertValueWithAnnotation$result$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Object invoke(Object obj) {
                    Object proxyValue;
                    KClass<? extends XBaseModel> nestedClassType2;
                    Intrinsics.checkNotNullParameter(obj, "it");
                    WebProcessorForMap webProcessorForMap = WebProcessorForMap.INSTANCE;
                    IDLParamField iDLParamField = IDLParamField.this;
                    proxyValue = webProcessorForMap.proxyValue((iDLParamField == null || (nestedClassType2 = iDLParamField.getNestedClassType()) == null) ? null : JvmClassMappingKt.getJavaClass(nestedClassType2), (JSONObject) obj, data);
                    return proxyValue;
                }
            });
        }
        if (value instanceof JSONArray) {
            return ConvertUtils.INSTANCE.jsonToList((JSONArray) value);
        }
        if (value instanceof JSONObject) {
            return ConvertUtils.INSTANCE.jsonToMap((JSONObject) value);
        }
        if (Intrinsics.areEqual(value, JSONObject.NULL)) {
            return null;
        }
        return value;
    }

    private final void checkValue(IDLAnnotationModel classMap, JSONObject params) {
        for (final Map.Entry<String, IDLParamField> entry : classMap.getStringModel().entrySet()) {
            String key = entry.getKey();
            IDLParamField value = entry.getValue();
            final Object opt = params.opt(key);
            if (value.getRequired() && (opt == null || Intrinsics.areEqual(opt, JSONObject.NULL))) {
                throw new IllegalInputParamException(entry.getKey() + " param is missing from input");
            }
            Class<?> returnType = value.getReturnType();
            if (Intrinsics.areEqual(returnType, String.class)) {
                if (opt != null && !(opt instanceof String) && !Intrinsics.areEqual(opt, JSONObject.NULL)) {
                    throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except string,but " + opt.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Number.class)) {
                if (opt != null && !(opt instanceof Number) && !Intrinsics.areEqual(opt, JSONObject.NULL)) {
                    throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except number,but " + opt.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Boolean.class) ? true : Intrinsics.areEqual(returnType, Boolean.TYPE)) {
                if (opt != null && !(opt instanceof Boolean) && !Intrinsics.areEqual(opt, JSONObject.NULL)) {
                    throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except boolean,but " + opt.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, List.class)) {
                if (opt != null && !Intrinsics.areEqual(opt, JSONObject.NULL) && !(opt instanceof JSONArray)) {
                    throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except List ,but " + opt.getClass());
                }
            } else if (Intrinsics.areEqual(returnType, Map.class) && opt != null && !Intrinsics.areEqual(opt, JSONObject.NULL) && !(opt instanceof JSONObject)) {
                throw new IllegalInputParamException(entry.getKey() + " param has wrong declared type. except Map ,but " + opt.getClass());
            }
            if (opt != null && value.isEnum()) {
                Class<?> returnType2 = value.getReturnType();
                if (Intrinsics.areEqual(returnType2, String.class)) {
                    List<String> stringEnum = value.getStringEnum();
                    if (!CollectionsKt.contains(stringEnum, opt)) {
                        throw new IllegalInputParamException(entry.getKey() + " has wrong type.should be one of " + stringEnum + " but got " + opt);
                    }
                } else if (Intrinsics.areEqual(returnType2, Number.class)) {
                    List<Integer> intEnum = value.getIntEnum();
                    if (!intEnum.contains(Integer.valueOf(INSTANCE.getInt(opt)))) {
                        throw new IllegalInputParamException(entry.getKey() + " has wrong value.should be one of " + intEnum + " but got " + opt);
                    }
                } else if (Intrinsics.areEqual(returnType2, Map.class)) {
                    final List<String> stringEnum2 = value.getStringEnum();
                    if (!stringEnum2.isEmpty()) {
                        INSTANCE.mapValues((JSONObject) opt, new Function1<Pair<? extends String, ? extends Object>, Unit>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebProcessorForMap$checkValue$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Pair<String, ? extends Object>) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Pair<String, ? extends Object> pair) {
                                Intrinsics.checkNotNullParameter(pair, "item");
                                if (!CollectionsKt.contains(stringEnum2, pair.getSecond())) {
                                    throw new IllegalInputParamException(entry.getKey() + " has wrong value.should be one of " + stringEnum2 + " but got " + opt);
                                }
                            }
                        });
                    } else {
                        final List<Integer> intEnum2 = value.getIntEnum();
                        if (!intEnum2.isEmpty()) {
                            INSTANCE.mapValues((JSONObject) opt, new Function1<Pair<? extends String, ? extends Object>, Unit>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebProcessorForMap$checkValue$1$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Pair<String, ? extends Object>) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Pair<String, ? extends Object> pair) {
                                    Intrinsics.checkNotNullParameter(pair, "item");
                                    if (!CollectionsKt.contains(intEnum2, pair.getSecond())) {
                                        throw new IllegalInputParamException(entry.getKey() + " has wrong value.should be one of " + intEnum2 + " but got " + opt);
                                    }
                                }
                            });
                        }
                    }
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
        if (value instanceof JSONObject) {
            if (!Intrinsics.areEqual(annotation != null ? annotation.getNestedClassType() : null, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class))) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNestListClass(Object value, IDLParamField annotation) {
        if (value instanceof JSONArray) {
            if (!Intrinsics.areEqual(annotation != null ? annotation.getNestedClassType() : null, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class))) {
                return true;
            }
        }
        return false;
    }

    private final IDLAnnotationModel preCheck(IDLAnnotationModel classMap, JSONObject map) {
        if (classMap == null) {
            return null;
        }
        HashMap<String, IDLParamField> stringModel = classMap.getStringModel();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, IDLParamField> entry : stringModel.entrySet()) {
            if (map.opt(entry.getKey()) == null && entry.getValue().getDefaultValue().getType() != DefaultType.NONE) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            IDLParamField iDLParamField = (IDLParamField) entry2.getValue();
            map.put((String) entry2.getKey(), INSTANCE.parseStringByReturnType(iDLParamField.getReturnType(), iDLParamField));
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
    public final JSONObject getMapWithDefault(JSONObject map, IDLAnnotationModel model, final IDLAnnotationData data) {
        Object opt;
        if (model == null) {
            return null;
        }
        HashMap<String, IDLParamField> stringModel = model.getStringModel();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(stringModel.size()));
        Iterator<T> it = stringModel.entrySet().iterator();
        while (it.hasNext()) {
            final Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object opt2 = map.opt(((IDLParamField) entry.getValue()).getKeyPath());
            if (opt2 == null && ((IDLParamField) entry.getValue()).getDefaultValue().getType() != DefaultType.NONE) {
                map.put(((IDLParamField) entry.getValue()).getKeyPath(), INSTANCE.parseStringByReturnType(((IDLParamField) entry.getValue()).getReturnType(), (IDLParamField) entry.getValue()));
            }
            if (!Intrinsics.areEqual(((IDLParamField) entry.getValue()).getNestedClassType(), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && (opt2 instanceof JSONObject)) {
                IDLAnnotationModel iDLAnnotationModel = data.getModels().get(JvmClassMappingKt.getJavaClass(((IDLParamField) entry.getValue()).getNestedClassType()));
                Intrinsics.checkNotNull(iDLAnnotationModel);
                opt = INSTANCE.getMapWithDefault((JSONObject) opt2, iDLAnnotationModel, data);
            } else if (!Intrinsics.areEqual(((IDLParamField) entry.getValue()).getNestedClassType(), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && (opt2 instanceof JSONArray)) {
                opt = ConvertUtilsKt.map((JSONArray) opt2, new Function1<Object, JSONObject>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebProcessorForMap$getMapWithDefault$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final JSONObject invoke(Object obj) {
                        JSONObject mapWithDefault;
                        Intrinsics.checkNotNullParameter(obj, "v");
                        IDLAnnotationModel iDLAnnotationModel2 = IDLAnnotationData.this.getModels().get(JvmClassMappingKt.getJavaClass(entry.getValue().getNestedClassType()));
                        Intrinsics.checkNotNull(iDLAnnotationModel2);
                        mapWithDefault = WebProcessorForMap.INSTANCE.getMapWithDefault((JSONObject) obj, iDLAnnotationModel2, IDLAnnotationData.this);
                        return mapWithDefault;
                    }
                });
            } else {
                opt = map.opt(((IDLParamField) entry.getValue()).getKeyPath());
            }
            linkedHashMap.put(key, opt);
        }
        return new JSONObject(linkedHashMap);
    }
}
