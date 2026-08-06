package com.lynx.tasm.group;

import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.IUIRendererCreator;
import com.lynx.tasm.LynxBackgroundRuntimeOptions;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.BuiltInUIRegistry;
import com.lynx.tasm.behavior.LynxUIRendererCreator;
import com.lynx.tasm.behavior.TouchEventDispatcher;
import com.lynx.tasm.group.LynxBaseConfigurator;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxBaseConfigurator<T extends LynxBaseConfigurator<T>> {
    static Float defaultDensity;
    protected BehaviorRegistry behaviorRegistry;
    protected Float densityOverride;
    protected boolean enableAutoExpose;
    protected boolean enableLayoutSafepoint;
    protected boolean enableUnifiedPipeline;
    protected LynxBackgroundRuntimeOptions lynxRuntimeOptions;
    protected HashMap<String, Object> mContextData;
    protected int presetHeightMeasureSpec;
    protected int presetWidthMeasureSpec;
    protected IUIRendererCreator uiRendererCreator;
    protected boolean enableMultiAsyncThread = true;
    protected boolean forceDarkAllowed = false;
    protected boolean enableSyncFlush = false;

    @Deprecated
    protected boolean enableAutoConcurrency = false;
    protected boolean enableVSyncAlignedMessageLoop = false;
    protected boolean enablePendingJsTask = false;
    protected boolean hasPendingJsTaskSet = false;
    protected boolean hasPresetMeasureSpec = false;
    protected boolean enableAsyncHydration = false;
    protected boolean enableJSRuntime = true;
    protected boolean enableAirStrictMode = false;
    protected boolean debuggable = false;
    protected float fontScale = 1.0f;
    protected boolean enablePreUpdateData = false;
    protected ThreadStrategyForRendering threadStrategy = ThreadStrategyForRendering.ALL_ON_UI;
    protected int screenWidth = -1;
    protected int screenHeight = -1;
    protected int embeddedMode = 0;
    protected boolean enableMTSModule = false;
    protected String tapSlop = TouchEventDispatcher.mTapSlopDefault;

    public LynxBaseConfigurator() {
        LynxEnv.inst().lazyInitIfNeeded();
        this.lynxRuntimeOptions = new LynxBackgroundRuntimeOptions();
        this.behaviorRegistry = new BehaviorRegistry((Map<String, Behavior>) LynxEnv.inst().getBehaviorMap());
        this.uiRendererCreator = new LynxUIRendererCreator();
        Float f = defaultDensity;
        if (f != null) {
            this.densityOverride = f;
        }
    }

    public static void setDefaultDensity(Float f) {
        defaultDensity = f;
    }

    public void setCustomBehaviorRegistry(BehaviorRegistry behaviorRegistry) {
        this.behaviorRegistry = behaviorRegistry;
    }

    public T setScreenSize(int i, int i2) {
        this.screenWidth = i;
        this.screenHeight = i2;
        return this;
    }

    @Deprecated
    public T setBehaviors(List<Behavior> list) {
        if (list != null) {
            this.behaviorRegistry.addBehaviors(list);
        }
        return this;
    }

    public T addBehaviors(List<Behavior> list) {
        this.behaviorRegistry.addBehaviors(list);
        return this;
    }

    public T addBehavior(Behavior behavior) {
        this.behaviorRegistry.addBehavior(behavior);
        return this;
    }

    public T enableAutoExpose(boolean z) {
        this.enableAutoExpose = z;
        return this;
    }

    public T setEnableUserBytecode(boolean z) {
        this.lynxRuntimeOptions.setEnableUserBytecode(z);
        return this;
    }

    public T setBytecodeSourceUrl(String str) {
        this.lynxRuntimeOptions.setBytecodeSourceUrl(str);
        return this;
    }

    @Deprecated
    public T setEnableUserCodeCache(boolean z) {
        setEnableUserBytecode(z);
        return this;
    }

    @Deprecated
    public T setCodeCacheSourceUrl(String str) {
        setBytecodeSourceUrl(str);
        return this;
    }

    public T setDensity(float f) {
        this.densityOverride = Float.valueOf(f);
        return this;
    }

    public T setThreadStrategyForRendering(ThreadStrategyForRendering threadStrategyForRendering) {
        if (threadStrategyForRendering != null) {
            this.threadStrategy = threadStrategyForRendering;
        }
        return this;
    }

    public T setLynxGroup(LynxGroup lynxGroup) {
        this.lynxRuntimeOptions.setLynxGroup(lynxGroup);
        return this;
    }

    public void registerModule(String str, Class<? extends LynxModule> cls) {
        registerModule(str, cls, null);
    }

    public void registerModule(String str, Class<? extends LynxModule> cls, Object obj) {
        this.lynxRuntimeOptions.registerModule(str, cls, obj);
    }

    public void registerModuleAuthValidator(LynxModule.AuthValidator authValidator) {
        this.lynxRuntimeOptions.registerModuleAuthValidator(authValidator);
    }

    public T setEnableLayoutSafepoint(boolean z) {
        this.enableLayoutSafepoint = z;
        return this;
    }

    public T setEnableUnifiedPipeline(boolean z) {
        this.enableUnifiedPipeline = z;
        return this;
    }

    public T registerContextData(String str, Object obj) {
        if (this.mContextData == null) {
            this.mContextData = new HashMap<>();
        }
        this.mContextData.put(str, obj);
        return this;
    }

    public void setGenericResourceFetcher(LynxGenericResourceFetcher lynxGenericResourceFetcher) {
        this.lynxRuntimeOptions.setGenericResourceFetcher(lynxGenericResourceFetcher);
    }

    public void setMediaResourceFetcher(LynxMediaResourceFetcher lynxMediaResourceFetcher) {
        this.lynxRuntimeOptions.setMediaResourceFetcher(lynxMediaResourceFetcher);
    }

    public void setTemplateResourceFetcher(LynxTemplateResourceFetcher lynxTemplateResourceFetcher) {
        this.lynxRuntimeOptions.setTemplateResourceFetcher(lynxTemplateResourceFetcher);
    }

    public void setEnableGenericResourceFetcher(LynxBooleanOption lynxBooleanOption) {
        this.lynxRuntimeOptions.setEnableGenericResourceFetcher(lynxBooleanOption);
    }

    public T setForceDarkAllowed(boolean z) {
        this.forceDarkAllowed = z;
        return this;
    }

    public T setEnableMultiAsyncThread(boolean z) {
        this.enableMultiAsyncThread = z;
        return this;
    }

    public T setEnableSyncFlush(boolean z) {
        this.enableSyncFlush = z;
        return this;
    }

    public T setEnablePendingJsTask(boolean z) {
        this.enablePendingJsTask = z;
        this.hasPendingJsTaskSet = true;
        return this;
    }

    @Deprecated
    public T setEnableAutoConcurrency(boolean z) {
        this.enableAutoConcurrency = z;
        return this;
    }

    public T setEnableVSyncAlignedMessageLoop(boolean z) {
        this.enableVSyncAlignedMessageLoop = z;
        return this;
    }

    public T setEnableAsyncHydration(boolean z) {
        this.enableAsyncHydration = z;
        return this;
    }

    public T setEnableJSRuntime(boolean z) {
        this.enableJSRuntime = z;
        return this;
    }

    public T setEnableAirStrictMode(boolean z) {
        this.enableAirStrictMode = z;
        return this;
    }

    public T setDebuggable(boolean z) {
        this.debuggable = z;
        return this;
    }

    @Deprecated
    public T setUIRunningMode(boolean z) {
        if (z) {
            this.threadStrategy = ThreadStrategyForRendering.ALL_ON_UI;
        } else {
            this.threadStrategy = ThreadStrategyForRendering.PART_ON_LAYOUT;
        }
        return this;
    }

    public T setPresetMeasuredSpec(int i, int i2) {
        this.presetHeightMeasureSpec = i2;
        this.presetWidthMeasureSpec = i;
        this.hasPresetMeasureSpec = true;
        return this;
    }

    public T setFontScale(float f) {
        this.fontScale = f;
        return this;
    }

    public T setEnablePreUpdateData(boolean z) {
        this.enablePreUpdateData = z;
        return this;
    }

    public T setUIRendererCreator(IUIRendererCreator iUIRendererCreator) {
        this.uiRendererCreator = iUIRendererCreator;
        return this;
    }

    public T setEmbeddedMode(int i) {
        this.embeddedMode = i;
        if ((i & 1) > 0) {
            this.behaviorRegistry.setBuiltInBehaviors(BuiltInUIRegistry.getInstance().getBuiltInUIBehaviors());
        }
        return this;
    }

    public T setResourceProvider(String str, LynxResourceProvider lynxResourceProvider) {
        this.lynxRuntimeOptions.setResourceProviders(str, lynxResourceProvider);
        return this;
    }

    public T setEnableMTSModule(boolean z) {
        this.enableMTSModule = z;
        return this;
    }

    public T setTapSlop(String str) {
        this.tapSlop = str;
        return this;
    }
}
