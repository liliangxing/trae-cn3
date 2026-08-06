package com.bytedance.ies.bullet.preloadv2.cache;

import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreloadCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/HighSubResourceMemCache;", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadCache;", "()V", "generateLruCache", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadLruCache;", "size", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HighSubResourceMemCache extends PreloadCache {
    public static final HighSubResourceMemCache INSTANCE = new HighSubResourceMemCache();

    private HighSubResourceMemCache() {
        super(PreloadV2.INSTANCE.getSubResMemSize());
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadCache
    public PreloadLruCache generateLruCache(final int size) {
        if (size <= 0) {
            size = 10485760;
        }
        return new PreloadLruCache(size) { // from class: com.bytedance.ies.bullet.preloadv2.cache.HighSubResourceMemCache$generateLruCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, PreloadItem value) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.bytedance.ies.bullet.preloadv2.cache.PreloadItem");
                return value.getSize();
            }
        };
    }
}
