package com.bytedance.push.utils;

import com.google.gson.Gson;

/* loaded from: classes4.dex */
public class GsonUtils {
    private static final Gson gson = new Gson();

    public static <T> T from(String str, Class<T> cls) {
        try {
            return (T) gson.fromJson(str, (Class) cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String toJson(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Throwable unused) {
            return null;
        }
    }
}
