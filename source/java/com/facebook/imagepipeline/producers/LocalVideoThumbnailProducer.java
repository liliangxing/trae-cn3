package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Size;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "VideoThumbnailProducer";
    private final ContentResolver mContentResolver;
    private final Executor mDiskWriteExecutor;
    private final Executor mProducerExecutor;

    public LocalVideoThumbnailProducer(Executor executor, Executor executor2, ContentResolver contentResolver) {
        this.mProducerExecutor = executor;
        this.mDiskWriteExecutor = executor2;
        this.mContentResolver = contentResolver;
    }

    public Bitmap getCachedBitmapFromFile(ImageRequest imageRequest) {
        CacheKey encodedCacheKey;
        BinaryResource resource;
        File file;
        try {
            if (imageRequest.isResizedImageDiskCacheActuallyEnabled()) {
                encodedCacheKey = DefaultCacheKeyFactory.getInstance().getResizedImageCacheKey(imageRequest, null);
            } else {
                encodedCacheKey = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(imageRequest, null);
            }
            if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.CUSTOM) {
                FileCache fileCache = ImagePipelineFactory.getInstance().getCustomImageFileCacheMap().get(imageRequest.getCustomCacheName());
                resource = fileCache != null ? fileCache.getResource(encodedCacheKey) : null;
            } else if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
                resource = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(encodedCacheKey);
            } else {
                resource = ImagePipelineFactory.getInstance().getMainFileCache().getResource(encodedCacheKey);
            }
            if ((resource instanceof FileBinaryResource) && (file = ((FileBinaryResource) resource).getFile()) != null && file.exists()) {
                return BitmapFactory.decodeFile(file.getAbsolutePath());
            }
        } catch (Exception e) {
            FLog.m442e(PRODUCER_NAME, "getCachedBitmapFromFile " + e);
        }
        return null;
    }

    public void cacheBitmapToFile(ImageRequest imageRequest, final Bitmap bitmap) {
        CacheKey encodedCacheKey;
        FileCache mainFileCache;
        try {
            final boolean isResizedImageDiskCacheActuallyEnabled = imageRequest.isResizedImageDiskCacheActuallyEnabled();
            if (isResizedImageDiskCacheActuallyEnabled) {
                encodedCacheKey = DefaultCacheKeyFactory.getInstance().getResizedImageCacheKey(imageRequest, null);
            } else {
                encodedCacheKey = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(imageRequest, null);
            }
            if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.CUSTOM) {
                mainFileCache = ImagePipelineFactory.getInstance().getCustomImageFileCacheMap().get(imageRequest.getCustomCacheName());
            } else if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
                mainFileCache = ImagePipelineFactory.getInstance().getSmallImageFileCache();
            } else {
                mainFileCache = ImagePipelineFactory.getInstance().getMainFileCache();
            }
            if (mainFileCache != null) {
                mainFileCache.insert(encodedCacheKey, new WriterCallback() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.1
                    @Override // com.facebook.cache.common.WriterCallback
                    public void write(OutputStream outputStream) throws IOException {
                        bitmap.compress(isResizedImageDiskCacheActuallyEnabled ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, isResizedImageDiskCacheActuallyEnabled ? 85 : 100, outputStream);
                    }
                });
            }
        } catch (Exception e) {
            FLog.m442e(PRODUCER_NAME, "cacheBitmapToFile " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloseableReference<CloseableImage> getResultOld(ImageRequest imageRequest) throws IOException {
        String localFilePath = getLocalFilePath(imageRequest);
        if (localFilePath == null) {
            return null;
        }
        Bitmap cachedBitmapFromFile = getCachedBitmapFromFile(imageRequest);
        if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy() && UriUtil.isLocalContentUri(imageRequest.getSourceUri())) {
            cachedBitmapFromFile = this.mContentResolver.loadThumbnail(imageRequest.getSourceUri(), new Size(imageRequest.getPreferredWidth(), imageRequest.getPreferredHeight()), null);
        }
        if (cachedBitmapFromFile == null) {
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(localFilePath, calculateKind(imageRequest));
            if (createVideoThumbnail == null) {
                return null;
            }
            if (imageRequest.isResizedImageDiskCacheActuallyEnabled() && createVideoThumbnail.getHeight() != 0 && imageRequest.getResizeOptions().height != 0) {
                float width = createVideoThumbnail.getWidth() / createVideoThumbnail.getHeight();
                int i = imageRequest.getResizeOptions().width;
                int i2 = imageRequest.getResizeOptions().height;
                float f = i;
                float f2 = i2;
                if (f / f2 > width) {
                    i2 = (int) (f / width);
                } else {
                    i = (int) (f2 * width);
                }
                createVideoThumbnail = Bitmap.createScaledBitmap(createVideoThumbnail, i, i2, true);
            }
            cachedBitmapFromFile = createVideoThumbnail;
            cacheBitmapToFile(imageRequest, cachedBitmapFromFile);
        }
        return CloseableReference.m496of(new CloseableStaticBitmap(cachedBitmapFromFile, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloseableReference<CloseableImage> getResultNew(final ImageRequest imageRequest) throws IOException {
        Bitmap cachedBitmapFromFile = getCachedBitmapFromFile(imageRequest);
        if (cachedBitmapFromFile != null) {
            FLog.m430d(PRODUCER_NAME, "cacheBitmapReadTask getCachedBitmapFromFile return " + imageRequest);
            return CloseableReference.m496of(new CloseableStaticBitmap(cachedBitmapFromFile, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
        }
        if (FrescoCacheMonitorUtil.isLocalVideoThumbOpt()) {
            String localFilePath = getLocalFilePath(imageRequest);
            if (localFilePath == null) {
                return null;
            }
            FLog.m430d(PRODUCER_NAME, "aboveQThumbnailReadTask ThumbnailUtils.createVideoThumbnail return" + imageRequest);
            Bitmap fetchFirstFrameThumbnail = fetchFirstFrameThumbnail(this.mContentResolver, localFilePath, imageRequest);
            if (fetchFirstFrameThumbnail == null && Build.VERSION.SDK_INT >= 29 && UriUtil.isLocalContentUri(imageRequest.getSourceUri())) {
                try {
                    FLog.m430d(PRODUCER_NAME, "aboveQThumbnailReadTask mContentResolver.loadThumbnail return " + imageRequest);
                    fetchFirstFrameThumbnail = this.mContentResolver.loadThumbnail(imageRequest.getSourceUri(), new Size(imageRequest.getPreferredWidth(), imageRequest.getPreferredHeight()), null);
                } catch (Throwable th) {
                    FLog.m443e(PRODUCER_NAME, "mContentResolver.loadThumbnail " + imageRequest + " error", th);
                }
            }
            if (fetchFirstFrameThumbnail == null) {
                fetchFirstFrameThumbnail = loadBitmapByOldVersion(imageRequest, localFilePath);
            }
            if (fetchFirstFrameThumbnail == null) {
                return null;
            }
            final Bitmap copy = fetchFirstFrameThumbnail.copy(fetchFirstFrameThumbnail.getConfig(), true);
            this.mDiskWriteExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.2
                @Override // java.lang.Runnable
                public void run() {
                    LocalVideoThumbnailProducer.this.writeToDiskCache(imageRequest, copy, "cacheBitmapReadTask cacheBitmapToFile called" + imageRequest);
                }
            });
            return CloseableReference.m496of(new CloseableStaticBitmap(fetchFirstFrameThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
        }
        if (Build.VERSION.SDK_INT >= 29 && UriUtil.isLocalContentUri(imageRequest.getSourceUri())) {
            FLog.m430d(PRODUCER_NAME, "aboveQThumbnailReadTask mContentResolver.loadThumbnail return " + imageRequest);
            Bitmap loadThumbnail = this.mContentResolver.loadThumbnail(imageRequest.getSourceUri(), new Size(imageRequest.getPreferredWidth(), imageRequest.getPreferredHeight()), null);
            if (loadThumbnail != null) {
                final Bitmap copy2 = loadThumbnail.copy(loadThumbnail.getConfig(), true);
                this.mDiskWriteExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LocalVideoThumbnailProducer.this.writeToDiskCache(imageRequest, copy2, "cacheBitmapReadTask cacheBitmapToFile called" + imageRequest);
                    }
                });
                return CloseableReference.m496of(new CloseableStaticBitmap(loadThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
            }
        }
        String localFilePath2 = getLocalFilePath(imageRequest);
        if (localFilePath2 == null) {
            return null;
        }
        FLog.m430d(PRODUCER_NAME, "aboveQThumbnailReadTask ThumbnailUtils.createVideoThumbnail return" + imageRequest);
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(localFilePath2, calculateKind(imageRequest));
        if (createVideoThumbnail == null) {
            return null;
        }
        final Bitmap copy3 = createVideoThumbnail.copy(createVideoThumbnail.getConfig(), true);
        this.mDiskWriteExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.4
            @Override // java.lang.Runnable
            public void run() {
                LocalVideoThumbnailProducer.this.writeToDiskCache(imageRequest, copy3, "cacheBitmapReadTask cacheBitmapToFile called" + imageRequest);
            }
        });
        return CloseableReference.m496of(new CloseableStaticBitmap(createVideoThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
    }

    private Bitmap loadBitmapByOldVersion(ImageRequest imageRequest, String str) {
        if (str != null) {
            return ThumbnailUtils.createVideoThumbnail(str, calculateKind(imageRequest));
        }
        return createThumbnailFromContentProvider(this.mContentResolver, imageRequest, false);
    }

    @Nullable
    private static Bitmap createThumbnailFromContentProvider(ContentResolver contentResolver, ImageRequest imageRequest, boolean z) {
        Uri sourceUri = imageRequest.getSourceUri();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(sourceUri, "r");
            Preconditions.checkNotNull(openFileDescriptor);
            mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
            if (z) {
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                if (FrescoCacheMonitorUtil.isLocalVideoThumbOpt()) {
                    MediaMetadataRetrieverUtils.release(mediaMetadataRetriever);
                }
                return frameAtTime;
            }
            Bitmap frameAtTime2 = mediaMetadataRetriever.getFrameAtTime(-1L);
            if (FrescoCacheMonitorUtil.isLocalVideoThumbOpt()) {
                MediaMetadataRetrieverUtils.release(mediaMetadataRetriever);
            }
            return frameAtTime2;
        } catch (Throwable unused) {
            if (!FrescoCacheMonitorUtil.isLocalVideoThumbOpt()) {
                return null;
            }
            MediaMetadataRetrieverUtils.release(mediaMetadataRetriever);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d3, code lost:
    
        if (com.facebook.imagepipeline.core.FrescoCacheMonitorUtil.isLocalVideoThumbOpt() == false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap fetchFirstFrameThumbnail(ContentResolver contentResolver, String str, ImageRequest imageRequest) {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever;
        if (Build.VERSION.SDK_INT >= 29) {
            File file = new File(str);
            Size size = new Size(imageRequest.getPreferredWidth(), imageRequest.getPreferredHeight());
            boolean isLocalVideoThumbOpt = FrescoCacheMonitorUtil.isLocalVideoThumbOpt();
            if (isLocalVideoThumbOpt) {
                mediaMetadataRetriever = MediaMetadataRetrieverUtils.getRetriever();
            } else {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            }
            try {
                mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
                int parseInt = Integer.parseInt((String) Objects.requireNonNull(mediaMetadataRetriever.extractMetadata(18)));
                int parseInt2 = Integer.parseInt((String) Objects.requireNonNull(mediaMetadataRetriever.extractMetadata(19)));
                if (size.getWidth() > parseInt && size.getHeight() > parseInt2) {
                    bitmap = (Bitmap) Objects.requireNonNull(mediaMetadataRetriever.getFrameAtTime(0L, 2));
                } else {
                    bitmap = (Bitmap) Objects.requireNonNull(mediaMetadataRetriever.getScaledFrameAtTime(0L, 2, size.getWidth(), size.getHeight()));
                }
            } catch (Throwable th) {
                try {
                    FLog.m445e(PRODUCER_NAME, th, "fetchFirstFrameThumbnail 1", new Object[0]);
                    if (!isLocalVideoThumbOpt) {
                        MediaMetadataRetrieverUtils.release(mediaMetadataRetriever);
                    }
                } finally {
                    if (!isLocalVideoThumbOpt) {
                        MediaMetadataRetrieverUtils.release(mediaMetadataRetriever);
                    }
                }
            }
            Uri sourceUri = imageRequest.getSourceUri();
            if (bitmap == null) {
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(sourceUri, "r");
                    Preconditions.checkNotNull(openFileDescriptor);
                    mediaMetadataRetriever2.setDataSource(openFileDescriptor.getFileDescriptor());
                    bitmap = mediaMetadataRetriever2.getFrameAtTime(0L);
                } catch (Throwable th2) {
                    try {
                        FLog.m445e(PRODUCER_NAME, th2, "fetchFirstFrameThumbnail 2", new Object[0]);
                    } finally {
                        if (FrescoCacheMonitorUtil.isLocalVideoThumbOpt()) {
                            MediaMetadataRetrieverUtils.release(mediaMetadataRetriever2);
                        }
                    }
                }
            }
            if (bitmap != null) {
                FLog.m442e(PRODUCER_NAME, "fetchFirstFrameThumbnail failed");
            } else {
                FLog.m430d(PRODUCER_NAME, "fetchFirstFrameThumbnail success");
            }
            return bitmap;
        }
        bitmap = null;
        Uri sourceUri2 = imageRequest.getSourceUri();
        if (bitmap == null) {
        }
        if (bitmap != null) {
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToDiskCache(ImageRequest imageRequest, Bitmap bitmap, String str) {
        if (imageRequest.isResizedImageDiskCacheActuallyEnabled() && bitmap.getHeight() != 0 && imageRequest.getResizeOptions().height != 0) {
            float width = bitmap.getWidth() / bitmap.getHeight();
            int i = imageRequest.getResizeOptions().width;
            int i2 = imageRequest.getResizeOptions().height;
            float f = i;
            float f2 = i2;
            if (f / f2 > width) {
                i2 = (int) (f / width);
            } else {
                i = (int) (f2 * width);
            }
            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        }
        FLog.m430d(PRODUCER_NAME, str);
        cacheBitmapToFile(imageRequest, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean useNewProducer() {
        return ImagePipelineFactory.getInstance().isNewLocalVideoThumbnailOptEnabled() || ImagePipelineConfig.getInstance().isNewLocalVideoThumbnailOptEnabled();
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> statefulProducerRunnable = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, listener, PRODUCER_NAME, id) { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(CloseableReference<CloseableImage> closeableReference) {
                super.onSuccess((C03345) closeableReference);
                listener.onUltimateProducerReached(id, LocalVideoThumbnailProducer.PRODUCER_NAME, closeableReference != null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onFailure(Exception exc) {
                super.onFailure(exc);
                listener.onUltimateProducerReached(id, LocalVideoThumbnailProducer.PRODUCER_NAME, false);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            public CloseableReference<CloseableImage> getResult() throws Exception {
                return LocalVideoThumbnailProducer.this.useNewProducer() ? LocalVideoThumbnailProducer.this.getResultNew(imageRequest) : LocalVideoThumbnailProducer.this.getResultOld(imageRequest);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> closeableReference) {
                return ImmutableMap.m414of(LocalVideoThumbnailProducer.CREATED_THUMBNAIL, String.valueOf(closeableReference != null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(CloseableReference<CloseableImage> closeableReference) {
                CloseableReference.closeSafely(closeableReference);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.6
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mProducerExecutor.execute(statefulProducerRunnable);
    }

    private static int calculateKind(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    private String getLocalFilePath(ImageRequest imageRequest) {
        Uri uri;
        String str;
        String[] strArr;
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalFileUri(sourceUri)) {
            return imageRequest.getSourceFile().getPath();
        }
        if (UriUtil.isLocalContentUri(sourceUri)) {
            if ("com.android.providers.media.documents".equals(sourceUri.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(sourceUri);
                str = "_id=?";
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                strArr = new String[]{documentId.split(":")[1]};
            } else {
                uri = sourceUri;
                str = null;
                strArr = null;
            }
            Cursor query = this.mContentResolver.query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        return query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return null;
    }
}
