package com.bytedance.android.monitorV2.util;

import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.URIQueryParamKeys;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Extension.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a-\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a\u001f\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0011\"\u00020\u000b¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b\u001a\u0010\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u000bH\u0000\u001a%\u0010\u0018\u001a\u00020\u001a*\u00020\u000b2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b\u001dH\u0000\u001aE\u0010\u001e\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u001f\"\u0004\b\u0001\u0010 *\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H 0!2\u0006\u0010\"\u001a\u0002H\u001f2\u0006\u0010#\u001a\u0002H\u001f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010$\u001a-\u0010\u001e\u001a\u0004\u0018\u00010\u0004*\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010%\u001a\u0014\u0010&\u001a\u00020\u000b*\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u0001\u001a=\u0010'\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u001f\"\u0004\b\u0001\u0010 *\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H 0!2\u0006\u0010(\u001a\u0002H\u001f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010)\u001a \u0010'\u001a\u0004\u0018\u00010\u0006*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u001a \u0010+\u001a\u0004\u0018\u00010,*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010,\u001a \u0010-\u001a\u0004\u0018\u00010\u000b*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u000b\u001a\u0012\u0010.\u001a\u00020\u001a*\u00020\u000b2\u0006\u0010*\u001a\u00020\u0001\u001a\u001c\u0010/\u001a\u000200*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u000200\u001a\u001c\u00101\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0004\u001a'\u00102\u001a\u00020\u000b*\u00020\u000b2\u0016\u00103\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0011\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u00104\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u000b\u001a\u001c\u00105\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u0006\u001a+\u00107\u001a\u00020\u000b*\u00020\u000b2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010*\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010:\u001a\u001c\u0010;\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u0006\u001a\u001c\u0010<\u001a\u00020\u001a*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u0006\u001a+\u0010=\u001a\u00020\u001a*\u00020\u000b2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010*\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010>\u001a\u001c\u0010=\u001a\u00020\u001a*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u00010\u0006\u001a\u001c\u0010?\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010*\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0001¨\u0006@"}, d2 = {"camelToUnderline", "", "param", "diff", "", "x", "", "y", "fallback", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Long;)Ljava/lang/Long;", "jsonFlat", "Lorg/json/JSONObject;", "obj", "output", URIQueryParamKeys.KRY_PREFIX, "jsonMergeAll", "objArr", "", "([Lorg/json/JSONObject;)Lorg/json/JSONObject;", "jsonMergeInto", "from", "into", "jsonParse", "json", Api.KEY_ACCESS, "Lcom/bytedance/android/monitorV2/util/JsonAccessor;", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "duration", "K", "V", "", "keyX", "keyY", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Long;)Ljava/lang/Long;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "flat", "getAny", "k", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY, "getJArr", "Lorg/json/JSONArray;", "getJObj", "increment", "int", "", WsChannelMultiProcessSharedProvider.LONG_TYPE, "mergeFrom", "jsonObjects", "(Lorg/json/JSONObject;[Ljava/lang/Object;)Lorg/json/JSONObject;", "putAny", "value", "putAnyIf", "condition", "", "(Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;", "putAnyIfNotNull", "putIfNotBlank", "putIfNotNull", "(Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Object;)V", "str", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ExtensionKt {
    public static final JSONObject jsonMergeAll(JSONObject... jSONObjectArr) {
        Intrinsics.checkNotNullParameter(jSONObjectArr, "objArr");
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            jsonMergeInto(jSONObject2, jSONObject);
        }
        return jSONObject;
    }

    public static final JSONObject jsonMergeInto(JSONObject jSONObject, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "from");
        Intrinsics.checkNotNullParameter(jSONObject2, "into");
        try {
            Result.Companion companion = Result.Companion;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof JSONObject) {
                    Intrinsics.checkNotNullExpressionValue(next, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
                    putAny(jSONObject2, next, jsonMergeInto(obj$default(jSONObject, next, null, 2, null), obj(jSONObject2, next, new JSONObject())));
                } else {
                    if (opt instanceof Boolean) {
                        opt = opt.toString();
                    }
                    Intrinsics.checkNotNullExpressionValue(next, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
                    putAny(jSONObject2, next, opt);
                }
            }
            Result.constructor-impl(jSONObject2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return jSONObject2;
    }

    public static final JSONObject jsonParse(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.Companion;
            if (str != null && !TextUtils.isEmpty(str)) {
                new JSONObject(str);
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return jSONObject;
    }

    public static /* synthetic */ JSONObject jsonFlat$default(Object obj, JSONObject jSONObject, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            jSONObject = new JSONObject();
        }
        if ((i & 4) != 0) {
            str = "";
        }
        return jsonFlat(obj, jSONObject, str);
    }

    public static final JSONObject jsonFlat(Object obj, JSONObject jSONObject, String str) {
        Unit putAny;
        Intrinsics.checkNotNullParameter(jSONObject, "output");
        Intrinsics.checkNotNullParameter(str, URIQueryParamKeys.KRY_PREFIX);
        try {
            Result.Companion companion = Result.Companion;
            if (obj instanceof JSONObject) {
                Iterator<String> keys = ((JSONObject) obj).keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Intrinsics.checkNotNullExpressionValue(next, "k");
                    jsonFlat(getAny$default((JSONObject) obj, next, (Object) null, 2, (Object) null), jSONObject, (str.length() > 0 ? str + '_' : "") + camelToUnderline(next));
                }
                putAny = Unit.INSTANCE;
            } else if (obj instanceof JSONArray) {
                putAny = putAny(jSONObject, str, ((JSONArray) obj).join(","));
            } else {
                putAny = putAny(jSONObject, str, obj);
            }
            Result.constructor-impl(putAny);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return jSONObject;
    }

    public static /* synthetic */ Long diff$default(Object obj, Object obj2, Long l, int i, Object obj3) {
        if ((i & 4) != 0) {
            l = 0L;
        }
        return diff(obj, obj2, l);
    }

    public static final Long diff(Object obj, Object obj2, Long l) {
        return (obj == null || obj2 == null || !(obj instanceof Number) || !(obj2 instanceof Number)) ? l : Long.valueOf(((Number) obj).longValue() - ((Number) obj2).longValue());
    }

    public static final JSONObject mergeFrom(JSONObject jSONObject, Object... objArr) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "jsonObjects");
        for (Object obj : objArr) {
            if (obj != null && (obj instanceof JSONObject)) {
                jsonMergeInto((JSONObject) obj, jSONObject);
            }
        }
        return jSONObject;
    }

    public static /* synthetic */ JSONObject flat$default(JSONObject jSONObject, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return flat(jSONObject, str);
    }

    public static final JSONObject flat(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, URIQueryParamKeys.KRY_PREFIX);
        JSONObject jSONObject2 = new JSONObject();
        jsonFlat(jSONObject, jSONObject2, str);
        return jSONObject2;
    }

    public static final JSONObject putAny(JSONObject jSONObject, String str, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        try {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(jSONObject.put(str, obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return jSONObject;
    }

    public static final JSONObject putAnyIf(JSONObject jSONObject, Boolean bool, String str, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        if (bool != null && bool.booleanValue()) {
            putAny(jSONObject, str, obj);
        }
        return jSONObject;
    }

    public static final JSONObject putAnyIfNotNull(JSONObject jSONObject, String str, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        if (obj != null) {
            putAny(jSONObject, str, obj);
        }
        return jSONObject;
    }

    public static /* synthetic */ String str$default(JSONObject jSONObject, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return str(jSONObject, str, str2);
    }

    public static final String str(JSONObject jSONObject, String str, String str2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(str2, "fallback");
        String optString = jSONObject.optString(str, str2);
        Intrinsics.checkNotNullExpressionValue(optString, "optString(key, fallback)");
        return optString;
    }

    public static /* synthetic */ int int$default(JSONObject jSONObject, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m376int(jSONObject, str, i);
    }

    /* renamed from: int, reason: not valid java name */
    public static final int m376int(JSONObject jSONObject, String str, int i) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        return jSONObject.optInt(str, i);
    }

    public static /* synthetic */ long long$default(JSONObject jSONObject, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return m377long(jSONObject, str, j);
    }

    /* renamed from: long, reason: not valid java name */
    public static final long m377long(JSONObject jSONObject, String str, long j) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        return jSONObject.optLong(str, j);
    }

    public static /* synthetic */ Object getAny$default(Map map, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 2) != 0) {
            obj2 = 0;
        }
        return getAny((Map<Object, ? extends V>) map, obj, obj2);
    }

    public static final <K, V> Object getAny(Map<K, ? extends V> map, K k, Object obj) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        V v = map.get(k);
        return v == null ? obj : v;
    }

    public static /* synthetic */ Long duration$default(Map map, Object obj, Object obj2, Long l, int i, Object obj3) {
        if ((i & 4) != 0) {
            l = 0L;
        }
        return duration((Map<Object, ? extends V>) map, obj, obj2, l);
    }

    public static final <K, V> Long duration(Map<K, ? extends V> map, K k, K k2, Long l) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return diff(map.get(k), map.get(k2), l);
    }

    public static /* synthetic */ Long duration$default(JSONObject jSONObject, String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = 0L;
        }
        return duration(jSONObject, str, str2, l);
    }

    public static final Long duration(JSONObject jSONObject, String str, String str2, Long l) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "keyX");
        Intrinsics.checkNotNullParameter(str2, "keyY");
        return diff(getAny$default(jSONObject, str, (Object) null, 2, (Object) null), getAny$default(jSONObject, str2, (Object) null, 2, (Object) null), l);
    }

    public static /* synthetic */ JSONObject obj$default(JSONObject jSONObject, String str, JSONObject jSONObject2, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject2 = new JSONObject();
        }
        return obj(jSONObject, str, jSONObject2);
    }

    public static final JSONObject obj(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(jSONObject2, "fallback");
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        return optJSONObject == null ? jSONObject2 : optJSONObject;
    }

    public static final void access(JSONObject jSONObject, Function1<? super JsonAccessor, Unit> function1) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(new JsonAccessor(jSONObject));
    }

    public static final JsonAccessor access(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return new JsonAccessor(jSONObject);
    }

    public static /* synthetic */ Object getAny$default(JSONObject jSONObject, String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return getAny(jSONObject, str, obj);
    }

    public static final Object getAny(JSONObject jSONObject, String str, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        Object opt = jSONObject.opt(str);
        return opt == null ? obj : opt;
    }

    public static /* synthetic */ JSONObject getJObj$default(JSONObject jSONObject, String str, JSONObject jSONObject2, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject2 = null;
        }
        return getJObj(jSONObject, str, jSONObject2);
    }

    public static final JSONObject getJObj(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        Object opt = jSONObject.opt(str);
        return (opt == null || !(opt instanceof JSONObject)) ? jSONObject2 : (JSONObject) opt;
    }

    public static /* synthetic */ JSONArray getJArr$default(JSONObject jSONObject, String str, JSONArray jSONArray, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONArray = null;
        }
        return getJArr(jSONObject, str, jSONArray);
    }

    public static final JSONArray getJArr(JSONObject jSONObject, String str, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        Object opt = jSONObject.opt(str);
        return (opt == null || !(opt instanceof JSONArray)) ? jSONArray : (JSONArray) opt;
    }

    private static final String camelToUnderline(String str) {
        if (str.length() == 0) {
            return str;
        }
        int length = str.length();
        if (str != null) {
            char[] charArray = str.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                char c = charArray[i];
                if (Character.isUpperCase(c)) {
                    sb.append('_');
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final void increment(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        try {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(jSONObject.put(str, jSONObject.optLong(str, 0L) + 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final void putIfNotNull(JSONObject jSONObject, String str, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        if (obj == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Result.constructor-impl(jSONObject.put(str, obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final void putIfNotBlank(JSONObject jSONObject, String str, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        try {
            Result.Companion companion = Result.Companion;
            if (obj != null && !StringsKt.isBlank(String.valueOf(obj))) {
                Result.constructor-impl(jSONObject.put(str, obj));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final void putIfNotNull(JSONObject jSONObject, Boolean bool, String str, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY);
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        putIfNotNull(jSONObject, str, obj);
    }
}
