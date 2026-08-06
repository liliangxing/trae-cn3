package com.bytedance.ies.bullet.kit.resourceloader;

import com.bytedance.geckox.GeckoClient;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoXClientManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007RF\u0010\u0003\u001a:\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0004j\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/GeckoXClientManager;", "", "()V", "map", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/geckox/GeckoClient;", "Lkotlin/collections/HashMap;", "getGeckoClient", "accessKey", "bid", "putGeckoClient", "", "geckoClient", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GeckoXClientManager {
    private final HashMap<String, Map<String, GeckoClient>> map = new HashMap<>();

    public final void putGeckoClient(String accessKey, String bid, GeckoClient geckoClient) {
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(bid, "bid");
        synchronized (this.map) {
            LinkedHashMap linkedHashMap = this.map.get(bid);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            linkedHashMap.put(accessKey, geckoClient);
            this.map.put(bid, linkedHashMap);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final GeckoClient getGeckoClient(String accessKey, String bid) {
        GeckoClient geckoClient;
        Intrinsics.checkNotNullParameter(bid, "bid");
        String str = accessKey;
        if (str == null || str.length() == 0) {
            return null;
        }
        synchronized (this.map) {
            Map<String, GeckoClient> map = this.map.get(bid);
            geckoClient = map != null ? map.get(accessKey) : null;
        }
        return geckoClient;
    }
}
