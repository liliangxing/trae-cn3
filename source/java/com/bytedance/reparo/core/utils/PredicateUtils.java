package com.bytedance.reparo.core.utils;

import java.util.List;

/* loaded from: classes4.dex */
public class PredicateUtils {
    public static <T> T findFirst(T[] tArr, Predicate<T> predicate) {
        for (T t : tArr) {
            if (predicate.apply(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T findFirst(List<T> list, Predicate<T> predicate) {
        for (T t : list) {
            if (predicate.apply(t)) {
                return t;
            }
        }
        return null;
    }
}
