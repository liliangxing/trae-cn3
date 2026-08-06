package com.lynx.tasm.p001ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxConsumer;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.image.ImageUrlRedirectUtils;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.p001ui.image.FrescoImageView;
import com.lynx.tasm.p001ui.image.fresco.BaseRoundedCornerPostprocessor;
import com.lynx.tasm.p001ui.image.fresco.LoopCountModifyingBackend;
import com.lynx.tasm.p001ui.image.fresco.LynxIterativeBoxBlurPostProcessor;
import com.lynx.tasm.p001ui.image.fresco.LynxNetworkImageRequest;
import com.lynx.tasm.p001ui.image.helper.BitmapUtil;
import com.lynx.tasm.p001ui.image.helper.ByteDanceFrescoUtils;
import com.lynx.tasm.p001ui.image.helper.FrescoEventHelper;
import com.lynx.tasm.p001ui.image.helper.ImageResizeUtils;
import com.lynx.tasm.p001ui.image.helper.ImageSource;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxResourceService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.ContextUtils;
import com.lynx.tasm.utils.LynxConstants;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.UnitUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.Closeable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ImageDelegate {
    public static final String EVENT_LOAD = "load";
    public static final String FADE_IN_STYLE = "fadeIn";
    public static final String HTTP_PREFIX = "http";
    public static final int ImageOriginBitmap = 5;
    public static final int ImageOriginUnknown = -1;
    private static final String LOG_TAG = "Lynx-Image";
    private static final String TAG = "ImageDelegate";
    private static final int sMaxRetryCount = 1;
    private boolean enableResourceHint;
    private final Context mContext;
    private boolean mEnableAllLoopEvent;
    private boolean mEnableAsyncRedirect;
    private boolean mEnableAsyncRedirectOnCreate;
    private boolean mEnableCheckLocalImage;
    private boolean mEnableCurrentLoopEvent;
    private boolean mEnableCustomGifDecoder;
    private boolean mEnableGenericFetcher;
    private boolean mEnableImageAsyncLayout;
    private boolean mEnableImageEventReport;
    private boolean mEnableOnLoad;
    private boolean mEnableSmallDiskCache;
    private boolean mEnableStartPlayEvent;
    private boolean mFirstRequest;
    private ReadableMap mHeaders;
    private GenericDraweeHierarchy mHierarchy;
    private ImageSource mImagePlaceholder;
    private final ImageResourceOperation mImageResourceOperation;
    private ImageSource mImageSource;
    private IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;
    private final LynxContext mLynxContext;
    private ILynxImageService mLynxImageService;
    private boolean mNeedExtraLoadInfo;
    private boolean mNeedRetryAutoSize;
    private boolean mProgressiveRenderingEnabled;
    private String mRawSrc;
    private LynxMediaResourceFetcher mResourceFetcher;
    private int mRetryCount;
    private boolean mUseLocalCache;
    private static final Bitmap.Config DEFAULT_BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    public static ConcurrentHashMap<String, FrescoImageView.ImageSize> sUrlImageSizeMap = new ConcurrentHashMap<>();
    private int mLastWidth = 0;
    private int mLastHeight = 0;
    private int mImageWidth = 0;
    private int mImageHeight = 0;
    private String mCapInsets = null;
    private String mCapInsetsScale = null;
    private String mRequestPriority = null;
    private String mCacheChoice = null;
    private boolean mSimpleCacheKey = false;
    private boolean mAutoSize = false;
    private ShadowNode mAutoSizeShadowNode = null;
    private Bitmap.Config mBitmapConfig = DEFAULT_BITMAP_CONFIG;
    private long mBitmapMemorySizeBytes = 0;
    private ImageResizeMethod mResizeMethod = ImageResizeMethod.RESIZE;
    private boolean mAwaitLocalCache = false;
    private ImageAsyncRedirectListener mImageRedirectListener = null;
    private boolean mIsUsedForBackgroundImage = false;
    private LynxBaseUI mLynxBaseUI = null;
    private Map<String, String> mCustomParams = new HashMap();
    private boolean mEnableAsyncRequestImage = false;
    private int mLoopCount = 0;
    private final String EVENT_START_PLAY = "startplay";
    private final String EVENT_CURRENT_LOOP_COMPLETE = "currentloopcomplete";
    private final String EVENT_ALL_LOOP_COMPLETE = "finalloopcomplete";
    private boolean mEnableImageSR = false;
    private float mImageSRScale = 0.0f;
    private boolean mEnablePreViewHash = false;
    private boolean mEnableBlurHash = false;
    private int mHashWidth = 0;
    private int mHashHeight = 0;
    private int mHashRadius = 0;
    private String mHashString = null;
    private String mMetaData = null;
    private int mIterations = 1;
    private final AnimationListener mAnimationListener = new BaseAnimationListener() { // from class: com.lynx.tasm.ui.image.ImageDelegate.1
        public void onAnimationStart(AnimatedDrawable2 animatedDrawable2) {
            if (ImageDelegate.this.mEnableStartPlayEvent) {
                ImageDelegate.this.sendCustomEvent("startplay");
            }
        }

        public void onAnimationStop(AnimatedDrawable2 animatedDrawable2) {
            if (ImageDelegate.this.mEnableAllLoopEvent && animatedDrawable2.isRunning()) {
                ImageDelegate.this.sendCustomEvent("currentloopcomplete");
                ImageDelegate.this.sendCustomEvent("finalloopcomplete");
            }
        }

        public void onAnimationRepeat(AnimatedDrawable2 animatedDrawable2) {
            if (ImageDelegate.this.mEnableCurrentLoopEvent && animatedDrawable2.isRunning()) {
                ImageDelegate.this.sendCustomEvent("currentloopcomplete");
            }
        }
    };
    private OptionalBool mSrcRedirectCheckResult = OptionalBool.UNDEFINED;
    private OptionalBool mPlaceHolderRedirectCheckResult = OptionalBool.UNDEFINED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ImageResourceOperation {
        void clear();

        ImageRequestBuilder createImageRequestBuilder(Uri uri);

        void fetchFrescoResource();

        boolean isUseImagePostProcessor();

        void markDirty();

        void maybeUpdateView();

        void onLocalCacheGet(CloseableReference<?> closeableReference);

        void onPostprocessorPreparing(List<Postprocessor> list);

        void onSourceSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageDelegate(Context context, ImageResourceOperation imageResourceOperation) {
        this.enableResourceHint = false;
        this.mUseLocalCache = false;
        this.mEnableSmallDiskCache = false;
        this.mEnableImageEventReport = false;
        this.mEnableCheckLocalImage = false;
        this.mEnableGenericFetcher = false;
        this.mEnableImageAsyncLayout = true;
        this.mResourceFetcher = null;
        this.mEnableAsyncRedirect = false;
        this.mFirstRequest = false;
        this.mEnableAsyncRedirectOnCreate = false;
        this.mContext = context;
        this.mImageResourceOperation = imageResourceOperation;
        LynxContext lynxContext = ContextUtils.toLynxContext(context);
        this.mLynxContext = lynxContext;
        this.mFirstRequest = true;
        this.mLynxImageService = (ILynxImageService) LynxServiceCenter.inst().getService(ILynxImageService.class);
        if (lynxContext != null) {
            this.enableResourceHint = lynxContext.getEnableImageResourceHint();
            this.mUseLocalCache = lynxContext.getEnableImageResourceHint();
            this.mEnableCheckLocalImage = lynxContext.isEnableCheckLocalImage();
            this.mEnableSmallDiskCache = lynxContext.getEnableImageSmallDiskCache();
            this.mEnableImageEventReport = LynxEnv.inst().enableImageEventReport();
            LynxMediaResourceFetcher mediaResourceFetcher = lynxContext.getMediaResourceFetcher();
            this.mResourceFetcher = mediaResourceFetcher;
            this.mEnableGenericFetcher = mediaResourceFetcher != null;
            this.mEnableAsyncRedirect = (LynxEnv.inst().enableImageAsyncRedirect() && (this.mEnableGenericFetcher || lynxContext.getAsyncImageInterceptor() != null)) || lynxContext.isAsyncRedirect();
        }
        this.mEnableAsyncRedirectOnCreate = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
        this.mEnableImageAsyncLayout = LynxEnv.inst().enableImageAsyncLayout();
    }

    public void onDetach() {
        this.mImageWidth = 0;
        this.mImageHeight = 0;
    }

    OptionalBool convertToOptionalBool(int i) {
        if (i == -1) {
            return OptionalBool.UNDEFINED;
        }
        if (i == 1) {
            return OptionalBool.TRUE;
        }
        if (i == 0) {
            return OptionalBool.FALSE;
        }
        return OptionalBool.UNDEFINED;
    }

    public long getBitmapMemorySizeBytes() {
        return this.mBitmapMemorySizeBytes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean enableGenericFetcher() {
        return this.mEnableGenericFetcher;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateRedirectCheckResult(String str, String str2, boolean z, boolean z2) {
        LynxContext lynxContext;
        if (this.mEnableCheckLocalImage) {
            if (z || z2) {
                if (!this.mEnableGenericFetcher) {
                    ILynxResourceService iLynxResourceService = (ILynxResourceService) LynxServiceCenter.inst().getService(ILynxResourceService.class);
                    if (iLynxResourceService == null) {
                        LLog.e(TAG, "Unable to update redirect because ILynxResourceService cannot be obtained.");
                        return;
                    }
                    if (z) {
                        this.mSrcRedirectCheckResult = convertToOptionalBool(iLynxResourceService.isLocalResource(str));
                    }
                    if (z2) {
                        this.mPlaceHolderRedirectCheckResult = convertToOptionalBool(iLynxResourceService.isLocalResource(str2));
                    }
                } else {
                    TraceEvent.beginSection(TraceEventDef.IMAGE_DELEGATE_IS_LOCAL_RESOURCE);
                    if (z) {
                        ILynxImageService iLynxImageService = this.mLynxImageService;
                        if (iLynxImageService != null && iLynxImageService.canParseUrl(str)) {
                            this.mSrcRedirectCheckResult = OptionalBool.FALSE;
                        } else {
                            this.mSrcRedirectCheckResult = this.mResourceFetcher.isLocalResource(str);
                        }
                    }
                    if (z2) {
                        ILynxImageService iLynxImageService2 = this.mLynxImageService;
                        if (iLynxImageService2 != null && iLynxImageService2.canParseUrl(str2)) {
                            this.mPlaceHolderRedirectCheckResult = OptionalBool.FALSE;
                        } else {
                            this.mPlaceHolderRedirectCheckResult = this.mResourceFetcher.isLocalResource(str2);
                        }
                    }
                    TraceEvent.endSection(TraceEventDef.IMAGE_DELEGATE_IS_LOCAL_RESOURCE);
                }
                if (!z || (lynxContext = this.mLynxContext) == null || !lynxContext.isPrefetchImageOnCreate() || this.mSrcRedirectCheckResult == OptionalBool.TRUE || str == null || !str.startsWith(HTTP_PREFIX) || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    return;
                }
                TraceEvent.beginSection(TraceEventDef.IMAGE_DELEGATE_PREFETCH_TO_DISK_CACHE);
                Fresco.getImagePipeline().prefetchToDiskCache(ImageRequest.fromUri(str), (Object) null);
                TraceEvent.endSection(TraceEventDef.IMAGE_DELEGATE_PREFETCH_TO_DISK_CACHE);
            }
        }
    }

    public void setSrc(String str) {
        setSrc(str, true);
    }

    public void setSrcSkippingRedirection(String str) {
        setSrc(str, false);
    }

    private void setSrc(String str, boolean z) {
        if (z) {
            setRedirectImageSource(str, null);
        } else {
            this.mRawSrc = str;
            setSrcInternal(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSrcInternal(String str) {
        ImageSource imageSource = this.mImageSource;
        if (imageSource == null || !imageSource.getSource().equals(str)) {
            this.mImageSource = null;
            if (str != null && !str.isEmpty()) {
                ImageSource imageSource2 = new ImageSource(this.mContext, str);
                this.mImageSource = imageSource2;
                if (Uri.EMPTY.equals(imageSource2.getUri())) {
                    warnImageSource(str);
                }
            } else {
                this.mImageResourceOperation.clear();
            }
            this.mImageWidth = 0;
            this.mImageHeight = 0;
            this.mImageResourceOperation.onSourceSet();
            this.mImageResourceOperation.markDirty();
        }
    }

    public void setPlaceholder(String str) {
        setPlaceholder(str, true);
    }

    public void setPlaceholder(String str, boolean z) {
        if (z) {
            setRedirectImageSource(null, str);
        } else {
            setPlaceholderInternal(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaceholderInternal(String str) {
        ImageSource imageSource = this.mImagePlaceholder;
        if (imageSource == null || !imageSource.getSource().equals(str)) {
            this.mImagePlaceholder = null;
            if (str != null && !str.isEmpty()) {
                ImageSource imageSource2 = new ImageSource(this.mContext, str);
                this.mImagePlaceholder = imageSource2;
                if (Uri.EMPTY.equals(imageSource2.getUri())) {
                    warnImageSource(str);
                }
            }
            this.mImageResourceOperation.markDirty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setRedirectImageSource(final String str, final String str2) {
        final boolean z;
        final boolean z2;
        if (str != null) {
            this.mRawSrc = str;
            if (this.mEnableCheckLocalImage) {
                if (this.mSrcRedirectCheckResult == OptionalBool.FALSE) {
                    setSrcInternal(str);
                } else if (this.mSrcRedirectCheckResult == OptionalBool.TRUE || this.mSrcRedirectCheckResult == OptionalBool.UNDEFINED) {
                    this.mRetryCount = 1;
                }
            }
            z = true;
            if (str2 != null) {
                if (!this.mEnableCheckLocalImage || this.mPlaceHolderRedirectCheckResult != OptionalBool.FALSE) {
                    z2 = true;
                    if (!z || z2) {
                        final LynxContext lynxContext = ContextUtils.toLynxContext(this.mContext);
                        if (needRedirectAsync()) {
                            LynxContext lynxContext2 = this.mLynxContext;
                            if (lynxContext2 != null) {
                                LynxFeatureCounter.count(73, lynxContext2.getInstanceId());
                            }
                            LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ui.image.ImageDelegate.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    final String str3 = str;
                                    final String str4 = str2;
                                    try {
                                        if (z) {
                                            str3 = ImageDelegate.this.fetchImageRedirectPath(str3, lynxContext);
                                        }
                                        if (z2) {
                                            str4 = ImageDelegate.this.fetchImageRedirectPath(str2, lynxContext);
                                        }
                                    } catch (Throwable th) {
                                        LLog.e(ImageDelegate.LOG_TAG, "async redirect url failed, placeholder: " + str2 + ", url:" + str + ", msg:" + th.getMessage());
                                        str3 = str;
                                        str4 = str2;
                                    }
                                    UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.ui.image.ImageDelegate.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (z) {
                                                if (TextUtils.equals(str, ImageDelegate.this.mRawSrc)) {
                                                    ImageDelegate.this.setSrcInternal(str3);
                                                } else {
                                                    LLog.w(ImageDelegate.LOG_TAG, "image redirect check failed curUrl = " + ImageDelegate.this.mRawSrc + " preUrl = " + str);
                                                }
                                            }
                                            if (z2) {
                                                ImageDelegate.this.setPlaceholderInternal(str4);
                                            }
                                            if (ImageDelegate.this.mImageRedirectListener != null) {
                                                ImageDelegate.this.mImageRedirectListener.onAsyncRedirectFinish();
                                            }
                                        }
                                    });
                                }
                            });
                            return;
                        }
                        if (z) {
                            setSrcInternal(fetchImageRedirectPath(str, lynxContext));
                        }
                        if (z2) {
                            setPlaceholderInternal(fetchImageRedirectPath(str2, lynxContext));
                            return;
                        }
                        return;
                    }
                    return;
                }
                setPlaceholderInternal(str2);
            }
            z2 = false;
            if (z) {
            }
            final LynxContext lynxContext3 = ContextUtils.toLynxContext(this.mContext);
            if (needRedirectAsync()) {
            }
        }
        z = false;
        if (str2 != null) {
        }
        z2 = false;
        if (z) {
        }
        final LynxContext lynxContext32 = ContextUtils.toLynxContext(this.mContext);
        if (needRedirectAsync()) {
        }
    }

    private boolean needRedirectAsync() {
        if (this.mFirstRequest) {
            this.mFirstRequest = false;
            if (this.mEnableAsyncRedirectOnCreate && !UIThreadUtils.isOnUiThread()) {
                return false;
            }
        }
        return this.mEnableAsyncRedirect;
    }

    public void setCapInsets(String str) {
        this.mCapInsets = str;
        this.mImageResourceOperation.markDirty();
    }

    public void setEnableAsyncRedirect(boolean z) {
        this.mEnableAsyncRedirect = z;
    }

    public void setCapInsetsScale(String str) {
        this.mCapInsetsScale = str;
        this.mImageResourceOperation.markDirty();
    }

    public void setImageRequestPriority(String str) {
        this.mRequestPriority = str;
    }

    public void setImageCacheChoice(String str) {
        this.mCacheChoice = str;
    }

    public void setImagePlaceHolderHashConfig(ReadableMap readableMap) {
        if (readableMap != null) {
            String string = readableMap.getString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
            if ("preview".equalsIgnoreCase(string)) {
                this.mEnablePreViewHash = true;
            } else if ("blur".equalsIgnoreCase(string)) {
                this.mEnableBlurHash = true;
            } else {
                this.mEnablePreViewHash = false;
                this.mEnableBlurHash = false;
            }
            if (this.mEnablePreViewHash || this.mEnableBlurHash) {
                this.mHashWidth = Math.round(UnitUtils.toPxWithDisplayMetrics(readableMap.getString("width"), this.mLynxContext.getUIBody().getFontSize(), this.mLynxBaseUI.getFontSize(), this.mLynxContext.getUIBody().getWidth(), this.mLynxContext.getUIBody().getHeight(), this.mLynxContext.getScreenMetrics()));
                this.mHashHeight = Math.round(UnitUtils.toPxWithDisplayMetrics(readableMap.getString("height"), this.mLynxContext.getUIBody().getFontSize(), this.mLynxBaseUI.getFontSize(), this.mLynxContext.getUIBody().getWidth(), this.mLynxContext.getUIBody().getHeight(), this.mLynxContext.getScreenMetrics()));
                this.mHashRadius = Math.round(UnitUtils.toPxWithDisplayMetrics(readableMap.getString("radius"), this.mLynxContext.getUIBody().getFontSize(), this.mLynxBaseUI.getFontSize(), this.mLynxContext.getUIBody().getWidth(), this.mLynxContext.getUIBody().getHeight(), this.mLynxContext.getScreenMetrics()));
                this.mHashString = readableMap.getString("hash");
                this.mMetaData = readableMap.getString("metaData");
                this.mIterations = readableMap.getInt("iterations", 1);
            }
        }
    }

    public void setHierarchy(GenericDraweeHierarchy genericDraweeHierarchy) {
        this.mHierarchy = genericDraweeHierarchy;
    }

    public void setAutoSize(boolean z) {
        this.mAutoSize = z;
        if (!z || (this.mImageHeight != 0 && this.mImageWidth != 0)) {
            justSizeIfNeeded();
        }
        this.mImageResourceOperation.markDirty();
    }

    public void justSizeIfNeeded() {
        final int i;
        final int i2;
        LynxBaseUI lynxBaseUI = this.mLynxBaseUI;
        if (lynxBaseUI == null || (i = this.mImageWidth) == 0 || (i2 = this.mImageHeight) == 0) {
            return;
        }
        final boolean z = this.mAutoSize;
        final int width = lynxBaseUI.getWidth();
        final int height = this.mLynxBaseUI.getHeight();
        if (this.mEnableImageAsyncLayout) {
            this.mLynxBaseUI.getLynxContext().findShadowNodeAndRunTask(this.mLynxBaseUI.getSign(), new LynxConsumer() { // from class: com.lynx.tasm.ui.image.ImageDelegate$$ExternalSyntheticLambda0
                public final void accept(Object obj) {
                    ImageDelegate.lambda$justSizeIfNeeded$0(z, i, i2, width, height, (ShadowNode) obj);
                }
            });
            return;
        }
        if (this.mAutoSizeShadowNode == null) {
            this.mAutoSizeShadowNode = this.mLynxBaseUI.getLynxContext().findShadowNodeBySign(this.mLynxBaseUI.getSign());
        }
        ShadowNode shadowNode = this.mAutoSizeShadowNode;
        if (!(shadowNode instanceof AutoSizeImage)) {
            this.mNeedRetryAutoSize = true;
        } else {
            ((AutoSizeImage) shadowNode).justSizeIfNeeded(z, i, i2, width, height);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$justSizeIfNeeded$0(boolean z, int i, int i2, int i3, int i4, ShadowNode shadowNode) {
        if (!(shadowNode instanceof AutoSizeImage)) {
            LLog.e(TAG, "ShadowNode is not an instance of AutoSizeImage.");
        } else {
            ((AutoSizeImage) shadowNode).justSizeIfNeeded(z, i, i2, i3, i4);
        }
    }

    public boolean isNeedAutoSize() {
        return this.mAutoSize && this.mImageWidth == 0 && this.mImageHeight == 0;
    }

    public boolean isAutoSize() {
        return this.mAutoSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSimpleCacheKey(boolean z) {
        this.mSimpleCacheKey = z;
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        this.mImageResourceOperation.markDirty();
    }

    public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
        this.mResizeMethod = imageResizeMethod;
        this.mImageResourceOperation.markDirty();
    }

    public void setBlurRadius(int i) {
        if (i == 0) {
            this.mIterativeBoxBlurPostProcessor = null;
        } else {
            try {
                this.mIterativeBoxBlurPostProcessor = new LynxIterativeBoxBlurPostProcessor(i, this.mLynxContext);
            } catch (Exception e) {
                LLog.e(TAG, "setBlurRadius failed: " + e.toString());
            }
        }
        this.mImageResourceOperation.markDirty();
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.mProgressiveRenderingEnabled = z;
    }

    public void setHeaders(ReadableMap readableMap) {
        this.mHeaders = readableMap;
    }

    public void setUseLocalCache(boolean z) {
        this.mUseLocalCache = z;
    }

    public void setAwaitLocalCache(boolean z) {
        this.mAwaitLocalCache = z;
    }

    public void setEnableAsyncRequestImage(boolean z) {
        this.mEnableAsyncRequestImage = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fetchImageRedirectPath(String str, LynxContext lynxContext) {
        if (!this.mEnableGenericFetcher) {
            if (this.mEnableAsyncRedirect) {
                return ImageUrlRedirectUtils.asyncRedirectUrl(lynxContext, str);
            }
            return ImageUrlRedirectUtils.redirectUrl(lynxContext, str);
        }
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            TraceEvent.beginSection(TraceEventDef.MEDIA_FETCHER_SHOULD_REDIRECT, hashMap);
        }
        String shouldRedirectUrl = this.mResourceFetcher.shouldRedirectUrl(new LynxResourceRequest(str, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage));
        if (!TraceEvent.isTracingStarted()) {
            return shouldRedirectUrl;
        }
        TraceEvent.endSection(TraceEventDef.MEDIA_FETCHER_SHOULD_REDIRECT);
        return shouldRedirectUrl;
    }

    public void tryFetchImageFromLocalCache(final int i, final int i2, boolean z) {
        ImageSource imageSource = this.mImageSource;
        if (imageSource == null || imageSource.getSource() == null || !this.mUseLocalCache || this.mContext == null) {
            return;
        }
        TraceEvent.beginSection(TraceEventDef.IMAGE_DELEGATE_TRY_FETCH_FROM_LOCAL_CACHE);
        final long currentTimeMillis = System.currentTimeMillis();
        final String source = this.mImageSource.getSource();
        ImageUrlRedirectUtils.loadImage(this.mContext, null, source, i, i2, null, new ImageInterceptor.CompletionHandler() { // from class: com.lynx.tasm.ui.image.ImageDelegate.3
            @Override // com.lynx.tasm.behavior.ImageInterceptor.CompletionHandler
            public void imageLoadCompletion(final Object obj, Throwable th) {
                try {
                    if (!(obj instanceof CloseableReference)) {
                        ImageDelegate.this.retryWhenNoLocalCache();
                        LLog.w(ImageDelegate.TAG, "localCache image is not CloseableReference and the url is: " + source);
                        return;
                    }
                    Object obj2 = ((CloseableReference) obj).get();
                    if (!(obj2 instanceof Bitmap) && !(obj2 instanceof CloseableBitmap)) {
                        ImageDelegate.this.retryWhenNoLocalCache();
                        LLog.w(ImageDelegate.TAG, "localCache cannot get bitmap and the url is: " + source);
                        return;
                    }
                    Runnable runnable = new Runnable() { // from class: com.lynx.tasm.ui.image.ImageDelegate.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ImageDelegate.this.mImageSource == null || !source.equals(ImageDelegate.this.mImageSource.getSource())) {
                                ImageDelegate.this.retryWhenNoLocalCache();
                                LLog.w(ImageDelegate.TAG, "localCache url check error: " + source);
                            } else {
                                ImageDelegate.this.reportImageInfo(ImageDelegate.this.mRawSrc, true, true, currentTimeMillis, System.currentTimeMillis(), 0, ImageDelegate.this.bitmapMemorySize(i, i2));
                                ImageDelegate.this.mImageResourceOperation.onLocalCacheGet((CloseableReference) obj);
                            }
                        }
                    };
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        runnable.run();
                    } else {
                        new Handler(Looper.getMainLooper()).post(runnable);
                    }
                } catch (Throwable th2) {
                    ImageDelegate.this.retryWhenNoLocalCache();
                    th2.printStackTrace();
                }
            }
        });
        TraceEvent.endSection(TraceEventDef.IMAGE_DELEGATE_TRY_FETCH_FROM_LOCAL_CACHE);
    }

    public boolean tryFetchImageFromMediaFetcher(final int i, final int i2, boolean z) {
        ImageSource imageSource = this.mImageSource;
        if (imageSource == null || imageSource.getSource() == null || !this.mUseLocalCache || this.mLynxContext == null) {
            return false;
        }
        TraceEvent.beginSection(TraceEventDef.IMAGE_DELEGATE_TRY_FETCH_FROM_MEDIA_FETCHER);
        final long currentTimeMillis = System.currentTimeMillis();
        this.mResourceFetcher.fetchImage(new LynxResourceRequest(this.mImageSource.getSource(), LynxResourceRequest.LynxResourceType.LynxResourceTypeImage), new LynxResourceCallback<Closeable>() { // from class: com.lynx.tasm.ui.image.ImageDelegate.4
            @Override // com.lynx.tasm.resourceprovider.LynxResourceCallback
            public void onResponse(LynxResourceResponse<Closeable> lynxResourceResponse) {
                if (lynxResourceResponse.getState() != LynxResourceResponse.ResponseState.SUCCESS || !(lynxResourceResponse.getData() instanceof CloseableReference)) {
                    ImageDelegate.this.mImageResourceOperation.fetchFrescoResource();
                    return;
                }
                ImageDelegate.this.mImageResourceOperation.onLocalCacheGet((CloseableReference) lynxResourceResponse.getData());
                long currentTimeMillis2 = System.currentTimeMillis();
                int bitmapMemorySize = ImageDelegate.this.bitmapMemorySize(i, i2);
                ImageDelegate imageDelegate = ImageDelegate.this;
                imageDelegate.reportImageInfo(imageDelegate.mRawSrc, true, true, currentTimeMillis, currentTimeMillis2, 0, bitmapMemorySize);
            }
        });
        TraceEvent.endSection(TraceEventDef.IMAGE_DELEGATE_TRY_FETCH_FROM_MEDIA_FETCHER);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryWhenNoLocalCache() {
        Runnable runnable = new Runnable() { // from class: com.lynx.tasm.ui.image.ImageDelegate.5
            @Override // java.lang.Runnable
            public void run() {
                if (ImageDelegate.this.mAwaitLocalCache) {
                    ImageDelegate.this.mAwaitLocalCache = false;
                    ImageDelegate.this.mImageResourceOperation.fetchFrescoResource();
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public boolean retryWithRawSrc(String str) {
        if (str == null || !str.equals(this.mRawSrc) || !str.startsWith(HTTP_PREFIX)) {
            return false;
        }
        int i = this.mRetryCount;
        this.mRetryCount = i - 1;
        if (i <= 0) {
            return false;
        }
        setSrcInternal(str);
        this.mImageResourceOperation.markDirty();
        this.mImageResourceOperation.maybeUpdateView();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequestBuilder createImageRequestBuilder(Uri uri) {
        ImageRequestBuilder imageRequestBuilder = ImageUtils.getImageRequestBuilder(uri, this.mBitmapConfig, this.mEnableCustomGifDecoder);
        if (!this.mCustomParams.isEmpty()) {
            ByteDanceFrescoUtils.setCustomParam(imageRequestBuilder, this.mCustomParams);
        } else {
            LynxContext lynxContext = this.mLynxContext;
            if (lynxContext != null && lynxContext.getImageCustomParam() != null) {
                ByteDanceFrescoUtils.setCustomParam(imageRequestBuilder, this.mLynxContext.getImageCustomParam());
            }
        }
        return imageRequestBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnableCustomGifDecoder(boolean z) {
        this.mEnableCustomGifDecoder = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageRequest createImageRequest(ImageSource imageSource, int i, int i2, int i3, int i4, int i5, int i6, float[] fArr, ScalingUtils.ScaleType scaleType) {
        ImageRequestBuilder imageRequestBuilder;
        ImageDelegate imageDelegate;
        LinkedList linkedList;
        ImageRequestBuilder imageRequestBuilder2;
        boolean z;
        ILynxImageService iLynxImageService;
        ILynxImageService iLynxImageService2;
        if (imageSource == null) {
            return null;
        }
        TraceEvent.beginSection(TraceEventDef.IMAGE_DELEGATE_CREATE_IMAGE_REQUEST);
        ImageRequestBuilder createImageRequestBuilder = this.mImageResourceOperation.createImageRequestBuilder(imageSource.getUri());
        createImageRequestBuilder.setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled);
        if (!this.enableResourceHint && !this.mEnableImageSR) {
            createImageRequestBuilder.setResizeOptions(ImageResizeUtils.shouldResize(imageSource, this.mResizeMethod) && !this.mAutoSize ? ImageResizeUtils.getResizeOptions(i, i2, this.mLastWidth, this.mLastHeight) : null);
        }
        if (this.mEnableSmallDiskCache && createImageRequestBuilder.getCacheChoice() == ImageRequest.CacheChoice.DEFAULT) {
            createImageRequestBuilder.setCacheChoice(ImageRequest.CacheChoice.SMALL);
        }
        if (this.mEnableAsyncRequestImage) {
            createImageRequestBuilder.setRequestPriority(Priority.HIGH);
        }
        boolean isUseImagePostProcessor = this.mImageResourceOperation.isUseImagePostProcessor();
        LinkedList linkedList2 = new LinkedList();
        if (this.mEnableImageSR) {
            ILynxImageService iLynxImageService3 = this.mLynxImageService;
            if (iLynxImageService3 != null) {
                linkedList2.add((Postprocessor) iLynxImageService3.getImageSRPostProcessor());
            }
            if (this.mImageSRScale > 0.0f) {
                try {
                    Method method = ImageRequestBuilder.class.getMethod("setTargetWidth", Integer.TYPE);
                    Method method2 = ImageRequestBuilder.class.getMethod("setTargetHeight", Integer.TYPE);
                    float f = i;
                    method.invoke(createImageRequestBuilder, Integer.valueOf((int) (this.mImageSRScale * f)));
                    float f2 = i2;
                    method2.invoke(createImageRequestBuilder, Integer.valueOf((int) (this.mImageSRScale * f2)));
                    LLog.d(TAG, "SR setTargetWidth:setTargetHeight" + ((int) (f * this.mImageSRScale)) + "::" + ((int) (f2 * this.mImageSRScale)));
                } catch (IllegalAccessException e) {
                    LLog.e(TAG, "SR invoke setTargetWidth & setTargetHeight failed:" + e);
                } catch (NoSuchMethodException e2) {
                    LLog.e(TAG, "SR no such method setTargetWidth & setTargetHeight:" + e2);
                } catch (InvocationTargetException e3) {
                    LLog.e(TAG, "SR invoke setTargetWidth & setTargetHeight failed:" + e3);
                }
            }
        }
        if (!isUseImagePostProcessor || i <= 0 || i2 <= 0 || this.mIsUsedForBackgroundImage) {
            imageRequestBuilder = createImageRequestBuilder;
            imageDelegate = this;
            linkedList = linkedList2;
        } else {
            imageRequestBuilder = createImageRequestBuilder;
            linkedList2.add(new RoundedCornerPostprocessor(imageSource.getUri().toString(), i, i2, i3, i4, i5, i6, fArr, scaleType, this.mCapInsets, this.mCapInsetsScale, this.mBitmapConfig, this.mSimpleCacheKey));
            linkedList = linkedList2;
            imageDelegate = this;
        }
        IterativeBoxBlurPostProcessor iterativeBoxBlurPostProcessor = imageDelegate.mIterativeBoxBlurPostProcessor;
        if (iterativeBoxBlurPostProcessor != null) {
            linkedList.add(iterativeBoxBlurPostProcessor);
        }
        imageDelegate.mImageResourceOperation.onPostprocessorPreparing(linkedList);
        Postprocessor from = MultiPostprocessor.from(linkedList);
        if (from == null || !isSupportPostProcess()) {
            imageRequestBuilder2 = imageRequestBuilder;
        } else {
            imageRequestBuilder2 = imageRequestBuilder;
            imageRequestBuilder2.setPostprocessor(from);
        }
        if (!TextUtils.isEmpty(imageDelegate.mRequestPriority)) {
            if ("high".equalsIgnoreCase(imageDelegate.mRequestPriority)) {
                imageRequestBuilder2.setRequestPriority(Priority.HIGH);
            } else if ("low".equalsIgnoreCase(imageDelegate.mRequestPriority)) {
                imageRequestBuilder2.setRequestPriority(Priority.LOW);
            } else {
                imageRequestBuilder2.setRequestPriority(Priority.MEDIUM);
            }
        }
        if (!TextUtils.isEmpty(imageDelegate.mCacheChoice) && (iLynxImageService2 = imageDelegate.mLynxImageService) != null) {
            iLynxImageService2.setImageCacheChoice(imageDelegate.mCacheChoice, imageRequestBuilder2);
        }
        LynxNetworkImageRequest fromBuilderWithHeaders = LynxNetworkImageRequest.fromBuilderWithHeaders(imageRequestBuilder2, imageDelegate.mHeaders);
        if (!TextUtils.isEmpty(imageDelegate.mHashString) && (((z = imageDelegate.mEnablePreViewHash) || imageDelegate.mEnableBlurHash) && (iLynxImageService = imageDelegate.mLynxImageService) != null)) {
            iLynxImageService.setImagePlaceHolderHash(imageDelegate.mHierarchy, fromBuilderWithHeaders, scaleType, imageDelegate.mHashString, imageDelegate.mMetaData, imageDelegate.mHashWidth, imageDelegate.mHashHeight, imageDelegate.mHashRadius, imageDelegate.mIterations, z);
        }
        TraceEvent.endSection(TraceEventDef.IMAGE_DELEGATE_CREATE_IMAGE_REQUEST);
        return fromBuilderWithHeaders;
    }

    public void monitorReporter(String str, boolean z, boolean z2, long j, long j2, int i, JSONObject jSONObject) {
        boolean enableImageMemoryReport = LynxEnv.inst().enableImageMemoryReport();
        LynxContext lynxContext = ContextUtils.toLynxContext(this.mContext);
        if (enableImageMemoryReport) {
            LynxBaseUI lynxBaseUI = this.mLynxBaseUI;
            FrescoEventHelper.monitorReporterV2(lynxContext, lynxBaseUI != null ? lynxBaseUI.getSign() : -1, str, z, z2, j, j2, i, jSONObject);
        } else if (this.mEnableImageEventReport) {
            FrescoEventHelper.monitorReporter(lynxContext, str, z, z2, j, j2, i, jSONObject);
        }
    }

    public void reportImageInfo(String str, boolean z, boolean z2, long j, long j2, int i, int i2) {
        LynxContext lynxContext = ContextUtils.toLynxContext(this.mContext);
        if (this.mEnableImageEventReport) {
            FrescoEventHelper.reportImageInfo(lynxContext, str, z, z2, j, j2, i2, i);
        }
    }

    public void reportImageEvent(String str, int i, boolean z, int i2, long j, long j2, boolean z2, int i3, int i4) {
        if (this.mEnableImageEventReport && str.startsWith(HTTP_PREFIX)) {
            FrescoEventHelper.reportImageEvent(ContextUtils.toLynxContext(this.mContext), str, i, z, i2, j, j2, z2, i3, i4, this.mCustomParams);
        }
    }

    public void reportImageEvent(String str, int i, boolean z, int i2, long j, long j2, boolean z2) {
        reportImageEvent(str, i, z, i2, j, j2, z2, 0, 0);
    }

    public int bitmapMemorySize(int i, int i2) {
        Bitmap.Config config = this.mBitmapConfig;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        return BitmapUtil.getSizeInByteForBitmap(i, i2, config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCustomEvent(String str) {
        if (this.mLynxContext == null || this.mLynxBaseUI == null) {
            return;
        }
        this.mLynxContext.getEventEmitter().sendCustomEvent(new LynxDetailEvent(this.mLynxBaseUI.getSign(), str));
    }

    private void warnImageSource(String str) {
        LLog.w(LynxConstants.TAG, "Warning: Image source \"" + str + "\" doesn't exist");
    }

    private boolean isSupportPostProcess() {
        ImageSource imageSource = this.mImageSource;
        if (imageSource == null) {
            return false;
        }
        String lowerCase = imageSource.getUri().toString().toLowerCase();
        return (lowerCase.endsWith(".gif") || lowerCase.endsWith(".apng")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class RoundedCornerPostprocessor extends BaseRoundedCornerPostprocessor {
        private final String mUrl;

        RoundedCornerPostprocessor(String str, int i, int i2, int i3, int i4, int i5, int i6, float[] fArr, ScalingUtils.ScaleType scaleType, String str2, String str3, Bitmap.Config config, boolean z) {
            super(str, i, i2, i3, i4, i5, i6, fArr, scaleType, str2, str3, config, z);
            this.mUrl = str;
        }

        @Override // com.lynx.tasm.p001ui.image.fresco.BaseRoundedCornerPostprocessor
        public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            if (!ImageDelegate.sUrlImageSizeMap.containsKey(this.mUrl)) {
                ImageDelegate.sUrlImageSizeMap.put(this.mUrl, new FrescoImageView.ImageSize(bitmap.getWidth(), bitmap.getHeight()));
            }
            return super.process(bitmap, platformBitmapFactory);
        }
    }

    public ImageSource getImageSource() {
        return this.mImageSource;
    }

    public boolean setEnableResourceHint() {
        return this.enableResourceHint;
    }

    public ImageSource getImagePlaceholder() {
        return this.mImagePlaceholder;
    }

    public String getRawSrc() {
        return this.mRawSrc;
    }

    public String getCapInsets() {
        return this.mCapInsets;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLoopCount() {
        return this.mLoopCount;
    }

    public String getCapInsetsScale() {
        return this.mCapInsetsScale;
    }

    public ImageResizeMethod getResizeMethod() {
        return this.mResizeMethod;
    }

    public boolean isUseLocalCache() {
        return this.mUseLocalCache;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public boolean isAwaitLocalCache() {
        return this.mAwaitLocalCache;
    }

    public void setIsUsedForBackgroundImage(boolean z) {
        this.mIsUsedForBackgroundImage = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLynxBaseUI(LynxBaseUI lynxBaseUI) {
        this.mLynxBaseUI = lynxBaseUI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageRedirectListener(ImageAsyncRedirectListener imageAsyncRedirectListener) {
        this.mImageRedirectListener = imageAsyncRedirectListener;
    }

    public void setLastWidth(int i) {
        this.mLastWidth = i;
    }

    public void setLastHeight(int i) {
        this.mLastHeight = i;
    }

    public void setImageWidth(int i) {
        this.mImageWidth = i;
    }

    public void setImageHeight(int i) {
        this.mImageHeight = i;
    }

    public void setEnableResourceHint(boolean z) {
        this.enableResourceHint = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoopCount(int i) {
        this.mLoopCount = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageEvents(Map<String, EventsListener> map) {
        this.mEnableStartPlayEvent = false;
        this.mEnableCurrentLoopEvent = false;
        this.mEnableAllLoopEvent = false;
        if (map.containsKey("startplay")) {
            this.mEnableStartPlayEvent = true;
        }
        if (map.containsKey("currentloopcomplete")) {
            this.mEnableCurrentLoopEvent = true;
        }
        if (map.containsKey("finalloopcomplete")) {
            this.mEnableAllLoopEvent = true;
        }
        if (map.containsKey("load")) {
            this.mEnableOnLoad = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtraLoadInfo(boolean z) {
        this.mNeedExtraLoadInfo = z;
    }

    void handlerAnim(Animatable animatable) {
        if (animatable instanceof AnimatedDrawable2) {
            AnimatedDrawable2 animatedDrawable2 = (AnimatedDrawable2) animatable;
            if (this.mEnableAllLoopEvent || this.mEnableStartPlayEvent || this.mEnableCurrentLoopEvent) {
                animatedDrawable2.setAnimationListener(this.mAnimationListener);
            } else {
                animatedDrawable2.setAnimationListener((AnimationListener) null);
            }
            animatedDrawable2.setAnimationBackend(new LoopCountModifyingBackend(animatedDrawable2.getAnimationBackend(), getLoopCount()));
            ByteDanceFrescoUtils.fixSlowBug(animatedDrawable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleImageSuccessCallback(int i, int i2, ImageInfo imageInfo, Animatable animatable, long j, boolean z, int i3, ImageLoaderCallback imageLoaderCallback) {
        int i4;
        int i5;
        int i6;
        int i7;
        JSONObject sizeInfo;
        JSONObject jSONObject;
        long j2;
        int i8;
        long currentTimeMillis = System.currentTimeMillis();
        int i9 = 0;
        if (getImageSource() != null && sUrlImageSizeMap.containsKey(getImageSource().getUri().toString())) {
            FrescoImageView.ImageSize imageSize = sUrlImageSizeMap.get(getImageSource().getUri().toString());
            int width = imageSize.getWidth();
            i5 = i2;
            i6 = imageSize.getHeight();
            i7 = width;
        } else if (imageInfo != null) {
            i5 = i2;
            i7 = imageInfo.getWidth();
            i6 = imageInfo.getHeight();
        } else {
            i4 = i;
            i5 = i2;
            i6 = 0;
            i7 = 0;
            sizeInfo = getSizeInfo(i4, i5, i7, i6);
            if (sizeInfo != null) {
                if (animatable != null && z) {
                    i9 = 1;
                }
                try {
                    sizeInfo.put("isFlattenAnim", i9);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (imageLoaderCallback == null) {
                if (isNeedAutoSize()) {
                    setImageWidth(i7);
                    setImageHeight(i6);
                    justSizeIfNeeded();
                }
                if (this.mNeedExtraLoadInfo) {
                    jSONObject = sizeInfo;
                    j2 = currentTimeMillis;
                    i8 = i6;
                    sendLoadEventWithExtraInfo(i, i2, i7, i6, j, currentTimeMillis, false);
                } else {
                    jSONObject = sizeInfo;
                    j2 = currentTimeMillis;
                    i8 = i6;
                    imageLoaderCallback.onImageLoadSuccess(i7, i8);
                }
            } else {
                jSONObject = sizeInfo;
                j2 = currentTimeMillis;
                i8 = i6;
            }
            handlerAnim(animatable);
            int bitmapMemorySize = bitmapMemorySize(i7, i8);
            this.mBitmapMemorySizeBytes = bitmapMemorySize;
            long j3 = j2;
            monitorReporter(getRawSrc(), true, false, j, j3, bitmapMemorySize, jSONObject);
            reportImageInfo(getRawSrc(), true, false, j, j3, 0, bitmapMemorySize);
            reportImageEvent(getRawSrc(), 0, false, i3, j, j2, z, i7, i8);
        }
        i4 = i;
        sizeInfo = getSizeInfo(i4, i5, i7, i6);
        if (sizeInfo != null) {
        }
        if (imageLoaderCallback == null) {
        }
        handlerAnim(animatable);
        int bitmapMemorySize2 = bitmapMemorySize(i7, i8);
        this.mBitmapMemorySizeBytes = bitmapMemorySize2;
        long j32 = j2;
        monitorReporter(getRawSrc(), true, false, j, j32, bitmapMemorySize2, jSONObject);
        reportImageInfo(getRawSrc(), true, false, j, j32, 0, bitmapMemorySize2);
        reportImageEvent(getRawSrc(), 0, false, i3, j, j2, z, i7, i8);
    }

    private JSONObject getSizeInfo(int i, int i2, int i3, int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewWidth", i);
            jSONObject.put("viewHeight", i2);
            jSONObject.put("width", i3);
            jSONObject.put("height", i4);
            jSONObject.put("config", getBitmapConfig() == null ? DEFAULT_BITMAP_CONFIG : getBitmapConfig());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendLoadEventWithExtraInfo(int i, int i2, int i3, int i4, long j, long j2, boolean z) {
        String str;
        Object obj;
        String str2;
        if (!this.mEnableOnLoad || this.mLynxContext == null || this.mLynxBaseUI == null) {
            return;
        }
        int bitmapMemorySize = bitmapMemorySize(i3, i4);
        long j3 = j2 - j;
        if (this.mImageSource == null || (str2 = this.mRawSrc) == null) {
            str = "";
        } else if (str2.startsWith("data")) {
            str = "base64";
        } else {
            str = (this.mRawSrc.startsWith(HTTP_PREFIX) && this.mImageSource.getSource().equals(this.mRawSrc)) ? "cdn" : "local resource";
        }
        String str3 = str;
        JSONObject reportData = FrescoEventHelper.getReportData(this.mLynxContext, getRawSrc(), true, z, j, j3, j3, j2, bitmapMemorySize, getSizeInfo(i, i2, i3, i4));
        if (reportData != null) {
            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(this.mLynxBaseUI.getSign(), "load");
            Iterator<String> keys = reportData.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    obj = reportData.get(next);
                } catch (JSONException e) {
                    e.printStackTrace();
                    obj = null;
                }
                lynxDetailEvent.addDetail(next, obj);
            }
            lynxDetailEvent.addDetail("resourceFrom", str3);
            lynxDetailEvent.addDetail("width", Integer.valueOf(i3));
            lynxDetailEvent.addDetail("height", Integer.valueOf(i4));
            this.mLynxContext.getEventEmitter().sendCustomEvent(lynxDetailEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNodeReady() {
        if (this.mNeedRetryAutoSize) {
            this.mNeedRetryAutoSize = false;
            if (isAutoSize()) {
                justSizeIfNeeded();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageCustomParams(ReadableMap readableMap) {
        if (!this.mCustomParams.isEmpty()) {
            this.mCustomParams.clear();
        }
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                this.mCustomParams.put(nextKey, readableMap.getString(nextKey, ""));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnableImageSR(boolean z) {
        this.mEnableImageSR = z;
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImageSRScale(float f) {
        if (f > 0.0f) {
            this.mEnableImageSR = true;
            this.mBitmapConfig = Bitmap.Config.ARGB_8888;
            this.mImageSRScale = f;
        } else {
            this.mEnableImageSR = false;
            this.mImageSRScale = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getEnableImageSR() {
        return this.mEnableImageSR;
    }

    public IterativeBoxBlurPostProcessor getIterativeBoxBlurPostProcessor() {
        return this.mIterativeBoxBlurPostProcessor;
    }
}
