package com.bytedance.sdk.xbridge.cn.runtime.utils;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/utils/JsonUtils;", "", "()V", "GSON", "Lcom/google/gson/Gson;", "getGSON", "()Lcom/google/gson/Gson;", "fromJson", "T", "json", "", "typeClass", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJson", "obj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class JsonUtils {
    public static final JsonUtils INSTANCE = new JsonUtils();
    private static final Gson GSON = new Gson();

    private JsonUtils() {
    }

    public final Gson getGSON() {
        return GSON;
    }

    public final String toJson(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String json = GSON.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "GSON.toJson(obj)");
        return json;
    }

    public final <T> T fromJson(String json, Class<T> typeClass) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(typeClass, "typeClass");
        return (T) GSON.fromJson(json, typeClass);
    }
}
