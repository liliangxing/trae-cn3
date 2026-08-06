package com.bytedance.android.monitorV2.util;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: Extension.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0007J!\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/monitorV2/util/JsonAccessor;", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "cache", "", "", "duration", "", "pathX", "pathY", "fallback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "get", "path", "getInt", "", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "getLong", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getStr", "jsonObj", "originJson", "valueIs", "", "expect", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class JsonAccessor {
    private final Map<String, Object> cache;
    private final JSONObject data;

    public JsonAccessor(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "data");
        this.data = jSONObject;
        this.cache = new HashMap();
    }

    /* renamed from: originJson, reason: from getter */
    public final JSONObject getData() {
        return this.data;
    }

    public final boolean valueIs(String path, Object expect) {
        Intrinsics.checkNotNullParameter(path, "path");
        return Intrinsics.areEqual(get(path), expect);
    }

    public static /* synthetic */ Long duration$default(JsonAccessor jsonAccessor, String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = 0L;
        }
        return jsonAccessor.duration(str, str2, l);
    }

    public final Long duration(String pathX, String pathY, Long fallback) {
        Intrinsics.checkNotNullParameter(pathX, "pathX");
        Intrinsics.checkNotNullParameter(pathY, "pathY");
        return ExtensionKt.diff(get(pathX), get(pathY), fallback);
    }

    public static /* synthetic */ Integer getInt$default(JsonAccessor jsonAccessor, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = 0;
        }
        return jsonAccessor.getInt(str, num);
    }

    public final Integer getInt(String path, Integer fallback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Object obj = get(path);
        return (obj != null && (obj instanceof Number)) ? Integer.valueOf(((Number) obj).intValue()) : fallback;
    }

    public static /* synthetic */ String getStr$default(JsonAccessor jsonAccessor, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return jsonAccessor.getStr(str, str2);
    }

    public final String getStr(String path, String fallback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Object obj = get(path);
        return (obj != null && (obj instanceof String)) ? (String) obj : fallback;
    }

    public static /* synthetic */ JSONObject jsonObj$default(JsonAccessor jsonAccessor, String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = new JSONObject();
        }
        return jsonAccessor.jsonObj(str, jSONObject);
    }

    public final JSONObject jsonObj(String path, JSONObject fallback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Object obj = get(path);
        return (obj != null && (obj instanceof JSONObject)) ? (JSONObject) obj : fallback;
    }

    public static /* synthetic */ Long getLong$default(JsonAccessor jsonAccessor, String str, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = 0L;
        }
        return jsonAccessor.getLong(str, l);
    }

    public final Long getLong(String path, Long fallback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Object obj = get(path);
        return (obj != null && (obj instanceof Number)) ? Long.valueOf(((Number) obj).longValue()) : fallback;
    }

    public final Object get(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String str = path;
        if (str.length() == 0) {
            return null;
        }
        if (this.cache.containsKey(path)) {
            return this.cache.get(path);
        }
        if (this.data.has(path)) {
            Object opt = this.data.opt(path);
            if (!this.cache.containsKey(path)) {
                Map<String, Object> map = this.cache;
                Intrinsics.checkNotNullExpressionValue(opt, "o");
                map.put(path, opt);
            }
            return opt;
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default(str, ".", 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            return null;
        }
        String substring = path.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Object obj = get(substring);
        if (obj == null || !(obj instanceof JSONObject)) {
            return null;
        }
        String substring2 = path.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
        Object opt2 = ((JSONObject) obj).opt(substring2);
        if (opt2 != null && !this.cache.containsKey(path)) {
            this.cache.put(path, opt2);
        }
        return opt2;
    }
}
