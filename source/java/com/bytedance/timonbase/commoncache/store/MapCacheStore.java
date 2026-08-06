package com.bytedance.timonbase.commoncache.store;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapCacheStore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0005H\u0016R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/timonbase/commoncache/store/MapCacheStore;", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "", "Ljava/lang/ref/SoftReference;", "containsKey", "key", "get", "", "put", "", "data", "remove", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class MapCacheStore implements CacheStore {
    private final ConcurrentHashMap<String, Pair<Boolean, SoftReference<?>>> cache = new ConcurrentHashMap<>();

    @Override // com.bytedance.timonbase.commoncache.store.CacheStore
    public void put(String key, Object data) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.cache.put(key, new Pair<>(Boolean.valueOf(data == null), new SoftReference(data)));
    }

    @Override // com.bytedance.timonbase.commoncache.store.CacheStore
    public Object get(String key) {
        SoftReference<?> second;
        Intrinsics.checkParameterIsNotNull(key, "key");
        Pair<Boolean, SoftReference<?>> pair = this.cache.get(key);
        if (pair == null || (second = pair.getSecond()) == null) {
            return null;
        }
        return second.get();
    }

    @Override // com.bytedance.timonbase.commoncache.store.CacheStore
    public void remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.cache.remove(key);
    }

    @Override // com.bytedance.timonbase.commoncache.store.CacheStore
    public boolean containsKey(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Pair<Boolean, SoftReference<?>> pair = this.cache.get(key);
        if (pair != null) {
            return pair.component1().booleanValue() || pair.component2().get() != null;
        }
        return false;
    }
}
