package com.lynx.tasm.p001ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.lynx.tasm.p001ui.image.fresco.BaseRoundedCornerPostprocessor;
import com.lynx.tasm.p001ui.image.helper.BigImageDrawingHelper;
import com.lynx.tasm.p001ui.image.helper.ByteDanceFrescoUtils;
import com.lynx.tasm.p001ui.image.helper.ImageResizeUtils;
import com.lynx.tasm.p001ui.image.helper.ImageSource;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoImageView extends SimpleDraweeView {
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    private boolean mAutoPlay;
    private BigImageDrawingHelper mBigImageHelper;
    private BorderRadius mBorderRadii;
    private final Object mCallerContext;
    private boolean mConsumeHoverEvent;
    private ControllerListener mControllerForTesting;
    private ControllerListener mControllerListener;
    private boolean mCoverStart;
    private ImageRequest mCurImageRequest;
    private boolean mDeferInvalidation;
    private boolean mDisableDefaultPlaceholder;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private int mFadeDurationMs;
    private boolean mFixFrescoBug;
    private boolean mFrescoNinePatch;
    private GlobalImageLoadListener mGlobalImageLoadListener;
    private ImageDelegate mImageDelegate;
    private int mImageOrigin;
    private ImageRequestBuilderHook mImageRequestBuilderHook;
    protected boolean mIsBorderRadiusDirty;
    protected boolean mIsDirty;
    public boolean mIsFrescoAttach;
    public boolean mIsFrescoVisible;
    private boolean mIsNoSubSampleMode;
    private boolean mIsPixelated;
    private ImageLoaderCallback mLoaderCallback;
    private LynxBaseUI mLynxBaseUI;
    private int mOverlayColor;
    private float mPreFetchHeight;
    private float mPreFetchWidth;
    private CloseableReference<?> mRef;
    private boolean mRepeat;
    private ScalingUtils.ScaleType mScaleType;
    private int mShowCnt;
    private int mSourceImageHeight;
    private int mSourceImageWidth;
    private long mStartTimeStamp;
    private CloseableReference<Bitmap> mTempPlaceHolder;
    private boolean mUsePostprocessorScaling;
    private WeakImageOriginListener mWeakImageOriginListener;

    public boolean hasOverlappingRendering() {
        return false;
    }

    protected void onImageRequestLoaded() {
    }

    protected void onPostprocessorPreparing(List<Postprocessor> list) {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ImageSize {
        private int mHeight;
        private int mWidth;

        public ImageSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class ImageHelperCallback implements BigImageDrawingHelper.ImageLoaderCallback {
        @Override // com.lynx.tasm.ui.image.helper.BigImageDrawingHelper.ImageLoaderCallback
        public void onImageLoadFailed(String str) {
        }

        ImageHelperCallback() {
        }

        @Override // com.lynx.tasm.ui.image.helper.BigImageDrawingHelper.ImageLoaderCallback
        public void onImageLoadSuccess(BigImageDrawingHelper.Tile tile) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                FrescoImageView.this.invalidate();
            } else {
                FrescoImageView.this.postInvalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class WeakImageOriginListener implements ImageOriginListener {
        private final WeakReference<FrescoImageView> mImageViewRef;

        WeakImageOriginListener(FrescoImageView frescoImageView) {
            this.mImageViewRef = new WeakReference<>(frescoImageView);
        }

        public void onImageLoaded(String str, int i, boolean z) {
            FrescoImageView frescoImageView = this.mImageViewRef.get();
            if (frescoImageView != null) {
                frescoImageView.mImageOrigin = i;
            }
        }
    }

    private static GenericDraweeHierarchy buildHierarchy(Context context) {
        return new GenericDraweeHierarchyBuilder(context.getResources()).setRoundingParams((RoundingParams) null).build();
    }

    @Deprecated
    public FrescoImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        this(context, abstractDraweeControllerBuilder, globalImageLoadListener, obj, null);
    }

    public FrescoImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj, LynxBaseUI lynxBaseUI) {
        super(context, buildHierarchy(context));
        this.mUsePostprocessorScaling = false;
        this.mSourceImageWidth = 0;
        this.mSourceImageHeight = 0;
        this.mPreFetchWidth = -1.0f;
        this.mPreFetchHeight = -1.0f;
        this.mIsFrescoVisible = false;
        this.mIsFrescoAttach = false;
        this.mFrescoNinePatch = false;
        this.mAutoPlay = true;
        this.mIsPixelated = false;
        this.mFadeDurationMs = 0;
        this.mBorderRadii = null;
        this.mIsNoSubSampleMode = false;
        this.mRef = null;
        this.mDisableDefaultPlaceholder = false;
        this.mTempPlaceHolder = null;
        this.mConsumeHoverEvent = false;
        this.mLynxBaseUI = null;
        this.mImageOrigin = -1;
        this.mScaleType = ImageResizeMode.defaultValue();
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
        this.mShowCnt = 0;
        this.mRepeat = false;
        this.mCoverStart = false;
        ImageDelegate imageDelegate = new ImageDelegate(context, new ImageDelegate.ImageResourceOperation() { // from class: com.lynx.tasm.ui.image.FrescoImageView.1
            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void clear() {
                FrescoImageView.this.setController(null);
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void markDirty() {
                FrescoImageView.this.markDirty();
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void onSourceSet() {
                FrescoImageView.this.onSourceSetted();
                if (FrescoImageView.this.mRef != null) {
                    FrescoImageView.this.mRef.close();
                    FrescoImageView.this.mRef = null;
                }
                if (FrescoImageView.this.mTempPlaceHolder != null) {
                    GenericDraweeHierarchy hierarchy = FrescoImageView.this.getHierarchy();
                    if (hierarchy != null) {
                        hierarchy.setPlaceholderImage((Drawable) null);
                    }
                    FrescoImageView.this.mTempPlaceHolder.close();
                    FrescoImageView.this.mTempPlaceHolder = null;
                }
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void maybeUpdateView() {
                FrescoImageView.this.maybeUpdateView();
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void onPostprocessorPreparing(List<Postprocessor> list) {
                FrescoImageView.this.onPostprocessorPreparing(list);
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public boolean isUseImagePostProcessor() {
                return FrescoImageView.this.mUsePostprocessorScaling;
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void onLocalCacheGet(CloseableReference<?> closeableReference) {
                Bitmap bitmap = null;
                if (FrescoImageView.this.mRef != null) {
                    FrescoImageView.this.mRef.close();
                    FrescoImageView.this.mRef = null;
                }
                FrescoImageView.this.mRef = closeableReference.clone();
                if (FrescoImageView.this.mLoaderCallback != null && FrescoImageView.this.mRef != null) {
                    Object obj2 = FrescoImageView.this.mRef.get();
                    if (obj2 instanceof CloseableBitmap) {
                        bitmap = ((CloseableBitmap) obj2).getUnderlyingBitmap();
                    } else if (obj2 instanceof Bitmap) {
                        bitmap = (Bitmap) obj2;
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        FrescoImageView.this.mLoaderCallback.onImageLoadSuccess(bitmap.getWidth(), bitmap.getHeight());
                    } else {
                        LLog.e("FrescoImageView", "onLocalCacheGet error bitmap is null or recycled");
                    }
                }
                FrescoImageView.this.postInvalidate();
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void fetchFrescoResource() {
                FrescoImageView frescoImageView = FrescoImageView.this;
                frescoImageView.tryFetchImageFromFresco(frescoImageView.getWidth(), FrescoImageView.this.getHeight(), FrescoImageView.this.getPaddingLeft(), FrescoImageView.this.getPaddingTop(), FrescoImageView.this.getPaddingRight(), FrescoImageView.this.getPaddingBottom());
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public ImageRequestBuilder createImageRequestBuilder(Uri uri) {
                return FrescoImageView.this.createImageRequestBuilder(uri);
            }
        });
        this.mImageDelegate = imageDelegate;
        imageDelegate.setHierarchy((GenericDraweeHierarchy) getHierarchy());
        setLynxBaseUI(lynxBaseUI);
    }

    public void setFrescoAttach() {
        doAttach();
    }

    public long getBitmapMemorySizeBytes() {
        ImageDelegate imageDelegate = this.mImageDelegate;
        if (imageDelegate == null) {
            return 0L;
        }
        return imageDelegate.getBitmapMemorySizeBytes();
    }

    protected void onAttach() {
        this.mStartTimeStamp = System.currentTimeMillis();
        super.onAttach();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent) || this.mConsumeHoverEvent;
    }

    public void setConsumeHoverEvent(boolean z) {
        this.mConsumeHoverEvent = z;
    }

    public void setFrescoVisible() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setVisible(true, false);
        }
    }

    public void setBlurRadius(int i) {
        this.mImageDelegate.setBlurRadius(i);
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
        this.mIsDirty = true;
    }

    public void setBorderRadius(BorderRadius borderRadius) {
        this.mBorderRadii = borderRadius;
        this.mIsDirty = true;
        this.mIsBorderRadiusDirty = true;
    }

    public void setCapInsets(String str) {
        this.mImageDelegate.setCapInsets(str);
    }

    public void setCapInsetsScale(String str) {
        this.mImageDelegate.setCapInsetsScale(str);
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.mScaleType = scaleType;
        this.mIsDirty = true;
    }

    public void setCoverStart(boolean z) {
        this.mCoverStart = z;
        this.mIsDirty = true;
    }

    public ScalingUtils.ScaleType getFrescoScaleType() {
        return this.mScaleType;
    }

    public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
        this.mImageDelegate.setResizeMethod(imageResizeMethod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSourceSetted() {
        int i = this.mShowCnt + 1;
        this.mShowCnt = i;
        BigImageDrawingHelper bigImageDrawingHelper = this.mBigImageHelper;
        if (bigImageDrawingHelper != null) {
            bigImageDrawingHelper.setCnt(i);
        }
    }

    public void setSrc(String str) {
        this.mImageDelegate.setSrc(str);
    }

    public void setSrcSkippingRedirection(String str) {
        this.mImageDelegate.setSrcSkippingRedirection(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageRedirectListener(ImageAsyncRedirectListener imageAsyncRedirectListener) {
        this.mImageDelegate.setImageRedirectListener(imageAsyncRedirectListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRedirectImageSource(String str, String str2) {
        this.mImageDelegate.setRedirectImageSource(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateRedirectCheckResult(String str, String str2, boolean z, boolean z2) {
        this.mImageDelegate.updateRedirectCheckResult(str, str2, z, z2);
    }

    public void setPlaceholder(String str) {
        this.mImageDelegate.setPlaceholder(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlaceholder(String str, boolean z) {
        this.mImageDelegate.setPlaceholder(str, z);
    }

    public String getSrc() {
        if (this.mImageDelegate.getImageSource() != null) {
            return this.mImageDelegate.getImageSource().getUri().toString();
        }
        return null;
    }

    @Deprecated
    public void setSource(String str) {
        this.mImageDelegate.setSrcInternal(str);
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.mImageDelegate.setProgressiveRenderingEnabled(z);
    }

    public void setFadeDuration(int i) {
        this.mFadeDurationMs = i;
    }

    public void setNoSubSampleMode(boolean z) {
        this.mIsNoSubSampleMode = z;
    }

    public void setEnableCustomGifDecoder(boolean z) {
        this.mImageDelegate.setEnableCustomGifDecoder(z);
    }

    public void setHeaders(ReadableMap readableMap) {
        this.mImageDelegate.setHeaders(readableMap);
    }

    protected ImageRequestBuilder createImageRequestBuilder(Uri uri) {
        ImageRequestBuilder createImageRequestBuilder = this.mImageDelegate.createImageRequestBuilder(uri);
        ImageRequestBuilderHook imageRequestBuilderHook = this.mImageRequestBuilderHook;
        return imageRequestBuilderHook != null ? imageRequestBuilderHook.hookImageRequestBuilder(createImageRequestBuilder) : createImageRequestBuilder;
    }

    public void setImageRequestBuilderHook(ImageRequestBuilderHook imageRequestBuilderHook) {
        this.mImageRequestBuilderHook = imageRequestBuilderHook;
    }

    public void setRepeat(boolean z) {
        this.mRepeat = z;
    }

    public void setLocalCache(boolean z) {
        this.mImageDelegate.setUseLocalCache(z);
    }

    public void setAwaitLocalCache(boolean z) {
        this.mImageDelegate.setAwaitLocalCache(z);
    }

    public void setFrescoNinePatch(boolean z) {
        this.mFrescoNinePatch = z;
    }

    public void setAutoSize(boolean z) {
        this.mImageDelegate.setAutoSize(z);
    }

    public void setIsPixelated(boolean z) {
        this.mIsPixelated = z;
        this.mIsDirty = true;
    }

    protected ImageRequest createImageRequest(ImageSource imageSource, int i, int i2, int i3, int i4, int i5, int i6, float[] fArr, ScalingUtils.ScaleType scaleType) {
        return this.mImageDelegate.createImageRequest(imageSource, i, i2, i3, i4, i5, i6, fArr, scaleType);
    }

    public void setEnableResourceHint(boolean z) {
        this.mImageDelegate.setEnableResourceHint(z);
    }

    public void maybeUpdateView() {
        if ((!this.mIsDirty || ((getWidth() <= 0 || getHeight() <= 0) && !this.mImageDelegate.isAutoSize())) && this.mPreFetchWidth <= 0.0f && this.mPreFetchHeight <= 0.0f) {
            return;
        }
        if (getWidth() > 0 && getHeight() > 0) {
            maybeUpdateViewInternal(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } else {
            tryFetchImage((int) this.mPreFetchWidth, (int) this.mPreFetchHeight, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    private void maybeUpdateViewInternal(int i, int i2, int i3, int i4, int i5, int i6) {
        CloseableReference<?> closeableReference;
        if (this.mImageDelegate.getImageSource() == null && this.mImageDelegate.getImagePlaceholder() == null) {
            return;
        }
        if (!(ImageResizeUtils.shouldResize(this.mImageDelegate.getImageSource(), this.mImageDelegate.getResizeMethod()) && !this.mImageDelegate.isAutoSize()) || (i > 0 && i2 > 0)) {
            this.mImageOrigin = -1;
            ImageLoaderCallback imageLoaderCallback = this.mLoaderCallback;
            if (imageLoaderCallback != null) {
                imageLoaderCallback.onImageStartLoad();
            }
            TraceEvent.beginSection(TraceEventDef.FRESCO_IMAGE_VIEW_MAYBE_UPDATE_INTERNAL);
            if (this.mImageDelegate.isUseLocalCache()) {
                if (this.mImageDelegate.enableGenericFetcher()) {
                    if (this.mImageDelegate.tryFetchImageFromMediaFetcher(i, i2, false)) {
                        TraceEvent.endSection(TraceEventDef.FRESCO_IMAGE_VIEW_MAYBE_UPDATE_INTERNAL);
                        return;
                    }
                } else {
                    this.mImageDelegate.tryFetchImageFromLocalCache(i, i2, false);
                }
            }
            if (this.mImageDelegate.isUseLocalCache() && (((closeableReference = this.mRef) != null && closeableReference.isValid() && this.mRef.get() != null) || this.mImageDelegate.isAwaitLocalCache())) {
                TraceEvent.endSection(TraceEventDef.FRESCO_IMAGE_VIEW_MAYBE_UPDATE_INTERNAL);
            } else {
                tryFetchImageFromFresco(i, i2, i3, i4, i5, i6);
                TraceEvent.endSection(TraceEventDef.FRESCO_IMAGE_VIEW_MAYBE_UPDATE_INTERNAL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryFetchImageFromFresco(int i, int i2, int i3, int i4, int i5, int i6) {
        float[] fArr;
        TraceEvent.beginSection(TraceEventDef.IMAGE_MANAGER_TRY_FETCH_FROM_FRESCO);
        GenericDraweeHierarchy hierarchy = getHierarchy();
        if (!this.mFixFrescoBug) {
            hierarchy.setActualImageScaleType(this.mScaleType);
        }
        if (this.mScaleType == ScalingUtils.ScaleType.CENTER_CROP && this.mCoverStart) {
            LynxCoverStartScaleType lynxCoverStartScaleType = new LynxCoverStartScaleType();
            this.mScaleType = lynxCoverStartScaleType;
            hierarchy.setActualImageScaleType(lynxCoverStartScaleType);
        }
        this.mUsePostprocessorScaling = (this.mImageDelegate.getEnableImageSR() || this.mScaleType == ScalingUtils.ScaleType.CENTER_CROP || this.mScaleType == ScalingUtils.ScaleType.FOCUS_CROP || this.mImageDelegate.isAutoSize() || this.mIsPixelated || this.mImageDelegate.setEnableResourceHint()) ? false : true;
        BorderRadius borderRadius = this.mBorderRadii;
        RoundingParams roundingParams = null;
        if (borderRadius != null) {
            if (borderRadius.updateSize(i + i3 + i5, i2 + i4 + i6)) {
                this.mIsBorderRadiusDirty = true;
            }
            fArr = adjustBorderRadiusArrayWithPadding(this.mBorderRadii.getArray());
        } else {
            fArr = null;
        }
        if (this.mIsBorderRadiusDirty) {
            if (!this.mUsePostprocessorScaling && fArr != null) {
                roundingParams = RoundingParams.fromCornersRadii(fArr);
                int i7 = this.mOverlayColor;
                if (i7 != 0) {
                    roundingParams.setOverlayColor(i7);
                } else {
                    roundingParams.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                }
            }
            hierarchy.setRoundingParams(roundingParams);
            this.mIsBorderRadiusDirty = true;
        }
        int i8 = this.mFadeDurationMs;
        if (i8 < 0) {
            i8 = 0;
        }
        hierarchy.setFadeDuration(i8);
        ImageRequest createImageRequest = createImageRequest(this.mImageDelegate.getImageSource(), i, i2, 0, 0, 0, 0, fArr, this.mScaleType);
        ImageRequest imageRequest = this.mCurImageRequest;
        this.mCurImageRequest = createImageRequest;
        ImageRequest createImageRequest2 = createImageRequest(this.mImageDelegate.getImagePlaceholder(), i, i2, 0, 0, 0, 0, fArr, this.mScaleType);
        if (this.mDeferInvalidation) {
            createImageRequest2 = imageRequest;
        }
        if (this.mGlobalImageLoadListener != null && this.mImageDelegate.getImageSource() != null) {
            this.mGlobalImageLoadListener.onLoadAttempt(this.mImageDelegate.getImageSource().getUri());
        }
        this.mDraweeControllerBuilder.reset();
        final WeakReference weakReference = new WeakReference(this);
        this.mDraweeControllerBuilder.setAutoPlayAnimations(this.mAutoPlay).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(createImageRequest).setRetainImageOnFailure(createImageRequest2 != null).setLowResImageRequest(createImageRequest2);
        final String rawSrc = this.mImageDelegate.getRawSrc();
        this.mStartTimeStamp = System.currentTimeMillis();
        this.mControllerListener = new BaseControllerListener<ImageInfo>() { // from class: com.lynx.tasm.ui.image.FrescoImageView.2
            public void onSubmit(String str, Object obj) {
            }

            public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                if (weakReference.get() != null) {
                    ((FrescoImageView) weakReference.get()).onImageRequestLoaded();
                }
                if (FrescoImageView.this.mDisableDefaultPlaceholder && (imageInfo instanceof CloseableStaticBitmap)) {
                    FrescoImageView.this.mTempPlaceHolder = ((CloseableStaticBitmap) imageInfo).cloneUnderlyingBitmapReference();
                    GenericDraweeHierarchy hierarchy2 = FrescoImageView.this.getHierarchy();
                    if (hierarchy2 != null && FrescoImageView.this.mTempPlaceHolder != null && FrescoImageView.this.mTempPlaceHolder.get() != null) {
                        hierarchy2.setPlaceholderImage(new ScaleTypeDrawable(new BitmapDrawable(FrescoImageView.this.getResources(), (Bitmap) FrescoImageView.this.mTempPlaceHolder.get()), FrescoImageView.this.mScaleType));
                    }
                }
                if (FrescoImageView.this.mIsPixelated && FrescoImageView.this.getTopLevelDrawable() != null) {
                    FrescoImageView.this.getTopLevelDrawable().setFilterBitmap(false);
                }
                FrescoImageView.this.mImageDelegate.handleImageSuccessCallback(FrescoImageView.this.getWidth(), FrescoImageView.this.getHeight(), imageInfo, animatable, FrescoImageView.this.mStartTimeStamp, false, FrescoImageView.this.mImageOrigin, FrescoImageView.this.mLoaderCallback);
            }

            public void onFailure(String str, Throwable th) {
                if (FrescoImageView.this.mImageDelegate.retryWithRawSrc(rawSrc)) {
                    return;
                }
                FrescoImageView.this.mIsDirty = true;
                int checkImageException = ImageErrorCodeUtils.checkImageException(th);
                int checkImageExceptionCategory = ImageErrorCodeUtils.checkImageExceptionCategory(checkImageException);
                if (FrescoImageView.this.mLoaderCallback != null) {
                    LynxError lynxError = new LynxError(checkImageExceptionCategory, "Android FrescoImageView loading image failed", "", "error");
                    if (th != null) {
                        lynxError.setRootCause(th.getMessage());
                    }
                    lynxError.addCustomInfo("node_index", Integer.toString(FrescoImageView.this.mLynxBaseUI != null ? FrescoImageView.this.mLynxBaseUI.getNodeIndex() : 0));
                    FrescoImageView.this.mLoaderCallback.onImageLoadFailed(lynxError, checkImageExceptionCategory, checkImageException);
                }
                FrescoImageView.this.mImageOrigin = -1;
                long currentTimeMillis = System.currentTimeMillis();
                FrescoImageView.this.mImageDelegate.monitorReporter(FrescoImageView.this.mImageDelegate.getRawSrc(), false, false, FrescoImageView.this.mStartTimeStamp, currentTimeMillis, 0, null);
                FrescoImageView.this.mImageDelegate.reportImageInfo(FrescoImageView.this.mImageDelegate.getRawSrc(), false, false, FrescoImageView.this.mStartTimeStamp, currentTimeMillis, checkImageException, 0);
                FrescoImageView.this.mImageDelegate.reportImageEvent(FrescoImageView.this.mImageDelegate.getRawSrc(), checkImageException, false, FrescoImageView.this.mImageOrigin, FrescoImageView.this.mStartTimeStamp, currentTimeMillis, false, 0, 0);
                LLog.e("FrescoImageView", "onFailed src:" + rawSrc + "with reason" + th.getMessage());
            }
        };
        this.mWeakImageOriginListener = new WeakImageOriginListener(this);
        if (this.mControllerForTesting == null) {
            this.mDraweeControllerBuilder.setControllerListener(this.mControllerListener);
        } else {
            ForwardingControllerListener forwardingControllerListener = new ForwardingControllerListener();
            forwardingControllerListener.addListener(this.mControllerListener);
            forwardingControllerListener.addListener(this.mControllerForTesting);
            this.mDraweeControllerBuilder.setControllerListener(forwardingControllerListener);
        }
        if (LynxLiteConfigs.enableNewFresco()) {
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = this.mDraweeControllerBuilder;
            if (pipelineDraweeControllerBuilder instanceof PipelineDraweeControllerBuilder) {
                pipelineDraweeControllerBuilder.setImageOriginListener(this.mWeakImageOriginListener);
            }
        }
        setController(this.mDraweeControllerBuilder.build());
        this.mIsDirty = false;
        this.mImageDelegate.setLastWidth(i);
        this.mImageDelegate.setLastHeight(i2);
        this.mDraweeControllerBuilder.reset();
        TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_TRY_FETCH_FROM_FRESCO);
    }

    public void setControllerListener(ControllerListener controllerListener) {
        this.mControllerForTesting = controllerListener;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        maybeUpdateView();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsFrescoVisible) {
            setFrescoVisible();
        }
        if (this.mIsFrescoAttach) {
            setFrescoAttach();
        }
    }

    public void setImageLoaderCallback(ImageLoaderCallback imageLoaderCallback) {
        this.mLoaderCallback = imageLoaderCallback;
    }

    private float[] adjustBorderRadiusArrayWithPadding(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return null;
        }
        float[] fArr2 = new float[8];
        fArr2[0] = getPaddingLeft();
        fArr2[1] = getPaddingTop();
        fArr2[2] = getPaddingRight();
        fArr2[3] = getPaddingTop();
        fArr2[4] = getPaddingRight();
        fArr2[5] = getPaddingBottom();
        fArr2[6] = getPaddingLeft();
        fArr2[7] = getPaddingBottom();
        for (int i = 0; i < 8; i++) {
            fArr2[i] = Math.max(0.0f, fArr[i] - fArr2[i]);
        }
        return fArr2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            LLog.e("Lynx FrescoImageView", "catch onTouchEvent exception: " + th.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        DisplayMetrics screenMetrics;
        Bitmap bitmap;
        ImageLoaderCallback imageLoaderCallback = this.mLoaderCallback;
        if (imageLoaderCallback != null) {
            imageLoaderCallback.onImageDstSize(getWidth(), getHeight());
            if (this.mLoaderCallback.isPendingLoad()) {
                return;
            }
        }
        CloseableReference<?> closeableReference = this.mRef;
        if (closeableReference != null && closeableReference.isValid() && this.mImageDelegate.isUseLocalCache()) {
            Object obj = this.mRef.get();
            if (obj instanceof CloseableBitmap) {
                bitmap = ((CloseableBitmap) obj).getUnderlyingBitmap();
            } else {
                bitmap = obj instanceof Bitmap ? (Bitmap) obj : null;
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                LLog.i("Lynx Android Image", "draw image from local cache");
                if (BaseRoundedCornerPostprocessor.customDraw(canvas.getWidth(), canvas.getHeight(), bitmap2.getWidth(), bitmap2.getHeight(), this.mScaleType, this.mImageDelegate.getCapInsets(), this.mImageDelegate.getCapInsetsScale(), canvas, bitmap2)) {
                    return;
                }
            }
        }
        if (!this.mFrescoNinePatch && this.mImageDelegate.getCapInsets() != null) {
            LLog.i("Lynx Android Image", "load origin bitmap to draw image with cap-insets");
            if (this.mBigImageHelper == null) {
                this.mBigImageHelper = new BigImageDrawingHelper(new ImageHelperCallback(), this.mShowCnt);
            }
            if (this.mBigImageHelper.drawImageWithCapInsets(getContext(), canvas, this.mCurImageRequest, new BigImageDrawingHelper.ImageBaseData(this.mShowCnt, getWidth(), getHeight(), this.mRepeat, this.mScaleType, getSrc(), BigImageDrawingHelper.getMaxBitmapDimensions(canvas), this.mImageDelegate.getCapInsets(), this.mImageDelegate.getCapInsetsScale()))) {
                return;
            }
        }
        if (TraceEvent.enableTrace()) {
            HashMap hashMap = new HashMap();
            LynxBaseUI lynxBaseUI = this.mLynxBaseUI;
            if (lynxBaseUI != null && lynxBaseUI.getLynxContext() != null) {
                hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(this.mLynxBaseUI.getLynxContext().getInstanceId()));
            }
            TraceEvent.beginSection(TraceEventDef.FRESCO_IMAGE_VIEW_ON_DRAW, hashMap);
        }
        if (this.mIsNoSubSampleMode || (getController() != null && getController().getAnimatable() == null && this.mImageDelegate.getCapInsets() == null)) {
            if (this.mBigImageHelper == null) {
                this.mBigImageHelper = new BigImageDrawingHelper(new ImageHelperCallback(), this.mShowCnt);
            }
            BigImageDrawingHelper.ImageBaseData imageBaseData = new BigImageDrawingHelper.ImageBaseData(this.mShowCnt, getWidth(), getHeight(), this.mRepeat, this.mScaleType, getSrc(), BigImageDrawingHelper.getMaxBitmapDimensions(canvas), this.mImageDelegate.getCapInsets(), this.mImageDelegate.getCapInsetsScale());
            if (this.mIsNoSubSampleMode && this.mBigImageHelper.drawImageWithoutSubSample(getContext(), canvas, this.mCurImageRequest, imageBaseData)) {
                TraceEvent.endSection(TraceEventDef.FRESCO_IMAGE_VIEW_ON_DRAW);
                return;
            }
            LynxBaseUI lynxBaseUI2 = this.mLynxBaseUI;
            if (lynxBaseUI2 == null) {
                screenMetrics = DisplayMetricsHolder.getRealScreenDisplayMetrics(getContext());
            } else {
                screenMetrics = lynxBaseUI2.getLynxContext().getScreenMetrics();
            }
            if (this.mBigImageHelper.drawBigImage(getContext(), canvas, this.mCurImageRequest, imageBaseData, screenMetrics)) {
                TraceEvent.endSection(TraceEventDef.FRESCO_IMAGE_VIEW_ON_DRAW);
                return;
            }
        }
        try {
            super.onDraw(canvas);
        } catch (OutOfMemoryError e) {
            LLog.e("FrescoImageView", e.getMessage());
        }
        TraceEvent.endSection(TraceEventDef.FRESCO_IMAGE_VIEW_ON_DRAW);
    }

    public void startAnimate() {
        if (getController() == null || getController().getAnimatable() == null) {
            return;
        }
        getController().getAnimatable().start();
    }

    public boolean pauseAnimate() {
        if (getController() == null || getController().getAnimatable() == null) {
            return false;
        }
        AnimatedDrawable2 animatable = getController().getAnimatable();
        if (animatable instanceof AnimatedDrawable2) {
            return ByteDanceFrescoUtils.pauseAnimation(animatable);
        }
        return false;
    }

    public void stopAnimate() {
        if (getController() == null || getController().getAnimatable() == null) {
            return;
        }
        getController().getAnimatable().stop();
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mImageDelegate.setBitmapConfig(config);
    }

    public int bitmapMemorySize(int i, int i2) {
        ImageDelegate imageDelegate = this.mImageDelegate;
        if (imageDelegate == null) {
            return 0;
        }
        return imageDelegate.bitmapMemorySize(i, i2);
    }

    public void setLoopCount(int i) {
        this.mImageDelegate.setLoopCount(i);
    }

    public void setPreFetchWidth(float f) {
        this.mPreFetchWidth = f;
    }

    public void setPreFetchHeight(float f) {
        this.mPreFetchHeight = f;
    }

    public void setDisableDefaultPlaceHolder(boolean z) {
        this.mDisableDefaultPlaceholder = z;
    }

    protected int getLoopCount() {
        return this.mImageDelegate.getLoopCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSimpleCacheKey(boolean z) {
        this.mImageDelegate.setSimpleCacheKey(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageTransitionStyle(String str) {
        if (ImageDelegate.FADE_IN_STYLE.equals(str)) {
            this.mFadeDurationMs = 300;
        } else {
            this.mFadeDurationMs = 0;
        }
    }

    public void destroy() {
        BigImageDrawingHelper bigImageDrawingHelper = this.mBigImageHelper;
        if (bigImageDrawingHelper != null) {
            bigImageDrawingHelper.destroy();
        }
        CloseableReference<?> closeableReference = this.mRef;
        if (closeableReference != null) {
            closeableReference.close();
            this.mRef = null;
        }
        this.mImageDelegate.onDetach();
        if (this.mTempPlaceHolder != null) {
            GenericDraweeHierarchy hierarchy = getHierarchy();
            if (hierarchy != null) {
                hierarchy.setPlaceholderImage((Drawable) null);
            }
            this.mTempPlaceHolder.close();
            this.mTempPlaceHolder = null;
        }
    }

    public void markDirty() {
        this.mIsDirty = true;
    }

    public void tryFetchImage(int i, int i2, int i3, int i4, int i5, int i6) {
        maybeUpdateViewInternal(i, i2, i3, i4, i5, i6);
    }

    public void fixFrescoWebPBug(boolean z) {
        this.mFixFrescoBug = z;
    }

    void setLynxBaseUI(LynxBaseUI lynxBaseUI) {
        this.mLynxBaseUI = lynxBaseUI;
        this.mImageDelegate.setLynxBaseUI(lynxBaseUI);
    }

    public void setImageRequestPriority(String str) {
        this.mImageDelegate.setImageRequestPriority(str);
    }

    public void setImageCacheChoice(String str) {
        this.mImageDelegate.setImageCacheChoice(str);
    }

    public void setImagePlaceHolderHashConfig(ReadableMap readableMap) {
        this.mImageDelegate.setImagePlaceHolderHashConfig(readableMap);
    }

    public void setDeferInvalidation(boolean z) {
        this.mDeferInvalidation = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageEvents(Map<String, EventsListener> map) {
        this.mImageDelegate.setImageEvents(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTintColor(String str) {
        PorterDuffColorFilter porterDuffColorFilter = !ColorUtils.isValid(str) ? null : new PorterDuffColorFilter(ColorUtils.parse(str), PorterDuff.Mode.SRC_IN);
        if (getHierarchy() != null) {
            getHierarchy().setActualImageColorFilter(porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtraLoadInfo(boolean z) {
        this.mImageDelegate.setExtraLoadInfo(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNodeReady() {
        this.mImageDelegate.onNodeReady();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageCustomParams(ReadableMap readableMap) {
        this.mImageDelegate.setImageCustomParams(readableMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnableImageSR(boolean z) {
        this.mImageDelegate.setEnableImageSR(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageSRScale(float f) {
        this.mImageDelegate.setImageSRScale(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAsyncRedirect(boolean z) {
        this.mImageDelegate.setEnableAsyncRedirect(z);
    }
}
