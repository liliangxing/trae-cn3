package com.lynx.tasm.group;

import android.content.Context;
import com.lynx.tasm.ILynxLogicExecutor;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxViewGroupBuilder extends LynxBaseConfigurator<LynxViewGroupBuilder> {
    private TemplateData globalProps;
    private ILynxLogicExecutor logicExecutor;
    private Context mContext;
    private TemplateBundle templateBundle;
    private String url;

    public LynxViewGroupBuilder setContext(Context context) {
        this.mContext = context;
        return this;
    }

    public LynxViewGroupBuilder setUrl(String str) {
        this.url = str;
        return this;
    }

    public LynxViewGroupBuilder setTemplateBundle(TemplateBundle templateBundle) {
        this.templateBundle = templateBundle;
        return this;
    }

    public LynxViewGroupBuilder setGlobalProps(TemplateData templateData) {
        this.globalProps = templateData;
        return this;
    }

    public LynxViewGroupBuilder setLogicExecutor(ILynxLogicExecutor iLynxLogicExecutor) {
        this.logicExecutor = iLynxLogicExecutor;
        return this;
    }

    public ILynxViewGroup build() {
        return new LynxViewGroup(this.mContext, this.url, this.templateBundle, this.globalProps, this.behaviorRegistry, this.lynxRuntimeOptions, this.mContextData, this.threadStrategy, this.enableAutoExpose, this.enableLayoutSafepoint, this.enableUnifiedPipeline, this.forceDarkAllowed, this.densityOverride, this.screenWidth, this.screenHeight, this.enableMultiAsyncThread, this.enableSyncFlush, this.enablePendingJsTask, this.enableAsyncHydration, this.enableVSyncAlignedMessageLoop, this.enableJSRuntime, this.enableAirStrictMode, this.debuggable, this.presetWidthMeasureSpec, this.presetHeightMeasureSpec, this.fontScale, this.enablePreUpdateData, this.uiRendererCreator, this.embeddedMode, this.hasPresetMeasureSpec, this.logicExecutor, this.enableMTSModule, this.tapSlop);
    }
}
