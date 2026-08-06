package com.lynx.tasm.group;

import android.content.Context;
import com.lynx.jsbridge.LynxEmbeddedModule;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.DefaultLogicExecutor;
import com.lynx.tasm.ILynxEngine;
import com.lynx.tasm.ILynxLogicExecutor;
import com.lynx.tasm.IUIRendererCreator;
import com.lynx.tasm.LynxBackgroundRuntimeOptions;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.TouchEventDispatcher;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import com.lynx.tasm.resourceprovider.template.TemplateProviderResult;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxViewGroup implements ILynxViewGroup, ILynxViewRuntimeCacheManager {
    static final String TAG = "LynxViewGroup";
    private BehaviorRegistry behaviorRegistry;
    private HashMap contextData;
    private boolean debuggable;
    private Float density;
    private int embeddedMode;
    private boolean enableAirStrictMode;
    private boolean enableAsyncHydration;
    private boolean enableAutoExpose;
    private boolean enableJSRuntime;
    private boolean enableLayoutSafepoint;
    private boolean enableMTSModule;
    private boolean enableMultiAsyncThread;
    private boolean enablePendingJsTask;
    private boolean enablePreUpdateData;
    private boolean enableSyncFlush;
    private boolean enableUnifiedPipeline;
    private boolean enableVSyncAlignedMessageLoop;
    private float fontScale;
    private boolean forceDarkAllowed;
    private TemplateData globalProps;
    private boolean hasPresetMeasureSpec;
    private ILynxLogicExecutor logicExecutor;
    private LynxBackgroundRuntimeOptions lynxRuntimeOptions;
    private Context mContext;
    private int presetHeightMeasureSpec;
    private int presetWidthMeasureSpec;
    private int screenHeight;
    private int screenWidth;
    private String tapSlop;
    private volatile TemplateBundle templateBundle;
    private Future<Void> templateResultFutureTask;
    private ThreadStrategyForRendering threadStrategy;
    private IUIRendererCreator uiRendererCreator;
    private final String url;
    private final AtomicInteger mViewIdGenerator = new AtomicInteger(0);
    private final ConcurrentHashMap<Integer, WeakReference<LynxView>> mLynxViewMap = new ConcurrentHashMap<>();
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private final List<LynxResourceCallback<TemplateBundle>> mFetchCallbacks = Collections.synchronizedList(new LinkedList());
    private volatile LynxResourceResponse<TemplateBundle> mFetchResult = null;
    private Map<String, BitmapSize> bitmapSizePool = new ConcurrentHashMap();

    @Override // com.lynx.tasm.group.ILynxViewRuntimeCacheManager
    public ILynxEngine getLynxEngine() {
        return null;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableAutoConcurrency() {
        return false;
    }

    @Override // com.lynx.tasm.group.ILynxViewRuntimeCacheManager
    public void setLynxEngine(ILynxEngine iLynxEngine) {
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean hasPresetMeasureSpec() {
        return this.hasPresetMeasureSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxViewGroup(Context context, String str, TemplateBundle templateBundle, TemplateData templateData, BehaviorRegistry behaviorRegistry, LynxBackgroundRuntimeOptions lynxBackgroundRuntimeOptions, HashMap hashMap, ThreadStrategyForRendering threadStrategyForRendering, boolean z, boolean z2, boolean z3, boolean z4, Float f, int i, int i2, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i3, int i4, float f2, boolean z13, IUIRendererCreator iUIRendererCreator, int i5, boolean z14, ILynxLogicExecutor iLynxLogicExecutor, boolean z15, String str2) {
        this.threadStrategy = ThreadStrategyForRendering.ALL_ON_UI;
        this.embeddedMode = 0;
        this.hasPresetMeasureSpec = false;
        this.tapSlop = TouchEventDispatcher.mTapSlopDefault;
        this.mContext = context;
        this.url = str;
        this.templateBundle = templateBundle;
        this.globalProps = templateData;
        this.behaviorRegistry = behaviorRegistry;
        this.lynxRuntimeOptions = lynxBackgroundRuntimeOptions;
        this.contextData = hashMap;
        this.threadStrategy = threadStrategyForRendering;
        this.enableAutoExpose = z;
        this.enableLayoutSafepoint = z2;
        this.enableUnifiedPipeline = z3;
        this.forceDarkAllowed = z4;
        this.density = f;
        this.screenWidth = i;
        this.screenHeight = i2;
        this.enableMultiAsyncThread = z5;
        this.enableSyncFlush = z6;
        this.enablePendingJsTask = z7;
        this.enableAsyncHydration = z8;
        this.enableVSyncAlignedMessageLoop = z9;
        this.enableJSRuntime = z10;
        this.enableAirStrictMode = z11;
        this.debuggable = z12;
        this.presetWidthMeasureSpec = i3;
        this.presetHeightMeasureSpec = i4;
        this.fontScale = f2;
        this.enablePreUpdateData = z13;
        this.uiRendererCreator = iUIRendererCreator;
        this.embeddedMode = i5;
        this.hasPresetMeasureSpec = z14;
        this.logicExecutor = iLynxLogicExecutor;
        this.enableMTSModule = z15;
        this.tapSlop = str2;
        init();
    }

    private void init() {
        LynxBackgroundRuntimeOptions lynxBackgroundRuntimeOptions = this.lynxRuntimeOptions;
        if (lynxBackgroundRuntimeOptions != null) {
            lynxBackgroundRuntimeOptions.setGlobalProps(this.globalProps);
        }
        if (this.templateBundle == null) {
            fetchTemplateInternal();
        }
        DefaultLogicExecutor defaultLogicExecutor = this.logicExecutor;
        if (defaultLogicExecutor instanceof DefaultLogicExecutor) {
            defaultLogicExecutor.init(this);
        } else if (defaultLogicExecutor == null) {
            registerModule("LynxEmbeddedModule", LynxEmbeddedModule.class, this);
        }
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public BehaviorRegistry getBehaviorRegistry() {
        return this.behaviorRegistry;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableAutoExpose() {
        return this.enableAutoExpose;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public Float getDensity() {
        return this.density;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public ThreadStrategyForRendering getThreadStrategy() {
        return this.threadStrategy;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableLayoutSafepoint() {
        return this.enableLayoutSafepoint;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableUnifiedPipeline() {
        return this.enableUnifiedPipeline;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public HashMap getContextData() {
        return this.contextData;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public LynxBackgroundRuntimeOptions getLynxRuntimeOptions() {
        return this.lynxRuntimeOptions;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public LynxGroup getLynxGroup() {
        return this.lynxRuntimeOptions.getLynxGroup();
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public int getScreenWidth() {
        return this.screenWidth;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public int getScreenHeight() {
        return this.screenHeight;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean getForceDarkAllowed() {
        return this.forceDarkAllowed;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableMultiAsyncThread() {
        return this.enableMultiAsyncThread;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableSyncFlush() {
        return this.enableSyncFlush;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableVSyncAlignedMessageLoop() {
        return this.enableVSyncAlignedMessageLoop;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnablePendingJsTask() {
        return this.enablePendingJsTask;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableAsyncHydration() {
        return this.enableAsyncHydration;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableJSRuntime() {
        if (this.enableAirStrictMode) {
            return false;
        }
        return this.enableJSRuntime;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableAirStrictMode() {
        return this.enableAirStrictMode;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isDebuggable() {
        return this.debuggable;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public int getPresetWidthMeasureSpec() {
        return this.presetWidthMeasureSpec;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public int getPresetHeightMeasureSpec() {
        return this.presetHeightMeasureSpec;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public float getFontScale() {
        return this.fontScale;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnablePreUpdateData() {
        return this.enablePreUpdateData;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public IUIRendererCreator getUIRendererCreator() {
        return this.uiRendererCreator;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public int getEmbeddedMode() {
        return this.embeddedMode;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public boolean isEnableMTSModule() {
        return this.enableMTSModule;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public LynxBooleanOption isEnableGenericResourceFetcher() {
        return this.lynxRuntimeOptions.isEnableGenericResourceFetcher();
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public LynxGenericResourceFetcher getLynxGenericResourceFetcher() {
        return this.lynxRuntimeOptions.getGenericResourceFetcher();
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public LynxMediaResourceFetcher getLynxMediaResourceFetcher() {
        return this.lynxRuntimeOptions.getMediaResourceFetcher();
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public LynxTemplateResourceFetcher getLynxTemplateResourceFetcher() {
        return this.lynxRuntimeOptions.getTemplateResourceFetcher();
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public String getUrl() {
        return this.url;
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public TemplateData getGlobalProps() {
        return this.globalProps;
    }

    @Override // com.lynx.tasm.group.ILynxViewRuntimeCacheManager
    public void setTemplateBundle(TemplateBundle templateBundle) {
        this.templateBundle = templateBundle;
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup, com.lynx.tasm.group.ILynxViewRuntimeCacheManager
    public TemplateBundle getTemplateBundle() {
        if (this.templateBundle == null) {
            try {
                if (this.countDownLatch.await(3L, TimeUnit.SECONDS)) {
                    return this.templateBundle;
                }
            } catch (Exception unused) {
                LLog.i(TAG, "getTemplateBundle failed.");
            }
        }
        return this.templateBundle;
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public TemplateBundle getTemplateBundleNonBlocking() {
        return this.templateBundle;
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public boolean isTemplateBundleReady() {
        return this.templateBundle != null;
    }

    @Override // com.lynx.tasm.group.ILynxViewRuntimeCacheManager
    public void setBitmapSizeCache(String str, int i, int i2) {
        String str2;
        if (TraceEvent.isTracingStarted()) {
            str2 = "setBitmapSizeCache: " + str + ": " + i + " - " + i2;
            TraceEvent.beginSection(str2);
        } else {
            str2 = null;
        }
        if (str == null) {
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str2);
            }
        } else {
            this.bitmapSizePool.put(str, new BitmapSize(str, i, i2));
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str2);
            }
        }
    }

    @Override // com.lynx.tasm.group.ILynxViewRuntimeCacheManager
    public BitmapSize getBitmapSizeCache(String str) {
        String str2;
        if (TraceEvent.isTracingStarted()) {
            str2 = "getBitmapSizeCache: " + str;
            TraceEvent.beginSection(str2);
        } else {
            str2 = null;
        }
        BitmapSize bitmapSize = this.bitmapSizePool.get(str);
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str2);
        }
        return bitmapSize;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public ILynxLogicExecutor getLogicExecutor() {
        return this.logicExecutor;
    }

    @Override // com.lynx.tasm.group.ILynxViewConfigProvider
    public String getTapSlop() {
        return this.tapSlop;
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public int generateNextLynxViewID() {
        return this.mViewIdGenerator.getAndIncrement();
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public void addLynxView(int i, LynxView lynxView) {
        if (lynxView != null) {
            this.mLynxViewMap.put(Integer.valueOf(i), new WeakReference<>(lynxView));
        }
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public void removeLynxView(int i) {
        this.mLynxViewMap.remove(Integer.valueOf(i));
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public LynxView getLynxViewById(int i) {
        WeakReference<LynxView> weakReference = this.mLynxViewMap.get(Integer.valueOf(i));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public void registerModule(String str, Class<? extends LynxModule> cls, Object obj) {
        this.lynxRuntimeOptions.registerModule(str, cls, obj);
    }

    private void setFetchResult(LynxResourceResponse<TemplateBundle> lynxResourceResponse) {
        synchronized (this.mFetchCallbacks) {
            if (this.mFetchResult != null) {
                LLog.e(TAG, "internal error: fetch result should be set once");
                return;
            }
            this.mFetchResult = lynxResourceResponse;
            if (lynxResourceResponse.getState() == LynxResourceResponse.ResponseState.SUCCESS) {
                this.templateBundle = lynxResourceResponse.getData();
            }
            if (this.countDownLatch.getCount() > 0) {
                this.countDownLatch.countDown();
            }
            Iterator<LynxResourceCallback<TemplateBundle>> it = this.mFetchCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onResponse(lynxResourceResponse);
            }
            this.mFetchCallbacks.clear();
            DefaultLogicExecutor defaultLogicExecutor = this.logicExecutor;
            if (defaultLogicExecutor instanceof DefaultLogicExecutor) {
                defaultLogicExecutor.init(this);
            }
        }
    }

    private void fetchTemplateInternal() {
        Runnable runnable = new Runnable() { // from class: com.lynx.tasm.group.LynxViewGroup$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LynxViewGroup.this.m4134lambda$fetchTemplateInternal$1$comlynxtasmgroupLynxViewGroup();
            }
        };
        if (this.lynxRuntimeOptions != null) {
            LynxThreadPool.getAsyncServiceExecutor().execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$fetchTemplateInternal$1$com-lynx-tasm-group-LynxViewGroup, reason: not valid java name */
    public /* synthetic */ void m4134lambda$fetchTemplateInternal$1$comlynxtasmgroupLynxViewGroup() {
        this.lynxRuntimeOptions.getTemplateResourceFetcher().fetchTemplate(new LynxResourceRequest(this.url, LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate), new LynxResourceCallback() { // from class: com.lynx.tasm.group.LynxViewGroup$$ExternalSyntheticLambda1
            @Override // com.lynx.tasm.resourceprovider.LynxResourceCallback
            public final void onResponse(LynxResourceResponse lynxResourceResponse) {
                LynxViewGroup.this.m4135lambda$null$0$comlynxtasmgroupLynxViewGroup(lynxResourceResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* renamed from: lambda$null$0$com-lynx-tasm-group-LynxViewGroup, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void m4135lambda$null$0$comlynxtasmgroupLynxViewGroup(LynxResourceResponse lynxResourceResponse) {
        TemplateBundle templateBundle;
        if (lynxResourceResponse.getState() == LynxResourceResponse.ResponseState.FAILED) {
            setFetchResult(LynxResourceResponse.onFailed(lynxResourceResponse.getError()));
            return;
        }
        TemplateProviderResult templateProviderResult = (TemplateProviderResult) lynxResourceResponse.getData();
        if (templateProviderResult != null) {
            if (templateProviderResult.getTemplateBundle() != null) {
                templateBundle = templateProviderResult.getTemplateBundle();
            } else if (templateProviderResult.getTemplateBinary() != null) {
                templateBundle = TemplateBundle.fromTemplate(templateProviderResult.getTemplateBinary());
            }
            if (templateBundle != null) {
                setFetchResult(LynxResourceResponse.onFailed(new RuntimeException("Template bundle is null")));
                return;
            } else {
                setFetchResult(LynxResourceResponse.onSuccess(templateBundle));
                return;
            }
        }
        templateBundle = null;
        if (templateBundle != null) {
        }
    }

    @Override // com.lynx.tasm.group.ILynxViewGroup
    public void fetchTemplateBundle(LynxResourceCallback<TemplateBundle> lynxResourceCallback) {
        if (this.mFetchResult != null) {
            lynxResourceCallback.onResponse(this.mFetchResult);
            return;
        }
        synchronized (this.mFetchCallbacks) {
            if (this.mFetchResult != null) {
                lynxResourceCallback.onResponse(this.mFetchResult);
            } else {
                this.mFetchCallbacks.add(lynxResourceCallback);
            }
        }
    }

    public void release() {
        if (this.templateBundle != null) {
            this.templateBundle.release();
        }
        ILynxLogicExecutor iLynxLogicExecutor = this.logicExecutor;
        if (iLynxLogicExecutor != null) {
            iLynxLogicExecutor.destroy();
        }
        setFetchResult(LynxResourceResponse.onFailed(new RuntimeException("This LynxViewGroup released")));
    }
}
