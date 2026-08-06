package com.lynx.tasm.behavior.p000ui.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.ViewInfo;
import com.lynx.tasm.behavior.p000ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.group.ILynxViewRuntimeCacheManager;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.image.ImageContent;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.image.ImageUtils;
import com.lynx.tasm.image.LynxImageMediaFetcherProxy;
import com.lynx.tasm.image.LynxScaleTypeDrawable;
import com.lynx.tasm.image.ScalingUtils;
import com.lynx.tasm.image.model.AnimationListener;
import com.lynx.tasm.image.model.ImageBlurPostProcessor;
import com.lynx.tasm.image.model.ImageInfo;
import com.lynx.tasm.image.model.ImageLoadListener;
import com.lynx.tasm.image.model.ImageRequestInfo;
import com.lynx.tasm.image.model.ImageRequestInfoBuilder;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.UnitUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxImageManager implements Drawable.Callback {
    private static final long ASYNC_REQUEST_CHANGED = 256;
    private static final long AUTO_SIZE_CHANGED = 64;
    private static final long BLUR_RADIUS_CHANGED = 32;
    private static final long BORDER_CHANGED = 1024;
    private static final long BORDER_RADIUS_CHANGED = 4096;
    private static final long CAP_INSETS_CHANGED = 8;
    private static final long DOWN_SAMPLING_SCALE_CHANGED = 2048;
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_LOAD = "load";
    private static final long LAYOUT_CHANGED = 512;
    private static final long MODE_CHANGED = 16;
    private static final long PLACEHOLDER_CHANGED = 4;
    private static final long SRC_CHANGED = 2;
    public static final String TAG = "LynxImageManager";
    private static final long TINT_COLOR_CHANGED = 128;
    private final AnimationListener mAnimationListener;
    private final boolean mAsyncRedirect;
    private boolean mAutoSize;
    private boolean mAwaitLocalCache;
    private Bitmap.Config mBitmapConfig;
    private String mBlurRadius;
    private float mBorderBottomWidth;
    private float mBorderLeftWidth;
    private float[] mBorderRadius;
    private float mBorderRightWidth;
    private float mBorderTopWidth;
    private String mCapInsets;
    private String mCapInsetsScale;
    private final LynxContext mContext;
    private ImageRequestInfo mCurImageRequest;
    private ImageRequestInfo mCurPlaceholderRequest;
    private boolean mDeferInvalidation;
    private boolean mDisableDefaultPlaceholder;
    private boolean mDisableDefaultResize;
    private Rect mDrawableBounds;
    private boolean mEnableAllLoopEvent;
    private boolean mEnableCheckLocalImage;
    private boolean mEnableCurrentLoopEvent;
    private boolean mEnableCustomGifDecoder;
    private boolean mEnableExtraLoadInfo;
    private boolean mEnableOnError;
    private boolean mEnableOnLoad;
    private boolean mEnableResourceHint;
    private boolean mEnableStartPlayEvent;
    private LynxScaleTypeDrawable mImageDrawable;
    private int mImageHeight;
    private final LynxImageLoader mImageLoader;
    private int mImageWidth;
    private BackgroundDrawable.RoundRectPath mInnerClipPathForBorderRadius;
    private final LynxMediaResourceFetcher mMediaResourceFetcher;
    private boolean mNeedRetryAutoSize;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private final ImageLoadListener mPlaceHolderListener;
    private String mPlaceholder;
    private LynxScaleTypeDrawable mPlaceholderDrawable;
    private int mPreFetchHeight;
    private int mPreFetchWidth;
    private boolean mSkipRedirection;
    private String mSrc;
    private final ImageRequestHandle mSrcLoadListener;
    private final ImageLoadListener mSrcLoadListenerInner;
    private String mTintColor;
    private LynxBaseUI mUI;
    private boolean mUseLocalCache;
    private int mViewHeight;
    private ViewInfo mViewInfo;
    private int mViewWidth;
    private long dirtyFlags = 0;
    private ScalingUtils.ScaleType mMode = ScalingUtils.ScaleType.FIT_XY;
    private int mLoopCount = 0;
    private boolean mAutoPlay = true;
    private boolean mEnableAsyncRequest = true;
    private RectF mBorderWidthRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private ShadowNode mAutoSizeShadowNode = null;
    private OptionalBool mSrcRedirectCheckResult = OptionalBool.UNDEFINED;
    private OptionalBool mPlaceHolderRedirectCheckResult = OptionalBool.UNDEFINED;
    private final String EVENT_START_PLAY = "startplay";
    private final String EVENT_CURRENT_LOOP_COMPLETE = "currentloopcomplete";
    private final String EVENT_ALL_LOOP_COMPLETE = "finalloopcomplete";
    private ColorFilter mColorFilter = null;
    private ImageRequestInfo mPreImageRequestInfo = null;
    private boolean mIsPixelated = false;

    public void onPropsUpdated() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ImageRequestHandle implements ImageLoadListener {
        private final ArrayList<Runnable> mRunnableList = new ArrayList<>();
        private final ImageLoadListener mSrcLoadListenerImpl;

        public ImageRequestHandle(ImageLoadListener imageLoadListener) {
            this.mSrcLoadListenerImpl = imageLoadListener;
        }

        public synchronized void tryHandleResult() {
            if (this.mRunnableList.isEmpty()) {
                return;
            }
            Iterator<Runnable> it = this.mRunnableList.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.mRunnableList.clear();
        }

        private synchronized void handleCallback(Runnable runnable) {
            this.mRunnableList.add(runnable);
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.ImageRequestHandle.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageRequestHandle.this.tryHandleResult();
                }
            });
        }

        @Override // com.lynx.tasm.image.model.ImageLoadListener
        public synchronized void onRequestSubmit(final ImageRequestInfo imageRequestInfo) {
            handleCallback(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.ImageRequestHandle.2
                @Override // java.lang.Runnable
                public void run() {
                    ImageRequestHandle.this.mSrcLoadListenerImpl.onRequestSubmit(imageRequestInfo);
                }
            });
        }

        @Override // com.lynx.tasm.image.model.ImageLoadListener
        public synchronized void onSuccess(final ImageContent imageContent, final ImageRequestInfo imageRequestInfo, final ImageInfo imageInfo) {
            handleCallback(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.ImageRequestHandle.3
                @Override // java.lang.Runnable
                public void run() {
                    ImageRequestHandle.this.mSrcLoadListenerImpl.onSuccess(imageContent, imageRequestInfo, imageInfo);
                }
            });
        }

        @Override // com.lynx.tasm.image.model.ImageLoadListener
        public synchronized void onFailure(final int i, final Throwable th) {
            handleCallback(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.ImageRequestHandle.4
                @Override // java.lang.Runnable
                public void run() {
                    ImageRequestHandle.this.mSrcLoadListenerImpl.onFailure(i, th);
                }
            });
        }

        @Override // com.lynx.tasm.image.model.ImageLoadListener
        public synchronized void onImageMonitorInfo(final JSONObject jSONObject) {
            handleCallback(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.ImageRequestHandle.5
                @Override // java.lang.Runnable
                public void run() {
                    ImageRequestHandle.this.mSrcLoadListenerImpl.onImageMonitorInfo(jSONObject);
                }
            });
        }
    }

    public LynxImageManager(LynxContext lynxContext) {
        this.mEnableCheckLocalImage = false;
        ImageLoadListener imageLoadListener = new ImageLoadListener() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.1
            @Override // com.lynx.tasm.image.model.ImageLoadListener
            public void onRequestSubmit(ImageRequestInfo imageRequestInfo) {
            }

            @Override // com.lynx.tasm.image.model.ImageLoadListener
            public void onSuccess(ImageContent imageContent, ImageRequestInfo imageRequestInfo, ImageInfo imageInfo) {
                if (TextUtils.equals(imageRequestInfo.getUrl(), LynxImageManager.this.mCurImageRequest != null ? LynxImageManager.this.mCurImageRequest.getUrl() : null)) {
                    if (imageContent != null) {
                        if (LynxImageManager.this.mIsPixelated) {
                            imageContent.setFilterBitmap(false);
                        }
                        if (imageInfo.isAnim()) {
                            imageContent.setCallback(LynxImageManager.this);
                        }
                    }
                    if (LynxImageManager.this.mDeferInvalidation) {
                        LynxImageManager lynxImageManager = LynxImageManager.this;
                        lynxImageManager.releaseImage(lynxImageManager.mPreImageRequestInfo);
                        LynxImageManager lynxImageManager2 = LynxImageManager.this;
                        lynxImageManager2.releaseDrawable(lynxImageManager2.mImageDrawable);
                        LynxImageManager.this.mPreImageRequestInfo = null;
                        if (LynxImageManager.this.mImageDrawable != null) {
                            LynxImageManager.this.mImageDrawable.releaseImageSource();
                            LynxImageManager.this.mImageDrawable = null;
                        }
                    }
                    LynxImageManager.this.mImageDrawable = new LynxScaleTypeDrawable(imageContent, LynxImageManager.this.mMode);
                    if (!TextUtils.isEmpty(LynxImageManager.this.mCapInsets)) {
                        LynxImageManager.this.mImageDrawable.setCapInsets(LynxImageManager.this.mCapInsets, LynxImageManager.this.mCapInsetsScale);
                    }
                    LynxImageManager.this.mImageWidth = imageInfo.getWidth();
                    LynxImageManager.this.mImageHeight = imageInfo.getHeight();
                    ILynxViewRuntimeCacheManager runtimeCacheManager = LynxImageManager.this.mContext.getRuntimeCacheManager();
                    if (runtimeCacheManager != null) {
                        runtimeCacheManager.setBitmapSizeCache(imageRequestInfo.getUrl(), LynxImageManager.this.mImageWidth, LynxImageManager.this.mImageHeight);
                    }
                    LynxImageManager.this.justSizeIfNeeded();
                    if (LynxImageManager.this.mColorFilter != null) {
                        LynxImageManager.this.mImageDrawable.setColorFilter(LynxImageManager.this.mColorFilter);
                    }
                    LynxImageManager lynxImageManager3 = LynxImageManager.this;
                    lynxImageManager3.configureBounds(lynxImageManager3.mImageDrawable);
                    LynxImageManager lynxImageManager4 = LynxImageManager.this;
                    lynxImageManager4.onImageLoadSuccess(lynxImageManager4.mImageWidth, LynxImageManager.this.mImageHeight);
                    LynxImageManager.this.invalidate();
                }
            }

            @Override // com.lynx.tasm.image.model.ImageLoadListener
            public void onFailure(int i, Throwable th) {
                LLog.e(LynxImageManager.TAG, "onFailed src:" + LynxImageManager.this.mSrc + ",with reason:" + th.getMessage());
                int checkImageExceptionCategory = ImageErrorCodeUtils.checkImageExceptionCategory(i);
                String message = th.getMessage();
                if (TextUtils.isEmpty(message) && (message = Log.getStackTraceString(th)) != null && message.length() > 200) {
                    message = message.substring(0, 200);
                }
                LynxError lynxError = new LynxError(checkImageExceptionCategory, "Android LynxImageManager loading image failed", "", "error");
                lynxError.setRootCause(message);
                LynxImageManager.this.onImageLoadError(lynxError, checkImageExceptionCategory, i);
            }

            @Override // com.lynx.tasm.image.model.ImageLoadListener
            public void onImageMonitorInfo(JSONObject jSONObject) {
                if (LynxImageManager.this.mEnableExtraLoadInfo) {
                    LynxImageManager.this.sendExtraLoadEvent(jSONObject);
                }
            }
        };
        this.mSrcLoadListenerInner = imageLoadListener;
        this.mSrcLoadListener = new ImageRequestHandle(imageLoadListener);
        this.mPlaceHolderListener = new ImageLoadListener() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.2
            @Override // com.lynx.tasm.image.model.ImageLoadListener
            public void onFailure(int i, Throwable th) {
            }

            @Override // com.lynx.tasm.image.model.ImageLoadListener
            public void onImageMonitorInfo(JSONObject jSONObject) {
            }

            @Override // com.lynx.tasm.image.model.ImageLoadListener
            public void onRequestSubmit(ImageRequestInfo imageRequestInfo) {
            }

            @Override // com.lynx.tasm.image.model.ImageLoadListener
            public void onSuccess(ImageContent imageContent, ImageRequestInfo imageRequestInfo, ImageInfo imageInfo) {
                if (TextUtils.equals(imageRequestInfo.getUrl(), LynxImageManager.this.mCurPlaceholderRequest != null ? LynxImageManager.this.mCurPlaceholderRequest.getUrl() : null)) {
                    LynxImageManager.this.mPlaceholderDrawable = new LynxScaleTypeDrawable(imageContent, LynxImageManager.this.mMode);
                    LynxImageManager lynxImageManager = LynxImageManager.this;
                    lynxImageManager.configureBounds(lynxImageManager.mPlaceholderDrawable);
                    LynxImageManager.this.invalidate();
                }
            }
        };
        this.mAnimationListener = new AnimationListener() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.3
            @Override // com.lynx.tasm.image.model.AnimationListener
            public void onAnimationStart(Drawable drawable) {
                if (LynxImageManager.this.mEnableStartPlayEvent) {
                    LynxImageManager.this.sendCustomEvent("startplay");
                }
            }

            @Override // com.lynx.tasm.image.model.AnimationListener
            public void onAnimationFinalLoop(Drawable drawable) {
                if (LynxImageManager.this.mEnableAllLoopEvent) {
                    LynxImageManager.this.sendCustomEvent("finalloopcomplete");
                }
            }

            @Override // com.lynx.tasm.image.model.AnimationListener
            public void onAnimationCurrentLoop(Drawable drawable) {
                if (LynxImageManager.this.mEnableCurrentLoopEvent) {
                    LynxImageManager.this.sendCustomEvent("currentloopcomplete");
                }
            }
        };
        this.mContext = lynxContext;
        this.mImageLoader = new LynxImageLoader(lynxContext.getImageFetcher());
        this.mMediaResourceFetcher = new LynxImageMediaFetcherProxy(lynxContext);
        this.mAsyncRedirect = (lynxContext.getMediaResourceFetcher() == null && lynxContext.getAsyncImageInterceptor() == null) ? false : true;
        this.mEnableCheckLocalImage = lynxContext.isEnableCheckLocalImage();
    }

    public void setSkipRedirection(boolean z) {
        this.mSkipRedirection = z;
    }

    public void setDeferInvalidation(boolean z) {
        this.mDeferInvalidation = z;
    }

    public void setDisableDefaultPlaceholder(boolean z) {
        this.mDisableDefaultPlaceholder = z;
    }

    public void setEnableResourceHint(boolean z) {
        this.mEnableResourceHint = z;
    }

    public void setEnableCustomGifDecoder(boolean z) {
        this.mEnableCustomGifDecoder = z;
    }

    public void setSrc(String str) {
        if (TextUtils.equals(str, this.mSrc)) {
            return;
        }
        this.mSrc = str;
        this.dirtyFlags |= 2;
    }

    public void setPlaceholder(String str) {
        if (TextUtils.equals(str, this.mPlaceholder)) {
            return;
        }
        this.mPlaceholder = str;
        this.dirtyFlags |= 4;
    }

    public void setCapInsets(String str) {
        if (TextUtils.equals(str, this.mCapInsets)) {
            return;
        }
        this.mCapInsets = str;
        this.dirtyFlags |= 8;
    }

    public void setCapInsetsBackUp(String str) {
        if (TextUtils.equals(str, this.mCapInsets)) {
            return;
        }
        this.mCapInsets = str;
        this.dirtyFlags |= 8;
    }

    public void setMode(String str) {
        ScalingUtils.ScaleType mode = getMode(str);
        if (Objects.equals(mode, this.mMode)) {
            return;
        }
        this.mMode = mode;
        this.dirtyFlags |= 16;
    }

    public void setBlurRadius(String str) {
        if (TextUtils.equals(str, this.mBlurRadius)) {
            return;
        }
        this.mBlurRadius = str;
        this.dirtyFlags |= 32;
    }

    public void setAutoSize(boolean z) {
        if (z != this.mAutoSize) {
            this.mAutoSize = z;
            this.dirtyFlags |= 64;
        }
    }

    public void setLoopCount(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.mLoopCount = i;
    }

    public void setImageConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
    }

    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
    }

    public void setTintColor(String str) {
        if (TextUtils.equals(str, this.mTintColor)) {
            return;
        }
        this.mTintColor = str;
        if (ColorUtils.isValid(str)) {
            this.mColorFilter = new PorterDuffColorFilter(ColorUtils.parse(this.mTintColor), PorterDuff.Mode.SRC_IN);
        }
        this.dirtyFlags |= 128;
    }

    public void setExtraLoadInfo(boolean z) {
        this.mEnableExtraLoadInfo = z;
    }

    public void setAsyncRequest(boolean z) {
        if (this.mEnableAsyncRequest != z) {
            this.mEnableAsyncRequest = z;
            this.dirtyFlags |= 256;
        }
    }

    public void setPreFetchWidth(String str) {
        this.mPreFetchWidth = (int) UnitUtils.toPxWithDisplayMetrics(str, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics());
    }

    public void setCapInsetsScale(String str) {
        if (TextUtils.equals(str, this.mCapInsetsScale)) {
            return;
        }
        this.mCapInsetsScale = str;
        this.dirtyFlags |= 8;
    }

    public void setPreFetchHeight(String str) {
        this.mPreFetchHeight = (int) UnitUtils.toPxWithDisplayMetrics(str, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics());
    }

    public void setLocalCache(Dynamic dynamic) {
        ImageUtils.LocalCacheState parseLocalCache = ImageUtils.parseLocalCache(dynamic);
        this.mUseLocalCache = parseLocalCache.mUseLocalCache;
        this.mAwaitLocalCache = parseLocalCache.mAwaitLocalCache;
    }

    public void setDisableDefaultResize(boolean z) {
        this.mDisableDefaultResize = z;
    }

    public void setLynxBaseUI(LynxBaseUI lynxBaseUI) {
        this.mUI = lynxBaseUI;
    }

    public void setViewInfo(ViewInfo viewInfo) {
        this.mViewInfo = viewInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsPixelated(boolean z) {
        this.mIsPixelated = z;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0023. Please report as an issue. */
    public void updatePropertiesInterval(ReadableMap readableMap) {
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.beginSection("LynxImageManager.updatePropertiesInterval");
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            nextKey.hashCode();
            char c = 65535;
            switch (nextKey.hashCode()) {
                case -1937917490:
                    if (nextKey.equals(PropsConstants.CAP_INSETS_SCALE)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1492006372:
                    if (nextKey.equals(PropsConstants.ENABLE_RESOURCE_HINT)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1338903714:
                    if (nextKey.equals(PropsConstants.SKIP_REDIRECTION)) {
                        c = 2;
                        break;
                    }
                    break;
                case -1138223116:
                    if (nextKey.equals(PropsConstants.IAMGE_CONFIG)) {
                        c = 3;
                        break;
                    }
                    break;
                case -629825370:
                    if (nextKey.equals(PropsConstants.LOOP_COUNT)) {
                        c = 4;
                        break;
                    }
                    break;
                case -320982203:
                    if (nextKey.equals(PropsConstants.DISABLE_DEFAULT_RESIZE)) {
                        c = 5;
                        break;
                    }
                    break;
                case -256430480:
                    if (nextKey.equals(PropsConstants.PRE_FETCH_WIDTH)) {
                        c = 6;
                        break;
                    }
                    break;
                case 114148:
                    if (nextKey.equals(PropsConstants.SRC)) {
                        c = 7;
                        break;
                    }
                    break;
                case 3357091:
                    if (nextKey.equals(PropsConstants.MODE)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 108305470:
                    if (nextKey.equals(PropsConstants.ENABLE_IMAGE_ASYNC_REQUEST)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 207594941:
                    if (nextKey.equals(PropsConstants.PRE_FETCH_HEIGHT)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 313009824:
                    if (nextKey.equals(PropsConstants.LOCAL_CACHE)) {
                        c = 11;
                        break;
                    }
                    break;
                case 516005201:
                    if (nextKey.equals(PropsConstants.CAP_INSETS_BACKUP)) {
                        c = '\f';
                        break;
                    }
                    break;
                case 598246771:
                    if (nextKey.equals(PropsConstants.PLACEHOLDER)) {
                        c = '\r';
                        break;
                    }
                    break;
                case 681292984:
                    if (nextKey.equals(PropsConstants.BLUR_RADIUS)) {
                        c = 14;
                        break;
                    }
                    break;
                case 1198809474:
                    if (nextKey.equals(PropsConstants.DISABLE_DEFAULT_PLACEHOLDER)) {
                        c = 15;
                        break;
                    }
                    break;
                case 1439562083:
                    if (nextKey.equals(PropsConstants.AUTO_PLAY)) {
                        c = 16;
                        break;
                    }
                    break;
                case 1515751784:
                    if (nextKey.equals(PropsConstants.CAP_INSETS)) {
                        c = 17;
                        break;
                    }
                    break;
                case 1615092063:
                    if (nextKey.equals(PropsConstants.AUTO_SIZE)) {
                        c = 18;
                        break;
                    }
                    break;
                case 1739487650:
                    if (nextKey.equals(PropsConstants.DEFER_SRC_INVALIDATION)) {
                        c = 19;
                        break;
                    }
                    break;
                case 1860054545:
                    if (nextKey.equals(PropsConstants.TINT_COLOR)) {
                        c = 20;
                        break;
                    }
                    break;
                case 1998893929:
                    if (nextKey.equals(PropsConstants.ENABLE_CUSTOM_GIF_DECODER)) {
                        c = 21;
                        break;
                    }
                    break;
                case 2141225912:
                    if (nextKey.equals(PropsConstants.EXTRA_LOAD_INFO)) {
                        c = 22;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setCapInsetsScale(readableMap.getString(nextKey));
                    break;
                case 1:
                    setEnableResourceHint(readableMap.getBoolean(nextKey, false));
                    break;
                case 2:
                    setSkipRedirection(readableMap.getBoolean(nextKey, false));
                    break;
                case 3:
                    setImageConfig(readableMap.getString(nextKey));
                    break;
                case 4:
                    setLoopCount(readableMap.getInt(nextKey, 0));
                    break;
                case 5:
                    setDisableDefaultResize(readableMap.getBoolean(nextKey, false));
                    break;
                case 6:
                    setPreFetchWidth(readableMap.getString(nextKey));
                    break;
                case 7:
                    setSrc(readableMap.getString(nextKey));
                    break;
                case '\b':
                    setMode(readableMap.getString(nextKey));
                    break;
                case '\t':
                    setAsyncRequest(readableMap.getBoolean(nextKey, false));
                    break;
                case '\n':
                    setPreFetchHeight(readableMap.getString(nextKey));
                    break;
                case 11:
                    setLocalCache(readableMap.getDynamic(nextKey));
                    break;
                case '\f':
                    setCapInsetsBackUp(readableMap.getString(nextKey));
                    break;
                case '\r':
                    setPlaceholder(readableMap.getString(nextKey));
                    break;
                case 14:
                    setBlurRadius(readableMap.getString(nextKey));
                    break;
                case 15:
                    setDisableDefaultPlaceholder(readableMap.getBoolean(nextKey, false));
                    break;
                case 16:
                    setAutoPlay(readableMap.getBoolean(nextKey, true));
                    break;
                case 17:
                    setCapInsets(readableMap.getString(nextKey));
                    break;
                case 18:
                    setAutoSize(readableMap.getBoolean(nextKey, false));
                    break;
                case 19:
                    setDeferInvalidation(readableMap.getBoolean(nextKey, false));
                    break;
                case 20:
                    setTintColor(readableMap.getString(nextKey));
                    break;
                case 21:
                    setEnableCustomGifDecoder(readableMap.getBoolean(nextKey, false));
                    break;
                case 22:
                    setExtraLoadInfo(readableMap.getBoolean(nextKey, false));
                    break;
            }
        }
        updateRedirectCheckResult();
        TraceEvent.endSection("LynxImageManager.updatePropertiesInterval");
    }

    public void pauseAnimation(ReadableMap readableMap, Callback callback) {
        LynxScaleTypeDrawable lynxScaleTypeDrawable = this.mImageDrawable;
        if (lynxScaleTypeDrawable == null || !this.mImageLoader.pauseAnimation(lynxScaleTypeDrawable.getAnimDrawable())) {
            callback.invoke(new Object[]{4, "Not support pause yet"});
        } else {
            callback.invoke(new Object[]{0, "Animation paused."});
        }
    }

    public void resumeAnimation(ReadableMap readableMap, Callback callback) {
        LynxScaleTypeDrawable lynxScaleTypeDrawable = this.mImageDrawable;
        if (lynxScaleTypeDrawable == null || !this.mImageLoader.resumeAnimation(lynxScaleTypeDrawable.getAnimDrawable())) {
            callback.invoke(new Object[]{4, "Not support resume yet"});
        } else {
            callback.invoke(new Object[]{0, "Animation resumed."});
        }
    }

    public void stopAnimation(ReadableMap readableMap, Callback callback) {
        LynxScaleTypeDrawable lynxScaleTypeDrawable = this.mImageDrawable;
        if (lynxScaleTypeDrawable == null || !this.mImageLoader.stopAnimation(lynxScaleTypeDrawable.getAnimDrawable())) {
            callback.invoke(new Object[]{4, "Not support stop yet"});
        } else {
            callback.invoke(new Object[]{0, "Animation stopped."});
        }
    }

    public void startAnimate(ReadableMap readableMap, Callback callback) {
        LynxScaleTypeDrawable lynxScaleTypeDrawable = this.mImageDrawable;
        if (lynxScaleTypeDrawable == null || !this.mImageLoader.startAnimation(lynxScaleTypeDrawable.getAnimDrawable())) {
            callback.invoke(new Object[]{4, "Not support start yet"});
        } else {
            callback.invoke(new Object[]{0, "Animation started."});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateRedirectCheckResult() {
        final LynxResourceRequest lynxResourceRequest;
        if (this.mSkipRedirection || !this.mEnableCheckLocalImage) {
            return;
        }
        boolean isDirty = isDirty(2L);
        boolean isDirty2 = isDirty(4L);
        final LynxResourceRequest lynxResourceRequest2 = null;
        if (isDirty) {
            if (this.mImageLoader.canParseUrl(this.mSrc)) {
                this.mSrcRedirectCheckResult = OptionalBool.FALSE;
            } else {
                this.mSrcRedirectCheckResult = this.mMediaResourceFetcher.isLocalResource(this.mSrc);
            }
            if (this.mSrcRedirectCheckResult != OptionalBool.FALSE) {
                lynxResourceRequest = new LynxResourceRequest(this.mSrc, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage);
                if (isDirty2) {
                    if (this.mImageLoader.canParseUrl(this.mPlaceholder)) {
                        this.mPlaceHolderRedirectCheckResult = OptionalBool.FALSE;
                    } else {
                        this.mPlaceHolderRedirectCheckResult = this.mMediaResourceFetcher.isLocalResource(this.mPlaceholder);
                    }
                    if (this.mPlaceHolderRedirectCheckResult != OptionalBool.FALSE) {
                        lynxResourceRequest2 = new LynxResourceRequest(this.mPlaceholder, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage);
                    }
                }
                if (Thread.currentThread() == Looper.getMainLooper().getThread() || !this.mAsyncRedirect) {
                    if (lynxResourceRequest != null) {
                        this.mSrc = this.mMediaResourceFetcher.shouldRedirectUrl(lynxResourceRequest);
                    }
                    if (lynxResourceRequest2 == null) {
                        this.mPlaceholder = this.mMediaResourceFetcher.shouldRedirectUrl(lynxResourceRequest2);
                        return;
                    }
                    return;
                }
                if (lynxResourceRequest == null && lynxResourceRequest2 == null) {
                    return;
                }
                if (lynxResourceRequest != null) {
                    this.dirtyFlags &= -3;
                }
                if (lynxResourceRequest2 != null) {
                    this.dirtyFlags &= -5;
                }
                LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LynxImageManager.this.m3x97c15b49(lynxResourceRequest2, lynxResourceRequest);
                    }
                });
                return;
            }
        }
        lynxResourceRequest = null;
        if (isDirty2) {
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        }
        if (lynxResourceRequest != null) {
        }
        if (lynxResourceRequest2 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateRedirectCheckResult$1$com-lynx-tasm-behavior-ui-image-LynxImageManager */
    public /* synthetic */ void m3x97c15b49(LynxResourceRequest lynxResourceRequest, LynxResourceRequest lynxResourceRequest2) {
        final boolean z;
        final boolean z2 = true;
        if (lynxResourceRequest != null) {
            this.mPlaceholder = this.mMediaResourceFetcher.shouldRedirectUrl(lynxResourceRequest);
            z = true;
        } else {
            z = false;
        }
        if (lynxResourceRequest2 != null) {
            this.mSrc = this.mMediaResourceFetcher.shouldRedirectUrl(lynxResourceRequest2);
        } else {
            z2 = false;
        }
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LynxImageManager.this.m4127lambda$null$0$comlynxtasmbehavioruiimageLynxImageManager(z2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$null$0$com-lynx-tasm-behavior-ui-image-LynxImageManager, reason: not valid java name */
    public /* synthetic */ void m4127lambda$null$0$comlynxtasmbehavioruiimageLynxImageManager(boolean z, boolean z2) {
        if (z) {
            this.dirtyFlags |= 2;
        }
        if (z2) {
            this.dirtyFlags |= 4;
        }
        onNodeReady();
    }

    private void updateImageSource() {
        final int i;
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.beginSection("LynxImageManager.updateImageSource");
        }
        final int i2 = this.mViewWidth;
        boolean z = true;
        if ((i2 <= 0 || (i = this.mViewHeight) <= 0) && ((i2 = this.mPreFetchWidth) <= 0 || (i = this.mPreFetchHeight) <= 0)) {
            i = 0;
            if (this.mAutoSize) {
                i2 = 0;
            } else {
                i2 = 0;
                z = false;
            }
        }
        if (z) {
            LynxThreadPool.postUIOperationTask(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.4
                @Override // java.lang.Runnable
                public void run() {
                    LynxImageManager.this.tryFetchImageFromService(i2, i);
                }
            });
        }
        TraceEvent.endSection("LynxImageManager.updateImageSource");
    }

    private void updatePlaceholderSource() {
        int i;
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.beginSection("LynxImageManager.updatePlaceholderSource");
        }
        int i2 = this.mViewWidth;
        boolean z = true;
        if ((i2 <= 0 || (i = this.mViewHeight) <= 0) && ((i2 = this.mPreFetchWidth) <= 0 || (i = this.mPreFetchHeight) <= 0)) {
            i2 = 0;
            z = false;
            i = 0;
        }
        if (z) {
            tryFetchPlaceholderFromService(i2, i);
        }
        TraceEvent.endSection("LynxImageManager.updatePlaceholderSource");
    }

    public void onNodeReady() {
        updateNodeProps();
        invalidate();
    }

    public void updateNodeProps() {
        LynxScaleTypeDrawable lynxScaleTypeDrawable;
        LynxScaleTypeDrawable lynxScaleTypeDrawable2;
        if (isDirty(2048L) && (this.mDisableDefaultResize || this.mAutoSize || this.mEnableResourceHint)) {
            this.dirtyFlags &= -2049;
        }
        if (isDirty(16L) && this.mImageDrawable != null) {
            this.mImageDrawable = new LynxScaleTypeDrawable(this.mImageDrawable.getContent(), this.mMode);
        }
        if (isDirty(8L) && (lynxScaleTypeDrawable2 = this.mImageDrawable) != null) {
            lynxScaleTypeDrawable2.setCapInsets(this.mCapInsets, this.mCapInsetsScale);
        }
        if (isDirty(128L) && (lynxScaleTypeDrawable = this.mImageDrawable) != null) {
            lynxScaleTypeDrawable.setColorFilter(this.mColorFilter);
        }
        if (isDirty(4L)) {
            releaseImage(this.mCurPlaceholderRequest);
            releaseDrawable(this.mPlaceholderDrawable);
            LynxScaleTypeDrawable lynxScaleTypeDrawable3 = this.mPlaceholderDrawable;
            if (lynxScaleTypeDrawable3 != null) {
                lynxScaleTypeDrawable3.releaseImageSource();
                this.mPlaceholderDrawable = null;
            }
            this.mCurPlaceholderRequest = null;
            updatePlaceholderSource();
        }
        if (isDirty(2L) || isDirty(32L) || isDirty(2048L)) {
            if (!this.mDeferInvalidation) {
                releaseImage(this.mCurImageRequest);
                releaseDrawable(this.mImageDrawable);
                LynxScaleTypeDrawable lynxScaleTypeDrawable4 = this.mImageDrawable;
                if (lynxScaleTypeDrawable4 != null) {
                    lynxScaleTypeDrawable4.releaseImageSource();
                    this.mImageDrawable = null;
                }
                this.mCurImageRequest = null;
                this.mImageWidth = 0;
                this.mImageHeight = 0;
            } else {
                this.mPreImageRequestInfo = this.mCurImageRequest;
            }
            updateImageSource();
        }
        if (isDirty(512L) || isDirty(1024L) || isDirty(4096L)) {
            configureBounds(this.mImageDrawable);
            configureBounds(this.mPlaceholderDrawable);
            float[] fArr = this.mBorderRadius;
            if (fArr != null && fArr.length > 0) {
                if (this.mInnerClipPathForBorderRadius == null) {
                    this.mInnerClipPathForBorderRadius = new BackgroundDrawable.RoundRectPath();
                }
                this.mInnerClipPathForBorderRadius.updateValue(new Rect(this.mPaddingLeft, this.mPaddingTop, this.mViewWidth - this.mPaddingRight, this.mViewHeight - this.mPaddingBottom), this.mBorderRadius, this.mBorderWidthRect, 1.0f, false);
            }
        }
        if (this.mNeedRetryAutoSize) {
            this.mNeedRetryAutoSize = false;
            if (this.mAutoSize) {
                justSizeIfNeeded();
            }
        }
        this.dirtyFlags = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseImage(ImageRequestInfo imageRequestInfo) {
        if (imageRequestInfo != null) {
            this.mImageLoader.releaseImage(imageRequestInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mImageLoader.releaseAnimDrawable(drawable.getCurrent());
        }
    }

    private ImageRequestInfo createImageRequest(int i, int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ImageRequestInfoBuilder imageRequestInfoBuilder = new ImageRequestInfoBuilder();
        imageRequestInfoBuilder.setUrl(str).setResizeWidth(i).setResizeHeight(i2).setLoopCount(this.mLoopCount).setCallerContext(this.mContext.getFrescoCallerContext()).setEnableAnimationAutoPlay(this.mAutoPlay).setEnableDownSampling((this.mDisableDefaultResize || this.mAutoSize) ? false : true).setEnableAsyncRequest(this.mEnableAsyncRequest).setEnableGifLiteDecoder(this.mEnableCustomGifDecoder).setEnableResourceHint(this.mEnableResourceHint);
        Bitmap.Config config = this.mBitmapConfig;
        if (config != null) {
            imageRequestInfoBuilder.setBitmapConfig(config);
        }
        if (this.mContext.getEnableImageSmallDiskCache()) {
            imageRequestInfoBuilder.setDiskCacheChoice(1);
        }
        if (this.mContext.getImageCustomParam() != null) {
            imageRequestInfoBuilder.setCustomParam(this.mContext.getImageCustomParam());
        }
        if (!TextUtils.isEmpty(this.mBlurRadius)) {
            float pxWithDisplayMetrics = UnitUtils.toPxWithDisplayMetrics(this.mBlurRadius, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics());
            if (pxWithDisplayMetrics > 0.0f) {
                ImageBlurPostProcessor imageBlurPostProcessor = new ImageBlurPostProcessor((int) pxWithDisplayMetrics);
                ArrayList arrayList = new ArrayList();
                arrayList.add(imageBlurPostProcessor);
                imageRequestInfoBuilder.setBitmapPostProcessor(arrayList);
            }
        }
        return imageRequestInfoBuilder.build();
    }

    public void tryFetchImageFromService(int i, int i2) {
        AnimationListener animationListener = (this.mEnableAllLoopEvent || this.mEnableStartPlayEvent || this.mEnableCurrentLoopEvent) ? this.mAnimationListener : null;
        ImageRequestInfo createImageRequest = createImageRequest(i, i2, this.mSrc);
        if (createImageRequest != null) {
            this.mCurImageRequest = createImageRequest;
            this.mImageLoader.fetchImage(createImageRequest, this.mSrcLoadListener, animationListener, this.mContext);
        }
    }

    public void tryFetchPlaceholderFromService(int i, int i2) {
        ImageRequestInfo createImageRequest;
        if (this.mImageDrawable == null && (createImageRequest = createImageRequest(i, i2, this.mPlaceholder)) != null) {
            this.mCurPlaceholderRequest = createImageRequest;
            this.mImageLoader.fetchImage(createImageRequest, this.mPlaceHolderListener, null, this.mContext);
        }
    }

    public void destroy() {
        releaseAllImage();
    }

    private void releaseAllImage() {
        releaseImage(this.mCurImageRequest);
        releaseImage(this.mCurPlaceholderRequest);
        releaseDrawable(this.mImageDrawable);
        releaseDrawable(this.mPlaceholderDrawable);
        this.mCurImageRequest = null;
        this.mCurPlaceholderRequest = null;
        LynxScaleTypeDrawable lynxScaleTypeDrawable = this.mImageDrawable;
        if (lynxScaleTypeDrawable != null) {
            lynxScaleTypeDrawable.releaseImageSource();
            this.mImageDrawable = null;
        }
        LynxScaleTypeDrawable lynxScaleTypeDrawable2 = this.mPlaceholderDrawable;
        if (lynxScaleTypeDrawable2 != null) {
            lynxScaleTypeDrawable2.releaseImageSource();
            this.mPlaceholderDrawable = null;
        }
    }

    public void tryHandleResult() {
        ImageRequestHandle imageRequestHandle = this.mSrcLoadListener;
        if (imageRequestHandle == null) {
            return;
        }
        imageRequestHandle.tryHandleResult();
    }

    public void onDraw(Canvas canvas) {
        this.mSrcLoadListener.tryHandleResult();
        canvas.save();
        BackgroundDrawable.RoundRectPath roundRectPath = this.mInnerClipPathForBorderRadius;
        if (roundRectPath != null && roundRectPath.path != null) {
            canvas.clipPath(this.mInnerClipPathForBorderRadius.path);
        }
        LynxScaleTypeDrawable lynxScaleTypeDrawable = this.mPlaceholderDrawable;
        if (lynxScaleTypeDrawable != null) {
            lynxScaleTypeDrawable.draw(canvas);
        }
        LynxScaleTypeDrawable lynxScaleTypeDrawable2 = this.mImageDrawable;
        if (lynxScaleTypeDrawable2 != null) {
            lynxScaleTypeDrawable2.draw(canvas);
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureBounds(Drawable drawable) {
        Rect rect = new Rect(0, 0, this.mViewWidth, this.mViewHeight);
        this.mDrawableBounds = rect;
        rect.left = (int) (rect.left + this.mBorderLeftWidth + this.mPaddingLeft);
        this.mDrawableBounds.top = (int) (r0.top + this.mBorderTopWidth + this.mPaddingTop);
        this.mDrawableBounds.right = (int) ((r0.right - this.mBorderRightWidth) - this.mPaddingRight);
        this.mDrawableBounds.bottom = (int) ((r0.bottom - this.mBorderBottomWidth) - this.mPaddingBottom);
        if (drawable != null) {
            drawable.setBounds(this.mDrawableBounds);
        }
    }

    public void invalidate() {
        LynxBaseUI lynxBaseUI = this.mUI;
        if (lynxBaseUI != null) {
            lynxBaseUI.invalidateMeaningfulPaintingArea();
        }
        ViewInfo viewInfo = this.mViewInfo;
        if (viewInfo != null) {
            viewInfo.invalidateMeaningfulPaintingArea();
        }
        if (UIThreadUtils.isOnUiThread()) {
            LynxBaseUI lynxBaseUI2 = this.mUI;
            if (lynxBaseUI2 != null) {
                lynxBaseUI2.invalidate();
            }
            ViewInfo viewInfo2 = this.mViewInfo;
            if (viewInfo2 != null) {
                viewInfo2.invalidate();
            }
        }
    }

    public void setEvents(Map<String, EventsListener> map) {
        if (map == null) {
            return;
        }
        this.mEnableStartPlayEvent = false;
        this.mEnableCurrentLoopEvent = false;
        this.mEnableAllLoopEvent = false;
        this.mEnableOnLoad = false;
        this.mEnableOnError = false;
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
        if (map.containsKey("error")) {
            this.mEnableOnError = true;
        }
    }

    public void onLayoutUpdated(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i > 0 || i2 > 0) {
            int i7 = this.mViewWidth;
            if (i != i7 || i2 != this.mViewHeight) {
                if (i > i7 || i2 > this.mViewHeight) {
                    this.dirtyFlags |= 2048;
                }
                this.mViewWidth = i;
                this.mViewHeight = i2;
                this.dirtyFlags |= 512;
            }
            if (this.mPaddingTop == i5 && this.mPaddingRight == i4 && this.mPaddingBottom == i6 && this.mPaddingLeft == i3) {
                return;
            }
            this.mPaddingTop = i5;
            this.mPaddingRight = i4;
            this.mPaddingLeft = i3;
            this.mPaddingBottom = i6;
            this.dirtyFlags |= 512;
        }
    }

    ScalingUtils.ScaleType getMode(String str) {
        if ("aspectFit".equals(str)) {
            return ScalingUtils.ScaleType.FIT_CENTER;
        }
        if ("aspectFill".equals(str)) {
            return ScalingUtils.ScaleType.CENTER_CROP;
        }
        if ("center".equals(str)) {
            return ScalingUtils.ScaleType.CENTER;
        }
        return ScalingUtils.ScaleType.FIT_XY;
    }

    private boolean isDirty(long j) {
        return (j & this.dirtyFlags) != 0;
    }

    public void setImageConfig(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            this.mBitmapConfig = null;
        } else if (str.equalsIgnoreCase("RGB_565")) {
            this.mBitmapConfig = Bitmap.Config.RGB_565;
        } else if (str.equalsIgnoreCase("ARGB_8888")) {
            this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.LynxImageManager.5
            @Override // java.lang.Runnable
            public void run() {
                LynxImageManager.this.invalidate();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        UIThreadUtils.runOnUiThreadAtTime(runnable, drawable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        UIThreadUtils.removeCallbacks(runnable, drawable);
    }

    public void setBorderWidth(RectF rectF) {
        this.mBorderWidthRect = rectF;
        float f = rectF.top;
        float f2 = this.mBorderWidthRect.bottom;
        float f3 = this.mBorderWidthRect.left;
        float f4 = this.mBorderWidthRect.right;
        if (this.mBorderTopWidth != f) {
            this.mBorderTopWidth = f;
            this.dirtyFlags |= 1024;
        }
        if (this.mBorderLeftWidth != f3) {
            this.mBorderLeftWidth = f3;
            this.dirtyFlags |= 1024;
        }
        if (this.mBorderRightWidth != f4) {
            this.mBorderRightWidth = f4;
            this.dirtyFlags |= 1024;
        }
        if (this.mBorderBottomWidth != f2) {
            this.mBorderBottomWidth = f2;
            this.dirtyFlags |= 1024;
        }
    }

    public void justSizeIfNeeded() {
        LynxBaseUI lynxBaseUI;
        if (this.mImageWidth == 0 || this.mImageHeight == 0 || !this.mAutoSize || (lynxBaseUI = this.mUI) == null) {
            return;
        }
        if (this.mAutoSizeShadowNode == null) {
            this.mAutoSizeShadowNode = lynxBaseUI.getLynxContext().findShadowNodeBySign(this.mUI.getSign());
        }
        ShadowNode shadowNode = this.mAutoSizeShadowNode;
        if (!(shadowNode instanceof AutoSizeImage)) {
            this.mNeedRetryAutoSize = true;
        } else {
            ((AutoSizeImage) shadowNode).justSizeIfNeeded(this.mAutoSize, this.mImageWidth, this.mImageHeight, this.mUI.getWidth(), this.mUI.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCustomEvent(String str) {
        if (this.mContext == null || this.mUI == null) {
            return;
        }
        this.mContext.getEventEmitter().sendCustomEvent(new LynxDetailEvent(this.mUI.getSign(), str));
    }

    protected void onImageLoadSuccess(int i, int i2) {
        if (this.mEnableOnLoad) {
            sendLoadEvent(i, i2);
        }
    }

    protected void onImageLoadError(LynxError lynxError, int i, int i2) {
        handlerFailure(lynxError, i, i2);
    }

    private void sendLoadEvent(int i, int i2) {
        if (this.mContext == null || this.mUI == null || this.mEnableExtraLoadInfo) {
            return;
        }
        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(this.mUI.getSign(), "load");
        lynxDetailEvent.addDetail("height", Integer.valueOf(i2));
        lynxDetailEvent.addDetail("width", Integer.valueOf(i));
        this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendExtraLoadEvent(JSONObject jSONObject) {
        Object obj;
        if (this.mContext == null || this.mUI == null || !this.mEnableExtraLoadInfo || jSONObject == null) {
            return;
        }
        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(this.mUI.getSign(), "load");
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                obj = jSONObject.get(next);
            } catch (JSONException e) {
                LLog.e(TAG, e.getMessage());
                obj = null;
            }
            lynxDetailEvent.addDetail(next, obj);
        }
    }

    private void handlerFailure(LynxError lynxError, int i, int i2) {
        LynxBaseUI lynxBaseUI;
        if (this.mContext == null || (lynxBaseUI = this.mUI) == null) {
            return;
        }
        lynxError.addCustomInfo("node_index", Integer.toString(lynxBaseUI.getNodeIndex()));
        if (this.mEnableOnError) {
            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(this.mUI.getSign(), "error");
            lynxDetailEvent.addDetail("errMsg", lynxError.getSummaryMessage() + ": " + lynxError.getRootCause());
            lynxDetailEvent.addDetail(ImageErrorCodeUtils.LYNX_IMAGE_CATEGORIZED_CODE_KEY, Integer.valueOf(i));
            lynxDetailEvent.addDetail("error_code", Integer.valueOf(i2));
            this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent);
        }
        lynxError.addCustomInfo("image_categorized_code", String.valueOf(i));
        this.mContext.reportResourceError(this.mSrc, LynxMemoryInfo.TYPE_IMAGE, lynxError);
    }

    public void setBorderRadius(float[] fArr, boolean z) {
        if (this.mBorderRadius == null || z) {
            this.dirtyFlags |= 4096;
        }
        this.mBorderRadius = fArr;
    }

    public Drawable getSrcImageDrawable() {
        return this.mImageDrawable;
    }

    public Boolean getHasContent() {
        return Boolean.valueOf((this.mImageDrawable == null && this.mPlaceholderDrawable == null) ? false : true);
    }
}
