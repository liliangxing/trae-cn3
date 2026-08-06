package com.bytedance.android.anniex.solutions.card.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsonUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/util/JsonUtil;", "", "()V", "safeToMap", "", "", "jsonOb", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class JsonUtil {
    public static final JsonUtil INSTANCE = new JsonUtil();

    private JsonUtil() {
    }

    public final Map<String, Object> safeToMap(JSONObject jsonOb) {
        Intrinsics.checkNotNullParameter(jsonOb, "jsonOb");
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jsonOb.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object opt = jsonOb.opt(key);
                if (opt != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap.put(key, opt);
                }
            }
            return hashMap;
        } catch (Throwable unused) {
            return new HashMap();
        }
    }
}
