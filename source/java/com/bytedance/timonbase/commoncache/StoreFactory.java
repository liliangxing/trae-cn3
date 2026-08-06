package com.bytedance.timonbase.commoncache;

import com.bytedance.timonbase.commoncache.store.CacheStore;
import com.bytedance.timonbase.commoncache.store.EmptyCacheStore;
import com.bytedance.timonbase.commoncache.store.MapCacheStore;
import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoreFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timonbase/commoncache/StoreFactory;", "", "()V", "globalStores", "", "", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "mapCacheStore", "Lcom/bytedance/timonbase/commoncache/store/MapCacheStore;", "getStore", "name", "registerStore", "", "store", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StoreFactory {
    public static final StoreFactory INSTANCE = new StoreFactory();
    private static final Map<String, CacheStore> globalStores;
    private static final MapCacheStore mapCacheStore;

    static {
        MapCacheStore mapCacheStore2 = new MapCacheStore();
        mapCacheStore = mapCacheStore2;
        globalStores = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("map", mapCacheStore2), TuplesKt.to(VoiceAttemptMetricsTracker.FINAL_SOURCE_EMPTY, EmptyCacheStore.INSTANCE)});
    }

    private StoreFactory() {
    }

    public final void registerStore(String name, CacheStore store) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(store, "store");
        globalStores.put(name, store);
    }

    public final CacheStore getStore(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        CacheStore cacheStore = globalStores.get(name);
        return cacheStore != null ? cacheStore : mapCacheStore;
    }
}
