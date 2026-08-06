package com.bytedance.geckox.clean.cache;

import java.io.File;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public abstract class CachePolicy {
    protected List<String> mAccessKeys;
    protected CacheConfig mConfig;
    protected File mRootDir;
    public static final CachePolicy NONE = new EmptyCachePolicy();
    public static final CachePolicy LRU = new LRUCachePolicy();
    public static final CachePolicy FIFO = new FIFOCachePolicy();

    public abstract void append();

    public abstract void visit(String str);

    public void attach(CacheConfig cacheConfig, File file, List<String> list) {
        this.mConfig = cacheConfig;
        this.mRootDir = file;
        this.mAccessKeys = list;
    }
}
