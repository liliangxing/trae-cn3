package com.lynx.tasm;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PageConfig {
    private static final String KEY_ASYNC_REDIRECT = "asyncRedirect";
    private static final String KEY_AUTO_EXPOSE = "autoExpose";
    private static final String KEY_CLI_VERSION = "cliVersion";
    private static final String KEY_CSS_ALIGN_WITH_LEGACY_W3C = "cssAlignWithLegacyW3c";
    private static final String KEY_CUSTOM_DATA = "customData";
    private static final String KEY_DEFAULT_OVERFLOW_VISIBLE = "defaultOverflowVisible";
    private static final String KEY_ENABLE_A11Y = "enableA11y";
    private static final String KEY_ENABLE_A11Y_ID_MUTATION_OBSERVER = "enableA11yIDMutationObserver";
    private static final String KEY_ENABLE_ACCESSIBILITY_ELEMENT = "enableAccessibilityElement";
    private static final String KEY_ENABLE_ASYNC_REQUEST_IMAGE = "enableAsyncRequestImage";
    private static final String KEY_ENABLE_CHECK_LOCAL_IMAGE = "enableCheckLocalImage";
    private static final String KEY_ENABLE_CREATE_VIEW_ASYNC = "enableCreateViewAsync";
    private static final String KEY_ENABLE_CSS_PARSER = "enableCSSParser";
    private static final String KEY_ENABLE_DISEXPOSURE_WHEN_LYNX_HIDDEN = "enableDisexposureWhenLynxHidden";
    private static final String KEY_ENABLE_EVENT_REFACTOR = "enableEventRefactor";
    private static final String KEY_ENABLE_EXPOSURE_UI_MARGIN = "enableExposureUIMargin";
    private static final String KEY_ENABLE_EXPOSURE_WHEN_LAYOUT = "enableExposureWhenLayout";
    private static final String KEY_ENABLE_EXPOSURE_WHEN_RELOAD = "enableExposureWhenReload";
    private static final String KEY_ENABLE_FIBER = "enableFiber";
    private static final String KEY_ENABLE_FLATTEN_TRANSLATE_Z = "enableFlattenTranslateZ";
    private static final String KEY_ENABLE_LEPUS_NG = "enableLepusNG";
    private static final String KEY_ENABLE_LYNX_SCROLL_FLUENCY = "enableLynxScrollFluency";
    private static final String KEY_ENABLE_MULTITOUCH = "enableMultiTouch";
    private static final String KEY_ENABLE_NEW_ACCESSIBILITY = "enableNewAccessibility";
    private static final String KEY_ENABLE_NEW_CLIP_MODE = "enableNewClipMode";
    private static final String KEY_ENABLE_NEW_GESTURE = "enableNewGesture";
    private static final String KEY_ENABLE_NEW_IMAGE = "enableNewImage";
    private static final String KEY_ENABLE_NEW_INTERSECTION_OBSERVER = "enableNewIntersectionObserver";
    private static final String KEY_ENABLE_OVERLAP_ACCESSIBILITY_ELEMENT = "enableOverlapForAccessibilityElement";
    private static final String KEY_ENABLE_TEXT_BORING_LAYOUT = "enableTextBoringLayout";
    private static final String KEY_ENABLE_TEXT_LAYOUT_CACHE = "enableTextLayoutCache";
    private static final String KEY_ENABLE_TEXT_OVERFLOW = "enableTextOverflow";
    private static final String KEY_ENABLE_TEXT_REFACTOR = "enableTextRefactor";
    private static final String KEY_ENABLE_VSYNC_ALIGNED_FLUSH = "enableVsyncAlignedFlush";
    private static final String KEY_EVENT_THROUGH = "enableEventThrough";
    private static final String KEY_FILE_PATH = "filePath";
    private static final String KEY_GIT = "git";
    private static final String KEY_INCLUDE_FONT_PADDING = "includeFontPadding";
    private static final String KEY_INIT_ASYNC_TT_VIDEO_ENGINE = "enableAsyncInitVideoEngine";
    private static final String KEY_KEYBOARD_CALLBACK_PASS_RELATIVE_HEIGHT = "keyboardCallbackPassRelativeHeight";
    private static final String KEY_LEPUS_VERSION = "lepusVersion";
    private static final String KEY_LONG_PRESS_DURATION = "longPressDuration";
    private static final String KEY_MAP_CONTAINER_TYPE = "mapContainerType";
    private static final String KEY_OBSERVER_FRAME_RATE = "observerFrameRate";
    private static final String KEY_PAGE_FLATTEN = "pageFlatten";
    private static final String KEY_PAGE_TYPE = "pageType";
    private static final String KEY_PAGE_VERSION = "pageVersion";
    private static final String KEY_REACT_VERSION = "reactVersion";
    private static final String KEY_SYNC_IMAGE_ATTACH = "syncImageAttach";
    private static final String KEY_TAP_SLOP = "tapSlop";
    private static final String KEY_TARGET_SDK_VERSION = "targetSdkVersion";
    private static final String KEY_USER = "user";
    private static final String KEY_USE_IMAGE_POST_PROCESSOR = "useImagePostProcessor";
    private static final String KEY_USE_NEW_SWIPER = "useNewSwiper";
    private static final String TAG = "PageConfig";
    private boolean asyncRedirect;
    private boolean autoExpose;
    private String cliVersion;
    private String customData;
    private boolean defaultOverflowVisible;
    private boolean enableAsyncRequestImage;
    private boolean enableCheckLocalImage;
    private boolean enableEventThrough;
    private boolean enableLepusNG;
    private boolean enableLoadImageFromService;
    private String lepusVersion;
    private boolean mCssAlignWithLegacyW3c;
    private boolean mDefaultTextIncludePadding;
    private boolean mEnableA11y;
    private boolean mEnableA11yIDMutationObserver;
    private boolean mEnableAccessibilityElement;
    private boolean mEnableAsyncInitTTVideoEngine;
    private boolean mEnableCSSParser;
    private boolean mEnableCreateViewAsync;
    private boolean mEnableDisexposureWhenLynxHidden;
    private boolean mEnableEventRefactor;
    private boolean mEnableExposureUIMargin;
    private boolean mEnableExposureWhenLayout;
    private boolean mEnableExposureWhenReload;
    private boolean mEnableFiber;
    private boolean mEnableFlattenTranslateZ;
    private double mEnableLynxScrollFluency;
    private boolean mEnableMultiTouch;
    private boolean mEnableNewAccessibility;
    private boolean mEnableNewClipMode;
    private boolean mEnableNewGesture;
    private boolean mEnableNewIntersectionObserver;
    private boolean mEnableOverlapForAccessibilityElement;
    private boolean mEnableTextBoringLayout;
    private boolean mEnableTextLayoutCache;
    private boolean mEnableTextOverflow;
    private boolean mEnableTextRefactor;
    private boolean mEnableVsyncAlignedFlush;
    private String mFilePath;
    private String mGit;
    private boolean mKeyboardCallbackUseRelativeHeight;
    private int mLongPressDuration;
    private int mMapContainerType;
    private int mObserverFrameRate;
    private boolean mPageFlatten;
    private String mReactVersion;
    private String mTapSlop;
    private String mUser;
    private String pageType;
    private String pageVersion;
    private boolean syncImageAttach;
    private String targetSdkVersion;
    private boolean useImagePostProcessor;
    private boolean useNewSwiper;

    public PageConfig(ReadableMap readableMap) {
        this.syncImageAttach = true;
        this.enableCheckLocalImage = true;
        this.useNewSwiper = true;
        this.enableLepusNG = true;
        this.mTapSlop = "50px";
        this.mEnableCreateViewAsync = true;
        this.mEnableAccessibilityElement = true;
        this.mEnableOverlapForAccessibilityElement = true;
        this.mEnableNewClipMode = true;
        this.mDefaultTextIncludePadding = false;
        this.mEnableEventRefactor = true;
        this.mEnableDisexposureWhenLynxHidden = true;
        this.mEnableExposureWhenLayout = false;
        this.mEnableExposureWhenReload = false;
        this.mEnableFlattenTranslateZ = false;
        this.mEnableNewGesture = false;
        this.mEnableNewIntersectionObserver = false;
        this.mEnableFiber = false;
        this.mEnableMultiTouch = false;
        this.mObserverFrameRate = 20;
        this.mEnableExposureUIMargin = false;
        this.mLongPressDuration = -1;
        this.mMapContainerType = 0;
        this.mPageFlatten = true;
        this.mEnableLynxScrollFluency = -1.0d;
        this.mEnableTextLayoutCache = true;
        this.autoExpose = true;
        this.enableEventThrough = false;
        this.pageVersion = "error";
        if (readableMap != null) {
            if (readableMap.hasKey(KEY_AUTO_EXPOSE)) {
                this.autoExpose = readableMap.getBoolean(KEY_AUTO_EXPOSE);
            }
            if (readableMap.hasKey(KEY_PAGE_VERSION)) {
                this.pageVersion = readableMap.getString(KEY_PAGE_VERSION);
            }
            if (readableMap.hasKey(KEY_EVENT_THROUGH)) {
                this.enableEventThrough = readableMap.getBoolean(KEY_EVENT_THROUGH);
            }
            if (readableMap.hasKey(KEY_DEFAULT_OVERFLOW_VISIBLE)) {
                this.defaultOverflowVisible = readableMap.getBoolean(KEY_DEFAULT_OVERFLOW_VISIBLE);
            }
            if (readableMap.hasKey(KEY_SYNC_IMAGE_ATTACH)) {
                this.syncImageAttach = readableMap.getBoolean(KEY_SYNC_IMAGE_ATTACH);
            }
            if (readableMap.hasKey(KEY_ENABLE_CHECK_LOCAL_IMAGE)) {
                this.enableCheckLocalImage = readableMap.getBoolean(KEY_ENABLE_CHECK_LOCAL_IMAGE);
            }
            if (readableMap.hasKey(KEY_ENABLE_ASYNC_REQUEST_IMAGE)) {
                this.enableAsyncRequestImage = readableMap.getBoolean(KEY_ENABLE_ASYNC_REQUEST_IMAGE);
            }
            if (readableMap.hasKey(KEY_USE_IMAGE_POST_PROCESSOR)) {
                this.useImagePostProcessor = readableMap.getBoolean(KEY_USE_IMAGE_POST_PROCESSOR);
            }
            if (readableMap.hasKey(KEY_ENABLE_NEW_IMAGE)) {
                this.enableLoadImageFromService = readableMap.getBoolean(KEY_ENABLE_NEW_IMAGE);
            }
            if (readableMap.hasKey(KEY_ASYNC_REDIRECT)) {
                this.asyncRedirect = readableMap.getBoolean(KEY_ASYNC_REDIRECT);
            }
            if (readableMap.hasKey(KEY_PAGE_TYPE)) {
                this.pageType = readableMap.getString(KEY_PAGE_TYPE);
            }
            if (readableMap.hasKey(KEY_CLI_VERSION)) {
                this.cliVersion = readableMap.getString(KEY_CLI_VERSION);
            }
            if (readableMap.hasKey(KEY_CUSTOM_DATA)) {
                this.customData = readableMap.getString(KEY_CUSTOM_DATA);
            }
            if (readableMap.hasKey(KEY_USE_NEW_SWIPER)) {
                this.useNewSwiper = readableMap.getBoolean(KEY_USE_NEW_SWIPER);
            }
            if (readableMap.hasKey(KEY_INIT_ASYNC_TT_VIDEO_ENGINE)) {
                this.mEnableAsyncInitTTVideoEngine = readableMap.getBoolean(KEY_INIT_ASYNC_TT_VIDEO_ENGINE);
            }
            if (readableMap.hasKey(KEY_TARGET_SDK_VERSION)) {
                this.targetSdkVersion = readableMap.getString(KEY_TARGET_SDK_VERSION);
            }
            if (readableMap.hasKey(KEY_ENABLE_FLATTEN_TRANSLATE_Z)) {
                this.mEnableFlattenTranslateZ = readableMap.getBoolean(KEY_ENABLE_FLATTEN_TRANSLATE_Z);
            }
            if (readableMap.hasKey(KEY_ENABLE_NEW_GESTURE)) {
                this.mEnableNewGesture = readableMap.getBoolean(KEY_ENABLE_NEW_GESTURE);
            }
            if (readableMap.hasKey(KEY_INCLUDE_FONT_PADDING)) {
                this.mDefaultTextIncludePadding = readableMap.getBoolean(KEY_INCLUDE_FONT_PADDING);
            }
            if (readableMap.hasKey(KEY_LEPUS_VERSION)) {
                this.lepusVersion = readableMap.getString(KEY_LEPUS_VERSION);
            }
            if (readableMap.hasKey(KEY_ENABLE_LEPUS_NG)) {
                this.enableLepusNG = readableMap.getBoolean(KEY_ENABLE_LEPUS_NG);
            }
            if (readableMap.hasKey(KEY_TAP_SLOP)) {
                this.mTapSlop = readableMap.getString(KEY_TAP_SLOP);
            }
            if (readableMap.hasKey(KEY_ENABLE_CREATE_VIEW_ASYNC)) {
                this.mEnableCreateViewAsync = readableMap.getBoolean(KEY_ENABLE_CREATE_VIEW_ASYNC);
            }
            if (readableMap.hasKey(KEY_ENABLE_VSYNC_ALIGNED_FLUSH)) {
                this.mEnableVsyncAlignedFlush = readableMap.getBoolean(KEY_ENABLE_VSYNC_ALIGNED_FLUSH);
            }
            if (readableMap.hasKey(KEY_CSS_ALIGN_WITH_LEGACY_W3C)) {
                this.mCssAlignWithLegacyW3c = readableMap.getBoolean(KEY_CSS_ALIGN_WITH_LEGACY_W3C);
            }
            if (readableMap.hasKey(KEY_ENABLE_ACCESSIBILITY_ELEMENT)) {
                this.mEnableAccessibilityElement = readableMap.getBoolean(KEY_ENABLE_ACCESSIBILITY_ELEMENT);
            }
            if (readableMap.hasKey(KEY_ENABLE_OVERLAP_ACCESSIBILITY_ELEMENT)) {
                this.mEnableOverlapForAccessibilityElement = readableMap.getBoolean(KEY_ENABLE_OVERLAP_ACCESSIBILITY_ELEMENT, true);
            }
            if (readableMap.hasKey(KEY_ENABLE_NEW_ACCESSIBILITY)) {
                this.mEnableNewAccessibility = readableMap.getBoolean(KEY_ENABLE_NEW_ACCESSIBILITY, false);
            }
            if (readableMap.hasKey(KEY_ENABLE_A11Y_ID_MUTATION_OBSERVER)) {
                this.mEnableA11yIDMutationObserver = readableMap.getBoolean(KEY_ENABLE_A11Y_ID_MUTATION_OBSERVER, false);
            }
            if (readableMap.hasKey(KEY_ENABLE_A11Y)) {
                this.mEnableA11y = readableMap.getBoolean(KEY_ENABLE_A11Y, false);
            }
            if (readableMap.hasKey(KEY_REACT_VERSION)) {
                this.mReactVersion = readableMap.getString(KEY_REACT_VERSION);
            }
            if (readableMap.hasKey(KEY_ENABLE_TEXT_REFACTOR)) {
                this.mEnableTextRefactor = readableMap.getBoolean(KEY_ENABLE_TEXT_REFACTOR);
            }
            if (readableMap.hasKey(KEY_ENABLE_TEXT_OVERFLOW)) {
                this.mEnableTextOverflow = readableMap.getBoolean(KEY_ENABLE_TEXT_OVERFLOW);
            }
            if (readableMap.hasKey(KEY_ENABLE_TEXT_BORING_LAYOUT)) {
                this.mEnableTextBoringLayout = readableMap.getBoolean(KEY_ENABLE_TEXT_BORING_LAYOUT);
            } else {
                this.mEnableTextBoringLayout = LynxEnv.inst().enableTextBoringLayout();
            }
            if (readableMap.hasKey(KEY_ENABLE_NEW_CLIP_MODE)) {
                this.mEnableNewClipMode = readableMap.getBoolean(KEY_ENABLE_NEW_CLIP_MODE);
            }
            if (readableMap.hasKey(KEY_KEYBOARD_CALLBACK_PASS_RELATIVE_HEIGHT)) {
                this.mKeyboardCallbackUseRelativeHeight = readableMap.getBoolean(KEY_KEYBOARD_CALLBACK_PASS_RELATIVE_HEIGHT);
            }
            if (readableMap.hasKey(KEY_ENABLE_CSS_PARSER)) {
                this.mEnableCSSParser = readableMap.getBoolean(KEY_ENABLE_CSS_PARSER);
            }
            if (readableMap.hasKey(KEY_ENABLE_EVENT_REFACTOR)) {
                this.mEnableEventRefactor = readableMap.getBoolean(KEY_ENABLE_EVENT_REFACTOR);
            }
            if (readableMap.hasKey(KEY_ENABLE_DISEXPOSURE_WHEN_LYNX_HIDDEN)) {
                this.mEnableDisexposureWhenLynxHidden = readableMap.getBoolean(KEY_ENABLE_DISEXPOSURE_WHEN_LYNX_HIDDEN);
            }
            if (readableMap.hasKey(KEY_ENABLE_EXPOSURE_WHEN_LAYOUT)) {
                this.mEnableExposureWhenLayout = readableMap.getBoolean(KEY_ENABLE_EXPOSURE_WHEN_LAYOUT, false);
            }
            if (readableMap.hasKey(KEY_ENABLE_EXPOSURE_WHEN_RELOAD)) {
                this.mEnableExposureWhenReload = readableMap.getBoolean(KEY_ENABLE_EXPOSURE_WHEN_RELOAD, false);
            }
            if (readableMap.hasKey(KEY_ENABLE_NEW_INTERSECTION_OBSERVER)) {
                this.mEnableNewIntersectionObserver = readableMap.getBoolean(KEY_ENABLE_NEW_INTERSECTION_OBSERVER);
            }
            if (readableMap.hasKey(KEY_OBSERVER_FRAME_RATE)) {
                this.mObserverFrameRate = readableMap.getInt(KEY_OBSERVER_FRAME_RATE);
            }
            if (readableMap.hasKey(KEY_ENABLE_EXPOSURE_UI_MARGIN)) {
                this.mEnableExposureUIMargin = readableMap.getBoolean(KEY_ENABLE_EXPOSURE_UI_MARGIN);
            }
            if (readableMap.hasKey(KEY_LONG_PRESS_DURATION)) {
                this.mLongPressDuration = readableMap.getInt(KEY_LONG_PRESS_DURATION);
            }
            if (readableMap.hasKey(KEY_MAP_CONTAINER_TYPE)) {
                this.mMapContainerType = readableMap.getInt(KEY_MAP_CONTAINER_TYPE);
            }
            if (readableMap.hasKey(KEY_PAGE_FLATTEN)) {
                this.mPageFlatten = readableMap.getBoolean(KEY_PAGE_FLATTEN);
            }
            if (readableMap.hasKey(KEY_ENABLE_NEW_GESTURE)) {
                this.mEnableNewGesture = readableMap.getBoolean(KEY_ENABLE_NEW_GESTURE);
            }
            if (readableMap.hasKey(KEY_USER)) {
                this.mUser = readableMap.getString(KEY_USER);
            }
            if (readableMap.hasKey(KEY_GIT)) {
                this.mGit = readableMap.getString(KEY_GIT);
            }
            if (readableMap.hasKey(KEY_FILE_PATH)) {
                this.mFilePath = readableMap.getString(KEY_FILE_PATH);
            }
            if (readableMap.hasKey(KEY_ENABLE_FIBER)) {
                this.mEnableFiber = readableMap.getBoolean(KEY_ENABLE_FIBER);
            }
            if (readableMap.hasKey(KEY_ENABLE_MULTITOUCH)) {
                this.mEnableMultiTouch = readableMap.getBoolean(KEY_ENABLE_MULTITOUCH);
            }
            if (readableMap.hasKey(KEY_ENABLE_LYNX_SCROLL_FLUENCY)) {
                this.mEnableLynxScrollFluency = readableMap.getDouble(KEY_ENABLE_LYNX_SCROLL_FLUENCY);
            }
            if (readableMap.hasKey(KEY_ENABLE_TEXT_LAYOUT_CACHE)) {
                this.mEnableTextLayoutCache = readableMap.getBoolean(KEY_ENABLE_TEXT_LAYOUT_CACHE);
            } else {
                this.mEnableTextLayoutCache = LynxEnv.inst().enableTextLayoutCache();
            }
        }
    }

    public boolean isCssAlignWithLegacyW3c() {
        return this.mCssAlignWithLegacyW3c;
    }

    public void setCssAlignWithLegacyW3c(boolean z) {
        this.mCssAlignWithLegacyW3c = z;
    }

    public boolean isAutoExpose() {
        return this.autoExpose;
    }

    public boolean enableEventThrough() {
        return this.enableEventThrough;
    }

    public String getPageVersion() {
        return this.pageVersion;
    }

    public boolean getDefaultOverflowVisible() {
        return this.defaultOverflowVisible;
    }

    public boolean isAsyncRedirect() {
        return this.asyncRedirect;
    }

    public boolean isSyncImageAttach() {
        return this.syncImageAttach;
    }

    public boolean isEnableCheckLocalImage() {
        return this.enableCheckLocalImage;
    }

    public boolean isEnableAsyncRequestImage() {
        return this.enableAsyncRequestImage;
    }

    public boolean isUseImagePostProcessor() {
        return this.useImagePostProcessor;
    }

    public boolean isEnableLoadImageFromService() {
        return this.enableLoadImageFromService;
    }

    public boolean isUseNewSwiper() {
        return this.useNewSwiper;
    }

    public boolean isAsyncInitTTVideoEngine() {
        return this.mEnableAsyncInitTTVideoEngine;
    }

    public String getPageType() {
        return this.pageType;
    }

    public String getCliVersion() {
        return this.cliVersion;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getTargetSdkVersion() {
        return this.targetSdkVersion;
    }

    public String getLepusVersion() {
        return this.lepusVersion;
    }

    public boolean isEnableLepusNG() {
        return this.enableLepusNG;
    }

    public String getTapSlop() {
        return this.mTapSlop;
    }

    public boolean getEnableCreateViewAsync() {
        return this.mEnableCreateViewAsync;
    }

    public boolean getEnableVsyncAlignedFlush() {
        return this.mEnableVsyncAlignedFlush;
    }

    public boolean getEnableAccessibilityElement() {
        return this.mEnableAccessibilityElement;
    }

    public boolean getEnableOverlapForAccessibilityElement() {
        return this.mEnableOverlapForAccessibilityElement;
    }

    public boolean getEnableNewAccessibility() {
        return this.mEnableNewAccessibility;
    }

    public boolean getEnableA11yIDMutationObserver() {
        return this.mEnableA11yIDMutationObserver;
    }

    public boolean getEnableA11y() {
        return this.mEnableA11y;
    }

    public String getReactVersion() {
        return this.mReactVersion;
    }

    public boolean isTextRefactorEnabled() {
        return this.mEnableTextRefactor;
    }

    public boolean isTextOverflowEnabled() {
        return this.mEnableTextOverflow;
    }

    public boolean isTextBoringLayoutEnabled() {
        return this.mEnableTextBoringLayout;
    }

    public boolean isTextLayoutCacheEnabled() {
        return this.mEnableTextLayoutCache;
    }

    public boolean isNewClipModeEnabled() {
        return this.mEnableNewClipMode;
    }

    public boolean useRelativeKeyboardHeightApi() {
        return this.mKeyboardCallbackUseRelativeHeight;
    }

    public boolean isCSSParserEnabled() {
        return this.mEnableCSSParser;
    }

    public boolean getDefaultTextIncludePadding() {
        return this.mDefaultTextIncludePadding;
    }

    public boolean getEnableFlattenTranslateZ() {
        return this.mEnableFlattenTranslateZ;
    }

    public boolean isEnableNewGesture() {
        return this.mEnableNewGesture;
    }

    public boolean getEnableEventRefactor() {
        return this.mEnableEventRefactor;
    }

    public boolean getEnableDisexposureWhenLynxHidden() {
        return this.mEnableDisexposureWhenLynxHidden;
    }

    public boolean getEnableExposureWhenLayout() {
        return this.mEnableExposureWhenLayout;
    }

    public boolean getEnableExposureWhenReload() {
        return this.mEnableExposureWhenReload;
    }

    public boolean getEnableNewIntersectionObserver() {
        return this.mEnableNewIntersectionObserver;
    }

    public int getObserverFrameRate() {
        return this.mObserverFrameRate;
    }

    public boolean getEnableExposureUIMargin() {
        return this.mEnableExposureUIMargin;
    }

    public int getLongPressDuration() {
        return this.mLongPressDuration;
    }

    public int getMapContainerType() {
        return this.mMapContainerType;
    }

    public boolean isPageFlatten() {
        return this.mPageFlatten;
    }

    public String getUser() {
        return this.mUser;
    }

    public String getGit() {
        return this.mGit;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public boolean getEnableFiberArc() {
        return this.mEnableFiber;
    }

    public boolean getEnableMultiTouch() {
        return this.mEnableMultiTouch;
    }

    public double getEnableLynxScrollFluency() {
        return this.mEnableLynxScrollFluency;
    }

    public String toString() {
        return "PageConfig{autoExpose=" + this.autoExpose + ", pageVersion='" + this.pageVersion + '}';
    }

    public static void attachPageConfig(PageConfig pageConfig, LynxContext lynxContext, ILynxUIRenderer iLynxUIRenderer) {
        if (pageConfig == null) {
            LLog.m2577e(TAG, "PageConfig is null when exec onPageConfigDecoded from TemplateBundle.");
            return;
        }
        if (lynxContext != null) {
            lynxContext.onPageConfigDecoded(pageConfig);
        } else {
            LLog.m2577e(TAG, "lynx context free in used: LynxUI configs may be not valid from TemplateBundle.");
        }
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.onPageConfigDecoded(pageConfig);
        }
    }
}
