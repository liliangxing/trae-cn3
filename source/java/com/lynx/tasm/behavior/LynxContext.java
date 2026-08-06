package com.lynx.tasm.behavior;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.jsbridge.JSModule;
import com.lynx.jsbridge.LynxExtensionModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.EmbeddedMode;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.IListNodeInfoFetcher;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.PageConfig;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxConsumer;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIExposure;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityWrapper;
import com.lynx.tasm.behavior.p000ui.frame.LynxFrameView;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxLayoutProxy;
import com.lynx.tasm.fluency.FluencyTraceHelper;
import com.lynx.tasm.fontface.FontFace;
import com.lynx.tasm.group.ILynxViewRuntimeCacheManager;
import com.lynx.tasm.image.model.LynxImageFetcher;
import com.lynx.tasm.loader.LynxFontFaceLoader;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.provider.LynxProviderRegistry;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import com.lynx.tasm.utils.FontFaceParser;
import com.lynx.tasm.utils.LynxConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LynxContext extends LynxBaseContext implements ExceptionHandler {
    public static final int INSTANCE_ID_DEFAULT = -1;
    private static final String TAG = "LynxContext";
    private static final String UIAPPEAREVENT = "uiappear";
    private static final String UIDISAPPEAREVENT = "uidisappear";
    private static boolean sSupportUsageHint = true;
    private int embeddedMode;
    private LynxFontFaceLoader.Loader fontLoader;
    private LynxGenericResourceFetcher genericResourceFetcher;
    private boolean hasCustomGenericFetcher;
    private boolean hasCustomMediaFetcher;
    private boolean hasCustomTemplateFetcher;
    private boolean isFallbackProcess;
    private ILynxViewRuntimeCacheManager lynxViewGroup;
    private ImageInterceptor mAsyncImageInterceptor;
    private WeakReference<UIBody.UIBodyView> mBodyView;
    private final Map<String, ReadableMap> mCSSFontFaces;
    private JavaOnlyMap mCSSKeyframes;
    private Map<String, Object> mContextData;
    private boolean mEnableAsyncImageCallback;
    private Boolean mEnableAsyncLoadImage;
    private boolean mEnableAutoExpose;
    private boolean mEnableImageResourceHint;
    private boolean mEnableImageSmallDiskCache;
    private boolean mEnableVSyncAligned;
    private EventEmitter mEventEmitter;
    private UIExposure mExposure;
    private Map<String, LynxExtensionModule> mExtensionModules;
    private FluencyTraceHelper mFluencyTraceHelper;
    private Float mFontScale;
    private boolean mForceDarkAllowed;
    private boolean mForceImageAsyncRequest;
    private Object mFrescoCallerContext;
    private Map<String, String> mImageCustomParams;
    private LynxImageFetcher mImageFetcher;
    private ImageInterceptor mImageInterceptor;
    private boolean mInPreLoad;
    private int mInstanceId;
    private WeakReference<LynxIntersectionObserverManager> mIntersectionObserverManager;
    private String mJSGroupThreadName;
    private WeakReference<JSProxy> mJSProxy;
    private WeakReference<LynxLayoutProxy> mLayoutProxy;
    private boolean mLayoutThreadChanged;
    private IListNodeInfoFetcher mListNodeInfoFetcher;
    private LynxBooleanOption mLongTaskMonitorEnabled;
    private Object mLynxExtraData;
    private String mLynxSessionId;
    private WeakReference<LynxUIOwner> mLynxUIOwner;
    private LynxViewClient mLynxViewClient;
    private PageConfig mPageConfig;
    private Map<String, FontFace> mParsedFontFace;
    private List<PatchFinishListener> mPatchFinishListeners;
    private WeakReference<PerformanceController> mPerfController;
    private int mPlatformMeasureHeightCache;
    private int mPlatformMeasureWidthCache;
    private boolean mPrefetchImageOnCreate;
    private WeakReference<ShadowNodeOwner> mShadowNodeOwnerRef;
    private Map<String, Object> mSharedData;
    private String mTemplateUrl;
    private TouchEventDispatcher mTouchEventDispatcher;
    private UIBody mUIBody;
    private DisplayMetrics mVirtualScreenMetrics;
    private LynxMediaResourceFetcher mediaResourceFetcher;
    private LynxProviderRegistry providerRegistry;
    private LynxTemplateResourceFetcher templateResourceFetcher;

    @Deprecated
    public boolean getEnableAutoConcurrency() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ExceptionHandler
    public abstract void handleException(Exception exc);

    @Override // com.lynx.tasm.behavior.ExceptionHandler
    @Deprecated
    public void handleException(Exception exc, int i) {
    }

    @Override // com.lynx.tasm.behavior.ExceptionHandler
    @Deprecated
    public void handleException(Exception exc, int i, JSONObject jSONObject) {
    }

    @Override // com.lynx.tasm.behavior.ExceptionHandler
    public void handleException(Exception exc, JSONObject jSONObject) {
    }

    public void handleLynxError(LynxError lynxError) {
    }

    @Deprecated
    public void setEnableAutoConcurrency(boolean z) {
    }

    @Override // com.lynx.tasm.behavior.LynxBaseContext
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.lynx.tasm.behavior.LynxBaseContext
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.lynx.tasm.behavior.LynxBaseContext, android.content.MutableContextWrapper
    public /* bridge */ /* synthetic */ void setBaseContext(Context context) {
        super.setBaseContext(context);
    }

    public LynxContext(Context context, DisplayMetrics displayMetrics) {
        super(context);
        this.mCSSKeyframes = null;
        this.mCSSFontFaces = new HashMap();
        this.mTouchEventDispatcher = null;
        this.mPerfController = null;
        this.mTemplateUrl = null;
        this.mJSGroupThreadName = null;
        this.mLynxViewClient = null;
        this.mBodyView = null;
        this.mExposure = null;
        this.mFrescoCallerContext = null;
        this.mEnableImageSmallDiskCache = false;
        this.mPrefetchImageOnCreate = false;
        this.mEnableAsyncImageCallback = false;
        this.mEnableImageResourceHint = false;
        this.mLongTaskMonitorEnabled = LynxBooleanOption.UNSET;
        this.mInstanceId = -1;
        this.mForceImageAsyncRequest = false;
        this.mExtensionModules = new HashMap();
        this.embeddedMode = 0;
        this.isFallbackProcess = false;
        this.mLayoutThreadChanged = false;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        this.mVirtualScreenMetrics = displayMetrics2;
        displayMetrics2.setTo(displayMetrics);
    }

    public void setPlatformMeasureHeightCache(int i) {
        this.mPlatformMeasureHeightCache = i;
    }

    public void setPlatformMeasureWidthCache(int i) {
        this.mPlatformMeasureWidthCache = i;
    }

    public int getPlatformMeasureWidthCache() {
        return this.mPlatformMeasureWidthCache;
    }

    public int getPlatformMeasureHeightCache() {
        return this.mPlatformMeasureHeightCache;
    }

    public float getFontScale() {
        if (this.mFontScale == null) {
            this.mFontScale = Float.valueOf(getResources().getConfiguration().fontScale);
        }
        return this.mFontScale.floatValue();
    }

    public boolean enableEventReporter() {
        return !isEmbeddedModeOn();
    }

    public boolean enableTiming() {
        return !isEmbeddedModeOn();
    }

    public boolean isEmbeddedModeOn() {
        return (this.embeddedMode & 1) > 0;
    }

    public boolean isFallbackProcess() {
        return this.isFallbackProcess;
    }

    public void markFallbackProcess(boolean z) {
        this.isFallbackProcess = z;
        if (z || getUIBodyView() == null) {
            return;
        }
        getUIBodyView().clearNodeIndexImageMap();
        getUIBodyView().markNeedRemoveExistingViews();
        getUIBodyView().removeExistingViews();
    }

    public boolean isLayoutInElementModeOn() {
        return (this.embeddedMode & 4) > 0;
    }

    public boolean isFragmentLayerRenderOn() {
        return (this.embeddedMode & 8) > 0;
    }

    public boolean isEnginePoolEnabled() {
        return EmbeddedMode.isEnginePoolEnable(this.embeddedMode);
    }

    public void setEmbeddedMode(int i) {
        this.embeddedMode = i;
    }

    public void setRuntimeCacheManager(ILynxViewRuntimeCacheManager iLynxViewRuntimeCacheManager) {
        this.lynxViewGroup = iLynxViewRuntimeCacheManager;
    }

    public ILynxViewRuntimeCacheManager getRuntimeCacheManager() {
        return this.lynxViewGroup;
    }

    public void setEnableAsyncLoadImage(boolean z) {
        this.mEnableAsyncLoadImage = Boolean.valueOf(z);
    }

    public boolean isEnableAsyncLoadImage() {
        Boolean bool = this.mEnableAsyncLoadImage;
        return bool != null && bool.booleanValue();
    }

    public LynxBooleanOption getLongTaskMonitorEnabled() {
        return this.mLongTaskMonitorEnabled;
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption lynxBooleanOption) {
        this.mLongTaskMonitorEnabled = lynxBooleanOption;
    }

    public void setPerfController(PerformanceController performanceController) {
        if (performanceController != null) {
            this.mPerfController = new WeakReference<>(performanceController);
        }
    }

    public PerformanceController getPerfController() {
        WeakReference<PerformanceController> weakReference = this.mPerfController;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void onPageConfigDecoded(PageConfig pageConfig) {
        this.mPageConfig = pageConfig;
    }

    public void setEnableAutoExpose(boolean z) {
        this.mEnableAutoExpose = z;
    }

    public boolean getAutoExpose() {
        if (!this.mEnableAutoExpose) {
            return false;
        }
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig == null) {
            LLog.e(TAG, "PageConfig is null.GetAutoExpose get default true!");
            return true;
        }
        return pageConfig.isAutoExpose();
    }

    public String getPageVersion() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig == null) {
            LLog.e(TAG, "PageConfig is null.GetPageVersion get default error;");
            return "error";
        }
        return pageConfig.getPageVersion();
    }

    public double getEnableLynxScrollFluency() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableLynxScrollFluency();
        }
        return -1.0d;
    }

    public boolean getEnableVsyncAlignedFlush() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableVsyncAlignedFlush();
        }
        return false;
    }

    public boolean isAsyncRedirect() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isAsyncRedirect();
        }
        return false;
    }

    public boolean isSyncImageAttach() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isSyncImageAttach();
        }
        return true;
    }

    public boolean isPrefetchImageOnCreate() {
        return this.mPrefetchImageOnCreate;
    }

    public boolean isEnableCheckLocalImage() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isEnableCheckLocalImage();
        }
        return true;
    }

    public boolean isEnableAsyncRequestImage() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isEnableAsyncRequestImage();
        }
        return false;
    }

    public boolean isEnableAsyncImageCallback() {
        return this.mEnableAsyncImageCallback;
    }

    public boolean isForceImageAsyncRequest() {
        return this.mForceImageAsyncRequest;
    }

    public boolean isUseImagePostProcessor() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isUseImagePostProcessor();
        }
        return false;
    }

    public boolean getEnableLoadImageFromService() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isEnableLoadImageFromService();
        }
        return true;
    }

    public boolean getDefaultOverflowVisible() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getDefaultOverflowVisible();
        }
        return false;
    }

    public boolean isAsyncInitTTVideoEngine() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isAsyncInitTTVideoEngine();
        }
        return false;
    }

    public boolean getEnableFiberArch() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableFiberArc();
        }
        return false;
    }

    public boolean getCssAlignWithLegacyW3c() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isCssAlignWithLegacyW3c();
        }
        return false;
    }

    public boolean isEnableNewGesture() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isEnableNewGesture();
        }
        return false;
    }

    public FluencyTraceHelper getFluencyTraceHelper() {
        if (this.mFluencyTraceHelper == null) {
            this.mFluencyTraceHelper = new FluencyTraceHelper(this);
        }
        return this.mFluencyTraceHelper;
    }

    public DisplayMetrics getScreenMetrics() {
        return this.mVirtualScreenMetrics;
    }

    public void updateScreenSize(int i, int i2) {
        this.mVirtualScreenMetrics.widthPixels = i;
        this.mVirtualScreenMetrics.heightPixels = i2;
        UIExposure uIExposure = this.mExposure;
        if (uIExposure != null) {
            uIExposure.updateWindowSize(this);
        }
    }

    public void setImageInterceptor(ImageInterceptor imageInterceptor) {
        this.mImageInterceptor = imageInterceptor;
    }

    public void setAsyncImageInterceptor(ImageInterceptor imageInterceptor) {
        this.mAsyncImageInterceptor = imageInterceptor;
    }

    public ImageInterceptor imageInterceptor() {
        return this.mImageInterceptor;
    }

    public ImageInterceptor getAsyncImageInterceptor() {
        return this.mAsyncImageInterceptor;
    }

    public boolean getEnableImageSmallDiskCache() {
        return this.mEnableImageSmallDiskCache;
    }

    public void setEnableImageSmallDiskCache(boolean z) {
        this.mEnableImageSmallDiskCache = z;
    }

    public void setPrefetchImageOnCreate(boolean z) {
        this.mPrefetchImageOnCreate = z;
    }

    public void setEnableAsyncImageCallback(boolean z) {
        this.mEnableAsyncImageCallback = z;
    }

    public void setForceImageAsyncRequest(boolean z) {
        this.mForceImageAsyncRequest = z;
    }

    public void setLynxViewClient(LynxViewClient lynxViewClient) {
        this.mLynxViewClient = lynxViewClient;
    }

    public LynxViewClient getLynxViewClient() {
        return this.mLynxViewClient;
    }

    private void updateLynxSessionID(UIBody.UIBodyView uIBodyView) {
        TraceEvent.beginSection("LynxContext.updateLynxSessionID");
        this.mLynxSessionId = String.valueOf(System.currentTimeMillis()) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(System.identityHashCode(uIBodyView));
        TraceEvent.endSection("LynxContext.updateLynxSessionID");
    }

    @Deprecated
    public void setLynxView(LynxView lynxView) {
        setUIBodyView(lynxView);
    }

    public void setUIBodyView(UIBody.UIBodyView uIBodyView) {
        setHasLynxViewAttached(uIBodyView != null);
        LLog.i("LynxUIRenderer", "lynxContext setUIBodyView" + uIBodyView + this);
        this.mBodyView = new WeakReference<>(uIBodyView);
        if (TextUtils.isEmpty(this.mLynxSessionId)) {
            updateLynxSessionID(uIBodyView);
        }
    }

    public String getLynxSessionID() {
        String str = this.mLynxSessionId;
        return str == null ? "" : str;
    }

    public LynxView getLynxView() {
        LynxView uIBodyView = getUIBodyView();
        if (uIBodyView instanceof LynxView) {
            return uIBodyView;
        }
        if (uIBodyView instanceof LynxFrameView) {
            return ((LynxFrameView) uIBodyView).getRootView();
        }
        return null;
    }

    public UIBody.UIBodyView getUIBodyView() {
        WeakReference<UIBody.UIBodyView> weakReference = this.mBodyView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Deprecated
    public void reportResourceError(String str) {
        LynxViewClient lynxViewClient = this.mLynxViewClient;
        if (lynxViewClient != null) {
            lynxViewClient.onReceivedError(new LynxError(str, 39800));
        }
    }

    public void reportResourceError(String str, String str2, String str3) {
        reportResourceError(39800, str, str2, str3);
    }

    public void reportResourceError(int i, String str, String str2, String str3) {
        reportResourceError(str, str2, new LynxError(i, str3));
    }

    public void reportResourceError(String str, String str2, LynxError lynxError) {
        if (this.mLynxViewClient == null || lynxError == null) {
            return;
        }
        lynxError.setTemplateUrl(this.mTemplateUrl);
        lynxError.addCustomInfo(PropsConstants.SRC, str);
        lynxError.addCustomInfo(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, str2);
        this.mLynxViewClient.onReceivedError(lynxError);
    }

    public void setTouchEventDispatcher(TouchEventDispatcher touchEventDispatcher) {
        this.mTouchEventDispatcher = touchEventDispatcher;
    }

    public TouchEventDispatcher getTouchEventDispatcher() {
        return this.mTouchEventDispatcher;
    }

    public void onGestureRecognized() {
        TouchEventDispatcher touchEventDispatcher = this.mTouchEventDispatcher;
        if (touchEventDispatcher != null) {
            touchEventDispatcher.onGestureRecognized();
        }
    }

    public void onGestureRecognized(int i) {
        TouchEventDispatcher touchEventDispatcher = this.mTouchEventDispatcher;
        if (touchEventDispatcher != null) {
            touchEventDispatcher.onGestureRecognized(i);
        }
    }

    public void onGestureRecognized(LynxBaseUI lynxBaseUI) {
        TouchEventDispatcher touchEventDispatcher = this.mTouchEventDispatcher;
        if (touchEventDispatcher != null) {
            touchEventDispatcher.onGestureRecognized(lynxBaseUI);
        }
    }

    public void onPropsChanged(LynxBaseUI lynxBaseUI) {
        TouchEventDispatcher touchEventDispatcher = this.mTouchEventDispatcher;
        if (touchEventDispatcher != null) {
            touchEventDispatcher.onPropsChanged(lynxBaseUI);
        }
    }

    public boolean isTouchMoving() {
        TouchEventDispatcher touchEventDispatcher = this.mTouchEventDispatcher;
        if (touchEventDispatcher != null) {
            return touchEventDispatcher.isTouchMoving();
        }
        return false;
    }

    public void setEventEmitter(EventEmitter eventEmitter) {
        this.mEventEmitter = eventEmitter;
    }

    public EventEmitter getEventEmitter() {
        return this.mEventEmitter;
    }

    public IListNodeInfoFetcher getListNodeInfoFetcher() {
        return this.mListNodeInfoFetcher;
    }

    public void setListNodeInfoFetcher(IListNodeInfoFetcher iListNodeInfoFetcher) {
        this.mListNodeInfoFetcher = iListNodeInfoFetcher;
    }

    public void setIntersectionObserverManager(LynxIntersectionObserverManager lynxIntersectionObserverManager) {
        this.mIntersectionObserverManager = new WeakReference<>(lynxIntersectionObserverManager);
    }

    public LynxIntersectionObserverManager getIntersectionObserverManager() {
        WeakReference<LynxIntersectionObserverManager> weakReference = this.mIntersectionObserverManager;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public Long getRuntimeId() {
        JSProxy jSProxy = this.mJSProxy.get();
        if (jSProxy != null) {
            return Long.valueOf(jSProxy.getRuntimeId());
        }
        return null;
    }

    public void setJSProxy(JSProxy jSProxy) {
        this.mJSProxy = new WeakReference<>(jSProxy);
    }

    public void setLayoutProxy(LynxLayoutProxy lynxLayoutProxy) {
        this.mLayoutProxy = new WeakReference<>(lynxLayoutProxy);
    }

    public JSModule getJSModule(String str) {
        JSProxy jSProxy;
        WeakReference<JSProxy> weakReference = this.mJSProxy;
        if (weakReference == null || (jSProxy = weakReference.get()) == null) {
            return null;
        }
        return jSProxy.getJSModule(str);
    }

    public void sendKeyEvent(int i, String str) {
        JSModule jSModule = getJSModule("GlobalEventEmitter");
        if (jSModule == null) {
            LLog.e(LynxConstants.TAG, "sendGlobalEvent error, can't get GlobalEventEmitter");
            return;
        }
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        javaOnlyArray.pushString(str);
        JavaOnlyArray javaOnlyArray2 = new JavaOnlyArray();
        javaOnlyArray2.pushString(str);
        javaOnlyArray2.pushInt(i);
        javaOnlyArray.pushArray(javaOnlyArray2);
        jSModule.fire("emit", javaOnlyArray);
    }

    public void sendGlobalEvent(String str, JavaOnlyArray javaOnlyArray) {
        LLog.i(TAG, "LynxContext sendGlobalEvent " + str + " with this: " + toString());
        JSModule jSModule = getJSModule("GlobalEventEmitter");
        if (jSModule == null) {
            LLog.e(TAG, "LynxContext sendGlobalEvent failed since eventEmitter is null with this: " + toString());
            return;
        }
        JavaOnlyArray javaOnlyArray2 = new JavaOnlyArray();
        javaOnlyArray2.pushString(str);
        javaOnlyArray2.pushArray(javaOnlyArray);
        if (jSModule != null) {
            jSModule.fire("emit", javaOnlyArray2);
        } else {
            LLog.e(LynxConstants.TAG, "sendGlobalEvent error, can't get GlobalEventEmitter");
        }
    }

    public void removeAnimationKeyframe(String str) {
        JavaOnlyMap javaOnlyMap = this.mCSSKeyframes;
        if (javaOnlyMap != null) {
            javaOnlyMap.remove(str);
        }
    }

    public void setKeyframes(ReadableMap readableMap) {
        if (this.mCSSKeyframes == null) {
            this.mCSSKeyframes = new JavaOnlyMap();
        }
        if (readableMap != null) {
            this.mCSSKeyframes.merge(readableMap);
        }
    }

    public void setFontFaces(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        synchronized (this.mCSSFontFaces) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                ReadableMap map = readableMap.getMap(nextKey);
                if (map != null) {
                    this.mCSSFontFaces.put(nextKey, map);
                }
            }
        }
    }

    public ReadableMap getKeyframes(String str) {
        JavaOnlyMap javaOnlyMap = this.mCSSKeyframes;
        if (javaOnlyMap != null && javaOnlyMap.hasKey(str)) {
            return this.mCSSKeyframes.getMap(str);
        }
        return null;
    }

    public Map getFontFaces(String str) {
        synchronized (this.mCSSFontFaces) {
            ReadableMap readableMap = this.mCSSFontFaces.containsKey(str) ? this.mCSSFontFaces.get(str) : null;
            if (readableMap != null) {
                return readableMap.asHashMap();
            }
            return null;
        }
    }

    public FontFace getFontFace(String str) {
        for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            String trim = FontFaceParser.trim(str2);
            if (!TextUtils.isEmpty(trim)) {
                synchronized (FontFaceParser.class) {
                    if (this.mParsedFontFace == null) {
                        this.mParsedFontFace = new HashMap();
                    }
                    FontFace fontFace = this.mParsedFontFace.get(trim);
                    if (fontFace != null) {
                        return fontFace;
                    }
                    FontFace parse = FontFaceParser.parse(this, trim);
                    if (parse != null) {
                        this.mParsedFontFace.put(trim, parse);
                        return parse;
                    }
                }
            }
        }
        return null;
    }

    public String getTemplateUrl() {
        return this.mTemplateUrl;
    }

    public String getJSGroupThreadName() {
        return this.mJSGroupThreadName;
    }

    public void setTemplateUrl(String str) {
        this.mTemplateUrl = str;
    }

    public void setJSGroupThreadName(String str) {
        this.mJSGroupThreadName = str;
    }

    public void setLynxUIOwner(LynxUIOwner lynxUIOwner) {
        this.mLynxUIOwner = new WeakReference<>(lynxUIOwner);
    }

    public UIExposure getExposure() {
        return this.mExposure;
    }

    public LynxUIOwner getLynxUIOwner() {
        return this.mLynxUIOwner.get();
    }

    public LynxBaseUI findLynxUIByName(String str) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner.get();
        if (lynxUIOwner != null) {
            return lynxUIOwner.findLynxUIByName(str);
        }
        return null;
    }

    public UIBody getUIBody() {
        return this.mUIBody;
    }

    public void setUIBody(UIBody uIBody) {
        this.mUIBody = uIBody;
    }

    public void putSharedData(String str, Object obj) {
        if (this.mSharedData == null) {
            this.mSharedData = new HashMap();
        }
        this.mSharedData.put(str, obj);
    }

    public Object getSharedData(String str) {
        Map<String, Object> map = this.mSharedData;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public <T> T getSharedData(String str, Class<T> cls) {
        Map<String, Object> map = this.mSharedData;
        if (map == null) {
            return null;
        }
        Object obj = map.get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public LynxBaseUI findLynxUIByIdSelector(String str, LynxBaseUI lynxBaseUI) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner.get();
        if (lynxUIOwner != null) {
            return lynxUIOwner.findLynxUIByIdSelector(str, lynxBaseUI);
        }
        return null;
    }

    public LynxBaseUI findLynxUIBySign(int i) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner.get();
        if (lynxUIOwner != null) {
            return lynxUIOwner.getNode(i);
        }
        return null;
    }

    public LynxBaseUI findLynxUIByComponentId(String str) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner.get();
        if (lynxUIOwner != null) {
            return lynxUIOwner.findLynxUIByComponentId(str);
        }
        return null;
    }

    public void invokeUIMethod(String str, ReadableArray readableArray, String str2, ReadableMap readableMap, Callback callback) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner.get();
        if (lynxUIOwner != null) {
            lynxUIOwner.invokeUIMethod(str, readableArray, str2, readableMap, callback);
        }
    }

    public void reportModuleCustomError(String str) {
        this.mLynxViewClient.onReceivedError(new LynxError(str, 99800));
    }

    public void setShadowNodeOwner(ShadowNodeOwner shadowNodeOwner) {
        this.mShadowNodeOwnerRef = new WeakReference<>(shadowNodeOwner);
    }

    public ShadowNode findShadowNodeBySign(int i) {
        ShadowNodeOwner shadowNodeOwner = this.mShadowNodeOwnerRef.get();
        if (shadowNodeOwner != null) {
            return shadowNodeOwner.getShadowNode(i);
        }
        return null;
    }

    public void findShadowNodeAndRunTask(final int i, final LynxConsumer<ShadowNode> lynxConsumer) {
        runOnLayoutThread(new Runnable() { // from class: com.lynx.tasm.behavior.LynxContext$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LynxContext.this.m0x9dc4500(i, lynxConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$findShadowNodeAndRunTask$0$com-lynx-tasm-behavior-LynxContext */
    public /* synthetic */ void m0x9dc4500(int i, LynxConsumer lynxConsumer) {
        ShadowNodeOwner shadowNodeOwner = this.mShadowNodeOwnerRef.get();
        if (shadowNodeOwner != null) {
            lynxConsumer.accept(shadowNodeOwner.getShadowNode(i));
        }
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        LynxView lynxView = getLynxView();
        if (lynxView != null) {
            return lynxView.getBaseInspectorOwner();
        }
        return null;
    }

    public void setProviderRegistry(LynxProviderRegistry lynxProviderRegistry) {
        this.providerRegistry = lynxProviderRegistry;
    }

    public LynxProviderRegistry getProviderRegistry() {
        return this.providerRegistry;
    }

    public void setGenericResourceFetcher(LynxGenericResourceFetcher lynxGenericResourceFetcher) {
        this.genericResourceFetcher = lynxGenericResourceFetcher;
    }

    public LynxGenericResourceFetcher getGenericResourceFetcher() {
        if (this.hasCustomGenericFetcher) {
            return null;
        }
        return this.genericResourceFetcher;
    }

    public void setMediaResourceFetcher(LynxMediaResourceFetcher lynxMediaResourceFetcher) {
        this.mediaResourceFetcher = lynxMediaResourceFetcher;
    }

    public LynxMediaResourceFetcher getMediaResourceFetcher() {
        if (this.hasCustomMediaFetcher) {
            return null;
        }
        return this.mediaResourceFetcher;
    }

    public void setTemplateResourceFetcher(LynxTemplateResourceFetcher lynxTemplateResourceFetcher) {
        this.templateResourceFetcher = lynxTemplateResourceFetcher;
    }

    public LynxTemplateResourceFetcher getTemplateResourceFetcher() {
        if (this.hasCustomTemplateFetcher) {
            return null;
        }
        return this.templateResourceFetcher;
    }

    public void setHasCustomGenericFetcher(boolean z) {
        LLog.i(TAG, "setHasCustomGenericFetcher: " + z);
        this.hasCustomGenericFetcher = z;
    }

    public void setHasCustomMediaFetcher(boolean z) {
        LLog.i(TAG, "setHasCustomMediaFetcher: " + z);
        this.hasCustomMediaFetcher = z;
    }

    public void setHasCustomTemplateFetcher(boolean z) {
        LLog.i(TAG, "setHasCustomTemplateFetcher: " + z);
        this.hasCustomTemplateFetcher = z;
    }

    public void setFontLoader(LynxFontFaceLoader.Loader loader) {
        this.fontLoader = loader;
    }

    public LynxFontFaceLoader.Loader getFontLoader() {
        return this.fontLoader;
    }

    public Object getFrescoCallerContext() {
        return this.mFrescoCallerContext;
    }

    public void setFrescoCallerContext(Object obj) {
        this.mFrescoCallerContext = obj;
    }

    public void runOnTasmThread(Runnable runnable) {
        UIBody.UIBodyView uIBodyView = getUIBodyView();
        if (uIBodyView != null) {
            uIBodyView.runOnTasmThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerPatchFinishListener(PatchFinishListener patchFinishListener) {
        if (this.mPatchFinishListeners == null) {
            this.mPatchFinishListeners = new ArrayList();
        }
        this.mPatchFinishListeners.add(patchFinishListener);
    }

    public void unregisterPatchFinishListener(PatchFinishListener patchFinishListener) {
        List<PatchFinishListener> list = this.mPatchFinishListeners;
        if (list != null) {
            list.remove(patchFinishListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<PatchFinishListener> getPatchFinishListeners() {
        return this.mPatchFinishListeners;
    }

    public boolean isTextRefactorEnabled() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isTextRefactorEnabled();
        }
        return false;
    }

    public boolean isNewClipModeEnabled() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isNewClipModeEnabled();
        }
        return false;
    }

    public boolean isTextOverflowEnabled() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isTextOverflowEnabled();
        }
        return false;
    }

    public boolean isTextBoringLayoutEnabled() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isTextBoringLayoutEnabled();
        }
        return false;
    }

    public boolean isTextLayoutCacheEnabled() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isTextLayoutCacheEnabled();
        }
        return true;
    }

    public boolean useRelativeKeyboardHeightApi() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.useRelativeKeyboardHeightApi();
        }
        return false;
    }

    public boolean getDefaultTextIncludePadding() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getDefaultTextIncludePadding();
        }
        return false;
    }

    public boolean getEnableEventRefactor() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableEventRefactor();
        }
        return true;
    }

    public boolean getEnableDisexposureWhenLynxHidden() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableDisexposureWhenLynxHidden();
        }
        return true;
    }

    public boolean getEnableExposureWhenLayout() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableExposureWhenLayout();
        }
        return false;
    }

    public boolean getEnableExposureWhenReload() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableExposureWhenReload();
        }
        return false;
    }

    public void reset() {
        WeakReference<LynxIntersectionObserverManager> weakReference;
        LynxIntersectionObserverManager lynxIntersectionObserverManager;
        synchronized (this.mCSSFontFaces) {
            this.mCSSFontFaces.clear();
        }
        TouchEventDispatcher touchEventDispatcher = this.mTouchEventDispatcher;
        if (touchEventDispatcher != null) {
            touchEventDispatcher.reset();
        }
        UIExposure uIExposure = this.mExposure;
        if (uIExposure != null) {
            uIExposure.clear();
        }
        if (!getEnableNewIntersectionObserver() || (weakReference = this.mIntersectionObserverManager) == null || (lynxIntersectionObserverManager = weakReference.get()) == null) {
            return;
        }
        lynxIntersectionObserverManager.clear();
    }

    public void destory() {
        WeakReference<LynxIntersectionObserverManager> weakReference;
        LynxIntersectionObserverManager lynxIntersectionObserverManager;
        UIExposure uIExposure = this.mExposure;
        if (uIExposure != null) {
            uIExposure.clear();
        }
        if (!getEnableNewIntersectionObserver() || (weakReference = this.mIntersectionObserverManager) == null || (lynxIntersectionObserverManager = weakReference.get()) == null) {
            return;
        }
        lynxIntersectionObserverManager.clear();
    }

    public void clearExposure() {
        UIExposure uIExposure = this.mExposure;
        if (uIExposure != null) {
            uIExposure.clear();
        }
    }

    public void stopExposure() {
        UIExposure uIExposure = this.mExposure;
        if (uIExposure != null) {
            uIExposure.stopExposure(null);
        }
    }

    public void resumeExposure() {
        UIExposure uIExposure = this.mExposure;
        if (uIExposure != null) {
            uIExposure.resumeExposure();
        }
    }

    public void addUIToExposedMap(LynxBaseUI lynxBaseUI) {
        addUIToExposedMap(lynxBaseUI, null, null, null);
    }

    public void addUIToExposedMap(LynxBaseUI lynxBaseUI, String str, JavaOnlyMap javaOnlyMap, JavaOnlyMap javaOnlyMap2) {
        if (str == null && lynxBaseUI.getEvents() != null && (lynxBaseUI.getEvents().containsKey(UIAPPEAREVENT) || lynxBaseUI.getEvents().containsKey(UIDISAPPEAREVENT))) {
            if (this.mExposure == null) {
                initUIExposure();
            }
            JavaOnlyMap javaOnlyMap3 = new JavaOnlyMap();
            javaOnlyMap3.put("sendCustom", true);
            this.mExposure.addUIToExposedMap(lynxBaseUI, String.valueOf(lynxBaseUI.getSign()), null, javaOnlyMap3);
        }
        if (str == null && lynxBaseUI.getExposureID() == null) {
            return;
        }
        if (this.mExposure == null) {
            initUIExposure();
        }
        this.mExposure.addUIToExposedMap(lynxBaseUI, str, javaOnlyMap, javaOnlyMap2);
    }

    public void removeUIFromExposedMap(LynxBaseUI lynxBaseUI) {
        removeUIFromExposedMap(lynxBaseUI, null);
    }

    public void removeUIFromExposedMap(LynxBaseUI lynxBaseUI, String str) {
        if (str == null && lynxBaseUI.getEvents() != null && (lynxBaseUI.getEvents().containsKey(UIAPPEAREVENT) || lynxBaseUI.getEvents().containsKey(UIDISAPPEAREVENT))) {
            if (this.mExposure == null) {
                initUIExposure();
            }
            this.mExposure.removeUIFromExposedMap(lynxBaseUI, String.valueOf(lynxBaseUI.getSign()));
        }
        if (str == null && lynxBaseUI.getExposureID() == null) {
            return;
        }
        if (this.mExposure == null) {
            initUIExposure();
        }
        this.mExposure.removeUIFromExposedMap(lynxBaseUI, str);
    }

    public void onRootViewDraw(Canvas canvas) {
        WeakReference<LynxIntersectionObserverManager> weakReference;
        LynxIntersectionObserverManager lynxIntersectionObserverManager;
        UIExposure uIExposure = this.mExposure;
        if (uIExposure != null) {
            uIExposure.onRootViewDraw(canvas);
        }
        if (!getEnableNewIntersectionObserver() || (weakReference = this.mIntersectionObserverManager) == null || (lynxIntersectionObserverManager = weakReference.get()) == null) {
            return;
        }
        lynxIntersectionObserverManager.onRootViewDraw(canvas);
    }

    public void onAttachedToWindow() {
        UIExposure uIExposure = this.mExposure;
        if (uIExposure != null) {
            uIExposure.onAttachedToWindow();
        }
    }

    public boolean getEnableFlattenTranslateZ() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableFlattenTranslateZ();
        }
        return false;
    }

    public boolean enableEventThrough() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.enableEventThrough();
        }
        return false;
    }

    public boolean getEnableNewIntersectionObserver() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableNewIntersectionObserver();
        }
        return false;
    }

    public boolean getEnableCreateViewAsync() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableCreateViewAsync();
        }
        return false;
    }

    public boolean isUseNewSwiper() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.isUseNewSwiper();
        }
        return false;
    }

    public int getObserverFrameRate() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getObserverFrameRate();
        }
        return 20;
    }

    public boolean getEnableExposureUIMargin() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getEnableExposureUIMargin();
        }
        return false;
    }

    public int getLongPressDuration() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getLongPressDuration();
        }
        return -1;
    }

    public int getMapContainerType() {
        PageConfig pageConfig = this.mPageConfig;
        if (pageConfig != null) {
            return pageConfig.getMapContainerType();
        }
        return 0;
    }

    public LynxAccessibilityWrapper getLynxAccessibilityWrapper() {
        UIBody uIBody = this.mUIBody;
        if (uIBody != null) {
            return uIBody.getLynxAccessibilityWrapper();
        }
        return null;
    }

    public void setContextData(HashMap<String, Object> hashMap) {
        this.mContextData = hashMap;
    }

    public Map getContextData() {
        return this.mContextData;
    }

    public int getInstanceId() {
        return this.mInstanceId;
    }

    public void setInstanceId(int i) {
        this.mInstanceId = i;
    }

    public void setInPreLoad(boolean z) {
        this.mInPreLoad = z;
        EventEmitter eventEmitter = this.mEventEmitter;
        if (eventEmitter != null) {
            eventEmitter.setInPreLoad(z);
        }
    }

    public void setEnableImageResourceHint(boolean z) {
        this.mEnableImageResourceHint = z;
    }

    public boolean getEnableImageResourceHint() {
        return this.mEnableImageResourceHint;
    }

    public void setImageCustomParam(Map<String, String> map) {
        this.mImageCustomParams = map;
    }

    public Map<String, String> getImageCustomParam() {
        return this.mImageCustomParams;
    }

    public void setImageFetcher(LynxImageFetcher lynxImageFetcher) {
        this.mImageFetcher = lynxImageFetcher;
    }

    public LynxImageFetcher getImageFetcher() {
        return this.mImageFetcher;
    }

    public void setLynxExtraData(Object obj) {
        this.mLynxExtraData = obj;
    }

    public Object getLynxExtraData() {
        return this.mLynxExtraData;
    }

    public boolean isInPreLoad() {
        return this.mInPreLoad;
    }

    public void runOnJSThread(Runnable runnable) {
        JSProxy jSProxy;
        if (runnable == null || (jSProxy = this.mJSProxy.get()) == null) {
            return;
        }
        jSProxy.runOnJSThread(runnable);
    }

    public void runOnLayoutThread(Runnable runnable) {
        LynxLayoutProxy lynxLayoutProxy;
        if (runnable == null || (lynxLayoutProxy = this.mLayoutProxy.get()) == null) {
            return;
        }
        lynxLayoutProxy.runOnLayoutThread(runnable);
    }

    public void setForceDarkAllowed(boolean z) {
        this.mForceDarkAllowed = z;
        if (z && Build.VERSION.SDK_INT >= 29 && sSupportUsageHint && LynxFlattenUI.sSetUsageHint == null) {
            try {
                LynxFlattenUI.sSetUsageHint = RenderNode.class.getMethod("setUsageHint", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                sSupportUsageHint = false;
                LLog.e(TAG, "NoSuchMethodException: setUsageHint");
            }
        }
    }

    public boolean getForceDarkAllowed() {
        return this.mForceDarkAllowed;
    }

    public void initUIExposure() {
        this.mExposure = new UIExposure();
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner.get();
        if (lynxUIOwner != null) {
            this.mExposure.setRootUI(lynxUIOwner.getRootUI());
        }
        this.mExposure.setCallback(new UIExposure.ExposureCallback(new WeakReference(this)));
        this.mExposure.updateWindowSize(this);
    }

    public void EnsureEventDispatcher() {
        UIBody.UIBodyView uIBodyView;
        ILynxUIRenderer lynxUIRendererInternal;
        if (this.mTouchEventDispatcher == null && (uIBodyView = getUIBodyView()) != null && (lynxUIRendererInternal = uIBodyView.getLynxUIRendererInternal()) != null && (lynxUIRendererInternal instanceof LynxUIRenderer)) {
            ((LynxUIRenderer) lynxUIRendererInternal).EnsureEventDispatcher();
        }
    }

    public void setExtensionModuleForKey(LynxExtensionModule lynxExtensionModule, String str) {
        if (lynxExtensionModule == null) {
            return;
        }
        this.mExtensionModules.put(str, lynxExtensionModule);
    }

    public LynxExtensionModule getExtensionModuleByKey(String str) {
        return this.mExtensionModules.get(str);
    }

    public Map<String, LynxExtensionModule> getExtensionModules() {
        return this.mExtensionModules;
    }

    public void setEnableVSyncAligned(boolean z) {
        this.mEnableVSyncAligned = z;
    }

    public boolean getEnableVSyncAligned() {
        return this.mEnableVSyncAligned;
    }

    public boolean hasLayoutThreadChanged() {
        return this.mLayoutThreadChanged;
    }

    public void setLayoutThreadChanged(boolean z) {
        this.mLayoutThreadChanged = z;
    }
}
