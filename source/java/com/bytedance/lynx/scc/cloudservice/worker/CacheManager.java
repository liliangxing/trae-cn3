package com.bytedance.lynx.scc.cloudservice.worker;

import android.text.TextUtils;
import android.util.LruCache;

/* loaded from: classes4.dex */
public final class CacheManager {
    private static final int CACHE_CAPACITY = 128;
    private final LruCache<String, Boolean> mAllowCache;

    /* loaded from: classes4.dex */
    private static class InstanceHolder {
        private static final CacheManager sInstance = new CacheManager();

        private InstanceHolder() {
        }
    }

    public static CacheManager getInstance() {
        return InstanceHolder.sInstance;
    }

    private CacheManager() {
        this.mAllowCache = new LruCache<>(128);
    }

    public void addAllowUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        synchronized (this) {
            this.mAllowCache.put(url, true);
        }
    }

    public boolean hitAllowUrlCache(String url) {
        boolean z = false;
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        synchronized (this) {
            Boolean bool = this.mAllowCache.get(url);
            if (bool != null && bool.booleanValue()) {
                z = true;
            }
        }
        return z;
    }
}
