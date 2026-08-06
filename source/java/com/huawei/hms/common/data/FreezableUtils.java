package com.huawei.hms.common.data;

import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        JavaOnlyArray javaOnlyArray = (ArrayList<T>) new ArrayList();
        if (iterable == null) {
            return javaOnlyArray;
        }
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            javaOnlyArray.add(it.next().freeze());
        }
        return javaOnlyArray;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(Arrays.asList(eArr));
    }
}
