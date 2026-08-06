package com.bytedance.reparo.core.common.utils;

/* loaded from: classes4.dex */
public class StringUtils {
    public static String notNull(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
