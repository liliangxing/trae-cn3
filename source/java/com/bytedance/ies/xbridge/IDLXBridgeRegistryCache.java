package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.annotation.XBridgeDefaultValue;
import com.bytedance.ies.xbridge.annotation.XBridgeIntEnum;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.annotation.XBridgeStringEnum;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.utils.ThreadPool;
import com.bytedance.ies.xbridge.utils.XLog;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XBridgeRegistryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0007J.\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0005H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0005JH\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u000522\u0010\u001c\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u0005\u0012\u0004\u0012\u00020\u001a0\u001dj\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u0005\u0012\u0004\u0012\u00020\u001a`\u001fH\u0002R%\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR%\u0010\n\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\"\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ies/xbridge/IDLXBridgeRegistryCache;", "", "()V", "BRIDGE_ANNOTATION_MAP", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "Lcom/bytedance/ies/xbridge/IDLAnnotationData;", "getBRIDGE_ANNOTATION_MAP", "()Ljava/util/concurrent/ConcurrentHashMap;", "BRIDGE_RESULT_MAP", "getBRIDGE_RESULT_MAP", "cache", "", "", "addAnnotationCache", "", "clazz", "annotationCache", "find", "findModelClassByAnnotation", "annotation", "", "getAnnotationDataByResultClass", "resultModelClazz", "getIDLParamField", "Lcom/bytedance/ies/xbridge/IDLAnnotationModel;", "paramModelClass", "models", "Ljava/util/HashMap;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "Lkotlin/collections/HashMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IDLXBridgeRegistryCache {
    public static final IDLXBridgeRegistryCache INSTANCE = new IDLXBridgeRegistryCache();
    private static final Map<Class<? extends IDLXBridgeMethod>, String> cache = new LinkedHashMap();
    private static final ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, IDLAnnotationData> BRIDGE_ANNOTATION_MAP = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Class<?>, Class<?>> BRIDGE_RESULT_MAP = new ConcurrentHashMap<>();

    private IDLXBridgeRegistryCache() {
    }

    public final ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, IDLAnnotationData> getBRIDGE_ANNOTATION_MAP() {
        return BRIDGE_ANNOTATION_MAP;
    }

    public final ConcurrentHashMap<Class<?>, Class<?>> getBRIDGE_RESULT_MAP() {
        return BRIDGE_RESULT_MAP;
    }

    @JvmStatic
    public static final String find(final Class<? extends IDLXBridgeMethod> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            Map<Class<? extends IDLXBridgeMethod>, String> map = cache;
            String str = map.get(clazz);
            if (str == null) {
                ThreadPool.INSTANCE.runInBackGround(new Runnable() { // from class: com.bytedance.ies.xbridge.IDLXBridgeRegistryCache$find$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        IDLXBridgeRegistryCache.INSTANCE.addAnnotationCache(clazz);
                    }
                });
                map.put(clazz, clazz.newInstance().getName());
                str = map.get(clazz);
                XLog.INSTANCE.info("Register local idl_bridge named :" + str);
            }
            return str == null ? "" : str;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAnnotationCache(Class<? extends IDLXBridgeMethod> clazz) {
        IDLAnnotationData annotationCache = annotationCache(clazz);
        if (annotationCache != null) {
            BRIDGE_ANNOTATION_MAP.put(clazz, annotationCache);
            BRIDGE_RESULT_MAP.put(annotationCache.getResultClass(), clazz);
        }
    }

    public final IDLAnnotationData getAnnotationDataByResultClass(Class<?> resultModelClazz) {
        Intrinsics.checkNotNullParameter(resultModelClazz, "resultModelClazz");
        Class<?> cls = BRIDGE_RESULT_MAP.get(resultModelClazz);
        if (cls == null) {
            return null;
        }
        return BRIDGE_ANNOTATION_MAP.get(cls);
    }

    private final IDLAnnotationData annotationCache(Class<? extends IDLXBridgeMethod> clazz) {
        Class<?> findModelClassByAnnotation;
        Class<?> findModelClassByAnnotation2 = findModelClassByAnnotation(clazz, XBridgeParamModel.class);
        if (findModelClassByAnnotation2 == null || (findModelClassByAnnotation = findModelClassByAnnotation(clazz, XBridgeResultModel.class)) == null) {
            return null;
        }
        HashMap<Class<? extends XBaseModel>, IDLAnnotationModel> hashMap = new HashMap<>();
        return new IDLAnnotationData(findModelClassByAnnotation2, findModelClassByAnnotation, getIDLParamField(findModelClassByAnnotation2, hashMap), getIDLParamField(findModelClassByAnnotation, hashMap), hashMap);
    }

    private final Class<?> findModelClassByAnnotation(Class<? extends IDLXBridgeMethod> clazz, Class<? extends Annotation> annotation) {
        Class<?> cls;
        Class<?> cls2;
        try {
            Class<?>[] declaredClasses = clazz.getSuperclass().getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(declaredClasses, "clazz.superclass.declaredClasses");
            Class<?>[] clsArr = declaredClasses;
            int length = clsArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    cls = null;
                    break;
                }
                cls = clsArr[i];
                if (cls.getAnnotation(annotation) != null) {
                    break;
                }
                i++;
            }
            Class<?> cls3 = cls;
            if (cls3 != null) {
                return cls3;
            }
            Class<?>[] declaredClasses2 = clazz.getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(declaredClasses2, "clazz.declaredClasses");
            Class<?>[] clsArr2 = declaredClasses2;
            int length2 = clsArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    cls2 = null;
                    break;
                }
                cls2 = clsArr2[i2];
                if (cls2.getAnnotation(annotation) != null) {
                    break;
                }
                i2++;
            }
            return cls2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final IDLAnnotationModel getIDLParamField(Class<?> paramModelClass, HashMap<Class<? extends XBaseModel>, IDLAnnotationModel> models) {
        List emptyList;
        List emptyList2;
        int[] option;
        String[] option2;
        Method[] declaredMethods = paramModelClass.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "methods");
        IDLAnnotationModel iDLAnnotationModel = new IDLAnnotationModel(null, null, 3, null);
        for (Method method : declaredMethods) {
            XBridgeParamField xBridgeParamField = (XBridgeParamField) method.getAnnotation(XBridgeParamField.class);
            if (xBridgeParamField != null) {
                XBridgeDefaultValue defaultValue = xBridgeParamField.defaultValue();
                XBridgeStringEnum xBridgeStringEnum = (XBridgeStringEnum) method.getAnnotation(XBridgeStringEnum.class);
                XBridgeIntEnum xBridgeIntEnum = (XBridgeIntEnum) method.getAnnotation(XBridgeIntEnum.class);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(xBridgeParamField.nestedClassType());
                String keyPath = xBridgeParamField.keyPath();
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(XBaseModel.Default.class)) && !models.containsKey(JvmClassMappingKt.getJavaClass(orCreateKotlinClass)) && !iDLAnnotationModel.getStringModel().containsKey(keyPath)) {
                    models.put(JvmClassMappingKt.getJavaClass(orCreateKotlinClass), INSTANCE.getIDLParamField(JvmClassMappingKt.getJavaClass(orCreateKotlinClass), models));
                }
                boolean required = xBridgeParamField.required();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(xBridgeParamField.primitiveClassType());
                boolean isEnum = xBridgeParamField.isEnum();
                boolean isGetter = xBridgeParamField.isGetter();
                IDLDefaultValue iDLDefaultValue = new IDLDefaultValue(defaultValue.type(), defaultValue.doubleValue(), defaultValue.stringValue(), defaultValue.intValue(), defaultValue.boolValue(), defaultValue.longValue());
                Class<?> returnType = method.getReturnType();
                Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
                if (xBridgeStringEnum == null || (option2 = xBridgeStringEnum.option()) == null || (emptyList = ArraysKt.toList(option2)) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                List list = emptyList;
                if (xBridgeIntEnum == null || (option = xBridgeIntEnum.option()) == null || (emptyList2 = ArraysKt.toList(option)) == null) {
                    emptyList2 = CollectionsKt.emptyList();
                }
                IDLParamField iDLParamField = new IDLParamField(required, keyPath, orCreateKotlinClass, orCreateKotlinClass2, isEnum, isGetter, iDLDefaultValue, returnType, list, emptyList2);
                HashMap<Method, IDLParamField> methodModel = iDLAnnotationModel.getMethodModel();
                Intrinsics.checkNotNullExpressionValue(method, "method");
                methodModel.put(method, iDLParamField);
                if (xBridgeParamField.isGetter()) {
                    iDLAnnotationModel.getStringModel().put(keyPath, iDLParamField);
                }
            }
        }
        return iDLAnnotationModel;
    }
}
