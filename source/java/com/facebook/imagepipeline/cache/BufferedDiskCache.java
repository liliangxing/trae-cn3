package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskWrapperCacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BufferedDiskCache {
    private static final Class<?> TAG = BufferedDiskCache.class;
    private final FileCache mFileCache;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    private boolean mNeedEncrypt;
    private boolean mNeedMD5;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    private final StagingArea mStagingArea = StagingArea.getInstance();
    private final Executor mWriteExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    public StagingArea getStagingArea() {
        return this.mStagingArea;
    }

    public boolean containsSync(CacheKey cacheKey) {
        return this.mStagingArea.containsKey(cacheKey) || this.mFileCache.hasKeySync(cacheKey);
    }

    public Task<Boolean> contains(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return Task.forResult(true);
        }
        return containsAsync(cacheKey);
    }

    private Task<Boolean> containsAsync(final CacheKey cacheKey) {
        try {
            return Task.call(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(cacheKey));
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(cacheKey);
    }

    public Task<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        StagingArea mainStagingArea;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#get");
            }
            EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
            if (encodedImage == null && FrescoCacheMonitorUtil.isFallBackMainDisk() && FrescoCacheMonitorUtil.getMainStagingArea() != this.mStagingArea && (mainStagingArea = FrescoCacheMonitorUtil.getMainStagingArea()) != null) {
                encodedImage = mainStagingArea.get(cacheKey);
            }
            if (encodedImage != null) {
                return foundPinnedImage(cacheKey, encodedImage);
            }
            Task<EncodedImage> async = getAsync(cacheKey, atomicBoolean);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return async;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInStagingAreaAndFileCache(CacheKey cacheKey) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.m463v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
            return true;
        }
        FLog.m463v(TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaMiss();
        try {
            return this.mFileCache.hasKey(cacheKey);
        } catch (Exception unused) {
            return false;
        }
    }

    private Task<EncodedImage> getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            return Task.call(new Callable<EncodedImage>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public EncodedImage call() throws Exception {
                    PooledByteBuffer readFromDiskCache;
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("BufferedDiskCache#getAsync");
                        }
                        if (atomicBoolean.get()) {
                            throw new CancellationException();
                        }
                        EncodedImage encodedImage = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                        if (encodedImage == null && FrescoCacheMonitorUtil.isFallBackMainDisk() && FrescoCacheMonitorUtil.getMainStagingArea() != BufferedDiskCache.this.mStagingArea && FrescoCacheMonitorUtil.getMainStagingArea() != null) {
                            encodedImage = FrescoCacheMonitorUtil.getMainStagingArea().get(cacheKey);
                        }
                        if (encodedImage != null) {
                            FLog.m463v((Class<?>) BufferedDiskCache.TAG, "Found image for %s in staging area", cacheKey.getUriString());
                            BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
                        } else {
                            FLog.m463v((Class<?>) BufferedDiskCache.TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
                            BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss();
                            try {
                                Map<String, String> resourceConfig = BufferedDiskCache.this.mFileCache.getResourceConfig(cacheKey);
                                if (BufferedDiskCache.this.mNeedMD5) {
                                    readFromDiskCache = BufferedDiskCache.this.readFromDiskCacheAndCompareMD5(cacheKey, resourceConfig.get(cacheKey.getUriString()));
                                } else {
                                    readFromDiskCache = BufferedDiskCache.this.readFromDiskCache(cacheKey);
                                }
                                if (readFromDiskCache == null && FrescoCacheMonitorUtil.isFallBackMainDisk() && FrescoCacheMonitorUtil.getMainFileCache() != BufferedDiskCache.this.mFileCache && FrescoCacheMonitorUtil.getMainFileCache() != null) {
                                    resourceConfig = FrescoCacheMonitorUtil.getMainFileCache().getResourceConfig(cacheKey);
                                    if (BufferedDiskCache.this.mNeedMD5) {
                                        readFromDiskCache = BufferedDiskCache.this.readFromMainDiskCacheAndCompareMD5(cacheKey, resourceConfig.get(cacheKey.getUriString()));
                                    } else {
                                        readFromDiskCache = BufferedDiskCache.this.readFromMainDiskCache(cacheKey);
                                    }
                                }
                                if (readFromDiskCache == null) {
                                    return null;
                                }
                                CloseableReference m496of = CloseableReference.m496of(readFromDiskCache);
                                try {
                                    EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) m496of);
                                    encodedImage2.setExtraInfo(resourceConfig);
                                    encodedImage = encodedImage2;
                                } finally {
                                    CloseableReference.closeSafely((CloseableReference<?>) m496of);
                                }
                            } catch (Exception unused) {
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.endSection();
                                }
                                return null;
                            }
                        }
                        if (!Thread.interrupted()) {
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return encodedImage;
                        }
                        FLog.m462v((Class<?>) BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                        if (encodedImage != null) {
                            encodedImage.close();
                        }
                        throw new InterruptedException();
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#put");
            }
            Preconditions.checkNotNull(cacheKey);
            Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
            this.mStagingArea.put(cacheKey, encodedImage);
            final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            try {
                if (FrescoCacheMonitorUtil.isDelayWriteDisk() && FrescoCacheMonitorUtil.getNewIoBoundExecutor() != null) {
                    FrescoCacheMonitorUtil.getNewIoBoundExecutor().schedule(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.beginSection("BufferedDiskCache#putAsync");
                                }
                                if (BufferedDiskCache.this.mNeedEncrypt) {
                                    BufferedDiskCache.this.writeToDiskCacheEncrypt(cacheKey, cloneOrNull);
                                } else {
                                    BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
                                }
                            } finally {
                                BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                                EncodedImage.closeSafely(cloneOrNull);
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.endSection();
                                }
                            }
                        }
                    }, FrescoCacheMonitorUtil.getDelayTime(), TimeUnit.MILLISECONDS);
                } else {
                    this.mWriteExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.beginSection("BufferedDiskCache#putAsync");
                                }
                                if (BufferedDiskCache.this.mNeedEncrypt) {
                                    BufferedDiskCache.this.writeToDiskCacheEncrypt(cacheKey, cloneOrNull);
                                } else {
                                    BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
                                }
                            } finally {
                                BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                                EncodedImage.closeSafely(cloneOrNull);
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.endSection();
                                }
                            }
                        }
                    });
                }
            } catch (Exception e) {
                FLog.m481w(TAG, e, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
                this.mStagingArea.remove(cacheKey, encodedImage);
                EncodedImage.closeSafely(cloneOrNull);
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Task<Void> remove(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mStagingArea.remove(cacheKey);
        try {
            return Task.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.5
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("BufferedDiskCache#remove");
                        }
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey);
                        BufferedDiskCache.this.mFileCache.remove(cacheKey);
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public Task<Void> clearAll() {
        this.mStagingArea.clearAll();
        try {
            return Task.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.6
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    BufferedDiskCache.this.mStagingArea.clearAll();
                    BufferedDiskCache.this.mFileCache.clearAll();
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e);
        }
    }

    public Task<Void> clearByPercentage(final Double d) {
        try {
            return Task.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.7
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    BufferedDiskCache.this.mFileCache.clearByPercentage(d);
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.m481w(TAG, e, "clearByPercentage, Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e);
        }
    }

    public Task<Void> clearByTimestamp(final long j) {
        try {
            return Task.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.8
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    BufferedDiskCache.this.mFileCache.clearByTimestamp(j);
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.m481w(TAG, e, "clearByTimestamp, Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e);
        }
    }

    private Task<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.m463v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
        return Task.forResult(encodedImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws Exception {
        try {
            Class<?> cls = TAG;
            FLog.m464v(cls, "Disk cache read for %s needEncrypt = %s", cacheKey.getUriString(), Boolean.valueOf(this.mNeedEncrypt));
            BinaryResource resource = this.mFileCache.getResource(cacheKey);
            PooledByteBuffer pooledByteBuffer = null;
            if (resource == null) {
                FLog.m463v(cls, "Disk cache miss for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.m463v(cls, "Found entry in disk cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
            InputStream openStream = resource.openStream();
            try {
                if (this.mNeedEncrypt) {
                    byte[] decryptBytes = ImageDiskEncryptUtils.decryptBytes(openStream);
                    if (decryptBytes != null) {
                        pooledByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(decryptBytes);
                    }
                } else {
                    pooledByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size());
                }
                openStream.close();
                FLog.m464v(cls, "Successful read from disk cache for %s needEncrypt = %s", cacheKey.getUriString(), Boolean.valueOf(this.mNeedEncrypt));
                return pooledByteBuffer;
            } catch (Throwable th) {
                openStream.close();
                throw th;
            }
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Exception reading from cache for %s needEncrypt = %s", cacheKey.getUriString(), Boolean.valueOf(this.mNeedEncrypt));
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer readFromDiskCacheAndCompareMD5(CacheKey cacheKey, String str) throws IOException {
        try {
            Class<?> cls = TAG;
            FLog.m464v(cls, "Disk cache read for %s, compare to md5:%s", cacheKey.getUriString(), str);
            BinaryResource resource = this.mFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.m463v(cls, "Disk cache miss for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.m463v(cls, "Found entry in disk cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
            InputStream openStream = resource.openStream();
            try {
                PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size(), str);
                if (newByteBuffer == null) {
                    FLog.m463v(cls, "Failed read from disk cache or MD5 did not match for %s", cacheKey.getUriString());
                    this.mImageCacheStatsTracker.onDiskCacheMiss();
                } else {
                    FLog.m463v(cls, "Successful read from disk cache for %s", cacheKey.getUriString());
                    this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
                }
                return newByteBuffer;
            } finally {
                openStream.close();
            }
        } catch (IOException e) {
            FLog.m481w(TAG, e, "Exception reading from cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer readFromMainDiskCache(CacheKey cacheKey) throws Exception {
        try {
            Class<?> cls = TAG;
            FLog.m464v(cls, "fall back main Disk cache read for %s needEncrypt = %s", cacheKey.getUriString(), Boolean.valueOf(this.mNeedEncrypt));
            FileCache mainFileCache = FrescoCacheMonitorUtil.getMainFileCache();
            PooledByteBuffer pooledByteBuffer = null;
            if (mainFileCache == null) {
                return null;
            }
            BinaryResource resource = mainFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.m463v(cls, "Disk cache miss for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.m463v(cls, "Found entry in disk cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
            InputStream openStream = resource.openStream();
            try {
                if (this.mNeedEncrypt) {
                    byte[] decryptBytes = ImageDiskEncryptUtils.decryptBytes(openStream);
                    if (decryptBytes != null) {
                        pooledByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(decryptBytes);
                    }
                } else {
                    pooledByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size());
                }
                openStream.close();
                FLog.m464v(cls, "Successful read from disk cache for %s needEncrypt = %s", cacheKey.getUriString(), Boolean.valueOf(this.mNeedEncrypt));
                return pooledByteBuffer;
            } catch (Throwable th) {
                openStream.close();
                throw th;
            }
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Exception reading from cache for %s needEncrypt = %s", cacheKey.getUriString(), Boolean.valueOf(this.mNeedEncrypt));
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer readFromMainDiskCacheAndCompareMD5(CacheKey cacheKey, String str) throws IOException {
        try {
            Class<?> cls = TAG;
            FLog.m464v(cls, "fall back main Disk cache read for %s, compare to md5:%s", cacheKey.getUriString(), str);
            FileCache mainFileCache = FrescoCacheMonitorUtil.getMainFileCache();
            if (mainFileCache == null) {
                return null;
            }
            BinaryResource resource = mainFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.m463v(cls, "Disk cache miss for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.m463v(cls, "Found entry in disk cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
            InputStream openStream = resource.openStream();
            try {
                PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size(), str);
                if (newByteBuffer == null) {
                    FLog.m463v(cls, "Failed read from disk cache or MD5 did not match for %s", cacheKey.getUriString());
                    this.mImageCacheStatsTracker.onDiskCacheMiss();
                } else {
                    FLog.m463v(cls, "Successful read from disk cache for %s", cacheKey.getUriString());
                    this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
                }
                return newByteBuffer;
            } finally {
                openStream.close();
            }
        } catch (IOException e) {
            FLog.m481w(TAG, e, "Exception reading from cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        }
    }

    public void setNeedMD5(boolean z) {
        this.mNeedMD5 = z;
    }

    public boolean getNeedMD5() {
        return this.mNeedMD5;
    }

    public boolean getNeedEncrypt() {
        return this.mNeedEncrypt;
    }

    public void setNeedEncrypt(boolean z) {
        this.mNeedEncrypt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        Class<?> cls = TAG;
        FLog.m463v(cls, "About to write to disk-cache for key %s", cacheKey.getUriString());
        try {
            this.mFileCache.insert(new DiskWrapperCacheKey(cacheKey, encodedImage.getExtraInfo()), new WriterCallback() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.9
                @Override // com.facebook.cache.common.WriterCallback
                public void write(OutputStream outputStream) throws IOException {
                    BufferedDiskCache.this.mPooledByteStreams.copy(encodedImage.getInputStream(), outputStream);
                }
            });
            FLog.m463v(cls, "Successful disk-cache write for key %s", cacheKey.getUriString());
        } catch (IOException e) {
            FLog.m481w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToDiskCacheEncrypt(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.m463v(TAG, "About to write to disk-cache encrypt for key %s", cacheKey.getUriString());
        EncodedImage encodedImage2 = null;
        try {
            try {
                byte[] encryptByte = ImageDiskEncryptUtils.encryptByte(encodedImage.getInputStream());
                if (encryptByte != null) {
                    EncodedImage encodedImage3 = new EncodedImage((CloseableReference<PooledByteBuffer>) CloseableReference.m496of(this.mPooledByteBufferFactory.newByteBuffer(encryptByte)));
                    try {
                        encodedImage3.copyMetaDataFrom(encodedImage);
                        writeToDiskCache(cacheKey, encodedImage3);
                        encodedImage2 = encodedImage3;
                    } catch (Exception e) {
                        e = e;
                        encodedImage2 = encodedImage3;
                        FLog.m481w(TAG, e, "Failed to write to disk-cache encrypt for key %s", cacheKey.getUriString());
                        EncodedImage.closeSafely(encodedImage2);
                    } catch (Throwable th) {
                        th = th;
                        encodedImage2 = encodedImage3;
                        EncodedImage.closeSafely(encodedImage2);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            EncodedImage.closeSafely(encodedImage2);
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
