package com.lynx.tasm.image.model;

import android.graphics.Bitmap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class ImageRequestInfoBuilder {
    private int mCacheChoice;
    private Object mCallerContext;
    private Bitmap.Config mConfig;
    private Map<String, String> mCustomParam;
    private boolean mEnableAnimationAutoPlay;
    private boolean mEnableAsyncRequest;
    private boolean mEnableGifLiteDecoder;
    private boolean mEnableResourceHint;
    private int mLoopCount;
    private List<BitmapPostProcessor> mProcessors;
    private int mResizeHeight;
    private int mResizeWidth;
    private String mUrl;
    private boolean mUseLocalCache;
    private Integer mDiskCacheChoice = null;
    private boolean mEnableDownSampling = true;
    private boolean mForceStaticImage = false;
    private boolean mEnablePremultiplied = true;

    public static ImageRequestInfoBuilder newBuilderWithSource(String str) {
        return new ImageRequestInfoBuilder().setUrl(str);
    }

    public boolean isEnableDownSampling() {
        return this.mEnableDownSampling;
    }

    public ImageRequestInfoBuilder setEnableDownSampling(boolean z) {
        this.mEnableDownSampling = z;
        return this;
    }

    public boolean isEnableAnimationAutoPlay() {
        return this.mEnableAnimationAutoPlay;
    }

    public ImageRequestInfoBuilder setEnableAnimationAutoPlay(boolean z) {
        this.mEnableAnimationAutoPlay = z;
        return this;
    }

    public boolean isEnablePremultiplied() {
        return this.mEnablePremultiplied;
    }

    public ImageRequestInfoBuilder setEnablePremultiplied(boolean z) {
        this.mEnablePremultiplied = z;
        return this;
    }

    public ImageRequestInfoBuilder setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public ImageRequestInfoBuilder setResizeWidth(int i) {
        this.mResizeWidth = i;
        return this;
    }

    public ImageRequestInfoBuilder setResizeHeight(int i) {
        this.mResizeHeight = i;
        return this;
    }

    public void setCustomParam(Map<String, String> map) {
        this.mCustomParam = map;
    }

    public ImageRequestInfoBuilder setLoopCount(int i) {
        this.mLoopCount = i;
        return this;
    }

    public ImageRequestInfoBuilder setBitmapConfig(Bitmap.Config config) {
        this.mConfig = config;
        return this;
    }

    public ImageRequestInfoBuilder setEnableGifLiteDecoder(boolean z) {
        this.mEnableGifLiteDecoder = z;
        return this;
    }

    public ImageRequestInfoBuilder setCacheChoice(int i) {
        this.mCacheChoice = i;
        return this;
    }

    public ImageRequestInfoBuilder setBitmapPostProcessor(List<BitmapPostProcessor> list) {
        this.mProcessors = list;
        return this;
    }

    public ImageRequestInfoBuilder setEnableResourceHint(boolean z) {
        this.mEnableResourceHint = z;
        return this;
    }

    public ImageRequestInfoBuilder setUseLocalCache(boolean z) {
        this.mUseLocalCache = z;
        return this;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public ImageRequestInfoBuilder setCallerContext(Object obj) {
        this.mCallerContext = obj;
        return this;
    }

    public Integer getDiskCacheChoice() {
        return this.mDiskCacheChoice;
    }

    public void setDiskCacheChoice(Integer num) {
        this.mDiskCacheChoice = num;
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

    public boolean enableGifLiteDecoder() {
        return this.mEnableGifLiteDecoder;
    }

    public Map<String, String> getCustomParam() {
        return this.mCustomParam;
    }

    public boolean isEnableAsyncRequest() {
        return this.mEnableAsyncRequest;
    }

    public boolean isEnableResourceHint() {
        return this.mEnableResourceHint;
    }

    public boolean isUseLocalCache() {
        return this.mUseLocalCache;
    }

    public ImageRequestInfoBuilder setEnableAsyncRequest(boolean z) {
        this.mEnableAsyncRequest = z;
        return this;
    }

    public boolean isForceStaticImage() {
        return this.mForceStaticImage;
    }

    public ImageRequestInfoBuilder setForceStaticImage(boolean z) {
        this.mForceStaticImage = z;
        return this;
    }

    public int getCacheChoice() {
        return this.mCacheChoice;
    }

    public List<BitmapPostProcessor> getProcessors() {
        return this.mProcessors;
    }

    public ImageRequestInfo build() {
        return new ImageRequestInfo(this);
    }
}
