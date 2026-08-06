package com.lynx.tasm.group;

import com.lynx.tasm.ILynxLogicExecutor;
import com.lynx.tasm.IUIRendererCreator;
import com.lynx.tasm.LynxBackgroundRuntimeOptions;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ILynxViewConfigProvider {
    BehaviorRegistry getBehaviorRegistry();

    HashMap getContextData();

    Float getDensity();

    int getEmbeddedMode();

    float getFontScale();

    boolean getForceDarkAllowed();

    ILynxLogicExecutor getLogicExecutor();

    LynxGenericResourceFetcher getLynxGenericResourceFetcher();

    LynxGroup getLynxGroup();

    LynxMediaResourceFetcher getLynxMediaResourceFetcher();

    LynxBackgroundRuntimeOptions getLynxRuntimeOptions();

    LynxTemplateResourceFetcher getLynxTemplateResourceFetcher();

    int getPresetHeightMeasureSpec();

    int getPresetWidthMeasureSpec();

    int getScreenHeight();

    int getScreenWidth();

    String getTapSlop();

    ThreadStrategyForRendering getThreadStrategy();

    IUIRendererCreator getUIRendererCreator();

    boolean hasPresetMeasureSpec();

    boolean isDebuggable();

    boolean isEnableAirStrictMode();

    boolean isEnableAsyncHydration();

    @Deprecated
    boolean isEnableAutoConcurrency();

    boolean isEnableAutoExpose();

    LynxBooleanOption isEnableGenericResourceFetcher();

    boolean isEnableJSRuntime();

    boolean isEnableLayoutSafepoint();

    boolean isEnableMTSModule();

    boolean isEnableMultiAsyncThread();

    boolean isEnablePendingJsTask();

    boolean isEnablePreUpdateData();

    boolean isEnableSyncFlush();

    boolean isEnableUnifiedPipeline();

    boolean isEnableVSyncAlignedMessageLoop();
}
