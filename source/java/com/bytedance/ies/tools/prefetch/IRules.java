package com.bytedance.ies.tools.prefetch;

import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Pair;

/* compiled from: PrefetchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a(\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IRules;", "", "getApiListWithPathParam", "Lkotlin/Pair;", "", "", "Lcom/bytedance/ies/tools/prefetch/ApiName;", "Ljava/util/SortedMap;", "occasion", "uriWrapper", "Lcom/bytedance/ies/tools/prefetch/UriWrapper;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IRules {
    Pair<List<String>, SortedMap<String, String>> getApiListWithPathParam(String occasion, UriWrapper uriWrapper);
}
