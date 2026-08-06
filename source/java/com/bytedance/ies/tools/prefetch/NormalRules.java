package com.bytedance.ies.tools.prefetch;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006¢\u0006\u0002\u0010\nJ@\u0010\r\u001a(\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\u000f0\b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R&\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/NormalRules;", "Lcom/bytedance/ies/tools/prefetch/IRules;", "rulesObj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "rules", "", "", "", "Lcom/bytedance/ies/tools/prefetch/Rule;", "(Ljava/util/Map;)V", "getRules$prefetch_release", "()Ljava/util/Map;", "getApiListWithPathParam", "Lkotlin/Pair;", "Lcom/bytedance/ies/tools/prefetch/ApiName;", "Ljava/util/SortedMap;", "occasion", "uriWrapper", "Lcom/bytedance/ies/tools/prefetch/UriWrapper;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NormalRules implements IRules {
    private final Map<String, List<Rule>> rules;

    /* JADX WARN: Multi-variable type inference failed */
    public NormalRules(Map<String, ? extends List<? extends Rule>> map) {
        Intrinsics.checkParameterIsNotNull(map, "rules");
        this.rules = map;
    }

    public final Map<String, List<Rule>> getRules$prefetch_release() {
        return this.rules;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NormalRules(JSONObject jSONObject) {
        this(r0);
        Intrinsics.checkParameterIsNotNull(jSONObject, "rulesObj");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "rulesObj.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof JSONObject) {
                Intrinsics.checkExpressionValueIsNotNull(next, "key");
                linkedHashMap.put(next, CollectionsKt.mutableListOf(new Rule[]{new Rule(next, (JSONObject) opt)}));
            } else if (opt instanceof JSONArray) {
                Intrinsics.checkExpressionValueIsNotNull(next, "key");
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = (JSONArray) opt;
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(new Rule(next, optJSONObject));
                    }
                }
                linkedHashMap.put(next, arrayList);
            }
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IRules
    public Pair<List<String>, SortedMap<String, String>> getApiListWithPathParam(String occasion, UriWrapper uriWrapper) {
        String str;
        List<Rule> list;
        List<Rule> list2;
        Intrinsics.checkParameterIsNotNull(uriWrapper, "uriWrapper");
        String url = uriWrapper.getUrl();
        if (this.rules.containsKey(url)) {
            list = this.rules.get(url);
        } else {
            Uri uri = uriWrapper.getUri();
            String path = uri.getPath();
            if (path == null || (list2 = this.rules.get(path)) == null) {
                String path2 = uri.getPath();
                if (path2 == null) {
                    path2 = "";
                }
                if (StringsKt.endsWith$default(path2, '/', false, 2, (Object) null)) {
                    str = StringsKt.substringBeforeLast$default(path2, '/', (String) null, 2, (Object) null);
                } else {
                    str = path2 + '/';
                }
                list = this.rules.get(str);
            } else {
                list = list2;
            }
        }
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List<String> matchApisName = ((Rule) it.next()).getMatchApisName(occasion, uriWrapper);
                if (matchApisName != null) {
                    return new Pair<>(matchApisName, (Object) null);
                }
            }
        }
        return null;
    }
}
