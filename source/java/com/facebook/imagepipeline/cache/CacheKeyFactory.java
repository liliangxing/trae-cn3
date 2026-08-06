package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface CacheKeyFactory {
    CacheKey getBitmapCacheKey(ImageRequest imageRequest, Object obj);

    CacheKey getEncodedCacheKey(ImageRequest imageRequest, Uri uri, @Nullable Object obj);

    CacheKey getEncodedCacheKey(ImageRequest imageRequest, @Nullable Object obj);

    CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest, Object obj);

    CacheKey getResizedImageCacheKey(ImageRequest imageRequest, @Nullable Object obj);
}
