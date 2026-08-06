package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface FileCacheFactory {
    FileCache get(DiskCacheConfig diskCacheConfig);
}
