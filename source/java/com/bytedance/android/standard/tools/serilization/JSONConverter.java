package com.bytedance.android.standard.tools.serilization;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson;
import java.lang.reflect.Type;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class JSONConverter {
    private static final Gson GSON = new Gson();

    public static <T> T fromJson(String str, Class<T> cls) {
        return (T) GSON.fromJson(str, cls);
    }

    public static <T> T fromJson(String str, Type type) {
        return (T) GSON.fromJson(str, type);
    }

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> String toJson(Object obj, Type type) {
        return GSON.toJson(obj, type);
    }

    public static Type canonicalize(Type type) {
        return $Gson.Types.canonicalize(type);
    }

    public static <T> T fromJsonSafely(String str, Class<T> cls) {
        try {
            return (T) GSON.fromJson(str, cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T fromJsonSafely(String str, Type type) {
        try {
            return (T) GSON.fromJson(str, type);
        } catch (Exception unused) {
            return null;
        }
    }
}
