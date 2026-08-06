package com.google.android.gms.common.data;

import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes6.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        JavaOnlyArray javaOnlyArray = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            javaOnlyArray.add(arrayList.get(i).freeze());
        }
        return javaOnlyArray;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        JavaOnlyArray javaOnlyArray = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            javaOnlyArray.add(it.next().freeze());
        }
        return javaOnlyArray;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        JavaOnlyArray javaOnlyArray = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            javaOnlyArray.add(e.freeze());
        }
        return javaOnlyArray;
    }
}
