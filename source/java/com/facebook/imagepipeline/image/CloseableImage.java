package com.facebook.imagepipeline.image;

import android.graphics.Rect;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.ImageFormat;
import java.io.Closeable;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class CloseableImage implements Closeable, ImageInfo, MemoryCacheHitTracker {
    private static final String TAG = "CloseableImage";
    private boolean isThumbCache;
    protected CalculateColorInfo mCalculateColorInfo;
    protected Map<String, String> mExtraMap;
    private int mFileSize;
    protected ImageFormat mImageFormat;
    private boolean isRequestInternet = false;
    private boolean isHitDiskCache = false;
    private boolean isHitEncodeMemoryCache = false;
    private boolean isHitBitmapMemoryCache = false;

    public CloseableImage cloneOrNull() {
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public Rect getRegionToDecode() {
        return null;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getSampleSize() {
        return -1;
    }

    public abstract int getSizeInBytes();

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public Rect getSmartCrop() {
        return null;
    }

    public String getSourceUri() {
        return null;
    }

    public abstract boolean isClosed();

    public boolean isStateful() {
        return false;
    }

    public void setSourceUri(String str) {
    }

    public void setFileSize(int i) {
        this.mFileSize = i;
    }

    public int getFileSize() {
        return this.mFileSize;
    }

    public void setExtraMap(Map<String, String> map) {
        this.mExtraMap = map;
    }

    public Map<String, String> getExtraMap() {
        return this.mExtraMap;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public QualityInfo getQualityInfo() {
        return ImmutableQualityInfo.FULL_QUALITY;
    }

    public boolean isRequestInternet() {
        return this.isRequestInternet;
    }

    public boolean isHitDiskCache() {
        return this.isHitDiskCache;
    }

    public boolean isHitMemoryCache() {
        return this.isHitEncodeMemoryCache || this.isHitBitmapMemoryCache;
    }

    public boolean isHitEncodeMemoryCache() {
        return this.isHitEncodeMemoryCache;
    }

    public boolean isHitBitmapMemoryCache() {
        return this.isHitBitmapMemoryCache;
    }

    @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
    public void hitEncodeMemoryCache() {
        this.isHitEncodeMemoryCache = true;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestInternet = false;
    }

    @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
    public void hitBitmapMemoryCache() {
        this.isHitBitmapMemoryCache = true;
        this.isHitEncodeMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestInternet = false;
    }

    public void copyImageFromTrace(EncodedImage encodedImage) {
        this.isRequestInternet = encodedImage.isRequestNetwork();
        this.isHitDiskCache = encodedImage.isHitDiskCache();
        this.isHitEncodeMemoryCache = encodedImage.isHitEncodeMemoryCache();
        this.isHitBitmapMemoryCache = encodedImage.isHitBitmapMemoryCache();
    }

    public void setImageFrom(int i) {
        if (i == 0) {
            this.isHitEncodeMemoryCache = false;
            this.isHitBitmapMemoryCache = false;
            this.isHitDiskCache = false;
            this.isRequestInternet = true;
            return;
        }
        if (i == 1) {
            hitEncodeMemoryCache();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            hitBitmapMemoryCache();
        } else {
            this.isHitEncodeMemoryCache = false;
            this.isHitBitmapMemoryCache = false;
            this.isHitDiskCache = true;
            this.isRequestInternet = false;
        }
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public ImageFormat getImageFormat() {
        ImageFormat imageFormat = this.mImageFormat;
        return imageFormat == null ? ImageFormat.UNKNOWN : imageFormat;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public void setCalculateColorInfo(CalculateColorInfo calculateColorInfo) {
        this.mCalculateColorInfo = calculateColorInfo;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public CalculateColorInfo getCalculateColorInfo() {
        return this.mCalculateColorInfo;
    }

    protected void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        FLog.d(TAG, "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void setThumbCache(boolean z) {
        this.isThumbCache = z;
    }

    public boolean isThumbCache() {
        return this.isThumbCache;
    }
}
