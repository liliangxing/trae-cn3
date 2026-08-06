package com.lynx.tasm;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper;
import com.lynx.jsbridge.JSModule;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxExposureModule;
import com.lynx.jsbridge.LynxExtensionModule;
import com.lynx.jsbridge.LynxFetchModule;
import com.lynx.jsbridge.LynxIntersectionObserverModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.jsbridge.LynxSetModule;
import com.lynx.jsbridge.LynxTextInfoModule;
import com.lynx.jsbridge.LynxUIMethodModule;
import com.lynx.jsbridge.RuntimeLifecycleListener;
import com.lynx.jsbridge.network.LynxFetchModuleEventSender;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxEngine;
import com.lynx.tasm.LynxLoadMeta;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxViewClientV2;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.TimingHandler;
import com.lynx.tasm.base.CleanupReference;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxPageLoadListener;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxIntersectionObserverManager;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.herotransition.HeroTransitionManager;
import com.lynx.tasm.behavior.shadow.ChoreographerLayoutTick;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ViewLayoutTick;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.common.LepusBuffer;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.LynxLayoutProxy;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.group.ILynxViewConfigProvider;
import com.lynx.tasm.group.ILynxViewGroup;
import com.lynx.tasm.group.ILynxViewRuntimeCacheManager;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.performance.TimingOption;
import com.lynx.tasm.performance.longtasktiming.LynxLongTaskMonitor;
import com.lynx.tasm.provider.AbsTemplateProvider;
import com.lynx.tasm.provider.LynxProviderRegistry;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.provider.ThemeResourceProvider;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import com.lynx.tasm.resourceprovider.template.TemplateProviderResult;
import com.lynx.tasm.service.ILynxExtensionService;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.service.security.ILynxSecurityService;
import com.lynx.tasm.service.security.SecurityResult;
import com.lynx.tasm.theme.LynxTheme;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.ContextUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.LynxViewBuilderProperty;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxTemplateRender implements ILynxEngine, ILynxErrorReceiver, EventEmitter.LynxEventFallback {
    private static final String EVENT_NAME_LYNX_OPEN_PAGE = "lynxsdk_open_page";
    public static final String RENDER_PHASE_SETUP = "setup";
    public static final String RENDER_PHASE_UPDATE = "update";
    private static final String TAG = "LynxTemplateRender";
    private static final boolean VSYNC_ALIGNED_FLUSH_EXP_SWITCH = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.VSYNC_ALIGNED_FLUSH_EXP_KEY, false);
    private List<Map<String, Object>> componentsData;
    private TemplateData globalProps;
    private boolean mAsyncRender;
    protected UIBody.UIBodyView mBodyView;
    protected String mBytecodeSourceUrl;
    private ILynxViewRuntimeCacheManager mCacheManager;
    private Context mContext;
    private LynxDevtool mDevTool;
    private int mEmbeddedMode;
    private boolean mEnableAirStrictMode;
    private boolean mEnableJSRuntime;
    private boolean mEnableReuseEngine;
    private boolean mEnableSyncFlush;
    private LynxEngineProxy mEngineProxy;
    private LynxGroup mGroup;
    private boolean mHasEnvPrepared;
    private boolean mHasPageStart;
    private long mInitEnd;
    private long mInitStart;
    private LynxIntersectionObserverManager mIntersectionObserverManager;
    private boolean mIsEngineFromReuse;
    private JSProxy mJSProxy;
    private LynxLayoutProxy mLayoutProxy;
    private LynxResourceLoader mLoader;
    private ILynxLogicExecutor mLogicExecutor;
    private LynxContext mLynxContext;
    private LynxEngine mLynxEngineRef;
    private LynxBackgroundRuntimeOptions mLynxRuntimeOptions;
    private ILynxUIRenderer mLynxUIRender;
    private LynxViewBuilder mLynxViewBuilder;
    private ILynxViewConfigProvider mLynxViewConfigProvider;
    private ILynxViewGroup mLynxViewGroup;
    private LynxModuleFactory mMainThreadModuleFactory;
    private boolean mMarkEngineInUseFlag;
    protected LynxModuleFactory mModuleFactory;
    private NativeFacade mNativeFacade;
    private long mNativeLifecycle;
    private Map<String, String> mOriginLynxViewConfig;
    private InnerPageLoadListener mPageLoadListener;
    private int mPreHeightMeasureSpec;
    private int mPreWidthMeasureSpec;
    private LynxResourceLoader mResourceLoader;
    private LynxBackgroundRuntime mRuntime;
    private LynxSSRHelper mSSRHelper;
    private WeakReference<TasmPlatformInvoker> mTasmPlatformInvoker;
    private TemplateBundle mTemplateBundle;
    private AbsTemplateProvider mTemplateProvider;
    private LynxTheme mTheme;
    private ThreadStrategyForRendering mThreadStrategyForRendering;
    private String mUrl;
    private ViewLayoutTick mViewLayoutTick;
    private boolean mWillContentSizeChange;
    private final TemplateAssembler mTemplateAssembler = new TemplateAssembler();
    private volatile boolean reload = false;
    private boolean mHasDestroy = false;
    private final LynxViewClientGroup mClient = new LynxViewClientGroup();
    private final LynxViewClientGroupV2 mClientV2 = new LynxViewClientGroupV2();
    private long mFirstMeasureTime = -1;
    private List<TemplateData> updatedDataList = new CopyOnWriteArrayList();
    private volatile boolean mIsMemoryCollecting = false;
    protected boolean mEnableBytecode = false;
    private boolean mEnablePendingJsTask = false;
    private boolean mEnableGenericResourceFetcher = false;
    private boolean mShouldUpdateViewport = true;
    private float mFontScale = 1.0f;
    private LynxBooleanOption mLongTaskMonitorEnabled = LynxBooleanOption.UNSET;
    private boolean mEnableUIFlush = true;
    private boolean mVsyncAlignedFlushEnabled = true;
    private LynxInfoReportHelper mReportHelper = new LynxInfoReportHelper();
    private PerformanceController mPerformanceController = new PerformanceController();
    private volatile String mRenderPhase = RENDER_PHASE_SETUP;
    private boolean mForceLayoutOnBackgroundThread = LynxEnv.inst().shouldForceLayoutOnBackgroundThread();
    private Map<Double, PlatformCallBack> platformCallBackMap = new HashMap();
    private AtomicBoolean mIsDestroyed = new AtomicBoolean(true);
    private CleanupReference mCleanupReference = null;
    private long mNativePtr = 0;
    private AtomicInteger mLynxGetDataCounter = new AtomicInteger(0);
    private SparseArray<LynxGetDataCallback> mCallbackSparseArray = new SparseArray<>();
    private AtomicInteger mEmbeddedPipelineCounter = new AtomicInteger(0);
    private TemplateData mTemplateData = TemplateData.fromMap(new HashMap());

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public @interface RenderPhaseName {
    }

    private native void nativeAttachEngineToUIThread(long j, long j2);

    private static native void nativeAttachRuntime(long j, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeClearPipelineTimingInfo(long j, long j2);

    private static native long nativeCreate(long j, Object obj, Object obj2, Object obj3, int i, boolean z, boolean z2, int i2, int i3, float f, String str, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, String str2, Object obj4, long j2, long j3, boolean z9, boolean z10, boolean z11, boolean z12, int i4, boolean z13, boolean z14, long j4, Object obj5);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroy(long j);

    private native void nativeDetachEngineFromUIThread(long j, long j2);

    private static native void nativeDispatchMessageEvent(long j, long j2, ReadableMap readableMap);

    private static native void nativeEnforceRelayoutOnCurrentThreadWithUpdatedViewport(long j, long j2, int i, int i2, int i3, int i4);

    private static native void nativeFlush(long j, long j2);

    private static native JavaOnlyMap nativeGetAllJsSource(long j, long j2);

    private native JavaOnlyMap nativeGetAllTimingInfo(long j, long j2);

    private native void nativeGetDataAsync(long j, long j2, int i);

    private static native int nativeGetInstanceId(long j, long j2);

    private static native JavaOnlyMap nativeGetListPlatformInfo(long j, long j2, int i);

    private static native Object nativeGetPageDataByKey(long j, long j2, String[] strArr);

    private native void nativeGetSessionStorageItem(long j, long j2, String str, PlatformCallBack platformCallBack);

    private static native void nativeInitRuntime(long j, LynxResourceLoader lynxResourceLoader, LynxModuleFactory lynxModuleFactory, String str, String[] strArr, String str2, int i, long j2);

    private static native long nativeLifecycleCreate();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeLifecycleDestroy(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeLifecycleTryTerminate(long j);

    private static native void nativeLoadSSRDataByPreParsedData(long j, long j2, byte[] bArr, long j3, boolean z, String str, TemplateData templateData);

    private static native void nativeLoadTemplateBufferByPreParsedData(long j, long j2, String str, ByteBuffer byteBuffer, int i, boolean z, long j3, boolean z2, String str2, TemplateData templateData, int i2, ReadableMap readableMap);

    private static native void nativeLoadTemplateBundleByPreParsedData(long j, long j2, String str, long j3, int i, long j4, boolean z, String str2, TemplateData templateData, int i2, ReadableMap readableMap);

    private static native void nativeLoadTemplateByPreParsedData(long j, long j2, String str, byte[] bArr, int i, boolean z, long j3, boolean z2, String str2, TemplateData templateData, int i2, ReadableMap readableMap);

    private static native void nativeMarkDirty(long j, long j2);

    private static native int nativeObtainChild(long j, long j2, int i, int i2, long j3, boolean z);

    private static native void nativeObtainChildAsync(long j, long j2, int i, int i2, long j3);

    private static native void nativeOnEnterBackground(long j, long j2);

    private static native void nativeOnEnterForeground(long j, long j2);

    private static native void nativeOnLynxEngineCreated(long j, long j2);

    private static native void nativePreloadLazyBundles(long j, long j2, String[] strArr);

    private static native void nativeProcessRender(long j, long j2);

    private static native void nativeRecycleChild(long j, long j2, int i, int i2);

    private static native void nativeRecycleChildAsync(long j, long j2, int i, int i2);

    private static native boolean nativeRegisterLazyBundle(long j, long j2, String str, long j3);

    private static native void nativeReloadTemplate(long j, long j2, long j3, long j4, String str, boolean z, Object obj, TemplateData templateData, ReadableMap readableMap);

    private static native void nativeRemoveChild(long j, long j2, int i, int i2);

    private static native void nativeRenderChild(long j, long j2, int i, int i2, long j3);

    private static native void nativeResetDataByPreParsedData(long j, long j2, long j3, String str, boolean z, TemplateData templateData);

    private native void nativeScrollByListContainer(long j, long j2, int i, float f, float f2, float f3, float f4);

    private native void nativeScrollStopped(long j, long j2, int i);

    private native void nativeScrollToPosition(long j, long j2, int i, int i2, float f, int i3, boolean z);

    private static native void nativeSendGlobalEventToLepus(long j, long j2, String str, ByteBuffer byteBuffer, int i);

    private static native void nativeSendSsrGlobalEvent(long j, long j2, String str, ByteBuffer byteBuffer, int i);

    private native void nativeSetContextHasAttached(long j, long j2);

    private static native void nativeSetEnableBytecode(long j, long j2, boolean z, String str);

    private static native void nativeSetEnableUIFlush(long j, long j2, boolean z);

    private native void nativeSetExtensionDelegate(long j, long j2, long j3);

    private static native void nativeSetFontScale(long j, long j2, float f);

    private native void nativeSetLongTaskMonitorDisabled(long j, long j2, boolean z);

    private static native void nativeSetPlatformConfig(long j, long j2, String str);

    private native void nativeSetSSRTimingData(long j, long j2, String str, long j3);

    private native void nativeSetSessionStorageItem(long j, long j2, String str, long j3, boolean z);

    private static native void nativeStartRuntime(long j, long j2);

    private native double nativeSubscribeSessionStorage(long j, long j2, String str, PlatformCallBack platformCallBack);

    private static native void nativeSyncFetchLayoutResult(long j, long j2);

    private static native void nativeSyncPackageExternalPath(long j, String str);

    private static native void nativeTriggerEventBus(long j, long j2, String str, ByteBuffer byteBuffer, int i);

    private native void nativeUnsubscribeSessionStorage(long j, long j2, String str, double d);

    private static native void nativeUpdateChild(long j, long j2, int i, int i2, int i3, long j3);

    private static native void nativeUpdateConfig(long j, long j2, ByteBuffer byteBuffer, int i);

    private static native void nativeUpdateDataByPreParsedData(long j, long j2, long j3, String str, boolean z, TemplateData templateData, boolean z2);

    private static native void nativeUpdateFontScale(long j, long j2, float f);

    private static native void nativeUpdateGlobalProps(long j, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeUpdateI18nResource(long j, long j2, String str, String str2, int i);

    private static native void nativeUpdateMetaData(long j, long j2, long j3, String str, boolean z, TemplateData templateData, long j4);

    private static native void nativeUpdateScreenMetrics(long j, long j2, int i, int i2, float f, long j3);

    private static native void nativeUpdateViewport(long j, long j2, int i, int i2, int i3, int i4, float f, long j3, boolean z);

    public native void nativeDetachLynxEngineWrapper(long j, long j2);

    public native void nativeReattachLynxEngineWrapper(long j, long j2, long j3, long j4);

    public void onInterceptTouchEvent(MotionEvent motionEvent) {
    }

    public void onTouchEvent(MotionEvent motionEvent) {
    }

    public LynxTemplateRender(Context context, UIBody.UIBodyView uIBodyView, LynxViewBuilder lynxViewBuilder) {
        init(context, uIBodyView, lynxViewBuilder);
    }

    LynxTemplateRender(Context context, LynxViewBuilder lynxViewBuilder) {
        init(context, null, lynxViewBuilder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxTemplateRender(LynxViewBuilder lynxViewBuilder) {
        init(null, null, lynxViewBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LynxView getLynxView() {
        UIBody.UIBodyView uIBodyView = this.mBodyView;
        if (uIBodyView instanceof LynxView) {
            return (LynxView) uIBodyView;
        }
        return null;
    }

    private String formatLynxMessage(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(currentTimeMillis)).append(" ");
        sb.append(str).append(" LynxView ");
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null && !TextUtils.isEmpty(lynxContext.getLynxSessionID())) {
            sb.append(this.mLynxContext.getLynxSessionID()).append(" ");
        }
        String str2 = this.mUrl;
        if (str2 != null) {
            sb.append(str2);
        }
        return sb.toString();
    }

    private boolean checkEnableGenericResourceFetcher(LynxBooleanOption lynxBooleanOption) {
        if (lynxBooleanOption == LynxBooleanOption.UNSET) {
            return LynxEnv.inst().enableGenericResourceFetcher();
        }
        return lynxBooleanOption == LynxBooleanOption.TRUE;
    }

    private void init(Context context, UIBody.UIBodyView uIBodyView, LynxViewBuilder lynxViewBuilder) {
        TraceEvent.beginSection(TraceEventDef.TEMPLATE_RENDER_INIT);
        ILynxTrailServiceExtension iLynxTrailServiceExtension = (ILynxTrailService) LynxServiceCenter.inst().getService(ILynxTrailService.class);
        if (iLynxTrailServiceExtension instanceof ILynxTrailServiceExtension) {
            iLynxTrailServiceExtension.parseLynxViewBuilder(lynxViewBuilder);
        }
        this.mInitStart = System.currentTimeMillis();
        this.mContext = context;
        this.mBodyView = uIBodyView;
        this.mLynxViewConfigProvider = lynxViewBuilder;
        this.mLogicExecutor = lynxViewBuilder.getLogicExecutor();
        this.mLynxViewGroup = lynxViewBuilder.lynxViewGroup;
        if (lynxViewBuilder.lynxViewGroup instanceof ILynxViewRuntimeCacheManager) {
            this.mCacheManager = lynxViewBuilder.lynxViewGroup;
        }
        this.mLynxViewBuilder = lynxViewBuilder;
        ILynxViewGroup iLynxViewGroup = this.mLynxViewGroup;
        if (iLynxViewGroup != null) {
            this.mTemplateBundle = iLynxViewGroup.getTemplateBundle();
        }
        if (this.mTemplateBundle == null) {
            this.mTemplateBundle = this.mLynxViewBuilder.templateBundle;
        }
        int embeddedMode = this.mLynxViewConfigProvider.getEmbeddedMode();
        this.mEmbeddedMode = embeddedMode;
        this.mPerformanceController.setEmbeddedMode(EmbeddedMode.isBaseModeEnable(embeddedMode));
        this.mPerformanceController.setPerformanceObserver(this.mClientV2);
        boolean z = true;
        this.mEnableReuseEngine = EmbeddedMode.isEnginePoolEnable(this.mEmbeddedMode) && this.mTemplateBundle != null;
        this.mThreadStrategyForRendering = this.mLynxViewConfigProvider.getThreadStrategy();
        if (this.mEnableReuseEngine) {
            reuseLynxEngine();
        } else {
            this.mLynxUIRender = lynxUIRenderer();
        }
        this.mRuntime = lynxViewBuilder.lynxBackgroundRuntime;
        this.mTemplateProvider = lynxViewBuilder.templateProvider;
        this.mEnableSyncFlush = this.mLynxViewConfigProvider.isEnableSyncFlush();
        this.mEnableJSRuntime = this.mLynxViewConfigProvider.isEnableJSRuntime();
        this.mEnableGenericResourceFetcher = checkEnableGenericResourceFetcher(this.mLynxViewConfigProvider.isEnableGenericResourceFetcher());
        this.mEnableAirStrictMode = this.mLynxViewConfigProvider.isEnableAirStrictMode();
        lynxViewBuilder.lynxBackgroundRuntime = null;
        UIBody.UIBodyView uIBodyView2 = this.mBodyView;
        if (uIBodyView2 != null) {
            uIBodyView2.setTimingCollector(this.mPerformanceController);
        }
        this.mLynxRuntimeOptions = this.mLynxViewConfigProvider.getLynxRuntimeOptions();
        boolean z2 = this.mThreadStrategyForRendering == ThreadStrategyForRendering.MULTI_THREADS || this.mThreadStrategyForRendering == ThreadStrategyForRendering.MOST_ON_TASM;
        this.mAsyncRender = z2;
        if (this.mForceLayoutOnBackgroundThread) {
            this.mThreadStrategyForRendering = z2 ? ThreadStrategyForRendering.MULTI_THREADS : ThreadStrategyForRendering.PART_ON_LAYOUT;
        }
        this.mHasEnvPrepared = LynxEnv.inst().isNativeLibraryLoaded();
        this.mVsyncAlignedFlushEnabled = VSYNC_ALIGNED_FLUSH_EXP_SWITCH && LynxEnv.inst().getVsyncAlignedFlushGlobalSwitch() && isThreadStrategySupportVsyncAlignedFlush();
        this.mFontScale = this.mLynxViewConfigProvider.getFontScale();
        this.mOriginLynxViewConfig = lynxViewBuilder.lynxViewConfig;
        this.mEnableBytecode = this.mLynxRuntimeOptions.isEnableUserBytecode();
        this.mBytecodeSourceUrl = this.mLynxRuntimeOptions.getBytecodeSourceUrl();
        this.mEnablePendingJsTask = this.mLynxViewConfigProvider.isEnablePendingJsTask();
        DisplayMetricsHolder.updateOrInitDisplayMetrics(context, this.mLynxViewConfigProvider.getDensity());
        DisplayMetrics screenDisplayMetrics = DisplayMetricsHolder.getScreenDisplayMetrics();
        if (this.mLynxViewConfigProvider.getScreenWidth() != -1 && this.mLynxViewConfigProvider.getScreenHeight() != -1) {
            screenDisplayMetrics.widthPixels = this.mLynxViewConfigProvider.getScreenWidth();
            screenDisplayMetrics.heightPixels = this.mLynxViewConfigProvider.getScreenHeight();
        }
        LynxContext lynxContext = new LynxContext(context != null ? context : LynxEnv.inst().getAppContext(), screenDisplayMetrics) { // from class: com.lynx.tasm.LynxTemplateRender.1
            public void handleException(Exception exc) {
                LynxTemplateRender.this.onExceptionOccurred(LynxSubErrorCode.E_EXCEPTION_PLATFORM, exc, null);
            }

            public void handleException(Exception exc, JSONObject jSONObject) {
                LynxTemplateRender.this.onExceptionOccurred(LynxSubErrorCode.E_EXCEPTION_PLATFORM, exc, jSONObject);
            }

            @Deprecated
            public void handleException(Exception exc, int i) {
                LynxTemplateRender.this.onExceptionOccurred(i, exc, null);
            }

            @Deprecated
            public void handleException(Exception exc, int i, JSONObject jSONObject) {
                LynxTemplateRender.this.onExceptionOccurred(i, exc, jSONObject);
            }

            public void handleLynxError(LynxError lynxError) {
                LynxTemplateRender.this.onErrorOccurred(lynxError);
            }
        };
        this.mLynxContext = lynxContext;
        lynxContext.setRuntimeCacheManager(this.mCacheManager);
        this.mTemplateAssembler.setLynxContext(this.mLynxContext);
        this.mLynxContext.setEmbeddedMode(this.mEmbeddedMode);
        this.mLynxContext.setPerfController(this.mPerformanceController);
        this.mLynxContext.setUIBodyView(this.mBodyView);
        this.mLynxContext.setForceDarkAllowed(this.mLynxViewConfigProvider.getForceDarkAllowed());
        this.mLynxContext.setContextData(this.mLynxViewConfigProvider.getContextData());
        if (this.mLynxViewBuilder.mImageCustomParam != null) {
            this.mLynxContext.setImageCustomParam(this.mLynxViewBuilder.mImageCustomParam);
        }
        ILynxExtensionService service = LynxServiceCenter.inst().getService(ILynxExtensionService.class);
        if (service != null) {
            service.onLynxViewSetup(this.mLynxContext, this.mLynxRuntimeOptions.getLynxGroup(), this.mLynxViewConfigProvider.getBehaviorRegistry());
        }
        LynxEnv.inst().initNativeUIThread();
        init(context);
        int presetWidthMeasureSpec = this.mLynxViewConfigProvider.getPresetWidthMeasureSpec();
        int presetHeightMeasureSpec = this.mLynxViewConfigProvider.getPresetHeightMeasureSpec();
        if (this.mForceLayoutOnBackgroundThread && presetWidthMeasureSpec == 0 && presetHeightMeasureSpec == 0) {
            presetWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mLynxContext.getResources().getDisplayMetrics().widthPixels, 1073741824);
        }
        if ((this.mEnableReuseEngine && this.mIsEngineFromReuse) || ((this.mEmbeddedMode & 4) > 0 && !this.mLynxViewConfigProvider.hasPresetMeasureSpec())) {
            z = false;
        }
        if (z) {
            updateViewport(presetWidthMeasureSpec, presetHeightMeasureSpec);
        }
        this.mClient.addClient(LynxEnv.inst().getLynxViewClient());
        this.mClient.addClient(new LogLynxViewClient());
        setupReusedEngineConfig();
        this.mInitEnd = System.currentTimeMillis();
        setMsTiming(TimingHandler.CREATE_LYNX_START, this.mInitStart, null);
        setMsTiming(TimingHandler.CREATE_LYNX_END, this.mInitEnd, null);
        LLog.m2578i(TAG, formatLynxMessage("create"));
        TraceEvent.endSection(TraceEventDef.TEMPLATE_RENDER_INIT);
    }

    private void reuseLynxEngine() {
        tryReuseLynxEngineFromPool();
        if (this.mLynxEngineRef == null) {
            this.mLynxEngineRef = new LynxEngine(this.mTemplateBundle, this);
            ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
            this.mLynxUIRender = lynxUIRenderer;
            this.mLynxEngineRef.setLynxUIRenderer(lynxUIRenderer);
            this.mLynxEngineRef.attachCurrentTemplateRender(this);
            this.mIsEngineFromReuse = false;
        }
        TemplateData templateData = this.mTemplateData;
        if (templateData != null) {
            templateData.setEnableJSData(false);
        }
    }

    private void setLynxInternalModules(LynxModuleFactory lynxModuleFactory) {
        lynxModuleFactory.registerModule(LynxIntersectionObserverModule.NAME, LynxIntersectionObserverModule.class, null);
        lynxModuleFactory.registerModule(LynxUIMethodModule.NAME, LynxUIMethodModule.class, null);
        lynxModuleFactory.registerModule(LynxTextInfoModule.NAME, LynxTextInfoModule.class, null);
        lynxModuleFactory.registerModule(LynxAccessibilityModule.NAME, LynxAccessibilityModule.class, null);
        lynxModuleFactory.registerModule(LynxSetModule.NAME, LynxSetModule.class, null);
        lynxModuleFactory.registerModule(LynxResourceModule.NAME, LynxResourceModule.class, null);
        lynxModuleFactory.registerModule(LynxExposureModule.NAME, LynxExposureModule.class, null);
    }

    private void setUserModules(LynxModuleFactory lynxModuleFactory) {
        lynxModuleFactory.setLynxModuleExtraData(this.mLynxViewBuilder.lynxModuleExtraData);
        lynxModuleFactory.addModuleParamWrapper(this.mLynxRuntimeOptions.getWrappers());
    }

    private void setUpMainThreadModuleFactory() {
        if (this.mLynxViewBuilder.isEnableMTSModule()) {
            LynxModuleFactory lynxModuleFactory = new LynxModuleFactory(this.mLynxContext);
            this.mMainThreadModuleFactory = lynxModuleFactory;
            setLynxInternalModules(lynxModuleFactory);
            setUserModules(this.mMainThreadModuleFactory);
        }
    }

    private void setUpBackgroundThreadModuleFactory() {
        LynxBackgroundRuntime lynxBackgroundRuntime = this.mRuntime;
        if (lynxBackgroundRuntime != null) {
            LynxModuleFactory moduleFactory = lynxBackgroundRuntime.getModuleFactory();
            this.mModuleFactory = moduleFactory;
            moduleFactory.setContext(this.mLynxContext);
        } else {
            LynxModuleFactory lynxModuleFactory = new LynxModuleFactory(this.mLynxContext);
            this.mModuleFactory = lynxModuleFactory;
            lynxModuleFactory.registerModuleAuthValidator(this.mLynxRuntimeOptions.getModuleAuthValidator());
        }
        setUserModules(this.mModuleFactory);
        setLynxInternalModules(this.mModuleFactory);
        LynxFetchModuleEventSender lynxFetchModuleEventSender = new LynxFetchModuleEventSender();
        lynxFetchModuleEventSender.setWeakContext(this.mLynxContext);
        this.mModuleFactory.registerModule(LynxFetchModule.NAME, LynxFetchModule.class, lynxFetchModuleEventSender);
    }

    private void tryReuseLynxEngineFromPool() {
        if (this.mThreadStrategyForRendering == ThreadStrategyForRendering.MOST_ON_TASM) {
            return;
        }
        onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_TRY_REUSE_ENGINE);
        LynxEngine pollEngineFromPool = LynxEnginePool.getInstance().pollEngineFromPool(this.mTemplateBundle, this.mThreadStrategyForRendering);
        this.mLynxEngineRef = pollEngineFromPool;
        if (pollEngineFromPool != null) {
            pollEngineFromPool.updateLynxEngineState(LynxEngine.LynxEngineState.ON_REUSING);
            this.mLynxEngineRef.detachFromLynxView();
            ILynxUIRenderer lynxUIRenderer = this.mLynxEngineRef.getLynxUIRenderer();
            this.mLynxUIRender = lynxUIRenderer;
            lynxUIRenderer.attachBodyView(this.mBodyView, this.mLynxContext, this.mContext);
            this.mLynxEngineRef.attachCurrentTemplateRender(this);
            WeakReference<TasmPlatformInvoker> weakReference = new WeakReference<>(this.mLynxEngineRef.getTasmPlatformInvoker());
            this.mTasmPlatformInvoker = weakReference;
            if (weakReference.get() != null) {
                this.mTasmPlatformInvoker.get().setNativeFacade(this.mNativeFacade);
            }
            setupReusedEngineConfig();
            this.mIsEngineFromReuse = true;
        }
        onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_TRY_REUSE_ENGINE);
    }

    private void setupReusedEngineConfig() {
        LynxEngine lynxEngine;
        WeakReference<TasmPlatformInvoker> weakReference;
        if (this.mEnableReuseEngine && (lynxEngine = this.mLynxEngineRef) != null) {
            if (lynxEngine.hasLoaded()) {
                TemplateBundle templateBundle = this.mTemplateBundle;
                PageConfig.attachPageConfig(templateBundle != null ? templateBundle.getPageConfig() : this.mLynxEngineRef.getPageConfig(), this.mLynxContext, this.mLynxUIRender);
            }
            if (this.mLynxEngineRef.hasLoaded() || (weakReference = this.mTasmPlatformInvoker) == null) {
                return;
            }
            this.mLynxEngineRef.setTasmPlatformInvoker(weakReference.get());
        }
    }

    public boolean enableAirStrictMode() {
        return this.mEnableAirStrictMode;
    }

    void showErrorMessage(LynxError lynxError) {
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.showErrorMessage(lynxError);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnableReuseEngine() {
        return this.mEnableReuseEngine;
    }

    public LynxContext getLynxContext() {
        return this.mLynxContext;
    }

    public PerformanceController getPerformanceController() {
        return this.mPerformanceController;
    }

    public UIGroup<UIBody.UIBodyView> getLynxRootUI() {
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            return iLynxUIRenderer.getLynxRootUI();
        }
        return null;
    }

    public LynxDevtool getDevTool() {
        return this.mDevTool;
    }

    public void onEnterForeground() {
        onEnterForeground(true);
    }

    public void onEnterBackground() {
        onEnterBackground(true);
    }

    public void updateScreenMetrics(int i, int i2) {
        LynxContext lynxContext = this.mLynxContext;
        if (this.mNativePtr == 0 || lynxContext == null) {
            return;
        }
        if (i == lynxContext.getScreenMetrics().widthPixels && i2 == lynxContext.getScreenMetrics().heightPixels) {
            return;
        }
        this.mShouldUpdateViewport = true;
        lynxContext.updateScreenSize(i, i2);
        nativeUpdateScreenMetrics(this.mNativePtr, this.mNativeLifecycle, i, i2, lynxContext.getScreenMetrics().density, this.mLynxUIRender.getUIDelegatePtr());
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.updateScreenMetrics(i, i2, lynxContext.getScreenMetrics().density);
        }
    }

    public void addLynxViewClient(LynxViewClient lynxViewClient) {
        if (lynxViewClient == null) {
            return;
        }
        this.mClient.addClient(lynxViewClient);
    }

    public void addLynxViewClientV2(LynxViewClientV2 lynxViewClientV2) {
        this.mClientV2.addClient(lynxViewClientV2);
    }

    public void removeLynxViewClient(LynxViewClient lynxViewClient) {
        LynxViewClientGroup lynxViewClientGroup;
        if (lynxViewClient == null || (lynxViewClientGroup = this.mClient) == null) {
            return;
        }
        lynxViewClientGroup.removeClient(lynxViewClient);
    }

    public void removeLynxViewClientV2(LynxViewClientV2 lynxViewClientV2) {
        this.mClientV2.removeClient(lynxViewClientV2);
    }

    private void setMsTiming(String str, long j, String str2) {
        this.mPerformanceController.setMsTiming(str, j, str2);
    }

    public void setExtraTiming(TimingHandler.ExtraTimingInfo extraTimingInfo) {
        onTraceEventBegin("LynxTemplateRender.setExtraTiming");
        this.mPerformanceController.setExtraTiming(extraTimingInfo);
        onTraceEventEnd("LynxTemplateRender.setExtraTiming");
    }

    public void setFluencyTracerEnabled(LynxBooleanOption lynxBooleanOption) {
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxContext.getFluencyTraceHelper().setEnabledBySampling(lynxBooleanOption);
        }
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption lynxBooleanOption) {
        UIThreadUtils.assertOnUiThread();
        this.mLongTaskMonitorEnabled = lynxBooleanOption;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetLongTaskMonitorDisabled(j, this.mNativeLifecycle, lynxBooleanOption == LynxBooleanOption.FALSE);
        }
    }

    public void putExtraParamsForReportingEvents(Map<String, Object> map) {
        onTraceEventBegin("LynxTemplateRender.putExtraParamsForReportEvents");
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null && lynxContext.enableEventReporter()) {
            LynxEventReporter.putExtraParams(map, this.mLynxContext.getInstanceId());
        }
        onTraceEventEnd("LynxTemplateRender.putExtraParamsForReportEvents");
    }

    public HashMap<String, Object> getAllTimingInfo() {
        long j = this.mNativePtr;
        if (j != 0) {
            return nativeGetAllTimingInfo(j, this.mNativeLifecycle);
        }
        return null;
    }

    public String getRenderPhase() {
        return this.mRenderPhase;
    }

    public void setImageInterceptor(ImageInterceptor imageInterceptor) {
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxContext.setImageInterceptor(imageInterceptor);
        }
    }

    public void setAsyncImageInterceptor(ImageInterceptor imageInterceptor) {
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxContext.setAsyncImageInterceptor(imageInterceptor);
        }
    }

    private synchronized void reloadAndInit() {
        if (this.mHasDestroy) {
            return;
        }
        if (this.reload) {
            onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_RELOAD_AND_INIT);
            this.mHasPageStart = false;
            this.mSSRHelper = null;
            this.mRenderPhase = RENDER_PHASE_SETUP;
            LynxContext lynxContext = this.mLynxContext;
            if (lynxContext != null) {
                lynxContext.clearExposure();
            }
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LynxTemplateRender.this.m2916lambda$reloadAndInit$0$comlynxtasmLynxTemplateRender();
                }
            });
            TemplateData templateData = this.globalProps;
            if (templateData != null) {
                this.globalProps = templateData.deepClone();
            }
            int i = -1;
            if (this.mNativePtr != 0) {
                LynxContext lynxContext2 = this.mLynxContext;
                if (lynxContext2 != null && lynxContext2.enableEventReporter()) {
                    i = this.mLynxContext.getInstanceId();
                    LynxEventReporter.removeGenericInfo(i);
                }
                destroyLynxEngine();
            }
            int i2 = this.mPreWidthMeasureSpec;
            int i3 = this.mPreHeightMeasureSpec;
            this.mPreWidthMeasureSpec = 0;
            this.mPreHeightMeasureSpec = 0;
            ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
            if (lynxUIRenderer != null) {
                lynxUIRenderer.onReloadAndInitAnyThreadPart();
            }
            LynxContext lynxContext3 = this.mLynxContext;
            if (lynxContext3 != null) {
                lynxContext3.reset();
            }
            createLynxEngine(i);
            updateViewport(i2, i3);
            setMsTiming(TimingHandler.CREATE_LYNX_START, this.mInitStart, null);
            setMsTiming(TimingHandler.CREATE_LYNX_END, this.mInitEnd, null);
            onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_RELOAD_AND_INIT);
        } else {
            this.reload = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$reloadAndInit$0$com-lynx-tasm-LynxTemplateRender, reason: not valid java name */
    public /* synthetic */ void m2916lambda$reloadAndInit$0$comlynxtasmLynxTemplateRender() {
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onReloadAndInitUIThreadPart();
        }
        UIBody.UIBodyView uIBodyView = this.mBodyView;
        if (uIBodyView != null) {
            uIBodyView.removeAllViews();
        }
    }

    public String getPageVersion() {
        LynxContext lynxContext = this.mLynxContext;
        return lynxContext == null ? "" : lynxContext.getPageVersion();
    }

    public void pauseRootLayoutAnimation() {
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.pauseRootLayoutAnimation();
        }
    }

    public void resumeRootLayoutAnimation() {
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.resumeRootLayoutAnimation();
        }
    }

    private void createLynxEngine(int i) {
        ViewLayoutTick choreographerLayoutTick;
        TasmPlatformInvoker tasmPlatformInvoker;
        if (checkIfEnvPrepared() && this.mIsDestroyed.compareAndSet(true, false)) {
            TraceEvent.beginSection(TraceEventDef.TEMPLATE_RENDER_CREATE_TASM);
            if (this.mThreadStrategyForRendering == ThreadStrategyForRendering.ALL_ON_UI) {
                choreographerLayoutTick = new ViewLayoutTick(this.mBodyView);
                this.mViewLayoutTick = choreographerLayoutTick;
            } else {
                choreographerLayoutTick = new ChoreographerLayoutTick(this.mLynxContext);
            }
            ViewLayoutTick viewLayoutTick = choreographerLayoutTick;
            LLog.m2578i(TAG, "mEnableGenericResourceFetcher: " + this.mEnableGenericResourceFetcher + " render: " + this);
            if (this.mEnableGenericResourceFetcher) {
                this.mLynxContext.setGenericResourceFetcher(this.mLynxViewConfigProvider.getLynxGenericResourceFetcher());
                this.mLynxContext.setMediaResourceFetcher(this.mLynxViewConfigProvider.getLynxMediaResourceFetcher());
                this.mLynxContext.setTemplateResourceFetcher(this.mLynxViewConfigProvider.getLynxTemplateResourceFetcher());
            }
            this.mPageLoadListener = new InnerPageLoadListener();
            this.mGroup = this.mLynxViewBuilder.getLynxGroup();
            this.mLoader = new LynxResourceLoader((LynxBackgroundRuntimeOptions) null, this.mLynxViewBuilder.fetcher, this, this.mLynxContext.getTemplateResourceFetcher(), this.mLynxContext.getGenericResourceFetcher());
            this.mLynxContext.setEnableAutoExpose(this.mLynxViewConfigProvider.isEnableAutoExpose());
            NativeFacade nativeFacade = new NativeFacade(this.mLynxViewBuilder.isEnableJSRuntime());
            this.mNativeFacade = nativeFacade;
            nativeFacade.setCallback(new TASMCallback());
            DisplayMetrics screenMetrics = this.mLynxContext.getScreenMetrics();
            LynxBackgroundRuntime lynxBackgroundRuntime = this.mRuntime;
            long nativePtr = lynxBackgroundRuntime == null ? 0L : lynxBackgroundRuntime.getNativePtr();
            LynxGroup lynxGroup = this.mGroup;
            long whiteBoardPtr = lynxGroup == null ? 0L : lynxGroup.getWhiteBoardPtr();
            ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
            lynxUIRenderer.onCreateTemplateRenderer(this.mLynxContext, this.mPageLoadListener, this.mThreadStrategyForRendering, this.mLynxViewConfigProvider.getBehaviorRegistry(), viewLayoutTick);
            WeakReference<TasmPlatformInvoker> weakReference = this.mTasmPlatformInvoker;
            if (weakReference != null && weakReference.get() != null) {
                tasmPlatformInvoker = this.mTasmPlatformInvoker.get();
                tasmPlatformInvoker.setNativeFacade(this.mNativeFacade);
            } else {
                tasmPlatformInvoker = new TasmPlatformInvoker(this.mNativeFacade);
                this.mTasmPlatformInvoker = new WeakReference<>(tasmPlatformInvoker);
            }
            TasmPlatformInvoker tasmPlatformInvoker2 = tasmPlatformInvoker;
            boolean z = this.mLynxViewConfigProvider.isEnableVSyncAlignedMessageLoop() || LynxEnv.inst().enableVSyncAlignedMessageLoopGlobal();
            setUpMainThreadModuleFactory();
            NativeFacade nativeFacade2 = this.mNativeFacade;
            PerformanceController performanceController = this.mPerformanceController.isEmbeddedMode() ? null : this.mPerformanceController;
            LynxResourceLoader lynxResourceLoader = this.mLoader;
            int m2569id = this.mThreadStrategyForRendering.m2569id();
            boolean isEnableLayoutSafepoint = this.mLynxViewConfigProvider.isEnableLayoutSafepoint();
            boolean z2 = this.mLynxViewBuilder.enableLayoutOnly;
            int i2 = screenMetrics.widthPixels;
            int i3 = screenMetrics.heightPixels;
            float f = screenMetrics.density;
            String locale = LynxEnv.inst().getLocale();
            boolean isEnableJSRuntime = this.mLynxViewBuilder.isEnableJSRuntime();
            boolean isEnableMultiAsyncThread = this.mLynxViewConfigProvider.isEnableMultiAsyncThread();
            boolean isEnablePreUpdateData = this.mLynxViewConfigProvider.isEnablePreUpdateData();
            boolean isEnableAsyncHydration = this.mLynxViewConfigProvider.isEnableAsyncHydration();
            LynxGroup lynxGroup2 = this.mGroup;
            boolean z3 = lynxGroup2 != null && lynxGroup2.enableJSGroupThread();
            String jSGroupThreadNameIfNeed = getJSGroupThreadNameIfNeed();
            long uIDelegatePtr = lynxUIRenderer.getUIDelegatePtr();
            boolean useInvokeUIMethod = lynxUIRenderer.useInvokeUIMethod();
            boolean z4 = this.mLongTaskMonitorEnabled == LynxBooleanOption.FALSE;
            boolean z5 = this.mForceLayoutOnBackgroundThread;
            boolean isEnableUnifiedPipeline = this.mLynxViewConfigProvider.isEnableUnifiedPipeline();
            int i4 = this.mEmbeddedMode;
            boolean z6 = this.mLogicExecutor != null;
            boolean isDebuggable = this.mLynxViewBuilder.isDebuggable();
            LynxEngine lynxEngine = this.mLynxEngineRef;
            long nativePtr2 = lynxEngine == null ? 0L : lynxEngine.getNativePtr();
            LynxModuleFactory lynxModuleFactory = this.mMainThreadModuleFactory;
            this.mNativePtr = nativeCreate(nativePtr, nativeFacade2, performanceController, lynxResourceLoader, m2569id, isEnableLayoutSafepoint, z2, i2, i3, f, locale, isEnableJSRuntime, isEnableMultiAsyncThread, isEnablePreUpdateData, z, isEnableAsyncHydration, z3, jSGroupThreadNameIfNeed, tasmPlatformInvoker2, whiteBoardPtr, uIDelegatePtr, useInvokeUIMethod, z4, z5, isEnableUnifiedPipeline, i4, z6, isDebuggable, nativePtr2, lynxModuleFactory != null ? lynxModuleFactory : null);
            lynxUIRenderer.attachNativeFacade(this.mNativeFacade);
            this.mNativeLifecycle = nativeLifecycleCreate();
            this.mCleanupReference = new CleanupReference(this, new CleanupOnUiThread(this.mNativeLifecycle), true);
            this.mLynxContext.setListNodeInfoFetcher(new ListNodeInfoFetcher(this));
            this.mLynxContext.setEnableVSyncAligned(z);
            LynxDevtool lynxDevtool = this.mDevTool;
            if (lynxDevtool != null) {
                lynxDevtool.onTemplateAssemblerCreated(this.mNativePtr);
            }
            LynxProviderRegistry lynxProviderRegistry = new LynxProviderRegistry();
            for (Map.Entry<String, LynxResourceProvider> entry : LynxEnv.inst().getResourceProvider().entrySet()) {
                lynxProviderRegistry.addLynxResourceProvider(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, LynxResourceProvider> entry2 : this.mLynxRuntimeOptions.getAllResourceProviders()) {
                lynxProviderRegistry.addLynxResourceProvider(entry2.getKey(), entry2.getValue());
            }
            this.mLynxContext.setProviderRegistry(lynxProviderRegistry);
            this.mLynxContext.setFontLoader(this.mLynxViewBuilder.fontLoader);
            this.mLynxContext.setImageFetcher(this.mLynxViewBuilder.imageFetcher);
            this.mLynxContext.setLynxExtraData(this.mLynxViewBuilder.lynxModuleExtraData);
            this.mNativeFacade.setLynxContext(this.mLynxContext);
            int nativeGetInstanceId = nativeGetInstanceId(this.mNativePtr, this.mNativeLifecycle);
            if (nativeGetInstanceId >= 0) {
                this.mLynxContext.setInstanceId(nativeGetInstanceId);
                this.mPerformanceController.setInstanceId(nativeGetInstanceId);
            }
            UIBody.UIBodyView uIBodyView = this.mBodyView;
            if (uIBodyView != null) {
                uIBodyView.setInstanceId(this.mLynxContext.getInstanceId());
                this.mClient.setInstanceId(this.mLynxContext.getInstanceId());
                this.mClientV2.setInstanceId(this.mLynxContext.getInstanceId());
            }
            LynxContext lynxContext = this.mLynxContext;
            if (lynxContext != null && lynxContext.enableEventReporter()) {
                LynxEventReporter.updateGenericInfo("thread_mode", Integer.valueOf(this.mThreadStrategyForRendering.m2569id()), this.mLynxContext.getInstanceId());
                LynxEventReporter.moveExtraParams(i, this.mLynxContext.getInstanceId());
            }
            if (this.mLynxContext != null && this.mLogicExecutor == null) {
                setUpBackgroundThreadModuleFactory();
                LynxResourceLoader lynxResourceLoader2 = new LynxResourceLoader(this.mLynxRuntimeOptions, this.mLynxViewBuilder.fetcher, this, this.mLynxContext.getTemplateResourceFetcher(), this.mLynxContext.getGenericResourceFetcher());
                this.mResourceLoader = lynxResourceLoader2;
                LynxBackgroundRuntime lynxBackgroundRuntime2 = this.mRuntime;
                if (lynxBackgroundRuntime2 != null) {
                    attachPiper(lynxBackgroundRuntime2, this.mModuleFactory);
                    this.mRuntime = null;
                } else {
                    initPiper(this.mModuleFactory, lynxResourceLoader2, this.mLynxRuntimeOptions.useQuickJSEngine(), false, this.mEnableBytecode, this.mBytecodeSourceUrl, this.mEnablePendingJsTask, lynxUIRenderer);
                }
                setUpExtensionModules();
                LynxDevtool lynxDevtool2 = this.mDevTool;
                if (lynxDevtool2 != null) {
                    lynxDevtool2.onRegisterModule(this.mModuleFactory);
                }
                this.mLynxContext.setJSProxy(this.mJSProxy);
            } else {
                this.mEngineProxy = new LynxEngineProxy(this.mNativePtr);
                if (this.mLynxContext == null) {
                    LLog.m2577e(TAG, "mLynxContext is null, can not set LayoutProxy");
                } else {
                    LynxLayoutProxy lynxLayoutProxy = new LynxLayoutProxy(this.mNativePtr);
                    this.mLayoutProxy = lynxLayoutProxy;
                    this.mLynxContext.setLayoutProxy(lynxLayoutProxy);
                }
            }
            this.mLynxContext.setEventEmitter(new LynxEventEmitter(this.mEngineProxy));
            LynxIntersectionObserverManager lynxIntersectionObserverManager = new LynxIntersectionObserverManager(this.mLynxContext, this.mJSProxy);
            this.mIntersectionObserverManager = lynxIntersectionObserverManager;
            this.mLynxContext.setIntersectionObserverManager(lynxIntersectionObserverManager);
            EventEmitter eventEmitter = this.mLynxContext.getEventEmitter();
            if (eventEmitter != null) {
                eventEmitter.addObserver(this.mIntersectionObserverManager);
                eventEmitter.registerEventReporter(this.mNativeFacade);
                eventEmitter.registerEventFallback(this);
            }
            setThemeInternal(this.mTheme);
            updateGlobalPropsInternal(this.globalProps);
            float f2 = this.mFontScale;
            if (f2 != 1.0f) {
                nativeSetFontScale(this.mNativePtr, this.mNativeLifecycle, f2);
            }
            nativeOnLynxEngineCreated(this.mNativePtr, lynxUIRenderer().getUIDelegatePtr());
            TraceEvent.endSection(TraceEventDef.TEMPLATE_RENDER_CREATE_TASM);
        }
    }

    private void setUpExtensionModules() {
        if (!this.mLynxViewBuilder.isEnableJSRuntime()) {
            LLog.m2577e(TAG, "setUpExtensionModules failed, isEnableJSRuntime is false");
            return;
        }
        Map extensionModules = this.mLynxContext.getExtensionModules();
        Iterator it = extensionModules.keySet().iterator();
        while (it.hasNext()) {
            LynxExtensionModule lynxExtensionModule = (LynxExtensionModule) extensionModules.get((String) it.next());
            long extensionDelegatePtr = lynxExtensionModule.getExtensionDelegatePtr();
            if (extensionDelegatePtr == 0) {
                LLog.m2577e(TAG, "Fail to get extension delegate");
            } else {
                nativeSetExtensionDelegate(this.mNativePtr, this.mNativeLifecycle, extensionDelegatePtr);
                lynxExtensionModule.setUp();
            }
        }
    }

    private void init(Context context) {
        TraceEvent.beginSection(TraceEventDef.TEMPLATE_RENDER_INIT_WITH_CONTEXT);
        this.reload = false;
        this.mHasPageStart = false;
        this.mHasDestroy = false;
        this.mLynxContext.setImageInterceptor(this.mClient);
        this.mLynxContext.setLynxViewClient(this.mClient);
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        lynxUIRenderer.onInitLynxTemplateRender(this.mLynxContext, this.mLynxViewConfigProvider.getBehaviorRegistry(), this.mBodyView, this.mLongTaskMonitorEnabled);
        if (LynxEnv.inst().isLynxDebugEnabled()) {
            LynxBackgroundRuntime lynxBackgroundRuntime = this.mRuntime;
            if (lynxBackgroundRuntime != null) {
                LynxDevtool devtool = lynxBackgroundRuntime.getDevtool();
                this.mDevTool = devtool;
                devtool.attach(getLynxView(), this);
            } else {
                this.mDevTool = new LynxDevtool(getLynxView(), this, this.mLynxViewConfigProvider.isDebuggable());
            }
            this.mDevTool.attachLynxUIOwner(lynxUIRenderer.lynxUIOwner());
            new WeakReference(this);
        }
        createLynxEngine(-1);
        if (context == null) {
            lynxUIRenderer.setContextFree(true);
            setEnableUIFlush(false);
        }
        TraceEvent.endSection(TraceEventDef.TEMPLATE_RENDER_INIT_WITH_CONTEXT);
    }

    public void renderTemplateUrl(String str, TemplateData templateData) {
        renderTemplateUrlInternal(str, new InnerLoadedCallback(str, templateData));
    }

    public void renderTemplateUrl(String str, String str2) {
        renderTemplateUrlInternal(str, new InnerLoadedCallback(str, str2));
    }

    public void renderTemplateUrl(String str, Map<String, Object> map) {
        renderTemplateUrlInternal(str, new InnerLoadedCallback(str, map));
    }

    public void renderSSRUrl(String str, Map<String, Object> map) {
        renderSSRUrlInternal(str, new InnerSSRLoadedCallback(str, TemplateData.fromMap(map)));
    }

    public void renderSSRUrl(String str, TemplateData templateData) {
        renderSSRUrlInternal(str, new InnerSSRLoadedCallback(str, templateData));
    }

    private void onLoadTemplateFromSSRPage() {
        LynxSSRHelper lynxSSRHelper = this.mSSRHelper;
        if (lynxSSRHelper == null || !lynxSSRHelper.isHydrateStarted()) {
            return;
        }
        this.reload = false;
        this.mSSRHelper.onHydrateExecuting();
    }

    public void ssrHydrateUrl(String str, Map<String, Object> map) {
        LynxSSRHelper lynxSSRHelper = this.mSSRHelper;
        if (lynxSSRHelper != null && lynxSSRHelper.isHydratePending()) {
            this.mSSRHelper.onHydrateStart();
        }
        renderTemplateUrl(str, map);
    }

    public void ssrHydrateUrl(String str, TemplateData templateData) {
        LynxSSRHelper lynxSSRHelper = this.mSSRHelper;
        if (lynxSSRHelper != null && lynxSSRHelper.isHydratePending()) {
            this.mSSRHelper.onHydrateStart();
        }
        renderTemplateUrl(str, templateData);
    }

    public JSModule getJSModule(String str) {
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            return lynxContext.getJSModule(str);
        }
        return null;
    }

    public void sendGlobalEvent(String str, JavaOnlyArray javaOnlyArray) {
        LynxContext lynxContext;
        LynxSSRHelper lynxSSRHelper = this.mSSRHelper;
        if (lynxSSRHelper != null && lynxSSRHelper.shouldSendEventToSSR()) {
            if (checkIfEnvPrepared() && this.mNativePtr != 0) {
                ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(javaOnlyArray);
                nativeSendSsrGlobalEvent(this.mNativePtr, this.mNativeLifecycle, str, encodeMessage, encodeMessage == null ? 0 : encodeMessage.position());
            }
            javaOnlyArray = this.mSSRHelper.processEventParams(javaOnlyArray);
        }
        if (checkIfEnvPrepared() && (lynxContext = this.mLynxContext) != null) {
            lynxContext.sendGlobalEvent(str, javaOnlyArray);
        } else {
            LLog.m2577e(TAG, "sendGlobalEvent error, can't get GlobalEventEmitter in " + toString());
        }
        LynxContext lynxContext2 = this.mLynxContext;
        if (lynxContext2 == null || !lynxContext2.isEmbeddedModeOn()) {
            return;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(DefaultLogicExecutor.EVENT_METHOD, DefaultLogicExecutor.GLOBAL_EVENT_METHOD);
        javaOnlyMap.putString(DefaultLogicExecutor.GLOBAL_EVENT_NAME, str);
        javaOnlyMap.putArray("params", javaOnlyArray);
        onLynxEvent(javaOnlyMap);
    }

    public void sendGlobalEventToLepus(String str, List<Object> list) {
        if (checkIfEnvPrepared() && this.mNativePtr != 0) {
            ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(list);
            nativeSendGlobalEventToLepus(this.mNativePtr, this.mNativeLifecycle, str, encodeMessage, encodeMessage == null ? 0 : encodeMessage.position());
        } else {
            LLog.m2577e(TAG, "sendGlobalEventToLepus error, Env not prepared in " + toString());
        }
    }

    public void triggerEventBus(String str, List<Object> list) {
        if (checkIfEnvPrepared() && this.mNativePtr != 0) {
            ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(list);
            nativeTriggerEventBus(this.mNativePtr, this.mNativeLifecycle, str, encodeMessage, encodeMessage == null ? 0 : encodeMessage.position());
        } else {
            LLog.m2577e(TAG, "triggerEventBus error, Env not prepared in " + toString());
        }
    }

    public void updateGlobalProps(TemplateData templateData) {
        LLog.m2576d(TAG, "updateGlobalProps with url: " + getTemplateUrl());
        onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_SET_GLOBAL_PROPS);
        if (checkIfEnvPrepared() && this.mNativePtr != 0 && templateData != null) {
            internalMergeGlobalPropsSafely(templateData);
            updateGlobalPropsInternal(this.globalProps);
        }
        onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_SET_GLOBAL_PROPS);
    }

    private void renderSSRUrlInternal(String str, final InnerSSRLoadedCallback innerSSRLoadedCallback) {
        if (!checkIfEnvPrepared()) {
            onErrorOccurred(LynxSubErrorCode.E_APP_BUNDLE_LOAD_ENV_NOT_READY, "LynxEnv has not been prepared successfully!");
            return;
        }
        onTraceEventBegin("LynxTemplateRender.renderSSRUrlInternal");
        String[] processUrl = processUrl(str);
        setUrl(processUrl[0]);
        updateGenericInfoURL(processUrl[0]);
        LLog.m2578i(TAG, formatLynxMessage("renderTemplate"));
        LynxTemplateResourceFetcher templateResourceFetcher = this.mLynxContext.getTemplateResourceFetcher();
        if (templateResourceFetcher != null) {
            templateResourceFetcher.fetchSSRData(new LynxResourceRequest(str, LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate), new LynxResourceCallback<byte[]>() { // from class: com.lynx.tasm.LynxTemplateRender.2
                public void onResponse(LynxResourceResponse<byte[]> lynxResourceResponse) {
                    int i = C148411.f2304x51ec6ea4[lynxResourceResponse.getState().ordinal()];
                    if (i == 1) {
                        innerSSRLoadedCallback.onSuccess((byte[]) lynxResourceResponse.getData());
                    } else {
                        if (i != 2) {
                            return;
                        }
                        innerSSRLoadedCallback.onFailed(lynxResourceResponse.getError().getMessage());
                    }
                }
            });
        } else {
            legacyLoadTemplateWithProvider(str, innerSSRLoadedCallback);
        }
        onTraceEventEnd("LynxTemplateRender.renderSSRUrlInternal");
    }

    private void renderTemplateUrlInternal(String str, InnerLoadedCallback innerLoadedCallback) {
        if (!checkIfEnvPrepared()) {
            onErrorOccurred(LynxSubErrorCode.E_APP_BUNDLE_LOAD_ENV_NOT_READY, "LynxEnv has not been prepared successfully!");
            return;
        }
        onTraceEventBegin("LynxTemplateRender.renderTemplate");
        if (str != null) {
            String[] processUrl = processUrl(str);
            setUrl(processUrl[0]);
            if (this.mDevTool != null) {
                this.mDevTool.onLoadFromURL(processUrl[0], processUrl[1], innerLoadedCallback.metaData != null ? innerLoadedCallback.metaData.initialData : innerLoadedCallback.mTemplateData, innerLoadedCallback.mData, innerLoadedCallback.mJsonData);
            }
        }
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext == null) {
            LLog.m2577e(TAG, "renderTemplate error, can't get LynxContext in " + toString());
            return;
        }
        if (this.mLynxViewGroup != null) {
            loadTemplateWithLynxViewGroup(innerLoadedCallback);
        } else if (lynxContext.getTemplateResourceFetcher() != null) {
            loadTemplateWithGenericResourceFetcher(str, innerLoadedCallback);
        } else {
            legacyLoadTemplateWithProvider(str, innerLoadedCallback);
        }
        LLog.m2578i(TAG, formatLynxMessage("renderTemplate"));
        onTraceEventEnd("LynxTemplateRender.renderTemplate");
    }

    private void loadTemplateWithLynxViewGroup(final InnerLoadedCallback innerLoadedCallback) {
        this.mLynxViewGroup.fetchTemplateBundle(new LynxResourceCallback() { // from class: com.lynx.tasm.LynxTemplateRender$$ExternalSyntheticLambda1
            public final void onResponse(LynxResourceResponse lynxResourceResponse) {
                LynxTemplateRender.lambda$loadTemplateWithLynxViewGroup$1(LynxTemplateRender.InnerLoadedCallback.this, lynxResourceResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$loadTemplateWithLynxViewGroup$1(InnerLoadedCallback innerLoadedCallback, LynxResourceResponse lynxResourceResponse) {
        int i = C148411.f2304x51ec6ea4[lynxResourceResponse.getState().ordinal()];
        if (i == 1) {
            innerLoadedCallback.onSuccess((TemplateBundle) lynxResourceResponse.getData());
        } else {
            if (i != 2) {
                return;
            }
            innerLoadedCallback.onFailed(lynxResourceResponse.getError().getMessage());
        }
    }

    private void loadTemplateWithGenericResourceFetcher(String str, final InnerLoadedCallback innerLoadedCallback) {
        LynxTemplateResourceFetcher templateResourceFetcher = this.mLynxContext.getTemplateResourceFetcher();
        if (templateResourceFetcher != null) {
            templateResourceFetcher.fetchTemplate(new LynxResourceRequest(str, LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate), new LynxResourceCallback() { // from class: com.lynx.tasm.LynxTemplateRender$$ExternalSyntheticLambda2
                public final void onResponse(LynxResourceResponse lynxResourceResponse) {
                    LynxTemplateRender.lambda$loadTemplateWithGenericResourceFetcher$2(LynxTemplateRender.InnerLoadedCallback.this, lynxResourceResponse);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$loadTemplateWithGenericResourceFetcher$2(InnerLoadedCallback innerLoadedCallback, LynxResourceResponse lynxResourceResponse) {
        int i = C148411.f2304x51ec6ea4[lynxResourceResponse.getState().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            innerLoadedCallback.onFailed(lynxResourceResponse.getError().getMessage());
            return;
        }
        TemplateBundle templateBundle = ((TemplateProviderResult) lynxResourceResponse.getData()).getTemplateBundle();
        if (templateBundle != null && templateBundle.isValid()) {
            innerLoadedCallback.onSuccess(templateBundle);
        } else if (((TemplateProviderResult) lynxResourceResponse.getData()).getTemplateBuffer() != null) {
            innerLoadedCallback.onSuccess(((TemplateProviderResult) lynxResourceResponse.getData()).getTemplateBuffer());
        } else {
            innerLoadedCallback.onSuccess(((TemplateProviderResult) lynxResourceResponse.getData()).getTemplateBinary());
        }
    }

    private void legacyLoadTemplateWithProvider(String str, AbsTemplateProvider.Callback callback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("LynxTemplateRender template url is null or TemplateProvider is not init");
        }
        dispatchOnPageStart(this.mUrl);
        this.mPerformanceController.markTiming(TimingHandler.PREPARE_TEMPLATE_START, (String) null);
        this.mTemplateProvider.loadTemplate(this.mUrl, callback);
    }

    private boolean checkIfEnvPrepared() {
        return this.mHasEnvPrepared;
    }

    public void renderTemplateWithBaseUrl(byte[] bArr, TemplateData templateData, String str) {
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onLoadFromLocalFile(bArr, templateData, str);
        }
        setUrl(str);
        renderTemplate(bArr, templateData);
        LLog.m2578i(TAG, formatLynxMessage("renderTemplate"));
    }

    public void renderTemplateWithBaseUrl(byte[] bArr, Map<String, Object> map, String str) {
        TemplateData fromMap = TemplateData.fromMap(map);
        fromMap.markReadOnly();
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onLoadFromLocalFile(bArr, fromMap, str);
        }
        setUrl(str);
        renderTemplate(bArr, fromMap);
        LLog.m2578i(TAG, formatLynxMessage("renderTemplate"));
    }

    public void renderTemplateWithBaseUrl(byte[] bArr, String str, String str2) {
        TemplateData fromString = TemplateData.fromString(str);
        fromString.markReadOnly();
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onLoadFromLocalFile(bArr, fromString, str2);
        }
        setUrl(str2);
        renderTemplate(bArr, fromString);
        LLog.m2578i(TAG, formatLynxMessage("renderTemplate"));
    }

    public void ssrHydrateWithBaseUrl(byte[] bArr, Map<String, Object> map, String str) {
        LynxSSRHelper lynxSSRHelper = this.mSSRHelper;
        if (lynxSSRHelper != null && lynxSSRHelper.isHydratePending()) {
            this.mSSRHelper.onHydrateStart();
        }
        renderTemplateWithBaseUrl(bArr, map, str);
    }

    public void ssrHydrateWithBaseUrl(byte[] bArr, TemplateData templateData, String str) {
        LynxSSRHelper lynxSSRHelper = this.mSSRHelper;
        if (lynxSSRHelper != null && lynxSSRHelper.isHydratePending()) {
            this.mSSRHelper.onHydrateStart();
        }
        renderTemplateWithBaseUrl(bArr, templateData, str);
    }

    private void setUrl(String str) {
        this.mUrl = str;
        LynxEnv.inst().setLastUrl(this.mUrl);
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxContext.setTemplateUrl(this.mUrl);
        }
    }

    private void prepareLynxEngineIfNeeded() {
        if (!checkIfEnvPrepared()) {
            onErrorOccurred(LynxSubErrorCode.E_APP_BUNDLE_LOAD_ENV_NOT_READY, "LynxEnv has not been prepared successfully!");
            return;
        }
        if (this.mSSRHelper != null) {
            onLoadTemplateFromSSRPage();
        }
        this.mWillContentSizeChange = true;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeMarkDirty(j, this.mNativeLifecycle);
        }
        reloadAndInit();
        updateGenericInfoURL(this.mUrl);
        NativeFacade nativeFacade = this.mNativeFacade;
        if (nativeFacade != null) {
            nativeFacade.setTemplateLoadClient(this.mClient);
            dispatchOnPageStart(this.mUrl);
            LynxDevtool lynxDevtool = this.mDevTool;
            if (lynxDevtool != null) {
                lynxDevtool.attachToDebugBridge(this.mUrl);
            }
        }
    }

    private void updateGenericInfoURL(String str) {
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext == null || !lynxContext.enableEventReporter() || str == null) {
            return;
        }
        int instanceId = this.mLynxContext.getInstanceId();
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("relative_path", str);
        LynxEventReporter.updateGenericInfo(hashMap, instanceId);
        LynxInfoReportHelper lynxInfoReportHelper = this.mReportHelper;
        if (lynxInfoReportHelper != null) {
            lynxInfoReportHelper.reportLynxCrashContext(LynxInfoReportHelper.KEY_LAST_LYNX_URL, str);
        }
    }

    public void renderTemplate(final byte[] bArr, final Map<String, Object> map) {
        if (this.mHasDestroy) {
            return;
        }
        if ((!this.mAsyncRender || this.reload) && !UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.3
                @Override // java.lang.Runnable
                public void run() {
                    LynxTemplateRender.this.renderTemplate(bArr, map);
                }
            });
            return;
        }
        TimingOption createTimingOption = TimingOption.createTimingOption("loadBundle", "loadBundleStart");
        if (this.mPerformanceController.isEmbeddedMode()) {
            this.mPerformanceController.markTiming("loadBundleStart", (String) null);
        }
        prepareLynxEngineIfNeeded();
        if (this.mNativePtr != 0) {
            loadTemplate(bArr, map, getTemplateUrl(), new TASMCallback(), createTimingOption);
        }
    }

    public void renderTemplate(final byte[] bArr, final TemplateData templateData) {
        if (this.mHasDestroy) {
            return;
        }
        if ((!this.mAsyncRender || this.reload) && !UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.4
                @Override // java.lang.Runnable
                public void run() {
                    LynxTemplateRender.this.renderTemplate(bArr, templateData);
                }
            });
            return;
        }
        TimingOption createTimingOption = TimingOption.createTimingOption("loadBundle", "loadBundleStart");
        if (this.mPerformanceController.isEmbeddedMode()) {
            this.mPerformanceController.markTiming("loadBundleStart", (String) null);
        }
        prepareLynxEngineIfNeeded();
        if (this.mNativePtr != 0) {
            loadTemplate(bArr, templateData, getTemplateUrl(), new TASMCallback(), createTimingOption);
        }
        postRenderOrUpdateData(templateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderTemplate(final byte[] bArr, final String str, final TimingOption timingOption) {
        if (this.mHasDestroy) {
            return;
        }
        if ((!this.mAsyncRender || this.reload) && !UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.5
                @Override // java.lang.Runnable
                public void run() {
                    LynxTemplateRender.this.renderTemplate(bArr, str, timingOption);
                }
            });
            return;
        }
        prepareLynxEngineIfNeeded();
        if (this.mNativePtr != 0) {
            loadTemplate(bArr, str, getTemplateUrl(), new TASMCallback(), timingOption);
        }
    }

    public void renderTemplateBundle(final TemplateBundle templateBundle, final TemplateData templateData, final String str) {
        if (this.mHasDestroy) {
            return;
        }
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onLoadFromBundle(templateBundle, templateData, str);
        }
        if ((!this.mAsyncRender || this.reload) && !UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.6
                @Override // java.lang.Runnable
                public void run() {
                    LynxTemplateRender.this.renderTemplateBundle(templateBundle, templateData, str);
                }
            });
            return;
        }
        if (this.mEnableReuseEngine) {
            if (tryRenderByReuseLynxRender(templateData)) {
                return;
            } else {
                this.mEmbeddedPipelineCounter.incrementAndGet();
            }
        }
        onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_RENDER_TEMPLATE_BUNDLE);
        TimingOption createTimingOption = TimingOption.createTimingOption("loadBundle", "loadBundleStart");
        if (this.mPerformanceController.isEmbeddedMode()) {
            this.mPerformanceController.markTiming("loadBundleStart", (String) null);
        }
        setUrl(str);
        prepareLynxEngineIfNeeded();
        LLog.m2578i(TAG, formatLynxMessage("renderTemplate"));
        if (this.mNativePtr != 0) {
            loadTemplateBundle(templateBundle, str, templateData, false, 0, new TASMCallback(), createTimingOption);
        }
        postRenderOrUpdateData(templateData);
        onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_RENDER_TEMPLATE_BUNDLE);
    }

    @Override // com.lynx.tasm.ILynxEngine
    public void loadTemplate(final LynxLoadMeta lynxLoadMeta) {
        if (this.mHasDestroy) {
            return;
        }
        onTraceEventBegin("LynxTemplateRender.loadTemplateWithMeta");
        if ((!this.mAsyncRender || this.reload) && !UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.7
                @Override // java.lang.Runnable
                public void run() {
                    LynxTemplateRender.this.loadTemplate(lynxLoadMeta);
                }
            });
            onTraceEventEnd("LynxTemplateRender.loadTemplateWithMeta");
            return;
        }
        if (lynxLoadMeta.getLoadMode() == LynxLoadMode.PRE_PAINTING) {
            UIBody.UIBodyView uIBodyView = this.mBodyView;
            if (uIBodyView != null) {
                uIBodyView.setShouldInterceptRequestLayout(true);
            }
            this.mLynxContext.setInPreLoad(true);
        }
        if (lynxLoadMeta.getLoadMode() == LynxLoadMode.RENDER_SSR) {
            renderSSRWithMetaData(lynxLoadMeta);
            onTraceEventEnd("LynxTemplateRender.loadTemplateWithMeta");
            return;
        }
        LynxSSRHelper lynxSSRHelper = this.mSSRHelper;
        if (lynxSSRHelper != null && lynxSSRHelper.isHydratePending() && lynxLoadMeta.getLoadMode() == LynxLoadMode.HYDRATE_SSR) {
            this.mSSRHelper.onHydrateStart();
        }
        TimingOption createTimingOption = TimingOption.createTimingOption("loadBundle", "loadBundleStart");
        if (this.mPerformanceController.isEmbeddedMode()) {
            this.mPerformanceController.markTiming("loadBundleStart", (String) null);
        }
        setUrl(lynxLoadMeta.getUrl());
        renderWithLoadMeta(lynxLoadMeta, createTimingOption);
        LLog.m2578i(TAG, formatLynxMessage("renderTemplate"));
        if (lynxLoadMeta.initialData != null) {
            postRenderOrUpdateData(lynxLoadMeta.initialData);
        }
        onTraceEventEnd("LynxTemplateRender.loadTemplateWithMeta");
    }

    private void initLynxEngineWithLoadMeta(LynxLoadMeta lynxLoadMeta) {
        String str;
        if (this.mNativePtr != 0) {
            if (lynxLoadMeta.enableProcessLayout()) {
                setEnableUIFlush(false);
            }
            Map<String, String> map = lynxLoadMeta.lynxViewConfig;
            if (map == null || map.isEmpty()) {
                map = this.mOriginLynxViewConfig;
            }
            if (map != null && (str = map.get(LynxViewBuilderProperty.PLATFORM_CONFIG.getKey())) != null) {
                nativeSetPlatformConfig(this.mNativePtr, this.mNativeLifecycle, str);
            }
            ILynxViewGroup iLynxViewGroup = this.mLynxViewGroup;
            if (iLynxViewGroup != null) {
                updateGlobalProps(iLynxViewGroup.getGlobalProps());
            }
            if (lynxLoadMeta.isGlobalPropsValid()) {
                updateGlobalProps(lynxLoadMeta.getGlobalProps());
            }
        }
    }

    private boolean tryRenderByReuseLynxRender(TemplateData templateData) {
        onTraceEventBegin("LynxTemplateRender.tryRenderByReuseLynxRender");
        LynxEngine lynxEngine = this.mLynxEngineRef;
        if (lynxEngine == null) {
            tryReuseLynxEngineFromPool();
            if (this.mLynxEngineRef != null) {
                LLog.m2578i(TAG, "call nativeReattachLynxEngineWrapper." + this);
                long j = this.mNativePtr;
                long j2 = this.mNativeLifecycle;
                long nativePtr = this.mLynxEngineRef.getNativePtr();
                LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
                nativeReattachLynxEngineWrapper(j, j2, nativePtr, lynxEngineProxy != null ? lynxEngineProxy.getNativePtr() : 0L);
                if (this.mThreadStrategyForRendering == ThreadStrategyForRendering.ALL_ON_UI && this.mThreadStrategyForRendering != this.mLynxEngineRef.getThreadStrategy()) {
                    attachEngineToUIThread();
                }
                if (getLynxView() != null && getLynxView().getCurrentWidthMeasureSpec() >= 0 && getLynxView().getCurrentHeightMeasureSpec() >= 0) {
                    updateViewport(getLynxView().getCurrentWidthMeasureSpec(), getLynxView().getCurrentHeightMeasureSpec(), false);
                }
                dispatchOnPageStart(this.mUrl);
                updateData(templateData, true);
                onTraceEventEnd("LynxTemplateRender.tryRenderByReuseLynxRender");
                return true;
            }
            fallbackNewEngine(false);
        } else if (lynxEngine.hasLoaded()) {
            if (getLynxView() != null && getLynxView().getCurrentWidthMeasureSpec() >= 0 && getLynxView().getCurrentHeightMeasureSpec() >= 0) {
                updateViewport(getLynxView().getCurrentWidthMeasureSpec(), getLynxView().getCurrentHeightMeasureSpec(), false);
            }
            dispatchOnPageStart(this.mUrl);
            updateData(templateData, true);
            onTraceEventEnd("LynxTemplateRender.tryRenderByReuseLynxRender");
            return true;
        }
        onTraceEventEnd("LynxTemplateRender.tryRenderByReuseLynxRender");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderWithLoadMeta(LynxLoadMeta lynxLoadMeta, TimingOption timingOption) {
        TemplateBundle templateBundle;
        LynxLoadMode lynxLoadMode = lynxLoadMeta.loadMode;
        boolean z = LynxLoadMode.PRE_PAINTING == lynxLoadMode || LynxLoadMode.PRE_PAINTING_DRAW == lynxLoadMode;
        if (this.mLynxContext == null) {
            LLog.m2577e(TAG, "renderWithLoadMeta with null LynxContext");
            return;
        }
        if (this.mLogicExecutor != null && lynxLoadMeta.getInitialData() != null) {
            lynxLoadMeta.getInitialData().setEnableJSData(false);
            this.mTemplateData.updateWithTemplateData(lynxLoadMeta.getInitialData());
        }
        if (this.mEnableReuseEngine && tryRenderByReuseLynxRender(lynxLoadMeta.initialData)) {
            return;
        }
        if (this.mLynxContext.isEmbeddedModeOn() && getLynxView() != null && getLynxView().getCurrentWidthMeasureSpec() >= 0 && getLynxView().getCurrentHeightMeasureSpec() >= 0) {
            updateViewport(getLynxView().getCurrentWidthMeasureSpec(), getLynxView().getCurrentHeightMeasureSpec(), false);
        }
        if (lynxLoadMeta.isBundleValid() || ((templateBundle = this.mTemplateBundle) != null && templateBundle.isValid())) {
            if (this.mEnableReuseEngine) {
                this.mEmbeddedPipelineCounter.incrementAndGet();
            }
            TemplateBundle templateBundle2 = lynxLoadMeta.isBundleValid() ? lynxLoadMeta.bundle : this.mTemplateBundle;
            LynxDevtool lynxDevtool = this.mDevTool;
            if (lynxDevtool != null) {
                lynxDevtool.onLoadFromBundle(templateBundle2, lynxLoadMeta.initialData, lynxLoadMeta.url);
            }
            prepareLynxEngineIfNeeded();
            initLynxEngineWithLoadMeta(lynxLoadMeta);
            LLog.m2578i(TAG, "LoadMeta with bundle, pre-painting: " + z + " ,pre-painting with draw:" + (LynxLoadMode.PRE_PAINTING_DRAW == lynxLoadMode) + " enableDumpElementTree: " + lynxLoadMeta.enableDumpElementTree());
            loadTemplateBundle(templateBundle2, lynxLoadMeta.url, lynxLoadMeta.initialData, z, lynxLoadMeta.loadOptions, new TASMCallback(), timingOption);
            return;
        }
        if (lynxLoadMeta.isByteBufferValid()) {
            if (this.mEnableReuseEngine) {
                this.mEmbeddedPipelineCounter.incrementAndGet();
            }
            prepareLynxEngineIfNeeded();
            initLynxEngineWithLoadMeta(lynxLoadMeta);
            boolean enableRecycleTemplateBundle = lynxLoadMeta.enableRecycleTemplateBundle();
            LLog.m2578i(TAG, "LoadMeta with ByteBuffer, pre-painting: " + z + " ,pre-painting with draw:" + (LynxLoadMode.PRE_PAINTING_DRAW == lynxLoadMode) + " enableRecycleTemplateBundle: " + enableRecycleTemplateBundle);
            loadTemplateByteBuffer(lynxLoadMeta.byteBuffer, lynxLoadMeta.initialData, lynxLoadMeta.url, z, lynxLoadMeta.loadOptions, enableRecycleTemplateBundle, new TASMCallback(), timingOption);
            return;
        }
        if (lynxLoadMeta.isBinaryValid()) {
            if (this.mEnableReuseEngine) {
                this.mEmbeddedPipelineCounter.incrementAndGet();
            }
            LynxDevtool lynxDevtool2 = this.mDevTool;
            if (lynxDevtool2 != null) {
                lynxDevtool2.onLoadFromLocalFile(lynxLoadMeta.binaryData, lynxLoadMeta.initialData, lynxLoadMeta.url);
            }
            prepareLynxEngineIfNeeded();
            initLynxEngineWithLoadMeta(lynxLoadMeta);
            boolean enableRecycleTemplateBundle2 = lynxLoadMeta.enableRecycleTemplateBundle();
            LLog.m2578i(TAG, "LoadMeta with binary, pre-painting: " + z + " ,pre-painting with draw:" + (LynxLoadMode.PRE_PAINTING_DRAW == lynxLoadMode) + " enableRecycleTemplateBundle: " + enableRecycleTemplateBundle2);
            loadTemplate(lynxLoadMeta.binaryData, lynxLoadMeta.initialData, lynxLoadMeta.url, z, enableRecycleTemplateBundle2, new TASMCallback(), timingOption);
            return;
        }
        LLog.m2578i(TAG, "LoadMeta with url, pre-painting: " + z + " ,pre-painting with draw:" + (LynxLoadMode.PRE_PAINTING_DRAW == lynxLoadMode) + " url: " + lynxLoadMeta.url);
        renderTemplateUrlInternal(lynxLoadMeta.url, new InnerLoadedCallback(lynxLoadMeta.url, lynxLoadMeta));
    }

    private void renderSSRWithMetaData(LynxLoadMeta lynxLoadMeta) {
        if (lynxLoadMeta.isBinaryValid()) {
            renderSSR(lynxLoadMeta.binaryData, lynxLoadMeta.url, lynxLoadMeta.initialData);
        } else if (!lynxLoadMeta.url.isEmpty()) {
            renderSSRUrlInternal(lynxLoadMeta.url, new InnerSSRLoadedCallback(lynxLoadMeta.url, lynxLoadMeta.initialData));
        } else {
            LLog.m2577e(TAG, "SSR rendering failed: Binary data is invalid or URL is empty.");
        }
    }

    public void renderSSR(final byte[] bArr, final String str, final TemplateData templateData) {
        if (this.mHasDestroy) {
            return;
        }
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onLoadFromLocalFile(bArr, templateData, str);
        }
        if ((!this.mAsyncRender || this.reload) && !UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.8
                @Override // java.lang.Runnable
                public void run() {
                    LynxTemplateRender.this.renderSSR(bArr, str, templateData);
                }
            });
            return;
        }
        prepareForRenderSSR(bArr, str);
        if (this.mNativePtr != 0) {
            loadSSRData(bArr, templateData, new TASMCallback());
        }
        postRenderOrUpdateData(templateData);
    }

    public void renderSSR(byte[] bArr, String str, Map<String, Object> map) {
        TemplateData fromMap = TemplateData.fromMap(map);
        fromMap.markReadOnly();
        renderSSR(bArr, str, fromMap);
    }

    public void prepareForRenderSSR(byte[] bArr, String str) {
        setUrl(str);
        updateGenericInfoURL(str);
        LLog.m2578i(TAG, formatLynxMessage("renderTemplate"));
        if (!checkIfEnvPrepared()) {
            onErrorOccurred(LynxSubErrorCode.E_SSR_LOAD_UNINITIALIZED, "LynxEnv has not been prepared successfully!");
            return;
        }
        this.mWillContentSizeChange = true;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeMarkDirty(j, this.mNativeLifecycle);
        }
        reloadAndInit();
        LynxSSRHelper lynxSSRHelper = new LynxSSRHelper();
        this.mSSRHelper = lynxSSRHelper;
        lynxSSRHelper.onLoadSSRDataStart();
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null && lynxContext.enableEventReporter()) {
            LynxEventReporter.updateGenericInfo("enable_ssr", true, this.mLynxContext.getInstanceId());
        }
        long j2 = this.mNativePtr;
        if (j2 != 0) {
            nativeSetSSRTimingData(j2, this.mNativeLifecycle, str, bArr.length);
        }
    }

    public String getTemplateUrl() {
        String str = this.mUrl;
        return str == null ? "" : str;
    }

    public void setTheme(LynxTheme lynxTheme) {
        if (lynxTheme == null) {
            return;
        }
        LynxTheme lynxTheme2 = this.mTheme;
        if (lynxTheme2 == null) {
            this.mTheme = lynxTheme;
        } else {
            lynxTheme2.replaceWithTheme(lynxTheme);
        }
        if (!checkIfEnvPrepared() || this.mNativePtr == 0) {
            return;
        }
        setThemeInternal(lynxTheme);
    }

    public void setTheme(ByteBuffer byteBuffer) {
        if (checkIfEnvPrepared()) {
            long j = this.mNativePtr;
            if (j == 0) {
                return;
            }
            nativeUpdateConfig(j, this.mNativeLifecycle, byteBuffer, byteBuffer.position());
        }
    }

    public LynxTheme getTheme() {
        return this.mTheme;
    }

    public void updateData(String str, String str2) {
        TemplateData fromString = TemplateData.fromString(str);
        fromString.markState(str2);
        fromString.markReadOnly();
        updateData(fromString, false);
    }

    public TemplateData getTemplateData() {
        return this.mTemplateData.shallowClone();
    }

    @Override // com.lynx.tasm.ILynxEngine
    public void updateMetaData(LynxUpdateMeta lynxUpdateMeta) {
        String str;
        TemplateData templateData;
        LynxDevtool lynxDevtool;
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext == null) {
            return;
        }
        onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_UPDATE_META_DATE);
        if (lynxContext.isEmbeddedModeOn()) {
            this.mPerformanceController.markTiming("updateDataStart", "");
        }
        TemplateData updatedData = lynxUpdateMeta.getUpdatedData();
        if (this.mLynxContext != null && this.mLogicExecutor != null && updatedData != null) {
            updatedData.setEnableJSData(false);
            this.mTemplateData.updateWithTemplateData(updatedData);
        }
        if (updatedData != null && (lynxDevtool = this.mDevTool) != null) {
            lynxDevtool.onTemplateDataChanged(updatedData);
        }
        if (this.mEnableReuseEngine) {
            if (this.mLynxEngineRef == null) {
                tryReuseLynxEngineFromPool();
                if (this.mLynxEngineRef == null) {
                    fallbackNewEngine(false);
                    renderTemplateBundle(this.mTemplateBundle, this.mTemplateData, this.mUrl);
                    onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_UPDATE_META_DATE);
                    return;
                }
                LLog.m2578i(TAG, "call nativeReattachLynxEngineWrapper");
                long j = this.mNativePtr;
                long j2 = this.mNativeLifecycle;
                long nativePtr = this.mLynxEngineRef.getNativePtr();
                LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
                long nativePtr2 = lynxEngineProxy != null ? lynxEngineProxy.getNativePtr() : 0L;
                str = TAG;
                nativeReattachLynxEngineWrapper(j, j2, nativePtr, nativePtr2);
                if (this.mThreadStrategyForRendering == ThreadStrategyForRendering.ALL_ON_UI && this.mThreadStrategyForRendering != this.mLynxEngineRef.getThreadStrategy()) {
                    attachEngineToUIThread();
                }
            } else {
                str = TAG;
            }
            this.mEmbeddedPipelineCounter.incrementAndGet();
        } else {
            str = TAG;
        }
        if (lynxContext.isInPreLoad()) {
            LLog.m2578i(str, "updateData after pre load, url:" + this.mUrl);
            UIBody.UIBodyView uIBodyView = this.mBodyView;
            if (uIBodyView != null) {
                uIBodyView.setShouldInterceptRequestLayout(false);
            }
            lynxContext.setInPreLoad(false);
        }
        if (lynxUpdateMeta.getUpdatedGlobalProps() != null) {
            internalMergeGlobalPropsSafely(lynxUpdateMeta.getUpdatedGlobalProps());
            templateData = this.globalProps;
        } else {
            templateData = null;
        }
        if (this.mNativePtr != 0) {
            updateMetaDataInternal(updatedData, templateData);
        }
        onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_UPDATE_META_DATE);
    }

    private synchronized void internalMergeGlobalPropsSafely(TemplateData templateData) {
        if (this.globalProps == null) {
            this.globalProps = TemplateData.fromMap(new HashMap());
        }
        this.globalProps.updateWithTemplateData(templateData);
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onGlobalPropsChanged(this.globalProps);
        }
    }

    private synchronized void recycleGlobalPropsSafely() {
        TemplateData templateData = this.globalProps;
        if (templateData != null) {
            templateData.recycle();
            this.globalProps = null;
        }
    }

    private boolean prepareUpdateData(TemplateData templateData) {
        if (!checkIfEnvPrepared() || this.mNativePtr == 0) {
            return false;
        }
        if (templateData == null) {
            LLog.m2577e(TAG, "updateData with null TemplateData");
            return false;
        }
        templateData.flush();
        if (templateData.getNativePtr() == 0) {
            LLog.m2577e(TAG, "updateData with TemplateData after flush is nullptr");
            return false;
        }
        this.mWillContentSizeChange = true;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeMarkDirty(j, this.mNativeLifecycle);
        }
        return true;
    }

    private void postRenderOrUpdateData(TemplateData templateData) {
        if (templateData != null) {
            if (LynxEnv.inst().enableDataListFix()) {
                templateData.bindContext(this.mLynxContext);
            } else {
                this.updatedDataList.add(templateData);
            }
        }
    }

    public void updateData(TemplateData templateData, boolean z) {
        LynxDevtool lynxDevtool;
        onTraceEventBegin("LynxTemplateRender.updateData");
        if (templateData != null && (lynxDevtool = this.mDevTool) != null) {
            lynxDevtool.onTemplateDataChanged(templateData);
        }
        if (this.mEnableReuseEngine) {
            this.mEmbeddedPipelineCounter.incrementAndGet();
        }
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext == null) {
            return;
        }
        if (lynxContext.isInPreLoad()) {
            LLog.m2578i(TAG, "updateData after pre load, url:" + this.mUrl);
            UIBody.UIBodyView uIBodyView = this.mBodyView;
            if (uIBodyView != null) {
                uIBodyView.setShouldInterceptRequestLayout(false);
            }
            lynxContext.setInPreLoad(false);
        }
        if (prepareUpdateData(templateData)) {
            templateData.markConsumed();
            nativeUpdateDataByPreParsedData(this.mNativePtr, this.mNativeLifecycle, templateData.getNativePtr(), templateData.processorName(), templateData.isReadOnly(), templateData, z);
        }
        postRenderOrUpdateData(templateData);
        onTraceEventEnd("LynxTemplateRender.updateData");
    }

    public void resetData(TemplateData templateData) {
        LynxDevtool lynxDevtool;
        onTraceEventBegin("LynxTemplateRender.resetData");
        if (prepareUpdateData(templateData)) {
            if (templateData != null && (lynxDevtool = this.mDevTool) != null) {
                lynxDevtool.onTemplateDataReset(templateData);
            }
            nativeResetDataByPreParsedData(this.mNativePtr, this.mNativeLifecycle, templateData.getNativePtr(), templateData.processorName(), templateData.isReadOnly(), templateData);
        }
        postRenderOrUpdateData(templateData);
        LLog.m2578i(TAG, formatLynxMessage("reset"));
        onTraceEventEnd("LynxTemplateRender.resetData");
    }

    public void reloadTemplate(TemplateData templateData, TemplateData templateData2) {
        long j;
        LLog.m2576d(TAG, "reloadTemplate with url: " + getTemplateUrl());
        onTraceEventBegin("LynxTemplateRender.reloadTemplate");
        TimingOption createTimingOption = TimingOption.createTimingOption("reloadBundleFromNative", "reloadBundleStart");
        if (prepareUpdateData(templateData)) {
            if (templateData2 != null) {
                this.globalProps = templateData2;
            }
            LynxViewClientV2.LynxPipelineInfo lynxPipelineInfo = new LynxViewClientV2.LynxPipelineInfo(this.mUrl);
            lynxPipelineInfo.addPipelineOrigin(LynxViewClientV2.LynxPipelineInfo.LynxPipelineOrigin.LYNX_RELOAD);
            this.mClientV2.onPageStarted(getLynxView(), lynxPipelineInfo);
            if (templateData2 != null) {
                templateData2.flush();
                j = templateData2.getNativePtr();
            } else {
                j = 0;
            }
            long j2 = j;
            LynxContext lynxContext = this.mLynxContext;
            if (lynxContext != null && lynxContext.getEnableExposureWhenReload()) {
                this.mLynxContext.stopExposure();
                this.mLynxContext.resumeExposure();
            }
            createTimingOption.markTiming("ffiStart");
            nativeReloadTemplate(this.mNativePtr, this.mNativeLifecycle, templateData.getNativePtr(), j2, templateData.processorName(), templateData.isReadOnly(), templateData2, templateData, createTimingOption.toJavaOnlyMap());
        }
        postRenderOrUpdateData(templateData);
        LLog.m2578i(TAG, formatLynxMessage(WebViewContainer.EVENT_reload));
        onTraceEventEnd("LynxTemplateRender.reloadTemplate");
    }

    public void preloadLazyBundles(String[] strArr) {
        nativePreloadLazyBundles(this.mNativePtr, this.mNativeLifecycle, strArr);
    }

    public void getCurrentData(LynxGetDataCallback lynxGetDataCallback) {
        if (!checkIfEnvPrepared() || this.mNativePtr == 0) {
            lynxGetDataCallback.onFail("LynxView Not Initialized Yet");
            return;
        }
        int incrementAndGet = this.mLynxGetDataCounter.incrementAndGet();
        this.mCallbackSparseArray.put(incrementAndGet, lynxGetDataCallback);
        nativeGetDataAsync(this.mNativePtr, this.mNativeLifecycle, incrementAndGet);
    }

    public Map<String, Object> getPageDataByKey(String[] strArr) {
        if (!checkIfEnvPrepared()) {
            return null;
        }
        long j = this.mNativePtr;
        if (j == 0) {
            return null;
        }
        Object nativeGetPageDataByKey = nativeGetPageDataByKey(j, this.mNativeLifecycle, strArr);
        HashMap hashMap = new HashMap();
        if (nativeGetPageDataByKey instanceof Map) {
            hashMap.putAll((Map) nativeGetPageDataByKey);
        }
        return hashMap;
    }

    public void updateData(Map<String, Object> map, String str) {
        TemplateData fromMap = TemplateData.fromMap(map);
        fromMap.markState(str);
        fromMap.markReadOnly();
        updateData(fromMap, false);
        LLog.m2578i(TAG, formatLynxMessage(RENDER_PHASE_UPDATE));
    }

    public void onMeasure(int i, int i2) {
        markEngineInUse();
        LynxContext lynxContext = this.mLynxContext;
        boolean willProcessTask = lynxContext != null ? LynxLongTaskMonitor.willProcessTask("LynxTemplateRender.Measure", lynxContext.getInstanceId(), this.mLongTaskMonitorEnabled) : false;
        long currentTimeMillis = this.mFirstMeasureTime == -1 ? System.currentTimeMillis() : 0L;
        if (this.mForceLayoutOnBackgroundThread && !this.mAsyncRender) {
            maybeSyncLayoutResultDuringLayoutOnBackgroundThread(i, i2);
        } else {
            if (this.mEnableSyncFlush) {
                syncFlush();
            }
            updateViewport(i, i2);
            if (this.mThreadStrategyForRendering == ThreadStrategyForRendering.PART_ON_LAYOUT) {
                long j = this.mNativePtr;
                if (j != 0 && this.mWillContentSizeChange) {
                    nativeSyncFetchLayoutResult(j, this.mNativeLifecycle);
                    this.mWillContentSizeChange = false;
                }
            }
            ViewLayoutTick viewLayoutTick = this.mViewLayoutTick;
            if (viewLayoutTick != null) {
                viewLayoutTick.triggerLayout();
            }
            if (getEnableVsyncAlignedFlush()) {
                nativeFlush(this.mNativePtr, this.mNativeLifecycle);
                this.mWillContentSizeChange = false;
            }
        }
        if (this.mFirstMeasureTime == -1) {
            this.mFirstMeasureTime = System.currentTimeMillis() - currentTimeMillis;
        }
        if (willProcessTask) {
            LynxLongTaskMonitor.didProcessTask();
        }
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.performInnerMeasure(i, i2);
        }
        markEngineIdle();
    }

    public void markHostPlatformTiming(String str) {
        PerformanceController performanceController = this.mPerformanceController;
        if (performanceController != null) {
            performanceController.markHostPlatformTiming(str);
        }
    }

    private void maybeSyncLayoutResultDuringLayoutOnBackgroundThread(int i, int i2) {
        if (!this.mWillContentSizeChange) {
            updateViewport(i, i2);
            if (getEnableVsyncAlignedFlush()) {
                nativeFlush(this.mNativePtr, this.mNativeLifecycle);
                return;
            }
            return;
        }
        if (this.mPreWidthMeasureSpec == i && this.mPreHeightMeasureSpec == i2 && !this.mShouldUpdateViewport) {
            nativeSyncFetchLayoutResult(this.mNativePtr, this.mNativeLifecycle);
            this.mWillContentSizeChange = false;
        } else {
            this.mShouldUpdateViewport = false;
            enforceRelayoutOnCurrentThreadWithUpdatedViewport(i, i2);
            this.mWillContentSizeChange = false;
        }
    }

    private void enforceRelayoutOnCurrentThreadWithUpdatedViewport(int i, int i2) {
        int fromMeasureSpec = MeasureMode.fromMeasureSpec(i);
        int size = View.MeasureSpec.getSize(i);
        int fromMeasureSpec2 = MeasureMode.fromMeasureSpec(i2);
        nativeEnforceRelayoutOnCurrentThreadWithUpdatedViewport(this.mNativePtr, this.mNativeLifecycle, size, fromMeasureSpec, View.MeasureSpec.getSize(i2), fromMeasureSpec2);
        this.mPreWidthMeasureSpec = i;
        this.mPreHeightMeasureSpec = i2;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ILynxUIRenderer iLynxUIRenderer;
        if ((this.mEnableReuseEngine && this.mLynxEngineRef == null) || (iLynxUIRenderer = this.mLynxUIRender) == null) {
            return;
        }
        iLynxUIRenderer.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceEventBegin(String str) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            LynxContext lynxContext = this.mLynxContext;
            if (lynxContext != null) {
                hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(lynxContext.getInstanceId()));
                hashMap.put(TraceEventDef.LYNX_VIEW, this.mLynxContext.getLynxView() != null ? this.mLynxContext.getLynxView().toString() : "null");
            }
            TraceEvent.beginSection(1L, str, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceEventEnd(String str) {
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(1L, str);
        }
    }

    private boolean getEnableVsyncAlignedFlush() {
        return this.mVsyncAlignedFlushEnabled && isVsyncAlignedFlushPageConfigEnabled();
    }

    private boolean isVsyncAlignedFlushPageConfigEnabled() {
        LynxContext lynxContext = this.mLynxContext;
        return lynxContext != null && lynxContext.getEnableVsyncAlignedFlush();
    }

    private boolean isThreadStrategySupportVsyncAlignedFlush() {
        return this.mThreadStrategyForRendering == ThreadStrategyForRendering.ALL_ON_UI || this.mThreadStrategyForRendering == ThreadStrategyForRendering.PART_ON_LAYOUT;
    }

    @Override // com.lynx.tasm.ILynxEngine
    public void updateViewport(int i, int i2) {
        updateViewport(i, i2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateViewport(int i, int i2, boolean z) {
        if (!checkIfEnvPrepared() || this.mNativePtr == 0) {
            return;
        }
        if (this.mPreWidthMeasureSpec == i && this.mPreHeightMeasureSpec == i2 && !this.mShouldUpdateViewport) {
            LLog.m2578i(TAG, "updateViewport is unnecessary, because the size of the cache are the same as the size to be set.");
            return;
        }
        if (this.mShouldUpdateViewport) {
            this.mShouldUpdateViewport = false;
        }
        int fromMeasureSpec = MeasureMode.fromMeasureSpec(i);
        int size = View.MeasureSpec.getSize(i);
        int fromMeasureSpec2 = MeasureMode.fromMeasureSpec(i2);
        nativeUpdateViewport(this.mNativePtr, this.mNativeLifecycle, size, fromMeasureSpec, View.MeasureSpec.getSize(i2), fromMeasureSpec2, this.mLynxContext.getScreenMetrics().density, this.mLynxUIRender.getUIDelegatePtr(), z);
        this.mPreWidthMeasureSpec = i;
        this.mPreHeightMeasureSpec = i2;
    }

    public void updateFontScale(float f) {
        if (checkIfEnvPrepared()) {
            long j = this.mNativePtr;
            if (j == 0) {
                return;
            }
            nativeUpdateFontScale(j, this.mNativeLifecycle, f);
        }
    }

    @Override // com.lynx.tasm.ILynxEngine
    public void destroy() {
        onTraceEventBegin("LynxTemplateRender.destroy");
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxContext.clearExposure();
        }
        recycleUpdatedDataList();
        destroyNative();
        onTraceEventBegin("Client.onReportComponentInfo");
        this.mClient.onReportComponentInfo(new HashSet());
        onTraceEventEnd("Client.onReportComponentInfo");
        recycleGlobalPropsSafely();
        ILynxExtensionService service = LynxServiceCenter.inst().getService(ILynxExtensionService.class);
        if (service != null) {
            service.onLynxViewDestroy(this.mLynxContext);
        }
        LynxContext lynxContext2 = this.mLynxContext;
        if (lynxContext2 != null && lynxContext2.getProviderRegistry() != null) {
            this.mLynxContext.getProviderRegistry().clear();
        }
        this.mLynxContext = null;
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.onDestroy();
        }
        LLog.m2578i(TAG, formatLynxMessage(WebViewContainer.EVENT_destroy));
        onTraceEventEnd("LynxTemplateRender.destroy");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroyNative();
    }

    private void recycleUpdatedDataList() {
        Iterator<TemplateData> it = this.updatedDataList.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.updatedDataList.clear();
    }

    private void destroyNative() {
        LynxModuleFactory lynxModuleFactory = this.mModuleFactory;
        if (lynxModuleFactory != null) {
            lynxModuleFactory.markLynxViewIsDestroying();
        }
        LLog.m2578i(TAG, "destroyNative url " + getTemplateUrl() + " in " + toString());
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.destroy();
            this.mDevTool = null;
        }
        if (this.mNativePtr != 0) {
            LynxContext lynxContext = this.mLynxContext;
            if (lynxContext != null && lynxContext.enableEventReporter()) {
                LynxEventReporter.clearCache(this.mLynxContext.getInstanceId());
            }
            destroyLynxEngine();
        }
        this.mHasDestroy = true;
    }

    public final ThreadStrategyForRendering getThreadStrategyForRendering() {
        return this.mThreadStrategyForRendering;
    }

    private void dispatchOnPageStart(String str) {
        LLog.m2578i(TAG, "dispatchOnPageStart url " + str + " in " + toString());
        if (this.mHasPageStart || this.mClient == null) {
            return;
        }
        this.mHasPageStart = true;
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null && lynxContext.enableEventReporter()) {
            LynxEventReporter.onEvent(EVENT_NAME_LYNX_OPEN_PAGE, (Map) null, this.mLynxContext.getInstanceId());
        }
        TraceEvent.instant(1L, TraceEventDef.TEMPLATE_RENDER_START_LOAD);
        onTraceEventBegin(TraceEventDef.CLIENT_ON_PAGE_START);
        this.mClient.onPageStart(str);
        LynxViewClientV2.LynxPipelineInfo lynxPipelineInfo = new LynxViewClientV2.LynxPipelineInfo(str);
        lynxPipelineInfo.addPipelineOrigin(LynxViewClientV2.LynxPipelineInfo.LynxPipelineOrigin.LYNX_FIRST_SCREEN);
        this.mClientV2.onPageStarted(getLynxView(), lynxPipelineInfo);
        onTraceEventEnd(TraceEventDef.CLIENT_ON_PAGE_START);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLoadSuccess(int i) {
        LLog.m2578i(TAG, "dispatchLoadSuccess templateSize in " + toString());
        if (this.mClient == null) {
            return;
        }
        onTraceEventBegin(TraceEventDef.CLIENT_ON_LOAD_SUCCESS);
        this.mClient.onLoadSuccess();
        onTraceEventEnd(TraceEventDef.CLIENT_ON_LOAD_SUCCESS);
    }

    @Deprecated
    public void onErrorOccurred(int i, String str) {
        onErrorOccurred(new LynxError(i, str, null, "error"));
    }

    @Override // com.lynx.tasm.ILynxErrorReceiver
    public void onErrorOccurred(final LynxError lynxError) {
        if (lynxError == null || !lynxError.isValid()) {
            LLog.m2577e(TAG, "receive invalid error");
            return;
        }
        lynxError.setTemplateUrl(this.mUrl);
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxError.setCardVersion(lynxContext.getPageVersion());
        }
        showErrorMessage(lynxError);
        LynxSSRHelper lynxSSRHelper = this.mSSRHelper;
        if (lynxSSRHelper != null) {
            lynxSSRHelper.onErrorOccurred(lynxError.getType(), lynxError);
        }
        if (!lynxError.isLogBoxOnly()) {
            LynxContext lynxContext2 = this.mLynxContext;
            if (lynxContext2 != null && lynxContext2.enableEventReporter()) {
                LynxContext lynxContext3 = this.mLynxContext;
                LynxEventReporter.onEvent("lynxsdk_error_event", lynxContext3 == null ? -1 : lynxContext3.getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.LynxTemplateRender.9
                    public Map<String, Object> build() {
                        HashMap hashMap = new HashMap();
                        hashMap.put("code", Integer.valueOf(lynxError.getErrorCode()));
                        hashMap.put("level", lynxError.getLevel() == null ? "" : lynxError.getLevel());
                        hashMap.put("summary_message", lynxError.getSummaryMessage());
                        return hashMap;
                    }
                });
            }
            dispatchError(lynxError.getType(), lynxError);
        }
        LLog.m2577e(TAG, "LynxTemplateRender " + toString() + ": onErrorOccurred type " + lynxError.getType() + ",errCode:" + lynxError.getErrorCode() + ",detail:" + lynxError.getMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExceptionOccurred(int i, Throwable th, JSONObject jSONObject) {
        if (th == null) {
            LLog.m2577e(TAG, "receive null exception");
            return;
        }
        String stackTraceStringTrimmed = CallStackUtil.getStackTraceStringTrimmed(th);
        LynxError lynxError = new LynxError(i, th.getMessage(), null, "error", -3);
        lynxError.setCallStack(stackTraceStringTrimmed);
        lynxError.setUserDefineInfo(jSONObject);
        onErrorOccurred(lynxError);
    }

    private void dispatchError(int i, LynxError lynxError) {
        onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_DISPATCH_ERROR);
        int errorCode = lynxError.getErrorCode();
        if (errorCode == 102) {
            this.mClient.onLoadFailed(lynxError.getMsg());
        } else {
            this.mClient.onReceivedError(lynxError.getMsg());
        }
        this.mClient.onReceivedError(lynxError);
        if (errorCode == 201) {
            this.mClient.onReceivedJSError(lynxError);
        } else if (i == -1) {
            this.mClient.onReceivedNativeError(lynxError);
        } else {
            this.mClient.onReceivedJavaError(lynxError);
        }
        onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_DISPATCH_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMemoryUsage() {
        if (!this.mIsMemoryCollecting && PerformanceController.isMemoryMonitorEnabled()) {
            this.mIsMemoryCollecting = true;
            final WeakReference weakReference = new WeakReference(this);
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.10
                @Override // java.lang.Runnable
                public void run() {
                    ILynxUIRenderer iLynxUIRenderer;
                    LynxUIOwner lynxUIOwner;
                    LynxTemplateRender lynxTemplateRender = (LynxTemplateRender) weakReference.get();
                    if (lynxTemplateRender == null) {
                        return;
                    }
                    lynxTemplateRender.mIsMemoryCollecting = false;
                    PerformanceController performanceController = lynxTemplateRender.mPerformanceController;
                    if (performanceController == null || (iLynxUIRenderer = lynxTemplateRender.mLynxUIRender) == null || (lynxUIOwner = iLynxUIRenderer.lynxUIOwner()) == null) {
                        return;
                    }
                    performanceController.updateMemoryUsage(lynxUIOwner.getMemoryUsage());
                }
            }, PerformanceController.getMemoryAcquisitionDelaySec() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class InnerSSRLoadedCallback implements AbsTemplateProvider.Callback {
        private TemplateData mTemplateData;
        private String mUrl;

        public InnerSSRLoadedCallback(String str, TemplateData templateData) {
            this.mTemplateData = templateData;
            this.mUrl = str;
        }

        public void onSuccess(byte[] bArr) {
            if (LynxTemplateRender.this.mDevTool != null) {
                LynxTemplateRender.this.mDevTool.attachToDebugBridge(this.mUrl);
            }
            if (LynxTemplateRender.this.mDevTool != null) {
                LynxTemplateRender.this.mDevTool.onTemplateLoadSuccess(bArr);
            }
            LynxTemplateRender.this.mPerformanceController.markTiming(TimingHandler.PREPARE_TEMPLATE_END, (String) null);
            LynxTemplateRender.this.renderSSR(bArr, this.mUrl, this.mTemplateData);
        }

        public void onFailed(final String str) {
            final String stackTraceStringTrimmed = CallStackUtil.getStackTraceStringTrimmed(new Throwable("Fetch template resource failed"));
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.InnerSSRLoadedCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    LynxError lynxError = new LynxError(LynxSubErrorCode.E_APP_BUNDLE_LOAD_BAD_RESPONSE, "Error occurred while fetching app bundle resource");
                    lynxError.setRootCause(str);
                    lynxError.setCallStack(stackTraceStringTrimmed);
                    LynxTemplateRender.this.onErrorOccurred(lynxError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class InnerLoadedCallback implements AbsTemplateProvider.Callback {
        private Map<String, Object> mData;
        private String mJsonData;
        private TemplateData mTemplateData;
        private final String mUrl;
        private LynxLoadMeta metaData;

        public InnerLoadedCallback(String str, LynxLoadMeta lynxLoadMeta) {
            this.mUrl = str;
            this.metaData = lynxLoadMeta;
        }

        public InnerLoadedCallback(String str, String str2) {
            this.mJsonData = str2;
            this.mUrl = str;
        }

        public InnerLoadedCallback(String str, TemplateData templateData) {
            this.mTemplateData = templateData;
            this.mUrl = str;
        }

        public InnerLoadedCallback(String str, Map<String, Object> map) {
            this.mData = map;
            this.mUrl = str;
        }

        public void onSuccess(final byte[] bArr) {
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.InnerLoadedCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    TemplateData fromString;
                    byte[] bArr2 = bArr;
                    if (bArr2 != null && bArr2.length != 0) {
                        if (LynxTemplateRender.this.mDevTool != null) {
                            LynxTemplateRender.this.mDevTool.attachToDebugBridge(InnerLoadedCallback.this.mUrl);
                        }
                        if (LynxTemplateRender.this.mDevTool != null) {
                            LynxTemplateRender.this.mDevTool.onTemplateLoadSuccess(bArr);
                        }
                        LynxTemplateRender.this.mPerformanceController.markTiming(TimingHandler.PREPARE_TEMPLATE_END, (String) null);
                        if (InnerLoadedCallback.this.metaData == null) {
                            if (InnerLoadedCallback.this.mTemplateData != null) {
                                fromString = InnerLoadedCallback.this.mTemplateData;
                            } else if (InnerLoadedCallback.this.mData != null) {
                                fromString = TemplateData.fromMap(InnerLoadedCallback.this.mData);
                            } else {
                                fromString = TemplateData.fromString(InnerLoadedCallback.this.mJsonData == null ? "" : InnerLoadedCallback.this.mJsonData);
                            }
                            LynxTemplateRender.this.renderTemplate(bArr, fromString);
                            return;
                        }
                        TimingOption createTimingOption = TimingOption.createTimingOption("loadBundle", "loadBundleStart");
                        if (LynxTemplateRender.this.mPerformanceController.isEmbeddedMode()) {
                            LynxTemplateRender.this.mPerformanceController.markTiming("loadBundleStart", (String) null);
                        }
                        InnerLoadedCallback.this.metaData.binaryData = bArr;
                        LynxTemplateRender.this.renderWithLoadMeta(InnerLoadedCallback.this.metaData, createTimingOption);
                        return;
                    }
                    InnerLoadedCallback.this.onFailed("Source is null!");
                }
            });
        }

        public void onSuccess(ByteBuffer byteBuffer) {
            if (byteBuffer != null && byteBuffer.limit() != 0) {
                if (LynxTemplateRender.this.mDevTool != null) {
                    LynxTemplateRender.this.mDevTool.attachToDebugBridge(this.mUrl);
                }
                LynxTemplateRender.this.mPerformanceController.markTiming(TimingHandler.PREPARE_TEMPLATE_END, (String) null);
                LynxLoadMeta lynxLoadMeta = this.metaData;
                if (lynxLoadMeta == null) {
                    TemplateData templateData = this.mTemplateData;
                    if (templateData == null) {
                        Map<String, Object> map = this.mData;
                        if (map != null) {
                            templateData = TemplateData.fromMap(map);
                        } else {
                            String str = this.mJsonData;
                            if (str == null) {
                                str = "";
                            }
                            templateData = TemplateData.fromString(str);
                        }
                    }
                    LynxLoadMeta build = new LynxLoadMeta.Builder().build();
                    build.initialData = templateData;
                    lynxLoadMeta = build;
                }
                TimingOption createTimingOption = TimingOption.createTimingOption("loadBundle", "loadBundleStart");
                if (LynxTemplateRender.this.mPerformanceController.isEmbeddedMode()) {
                    LynxTemplateRender.this.mPerformanceController.markTiming("loadBundleStart", (String) null);
                }
                lynxLoadMeta.byteBuffer = byteBuffer;
                LynxTemplateRender.this.renderWithLoadMeta(this.metaData, createTimingOption);
                return;
            }
            onFailed("ByteBuffer is null!");
        }

        public void onSuccess(TemplateBundle templateBundle) {
            if (templateBundle.isValid()) {
                if (LynxTemplateRender.this.mDevTool != null) {
                    LynxTemplateRender.this.mDevTool.attachToDebugBridge(this.mUrl);
                }
                if (LynxTemplateRender.this.mDevTool != null) {
                    LynxTemplateRender.this.mDevTool.onLoadFromBundle(templateBundle, this.mTemplateData, this.mUrl);
                }
                LynxTemplateRender.this.mPerformanceController.markTiming(TimingHandler.PREPARE_TEMPLATE_END, (String) null);
                if (this.metaData == null) {
                    TemplateData templateData = this.mTemplateData;
                    if (templateData == null) {
                        Map<String, Object> map = this.mData;
                        if (map != null) {
                            templateData = TemplateData.fromMap(map);
                        } else {
                            String str = this.mJsonData;
                            if (str == null) {
                                str = "";
                            }
                            templateData = TemplateData.fromString(str);
                        }
                    }
                    LynxTemplateRender.this.renderTemplateBundle(templateBundle, templateData, this.mUrl);
                    return;
                }
                TimingOption createTimingOption = TimingOption.createTimingOption("loadBundle", "loadBundleStart");
                if (LynxTemplateRender.this.mPerformanceController.isEmbeddedMode()) {
                    LynxTemplateRender.this.mPerformanceController.markTiming("loadBundleStart", (String) null);
                }
                this.metaData.bundle = templateBundle;
                LynxTemplateRender.this.renderWithLoadMeta(this.metaData, createTimingOption);
                return;
            }
            onFailed("template bundle is invalid.");
        }

        public void onFailed(final String str) {
            final String stackTraceStringTrimmed = CallStackUtil.getStackTraceStringTrimmed(new Throwable("Fetch template resource failed"));
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.InnerLoadedCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    LynxError lynxError = new LynxError(LynxSubErrorCode.E_APP_BUNDLE_LOAD_BAD_RESPONSE, "Error occurred while fetching app bundle resource");
                    lynxError.setRootCause(str);
                    lynxError.setCallStack(stackTraceStringTrimmed);
                    LynxTemplateRender.this.onErrorOccurred(lynxError);
                }
            });
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class InnerPageLoadListener implements LynxPageLoadListener {
        public InnerPageLoadListener() {
        }

        @Override // com.lynx.tasm.base.LynxPageLoadListener
        public void onFirstScreen() {
            LLog.m2578i(LynxTemplateRender.TAG, "onFirstScreen");
            ILynxUIRenderer iLynxUIRenderer = LynxTemplateRender.this.mLynxUIRender;
            if (iLynxUIRenderer != null) {
                iLynxUIRenderer.setFirstLayout();
            }
            try {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.InnerPageLoadListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LynxTemplateRender.this.mClient != null) {
                            LynxTemplateRender.this.mClient.onFirstScreen();
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.lynx.tasm.base.LynxPageLoadListener
        public void onPageUpdate() {
            try {
                LLog.m2578i(LynxTemplateRender.TAG, "onPageUpdate");
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.InnerPageLoadListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LynxTemplateRender.this.mClient != null) {
                            LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_PAGE_UPDATE);
                            LynxTemplateRender.this.mClient.onPageUpdate();
                            LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_PAGE_UPDATE);
                        }
                    }
                });
                if (LynxTemplateRender.this.mDevTool != null) {
                    LynxTemplateRender.this.mDevTool.onPageUpdate();
                }
                LynxTemplateRender.this.updateMemoryUsage();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.lynx.tasm.base.LynxPageLoadListener
        public void onUpdateDataWithoutChange() {
            try {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxTemplateRender.InnerPageLoadListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LynxTemplateRender.this.mClient != null) {
                            LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_UPDATE_WITHOUT_CHANGE);
                            LynxTemplateRender.this.mClient.onUpdateDataWithoutChange();
                            LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_UPDATE_WITHOUT_CHANGE);
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean markEngineInUse() {
        LynxEngine lynxEngine;
        if ((this.mEnableReuseEngine && this.mLynxEngineRef == null) || (lynxEngine = this.mLynxEngineRef) == null || !lynxEngine.tryBeReusing()) {
            return false;
        }
        this.mMarkEngineInUseFlag = true;
        return true;
    }

    private void markEngineIdle() {
        LynxEngine lynxEngine;
        if (this.mEnableReuseEngine && (lynxEngine = this.mLynxEngineRef) != null && this.mMarkEngineInUseFlag) {
            this.mMarkEngineInUseFlag = false;
            lynxEngine.updateLynxEngineState(LynxEngine.LynxEngineState.READY_BE_REUSED);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        checkEngineFallbackAndLoad(false);
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        return iLynxUIRenderer != null && iLynxUIRenderer.onTouchEvent(motionEvent, (UIGroup) null);
    }

    public boolean consumeSlideEvent(MotionEvent motionEvent) {
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        return iLynxUIRenderer != null && iLynxUIRenderer.consumeSlideEvent(motionEvent);
    }

    public boolean blockNativeEvent(MotionEvent motionEvent) {
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        return iLynxUIRenderer != null && iLynxUIRenderer.blockNativeEvent(motionEvent);
    }

    public void onRootViewDraw(Canvas canvas) {
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxContext.onRootViewDraw(canvas);
        }
    }

    public void onAttachedToWindow() {
        if (this.mEnableReuseEngine && this.mLynxEngineRef != null && this.mThreadStrategyForRendering == ThreadStrategyForRendering.MOST_ON_TASM) {
            disableEngineBeReused();
        }
        String str = "lynxview onAttachedToWindow " + this;
        LLog.m2578i(TAG, str);
        onTraceEventBegin(str);
        onEnterForeground(false);
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.onAttach();
        }
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxContext.onAttachedToWindow();
        }
        onTraceEventEnd(str);
    }

    public void onDetachedFromWindow() {
        String str = "lynxview onDetachedFromWindow " + toString();
        LLog.m2578i(TAG, str);
        onTraceEventBegin(str);
        if (this.mLynxUIRender != null) {
            TraceEvent.beginSection("Client.onReportComponentInfo");
            this.mClient.onReportComponentInfo(new HashSet());
            TraceEvent.endSection("Client.onReportComponentInfo");
            this.mLynxUIRender.onDetach();
        }
        onEnterBackground(false);
        onTraceEventEnd(str);
    }

    private void onEnterForeground(boolean z) {
        LLog.m2578i(TAG, "onEnterForeground. force: " + z);
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onEnterForeground();
        }
        if (this.mNativePtr != 0 && (z || getAutoExpose())) {
            nativeOnEnterForeground(this.mNativePtr, this.mNativeLifecycle);
        }
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.onEnterForegroundInternal();
        }
    }

    private void onEnterBackground(boolean z) {
        LLog.m2578i(TAG, "onEnterBackground. force: " + z);
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onEnterBackground();
        }
        if (this.mNativePtr != 0 && (z || getAutoExpose())) {
            nativeOnEnterBackground(this.mNativePtr, this.mNativeLifecycle);
        }
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.onEnterBackgroundInternal();
        }
    }

    private boolean checkEngineFallbackAndLoad(boolean z) {
        if (!this.mEnableReuseEngine || this.mLynxEngineRef != null) {
            return false;
        }
        fallbackNewEngine(z);
        LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
        builder.addLoadOption(LynxLoadOption.RENDER_FOR_RECREATE_ENGINE);
        builder.setInitialData(this.mTemplateData);
        builder.setUrl(this.mUrl);
        builder.setTemplateBundle(this.mTemplateBundle);
        loadTemplate(builder.build());
        this.mLynxUIRender.lynxUIOwner().performMeasure();
        this.mLynxUIRender.lynxUIOwner().performLayout();
        return true;
    }

    private synchronized void fallbackNewEngine(boolean z) {
        if (!UIThreadUtils.isOnUiThread()) {
            LLog.m2577e(TAG, "fallbackNewEngine should be called on ui thread, url: " + this.mUrl);
            return;
        }
        if (this.mHasDestroy) {
            return;
        }
        onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_FALLBACK_NEW_ENGINE);
        LLog.m2578i(TAG, "call fallbackNewEngine enable_async:" + z);
        this.mEnableReuseEngine = false;
        this.reload = false;
        this.mHasPageStart = false;
        this.mSSRHelper = null;
        this.mRenderPhase = RENDER_PHASE_SETUP;
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            lynxContext.clearExposure();
        }
        TemplateData templateData = this.globalProps;
        if (templateData != null) {
            this.globalProps = templateData.deepClone();
        }
        if (this.mNativePtr != 0) {
            destroyLynxEngine();
        }
        int i = this.mPreWidthMeasureSpec;
        int i2 = this.mPreHeightMeasureSpec;
        this.mPreWidthMeasureSpec = 0;
        this.mPreHeightMeasureSpec = 0;
        this.mLynxEngineRef = null;
        this.mIsEngineFromReuse = false;
        recreateLynxUIRenderer();
        LynxContext lynxContext2 = this.mLynxContext;
        if (lynxContext2 != null) {
            lynxContext2.reset();
        }
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            iLynxUIRenderer.onInitLynxTemplateRender(this.mLynxContext, this.mLynxViewConfigProvider.getBehaviorRegistry(), this.mBodyView, this.mLongTaskMonitorEnabled);
            LynxDevtool lynxDevtool = this.mDevTool;
            if (lynxDevtool != null) {
                lynxDevtool.attachLynxUIOwner(this.mLynxUIRender.lynxUIOwner());
            }
        }
        this.mThreadStrategyForRendering = z ? ThreadStrategyForRendering.MOST_ON_TASM : ThreadStrategyForRendering.ALL_ON_UI;
        createLynxEngine(-1);
        updateViewport(i, i2);
        this.mLynxContext.markFallbackProcess(true);
        onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_FALLBACK_NEW_ENGINE);
    }

    private String[] processUrl(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("=|&");
        String str2 = "";
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 < split.length) {
                if (split[i].equalsIgnoreCase("compile_path") || split[i].equalsIgnoreCase("compilePath")) {
                    str = split[i2];
                } else if (split[i].equalsIgnoreCase("post_url") || split[i].equalsIgnoreCase(WebViewContainer.EVENT_postUrl)) {
                    str2 = split[i2];
                }
                i += 2;
            } else {
                arrayList.add(str);
                arrayList.add(str2);
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
    }

    public View findViewByName(String str) {
        LynxUI findUIByName = findUIByName(str);
        if (findUIByName instanceof LynxUI) {
            return findUIByName.getView();
        }
        return null;
    }

    public LynxBaseUI findUIByName(String str) {
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            return iLynxUIRenderer.findLynxUIByName(str);
        }
        return null;
    }

    public View findViewByIdSelector(String str) {
        LynxUI findUIByIdSelector = findUIByIdSelector(str);
        if (findUIByIdSelector instanceof LynxUI) {
            return findUIByIdSelector.getView();
        }
        return null;
    }

    public LynxBaseUI findUIByIdSelector(String str) {
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            return iLynxUIRenderer.findLynxUIByIdSelector(str);
        }
        return null;
    }

    public boolean attachLynxView(LynxView lynxView) {
        if (this.mBodyView != null) {
            LLog.m2577e(TAG, "already attached " + lynxView);
            return false;
        }
        Context context = lynxView.getContext();
        this.mContext = context;
        Activity activity = ContextUtils.getActivity(context);
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("curActivity", activity != null ? activity.toString() : "");
            TraceEvent.beginSection(TraceEventDef.TEMPLATE_RENDER_ATTACH_LYNX_VIEW, hashMap);
        }
        LLog.m2578i(TAG, "LynxTemplateRender(" + this + ") is attached on lynxView:" + lynxView);
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        this.mBodyView = lynxView;
        lynxView.setLynxUIRendererInternal(lynxUIRenderer);
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.attachContext(this.mContext);
        }
        ViewLayoutTick viewLayoutTick = this.mViewLayoutTick;
        if (viewLayoutTick != null) {
            viewLayoutTick.attach(this.mBodyView);
        }
        this.mBodyView.setTimingCollector(this.mPerformanceController);
        lynxUIRenderer.attachBodyView(lynxView, this.mLynxContext, this.mContext);
        if (activity != null) {
            lynxUIRenderer.setContextFree(false);
            nativeSetContextHasAttached(this.mNativePtr, this.mNativeLifecycle);
        }
        LynxDevtool lynxDevtool2 = this.mDevTool;
        if (lynxDevtool2 != null) {
            lynxDevtool2.attach(lynxView);
        }
        if (!TraceEvent.isTracingStarted()) {
            return true;
        }
        TraceEvent.endSection(TraceEventDef.TEMPLATE_RENDER_ATTACH_LYNX_VIEW);
        return true;
    }

    public long getFirstMeasureTime() {
        return this.mFirstMeasureTime;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class TASMCallback implements NativeFacade.Callback {
        private static final String DEFAULT_ENTRY = "__Card__";

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onRunPipelineFinished() {
        }

        public TASMCallback() {
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onLoaded(int i) {
            HeroTransitionManager.inst().executeEnterAnim(LynxTemplateRender.this.mBodyView, (HeroTransitionManager.LynxViewEnterFinishListener) null);
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.dispatchLoadSuccess(i);
            }
            LynxTemplateRender.this.mRenderPhase = LynxTemplateRender.RENDER_PHASE_UPDATE;
            if (LynxTemplateRender.this.mDevTool != null) {
                LynxTemplateRender.this.mDevTool.onLoadFinished();
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onSSRHydrateFinished() {
            if (LynxTemplateRender.this.mSSRHelper != null) {
                LynxTemplateRender.this.mSSRHelper.onHydrateFinished();
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onRuntimeReady() {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_RUNTIME_READY);
                LynxTemplateRender.this.mClient.onRuntimeReady();
                LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_RUNTIME_READY);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onDataUpdated() {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_DATA_UPDATED);
                LynxTemplateRender.this.mClient.onDataUpdated();
                LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_DATA_UPDATED);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onPageChanged(boolean z) {
            if (z) {
                LynxTemplateRender.this.mPageLoadListener.onFirstScreen();
            } else {
                LynxTemplateRender.this.mPageLoadListener.onPageUpdate();
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onDynamicComponentPerfReady(HashMap<String, Object> hashMap) {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_DYNAMIC_COMPONENT_PERF);
                LynxTemplateRender.this.mClient.onDynamicComponentPerfReady(hashMap);
                LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_DYNAMIC_COMPONENT_PERF);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onErrorOccurred(LynxError lynxError) {
            LynxTemplateRender.this.onErrorOccurred(lynxError);
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onThemeUpdatedByJs(LynxTheme lynxTheme) {
            if (lynxTheme == null) {
                return;
            }
            if (LynxTemplateRender.this.mTheme == null) {
                LynxTemplateRender.this.mTheme = lynxTheme;
            } else {
                LynxTemplateRender.this.mTheme.replaceWithTheme(lynxTheme);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public String translateResourceForTheme(String str, String str2) {
            ThemeResourceProvider themeResourceProviderProvider = LynxEnv.inst().getThemeResourceProviderProvider();
            if (themeResourceProviderProvider != null) {
                if (str2 != null) {
                    try {
                        if (str2.isEmpty()) {
                            str2 = null;
                        }
                    } catch (Throwable th) {
                        LLog.m2576d(LynxTemplateRender.TAG, "translateResourceForTheme exception " + th.toString());
                    }
                }
                return themeResourceProviderProvider.translateResourceForTheme(str, LynxTemplateRender.this.mTheme, str2, LynxTemplateRender.this.getLynxView());
            }
            return null;
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onModuleFunctionInvoked(String str, String str2, int i) {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_MODULE_FUNCTION);
                LynxTemplateRender.this.mClient.onModuleMethodInvoked(str, str2, i);
                LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_MODULE_FUNCTION);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onPageConfigDecoded(PageConfig pageConfig) {
            if (LynxTemplateRender.this.mEnableReuseEngine && LynxTemplateRender.this.mLynxEngineRef != null) {
                LynxTemplateRender.this.mLynxEngineRef.setPageConfig(pageConfig);
            }
            PageConfig.attachPageConfig(pageConfig, LynxTemplateRender.this.mLynxContext, LynxTemplateRender.this.mLynxUIRender);
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onJSBInvoked(Map<String, Object> map) {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.mClient.onJSBInvoked(map);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onCallJSBFinished(Map<String, Object> map) {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.mClient.onCallJSBFinished(map);
            }
            if (LynxDevtoolGlobalHelper.getInstance().isRemoteDebugAvailable()) {
                LynxDevtoolGlobalHelper.getInstance().onPerfMetricsEvent("lynxsdk_jsb_timing", new JSONObject(map), LynxTemplateRender.this.mLynxContext != null ? LynxTemplateRender.this.mLynxContext.getInstanceId() : -1);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onUpdateDataWithoutChange() {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_UPDATE_WITHOUT_CHANGE);
                LynxTemplateRender.this.mClient.onUpdateDataWithoutChange();
                LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_UPDATE_WITHOUT_CHANGE);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onTemplateBundleReady(TemplateBundle templateBundle) {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_TEMPLATE_BUNDLE_READY);
                LynxTemplateRender.this.mClient.onTemplateBundleReady(templateBundle);
                LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_TEMPLATE_BUNDLE_READY);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onReceiveMessageEvent(ReadableMap readableMap) {
            if (LynxTemplateRender.this.mDevTool != null) {
                LynxTemplateRender.this.mDevTool.onReceiveMessageEvent(readableMap);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onTASMFinishedByNative() {
            if (LynxTemplateRender.this.mClient != null) {
                LynxTemplateRender.this.onTraceEventBegin(TraceEventDef.CLIENT_ON_TASM_FINISHED_BY_NATIVE);
                LynxTemplateRender.this.mClient.onTASMFinishedByNative();
                LynxTemplateRender.this.tryRegisterLynxEngineReused();
                LynxTemplateRender.this.onTraceEventEnd(TraceEventDef.CLIENT_ON_TASM_FINISHED_BY_NATIVE);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onUpdateI18nResource(String str, String str2, int i) {
            LynxTemplateRender.nativeUpdateI18nResource(LynxTemplateRender.this.mNativePtr, LynxTemplateRender.this.mNativeLifecycle, str, str2, i);
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onUIMethodInvoked(int i, JavaOnlyMap javaOnlyMap) {
            if (LynxTemplateRender.this.enableAirStrictMode()) {
                if (LynxTemplateRender.this.mEngineProxy != null) {
                    LynxTemplateRender.this.mEngineProxy.invokeLepusApiCallback(i, DEFAULT_ENTRY, LepusBuffer.INSTANCE.encodeMessage(javaOnlyMap));
                    return;
                }
                return;
            }
            if (LynxTemplateRender.this.mJSProxy != null) {
                LynxTemplateRender.this.mJSProxy.callJSApiCallbackWithValue(i, javaOnlyMap);
            }
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onClearNativePipelineTimingInfo() {
            LynxTemplateRender lynxTemplateRender = LynxTemplateRender.this;
            lynxTemplateRender.nativeClearPipelineTimingInfo(lynxTemplateRender.mNativePtr, LynxTemplateRender.this.mNativeLifecycle);
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onEventCapture(long j, boolean z, long j2) {
            LynxBaseUI findLynxUIBySign;
            if (LynxTemplateRender.this.mLynxContext == null || LynxTemplateRender.this.mLynxContext.getLynxUIOwner() == null || (findLynxUIBySign = LynxTemplateRender.this.mLynxContext.getLynxUIOwner().findLynxUIBySign((int) j)) == null) {
                return;
            }
            findLynxUIBySign.onEventCapture(z, j2);
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onEventBubble(long j, boolean z, long j2) {
            LynxBaseUI findLynxUIBySign;
            if (LynxTemplateRender.this.mLynxContext == null || LynxTemplateRender.this.mLynxContext.getLynxUIOwner() == null || (findLynxUIBySign = LynxTemplateRender.this.mLynxContext.getLynxUIOwner().findLynxUIBySign((int) j)) == null) {
                return;
            }
            findLynxUIBySign.onEventBubble(z, j2);
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onEventFire(long j, boolean z, long j2) {
            LynxBaseUI findLynxUIBySign;
            if (LynxTemplateRender.this.mLynxContext == null || LynxTemplateRender.this.mLynxContext.getLynxUIOwner() == null || (findLynxUIBySign = LynxTemplateRender.this.mLynxContext.getLynxUIOwner().findLynxUIBySign((int) j)) == null) {
                return;
            }
            findLynxUIBySign.onEventFire(z, j2);
        }

        @Override // com.lynx.tasm.NativeFacade.Callback
        public void onLynxEvent(ReadableMap readableMap) {
            if (LynxTemplateRender.this.mLogicExecutor != null) {
                LynxTemplateRender.this.mLogicExecutor.onLynxEvent(LynxTemplateRender.this.getLynxView(), readableMap);
            }
        }
    }

    public void onLynxEvent(ReadableMap readableMap) {
        ILynxLogicExecutor iLynxLogicExecutor = this.mLogicExecutor;
        if (iLynxLogicExecutor != null) {
            iLynxLogicExecutor.onLynxEvent(getLynxView(), readableMap);
        }
    }

    public LynxBaseUI findUIByIndex(int i) {
        ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
        if (iLynxUIRenderer != null) {
            return iLynxUIRenderer.findLynxUIByIndex(i);
        }
        return null;
    }

    public void onDispatchInputEvent(InputEvent inputEvent) {
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.onRootViewInputEvent(inputEvent);
        }
    }

    public Map<String, Object> getAllJsSource() {
        long j = this.mNativePtr;
        if (j != 0) {
            return nativeGetAllJsSource(j, this.mNativeLifecycle);
        }
        return null;
    }

    public boolean enableJSRuntime() {
        return this.mEnableJSRuntime;
    }

    public void syncFlush() {
        onTraceEventBegin("LynxTemplateRender.syncFlush");
        UIThreadUtils.assertOnUiThread();
        if (this.mAsyncRender && !this.mIsDestroyed.get()) {
            LLog.m2578i(TAG, "syncFlush wait layout finish");
            long j = this.mNativePtr;
            if (j != 0) {
                nativeFlush(j, this.mNativeLifecycle);
            }
        }
        onTraceEventEnd("LynxTemplateRender.syncFlush");
    }

    public void runOnTasmThread(Runnable runnable) {
        LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
        if (lynxEngineProxy == null) {
            LLog.m2578i(TAG, "runOnTasmThread failed, engine proxy is null.");
        } else {
            lynxEngineProxy.dispatchTaskToLynxEngine(runnable);
        }
    }

    public void startLynxRuntime() {
        long j = this.mNativePtr;
        if (j != 0) {
            this.mEnablePendingJsTask = false;
            nativeStartRuntime(j, this.mNativeLifecycle);
        }
    }

    @Deprecated
    public void processLayout(String str, TemplateData templateData) {
        setEnableUIFlush(false);
        renderTemplateUrl(str, templateData);
    }

    @Deprecated
    public void processLayoutWithSSRUrl(String str, TemplateData templateData) {
        setEnableUIFlush(false);
        renderSSRUrl(str, templateData);
    }

    @Deprecated
    public void processLayoutWithTemplateBundle(TemplateBundle templateBundle, TemplateData templateData, String str) {
        setEnableUIFlush(false);
        renderTemplateBundle(templateBundle, templateData, str);
    }

    public void setEnableUIFlush(boolean z) {
        long j = this.mNativePtr;
        if (j == 0 || this.mEnableUIFlush == z) {
            return;
        }
        this.mEnableUIFlush = z;
        nativeSetEnableUIFlush(j, this.mNativeLifecycle, z);
    }

    public void processRender() {
        onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_PROCESS_RENDER);
        if (this.mNativePtr != 0 && !this.mEnableUIFlush) {
            setEnableUIFlush(true);
            nativeProcessRender(this.mNativePtr, this.mNativeLifecycle);
        }
        onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_PROCESS_RENDER);
    }

    public void setEnableBytecode(boolean z, String str) {
        if (this.mEnableBytecode == z && Objects.equals(this.mBytecodeSourceUrl, str)) {
            return;
        }
        this.mEnableBytecode = z;
        this.mBytecodeSourceUrl = str;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetEnableBytecode(j, this.mNativeLifecycle, z, str);
        }
    }

    public void setSessionStorageItem(String str, TemplateData templateData) {
        LLog.m2576d(TAG, "setSessionStorageItem with key: " + str);
        if (this.mNativePtr == 0 || templateData == null || TextUtils.isEmpty(str)) {
            return;
        }
        templateData.flush();
        if (templateData.getNativePtr() == 0) {
            LLog.m2577e(TAG, "setSessionStorageItem with zero data! key: " + str);
        } else {
            nativeSetSessionStorageItem(this.mNativePtr, this.mNativeLifecycle, str, templateData.getNativePtr(), templateData.isReadOnly());
        }
    }

    public void getSessionStorageItem(String str, PlatformCallBack platformCallBack) {
        LLog.m2576d(TAG, "getSessionStorageItem with key: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.mNativePtr;
        if (j != 0) {
            nativeGetSessionStorageItem(j, this.mNativeLifecycle, str, platformCallBack);
        }
    }

    public double subscribeSessionStorage(String str, PlatformCallBack platformCallBack) {
        LLog.m2576d(TAG, "subscribeSessionStorage with key: " + str);
        if (TextUtils.isEmpty(str)) {
            return -1.0d;
        }
        long j = this.mNativePtr;
        if (j == 0) {
            return -1.0d;
        }
        double nativeSubscribeSessionStorage = nativeSubscribeSessionStorage(j, this.mNativeLifecycle, str, platformCallBack);
        this.platformCallBackMap.put(Double.valueOf(nativeSubscribeSessionStorage), platformCallBack);
        return nativeSubscribeSessionStorage;
    }

    public void unsubscribeSessionStorage(String str, double d) {
        LLog.m2576d(TAG, "unsubscribeSessionStorage with key: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.mNativePtr;
        if (j == 0 || -1.0d == d) {
            return;
        }
        nativeUnsubscribeSessionStorage(j, this.mNativeLifecycle, str, d);
        this.platformCallBackMap.remove(Double.valueOf(d));
    }

    public void attachEngineToUIThread() {
        if (this.mNativePtr != 0) {
            if (!UIThreadUtils.isOnUiThread()) {
                LLog.m2577e(TAG, "attachEngineToUIThread should be called on ui thread, url: " + this.mUrl);
                return;
            }
            if (checkEngineFallbackAndLoad(false)) {
                onThreadStrategyUpdated();
                return;
            }
            int i = C148411.$SwitchMap$com$lynx$tasm$ThreadStrategyForRendering[this.mThreadStrategyForRendering.ordinal()];
            if (i == 1) {
                this.mThreadStrategyForRendering = ThreadStrategyForRendering.ALL_ON_UI;
                if (this.mEnableReuseEngine && this.mLynxEngineRef != null) {
                    markEngineInUse();
                    this.mLynxEngineRef.setThreadStrategy(ThreadStrategyForRendering.ALL_ON_UI);
                }
            } else if (i != 2) {
                return;
            } else {
                this.mThreadStrategyForRendering = ThreadStrategyForRendering.PART_ON_LAYOUT;
            }
            nativeAttachEngineToUIThread(this.mNativePtr, this.mNativeLifecycle);
            onThreadStrategyUpdated();
            markEngineIdle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.LynxTemplateRender$11 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C148411 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$tasm$ThreadStrategyForRendering;

        /* renamed from: $SwitchMap$com$lynx$tasm$resourceprovider$LynxResourceResponse$ResponseState */
        static final /* synthetic */ int[] f2304x51ec6ea4;

        static {
            int[] iArr = new int[ThreadStrategyForRendering.values().length];
            $SwitchMap$com$lynx$tasm$ThreadStrategyForRendering = iArr;
            try {
                iArr[ThreadStrategyForRendering.MOST_ON_TASM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$tasm$ThreadStrategyForRendering[ThreadStrategyForRendering.MULTI_THREADS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$tasm$ThreadStrategyForRendering[ThreadStrategyForRendering.ALL_ON_UI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$tasm$ThreadStrategyForRendering[ThreadStrategyForRendering.PART_ON_LAYOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[LynxResourceResponse.ResponseState.values().length];
            f2304x51ec6ea4 = iArr2;
            try {
                iArr2[LynxResourceResponse.ResponseState.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2304x51ec6ea4[LynxResourceResponse.ResponseState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public void detachEngineFromUIThread() {
        if (this.mNativePtr != 0) {
            if (!UIThreadUtils.isOnUiThread()) {
                LLog.m2577e(TAG, "detachEngineFromUIThread should be called on ui thread, url: " + this.mUrl);
                return;
            }
            if (checkEngineFallbackAndLoad(true)) {
                onThreadStrategyUpdated();
                return;
            }
            int i = C148411.$SwitchMap$com$lynx$tasm$ThreadStrategyForRendering[this.mThreadStrategyForRendering.ordinal()];
            if (i == 3) {
                this.mThreadStrategyForRendering = ThreadStrategyForRendering.MOST_ON_TASM;
                disableEngineBeReused();
            } else if (i != 4) {
                return;
            } else {
                this.mThreadStrategyForRendering = ThreadStrategyForRendering.MULTI_THREADS;
            }
            nativeDetachEngineFromUIThread(this.mNativePtr, this.mNativeLifecycle);
            onThreadStrategyUpdated();
        }
    }

    private void onThreadStrategyUpdated() {
        this.mAsyncRender = this.mThreadStrategyForRendering == ThreadStrategyForRendering.MULTI_THREADS || this.mThreadStrategyForRendering == ThreadStrategyForRendering.MOST_ON_TASM;
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext != null) {
            if (lynxContext.enableEventReporter()) {
                LynxEventReporter.updateGenericInfo("thread_mode", Integer.valueOf(this.mThreadStrategyForRendering.m2569id()), this.mLynxContext.getInstanceId());
            }
            if (this.mThreadStrategyForRendering == ThreadStrategyForRendering.MOST_ON_TASM || this.mThreadStrategyForRendering == ThreadStrategyForRendering.ALL_ON_UI) {
                this.mLynxContext.setLayoutThreadChanged(true);
            }
        }
    }

    private void disableEngineBeReused() {
        this.mEnableReuseEngine = false;
        LynxEngine lynxEngine = this.mLynxEngineRef;
        if (lynxEngine != null) {
            lynxEngine.destroy();
            this.mLynxEngineRef = null;
        }
    }

    private void loadTemplate(byte[] bArr, TemplateData templateData, String str, NativeFacade.Callback callback, TimingOption timingOption) {
        loadTemplate(bArr, templateData, str, false, false, callback, timingOption);
    }

    private void loadTemplateByteBuffer(ByteBuffer byteBuffer, TemplateData templateData, String str, boolean z, int i, boolean z2, NativeFacade.Callback callback, TimingOption timingOption) {
        String str2;
        boolean z3;
        long j;
        if (byteBuffer == null) {
            LLog.m2577e(TAG, "Load Template with null template");
            return;
        }
        if (this.mNativeFacade == null || this.mNativePtr == 0) {
            LLog.m2577e(TAG, "Load Template before inited");
            return;
        }
        if (templateData != null) {
            templateData.flush();
            j = templateData.getNativePtr();
            String processorName = templateData.processorName();
            boolean isReadOnly = templateData.isReadOnly();
            templateData.markConsumed();
            str2 = processorName;
            z3 = isReadOnly;
        } else {
            str2 = null;
            z3 = false;
            j = 0;
        }
        if (j == 0) {
            LLog.m2577e(TAG, "Load Template with zero template data");
        }
        this.mNativeFacade.setUrl(str);
        this.mNativeFacade.setCallback(callback);
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.attachToDebugBridge(str);
        }
        nativeLoadTemplate(str, null, byteBuffer, z ? 1 : 0, z2, z3, str2, templateData, i, timingOption);
    }

    private void loadTemplate(byte[] bArr, TemplateData templateData, String str, boolean z, boolean z2, NativeFacade.Callback callback, TimingOption timingOption) {
        String str2;
        boolean z3;
        long j;
        if (bArr == null) {
            LLog.m2577e(TAG, "Load Template with null template");
            return;
        }
        if (this.mNativeFacade == null || this.mNativePtr == 0) {
            LLog.m2577e(TAG, "Load Template before inited");
            return;
        }
        if (templateData != null) {
            templateData.flush();
            j = templateData.getNativePtr();
            str2 = templateData.processorName();
            z3 = templateData.isReadOnly();
            templateData.markConsumed();
        } else {
            str2 = null;
            z3 = false;
            j = 0;
        }
        if (j == 0) {
            LLog.m2577e(TAG, "Load Template with zero template data");
        }
        this.mNativeFacade.setUrl(str);
        this.mNativeFacade.setCallback(callback);
        this.mNativeFacade.setSize(bArr.length);
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.attachToDebugBridge(str);
        }
        nativeLoadTemplate(str, bArr, null, z ? 1 : 0, z2, z3, str2, templateData, 0, timingOption);
    }

    private void loadTemplateBundle(TemplateBundle templateBundle, String str, TemplateData templateData, boolean z, int i, NativeFacade.Callback callback, TimingOption timingOption) {
        String str2;
        boolean z2;
        long j;
        if (this.mNativeFacade == null || this.mNativePtr == 0) {
            LLog.m2577e(TAG, "LoadTemplateBundle before inited");
            return;
        }
        if (templateBundle == null || !templateBundle.isValid()) {
            LLog.m2577e(TAG, "LoadTemplateBundle with null bundle or invalid bundle");
            LynxError lynxError = new LynxError(LynxSubErrorCode.E_APP_BUNDLE_LOAD_BAD_BUNDLE, "LoadTemplateBundle with null bundle or invalid bundle");
            lynxError.setRootCause(templateBundle == null ? "bundle is null" : templateBundle.getErrorMessage());
            this.mNativeFacade.reportError(lynxError);
            return;
        }
        if (templateData != null) {
            templateData.flush();
            long nativePtr = templateData.getNativePtr();
            String processorName = templateData.processorName();
            boolean isReadOnly = templateData.isReadOnly();
            templateData.markConsumed();
            str2 = processorName;
            j = nativePtr;
            z2 = isReadOnly;
        } else {
            str2 = null;
            z2 = false;
            j = 0;
        }
        if (j == 0) {
            LLog.m2577e(TAG, "LoadTemplateBundle with zero templateData");
        }
        this.mNativeFacade.setUrl(str);
        this.mNativeFacade.setCallback(callback);
        this.mNativeFacade.setSize(templateBundle.getTemplateSize());
        LynxDevtool lynxDevtool = this.mDevTool;
        if (lynxDevtool != null) {
            lynxDevtool.attachToDebugBridge(str);
        }
        PageConfig.attachPageConfig(templateBundle.getPageConfig(), this.mLynxContext, this.mLynxUIRender);
        timingOption.markTiming("ffiStart");
        nativeLoadTemplateBundleByPreParsedData(this.mNativePtr, this.mNativeLifecycle, str, templateBundle.getNativePtr(), z ? 1 : 0, j, z2, str2, templateData, i, timingOption.toJavaOnlyMap());
    }

    private void loadSSRData(byte[] bArr, TemplateData templateData, NativeFacade.Callback callback) {
        String str;
        boolean z;
        if (this.mNativeFacade != null) {
            long j = 0;
            if (this.mNativePtr != 0) {
                if (bArr == null) {
                    LLog.m2577e(TAG, "Load ssr data  with null template");
                    return;
                }
                if (templateData != null) {
                    templateData.flush();
                    j = templateData.getNativePtr();
                    str = templateData.processorName();
                    z = templateData.isReadOnly();
                } else {
                    str = null;
                    z = false;
                }
                long j2 = j;
                this.mNativeFacade.setCallback(callback);
                long j3 = this.mNativePtr;
                long j4 = this.mNativeLifecycle;
                nativeLoadSSRDataByPreParsedData(j3, j4, bArr, j2, z, str, templateData);
                return;
            }
        }
        LLog.m2577e(TAG, "Load ssr data before inited");
    }

    private void loadTemplate(byte[] bArr, String str, String str2, NativeFacade.Callback callback, TimingOption timingOption) {
        NativeFacade nativeFacade = this.mNativeFacade;
        if (nativeFacade == null || this.mNativePtr == 0) {
            LLog.m2577e(TAG, "Load Template before inited");
            return;
        }
        if (bArr == null) {
            LLog.m2577e(TAG, "Load Template with null template");
            return;
        }
        nativeFacade.setUrl(str2);
        this.mNativeFacade.setCallback(callback);
        this.mNativeFacade.setSize(bArr.length);
        TemplateData fromString = TemplateData.fromString(str);
        fromString.flush();
        fromString.markConsumed();
        nativeLoadTemplate(str2, bArr, null, 0, false, true, "", fromString, 0, timingOption);
    }

    private void loadTemplate(byte[] bArr, Map<String, Object> map, String str, NativeFacade.Callback callback, TimingOption timingOption) {
        NativeFacade nativeFacade = this.mNativeFacade;
        if (nativeFacade == null || this.mNativePtr == 0) {
            LLog.m2577e(TAG, "Load Template before inited");
            return;
        }
        if (bArr == null) {
            LLog.m2577e(TAG, "Load Template with null template");
            return;
        }
        nativeFacade.setUrl(str);
        this.mNativeFacade.setCallback(callback);
        this.mNativeFacade.setSize(bArr.length);
        TemplateData fromMap = TemplateData.fromMap(map);
        fromMap.flush();
        fromMap.markConsumed();
        nativeLoadTemplate(str, bArr, null, 0, false, true, "", fromMap, 0, timingOption);
    }

    private void nativeLoadTemplate(String str, byte[] bArr, ByteBuffer byteBuffer, int i, boolean z, boolean z2, String str2, TemplateData templateData, int i2, TimingOption timingOption) {
        ILynxSecurityService service = LynxServiceCenter.inst().getService(ILynxSecurityService.class);
        if (service != null) {
            timingOption.markTiming("verifyTasmStart");
            SecurityResult verifyTASM = service.verifyTASM(getLynxView(), bArr, byteBuffer, str, ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE);
            timingOption.markTiming("verifyTasmEnd");
            if (!verifyTASM.isVerified()) {
                this.mNativeFacade.reportError(new LynxError(LynxSubErrorCode.E_APP_BUNDLE_VERIFY_INVALID_SIGNATURE, verifyTASM.getErrorMsg()));
                return;
            }
        }
        timingOption.markTiming("ffiStart");
        long nativePtr = templateData == null ? 0L : templateData.getNativePtr();
        if (byteBuffer != null) {
            nativeLoadTemplateBufferByPreParsedData(this.mNativePtr, this.mNativeLifecycle, str, byteBuffer, i, z, nativePtr, z2, str2, templateData, i2, timingOption.toJavaOnlyMap());
        } else if (bArr != null) {
            nativeLoadTemplateByPreParsedData(this.mNativePtr, this.mNativeLifecycle, str, bArr, i, z, nativePtr, z2, str2, templateData, i2, timingOption.toJavaOnlyMap());
        } else {
            LLog.m2577e(TAG, "loadTemplate with empty template or buffer.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean registerLazyBundle(String str, TemplateBundle templateBundle) {
        String str2;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            str3 = "url is empty";
        } else if (templateBundle == null) {
            str3 = "bundle is null";
        } else if (!templateBundle.isValid()) {
            str4 = templateBundle.getErrorMessage();
            str3 = "bundle is invalid";
        } else {
            if (nativeRegisterLazyBundle(this.mNativePtr, this.mNativeLifecycle, str, templateBundle.getNativePtr())) {
                str2 = null;
                if (str4 != null) {
                    return true;
                }
                LynxError lynxError = new LynxError(LynxSubErrorCode.E_LAZY_BUNDLE_LOAD_BAD_BUNDLE, str4);
                lynxError.setRootCause(str2);
                lynxError.addCustomInfo("component_url", str);
                NativeFacade nativeFacade = this.mNativeFacade;
                if (nativeFacade == null) {
                    return false;
                }
                nativeFacade.reportError(lynxError);
                return false;
            }
            str3 = "input bundle is not from a dynamic component template";
        }
        String str5 = str4;
        str4 = str3;
        str2 = str5;
        if (str4 != null) {
        }
    }

    public synchronized void updateGlobalPropsInternal(TemplateData templateData) {
        if (templateData == null) {
            return;
        }
        templateData.flush();
        long nativePtr = templateData.getNativePtr();
        if (nativePtr == 0) {
            LLog.m2577e(TAG, "updateGlobalProps with zero templateData");
        } else {
            nativeUpdateGlobalProps(this.mNativePtr, this.mNativeLifecycle, nativePtr);
        }
    }

    private void attachPiper(LynxBackgroundRuntime lynxBackgroundRuntime, LynxModuleFactory lynxModuleFactory) {
        this.mNativeFacade.setModuleFactory(lynxModuleFactory);
        nativeAttachRuntime(this.mNativePtr, this.mNativeLifecycle, lynxBackgroundRuntime.getNativePtr());
        String jSGroupThreadNameIfNeed = getJSGroupThreadNameIfNeed();
        WeakReference<LynxContext> lynxContext = this.mNativeFacade.getLynxContext();
        JSProxy jSProxy = new JSProxy(this.mNativePtr, lynxContext, jSGroupThreadNameIfNeed);
        this.mJSProxy = jSProxy;
        this.mNativeFacade.setJSProxy(jSProxy);
        LynxContext lynxContext2 = lynxContext.get();
        if (lynxContext2 != null) {
            LLog.m2578i(TAG, "set JSGroupThreadName to lynx context: " + jSGroupThreadNameIfNeed);
            lynxContext2.setJSGroupThreadName(jSGroupThreadNameIfNeed);
        }
        LynxEngineProxy lynxEngineProxy = new LynxEngineProxy(this.mNativePtr);
        this.mEngineProxy = lynxEngineProxy;
        this.mNativeFacade.setEngineProxy(lynxEngineProxy);
        if (this.mLynxContext == null) {
            LLog.m2577e(TAG, "mLynxContext is null, can not set LayoutProxy");
            return;
        }
        LynxLayoutProxy lynxLayoutProxy = new LynxLayoutProxy(this.mNativePtr);
        this.mLayoutProxy = lynxLayoutProxy;
        this.mLynxContext.setLayoutProxy(lynxLayoutProxy);
    }

    public LynxEngineProxy getEngineProxy() {
        return this.mEngineProxy;
    }

    private void initPiper(LynxModuleFactory lynxModuleFactory, LynxResourceLoader lynxResourceLoader, boolean z, boolean z2, boolean z3, String str, boolean z4, ILynxUIRenderer iLynxUIRenderer) {
        TraceEvent.beginSection(TraceEventDef.TEMPLATE_RENDER_INIT_PIPER);
        initPiperInternal(lynxModuleFactory, lynxResourceLoader, z, z2, z3, str, z4, iLynxUIRenderer);
        TraceEvent.endSection(TraceEventDef.TEMPLATE_RENDER_INIT_PIPER);
    }

    private void initPiperInternal(LynxModuleFactory lynxModuleFactory, LynxResourceLoader lynxResourceLoader, boolean z, boolean z2, boolean z3, String str, boolean z4, ILynxUIRenderer iLynxUIRenderer) {
        this.mNativeFacade.setModuleFactory(lynxModuleFactory);
        if (z) {
            LLog.m2578i(TAG, "force use quick js engine");
        } else {
            LLog.m2578i(TAG, "useQuickJSEngine is false");
        }
        nativeInitRuntime(this.mNativePtr, lynxResourceLoader, lynxModuleFactory, getGroupID(), getPreloadJSPath(), str, LynxBackgroundRuntimeOptions.calcRuntimeFlags(z2, z, z4, z3, null, null), iLynxUIRenderer.getUIDelegatePtr());
        String jSGroupThreadNameIfNeed = getJSGroupThreadNameIfNeed();
        WeakReference<LynxContext> lynxContext = this.mNativeFacade.getLynxContext();
        if (this.mNativeFacade.getEnableJSRuntime()) {
            this.mJSProxy = new JSProxy(this.mNativePtr, lynxContext, jSGroupThreadNameIfNeed);
        }
        this.mNativeFacade.setJSProxy(this.mJSProxy);
        if (lynxContext.get() != null) {
            LLog.m2578i(TAG, "set JSGroupThreadName to lynx context: " + jSGroupThreadNameIfNeed);
            lynxContext.get().setJSGroupThreadName(jSGroupThreadNameIfNeed);
        }
        LynxEngineProxy lynxEngineProxy = new LynxEngineProxy(this.mNativePtr);
        this.mEngineProxy = lynxEngineProxy;
        this.mNativeFacade.setEngineProxy(lynxEngineProxy);
        LynxLayoutProxy lynxLayoutProxy = new LynxLayoutProxy(this.mNativePtr);
        this.mLayoutProxy = lynxLayoutProxy;
        this.mLynxContext.setLayoutProxy(lynxLayoutProxy);
    }

    public void sendCustomEvent(LynxCustomEvent lynxCustomEvent) {
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext == null) {
            LLog.m2577e(TAG, "sendCustomEvent event: " + lynxCustomEvent.getName() + " failed since mLynxContext is null.");
        } else if (lynxContext.getEventEmitter() == null) {
            LLog.m2577e(TAG, "sendCustomEvent event: " + lynxCustomEvent.getName() + " failed since mLynxContext.getEventEmitter() is null.");
        } else {
            lynxContext.getEventEmitter().sendCustomEvent(lynxCustomEvent);
        }
    }

    public JavaOnlyMap getListPlatformInfo(int i) {
        return nativeGetListPlatformInfo(this.mNativePtr, this.mNativeLifecycle, i);
    }

    public void renderChild(int i, int i2, long j) {
        nativeRenderChild(this.mNativePtr, this.mNativeLifecycle, i, i2, j);
    }

    public void updateChild(int i, int i2, int i3, long j) {
        nativeUpdateChild(this.mNativePtr, this.mNativeLifecycle, i, i2, i3, j);
    }

    public void removeChild(int i, int i2) {
        nativeRemoveChild(this.mNativePtr, this.mNativeLifecycle, i, i2);
    }

    public int obtainChild(int i, int i2, long j, boolean z) {
        return nativeObtainChild(this.mNativePtr, this.mNativeLifecycle, i, i2, j, z);
    }

    public void recycleChild(int i, int i2) {
        nativeRecycleChild(this.mNativePtr, this.mNativeLifecycle, i, i2);
    }

    public void obtainChildAsync(int i, int i2, long j) {
        nativeObtainChildAsync(this.mNativePtr, this.mNativeLifecycle, i, i2, j);
    }

    public void recycleChildAsync(int i, int i2) {
        nativeRecycleChildAsync(this.mNativePtr, this.mNativeLifecycle, i, i2);
    }

    public void scrollByListContainer(int i, float f, float f2, float f3, float f4) {
        nativeScrollByListContainer(this.mNativePtr, this.mNativeLifecycle, i, f, f2, f3, f4);
    }

    public void scrollToPosition(int i, int i2, float f, int i3, boolean z) {
        nativeScrollToPosition(this.mNativePtr, this.mNativeLifecycle, i, i2, f, i3, z);
    }

    public void scrollStopped(int i) {
        nativeScrollStopped(this.mNativePtr, this.mNativeLifecycle, i);
    }

    private String getJSGroupThreadNameIfNeed() {
        LynxGroup lynxGroup = this.mGroup;
        return (lynxGroup == null || !lynxGroup.enableJSGroupThread()) ? "" : getGroupID();
    }

    private void destroyLynxEngine() {
        LynxEngine lynxEngine;
        if (this.mIsDestroyed.compareAndSet(false, true)) {
            if (this.mEnableReuseEngine && (lynxEngine = this.mLynxEngineRef) != null && (lynxEngine.tryBeReusing() || !this.mLynxEngineRef.hasLoaded())) {
                this.mLynxEngineRef.destroy();
                ILynxUIRenderer iLynxUIRenderer = this.mLynxUIRender;
                if (iLynxUIRenderer != null) {
                    iLynxUIRenderer.onDestroyTemplateRenderer();
                }
            } else {
                ILynxUIRenderer iLynxUIRenderer2 = this.mLynxUIRender;
                if (iLynxUIRenderer2 != null) {
                    iLynxUIRenderer2.onDestroyTemplateRenderer();
                }
            }
            NativeFacade nativeFacade = this.mNativeFacade;
            if (nativeFacade != null) {
                nativeFacade.destroyAnyThreadPart();
            }
            UIThreadUtils.runOnUiThreadImmediately(new DestroyTask(this.mNativePtr, this.mNativeLifecycle, this, this.mNativeFacade));
            Map<Double, PlatformCallBack> map = this.platformCallBackMap;
            if (map != null) {
                map.clear();
            }
            JSProxy jSProxy = this.mJSProxy;
            if (jSProxy != null) {
                jSProxy.destroy();
                this.mJSProxy = null;
            }
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.destroy();
            }
            LynxLayoutProxy lynxLayoutProxy = this.mLayoutProxy;
            if (lynxLayoutProxy != null) {
                lynxLayoutProxy.destroy();
            }
            this.mTasmPlatformInvoker = null;
            this.mNativeFacade = null;
            this.mNativeLifecycle = 0L;
            this.mNativePtr = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class DestroyTask implements Runnable {
        private NativeFacade mNativeFacade;
        private long mNativeLifecycle;
        private long mNativePtr;
        private LynxTemplateRender mRenderer;

        public DestroyTask(long j, long j2, LynxTemplateRender lynxTemplateRender, NativeFacade nativeFacade) {
            this.mNativePtr = j;
            this.mNativeLifecycle = j2;
            this.mRenderer = (j2 == 0 || j == 0) ? null : lynxTemplateRender;
            this.mNativeFacade = nativeFacade;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j = this.mNativeLifecycle;
            if (j != 0 && this.mNativePtr != 0) {
                if (LynxTemplateRender.nativeLifecycleTryTerminate(j)) {
                    LynxTemplateRender.nativeDestroy(this.mNativePtr);
                    this.mNativePtr = 0L;
                    this.mNativeLifecycle = 0L;
                    this.mRenderer = null;
                } else {
                    UIThreadUtils.runOnUiThread(this, 1L);
                }
            }
            NativeFacade nativeFacade = this.mNativeFacade;
            if (nativeFacade != null) {
                nativeFacade.destroyUiThreadPart();
                this.mNativeFacade = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class CleanupOnUiThread implements Runnable {
        private long mNativePtr;

        public CleanupOnUiThread(long j) {
            this.mNativePtr = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j = this.mNativePtr;
            if (j == 0) {
                return;
            }
            LynxTemplateRender.nativeLifecycleDestroy(j);
            this.mNativePtr = 0L;
        }
    }

    private boolean getAutoExpose() {
        LynxContext lynxContext = this.mLynxContext;
        return lynxContext != null && lynxContext.getAutoExpose();
    }

    private String getGroupID() {
        LynxGroup lynxGroup = this.mGroup;
        return lynxGroup != null ? lynxGroup.getID() : LynxGroup.SINGNLE_GROUP;
    }

    private String[] getPreloadJSPath() {
        LynxGroup lynxGroup = this.mGroup;
        if (lynxGroup != null) {
            return lynxGroup.getPreloadJSPaths();
        }
        return null;
    }

    private void recreateLynxUIRenderer() {
        ILynxUIRenderer createLynxUIRender = this.mLynxViewConfigProvider.getUIRendererCreator().createLynxUIRender();
        this.mLynxUIRender = createLynxUIRender;
        this.mBodyView.setLynxUIRendererInternal(createLynxUIRender);
    }

    public ILynxUIRenderer lynxUIRenderer() {
        if (this.mLynxUIRender == null) {
            UIBody.UIBodyView uIBodyView = this.mBodyView;
            if (uIBodyView != null) {
                this.mLynxUIRender = uIBodyView.getLynxUIRendererInternal();
            } else {
                this.mLynxUIRender = this.mLynxViewConfigProvider.getUIRendererCreator().createLynxUIRender();
            }
        }
        return this.mLynxUIRender;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchMessageEvent(ReadableMap readableMap) {
        long j = this.mNativePtr;
        if (j != 0) {
            nativeDispatchMessageEvent(j, this.mNativeLifecycle, readableMap);
        }
    }

    private void updateMetaDataInternal(TemplateData templateData, TemplateData templateData2) {
        long j;
        String str;
        boolean z;
        if (templateData == null && templateData2 == null) {
            LLog.m2577e(TAG, "updateMetaData with null data and null globalProps.");
            return;
        }
        long j2 = 0;
        if (templateData != null) {
            templateData.flush();
            long nativePtr = templateData.getNativePtr();
            str = templateData.processorName();
            z = templateData.isReadOnly();
            j = nativePtr;
        } else {
            j = 0;
            str = null;
            z = false;
        }
        if (templateData2 != null) {
            templateData2.flush();
            j2 = templateData2.getNativePtr();
        }
        nativeUpdateMetaData(this.mNativePtr, this.mNativeLifecycle, j, str, z, templateData, j2);
    }

    private void setThemeInternal(LynxTheme lynxTheme) {
        if (lynxTheme == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        lynxTheme.addToHashMap(hashMap, "theme");
        ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(hashMap);
        if (encodeMessage != null) {
            nativeUpdateConfig(this.mNativePtr, this.mNativeLifecycle, encodeMessage, encodeMessage.position());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryRegisterLynxEngineReused() {
        ILynxUIRenderer iLynxUIRenderer;
        if (this.mEnableReuseEngine) {
            if (this.mLynxContext != null && (iLynxUIRenderer = this.mLynxUIRender) != null && iLynxUIRenderer.getLynxRootUI() != null) {
                this.mLynxContext.setPlatformMeasureWidthCache(this.mLynxUIRender.getLynxRootUI().getWidth());
                this.mLynxContext.setPlatformMeasureHeightCache(this.mLynxUIRender.getLynxRootUI().getHeight());
            }
            if (this.mLynxEngineRef != null) {
                if (this.mEmbeddedPipelineCounter.decrementAndGet() == 0) {
                    this.mLynxEngineRef.registerLynxEngineReused();
                } else {
                    LLog.m2577e(TAG, "Can not call registerLynxEngineReused, because next pipeline is running. mEmbeddedPipelineCounter:" + this.mEmbeddedPipelineCounter.get());
                }
            }
        }
    }

    public LynxViewBuilder getLynxViewBuilder() {
        LynxViewBuilder lynxViewGroup = new LynxViewBuilder().setLynxViewGroup(this.mLynxViewBuilder.lynxViewGroup);
        if (lynxViewGroup.lynxViewGroup != null) {
            return lynxViewGroup;
        }
        ((LynxViewBuilder) ((LynxViewBuilder) lynxViewGroup.setUIRendererCreator(this.mLynxViewBuilder.getUIRendererCreator())).setFontLoader(this.mLynxViewBuilder.fontLoader).setImageFetcher(this.mLynxViewBuilder.imageFetcher).m2929setFontScale(this.mLynxViewBuilder.getFontScale()).setEnablePreUpdateData(true)).setDynamicComponentFetcher(this.mLynxViewBuilder.fetcher).setEnableGenericResourceFetcher(this.mLynxViewBuilder.getLynxRuntimeOptions().isEnableGenericResourceFetcher());
        lynxViewGroup.mergeLynxRuntimeOptions(this.mLynxViewBuilder.getLynxRuntimeOptions()).m2933setScreenSize(this.mLynxViewBuilder.getScreenWidth(), this.mLynxViewBuilder.getScreenHeight()).m2934setThreadStrategyForRendering(this.mLynxViewBuilder.getThreadStrategy());
        lynxViewGroup.setCustomBehaviorRegistry(this.mLynxViewBuilder.getBehaviorRegistry());
        return lynxViewGroup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachLynxEngineWrapper() {
        if (this.mEnableReuseEngine) {
            onTraceEventBegin(TraceEventDef.TEMPLATE_RENDER_DETACH_LYNX_ENGINE);
            if (getLynxContext() != null && getLynxContext().getUIBody() != null) {
                getLynxContext().getUIBody().detachUIBodyView();
            }
            if (this.mLynxEngineRef != null) {
                this.mLynxUIRender = null;
                UIBody.UIBodyView uIBodyView = this.mBodyView;
                if (uIBodyView != null) {
                    uIBodyView.setLynxUIRendererInternal((ILynxUIRenderer) null);
                }
                this.mLynxEngineRef = null;
                this.mTasmPlatformInvoker = null;
                LLog.m2578i(TAG, this + ", call detachLynxEngineWrapper");
                long j = this.mNativePtr;
                if (j != 0) {
                    nativeDetachLynxEngineWrapper(j, this.mNativeLifecycle);
                }
            }
            onTraceEventEnd(TraceEventDef.TEMPLATE_RENDER_DETACH_LYNX_ENGINE);
        }
    }

    public void setAttachLynxPageUICallback(UIBody.UIBodyView.attachLynxPageUICallback attachlynxpageuicallback) {
        LynxContext lynxContext = this.mLynxContext;
        if (lynxContext == null || lynxContext.getLynxUIOwner() == null) {
            return;
        }
        this.mLynxContext.getLynxUIOwner().setAttachLynxPageUICallback(attachlynxpageuicallback);
    }

    @Override // com.lynx.tasm.EventEmitter.LynxEventFallback
    public void checkFallbackForLynxEvent(boolean z) {
        checkEngineFallbackAndLoad(z);
    }

    private void getDataBack(ByteBuffer byteBuffer, int i) {
        LynxGetDataCallback lynxGetDataCallback = this.mCallbackSparseArray.get(i);
        Object decodeMessage = LepusBuffer.INSTANCE.decodeMessage(byteBuffer);
        if (decodeMessage instanceof Map) {
            lynxGetDataCallback.onSuccess(JavaOnlyMap.from((Map) decodeMessage));
        } else {
            lynxGetDataCallback.onFail("LynxView GetData Failed");
        }
    }

    private static Object decodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            return LepusBuffer.INSTANCE.decodeMessage(byteBuffer);
        }
        return null;
    }

    public void addRuntimeLifecycleListener(RuntimeLifecycleListener runtimeLifecycleListener) {
        JSProxy jSProxy;
        if (runtimeLifecycleListener == null || (jSProxy = this.mJSProxy) == null) {
            LLog.m2580w(TAG, "add a null lifecycle listener or js proxy is null.");
        } else {
            jSProxy.addLifecycleListener(runtimeLifecycleListener);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LogLynxViewClient extends LynxViewClient {
        private long mStartLoadTime = 0;

        @Override // com.lynx.tasm.LynxViewClient
        public void onPageStart(String str) {
            this.mStartLoadTime = System.currentTimeMillis();
        }

        @Override // com.lynx.tasm.LynxViewClient
        public void onLoadSuccess() {
            LLog.m2576d(LynxTemplateRender.TAG, "onLoadSuccess time: " + (System.currentTimeMillis() - this.mStartLoadTime));
        }

        @Override // com.lynx.tasm.LynxViewClient
        public void onFirstScreen() {
            LLog.m2576d(LynxTemplateRender.TAG, "onFirstScreen time: " + (System.currentTimeMillis() - this.mStartLoadTime));
        }

        @Override // com.lynx.tasm.LynxViewClient
        public void onPageUpdate() {
            LLog.m2576d(LynxTemplateRender.TAG, "onPageUpdate time:" + (System.currentTimeMillis() - this.mStartLoadTime));
        }

        @Override // com.lynx.tasm.LynxViewClient
        public void onDataUpdated() {
            LLog.m2576d(LynxTemplateRender.TAG, "onDataUpdated time:" + (System.currentTimeMillis() - this.mStartLoadTime));
        }
    }
}
