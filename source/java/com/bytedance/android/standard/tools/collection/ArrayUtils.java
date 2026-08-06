package com.bytedance.android.standard.tools.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class ArrayUtils {
    private static final int CACHE_SIZE = 73;
    private static final Object[] EMPTY = new Object[0];
    private static Object[] sCache = new Object[73];

    public static int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    private ArrayUtils() {
    }

    public static long[] toLongArray(List<Long> list) {
        if (list == null) {
            return null;
        }
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }

    public static List<Long> toList(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static <T> T[] combineArray(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) copyOfRange(tArr, 0, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static <T> T[] insert(T[] tArr, int i, T t) {
        T t2;
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + 1));
        int i2 = 0;
        while (i2 < tArr2.length) {
            if (i2 < i) {
                t2 = tArr[i2];
            } else {
                t2 = i2 == i ? t : tArr[i2 - 1];
            }
            tArr2[i2] = t2;
            i2++;
        }
        return tArr2;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
        System.arraycopy(tArr, i, tArr2, 0, min);
        return tArr2;
    }

    public static int idealBooleanArraySize(int i) {
        return idealByteArraySize(i);
    }

    public static int idealShortArraySize(int i) {
        return idealByteArraySize(i * 2) / 2;
    }

    public static int idealCharArraySize(int i) {
        return idealByteArraySize(i * 2) / 2;
    }

    public static int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static int idealFloatArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static int idealObjectArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }

    public static boolean equals(byte[] bArr, byte[] bArr2, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static <T> T[] emptyArray(Class<T> cls) {
        if (cls == Object.class) {
            return (T[]) EMPTY;
        }
        int identityHashCode = ((System.identityHashCode(cls) / 8) & Integer.MAX_VALUE) % 73;
        Object obj = sCache[identityHashCode];
        if (obj == null || obj.getClass().getComponentType() != cls) {
            obj = Array.newInstance((Class<?>) cls, 0);
            sCache[identityHashCode] = obj;
        }
        return (T[]) ((Object[]) obj);
    }

    public static <T> boolean contains(T[] tArr, T t) {
        return indexOf(tArr, t) != -1;
    }

    public static <T> int indexOf(T[] tArr, T t) {
        for (int i = 0; i < tArr.length; i++) {
            T t2 = tArr[i];
            if (t2 == null) {
                if (t == null) {
                    return i;
                }
                if (t != null && t2.equals(t)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static <T> boolean containsAll(T[] tArr, T[] tArr2) {
        for (T t : tArr2) {
            if (!contains(tArr, t)) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static long total(long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    public static <T> T[] appendElement(Class<T> cls, T[] tArr, T t) {
        T[] tArr2;
        int i = 0;
        if (tArr != null) {
            int length = tArr.length;
            tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length + 1));
            System.arraycopy(tArr, 0, tArr2, 0, length);
            i = length;
        } else {
            tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 1));
        }
        tArr2[i] = t;
        return tArr2;
    }

    public static <T> T[] removeElement(Class<T> cls, T[] tArr, T t) {
        if (tArr != null) {
            int length = tArr.length;
            for (int i = 0; i < length; i++) {
                if (tArr[i] == t) {
                    if (length == 1) {
                        return null;
                    }
                    T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length - 1));
                    System.arraycopy(tArr, 0, tArr2, 0, i);
                    System.arraycopy(tArr, i + 1, tArr2, i, (length - i) - 1);
                    return tArr2;
                }
            }
        }
        return tArr;
    }

    public static int[] appendInt(int[] iArr, int i) {
        if (iArr == null) {
            return new int[]{i};
        }
        int length = iArr.length;
        for (int i2 : iArr) {
            if (i2 == i) {
                return iArr;
            }
        }
        int[] iArr2 = new int[length + 1];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        iArr2[length] = i;
        return iArr2;
    }

    public static int[] removeInt(int[] iArr, int i) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (iArr[i2] == i) {
                int i3 = length - 1;
                int[] iArr2 = new int[i3];
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                }
                if (i2 < i3) {
                    System.arraycopy(iArr, i2 + 1, iArr2, i2, (length - i2) - 1);
                }
                return iArr2;
            }
        }
        return iArr;
    }
}
