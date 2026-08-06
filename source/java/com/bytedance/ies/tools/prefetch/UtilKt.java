package com.bytedance.ies.tools.prefetch;

import android.net.Uri;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Util.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\nH\u0000\u001a\u0018\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\f*\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u000fH\u0000\u001a\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\f*\u0004\u0018\u00010\u0007H\u0000\u001a\f\u0010\u0011\u001a\u00020\r*\u00020\rH\u0000\u001a\u001a\u0010\u0012\u001a\u00020\u0007*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0000\u001a\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004*\u0004\u0018\u00010\u0014H\u0000\u001a \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00160\u0004*\u0004\u0018\u00010\u0007H\u0000\u001a\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016*\u0004\u0018\u00010\u0014H\u0000\u001a\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\f*\u0004\u0018\u00010\u0007H\u0000\u001a\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\f*\u0004\u0018\u00010\u0007H\u0000¨\u0006\u001b"}, d2 = {"createApiUrl", "", "baseUrl", "params", "", "", "createSortedJSONObject", "Lorg/json/JSONObject;", "originalObject", "emptyStringTreeMap", "Ljava/util/TreeMap;", "getQueryMap", "Ljava/util/SortedMap;", "Landroid/net/Uri;", "stacktraceString", "", "toAnyMap", "toBasicUri", "toJSONObject", "toKeyValueMap", "Lorg/json/JSONArray;", "toListMap", "", "toStringList", "toStringMap", "toTypedMap", "Lcom/bytedance/ies/tools/prefetch/TypedParam;", "prefetch_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UtilKt {
    public static final SortedMap<String, String> toStringMap(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return new TreeMap();
        }
        TreeMap treeMap = new TreeMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            treeMap.put(next, jSONObject.getString(next));
        }
        return treeMap;
    }

    public static final SortedMap<String, Object> toAnyMap(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return new TreeMap();
        }
        TreeMap treeMap = new TreeMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "it");
            Object obj = jSONObject.get(next);
            Intrinsics.checkExpressionValueIsNotNull(obj, "get(it)");
            treeMap.put(next, obj);
        }
        return treeMap;
    }

    public static final Map<String, List<String>> toListMap(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "key");
            linkedHashMap.put(next, toStringList(jSONObject.optJSONArray(next)));
        }
        return linkedHashMap;
    }

    public static final SortedMap<String, TypedParam<?>> toTypedMap(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return new TreeMap();
        }
        TreeMap treeMap = new TreeMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "this@toTypedMap.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            String string = jSONObject2.getString("type");
            Intrinsics.checkExpressionValueIsNotNull(string, "obj.getString(\"type\")");
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            if (string == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = string.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            switch (lowerCase.hashCode()) {
                case -1249586564:
                    if (!lowerCase.equals("variable")) {
                        break;
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(next, "key");
                        String string2 = jSONObject2.getString("value");
                        Intrinsics.checkExpressionValueIsNotNull(string2, "obj.getString(\"value\")");
                        treeMap.put(next, new VariableParam(string2));
                        break;
                    }
                case -1048944393:
                    if (!lowerCase.equals("nested")) {
                        break;
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(next, "key");
                        treeMap.put(next, new NestedParam(toTypedMap(jSONObject2.getJSONObject("value"))));
                        break;
                    }
                case -892481938:
                    if (!lowerCase.equals(PrefetchRequestConfig.PARAM_TYPE_STATIC)) {
                        break;
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(next, "key");
                        Object obj = jSONObject2.get("value");
                        Intrinsics.checkExpressionValueIsNotNull(obj, "obj.get(\"value\")");
                        treeMap.put(next, new StaticParam(obj));
                        break;
                    }
                case -362445944:
                    if (!lowerCase.equals("pathparam")) {
                        break;
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(next, "key");
                        String string3 = jSONObject2.getString("value");
                        Intrinsics.checkExpressionValueIsNotNull(string3, "obj.getString(\"value\")");
                        String optString = jSONObject2.optString("dataType", "string");
                        Intrinsics.checkExpressionValueIsNotNull(optString, "obj.optString(\"dataType\", \"string\")");
                        treeMap.put(next, new PathParam(string3, optString));
                        break;
                    }
                case 107944136:
                    if (!lowerCase.equals("query")) {
                        break;
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(next, "key");
                        String string4 = jSONObject2.getString("value");
                        Intrinsics.checkExpressionValueIsNotNull(string4, "obj.getString(\"value\")");
                        String optString2 = jSONObject2.optString("dataType", "string");
                        Intrinsics.checkExpressionValueIsNotNull(optString2, "obj.optString(\"dataType\", \"string\")");
                        treeMap.put(next, new ParameterizedParam(string4, optString2));
                        break;
                    }
            }
        }
        return treeMap;
    }

    public static final List<String> toStringList(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Intrinsics.checkExpressionValueIsNotNull(string, "this@toStringList.getString(i)");
            arrayList.add(string);
        }
        return arrayList;
    }

    public static final Map<String, String> toKeyValueMap(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String optString = jSONObject.optString("key");
            Intrinsics.checkExpressionValueIsNotNull(optString, "obj.optString(\"key\")");
            String optString2 = jSONObject.optString("value");
            Intrinsics.checkExpressionValueIsNotNull(optString2, "obj.optString(\"value\")");
            linkedHashMap.put(optString, optString2);
        }
        return linkedHashMap;
    }

    public static final Uri toBasicUri(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$toBasicUri");
        Uri build = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Uri.Builder()\n        .s…is.path)\n        .build()");
        return build;
    }

    public static final SortedMap<String, String> getQueryMap(Uri uri) {
        List<String> split$default;
        Intrinsics.checkParameterIsNotNull(uri, "$this$getQueryMap");
        TreeMap treeMap = new TreeMap();
        String fragment = uri.getFragment();
        boolean z = true;
        if (fragment != null) {
            String str = fragment;
            if (StringsKt.contains$default(str, "?", false, 2, (Object) null)) {
                for (String str2 : StringsKt.split$default((String) StringsKt.split$default(str, new String[]{"?"}, false, 0, 6, (Object) null).get(1), new String[]{"&"}, false, 0, 6, (Object) null)) {
                    int indexOf$default = StringsKt.indexOf$default(str2, "=", 0, false, 6, (Object) null);
                    if (indexOf$default >= 0) {
                        TreeMap treeMap2 = treeMap;
                        if (str2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        String substring = str2.substring(0, indexOf$default);
                        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String decode = URLDecoder.decode(substring, "UTF-8");
                        Intrinsics.checkExpressionValueIsNotNull(decode, "URLDecoder.decode(pair.s…tring(0, index), \"UTF-8\")");
                        int i = indexOf$default + 1;
                        if (str2 != null) {
                            String substring2 = str2.substring(i);
                            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                            String decode2 = URLDecoder.decode(substring2, "UTF-8");
                            Intrinsics.checkExpressionValueIsNotNull(decode2, "URLDecoder.decode(pair.s…ring(index + 1), \"UTF-8\")");
                            treeMap2.put(decode, decode2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
            }
        }
        String query = uri.getQuery();
        if (query != null && query.length() != 0) {
            z = false;
        }
        if (z) {
            return treeMap;
        }
        String query2 = uri.getQuery();
        if (query2 == null || (split$default = StringsKt.split$default(query2, new String[]{"&"}, false, 0, 6, (Object) null)) == null) {
            return treeMap;
        }
        for (String str3 : split$default) {
            int indexOf$default2 = StringsKt.indexOf$default(str3, "=", 0, false, 6, (Object) null);
            if (indexOf$default2 >= 0) {
                TreeMap treeMap3 = treeMap;
                if (str3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring3 = str3.substring(0, indexOf$default2);
                Intrinsics.checkExpressionValueIsNotNull(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String decode3 = URLDecoder.decode(substring3, "UTF-8");
                Intrinsics.checkExpressionValueIsNotNull(decode3, "URLDecoder.decode(pair.s…tring(0, index), \"UTF-8\")");
                int i2 = indexOf$default2 + 1;
                if (str3 != null) {
                    String substring4 = str3.substring(i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring4, "(this as java.lang.String).substring(startIndex)");
                    String decode4 = URLDecoder.decode(substring4, "UTF-8");
                    Intrinsics.checkExpressionValueIsNotNull(decode4, "URLDecoder.decode(pair.s…ring(index + 1), \"UTF-8\")");
                    treeMap3.put(decode3, decode4);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }
        return treeMap;
    }

    public static final JSONObject toJSONObject(Map<String, ? extends Object> map) {
        if (map == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static final String createApiUrl(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(str, "baseUrl");
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (map != null) {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue().toString());
            }
        }
        String builder = buildUpon.toString();
        Intrinsics.checkExpressionValueIsNotNull(builder, "builder.toString()");
        return builder;
    }

    public static final JSONObject createSortedJSONObject(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "originalObject");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "originalObject.keys()");
        for (String str : SequencesKt.sorted(SequencesKt.asSequence(keys))) {
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONObject) {
                jSONObject2.put(str, createSortedJSONObject((JSONObject) obj));
            } else {
                jSONObject2.put(str, obj);
            }
        }
        return jSONObject2;
    }

    public static final TreeMap<String, String> emptyStringTreeMap() {
        return new TreeMap<>();
    }

    public static final String stacktraceString(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "$this$stacktraceString");
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringWriter2, "StringWriter()\n    .also…er(it)) }\n    .toString()");
        return stringWriter2;
    }
}
