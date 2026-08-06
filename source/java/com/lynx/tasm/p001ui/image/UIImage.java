package com.lynx.tasm.p001ui.image;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.ScrollStateChangeListener;
import com.lynx.tasm.behavior.p000ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.p000ui.image.AbsUIImage;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.image.ImageUtils;
import com.lynx.tasm.p001ui.image.FrescoImageView;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.lynx.tasm.utils.UnitUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIImage<T extends FrescoImageView> extends AbsUIImage<T> {
    public static final String EVENT_ERROR = "error";
    protected AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private boolean mEnableImageAsyncRedirectOnCreate;
    private boolean mHasPendingPlaceholder;
    private boolean mHasPendingSource;
    private int mImageDstHeight;
    private int mImageDstWidth;
    private boolean mIsNoSubSampleMode;
    private String mOriginPlaceholder;
    private boolean mPendingLoad;
    private int mScrollState;
    private ScrollStateChangeListener mScrollStateChangeListener;
    private boolean mSkipRedirection;
    private String mSources;
    private boolean mSuspendable;

    @Deprecated
    public UIImage(Context context) {
        this((LynxContext) context);
    }

    public UIImage(LynxContext lynxContext) {
        super(lynxContext);
        this.mImageDstHeight = 0;
        this.mImageDstWidth = 0;
        this.mIsNoSubSampleMode = false;
        this.mSources = null;
        this.mOriginPlaceholder = null;
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
        this.mSkipRedirection = false;
        this.mScrollState = 0;
    }

    public UIImage(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mImageDstHeight = 0;
        this.mImageDstWidth = 0;
        this.mIsNoSubSampleMode = false;
        this.mSources = null;
        this.mOriginPlaceholder = null;
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
        this.mSkipRedirection = false;
        this.mScrollState = 0;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void renderIfNeeded() {
        reloadImage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public T createView(Context context) {
        this.mDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        T t = (T) new FrescoImageView(context, this.mDraweeControllerBuilder, null, getLynxContext().getFrescoCallerContext(), this);
        t.setNoSubSampleMode(this.mIsNoSubSampleMode);
        t.setImageLoaderCallback(new ImageLoaderCallback() { // from class: com.lynx.tasm.ui.image.UIImage.1
            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageLoadSuccess(int i, int i2) {
                if (UIImage.this.mEvents == null || !UIImage.this.mEvents.containsKey("load")) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(UIImage.this.getSign(), "load");
                lynxDetailEvent.addDetail("height", Integer.valueOf(i2));
                lynxDetailEvent.addDetail("width", Integer.valueOf(i));
                UIImage.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageLoadFailed(LynxError lynxError, int i, int i2) {
                if (lynxError == null) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(UIImage.this.getSign(), "error");
                lynxDetailEvent.addDetail("errMsg", lynxError.getSummaryMessage() + ": " + lynxError.getRootCause());
                lynxDetailEvent.addDetail(ImageErrorCodeUtils.LYNX_IMAGE_CATEGORIZED_CODE_KEY, Integer.valueOf(i));
                lynxDetailEvent.addDetail("error_code", Integer.valueOf(i2));
                UIImage.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
                UIImage.this.getLynxContext().reportResourceError(UIImage.this.mSources, LynxMemoryInfo.TYPE_IMAGE, lynxError);
            }

            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public void onImageDstSize(int i, int i2) {
                UIImage.this.mImageDstWidth = i;
                UIImage.this.mImageDstHeight = i2;
            }

            @Override // com.lynx.tasm.p001ui.image.ImageLoaderCallback
            public boolean isPendingLoad() {
                return UIImage.this.mPendingLoad;
            }
        });
        t.setImageRedirectListener(new ImageAsyncRedirectListener() { // from class: com.lynx.tasm.ui.image.UIImage.2
            @Override // com.lynx.tasm.p001ui.image.ImageAsyncRedirectListener
            public void onAsyncRedirectFinish() {
                UIImage.this.reloadImage();
            }
        });
        this.mEnableImageAsyncRedirectOnCreate = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public long getMemoryUsageBytes() {
        long memoryUsageBytes = super.getMemoryUsageBytes();
        return this.mView == 0 ? memoryUsageBytes : ((FrescoImageView) this.mView).getBitmapMemorySizeBytes() + memoryUsageBytes;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public Map<String, String> getMemoryUsageDetail() {
        long memoryUsageBytes = getMemoryUsageBytes();
        String str = this.mSources;
        if (memoryUsageBytes == 0 || str == null || str.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, String.valueOf(memoryUsageBytes));
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        int i = this.mPaddingLeft + this.mBorderLeftWidth;
        int i2 = this.mPaddingRight + this.mBorderRightWidth;
        int i3 = this.mPaddingTop + this.mBorderTopWidth;
        int i4 = this.mPaddingBottom + this.mBorderBottomWidth;
        if ((getWidth() - this.mImageDstWidth > 1 || getHeight() - this.mImageDstHeight > 1) && !hasAnimationRunning()) {
            ((FrescoImageView) this.mView).markDirty();
        }
        ((FrescoImageView) this.mView).setPadding(i, i3, i2, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        if (this.mView != 0) {
            ViewCompat.setAccessibilityDelegate(this.mView, new CustomAccessibilityDelegateCompat(this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.IMAGE_SUBSAMPLE)
    public void setSubSample(String str) {
        if (str != null && (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no"))) {
            this.mIsNoSubSampleMode = true;
        } else {
            this.mIsNoSubSampleMode = false;
        }
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setNoSubSampleMode(this.mIsNoSubSampleMode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.ENABLE_CUSTOM_GIF_DECODER)
    public void setEnableCustomGifDecoder(boolean z) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setEnableCustomGifDecoder(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = PropsConstants.ENABLE_RESOURCE_HINT)
    public void setEnableResourceHint(boolean z) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setEnableResourceHint(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setLocalCache(Dynamic dynamic) {
        super.setLocalCache(dynamic);
        if (this.mView == 0) {
            return;
        }
        ImageUtils.LocalCacheState parseLocalCache = ImageUtils.parseLocalCache(dynamic);
        boolean z = parseLocalCache.mUseLocalCache;
        boolean z2 = parseLocalCache.mAwaitLocalCache;
        ((FrescoImageView) this.mView).setLocalCache(z);
        ((FrescoImageView) this.mView).setAwaitLocalCache(z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void setLocalCache(Boolean bool) {
        if (this.mView == 0) {
            return;
        }
        if (bool == null) {
            ((FrescoImageView) this.mView).setLocalCache(false);
        }
        ((FrescoImageView) this.mView).setLocalCache(bool.booleanValue());
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(defaultBoolean = false, name = PropsConstants.SKIP_REDIRECTION)
    public void setSkipRedirection(boolean z) {
        this.mSkipRedirection = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = PropsConstants.DEFER_SRC_INVALIDATION)
    public void setDeferInvalidation(boolean z) {
        ((FrescoImageView) this.mView).setDeferInvalidation(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "async-redirect")
    public void setAsyncRedirect(boolean z) {
        ((FrescoImageView) this.mView).setAsyncRedirect(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setSource(String str) {
        String str2 = this.mSources;
        if (str2 != null && !str2.equals(str)) {
            this.mImageDstWidth = 0;
            this.mImageDstHeight = 0;
        }
        this.mSources = str;
        this.mHasPendingSource = true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setPlaceholder(String str) {
        this.mHasPendingPlaceholder = true;
        this.mOriginPlaceholder = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onBorderRadiusUpdated(int i) {
        ((FrescoImageView) this.mView).setBorderRadius(getLynxBackground().getBorderRadius());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setObjectFit(String str) {
        ((FrescoImageView) this.mView).setScaleType(ImageResizeMode.toScaleType(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setBlurRadius(String str) {
        ((FrescoImageView) this.mView).setBlurRadius(Math.round(UnitUtils.toPxWithDisplayMetrics(str, this.mContext.getUIBody().getFontSize(), this.mFontSize, r0.getWidth(), r0.getHeight(), this.mContext.getScreenMetrics())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setRepeat(boolean z) {
        ((FrescoImageView) this.mView).setRepeat(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setCoverStart(boolean z) {
        ((FrescoImageView) this.mView).setCoverStart(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updatePropertiesInterval(StylesDiffMap stylesDiffMap) {
        super.updatePropertiesInterval(stylesDiffMap);
        if ((!this.mSkipRedirection || (this.mContext != null && this.mContext.isPrefetchImageOnCreate())) && this.mView != 0) {
            ((FrescoImageView) this.mView).updateRedirectCheckResult(this.mSources, this.mOriginPlaceholder, this.mHasPendingSource, this.mHasPendingPlaceholder);
        }
        if (this.mEnableImageAsyncRedirectOnCreate) {
            updateImageSource();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        if (!this.mEnableImageAsyncRedirectOnCreate) {
            updateImageSource();
        }
        ((FrescoImageView) this.mView).setConsumeHoverEvent(this.mConsumeHoverEvent);
        reloadImage();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateImageSource() {
        if (!this.mSkipRedirection && this.mHasPendingPlaceholder && this.mHasPendingSource) {
            ((FrescoImageView) this.mView).setRedirectImageSource(this.mSources, this.mOriginPlaceholder);
            ((FrescoImageView) this.mView).invalidate();
            this.mHasPendingSource = false;
            this.mHasPendingPlaceholder = false;
        }
        if (this.mHasPendingSource) {
            if (this.mSkipRedirection) {
                ((FrescoImageView) this.mView).setSrcSkippingRedirection(this.mSources);
            } else {
                ((FrescoImageView) this.mView).setSrc(this.mSources);
                ((FrescoImageView) this.mView).invalidate();
            }
            this.mHasPendingSource = false;
        }
        if (this.mHasPendingPlaceholder) {
            this.mHasPendingPlaceholder = false;
            ((FrescoImageView) this.mView).setPlaceholder(this.mOriginPlaceholder, !this.mSkipRedirection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void reloadImage() {
        if (this.mSuspendable && this.mScrollState != 0) {
            this.mPendingLoad = true;
        } else {
            ((FrescoImageView) this.mView).maybeUpdateView();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setLoopCount(int i) {
        if (i <= 0) {
            i = 0;
        }
        ((FrescoImageView) this.mView).setLoopCount(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setPreFetchWidth(String str) {
        ((FrescoImageView) this.mView).setPreFetchWidth(UnitUtils.toPxWithDisplayMetrics(str, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setPreFetchHeight(String str) {
        ((FrescoImageView) this.mView).setPreFetchHeight(UnitUtils.toPxWithDisplayMetrics(str, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setDisableDefaultPlaceholder(boolean z) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setDisableDefaultPlaceHolder(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        ((FrescoImageView) this.mView).destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        ((FrescoImageView) this.mView).destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setCapInsets(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            ((FrescoImageView) this.mView).setCapInsets(null);
        } else {
            ((FrescoImageView) this.mView).setCapInsets(str);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    @LynxProp(name = PropsConstants.CAP_INSETS_BACKUP)
    public void setCapInsetsBackUp(String str) {
        setCapInsets(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    @LynxProp(name = PropsConstants.CAP_INSETS_SCALE)
    public void setCapInsetsScale(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            ((FrescoImageView) this.mView).setCapInsetsScale(null);
        } else {
            ((FrescoImageView) this.mView).setCapInsetsScale(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.FRESCO_ATTACH)
    public void setFrescoAttach(String str) {
        if (str != null) {
            if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes")) {
                ((FrescoImageView) this.mView).mIsFrescoAttach = true;
                ((FrescoImageView) this.mView).setFrescoAttach();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.FRESCO_VISIBLE)
    public void setFrescoVisible(String str) {
        if (str != null) {
            if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes")) {
                ((FrescoImageView) this.mView).mIsFrescoVisible = true;
                ((FrescoImageView) this.mView).setFrescoVisible();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    @LynxProp(defaultInt = 1, name = "visibility")
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (((FrescoImageView) this.mView).mIsFrescoVisible) {
            ((FrescoImageView) this.mView).setFrescoVisible();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(name = PropsConstants.IAMGE_CONFIG)
    public void setImageConfig(String str) {
        super.setImageConfig(str);
        ((FrescoImageView) this.mView).setBitmapConfig(this.mBitmapConfig);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = PropsConstants.FRESCO_NINE_PATCH)
    public void setFrescoNinePatch(boolean z) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setFrescoNinePatch(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.FIX_FRESCO_BUG)
    public void fixFrescoWebPBug(boolean z) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).fixFrescoWebPBug(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.TINT_COLOR)
    public void setTintColor(String str) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setTintColor(str);
        }
    }

    @LynxProp(name = PropsConstants.SUSPENDABLE)
    public void setSuspendable(Dynamic dynamic) {
        this.mSuspendable = false;
        if (dynamic != null) {
            int i = C02464.$SwitchMap$com$lynx$react$bridge$ReadableType[dynamic.getType().ordinal()];
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
            this.mScrollStateChangeListener = new ScrollStateChangeListener() { // from class: com.lynx.tasm.ui.image.UIImage.3
                @Override // com.lynx.tasm.behavior.p000ui.ScrollStateChangeListener
                public void onScrollStateChanged(int i2) {
                    UIImage.this.mScrollState = i2;
                    if (UIImage.this.mPendingLoad && i2 == 0) {
                        UIImage.this.mPendingLoad = false;
                        UIImage.this.reloadImage();
                    }
                }
            };
        }
        registerScrollStateListener(this.mScrollStateChangeListener);
    }

    /* renamed from: com.lynx.tasm.ui.image.UIImage$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C02464 {
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

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = PropsConstants.AUTO_PLAY)
    public void setAutoPlay(boolean z) {
        ((FrescoImageView) this.mView).setAutoPlay(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = PropsConstants.ANDROID_IMAGE_SIMPLE_KEY)
    public void setSimpleCacheKey(boolean z) {
        ((FrescoImageView) this.mView).setSimpleCacheKey(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.IMAGE_TRANSITION_STYLE)
    public void setImageTransitionStyle(String str) {
        ((FrescoImageView) this.mView).setImageTransitionStyle(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = PropsConstants.EXTRA_LOAD_INFO)
    public void setExtraLoadInfo(boolean z) {
        ((FrescoImageView) this.mView).setExtraLoadInfo(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void startAnimate() {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).stopAnimate();
            ((FrescoImageView) this.mView).startAnimate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void resumeAnimation(ReadableMap readableMap, Callback callback) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).startAnimate();
            callback.invoke(new Object[]{0, "Animation resumed."});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void stopAnimation(ReadableMap readableMap, Callback callback) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).stopAnimate();
            callback.invoke(new Object[]{0, "Animation stopped."});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void pauseAnimation(ReadableMap readableMap, Callback callback) {
        if (this.mView != 0) {
            if (((FrescoImageView) this.mView).pauseAnimate()) {
                callback.invoke(new Object[]{0, "Animation paused."});
            } else {
                callback.invoke(new Object[]{4, "Not support pause yet"});
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setAutoSize(boolean z) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setAutoSize(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setImageRendering(int i) {
        super.setImageRendering(i);
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setIsPixelated(i == 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage
    public void setDisableDefaultResize(boolean z) {
        if (this.mView == 0) {
            return;
        }
        if (z) {
            ((FrescoImageView) this.mView).setResizeMethod(ImageResizeMethod.SCALE);
        } else {
            ((FrescoImageView) this.mView).setResizeMethod(ImageResizeMethod.RESIZE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onBeforeAnimation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 > this.mImageDstWidth || i4 > this.mImageDstHeight) {
            ((FrescoImageView) this.mView).tryFetchImage(i3, i4, i5, i6, i7, i8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> map) {
        super.setEvents(map);
        if (map == null || this.mView == 0) {
            return;
        }
        ((FrescoImageView) this.mView).setImageEvents(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).onNodeReady();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "additional-custom-info")
    public void setCustomParams(ReadableMap readableMap) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setImageCustomParams(readableMap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.IMAGE_PRIORITY)
    public void setImageRequestPriority(String str) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setImageRequestPriority(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.IMAGE_PLACE_HOLDER_HASH_CONFIG)
    public void setImagePlaceHolderHashConfig(ReadableMap readableMap) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setImagePlaceHolderHashConfig(readableMap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = PropsConstants.IMAGE_CACHE_CHOICE)
    public void setImageCacheChoice(String str) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setImageCacheChoice(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "enable-super-resolution")
    public void setImageSR(boolean z) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setEnableImageSR(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "super-resolution-scale")
    public void setImageSRScale(float f) {
        if (this.mView != 0) {
            ((FrescoImageView) this.mView).setImageSRScale(f);
        }
    }
}
