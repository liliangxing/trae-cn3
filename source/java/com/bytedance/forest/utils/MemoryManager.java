package com.bytedance.forest.utils;

import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.InMemoryBuffer;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.IESGurdObserver;
import com.bytedance.iesgurd.IESGurdObserverAccessInfo;
import com.bytedance.iesgurd.IESGurdObserverCleanInfo;
import com.bytedance.iesgurd.IESGurdObserverUpdateInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/forest/utils/MemoryManager;", "Lcom/bytedance/forest/utils/IResourcePool;", "maxNormalSize", "", "maxPreloadSize", "(II)V", "normalPool", "Lcom/bytedance/forest/utils/ResourcePool;", "preloadPool", "type", "Lcom/bytedance/forest/utils/PoolType;", "getType", "()Lcom/bytedance/forest/utils/PoolType;", "clearAllCache", "", "getCache", "Lcom/bytedance/forest/utils/MemoryCacheItem;", Api.KEY_ENCRYPT_RESP_KEY, "Lcom/bytedance/forest/utils/CacheIdentifier;", "enableRequestReuse", "", "hasCache", "removeCache", "updateCache", "item", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MemoryManager implements IResourcePool {
    public static final String TAG = "MemoryManager";
    private final ResourcePool normalPool;
    private final ResourcePool preloadPool;
    private final PoolType type = PoolType.Manger;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, CopyOnWriteArrayList<GeckoChannelExpireObserver>> geckoObservers = new HashMap<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PoolType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PoolType.Preload.ordinal()] = 1;
            iArr[PoolType.Normal.ordinal()] = 2;
            iArr[PoolType.Manger.ordinal()] = 3;
        }
    }

    public MemoryManager(int i, int i2) {
        this.normalPool = new ResourcePool(i, PoolType.Normal);
        this.preloadPool = new ResourcePool(i2, PoolType.Preload);
    }

    /* compiled from: MemoryManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/forest/utils/MemoryManager$Companion;", "", "()V", "TAG", "", "geckoObservers", "Ljava/util/HashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/forest/utils/GeckoChannelExpireObserver;", "Lkotlin/collections/HashMap;", "registerGeckoExpireObserver", "cacheItem", "Lcom/bytedance/forest/utils/MemoryCacheItem;", "registerGeckoExpireObserver$forest_release", "unRegisterGeckoExpireObserver", "", "observer", "unRegisterGeckoExpireObserver$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GeckoChannelExpireObserver registerGeckoExpireObserver$forest_release(MemoryCacheItem cacheItem) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            Intrinsics.checkParameterIsNotNull(cacheItem, "cacheItem");
            if (cacheItem.getResponse().getRequest().getGeckoModel().getAccessKey().length() == 0) {
                return null;
            }
            if (cacheItem.getResponse().getRequest().getGeckoModel().getChannel().length() == 0) {
                return null;
            }
            GeckoChannelExpireObserver geckoChannelExpireObserver = new GeckoChannelExpireObserver(cacheItem);
            synchronized (MemoryManager.geckoObservers) {
                copyOnWriteArrayList = (CopyOnWriteArrayList) MemoryManager.geckoObservers.get(geckoChannelExpireObserver.getObserveKey());
                if (copyOnWriteArrayList == null) {
                    Companion companion = MemoryManager.INSTANCE;
                    copyOnWriteArrayList = new CopyOnWriteArrayList();
                    MemoryManager.geckoObservers.put(geckoChannelExpireObserver.getObserveKey(), copyOnWriteArrayList);
                }
            }
            Intrinsics.checkExpressionValueIsNotNull(copyOnWriteArrayList, "synchronized(geckoObserv…          }\n            }");
            copyOnWriteArrayList.add(geckoChannelExpireObserver);
            return geckoChannelExpireObserver;
        }

        public final void unRegisterGeckoExpireObserver$forest_release(GeckoChannelExpireObserver observer) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            synchronized (MemoryManager.geckoObservers) {
                copyOnWriteArrayList = (CopyOnWriteArrayList) MemoryManager.geckoObservers.get(observer.getObserveKey());
            }
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(observer);
            }
        }
    }

    static {
        IESGurdKit.INSTANCE.addObserver("forest-monitor", new IESGurdObserver() { // from class: com.bytedance.forest.utils.MemoryManager.Companion.1
            public void onResAccess(IESGurdObserverAccessInfo iESGurdObserverAccessInfo) {
                Intrinsics.checkParameterIsNotNull(iESGurdObserverAccessInfo, "info");
                IESGurdObserver.DefaultImpls.onResAccess(this, iESGurdObserverAccessInfo);
            }

            public void onResUpdate(IESGurdObserverUpdateInfo iESGurdObserverUpdateInfo) {
                Intrinsics.checkParameterIsNotNull(iESGurdObserverUpdateInfo, "info");
                IESGurdObserver.DefaultImpls.onResUpdate(this, iESGurdObserverUpdateInfo);
            }

            public void onResClean(IESGurdObserverCleanInfo info) {
                CopyOnWriteArrayList copyOnWriteArrayList;
                Intrinsics.checkParameterIsNotNull(info, "info");
                String buildObserveKey = GeckoChannelExpireObserver.INSTANCE.buildObserveKey(info.getAccessKey(), info.getChannel());
                synchronized (MemoryManager.geckoObservers) {
                    copyOnWriteArrayList = (CopyOnWriteArrayList) MemoryManager.geckoObservers.remove(buildObserveKey);
                }
                if (copyOnWriteArrayList != null) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((GeckoChannelExpireObserver) it.next()).onResClean(info);
                    }
                }
            }
        });
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public PoolType getType() {
        return this.type;
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public void updateCache(MemoryCacheItem item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (item.getResponse().getRequest().getIsPreload()) {
            this.preloadPool.updateCache(item);
        } else {
            this.normalPool.updateCache(item);
        }
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public MemoryCacheItem getCache(CacheIdentifier key, boolean enableRequestReuse) {
        final MemoryCacheItem removeCache;
        InMemoryBuffer buffer;
        if (key == null) {
            return null;
        }
        if (enableRequestReuse && (removeCache = this.preloadPool.removeCache(key)) != null && (buffer = removeCache.getBuffer()) != null && buffer.isCacheProvided$forest_release()) {
            ThreadUtils.INSTANCE.runInBackground(new Function0<Unit>() { // from class: com.bytedance.forest.utils.MemoryManager$getCache$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m534invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m534invoke() {
                    ResourcePool resourcePool;
                    resourcePool = MemoryManager.this.normalPool;
                    resourcePool.updateCache(removeCache);
                }
            });
            return removeCache;
        }
        return this.normalPool.getCache(key, enableRequestReuse);
    }

    public final boolean hasCache(CacheIdentifier key, PoolType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (key == null) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return this.preloadPool.hasCache(key);
        }
        if (i == 2) {
            return this.normalPool.hasCache(key);
        }
        if (i == 3) {
            return this.preloadPool.hasCache(key) || this.normalPool.hasCache(key);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public MemoryCacheItem removeCache(CacheIdentifier key) {
        if (key == null) {
            return null;
        }
        MemoryCacheItem removeCache = this.preloadPool.removeCache(key);
        return removeCache != null ? removeCache : this.normalPool.removeCache(key);
    }

    @Override // com.bytedance.forest.utils.IResourcePool
    public void clearAllCache() {
        this.preloadPool.clearAllCache();
        this.normalPool.clearAllCache();
    }
}
