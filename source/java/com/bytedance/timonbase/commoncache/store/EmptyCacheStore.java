package com.bytedance.timonbase.commoncache.store;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmptyCacheStore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/timonbase/commoncache/store/EmptyCacheStore;", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "()V", "containsKey", "", "key", "", "get", "", "put", "", "data", "remove", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class EmptyCacheStore implements CacheStore {
    public static final EmptyCacheStore INSTANCE = new EmptyCacheStore();

    @Override // com.bytedance.timonbase.commoncache.store.CacheStore
    public boolean containsKey(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return true;
    }

    @Override // com.bytedance.timonbase.commoncache.store.CacheStore
    public Object get(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return null;
    }

    @Override // com.bytedance.timonbase.commoncache.store.CacheStore
    public void put(String key, Object data) {
        Intrinsics.checkParameterIsNotNull(key, "key");
    }

    @Override // com.bytedance.timonbase.commoncache.store.CacheStore
    public void remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
    }

    private EmptyCacheStore() {
    }
}
