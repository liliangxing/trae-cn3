package com.bytedance.android.monitorV2.dataprocessor;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Extension.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a \u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u001a \u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001\u001a'\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0001\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\r¨\u0006\u0012"}, d2 = {"jsonMergeInto", "Lorg/json/JSONObject;", "from", "into", "getJArr", "Lorg/json/JSONArray;", "key", "", "fallback", "getJObj", "mergeFrom", "jsonObjects", "", "", "(Lorg/json/JSONObject;[Ljava/lang/Object;)Lorg/json/JSONObject;", "obj", "putAny", "value", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ExtensionKt {
    public static final JSONObject mergeFrom(JSONObject jSONObject, Object... jsonObjects) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jsonObjects, "jsonObjects");
        for (Object obj : jsonObjects) {
            if (obj != null && (obj instanceof JSONObject)) {
                jsonMergeInto((JSONObject) obj, jSONObject);
            }
        }
        return jSONObject;
    }

    public static final JSONObject jsonMergeInto(JSONObject from, JSONObject into) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(into, "into");
        try {
            Result.Companion companion = Result.INSTANCE;
            Iterator<String> keys = from.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object opt = from.opt(key);
                if (opt instanceof JSONObject) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    putAny(into, key, jsonMergeInto(obj$default(from, key, null, 2, null), obj(into, key, new JSONObject())));
                } else {
                    if (opt instanceof Boolean) {
                        opt = opt.toString();
                    }
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    putAny(into, key, opt);
                }
            }
            Result.m10253constructorimpl(into);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        return into;
    }

    public static final JSONObject putAny(JSONObject jSONObject, String key, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.m10253constructorimpl(jSONObject.put(key, obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        return jSONObject;
    }

    public static /* synthetic */ JSONObject obj$default(JSONObject jSONObject, String str, JSONObject jSONObject2, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject2 = new JSONObject();
        }
        return obj(jSONObject, str, jSONObject2);
    }

    public static final JSONObject obj(JSONObject jSONObject, String key, JSONObject fallback) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        JSONObject optJSONObject = jSONObject.optJSONObject(key);
        return optJSONObject == null ? fallback : optJSONObject;
    }

    public static /* synthetic */ JSONArray getJArr$default(JSONObject jSONObject, String str, JSONArray jSONArray, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONArray = null;
        }
        return getJArr(jSONObject, str, jSONArray);
    }

    public static final JSONArray getJArr(JSONObject jSONObject, String key, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object opt = jSONObject.opt(key);
        return (opt == null || !(opt instanceof JSONArray)) ? jSONArray : (JSONArray) opt;
    }

    public static /* synthetic */ JSONObject getJObj$default(JSONObject jSONObject, String str, JSONObject jSONObject2, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject2 = null;
        }
        return getJObj(jSONObject, str, jSONObject2);
    }

    public static final JSONObject getJObj(JSONObject jSONObject, String key, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object opt = jSONObject.opt(key);
        return (opt == null || !(opt instanceof JSONObject)) ? jSONObject2 : (JSONObject) opt;
    }
}
