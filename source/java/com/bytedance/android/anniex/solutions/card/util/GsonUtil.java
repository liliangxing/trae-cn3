package com.bytedance.android.anniex.solutions.card.util;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GsonUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u000e\u001a\u0002H\u0006¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/util/GsonUtil;", "", "()V", "gson", "Lcom/google/gson/Gson;", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "jsonStr", "", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJsonTree", "Lcom/google/gson/JsonElement;", "t", "(Ljava/lang/Object;)Lcom/google/gson/JsonElement;", "toString", "any", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class GsonUtil {
    public static final GsonUtil INSTANCE = new GsonUtil();
    private static final Gson gson = new Gson();

    private GsonUtil() {
    }

    public final <T> JsonElement toJsonTree(T t) {
        JsonElement jsonTree = gson.toJsonTree(t);
        Intrinsics.checkNotNullExpressionValue(jsonTree, "gson.toJsonTree(t)");
        return jsonTree;
    }

    public final String toString(Object any) {
        Intrinsics.checkNotNullParameter(any, "any");
        String json = gson.toJson(any);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(any)");
        return json;
    }

    public final <T> T fromJson(String jsonStr, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) gson.fromJson(jsonStr, clazz);
    }
}
