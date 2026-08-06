package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* compiled from: PrefetchRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bg\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010By\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0012J\u0013\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010/\u001a\u00020\u0003J\b\u00100\u001a\u00020\u0006H\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b\"\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u001b\u0010)\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b*\u0010%R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%¨\u00061"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "url", "", "method", "headerMap", "paramMap", "dataMap", "needCommonParams", "", "extras", "", "ignoreHeaders", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;ZLjava/util/Map;Ljava/lang/Boolean;)V", "Ljava/util/SortedMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/SortedMap;Ljava/util/SortedMap;Lorg/json/JSONObject;ZLjava/util/Map;Ljava/lang/Boolean;)V", "getDataMap", "()Lorg/json/JSONObject;", "getExtras", "()Ljava/util/Map;", "hashCode", "", "getHashCode", "()I", "hashCode$delegate", "Lkotlin/Lazy;", "getHeaderMap", "()Ljava/util/SortedMap;", "getIgnoreHeaders", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getJsonObject", "jsonObject$delegate", "getMethod", "()Ljava/lang/String;", "getNeedCommonParams", "()Z", "getParamMap", "str", "getStr", "str$delegate", "getUrl", "equals", "other", "toJSONObject", "toString", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchRequest {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchRequest.class), "str", "getStr()Ljava/lang/String;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchRequest.class), "jsonObject", "getJsonObject()Lorg/json/JSONObject;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PrefetchRequest.class), "hashCode", "getHashCode()I"))};
    private final JSONObject dataMap;
    private final Map<String, String> extras;

    /* renamed from: hashCode$delegate, reason: from kotlin metadata */
    private final Lazy hashCode;
    private final SortedMap<String, String> headerMap;
    private final Boolean ignoreHeaders;

    /* renamed from: jsonObject$delegate, reason: from kotlin metadata */
    private final Lazy jsonObject;
    private final String method;
    private final boolean needCommonParams;
    private final SortedMap<String, Object> paramMap;

    /* renamed from: str$delegate, reason: from kotlin metadata */
    private final Lazy str;
    private final String url;

    private final int getHashCode() {
        Lazy lazy = this.hashCode;
        KProperty kProperty = $$delegatedProperties[2];
        return ((Number) lazy.getValue()).intValue();
    }

    private final JSONObject getJsonObject() {
        Lazy lazy = this.jsonObject;
        KProperty kProperty = $$delegatedProperties[1];
        return (JSONObject) lazy.getValue();
    }

    private final String getStr() {
        Lazy lazy = this.str;
        KProperty kProperty = $$delegatedProperties[0];
        return (String) lazy.getValue();
    }

    public PrefetchRequest(String str, String str2, SortedMap<String, String> sortedMap, SortedMap<String, Object> sortedMap2, JSONObject jSONObject, boolean z, Map<String, String> map, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "method");
        this.url = str;
        this.method = str2;
        this.headerMap = sortedMap;
        this.paramMap = sortedMap2;
        this.dataMap = jSONObject;
        this.needCommonParams = z;
        this.extras = map;
        this.ignoreHeaders = bool;
        this.str = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchRequest$str$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                Object obj;
                SortedMap<String, String> headerMap;
                StringBuilder append = new StringBuilder().append(UtilKt.createApiUrl(PrefetchRequest.this.getUrl(), PrefetchRequest.this.getParamMap())).append(StringListParam.SPLIT_DELIMITER);
                JSONObject dataMap = PrefetchRequest.this.getDataMap();
                Object obj2 = "{}";
                if (dataMap == null || (obj = UtilKt.createSortedJSONObject(dataMap)) == null) {
                    obj = "{}";
                }
                StringBuilder append2 = append.append(obj).append(StringListParam.SPLIT_DELIMITER);
                if (!Intrinsics.areEqual(PrefetchRequest.this.getIgnoreHeaders(), true) && (headerMap = PrefetchRequest.this.getHeaderMap()) != null) {
                    obj2 = headerMap;
                }
                return append2.append(obj2).append(StringListParam.SPLIT_DELIMITER).append(PrefetchRequest.this.getNeedCommonParams()).toString();
            }
        });
        this.jsonObject = LazyKt.lazy(new Function0<JSONObject>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchRequest$jsonObject$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final JSONObject invoke() {
                JSONObject put = new JSONObject().put("url", PrefetchRequest.this.getUrl()).put("method", PrefetchRequest.this.getMethod());
                SortedMap<String, String> headerMap = PrefetchRequest.this.getHeaderMap();
                JSONObject put2 = put.put("headers", headerMap != null ? UtilKt.toJSONObject(headerMap) : null);
                SortedMap<String, Object> paramMap = PrefetchRequest.this.getParamMap();
                JSONObject put3 = put2.put("params", paramMap != null ? UtilKt.toJSONObject(paramMap) : null).put("data", PrefetchRequest.this.getDataMap()).put("needCommonParams", PrefetchRequest.this.getNeedCommonParams());
                Map<String, String> extras = PrefetchRequest.this.getExtras();
                return put3.put("extras", extras != null ? UtilKt.toJSONObject(extras) : null);
            }
        });
        this.hashCode = LazyKt.lazy(new Function0<Integer>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchRequest$hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m620invoke() {
                return Integer.valueOf(invoke());
            }

            public final int invoke() {
                int hashCode = ((PrefetchRequest.this.getUrl().hashCode() * 31) + PrefetchRequest.this.getMethod().hashCode()) * 31;
                SortedMap<String, String> headerMap = PrefetchRequest.this.getHeaderMap();
                int hashCode2 = (hashCode + (headerMap != null ? headerMap.hashCode() : 0)) * 31;
                SortedMap<String, Object> paramMap = PrefetchRequest.this.getParamMap();
                int hashCode3 = (hashCode2 + (paramMap != null ? paramMap.hashCode() : 0)) * 31;
                JSONObject dataMap = PrefetchRequest.this.getDataMap();
                int hashCode4 = (((hashCode3 + (dataMap != null ? dataMap.hashCode() : 0)) * 31) + Boolean.valueOf(PrefetchRequest.this.getNeedCommonParams()).hashCode()) * 31;
                Map<String, String> extras = PrefetchRequest.this.getExtras();
                int hashCode5 = (hashCode4 + (extras != null ? extras.hashCode() : 0)) * 31;
                Boolean ignoreHeaders = PrefetchRequest.this.getIgnoreHeaders();
                return hashCode5 + (ignoreHeaders != null ? ignoreHeaders.hashCode() : 0);
            }
        });
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public final SortedMap<String, String> getHeaderMap() {
        return this.headerMap;
    }

    public final SortedMap<String, Object> getParamMap() {
        return this.paramMap;
    }

    public final JSONObject getDataMap() {
        return this.dataMap;
    }

    public final boolean getNeedCommonParams() {
        return this.needCommonParams;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PrefetchRequest(String str, String str2, SortedMap sortedMap, SortedMap sortedMap2, JSONObject jSONObject, boolean z, Map map, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (SortedMap<String, String>) sortedMap, (SortedMap<String, Object>) sortedMap2, jSONObject, r9, (Map<String, String>) r10, (i & 128) != 0 ? false : bool);
        Map map2;
        boolean z2 = (i & 32) != 0 ? false : z;
        if ((i & 64) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
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
    public PrefetchRequest(JSONObject jSONObject) {
        this(r2, r3, r4, r5, r6, r0, r8 != null ? UtilKt.toStringMap(r8) : null, Boolean.valueOf(jSONObject.optBoolean("ignore_headers", false)));
        Intrinsics.checkParameterIsNotNull(jSONObject, "jsonObject");
        String optString = jSONObject.optString("url");
        Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(\"url\")");
        String optString2 = jSONObject.optString("method", PrefetchRequestConfig.METHOD_GET);
        Intrinsics.checkExpressionValueIsNotNull(optString2, "jsonObject.optString(\"method\", \"get\")");
        JSONObject optJSONObject = jSONObject.optJSONObject("headers");
        SortedMap<String, String> stringMap = optJSONObject != null ? UtilKt.toStringMap(optJSONObject) : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("params");
        SortedMap<String, Object> anyMap = optJSONObject2 != null ? UtilKt.toAnyMap(optJSONObject2) : null;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
        boolean optBoolean = jSONObject.optBoolean("needCommonParams", false);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("extras");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PrefetchRequest(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, boolean z, Map map, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, jSONObject, jSONObject2, jSONObject3, r9, (Map<String, String>) r10, (i & 128) != 0 ? false : bool);
        Map map2;
        boolean z2 = (i & 32) != 0 ? false : z;
        if ((i & 64) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
    }

    public PrefetchRequest(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, boolean z, Map<String, String> map, Boolean bool) {
        this(str != null ? str : "", str2 != null ? str2 : PrefetchRequestConfig.METHOD_GET, jSONObject != null ? UtilKt.toStringMap(jSONObject) : null, jSONObject2 != null ? UtilKt.toAnyMap(jSONObject2) : null, jSONObject3, z, map, bool);
    }

    public final JSONObject toJSONObject() {
        return getJsonObject();
    }

    public boolean equals(Object other) {
        if (!(other instanceof PrefetchRequest)) {
            return false;
        }
        PrefetchRequest prefetchRequest = (PrefetchRequest) other;
        return Intrinsics.areEqual(this.url, prefetchRequest.url) && Intrinsics.areEqual(this.method, prefetchRequest.method) && Intrinsics.areEqual(this.headerMap, prefetchRequest.headerMap) && Intrinsics.areEqual(this.paramMap, prefetchRequest.paramMap) && Intrinsics.areEqual(this.dataMap, prefetchRequest.dataMap) && this.needCommonParams == prefetchRequest.needCommonParams && Intrinsics.areEqual(this.extras, prefetchRequest.extras) && Intrinsics.areEqual(this.ignoreHeaders, prefetchRequest.ignoreHeaders);
    }

    public int hashCode() {
        return getHashCode();
    }

    public String toString() {
        return getStr();
    }
}
