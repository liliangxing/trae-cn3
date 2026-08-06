package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.utils.ImageCenterStrategy;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImageRequestBuilder {
    private static boolean enableGlobalSecurityTag;
    private static IHeaderInterceptor mHeaderInterceptor;
    private static IRequestBackUrlReplace mRequestBackUrlReplace;
    private static IRequestUrlReplace mRequestUrlReplace;
    private CalculateColorConfig mCalculateColorConfig;
    private Map<String, String> mCustomParam;
    private boolean mEnableNetworkPriority;
    private Map<String, String> mHttpHeader;

    @Nullable
    private String mMimeType;
    private String mPublicKey;

    @Nullable
    private RequestListener mRequestListener;
    private String mUrlKey;
    private Map<String, String> mWaitParseParamFromUrl;
    private Uri mSourceUri = null;
    private Uri mCacheKeyUri = null;
    private List<Uri> mBackupUris = null;
    private ImageRequest.RequestLevel mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;

    @Nullable
    private ResizeOptions mResizeOptions = null;

    @Nullable
    private BlurHashConfig mBlurHashOptions = null;

    @Nullable
    private RotationOptions mRotationOptions = null;
    private ImageDecodeOptions mImageDecodeOptions = ImageDecodeOptions.defaults();
    private ImageRequest.CacheChoice mCacheChoice = ImageRequest.CacheChoice.DEFAULT;
    private boolean mProgressiveRenderingEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();
    private boolean mProgressiveRenderingAnimatedEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingAnimatedEnabled();
    private boolean mProgressiveRenderingHeicEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingHeicEnabled();
    private boolean mLocalThumbnailPreviewsEnabled = false;
    private boolean mLoadThumbnailOnly = false;
    private Priority mRequestPriority = Priority.MEDIUM;

    @Nullable
    private Postprocessor mPostprocessor = null;
    private boolean mDiskCacheEnabled = true;
    private boolean mResizedImageDiskCacheEnabled = false;
    private boolean mMemoryCacheEnabled = true;

    @Nullable
    private BytesRange mBytesRange = null;
    private String mCustomCacheName = null;
    private int mAwebpScanNumber = 1;
    private boolean enableSecurityTag = false;
    private boolean mIsPrefetch = false;
    private boolean useSingleHeaderBlurhash = false;
    private boolean isFallBackToMainMemory = false;
    private boolean mMultiplexerEnabled = true;
    private boolean mNeedReplaceUri = false;
    private boolean mIsOptPrefetch = false;
    private int mSampleSize = -1;
    private int mTargetWidth = -1;
    private int mTargetHeight = -1;
    private boolean mOptOnNewResultMsg = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface IHeaderInterceptor {
        Map<String, String> interceptHeader(Uri uri, Map<String, String> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface IRequestBackUrlReplace {
        List<Uri> replaceRequestBackUrl(List<Uri> list);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface IRequestUrlReplace {
        Uri replaceRequestUrl(Uri uri);
    }

    public static void setRequestUrlReplace(IRequestUrlReplace iRequestUrlReplace) {
        mRequestUrlReplace = iRequestUrlReplace;
    }

    public static void setRequestBackUrlReplace(IRequestBackUrlReplace iRequestBackUrlReplace) {
        mRequestBackUrlReplace = iRequestBackUrlReplace;
    }

    public static void setHeaderInterceptor(IHeaderInterceptor iHeaderInterceptor) {
        mHeaderInterceptor = iHeaderInterceptor;
    }

    public static ImageRequestBuilder newBuilderWithSource(Uri uri) {
        return new ImageRequestBuilder().setSource(uri);
    }

    public static void setEnableGlobalSecurityTag(boolean z) {
        enableGlobalSecurityTag = z;
    }

    public static ImageRequestBuilder newBuilderWithResourceId(int i) {
        return newBuilderWithSource(UriUtil.getUriForResourceId(i));
    }

    public static ImageRequestBuilder fromRequest(ImageRequest imageRequest) {
        if (!ImagePipelineConfig.useSingleImageRequest) {
            ImageRequestBuilder rotationOptions = newBuilderWithSource(imageRequest.getSourceUri()).setImageDecodeOptions(imageRequest.getImageDecodeOptions()).setBytesRange(imageRequest.getBytesRange()).setCacheChoice(imageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(imageRequest.getLocalThumbnailPreviewsEnabled()).setLoadThumbnailOnly(imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()).setLowestPermittedRequestLevel(imageRequest.getLowestPermittedRequestLevel()).setPostprocessor(imageRequest.getPostprocessor()).setProgressiveRenderingEnabled(imageRequest.getProgressiveRenderingEnabled()).setRequestPriority(imageRequest.getPriority()).setResizeOptions(imageRequest.getResizeOptions()).setRequestListener(imageRequest.getRequestListener()).setRotationOptions(imageRequest.getRotationOptions());
            if (imageRequest.getCustomCacheName() != null) {
                rotationOptions.setCustomCacheName(imageRequest.getCustomCacheName());
            }
            return rotationOptions;
        }
        ImageRequestBuilder targetHeight = newBuilderWithSource(imageRequest.getSourceUri()).setImageDecodeOptions(imageRequest.getImageDecodeOptions()).setBytesRange(imageRequest.getBytesRange()).setCacheChoice(imageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(imageRequest.getLocalThumbnailPreviewsEnabled()).setLoadThumbnailOnly(imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()).setLowestPermittedRequestLevel(imageRequest.getLowestPermittedRequestLevel()).setPostprocessor(imageRequest.getPostprocessor()).setProgressiveRenderingEnabled(imageRequest.getProgressiveRenderingEnabled()).setRequestPriority(imageRequest.getPriority()).setResizeOptions(imageRequest.getResizeOptions()).setRequestListener(imageRequest.getRequestListener()).setRotationOptions(imageRequest.getRotationOptions()).setAwebpScanNumber(imageRequest.getAwebpScanNumber()).setProgressiveRenderingAnimatedEnabled(imageRequest.getProgressiveRenderingAnimatedEnabled()).setProgressiveRenderingHeicEnabled(imageRequest.getProgressiveRenderingHeicEnabled()).setMultiplexerEnabled(imageRequest.isMultiplexerEnabled()).setSampleSize(imageRequest.getSampleSize()).setOptPrefetch(imageRequest.isOptPrefetch()).setOpenHeaderBlurhash(imageRequest.isUseSingleHeaderBlurhash()).setOptOnNewResultMsg(imageRequest.isOptOnNewResultMsg()).setPrefetchMark(imageRequest.isPrefetch()).setTargetWidth(imageRequest.getTargetWidth()).setTargetHeight(imageRequest.getTargetHeight());
        if (imageRequest.getCustomCacheName() != null) {
            targetHeight.setCustomCacheName(imageRequest.getCustomCacheName());
        }
        if (imageRequest.getHttpHeader() != null) {
            targetHeight.setHttpHeader(imageRequest.getHttpHeader());
        }
        return targetHeight;
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder setSource(Uri uri) {
        Preconditions.checkNotNull(uri);
        IRequestUrlReplace iRequestUrlReplace = mRequestUrlReplace;
        if (iRequestUrlReplace != null) {
            uri = iRequestUrlReplace.replaceRequestUrl(uri);
        }
        this.mSourceUri = uri;
        return this;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public ImageRequestBuilder setCustomCacheName(String str) {
        Preconditions.checkNotNull(str);
        this.mCustomCacheName = str;
        return this;
    }

    @Nullable
    public String getCustomCacheName() {
        return this.mCustomCacheName;
    }

    public ImageRequestBuilder setCacheKeyUri(Uri uri) {
        this.mCacheKeyUri = uri;
        return this;
    }

    public Uri getCacheKeyUri() {
        return this.mCacheKeyUri;
    }

    public ImageRequestBuilder setBackup(List<Uri> list) {
        IRequestBackUrlReplace iRequestBackUrlReplace = mRequestBackUrlReplace;
        if (iRequestBackUrlReplace != null) {
            list = iRequestBackUrlReplace.replaceRequestBackUrl(list);
        }
        this.mBackupUris = list;
        return this;
    }

    public List<Uri> getBackupUris() {
        return this.mBackupUris;
    }

    public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel requestLevel) {
        this.mLowestPermittedRequestLevel = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    @Deprecated
    public ImageRequestBuilder setAutoRotateEnabled(boolean z) {
        if (z) {
            return setRotationOptions(RotationOptions.autoRotate());
        }
        return setRotationOptions(RotationOptions.disableRotation());
    }

    public ImageRequestBuilder setResizeOptions(@Nullable ResizeOptions resizeOptions) {
        this.mResizeOptions = resizeOptions;
        return this;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public ImageRequestBuilder setBlurHashOptions(@Nullable BlurHashConfig blurHashConfig) {
        this.mBlurHashOptions = blurHashConfig;
        return this;
    }

    @Nullable
    public BlurHashConfig getBlurHashOptions() {
        return this.mBlurHashOptions;
    }

    public ImageRequestBuilder setRotationOptions(@Nullable RotationOptions rotationOptions) {
        this.mRotationOptions = rotationOptions;
        return this;
    }

    @Nullable
    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    public ImageRequestBuilder setBytesRange(@Nullable BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
        return this;
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions imageDecodeOptions) {
        this.mImageDecodeOptions = imageDecodeOptions;
        return this;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public ImageRequestBuilder setCacheChoice(ImageRequest.CacheChoice cacheChoice) {
        this.mCacheChoice = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public ImageRequestBuilder setProgressiveRenderingEnabled(boolean z) {
        this.mProgressiveRenderingEnabled = z;
        return this;
    }

    public boolean isProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public ImageRequestBuilder setProgressiveRenderingAnimatedEnabled(boolean z) {
        this.mProgressiveRenderingAnimatedEnabled = z;
        return this;
    }

    public boolean isProgressiveRenderingAnimatedEnabled() {
        return this.mProgressiveRenderingAnimatedEnabled;
    }

    public ImageRequestBuilder setProgressiveRenderingHeicEnabled(boolean z) {
        this.mProgressiveRenderingHeicEnabled = z;
        return this;
    }

    public boolean isProgressiveRenderingHeicEnabled() {
        return this.mProgressiveRenderingHeicEnabled;
    }

    public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean z) {
        this.mLocalThumbnailPreviewsEnabled = z;
        return this;
    }

    public boolean isLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public ImageRequestBuilder setLoadThumbnailOnly(boolean z) {
        this.mLoadThumbnailOnly = z;
        return this;
    }

    public boolean getLoadThumbnailOnly() {
        return this.mLoadThumbnailOnly;
    }

    public ImageRequestBuilder disableDiskCache() {
        this.mDiskCacheEnabled = false;
        return this;
    }

    public ImageRequestBuilder enableResizedImageDiskCache(boolean z) {
        this.mResizedImageDiskCacheEnabled = z;
        return this;
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCacheEnabled && UriUtil.isNetworkUri(this.mSourceUri);
    }

    public boolean isResizedImageDiskCacheEnabled() {
        return this.mResizedImageDiskCacheEnabled;
    }

    public ImageRequestBuilder disableMemoryCache() {
        this.mMemoryCacheEnabled = false;
        return this;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mMemoryCacheEnabled;
    }

    public ImageRequestBuilder setRequestPriority(Priority priority) {
        this.mRequestPriority = priority;
        return this;
    }

    public Priority getRequestPriority() {
        return this.mRequestPriority;
    }

    public ImageRequestBuilder setPostprocessor(Postprocessor postprocessor) {
        this.mPostprocessor = postprocessor;
        return this;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public ImageRequestBuilder setRequestListener(RequestListener requestListener) {
        this.mRequestListener = requestListener;
        return this;
    }

    @Nullable
    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    @Nullable
    public String getMimeType() {
        return this.mMimeType;
    }

    public ImageRequestBuilder setMimeType(@Nullable String str) {
        this.mMimeType = str;
        return this;
    }

    public boolean isMultiplexerEnabled() {
        return this.mMultiplexerEnabled;
    }

    public ImageRequestBuilder setMultiplexerEnabled(boolean z) {
        this.mMultiplexerEnabled = z;
        return this;
    }

    public ImageRequestBuilder setOptPrefetch(boolean z) {
        this.mIsOptPrefetch = z;
        return this;
    }

    public boolean isOptPrefetch() {
        return this.mIsOptPrefetch;
    }

    public boolean isNeedReplaceUri() {
        return this.mNeedReplaceUri;
    }

    public ImageRequestBuilder setNeedReplaceUri(boolean z) {
        this.mNeedReplaceUri = z;
        return this;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    public ImageRequestBuilder setSampleSize(int i) {
        this.mSampleSize = i;
        return this;
    }

    public int getTargetWidth() {
        return this.mTargetWidth;
    }

    public ImageRequestBuilder setTargetWidth(int i) {
        this.mTargetWidth = i;
        return this;
    }

    public int getTargetHeight() {
        return this.mTargetHeight;
    }

    public ImageRequestBuilder setTargetHeight(int i) {
        this.mTargetHeight = i;
        return this;
    }

    public CalculateColorConfig getCalculateColorConfig() {
        return this.mCalculateColorConfig;
    }

    public ImageRequestBuilder setCalculateColorConfig(CalculateColorConfig calculateColorConfig) {
        this.mCalculateColorConfig = calculateColorConfig;
        return this;
    }

    public boolean isEnableNetworkPriority() {
        return this.mEnableNetworkPriority;
    }

    public ImageRequestBuilder setEnableNetworkPriority(boolean z) {
        this.mEnableNetworkPriority = z;
        return this;
    }

    public Map<String, String> getHttpHeader() {
        if ((enableGlobalSecurityTag || this.enableSecurityTag) && this.mHttpHeader == null) {
            HashMap hashMap = new HashMap();
            this.mHttpHeader = hashMap;
            hashMap.put("x-security-argus", "StaticResource/img/BDFresco");
        }
        IHeaderInterceptor iHeaderInterceptor = mHeaderInterceptor;
        if (iHeaderInterceptor != null) {
            this.mHttpHeader = iHeaderInterceptor.interceptHeader(this.mSourceUri, this.mHttpHeader);
        }
        return this.mHttpHeader;
    }

    public ImageRequestBuilder setHttpHeader(Map<String, String> map) {
        Map<String, String> map2 = this.mHttpHeader;
        if (map2 == null) {
            this.mHttpHeader = new HashMap();
        } else {
            map2.clear();
        }
        boolean z = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ((enableGlobalSecurityTag || this.enableSecurityTag) && !TextUtils.isEmpty(entry.getKey()) && entry.getKey().contains("x-security-argus")) {
                if (entry.getValue() != null && !entry.getValue().contains("StaticResource/")) {
                    this.mHttpHeader.put(entry.getKey(), entry.getValue() + " StaticResource/img/BDFresco");
                } else {
                    this.mHttpHeader.put(entry.getKey(), entry.getValue());
                }
                z = true;
            } else {
                this.mHttpHeader.put(entry.getKey(), entry.getValue());
            }
        }
        if ((enableGlobalSecurityTag || this.enableSecurityTag) && !z) {
            this.mHttpHeader.put("x-security-argus", "StaticResource/img/BDFresco");
        }
        return this;
    }

    public ImageRequestBuilder setEnableSecurityTag(boolean z) {
        this.enableSecurityTag = z;
        return this;
    }

    public boolean getPrefetchMark() {
        return this.mIsPrefetch;
    }

    public ImageRequestBuilder setPrefetchMark(boolean z) {
        this.mIsPrefetch = z;
        return this;
    }

    public ImageRequestBuilder setOpenHeaderBlurhash(boolean z) {
        this.useSingleHeaderBlurhash = z;
        return this;
    }

    public boolean isUseSingleHeaderBlurhash() {
        return this.useSingleHeaderBlurhash;
    }

    public ImageRequestBuilder setFallBackToMainMemory(boolean z) {
        this.isFallBackToMainMemory = z;
        return this;
    }

    public boolean isFallBackToMainMemory() {
        return this.isFallBackToMainMemory;
    }

    public int getAwebpScanNumber() {
        return this.mAwebpScanNumber;
    }

    public ImageRequestBuilder setAwebpScanNumber(int i) {
        this.mAwebpScanNumber = i;
        return this;
    }

    public Map<String, String> getCustomParam() {
        return this.mCustomParam;
    }

    public ImageRequestBuilder setCustomParam(Map<String, String> map) {
        this.mCustomParam = map;
        return this;
    }

    public ImageRequestBuilder setWaitParseParamFromUrl(Map<String, String> map) {
        this.mWaitParseParamFromUrl = map;
        return this;
    }

    public Map<String, String> getWaitParseParamFromUrl() {
        return this.mWaitParseParamFromUrl;
    }

    public String getPublicKey() {
        return this.mPublicKey;
    }

    public ImageRequestBuilder setPublicKey(String str) {
        this.mPublicKey = str;
        return this;
    }

    public String getUrlKey() {
        return this.mUrlKey;
    }

    public ImageRequestBuilder setUrlKey(String str) {
        this.mUrlKey = str;
        return this;
    }

    public boolean isOptOnNewResultMsg() {
        return this.mOptOnNewResultMsg;
    }

    public ImageRequestBuilder setOptOnNewResultMsg(boolean z) {
        this.mOptOnNewResultMsg = z;
        return this;
    }

    public ImageRequest build() {
        Map<String, Object> imageStrategyResult;
        Object obj;
        ImageRequestDiskCacheStrategy strategy;
        int i;
        validate();
        Map<String, String> waitParseParamFromUrl = getWaitParseParamFromUrl();
        Map<String, String> waitParseParamFromUrl2 = FrescoCacheMonitorUtil.getWaitParseParamFromUrl();
        if (waitParseParamFromUrl2 != null) {
            if (this.mCustomParam == null) {
                this.mCustomParam = new HashMap();
            }
            updateCustomParam(this.mSourceUri, this.mCustomParam, waitParseParamFromUrl2);
        }
        if (waitParseParamFromUrl != null) {
            if (this.mCustomParam == null) {
                this.mCustomParam = new HashMap();
            }
            updateCustomParam(this.mSourceUri, this.mCustomParam, waitParseParamFromUrl);
        }
        if (ImageRequestDiskCacheStrategy.getStrategy() != null && (strategy = ImageRequestDiskCacheStrategy.getStrategy()) != null) {
            if (getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
                i = 2;
            } else {
                i = getCacheChoice() == ImageRequest.CacheChoice.CUSTOM ? 3 : 1;
            }
            Pair<Integer, String> customDiskCache = strategy.getCustomDiskCache(getSourceUri(), i, getCustomCacheName());
            if (customDiskCache != null) {
                if (((Integer) customDiskCache.first).intValue() == 1) {
                    setCacheChoice(ImageRequest.CacheChoice.DEFAULT);
                } else if (((Integer) customDiskCache.first).intValue() == 2) {
                    setCacheChoice(ImageRequest.CacheChoice.SMALL);
                } else if (((Integer) customDiskCache.first).intValue() == 3) {
                    setCacheChoice(ImageRequest.CacheChoice.CUSTOM);
                    setCustomCacheName((String) customDiskCache.second);
                }
            }
        }
        if (ImageCenterStrategy.getStrategy() != null && getSourceUri() != null && (imageStrategyResult = ImageCenterStrategy.getStrategy().getImageStrategyResult(getSourceUri().toString(), null)) != null && !imageStrategyResult.isEmpty()) {
            if (imageStrategyResult.containsKey("super_resolution")) {
                Object obj2 = imageStrategyResult.get("super_resolution");
                if (obj2 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(obj2.toString());
                        if (jSONObject.optBoolean("enable")) {
                            this.mPostprocessor = (Postprocessor) getPostProcesorByStrategy(2, "com.bytedance.fresco.sr.SRPostProcessor", jSONObject);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (imageStrategyResult.containsKey("sharpen") && (obj = imageStrategyResult.get("sharpen")) != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(obj.toString());
                    if (jSONObject2.optBoolean("enable")) {
                        this.mPostprocessor = (Postprocessor) getPostProcesorByStrategy(4, "com.bytedance.fresco.sharp.SharpPostProcessor", jSONObject2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return new ImageRequest(this);
    }

    public Object getPostProcesorByStrategy(int i, String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (i == 2) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
                declaredConstructor.setAccessible(true);
                try {
                    return declaredConstructor.newInstance(Integer.valueOf(jSONObject.optInt("algorithm_type")), Integer.valueOf(getScaleType((float) jSONObject.optDouble("scale_type"))), Integer.valueOf(jSONObject.optInt("max_width")), Integer.valueOf(jSONObject.optInt("max_height")), Boolean.valueOf(jSONObject.getBoolean("enable_all_sr")));
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return null;
                }
            }
            if (i != 4) {
                return null;
            }
            int optInt = jSONObject.optInt("template");
            if (optInt == 10) {
                Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(Integer.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE);
                declaredConstructor2.setAccessible(true);
                return declaredConstructor2.newInstance(Integer.valueOf(jSONObject.optInt("algorithm_type")), Float.valueOf((float) jSONObject.optDouble("wt")), Float.valueOf((float) jSONObject.optDouble("thr")), Float.valueOf((float) jSONObject.optDouble("ovrt")), Boolean.valueOf(jSONObject.optBoolean("enable_adaptive")), Float.valueOf((float) jSONObject.optDouble("g0")), Float.valueOf((float) jSONObject.optDouble("lc_wt_thr")));
            }
            Constructor<?> declaredConstructor3 = cls.getDeclaredConstructor(Integer.TYPE);
            declaredConstructor3.setAccessible(true);
            return declaredConstructor3.newInstance(Integer.valueOf(optInt));
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void updateCustomParam(Uri uri, Map<String, String> map, Map<String, String> map2) {
        if (uri == null) {
            return;
        }
        try {
            for (String str : map2.keySet()) {
                String str2 = map2.get(str);
                String queryParameter = uri.getQueryParameter(str);
                if (!TextUtils.isEmpty(queryParameter)) {
                    map.put(str2, queryParameter);
                }
            }
        } catch (Exception unused) {
            FLog.m442e("ImageRequestBuilder", "updateCustomParam failed");
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        Uri uri = this.mSourceUri;
        if (uri == null) {
            throw new BuilderException("Source must be set!");
        }
        if (UriUtil.isLocalResourceUri(uri)) {
            if (!this.mSourceUri.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.mSourceUri.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.mSourceUri.getPath().substring(1));
            } catch (NumberFormatException unused) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (this.mCustomCacheName == null && this.mCacheChoice.equals(ImageRequest.CacheChoice.CUSTOM)) {
            throw new BuilderException("CustomCacheName must be set as you have choice your cacheChoice as 'CUSTOM'");
        }
        if (UriUtil.isLocalAssetUri(this.mSourceUri) && !this.mSourceUri.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }

    private int getScaleType(float f) {
        if (f <= 0.0f) {
            return -1;
        }
        if (Math.abs(f - 1.1f) <= 1.0E-6f) {
            return 4;
        }
        if (Math.abs(f - 1.2f) <= 1.0E-6f) {
            return 8;
        }
        if (Math.abs(f - 1.3f) <= 1.0E-6f) {
            return 16;
        }
        if (Math.abs(f - 1.4f) <= 1.0E-6f) {
            return 32;
        }
        if (Math.abs(f - 1.5f) <= 1.0E-6f) {
            return 1;
        }
        return Math.abs(f - 2.0f) <= 1.0E-6f ? 2 : -1;
    }
}
