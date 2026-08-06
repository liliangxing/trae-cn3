package com.bytedance.monitor.util;

/* loaded from: classes4.dex */
class InnerUtils {
    static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    InnerUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasSameLength(Object[] objArr, Object[] objArr2) {
        if (objArr == null && objArr2 != null && objArr2.length > 0) {
            return false;
        }
        if (objArr2 != null || objArr == null || objArr.length <= 0) {
            return objArr == null || objArr2 == null || objArr.length == objArr2.length;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] nullToEmpty(Object[] objArr) {
        return (objArr == null || objArr.length <= 0) ? EMPTY_OBJECT_ARRAY : objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?>[] toClass(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? null : obj.getClass();
        }
        return clsArr;
    }
}
