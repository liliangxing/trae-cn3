package com.ss.alive.monitor.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
class MemberUtils {
    private static int ACCESS_LEVEL = 7;
    private static Class<?>[] TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
    private static Map<Class<?>, Class<?>> boxingToPrimitiveMap = new HashMap();
    private static Map<Class<?>, Class<?>> primitiveToBoxingMap;

    MemberUtils() {
    }

    static {
        HashMap hashMap = new HashMap();
        primitiveToBoxingMap = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        primitiveToBoxingMap.put(Byte.TYPE, Byte.class);
        primitiveToBoxingMap.put(Character.TYPE, Character.class);
        primitiveToBoxingMap.put(Short.TYPE, Short.class);
        primitiveToBoxingMap.put(Integer.TYPE, Integer.class);
        primitiveToBoxingMap.put(Long.TYPE, Long.class);
        primitiveToBoxingMap.put(Double.TYPE, Double.class);
        primitiveToBoxingMap.put(Float.TYPE, Float.class);
        primitiveToBoxingMap.put(Void.TYPE, Void.TYPE);
        for (Class<?> cls : primitiveToBoxingMap.keySet()) {
            Class<?> cls2 = primitiveToBoxingMap.get(cls);
            if (cls2 != null && !cls.equals(cls2)) {
                boxingToPrimitiveMap.put(cls2, cls);
            }
        }
    }

    private static boolean isPackageAccessible(int i) {
        return (i & ACCESS_LEVEL) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isMemberAccessible(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean setMemberAccessible(AccessibleObject accessibleObject) {
        if (accessibleObject != 0 && !accessibleObject.isAccessible() && (accessibleObject instanceof Member)) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccessible(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAssignableWithAutoBoxing(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (!Utils.isSameLength(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = Utils.CLASS_ARRAY_EMPTY;
        }
        if (clsArr2 == null) {
            clsArr2 = Utils.CLASS_ARRAY_EMPTY;
        }
        int length = clsArr.length;
        for (int i = 0; i < length; i++) {
            if (!isAssignableWithAutoBoxing(clsArr[i], clsArr2[i])) {
                return false;
            }
        }
        return true;
    }

    static boolean isAssignableWithAutoBoxing(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToBoxing(cls)) == null) {
            return false;
        }
        if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = boxingToPrimitive(cls)) == null) {
            return false;
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (cls.isPrimitive()) {
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
            if (Character.TYPE.equals(cls)) {
                return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Short.TYPE.equals(cls)) {
                return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Byte.TYPE.equals(cls)) {
                return Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            return false;
        }
        return cls2.isAssignableFrom(cls);
    }

    static Class<?> primitiveToBoxing(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : primitiveToBoxingMap.get(cls);
    }

    static Class<?> boxingToPrimitive(Class<?> cls) {
        return boxingToPrimitiveMap.get(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int compareCost(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        return Float.compare(getTransformCost(clsArr3, clsArr), getTransformCost(clsArr3, clsArr2));
    }

    private static float getTransformCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        int length = clsArr.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += getTransformCost(clsArr[i], clsArr2[i]);
        }
        return f;
    }

    private static float getTransformCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitiveCost(cls, cls2);
        }
        float f = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && isAssignableWithAutoBoxing(cls, cls2)) {
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

    private static float getPrimitiveCost(Class<?> cls, Class<?> cls2) {
        float f;
        if (cls.isPrimitive()) {
            f = 0.0f;
        } else {
            cls = boxingToPrimitive(cls);
            f = 0.1f;
        }
        int i = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = TYPES;
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
}
