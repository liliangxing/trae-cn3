package com.bytedance.security.android.aopcheck.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GsonUtil {
    private static Gson GSON = new GsonBuilder().create();

    private GsonUtil() {
    }

    public static String toJsonStr(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return GSON.toJson(obj);
        } catch (Exception e) {
            LogPrint.m178e("object to json exception:" + e);
            return "";
        }
    }

    public static <T> T parse(String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            return (T) GSON.fromJson(str, cls);
        } catch (Exception e) {
            LogPrint.m178e("json to object exception：" + e);
            return null;
        }
    }

    public static <T> T pare(String str, Type type) {
        if (str == null) {
            return null;
        }
        try {
            return (T) GSON.fromJson(str, type);
        } catch (Exception e) {
            LogPrint.m178e("json to object exception：" + e);
            return null;
        }
    }

    public static <T> List<T> parseList(String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            return (List) GSON.fromJson(str, new TypeToken<List<T>>() { // from class: com.bytedance.security.android.aopcheck.utils.GsonUtil.1
            }.getType());
        } catch (Exception e) {
            LogPrint.m178e("json to array exception:" + e);
            return null;
        }
    }
}
