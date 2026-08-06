package com.lynx.tasm.p001ui.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.p001ui.image.FrescoImageView;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.lynx.tasm.p001ui.image.helper.ByteDanceFrescoUtils;
import com.lynx.tasm.p001ui.image.helper.ImageSource;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.ContextUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxImageManager {
    private static Handler sUIHandler = new Handler(Looper.getMainLooper());
    private boolean isPixelated;
    private Animatable mAnimatable;
    private Bitmap mAsyncBitmap;
    private CloseableReference<?> mAsyncDrawImage;
    private boolean mAutoPlay;
    private boolean mBitmapFromCache;
    private BorderRadius mBorderRadii;
    private CacheKey mCacheKey;
    private final Object mCallerContext;
    private CloseableReference<CloseableImage> mCloseableImage;
    private ColorFilter mColorFilter;
    private final Context mContext;
    private ControllerListener mControllerListener;
    private ImageRequest mCurImageRequest;
    private DefaultDrawableFactory mDefaultDrawableFactory;
    private volatile boolean mDeferInvalidation;
    private DrawableReadyListener mDrawableReadyListener;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private DraweeHolder<GenericDraweeHierarchy> mDraweeHolder;
    private boolean mEnableAsyncCallback;
    private boolean mEnableAsyncRequestImage;
    private int mFadeDurationMs;
    private GenericDraweeHierarchy mGenericDraweeHierarchy;
    private int mHeight;
    private ImageDelegate mImageDelegate;
    private int mImageOrigin;
    private ImageRequestBuilderHook mImageRequestBuilderHook;
    private View mImageSrSizeView;
    private boolean mIsAttached;
    private boolean mIsBorderRadiusDirty;
    protected boolean mIsDirty;
    private boolean mIsUsedForBackgroundImage;
    ImageLoaderCallback mLoaderCallback;
    private LynxBaseUI mLynxBaseUI;
    private LynxContext mLynxContext;
    private LynxDraweeControllerBuilder mLynxDraweeControllerBuilder;
    private LynxDraweeHolder<GenericDraweeHierarchy> mLynxDraweeHolder;
    private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private boolean mNeedExtraLoadInfo;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private CloseableReference<?> mPreAsyncDrawImage;
    private DraweeHolder<GenericDraweeHierarchy> mPreDraweeHolder;
    private LynxDraweeHolder<GenericDraweeHierarchy> mPreLynxDraweeHolder;
    private TemporaryDraweeHolder mPreTemporaryDraweeHolder;
    private CloseableReference<?> mRef;
    private RoundingParams mRoundingParams;
    private ScalingUtils.ScaleType mScaleType;
    private boolean mScaleTypeDirty;
    private long mStartTimeStamp;
    private boolean mSyncAttach;
    private TemporaryDraweeHolder mTemporaryDraweeHolder;
    private boolean mUseImagePostProcessor;
    private WeakImageOriginListener mWeakImageOriginListener;
    private WeakReference<FlattenUIImage> mWeakUI;
    private int mWidth;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface DrawableReadyListener {
        void onCloseableRefReady(CloseableReference<?> closeableReference);

        void onDrawableReady(Drawable drawable);

        void onImageLoaded();
    }

    protected void onImageRequestLoaded() {
    }

    protected void onPostprocessorPreparing(List<Postprocessor> list) {
    }

    public void setFadeDuration(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class WeakImageOriginListener implements ImageOriginListener {
        private final WeakReference<LynxImageManager> mImageManagerRef;

        WeakImageOriginListener(LynxImageManager lynxImageManager) {
            this.mImageManagerRef = new WeakReference<>(lynxImageManager);
        }

        public void onImageLoaded(String str, int i, boolean z) {
            LynxImageManager lynxImageManager = this.mImageManagerRef.get();
            if (lynxImageManager != null) {
                lynxImageManager.mImageOrigin = i;
            }
        }
    }

    public LynxImageManager(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj, DrawableReadyListener drawableReadyListener) {
        this.mWidth = 0;
        this.mHeight = 0;
        this.mBorderRadii = null;
        this.mIsAttached = false;
        this.mIsUsedForBackgroundImage = false;
        this.mRef = null;
        this.mDeferInvalidation = false;
        this.mSyncAttach = false;
        this.mUseImagePostProcessor = false;
        this.mLynxBaseUI = null;
        this.mAutoPlay = true;
        this.mColorFilter = null;
        this.mEnableAsyncRequestImage = false;
        this.mFadeDurationMs = 0;
        this.mImageOrigin = -1;
        this.mContext = context;
        this.mScaleType = ImageResizeMode.defaultValue();
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mCallerContext = obj;
        this.mDrawableReadyListener = drawableReadyListener;
        LynxContext lynxContext = ContextUtils.toLynxContext(context);
        this.mLynxContext = lynxContext;
        if (lynxContext != null) {
            this.mSyncAttach = lynxContext.isSyncImageAttach();
            this.mEnableAsyncCallback = this.mLynxContext.isEnableAsyncImageCallback();
            this.mEnableAsyncRequestImage = this.mLynxContext.isEnableAsyncRequestImage() || this.mEnableAsyncCallback || this.mLynxContext.isForceImageAsyncRequest() || LynxEnv.inst().enableImageAsyncRequest();
        }
        this.mUseImagePostProcessor = !LynxEnv.inst().disableImagePostProcessor();
        ImageDelegate imageDelegate = new ImageDelegate(context, new ImageDelegate.ImageResourceOperation() { // from class: com.lynx.tasm.ui.image.LynxImageManager.1
            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void clear() {
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void onPostprocessorPreparing(List<Postprocessor> list) {
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void markDirty() {
                LynxImageManager.this.setDirty(true);
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void onSourceSet() {
                if (LynxImageManager.this.mRef != null) {
                    LynxImageManager.this.mRef.close();
                    LynxImageManager.this.mRef = null;
                }
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void maybeUpdateView() {
                LynxImageManager lynxImageManager = LynxImageManager.this;
                lynxImageManager.maybeUpdateView(lynxImageManager.mWidth, LynxImageManager.this.mHeight, LynxImageManager.this.mPaddingLeft, LynxImageManager.this.mPaddingTop, LynxImageManager.this.mPaddingRight, LynxImageManager.this.mPaddingBottom);
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public boolean isUseImagePostProcessor() {
                return LynxImageManager.this.mUseImagePostProcessor;
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void onLocalCacheGet(CloseableReference<?> closeableReference) {
                Bitmap bitmap = null;
                if (LynxImageManager.this.mRef != null) {
                    LynxImageManager.this.mRef.close();
                    LynxImageManager.this.mRef = null;
                }
                LynxImageManager.this.mRef = closeableReference.clone();
                if (LynxImageManager.this.mLoaderCallback != null && LynxImageManager.this.mRef != null) {
                    Object obj2 = LynxImageManager.this.mRef.get();
                    if (obj2 instanceof CloseableBitmap) {
                        bitmap = ((CloseableBitmap) obj2).getUnderlyingBitmap();
                    } else if (obj2 instanceof Bitmap) {
                        bitmap = (Bitmap) obj2;
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        LynxImageManager.this.mLoaderCallback.onImageLoadSuccess(bitmap.getWidth(), bitmap.getHeight());
                    } else {
                        LLog.e(com.lynx.tasm.behavior.p000ui.image.LynxImageManager.TAG, "onLocalCacheGet error bitmap is null or recycled");
                    }
                }
                LynxImageManager.this.mDrawableReadyListener.onCloseableRefReady(LynxImageManager.this.mRef);
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public void fetchFrescoResource() {
                if (LynxImageManager.this.mEnableAsyncRequestImage) {
                    LynxImageManager lynxImageManager = LynxImageManager.this;
                    lynxImageManager.tryFetchImageFromFrescoAsync(lynxImageManager.mWidth, LynxImageManager.this.mHeight, LynxImageManager.this.mPaddingLeft, LynxImageManager.this.mPaddingTop, LynxImageManager.this.mPaddingRight, LynxImageManager.this.mPaddingBottom);
                } else {
                    LynxImageManager lynxImageManager2 = LynxImageManager.this;
                    lynxImageManager2.tryFetchImageFromFresco(lynxImageManager2.mWidth, LynxImageManager.this.mHeight, LynxImageManager.this.mPaddingLeft, LynxImageManager.this.mPaddingTop, LynxImageManager.this.mPaddingRight, LynxImageManager.this.mPaddingBottom);
                }
            }

            @Override // com.lynx.tasm.ui.image.ImageDelegate.ImageResourceOperation
            public ImageRequestBuilder createImageRequestBuilder(Uri uri) {
                return LynxImageManager.this.createImageRequestBuilder(uri);
            }
        });
        this.mImageDelegate = imageDelegate;
        imageDelegate.setEnableAsyncRequestImage(this.mEnableAsyncRequestImage);
        if (this.mEnableAsyncRequestImage) {
            initAsyncRequestHolder();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAsyncBitmapInValid() {
        Bitmap bitmap = this.mAsyncBitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            return false;
        }
        LLog.e("Lynx-Image", "bitmap has recycled and bitmap from cache is " + this.mBitmapFromCache);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnableAsyncRequest() {
        return this.mEnableAsyncRequestImage;
    }

    private void initAsyncRequestHolder() {
        this.mMemoryCache = Fresco.getImagePipeline().getBitmapMemoryCache();
        this.mDefaultDrawableFactory = new DefaultDrawableFactory(this.mContext.getResources(), Fresco.getImagePipelineFactory().getAnimatedDrawableFactory(this.mContext));
        this.mLynxDraweeControllerBuilder = new LynxDraweeControllerBuilder(this.mContext, this.mDefaultDrawableFactory);
        GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(this.mContext.getResources()).setActualImageScaleType(ImageResizeMode.getRealScaleType(this.mScaleType)).setFadeDuration(0).build();
        this.mGenericDraweeHierarchy = build;
        this.mLynxDraweeHolder = LynxDraweeHolder.create(build);
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            LynxFeatureCounter.count(74, lynxContext.getInstanceId());
        }
        this.mControllerListener = new BaseControllerListener<ImageInfo>() { // from class: com.lynx.tasm.ui.image.LynxImageManager.2
            public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                LynxImageManager.this.updateHierarchyProps();
                if (LynxImageManager.this.mDeferInvalidation) {
                    LynxImageManager.sUIHandler.post(new Runnable() { // from class: com.lynx.tasm.ui.image.LynxImageManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LynxImageManager.this.mDrawableReadyListener != null) {
                                LynxImageManager.this.mDrawableReadyListener.onDrawableReady(LynxImageManager.this.mLynxDraweeHolder.getTopLevelDrawable());
                            }
                            if (LynxImageManager.this.mPreLynxDraweeHolder != null) {
                                LynxImageManager.this.mPreLynxDraweeHolder.onDetach();
                                LynxImageManager.this.mPreLynxDraweeHolder = null;
                            }
                            if (LynxImageManager.this.mPreAsyncDrawImage != null) {
                                CloseableReference.closeSafely(LynxImageManager.this.mPreAsyncDrawImage);
                                LynxImageManager.this.mPreAsyncDrawImage = null;
                            }
                        }
                    });
                }
                LynxImageManager.this.mAnimatable = animatable;
                LynxImageManager.this.mBitmapFromCache = false;
                if (imageInfo instanceof CloseableStaticBitmap) {
                    CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) imageInfo;
                    LynxImageManager.this.mAsyncBitmap = closeableStaticBitmap.getUnderlyingBitmap();
                    if (!LynxImageManager.this.mDeferInvalidation) {
                        LynxImageManager.this.closeDrawImage();
                    } else {
                        LynxImageManager lynxImageManager = LynxImageManager.this;
                        lynxImageManager.mPreAsyncDrawImage = lynxImageManager.mAsyncDrawImage;
                    }
                    LynxImageManager.this.mAsyncDrawImage = closeableStaticBitmap.cloneUnderlyingBitmapReference();
                }
                if (LynxImageManager.this.mCloseableImage != null) {
                    LynxImageManager.this.clearAsyncCache();
                }
                LynxImageManager.this.mImageDelegate.handleImageSuccessCallback(LynxImageManager.this.mWidth, LynxImageManager.this.mHeight, imageInfo, animatable, LynxImageManager.this.mStartTimeStamp, true, LynxImageManager.this.mImageOrigin, LynxImageManager.this.mLoaderCallback);
            }

            public void onFailure(String str, Throwable th) {
                LynxImageManager.this.mBitmapFromCache = false;
                LynxImageManager.this.updateHierarchyProps();
                LynxImageManager.this.handlerFailure(th);
            }
        };
        this.mWeakImageOriginListener = new WeakImageOriginListener(this);
        this.mImageDelegate.setHierarchy(this.mGenericDraweeHierarchy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerFailure(Throwable th) {
        ImageDelegate imageDelegate = this.mImageDelegate;
        if (imageDelegate.retryWithRawSrc(imageDelegate.getRawSrc())) {
            return;
        }
        LLog.e("FrescoImageView", "onFailed src:" + this.mImageDelegate.getRawSrc() + "with reason" + th.getMessage());
        int checkImageException = ImageErrorCodeUtils.checkImageException(th);
        int checkImageExceptionCategory = ImageErrorCodeUtils.checkImageExceptionCategory(checkImageException);
        this.mImageOrigin = -1;
        if (this.mLoaderCallback != null) {
            String message = th.getMessage();
            if (TextUtils.isEmpty(message) && (message = Log.getStackTraceString(th)) != null && message.length() > 200) {
                message = message.substring(0, 200);
            }
            LynxError lynxError = new LynxError(checkImageExceptionCategory, "Android LynxImageManager loading image failed", "", "error");
            lynxError.setRootCause(message);
            LynxBaseUI lynxBaseUI = this.mLynxBaseUI;
            lynxError.addCustomInfo("node_index", Integer.toString(lynxBaseUI != null ? lynxBaseUI.getNodeIndex() : 0));
            this.mLoaderCallback.onImageLoadFailed(lynxError, checkImageExceptionCategory, checkImageException);
        }
        long currentTimeMillis = System.currentTimeMillis();
        ImageDelegate imageDelegate2 = this.mImageDelegate;
        imageDelegate2.monitorReporter(imageDelegate2.getRawSrc(), false, false, this.mStartTimeStamp, currentTimeMillis, 0, null);
        ImageDelegate imageDelegate3 = this.mImageDelegate;
        imageDelegate3.reportImageInfo(imageDelegate3.getRawSrc(), false, false, this.mStartTimeStamp, currentTimeMillis, checkImageException, 0);
        ImageDelegate imageDelegate4 = this.mImageDelegate;
        imageDelegate4.reportImageEvent(imageDelegate4.getRawSrc(), checkImageException, false, this.mImageOrigin, this.mStartTimeStamp, currentTimeMillis, true, 0, 0);
    }

    public LynxImageManager(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj, DrawableReadyListener drawableReadyListener, boolean z) {
        this(context, abstractDraweeControllerBuilder, globalImageLoadListener, obj, drawableReadyListener);
        this.mIsUsedForBackgroundImage = z;
        this.mImageDelegate.setIsUsedForBackgroundImage(z);
    }

    public DraweeHolder getDraweeHolder() {
        return this.mDraweeHolder;
    }

    public long getBitmapMemorySizeBytes() {
        ImageDelegate imageDelegate = this.mImageDelegate;
        if (imageDelegate == null) {
            return 0L;
        }
        return imageDelegate.getBitmapMemorySizeBytes();
    }

    public boolean isAnimated() {
        if (this.mEnableAsyncRequestImage) {
            return this.mAnimatable != null;
        }
        DraweeHolder<GenericDraweeHierarchy> draweeHolder = this.mDraweeHolder;
        return (draweeHolder == null || draweeHolder.getController() == null || this.mDraweeHolder.getController().getAnimatable() == null) ? false : true;
    }

    public void pauseAnimation(Callback callback) {
        Animatable animatable;
        if (isAnimated()) {
            if (this.mEnableAsyncRequestImage) {
                animatable = this.mAnimatable;
            } else {
                animatable = getDraweeHolder().getController().getAnimatable();
            }
            if (animatable instanceof AnimatedDrawable2) {
                if (ByteDanceFrescoUtils.pauseAnimation((AnimatedDrawable2) animatable)) {
                    callback.invoke(new Object[]{0, "Animation paused."});
                } else {
                    callback.invoke(new Object[]{4, "Not support pause yet"});
                }
            }
        }
    }

    public void resumeAnimation(Callback callback) {
        Animatable animatable;
        if (isAnimated()) {
            if (this.mEnableAsyncRequestImage) {
                animatable = this.mAnimatable;
            } else {
                animatable = getDraweeHolder().getController().getAnimatable();
            }
            animatable.start();
            callback.invoke(new Object[]{0, "Animation resumed."});
        }
    }

    public void stopAnimation(Callback callback) {
        Animatable animatable;
        if (isAnimated()) {
            if (this.mEnableAsyncRequestImage) {
                animatable = this.mAnimatable;
            } else {
                animatable = getDraweeHolder().getController().getAnimatable();
            }
            animatable.stop();
            callback.invoke(new Object[]{0, "Animation stopped."});
        }
    }

    public void startAnimate() {
        if (isAnimated()) {
            if (this.mEnableAsyncRequestImage) {
                this.mAnimatable.stop();
                this.mAnimatable.start();
            } else {
                getDraweeHolder().getController().getAnimatable().stop();
                getDraweeHolder().getController().getAnimatable().start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLynxBaseUI(LynxBaseUI lynxBaseUI) {
        this.mLynxBaseUI = lynxBaseUI;
        if (this.mEnableAsyncRequestImage) {
            this.mWeakUI = new WeakReference<>((FlattenUIImage) this.mLynxBaseUI);
        }
        this.mImageDelegate.setLynxBaseUI(lynxBaseUI);
    }

    public void onAttach() {
        this.mIsAttached = true;
        if (this.mEnableAsyncRequestImage) {
            this.mStartTimeStamp = System.currentTimeMillis();
            this.mLynxDraweeHolder.onAttach();
        } else if (this.mDraweeHolder != null) {
            this.mStartTimeStamp = System.currentTimeMillis();
            this.mDraweeHolder.onAttach();
        }
    }

    public void onDetach() {
        this.mIsAttached = false;
        if (this.mEnableAsyncRequestImage) {
            if (this.mCloseableImage != null) {
                clearAsyncCache();
            }
            LynxDraweeHolder<GenericDraweeHierarchy> lynxDraweeHolder = this.mLynxDraweeHolder;
            if (lynxDraweeHolder != null) {
                lynxDraweeHolder.onDetach();
            }
            this.mAsyncBitmap = null;
            closeDrawImage();
            GenericDraweeHierarchy genericDraweeHierarchy = this.mGenericDraweeHierarchy;
            if (genericDraweeHierarchy != null) {
                genericDraweeHierarchy.reset();
            }
        } else {
            detachHolder();
        }
        this.mImageDelegate.onDetach();
        CloseableReference<?> closeableReference = this.mRef;
        if (closeableReference != null) {
            closeableReference.close();
            this.mRef = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detachHolder() {
        DraweeHolder<GenericDraweeHierarchy> draweeHolder = this.mDraweeHolder;
        if (draweeHolder != null) {
            draweeHolder.onDetach();
        }
        TemporaryDraweeHolder temporaryDraweeHolder = this.mTemporaryDraweeHolder;
        if (temporaryDraweeHolder != null) {
            temporaryDraweeHolder.onDetach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDrawImage() {
        CloseableReference<?> closeableReference = this.mAsyncDrawImage;
        if (closeableReference != null) {
            CloseableReference.closeSafely(closeableReference);
            this.mAsyncDrawImage = null;
        }
    }

    public void setBlurRadius(int i) {
        this.mImageDelegate.setBlurRadius(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAsyncRequest(boolean z) {
        this.mEnableAsyncRequestImage = z;
        this.mImageDelegate.setEnableAsyncRequestImage(z);
        if (this.mEnableAsyncRequestImage) {
            detachHolder();
            if (this.mLynxDraweeHolder == null) {
                initAsyncRequestHolder();
            }
            if (this.mWeakUI == null) {
                this.mWeakUI = new WeakReference<>((FlattenUIImage) this.mLynxBaseUI);
            }
        } else {
            if (this.mCloseableImage != null) {
                clearAsyncCache();
            }
            LynxDraweeHolder<GenericDraweeHierarchy> lynxDraweeHolder = this.mLynxDraweeHolder;
            if (lynxDraweeHolder != null) {
                lynxDraweeHolder.onDetach();
            }
            this.mAsyncBitmap = null;
            closeDrawImage();
        }
        this.mIsDirty = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnableCustomGifDecoder(boolean z) {
        this.mImageDelegate.setEnableCustomGifDecoder(z);
    }

    public void setBorderRadius(BorderRadius borderRadius) {
        if (this.mBorderRadii == borderRadius) {
            if (borderRadius == null || !borderRadius.hasArray()) {
                this.mIsDirty = true;
            }
        } else {
            this.mBorderRadii = borderRadius;
            this.mIsDirty = true;
        }
        this.mIsBorderRadiusDirty = true;
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.mScaleType = scaleType;
        this.mScaleTypeDirty = true;
        this.mIsDirty = true;
    }

    public ScalingUtils.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public ScalingUtils.ScaleType getFrescoScaleType() {
        return this.mScaleType;
    }

    public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
        this.mImageDelegate.setResizeMethod(imageResizeMethod);
    }

    public void setCapInsets(String str) {
        this.mImageDelegate.setCapInsets(str);
    }

    public void setCapInsetsScale(String str) {
        this.mImageDelegate.setCapInsetsScale(str);
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

    public void setSrcSkippingRedirection(String str) {
        this.mImageDelegate.setSrcSkippingRedirection(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageRedirectListener(ImageAsyncRedirectListener imageAsyncRedirectListener) {
        this.mImageDelegate.setImageRedirectListener(imageAsyncRedirectListener);
    }

    public void setSrc(String str) {
        this.mImageDelegate.setSrc(str);
    }

    public void setPlaceholder(String str) {
        this.mImageDelegate.setPlaceholder(str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlaceholder(String str, boolean z) {
        this.mImageDelegate.setPlaceholder(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRedirectImageSource(String str, String str2) {
        this.mImageDelegate.setRedirectImageSource(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateRedirectCheckResult(String str, String str2, boolean z, boolean z2) {
        this.mImageDelegate.updateRedirectCheckResult(str, str2, z, z2);
    }

    public String getSrc() {
        if (this.mImageDelegate.getImageSource() != null) {
            return this.mImageDelegate.getImageSource().getUri().toString();
        }
        return null;
    }

    public String getRawSrc() {
        return this.mImageDelegate.getRawSrc();
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.mImageDelegate.setProgressiveRenderingEnabled(z);
    }

    public void setHeaders(ReadableMap readableMap) {
        this.mImageDelegate.setHeaders(readableMap);
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mImageDelegate.setBitmapConfig(config);
    }

    public void setAutoSize(boolean z) {
        this.mImageDelegate.setAutoSize(z);
        this.mUseImagePostProcessor = !z;
    }

    protected ImageRequestBuilder createImageRequestBuilder(Uri uri) {
        ImageRequestBuilder createImageRequestBuilder = this.mImageDelegate.createImageRequestBuilder(uri);
        ImageRequestBuilderHook imageRequestBuilderHook = this.mImageRequestBuilderHook;
        return imageRequestBuilderHook != null ? imageRequestBuilderHook.hookImageRequestBuilder(createImageRequestBuilder) : createImageRequestBuilder;
    }

    public void setImageRequestBuilderHook(ImageRequestBuilderHook imageRequestBuilderHook) {
        this.mImageRequestBuilderHook = imageRequestBuilderHook;
    }

    protected ImageRequest createImageRequest(ImageSource imageSource, int i, int i2, int i3, int i4, int i5, int i6, float[] fArr, ScalingUtils.ScaleType scaleType) {
        return this.mImageDelegate.createImageRequest(imageSource, i, i2, i3, i4, i5, i6, fArr, scaleType);
    }

    private void updatePostProcessorValue(int i, int i2, int i3, int i4, float[] fArr, ScalingUtils.ScaleType scaleType) {
        if (this.mImageDelegate.setEnableResourceHint()) {
            this.mUseImagePostProcessor = false;
            return;
        }
        if (this.isPixelated) {
            this.mUseImagePostProcessor = false;
            return;
        }
        if (this.mImageDelegate.getEnableImageSR()) {
            this.mUseImagePostProcessor = false;
            return;
        }
        if (this.mUseImagePostProcessor) {
            return;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            this.mUseImagePostProcessor = true;
            return;
        }
        if (this.mImageDelegate.getCapInsets() != null) {
            this.mUseImagePostProcessor = true;
            return;
        }
        if (this.mImageDelegate.getIterativeBoxBlurPostProcessor() != null) {
            this.mUseImagePostProcessor = true;
        } else {
            if (fArr == null || scaleType == ScalingUtils.ScaleType.CENTER_CROP || scaleType == ScalingUtils.ScaleType.FOCUS_CROP || scaleType == ScalingUtils.ScaleType.FIT_XY) {
                return;
            }
            this.mUseImagePostProcessor = true;
        }
    }

    public void maybeUpdateView(int i, int i2, int i3, int i4, int i5, int i6) {
        CloseableReference<?> closeableReference;
        setBounds(i, i2);
        setPadding(i3, i4, i5, i6);
        if (this.mIsDirty) {
            if ((i <= 0 || i2 <= 0) && !this.mImageDelegate.isAutoSize()) {
                return;
            }
            if (this.mImageDelegate.getImageSource() == null && this.mImageDelegate.getImagePlaceholder() == null) {
                return;
            }
            ImageLoaderCallback imageLoaderCallback = this.mLoaderCallback;
            if (imageLoaderCallback != null) {
                imageLoaderCallback.onImageStartLoad();
            }
            TraceEvent.beginSection(TraceEventDef.IMAGE_MANAGER_MAYBE_UPDATE_VIEW);
            if (this.mImageDelegate.isUseLocalCache()) {
                if (this.mImageDelegate.enableGenericFetcher()) {
                    if (this.mImageDelegate.tryFetchImageFromMediaFetcher(i, i2, true)) {
                        TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_MAYBE_UPDATE_VIEW);
                        return;
                    }
                } else {
                    this.mImageDelegate.tryFetchImageFromLocalCache(i, i2, true);
                }
            }
            this.mImageOrigin = -1;
            if (this.mImageDelegate.isUseLocalCache() && (((closeableReference = this.mRef) != null && closeableReference.isValid() && this.mRef.get() != null) || this.mImageDelegate.isAwaitLocalCache())) {
                TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_MAYBE_UPDATE_VIEW);
                return;
            }
            if (this.mEnableAsyncRequestImage) {
                tryFetchImageFromFrescoAsync(i, i2, i3, i4, i5, i6);
            } else {
                tryFetchImageFromFresco(i, i2, i3, i4, i5, i6);
            }
            TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_MAYBE_UPDATE_VIEW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryFetchImageFromFresco(int i, int i2, int i3, int i4, int i5, int i6) {
        float[] fArr;
        float[] fArr2;
        ILynxImageService iLynxImageService;
        View view;
        TraceEvent.beginSection(TraceEventDef.IMAGE_MANAGER_TRY_FETCH_FROM_FRESCO);
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        BorderRadius borderRadius = this.mBorderRadii;
        if (borderRadius != null) {
            borderRadius.updateSize(i, i2);
            fArr = this.mBorderRadii.getArray();
        } else {
            fArr = null;
        }
        updatePostProcessorValue(i3, i4, i5, i6, fArr, scaleType);
        if (this.mGenericDraweeHierarchy == null || this.mDeferInvalidation) {
            this.mGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder(this.mContext.getResources()).setRoundingParams((RoundingParams) null).build();
        } else {
            this.mGenericDraweeHierarchy.reset();
        }
        this.mImageDelegate.setHierarchy(this.mGenericDraweeHierarchy);
        float[] fArr3 = fArr;
        ImageRequest createImageRequest = createImageRequest(this.mImageDelegate.getImageSource(), i, i2, i3, i4, i5, i6, fArr, scaleType);
        if (this.mImageDelegate.getEnableImageSR() && (iLynxImageService = (ILynxImageService) LynxServiceCenter.inst().getService(ILynxImageService.class)) != null && (view = this.mImageSrSizeView) != null) {
            iLynxImageService.setImageSRSize(createImageRequest, view);
        }
        this.mCurImageRequest = createImageRequest;
        this.mStartTimeStamp = System.currentTimeMillis();
        if (this.mUseImagePostProcessor) {
            if (tryFetchImageFromPostProcessorCache(createImageRequest)) {
                TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_TRY_FETCH_FROM_FRESCO);
                return;
            } else {
                this.mRoundingParams = null;
                fArr2 = fArr3;
            }
        } else {
            fArr2 = fArr3;
            if (fArr2 != null && fArr2.length == 8) {
                this.mRoundingParams = RoundingParams.fromCornersRadii(fArr2);
            }
        }
        this.mImageDelegate.getRawSrc();
        RunnableC02383 runnableC02383 = new RunnableC02383(createImageRequest(this.mImageDelegate.getImagePlaceholder(), i, i2, i3, i4, i5, i6, fArr2, scaleType), createImageRequest);
        if (this.mSyncAttach && Looper.myLooper() == Looper.getMainLooper()) {
            runnableC02383.run();
        } else {
            ImageRequestJobScheduler.instance().schedule(runnableC02383);
        }
        this.mIsDirty = false;
        this.mImageDelegate.setLastWidth(i);
        this.mImageDelegate.setLastHeight(i2);
        TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_TRY_FETCH_FROM_FRESCO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.ui.image.LynxImageManager$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class RunnableC02383 implements Runnable {
        final /* synthetic */ ImageRequest val$imageRequest;
        final /* synthetic */ ImageRequest val$placeholderImageRequest;

        RunnableC02383(ImageRequest imageRequest, ImageRequest imageRequest2) {
            this.val$placeholderImageRequest = imageRequest;
            this.val$imageRequest = imageRequest2;
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceEvent.beginSection(TraceEventDef.IMAGE_MANAGER_REQUEST_JOB_SCHEDULER);
            if (LynxImageManager.this.mColorFilter != null) {
                LynxImageManager.this.mGenericDraweeHierarchy.setActualImageColorFilter(LynxImageManager.this.mColorFilter);
            }
            if (LynxImageManager.this.mDraweeHolder == null || LynxImageManager.this.mDeferInvalidation) {
                if (LynxImageManager.this.mDraweeHolder != null) {
                    LynxImageManager lynxImageManager = LynxImageManager.this;
                    lynxImageManager.mPreDraweeHolder = lynxImageManager.mDraweeHolder;
                }
                if (LynxImageManager.this.mDeferInvalidation && LynxImageManager.this.mTemporaryDraweeHolder != null) {
                    LynxImageManager lynxImageManager2 = LynxImageManager.this;
                    lynxImageManager2.mPreTemporaryDraweeHolder = lynxImageManager2.mTemporaryDraweeHolder;
                    LynxImageManager.this.mTemporaryDraweeHolder = null;
                }
                LynxImageManager lynxImageManager3 = LynxImageManager.this;
                lynxImageManager3.mDraweeHolder = DraweeHolder.create(lynxImageManager3.mGenericDraweeHierarchy, LynxImageManager.this.mContext);
            }
            LynxImageManager.this.mDraweeControllerBuilder.reset();
            ImageRequest imageRequest = this.val$placeholderImageRequest;
            LynxImageManager.this.mControllerListener = new BaseControllerListener<ImageInfo>() { // from class: com.lynx.tasm.ui.image.LynxImageManager.3.1
                public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                    GenericDraweeHierarchy hierarchy;
                    System.currentTimeMillis();
                    long unused = LynxImageManager.this.mStartTimeStamp;
                    if ((imageInfo instanceof CloseableStaticBitmap) && LynxImageManager.this.mDraweeHolder.hasHierarchy() && (hierarchy = LynxImageManager.this.mDraweeHolder.getHierarchy()) != null) {
                        hierarchy.setFadeDuration(LynxImageManager.this.mFadeDurationMs);
                    }
                    if (LynxImageManager.this.mDeferInvalidation) {
                        LynxImageManager.sUIHandler.post(new Runnable() { // from class: com.lynx.tasm.ui.image.LynxImageManager.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LynxImageManager.this.mDrawableReadyListener != null) {
                                    LynxImageManager.this.mDrawableReadyListener.onDrawableReady(LynxImageManager.this.mDraweeHolder.getTopLevelDrawable());
                                }
                                if (LynxImageManager.this.mPreDraweeHolder != null) {
                                    LynxImageManager.this.mPreDraweeHolder.onDetach();
                                    LynxImageManager.this.mPreDraweeHolder = null;
                                }
                                if (LynxImageManager.this.mPreTemporaryDraweeHolder != null) {
                                    LynxImageManager.this.mPreTemporaryDraweeHolder.onDetach();
                                    LynxImageManager.this.mPreTemporaryDraweeHolder = null;
                                }
                            }
                        });
                    }
                    LynxImageManager.this.mImageDelegate.handleImageSuccessCallback(LynxImageManager.this.mWidth, LynxImageManager.this.mHeight, imageInfo, animatable, LynxImageManager.this.mStartTimeStamp, true, LynxImageManager.this.mImageOrigin, LynxImageManager.this.mLoaderCallback);
                }

                public void onFailure(String str, Throwable th) {
                    LynxImageManager.this.handlerFailure(th);
                }
            };
            LynxImageManager.this.mDraweeControllerBuilder.setAutoPlayAnimations(LynxImageManager.this.mAutoPlay).setCallerContext(LynxImageManager.this.mCallerContext).setControllerListener(LynxImageManager.this.mControllerListener).setRetainImageOnFailure(imageRequest != null).setImageRequest(this.val$imageRequest).setOldController(LynxImageManager.this.mDraweeHolder.getController()).setLowResImageRequest(imageRequest);
            LynxImageManager.this.mWeakImageOriginListener = new WeakImageOriginListener(LynxImageManager.this);
            if (LynxLiteConfigs.enableNewFresco() && (LynxImageManager.this.mDraweeControllerBuilder instanceof PipelineDraweeControllerBuilder)) {
                LynxImageManager.this.mDraweeControllerBuilder.setImageOriginListener(LynxImageManager.this.mWeakImageOriginListener);
            }
            LynxImageManager.this.mDraweeHolder.setController(LynxImageManager.this.mDraweeControllerBuilder.build());
            LynxImageManager.this.mDraweeControllerBuilder.reset();
            if (!LynxImageManager.this.mUseImagePostProcessor && LynxImageManager.this.mDraweeHolder.hasHierarchy()) {
                LynxImageManager.this.mGenericDraweeHierarchy.setRoundingParams(LynxImageManager.this.mRoundingParams);
                LynxImageManager.this.mDraweeHolder.getHierarchy().setActualImageScaleType(ImageResizeMode.getRealScaleType(LynxImageManager.this.mScaleType));
            }
            if (LynxImageManager.this.mIsUsedForBackgroundImage && LynxImageManager.this.mDraweeHolder.hasHierarchy()) {
                LynxImageManager.this.mDraweeHolder.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
            }
            Runnable runnable = new Runnable() { // from class: com.lynx.tasm.ui.image.LynxImageManager.3.2
                @Override // java.lang.Runnable
                public void run() {
                    if (RunnableC02383.this.val$imageRequest != LynxImageManager.this.mCurImageRequest) {
                        return;
                    }
                    if (!LynxImageManager.this.mDeferInvalidation && LynxImageManager.this.mDrawableReadyListener != null) {
                        LynxImageManager.this.mDrawableReadyListener.onDrawableReady(LynxImageManager.this.mDraweeHolder.getTopLevelDrawable());
                    }
                    TraceEvent.beginSection(TraceEventDef.IMAGE_MANAGER_ON_ATTACH);
                    LynxImageManager.this.detachHolder();
                    if (LynxImageManager.this.mIsAttached) {
                        LynxImageManager.this.mDraweeHolder.onAttach();
                    }
                    TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_ON_ATTACH);
                }
            };
            if (!LynxImageManager.this.mSyncAttach || Looper.myLooper() != Looper.getMainLooper()) {
                LynxImageManager.sUIHandler.post(runnable);
            } else {
                runnable.run();
            }
            TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_REQUEST_JOB_SCHEDULER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryFetchImageFromFrescoAsync(int i, int i2, int i3, int i4, int i5, int i6) {
        float[] fArr;
        TraceEvent.beginSection(TraceEventDef.IMAGE_MANAGER_TRY_FETCH_FROM_FRESCO_ASYNC);
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        BorderRadius borderRadius = this.mBorderRadii;
        if (borderRadius != null) {
            if (borderRadius.updateSize(i + i3 + i5, i2 + i4 + i6)) {
                this.mIsBorderRadiusDirty = true;
            }
            fArr = this.mBorderRadii.getArray();
        } else {
            fArr = null;
        }
        float[] fArr2 = fArr;
        this.mUseImagePostProcessor = false;
        updatePostProcessorValue(i3, i4, i5, i6, fArr2, scaleType);
        ImageRequest createImageRequest = createImageRequest(this.mImageDelegate.getImageSource(), i, i2, i3, i4, i5, i6, fArr2, scaleType);
        this.mCurImageRequest = createImageRequest;
        this.mCacheKey = ImageUtils.getCacheKey(createImageRequest, this.mCallerContext);
        this.mStartTimeStamp = System.currentTimeMillis();
        if (tryFetchImageFromCache()) {
            TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_TRY_FETCH_FROM_FRESCO_ASYNC);
            return;
        }
        doAsyncFrescoImageRequest(createImageRequest, createImageRequest(this.mImageDelegate.getImagePlaceholder(), i, i2, i3, i4, i5, i6, fArr2, scaleType));
        this.mIsDirty = false;
        this.mImageDelegate.setLastWidth(i);
        this.mImageDelegate.setLastHeight(i2);
        TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_TRY_FETCH_FROM_FRESCO_ASYNC);
    }

    private void doAsyncFrescoImageRequest(final ImageRequest imageRequest, final ImageRequest imageRequest2) {
        DrawableReadyListener drawableReadyListener;
        TraceEvent.beginSection(TraceEventDef.IMAGE_MANAGER_DO_ASYNC_FRESCO_REQUEST);
        if (this.mDeferInvalidation) {
            this.mGenericDraweeHierarchy = new GenericDraweeHierarchyBuilder((Resources) null).setRoundingParams(this.mRoundingParams).setFadeDuration(this.mFadeDurationMs).build();
        } else {
            this.mGenericDraweeHierarchy.reset();
        }
        if (this.mDeferInvalidation) {
            LynxDraweeHolder<GenericDraweeHierarchy> lynxDraweeHolder = this.mLynxDraweeHolder;
            if (lynxDraweeHolder != null) {
                this.mPreLynxDraweeHolder = lynxDraweeHolder;
            }
            this.mLynxDraweeHolder = LynxDraweeHolder.create(this.mGenericDraweeHierarchy);
        }
        if (this.mIsAttached) {
            this.mLynxDraweeHolder.onAttach();
        }
        if (!this.mDeferInvalidation && (drawableReadyListener = this.mDrawableReadyListener) != null) {
            drawableReadyListener.onDrawableReady(this.mLynxDraweeHolder.getTopLevelDrawable());
        }
        final String rawSrc = this.mImageDelegate.getRawSrc();
        LynxThreadPool.getImageRequestExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ui.image.LynxImageManager.4
            @Override // java.lang.Runnable
            public void run() {
                LynxImageManager.this.mLynxDraweeControllerBuilder.setAutoPlayAnimations(LynxImageManager.this.mAutoPlay).setCallerContext(LynxImageManager.this.mCallerContext).setControllerListener(LynxImageManager.this.mControllerListener).setRetainImageOnFailure(imageRequest2 != null).setImageRequest(imageRequest).setOldController(LynxImageManager.this.mLynxDraweeHolder.getController()).setEnableAsyncCallback(LynxImageManager.this.mEnableAsyncCallback && !LynxImageManager.this.mDeferInvalidation).setLowResImageRequest(imageRequest2);
                if (LynxLiteConfigs.enableNewFresco()) {
                    LynxImageManager.this.mLynxDraweeControllerBuilder.setImageOriginListener(LynxImageManager.this.mWeakImageOriginListener);
                }
                LynxAbstractDraweeController build = LynxImageManager.this.mLynxDraweeControllerBuilder.build();
                build.setUI(LynxImageManager.this.mWeakUI);
                build.setRequestUrl(rawSrc);
                LynxImageManager.this.mLynxDraweeHolder.setController(build);
                LynxImageManager.this.mLynxDraweeControllerBuilder.reset();
            }
        });
        TraceEvent.endSection(TraceEventDef.IMAGE_MANAGER_DO_ASYNC_FRESCO_REQUEST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHierarchyProps() {
        BorderRadius borderRadius;
        if (this.mUseImagePostProcessor) {
            this.mScaleTypeDirty = false;
            this.mIsBorderRadiusDirty = false;
            return;
        }
        if (this.mScaleTypeDirty) {
            this.mGenericDraweeHierarchy.setActualImageScaleType(ImageResizeMode.getRealScaleType(this.mScaleType));
            this.mScaleTypeDirty = false;
        }
        if (!this.mIsBorderRadiusDirty || (borderRadius = this.mBorderRadii) == null) {
            return;
        }
        if (borderRadius.getArray() != null) {
            this.mRoundingParams = RoundingParams.fromCornersRadii(this.mBorderRadii.getArray());
        } else {
            this.mRoundingParams = null;
        }
        this.mGenericDraweeHierarchy.setRoundingParams(this.mRoundingParams);
        this.mIsBorderRadiusDirty = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLayoutUpdated(int i, int i2, int i3, int i4) {
        View view = this.mImageSrSizeView;
        if (view != null) {
            view.setLeft(i);
            this.mImageSrSizeView.setTop(i2);
            this.mImageSrSizeView.setRight(i3);
            this.mImageSrSizeView.setBottom(i4);
        }
    }

    private boolean tryFetchImageFromCache() {
        MemoryCache<CacheKey, CloseableImage> memoryCache;
        CloseableReference<CloseableImage> closeableReference;
        int i;
        int i2;
        CacheKey cacheKey = this.mCacheKey;
        if (cacheKey != null && (memoryCache = this.mMemoryCache) != null && (closeableReference = memoryCache.get(cacheKey)) != null && closeableReference.get() != null) {
            if (!((CloseableImage) closeableReference.get()).getQualityInfo().isOfFullQuality()) {
                CloseableReference.closeSafely(closeableReference);
                return false;
            }
            CloseableBitmap closeableBitmap = (CloseableImage) closeableReference.get();
            if (closeableBitmap instanceof CloseableBitmap) {
                this.mAsyncBitmap = closeableBitmap.getUnderlyingBitmap();
            }
            try {
                Drawable createDrawable = this.mDefaultDrawableFactory.createDrawable(closeableBitmap);
                if (!this.mUseImagePostProcessor) {
                    this.mGenericDraweeHierarchy.setImage(createDrawable, 1.0f, true);
                }
                if (this.mLoaderCallback != null) {
                    if (this.mImageDelegate.getImageSource() != null && ImageDelegate.sUrlImageSizeMap.containsKey(this.mImageDelegate.getImageSource().getUri().toString())) {
                        FrescoImageView.ImageSize imageSize = ImageDelegate.sUrlImageSizeMap.get(this.mImageDelegate.getImageSource().getUri().toString());
                        i2 = imageSize.getWidth();
                        i = imageSize.getHeight();
                    } else {
                        i2 = closeableBitmap.getWidth();
                        i = closeableBitmap.getHeight();
                    }
                    if (this.mNeedExtraLoadInfo) {
                        this.mImageDelegate.sendLoadEventWithExtraInfo(this.mWidth, this.mHeight, i2, i, this.mStartTimeStamp, System.currentTimeMillis(), true);
                    } else {
                        this.mLoaderCallback.onImageLoadSuccess(i2, i);
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (this.mImageDelegate.isNeedAutoSize()) {
                    this.mImageDelegate.setImageHeight(i);
                    this.mImageDelegate.setImageWidth(i2);
                    this.mImageDelegate.justSizeIfNeeded();
                }
                updateHierarchyProps();
                ColorFilter colorFilter = this.mColorFilter;
                if (colorFilter != null && this.mUseImagePostProcessor && createDrawable != null) {
                    createDrawable.setColorFilter(colorFilter);
                }
                DrawableReadyListener drawableReadyListener = this.mDrawableReadyListener;
                if (!this.mUseImagePostProcessor) {
                    createDrawable = this.mLynxDraweeHolder.getTopLevelDrawable();
                }
                drawableReadyListener.onDrawableReady(createDrawable);
                if (this.mCloseableImage != null) {
                    clearAsyncCache();
                }
                this.mCloseableImage = closeableReference;
                this.mIsDirty = false;
                this.mBitmapFromCache = true;
                this.mImageDelegate.reportImageEvent(getRawSrc(), 0, true, 5, this.mStartTimeStamp, System.currentTimeMillis(), true, i2, i);
                return true;
            } catch (Exception unused) {
                CloseableReference.closeSafely(closeableReference);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAsyncCache() {
        CloseableReference.closeSafely(this.mCloseableImage);
        this.mCloseableImage = null;
    }

    private boolean tryFetchImageFromPostProcessorCache(ImageRequest imageRequest) {
        int i;
        int i2;
        int width;
        CloseableReference<CloseableImage> tryTemporaryDraweeHolder = TemporaryDraweeHolder.tryTemporaryDraweeHolder(imageRequest);
        if (tryTemporaryDraweeHolder == null || tryTemporaryDraweeHolder.get() == null) {
            return false;
        }
        detachHolder();
        TemporaryDraweeHolder temporaryDraweeHolder = new TemporaryDraweeHolder(tryTemporaryDraweeHolder);
        this.mTemporaryDraweeHolder = temporaryDraweeHolder;
        ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter != null) {
            temporaryDraweeHolder.setColorFilter(colorFilter);
        }
        if (this.mLoaderCallback != null) {
            if (this.mImageDelegate.getImageSource() != null && ImageDelegate.sUrlImageSizeMap.containsKey(this.mImageDelegate.getImageSource().getUri().toString())) {
                FrescoImageView.ImageSize imageSize = ImageDelegate.sUrlImageSizeMap.get(this.mImageDelegate.getImageSource().getUri().toString());
                width = imageSize.getWidth();
                i = imageSize.getHeight();
            } else {
                CloseableImage closeableImage = (CloseableImage) tryTemporaryDraweeHolder.get();
                width = closeableImage.getWidth();
                i = closeableImage.getHeight();
            }
            if (this.mNeedExtraLoadInfo) {
                this.mImageDelegate.sendLoadEventWithExtraInfo(this.mWidth, this.mHeight, width, i, this.mStartTimeStamp, System.currentTimeMillis(), true);
            } else {
                this.mLoaderCallback.onImageLoadSuccess(width, i);
            }
            i2 = width;
        } else {
            i = 0;
            i2 = 0;
        }
        if (this.mImageDelegate.isNeedAutoSize()) {
            this.mImageDelegate.setImageHeight(i);
            this.mImageDelegate.setImageWidth(i2);
            this.mImageDelegate.justSizeIfNeeded();
        }
        this.mDrawableReadyListener.onDrawableReady(this.mTemporaryDraweeHolder.getTopLevelDrawable());
        this.mImageDelegate.reportImageEvent(getRawSrc(), 0, true, 5, this.mStartTimeStamp, System.currentTimeMillis(), true, i2, i);
        this.mIsDirty = false;
        return true;
    }

    public ImageRequest getCurImageRequest() {
        return this.mCurImageRequest;
    }

    public void setBounds(int i, int i2) {
        if (this.mWidth == i && this.mHeight == i2) {
            return;
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.mIsDirty = true;
    }

    protected void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingRight = i3;
        this.mPaddingTop = i2;
        this.mPaddingBottom = i4;
    }

    public void setDirty(boolean z) {
        this.mIsDirty = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoopCount(int i) {
        this.mImageDelegate.setLoopCount(i);
    }

    protected int getLoopCount() {
        return this.mImageDelegate.getLoopCount();
    }

    public void setUseLocalCache(boolean z) {
        this.mImageDelegate.setUseLocalCache(z);
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
        GenericDraweeHierarchy genericDraweeHierarchy = this.mGenericDraweeHierarchy;
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setFadeDuration(this.mFadeDurationMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTintColor(String str) {
        if (!ColorUtils.isValid(str)) {
            this.mColorFilter = null;
        } else {
            this.mColorFilter = new PorterDuffColorFilter(ColorUtils.parse(str), PorterDuff.Mode.SRC_IN);
        }
        if (this.mEnableAsyncRequestImage) {
            this.mGenericDraweeHierarchy.setActualImageColorFilter(this.mColorFilter);
            return;
        }
        TemporaryDraweeHolder temporaryDraweeHolder = this.mTemporaryDraweeHolder;
        if (temporaryDraweeHolder != null) {
            temporaryDraweeHolder.setColorFilter(this.mColorFilter);
        }
        DraweeHolder<GenericDraweeHierarchy> draweeHolder = this.mDraweeHolder;
        if (draweeHolder == null || draweeHolder.getHierarchy() == null) {
            return;
        }
        this.mDraweeHolder.getHierarchy().setActualImageColorFilter(this.mColorFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageEvents(Map<String, EventsListener> map) {
        this.mImageDelegate.setImageEvents(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsPixelated(boolean z) {
        this.isPixelated = z;
        this.mIsDirty = true;
    }

    public void setAwaitLocalCache(boolean z) {
        this.mImageDelegate.setAwaitLocalCache(z);
    }

    public void setDeferInvalidation(boolean z) {
        this.mDeferInvalidation = z;
    }

    public void setEnableResourceHint(boolean z) {
        this.mImageDelegate.setEnableResourceHint(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtraLoadInfo(boolean z) {
        this.mNeedExtraLoadInfo = z;
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
        if (z && this.mImageSrSizeView == null) {
            this.mImageSrSizeView = new View(this.mLynxContext);
        }
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
