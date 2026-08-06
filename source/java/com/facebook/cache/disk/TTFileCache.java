package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;

/* loaded from: classes6.dex */
public interface TTFileCache extends FileCache {
    BinaryResource getTempResource(CacheKey cacheKey);
}
