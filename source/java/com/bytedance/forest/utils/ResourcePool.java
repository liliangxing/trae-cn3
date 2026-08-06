package com.bytedance.forest.utils;

import android.util.LruCache;
import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.InMemoryBuffer;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/forest/utils/ResourcePool;", "Lcom/bytedance/forest/utils/IResourcePool;", "maxBufferSize", "", "type", "Lcom/bytedance/forest/utils/PoolType;", "(ILcom/bytedance/forest/utils/PoolType;)V", "lruCache", "com/bytedance/forest/utils/ResourcePool$lruCache$1", "Lcom/bytedance/forest/utils/ResourcePool$lruCache$1;", "getType", "()Lcom/bytedance/forest/utils/PoolType;", "clearAllCache", "", "getCache", "Lcom/bytedance/forest/utils/MemoryCacheItem;", Api.KEY_ENCRYPT_RESP_KEY, "Lcom/bytedance/forest/utils/CacheIdentifier;", "enableRequestReuse", "", "hasCache", "removeCache", "updateCache", "item", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResourcePool implements IResourcePool {
    private final ResourcePool$lruCache$1 lruCache;
    private final PoolType type;

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.forest.utils.ResourcePool$lruCache$1] */
    public ResourcePool(final int i, PoolType poolType) {
        Intrinsics.checkParameterIsNotNull(poolType, "type");
        this.type = poolType;
        this.lruCache = new LruCache<CacheIdentifier, MemoryCacheItem>(i) { // from class: com.bytedance.forest.utils.ResourcePool$lruCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(CacheIdentifier key, MemoryCacheItem value) {
                if (value != null) {
                    return value.getCacheSize();
                }
                return 1;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public void entryRemoved(boolean evicted, CacheIdentifier key, MemoryCacheItem oldValue, MemoryCacheItem newValue) {
                super.entryRemoved(evicted, (boolean) key, oldValue, newValue);
                if (oldValue != null) {
                    oldValue.close();
                }
                LogUtils.i$default(LogUtils.INSTANCE, MemoryManager.TAG, "[" + ResourcePool.this.getType() + ']' + (evicted ? "evicted" : "remove") + ' ' + oldValue + ", key=" + key, false, null, null, null, 60, null);
            }
        };
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public PoolType getType() {
        return this.type;
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public void clearAllCache() {
        evictAll();
    }

    public final boolean hasCache(CacheIdentifier key) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        return get(key) != null;
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public void updateCache(MemoryCacheItem item) {
        final boolean z;
        Intrinsics.checkParameterIsNotNull(item, "item");
        ResourcePool resourcePool = this;
        item.setPool$forest_release(resourcePool);
        final Response response = item.getResponse();
        ForestLogger logger = response.getLogger();
        if (response.getFrom() != ResourceFrom.BUILTIN) {
            if (response.getFrom() == ResourceFrom.MEMORY && response.getOriginFrom() == ResourceFrom.BUILTIN) {
                return;
            }
            InMemoryBuffer buffer = item.getBuffer();
            CacheIdentifier cacheKey$forest_release = response.getRequest().getCacheKey$forest_release();
            if (cacheKey$forest_release == null) {
                ForestLogger.print$default(logger, 3, MemoryManager.TAG, "[" + getType() + "]updateCache: cache key is empty", false, null, null, 56, null);
                return;
            }
            final boolean z2 = false;
            if (buffer == null || !buffer.isCacheProvided$forest_release()) {
                String filePath = response.getFilePath();
                if (filePath == null || filePath.length() == 0) {
                    ForestLogger.print$default(logger, 3, MemoryManager.TAG, "[" + getType() + "]updateCache: cache in-memory buffer is not provided and file path is empty", false, null, null, 56, null);
                    return;
                }
            }
            final MemoryCacheItem memoryCacheItem = get(cacheKey$forest_release);
            final MemoryCacheItem memoryCacheItem2 = new MemoryCacheItem(response, resourcePool);
            InMemoryBuffer buffer2 = memoryCacheItem2.getBuffer();
            if (buffer2 != null && !buffer2.isCacheReady$forest_release()) {
                buffer2.fulfillListener$forest_release(new Function0<Unit>() { // from class: com.bytedance.forest.utils.ResourcePool$updateCache$$inlined$also$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m536invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m536invoke() {
                        final IResourcePool pool = MemoryCacheItem.this.getPool();
                        if (pool == null) {
                            ForestLogger.print$default(response.getLogger(), 5, MemoryManager.TAG, "onFulFilled but relate pool is NULL", false, null, null, 56, null);
                        } else {
                            ForestLogger.printOptimize$default(response.getLogger(), 4, MemoryManager.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.utils.ResourcePool$updateCache$$inlined$also$lambda$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    return "[" + pool.getType() + "]onFulFilled " + MemoryCacheItem.this;
                                }
                            }, 28, null);
                            pool.updateCache(new MemoryCacheItem(response, null, 2, null));
                        }
                    }
                });
            }
            final MemoryCacheItem memoryCacheItem3 = null;
            if (memoryCacheItem != null) {
                Response response2 = memoryCacheItem.getResponse();
                if (!(response2 instanceof ProcessedResponse)) {
                    response2 = null;
                }
                ProcessedResponse processedResponse = (ProcessedResponse) response2;
                if (processedResponse == null || !processedResponse.getIsProcessSucceed()) {
                    ProcessedResponse processedResponse2 = (ProcessedResponse) (!(response instanceof ProcessedResponse) ? null : response);
                    if (processedResponse2 != null && processedResponse2.getIsProcessSucceed()) {
                        z = true;
                        if (memoryCacheItem != null && memoryCacheItem.getCacheSize() != memoryCacheItem2.getCacheSize()) {
                            z2 = true;
                        }
                        if ((response.getFrom() != ResourceFrom.MEMORY || memoryCacheItem != null) && !z && !z2) {
                            ForestLogger.printOptimize$default(response.getLogger(), 4, MemoryManager.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.utils.ResourcePool$updateCache$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    return "[" + ResourcePool.this.getType() + "]reject update. sizeUpdate=" + z2 + ", processReplacement=" + z + ", cachedItem=" + memoryCacheItem;
                                }
                            }, 28, null);
                            memoryCacheItem2.close();
                        }
                        MemoryCacheItem put = put(cacheKey$forest_release, memoryCacheItem2);
                        if (put != null) {
                            put.close();
                            memoryCacheItem3 = put;
                        }
                        ForestLogger.printOptimize$default(logger, 4, MemoryManager.TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.utils.ResourcePool$updateCache$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "[" + ResourcePool.this.getType() + "]update from [" + memoryCacheItem3 + "] to [" + memoryCacheItem2 + ']';
                            }
                        }, 24, null);
                        if (memoryCacheItem != memoryCacheItem3) {
                            ForestLogger.printOptimize$default(logger, 5, MemoryManager.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.utils.ResourcePool$updateCache$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    return "[" + ResourcePool.this.getType() + "]replacement reference mismatch, except [" + memoryCacheItem + "] but received [" + memoryCacheItem3 + ']';
                                }
                            }, 28, null);
                            return;
                        }
                        return;
                    }
                }
            }
            z = false;
            if (memoryCacheItem != null) {
                z2 = true;
            }
            if (response.getFrom() != ResourceFrom.MEMORY) {
            }
            ForestLogger.printOptimize$default(response.getLogger(), 4, MemoryManager.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.utils.ResourcePool$updateCache$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return "[" + ResourcePool.this.getType() + "]reject update. sizeUpdate=" + z2 + ", processReplacement=" + z + ", cachedItem=" + memoryCacheItem;
                }
            }, 28, null);
            memoryCacheItem2.close();
        }
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public MemoryCacheItem getCache(CacheIdentifier key, boolean enableRequestReuse) {
        if (key != null) {
            return get(key);
        }
        return null;
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public MemoryCacheItem removeCache(CacheIdentifier key) {
        MemoryCacheItem remove;
        if (key == null || (remove = remove(key)) == null) {
            return null;
        }
        remove.close();
        return remove;
    }
}
