package com.bytedance.lynx.service.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.lynx.service.image.decoder.GifDecoder;
import com.bytedance.lynx.service.image.decoder.LoopCountModifyingBackend;
import com.bytedance.lynx.service.image.decoder.UnPremultipliedDecoder;
import com.bytedance.lynx.service.image.utils.ImageUtils;
import com.bytedance.rts.foundation.Int32;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.BlurHashBitmapDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.blurhash.BlurDecodeProducer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer;
import com.facebook.imagepipeline.blurhash2.PreviewHashConfig;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.image.ImageContent;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.image.model.AnimationListener;
import com.lynx.tasm.image.model.ImageInfo;
import com.lynx.tasm.image.model.ImageLoadListener;
import com.lynx.tasm.image.model.ImageRequestInfo;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxImageService implements ILynxImageService, ILynxImageServiceExtension {
    public static final String CACHE_BITMAP = "bitmap";
    public static final String CACHE_DISK = "disk";
    public static final String CACHE_TARGET_KEY = "cacheTarget";
    public static final String CUSTOM_PARAM = "additional-custom-info";
    public static final String PRIORITY_HIGH = "high";
    public static final String PRIORITY_KEY = "priority";
    public static final String PRIORITY_LOW = "low";
    public static final String PRIORITY_MEDIUM = "medium";
    private static volatile LynxImageService sInstance;
    private DefaultDrawableFactory mDefaultDrawableFactory;
    private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private final ConcurrentHashMap<ImageRequestInfo, CloseableReference<CloseableImage>> mImageReferenceMap = new ConcurrentHashMap<>();
    private Resources mResources = null;
    private final UiThreadImmediateExecutorService mExecutorService = UiThreadImmediateExecutorService.getInstance();

    private LynxImageService() {
    }

    public static LynxImageService getInstance() {
        if (sInstance == null) {
            synchronized (LynxImageService.class) {
                if (sInstance == null) {
                    sInstance = new LynxImageService();
                }
            }
        }
        return sInstance;
    }

    public void fetchImage(final ImageRequestInfo imageRequestInfo, final ImageLoadListener imageLoadListener, final AnimationListener animationListener, Context context) {
        if (this.mResources == null) {
            this.mResources = context.getResources();
        }
        if (this.mDefaultDrawableFactory == null) {
            this.mDefaultDrawableFactory = new DefaultDrawableFactory(this.mResources, Fresco.getImagePipelineFactory().getAnimatedDrawableFactory(context));
        }
        if (this.mMemoryCache == null) {
            this.mMemoryCache = Fresco.getImagePipelineFactory().getBitmapMemoryCache();
        }
        final ImageRequest frescoImageRequest = ImageUtils.getFrescoImageRequest(imageRequestInfo);
        CloseableReference<CloseableImage> cachedImage = ImageUtils.getCachedImage(this.mMemoryCache, ImageUtils.getCacheKey(frescoImageRequest, imageRequestInfo.getCallerContext()));
        if (cachedImage != null) {
            CloseableImage closeableImage = (CloseableImage) cachedImage.get();
            if (closeableImage instanceof CloseableStaticBitmap) {
                imageLoadListener.onSuccess(new ImageContent(new FrescoReleasableImage(cachedImage)), imageRequestInfo, new ImageInfo(closeableImage.getWidth(), closeableImage.getHeight(), false));
                return;
            }
        }
        final BaseDataSubscriber<CloseableReference<CloseableImage>> baseDataSubscriber = new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.bytedance.lynx.service.image.LynxImageService.1
            protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                LynxImageService.this.handleImageLoadSuccess(dataSource, imageRequestInfo, imageLoadListener, animationListener);
            }

            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                imageLoadListener.onFailure(ImageErrorCodeUtils.checkImageException(dataSource.getFailureCause()), dataSource.getFailureCause());
            }
        };
        if (imageRequestInfo.isEnableAsyncRequest()) {
            LynxThreadPool.getImageRequestExecutor().execute(new Runnable() { // from class: com.bytedance.lynx.service.image.LynxImageService.2
                @Override // java.lang.Runnable
                public void run() {
                    Fresco.getImagePipeline().fetchDecodedImage(frescoImageRequest, imageRequestInfo.getCallerContext()).subscribe(baseDataSubscriber, LynxImageService.this.mExecutorService);
                }
            });
        } else {
            Fresco.getImagePipeline().fetchDecodedImage(frescoImageRequest, imageRequestInfo.getCallerContext()).subscribe(baseDataSubscriber, this.mExecutorService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleImageLoadSuccess(DataSource<CloseableReference<CloseableImage>> dataSource, ImageRequestInfo imageRequestInfo, ImageLoadListener imageLoadListener, AnimationListener animationListener) {
        boolean handleImageAnimListener;
        ImageContent imageContent;
        CloseableReference closeableReference = (CloseableReference) dataSource.getResult();
        try {
            try {
                CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                if (closeableImage instanceof CloseableStaticBitmap) {
                    imageContent = new ImageContent(new FrescoReleasableImage(closeableReference.clone()));
                    handleImageAnimListener = false;
                } else {
                    Drawable createDrawable = this.mDefaultDrawableFactory.createDrawable((CloseableImage) closeableReference.get());
                    ImageContent imageContent2 = new ImageContent(new FrescoReleasableImage(createDrawable, closeableReference.clone()));
                    handleImageAnimListener = handleImageAnimListener(imageRequestInfo, createDrawable, animationListener);
                    imageContent = imageContent2;
                }
                imageLoadListener.onSuccess(imageContent, imageRequestInfo, new ImageInfo(closeableImage.getWidth(), closeableImage.getHeight(), handleImageAnimListener));
            } catch (Exception e) {
                CloseableReference.closeSafely(closeableReference);
                imageLoadListener.onFailure(30102, e);
            }
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    private boolean handleImageAnimListener(ImageRequestInfo imageRequestInfo, Drawable drawable, final AnimationListener animationListener) {
        if (!(drawable instanceof AnimatedDrawable2)) {
            return false;
        }
        AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) drawable;
        if (animationListener != null) {
            animatedDrawable2.setAnimationListener(new BaseAnimationListener() { // from class: com.bytedance.lynx.service.image.LynxImageService.3
                public void onAnimationStart(AnimatedDrawable2 animatedDrawable22) {
                    animationListener.onAnimationStart(animatedDrawable22);
                }

                public void onAnimationStop(AnimatedDrawable2 animatedDrawable22) {
                    if (animatedDrawable22.isRunning()) {
                        animationListener.onAnimationCurrentLoop(animatedDrawable22);
                        animationListener.onAnimationFinalLoop(animatedDrawable22);
                    }
                }

                public void onAnimationRepeat(AnimatedDrawable2 animatedDrawable22) {
                    if (animatedDrawable22.isRunning()) {
                        animationListener.onAnimationCurrentLoop(animatedDrawable22);
                    }
                }
            });
        }
        animatedDrawable2.setAnimationBackend(new LoopCountModifyingBackend(animatedDrawable2.getAnimationBackend(), imageRequestInfo.getLoopCount()));
        animatedDrawable2.setPrivateFrameScheduler(new DropFramesFrameScheduler(animatedDrawable2.getAnimationBackend()));
        if (imageRequestInfo.isAutoPlay()) {
            animatedDrawable2.start();
        }
        return true;
    }

    public boolean startAnimation(Drawable drawable) {
        if (!(drawable instanceof AnimatedDrawable2)) {
            return false;
        }
        AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) drawable;
        animatedDrawable2.stop();
        animatedDrawable2.start();
        return true;
    }

    public boolean resumeAnimation(Drawable drawable) {
        if (!(drawable instanceof AnimatedDrawable2)) {
            return false;
        }
        ((AnimatedDrawable2) drawable).start();
        return true;
    }

    public boolean pauseAnimation(Drawable drawable) {
        if (!(drawable instanceof AnimatedDrawable2)) {
            return false;
        }
        ((AnimatedDrawable2) drawable).pause();
        return true;
    }

    public boolean stopAnimation(Drawable drawable) {
        if (!(drawable instanceof AnimatedDrawable2)) {
            return false;
        }
        ((AnimatedDrawable2) drawable).stop();
        return true;
    }

    private void prefetchImageToDiskCache(ImageRequest imageRequest, Object obj, String str, final ImageLoadListener imageLoadListener) {
        Priority priority;
        if (str != null && str.equals("high")) {
            priority = Priority.HIGH;
        } else if (str != null && str.equals(PRIORITY_MEDIUM)) {
            priority = Priority.MEDIUM;
        } else {
            priority = Priority.LOW;
        }
        DataSource prefetchToDiskCache = Fresco.getImagePipeline().prefetchToDiskCache(imageRequest, obj, priority);
        if (imageLoadListener != null) {
            prefetchToDiskCache.subscribe(new BaseDataSubscriber<Void>() { // from class: com.bytedance.lynx.service.image.LynxImageService.4
                protected void onNewResultImpl(DataSource<Void> dataSource) {
                    imageLoadListener.onSuccess((ImageContent) null, (ImageRequestInfo) null, (ImageInfo) null);
                }

                protected void onFailureImpl(DataSource<Void> dataSource) {
                    if (dataSource.getFailureCause() != null) {
                        imageLoadListener.onFailure(ImageErrorCodeUtils.checkImageException(dataSource.getFailureCause()), dataSource.getFailureCause());
                    } else {
                        imageLoadListener.onFailure(-1, new Throwable("image prefetch to disk cache failed."));
                    }
                }
            }, CallerThreadExecutor.getInstance());
        }
    }

    private void prefetchImageToBitmapCache(ImageRequest imageRequest, Object obj, final ImageLoadListener imageLoadListener) {
        DataSource prefetchToBitmapCache = Fresco.getImagePipeline().prefetchToBitmapCache(imageRequest, obj);
        if (imageLoadListener != null) {
            prefetchToBitmapCache.subscribe(new BaseDataSubscriber<Void>() { // from class: com.bytedance.lynx.service.image.LynxImageService.5
                protected void onNewResultImpl(DataSource<Void> dataSource) {
                    imageLoadListener.onSuccess((ImageContent) null, (ImageRequestInfo) null, (ImageInfo) null);
                }

                protected void onFailureImpl(DataSource<Void> dataSource) {
                    if (dataSource.getFailureCause() != null) {
                        imageLoadListener.onFailure(ImageErrorCodeUtils.checkImageException(dataSource.getFailureCause()), dataSource.getFailureCause());
                    } else {
                        imageLoadListener.onFailure(-1, new Throwable("image prefetch to bitmap cache failed."));
                    }
                }
            }, CallerThreadExecutor.getInstance());
        }
    }

    public void prefetchImage(String str, Object obj, Map<String, Object> map) {
        prefetchImage(str, obj, map, null);
    }

    public void prefetchImage(String str, Object obj, Map<String, Object> map, ImageLoadListener imageLoadListener) {
        String str2 = map == null ? null : (String) map.get(PRIORITY_KEY);
        String str3 = map == null ? null : (String) map.get(CACHE_TARGET_KEY);
        Map map2 = map != null ? (Map) map.get(CUSTOM_PARAM) : null;
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            return;
        }
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(parse);
        ImageDecodeOptionsBuilder bitmapConfig = new ImageDecodeOptionsBuilder().setBitmapConfig(Bitmap.Config.ARGB_8888);
        bitmapConfig.setPreDecodeFrameCount(0);
        newBuilderWithSource.setImageDecodeOptions(bitmapConfig.build());
        if (map2 != null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : map2.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue() == null ? "" : (String) entry.getValue());
            }
            newBuilderWithSource.setCustomParam(hashMap);
        }
        if (str3 != null && str3.equals(CACHE_BITMAP)) {
            prefetchImageToBitmapCache(newBuilderWithSource.build(), obj, imageLoadListener);
        } else {
            prefetchImageToDiskCache(newBuilderWithSource.build(), obj, str2, imageLoadListener);
        }
    }

    public void decodeImage(final ImageRequestInfo imageRequestInfo, final ImageLoadListener imageLoadListener) {
        if (imageRequestInfo != null) {
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            ImageDecodeOptionsBuilder forceStaticImage = ImageDecodeOptions.newBuilder().setBitmapConfig(imageRequestInfo.getConfig()).setForceStaticImage(imageRequestInfo.isForceStaticImage());
            if (!imageRequestInfo.isEnablePremultiplied()) {
                forceStaticImage.setCustomImageDecoder(new UnPremultipliedDecoder());
            }
            imagePipeline.fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageRequestInfo.getUrl())).setResizeOptions(new ResizeOptions(Int32.MAX_VALUE, Int32.MAX_VALUE, 2.14748365E9f)).setImageDecodeOptions(forceStaticImage.build()).build(), (Object) null).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.bytedance.lynx.service.image.LynxImageService.6
                protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    CloseableReference closeableReference = (CloseableReference) dataSource.getResult();
                    Bitmap bitmap = new FrescoReleasableImage(closeableReference).getBitmap();
                    if (bitmap != null) {
                        imageLoadListener.onSuccess(new ImageContent(new FrescoReleasableImage(closeableReference)), imageRequestInfo, new ImageInfo(bitmap.getWidth(), bitmap.getHeight(), false));
                    } else {
                        imageLoadListener.onFailure(-1, new Throwable("empty bitmap!"));
                    }
                }

                protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    if (dataSource.getFailureCause() != null) {
                        imageLoadListener.onFailure(ImageErrorCodeUtils.checkImageException(dataSource.getFailureCause()), dataSource.getFailureCause());
                    } else {
                        imageLoadListener.onFailure(-1, new Throwable("imageLoadFailed."));
                    }
                }
            }, CallerThreadExecutor.getInstance());
        }
    }

    public void releaseImage(ImageRequestInfo imageRequestInfo) {
        CloseableReference<CloseableImage> remove;
        if (imageRequestInfo == null || (remove = this.mImageReferenceMap.remove(imageRequestInfo)) == null) {
            return;
        }
        CloseableReference.closeSafely(remove);
    }

    public void releaseAnimDrawable(Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).dropCaches();
        }
    }

    public boolean canParseUrl(String str) {
        return TextUtils.isEmpty(str) || str.startsWith("file://") || str.startsWith("content://") || str.startsWith("asset://") || str.startsWith("data:");
    }

    @Deprecated
    public void setCustomImageDecoder(Object obj) {
        if (obj instanceof ImageDecodeOptionsBuilder) {
            ((ImageDecodeOptionsBuilder) obj).setCustomImageDecoder(new GifDecoder(true));
        }
    }

    public BackgroundLayerDrawable createBackgroundImageDrawable(Context context, String str) {
        if (LynxEnv.inst().getBackgroundImageLoader() != null) {
            return LynxEnv.inst().getBackgroundImageLoader().loadImage(context, str);
        }
        return null;
    }

    @Deprecated
    public Object getImageSRPostProcessor() {
        return SRPostProcessorUtil.getSRPostProcessorInstance();
    }

    @Deprecated
    public void setImageSRSize(Object obj, View view) {
        if (obj instanceof ImageRequest) {
            ((ImageRequest) obj).setSizeDeterminer(new SizeDeterminer(view));
        }
    }

    @Deprecated
    public void setImageCacheChoice(String str, Object obj) {
        if (obj instanceof ImageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder = (ImageRequestBuilder) obj;
            imageRequestBuilder.setCacheChoice(ImageRequest.CacheChoice.CUSTOM);
            imageRequestBuilder.setCustomCacheName(str);
        }
    }

    @Deprecated
    public void setImagePlaceHolderHash(final Object obj, final Object obj2, final Object obj3, final String str, String str2, int i, int i2, int i3, int i4, boolean z) {
        if ((obj2 instanceof ImageRequest) && (obj instanceof GenericDraweeHierarchy) && (obj3 instanceof ScalingUtils.ScaleType)) {
            if (!z) {
                ImageRequest imageRequest = (ImageRequest) obj2;
                imageRequest.setPreviewUsed(true);
                imageRequest.setPreviewAlgo(1);
                final BlurHashConfig blurHashConfig = new BlurHashConfig(i, i2);
                final long uptimeMillis = SystemClock.uptimeMillis();
                new BlurDecodeProducer(str, blurHashConfig, new BlurDecodeProducer.BlurDecodeCallBack() { // from class: com.bytedance.lynx.service.image.LynxImageService.7
                    public void decodeResult(Bitmap bitmap) {
                        LynxImageService.this.handleHashDrawable(bitmap, (GenericDraweeHierarchy) obj, (ImageRequest) obj2, (ScalingUtils.ScaleType) obj3, uptimeMillis, blurHashConfig.getTargetWidth(), blurHashConfig.getTargetHeight(), str);
                    }
                });
                return;
            }
            ImageRequest imageRequest2 = (ImageRequest) obj2;
            imageRequest2.setPreviewUsed(true);
            imageRequest2.setPreviewAlgo(2);
            final long uptimeMillis2 = SystemClock.uptimeMillis();
            final PreviewHashConfig previewHashConfig = new PreviewHashConfig(i4, i3, i, i2);
            if (!TextUtils.isEmpty(str2)) {
                new PreviewBlurHashProducer(str, str2, previewHashConfig, new PreviewBlurHashProducer.PreviewBlurDecodeCallBack() { // from class: com.bytedance.lynx.service.image.LynxImageService.8
                    public void decodeResult(Bitmap bitmap) {
                        LynxImageService.this.handleHashDrawable(bitmap, (GenericDraweeHierarchy) obj, (ImageRequest) obj2, (ScalingUtils.ScaleType) obj3, uptimeMillis2, previewHashConfig.getWidth(), previewHashConfig.getHeight(), str);
                    }
                });
            } else {
                new PreviewBlurHashProducer(str, previewHashConfig, new PreviewBlurHashProducer.PreviewBlurDecodeCallBack() { // from class: com.bytedance.lynx.service.image.LynxImageService.9
                    public void decodeResult(Bitmap bitmap) {
                        LynxImageService.this.handleHashDrawable(bitmap, (GenericDraweeHierarchy) obj, (ImageRequest) obj2, (ScalingUtils.ScaleType) obj3, uptimeMillis2, previewHashConfig.getWidth(), previewHashConfig.getHeight(), str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleHashDrawable(final Bitmap bitmap, final GenericDraweeHierarchy genericDraweeHierarchy, final ImageRequest imageRequest, ScalingUtils.ScaleType scaleType, final long j, int i, int i2, String str) {
        if (genericDraweeHierarchy == null || imageRequest == null) {
            return;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            final BlurHashBitmapDrawable blurHashBitmapDrawable = new BlurHashBitmapDrawable(bitmap, i, i2, scaleType);
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.bytedance.lynx.service.image.LynxImageService.10
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    imageRequest.setPreviewDecodeTime(uptimeMillis - j);
                    imageRequest.setPreviewDecodeEnd(uptimeMillis);
                    genericDraweeHierarchy.setPlaceholderImage(blurHashBitmapDrawable, ScalingUtils.ScaleType.FIT_XY);
                }
            });
        } else {
            imageRequest.setPreviewError(str);
        }
    }

    public void onLynxEnvSetup() {
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.bytedance.lynx.service.image.LynxImageService.11
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    new UIImageClassWarmer().warmClass();
                    Log.i("warmClassForImage", "image warm-up cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
