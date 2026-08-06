package com.bytedance.ies.argus.util;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JSONUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\u001a*\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¨\u0006\u000b"}, d2 = {"mergeJSONObject", "Lorg/json/JSONObject;", "merge", "mergeStrValueJSONObject", "safelyPut", "key", "", "value", "", "defaultValue", "safelyPutWithDefault", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class JSONUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final JSONObject safelyPut(JSONObject jSONObject, String key, Object obj) {
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.INSTANCE;
            jSONObject2 = Result.m10253constructorimpl(obj != null ? jSONObject.put(key, obj) : jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            jSONObject2 = Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10256exceptionOrNullimpl(jSONObject2) == null) {
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public static /* synthetic */ JSONObject safelyPut$default(JSONObject jSONObject, String str, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = null;
        }
        return safelyPut(jSONObject, str, obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final JSONObject safelyPut(JSONObject jSONObject, String key, Object obj, Object obj2) {
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (obj == null) {
                obj = obj2;
            }
            jSONObject2 = Result.m10253constructorimpl(jSONObject.put(key, obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            jSONObject2 = Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10256exceptionOrNullimpl(jSONObject2) == null) {
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final JSONObject safelyPutWithDefault(JSONObject jSONObject, String key, Object obj) {
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (obj == null) {
                obj = "null";
            }
            jSONObject2 = Result.m10253constructorimpl(jSONObject.put(key, obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            jSONObject2 = Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10256exceptionOrNullimpl(jSONObject2) == null) {
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final JSONObject mergeJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Iterator<String> keys = jSONObject2.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "merge.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                safelyPut(jSONObject, next, jSONObject2.get(next));
            }
            jSONObject3 = Result.m10253constructorimpl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            jSONObject3 = Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10256exceptionOrNullimpl(jSONObject3) == null) {
            jSONObject = jSONObject3;
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final JSONObject mergeStrValueJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Iterator<String> keys = jSONObject2.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "merge.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                String str = obj instanceof String ? (String) obj : null;
                if (str == null) {
                    str = obj.toString();
                }
                safelyPut(jSONObject, next, str);
            }
            jSONObject3 = Result.m10253constructorimpl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            jSONObject3 = Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10256exceptionOrNullimpl(jSONObject3) == null) {
            jSONObject = jSONObject3;
        }
        return jSONObject;
    }
}
