package com.bytedance.ies.tools.prefetch;

import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bg\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\"\u0010\b\u001a\u001e\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002`\f0\u000b\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0016\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\t¢\u0006\u0002\u0010\u0014J0\u0010\u001f\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010!\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u0006J0\u0010#\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010!\u0018\u00010 2\u0006\u0010$\u001a\u00020%R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R0\u0010\b\u001a\u001e\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006j\u0002`\f0\u000b\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u0006&"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchConfig;", "", "config", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "project", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "occasion", "", "Lcom/bytedance/ies/tools/prefetch/OccasionName;", "", "Lcom/bytedance/ies/tools/prefetch/RuleName;", "normalRules", "Lcom/bytedance/ies/tools/prefetch/NormalRules;", "restfulRules", "Lcom/bytedance/ies/tools/prefetch/RestfulRules;", "prefetchApis", "Lcom/bytedance/ies/tools/prefetch/ApiName;", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/ies/tools/prefetch/NormalRules;Lcom/bytedance/ies/tools/prefetch/RestfulRules;Ljava/util/Map;)V", "getNormalRules$prefetch_release", "()Lcom/bytedance/ies/tools/prefetch/NormalRules;", "getOccasion$prefetch_release", "()Ljava/util/Map;", "getPrefetchApis$prefetch_release", "getProject", "()Ljava/lang/String;", "getRestfulRules$prefetch_release", "()Lcom/bytedance/ies/tools/prefetch/RestfulRules;", "getVersion", "getRequestConfigByOccasion", "Lkotlin/Pair;", "Ljava/util/SortedMap;", "name", "getRequestConfigByUri", "uriWrapper", "Lcom/bytedance/ies/tools/prefetch/UriWrapper;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchConfig {
    private final NormalRules normalRules;
    private final Map<String, List<String>> occasion;
    private final Map<String, RequestConfig> prefetchApis;
    private final String project;
    private final RestfulRules restfulRules;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    private PrefetchConfig(String str, String str2, Map<String, ? extends List<String>> map, NormalRules normalRules, RestfulRules restfulRules, Map<String, RequestConfig> map2) {
        this.project = str;
        this.version = str2;
        this.occasion = map;
        this.normalRules = normalRules;
        this.restfulRules = restfulRules;
        this.prefetchApis = map2;
    }

    public final String getProject() {
        return this.project;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Map<String, List<String>> getOccasion$prefetch_release() {
        return this.occasion;
    }

    /* renamed from: getNormalRules$prefetch_release, reason: from getter */
    public final NormalRules getNormalRules() {
        return this.normalRules;
    }

    /* renamed from: getRestfulRules$prefetch_release, reason: from getter */
    public final RestfulRules getRestfulRules() {
        return this.restfulRules;
    }

    public final Map<String, RequestConfig> getPrefetchApis$prefetch_release() {
        return this.prefetchApis;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PrefetchConfig(JSONObject jSONObject) {
        this(r2, r3, r4, r5, r6, r7);
        Iterator<String> keys;
        Intrinsics.checkParameterIsNotNull(jSONObject, "config");
        String optString = jSONObject.optString("project");
        Intrinsics.checkExpressionValueIsNotNull(optString, "config.optString(\"project\")");
        String optString2 = jSONObject.optString(IPiaCacheProvider.CacheConfig.FIELD_VERSION);
        Intrinsics.checkExpressionValueIsNotNull(optString2, "config.optString(\"version\")");
        JSONObject optJSONObject = jSONObject.optJSONObject("occasions");
        Map<String, List<String>> listMap = optJSONObject != null ? UtilKt.toListMap(optJSONObject) : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("rules");
        NormalRules normalRules = optJSONObject2 != null ? new NormalRules(optJSONObject2) : null;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("restful_rules");
        RestfulRules restfulRules = optJSONObject3 != null ? new RestfulRules(optJSONObject3) : null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject optJSONObject4 = jSONObject.optJSONObject("prefetch_apis");
        if (optJSONObject4 != null && (keys = optJSONObject4.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject5 = optJSONObject4.optJSONObject(next);
                if (optJSONObject5 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(next, "apiName");
                }
            }
        }
    }

    public final Pair<List<RequestConfig>, SortedMap<String, String>> getRequestConfigByUri(UriWrapper uriWrapper) {
        RestfulRules restfulRules;
        List list;
        Pair<List<String>, SortedMap<String, String>> apiListWithPathParam;
        List list2;
        Intrinsics.checkParameterIsNotNull(uriWrapper, "uriWrapper");
        if (this.prefetchApis.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        NormalRules normalRules = this.normalRules;
        if (normalRules != null && (apiListWithPathParam = normalRules.getApiListWithPathParam(null, uriWrapper)) != null && (list2 = (List) apiListWithPathParam.getFirst()) != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                RequestConfig requestConfig = this.prefetchApis.get((String) it.next());
                if (requestConfig != null) {
                    arrayList.add(requestConfig);
                }
            }
        }
        if (arrayList.isEmpty() && (restfulRules = this.restfulRules) != null) {
            Pair<List<String>, SortedMap<String, String>> apiListWithPathParam2 = restfulRules.getApiListWithPathParam(null, uriWrapper);
            if (apiListWithPathParam2 != null && (list = (List) apiListWithPathParam2.getFirst()) != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    RequestConfig requestConfig2 = this.prefetchApis.get((String) it2.next());
                    if (requestConfig2 != null) {
                        arrayList.add(requestConfig2);
                    }
                }
            }
            return new Pair<>(arrayList, apiListWithPathParam2 != null ? (SortedMap) apiListWithPathParam2.getSecond() : null);
        }
        return new Pair<>(arrayList, (Object) null);
    }

    public final Pair<List<RequestConfig>, SortedMap<String, String>> getRequestConfigByOccasion(String name) {
        Map<String, List<String>> map;
        Intrinsics.checkParameterIsNotNull(name, "name");
        if (!this.prefetchApis.isEmpty() && (map = this.occasion) != null && map.containsKey(name)) {
            LogUtil.INSTANCE.m55d("[occasion:" + name + "] match_occasion:" + name);
            NormalRules normalRules = this.normalRules;
            if (normalRules != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                List<String> list = map.get(name);
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        Pair<List<String>, SortedMap<String, String>> apiListWithPathParam = normalRules.getApiListWithPathParam(name, new UriWrapper((String) it.next()));
                        if (apiListWithPathParam != null) {
                            arrayList2.addAll((Collection) apiListWithPathParam.getFirst());
                        }
                    }
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    RequestConfig requestConfig = this.prefetchApis.get((String) it2.next());
                    if (requestConfig != null) {
                        arrayList.add(requestConfig);
                    }
                }
                return new Pair<>(arrayList, (Object) null);
            }
        }
        return null;
    }
}
