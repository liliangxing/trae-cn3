package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.xbridge.IDLAnnotationData;
import com.bytedance.ies.xbridge.IDLParamField;
import com.bytedance.ies.xbridge.exception.IllegalInputParamException;
import com.bytedance.ies.xbridge.exception.IllegalOperationException;
import com.bytedance.ies.xbridge.exception.IllegalOutputParamException;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.mt.protector.ThrowableDisposer;
import java.lang.reflect.Method;
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

/* compiled from: XBridgeResultModelHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002J\"\u0010\f\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011J0\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002JE\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0010\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u001c¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/XBridgeResultModelHelper;", "", "()V", "checkEnum", "", "isEnum", "", "enumModel", "", "actualFieldValue", "keyPath", "", "checkEnumBasic", "convertToMapByCache", "pool", "Lcom/bytedance/ies/xbridge/IDLAnnotationData;", "contentMap", "", "getValue", "arg", "objectInstance", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", ThrowableDisposer.ConfItem.RETURN_TYPE, "getterAndSetter", "method", "Ljava/lang/reflect/Method;", "args", "", "(Lcom/bytedance/ies/xbridge/IDLAnnotationData;Ljava/util/Map;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeResultModelHelper {
    public static final XBridgeResultModelHelper INSTANCE = new XBridgeResultModelHelper();

    private XBridgeResultModelHelper() {
    }

    public final void convertToMapByCache(IDLAnnotationData pool, Map<String, Object> contentMap) {
        List<? extends Object> list;
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(contentMap, "contentMap");
        Iterator<Map.Entry<String, IDLParamField>> it = pool.getXBridgeResultModel().getStringModel().entrySet().iterator();
        while (it.hasNext()) {
            IDLParamField value = it.next().getValue();
            String keyPath = value.getKeyPath();
            boolean required = value.getRequired();
            Class<?> returnType = value.getReturnType();
            boolean isEnum = value.isEnum();
            if (isEnum && Intrinsics.areEqual(returnType, Number.class)) {
                list = value.getIntEnum();
            } else if (isEnum && Intrinsics.areEqual(returnType, String.class)) {
                list = value.getStringEnum();
            } else {
                list = null;
                if (isEnum && Intrinsics.areEqual(returnType, List.class)) {
                    KClass<? extends Object> primitiveClassType = value.getPrimitiveClassType();
                    if (Intrinsics.areEqual(primitiveClassType, Reflection.getOrCreateKotlinClass(Number.class))) {
                        list = value.getIntEnum();
                    } else if (Intrinsics.areEqual(primitiveClassType, Reflection.getOrCreateKotlinClass(String.class))) {
                        list = value.getStringEnum();
                    }
                } else if (isEnum && Intrinsics.areEqual(returnType, Map.class)) {
                    KClass<? extends Object> primitiveClassType2 = value.getPrimitiveClassType();
                    if (Intrinsics.areEqual(primitiveClassType2, Reflection.getOrCreateKotlinClass(Number.class))) {
                        list = value.getIntEnum();
                    } else if (Intrinsics.areEqual(primitiveClassType2, Reflection.getOrCreateKotlinClass(String.class))) {
                        list = value.getStringEnum();
                    }
                }
            }
            Object obj = contentMap.get(keyPath);
            if (obj == null && required) {
                throw new IllegalOutputParamException(keyPath + " is missing from output");
            }
            if (Intrinsics.areEqual(returnType, Number.class)) {
                if (obj != null) {
                    INSTANCE.checkEnum(isEnum, list, obj, keyPath);
                    if (!(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Long) && !(obj instanceof Float)) {
                        throw new IllegalOutputParamException(keyPath + " is of invalid return type");
                    }
                } else {
                    continue;
                }
            } else if (!Intrinsics.areEqual(returnType, String.class)) {
                if (Intrinsics.areEqual(returnType, Boolean.class) ? true : Intrinsics.areEqual(returnType, Boolean.TYPE)) {
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
                        INSTANCE.checkEnum(isEnum, list, obj, keyPath);
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
                        INSTANCE.checkEnum(isEnum, list, ((Map) obj).values(), keyPath);
                    }
                } else if (Intrinsics.areEqual(returnType, Object.class)) {
                    if (obj == null && required) {
                        throw new IllegalOutputParamException(keyPath + " is missing from output");
                    }
                } else if (obj != null && !(obj instanceof XBaseModel)) {
                    throw new IllegalInputParamException("Failed to parse type " + returnType.getName() + StringListParam.SPLIT_DELIMITER + obj + " must be sub class of XBaseModel");
                }
            } else {
                if (obj == null && required) {
                    throw new IllegalOutputParamException(keyPath + " is missing from output");
                }
                if (obj != null) {
                    INSTANCE.checkEnum(isEnum, list, obj, keyPath);
                    if (!(obj instanceof String)) {
                        throw new IllegalOutputParamException(keyPath + " is of invalid return type");
                    }
                } else {
                    continue;
                }
            }
            contentMap.put(value.getKeyPath(), INSTANCE.getValue(obj, XBaseModel.class, returnType));
        }
    }

    public final Object getterAndSetter(IDLAnnotationData pool, Map<String, Object> contentMap, Method method, Object[] args) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(contentMap, "contentMap");
        Intrinsics.checkNotNullParameter(method, "method");
        IDLParamField iDLParamField = pool.getXBridgeResultModel().getMethodModel().get(method);
        if (iDLParamField == null) {
            throw new IllegalOperationException("Unsupported method invocation in result model");
        }
        if (iDLParamField.isGetter()) {
            return contentMap.get(iDLParamField.getKeyPath());
        }
        contentMap.put(iDLParamField.getKeyPath(), args != null ? ArraysKt.firstOrNull(args) : null);
        return Unit.INSTANCE;
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

    private final void checkEnum(boolean isEnum, List<? extends Object> enumModel, Object actualFieldValue, String keyPath) {
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

    private final boolean checkEnumBasic(List<? extends Object> enumModel, Object actualFieldValue) {
        if (enumModel == null) {
            return false;
        }
        return !CollectionsKt.contains(enumModel, actualFieldValue);
    }
}
