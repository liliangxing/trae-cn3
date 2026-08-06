package com.bytedance.timonbase.commoncache.strategy;

import com.bytedance.timonbase.commoncache.store.CacheStore;
import kotlin.Metadata;

/* compiled from: CacheUpdateStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;", "", "needUpdate", "", "store", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "storeKey", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface CacheUpdateStrategy {
    boolean needUpdate(CacheStore store, String storeKey);
}
