package com.bytedance.timonbase.commoncache.strategy;

import com.bytedance.timonbase.commoncache.store.CacheStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistCacheStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/timonbase/commoncache/strategy/PersistCacheStrategy;", "Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;", "()V", "needUpdate", "", "store", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "storeKey", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class PersistCacheStrategy implements CacheUpdateStrategy {
    @Override // com.bytedance.timonbase.commoncache.strategy.CacheUpdateStrategy
    public boolean needUpdate(CacheStore store, String storeKey) {
        Intrinsics.checkParameterIsNotNull(store, "store");
        Intrinsics.checkParameterIsNotNull(storeKey, "storeKey");
        return !store.containsKey(storeKey);
    }
}
