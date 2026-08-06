package com.bytedance.lottie.model;

import androidx.collection.LruCache;
import com.bytedance.lottie.LottieComposition;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LottieCompositionCache {
    private static final int CACHE_SIZE_MB = 10;
    private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();
    private final LruCache<String, LottieComposition> cache = new LruCache<>(10485760);

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    LottieCompositionCache() {
    }

    public LottieComposition get(String str) {
        if (str == null) {
            return null;
        }
        return (LottieComposition) this.cache.get(str);
    }

    public void put(String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.cache.put(str, lottieComposition);
    }

    public void clearCache(String str) {
        if (str == null) {
            return;
        }
        this.cache.remove(str);
    }
}
