package com.bytedance.ies.tools.prefetch;

import android.net.Uri;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0002\u0012\u0016\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ@\u0010\u000b\u001a(\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\u000e0\r\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/RestfulRules;", "Lcom/bytedance/ies/tools/prefetch/IRules;", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "rules", "", "", "Lcom/bytedance/ies/tools/prefetch/RestfulPath;", "Lcom/bytedance/ies/tools/prefetch/Rule;", "(Ljava/util/Map;)V", "getApiListWithPathParam", "Lkotlin/Pair;", "", "Lcom/bytedance/ies/tools/prefetch/ApiName;", "Ljava/util/SortedMap;", "occasion", "uriWrapper", "Lcom/bytedance/ies/tools/prefetch/UriWrapper;", "matchPath", "real", "rule", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RestfulRules implements IRules {
    private final Map<String, Rule> rules;

    /* JADX WARN: Multi-variable type inference failed */
    private RestfulRules(Map<String, ? extends Rule> map) {
        this.rules = map;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RestfulRules(JSONObject jSONObject) throws JSONException {
        this(r0);
        Intrinsics.checkParameterIsNotNull(jSONObject, "jsonObject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "jsonObject.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "it");
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jsonObject.getJSONObject(it)");
            linkedHashMap.put(next, new Rule(next, jSONObject2));
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IRules
    public Pair<List<String>, SortedMap<String, String>> getApiListWithPathParam(String occasion, UriWrapper uriWrapper) {
        Intrinsics.checkParameterIsNotNull(uriWrapper, "uriWrapper");
        Uri uri = uriWrapper.getUri();
        String url = uriWrapper.getUrl();
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        for (Map.Entry<String, Rule> entry : this.rules.entrySet()) {
            SortedMap<String, String> matchPath = matchPath(path, entry.getKey());
            if (matchPath != null) {
                LogUtil.INSTANCE.m55d("[scheme:" + url + "] match_result_rule:" + entry.getKey());
                List<String> matchApisName = entry.getValue().getMatchApisName(occasion, uriWrapper);
                if (matchApisName != null) {
                    return new Pair<>(matchApisName, matchPath);
                }
            }
        }
        return null;
    }

    private final SortedMap<String, String> matchPath(String real, String rule) {
        List split = new Regex("/").split(real, 0);
        List split2 = new Regex("/").split(rule, 0);
        if (split.size() != split2.size()) {
            return null;
        }
        TreeMap<String, String> emptyStringTreeMap = UtilKt.emptyStringTreeMap();
        int size = split.size();
        for (int i = 0; i < size; i++) {
            String str = (String) split2.get(i);
            if (StringsKt.startsWith$default(str, ":", false, 2, (Object) null)) {
                TreeMap<String, String> treeMap = emptyStringTreeMap;
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str.substring(1);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                treeMap.put(substring, split.get(i));
            } else if (!Intrinsics.areEqual((String) split.get(i), str)) {
                return null;
            }
        }
        return emptyStringTreeMap;
    }
}
