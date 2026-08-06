package com.lynx.tasm;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.webx.addr.AddressParam;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.larus.business.markdown.api.depend.ICustomDataHandlerKt;
import com.lynx.base.IBaseNativeLibraryLoader;
import com.lynx.base.LynxBaseEnv;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.devtoolwrapper.LynxDevToolUtils;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.tasm.LynxEnvLazyInitializer;
import com.lynx.tasm.base.GlobalRefQueue;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxNativeMemoryTracer;
import com.lynx.tasm.base.LynxTraceEnv;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.BehaviorBundle;
import com.lynx.tasm.behavior.BuiltInBehavior;
import com.lynx.tasm.behavior.herotransition.HeroTransitionManager;
import com.lynx.tasm.behavior.shadow.text.TextRendererCache;
import com.lynx.tasm.behavior.ui.background.BackgroundImageLoader;
import com.lynx.tasm.behavior.utils.LynxUIMethodsHolderAutoRegister;
import com.lynx.tasm.behavior.utils.PropsHolderAutoRegister;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.fluency.FluencySample;
import com.lynx.tasm.icu.ICURegister;
import com.lynx.tasm.provider.AbsNetworkingModuleProvider;
import com.lynx.tasm.provider.AbsTemplateProvider;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.provider.ResProvider;
import com.lynx.tasm.provider.ThemeResourceProvider;
import com.lynx.tasm.service.ILynxDevToolService;
import com.lynx.tasm.service.ILynxExtensionService;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import com.lynx.tasm.service.ILynxSystemInvokeService;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxEnv {
    public static final String SP_NAME = "lynx_env_config";
    protected static final String TAG = "LynxEnv";
    private static ILynxDevToolService devtoolService;
    protected static final ConcurrentHashMap<String, String> sExperimentSettingsMap = new ConcurrentHashMap<>();
    protected static final GlobalRefQueue sGlobalRefQueue;
    protected static Initializer sInitializer;
    protected static volatile LynxEnv sInstance;
    protected Application mContext;
    protected LynxModuleFactory mModuleFactory;
    protected AbsNetworkingModuleProvider mNetworkingModuleProvider;
    protected ResProvider mResProvider;
    protected SharedPreferences mSharedPreferences;
    protected AbsTemplateProvider mTemplateProvider;
    protected ThemeResourceProvider mThemeResourceProvider;
    protected BehaviorBundle mViewManagerBundle;
    protected final AtomicBoolean hasInit = new AtomicBoolean(false);
    protected boolean mDevToolComponentAttach = false;
    protected boolean mDebugModeEnabled = false;
    protected boolean mLayoutOnlyEnabled = true;
    protected boolean mRecordEnable = false;
    protected boolean mHighlightTouchEnabled = false;
    protected boolean mCreateViewAsync = true;
    protected boolean mVsyncAlignedFlushGlobalSwitch = true;

    @Deprecated
    protected boolean mEnableJSDebug = true;

    @Deprecated
    protected boolean mDebug = false;
    protected volatile boolean mIsNativeLibraryLoaded = false;
    protected boolean mIsDevLibraryLoaded = false;
    protected boolean mIsNativeUIThreadInited = false;
    protected final Map<String, Behavior> mBehaviorMap = new HashMap();
    protected final LynxViewClientGroup mClient = new LynxViewClientGroup();
    protected BackgroundImageLoader mBgImageLoader = null;
    protected InputMethodManager mInputMethodManager = null;
    protected boolean mIsCheckPropsSetter = true;
    protected volatile boolean hasCalledInitializer = false;
    protected INativeLibraryLoader mLibraryLoader = null;
    protected Map<String, LynxResourceProvider> mGlobalResourceProvider = new HashMap();
    protected String mLocale = null;
    protected String mLastUrl = null;
    protected boolean mDisableImagePostProcessor = false;
    protected boolean mEnableLoadImageFromService = false;
    protected boolean mEnableImageAsyncRedirect = false;
    protected boolean mEnableImageAsyncRedirectOnCreate = false;
    protected boolean mEnableImageAsyncRequest = false;
    protected boolean mEnableDataListFix = false;
    protected boolean mEnableImageRequestOptimize = false;
    protected boolean mEnableFlattenImageFlickerFix = false;
    protected boolean mEnableImageEventReport = false;
    protected boolean mEnableImageAsyncLayout = false;
    protected boolean mEnableImageMemoryReport = false;
    protected boolean mEnableComponentStatisticReport = false;
    protected boolean mEnableTransformForPositionCalculation = false;
    protected boolean mEnableSVGAsync = false;
    protected boolean mEnableGenericResourceFetcher = false;
    protected boolean mEnableTextBoringLayout = true;
    protected boolean mEnableRefreshRateOpt = true;
    protected boolean mEnableCheckAccessFromNonUIThread = false;
    protected final Object mLazyInitLock = new Object();
    private Boolean mHasV8BridgeLoadSuccess = false;
    private boolean mForceDisableQuickJsCache = false;
    private boolean mEnableLazyInitA11y = true;
    private boolean mEnableTextLayoutCache = true;
    private boolean mEnableInitDisplayMetricsInEnv = true;

    @Deprecated
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface Initializer {
        void init();
    }

    private static native void nativeClearBytecode(String str, boolean z);

    protected static native void nativeInitUIThread();

    protected static native void nativePrepareLynxGlobalPool();

    protected static native void nativeRunJavaTaskOnConcurrentLoop(long j, int i);

    @Deprecated
    public void enableRadonCompatible(boolean z) {
    }

    public String getLynxVersion() {
        return "3.5.25-rc.12";
    }

    @Deprecated
    public boolean isRadonCompatibleEnabled() {
        return true;
    }

    protected native void nativeCleanExternalCache();

    protected native String nativeGetDebugEnvDescription();

    protected native String nativeGetSSRApiVersion();

    public native void nativeSetEnvMask(String str, boolean z);

    public native void nativeSetGroupedEnv(String str, boolean z, String str2);

    public native void nativeSetGroupedEnvWithGroupSet(String str, Set<String> set);

    public native void nativeSetLocalEnv(String str, String str2);

    @Deprecated
    public void warmClass() {
    }

    static {
        LynxUIMethodsHolderAutoRegister.init();
        devtoolService = null;
        sGlobalRefQueue = new GlobalRefQueue();
    }

    protected LynxEnv() {
    }

    public static LynxEnv inst() {
        if (sInstance == null) {
            synchronized (LynxEnv.class) {
                if (sInstance == null) {
                    sInstance = new LynxEnv();
                }
            }
        }
        return sInstance;
    }

    public synchronized void init(Application application, INativeLibraryLoader iNativeLibraryLoader, AbsTemplateProvider absTemplateProvider, BehaviorBundle behaviorBundle) {
        init(application, iNativeLibraryLoader, absTemplateProvider, behaviorBundle, null);
    }

    @Deprecated
    public synchronized void init(Application application, INativeLibraryLoader iNativeLibraryLoader, AbsTemplateProvider absTemplateProvider, BehaviorBundle behaviorBundle, IDynamicHandler iDynamicHandler) {
        LynxServiceCenter.inst().initialize(application);
        initBase(iNativeLibraryLoader);
        initDevtoolComponentAttachSwitch();
        if (this.hasInit.get()) {
            LLog.m2580w(TAG, "LynxEnv is already initialized");
            return;
        }
        this.hasInit.set(true);
        LLog.m2578i(TAG, "LynxEnv start init");
        setAppTracingAllowed();
        PropsHolderAutoRegister.init();
        this.mContext = application;
        this.mViewManagerBundle = behaviorBundle;
        this.mTemplateProvider = absTemplateProvider;
        this.mLibraryLoader = iNativeLibraryLoader;
        setDebugMode(application);
        initBehaviors();
        getModuleFactory().setContext(application);
        initDevtoolEnv();
        if (initNativeLibraries(iNativeLibraryLoader)) {
            syncDevtoolComponentAttachSwitch();
            initTrace(this.mContext);
            postUpdateSettings();
            initNativeUIThread();
            initDisplayMetrics();
            initNativeGlobalPool();
            initImageExperimentSettings();
            initMemoryReportExperimentSettings();
            initEnableComponentStatisticReport();
            initEnableTransformForPositionCalculation();
            initEnableSvgAsync();
            initEnableGenericResourceFetcher();
            initEnableTextBoringLayout();
            initEnableRefreshRateOpt();
            initEnableCheckAccessFromNonUiThread();
            initEnableLazyInitA11y();
            initEnableTextLayoutCache();
            initEnableDataListFix();
            ICURegister.loadLibrary(this.mLibraryLoader);
            ILynxExtensionService service = LynxServiceCenter.inst().getService(ILynxExtensionService.class);
            if (service != null) {
                service.onLynxEnvSetup();
            } else {
                LLog.m2580w(TAG, "LynxEnv failed to get LynxExtensionService");
            }
            ILynxImageServiceExtension iLynxImageServiceExtension = (ILynxImageService) LynxServiceCenter.inst().getService(ILynxImageService.class);
            if (iLynxImageServiceExtension instanceof ILynxImageServiceExtension) {
                iLynxImageServiceExtension.onLynxEnvSetup();
            } else {
                LLog.m2580w(TAG, "LynxEnv failed to get ILynxImageServiceExtension");
            }
            initVsyncMonitor();
        }
    }

    protected void setDebugMode(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, 0);
        this.mSharedPreferences = sharedPreferences;
        if (sharedPreferences == null) {
            this.mDebugModeEnabled = false;
        } else {
            this.mDebugModeEnabled = sharedPreferences.getBoolean(LynxEnvKey.SP_KEY_ENABLE_DEBUG_MODE, false);
        }
        TraceEvent.markTraceDebugMode(this.mDebugModeEnabled);
    }

    protected void setAppTracingAllowed() {
        if (TraceEvent.enableSystemTrace()) {
            try {
                LLog.m2576d(TAG, "turn on systrace for app");
                Class.forName("android.os.Trace").getDeclaredMethod("setAppTracingAllowed", Boolean.TYPE).invoke(null, true);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    protected void initTrace(Context context) {
        if (this.mIsNativeLibraryLoaded && TraceEvent.enableTrace()) {
            try {
                TraceController.getInstance().init(context);
                TraceController.getInstance().startStartupTracingIfNeeded();
            } catch (Exception e) {
                e.printStackTrace();
                LLog.m2577e(TAG, "trace controller init failed");
            }
        }
    }

    @Deprecated
    public static void setLazyInitializer(Initializer initializer) {
        sInitializer = initializer;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lazyInitIfNeeded() {
        boolean z;
        synchronized (this.mLazyInitLock) {
            if (!this.hasInit.get() && !this.hasCalledInitializer) {
                LynxEnvLazyInitializer.Initializer initializer = LynxEnvLazyInitializer.getsInitializer();
                if (initializer == null && sInitializer == null) {
                    z = false;
                    this.hasCalledInitializer = z;
                    if (initializer == null) {
                        initializer.init();
                        return;
                    }
                    Initializer initializer2 = sInitializer;
                    if (initializer2 != null) {
                        initializer2.init();
                        return;
                    }
                    return;
                }
                z = true;
                this.hasCalledInitializer = z;
                if (initializer == null) {
                }
            }
        }
    }

    public void registerModule(String str, Class<? extends LynxModule> cls) {
        registerModule(str, cls, null);
    }

    public void registerModule(String str, Class<? extends LynxModule> cls, Object obj) {
        getModuleFactory().registerModule(str, cls, obj);
    }

    public LynxModuleFactory getModuleFactory() {
        if (this.mModuleFactory == null) {
            this.mModuleFactory = new LynxModuleFactory(this.mContext);
        }
        return this.mModuleFactory;
    }

    public void addResourceProvider(String str, LynxResourceProvider lynxResourceProvider) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mGlobalResourceProvider.put(str, lynxResourceProvider);
    }

    public Map<String, LynxResourceProvider> getResourceProvider() {
        return this.mGlobalResourceProvider;
    }

    protected void initLibraryLoader(INativeLibraryLoader iNativeLibraryLoader) {
        if (iNativeLibraryLoader != null) {
            this.mLibraryLoader = iNativeLibraryLoader;
        } else if (this.mLibraryLoader == null) {
            this.mLibraryLoader = new INativeLibraryLoader() { // from class: com.lynx.tasm.LynxEnv$$ExternalSyntheticLambda0
                @Override // com.lynx.tasm.INativeLibraryLoader
                public final void loadLibrary(String str) {
                    System.loadLibrary(str);
                }
            };
        }
    }

    public synchronized boolean initNativeLibraries(INativeLibraryLoader iNativeLibraryLoader) {
        if (this.mIsNativeLibraryLoaded) {
            return true;
        }
        initLibraryLoader(iNativeLibraryLoader);
        try {
            if (LynxLiteConfigs.requireQuickSharedLibrary()) {
                this.mLibraryLoader.loadLibrary("quick");
            }
            if (!LynxBaseEnv.inst().isNativeLibraryLoaded()) {
                initBase(this.mLibraryLoader);
            }
            this.mLibraryLoader.loadLibrary(ICustomDataHandlerKt.TYPE_LYNX);
            if (!LynxTraceEnv.inst().isNativeLibraryLoaded()) {
                this.mLibraryLoader.loadLibrary("lynxtrace");
                LynxTraceEnv.inst().markNativeLibraryLoaded(true);
            }
            this.mIsNativeLibraryLoaded = true;
            LLog.m2578i(TAG, "Loading native libraries succeeded");
            return true;
        } catch (UnsatisfiedLinkError e) {
            LLog.m2577e(TAG, e.getMessage() + ". Loader used was: " + this.mLibraryLoader);
            return false;
        }
    }

    @Deprecated
    public void loadNativeLynxLibrary(INativeLibraryLoader iNativeLibraryLoader) {
        initNativeLibraries(iNativeLibraryLoader);
    }

    protected void initBehaviors() {
        synchronized (this.mBehaviorMap) {
            Iterator it = new BuiltInBehavior().create().iterator();
            while (it.hasNext()) {
                addBehaviorInner((Behavior) it.next());
            }
            if (getBehaviorBundle() != null) {
                List create = getBehaviorBundle().create();
                if (create == null) {
                    return;
                }
                Iterator it2 = create.iterator();
                while (it2.hasNext()) {
                    addBehaviorInner((Behavior) it2.next());
                }
            }
        }
    }

    public void addBehaviors(List<Behavior> list) {
        synchronized (this.mBehaviorMap) {
            Iterator<Behavior> it = list.iterator();
            while (it.hasNext()) {
                addBehaviorInner(it.next());
            }
        }
    }

    public void addBehavior(Behavior behavior) {
        synchronized (this.mBehaviorMap) {
            addBehaviorInner(behavior);
        }
    }

    private void addBehaviorInner(Behavior behavior) {
        String name;
        if (behavior == null || (name = behavior.getName()) == null) {
            return;
        }
        if (this.mBehaviorMap.containsKey(name)) {
            LLog.m2577e(TAG, "Duplicated Behavior For Name " + name + " was added, oldBehavior will be override");
        }
        this.mBehaviorMap.put(name, behavior);
    }

    public List<Behavior> getBehaviors() {
        ArrayList arrayList;
        synchronized (this.mBehaviorMap) {
            arrayList = new ArrayList(this.mBehaviorMap.values());
        }
        return arrayList;
    }

    public Map<String, Behavior> getBehaviorMap() {
        HashMap hashMap;
        synchronized (this.mBehaviorMap) {
            hashMap = new HashMap(this.mBehaviorMap);
        }
        return hashMap;
    }

    public AbsTemplateProvider getTemplateProvider() {
        return this.mTemplateProvider;
    }

    public AbsNetworkingModuleProvider getNetworkingModuleProvider() {
        return this.mNetworkingModuleProvider;
    }

    public ResProvider getResProvider() {
        return this.mResProvider;
    }

    public void setResProvider(ResProvider resProvider) {
        this.mResProvider = resProvider;
    }

    public ThemeResourceProvider getThemeResourceProviderProvider() {
        return this.mThemeResourceProvider;
    }

    public void setThemeResourceProvider(ThemeResourceProvider themeResourceProvider) {
        this.mThemeResourceProvider = themeResourceProvider;
    }

    public BehaviorBundle getBehaviorBundle() {
        return this.mViewManagerBundle;
    }

    public synchronized String getLastUrl() {
        return this.mLastUrl;
    }

    public void setLastUrl(String str) {
        this.mLastUrl = str;
    }

    public boolean hasInited() {
        return this.hasInit.get();
    }

    protected void initDevtoolEnv() {
        if (!isLynxDebugEnabled() || this.mContext == null) {
            return;
        }
        try {
            ILynxDevToolService service = LynxServiceCenter.inst().getService(ILynxDevToolService.class);
            devtoolService = service;
            if (service != null) {
                service.devtoolEnvInit(this.mContext);
            } else {
                LLog.m2577e(TAG, "failed to get DevtoolService");
            }
        } catch (Exception e) {
            LLog.m2577e(TAG, "initDevtoolEnv failed: " + e.toString());
        }
    }

    public void setDevtoolEnv(String str, Object obj) {
        if (isNativeLibraryLoaded() && isLynxDebugEnabled()) {
            LynxDevToolUtils.setDevtoolEnv(str, obj);
        }
    }

    public void setDevtoolEnv(String str, Set<String> set) {
        if (isNativeLibraryLoaded() && isLynxDebugEnabled()) {
            LynxDevToolUtils.setDevtoolEnv(str, set);
        }
    }

    public boolean getDevtoolEnv(String str, boolean z) {
        return ((Boolean) getDevtoolEnvInternal(str, Boolean.valueOf(z))).booleanValue();
    }

    public int getDevtoolEnv(String str, int i) {
        return ((Integer) getDevtoolEnvInternal(str, Integer.valueOf(i))).intValue();
    }

    protected Object getDevtoolEnvInternal(String str, Object obj) {
        if (!isNativeLibraryLoaded()) {
            LLog.m2577e(TAG, "getDevtoolEnv must be called after init! key: " + str);
            return obj;
        }
        if (!isLynxDebugEnabled()) {
            LLog.m2577e(TAG, "getDevtoolEnv must be called when isLynxDebugEnabled = true key: " + str);
            return obj;
        }
        return LynxDevToolUtils.getDevtoolEnv(str, obj);
    }

    public Set<String> getDevtoolEnv(String str) {
        if (!isNativeLibraryLoaded()) {
            return new HashSet();
        }
        if (!isLynxDebugEnabled()) {
            LLog.m2577e(TAG, "getDevtoolEnv must be called when isLynxDebugEnabled = true groupKey: " + str);
            return new HashSet();
        }
        return LynxDevToolUtils.getDevtoolEnv(str);
    }

    public boolean isLynxDebugEnabled() {
        ILynxDevToolService service = LynxServiceCenter.inst().getService(ILynxDevToolService.class);
        return this.mDevToolComponentAttach && service != null && service.getLynxDebugPresetValue();
    }

    public void initDevtool() {
        initDevtoolComponentAttachSwitch();
        initDevtoolEnv();
        syncDevtoolComponentAttachSwitch();
    }

    public void enableLynxDebug(boolean z) {
        LLog.m2578i(TAG, z ? "enable lynx debug" : "disable lynx debug");
        ILynxDevToolService service = LynxServiceCenter.inst().getService(ILynxDevToolService.class);
        if (service != null) {
            service.setLynxDebugPresetValue(z);
        }
        initDevtoolEnv();
        if (this.mIsNativeLibraryLoaded) {
            setBooleanLocalEnv(LynxEnvKey.LYNX_DEBUG_ENABLED, isLynxDebugEnabled());
        }
    }

    protected void initDevtoolComponentAttachSwitch() {
        ILynxDevToolService service = LynxServiceCenter.inst().getService(ILynxDevToolService.class);
        devtoolService = service;
        if (service != null) {
            this.mDevToolComponentAttach = service.isDevtoolAttached();
        } else {
            this.mDevToolComponentAttach = false;
        }
        LLog.m2578i(TAG, "The current application has embedded the DevTool Component: " + this.mDevToolComponentAttach);
    }

    protected void syncDevtoolComponentAttachSwitch() {
        if (isNativeLibraryLoaded() && this.mDevToolComponentAttach) {
            setBooleanLocalEnv(LynxEnvKey.DEVTOOL_COMPONENT_ATTACH, true);
            setBooleanLocalEnv(LynxEnvKey.LYNX_DEBUG_ENABLED, isLynxDebugEnabled());
        }
    }

    public boolean isDevtoolComponentAttach() {
        return this.mDevToolComponentAttach;
    }

    public boolean isDevtoolEnabled() {
        if (isLynxDebugEnabled()) {
            return getDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_DEVTOOL, false);
        }
        return false;
    }

    public void enableDevtool(boolean z) {
        LLog.m2578i(TAG, z ? "Turn on devtool" : "Turn off devtool");
        if (z) {
            LLog.setMinimumLoggingLevel(0);
        } else {
            LLog.setMinimumLoggingLevel(2);
        }
        setDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_DEVTOOL, Boolean.valueOf(z));
    }

    @Deprecated
    public boolean isRedBoxEnabled() {
        return isLogBoxEnabled();
    }

    public boolean isLogBoxEnabled() {
        ILynxDevToolService service = LynxServiceCenter.inst().getService(ILynxDevToolService.class);
        return isLynxDebugEnabled() && getDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_LOGBOX, true) && service != null && service.getLogBoxPresetValue();
    }

    @Deprecated
    public void enableRedBox(boolean z) {
        enableLogBox(z);
    }

    public void enableLogBox(boolean z) {
        LLog.m2578i(TAG, z ? "Turn on logbox" : "Turn off logbox");
        setDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_LOGBOX, Boolean.valueOf(z));
    }

    public boolean isPixelCopyEnabled() {
        return getDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_PIXEL_COPY, true);
    }

    public void enablePixelCopy(boolean z) {
        setDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_PIXEL_COPY, Boolean.valueOf(z));
    }

    public boolean isHighlightTouchEnabled() {
        return this.mHighlightTouchEnabled && isLynxDebugEnabled();
    }

    public void enableHighlightTouch(boolean z) {
        LLog.m2578i(TAG, z ? "Turn on highlighttouch" : "Turn off highlighttouch");
        setDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_HIGHLIGHT_TOUCH, Boolean.valueOf(z));
        this.mHighlightTouchEnabled = z;
    }

    public boolean isDebugModeEnabled() {
        return this.mDebugModeEnabled;
    }

    public void enableDebugMode(boolean z) {
        LLog.m2578i(TAG, z ? "Turn on DebugMode" : "Turn off DebugMode");
        this.mDebugModeEnabled = z;
        TraceEvent.markTraceDebugMode(z);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            LLog.m2577e(TAG, "enableDebugMode() must be called after init()");
        } else {
            sharedPreferences.edit().putBoolean(LynxEnvKey.SP_KEY_ENABLE_DEBUG_MODE, z).apply();
        }
    }

    public boolean isLaunchRecordEnabled() {
        return getDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_LAUNCH_RECORD, false);
    }

    public void enableLaunchRecord(boolean z) {
        LLog.m2578i(TAG, z ? "Turn on launch record" : "Turn off launch record");
        setDevtoolEnv(LynxEnvKey.SP_KEY_ENABLE_LAUNCH_RECORD, Boolean.valueOf(z));
    }

    public void enableLayoutOnly(boolean z) {
        LLog.m2578i(TAG, z ? "Turn on LayoutOnly" : "Turn off LayoutOnly");
        this.mLayoutOnlyEnabled = z;
    }

    public boolean enableVSyncAlignedMessageLoopGlobal() {
        return getBooleanFromExternalEnv(LynxEnvKey.ENABLE_VSYNC_ALIGNED_MESSAGE_LOOP_GLOBAL, false);
    }

    public boolean shouldForceLayoutOnBackgroundThread() {
        return getBooleanFromExternalEnv(LynxEnvKey.FORCE_LAYOUT_ON_BACKGROUND_THREAD, false);
    }

    public boolean isLayoutOnlyEnabled() {
        return this.mLayoutOnlyEnabled;
    }

    public void setRecordEnable(boolean z) {
        this.mRecordEnable = z;
    }

    public boolean getRecordEnable() {
        return this.mRecordEnable;
    }

    public void setCreateViewAsync(boolean z) {
        this.mCreateViewAsync = z;
        LLog.m2578i("LynxEnv_mCreateViewAsync:", z ? "true" : "false");
    }

    public void setVsyncAlignedFlushGlobalSwitch(boolean z) {
        this.mVsyncAlignedFlushGlobalSwitch = z;
        setBooleanLocalEnv(LynxEnvKey.ENABLE_VSYNC_ALIGNED_FLUSH, z);
        LLog.m2578i(TAG, "mVsyncAlignedFlushGlobalSwitch: " + this.mVsyncAlignedFlushGlobalSwitch);
    }

    public boolean getCreateViewAsync() {
        return this.mCreateViewAsync;
    }

    public Boolean getEnableMemoryMonitor() {
        return Boolean.valueOf(getBooleanFromExternalEnv(LynxEnvKey.ENABLE_MEMORY_MONITOR, false));
    }

    public String getMemoryAcquisitionDelaySec() {
        return getStringFromExternalEnv(LynxEnvKey.MEMORY_ACQUISITION_DELAY_SEC);
    }

    public long getMemoryReportIntervalSec() {
        String stringFromExternalEnv = getStringFromExternalEnv(LynxEnvKey.MEMORY_REPORT_INTERVAL_SEC);
        if (stringFromExternalEnv != null && !stringFromExternalEnv.isEmpty()) {
            try {
                return Long.parseLong(stringFromExternalEnv);
            } catch (NumberFormatException unused) {
            }
        }
        return 1200L;
    }

    public int getGlobalMemoryReportThresholdMB() {
        return getIntFromExternalEnv(LynxEnvKey.GLOBAL_MEMORY_REPORT_THRESHOLD_MB, 30);
    }

    public static int getIntFromExternalEnv(LynxEnvKey lynxEnvKey, int i) {
        String stringFromExternalEnv = getStringFromExternalEnv(lynxEnvKey.getDescription());
        if (stringFromExternalEnv != null && !stringFromExternalEnv.isEmpty()) {
            try {
                return Integer.parseInt(stringFromExternalEnv);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public boolean getVsyncAlignedFlushGlobalSwitch() {
        return this.mVsyncAlignedFlushGlobalSwitch;
    }

    public boolean isSettingsEnableNewImage() {
        return getBooleanFromExternalEnv(LynxEnvKey.USE_NEW_IMAGE, true);
    }

    @Deprecated
    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    @Deprecated
    public void setEnableDevtoolDebug(boolean z) {
        enableDevtool(z);
    }

    @Deprecated
    public boolean isEnableDevtoolDebug() {
        return isDevtoolEnabled();
    }

    @Deprecated
    public void setEnableJSDebug(boolean z) {
        this.mEnableJSDebug = z;
    }

    @Deprecated
    public boolean isEnableJSDebug() {
        return this.mEnableJSDebug;
    }

    @Deprecated
    public void setEnableLogBox(boolean z) {
        enableLogBox(z);
    }

    @Deprecated
    public boolean isEnableLogBox() {
        return isLogBoxEnabled();
    }

    public boolean isNativeLibraryLoaded() {
        lazyInitIfNeeded();
        return this.mIsNativeLibraryLoaded;
    }

    public void setNativeLibraryLoaded(boolean z) {
        this.mIsNativeLibraryLoaded = z;
    }

    public Context getAppContext() {
        return this.mContext;
    }

    @Deprecated
    public void setNetworkingModuleProvider(AbsNetworkingModuleProvider absNetworkingModuleProvider) {
        this.mNetworkingModuleProvider = absNetworkingModuleProvider;
    }

    public void onLowMemory() {
        TextRendererCache.cache().onLowMemory();
    }

    public InputMethodManager getInputMethodManager() {
        if (this.mInputMethodManager == null) {
            this.mInputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        }
        return this.mInputMethodManager;
    }

    public void setBackgroundImageLoader(BackgroundImageLoader backgroundImageLoader) {
        this.mBgImageLoader = backgroundImageLoader;
    }

    public BackgroundImageLoader getBackgroundImageLoader() {
        return this.mBgImageLoader;
    }

    public HeroTransitionManager getHeroTransitionManager() {
        return HeroTransitionManager.inst();
    }

    public String getSSRApiVersion() {
        if (!this.mIsNativeLibraryLoaded) {
            LLog.m2577e(TAG, "The local library is not loaded, getting the ssr api version failed.");
            return "";
        }
        return nativeGetSSRApiVersion();
    }

    public void addLynxViewClient(LynxViewClient lynxViewClient) {
        if (lynxViewClient == null) {
            return;
        }
        this.mClient.addClient(lynxViewClient);
    }

    public void removeLynxViewClient(LynxViewClient lynxViewClient) {
        if (lynxViewClient == null) {
            return;
        }
        this.mClient.removeClient(lynxViewClient);
    }

    public void setLocale(String str) {
        this.mLocale = str;
    }

    public String getLocale() {
        if (this.mLocale == null) {
            ILynxSystemInvokeService service = LynxServiceCenter.inst().getService(ILynxSystemInvokeService.class);
            if (service != null) {
                this.mLocale = service.getLocale();
            } else {
                this.mLocale = Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
            }
        }
        return this.mLocale;
    }

    public LynxViewClientGroup getLynxViewClient() {
        return this.mClient;
    }

    public void setCheckPropsSetter(boolean z) {
        this.mIsCheckPropsSetter = z;
    }

    public void setSettings(HashMap<String, Object> hashMap) {
        sExperimentSettingsMap.clear();
        postUpdateSettings();
    }

    protected void postUpdateSettings() {
        if (this.mIsNativeLibraryLoaded) {
            nativeCleanExternalCache();
            FluencySample.needCheckUpdate();
        }
    }

    public boolean isCheckPropsSetter() {
        return this.mIsCheckPropsSetter;
    }

    public void setDevLibraryLoaded(boolean z) {
        this.mIsDevLibraryLoaded = z;
    }

    public void setUpNativeMemoryTracer(Context context, int i) {
        LynxNativeMemoryTracer.setup(context, i);
    }

    public void setUpNativeMemoryTracer(Context context) {
        LynxNativeMemoryTracer.setup(context);
    }

    public boolean isDevLibraryLoaded() {
        return this.mIsDevLibraryLoaded;
    }

    public INativeLibraryLoader getLibraryLoader() {
        return this.mLibraryLoader;
    }

    public void reportModuleCustomError(String str) {
        this.mClient.onReceivedError(new LynxError(str, LynxSubErrorCode.E_NATIVE_MODULES_CUSTOM_ERROR));
    }

    public void setPiperMonitorState(boolean z) {
        setBooleanLocalEnv(LynxEnvKey.ENABLE_PIPER_MONITOR, z);
    }

    protected void onPiperInvoked(Map<String, Object> map) {
        this.mClient.onPiperInvoked(map);
    }

    public static void reportPiperInvoked(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("module-name", str);
        hashMap.put("method-name", str2);
        hashMap.put("url", str4);
        if (!str3.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str3);
            hashMap.put("params", arrayList);
        }
        inst().onPiperInvoked(hashMap);
    }

    public HashMap<String, String> GetNativeEnvDebugDescription() {
        try {
            return (HashMap) new Gson().fromJson(nativeGetDebugEnvDescription(), HashMap.class);
        } catch (JsonSyntaxException e) {
            LLog.m2577e(TAG, "Convert native env json string failed. e: " + e.getMessage());
            return null;
        }
    }

    public HashMap<String, String> GetPlatformEnvDebugDescription() {
        String stringFromExternalEnv;
        HashMap<String, String> hashMap = new HashMap<>();
        for (LynxEnvKey lynxEnvKey : LynxEnvKey.values()) {
            String description = lynxEnvKey.getDescription();
            if (description != null && (stringFromExternalEnv = getStringFromExternalEnv(lynxEnvKey)) != null) {
                hashMap.put(description, stringFromExternalEnv);
            }
        }
        return hashMap;
    }

    public void setStringLocalEnv(LynxEnvKey lynxEnvKey, String str) {
        nativeSetLocalEnv(lynxEnvKey.getDescription(), str);
    }

    public void setBooleanLocalEnv(LynxEnvKey lynxEnvKey, boolean z) {
        nativeSetLocalEnv(lynxEnvKey.getDescription(), z ? "1" : AddressParam.TYPE_DISAPPROVE);
    }

    public boolean disableImagePostProcessor() {
        return this.mDisableImagePostProcessor;
    }

    public boolean enableLoadImageFromService() {
        return this.mEnableLoadImageFromService;
    }

    public boolean enableImageEventReport() {
        return this.mEnableImageEventReport;
    }

    public boolean enableImageAsyncRedirect() {
        return this.mEnableImageAsyncRedirect;
    }

    public boolean enableImageAsyncRedirectOnCreate() {
        return this.mEnableImageAsyncRedirectOnCreate;
    }

    public boolean enableImageAsyncRequest() {
        return this.mEnableImageAsyncRequest;
    }

    public boolean enableImageAsyncLayout() {
        return this.mEnableImageAsyncLayout;
    }

    public boolean enableImageRequestOptimize() {
        return this.mEnableImageRequestOptimize;
    }

    public boolean enableFlattenImageFlickerFix() {
        return this.mEnableFlattenImageFlickerFix;
    }

    protected void initImageExperimentSettings() {
        this.mDisableImagePostProcessor = getBooleanFromExternalEnv(LynxEnvKey.DISABLE_POST_PROCESSOR, false);
        this.mEnableLoadImageFromService = getBooleanFromExternalEnv(LynxEnvKey.USE_NEW_IMAGE, false);
        this.mEnableImageAsyncRedirect = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_ASYNC_REDIRECT, false);
        this.mEnableImageAsyncRedirectOnCreate = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_ASYNC_REDIRECT_ON_CREATE, false);
        this.mEnableImageAsyncRequest = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_ASYNC_REQUEST, false);
        this.mEnableImageEventReport = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_EVENT_REPORT, false);
        this.mEnableImageAsyncLayout = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_ASYNC_LAYOUT, false);
        this.mEnableImageRequestOptimize = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_REQUEST_OPTIMIZE, false);
        this.mEnableFlattenImageFlickerFix = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_FLATTEN_IMAGE_FLICKER_FIX, true);
    }

    public boolean enableImageMemoryReport() {
        return this.mEnableImageMemoryReport;
    }

    protected void initMemoryReportExperimentSettings() {
        this.mEnableImageMemoryReport = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_MEMORY_REPORT, false);
    }

    public boolean enableComponentStatisticReport() {
        return this.mEnableComponentStatisticReport;
    }

    protected void initEnableComponentStatisticReport() {
        this.mEnableComponentStatisticReport = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_COMPONENT_STATISTIC_REPORT, false);
    }

    public boolean enableTransformForPositionCalculation() {
        return this.mEnableTransformForPositionCalculation;
    }

    protected void initEnableTransformForPositionCalculation() {
        this.mEnableTransformForPositionCalculation = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_TRANSFORM_FOR_POSITION_CALCULATION, false);
    }

    public boolean enableSvgAsync() {
        return this.mEnableSVGAsync;
    }

    public void initEnableSvgAsync() {
        this.mEnableSVGAsync = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_SVG_ASYNC, false);
    }

    public boolean enableGenericResourceFetcher() {
        return this.mEnableGenericResourceFetcher;
    }

    public boolean enableTextBoringLayout() {
        return this.mEnableTextBoringLayout;
    }

    public boolean enableFreshRateOpt() {
        return this.mEnableRefreshRateOpt;
    }

    public boolean enableCheckAccessFromNonUIThread() {
        return this.mEnableCheckAccessFromNonUIThread;
    }

    public boolean enableTextLayoutCache() {
        return this.mEnableTextLayoutCache;
    }

    public boolean enableLazyInitA11y() {
        return this.mEnableLazyInitA11y;
    }

    protected void initEnableGenericResourceFetcher() {
        this.mEnableGenericResourceFetcher = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_GENERIC_RESOURCE_FETCHER, false);
    }

    protected void initEnableTextBoringLayout() {
        this.mEnableTextBoringLayout = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_TEXT_BORING_LAYOUT, true);
    }

    protected void initEnableRefreshRateOpt() {
        this.mEnableRefreshRateOpt = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_REFRESH_RATE_OPT, true);
    }

    protected void initEnableCheckAccessFromNonUiThread() {
        this.mEnableCheckAccessFromNonUIThread = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_CHECK_ACCESS_FROM_NON_UI_THREAD, false);
    }

    protected void initEnableTextLayoutCache() {
        this.mEnableTextLayoutCache = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_TEXT_LAYOUT_CACHE, true);
    }

    protected void initEnableLazyInitA11y() {
        this.mEnableLazyInitA11y = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_LAZY_INIT_A11Y, true);
    }

    private void initDisplayMetrics() {
        boolean booleanFromExternalEnv = getBooleanFromExternalEnv(LynxEnvKey.INIT_DISPLAY_METRICS_IN_ENV, true);
        this.mEnableInitDisplayMetricsInEnv = booleanFromExternalEnv;
        if (booleanFromExternalEnv) {
            DisplayMetricsHolder.updateOrInitDisplayMetrics(this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean enableDataListFix() {
        return this.mEnableDataListFix;
    }

    private void initEnableDataListFix() {
        this.mEnableDataListFix = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_DATA_LIST_FIX, false);
    }

    private void initBase(final INativeLibraryLoader iNativeLibraryLoader) {
        LynxBaseEnv.inst().init(iNativeLibraryLoader != null ? new IBaseNativeLibraryLoader() { // from class: com.lynx.tasm.LynxEnv.1
            @Override // com.lynx.base.IBaseNativeLibraryLoader
            public void loadLibrary(String str) throws UnsatisfiedLinkError {
                iNativeLibraryLoader.loadLibrary(str);
            }
        } : null, isDevtoolEnabled());
    }

    public void initNativeUIThread() {
        if (this.mIsNativeUIThreadInited) {
            return;
        }
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.LynxEnv.2
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEnv.this.mIsNativeLibraryLoaded) {
                    LynxEnv.nativeInitUIThread();
                    LynxEnv.this.mIsNativeUIThreadInited = true;
                }
            }
        });
    }

    protected static String getStringFromExternalEnv(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = sExperimentSettingsMap;
        String str2 = concurrentHashMap.get(str);
        if (str2 == null) {
            ILynxTrailService service = LynxServiceCenter.inst().getService(ILynxTrailService.class);
            if (service != null) {
                str2 = service.stringValueForTrailKey(str);
            }
            if (str2 == null) {
                str2 = "";
            }
            concurrentHashMap.put(str, str2);
        }
        return str2;
    }

    public static String getStringFromExternalEnv(LynxEnvKey lynxEnvKey) {
        return getStringFromExternalEnv(lynxEnvKey.getDescription());
    }

    public static boolean getBooleanFromExternalEnv(LynxEnvKey lynxEnvKey, boolean z) {
        String stringFromExternalEnv = getStringFromExternalEnv(lynxEnvKey.getDescription());
        return (stringFromExternalEnv == null || stringFromExternalEnv.isEmpty()) ? z : "1".equals(stringFromExternalEnv) || "true".equalsIgnoreCase(stringFromExternalEnv);
    }

    public static boolean runJavaTaskOnConcurrentLoop(Runnable runnable, int i) {
        long push = sGlobalRefQueue.push(runnable);
        if (push < 0) {
            LLog.m2577e(TAG, "Failed to get free slot for java task");
            return false;
        }
        nativeRunJavaTaskOnConcurrentLoop(push, i);
        return true;
    }

    public static void onJavaTaskOnConcurrentLoop(long j, int i) {
        Runnable runnable = (Runnable) sGlobalRefQueue.pop(j);
        if (runnable == null) {
            LLog.m2577e(TAG, "Failed to get java task for id " + j + " type " + i);
        } else {
            runnable.run();
        }
    }

    protected void initNativeGlobalPool() {
        if (this.mIsNativeLibraryLoaded) {
            nativePrepareLynxGlobalPool();
        }
    }

    public static void clearBytecode(String str, boolean z) {
        if (inst().isNativeLibraryLoaded()) {
            nativeClearBytecode(str, z);
        }
    }

    public boolean tryToLoadV8Bridge(boolean z) {
        synchronized (this) {
            if (this.mHasV8BridgeLoadSuccess.booleanValue()) {
                return true;
            }
            try {
                INativeLibraryLoader iNativeLibraryLoader = this.mLibraryLoader;
                if (iNativeLibraryLoader != null) {
                    iNativeLibraryLoader.loadLibrary("lynx_v8_bridge");
                } else {
                    System.loadLibrary("lynx_v8_bridge");
                }
                this.mHasV8BridgeLoadSuccess = true;
            } catch (Throwable th) {
                LLog.m2580w(TAG, "try to load library lynx_v8_bridge error" + th.toString());
                this.mHasV8BridgeLoadSuccess = false;
            }
            return this.mHasV8BridgeLoadSuccess.booleanValue();
        }
    }

    public void forceDisableQuickJsCache() {
        this.mForceDisableQuickJsCache = true;
        setBooleanLocalEnv(LynxEnvKey.FORCE_DISABLE_QUICKJS_CACHE, this.mForceDisableQuickJsCache);
    }

    private void initVsyncMonitor() {
        if (enableFreshRateOpt()) {
            VSyncMonitor.setCurrentDisplayManager((DisplayManager) this.mContext.getSystemService("display"));
        }
    }
}
