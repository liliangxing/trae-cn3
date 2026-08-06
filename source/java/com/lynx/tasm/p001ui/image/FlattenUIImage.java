package com.lynx.tasm.p001ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.ScrollStateChangeListener;
import com.lynx.tasm.behavior.p000ui.UIParent;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.image.ImageUtils;
import com.lynx.tasm.p001ui.image.LynxImageManager;
import com.lynx.tasm.p001ui.image.fresco.BaseRoundedCornerPostprocessor;
import com.lynx.tasm.p001ui.image.helper.BigImageDrawingHelper;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.UnitUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FlattenUIImage extends LynxFlattenUI implements Drawable.Callback, LynxImageManager.DrawableReadyListener {
    public static final String EVENT_ERROR = "error";
    private BigImageDrawingHelper mBigImageHelper;
    String mCapInsets;
    String mCapInsetsScale;
    private boolean mDeferInvalidation;
    private boolean mEnableImageAsyncRedirectOnCreate;
    private boolean mFrescoNinePatch;
    private final Handler mHandler;
    private boolean mHasPendingPlaceholder;
    private boolean mHasPendingSource;
    private Drawable mImageDrawable;
    protected final LynxImageManager mLynxImageManager;
    private String mOriginPlaceholder;
    private boolean mPendingLoad;
    private float mPreFetchHeight;
    private float mPreFetchWidth;
    private CloseableReference<?> mRef;
    private boolean mRepeat;
    private ScalingUtils.ScaleType mScaleType;
    private int mScrollState;
    private ScrollStateChangeListener mScrollStateChangeListener;
    private int mShowCnt;
    private boolean mSkipRedirection;
    private String mSources;
    private boolean mSuspendable;
    private boolean mUseLocalCache;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class ImageHelperCallback implements BigImageDrawingHelper.ImageLoaderCallback {
        @Override // com.lynx.tasm.ui.image.helper.BigImageDrawingHelper.ImageLoaderCallback
        public void onImageLoadFailed(String str) {
        }

        ImageHelperCallback() {
        }

        @Override // com.lynx.tasm.ui.image.helper.BigImageDrawingHelper.ImageLoaderCallback
        public void onImageLoadSuccess(BigImageDrawingHelper.Tile tile) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                FlattenUIImage.this.postInvalidate();
            } else {
                FlattenUIImage.this.invalidate();
            }
        }
    }

    @Deprecated
    public FlattenUIImage(Context context) {
        this((LynxContext) context);
    }

    public FlattenUIImage(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public FlattenUIImage(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mImageDrawable = null;
        this.mPreFetchWidth = -1.0f;
        this.mPreFetchHeight = -1.0f;
        this.mUseLocalCache = false;
        this.mRef = null;
        this.mScaleType = ScalingUtils.ScaleType.FIT_XY;
        this.mCapInsets = null;
        this.mCapInsetsScale = null;
        this.mFrescoNinePatch = false;
        this.mSources = null;
        this.mOriginPlaceholder = null;
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
        this.mSkipRedirection = false;
        this.mDeferInvalidation = false;
        this.mScrollState = 0;
        LynxImageManager createImageManager = createImageManager(lynxContext);
        this.mLynxImageManager = createImageManager;
        createImageManager.setLynxBaseUI(this);
        createImageManager.mLoaderCallback = new ImageLoaderCallback() { // from class: com.lynx.tasm.ui.image.FlattenUIImage.1
            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageLoadSuccess(int i, int i2) {
                if (FlattenUIImage.this.mEvents == null || !FlattenUIImage.this.mEvents.containsKey("load")) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(FlattenUIImage.this.getSign(), "load");
                lynxDetailEvent.addDetail("height", Integer.valueOf(i2));
                lynxDetailEvent.addDetail("width", Integer.valueOf(i));
                FlattenUIImage.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageLoadFailed(LynxError lynxError, int i, int i2) {
                if (lynxError == null) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(FlattenUIImage.this.getSign(), "error");
                lynxDetailEvent.addDetail("errMsg", lynxError.getSummaryMessage() + ": " + lynxError.getRootCause());
                lynxDetailEvent.addDetail(ImageErrorCodeUtils.LYNX_IMAGE_CATEGORIZED_CODE_KEY, Integer.valueOf(i));
                lynxDetailEvent.addDetail("error_code", Integer.valueOf(i2));
                FlattenUIImage.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
                FlattenUIImage.this.getLynxContext().reportResourceError(FlattenUIImage.this.mSources, LynxMemoryInfo.TYPE_IMAGE, lynxError);
            }
        };
        createImageManager.setImageRedirectListener(new ImageAsyncRedirectListener() { // from class: com.lynx.tasm.ui.image.FlattenUIImage.2
            @Override // com.lynx.tasm.p001ui.image.ImageAsyncRedirectListener
            public void onAsyncRedirectFinish() {
                FlattenUIImage.this.maybeUpdateView();
            }
        });
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mShowCnt = 0;
        this.mRepeat = false;
        this.mEnableImageAsyncRedirectOnCreate = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
    }

    protected LynxImageManager createImageManager(Context context) {
        return new LynxImageManager(context, Fresco.newDraweeControllerBuilder(), null, getLynxContext().getFrescoCallerContext(), this, false);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.ui.image.FlattenUIImage.3
            @Override // java.lang.Runnable
            public void run() {
                FlattenUIImage.this.invalidate();
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

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public long getMemoryUsageBytes() {
        long memoryUsageBytes = super.getMemoryUsageBytes();
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        return lynxImageManager != null ? lynxImageManager.getBitmapMemorySizeBytes() + memoryUsageBytes : memoryUsageBytes;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public Map<String, String> getMemoryUsageDetail() {
        float memoryUsageBytes = (float) getMemoryUsageBytes();
        String str = this.mSources;
        if (memoryUsageBytes == 0.0f || str == null || str.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, String.valueOf(memoryUsageBytes));
        return hashMap;
    }

    private void onSourceSetted() {
        int i = this.mShowCnt + 1;
        this.mShowCnt = i;
        BigImageDrawingHelper bigImageDrawingHelper = this.mBigImageHelper;
        if (bigImageDrawingHelper != null) {
            bigImageDrawingHelper.setCnt(i);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(defaultBoolean = false, name = PropsConstants.SKIP_REDIRECTION)
    public void setSkipRedirection(boolean z) {
        this.mSkipRedirection = z;
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.DEFER_SRC_INVALIDATION)
    public void setDeferInvalidation(boolean z) {
        this.mDeferInvalidation = z;
        this.mLynxImageManager.setDeferInvalidation(z);
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.ENABLE_RESOURCE_HINT)
    public void setEnableResourceHint(boolean z) {
        this.mLynxImageManager.setEnableResourceHint(z);
    }

    @LynxProp(name = PropsConstants.ENABLE_CUSTOM_GIF_DECODER)
    public void setEnableCustomGifDecoder(boolean z) {
        this.mLynxImageManager.setEnableCustomGifDecoder(z);
    }

    @LynxProp(name = PropsConstants.SRC)
    public void setSource(String str) {
        if (!TextUtils.equals(str, this.mLynxImageManager.getRawSrc())) {
            if (!this.mDeferInvalidation) {
                this.mImageDrawable = null;
            }
            CloseableReference<?> closeableReference = this.mRef;
            if (closeableReference != null) {
                closeableReference.close();
                this.mRef = null;
            }
        }
        this.mSources = str;
        this.mHasPendingSource = true;
        onSourceSetted();
        invalidate();
    }

    @LynxProp(name = PropsConstants.PLACEHOLDER)
    public void setPlaceholder(String str) {
        this.mHasPendingPlaceholder = true;
        this.mOriginPlaceholder = str;
    }

    @LynxProp(name = PropsConstants.CAP_INSETS)
    public void setCapInsets(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            this.mCapInsets = null;
        } else {
            this.mCapInsets = str;
        }
        this.mLynxImageManager.setCapInsets(this.mCapInsets);
    }

    @LynxProp(name = PropsConstants.CAP_INSETS_BACKUP)
    public void setCapInsetsBackUp(String str) {
        setCapInsets(str);
    }

    @LynxProp(name = PropsConstants.CAP_INSETS_SCALE)
    public void setCapInsetsScale(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            this.mCapInsetsScale = null;
        } else {
            this.mCapInsetsScale = str;
        }
        this.mLynxImageManager.setCapInsetsScale(this.mCapInsetsScale);
    }

    @LynxProp(name = PropsConstants.IMAGE_PRIORITY)
    public void setImageRequestPriority(String str) {
        this.mLynxImageManager.setImageRequestPriority(str);
    }

    @LynxProp(name = PropsConstants.IMAGE_CACHE_CHOICE)
    public void setImageCacheChoice(String str) {
        this.mLynxImageManager.setImageCacheChoice(str);
    }

    @LynxProp(name = PropsConstants.IMAGE_PLACE_HOLDER_HASH_CONFIG)
    public void setImagePlaceHolderHashConfig(ReadableMap readableMap) {
        this.mLynxImageManager.setImagePlaceHolderHashConfig(readableMap);
    }

    @LynxProp(name = PropsConstants.MODE)
    public void setObjectFit(String str) {
        ScalingUtils.ScaleType scaleType = ImageResizeMode.toScaleType(str);
        this.mScaleType = scaleType;
        this.mLynxImageManager.setScaleType(scaleType);
    }

    @LynxProp(name = PropsConstants.BLUR_RADIUS)
    public void setBlurRadius(String str) {
        this.mLynxImageManager.setBlurRadius(Math.round(UnitUtils.toPxWithDisplayMetrics(str, this.mContext.getUIBody().getFontSize(), this.mFontSize, r0.getWidth(), r0.getHeight(), this.mContext.getScreenMetrics())));
    }

    @LynxProp(name = PropsConstants.AUTO_SIZE)
    public void setAutoSize(boolean z) {
        this.mLynxImageManager.setAutoSize(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onBorderRadiusUpdated(int i) {
        this.mLynxImageManager.setBorderRadius(getLynxBackground().getBorderRadius());
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.REPEAT)
    public void setRepeat(boolean z) {
        this.mRepeat = z;
    }

    @LynxProp(name = PropsConstants.LOOP_COUNT)
    public void setLoopCount(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.mLynxImageManager.setLoopCount(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeUpdateView() {
        if (this.mSuspendable && this.mScrollState != 0) {
            this.mPendingLoad = true;
            return;
        }
        if (getWidth() <= 0 && getHeight() <= 0) {
            float f = this.mPreFetchWidth;
            if (f > 0.0f) {
                float f2 = this.mPreFetchHeight;
                if (f2 > 0.0f) {
                    this.mLynxImageManager.maybeUpdateView((int) f, (int) f2, this.mPaddingLeft + this.mBorderLeftWidth, this.mPaddingTop + this.mBorderTopWidth, this.mPaddingRight + this.mBorderRightWidth, this.mPaddingBottom + this.mBorderBottomWidth);
                    return;
                }
            }
        }
        this.mLynxImageManager.maybeUpdateView(getWidth(), getHeight(), this.mPaddingLeft + this.mBorderLeftWidth, this.mPaddingTop + this.mBorderTopWidth, this.mPaddingRight + this.mBorderRightWidth, this.mPaddingBottom + this.mBorderBottomWidth);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(name = PropsConstants.IAMGE_CONFIG)
    public void setImageConfig(String str) {
        super.setImageConfig(str);
        this.mLynxImageManager.setBitmapConfig(this.mBitmapConfig);
    }

    @LynxProp(defaultBoolean = true, name = PropsConstants.AUTO_PLAY)
    public void setAutoPlay(boolean z) {
        this.mLynxImageManager.setAutoPlay(z);
    }

    @LynxProp(name = PropsConstants.TINT_COLOR)
    public void setTintColor(String str) {
        this.mLynxImageManager.setTintColor(str);
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.EXTRA_LOAD_INFO)
    public void setExtraLoadInfo(boolean z) {
        this.mLynxImageManager.setExtraLoadInfo(z);
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.ENABLE_IMAGE_ASYNC_REQUEST)
    public void setAsyncRequest(boolean z) {
        this.mLynxImageManager.setAsyncRequest(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void renderIfNeeded() {
        maybeUpdateView();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager != null) {
            lynxImageManager.onLayoutUpdated(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        }
        configureBounds();
        maybeUpdateView();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setImageRendering(int i) {
        super.setImageRendering(i);
        this.mLynxImageManager.setIsPixelated(i == 2);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updatePropertiesInterval(StylesDiffMap stylesDiffMap) {
        LynxImageManager lynxImageManager;
        super.updatePropertiesInterval(stylesDiffMap);
        if ((!this.mSkipRedirection || (this.mContext != null && this.mContext.isPrefetchImageOnCreate())) && (lynxImageManager = this.mLynxImageManager) != null) {
            lynxImageManager.updateRedirectCheckResult(this.mSources, this.mOriginPlaceholder, this.mHasPendingSource, this.mHasPendingPlaceholder);
        }
        if (this.mEnableImageAsyncRedirectOnCreate) {
            updateImageSource();
        }
    }

    private void attachWhenSetPrefetchSize() {
        LynxImageManager lynxImageManager;
        if (this.mPreFetchWidth <= 0.0f || this.mPreFetchHeight <= 0.0f || (lynxImageManager = this.mLynxImageManager) == null || !lynxImageManager.isEnableAsyncRequest()) {
            return;
        }
        this.mLynxImageManager.onAttach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        if (!this.mEnableImageAsyncRedirectOnCreate) {
            updateImageSource();
        }
        maybeUpdateView();
    }

    private void updateImageSource() {
        if (!this.mSkipRedirection && this.mHasPendingPlaceholder && this.mHasPendingSource) {
            this.mLynxImageManager.setRedirectImageSource(this.mSources, this.mOriginPlaceholder);
            this.mHasPendingSource = false;
            this.mHasPendingPlaceholder = false;
        }
        if (this.mHasPendingSource) {
            if (this.mSkipRedirection) {
                this.mLynxImageManager.setSrcSkippingRedirection(this.mSources);
            } else {
                this.mLynxImageManager.setSrc(this.mSources);
            }
            this.mHasPendingSource = false;
        }
        if (this.mHasPendingPlaceholder) {
            this.mHasPendingPlaceholder = false;
            this.mLynxImageManager.setPlaceholder(this.mOriginPlaceholder, !this.mSkipRedirection);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setParent(UIParent uIParent) {
        super.setParent(uIParent);
        this.mLynxImageManager.onAttach();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        this.mLynxImageManager.onDetach();
        BigImageDrawingHelper bigImageDrawingHelper = this.mBigImageHelper;
        if (bigImageDrawingHelper != null) {
            bigImageDrawingHelper.destroy();
        }
        CloseableReference<?> closeableReference = this.mRef;
        if (closeableReference != null) {
            closeableReference.close();
            this.mRef = null;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxFlattenUI
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        if (this.mPendingLoad) {
            return;
        }
        if (this.mImageDrawable == null && this.mRef == null) {
            return;
        }
        CloseableReference<?> closeableReference = this.mRef;
        if (closeableReference != null && closeableReference.isValid() && this.mUseLocalCache) {
            Object obj = this.mRef.get();
            if (obj instanceof CloseableBitmap) {
                bitmap = ((CloseableBitmap) obj).getUnderlyingBitmap();
            } else {
                bitmap = obj instanceof Bitmap ? (Bitmap) obj : null;
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                LLog.i("Lynx Android Flatten Image", "draw image from local cache");
                if (BaseRoundedCornerPostprocessor.customDraw(getWidth(), getHeight(), bitmap2.getWidth(), bitmap2.getHeight(), this.mScaleType, this.mCapInsets, this.mCapInsetsScale, canvas, bitmap2)) {
                    return;
                }
            }
        }
        if (!this.mFrescoNinePatch && this.mCapInsets != null) {
            LLog.i("Lynx Android Flatten Image", "load origin bitmap to draw image with cap-insets");
            if (this.mBigImageHelper == null) {
                this.mBigImageHelper = new BigImageDrawingHelper(new ImageHelperCallback(), this.mShowCnt);
            }
            if (this.mBigImageHelper.drawImageWithCapInsets(getLynxContext(), canvas, this.mLynxImageManager.getCurImageRequest(), new BigImageDrawingHelper.ImageBaseData(this.mShowCnt, getWidth(), getHeight(), this.mRepeat, this.mScaleType, this.mLynxImageManager.getSrc(), BigImageDrawingHelper.getMaxBitmapDimensions(canvas), this.mCapInsets, this.mCapInsetsScale))) {
                return;
            }
        }
        if (this.mLynxImageManager.isEnableAsyncRequest() && this.mLynxImageManager.isAsyncBitmapInValid()) {
            return;
        }
        try {
            this.mImageDrawable.draw(canvas);
        } catch (Throwable th) {
            LLog.e("Lynx-Image", th.getMessage() + ", view sie:" + getWidth() + "x" + getHeight() + ", url:" + this.mSources);
        }
    }

    @Override // com.lynx.tasm.ui.image.LynxImageManager.DrawableReadyListener
    public void onDrawableReady(Drawable drawable) {
        this.mImageDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mImageRendering == 2) {
                this.mImageDrawable.setFilterBitmap(false);
            } else if (this.mImageRendering == 1 || this.mImageRendering == 0) {
                this.mImageDrawable.setFilterBitmap(true);
            }
        }
        configureBounds();
        invalidate();
    }

    @Override // com.lynx.tasm.ui.image.LynxImageManager.DrawableReadyListener
    public void onCloseableRefReady(CloseableReference<?> closeableReference) {
        if (closeableReference == null || !this.mUseLocalCache) {
            return;
        }
        this.mRef = closeableReference.clone();
        invalidate();
    }

    @Override // com.lynx.tasm.ui.image.LynxImageManager.DrawableReadyListener
    public void onImageLoaded() {
        configureBounds();
    }

    private void configureBounds() {
        Drawable drawable = this.mImageDrawable;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxFlattenUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        this.mLynxImageManager.onAttach();
        this.mLynxImageManager.setDirty(true);
        maybeUpdateView();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        this.mLynxImageManager.onDetach();
        BigImageDrawingHelper bigImageDrawingHelper = this.mBigImageHelper;
        if (bigImageDrawingHelper != null) {
            bigImageDrawingHelper.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postInvalidate() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.lynx.tasm.ui.image.FlattenUIImage.4
                @Override // java.lang.Runnable
                public void run() {
                    FlattenUIImage.this.invalidate();
                }
            });
        }
    }

    public Drawable getImageDrawable() {
        return this.mImageDrawable;
    }

    @LynxProp(name = PropsConstants.PRE_FETCH_WIDTH)
    public void setPreFetchWidth(String str) {
        this.mPreFetchWidth = UnitUtils.toPxWithDisplayMetrics(str, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics());
        attachWhenSetPrefetchSize();
    }

    @LynxProp(name = PropsConstants.PRE_FETCH_HEIGHT)
    public void setPreFetchHeight(String str) {
        this.mPreFetchHeight = UnitUtils.toPxWithDisplayMetrics(str, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics());
        attachWhenSetPrefetchSize();
    }

    @LynxProp(name = "async-redirect")
    public void setAsyncRedirect(boolean z) {
        this.mLynxImageManager.setAsyncRedirect(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setLocalCache(Dynamic dynamic) {
        super.setLocalCache(dynamic);
        if (this.mLynxImageManager == null) {
            return;
        }
        ImageUtils.LocalCacheState parseLocalCache = ImageUtils.parseLocalCache(dynamic);
        this.mUseLocalCache = parseLocalCache.mUseLocalCache;
        boolean z = parseLocalCache.mAwaitLocalCache;
        this.mLynxImageManager.setUseLocalCache(this.mUseLocalCache);
        this.mLynxImageManager.setAwaitLocalCache(z);
    }

    @Deprecated
    public void setLocalCache(Boolean bool) {
        if (this.mLynxImageManager == null) {
            return;
        }
        if (bool == null) {
            this.mUseLocalCache = false;
        }
        boolean booleanValue = bool.booleanValue();
        this.mUseLocalCache = booleanValue;
        this.mLynxImageManager.setUseLocalCache(booleanValue);
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.FRESCO_NINE_PATCH)
    public void setFrescoNinePatch(boolean z) {
        this.mFrescoNinePatch = z;
    }

    @LynxProp(name = PropsConstants.SUSPENDABLE)
    public void setSuspendable(Dynamic dynamic) {
        this.mSuspendable = false;
        if (dynamic != null) {
            int i = C02136.$SwitchMap$com$lynx$react$bridge$ReadableType[dynamic.getType().ordinal()];
            if (i == 1) {
                this.mSuspendable = dynamic.asBoolean();
            } else if (i == 2) {
                this.mSuspendable = TextUtils.equals("true", dynamic.asString());
            }
        }
        if (!this.mSuspendable) {
            unRegisterScrollStateListener(this.mScrollStateChangeListener);
            return;
        }
        if (this.mScrollStateChangeListener == null) {
            this.mScrollStateChangeListener = new ScrollStateChangeListener() { // from class: com.lynx.tasm.ui.image.FlattenUIImage.5
                @Override // com.lynx.tasm.behavior.p000ui.ScrollStateChangeListener
                public void onScrollStateChanged(int i2) {
                    FlattenUIImage.this.mScrollState = i2;
                    if (FlattenUIImage.this.mPendingLoad && i2 == 0) {
                        FlattenUIImage.this.mPendingLoad = false;
                        FlattenUIImage.this.maybeUpdateView();
                    }
                }
            };
        }
        registerScrollStateListener(this.mScrollStateChangeListener);
    }

    /* renamed from: com.lynx.tasm.ui.image.FlattenUIImage$6 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C02136 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$lynx$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @LynxProp(name = PropsConstants.DISABLE_DEFAULT_RESIZE)
    public void setDisableDefaultResize(boolean z) {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager == null) {
            return;
        }
        if (z) {
            lynxImageManager.setResizeMethod(ImageResizeMethod.SCALE);
        } else {
            lynxImageManager.setResizeMethod(ImageResizeMethod.RESIZE);
        }
    }

    @LynxProp(name = PropsConstants.ANDROID_IMAGE_SIMPLE_KEY)
    public void setSimpleCacheKey(boolean z) {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager == null) {
            return;
        }
        lynxImageManager.setSimpleCacheKey(z);
    }

    @LynxProp(name = PropsConstants.IMAGE_TRANSITION_STYLE)
    public void setImageTransitionStyle(String str) {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager == null) {
            return;
        }
        lynxImageManager.setImageTransitionStyle(str);
    }

    @LynxProp(name = "additional-custom-info")
    public void setCustomParams(ReadableMap readableMap) {
        this.mLynxImageManager.setImageCustomParams(readableMap);
    }

    @LynxProp(name = "enable-super-resolution")
    public void setImageSR(boolean z) {
        this.mLynxImageManager.setEnableImageSR(z);
    }

    @LynxProp(name = "super-resolution-scale")
    public void setImageSRScale(float f) {
        this.mLynxImageManager.setImageSRScale(f);
    }

    @LynxUIMethod
    public void pauseAnimation(ReadableMap readableMap, Callback callback) {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager == null) {
            return;
        }
        lynxImageManager.pauseAnimation(callback);
    }

    @LynxUIMethod
    public void resumeAnimation(ReadableMap readableMap, Callback callback) {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager == null) {
            return;
        }
        lynxImageManager.resumeAnimation(callback);
    }

    @LynxUIMethod
    public void stopAnimation(ReadableMap readableMap, Callback callback) {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager == null) {
            return;
        }
        lynxImageManager.stopAnimation(callback);
    }

    @LynxUIMethod
    public void startAnimate() {
        LynxImageManager lynxImageManager = this.mLynxImageManager;
        if (lynxImageManager == null) {
            return;
        }
        lynxImageManager.startAnimate();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> map) {
        super.setEvents(map);
        if (map == null) {
            return;
        }
        this.mLynxImageManager.setImageEvents(map);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        this.mLynxImageManager.onNodeReady();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSource() {
        return this.mSources;
    }
}
