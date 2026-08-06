package com.bytedance.apm.util;

/* loaded from: classes3.dex */
public class ArrayUtils {
    public static int indexOfFirst(Object[] objArr, Class<?> cls) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj != null && obj.getClass().equals(cls)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
