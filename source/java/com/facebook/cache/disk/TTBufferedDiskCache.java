package com.facebook.cache.disk;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.StagingArea;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TTBufferedDiskCache extends BufferedDiskCache {
    private static final Class<?> TAG = TTBufferedDiskCache.class;
    private final FileCache mFileCache;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    private final StagingArea mStagingArea;
    private final Executor mWriteExecutor;

    public TTBufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        super(fileCache, pooledByteBufferFactory, pooledByteStreams, executor, executor2, imageCacheStatsTracker);
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
        this.mStagingArea = StagingArea.getInstance();
    }

    @Override // com.facebook.imagepipeline.cache.BufferedDiskCache
    public Task<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            return foundPinnedImage(cacheKey, encodedImage);
        }
        return getAsync(cacheKey, atomicBoolean, true);
    }

    public Task<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean, boolean z) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            return foundPinnedImage(cacheKey, encodedImage);
        }
        return getAsync(cacheKey, atomicBoolean, z);
    }

    private Task<EncodedImage> getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean, final boolean z) {
        try {
            return Task.call(new Callable<EncodedImage>() { // from class: com.facebook.cache.disk.TTBufferedDiskCache.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public EncodedImage call() throws Exception {
                    if (!atomicBoolean.get()) {
                        EncodedImage encodedImage = TTBufferedDiskCache.this.mStagingArea.get(cacheKey);
                        if (encodedImage != null) {
                            FLog.m463v((Class<?>) TTBufferedDiskCache.TAG, "Found image for %s in staging area", cacheKey.toString());
                            TTBufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
                        } else {
                            FLog.m463v((Class<?>) TTBufferedDiskCache.TAG, "Did not find image for %s in staging area", cacheKey.toString());
                            TTBufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss();
                            try {
                                PooledByteBuffer readFromDiskCache = TTBufferedDiskCache.this.readFromDiskCache(cacheKey);
                                if (readFromDiskCache == null && !z) {
                                    PooledByteBuffer readTempFromDiskCache = TTBufferedDiskCache.this.readTempFromDiskCache(cacheKey);
                                    if (readTempFromDiskCache == null) {
                                        return encodedImage;
                                    }
                                    CloseableReference m496of = CloseableReference.m496of(readTempFromDiskCache);
                                    try {
                                        TempEncodedImage tempEncodedImage = new TempEncodedImage((CloseableReference<PooledByteBuffer>) m496of);
                                        CloseableReference.closeSafely((CloseableReference<?>) m496of);
                                        return tempEncodedImage;
                                    } finally {
                                    }
                                }
                                try {
                                    encodedImage = new EncodedImage((CloseableReference<PooledByteBuffer>) CloseableReference.m496of(readFromDiskCache));
                                } finally {
                                }
                            } catch (Exception unused) {
                                return null;
                            }
                            return null;
                        }
                        if (!Thread.interrupted()) {
                            return encodedImage;
                        }
                        FLog.m462v((Class<?>) TTBufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                        if (encodedImage != null) {
                            encodedImage.close();
                        }
                        throw new InterruptedException();
                    }
                    throw new CancellationException();
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.m481w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.toString());
            return Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws IOException {
        try {
            Class<?> cls = TAG;
            FLog.m463v(cls, "Disk cache read for %s", cacheKey.toString());
            BinaryResource resource = this.mFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.m463v(cls, "Disk cache miss for %s", cacheKey.toString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.m463v(cls, "Found entry in disk cache for %s", cacheKey.toString());
            this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
            InputStream openStream = resource.openStream();
            try {
                PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size());
                openStream.close();
                FLog.m463v(cls, "Successful read from disk cache for %s", cacheKey.toString());
                return newByteBuffer;
            } catch (Throwable th) {
                openStream.close();
                throw th;
            }
        } catch (IOException e) {
            FLog.m481w(TAG, e, "Exception reading from cache for %s", cacheKey.toString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer readTempFromDiskCache(CacheKey cacheKey) {
        try {
            Class<?> cls = TAG;
            FLog.m463v(cls, "Disk temp file cache read for %s", cacheKey.toString());
            FileCache fileCache = this.mFileCache;
            if (!(fileCache instanceof TTFileCache)) {
                return null;
            }
            BinaryResource tempResource = ((TTFileCache) fileCache).getTempResource(cacheKey);
            if (tempResource == null) {
                FLog.m463v(cls, "Disk temp file cache miss for %s", cacheKey.toString());
                return null;
            }
            FLog.m463v(cls, "Found temp file entry in disk cache for %s", cacheKey.toString());
            InputStream openStream = tempResource.openStream();
            try {
                PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) tempResource.size());
                openStream.close();
                FLog.m463v(cls, "Successful read temp file from disk cache for %s", cacheKey.toString());
                return newByteBuffer;
            } catch (Throwable th) {
                openStream.close();
                throw th;
            }
        } catch (IOException e) {
            FLog.m481w(TAG, e, "Exception reading temp file from cache for %s", cacheKey.toString());
            return null;
        }
    }

    private Task<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.m463v(TAG, "Found image for %s in staging area", cacheKey.toString());
        this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
        return Task.forResult(encodedImage);
    }

    public void putTempSync(CacheKey cacheKey, TempEncodedImage tempEncodedImage, boolean z) {
        if (z) {
            this.mStagingArea.put(cacheKey, tempEncodedImage);
        }
        try {
            Preconditions.checkNotNull(cacheKey);
            Preconditions.checkArgument(EncodedImage.isValid(tempEncodedImage));
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(tempEncodedImage);
            try {
                try {
                    writeTempToDiskCache(cacheKey, cloneOrNull, tempEncodedImage.getOffset(), z);
                    EncodedImage.closeSafely(cloneOrNull);
                } catch (Throwable th) {
                    EncodedImage.closeSafely(cloneOrNull);
                    throw th;
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            if (z) {
                this.mStagingArea.remove(cacheKey, tempEncodedImage);
            }
            EncodedImage.closeSafely(null);
        }
    }

    private void writeTempToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage, final int i, boolean z) {
        Class<?> cls = TAG;
        FLog.m463v(cls, "About to write temp file to disk-cache for key %s", cacheKey.toString());
        try {
            FileCache fileCache = this.mFileCache;
            if (fileCache instanceof TTDiskStorageCache) {
                ((TTDiskStorageCache) fileCache).insertTempSync(cacheKey, new WriterCallback() { // from class: com.facebook.cache.disk.TTBufferedDiskCache.2
                    @Override // com.facebook.cache.common.WriterCallback
                    public void write(OutputStream outputStream) throws IOException {
                        InputStream inputStream = encodedImage.getInputStream();
                        if (inputStream != null) {
                            inputStream.skip(i);
                        }
                        TTBufferedDiskCache.this.mPooledByteStreams.copy(inputStream, outputStream);
                    }
                }, i, z);
            }
            FLog.m463v(cls, "Successful disk-cache write temp file for key %s", cacheKey.toString());
        } catch (IOException e) {
            FLog.m481w(TAG, e, "Failed to write temp file to disk-cache for key %s", cacheKey.toString());
        }
    }
}
