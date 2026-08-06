package com.lynx.tasm;

import android.os.SystemClock;
import android.util.Log;
import com.larus.business.markdown.api.depend.ICustomDataHandlerKt;
import com.lynx.devtoolwrapper.ILynxLogBox;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.Arguments;
import com.lynx.jsbridge.CallbackImpl;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxMethodWrapper;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.jsbridge.ParamWrapper;
import com.lynx.jsbridge.Promise;
import com.lynx.jsbridge.PromiseImpl;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.DynamicFromArray;
import com.lynx.react.bridge.DynamicFromMap;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.NativeArrayInterface;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.SafeRunnable;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.react.bridge.mapbuffer.CompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.DynamicFromMapBuffer;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableBaseBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBufferWrapper;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.animation.AnimationInfo;
import com.lynx.tasm.animation.InterpolatorFactory;
import com.lynx.tasm.animation.keyframe.KeyframeManager;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;
import com.lynx.tasm.animation.layout.AbstractLayoutAnimation;
import com.lynx.tasm.animation.layout.BaseLayoutAnimation;
import com.lynx.tasm.animation.layout.LayoutAnimationManager;
import com.lynx.tasm.animation.layout.LayoutCreateAnimation;
import com.lynx.tasm.animation.layout.LayoutDeleteAnimation;
import com.lynx.tasm.animation.layout.LayoutUpdateAnimation;
import com.lynx.tasm.animation.layout.PositionAndSizeAnimation;
import com.lynx.tasm.animation.transition.TransitionAnimationManager;
import com.lynx.tasm.base.Assertions;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.JNINamespace;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxPageLoadListener;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.BehaviorBundle;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.BuiltInBehavior;
import com.lynx.tasm.behavior.ExceptionHandler;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.behavior.LayoutContext;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.LynxPropsHolder;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.PaintingContext;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.ShadowNodeOwner;
import com.lynx.tasm.behavior.ShadowNodeRegistry;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.TouchEventDispatcher;
import com.lynx.tasm.behavior.XElementBehavior;
import com.lynx.tasm.behavior.shadow.AlignContext;
import com.lynx.tasm.behavior.shadow.AlignParam;
import com.lynx.tasm.behavior.shadow.ChoreographerLayoutTick;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode;
import com.lynx.tasm.behavior.shadow.CustomMeasureFunc;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.LayoutTick;
import com.lynx.tasm.behavior.shadow.MeasureContext;
import com.lynx.tasm.behavior.shadow.MeasureFunc;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.MeasureOutput;
import com.lynx.tasm.behavior.shadow.MeasureParam;
import com.lynx.tasm.behavior.shadow.MeasureResult;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNodeType;
import com.lynx.tasm.behavior.shadow.ShadowStyle;
import com.lynx.tasm.behavior.shadow.Style;
import com.lynx.tasm.behavior.shadow.ViewLayoutTick;
import com.lynx.tasm.behavior.shadow.text.AbsBaselineShiftCalculatorSpan;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsoluteSizeSpan;
import com.lynx.tasm.behavior.shadow.text.BackgroundColorSpan;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaselineShiftCalculator;
import com.lynx.tasm.behavior.shadow.text.CustomBaselineShiftSpan;
import com.lynx.tasm.behavior.shadow.text.CustomLetterSpacingSpan;
import com.lynx.tasm.behavior.shadow.text.CustomLineHeightSpan;
import com.lynx.tasm.behavior.shadow.text.EventTargetSpan;
import com.lynx.tasm.behavior.shadow.text.FontFamilySpan;
import com.lynx.tasm.behavior.shadow.text.ForegroundColorSpan;
import com.lynx.tasm.behavior.shadow.text.InlineTextBaselineShiftSpan;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTruncationShadowNode;
import com.lynx.tasm.behavior.shadow.text.LynxStrikethroughSpan;
import com.lynx.tasm.behavior.shadow.text.LynxTextBackgroundSpan;
import com.lynx.tasm.behavior.shadow.text.LynxTextGradientSpan;
import com.lynx.tasm.behavior.shadow.text.LynxUnderlineSpan;
import com.lynx.tasm.behavior.shadow.text.NativeLayoutNodeSpan;
import com.lynx.tasm.behavior.shadow.text.RawTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.ShadowStyleSpan;
import com.lynx.tasm.behavior.shadow.text.StaticLayoutCompat;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import com.lynx.tasm.behavior.shadow.text.TextLayoutWarmer;
import com.lynx.tasm.behavior.shadow.text.TextRenderer;
import com.lynx.tasm.behavior.shadow.text.TextRendererCache;
import com.lynx.tasm.behavior.shadow.text.TextRendererKey;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextUpdateBundle;
import com.lynx.tasm.behavior.shadow.text.TypefaceCache;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIParent;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.background.BackgroundGradientLayer;
import com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable;
import com.lynx.tasm.behavior.ui.background.BackgroundLayerManager;
import com.lynx.tasm.behavior.ui.background.BackgroundLinearGradientLayer;
import com.lynx.tasm.behavior.ui.background.BackgroundPosition;
import com.lynx.tasm.behavior.ui.background.BackgroundSize;
import com.lynx.tasm.behavior.ui.image.AbsUIImage;
import com.lynx.tasm.behavior.ui.image.ImageUrlRedirectUtils;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.UIListAdapter;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.text.AbsInlineImageSpan;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BackgroundManager;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.behavior.ui.utils.ColorUtil;
import com.lynx.tasm.behavior.ui.utils.LynxBackground;
import com.lynx.tasm.behavior.ui.utils.Spacing;
import com.lynx.tasm.behavior.ui.utils.TransformProps;
import com.lynx.tasm.behavior.ui.utils.ViewHelper;
import com.lynx.tasm.behavior.ui.view.AndroidView;
import com.lynx.tasm.behavior.ui.view.ComponentView;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.behavior.utils.LynxUISetter;
import com.lynx.tasm.behavior.utils.PropsHolderAutoRegister;
import com.lynx.tasm.behavior.utils.PropsUpdater;
import com.lynx.tasm.behavior.utils.Settable;
import com.lynx.tasm.behavior.utils.ShadowNodeSetter;
import com.lynx.tasm.common.LepusBuffer;
import com.lynx.tasm.common.SingleThreadAsserter;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.core.ResourceLoader;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxImpressionEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.loader.LynxFontFaceLoader;
import com.lynx.tasm.provider.AbsNetworkingModuleProvider;
import com.lynx.tasm.provider.AbsTemplateProvider;
import com.lynx.tasm.provider.ResProvider;
import com.lynx.tasm.provider.ThemeResourceProvider;
import com.lynx.tasm.rendernode.compat.RenderNodeCompat;
import com.lynx.tasm.theme.LynxTheme;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.FloatUtils;
import com.lynx.tasm.utils.I18nUtil;
import com.lynx.tasm.utils.LynxConstants;
import com.lynx.tasm.utils.LynxFrameRateControl;
import com.lynx.tasm.utils.MatrixMathUtils;
import com.lynx.tasm.utils.PixelUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.UnitUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ClassWarmer {
    private static volatile boolean mFired;

    public static void warmClassWithWarmers(final List<BehaviorClassWarmer> list) {
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ClassWarmer.1
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    for (BehaviorClassWarmer behaviorClassWarmer : list) {
                        if (behaviorClassWarmer != null) {
                            behaviorClassWarmer.warmClass();
                        }
                    }
                    LLog.m2578i("warmClassWithExtraWarmers", "Task0 class warm-up cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public static void warmClassForBehaviors(final List<Behavior> list) {
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ClassWarmer.2
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        BehaviorClassWarmer createClassWarmer = ((Behavior) it.next()).createClassWarmer();
                        if (createClassWarmer != null) {
                            createClassWarmer.warmClass();
                        }
                    }
                    Log.i("warmClassForBehaviors", "Task0 class warm-up cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public static void warmClass() {
        if (mFired) {
            return;
        }
        mFired = true;
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ClassWarmer.3
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    Class.forName(AbsTemplateProvider.class.getName());
                    Class.forName(PropsHolderAutoRegister.class.getName());
                    Class.forName(BuiltInBehavior.class.getName());
                    Class.forName(Behavior.class.getName());
                    Class.forName(LynxModuleFactory.class.getName());
                    Class.forName(CallbackImpl.class.getName());
                    Class.forName(LynxEnvLazyInitializer.class.getName());
                    Class.forName(LepusBuffer.class.getName());
                    Class.forName(ParamWrapper.class.getName());
                    Class.forName(XElementBehavior.class.getName());
                    ClassWarmer.warmerBehaviorGenerator();
                    Log.i("Lynx_ClassWarmer", "Task0 class warm-up cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ClassWarmer.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        Class.forName("com.lynx.devtool.LynxInspectorOwner");
                    } catch (ClassNotFoundException unused) {
                        Log.i("Lynx_ClassWarmer", "LynxInspectorOwner class not find");
                        System.loadLibrary(ICustomDataHandlerKt.TYPE_LYNX);
                        Log.i("Lynx_ClassWarmer", "Task1 preload Lynx so cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ClassWarmer.5
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    Class.forName(Arguments.class.getName());
                    Class.forName(LynxMethod.class.getName());
                    Class.forName(LynxMethodWrapper.class.getName());
                    Class.forName(LynxModule.class.getName());
                    Class.forName(LynxModuleWrapper.class.getName());
                    Class.forName(MethodDescriptor.class.getName());
                    Class.forName(Promise.class.getName());
                    Class.forName(Callback.class.getName());
                    Class.forName(Dynamic.class.getName());
                    Class.forName(SafeRunnable.class.getName());
                    Class.forName(NativeArrayInterface.class.getName());
                    Class.forName(ReadableArray.class.getName());
                    Class.forName(ReadableMap.class.getName());
                    Class.forName(ReadableMapKeySetIterator.class.getName());
                    Class.forName(ReadableType.class.getName());
                    Class.forName(ClassWarmer.class.getName());
                    Class.forName(EventEmitter.class.getName());
                    Class.forName(IDynamicHandler.class.getName());
                    Class.forName(INativeLibraryLoader.class.getName());
                    Class.forName(ListNodeInfoFetcher.class.getName());
                    Class.forName(LynxEnv.class.getName());
                    Class.forName(LynxGroup.class.getName());
                    Class.forName(LynxViewBuilder.class.getName());
                    Class.forName(NativeFacade.Callback.class.getName());
                    Class.forName(TemplateData.class.getName());
                    Class.forName(ThreadStrategyForRendering.class.getName());
                    Class.forName(Assertions.class.getName());
                    Class.forName(CalledByNative.class.getName());
                    Class.forName(JNINamespace.class.getName());
                    Class.forName(LynxPageLoadListener.class.getName());
                    Class.forName(BehaviorBundle.class.getName());
                    Class.forName(BehaviorRegistry.class.getName());
                    Class.forName(ExceptionHandler.class.getName());
                    Class.forName(ImageInterceptor.class.getName());
                    Class.forName(AbstractLayoutAnimation.class.getName());
                    Class.forName(LayoutAnimationManager.class.getName());
                    Class.forName(LayoutContext.class.getName());
                    Class.forName(KeyframeManager.class.getName());
                    Class.forName(LynxKeyframeAnimator.class.getName());
                    Class.forName(LynxProp.class.getName());
                    Class.forName(LynxPropGroup.class.getName());
                    Class.forName(LynxPropsHolder.class.getName());
                    Class.forName(LynxUIOwner.class.getName());
                    Class.forName(PaintingContext.class.getName());
                    Class.forName(PropsConstants.class.getName());
                    Class.forName(ShadowNodeRegistry.class.getName());
                    Class.forName(StylesDiffMap.class.getName());
                    Class.forName(TouchEventDispatcher.class.getName());
                    Class.forName(AlignContext.class.getName());
                    Class.forName(AlignParam.class.getName());
                    Class.forName(ChoreographerLayoutTick.class.getName());
                    Class.forName(CustomLayoutShadowNode.class.getName());
                    Class.forName(CustomMeasureFunc.class.getName());
                    Class.forName(LayoutNode.class.getName());
                    Class.forName(LayoutTick.class.getName());
                    Class.forName(MeasureContext.class.getName());
                    Class.forName(MeasureFunc.class.getName());
                    Class.forName(MeasureMode.class.getName());
                    Class.forName(MeasureOutput.class.getName());
                    Class.forName(MeasureParam.class.getName());
                    Class.forName(MeasureResult.class.getName());
                    Class.forName(MeasureUtils.class.getName());
                    Class.forName(NativeLayoutNodeRef.class.getName());
                    Class.forName(ShadowNode.class.getName());
                    Class.forName(ShadowNodeType.class.getName());
                    Class.forName(ShadowStyle.class.getName());
                    Class.forName(Style.class.getName());
                    Class.forName(ViewLayoutTick.class.getName());
                    Class.forName(AbsBaselineShiftCalculatorSpan.class.getName());
                    Class.forName(AbsInlineImageShadowNode.class.getName());
                    Class.forName(AbsoluteSizeSpan.class.getName());
                    Class.forName(BackgroundColorSpan.class.getName());
                    Class.forName(BaselineShiftCalculator.class.getName());
                    Class.forName(BaseTextShadowNode.class.getName());
                    Class.forName(CustomBaselineShiftSpan.class.getName());
                    Class.forName(CustomLetterSpacingSpan.class.getName());
                    Class.forName(CustomLineHeightSpan.class.getName());
                    Class.forName(EventTargetSpan.class.getName());
                    Class.forName(FontFamilySpan.class.getName());
                    Class.forName(ForegroundColorSpan.class.getName());
                    Class.forName(InlineTextBaselineShiftSpan.class.getName());
                    Class.forName(InlineTextShadowNode.class.getName());
                    Class.forName(InlineTruncationShadowNode.class.getName());
                    Class.forName(InlineTruncationShadowNode.class.getName());
                    Class.forName(LynxStrikethroughSpan.class.getName());
                    Class.forName(LynxTextBackgroundSpan.class.getName());
                    Class.forName(LynxTextGradientSpan.class.getName());
                    Class.forName(LynxUnderlineSpan.class.getName());
                    Class.forName(NativeLayoutNodeSpan.class.getName());
                    Class.forName(RawTextShadowNode.class.getName());
                    Class.forName(ShadowStyleSpan.class.getName());
                    Class.forName(StaticLayoutCompat.class.getName());
                    Class.forName(TextAttributes.class.getName());
                    Class.forName(TextLayoutWarmer.class.getName());
                    Class.forName(TextRenderer.class.getName());
                    Class.forName(TextRendererCache.class.getName());
                    Class.forName(TextRendererKey.BaseKey.class.getName());
                    Class.forName(TextRendererKey.class.getName());
                    Class.forName(TextShadowNode.class.getName());
                    Class.forName(TextUpdateBundle.class.getName());
                    Class.forName(TypefaceCache.LazyProvider.class.getName());
                    Class.forName(TypefaceCache.class.getName());
                    Class.forName(UIComponent.class.getName());
                    Class.forName(ComponentView.class.getName());
                    Class.forName(IDrawChildHook.IDrawChildHookBinding.class.getName());
                    Class.forName(IDrawChildHook.class.getName());
                    Class.forName(LynxBaseUI.class.getName());
                    Class.forName(UIParent.class.getName());
                    Class.forName(ImageUrlRedirectUtils.class.getName());
                    Class.forName(AndroidScrollView.OnScrollListener.class.getName());
                    Class.forName(AbsInlineImageSpan.class.getName());
                    Class.forName(AndroidText.class.getName());
                    Class.forName(BackgroundDrawable.BorderRadiusLocation.class.getName());
                    Class.forName(BackgroundDrawable.class.getName());
                    Class.forName(ColorUtil.class.getName());
                    Class.forName(LynxBackground.class.getName());
                    Class.forName(Spacing.class.getName());
                    Class.forName(ViewHelper.class.getName());
                    Class.forName(PropsUpdater.class.getName());
                    Class.forName(Settable.class.getName());
                    Class.forName(SingleThreadAsserter.class.getName());
                    Class.forName(ResourceLoader.class.getName());
                    Class.forName(EventsListener.class.getName());
                    Class.forName(LynxEvent.class.getName());
                    Class.forName(PageReloadHelper.class.getName());
                    Class.forName(AbsNetworkingModuleProvider.class.getName());
                    Class.forName(AbsTemplateProvider.Callback.class.getName());
                    Class.forName(ColorUtils.class.getName());
                    Class.forName(DisplayMetricsHolder.class.getName());
                    Class.forName(FloatUtils.class.getName());
                    Class.forName(I18nUtil.class.getName());
                    Class.forName(LynxConstants.class.getName());
                    Class.forName(PixelUtils.class.getName());
                    Class.forName(UIThreadUtils.class.getName());
                    Class.forName(UnitUtils.class.getName());
                    Class.forName(LynxFrameRateControl.class.getName());
                    Class.forName(LynxFontFaceLoader.class.getName());
                    Class.forName(ResProvider.class.getName());
                    Class.forName(ThemeResourceProvider.class.getName());
                    Class.forName(LynxTheme.class.getName());
                    Class.forName(PromiseImpl.class.getName());
                    Class.forName(DynamicFromArray.class.getName());
                    Class.forName(DynamicFromMap.class.getName());
                    Class.forName(WritableArray.class.getName());
                    Class.forName(WritableMap.class.getName());
                    Class.forName(LynxTemplateRender.TASMCallback.class.getName());
                    Class.forName(LynxViewClient.class.getName());
                    Class.forName(NativeFacade.class.getName());
                    Class.forName(RenderNodeCompat.class.getName());
                    Class.forName(BaseLayoutAnimation.class.getName());
                    Class.forName(LayoutUpdateAnimation.class.getName());
                    Class.forName(PositionAndSizeAnimation.class.getName());
                    Class.forName(LynxContext.class.getName());
                    Class.forName(ShadowNodeOwner.class.getName());
                    Class.forName(LynxFlattenUI.class.getName());
                    Class.forName(LynxUI.class.getName());
                    Class.forName(UIBody.UIBodyView.class.getName());
                    Class.forName(AndroidScrollView.class.getName());
                    Class.forName(BackgroundManager.class.getName());
                    Class.forName(BorderStyle.class.getName());
                    Class.forName(TransformProps.class.getName());
                    Class.forName(AndroidView.class.getName());
                    Class.forName(LynxUISetter.class.getName());
                    Class.forName(ShadowNodeSetter.class.getName());
                    Class.forName(MatrixMathUtils.class.getName());
                    Class.forName(JSProxy.class.getName());
                    Class.forName(LynxCustomEvent.class.getName());
                    Class.forName(LynxTouchEvent.class.getName());
                    Class.forName(JavaOnlyArray.class.getName());
                    Class.forName(JavaOnlyMap.class.getName());
                    Class.forName(ReadableMapBuffer.class.getName());
                    Class.forName(ReadableCompactArrayBuffer.class.getName());
                    Class.forName(ReadableBaseBuffer.class.getName());
                    Class.forName(ReadableMapBufferWrapper.class.getName());
                    Class.forName(DynamicFromMapBuffer.class.getName());
                    Class.forName(MapBuffer.class.getName());
                    Class.forName(CompactArrayBuffer.class.getName());
                    Class.forName(LynxViewClientGroup.class.getName());
                    Class.forName(LynxView.class.getName());
                    Class.forName(LayoutCreateAnimation.class.getName());
                    Class.forName(LayoutDeleteAnimation.class.getName());
                    Class.forName(TransitionAnimationManager.class.getName());
                    Class.forName(AnimationInfo.class.getName());
                    Class.forName(InterpolatorFactory.class.getName());
                    Class.forName(UIGroup.class.getName());
                    Class.forName(UIShadowProxy.ShadowView.class.getName());
                    Class.forName(AbsUIImage.class.getName());
                    Class.forName(FlattenUIText.class.getName());
                    Class.forName(UIText.class.getName());
                    Class.forName(BackgroundLayerManager.class.getName());
                    Class.forName(BackgroundLayerDrawable.class.getName());
                    Class.forName(BackgroundGradientLayer.class.getName());
                    Class.forName(BackgroundLinearGradientLayer.class.getName());
                    Class.forName(BackgroundSize.class.getName());
                    Class.forName(BackgroundPosition.class.getName());
                    Class.forName(FontFaceManager.class.getName());
                    Class.forName(LynxImpressionEvent.class.getName());
                    Class.forName(UIBody.class.getName());
                    Class.forName(UIShadowProxy.class.getName());
                    Class.forName(UISimpleView.class.getName());
                    Class.forName(UIScrollView.class.getName());
                    Class.forName(UIView.class.getName());
                    Class.forName(UIList.class.getName());
                    Class.forName(UIListAdapter.class.getName());
                    Class.forName(LynxBaseInspectorOwner.class.getName());
                    Class.forName(ILynxLogBox.class.getName());
                    Class.forName(LynxDevtool.class.getName());
                    new BorderRadius();
                    I18nUtil.getInstance();
                    new BorderRadius.Corner();
                    Log.i("Lynx_ClassWarmer", "Task2 class warm-up cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void warmerBehaviorGenerator() {
        Iterator it = XElementBehavior.GENERATOR_FILE_NAME_SETS.iterator();
        while (it.hasNext()) {
            try {
                Class.forName(((String) it.next()) + ".BehaviorGenerator");
            } catch (Throwable unused) {
            }
        }
    }
}
