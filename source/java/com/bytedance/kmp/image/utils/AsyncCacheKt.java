package com.bytedance.kmp.image.utils;

import kotlin.Metadata;

/* compiled from: AsyncCache.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0003\" \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"drawableImageCache", "Lcom/bytedance/kmp/image/utils/AsyncCache;", "", "", "getDrawableImageCache", "()Lcom/bytedance/kmp/image/utils/AsyncCache;", "kmpimage_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AsyncCacheKt {
    private static final AsyncCache<String, byte[]> drawableImageCache = new AsyncCache<>();

    public static final AsyncCache<String, byte[]> getDrawableImageCache() {
        return drawableImageCache;
    }
}
