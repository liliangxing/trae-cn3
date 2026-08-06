package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.xbridge.IDLAnnotationData;
import com.bytedance.ies.xbridge.IDLXBridgeRegistryCache;
import com.bytedance.ies.xbridge.annotation.XBridgeIntEnum;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeStringEnum;
import com.bytedance.ies.xbridge.exception.IllegalInputParamException;
import com.bytedance.ies.xbridge.exception.IllegalOperationException;
import com.bytedance.ies.xbridge.exception.IllegalOutputParamException;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.mt.protector.ThrowableDisposer;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XBridgeResultModelArguments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J6\u0010\r\u001a\u00020\u0004\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0002J#\u0010\u0014\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011¢\u0006\u0002\u0010\u0015J0\u0010\u0016\u001a\u0004\u0018\u00010\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00112\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/XBridgeResultModelArguments;", "", "()V", "checkEnum", "", "isEnum", "", "enumModel", "", "actualFieldValue", "keyPath", "", "checkEnumBasic", "convertToMap", "T", "Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "clazz", "Ljava/lang/Class;", "contentMap", "", "createModel", "(Ljava/lang/Class;)Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "getValue", "arg", "objectInstance", ThrowableDisposer.ConfItem.RETURN_TYPE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeResultModelArguments {
    public static final XBridgeResultModelArguments INSTANCE = new XBridgeResultModelArguments();

    private XBridgeResultModelArguments() {
    }

    public final <T extends XBaseModel> T createModel(final Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object newProxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() { // from class: com.bytedance.ies.xbridge.utils.XBridgeResultModelArguments$createModel$1
            private final Map<String, Object> contentMap = new LinkedHashMap();

            public final Map<String, Object> getContentMap() {
                return this.contentMap;
            }

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object proxy, Method method, Object[] args) {
                Intrinsics.checkNotNullParameter(method, "method");
                IDLAnnotationData annotationDataByResultClass = IDLXBridgeRegistryCache.INSTANCE.getAnnotationDataByResultClass(clazz);
                if (annotationDataByResultClass != null) {
                    if (Intrinsics.areEqual(method.getName(), "convert")) {
                        XBridgeResultModelHelper.INSTANCE.convertToMapByCache(annotationDataByResultClass, this.contentMap);
                        return this.contentMap;
                    }
                    return XBridgeResultModelHelper.INSTANCE.getterAndSetter(annotationDataByResultClass, this.contentMap, method, args);
                }
                System.out.println((Object) "idl Model->Map. no cache");
                if (Intrinsics.areEqual(method.getName(), "convert")) {
                    XBridgeResultModelArguments.INSTANCE.convertToMap(clazz, this.contentMap);
                    return this.contentMap;
                }
                XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
                if (xBridgeParamField != null && xBridgeParamField.isGetter()) {
                    return this.contentMap.get(((XBridgeParamField) method.getAnnotation(XBridgeParamField.class)).keyPath());
                }
                if (xBridgeParamField != null) {
                    this.contentMap.put(((XBridgeParamField) method.getAnnotation(XBridgeParamField.class)).keyPath(), args != null ? ArraysKt.firstOrNull(args) : null);
                    return Unit.INSTANCE;
                }
                throw new IllegalOperationException("Unsupported method invocation in result model");
            }
        });
        Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type T of com.bytedance.ies.xbridge.utils.XBridgeResultModelArguments.createModel");
        return (T) newProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends XBaseModel> void convertToMap(Class<T> clazz, Map<String, Object> contentMap) {
        Annotation annotation;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "clazz.declaredMethods");
        Method[] methodArr = declaredMethods;
        ArrayList<Method> arrayList = new ArrayList();
        int length = methodArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Method method = methodArr[i];
            XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
            if (xBridgeParamField != null && xBridgeParamField.isGetter()) {
                arrayList.add(method);
            }
            i++;
        }
        for (Method method2 : arrayList) {
            XBridgeParamField xBridgeParamField2 = (XBridgeParamField) method2.getAnnotation(XBridgeParamField.class);
            String keyPath = xBridgeParamField2.keyPath();
            boolean required = xBridgeParamField2.required();
            Class<?> returnType = method2.getReturnType();
            boolean isEnum = xBridgeParamField2.isEnum();
            if (isEnum && Intrinsics.areEqual(returnType, Number.class)) {
                annotation = method2.getAnnotation(XBridgeIntEnum.class);
            } else if (isEnum && Intrinsics.areEqual(returnType, String.class)) {
                annotation = method2.getAnnotation(XBridgeStringEnum.class);
            } else if (isEnum && Intrinsics.areEqual(returnType, List.class)) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(xBridgeParamField2.primitiveClassType());
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Number.class))) {
                    annotation = method2.getAnnotation(XBridgeIntEnum.class);
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        annotation = method2.getAnnotation(XBridgeStringEnum.class);
                    }
                    annotation = null;
                }
            } else {
                if (isEnum && Intrinsics.areEqual(returnType, Map.class)) {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(xBridgeParamField2.primitiveClassType());
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Number.class))) {
                        annotation = method2.getAnnotation(XBridgeIntEnum.class);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        annotation = method2.getAnnotation(XBridgeStringEnum.class);
                    }
                }
                annotation = null;
            }
            Object obj = contentMap.get(keyPath);
            if (obj == null && required) {
                throw new IllegalOutputParamException(keyPath + " is missing from output");
            }
            if (Intrinsics.areEqual(returnType, Number.class)) {
                if (obj != null) {
                    INSTANCE.checkEnum(isEnum, annotation, obj, keyPath);
                    if (!(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Long) && !(obj instanceof Float)) {
                        throw new IllegalOutputParamException(keyPath + " is of invalid return type");
                    }
                } else {
                    continue;
                }
            } else if (Intrinsics.areEqual(returnType, String.class)) {
                if (obj == null && required) {
                    throw new IllegalOutputParamException(keyPath + " is missing from output");
                }
                if (obj != null) {
                    INSTANCE.checkEnum(isEnum, annotation, obj, keyPath);
                    if (!(obj instanceof String)) {
                        throw new IllegalOutputParamException(keyPath + " is of invalid return type");
                    }
                } else {
                    continue;
                }
            } else if (Intrinsics.areEqual(returnType, Boolean.class) ? true : Intrinsics.areEqual(returnType, Boolean.TYPE)) {
                if (obj == null && required) {
                    throw new IllegalOutputParamException(keyPath + " is missing from output");
                }
                if (obj != null && !(obj instanceof Boolean)) {
                    throw new IllegalOutputParamException(keyPath + " is of invalid return type");
                }
            } else if (Intrinsics.areEqual(returnType, List.class)) {
                if (obj == null && required) {
                    throw new IllegalOutputParamException(keyPath + " is missing from output");
                }
                if (obj == null) {
                    continue;
                } else {
                    if (!(obj instanceof List)) {
                        throw new IllegalOutputParamException(keyPath + " is of invalid return type");
                    }
                    INSTANCE.checkEnum(isEnum, annotation, obj, keyPath);
                }
            } else if (Intrinsics.areEqual(returnType, Map.class)) {
                if (obj == null && required) {
                    throw new IllegalOutputParamException(keyPath + " is missing from output");
                }
                if (obj == null) {
                    continue;
                } else {
                    if (!(obj instanceof Map)) {
                        throw new IllegalOutputParamException(keyPath + " is of invalid return type");
                    }
                    INSTANCE.checkEnum(isEnum, annotation, ((Map) obj).values(), keyPath);
                }
            } else if (Intrinsics.areEqual(returnType, Object.class)) {
                if (obj == null && required) {
                    throw new IllegalOutputParamException(keyPath + " is missing from output");
                }
            } else if (obj != null && !(obj instanceof XBaseModel)) {
                throw new IllegalInputParamException("Failed to parse type " + returnType.getName() + StringListParam.SPLIT_DELIMITER + obj + " must be sub class of XBaseModel");
            }
            XBridgeResultModelArguments xBridgeResultModelArguments = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(returnType, ThrowableDisposer.ConfItem.RETURN_TYPE);
            contentMap.put(xBridgeParamField2.keyPath(), xBridgeResultModelArguments.getValue(obj, XBaseModel.class, returnType));
        }
    }

    private final void checkEnum(boolean isEnum, Annotation enumModel, Object actualFieldValue, String keyPath) {
        boolean checkEnumBasic;
        if (isEnum) {
            if (actualFieldValue instanceof Collection) {
                Iterable iterable = (Iterable) actualFieldValue;
                checkEnumBasic = false;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (INSTANCE.checkEnumBasic(enumModel, it.next())) {
                            checkEnumBasic = true;
                            break;
                        }
                    }
                }
            } else {
                checkEnumBasic = checkEnumBasic(enumModel, actualFieldValue);
            }
            if (checkEnumBasic) {
                throw new IllegalOutputParamException(keyPath + " is not valid");
            }
        }
    }

    private final boolean checkEnumBasic(Annotation enumModel, Object actualFieldValue) {
        if (enumModel instanceof XBridgeStringEnum) {
            if (ArraysKt.contains(((XBridgeStringEnum) enumModel).option(), actualFieldValue)) {
                return false;
            }
        } else if (enumModel instanceof XBridgeIntEnum) {
            int[] option = ((XBridgeIntEnum) enumModel).option();
            Intrinsics.checkNotNull(actualFieldValue, "null cannot be cast to non-null type kotlin.Int");
            if (ArraysKt.contains(option, ((Integer) actualFieldValue).intValue())) {
                return false;
            }
        }
        return true;
    }

    private final Object getValue(Object arg, Class<? extends XBaseModel> objectInstance, Class<?> returnType) {
        if (Intrinsics.areEqual(returnType, Object.class) && (arg instanceof IXAssignDir)) {
            return ((IXAssignDir) arg).getValue();
        }
        if ((arg instanceof Integer) || (arg instanceof String) || (arg instanceof Number) || (arg instanceof Boolean) || arg == null) {
            return arg;
        }
        if (arg instanceof List) {
            Iterable iterable = (Iterable) arg;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.getValue(it.next(), objectInstance, returnType));
            }
            return arrayList;
        }
        if (arg instanceof Map) {
            Map map = (Map) arg;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), INSTANCE.getValue(entry.getValue(), objectInstance, returnType));
            }
            return linkedHashMap;
        }
        if ((arg instanceof JSONObject) || (arg instanceof JSONArray)) {
            return arg;
        }
        XBaseModel cast = objectInstance.cast(arg);
        if (cast != null) {
            return cast.convert();
        }
        return null;
    }
}
