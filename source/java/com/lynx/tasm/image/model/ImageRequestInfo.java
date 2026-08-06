package com.lynx.tasm.image.model;

import android.graphics.Bitmap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes7.dex */
public class ImageRequestInfo {
    private boolean mAutoPlay;
    private final int mCacheChoice;
    private Object mCallerContext;
    private final Bitmap.Config mConfig;
    private final Map<String, String> mCustomParam;
    private Integer mDiskCacheChoice;
    private final boolean mEnableAsyncRequest;
    private boolean mEnableDownSampling;
    private final boolean mEnableGifLiteDecoder;
    private boolean mEnablePremultiplied;
    private final boolean mEnableResourceHint;
    private boolean mForceStaticImage;
    private final int mLoopCount;
    private final List<BitmapPostProcessor> mProcessors;
    private final int mResizeHeight;
    private final int mResizeWidth;
    private final String mUrl;
    private boolean mUseLocalCache;

    public ImageRequestInfo(ImageRequestInfoBuilder imageRequestInfoBuilder) {
        this.mEnableDownSampling = true;
        this.mDiskCacheChoice = null;
        this.mForceStaticImage = false;
        this.mEnablePremultiplied = true;
        this.mUrl = imageRequestInfoBuilder.getUrl();
        this.mResizeWidth = imageRequestInfoBuilder.getResizeWidth();
        this.mEnableAsyncRequest = imageRequestInfoBuilder.isEnableAsyncRequest();
        this.mDiskCacheChoice = imageRequestInfoBuilder.getDiskCacheChoice();
        this.mResizeHeight = imageRequestInfoBuilder.getResizeHeight();
        this.mLoopCount = imageRequestInfoBuilder.getLoopCount();
        this.mConfig = imageRequestInfoBuilder.getConfig();
        this.mEnableGifLiteDecoder = imageRequestInfoBuilder.enableGifLiteDecoder();
        this.mCustomParam = imageRequestInfoBuilder.getCustomParam();
        this.mCacheChoice = imageRequestInfoBuilder.getCacheChoice();
        this.mProcessors = imageRequestInfoBuilder.getProcessors();
        this.mEnableResourceHint = imageRequestInfoBuilder.isEnableResourceHint();
        this.mEnableDownSampling = imageRequestInfoBuilder.isEnableDownSampling();
        this.mCallerContext = imageRequestInfoBuilder.getCallerContext();
        this.mAutoPlay = imageRequestInfoBuilder.isEnableAnimationAutoPlay();
        this.mUseLocalCache = imageRequestInfoBuilder.isUseLocalCache();
        this.mForceStaticImage = imageRequestInfoBuilder.isForceStaticImage();
        this.mEnablePremultiplied = imageRequestInfoBuilder.isEnablePremultiplied();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getResizeWidth() {
        return this.mResizeWidth;
    }

    public int getResizeHeight() {
        return this.mResizeHeight;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public Bitmap.Config getConfig() {
        return this.mConfig;
    }

    public boolean isEnableGifLiteDecoder() {
        return this.mEnableGifLiteDecoder;
    }

    public boolean isEnablePremultiplied() {
        return this.mEnablePremultiplied;
    }

    public Map<String, String> getCustomParam() {
        return this.mCustomParam;
    }

    public int getCacheChoice() {
        return this.mCacheChoice;
    }

    public List<BitmapPostProcessor> getProcessors() {
        return this.mProcessors;
    }

    public boolean isEnableResourceHint() {
        return this.mEnableResourceHint;
    }

    public boolean isEnableDownSampling() {
        return this.mEnableDownSampling;
    }

    public boolean isUseLocalCache() {
        return this.mUseLocalCache;
    }

    public boolean isForceStaticImage() {
        return this.mForceStaticImage;
    }

    public Integer getDiskCacheChoice() {
        return this.mDiskCacheChoice;
    }

    public boolean isEnableAsyncRequest() {
        return this.mEnableAsyncRequest;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public boolean isAutoPlay() {
        return this.mAutoPlay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageRequestInfo imageRequestInfo = (ImageRequestInfo) obj;
        if (this.mResizeWidth == imageRequestInfo.mResizeWidth && this.mResizeHeight == imageRequestInfo.mResizeHeight && this.mEnableResourceHint == imageRequestInfo.mEnableResourceHint && this.mEnableGifLiteDecoder == imageRequestInfo.mEnableGifLiteDecoder && this.mEnableDownSampling == imageRequestInfo.mEnableDownSampling && this.mEnableAsyncRequest == imageRequestInfo.mEnableAsyncRequest && Objects.equals(this.mUrl, imageRequestInfo.mUrl) && this.mConfig == imageRequestInfo.mConfig) {
            return Objects.equals(this.mProcessors, imageRequestInfo.mProcessors);
        }
        return false;
    }

    public int hashCode() {
        String str = this.mUrl;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.mResizeWidth) * 31) + this.mResizeHeight) * 31;
        Bitmap.Config config = this.mConfig;
        int hashCode2 = (((((((((hashCode + (config != null ? config.hashCode() : 0)) * 31) + (this.mEnableResourceHint ? 1 : 0)) * 31) + (this.mEnableGifLiteDecoder ? 1 : 0)) * 31) + (this.mEnableDownSampling ? 1 : 0)) * 31) + (this.mEnableAsyncRequest ? 1 : 0)) * 31;
        List<BitmapPostProcessor> list = this.mProcessors;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }
}
