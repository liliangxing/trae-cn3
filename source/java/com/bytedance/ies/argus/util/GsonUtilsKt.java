package com.bytedance.ies.argus.util;

import com.bytedance.applog.server.Api;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GsonUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\"\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0000¨\u0006\u000b"}, d2 = {"safeToJSONObject", "Lorg/json/JSONObject;", "Lcom/google/gson/Gson;", "src", "", "safeToString", "", "safelyGetString", "Lcom/google/gson/JsonObject;", Api.KEY_ENCRYPT_RESP_KEY, "defaultValue", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GsonUtilsKt {
    public static final JSONObject safeToJSONObject(Gson gson, Object obj) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(gson, "<this>");
        try {
            if (obj == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(gson.toJson(obj));
            }
            return jSONObject;
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public static final String safeToString(Gson gson, Object obj) {
        String json;
        Intrinsics.checkNotNullParameter(gson, "<this>");
        try {
            if (obj instanceof String) {
                json = (String) obj;
            } else {
                json = gson.toJson(obj);
            }
            Intrinsics.checkNotNullExpressionValue(json, "{\n        if (src is Str…Json(src)\n        }\n    }");
            return json;
        } catch (Exception unused) {
            return "";
        }
    }

    public static /* synthetic */ String safelyGetString$default(JsonObject jsonObject, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return safelyGetString(jsonObject, str, str2);
    }

    public static final String safelyGetString(JsonObject jsonObject, String str, String str2) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(str, Api.KEY_ENCRYPT_RESP_KEY);
        if (jsonObject.has(str)) {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                return jsonElement.getAsString();
            }
        }
        return str2;
    }
}
