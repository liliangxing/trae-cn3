package com.bytedance.ies.argus.util;

import com.bytedance.ies.argus.base.ArgusLog;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GsonUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0086\b¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u0011J\u0017\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u0014J+\u0010\u0015\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0018¢\u0006\u0002\u0010\u0019J6\u0010\u001a\u001a\u0004\u0018\u0001H\u000b\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0018H\u0086\b¢\u0006\u0002\u0010\u001dR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/argus/util/ArgusGsonUtils;", "", "()V", "gsonObjExcludeProperty", "Lcom/google/gson/Gson;", "getGsonObjExcludeProperty", "()Lcom/google/gson/Gson;", "gsonObjExcludeProperty$delegate", "Lkotlin/Lazy;", "initGsonExcludeProperty", "safeLyDeepCopyObj", "T", "obj", "(Ljava/lang/Object;)Ljava/lang/Object;", "safeToJSONObject", "Lorg/json/JSONObject;", "src", "safeToJSONObject$anniex_release", "safeToString", "", "safeToString$anniex_release", "safelyFromJSONObjectToClass", "jsonObj", "clazz", "Ljava/lang/Class;", "(Lorg/json/JSONObject;Ljava/lang/Class;)Ljava/lang/Object;", "safelyFromMapToClass", "data", "", "(Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;", "ArgusExclusionStrategy", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusGsonUtils {
    public static final ArgusGsonUtils INSTANCE = new ArgusGsonUtils();

    /* renamed from: gsonObjExcludeProperty$delegate, reason: from kotlin metadata */
    private static final Lazy gsonObjExcludeProperty = LazyKt.lazy(new Function0<Gson>() { // from class: com.bytedance.ies.argus.util.ArgusGsonUtils$gsonObjExcludeProperty$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Gson m629invoke() {
            Gson initGsonExcludeProperty;
            initGsonExcludeProperty = ArgusGsonUtils.INSTANCE.initGsonExcludeProperty();
            return initGsonExcludeProperty;
        }
    });

    private ArgusGsonUtils() {
    }

    public final Gson getGsonObjExcludeProperty() {
        return (Gson) gsonObjExcludeProperty.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Gson initGsonExcludeProperty() {
        Gson create = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy[]{new ArgusExclusionStrategy()}).create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder()\n          …())\n            .create()");
        return create;
    }

    public final JSONObject safeToJSONObject$anniex_release(Object src) {
        return GsonUtilsKt.safeToJSONObject(getGsonObjExcludeProperty(), src);
    }

    public final String safeToString$anniex_release(Object src) {
        return GsonUtilsKt.safeToString(getGsonObjExcludeProperty(), src);
    }

    public final /* synthetic */ <T> T safelyFromMapToClass(Map<?, ?> data, Class<T> clazz) {
        T t;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            Result.Companion companion = Result.Companion;
            ArgusGsonUtils argusGsonUtils = INSTANCE;
            t = (T) Result.constructor-impl(argusGsonUtils.getGsonObjExcludeProperty().fromJson(argusGsonUtils.getGsonObjExcludeProperty().toJson(data), clazz));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = (T) Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(t)) {
            return null;
        }
        return t;
    }

    public final <T> T safelyFromJSONObjectToClass(JSONObject jsonObj, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (jsonObj == null) {
            return null;
        }
        try {
            return (T) INSTANCE.getGsonObjExcludeProperty().fromJson(jsonObj.toString(), clazz);
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, "GsonUtils", "safelyFromMapToClass error " + e + ": " + jsonObj, null, null, 12, null);
            return null;
        }
    }

    public final /* synthetic */ <T> T safeLyDeepCopyObj(T obj) {
        try {
            Result.Companion companion = Result.Companion;
            ArgusGsonUtils argusGsonUtils = INSTANCE;
            String json = argusGsonUtils.getGsonObjExcludeProperty().toJson(obj);
            Gson gsonObjExcludeProperty2 = argusGsonUtils.getGsonObjExcludeProperty();
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) gsonObjExcludeProperty2.fromJson(json, Object.class);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            T t = (T) Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(t)) {
                return null;
            }
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GsonUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/util/ArgusGsonUtils$ArgusExclusionStrategy;", "Lcom/google/gson/ExclusionStrategy;", "()V", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "fieldAttributes", "Lcom/google/gson/FieldAttributes;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class ArgusExclusionStrategy implements ExclusionStrategy {
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            Intrinsics.checkNotNullParameter(fieldAttributes, "fieldAttributes");
            return fieldAttributes.getAnnotation(SerializedName.class) == null;
        }
    }
}
