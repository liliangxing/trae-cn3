package com.bytedance.ies.bullet.prefetchv2;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: PrefetchRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a&\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001¨\u0006\u0004"}, d2 = {"toStringMap", "", "", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchRequestKt {
    public static final Map<String, String> toStringMap(Map<String, ? extends Object> map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return linkedHashMap;
    }
}
