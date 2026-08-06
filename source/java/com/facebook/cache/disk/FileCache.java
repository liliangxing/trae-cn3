package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes6.dex */
public interface FileCache extends DiskTrimmable {
    void clearAll();

    void clearByPercentage(Double d);

    void clearByTimestamp(long j);

    long clearOldEntries(long j);

    long getCount();

    DiskStorage.DiskDumpInfo getDumpInfo() throws IOException;

    BinaryResource getResource(CacheKey cacheKey);

    Map<String, String> getResourceConfig(CacheKey cacheKey) throws IOException;

    long getSize();

    boolean hasKey(CacheKey cacheKey);

    boolean hasKeySync(CacheKey cacheKey);

    BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException;

    boolean isEnabled();

    boolean probe(CacheKey cacheKey);

    void remove(CacheKey cacheKey);
}
