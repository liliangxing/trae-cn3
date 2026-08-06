package com.bytedance.ies.bullet.preloadv2.cache;

import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import kotlin.Metadata;

/* compiled from: PreloadCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/TemplateMemCache;", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadCache;", "()V", "generateLruCache", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadLruCache;", "size", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TemplateMemCache extends PreloadCache {
    public static final TemplateMemCache INSTANCE = new TemplateMemCache();

    private TemplateMemCache() {
        super(PreloadV2.INSTANCE.getTemplateSize());
    }

    @Override // com.bytedance.ies.bullet.preloadv2.cache.PreloadCache
    public PreloadLruCache generateLruCache(int size) {
        if (size <= 0) {
            size = 10;
        }
        return new PreloadLruCache("模版缓存池", size);
    }
}
