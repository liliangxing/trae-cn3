package com.bytedance.ies.bullet.service.preload;

import android.app.ActivityManager;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Kt;
import com.bytedance.rts.foundation.Int32;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PreloadMemoryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/PreloadMemoryCache;", "", "lruCacheSize", "", "(I)V", "cacheSize", "getCacheSize", "()I", "mLruCache", "Landroid/util/LruCache;", "", "Lcom/bytedance/ies/bullet/service/preload/Expired;", "maxCacheSize", "getMaxCacheSize", PrefetchRequestConfig.METHOD_GET, "cacheKey", "put", "value", "remove", "trimAll", "", "trimExpired", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadMemoryCache {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MODULE = "BulletImageLruCache";
    private final int lruCacheSize;
    private LruCache<String, Expired> mLruCache;

    public PreloadMemoryCache(int i) {
        this.lruCacheSize = i;
        this.mLruCache = new LruCache<String, Expired>(i) { // from class: com.bytedance.ies.bullet.service.preload.PreloadMemoryCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public void entryRemoved(boolean evicted, String key, Expired oldValue, Expired newValue) {
                super.entryRemoved(evicted, (boolean) key, oldValue, newValue);
                if (oldValue != null) {
                    oldValue.release();
                }
                Log.i(PreloadMemoryCache.MODULE, "BulletImageLruCache entry removed, key = " + key + ", currentSize = " + size() + ", maxCacheSize = " + maxSize());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Expired value) {
                if (value != null) {
                    return (int) value.size();
                }
                return 0;
            }
        };
        Log.d(MODULE, "BulletImageLruCache init, maxCacheSize = " + i);
    }

    public final int getMaxCacheSize() {
        LruCache<String, Expired> lruCache = this.mLruCache;
        if (lruCache != null) {
            return lruCache.maxSize();
        }
        return 0;
    }

    public final int getCacheSize() {
        LruCache<String, Expired> lruCache = this.mLruCache;
        if (lruCache != null) {
            return lruCache.size();
        }
        return 0;
    }

    public final Expired put(String cacheKey, Expired value) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(value, "value");
        LruCache<String, Expired> lruCache = this.mLruCache;
        if (lruCache != null) {
            return lruCache.put(cacheKey, value);
        }
        return null;
    }

    public final Expired get(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        LruCache<String, Expired> lruCache = this.mLruCache;
        if (lruCache != null) {
            return lruCache.get(cacheKey);
        }
        return null;
    }

    public final Expired remove(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        LruCache<String, Expired> lruCache = this.mLruCache;
        if (lruCache != null) {
            return lruCache.remove(cacheKey);
        }
        return null;
    }

    public final synchronized void trimExpired() {
        Set<Map.Entry<String, Expired>> entrySet;
        LruCache<String, Expired> lruCache;
        long currentTimeMillis = System.currentTimeMillis();
        LruCache<String, Expired> lruCache2 = this.mLruCache;
        Map<String, Expired> snapshot = lruCache2 != null ? lruCache2.snapshot() : null;
        if (snapshot != null && (entrySet = snapshot.entrySet()) != null && (r3 = entrySet.iterator()) != null) {
            for (Map.Entry<String, Expired> entry : entrySet) {
                if (entry.getValue().isExpired(currentTimeMillis) && (lruCache = this.mLruCache) != null) {
                    lruCache.remove(entry.getKey());
                }
            }
        }
        if (snapshot != null) {
            snapshot.clear();
        }
    }

    public final synchronized void trimAll() {
        Log.e(MODULE, "evict all lru caches");
        LruCache<String, Expired> lruCache = this.mLruCache;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    /* compiled from: PreloadMemoryCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/PreloadMemoryCache$Companion;", "", "()V", "MODULE", "", "generateMaxCacheSize", "", "application", "Landroid/app/Application;", "makeBitmapCacheKey", "Lcom/facebook/cache/common/CacheKey;", "uri", "Landroid/net/Uri;", "request", "Lcom/facebook/imagepipeline/request/ImageRequest;", "makeDefaultRequest", "lowQuality", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CacheKey makeBitmapCacheKey(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return makeBitmapCacheKey(makeDefaultRequest$default(this, uri, false, 2, null));
        }

        public final CacheKey makeBitmapCacheKey(ImageRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            CacheKey postprocessedBitmapCacheKey = Fresco.getImagePipeline().getCacheKeyFactory().getPostprocessedBitmapCacheKey(request, PreloadMemoryCache.MODULE);
            Intrinsics.checkNotNullExpressionValue(postprocessedBitmapCacheKey, "getImagePipeline().cache… MODULE\n                )");
            return postprocessedBitmapCacheKey;
        }

        public final int generateMaxCacheSize(Application application) {
            int i;
            Intrinsics.checkNotNullParameter(application, "application");
            Object systemService = application.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            int coerceAtMost = RangesKt.coerceAtMost(((ActivityManager) systemService).getMemoryClass() * PreloadV2Kt.M_MEM_SIZE, Int32.MAX_VALUE);
            if (coerceAtMost < 33554432) {
                i = 4194304;
            } else {
                i = coerceAtMost < 67108864 ? 6291456 : coerceAtMost / 4;
            }
            return i / 2;
        }

        public static /* synthetic */ ImageRequest makeDefaultRequest$default(Companion companion, Uri uri, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.makeDefaultRequest(uri, z);
        }

        public final ImageRequest makeDefaultRequest(Uri uri, boolean lowQuality) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(uri);
            newBuilderWithSource.disableMemoryCache();
            Log.i(PreloadMemoryCache.MODULE, "use low quality image RGB565: " + lowQuality);
            if (lowQuality) {
                newBuilderWithSource.setPostprocessor(new BasePostprocessor() { // from class: com.bytedance.ies.bullet.service.preload.PreloadMemoryCache$Companion$makeDefaultRequest$1$1
                    public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
                        CloseableReference closeableReference;
                        Throwable th;
                        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
                        Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
                        try {
                            closeableReference = bitmapFactory.createBitmapInternal(sourceBitmap.getWidth(), sourceBitmap.getHeight(), Bitmap.Config.RGB_565);
                            try {
                                new Canvas((Bitmap) closeableReference.get()).drawBitmap(sourceBitmap, 0.0f, 0.0f, (Paint) null);
                                return CloseableReference.cloneOrNull(closeableReference);
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    Log.e("BulletImageLruCache", "error occur when convert ARGB8888 to RGB565, msg: " + th.getMessage());
                                    CloseableReference.closeSafely(closeableReference);
                                    return super.process(sourceBitmap, bitmapFactory);
                                } finally {
                                    CloseableReference.closeSafely(closeableReference);
                                }
                            }
                        } catch (Throwable th3) {
                            closeableReference = null;
                            th = th3;
                        }
                    }
                });
            }
            ImageRequest build = newBuilderWithSource.build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilderWithSource(uri…  }\n            }.build()");
            return build;
        }
    }
}
