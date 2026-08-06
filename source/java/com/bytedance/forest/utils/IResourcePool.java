package com.bytedance.forest.utils;

import com.bytedance.applog.server.Api;
import kotlin.Metadata;

/* compiled from: MemoryManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/bytedance/forest/utils/IResourcePool;", "", "type", "Lcom/bytedance/forest/utils/PoolType;", "getType", "()Lcom/bytedance/forest/utils/PoolType;", "clearAllCache", "", "getCache", "Lcom/bytedance/forest/utils/MemoryCacheItem;", Api.KEY_ENCRYPT_RESP_KEY, "Lcom/bytedance/forest/utils/CacheIdentifier;", "enableRequestReuse", "", "removeCache", "updateCache", "item", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IResourcePool {
    void clearAllCache();

    MemoryCacheItem getCache(CacheIdentifier key, boolean enableRequestReuse);

    PoolType getType();

    MemoryCacheItem removeCache(CacheIdentifier key);

    void updateCache(MemoryCacheItem item);
}
