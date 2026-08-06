package com.lynx.tasm;

import android.content.Context;
import android.net.Uri;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.component.DynamicComponentFetcher;
import com.lynx.tasm.group.ILynxViewConfigProvider;
import com.lynx.tasm.group.ILynxViewGroup;
import com.lynx.tasm.group.LynxBaseConfigurator;
import com.lynx.tasm.image.model.LynxImageFetcher;
import com.lynx.tasm.loader.LynxFontFaceLoader;
import com.lynx.tasm.provider.AbsTemplateProvider;
import com.lynx.tasm.provider.LynxResourceFetcher;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import com.lynx.tasm.service.LynxServiceCenter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxViewBuilder extends LynxBaseConfigurator<LynxViewBuilder> implements ILynxViewConfigProvider {
    boolean enableLayoutOnly;
    DynamicComponentFetcher fetcher;
    LynxFontFaceLoader.Loader fontLoader;
    LynxImageFetcher imageFetcher;
    LynxBackgroundRuntime lynxBackgroundRuntime;
    Object lynxModuleExtraData;
    Map<String, String> lynxViewConfig;
    ILynxViewGroup lynxViewGroup;
    Map<String, String> mImageCustomParam;
    LynxResourceFetcher resourceFetcher;
    TemplateBundle templateBundle;
    AbsTemplateProvider templateProvider;
    Uri uri;

    @Deprecated
    public boolean isEnableAutoConcurrency() {
        return false;
    }

    @Deprecated
    public LynxViewBuilder setEnableCreateViewAsync(boolean z) {
        return this;
    }

    @Deprecated
    public LynxViewBuilder setEnableLayoutOnly(boolean z) {
        return this;
    }

    @Deprecated
    public LynxViewBuilder setEnableRadonCompatible(boolean z) {
        return this;
    }

    /* renamed from: addBehaviors, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ LynxBaseConfigurator m2918addBehaviors(List list) {
        return addBehaviors((List<Behavior>) list);
    }

    public LynxViewBuilder() {
        this.enableLayoutOnly = LynxEnv.inst().isLayoutOnlyEnabled();
        this.uri = null;
        LynxEnv.inst().lazyInitIfNeeded();
        this.templateProvider = LynxEnv.inst().getTemplateProvider();
    }

    @Deprecated
    public LynxViewBuilder(Context context) {
        this();
    }

    public LynxViewBuilder setTemplateProvider(AbsTemplateProvider absTemplateProvider) {
        this.templateProvider = absTemplateProvider;
        return this;
    }

    public ILynxUIRenderer createLynxUIRenderer() {
        ILynxUIRenderer createLynxUIRender = getUIRendererCreator().createLynxUIRender();
        m2934setThreadStrategyForRendering(createLynxUIRender.getSupportedThreadStrategy(getThreadStrategy()));
        return createLynxUIRender;
    }

    public LynxViewBuilder setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

    public Uri getUri() {
        return this.uri;
    }

    public LynxViewBuilder insertLynxViewConfig(String str, String str2) {
        if (this.lynxViewConfig == null) {
            this.lynxViewConfig = new HashMap();
        }
        if (this.lynxViewConfig.get(str) == null) {
            this.lynxViewConfig.put(str, str2);
        }
        return this;
    }

    public LynxViewBuilder setLynxViewGroup(ILynxViewGroup iLynxViewGroup) {
        this.lynxViewGroup = iLynxViewGroup;
        return this;
    }

    public LynxGroup getLynxGroup() {
        LynxGroup lynxGroup = this.lynxRuntimeOptions.getLynxGroup();
        if (lynxGroup != null) {
            return lynxGroup;
        }
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getLynxGroup();
        }
        return null;
    }

    public LynxViewBuilder setLynxModuleExtraData(Object obj) {
        this.lynxModuleExtraData = obj;
        return this;
    }

    public LynxViewBuilder setResourceFetcher(LynxResourceFetcher lynxResourceFetcher) {
        this.resourceFetcher = lynxResourceFetcher;
        return this;
    }

    public LynxViewBuilder setFontLoader(LynxFontFaceLoader.Loader loader) {
        this.fontLoader = loader;
        return this;
    }

    public LynxViewBuilder setDynamicComponentFetcher(DynamicComponentFetcher dynamicComponentFetcher) {
        this.fetcher = dynamicComponentFetcher;
        return this;
    }

    public LynxViewBuilder setImageFetcher(LynxImageFetcher lynxImageFetcher) {
        this.imageFetcher = lynxImageFetcher;
        return this;
    }

    @Deprecated
    /* renamed from: setUIRunningMode, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2935setUIRunningMode(boolean z) {
        super.setUIRunningMode(z);
        return this;
    }

    public void setCustomBehaviorRegistry(BehaviorRegistry behaviorRegistry) {
        super.setCustomBehaviorRegistry(behaviorRegistry);
    }

    public LynxViewBuilder addBehaviors(List<Behavior> list) {
        return (LynxViewBuilder) super.addBehaviors(list);
    }

    /* renamed from: addBehavior, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2917addBehavior(Behavior behavior) {
        return (LynxViewBuilder) super.addBehavior(behavior);
    }

    /* renamed from: setLynxGroup, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2930setLynxGroup(LynxGroup lynxGroup) {
        return (LynxViewBuilder) super.setLynxGroup(lynxGroup);
    }

    /* renamed from: setEnableLayoutSafepoint, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2923setEnableLayoutSafepoint(boolean z) {
        return (LynxViewBuilder) super.setEnableLayoutSafepoint(z);
    }

    /* renamed from: setThreadStrategyForRendering, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2934setThreadStrategyForRendering(ThreadStrategyForRendering threadStrategyForRendering) {
        return (LynxViewBuilder) super.setThreadStrategyForRendering(threadStrategyForRendering);
    }

    /* renamed from: setPresetMeasuredSpec, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2931setPresetMeasuredSpec(int i, int i2) {
        return (LynxViewBuilder) super.setPresetMeasuredSpec(i, i2);
    }

    /* renamed from: setResourceProvider, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2932setResourceProvider(String str, LynxResourceProvider lynxResourceProvider) {
        return (LynxViewBuilder) super.setResourceProvider(str, lynxResourceProvider);
    }

    public void registerModule(String str, Class<? extends LynxModule> cls) {
        super.registerModule(str, cls);
    }

    public void registerModule(String str, Class<? extends LynxModule> cls, Object obj) {
        super.registerModule(str, cls, obj);
    }

    public void registerModuleAuthValidator(LynxModule.AuthValidator authValidator) {
        super.registerModuleAuthValidator(authValidator);
    }

    /* renamed from: setEnableUserCodeCache, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2927setEnableUserCodeCache(boolean z) {
        return (LynxViewBuilder) super.setEnableUserCodeCache(z);
    }

    /* renamed from: setCodeCacheSourceUrl, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2920setCodeCacheSourceUrl(String str) {
        return (LynxViewBuilder) super.setCodeCacheSourceUrl(str);
    }

    public void setGenericResourceFetcher(LynxGenericResourceFetcher lynxGenericResourceFetcher) {
        super.setGenericResourceFetcher(lynxGenericResourceFetcher);
    }

    public void setMediaResourceFetcher(LynxMediaResourceFetcher lynxMediaResourceFetcher) {
        super.setMediaResourceFetcher(lynxMediaResourceFetcher);
    }

    public void setTemplateResourceFetcher(LynxTemplateResourceFetcher lynxTemplateResourceFetcher) {
        super.setTemplateResourceFetcher(lynxTemplateResourceFetcher);
    }

    public void setEnableGenericResourceFetcher(LynxBooleanOption lynxBooleanOption) {
        super.setEnableGenericResourceFetcher(lynxBooleanOption);
    }

    /* renamed from: setFontScale, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2929setFontScale(float f) {
        return (LynxViewBuilder) super.setFontScale(f);
    }

    /* renamed from: setScreenSize, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2933setScreenSize(int i, int i2) {
        return (LynxViewBuilder) super.setScreenSize(i, i2);
    }

    /* renamed from: setEnablePendingJsTask, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2925setEnablePendingJsTask(boolean z) {
        return (LynxViewBuilder) super.setEnablePendingJsTask(z);
    }

    /* renamed from: setEnableJSRuntime, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2922setEnableJSRuntime(boolean z) {
        return (LynxViewBuilder) super.setEnableJSRuntime(z);
    }

    /* renamed from: enableAutoExpose, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2919enableAutoExpose(boolean z) {
        return (LynxViewBuilder) super.enableAutoExpose(z);
    }

    /* renamed from: setEnableVSyncAlignedMessageLoop, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2928setEnableVSyncAlignedMessageLoop(boolean z) {
        return (LynxViewBuilder) super.setEnableVSyncAlignedMessageLoop(z);
    }

    /* renamed from: setEnableAirStrictMode, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2921setEnableAirStrictMode(boolean z) {
        return (LynxViewBuilder) super.setEnableAirStrictMode(z);
    }

    /* renamed from: setEnableMultiAsyncThread, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2924setEnableMultiAsyncThread(boolean z) {
        return (LynxViewBuilder) super.setEnableMultiAsyncThread(z);
    }

    /* renamed from: setEnableSyncFlush, reason: merged with bridge method [inline-methods] */
    public LynxViewBuilder m2926setEnableSyncFlush(boolean z) {
        return (LynxViewBuilder) super.setEnableSyncFlush(z);
    }

    public LynxViewBuilder setImageCustomParam(Map<String, String> map) {
        this.mImageCustomParam = map;
        return this;
    }

    public LynxViewBuilder setLynxViewConfig(Map<String, String> map) {
        this.lynxViewConfig = map;
        return this;
    }

    public Map<String, String> getLynxViewConfig() {
        return this.lynxViewConfig;
    }

    public LynxViewBuilder setLynxBackgroundRuntime(LynxBackgroundRuntime lynxBackgroundRuntime) {
        this.lynxBackgroundRuntime = lynxBackgroundRuntime;
        return this;
    }

    public LynxViewBuilder setTemplateBundle(TemplateBundle templateBundle) {
        this.templateBundle = templateBundle;
        return this;
    }

    public BehaviorRegistry getBehaviorRegistry() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getBehaviorRegistry();
        }
        return this.behaviorRegistry;
    }

    public boolean isEnableAutoExpose() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableAutoExpose();
        }
        return this.enableAutoExpose;
    }

    public Float getDensity() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getDensity();
        }
        return this.densityOverride;
    }

    public ThreadStrategyForRendering getThreadStrategy() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getThreadStrategy();
        }
        return this.threadStrategy;
    }

    public boolean isEnableLayoutSafepoint() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableLayoutSafepoint();
        }
        return this.enableLayoutSafepoint;
    }

    public boolean isEnableUnifiedPipeline() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableUnifiedPipeline();
        }
        return this.enableUnifiedPipeline;
    }

    public HashMap getContextData() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getContextData();
        }
        return this.mContextData;
    }

    public LynxBackgroundRuntimeOptions getLynxRuntimeOptions() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getLynxRuntimeOptions();
        }
        return this.lynxRuntimeOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxViewBuilder mergeLynxRuntimeOptions(LynxBackgroundRuntimeOptions lynxBackgroundRuntimeOptions) {
        LynxBackgroundRuntimeOptions lynxRuntimeOptions = getLynxRuntimeOptions();
        if (lynxRuntimeOptions != null) {
            lynxRuntimeOptions.merge(lynxBackgroundRuntimeOptions);
        }
        return this;
    }

    public int getScreenWidth() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getScreenWidth();
        }
        return this.screenWidth;
    }

    public int getScreenHeight() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getScreenHeight();
        }
        return this.screenHeight;
    }

    public boolean getForceDarkAllowed() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getForceDarkAllowed();
        }
        return this.forceDarkAllowed;
    }

    public boolean isEnableMultiAsyncThread() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableMultiAsyncThread();
        }
        return this.enableMultiAsyncThread;
    }

    public boolean isEnableSyncFlush() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableSyncFlush();
        }
        return this.enableSyncFlush;
    }

    public boolean isEnableVSyncAlignedMessageLoop() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableVSyncAlignedMessageLoop();
        }
        return this.enableVSyncAlignedMessageLoop;
    }

    public boolean isEnablePendingJsTask() {
        if (this.hasPendingJsTaskSet) {
            return this.enablePendingJsTask;
        }
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnablePendingJsTask();
        }
        return false;
    }

    public boolean isEnableAsyncHydration() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableAsyncHydration();
        }
        return this.enableAsyncHydration;
    }

    public boolean isEnableJSRuntime() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableJSRuntime();
        }
        if (this.enableAirStrictMode) {
            return false;
        }
        return this.enableJSRuntime;
    }

    public boolean isEnableAirStrictMode() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableAirStrictMode();
        }
        return this.enableAirStrictMode;
    }

    public boolean isDebuggable() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isDebuggable();
        }
        return this.debuggable;
    }

    public boolean hasPresetMeasureSpec() {
        return this.hasPresetMeasureSpec;
    }

    public int getPresetWidthMeasureSpec() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getPresetWidthMeasureSpec();
        }
        return this.presetWidthMeasureSpec;
    }

    public int getPresetHeightMeasureSpec() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getPresetHeightMeasureSpec();
        }
        return this.presetHeightMeasureSpec;
    }

    public float getFontScale() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getFontScale();
        }
        return this.fontScale;
    }

    public boolean isEnablePreUpdateData() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnablePreUpdateData();
        }
        return this.enablePreUpdateData;
    }

    public IUIRendererCreator getUIRendererCreator() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getUIRendererCreator();
        }
        return this.uiRendererCreator;
    }

    public int getEmbeddedMode() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getEmbeddedMode();
        }
        return this.embeddedMode;
    }

    public boolean isEnableMTSModule() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableMTSModule();
        }
        return this.enableMTSModule;
    }

    public LynxBooleanOption isEnableGenericResourceFetcher() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.isEnableGenericResourceFetcher();
        }
        return this.lynxRuntimeOptions.isEnableGenericResourceFetcher();
    }

    public LynxGenericResourceFetcher getLynxGenericResourceFetcher() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getLynxGenericResourceFetcher();
        }
        return this.lynxRuntimeOptions.getGenericResourceFetcher();
    }

    public LynxMediaResourceFetcher getLynxMediaResourceFetcher() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getLynxMediaResourceFetcher();
        }
        return this.lynxRuntimeOptions.getMediaResourceFetcher();
    }

    public LynxTemplateResourceFetcher getLynxTemplateResourceFetcher() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getLynxTemplateResourceFetcher();
        }
        return this.lynxRuntimeOptions.getTemplateResourceFetcher();
    }

    public ILynxLogicExecutor getLogicExecutor() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getLogicExecutor();
        }
        return null;
    }

    public String getTapSlop() {
        ILynxViewGroup iLynxViewGroup = this.lynxViewGroup;
        if (iLynxViewGroup != null) {
            return iLynxViewGroup.getTapSlop();
        }
        return this.tapSlop;
    }

    public LynxView build(Context context) {
        TraceEvent.beginSection(TraceEventDef.LYNXVIEW_BUILDER_BUILD);
        ILynxTrailServiceExtension iLynxTrailServiceExtension = (ILynxTrailService) LynxServiceCenter.inst().getService(ILynxTrailService.class);
        if (iLynxTrailServiceExtension instanceof ILynxTrailServiceExtension) {
            iLynxTrailServiceExtension.parseLynxViewBuilder(this);
        }
        LynxView lynxView = new LynxView(context, this);
        if (TraceEvent.enableTrace()) {
            HashMap hashMap = new HashMap();
            if (lynxView.getLynxContext() != null) {
                hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(lynxView.getLynxContext().getInstanceId()));
            }
            TraceEvent.endSection(0L, TraceEventDef.LYNXVIEW_BUILDER_BUILD, hashMap);
        }
        return lynxView;
    }
}
