package com.lynx.tasm;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.lynx.devtoolwrapper.LogBoxLogLevel;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.JSModule;
import com.lynx.jsbridge.RuntimeLifecycleListener;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.TimingHandler;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.behavior.KeyboardEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.herotransition.HeroTransitionManager;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.MeaningfulPaintingArea;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.group.ILynxViewGroup;
import com.lynx.tasm.service.security.ILynxSecurityTarget;
import com.lynx.tasm.theme.LynxTheme;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxView extends UIBody.UIBodyView implements ILynxSecurityTarget {
    private static final String TAG = "LynxView";
    private static final String VIEW_TAG = "lynxview";
    private static final Looper sMainLooper = Looper.getMainLooper();
    private boolean isInPrePainting;
    private boolean mCanDispatchTouchEvent;
    private int mCurrentHeightMeasureSpec;
    private int mCurrentWidthMeasureSpec;
    private boolean mDisableDrawChildHook;
    protected boolean mDispatchTouchEventToDev;
    private volatile boolean mHasReportedAccessFromNonUiThread;
    private boolean mIsAccessibilityDisabled;
    private boolean mIsPrePaintingStage;
    private KeyboardEvent mKeyboardEvent;
    protected LynxTemplateRender mLynxTemplateRender;
    private WeakReference<ILynxViewGroup> mLynxViewGroupRef;
    private int mLynxViewId;
    private boolean mOnLoadFired;
    private String mUrl;

    @Deprecated
    public LynxPerfMetric forceGetPerf() {
        return null;
    }

    public Object getTag() {
        return "lynxview";
    }

    public LynxView(Context context) {
        super(context);
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
    }

    public LynxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
    }

    public LynxView(Context context, LynxViewBuilder lynxViewBuilder) {
        super(context);
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
        initWithLynxViewBuilder(lynxViewBuilder);
    }

    public LynxView(Context context, ILynxEngine iLynxEngine) {
        super(context);
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
        this.mLynxTemplateRender = (LynxTemplateRender) iLynxEngine;
        initialize(context, null);
    }

    public int getLynxViewId() {
        return this.mLynxViewId;
    }

    public void initWithLynxViewBuilder(LynxViewBuilder lynxViewBuilder) {
        this.mLynxUIRender = lynxViewBuilder.createLynxUIRenderer();
        if (lynxViewBuilder.lynxBackgroundRuntime != null) {
            initLynxViewWithRuntime(getContext(), lynxViewBuilder);
            return;
        }
        LLog.m2578i(TAG, "new lynxview detail " + this);
        this.mLynxUIRender.onInitBodyView(this, getContext(), lynxViewBuilder.getLynxRuntimeOptions().getLynxGroup());
        initialize(getContext(), lynxViewBuilder);
        if (lynxViewBuilder.lynxViewGroup != null) {
            this.mLynxViewId = lynxViewBuilder.lynxViewGroup.generateNextLynxViewID();
            lynxViewBuilder.lynxViewGroup.addLynxView(this.mLynxViewId, this);
            this.mLynxViewGroupRef = new WeakReference<>(lynxViewBuilder.lynxViewGroup);
        }
    }

    private void initialize(Context context, LynxViewBuilder lynxViewBuilder) {
        setFocusableInTouchMode(true);
        if (!LynxEnv.inst().enableFreshRateOpt()) {
            VSyncMonitor.setCurrentWindowManager((WindowManager) context.getSystemService("window"));
        }
        VSyncMonitor.initUIThreadChoreographer();
        initLynxTemplateRender(context, lynxViewBuilder);
        this.mKeyboardEvent = new KeyboardEvent(getLynxContext());
        this.mDisableDrawChildHook = this.mLynxUIRender.disableBindDrawChildHook();
    }

    private void initLynxViewWithRuntime(Context context, LynxViewBuilder lynxViewBuilder) {
        LynxBackgroundRuntime lynxBackgroundRuntime = lynxViewBuilder.lynxBackgroundRuntime;
        LLog.m2580w(TAG, "init LynxView with runtime, " + lynxBackgroundRuntime);
        if (!lynxBackgroundRuntime.attachToLynxView()) {
            throw new RuntimeException("Build LynxView using an used LynxBackgroundRuntime: " + lynxBackgroundRuntime);
        }
        lynxBackgroundRuntime.getModuleFactory().addModuleParamWrapperIfAbsent(lynxViewBuilder.getLynxRuntimeOptions().getWrappers());
        lynxViewBuilder.getLynxRuntimeOptions().merge(lynxBackgroundRuntime.getLynxRuntimeOptions());
        initialize(context, lynxViewBuilder);
    }

    private void initLynxTemplateRender(Context context, LynxViewBuilder lynxViewBuilder) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.attachLynxView(this);
        } else {
            this.mIsAccessibilityDisabled = this.mLynxUIRender.isAccessibilityDisabled();
            this.mLynxTemplateRender = new LynxTemplateRender(context, this, lynxViewBuilder);
        }
    }

    public LynxContext getLynxContext() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.getLynxContext();
        }
        return null;
    }

    public void reloadAndInit() {
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onReloadAndInitUIThreadPart();
        }
        removeAllViews();
    }

    public boolean isAccessibilityDisabled() {
        return this.mIsAccessibilityDisabled;
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        LynxDevtool devTool;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null || (devTool = lynxTemplateRender.getDevTool()) == null) {
            return null;
        }
        return devTool.getBaseInspectorOwner();
    }

    public void setExtraTiming(TimingHandler.ExtraTimingInfo extraTimingInfo) {
        LynxTemplateRender lynxTemplateRender;
        if (extraTimingInfo == null || (lynxTemplateRender = this.mLynxTemplateRender) == null) {
            return;
        }
        lynxTemplateRender.setExtraTiming(extraTimingInfo);
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption lynxBooleanOption) {
        this.mLynxTemplateRender.setLongTaskMonitorEnabled(lynxBooleanOption);
        LynxContext lynxContext = getLynxContext();
        if (lynxContext != null) {
            lynxContext.setLongTaskMonitorEnabled(lynxBooleanOption);
        }
    }

    public void setFluencyTracerEnabled(LynxBooleanOption lynxBooleanOption) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.setFluencyTracerEnabled(lynxBooleanOption);
        }
    }

    public void putParamsForReportingEvents(Map<String, Object> map) {
        LynxTemplateRender lynxTemplateRender;
        if (map == null || (lynxTemplateRender = this.mLynxTemplateRender) == null) {
            return;
        }
        lynxTemplateRender.putExtraParamsForReportingEvents(map);
    }

    public String getRenderPhase() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.getRenderPhase();
        }
        return null;
    }

    public HashMap<String, Object> getAllTimingInfo() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.getAllTimingInfo();
        }
        return null;
    }

    @Deprecated
    public void setExtraTiming(Map<String, Long> map) {
        if (map == null || this.mLynxTemplateRender == null) {
            return;
        }
        TimingHandler.ExtraTimingInfo extraTimingInfo = new TimingHandler.ExtraTimingInfo();
        if (map.containsKey("open_time")) {
            extraTimingInfo.mOpenTime = map.get("open_time").longValue();
        }
        if (map.containsKey("container_init_start")) {
            extraTimingInfo.mContainerInitStart = map.get("container_init_start").longValue();
        }
        if (map.containsKey("container_init_end")) {
            extraTimingInfo.mContainerInitEnd = map.get("container_init_end").longValue();
        }
        if (map.containsKey("prepare_template_start")) {
            extraTimingInfo.mPrepareTemplateStart = map.get("prepare_template_start").longValue();
        }
        if (map.containsKey("prepare_template_end")) {
            extraTimingInfo.mPrepareTemplateEnd = map.get("prepare_template_end").longValue();
        }
        this.mLynxTemplateRender.setExtraTiming(extraTimingInfo);
    }

    public void bindDrawChildHook(IDrawChildHook iDrawChildHook) {
        if (this.mDisableDrawChildHook) {
            return;
        }
        super.bindDrawChildHook(iDrawChildHook);
    }

    public void onEnterForeground() {
        checkAccessFromNonUiThread("onEnterForeground");
        LLog.m2578i(TAG, "onEnterForeground " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.onEnterForeground();
        }
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onEnterForeground();
        }
    }

    public void onEnterBackground() {
        checkAccessFromNonUiThread("onEnterBackground");
        LLog.m2578i(TAG, "onEnterBackground" + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.onEnterBackground();
        }
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onEnterBackground();
        }
    }

    public void addLynxViewClient(LynxViewClient lynxViewClient) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.addLynxViewClient(lynxViewClient);
    }

    public void addLynxViewClientV2(LynxViewClientV2 lynxViewClientV2) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.addLynxViewClientV2(lynxViewClientV2);
        }
    }

    public void updateScreenMetrics(int i, int i2) {
        checkAccessFromNonUiThread("updateScreenMetrics");
        if (this.mLynxTemplateRender == null) {
            return;
        }
        DisplayMetricsHolder.updateDisplayMetrics(i, i2);
        this.mLynxTemplateRender.updateScreenMetrics(i, i2);
    }

    public void removeLynxViewClient(LynxViewClient lynxViewClient) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.removeLynxViewClient(lynxViewClient);
    }

    public void removeLynxViewClientV2(LynxViewClientV2 lynxViewClientV2) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.removeLynxViewClientV2(lynxViewClientV2);
        }
    }

    public void setImageInterceptor(ImageInterceptor imageInterceptor) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.setImageInterceptor(imageInterceptor);
    }

    public void setAsyncImageInterceptor(ImageInterceptor imageInterceptor) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.setAsyncImageInterceptor(imageInterceptor);
    }

    public void pauseRootLayoutAnimation() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.pauseRootLayoutAnimation();
    }

    public void resumeRootLayoutAnimation() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.resumeRootLayoutAnimation();
    }

    public void renderTemplateUrl(String str, TemplateData templateData) {
        LLog.m2578i(TAG, "renderTemplateUrl " + str + "with templateData in" + toString());
        this.mUrl = str;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplateUrl(str, templateData);
    }

    public void renderTemplateUrl(String str, String str2) {
        LLog.m2578i(TAG, "renderTemplateUrl " + str + "with jsonData in" + toString());
        this.mUrl = str;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplateUrl(str, str2);
    }

    public void renderTemplateUrl(String str, Map<String, Object> map) {
        LLog.m2578i(TAG, "renderTemplateUrl " + str + "with Map in" + toString());
        this.mUrl = str;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplateUrl(str, map);
    }

    public JSModule getJSModule(String str) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.getJSModule(str);
    }

    public void sendGlobalEvent(String str, JavaOnlyArray javaOnlyArray) {
        if (LynxEnv.inst().isHighlightTouchEnabled()) {
            showMessageOnConsole("LynxView: send global event " + str + " for lynx " + hashCode(), LogBoxLogLevel.Info.ordinal());
        }
        LLog.m2578i(TAG, "LynxView sendGlobalEvent " + str + " with this: " + toString());
        if (this.mLynxTemplateRender == null) {
            LLog.m2577e(TAG, "LynxVew sendGlobalEvent failed since mLynxTemplateRender is null with this: " + toString());
        } else if (enableAirStrictMode()) {
            triggerEventBus(str, javaOnlyArray);
        } else {
            this.mLynxTemplateRender.sendGlobalEvent(str, javaOnlyArray);
        }
    }

    public void sendGlobalEventToLepus(String str, List<Object> list) {
        if (LynxEnv.inst().isHighlightTouchEnabled()) {
            showMessageOnConsole("LynxView: send global event " + str + " to lepus for lynx " + hashCode(), LogBoxLogLevel.Info.ordinal());
        }
        checkAccessFromNonUiThread("sendGlobalEventToLepus");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.sendGlobalEventToLepus(str, list);
    }

    public void renderTemplateWithBaseUrl(byte[] bArr, TemplateData templateData, String str) {
        LLog.m2578i(TAG, "renderTemplateWithBaseUrl " + str + "with templateData in " + toString());
        this.mUrl = str;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplateWithBaseUrl(bArr, templateData, str);
    }

    public void renderTemplateWithBaseUrl(byte[] bArr, Map<String, Object> map, String str) {
        LLog.m2578i(TAG, "renderTemplateWithBaseUrl " + str + "with map in " + toString());
        this.mUrl = str;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplateWithBaseUrl(bArr, map, str);
    }

    public void renderTemplateWithBaseUrl(byte[] bArr, String str, String str2) {
        LLog.m2578i(TAG, "renderTemplateWithBaseUrl " + str2 + "with string data in" + toString());
        this.mUrl = str2;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplateWithBaseUrl(bArr, str, str2);
    }

    public void renderTemplate(byte[] bArr, Map<String, Object> map) {
        LLog.m2578i(TAG, "renderTemplate with init data in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplate(bArr, map);
    }

    public void renderTemplate(byte[] bArr, TemplateData templateData) {
        LLog.m2578i(TAG, "renderTemplate with templateData in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplate(bArr, templateData);
    }

    public void renderTemplateBundle(TemplateBundle templateBundle, TemplateData templateData, String str) {
        LLog.m2578i(TAG, "renderTemplateBundle with templateData in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderTemplateBundle(templateBundle, templateData, str);
    }

    public void loadTemplate(LynxLoadMeta lynxLoadMeta) {
        if (lynxLoadMeta == null) {
            return;
        }
        if (lynxLoadMeta.getLoadMode() == LynxLoadMode.PRE_PAINTING || lynxLoadMeta.getLoadMode() == LynxLoadMode.PRE_PAINTING_DRAW) {
            this.mIsPrePaintingStage = true;
        }
        if (isLayoutRequested() && LynxLoadMode.PRE_PAINTING == lynxLoadMeta.getLoadMode()) {
            this.isInPrePainting = true;
            if (getChildCount() > 0) {
                removeAllViewsInLayout();
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            measure(View.MeasureSpec.makeMeasureSpec((layoutParams == null || layoutParams.width < 0) ? 0 : layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec((layoutParams == null || layoutParams.height < 0) ? 0 : layoutParams.height, 1073741824));
            layout(0, 0, (layoutParams == null || layoutParams.width < 0) ? 0 : layoutParams.width, (layoutParams == null || layoutParams.height < 0) ? 0 : layoutParams.height);
            this.isInPrePainting = false;
        }
        LLog.m2578i(TAG, "loadTemplate with LynxLoadMeta in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.loadTemplate(lynxLoadMeta);
    }

    public void renderSSR(byte[] bArr, String str, Map<String, Object> map) {
        LLog.m2576d(TAG, "renderSSR " + str);
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderSSR(bArr, str, map);
    }

    public void renderSSR(byte[] bArr, String str, TemplateData templateData) {
        LLog.m2576d(TAG, "renderSSR " + str);
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderSSR(bArr, str, templateData);
    }

    public void renderSSRUrl(String str, TemplateData templateData) {
        LLog.m2576d(TAG, "renderSSRUrl " + str);
        this.mUrl = str;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderSSRUrl(str, templateData);
    }

    public void renderSSRUrl(String str, Map<String, Object> map) {
        LLog.m2576d(TAG, "renderSSRUrl " + str);
        this.mUrl = str;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.renderSSRUrl(str, map);
    }

    public void ssrHydrate(byte[] bArr, String str, Map<String, Object> map) {
        LLog.m2576d(TAG, "ssrHydrate " + str + (map == null ? "" : " with data in " + map.toString()));
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.ssrHydrateWithBaseUrl(bArr, map, str);
    }

    public void ssrHydrate(byte[] bArr, String str, TemplateData templateData) {
        LLog.m2576d(TAG, "ssrHydrate " + str + (templateData == null ? "" : " with data in " + templateData.toString()));
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.ssrHydrateWithBaseUrl(bArr, templateData, str);
    }

    public void ssrHydrateUrl(String str, Map<String, Object> map) {
        if (map != null) {
            LLog.m2576d(TAG, "ssrHydrateUrl  " + str + " with data in " + map.toString());
        } else {
            LLog.m2576d(TAG, "ssrHydrateUrl  " + str);
        }
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.ssrHydrateUrl(str, map);
    }

    public void ssrHydrateUrl(String str, TemplateData templateData) {
        LLog.m2576d(TAG, "ssrHydrateUrl  " + str + " with data in " + templateData.toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.ssrHydrateUrl(str, templateData);
    }

    public String getTemplateUrl() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.getTemplateUrl();
    }

    public void updateData(String str) {
        updateData(str, (String) null);
    }

    public void updateData(String str, String str2) {
        checkAccessFromNonUiThread("updateData");
        LLog.m2578i(TAG, "updateData with json in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.updateData(str, str2);
        if (this.mIsPrePaintingStage) {
            this.mIsPrePaintingStage = false;
        } else {
            triggerEmbeddedModeLifecycle(DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DATA_CHANGED, true);
        }
    }

    public void updateData(TemplateData templateData) {
        checkAccessFromNonUiThread("updateData");
        LLog.m2578i(TAG, "updateData with data in " + templateData.toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.updateData(templateData, false);
        if (this.mIsPrePaintingStage) {
            this.mIsPrePaintingStage = false;
        } else {
            triggerEmbeddedModeLifecycle(DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DATA_CHANGED, true);
        }
    }

    public void updateMetaData(LynxUpdateMeta lynxUpdateMeta) {
        checkAccessFromNonUiThread("updateMetaData");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null || lynxUpdateMeta == null) {
            return;
        }
        lynxTemplateRender.updateMetaData(lynxUpdateMeta);
        if (this.mIsPrePaintingStage) {
            this.mIsPrePaintingStage = false;
        } else {
            triggerEmbeddedModeLifecycle(DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DATA_CHANGED, true);
        }
    }

    public void resetData(TemplateData templateData) {
        checkAccessFromNonUiThread("resetData");
        LLog.m2578i(TAG, "resetData with json in " + templateData.toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.resetData(templateData);
        if (this.mIsPrePaintingStage) {
            this.mIsPrePaintingStage = false;
        } else {
            triggerEmbeddedModeLifecycle(DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DATA_CHANGED, true);
        }
    }

    public void reloadTemplate(TemplateData templateData) {
        reloadTemplate(templateData, null);
    }

    public void reloadTemplate(TemplateData templateData, TemplateData templateData2) {
        checkAccessFromNonUiThread("reloadTemplate");
        LLog.m2578i(TAG, "reloadTemplate with data: " + String.valueOf(templateData) + ", with globalProps:" + String.valueOf(templateData2));
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.reloadTemplate(templateData, templateData2);
    }

    @Deprecated
    public boolean registerDynamicComponent(String str, TemplateBundle templateBundle) {
        LLog.m2578i(TAG, "register lazy bundle with TemplateBundle: " + str);
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return false;
        }
        return lynxTemplateRender.registerLazyBundle(str, templateBundle);
    }

    public Map<String, Object> getPageDataByKey(String[] strArr) {
        checkAccessFromNonUiThread("getPageDataByKey");
        if (strArr == null || strArr.length == 0) {
            LLog.m2578i(TAG, "getPageDataByKey called with empty keys.");
            return null;
        }
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.getPageDataByKey(strArr);
    }

    public void updateGlobalProps(Map<String, Object> map) {
        updateGlobalProps(TemplateData.fromMap(map));
    }

    public void updateGlobalProps(TemplateData templateData) {
        checkAccessFromNonUiThread("updateGlobalProps");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.updateGlobalProps(templateData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentWidthMeasureSpec() {
        return this.mCurrentWidthMeasureSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentHeightMeasureSpec() {
        return this.mCurrentHeightMeasureSpec;
    }

    private void onTraceEventBegin(String str, Callable<HashMap<String, String>> callable) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put(TraceEventDef.INSTANCE_ID, getLynxContext() != null ? String.valueOf(getLynxContext().getInstanceId()) : "null");
            hashMap.put(TraceEventDef.LYNX_VIEW, toString());
            if (callable != null) {
                try {
                    hashMap.putAll(callable.call());
                } catch (Exception e) {
                    hashMap.put("exception", e.toString());
                }
            }
            TraceEvent.beginSection(str, hashMap);
        }
    }

    private void onTraceEventEnd(String str) {
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putPendingPipelineIdsToMap(Map<String, String> map) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null || lynxTemplateRender.getPerformanceController() == null) {
            return;
        }
        JavaOnlyArray pendingPaintEndPipelineIds = this.mLynxTemplateRender.getPerformanceController().getPendingPaintEndPipelineIds();
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = pendingPaintEndPipelineIds.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(String.valueOf(next));
        }
        map.put(TraceEventDef.PIPELINE_IDS, sb.toString());
    }

    protected void onMeasure(final int i, final int i2) {
        onTraceEventBegin(TraceEventDef.LYNX_VIEW_ON_MEASURE, new Callable<HashMap<String, String>>() { // from class: com.lynx.tasm.LynxView.1
            @Override // java.util.concurrent.Callable
            public HashMap<String, String> call() throws Exception {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(TraceEventDef.WIDTH_MEASURE_SPEC, String.valueOf(i));
                hashMap.put(TraceEventDef.HEIGHT_MEASURE_SPEC, String.valueOf(i2));
                LynxView.this.putPendingPipelineIdsToMap(hashMap);
                return hashMap;
            }
        });
        this.mCurrentWidthMeasureSpec = i;
        this.mCurrentHeightMeasureSpec = i2;
        LLog.m2576d("Lynx", "onMeasure:" + hashCode() + ", width" + View.MeasureSpec.toString(i) + ", height" + View.MeasureSpec.toString(i2));
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null || this.isInPrePainting) {
            super.onMeasure(i, i2);
            onTraceEventEnd(TraceEventDef.LYNX_VIEW_ON_MEASURE);
            return;
        }
        lynxTemplateRender.markHostPlatformTiming("measureStart");
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        if (lynxUIRenderer != null) {
            if (this.mLynxTemplateRender.isEnableReuseEngine()) {
                UIBody lynxUIRoot = getLynxUIRoot();
                if (lynxUIRoot instanceof UIBody) {
                    lynxUIRoot.rebuildViewTree();
                }
            }
            this.mLynxTemplateRender.onMeasure(i, i2);
            if (lynxUIRenderer.shouldInvokeNativeViewMethod()) {
                super.onMeasure(i, i2);
            }
        } else {
            onMeasureWhenDetach(i, i2);
        }
        this.mLynxTemplateRender.markHostPlatformTiming("measureEnd");
        onTraceEventEnd(TraceEventDef.LYNX_VIEW_ON_MEASURE);
    }

    protected void onLayout(final boolean z, final int i, final int i2, final int i3, final int i4) {
        onTraceEventBegin(TraceEventDef.LYNX_VIEW_ON_LAYOUT, new Callable<HashMap<String, String>>() { // from class: com.lynx.tasm.LynxView.2
            @Override // java.util.concurrent.Callable
            public HashMap<String, String> call() throws Exception {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("params", "" + z + " " + i + " " + i2 + " " + i3 + " " + i4);
                LynxView.this.putPendingPipelineIdsToMap(hashMap);
                return hashMap;
            }
        });
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null || this.isInPrePainting) {
            onTraceEventEnd(TraceEventDef.LYNX_VIEW_ON_LAYOUT);
            return;
        }
        lynxTemplateRender.markHostPlatformTiming("layoutStart");
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        if (lynxUIRenderer != null) {
            if (lynxUIRenderer.shouldInvokeNativeViewMethod()) {
                super.onLayout(z, i, i2, i3, i4);
            }
            this.mLynxTemplateRender.onLayout(z, i, i2, i3, i4);
        } else {
            onLayoutWhenDetach();
        }
        if (z && getLynxContext() != null && getLynxContext().useRelativeKeyboardHeightApi() && this.mKeyboardEvent.isStart()) {
            this.mKeyboardEvent.detectKeyboardChangeAndSendEvent();
        }
        this.mLynxTemplateRender.markHostPlatformTiming("layoutEnd");
        onTraceEventEnd(TraceEventDef.LYNX_VIEW_ON_LAYOUT);
    }

    public void updateData(Map<String, Object> map) {
        updateData(map, (String) null);
    }

    public void updateData(Map<String, Object> map, String str) {
        checkAccessFromNonUiThread("updateData");
        LLog.m2578i(TAG, "updateData with map in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.updateData(map, str);
    }

    public void updateViewport(final int i, final int i2, final boolean z) {
        onTraceEventBegin(TraceEventDef.LYNX_VIEW_UPDATE_VIEWPORT, new Callable<HashMap<String, String>>() { // from class: com.lynx.tasm.LynxView.3
            @Override // java.util.concurrent.Callable
            public HashMap<String, String> call() throws Exception {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(TraceEventDef.WIDTH_MEASURE_SPEC, String.valueOf(i));
                hashMap.put(TraceEventDef.HEIGHT_MEASURE_SPEC, String.valueOf(i2));
                hashMap.put(TraceEventDef.NEED_LAYOUT, String.valueOf(z));
                return hashMap;
            }
        });
        this.mCurrentWidthMeasureSpec = i;
        this.mCurrentHeightMeasureSpec = i2;
        checkAccessFromNonUiThread("updateViewport");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.updateViewport(i, i2, z);
        onTraceEventEnd(TraceEventDef.LYNX_VIEW_UPDATE_VIEWPORT);
    }

    public void updateViewport(int i, int i2) {
        checkAccessFromNonUiThread("updateViewport");
        updateViewport(i, i2, true);
    }

    public void updateFontScale(float f) {
        checkAccessFromNonUiThread("updateFontScale");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        LynxFeatureCounter.count(71, (lynxTemplateRender == null || lynxTemplateRender.getLynxContext() == null) ? -1 : this.mLynxTemplateRender.getLynxContext().getInstanceId());
        LynxTemplateRender lynxTemplateRender2 = this.mLynxTemplateRender;
        if (lynxTemplateRender2 == null) {
            return;
        }
        lynxTemplateRender2.updateFontScale(f);
    }

    public void destroy() {
        ILynxViewGroup iLynxViewGroup;
        LLog.m2578i(TAG, "lynxview destroy " + toString());
        triggerEmbeddedModeLifecycle(DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DESTROY, true);
        TraceEvent.beginSection(TraceEventDef.DESTORY_LYNXVIEW);
        WeakReference<ILynxViewGroup> weakReference = this.mLynxViewGroupRef;
        if (weakReference != null && (iLynxViewGroup = weakReference.get()) != null) {
            iLynxViewGroup.removeLynxView(this.mLynxViewId);
        }
        KeyboardEvent keyboardEvent = this.mKeyboardEvent;
        if (keyboardEvent != null && keyboardEvent.isStart()) {
            this.mKeyboardEvent.stop();
        }
        if (this.mLynxTemplateRender != null) {
            HeroTransitionManager.inst().onLynxViewDestroy(this);
            this.mLynxTemplateRender.onDetachedFromWindow();
            this.mLynxTemplateRender.destroy();
            this.mLynxTemplateRender = null;
        }
        if (this.mA11yWrapper != null) {
            this.mA11yWrapper.onDestroy();
        }
        TraceEvent.endSection(TraceEventDef.DESTORY_LYNXVIEW);
    }

    public ThreadStrategyForRendering getThreadStrategyForRendering() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.getThreadStrategyForRendering();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        LynxTemplateRender lynxTemplateRender;
        if (lynxUIRenderer() == null || !lynxUIRenderer().needHandleDispatchKeyEvent()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean dispatchKeyEvent = lynxUIRenderer().dispatchKeyEvent(keyEvent);
        if (dispatchKeyEvent && (lynxTemplateRender = this.mLynxTemplateRender) != null) {
            lynxTemplateRender.onDispatchInputEvent(keyEvent);
        }
        return dispatchKeyEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action;
        boolean z;
        try {
            action = motionEvent.getAction();
            if (action == 0 || action == 1 || action == 3) {
                LLog.m2578i("Lynx", "LynxView dispatchTouchEvent, this: " + hashCode() + ", touch: " + motionEvent.getActionMasked() + " x: " + motionEvent.getX() + " y: " + motionEvent.getY());
            }
        } catch (Throwable th) {
            if (this.mLynxTemplateRender != null) {
                LynxError lynxError = new LynxError(LynxSubErrorCode.E_EVENT_EXCEPTION, "An exception occurred during dispatchTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
                lynxError.setCallStack(CallStackUtil.getStackTraceStringTrimmed(th));
                this.mLynxTemplateRender.onErrorOccurred(lynxError);
            }
        }
        if (this.mLynxTemplateRender == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        ILynxUIRenderer lynxUIRenderer = lynxUIRenderer();
        if (lynxUIRenderer != null && lynxUIRenderer.shouldInvokeNativeViewMethod()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (isChildLynxPageUI()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (action == 0) {
            if (LynxEnv.inst().isHighlightTouchEnabled()) {
                showMessageOnConsole("LynxView: dispatch touch for lynx " + hashCode() + ", touch: " + action + " x: " + motionEvent.getX() + " y: " + motionEvent.getY(), LogBoxLogLevel.Info.ordinal());
            }
            this.mCanDispatchTouchEvent = true;
        }
        if (this.mCanDispatchTouchEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            z = this.mLynxTemplateRender.dispatchTouchEvent(motionEvent);
            motionEvent.setLocation(x, y);
            if (z && this.mLynxTemplateRender.blockNativeEvent(motionEvent) && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else {
            z = false;
        }
        if (action == 1 || action == 3) {
            if (LynxEnv.inst().isHighlightTouchEnabled()) {
                showMessageOnConsole("LynxView: dispatch touch for lynx " + hashCode() + ", touch: " + action + " x: " + motionEvent.getX() + " y: " + motionEvent.getY(), LogBoxLogLevel.Info.ordinal());
            }
            this.mCanDispatchTouchEvent = false;
        }
        if (z) {
            if (this.mDispatchTouchEventToDev) {
                this.mLynxTemplateRender.onDispatchInputEvent(motionEvent);
            }
            if (this.mLynxTemplateRender.consumeSlideEvent(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    private void showMessageOnConsole(String str, int i) {
        LynxBaseInspectorOwner baseInspectorOwner = getBaseInspectorOwner();
        if (baseInspectorOwner == null) {
            return;
        }
        baseInspectorOwner.showMessageOnConsole(str, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            LLog.m2578i("Lynx", "LynxView onInterceptTouchEvent, this: " + hashCode());
            if (isChildLynxPageUI()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
            if (lynxTemplateRender != null && this.mCanDispatchTouchEvent) {
                lynxTemplateRender.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Throwable th) {
            if (this.mLynxTemplateRender == null) {
                return false;
            }
            LynxError lynxError = new LynxError(LynxSubErrorCode.E_EVENT_EXCEPTION, "An exception occurred during onInterceptTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
            lynxError.setCallStack(CallStackUtil.getStackTraceStringTrimmed(th));
            this.mLynxTemplateRender.onErrorOccurred(lynxError);
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            LLog.m2578i("Lynx", "LynxView onTouchEvent, this: " + hashCode());
            if (isChildLynxPageUI()) {
                return super.onTouchEvent(motionEvent);
            }
            LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
            if (lynxTemplateRender == null) {
                return true;
            }
            if (this.mCanDispatchTouchEvent) {
                lynxTemplateRender.onTouchEvent(motionEvent);
            }
            if (this.mLynxTemplateRender.blockNativeEvent(motionEvent) && getParent() != null) {
                return true;
            }
            super.onTouchEvent(motionEvent);
            return true;
        } catch (Throwable th) {
            if (this.mLynxTemplateRender == null) {
                return false;
            }
            LynxError lynxError = new LynxError(LynxSubErrorCode.E_EVENT_EXCEPTION, "An exception occurred during onTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
            lynxError.setCallStack(CallStackUtil.getStackTraceStringTrimmed(th));
            this.mLynxTemplateRender.onErrorOccurred(lynxError);
            return false;
        }
    }

    public TemplateData getTemplateData() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.getTemplateData();
        }
        return null;
    }

    protected void dispatchDraw(Canvas canvas) {
        onTraceEventBegin(TraceEventDef.LYNX_VIEW_ON_DRAW, new Callable<HashMap<String, String>>() { // from class: com.lynx.tasm.LynxView.4
            @Override // java.util.concurrent.Callable
            public HashMap<String, String> call() throws Exception {
                HashMap<String, String> hashMap = new HashMap<>();
                LynxView.this.putPendingPipelineIdsToMap(hashMap);
                return hashMap;
            }
        });
        super.dispatchDraw(canvas);
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.onRootViewDraw(canvas);
        }
        if (!this.mOnLoadFired && !this.mIsPrePaintingStage) {
            this.mOnLoadFired = true;
            triggerEmbeddedModeLifecycle(DefaultLogicExecutor.LIFECYCLE_EVENT_ON_LOAD, true);
        }
        onTraceEventEnd(TraceEventDef.LYNX_VIEW_ON_DRAW);
    }

    private void triggerEmbeddedModeLifecycle(final String str, final boolean z) {
        LynxContext lynxContext;
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null || (lynxContext = lynxTemplateRender.getLynxContext()) == null || !lynxContext.isEmbeddedModeOn()) {
            return;
        }
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.LynxView.5
            @Override // java.lang.Runnable
            public void run() {
                if (LynxView.this.mLynxTemplateRender == null) {
                    return;
                }
                if (TraceEvent.isTracingStarted()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("lifecycle", str);
                    TraceEvent.beginSection(TraceEventDef.TRIGGER_EMBEDDED_MODE_LIFECYCLE, hashMap);
                }
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                javaOnlyMap.put(DefaultLogicExecutor.EVENT_METHOD, str);
                if (z) {
                    javaOnlyMap.put(DefaultLogicExecutor.EVENT_ARGS, LynxView.this.mLynxTemplateRender.getTemplateData());
                }
                LynxView.this.mLynxTemplateRender.onLynxEvent(javaOnlyMap);
                if (TraceEvent.isTracingStarted()) {
                    TraceEvent.endSection(TraceEventDef.TRIGGER_EMBEDDED_MODE_LIFECYCLE);
                }
            }
        });
    }

    protected void onAttachedToWindow() {
        onTraceEventBegin(TraceEventDef.LYNX_VIEW_ON_ATTACH_TO_WINDOW, null);
        super.onAttachedToWindow();
        LLog.m2578i("Lynx", "onAttachedToWindow:" + hashCode());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.onAttachedToWindow();
        }
        onTraceEventEnd(TraceEventDef.LYNX_VIEW_ON_ATTACH_TO_WINDOW);
    }

    protected void onDetachedFromWindow() {
        onTraceEventBegin(TraceEventDef.LYNX_VIEW_ON_DETACHED_FROM_WINDOW, null);
        LLog.m2578i("Lynx", "onDetachedFromWindow:" + hashCode());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
        onTraceEventEnd(TraceEventDef.LYNX_VIEW_ON_DETACHED_FROM_WINDOW);
    }

    public View findViewByName(String str) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.findViewByName(str);
    }

    public LynxBaseUI findUIByName(String str) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.findUIByName(str);
    }

    public View findViewByIdSelector(String str) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.findViewByIdSelector(str);
    }

    public LynxBaseUI findUIByIdSelector(String str) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.findUIByIdSelector(str);
    }

    public UIGroup<UIBody.UIBodyView> getLynxUIRoot() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.getLynxRootUI();
    }

    public void syncFlush() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.syncFlush();
        }
    }

    public LynxBaseUI findUIByIndex(int i) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.findUIByIndex(i);
        }
        return null;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        setFocusableInTouchMode(onClickListener == null);
        super.setOnClickListener(onClickListener);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        LLog.m2578i("Lynx", "setVisibility:" + hashCode() + " " + i);
    }

    public void runOnTasmThread(Runnable runnable) {
        checkAccessFromNonUiThread("runOnTasmThread");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.runOnTasmThread(runnable);
    }

    public void startLynxRuntime() {
        checkAccessFromNonUiThread("startLynxRuntime");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.startLynxRuntime();
    }

    public void setEnableUIFlush(boolean z) {
        checkAccessFromNonUiThread("setEnableUIFlush");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.setEnableUIFlush(z);
    }

    public void processRender() {
        checkAccessFromNonUiThread("processRender");
        if (this.mLynxTemplateRender == null) {
            return;
        }
        LLog.m2578i(TAG, "LynxView call processRender in " + toString());
        this.mLynxTemplateRender.processRender();
    }

    public boolean enableJSRuntime() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.enableJSRuntime();
        }
        return true;
    }

    public void triggerEventBus(String str, List<Object> list) {
        checkAccessFromNonUiThread("triggerEventBus");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.triggerEventBus(str, list);
    }

    public boolean enableAirStrictMode() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.enableAirStrictMode();
        }
        return false;
    }

    public KeyboardEvent getKeyboardEvent() {
        return this.mKeyboardEvent;
    }

    public void setEnableUserBytecode(boolean z, String str) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.setEnableBytecode(z, str);
        }
    }

    private void checkAccessFromNonUiThread(String str) {
        LynxContext lynxContext = getLynxContext();
        if (lynxContext == null || !lynxContext.enableEventReporter() || !LynxEnv.inst().enableCheckAccessFromNonUIThread() || this.mHasReportedAccessFromNonUiThread || sMainLooper == Looper.myLooper() || TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        this.mHasReportedAccessFromNonUiThread = true;
        HashMap hashMap = new HashMap();
        hashMap.put("url", this.mUrl);
        hashMap.put("thread_mode", Integer.valueOf(getThreadStrategyForRendering() != null ? getThreadStrategyForRendering().m2569id() : -1));
        hashMap.put("lynx_sdk_version", LynxEnv.inst().getLynxVersion());
        hashMap.put(DefaultLogicExecutor.EVENT_METHOD, str);
        LynxEventReporter.onEvent("lynxsdk_access_lynxview_from_non_ui_thread", hashMap, -1);
    }

    public void setSessionStorageItem(String str, TemplateData templateData) {
        LynxTemplateRender lynxTemplateRender;
        checkAccessFromNonUiThread("setSessionStorageItem");
        if (templateData == null || (lynxTemplateRender = this.mLynxTemplateRender) == null) {
            return;
        }
        lynxTemplateRender.setSessionStorageItem(str, templateData);
    }

    public void getSessionStorageItem(String str, PlatformCallBack platformCallBack) {
        checkAccessFromNonUiThread("getSessionStorageItem");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.getSessionStorageItem(str, platformCallBack);
        }
    }

    public double subscribeSessionStorage(String str, PlatformCallBack platformCallBack) {
        checkAccessFromNonUiThread("subscribeSessionStorage");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.subscribeSessionStorage(str, platformCallBack);
        }
        return -1.0d;
    }

    public void unsubscribeSessionStorage(String str, double d) {
        checkAccessFromNonUiThread("removeGlobalSharedDataListener");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.unsubscribeSessionStorage(str, d);
        }
    }

    public void attachEngineToUIThread() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.attachEngineToUIThread();
        }
    }

    public void detachEngineFromUIThread() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.detachEngineFromUIThread();
        }
    }

    public ILynxUIRenderer lynxUIRenderer() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.lynxUIRenderer();
        }
        return null;
    }

    public static LynxViewBuilder builder() {
        return new LynxViewBuilder();
    }

    @Deprecated
    public static LynxViewBuilder builder(Context context) {
        return new LynxViewBuilder();
    }

    @Deprecated
    public void setTheme(LynxTheme lynxTheme) {
        LynxContext lynxContext = getLynxContext();
        if (lynxContext != null) {
            LynxFeatureCounter.count(76, lynxContext.getInstanceId());
        }
        checkAccessFromNonUiThread("setTheme");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.setTheme(lynxTheme);
    }

    @Deprecated
    public void setTheme(ByteBuffer byteBuffer) {
        LynxContext lynxContext = getLynxContext();
        if (lynxContext != null) {
            LynxFeatureCounter.count(76, lynxContext.getInstanceId());
        }
        checkAccessFromNonUiThread("setTheme");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null || byteBuffer == null) {
            return;
        }
        lynxTemplateRender.setTheme(byteBuffer);
    }

    @Deprecated
    public LynxTheme getTheme() {
        LynxContext lynxContext = getLynxContext();
        if (lynxContext != null) {
            LynxFeatureCounter.count(77, lynxContext.getInstanceId());
        }
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return null;
        }
        return lynxTemplateRender.getTheme();
    }

    @Deprecated
    public void preloadDynamicComponents(String[] strArr) {
        checkAccessFromNonUiThread("preloadDynamicComponents");
        LLog.m2578i(TAG, "preload lazy bundles: " + TextUtils.join(", ", strArr));
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null || strArr == null || strArr.length == 0) {
            return;
        }
        lynxTemplateRender.preloadLazyBundles(strArr);
    }

    @Deprecated
    public String getPageVersion() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        return lynxTemplateRender == null ? "" : lynxTemplateRender.getPageVersion();
    }

    @Deprecated
    public void getCurrentData(LynxGetDataCallback lynxGetDataCallback) {
        checkAccessFromNonUiThread("getCurrentData");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.getCurrentData(lynxGetDataCallback);
    }

    @Deprecated
    public void setGlobalProps(Map<String, Object> map) {
        checkAccessFromNonUiThread("setGlobalProps");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.updateGlobalProps(TemplateData.fromMap(map));
    }

    @Deprecated
    public void setGlobalProps(TemplateData templateData) {
        checkAccessFromNonUiThread("setGlobalProps");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.updateGlobalProps(templateData);
    }

    @Deprecated
    public long getFirstMeasureTime() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return -1L;
        }
        return lynxTemplateRender.getFirstMeasureTime();
    }

    @Deprecated
    public void processLayout(String str, TemplateData templateData) {
        LLog.m2578i(TAG, "processLayout " + str + "with templateData in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.processLayout(str, templateData);
    }

    @Deprecated
    public void processLayoutWithSSRUrl(String str, TemplateData templateData) {
        LLog.m2578i(TAG, "processLayoutWithSSRUrl in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.processLayoutWithSSRUrl(str, templateData);
    }

    @Deprecated
    public void processLayoutWithTemplateBundle(TemplateBundle templateBundle, TemplateData templateData, String str) {
        LLog.m2578i(TAG, "processLayoutWithTemplateBundle in " + toString());
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.processLayoutWithTemplateBundle(templateBundle, templateData, str);
    }

    @Deprecated
    public void updateFontScacle(float f) {
        checkAccessFromNonUiThread("updateFontScale");
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        LynxFeatureCounter.count(71, (lynxTemplateRender == null || lynxTemplateRender.getLynxContext() == null) ? -1 : this.mLynxTemplateRender.getLynxContext().getInstanceId());
        LynxTemplateRender lynxTemplateRender2 = this.mLynxTemplateRender;
        if (lynxTemplateRender2 == null) {
            return;
        }
        lynxTemplateRender2.updateFontScale(f);
    }

    public LynxConfigInfo getLynxConfigInfo() {
        return new LynxConfigInfo.Builder().buildLynxConfigInfo();
    }

    public List<MeaningfulPaintingArea> getMeaningfulPaintingAreas() {
        if (getLynxContext() == null || !getLynxContext().isEmbeddedModeOn()) {
            return null;
        }
        UIBody lynxUIRoot = getLynxUIRoot();
        if (lynxUIRoot instanceof UIBody) {
            return lynxUIRoot.getMeaningfulPaintingAreas();
        }
        return super.getMeaningfulPaintingAreas();
    }

    public void setEnableUserCodeCache(boolean z, String str) {
        setEnableUserBytecode(z, str);
    }

    public void setAttachLynxPageUICallback(UIBody.UIBodyView.attachLynxPageUICallback attachlynxpageuicallback) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.setAttachLynxPageUICallback(attachlynxpageuicallback);
        }
    }

    public void addRuntimeLifecycleListener(RuntimeLifecycleListener runtimeLifecycleListener) {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.addRuntimeLifecycleListener(runtimeLifecycleListener);
        }
    }

    public LynxViewBuilder getLynxViewBuilder() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.getLynxViewBuilder();
        }
        return null;
    }
}
