package com.bytedance.ies.tools.prefetch;

import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: RequestConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B«\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\u000b\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0016J\b\u0010)\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001c¨\u0006*"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "apiUrl", "", "method", "conditions", "", "headerMap", "Ljava/util/SortedMap;", "paramMap", "Lcom/bytedance/ies/tools/prefetch/TypedParam;", "dataMap", "expireTimeout", "", "needCommonParams", "", "extras", "", "ignoreHeaders", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/SortedMap;Ljava/util/SortedMap;Ljava/util/SortedMap;JZLjava/util/Map;Ljava/lang/Boolean;)V", "getApiUrl", "()Ljava/lang/String;", "getConditions", "()Ljava/util/List;", "getDataMap", "()Ljava/util/SortedMap;", "getExpireTimeout", "()J", "getExtras", "()Ljava/util/Map;", "getHeaderMap", "getIgnoreHeaders", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMethod", "getNeedCommonParams", "()Z", "getParamMap", "toString", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RequestConfig {
    private final String apiUrl;
    private final List<String> conditions;
    private final SortedMap<String, TypedParam<?>> dataMap;
    private final long expireTimeout;
    private final Map<String, String> extras;
    private final SortedMap<String, String> headerMap;
    private final Boolean ignoreHeaders;
    private final String method;
    private final boolean needCommonParams;
    private final SortedMap<String, TypedParam<?>> paramMap;

    public RequestConfig(String str, String str2, List<String> list, SortedMap<String, String> sortedMap, SortedMap<String, TypedParam<?>> sortedMap2, SortedMap<String, TypedParam<?>> sortedMap3, long j, boolean z, Map<String, String> map, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "apiUrl");
        Intrinsics.checkParameterIsNotNull(str2, "method");
        this.apiUrl = str;
        this.method = str2;
        this.conditions = list;
        this.headerMap = sortedMap;
        this.paramMap = sortedMap2;
        this.dataMap = sortedMap3;
        this.expireTimeout = j;
        this.needCommonParams = z;
        this.extras = map;
        this.ignoreHeaders = bool;
    }

    public final String getApiUrl() {
        return this.apiUrl;
    }

    public final String getMethod() {
        return this.method;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RequestConfig(String str, String str2, List list, SortedMap sortedMap, SortedMap sortedMap2, SortedMap sortedMap3, long j, boolean z, Map map, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, r6, r7, r8, r9, j, z, r13, (i & 512) != 0 ? false : bool);
        List list2;
        SortedMap sortedMap4;
        SortedMap sortedMap5;
        SortedMap sortedMap6;
        Map map2;
        if ((i & 4) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        if ((i & 8) != 0) {
            sortedMap4 = null;
        } else {
            sortedMap4 = sortedMap;
        }
        if ((i & 16) != 0) {
            sortedMap5 = null;
        } else {
            sortedMap5 = sortedMap2;
        }
        if ((i & 32) != 0) {
            sortedMap6 = null;
        } else {
            sortedMap6 = sortedMap3;
        }
        if ((i & 256) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
    }

    public final List<String> getConditions() {
        return this.conditions;
    }

    public final SortedMap<String, String> getHeaderMap() {
        return this.headerMap;
    }

    public final SortedMap<String, TypedParam<?>> getParamMap() {
        return this.paramMap;
    }

    public final SortedMap<String, TypedParam<?>> getDataMap() {
        return this.dataMap;
    }

    public final long getExpireTimeout() {
        return this.expireTimeout;
    }

    public final boolean getNeedCommonParams() {
        return this.needCommonParams;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final Boolean getIgnoreHeaders() {
        return this.ignoreHeaders;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RequestConfig(JSONObject jSONObject) {
        this(r2, r3, null, r5, r6, r7, r8, r0, r11 != null ? UtilKt.toStringMap(r11) : null, Boolean.valueOf(jSONObject.optBoolean("ignore_headers", false)));
        Intrinsics.checkParameterIsNotNull(jSONObject, "obj");
        String optString = jSONObject.optString("url");
        Intrinsics.checkExpressionValueIsNotNull(optString, "obj.optString(\"url\")");
        String optString2 = jSONObject.optString("method", "GET");
        Intrinsics.checkExpressionValueIsNotNull(optString2, "obj.optString(\"method\", \"GET\")");
        Locale locale = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
        if (optString2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = optString2.toLowerCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        JSONObject optJSONObject = jSONObject.optJSONObject("headers");
        SortedMap<String, String> stringMap = optJSONObject != null ? UtilKt.toStringMap(optJSONObject) : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("params");
        SortedMap<String, TypedParam<?>> typedMap = optJSONObject2 != null ? UtilKt.toTypedMap(optJSONObject2) : null;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
        SortedMap<String, TypedParam<?>> typedMap2 = optJSONObject3 != null ? UtilKt.toTypedMap(optJSONObject3) : null;
        long optLong = jSONObject.optLong(IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, -1L) * BytePatchException.ErrorCode.paramsError;
        optLong = optLong < 0 ? com.bytedance.ies.bullet.prefetchv2.PrefetchConfigKt.DEFAULT_EXPIRE_MS : optLong;
        boolean optBoolean = jSONObject.optBoolean("needCommonParams", false);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("extras");
    }

    public String toString() {
        return "hashCode: " + hashCode() + ", url: " + this.apiUrl + ", method: " + this.method + ", expireTimeout: " + this.expireTimeout;
    }
}
