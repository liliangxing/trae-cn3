package com.ss.alive.monitor.reflect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes7.dex */
class Utils {
    private static Object[] OBJECT_ARRAY_EMPTY = new Object[0];
    static Class<?>[] CLASS_ARRAY_EMPTY = new Class[0];

    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        return (objArr != null || objArr2 == null || objArr2.length <= 0) && (objArr2 != null || objArr == null || objArr.length <= 0) && (objArr == null || objArr2 == null || objArr.length == objArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?>[] objectsToClassArray(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return CLASS_ARRAY_EMPTY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? null : obj.getClass();
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?>[] ensureClassArrayNotNull(Class<?>[] clsArr) {
        return (clsArr == null || clsArr.length == 0) ? CLASS_ARRAY_EMPTY : clsArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] ensureObjectArrayNoNull(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? OBJECT_ARRAY_EMPTY : objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Class<?>> getInterfacesOfClass(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void getInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }
}
