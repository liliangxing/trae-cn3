package com.bytedance.ies.bullet.prefetchv2;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u0004\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0004\u001a\u0018\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b*\u0004\u0018\u00010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"DEFAULT_EXPIRE_MS", "", "isRequestMethodSupported", "", "", "toConfig", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "toStringMap", "", "Lorg/json/JSONObject;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchConfigKt {
    public static final long DEFAULT_EXPIRE_MS = 30000;

    public static final boolean isRequestMethodSupported(String str) {
        String str2;
        if (str != null) {
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            str2 = str.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).toLowerCase(locale)");
        } else {
            str2 = null;
        }
        return Intrinsics.areEqual(str2, "get") || Intrinsics.areEqual(str2, "post");
    }

    public static final PrefetchConfig toConfig(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return new PrefetchConfig(new JSONObject(str));
        } catch (Exception e) {
            PrefetchLogger.INSTANCE.e("Prefetch配置解析失败: " + e.getMessage() + "，json: " + str);
            return null;
        }
    }

    public static final Map<String, String> toStringMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new LinkedHashMap();
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String key = keys.next();
            if (jSONObject.optJSONObject(key) != null) {
                try {
                    Map<String, String> stringMap = toStringMap(jSONObject.optJSONObject(key));
                    Intrinsics.checkNotNull(stringMap);
                    hashMap.putAll(stringMap);
                } catch (NullPointerException e) {
                    Log.e("JsonExt", "handle " + key + " error: " + e.getMessage());
                }
            } else {
                String value = jSONObject.optString(key);
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }
}
