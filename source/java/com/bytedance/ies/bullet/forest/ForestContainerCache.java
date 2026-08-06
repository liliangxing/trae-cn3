package com.bytedance.ies.bullet.forest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: ForestContainerCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u001f\u0010\f\u001a\u0004\u0018\u00018\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u0004\u0018\u00018\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJF\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006*\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0003R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestContainerCache;", "K", "T", "", "()V", "cache", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "clear", "containerId", "fetchAll", "fetchCache", "key", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putToCache", "", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "getByContainerID", "buildIfNotExists", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestContainerCache<K, T> {
    private final Map<String, ConcurrentHashMap<K, T>> cache = new LinkedHashMap();

    static /* synthetic */ Map getByContainerID$default(ForestContainerCache forestContainerCache, Map map, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return forestContainerCache.getByContainerID(map, str, z);
    }

    private final Map<K, T> getByContainerID(Map<String, ConcurrentHashMap<K, T>> map, String str, boolean z) {
        ConcurrentHashMap<K, T> concurrentHashMap;
        if (str != null) {
            synchronized (map) {
                concurrentHashMap = map.get(str);
                if (z && concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    map.put(str, concurrentHashMap);
                }
            }
        } else {
            concurrentHashMap = null;
        }
        return concurrentHashMap;
    }

    public final Map<K, T> fetchAll(String containerId) {
        return getByContainerID$default(this, this.cache, containerId, false, 2, null);
    }

    public final T fetchCache(String containerId, K key) {
        Map byContainerID$default = getByContainerID$default(this, this.cache, containerId, false, 2, null);
        if (byContainerID$default != null) {
            return (T) byContainerID$default.get(key);
        }
        return null;
    }

    public final void putToCache(String containerId, K key, T value) {
        Map<K, T> byContainerID = getByContainerID(this.cache, containerId, true);
        if (byContainerID != null) {
            byContainerID.put(key, value);
        }
    }

    public final T remove(String containerId, K key) {
        Map byContainerID$default = getByContainerID$default(this, this.cache, containerId, false, 2, null);
        if (byContainerID$default != null) {
            return (T) byContainerID$default.remove(key);
        }
        return null;
    }

    public final ConcurrentHashMap<K, T> clear(String containerId) {
        ConcurrentHashMap<K, T> concurrentHashMap;
        synchronized (this) {
            Map<String, ConcurrentHashMap<K, T>> map = this.cache;
            if (map == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
            concurrentHashMap = (ConcurrentHashMap) TypeIntrinsics.asMutableMap(map).remove(containerId);
        }
        return concurrentHashMap;
    }
}
