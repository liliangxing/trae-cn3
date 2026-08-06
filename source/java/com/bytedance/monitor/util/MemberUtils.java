package com.bytedance.monitor.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
    private static final Map<Class<?>, Class<?>> originalWrapperMap;
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;

    private static boolean isPackageAccess(int i) {
        return (i & 7) == 0;
    }

    MemberUtils() {
    }

    static {
        HashMap hashMap = new HashMap();
        originalWrapperMap = hashMap;
        wrapperPrimitiveMap = new HashMap();
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Void.TYPE, Void.TYPE);
        for (Class<?> cls : hashMap.keySet()) {
            Class<?> cls2 = originalWrapperMap.get(cls);
            if (!cls.equals(cls2)) {
                wrapperPrimitiveMap.put(cls2, cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAccessible(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean setAccessible(AccessibleObject accessibleObject) {
        if (accessibleObject != 0 && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        return isAssignable(cls, cls2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!InnerUtils.hasSameLength(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = InnerUtils.EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = InnerUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!isAssignable(clsArr[i], clsArr2[i], z)) {
                return false;
            }
        }
        return true;
    }

    static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (cls.isPrimitive()) {
            return isAssignableFrom(cls, cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    private static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (Integer.TYPE.equals(cls)) {
            return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        }
        if (Long.TYPE.equals(cls)) {
            return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        }
        if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
            return false;
        }
        if (Float.TYPE.equals(cls)) {
            return Double.TYPE.equals(cls2);
        }
        boolean z = Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        if (Character.TYPE.equals(cls) || Short.TYPE.equals(cls)) {
            return z;
        }
        if (Byte.TYPE.equals(cls)) {
            return Short.TYPE.equals(cls2) || z;
        }
        return false;
    }

    static Class<?> primitiveToWrapper(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : originalWrapperMap.get(cls);
    }

    private static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        float f;
        if (cls.isPrimitive()) {
            f = 0.0f;
        } else {
            cls = wrapperToPrimitive(cls);
            f = 0.1f;
        }
        int i = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
            if (i >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i]) {
                f += 0.1f;
                if (i < clsArr.length - 1) {
                    cls = clsArr[i + 1];
                }
            }
            i++;
        }
        return f;
    }

    static Class<?> wrapperToPrimitive(Class<?> cls) {
        return wrapperPrimitiveMap.get(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int compareParameterTypes(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float totalTransformationCost = getTotalTransformationCost(clsArr3, clsArr);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr3, clsArr2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        return totalTransformationCost2 < totalTransformationCost ? 1 : 0;
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && isAssignable(cls, cls2)) {
                    f += 0.25f;
                    break;
                }
                f += 1.0f;
                cls = cls.getSuperclass();
            } else {
                break;
            }
        }
        return cls == null ? f + 1.5f : f;
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            f += getObjectTransformationCost(clsArr[i], clsArr2[i]);
        }
        return f;
    }
}
