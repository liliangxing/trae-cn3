package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.mix.AllowListForSpecialLogic;
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
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtilsKt;
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
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebPlatformDataProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003JL\u0010\u0004\u001a\u00020\u00052:\u0010\u0006\u001a6\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u0007j\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t`\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0002J0\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u00022\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018H\u0002J$\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\"\u0010\u001d\u001a\u00020\u00022\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u00182\u0006\u0010\u001e\u001a\u00020\u0002H\u0002J\u001c\u0010\u001f\u001a\u00020 2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010!\u001a\u00020 2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002JZ\u0010$\u001a:\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0018\u00010\u0007j\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0018\u0001`\f2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010%\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J>\u0010&\u001a\u00020\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00162\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0\u00182\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)H\u0016J0\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u00022\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0\u0018H\u0016J\u001e\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00162\u0006\u0010\r\u001a\u00020\u0002H\u0016J8\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u00022\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0\u00182\u0006\u0010-\u001a\u00020\bH\u0016J&\u0010.\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\n01H\u0002J>\u00102\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H30\u0016\"\u0004\b\u0000\u00103*\u00020\u00022\u001e\u00104\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\t\u0012\u0004\u0012\u0002H305H\u0002¨\u00066"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/WebPlatformDataProcessor;", "Lcom/bytedance/sdk/xbridge/cn/protocol/IPlatformDataProcessor;", "Lorg/json/JSONObject;", "()V", "checkValue", "", "classMap", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "Ljava/lang/reflect/Method;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/annotation/XBridgeParamField;", "Lkotlin/collections/HashMap;", "params", "convertValueWithAnnotation", "", "value", "annotation", "getInt", "", "data", "getJsonObjectParams", "", "clazz", "Ljava/lang/Class;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "getJsonWithDefault", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "map", "getMapWithDefault", "json", "isNestClass", "", "isNestListClass", "parseStringByReturnType", "method", "preCheck", "proxyValue", "transformMapToPlatformData", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "transformPlatformDataToMap", "transformPlatformDataToMapCompat", "transformPlatformDataToMapWithNamespace", "nameSpace", "initDefaultValue", "", "getters", "", "mapValues", "R", "op", "Lkotlin/Function1;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WebPlatformDataProcessor implements IPlatformDataProcessor<JSONObject, JSONObject> {

    /* compiled from: WebPlatformDataProcessor.kt */
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

    @Override // com.bytedance.sdk.xbridge.cn.protocol.IPlatformDataProcessor
    public /* bridge */ /* synthetic */ JSONObject transformMapToPlatformData(Map map, Class cls, BaseBridgeCall<JSONObject> baseBridgeCall) {
        return transformMapToPlatformData2((Map<String, ? extends Object>) map, (Class<? extends IDLXBridgeMethod>) cls, baseBridgeCall);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.IPlatformDataProcessor
    public /* bridge */ /* synthetic */ Map transformPlatformDataToMap(JSONObject jSONObject, Class cls) {
        return transformPlatformDataToMap2(jSONObject, (Class<? extends IDLXBridgeMethod>) cls);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.IPlatformDataProcessor
    public /* bridge */ /* synthetic */ Map transformPlatformDataToMapWithNamespace(JSONObject jSONObject, Class cls, String str) {
        return transformPlatformDataToMapWithNamespace2(jSONObject, (Class<? extends IDLXBridgeMethod>) cls, str);
    }

    /* renamed from: transformPlatformDataToMapWithNamespace, reason: avoid collision after fix types in other method */
    public Map<String, Object> transformPlatformDataToMapWithNamespace2(JSONObject params, Class<? extends IDLXBridgeMethod> clazz, String nameSpace) {
        Object opt;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(nameSpace, "nameSpace");
        if (Intrinsics.areEqual(nameSpace, "webcast")) {
            Iterator<String> keys = params.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "params.keys()");
            JSONObject jSONObject = new JSONObject();
            while (keys.hasNext()) {
                String next = keys.next();
                if (params.opt(next) != null && !Intrinsics.areEqual(params.opt(next).toString(), "null") && (opt = params.opt(next)) != null) {
                    jSONObject.put(next, opt);
                }
            }
            return transformPlatformDataToMap2(jSONObject, clazz);
        }
        return transformPlatformDataToMap2(params, clazz);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: transformPlatformDataToMap, reason: avoid collision after fix types in other method */
    public Map<String, Object> transformPlatformDataToMap2(JSONObject params, Class<? extends IDLXBridgeMethod> clazz) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IDLAnnotationData iDLAnnotationData = XBridgeAnnotationCache.INSTANCE.getBRIDGE_ANNOTATION_MAP().get(clazz);
        if (iDLAnnotationData != null) {
            return WebProcessorForMap.INSTANCE.getJavaOnlyMapParams(params, iDLAnnotationData);
        }
        Class<?> retrieveParamModel = ParamModelFinder.INSTANCE.retrieveParamModel(clazz);
        if (retrieveParamModel == null && (retrieveParamModel = XBridgeDynamicModel.INSTANCE.findParamModelByAnnotation(clazz)) == null) {
            return null;
        }
        return getJsonObjectParams(params, retrieveParamModel);
    }

    private final Map<String, Object> getJsonObjectParams(JSONObject params, Class<? extends XBaseParamModel> clazz) {
        final HashMap<String, Pair<Method, XBridgeParamField>> preCheck = preCheck(clazz, params);
        if (preCheck == null) {
            return null;
        }
        return mapValues(params, new Function1<Pair<? extends String, ? extends Object>, Object>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebPlatformDataProcessor$getJsonObjectParams$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Object invoke(Pair<String, ? extends Object> pair) {
                Object convertValueWithAnnotation;
                Intrinsics.checkNotNullParameter(pair, "it");
                Pair<Method, XBridgeParamField> pair2 = preCheck.get(pair.getFirst());
                convertValueWithAnnotation = this.convertValueWithAnnotation(pair.getSecond(), pair2 != null ? (XBridgeParamField) pair2.getSecond() : null);
                return convertValueWithAnnotation;
            }
        });
    }

    private final HashMap<String, Pair<Method, XBridgeParamField>> preCheck(Class<? extends XBaseModel> clazz, JSONObject params) {
        Method[] declaredMethods;
        if (clazz == null || (declaredMethods = clazz.getDeclaredMethods()) == null) {
            return null;
        }
        HashMap<String, Pair<Method, XBridgeParamField>> hashMap = new HashMap<>();
        for (Method method : declaredMethods) {
            XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
            if (xBridgeParamField != null) {
                String keyPath = xBridgeParamField.keyPath();
                Intrinsics.checkNotNullExpressionValue(method, "method");
                hashMap.put(keyPath, new Pair<>(method, xBridgeParamField));
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Pair<Method, XBridgeParamField>> entry : hashMap.entrySet()) {
            if ((params.has(entry.getKey()) || ((XBridgeParamField) entry.getValue().getSecond()).defaultValue().type() == DefaultType.NONE) ? false : true) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            params.put((String) entry2.getKey(), parseStringByReturnType((Method) ((Pair) entry2.getValue()).getFirst(), (XBridgeParamField) ((Pair) entry2.getValue()).getSecond()));
        }
        checkValue(hashMap, params);
        return hashMap;
    }

    private final void checkValue(HashMap<String, Pair<Method, XBridgeParamField>> classMap, JSONObject params) {
        for (final Map.Entry<String, Pair<Method, XBridgeParamField>> entry : classMap.entrySet()) {
            XBridgeParamField xBridgeParamField = (XBridgeParamField) entry.getValue().getSecond();
            Method method = (Method) entry.getValue().getFirst();
            final Object opt = params.opt(entry.getKey());
            if (xBridgeParamField.required() && (opt == null || Intrinsics.areEqual(opt, JSONObject.NULL))) {
                throw new IllegalInputParamException(entry.getKey() + " param is missing from input");
            }
            Class<?> returnType = method.getReturnType();
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
            if (opt != null && xBridgeParamField.isEnum()) {
                Class<?> returnType2 = method.getReturnType();
                if (Intrinsics.areEqual(returnType2, String.class)) {
                    String[] option = ((XBridgeStringEnum) method.getAnnotation(XBridgeStringEnum.class)).option();
                    if (!ArraysKt.contains(option, opt)) {
                        throw new IllegalInputParamException(entry.getKey() + " has wrong type.should be one of " + ArraysKt.asList(option) + " but got " + opt);
                    }
                } else if (Intrinsics.areEqual(returnType2, Number.class)) {
                    int[] option2 = ((XBridgeIntEnum) method.getAnnotation(XBridgeIntEnum.class)).option();
                    if (!ArraysKt.contains(option2, getInt(opt))) {
                        throw new IllegalInputParamException(entry.getKey() + " has wrong value.should be one of " + ArraysKt.asList(option2) + " but got " + opt);
                    }
                } else if (Intrinsics.areEqual(returnType2, Map.class)) {
                    XBridgeStringEnum xBridgeStringEnum = (XBridgeStringEnum) method.getAnnotation(XBridgeStringEnum.class);
                    if (xBridgeStringEnum != null) {
                        final String[] option3 = xBridgeStringEnum.option();
                        mapValues((JSONObject) opt, new Function1<Pair<? extends String, ? extends Object>, Unit>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebPlatformDataProcessor$checkValue$1$1
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
                                if (!ArraysKt.contains(option3, pair.getSecond())) {
                                    throw new IllegalInputParamException(entry.getKey() + " has wrong value.should be one of " + ArraysKt.asList(option3) + " but got " + opt);
                                }
                            }
                        });
                    } else {
                        XBridgeIntEnum xBridgeIntEnum = (XBridgeIntEnum) method.getAnnotation(XBridgeIntEnum.class);
                        if (xBridgeIntEnum != null) {
                            final int[] option4 = xBridgeIntEnum.option();
                            mapValues((JSONObject) opt, new Function1<Pair<? extends String, ? extends Object>, Unit>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebPlatformDataProcessor$checkValue$1$2
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
                                    int i;
                                    Intrinsics.checkNotNullParameter(pair, "item");
                                    int[] iArr = option4;
                                    i = this.getInt(pair.getSecond());
                                    if (!ArraysKt.contains(iArr, i)) {
                                        throw new IllegalInputParamException(entry.getKey() + " has wrong value.should be one of " + ArraysKt.asList(option4) + " but got " + opt);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInt(Object data) {
        if (data instanceof Number) {
            return ((Number) data).intValue();
        }
        if (data == null) {
            throw new IllegalInputParamException("the key is null");
        }
        throw new IllegalInputParamException("the key is not a number");
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
    public final Object proxyValue(final Class<? extends XBaseModel> clazz, final JSONObject map) {
        if (clazz == null || preCheck(clazz, map) == null) {
            return null;
        }
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebPlatformDataProcessor$proxyValue$1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object convertValueWithAnnotation;
                JSONObject mapWithDefault;
                if (Intrinsics.areEqual(method.getName(), "toJSON")) {
                    mapWithDefault = WebPlatformDataProcessor.this.getMapWithDefault(clazz, map);
                    return mapWithDefault;
                }
                XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
                convertValueWithAnnotation = WebPlatformDataProcessor.this.convertValueWithAnnotation(map.opt(xBridgeParamField.keyPath()), xBridgeParamField);
                return convertValueWithAnnotation;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object convertValueWithAnnotation(Object value, final XBridgeParamField annotation) {
        if (isNestClass(value, annotation)) {
            Class<? extends XBaseModel> nestedClassType = annotation != null ? annotation.nestedClassType() : null;
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type org.json.JSONObject");
            return proxyValue(nestedClassType, (JSONObject) value);
        }
        if (isNestListClass(value, annotation)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type org.json.JSONArray");
            return ConvertUtilsKt.map((JSONArray) value, new Function1<Object, Object>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebPlatformDataProcessor$convertValueWithAnnotation$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Object invoke(Object obj) {
                    Object proxyValue;
                    Intrinsics.checkNotNullParameter(obj, "it");
                    WebPlatformDataProcessor webPlatformDataProcessor = WebPlatformDataProcessor.this;
                    XBridgeParamField xBridgeParamField = annotation;
                    proxyValue = webPlatformDataProcessor.proxyValue(xBridgeParamField != null ? xBridgeParamField.nestedClassType() : null, (JSONObject) obj);
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

    private final boolean isNestClass(Object value, XBridgeParamField annotation) {
        if (value instanceof JSONObject) {
            if (!Intrinsics.areEqual(annotation != null ? Reflection.getOrCreateKotlinClass(annotation.nestedClassType()) : null, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class))) {
                return true;
            }
        }
        return false;
    }

    private final boolean isNestListClass(Object value, XBridgeParamField annotation) {
        if (value instanceof JSONArray) {
            if (!Intrinsics.areEqual(annotation != null ? Reflection.getOrCreateKotlinClass(annotation.nestedClassType()) : null, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        if (r5.isGetter() == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject getMapWithDefault(Class<? extends XBaseModel> clazz, JSONObject json) {
        ArrayList<Method> arrayList;
        Object opt;
        Method[] declaredMethods;
        if (clazz == null || (declaredMethods = clazz.getDeclaredMethods()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Method method : declaredMethods) {
                XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
                boolean z = xBridgeParamField != null;
                if (z) {
                    arrayList2.add(method);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        for (Method method2 : arrayList) {
            XBridgeParamField xBridgeParamField2 = (XBridgeParamField) method2.getAnnotation(XBridgeParamField.class);
            Object opt2 = json.opt(xBridgeParamField2.keyPath());
            if (opt2 == null && xBridgeParamField2.defaultValue().type() != DefaultType.NONE) {
                Intrinsics.checkNotNullExpressionValue(method2, "method");
                Intrinsics.checkNotNullExpressionValue(xBridgeParamField2, "annotation");
                json.put(xBridgeParamField2.keyPath(), parseStringByReturnType(method2, xBridgeParamField2));
            }
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(xBridgeParamField2.nestedClassType());
            String keyPath = xBridgeParamField2.keyPath();
            if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(xBridgeParamField2.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && (opt2 instanceof JSONObject)) {
                opt = getMapWithDefault(JvmClassMappingKt.getJavaClass(orCreateKotlinClass), (JSONObject) opt2);
            } else if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(xBridgeParamField2.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && (opt2 instanceof JSONArray)) {
                opt = ConvertUtilsKt.map((JSONArray) opt2, new Function1<Object, JSONObject>() { // from class: com.bytedance.sdk.xbridge.cn.platform.web.WebPlatformDataProcessor$getMapWithDefault$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final JSONObject invoke(Object obj) {
                        JSONObject mapWithDefault;
                        Intrinsics.checkNotNullParameter(obj, "it");
                        mapWithDefault = WebPlatformDataProcessor.this.getMapWithDefault(JvmClassMappingKt.getJavaClass(orCreateKotlinClass), (JSONObject) obj);
                        return mapWithDefault;
                    }
                });
            } else {
                opt = json.opt(xBridgeParamField2.keyPath());
            }
            jSONObject.put(keyPath, opt);
        }
        return jSONObject;
    }

    private final void initDefaultValue(Map<String, Object> map, List<Method> list) {
        ArrayList<Method> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((XBridgeParamField) ((Method) obj).getAnnotation(XBridgeParamField.class)).defaultValue().type() != DefaultType.NONE) {
                arrayList.add(obj);
            }
        }
        for (Method method : arrayList) {
            XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
            String keyPath = xBridgeParamField.keyPath();
            Intrinsics.checkNotNullExpressionValue(xBridgeParamField, "annotation");
            map.put(keyPath, parseStringByReturnType(method, xBridgeParamField));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r6.isGetter() == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject getJsonWithDefault(Class<? extends XBaseModel> clazz, JSONObject map) {
        ArrayList<Method> arrayList;
        Object opt;
        Method[] declaredMethods;
        JSONObject jSONObject = null;
        if (clazz == null || (declaredMethods = clazz.getDeclaredMethods()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Method method : declaredMethods) {
                XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
                boolean z = xBridgeParamField != null;
                if (z) {
                    arrayList2.add(method);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            jSONObject = new JSONObject();
            for (Method method2 : arrayList) {
                XBridgeParamField xBridgeParamField2 = (XBridgeParamField) method2.getAnnotation(XBridgeParamField.class);
                Object opt2 = map.opt(xBridgeParamField2.keyPath());
                if (opt2 == null && xBridgeParamField2.defaultValue().type() != DefaultType.NONE) {
                    Intrinsics.checkNotNullExpressionValue(method2, "method");
                    Intrinsics.checkNotNullExpressionValue(xBridgeParamField2, "annotation");
                    map.put(xBridgeParamField2.keyPath(), parseStringByReturnType(method2, xBridgeParamField2));
                }
                String keyPath = xBridgeParamField2.keyPath();
                if (!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(xBridgeParamField2.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && opt2 != null) {
                    opt = getJsonWithDefault(xBridgeParamField2.nestedClassType(), (JSONObject) opt2);
                } else {
                    opt = map.opt(xBridgeParamField2.keyPath());
                }
                jSONObject.put(keyPath, opt);
            }
        }
        return jSONObject;
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

    @Override // com.bytedance.sdk.xbridge.cn.protocol.IPlatformDataProcessor
    /* renamed from: transformMapToPlatformData, reason: avoid collision after fix types in other method */
    public JSONObject transformMapToPlatformData2(Map<String, ? extends Object> params, Class<? extends IDLXBridgeMethod> clazz, BaseBridgeCall<JSONObject> call) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object obj = params.get(AllowListForSpecialLogic.JSB2_DATA);
        if (obj != null) {
            return (JSONObject) obj;
        }
        return ConvertUtils.INSTANCE.mapToJSON(params, call != null ? call.getBigIntStrategy() : 0);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.IPlatformDataProcessor
    public Map<String, Object> transformPlatformDataToMapCompat(JSONObject params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return ConvertUtils.INSTANCE.jsonToMap(params);
    }
}
