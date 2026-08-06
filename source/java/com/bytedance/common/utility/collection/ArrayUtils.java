package com.bytedance.common.utility.collection;

import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static long[] toLongArray(List<Long> list) {
        return com.bytedance.android.standard.tools.collection.ArrayUtils.toLongArray(list);
    }

    public static List<Long> toList(long[] jArr) {
        return com.bytedance.android.standard.tools.collection.ArrayUtils.toList(jArr);
    }

    public static <T> T[] combineArray(T[] tArr, T[] tArr2) {
        return (T[]) com.bytedance.android.standard.tools.collection.ArrayUtils.combineArray(tArr, tArr2);
    }

    public static <T> T[] insert(T[] tArr, int i, T t) {
        return (T[]) com.bytedance.android.standard.tools.collection.ArrayUtils.insert(tArr, i, t);
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        return (T[]) com.bytedance.android.standard.tools.collection.ArrayUtils.copyOfRange(tArr, i, i2);
    }
}
