package com.lynx.tasm.behavior.p000ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.animation.AnimationInfo;
import com.lynx.tasm.animation.keyframe.KeyframeManager;
import com.lynx.tasm.animation.layout.LayoutAnimationManager;
import com.lynx.tasm.animation.transition.TransitionAnimationManager;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.OnceTask;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.herotransition.HeroAnimOwner;
import com.lynx.tasm.behavior.herotransition.HeroTransitionManager;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityWrapper;
import com.lynx.tasm.behavior.p000ui.list.UIList;
import com.lynx.tasm.behavior.p000ui.shapes.BasicShape;
import com.lynx.tasm.behavior.p000ui.shapes.LynxOffsetCalculator;
import com.lynx.tasm.behavior.p000ui.text.AndroidText;
import com.lynx.tasm.behavior.p000ui.utils.BackgroundManager;
import com.lynx.tasm.behavior.p000ui.utils.PlatformLength;
import com.lynx.tasm.behavior.p000ui.utils.TransformRaw;
import com.lynx.tasm.behavior.p000ui.utils.ViewHelper;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.service.ILynxSystemInvokeService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.BitmapUtils;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.FloatUtils;
import com.lynx.tasm.utils.UnitUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LynxUI<T extends View> extends LynxBaseUI implements IProcessViewInfoHook {
    protected static final boolean ENABLE_ZINDEX = false;
    private static final float OFFSET_ROTATE_AUTO = -1024.0f;
    private static final String TAG = "LynxUI";
    protected float mAlpha;
    private AnimationInfo[] mAnimationInfos;
    private BackgroundManager mBackgroundManager;
    protected BasicShape mClipPath;
    protected LynxBaseUI mDrawHead;
    private boolean mEnableReuseAnimationState;
    protected boolean mFirstRender;
    private float mGrayscaleAmount;
    private HeroAnimOwner mHeroAnimOwner;
    protected boolean mIsAutoOffsetRotate;
    private KeyframeManager mKeyframeManager;
    protected float mLastOffsetEffectRotate;
    protected float mLastOffsetEffectX;
    protected float mLastOffsetEffectY;
    private LayoutAnimationManager mLayoutAnimator;
    protected float mOffsetDistance;
    protected boolean mOffsetHasChanged;
    protected BasicShape mOffsetPath;
    protected float mOffsetRotate;
    protected OnceTask<T> mOnceTask;
    private boolean mOverlappingRendering;
    protected ReadableArray mRawOffsetShape;
    private boolean mSetVisibleByCSS;
    private TransitionAnimationManager mTransitionAnimator;
    protected T mView;
    protected ViewInfo mViewInfo;

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void afterDispatchProcessViewInfo(ViewInfo viewInfo) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void afterProcessChildViewInfo(ViewInfo viewInfo, View view, long j) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void afterProcessViewInfo(ViewInfo viewInfo) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void beforeDispatchProcessViewInfo(ViewInfo viewInfo) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void beforeProcessChildViewInfo(ViewInfo viewInfo, View view, long j) {
    }

    protected T createView(Context context) {
        return null;
    }

    public LynxUI getTransitionUI() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAccessibilityDelegate() {
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void processLayoutChildren() {
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void processMeasureChildren() {
    }

    public void setLayoutAnimationCreateTimingFunc(String str) {
    }

    private boolean shouldDoTransformTransition() {
        TransitionAnimationManager transitionAnimationManager;
        return !this.mIsFirstAnimatedReady && this.hasTransformChanged && (transitionAnimationManager = this.mTransitionAnimator) != null && transitionAnimationManager.containTransition(4096);
    }

    public void setDrawHead(LynxBaseUI lynxBaseUI) {
        this.mDrawHead = lynxBaseUI;
    }

    public LynxBaseUI getDrawHead() {
        return this.mDrawHead;
    }

    public void insertDrawList(LynxBaseUI lynxBaseUI, LynxBaseUI lynxBaseUI2) {
        lynxBaseUI2.setDrawParent(this);
        if (lynxBaseUI == null) {
            LynxBaseUI lynxBaseUI3 = this.mDrawHead;
            if (lynxBaseUI3 != null) {
                lynxBaseUI3.mPreviousDrawUI = lynxBaseUI2;
                lynxBaseUI2.mNextDrawUI = this.mDrawHead;
            }
            this.mDrawHead = lynxBaseUI2;
            return;
        }
        LynxBaseUI lynxBaseUI4 = lynxBaseUI.mNextDrawUI;
        if (lynxBaseUI4 != null) {
            lynxBaseUI4.mPreviousDrawUI = lynxBaseUI2;
            lynxBaseUI2.mNextDrawUI = lynxBaseUI4;
        }
        lynxBaseUI2.mPreviousDrawUI = lynxBaseUI;
        lynxBaseUI.mNextDrawUI = lynxBaseUI2;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onDrawingPositionChanged() {
        if (this.mView.isLayoutRequested()) {
            return;
        }
        handleLayout();
        invalidate();
    }

    @Deprecated
    public LynxUI(Context context) {
        this((LynxContext) context);
    }

    public LynxUI(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public LynxUI(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mGrayscaleAmount = 1.0f;
        this.mSetVisibleByCSS = true;
        this.mLayoutAnimator = null;
        this.mOverlappingRendering = true;
        this.mEnableReuseAnimationState = true;
        this.mAnimationInfos = null;
        this.mFirstRender = true;
        this.mAlpha = 1.0f;
        this.mDrawHead = null;
        this.mOffsetRotate = OFFSET_ROTATE_AUTO;
        this.mIsAutoOffsetRotate = true;
        this.mOffsetHasChanged = false;
    }

    T getOrCreateView(Context context, Object obj) {
        if (this.mContext != null && this.mContext.isFallbackProcess() && this.mContext.getUIBodyView() != null && (obj instanceof UIParams)) {
            setNodeIndex(((UIParams) obj).mNodeIndex);
            T t = (T) this.mContext.getUIBodyView().obtainViewAccordingToNodeIndex(this.mNodeIndex);
            if (t != null) {
                t.setBackground(null);
                return t;
            }
        }
        return createView(context, obj);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        T orCreateView = getOrCreateView(this.mContext, this.mParam);
        this.mView = orCreateView;
        if (orCreateView == null) {
            return;
        }
        this.mHeroAnimOwner = new HeroAnimOwner(this);
        BackgroundManager backgroundManager = new BackgroundManager(this, getLynxContext());
        this.mBackgroundManager = backgroundManager;
        setLynxBackground(backgroundManager);
        this.mBackgroundManager.setDrawableCallback(this.mDrawableCallback);
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper == null || !lynxAccessibilityWrapper.enableHelper()) {
            return;
        }
        initAccessibilityDelegate();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        KeyframeManager keyframeManager = this.mKeyframeManager;
        if (keyframeManager != null) {
            keyframeManager.onDetach();
        }
        LayoutAnimationManager layoutAnimationManager = this.mLayoutAnimator;
        if (layoutAnimationManager != null) {
            layoutAnimationManager.applyLatestLayoutInfoToUI();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        KeyframeManager keyframeManager = this.mKeyframeManager;
        if (keyframeManager != null) {
            keyframeManager.onAttach();
        }
    }

    protected T createView(Context context, Object obj) {
        return createView(context);
    }

    public T getView() {
        return this.mView;
    }

    public ViewInfo getViewInfo() {
        return this.mViewInfo;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected void registerViewAccordingToNodeIndex() {
        if (this.mContext == null || this.mContext.getUIBodyView() == null) {
            return;
        }
        this.mContext.getUIBodyView().registerViewAccordingToNodeIndex(this.mNodeIndex, this.mView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void detachWithViewInfo(ViewInfo viewInfo) {
        registerViewAccordingToNodeIndex();
        ViewInfo viewInfo2 = this.mViewInfo;
        if (viewInfo2 != null) {
            viewInfo = viewInfo2;
        }
        super.detachWithViewInfo(viewInfo);
        ViewInfo viewInfo3 = this.mViewInfo;
        if (viewInfo3 != null) {
            KeyframeManager keyframeManager = this.mKeyframeManager;
            if (keyframeManager != null) {
                viewInfo3.setKeyframeManager(keyframeManager);
                this.mKeyframeManager = null;
            }
            this.mViewInfo.detachFromUI();
            this.mViewInfo = null;
        }
        this.mView = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void attachToView(LynxContext lynxContext) {
        this.mContext = lynxContext;
        if (this.mView == null) {
            T t = (T) this.mContext.getUIBodyView().obtainViewAccordingToNodeIndex(this.mNodeIndex);
            if (t != null) {
                this.mView = t;
            } else {
                createViewAsync();
            }
        }
        this.mContext.getUIBody().appendUIWithCreateViewAsync(this);
        super.attachToView(lynxContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void createViewAsync() {
        super.createViewAsync();
        final OnceTask<T> onceTask = new OnceTask<>(new Callable<T>() { // from class: com.lynx.tasm.behavior.ui.LynxUI.1
            @Override // java.util.concurrent.Callable
            public T call() {
                try {
                    LynxUI lynxUI = LynxUI.this;
                    if (lynxUI.createView(lynxUI.mContext, LynxUI.this.mParam) != null) {
                        return null;
                    }
                    LynxUI lynxUI2 = LynxUI.this;
                    return (T) lynxUI2.createView(lynxUI2.mContext);
                } catch (Throwable th) {
                    LLog.e(LynxUI.TAG, th.toString());
                    return null;
                }
            }
        }, new Consumer<Exception>() { // from class: com.lynx.tasm.behavior.ui.LynxUI.2
            public void accept(Exception exc) {
                if (LynxUI.this.mContext != null) {
                    LynxUI.this.mContext.handleException(exc);
                }
            }
        });
        this.mOnceTask = onceTask;
        LynxThreadPool.postUIOperationTask(new Runnable() { // from class: com.lynx.tasm.behavior.ui.LynxUI.3
            @Override // java.lang.Runnable
            public void run() {
                onceTask.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void ensureCreateView() {
        OnceTask<T> onceTask = this.mOnceTask;
        if (onceTask != null) {
            onceTask.run();
            this.mView = (T) this.mOnceTask.get();
            this.mOnceTask = null;
        }
        if (this.mView == null) {
            T t = (T) createView(this.mContext, this.mParam);
            this.mView = t;
            if (t == null) {
                this.mView = (T) createView(this.mContext);
            }
        }
        T t2 = this.mView;
        if ((t2 instanceof IDrawChildHook.IDrawChildHookBinding) && (this instanceof IDrawChildHook)) {
            ((IDrawChildHook.IDrawChildHookBinding) t2).bindDrawChildHook((IDrawChildHook) this);
        }
        if ((this.mDrawParent instanceof UIGroup) && this.mView.getParent() == null) {
            ((UIGroup) this.mDrawParent).insertChildWhenRebuildView(this);
        }
        didEnsureCreateView();
        this.mView.requestLayout();
        this.mView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void didEnsureCreateView() {
        BackgroundManager backgroundManager = this.mBackgroundManager;
        if (backgroundManager != null && backgroundManager.getDrawable() != null) {
            this.mView.setBackground(this.mBackgroundManager.getDrawable());
        }
        if (this.mAlpha != this.mView.getAlpha()) {
            this.mView.setAlpha(this.mAlpha);
        }
        if (this.mAnimationInfos != null) {
            prepareKeyframeManager();
            this.mKeyframeManager.setAnimations(this.mAnimationInfos);
            this.mKeyframeManager.notifyAnimationUpdated();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void processViewInfo() {
        beforeProcessViewInfo(this.mViewInfo);
        beforeDispatchProcessViewInfo(this.mViewInfo);
        dispatchProcessViewInfo();
        afterDispatchProcessViewInfo(this.mViewInfo);
        afterProcessViewInfo(this.mViewInfo);
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void dispatchProcessViewInfo() {
        for (LynxBaseUI lynxBaseUI = this.mDrawHead; lynxBaseUI != null; lynxBaseUI = lynxBaseUI.mNextDrawUI) {
            if (lynxBaseUI instanceof LynxUI) {
                processChildViewInfo((LynxUI) lynxBaseUI);
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void processChildViewInfo(IProcessViewInfoHook iProcessViewInfoHook) {
        LynxUI lynxUI = (LynxUI) iProcessViewInfoHook;
        beforeProcessChildViewInfo(this.mViewInfo, lynxUI.getView(), 0L);
        lynxUI.processViewInfo();
        afterProcessChildViewInfo(this.mViewInfo, lynxUI.getView(), 0L);
    }

    @Override // com.lynx.tasm.behavior.p000ui.IProcessViewInfoHook
    public void beforeProcessViewInfo(ViewInfo viewInfo) {
        viewInfo.setSkewX(getSkewX());
        viewInfo.setSkewY(getSkewY());
        viewInfo.setClipPath(this.mClipPath);
        viewInfo.setWidth(getWidth());
        viewInfo.setHeight(getHeight());
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setSign(int i, String str) {
        super.setSign(i, str);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(defaultFloat = DisplayMetricsHolder.DEFAULT_SCREEN_SCALE, name = PropsConstants.OPACITY)
    public void setAlpha(float f) {
        super.setAlpha(f);
        if (getKeyframeManager() != null) {
            getKeyframeManager().notifyPropertyUpdated("Alpha", Float.valueOf(f));
        }
        TransitionAnimationManager transitionAnimationManager = this.mTransitionAnimator;
        if (transitionAnimationManager != null && transitionAnimationManager.containTransition(1)) {
            this.mTransitionAnimator.applyPropertyTransition(this, 1, Float.valueOf(f));
            return;
        }
        if (f != this.mView.getAlpha()) {
            this.mView.setAlpha(f);
        }
        LayoutAnimationManager layoutAnimationManager = this.mLayoutAnimator;
        if (layoutAnimationManager != null) {
            layoutAnimationManager.updateAlpha(f);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getTranslationX() {
        return this.mView.getTranslationX();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getTranslationY() {
        return this.mView.getTranslationY();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getRealTimeTranslationZ() {
        return this.mView.getTranslationZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getScaleX() {
        T t = this.mView;
        if (t == null) {
            return 1.0f;
        }
        return t.getScaleX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public float getScaleY() {
        T t = this.mView;
        if (t == null) {
            return 1.0f;
        }
        return t.getScaleY();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void onFocusChanged(boolean z, boolean z2) {
        if (z2) {
            return;
        }
        InputMethodManager inputMethodManager = LynxEnv.inst().getInputMethodManager();
        if (inputMethodManager == null) {
            LLog.w(TAG, "Failed to get InputMethodManager");
        } else if (z) {
            inputMethodManager.showSoftInput(this.mView, 1);
        } else {
            inputMethodManager.hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
        }
    }

    @LynxProp(defaultInt = 1, name = "visibility")
    public void setVisibility(int i) {
        TransitionAnimationManager transitionAnimationManager = this.mTransitionAnimator;
        if (transitionAnimationManager != null && transitionAnimationManager.containTransition(128)) {
            this.mTransitionAnimator.applyPropertyTransition(this, 128, Integer.valueOf(i));
            return;
        }
        int visibility = this.mView.getVisibility();
        if (i == 1) {
            this.mSetVisibleByCSS = true;
            this.mView.setVisibility(0);
            visibility = 0;
        } else if (i == 0) {
            this.mSetVisibleByCSS = false;
            visibility = 4;
            this.mView.setVisibility(4);
        }
        if (getParent() instanceof UIShadowProxy) {
            ((UIShadowProxy) getParent()).setVisibilityForView(visibility);
        }
    }

    public void setVisibilityForView(int i) {
        if (i == 0) {
            this.mSetVisibleByCSS = true;
            this.mView.setVisibility(0);
        } else if (i == 4) {
            this.mSetVisibleByCSS = false;
            this.mView.setVisibility(4);
        }
    }

    private void prepareKeyframeManager() {
        if (this.mKeyframeManager == null) {
            this.mKeyframeManager = new KeyframeManager(this);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setAnimation(ReadableArray readableArray) {
        if (readableArray == null) {
            KeyframeManager keyframeManager = this.mKeyframeManager;
            if (keyframeManager != null) {
                keyframeManager.endAllAnimation();
                this.mKeyframeManager = null;
            }
            this.mAnimationInfos = null;
            return;
        }
        prepareKeyframeManager();
        int size = readableArray.size();
        AnimationInfo[] animationInfoArr = new AnimationInfo[size];
        for (int i = 0; i < size; i++) {
            animationInfoArr[i] = AnimationInfo.toAnimationInfo(readableArray.getArray(i));
        }
        this.mAnimationInfos = animationInfoArr;
        this.mKeyframeManager.setAnimations(animationInfoArr);
    }

    public void setAnimation(AnimationInfo animationInfo) {
        prepareKeyframeManager();
        this.mKeyframeManager.setAnimation(animationInfo);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(name = PropsConstants.TRANSFORM)
    public void setTransform(ReadableArray readableArray) {
        this.mHasTranslateDiff = hasTranslateDiff(readableArray);
        super.setTransform(readableArray);
        if (getKeyframeManager() != null) {
            getKeyframeManager().notifyPropertyUpdated("Transform", this.mTransformRaw);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public Matrix getTransformMatrix() {
        T t = this.mView;
        if (t == null || t.getMatrix() == null) {
            return super.getTransformMatrix();
        }
        return this.mView.getMatrix();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(name = PropsConstants.TEST_TAG)
    public void setTestID(String str) {
        this.mView.setTag(str);
    }

    @LynxProp(name = PropsConstants.RENDER_TO_HARDWARE_TEXTURE)
    public void setRenderToHardwareTexture(boolean z) {
        int i;
        if (z) {
            if (this.mContext != null) {
                LynxFeatureCounter.count(62, this.mContext.getInstanceId());
            }
            i = 2;
        } else {
            i = 0;
        }
        this.mView.setLayerType(i, null);
    }

    @LynxProp(name = PropsConstants.SHARED_ELEMENT)
    public void setShareElement(String str) {
        this.mHeroAnimOwner.setSharedElementName(str);
    }

    @LynxProp(name = PropsConstants.ENTER_TRANSITION_NAME)
    public void setEnterTransitionName(ReadableArray readableArray) {
        AnimationInfo animationInfo = AnimationInfo.toAnimationInfo(readableArray);
        if (animationInfo != null) {
            if (this.mContext != null) {
                LynxFeatureCounter.count(67, this.mContext.getInstanceId());
            }
            HeroTransitionManager.inst().registerEnterAnim(this, animationInfo);
        }
    }

    @LynxProp(name = PropsConstants.EXIT_TRANSITION_NAME)
    public void setExitTransitionName(ReadableArray readableArray) {
        AnimationInfo animationInfo = AnimationInfo.toAnimationInfo(readableArray);
        if (animationInfo != null) {
            if (this.mContext != null) {
                LynxFeatureCounter.count(68, this.mContext.getInstanceId());
            }
            HeroTransitionManager.inst().registerExitAnim(this, animationInfo);
        }
    }

    @LynxProp(name = PropsConstants.PAUSE_TRANSITION_NAME)
    public void setPauseTransitionName(ReadableArray readableArray) {
        AnimationInfo animationInfo = AnimationInfo.toAnimationInfo(readableArray);
        if (animationInfo != null) {
            if (this.mContext != null) {
                LynxFeatureCounter.count(69, this.mContext.getInstanceId());
            }
            HeroTransitionManager.inst().registerPauseAnim(this, animationInfo);
        }
    }

    @LynxProp(name = PropsConstants.RESUME_TRANSITION_NAME)
    public void setResumeTransitionName(ReadableArray readableArray) {
        AnimationInfo animationInfo = AnimationInfo.toAnimationInfo(readableArray);
        if (animationInfo != null) {
            if (this.mContext != null) {
                LynxFeatureCounter.count(70, this.mContext.getInstanceId());
            }
            HeroTransitionManager.inst().registerResumeAnim(this, animationInfo);
        }
    }

    @LynxProp(name = PropsConstants.OVERLAP)
    public void setOverlap(Dynamic dynamic) {
        if (dynamic == null) {
            this.mOverlappingRendering = true;
            return;
        }
        ReadableType type = dynamic.getType();
        if (type == ReadableType.Boolean) {
            this.mOverlappingRendering = dynamic.asBoolean();
        } else if (type == ReadableType.String) {
            this.mOverlappingRendering = dynamic.asString().equalsIgnoreCase("true");
        }
    }

    @LynxProp(name = PropsConstants.TRANSFORM_ORDER)
    public void setTransformOrder(Dynamic dynamic) {
        if (dynamic == null) {
            this.mBackgroundManager.setTransformOrder(true);
            return;
        }
        ReadableType type = dynamic.getType();
        if (type == ReadableType.Boolean) {
            this.mBackgroundManager.setTransformOrder(dynamic.asBoolean());
        } else if (type == ReadableType.String) {
            this.mBackgroundManager.setTransformOrder(dynamic.asString().equalsIgnoreCase("true"));
        }
    }

    @LynxProp(defaultBoolean = true, name = PropsConstants.ENABLE_REUSE_ANIMATION_STATE)
    public void setEnableReuseAnimationState(boolean z) {
        this.mEnableReuseAnimationState = z;
        if (z || this.mContext == null) {
            return;
        }
        LynxFeatureCounter.count(72, this.mContext.getInstanceId());
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.ACCESSIBILITY_ELEMENTS_HIDDEN)
    public void setAccessibilityElementsHidden(boolean z) {
        this.mView.setImportantForAccessibility(z ? 4 : 0);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setAccessibilityValue(String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mView.setStateDescription(str);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setAccessibilityHeading(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mView.setAccessibilityHeading(z);
        }
    }

    public boolean hasOverlappingRenderingEnabled() {
        if (DeviceUtils.isHuaWei() && !DeviceUtils.is64BitDevice()) {
            LLog.i(TAG, "Disable overlap rendering for Huawei 32bit machine");
            return false;
        }
        return this.mOverlappingRendering;
    }

    @LynxUIMethod
    public void takeScreenshot(ReadableMap readableMap, final Callback callback) {
        Bitmap.Config config;
        Bitmap.CompressFormat compressFormat;
        String str;
        Bitmap createBitmap;
        if (this.mView == null) {
            callback.invoke(new Object[]{6, new JavaOnlyMap()});
            return;
        }
        String string = readableMap.getString("format", "jpeg");
        boolean z = readableMap.getBoolean("androidEnablePixelCopy", false);
        if (string.equals("png")) {
            config = Bitmap.Config.ARGB_8888;
            compressFormat = Bitmap.CompressFormat.PNG;
            str = "data:image/png;base64,";
        } else {
            config = Bitmap.Config.RGB_565;
            compressFormat = Bitmap.CompressFormat.JPEG;
            str = "data:image/jpeg;base64,";
        }
        final Bitmap.CompressFormat compressFormat2 = compressFormat;
        final String str2 = str;
        final float f = (float) readableMap.getDouble("scale", 1.0d);
        try {
            ILynxSystemInvokeService iLynxSystemInvokeService = (ILynxSystemInvokeService) LynxServiceCenter.inst().getService(ILynxSystemInvokeService.class);
            if (iLynxSystemInvokeService != null) {
                createBitmap = iLynxSystemInvokeService.takeScreenshot(this.mView, config);
            } else {
                createBitmap = Bitmap.createBitmap(this.mView.getWidth(), this.mView.getHeight(), config);
                Canvas canvas = new Canvas(createBitmap);
                if (z && this.mContext != null && this.mContext.getUIBodyView() != null) {
                    this.mContext.getUIBodyView().getLynxUIRendererInternal().drawViewToBitmap(this.mView, createBitmap, canvas);
                } else {
                    boolean isDirty = this.mView.isDirty();
                    this.mView.draw(canvas);
                    if (isDirty) {
                        this.mView.postInvalidate();
                    }
                }
            }
            final Bitmap bitmap = createBitmap;
            LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.behavior.ui.LynxUI.4
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (f != 1.0f) {
                        Matrix matrix = new Matrix();
                        float f2 = f;
                        matrix.setScale(f2, f2);
                        Bitmap bitmap3 = bitmap;
                        bitmap2 = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), bitmap.getHeight(), matrix, true);
                        bitmap.recycle();
                    } else {
                        bitmap2 = bitmap;
                    }
                    String bitmapToBase64 = BitmapUtils.bitmapToBase64(bitmap2, compressFormat2, 100, 2);
                    JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                    javaOnlyMap.putInt("width", bitmap2.getWidth());
                    javaOnlyMap.putInt("height", bitmap2.getHeight());
                    javaOnlyMap.putString("data", str2 + bitmapToBase64);
                    callback.invoke(new Object[]{0, javaOnlyMap});
                    bitmap2.recycle();
                }
            });
        } catch (Throwable unused) {
            callback.invoke(new Object[]{1, new JavaOnlyMap()});
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public void requestLayout() {
        this.mView.requestLayout();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public KeyframeManager getKeyframeManager() {
        return this.mKeyframeManager;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public void invalidate() {
        T t = this.mView;
        if (t == null) {
            return;
        }
        t.invalidate();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        boolean z = getBound() == null || (getBound().width() > 0 && getBound().height() > 0);
        if (z && this.mSetVisibleByCSS) {
            this.mView.setVisibility(0);
        } else {
            if (z) {
                return;
            }
            this.mView.setVisibility(8);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void measure() {
        String str;
        if (TraceEvent.isTracingStarted()) {
            str = "LynxUI.measure." + getTagName();
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        if (!isDetachedWithView()) {
            setLayoutParamsInternal();
            ViewHelper.measureView(this.mView, getWidth(), getHeight());
        }
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayoutParamsInternal() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams generateLayoutParams;
        if (this.mParent == null || !(this.mParent instanceof UIGroup) || !((UIGroup) this.mParent).needCustomLayout() || (generateLayoutParams = ((UIGroup) this.mParent).generateLayoutParams((layoutParams = this.mView.getLayoutParams()))) == null || layoutParams == generateLayoutParams) {
            return;
        }
        updateLayoutParams(generateLayoutParams);
    }

    public void updateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            throw new RuntimeException("LayoutPrams should not be null");
        }
        layoutParams.width = getWidth();
        layoutParams.height = getHeight();
        if (layoutParams != this.mView.getLayoutParams()) {
            this.mView.setLayoutParams(layoutParams);
        }
    }

    public void handleLayout() {
        String str;
        if (isDetachedWithView()) {
            return;
        }
        if (TraceEvent.isTracingStarted()) {
            str = "LynxUI.layout." + getTagName();
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        this.mView.layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        if (getParent() instanceof UIShadowProxy) {
            ((UIShadowProxy) getParent()).updateTransform();
        }
        if (this.mView.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
            boolean z = (getSkewX() == 0.0f && getSkewY() == 0.0f) ? false : true;
            if (getOverflow() != 0 || z) {
                viewGroup.setClipChildren(false);
            }
            if (!z) {
                ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
            }
        }
        if (getOverflow() != 0 && (getWidth() == 0 || getHeight() == 0)) {
            T t = this.mView;
            if (t instanceof AndroidText) {
                ((AndroidText) t).setOverflow(getOverflow());
            }
        }
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void layout() {
        handleLayout();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onAnimationNodeReady() {
        super.onAnimationNodeReady();
        updatePerspectiveToView();
        if (shouldDoTransform()) {
            this.mBackgroundManager.setTransformOrigin(this.mTransformOrigin);
            if (shouldDoTransformTransition()) {
                this.mTransitionAnimator.applyTransformTransition(this);
            } else {
                TransitionAnimationManager transitionAnimationManager = this.mTransitionAnimator;
                if (transitionAnimationManager != null) {
                    transitionAnimationManager.endTransitionAnimator(4096);
                }
                this.mBackgroundManager.setTransform(this.mTransformRaw);
            }
        }
        if (this.mOffsetHasChanged) {
            BasicShape basicShape = this.mOffsetPath;
            if (basicShape != null) {
                float[] pointAtProgress = LynxOffsetCalculator.pointAtProgress(basicShape.getPath(getWidth(), getHeight()), this.mOffsetDistance);
                if (this.mIsAutoOffsetRotate) {
                    applyOffsetAndRotate(pointAtProgress[0], pointAtProgress[1], pointAtProgress[2]);
                } else {
                    applyOffsetAndRotate(pointAtProgress[0], pointAtProgress[1], this.mOffsetRotate);
                }
            }
            this.mOffsetHasChanged = false;
        }
        TransitionAnimationManager transitionAnimationManager2 = this.mTransitionAnimator;
        if (transitionAnimationManager2 != null) {
            transitionAnimationManager2.startTransitions();
        }
        KeyframeManager keyframeManager = this.mKeyframeManager;
        if (keyframeManager != null) {
            keyframeManager.notifyAnimationUpdated();
        }
        if (this.mContext != null && this.mContext.isTouchMoving() && this.mHasTranslateDiff) {
            this.mContext.onPropsChanged(this);
        }
        this.mHasTranslateDiff = false;
    }

    public void applyOffsetAndRotate(float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TransformRaw.createTransformRaw(1, new PlatformLength(f - this.mLastOffsetEffectX, 0), 0, new PlatformLength(f2 - this.mLastOffsetEffectY, 0), 0, new PlatformLength(0.0f, 0), 0));
        arrayList.add(TransformRaw.createTransformRaw(32, f3 - this.mLastOffsetEffectRotate, 0, 0.0f, 0, 0.0f, 0));
        this.mLastOffsetEffectX = f;
        this.mLastOffsetEffectY = f2;
        this.mLastOffsetEffectRotate = f3;
        if (this.mBackgroundManager.getTransformProps() == null) {
            this.mBackgroundManager.setTransform(arrayList);
        } else {
            this.mBackgroundManager.appendTransform(arrayList);
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundManager.getBackgroundColor();
    }

    public BackgroundManager getBackgroundManager() {
        return this.mBackgroundManager;
    }

    public ReadableMap getKeyframes(String str) {
        if (this.mContext != null) {
            return this.mContext.getKeyframes(str);
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void initTransitionAnimator(ReadableMap readableMap) {
        if (this.mTransitionAnimator == null) {
            this.mTransitionAnimator = new TransitionAnimationManager(getTransitionUI());
        }
        if (this.mTransitionAnimator.initializeFromConfig(readableMap)) {
            return;
        }
        this.mTransitionAnimator = null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public TransitionAnimationManager getTransitionAnimator() {
        return this.mTransitionAnimator;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean getVisibility() {
        return this.mSetVisibleByCSS;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isVisible() {
        T t = this.mView;
        if (t != null && t.getVisibility() == 0 && this.mView.getAlpha() >= 0.01d) {
            return this.mView.isAttachedToWindow();
        }
        return false;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    @LynxProp(name = PropsConstants.ACCESSIBILITY_LABEL)
    public void setAccessibilityLabel(Dynamic dynamic) {
        super.setAccessibilityLabel(dynamic);
        T t = this.mView;
        if (t != null) {
            t.setFocusable(true);
            this.mView.setContentDescription(getAccessibilityLabel());
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setAccessibilityElement(Dynamic dynamic) {
        super.setAccessibilityElement(dynamic);
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (this.mView == null || this.mAccessibilityElementStatus == -1 || lynxAccessibilityWrapper == null || !lynxAccessibilityWrapper.enableHelper()) {
            return;
        }
        ViewCompat.setImportantForAccessibility(this.mView, this.mAccessibilityElementStatus != 1 ? 2 : 1);
    }

    public HeroAnimOwner getFakeSharedElementManager() {
        return this.mHeroAnimOwner;
    }

    public void execEnterAnim(HeroTransitionManager.LynxViewEnterFinishListener lynxViewEnterFinishListener) {
        this.mHeroAnimOwner.executeEnterAnim(lynxViewEnterFinishListener);
    }

    public void execExitAnim(HeroTransitionManager.LynxViewExitFinishListener lynxViewExitFinishListener) {
        this.mHeroAnimOwner.executeExitAnim(lynxViewExitFinishListener);
    }

    public void execPauseAnim() {
        this.mHeroAnimOwner.executePauseAnim();
    }

    public void execResumeAnim() {
        this.mHeroAnimOwner.executeResumeAnim();
    }

    public void setEnterAnim(AnimationInfo animationInfo) {
        this.mHeroAnimOwner.setEnterAnim(animationInfo);
    }

    public void setExitAnim(AnimationInfo animationInfo) {
        this.mHeroAnimOwner.setExitAnim(animationInfo);
    }

    public void setPauseAnim(AnimationInfo animationInfo) {
        this.mHeroAnimOwner.setPauseAnim(animationInfo);
    }

    public void setResumeAnim(AnimationInfo animationInfo) {
        this.mHeroAnimOwner.setResumeAnim(animationInfo);
    }

    public void onAnimationEnd(String str) {
        this.mHeroAnimOwner.onAnimationEnd(str);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean enableLayoutAnimation() {
        LayoutAnimationManager layoutAnimationManager = this.mLayoutAnimator;
        return layoutAnimationManager != null && layoutAnimationManager.isValid();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public LayoutAnimationManager getLayoutAnimator() {
        return this.mLayoutAnimator;
    }

    private void prepareLayoutAnimator() {
        if (this.mLayoutAnimator == null) {
            this.mLayoutAnimator = new LayoutAnimationManager();
        }
    }

    @LynxProp(name = "layout-animation-create-duration")
    public void setLayoutAnimationCreateDuration(double d) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(64, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.setLayoutAnimationCreateDuration(d);
    }

    @LynxProp(name = "layout-animation-create-property")
    public void setLayoutAnimationCreateProperty(int i) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(64, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutCreateAnimation().setAnimatedProperty(i);
    }

    @LynxProp(name = "layout-animation-create-timing-function")
    public void setLayoutAnimationCreateTimingFunc(ReadableArray readableArray) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(64, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutCreateAnimation().setInterpolator(readableArray);
    }

    @LynxProp(name = "layout-animation-create-delay")
    public void setLayoutAnimationCreateDelay(double d) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(64, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutCreateAnimation().setDelay((long) d);
    }

    @LynxProp(name = "layout-animation-update-duration")
    public void setLayoutAnimationUpdateDuration(double d) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(65, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.setLayoutAnimationUpdateDuration(d);
    }

    @LynxProp(name = "layout-animation-update-property")
    public void setLayoutAnimationUpdateProperty(int i) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(65, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutUpdateAnimation().setAnimatedProperty(i);
    }

    @LynxProp(name = "layout-animation-update-timing-function")
    public void setLayoutAnimationUpdateTimingFunc(ReadableArray readableArray) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(65, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutUpdateAnimation().setInterpolator(readableArray);
    }

    @LynxProp(name = "layout-animation-update-delay")
    public void setLayoutAnimationUpdateDelay(double d) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(65, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutUpdateAnimation().setDelay((long) d);
    }

    @LynxProp(name = "layout-animation-delete-duration")
    public void setLayoutAnimationDeleteDuration(double d) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(66, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.setLayoutAnimationDeleteDuration(d);
    }

    @LynxProp(name = "layout-animation-delete-property")
    public void setLayoutAnimationDeleteProperty(int i) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(66, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutDeleteAnimation().setAnimatedProperty(i);
    }

    @LynxProp(name = "layout-animation-delete-timing-function")
    public void setLayoutAnimationDeleteTimingFunc(ReadableArray readableArray) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(66, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutDeleteAnimation().setInterpolator(readableArray);
    }

    @LynxProp(name = "layout-animation-delete-delay")
    public void setLayoutAnimationDeleteDelay(double d) {
        prepareLayoutAnimator();
        if (this.mContext != null) {
            LynxFeatureCounter.count(66, this.mContext.getInstanceId());
        }
        this.mLayoutAnimator.getLayoutDeleteAnimation().setDelay((long) d);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean checkStickyOnParentScroll(int i, int i2) {
        boolean checkStickyOnParentScroll = super.checkStickyOnParentScroll(i, i2);
        this.mBackgroundManager.setPostTranlate(this.mSticky != null ? new PointF(this.mSticky.f1x, this.mSticky.f2y) : null);
        return checkStickyOnParentScroll;
    }

    @LynxProp(name = PropsConstants.FILTER)
    public void setFilter(ReadableArray readableArray) {
        double d;
        int i;
        if (this.mView == null) {
            return;
        }
        if (readableArray == null || readableArray.size() != 3) {
            d = 0.0d;
            i = 0;
        } else {
            i = readableArray.getInt(0);
            d = readableArray.getDouble(1);
        }
        if (i == 0) {
            this.mView.setLayerType(0, null);
            T t = this.mView;
            if (t instanceof AndroidView) {
                ((AndroidView) t).removeBlur();
            }
            this.mGrayscaleAmount = 1.0f;
            return;
        }
        if (i != 1) {
            if (i != 2) {
                return;
            }
            T t2 = this.mView;
            if (t2 instanceof AndroidView) {
                ((AndroidView) t2).setBlur((float) d);
                return;
            }
            return;
        }
        float doubleValue = (float) ((Double) UnitUtils.clamp(Double.valueOf(1.0d - d), Double.valueOf(0.0d), Double.valueOf(1.0d))).doubleValue();
        if (FloatUtils.floatsEqual(this.mGrayscaleAmount, doubleValue)) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(doubleValue);
        Paint paint = new Paint(1);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        this.mView.setLayerType(2, paint);
        this.mGrayscaleAmount = doubleValue;
    }

    public boolean hasAnimationRunning() {
        TransitionAnimationManager transitionAnimationManager;
        T t;
        KeyframeManager keyframeManager = this.mKeyframeManager;
        return (keyframeManager != null && keyframeManager.hasAnimationRunning()) || ((transitionAnimationManager = this.mTransitionAnimator) != null && transitionAnimationManager.hasAnimationRunning()) || !((t = this.mView) == null || t.getAnimation() == null);
    }

    public boolean hasTranslateDiff(ReadableArray readableArray) {
        List<TransformRaw> transformRaw = TransformRaw.toTransformRaw(readableArray);
        return (Float.compare(TransformRaw.hasXValue(this.mTransformRaw), TransformRaw.hasXValue(transformRaw)) != 0) || (Float.compare(TransformRaw.hasYValue(this.mTransformRaw), TransformRaw.hasYValue(transformRaw)) != 0);
    }

    public boolean isRtl() {
        return this.mLynxDirection == 2;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean isUserInteractionEnabled() {
        T t;
        return this.userInteractionEnabled && (t = this.mView) != null && t.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updatePerspectiveToView() {
        float width;
        float f;
        float f2;
        double d;
        int latestHeight;
        double d2;
        float f3 = this.mContext.getScreenMetrics().density;
        if (this.mPerspective != null && this.mPerspective.size() > 1 && this.mPerspective.getInt(1) != 3) {
            if (this.mPerspective.getInt(1) == 0) {
                double d3 = f3;
                f2 = (float) (this.mPerspective.getDouble(0) * d3 * d3 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                if (this.mPrePerspectiveValue == f2) {
                    this.mPrePerspectiveValue = f2;
                    this.mView.setCameraDistance(f2);
                    return;
                }
                return;
            }
            if ((this.mPerspective.getInt(1) == 1 || this.mPerspective.getInt(1) == 2) && this.mContext.getUIBody() != null) {
                if (this.mPerspective.getInt(1) == 1) {
                    d = this.mPerspective.getDouble(0) / 100.0d;
                    latestHeight = this.mContext.getUIBody().getLatestWidth();
                } else {
                    d = this.mPerspective.getDouble(0) / 100.0d;
                    latestHeight = this.mContext.getUIBody().getLatestHeight();
                }
                d2 = d * latestHeight;
            } else {
                d2 = this.mPerspective.getDouble(0);
            }
            width = ((float) d2) * f3;
            f = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        } else {
            width = (getWidth() > getHeight() ? getWidth() : getHeight()) * f3 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            f = 100.0f;
        }
        f2 = f * width;
        if (this.mPrePerspectiveValue == f2) {
        }
    }

    @LynxProp(name = "clip-path")
    public void setClipPath(ReadableArray readableArray) {
        this.mClipPath = BasicShape.CreateFromReadableArray(readableArray, this.mContext.getScreenMetrics().scaledDensity);
    }

    @LynxProp(name = PropsConstants.OFFSET_PATH)
    public void setOffsetPath(ReadableArray readableArray) {
        if (this.mRawOffsetShape != readableArray) {
            this.mRawOffsetShape = readableArray;
            this.mOffsetPath = BasicShape.CreateFromReadableArray(readableArray, this.mContext.getScreenMetrics().scaledDensity);
            this.mOffsetHasChanged = true;
        }
    }

    @LynxProp(name = PropsConstants.OFFSET_DISTANCE)
    public void setOffsetDistance(float f) {
        if (this.mOffsetDistance != f) {
            this.mOffsetDistance = f;
            this.mOffsetHasChanged = true;
        }
    }

    @LynxProp(name = PropsConstants.OFFSET_ROTATE)
    public void setOffsetRotate(float f) {
        if (this.mOffsetRotate != f) {
            this.mOffsetRotate = f;
            this.mOffsetHasChanged = true;
            if (f != OFFSET_ROTATE_AUTO) {
                this.mIsAutoOffsetRotate = false;
            } else {
                this.mIsAutoOffsetRotate = true;
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        TransitionAnimationManager transitionAnimationManager = this.mTransitionAnimator;
        if (transitionAnimationManager != null) {
            transitionAnimationManager.onDestroy();
        }
        KeyframeManager keyframeManager = this.mKeyframeManager;
        if (keyframeManager != null) {
            keyframeManager.onDestroy();
        }
    }

    private void saveKeyframeStateToStorage(String str, LynxBaseUI lynxBaseUI, boolean z) {
        if (!this.mEnableReuseAnimationState || TextUtils.isEmpty(str)) {
            return;
        }
        if ((!z || this.mKeyframeManager == null) && z) {
            return;
        }
        String str2 = "Animation_" + constructListStateCacheKey(getTagName(), str, getIdSelector());
        if (!z) {
            lynxBaseUI.removeKeyFromNativeStorage(str2);
        } else {
            lynxBaseUI.storeKeyToNativeStorage(str2, this.mKeyframeManager);
        }
        KeyframeManager keyframeManager = this.mKeyframeManager;
        if (keyframeManager != null) {
            keyframeManager.detachFromUI();
        }
        this.mKeyframeManager = null;
    }

    private void restoreKeyframeStateFromStorage(String str, UIList uIList) {
        if (!this.mEnableReuseAnimationState || TextUtils.isEmpty(str) || this.mAnimationInfos == null) {
            return;
        }
        String str2 = "Animation_" + constructListStateCacheKey(getTagName(), str, getIdSelector());
        KeyframeManager keyframeManager = (KeyframeManager) uIList.nativeListStateCache.get(str2);
        if (keyframeManager != null) {
            uIList.nativeListStateCache.remove(str2);
            KeyframeManager keyframeManager2 = this.mKeyframeManager;
            if (keyframeManager2 != null) {
                keyframeManager2.detachFromUI();
                this.mKeyframeManager = null;
            }
            keyframeManager.attachToUI(this);
            this.mKeyframeManager = keyframeManager;
        } else {
            prepareKeyframeManager();
        }
        this.mKeyframeManager.setAnimations(this.mAnimationInfos);
        this.mKeyframeManager.notifyAnimationUpdated();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onListCellDisAppear(String str, LynxBaseUI lynxBaseUI, boolean z) {
        super.onListCellDisAppear(str, lynxBaseUI, z);
        saveKeyframeStateToStorage(str, lynxBaseUI, z);
    }

    public void onListCellAppear(String str, UIList uIList) {
        super.onListCellAppear(str, (LynxBaseUI) uIList);
        restoreKeyframeStateFromStorage(str, uIList);
    }
}
