package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ies.bullet.service.base.IPreLoadServiceKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 M2\u00020\u0001:\u0001MB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020KJ\u0006\u0010L\u001a\u00020\rR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001c\u0010-\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R&\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001a\u00105\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000f\"\u0004\b6\u0010\u0011R\u001a\u00107\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R\u001a\u0010:\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R&\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001a\"\u0004\b?\u0010\u001cR\u001a\u0010@\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000f\"\u0004\bB\u0010\u0011R\u001a\u0010C\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000f\"\u0004\bE\u0010\u0011R\u001c\u0010F\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010/\"\u0004\bH\u00101¨\u0006N"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequestConfig;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "appendGlobalProps", "", "", "getAppendGlobalProps", "()Ljava/util/List;", "setAppendGlobalProps", "(Ljava/util/List;)V", "clearCacheBeforeRequest", "", "getClearCacheBeforeRequest", "()Z", "setClearCacheBeforeRequest", "(Z)V", "conditions", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchCondition;", "getConditions", "setConditions", "data", "", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchParam;", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "expireMs", "", "getExpireMs", "()Ljava/lang/Long;", "setExpireMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expireTimestamp", "getExpireTimestamp", "setExpireTimestamp", "extraHeaders", "getExtraHeaders", "setExtraHeaders", "extraParams", "getExtraParams", "setExtraParams", "globalPropsName", "getGlobalPropsName", "()Ljava/lang/String;", "setGlobalPropsName", "(Ljava/lang/String;)V", "headers", "getHeaders", "setHeaders", "isCustomizedCookie", "setCustomizedCookie", "method", "getMethod", "setMethod", "needCommonParams", "getNeedCommonParams", "setNeedCommonParams", "params", "getParams", "setParams", "requestIgnoreCache", "getRequestIgnoreCache", "setRequestIgnoreCache", "streamLoadType", "getStreamLoadType", "setStreamLoadType", "url", "getUrl", "setUrl", "checkCondition", "schemaModel", "Lcom/bytedance/ies/bullet/prefetchv2/SchemaModel;", "checkValid", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchRequestConfig {
    public static final String ENV_TYPE_AID = "AID";
    public static final String ENV_TYPE_APP_VERSION = "APP_VERSION";
    public static final String ENV_TYPE_DID = "DID";
    public static final String ENV_TYPE_OS = "OS";
    public static final String METHOD_GET = "get";
    public static final String METHOD_POST = "post";
    public static final String PARAM_TYPE_ENV = "env";
    public static final String PARAM_TYPE_QUERY = "query";
    public static final String PARAM_TYPE_QUERY_OBJECT = "queryObject";
    public static final String PARAM_TYPE_STATIC = "static";
    public static final String PARAM_TYPE_STORAGE = "userDomainStorage";
    private List<String> appendGlobalProps;
    private boolean clearCacheBeforeRequest;
    private List<PrefetchCondition> conditions;
    private Map<String, PrefetchParam> data;
    private Long expireMs;
    private Long expireTimestamp;
    private Map<String, PrefetchParam> extraHeaders;
    private Map<String, PrefetchParam> extraParams;
    private String globalPropsName;
    private Map<String, PrefetchParam> headers;
    private boolean isCustomizedCookie;
    private String method;
    private boolean needCommonParams;
    private Map<String, PrefetchParam> params;
    private boolean requestIgnoreCache;
    private boolean streamLoadType;
    private String url;

    public PrefetchRequestConfig(JSONObject jSONObject) {
        Iterator<String> keys;
        Iterator<String> keys2;
        Iterator<String> keys3;
        Iterator<String> keys4;
        Iterator<String> keys5;
        PrefetchParam prefetchParam;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        this.method = "GET";
        this.headers = new LinkedHashMap();
        this.params = new LinkedHashMap();
        this.data = new LinkedHashMap();
        this.conditions = new ArrayList();
        this.requestIgnoreCache = true;
        this.extraHeaders = new LinkedHashMap();
        this.extraParams = new LinkedHashMap();
        this.url = jSONObject.optString("url");
        String optString = jSONObject.optString("method");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"method\")");
        this.method = optString;
        JSONObject optJSONObject = jSONObject.optJSONObject("headers");
        if (optJSONObject != null && (keys5 = optJSONObject.keys()) != null) {
            while (keys5.hasNext()) {
                String next = keys5.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                Map<String, PrefetchParam> map = this.headers;
                Intrinsics.checkNotNullExpressionValue(next, "key");
                if (optJSONObject2 != null) {
                    prefetchParam = new PrefetchParam(optJSONObject2);
                } else {
                    String optString2 = optJSONObject.optString(next);
                    Intrinsics.checkNotNullExpressionValue(optString2, "headerJson.optString(key)");
                    prefetchParam = new PrefetchParam(optString2);
                }
                map.put(next, prefetchParam);
            }
        }
        this.params = new LinkedHashMap();
        JSONObject optJSONObject3 = jSONObject.optJSONObject("params");
        if (optJSONObject3 != null && (keys4 = optJSONObject3.keys()) != null) {
            while (keys4.hasNext()) {
                String next2 = keys4.next();
                Map<String, PrefetchParam> map2 = this.params;
                Intrinsics.checkNotNullExpressionValue(next2, "key");
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject(next2);
                Intrinsics.checkNotNullExpressionValue(optJSONObject4, "paramsJson.optJSONObject(key)");
                map2.put(next2, new PrefetchParam(optJSONObject4));
            }
        }
        this.data = new LinkedHashMap();
        JSONObject optJSONObject5 = jSONObject.optJSONObject("data");
        if (optJSONObject5 != null && (keys3 = optJSONObject5.keys()) != null) {
            while (keys3.hasNext()) {
                String next3 = keys3.next();
                Map<String, PrefetchParam> map3 = this.data;
                Intrinsics.checkNotNullExpressionValue(next3, "key");
                JSONObject optJSONObject6 = optJSONObject5.optJSONObject(next3);
                Intrinsics.checkNotNullExpressionValue(optJSONObject6, "dataJson.optJSONObject(key)");
                map3.put(next3, new PrefetchParam(optJSONObject6));
            }
        }
        this.needCommonParams = jSONObject.optBoolean("needCommonParams", true);
        this.isCustomizedCookie = jSONObject.optBoolean("isCustomizedCookie", false);
        if (jSONObject.has("expireMs")) {
            this.expireMs = Long.valueOf(jSONObject.optLong("expireMs"));
        }
        long optLong = jSONObject.optLong("expireTimestamp", -1L);
        this.expireTimestamp = optLong <= 0 ? null : Long.valueOf(optLong);
        this.globalPropsName = jSONObject.optString("globalPropsName");
        JSONArray optJSONArray = jSONObject.optJSONArray("conditions");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "this.getJSONObject(i)");
                arrayList.add(new PrefetchCondition(jSONObject2));
            }
            this.conditions = arrayList;
        }
        this.requestIgnoreCache = jSONObject.optInt("requestIgnoreCache", 1) == 1;
        this.clearCacheBeforeRequest = jSONObject.optInt("clearCacheBeforeRequest", 0) == 1;
        this.streamLoadType = jSONObject.optInt("streamLoadType", 0) == 1;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("appendGlobalProps");
        this.appendGlobalProps = optJSONArray2 != null ? IPreLoadServiceKt.toStringList(optJSONArray2) : null;
        this.extraHeaders = new LinkedHashMap();
        JSONObject optJSONObject7 = jSONObject.optJSONObject("extraHeaders");
        if (optJSONObject7 != null && (keys2 = optJSONObject7.keys()) != null) {
            while (keys2.hasNext()) {
                String next4 = keys2.next();
                Map<String, PrefetchParam> map4 = this.extraHeaders;
                Intrinsics.checkNotNullExpressionValue(next4, "key");
                JSONObject optJSONObject8 = optJSONObject7.optJSONObject(next4);
                Intrinsics.checkNotNullExpressionValue(optJSONObject8, "extraHeadersJson.optJSONObject(key)");
                map4.put(next4, new PrefetchParam(optJSONObject8));
            }
        }
        this.extraParams = new LinkedHashMap();
        JSONObject optJSONObject9 = jSONObject.optJSONObject("extraParams");
        if (optJSONObject9 == null || (keys = optJSONObject9.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next5 = keys.next();
            Map<String, PrefetchParam> map5 = this.extraParams;
            Intrinsics.checkNotNullExpressionValue(next5, "key");
            JSONObject optJSONObject10 = optJSONObject9.optJSONObject(next5);
            Intrinsics.checkNotNullExpressionValue(optJSONObject10, "extraParamsJson.optJSONObject(key)");
            map5.put(next5, new PrefetchParam(optJSONObject10));
        }
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.method = str;
    }

    public final Map<String, PrefetchParam> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Map<String, PrefetchParam> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.headers = map;
    }

    public final Map<String, PrefetchParam> getParams() {
        return this.params;
    }

    public final void setParams(Map<String, PrefetchParam> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.params = map;
    }

    public final Map<String, PrefetchParam> getData() {
        return this.data;
    }

    public final void setData(Map<String, PrefetchParam> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.data = map;
    }

    public final boolean getNeedCommonParams() {
        return this.needCommonParams;
    }

    public final void setNeedCommonParams(boolean z) {
        this.needCommonParams = z;
    }

    public final Long getExpireMs() {
        return this.expireMs;
    }

    public final void setExpireMs(Long l) {
        this.expireMs = l;
    }

    public final Long getExpireTimestamp() {
        return this.expireTimestamp;
    }

    public final void setExpireTimestamp(Long l) {
        this.expireTimestamp = l;
    }

    public final String getGlobalPropsName() {
        return this.globalPropsName;
    }

    public final void setGlobalPropsName(String str) {
        this.globalPropsName = str;
    }

    public final List<PrefetchCondition> getConditions() {
        return this.conditions;
    }

    public final void setConditions(List<PrefetchCondition> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.conditions = list;
    }

    public final boolean getRequestIgnoreCache() {
        return this.requestIgnoreCache;
    }

    public final void setRequestIgnoreCache(boolean z) {
        this.requestIgnoreCache = z;
    }

    public final boolean getClearCacheBeforeRequest() {
        return this.clearCacheBeforeRequest;
    }

    public final void setClearCacheBeforeRequest(boolean z) {
        this.clearCacheBeforeRequest = z;
    }

    public final Map<String, PrefetchParam> getExtraHeaders() {
        return this.extraHeaders;
    }

    public final void setExtraHeaders(Map<String, PrefetchParam> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraHeaders = map;
    }

    public final Map<String, PrefetchParam> getExtraParams() {
        return this.extraParams;
    }

    public final void setExtraParams(Map<String, PrefetchParam> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extraParams = map;
    }

    /* renamed from: isCustomizedCookie, reason: from getter */
    public final boolean getIsCustomizedCookie() {
        return this.isCustomizedCookie;
    }

    public final void setCustomizedCookie(boolean z) {
        this.isCustomizedCookie = z;
    }

    public final boolean getStreamLoadType() {
        return this.streamLoadType;
    }

    public final void setStreamLoadType(boolean z) {
        this.streamLoadType = z;
    }

    public final List<String> getAppendGlobalProps() {
        return this.appendGlobalProps;
    }

    public final void setAppendGlobalProps(List<String> list) {
        this.appendGlobalProps = list;
    }

    public final boolean checkValid() {
        String str = this.url;
        if (str == null || str.length() == 0) {
            PrefetchLogger.INSTANCE.m37e("url为空");
            return false;
        }
        if (PrefetchConfigKt.isRequestMethodSupported(this.method)) {
            return true;
        }
        PrefetchLogger.INSTANCE.m37e("不支持的请求类型: " + this.method);
        return false;
    }

    public final boolean checkCondition(SchemaModel schemaModel) {
        Intrinsics.checkNotNullParameter(schemaModel, "schemaModel");
        Iterator<PrefetchCondition> it = this.conditions.iterator();
        while (it.hasNext()) {
            if (!it.next().check(schemaModel)) {
                return false;
            }
        }
        return true;
    }
}
