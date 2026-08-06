package com.facebook.cache.disk;

import android.content.Context;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.SecureHashUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TTDiskStorageCache implements TTFileCache, DiskTrimmable {
    private static final String SHARED_PREFS_FILENAME_PREFIX = "disk_entries_list";
    public static final int START_OF_VERSIONING = 1;
    private static final double TRIMMING_LOWER_BOUND = 0.02d;
    private static final long UNINITIALIZED = -1;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private long mCacheSizeLimit;
    private final long mCacheSizeLimitMinimum;
    private final Clock mClock;
    private final long mDefaultCacheSizeLimit;
    private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final long mLowDiskSpaceCacheSizeLimit;
    final Set<String> mResourceIndex;
    private final DiskStorage mStorage;
    final Set<String> mTempResourceIndex;
    private static final Class<?> TAG = TTDiskStorageCache.class;
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2);
    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30);
    private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private final Object mLock = new Object();
    private final StatFsHelper mStatFsHelper = StatFsHelper.getInstance();
    private long mCacheSizeLastUpdateTime = UNINITIALIZED;
    private final DiskStorageCache.CacheStats mCacheStats = new DiskStorageCache.CacheStats();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static class CacheStats {
        private boolean mInitialized = false;
        private long mSize = TTDiskStorageCache.UNINITIALIZED;
        private long mCount = TTDiskStorageCache.UNINITIALIZED;

        CacheStats() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.mCount = TTDiskStorageCache.UNINITIALIZED;
            this.mSize = TTDiskStorageCache.UNINITIALIZED;
        }

        public synchronized void set(long j, long j2) {
            this.mCount = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void increment(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.mCount += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.mCount;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    public TTDiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, DiskStorageCache.Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, DiskTrimmableRegistry diskTrimmableRegistry, final Context context) {
        this.mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        this.mDefaultCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mStorage = diskStorage;
        this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        this.mCacheEventListener = cacheEventListener;
        this.mCacheSizeLimitMinimum = params.mCacheSizeLimitMinimum;
        this.mCacheErrorLogger = cacheErrorLogger;
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        this.mClock = SystemClock.get();
        this.mResourceIndex = new HashSet();
        this.mTempResourceIndex = new HashSet();
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.facebook.cache.disk.TTDiskStorageCache.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TTDiskStorageCache.this.mLock) {
                    TTDiskStorageCache.this.maybeUpdateFileCacheSize();
                    TTDiskStorageCache.maybeDeleteSharedPreferencesFile(context, TTDiskStorageCache.this.mStorage.getStorageName());
                }
                TTDiskStorageCache.this.mCountDownLatch.countDown();
            }
        });
    }

    @Override // com.facebook.cache.disk.FileCache
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        return this.mStorage.getDumpInfo();
    }

    @Override // com.facebook.cache.disk.FileCache
    public Map<String, String> getResourceConfig(CacheKey cacheKey) throws IOException {
        List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
        Map<String, String> map = null;
        for (int i = 0; i < resourceIds.size(); i++) {
            map = this.mStorage.getResourceConfig(resourceIds.get(i), cacheKey);
            if (map != null) {
                break;
            }
        }
        return map;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean isEnabled() {
        return this.mStorage.isEnabled();
    }

    protected void awaitIndex() {
        try {
            this.mCountDownLatch.await();
        } catch (InterruptedException unused) {
            FLog.m438e(TAG, "Memory Index is not ready yet. ");
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource getResource(CacheKey cacheKey) {
        BinaryResource binaryResource;
        SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
        try {
            synchronized (this.mLock) {
                List<String> resourceIds = getResourceIds(cacheKey);
                String str = null;
                binaryResource = null;
                for (int i = 0; i < resourceIds.size(); i++) {
                    str = resourceIds.get(i);
                    cacheKey2.setResourceId(str);
                    binaryResource = this.mStorage.getResource(str, cacheKey);
                    if (binaryResource != null) {
                        break;
                    }
                }
                if (binaryResource == null) {
                    this.mCacheEventListener.onMiss(cacheKey2);
                    this.mResourceIndex.remove(str);
                } else {
                    this.mCacheEventListener.onHit(cacheKey2);
                    this.mResourceIndex.add(str);
                    DiskCacheUtil.updateDiskCacheVisitCount(str);
                }
            }
            return binaryResource;
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e);
            cacheKey2.setException(e);
            this.mCacheEventListener.onReadException(cacheKey2);
            return null;
        }
    }

    @Override // com.facebook.cache.disk.TTFileCache
    public BinaryResource getTempResource(CacheKey cacheKey) {
        BinaryResource binaryResource;
        try {
            synchronized (this.mLock) {
                List<String> resourceIds = getResourceIds(cacheKey);
                String str = null;
                binaryResource = null;
                for (int i = 0; i < resourceIds.size(); i++) {
                    str = resourceIds.get(i);
                    DiskStorage diskStorage = this.mStorage;
                    if (diskStorage instanceof TTDiskStorage) {
                        binaryResource = ((TTDiskStorage) diskStorage).getTempResource(str, cacheKey);
                    }
                    if (binaryResource != null) {
                        break;
                    }
                }
                if (binaryResource == null) {
                    this.mTempResourceIndex.remove(str);
                } else {
                    this.mTempResourceIndex.add(str);
                }
            }
            return binaryResource;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean probe(CacheKey cacheKey) {
        String str;
        IOException e;
        String str2 = null;
        try {
            try {
                synchronized (this.mLock) {
                    try {
                        List<String> resourceIds = getResourceIds(cacheKey);
                        int i = 0;
                        while (i < resourceIds.size()) {
                            String str3 = resourceIds.get(i);
                            if (this.mStorage.touch(str3, cacheKey)) {
                                this.mResourceIndex.add(str3);
                                return true;
                            }
                            i++;
                            str2 = str3;
                        }
                        return false;
                    } catch (Throwable th) {
                        str = str2;
                        th = th;
                        try {
                            throw th;
                        } catch (IOException e2) {
                            e = e2;
                            this.mCacheEventListener.onReadException(SettableCacheEvent.obtain().setCacheKey(cacheKey).setResourceId(str).setException(e));
                            return false;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            str = null;
            e = e3;
        }
    }

    private DiskStorage.Inserter startInsert(String str, CacheKey cacheKey) throws IOException {
        maybeEvictFilesInCacheDir();
        return this.mStorage.insert(str, cacheKey);
    }

    private DiskStorage.Inserter startTempInsert(String str, CacheKey cacheKey, int i) throws IOException {
        maybeEvictFilesInCacheDir();
        DiskStorage diskStorage = this.mStorage;
        if (diskStorage instanceof TTDiskStorage) {
            return ((TTDiskStorage) diskStorage).insertTemp(str, i, cacheKey);
        }
        return null;
    }

    private BinaryResource endInsert(DiskStorage.Inserter inserter, CacheKey cacheKey, String str) throws IOException {
        BinaryResource commit;
        synchronized (this.mLock) {
            commit = inserter.commit(cacheKey);
            this.mResourceIndex.add(str);
            this.mCacheStats.increment(commit.size(), 1L);
            DiskCacheUtil.newDiskCacheVisitCount(str);
        }
        return commit;
    }

    public BinaryResource insertTempSync(CacheKey cacheKey, WriterCallback writerCallback, int i, boolean z) throws IOException {
        String firstResourceId;
        synchronized (this.mLock) {
            firstResourceId = getFirstResourceId(cacheKey);
        }
        try {
            DiskStorage.Inserter startTempInsert = startTempInsert(firstResourceId, cacheKey, i);
            if (startTempInsert == null) {
                return null;
            }
            startTempInsert.writeData(writerCallback, cacheKey);
            if (z) {
                return endInsert(startTempInsert, cacheKey, firstResourceId);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String firstResourceId;
        SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
        this.mCacheEventListener.onWriteAttempt(cacheKey2);
        synchronized (this.mLock) {
            firstResourceId = getFirstResourceId(cacheKey);
        }
        cacheKey2.setResourceId(firstResourceId);
        try {
            DiskStorage.Inserter startInsert = startInsert(firstResourceId, cacheKey);
            try {
                startInsert.writeData(writerCallback, cacheKey);
                BinaryResource endInsert = endInsert(startInsert, cacheKey, firstResourceId);
                cacheKey2.setItemSize(endInsert.size()).setCacheSize(this.mCacheStats.getSize());
                this.mCacheEventListener.onWriteSuccess(cacheKey2);
                return endInsert;
            } finally {
                if (!startInsert.cleanUp()) {
                    FLog.m438e(TAG, "Failed to delete temp file");
                }
            }
        } catch (IOException e) {
            cacheKey2.setException(e);
            this.mCacheEventListener.onWriteException(cacheKey2);
            FLog.m439e(TAG, "Failed inserting a file into the cache", e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void remove(CacheKey cacheKey) {
        synchronized (this.mLock) {
            try {
                List<String> resourceIds = getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    this.mStorage.remove(str);
                    this.mResourceIndex.remove(str);
                }
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + e.getMessage(), e);
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long clearOldEntries(long j) {
        long j2;
        long j3;
        long j4;
        synchronized (this.mLock) {
            try {
                long now = this.mClock.now();
                Collection<DiskStorage.Entry> entries = this.mStorage.getEntries();
                long size = this.mCacheStats.getSize();
                int i = 0;
                long j5 = 0;
                j3 = 0;
                for (DiskStorage.Entry entry : entries) {
                    try {
                        long j6 = now;
                        long max = Math.max(1L, Math.abs(now - entry.getTimestamp()));
                        if (max >= j) {
                            long remove = this.mStorage.remove(entry);
                            this.mResourceIndex.remove(entry.getId());
                            if (remove > 0) {
                                i++;
                                j5 += remove;
                                j4 = j6;
                                this.mCacheEventListener.onEviction(SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(remove).setCacheSize(size - j5));
                            } else {
                                j4 = j6;
                            }
                        } else {
                            j4 = j6;
                            j3 = Math.max(j3, max);
                        }
                        now = j4;
                    } catch (IOException e) {
                        e = e;
                        j2 = j3;
                        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
                        j3 = j2;
                        return j3;
                    }
                }
                this.mStorage.purgeUnexpectedResources();
                if (i > 0) {
                    maybeUpdateFileCacheSize();
                    this.mCacheStats.increment(-j5, -i);
                }
            } catch (IOException e2) {
                e = e2;
                j2 = 0;
            }
        }
        return j3;
    }

    private void maybeEvictFilesInCacheDir() throws IOException {
        synchronized (this.mLock) {
            boolean maybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.mCacheStats.getSize();
            if (size > this.mCacheSizeLimit && !maybeUpdateFileCacheSize) {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            long j = this.mCacheSizeLimit;
            if (size > j) {
                evictAboveSize((j * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    private void evictAboveSize(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        try {
            Collection<DiskStorage.Entry> sortedEntries = getSortedEntries(this.mStorage.getEntries());
            long size = this.mCacheStats.getSize();
            long j2 = size - j;
            int i = 0;
            long j3 = 0;
            for (DiskStorage.Entry entry : sortedEntries) {
                if (j3 > j2) {
                    break;
                }
                long remove = this.mStorage.remove(entry);
                this.mResourceIndex.remove(entry.getId());
                if (remove > 0) {
                    i++;
                    j3 += remove;
                    this.mCacheEventListener.onEviction(SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(evictionReason).setItemSize(remove).setCacheSize(size - j3).setCacheLimit(j));
                }
            }
            this.mCacheStats.increment(-j3, -i);
            this.mStorage.purgeUnexpectedResources();
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> collection) {
        long now = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (DiskStorage.Entry entry : collection) {
            if (entry.getTimestamp() > now) {
                arrayList.add(entry);
            } else {
                arrayList2.add(entry);
            }
        }
        Collections.sort(arrayList2, this.mEntryEvictionComparatorSupplier.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private Collection<DiskStorage.Entry> getCanClearEntriesByTimestamp(Collection<DiskStorage.Entry> collection, long j) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (DiskStorage.Entry entry : collection) {
            if (entry.getTimestamp() < j) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    private void updateFileCacheSizeLimit() {
        if (this.mStatFsHelper.testLowDiskSpace(this.mStorage.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize())) {
            this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
        } else {
            this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getSize() {
        return this.mCacheStats.getSize();
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getCount() {
        return this.mCacheStats.getCount();
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        synchronized (this.mLock) {
            try {
                this.mStorage.clearAll();
                this.mResourceIndex.clear();
                DiskCacheUtil.clearDiskCacheVisitCountMap();
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + e.getMessage(), e);
            }
            this.mCacheStats.reset();
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearByPercentage(Double d) {
        synchronized (this.mLock) {
            boolean maybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.mCacheStats.getSize();
            if (size > this.mCacheSizeLimit && !maybeUpdateFileCacheSize) {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            if (size > ((int) (this.mCacheSizeLimit * (1.0d - d.doubleValue())))) {
                try {
                    evictAboveSize((long) (this.mCacheSizeLimit * (1.0d - d.doubleValue())), CacheEventListener.EvictionReason.USER_FORCED);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearByTimestamp(long j) {
        synchronized (this.mLock) {
            try {
                try {
                    Collection<DiskStorage.Entry> canClearEntriesByTimestamp = getCanClearEntriesByTimestamp(this.mStorage.getEntries(), j);
                    long size = this.mCacheStats.getSize();
                    try {
                        int i = 0;
                        long j2 = 0;
                        for (DiskStorage.Entry entry : canClearEntriesByTimestamp) {
                            long remove = this.mStorage.remove(entry);
                            this.mResourceIndex.remove(entry.getId());
                            this.mStorage.removeConfig(entry.getId());
                            if (remove > 0) {
                                i++;
                                j2 += remove;
                                SettableCacheEvent cacheSize = SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(CacheEventListener.EvictionReason.USER_FORCED).setItemSize(remove).setCacheSize(size - j2);
                                this.mCacheEventListener.onEviction(cacheSize);
                                cacheSize.recycle();
                            }
                        }
                        this.mCacheStats.increment(-j2, -i);
                        this.mStorage.purgeUnexpectedResources();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e2.getMessage(), e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKeySync(CacheKey cacheKey) {
        synchronized (this.mLock) {
            List<String> resourceIds = getResourceIds(cacheKey);
            for (int i = 0; i < resourceIds.size(); i++) {
                if (this.mResourceIndex.contains(resourceIds.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKey(CacheKey cacheKey) {
        synchronized (this.mLock) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                List<String> resourceIds = getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    if (this.mStorage.contains(str, cacheKey)) {
                        this.mResourceIndex.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToMinimum() {
        synchronized (this.mLock) {
            maybeUpdateFileCacheSize();
            long size = this.mCacheStats.getSize();
            long j = this.mCacheSizeLimitMinimum;
            if (j > 0 && size > 0 && size >= j) {
                double d = 1.0d - (j / size);
                if (d > TRIMMING_LOWER_BOUND) {
                    trimBy(d);
                }
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToNothing() {
        clearAll();
    }

    private void trimBy(double d) {
        synchronized (this.mLock) {
            try {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
                long size = this.mCacheStats.getSize();
                evictAboveSize(size - ((long) (d * size)), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + e.getMessage(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeUpdateFileCacheSize() {
        long now = this.mClock.now();
        if (this.mCacheStats.isInitialized()) {
            long j = this.mCacheSizeLastUpdateTime;
            if (j != UNINITIALIZED && now - j <= FILECACHE_SIZE_UPDATE_PERIOD_MS) {
                return false;
            }
        }
        maybeUpdateFileCacheSizeAndIndex();
        this.mCacheSizeLastUpdateTime = now;
        return true;
    }

    private void maybeUpdateFileCacheSizeAndIndex() {
        Set<String> hashSet;
        long j;
        long now = this.mClock.now();
        long j2 = FUTURE_TIMESTAMP_THRESHOLD_MS + now;
        if (this.mResourceIndex.isEmpty()) {
            hashSet = this.mResourceIndex;
        } else {
            hashSet = new HashSet<>();
        }
        try {
            long j3 = 0;
            boolean z = false;
            int i = 0;
            long j4 = -1;
            int i2 = 0;
            int i3 = 0;
            for (DiskStorage.Entry entry : this.mStorage.getEntries()) {
                i2++;
                j3 += entry.getSize();
                if (entry.getTimestamp() > j2) {
                    i3++;
                    j = j2;
                    int size = (int) (i + entry.getSize());
                    j4 = Math.max(entry.getTimestamp() - now, j4);
                    i = size;
                    z = true;
                } else {
                    j = j2;
                    hashSet.add(entry.getId());
                }
                j2 = j;
            }
            if (z) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + i3 + " files , with a total size of " + i + " bytes, and a maximum time delta of " + j4 + "ms", null);
            }
            long j5 = i2;
            if (this.mCacheStats.getCount() == j5 && this.mCacheStats.getSize() == j3) {
                return;
            }
            Set<String> set = this.mResourceIndex;
            if (set != hashSet) {
                set.clear();
                this.mResourceIndex.addAll(hashSet);
            }
            this.mCacheStats.set(j3, j5);
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e.getMessage(), e);
        }
    }

    private static List<String> getResourceIds(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                List<CacheKey> cacheKeys = ((MultiCacheKey) cacheKey).getCacheKeys();
                ArrayList arrayList = new ArrayList(cacheKeys.size());
                for (int i = 0; i < cacheKeys.size(); i++) {
                    arrayList.add(secureHashKey(cacheKeys.get(i)));
                }
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(secureHashKey(cacheKey));
            return arrayList2;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    static String getFirstResourceId(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                return secureHashKey(((MultiCacheKey) cacheKey).getCacheKeys().get(0));
            }
            return secureHashKey(cacheKey);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String secureHashKey(CacheKey cacheKey) throws UnsupportedEncodingException {
        return SecureHashUtil.makeSHA1HashBase64(cacheKey.toString().getBytes(Utf8Charset.NAME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void maybeDeleteSharedPreferencesFile(Context context, String str) {
        File file = new File((context.getApplicationContext().getFilesDir().getParent() + File.separator + "shared_prefs" + File.separator + SHARED_PREFS_FILENAME_PREFIX + str) + ".xml");
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
            FLog.m438e(TAG, "Fail to delete SharedPreference from file system. ");
        }
    }
}
