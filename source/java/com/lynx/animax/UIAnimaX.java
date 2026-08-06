package com.lynx.animax;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.hms.android.SystemUtils;
import com.lynx.animax.ability.LynxAbility;
import com.lynx.animax.base.AnimaXError;
import com.lynx.animax.loader.LynxHttpAnimaXLoader;
import com.lynx.animax.monitor.AnimaXMonitorUtil;
import com.lynx.animax.monitor.LynxAnimaXMonitorDefault;
import com.lynx.animax.p034ui.AnimaXContainerView;
import com.lynx.animax.p034ui.AnimaXContext;
import com.lynx.animax.p034ui.AnimaXImageView;
import com.lynx.animax.p034ui.AnimaXView;
import com.lynx.animax.p034ui.IAnimaXView;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.service.IAnimaXResourceFactoryService;
import com.lynx.animax.setter.UIAnimaXPropsPrioritySetter;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.DeviceUtil;
import com.lynx.animax.util.UIPropertyUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ForegroundListener;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.LynxUIHelper;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UIAnimaX extends LynxUI<View> implements ForegroundListener {
    private static final UIAnimaXPropsPrioritySetter.ExecutionPriority RESOURCE_LOAD = UIAnimaXPropsPrioritySetter.ExecutionPriority.LOW;
    private static final UIAnimaXPropsPrioritySetter.ExecutionPriority RESOURCE_SETUP = UIAnimaXPropsPrioritySetter.ExecutionPriority.HIGH;
    private static final String TAG = "UIAnimaX";
    private LynxAbility mAbility;
    private final AnimaXContainerView mAnimaXContainerView;
    private AnimaXPlayer mAnimaXPlayer;
    private IAnimaXView mAnimaXView;
    private final LynxContext mContext;
    private DisplayMode mDisplayMode;
    private boolean mEnableLynxTapLayerEvent;
    private boolean mEnableScreenShot;
    private boolean mHasReportMotionEvent;
    private boolean mIgnoreAttachStatus;
    private boolean mIgnoreLynxLifecycle;
    private boolean mMultiThreadAccelerate;
    private final UIAnimaXPropsPrioritySetter mPropsSetter;
    private String mSrc;
    private String mTag;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum DisplayMode {
        IMAGE(LynxResourceModule.IMAGE_TYPE),
        SURFACE("surface"),
        AUTO("auto");

        private final String value;

        DisplayMode(String str) {
            this.value = str;
        }

        public static DisplayMode fromString(String str) {
            if (str == null) {
                return SURFACE;
            }
            for (DisplayMode displayMode : values()) {
                if (displayMode.value.equals(str)) {
                    return displayMode;
                }
            }
            return SURFACE;
        }
    }

    public UIAnimaX(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIAnimaX(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mPropsSetter = new UIAnimaXPropsPrioritySetter();
        this.mMultiThreadAccelerate = false;
        this.mIgnoreAttachStatus = false;
        this.mDisplayMode = DisplayMode.SURFACE;
        this.mEnableLynxTapLayerEvent = false;
        this.mIgnoreLynxLifecycle = false;
        this.mEnableScreenShot = false;
        this.mHasReportMotionEvent = false;
        this.mContext = lynxContext;
        if (!(this.mView instanceof AnimaXContainerView)) {
            postInitError();
        }
        this.mAnimaXContainerView = (AnimaXContainerView) this.mView;
    }

    private void postInitError() {
        this.mView.post(new Runnable() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                UIAnimaX.this.m2906lambda$postInitError$0$comlynxanimaxUIAnimaX();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$postInitError$0$com-lynx-animax-UIAnimaX, reason: not valid java name */
    public /* synthetic */ void m2906lambda$postInitError$0$comlynxanimaxUIAnimaX() {
        this.mContext.getEventEmitter().sendCustomEvent(new LynxCustomEvent(getSign(), "error", AnimaXError.createBlockErrorParam()) { // from class: com.lynx.animax.UIAnimaX.1
            public String paramsName() {
                return "detail";
            }
        });
    }

    protected View createView(Context context) {
        if (!(context instanceof LynxContext)) {
            LLog.m2577e(TAG, "context is not LynxContext, create AnimaXView fail");
            return new View(context);
        }
        this.mAbility = new LynxAbility(this, (LynxContext) context);
        return new AnimaXContainerView(context);
    }

    public boolean dispatchTouch(MotionEvent motionEvent) {
        if (this.mEnableLynxTapLayerEvent && this.mAnimaXView != null && isUserInteractionEnabled() && motionEvent.getAction() == 0) {
            RectF convertRectFromUIToScreen = LynxUIHelper.convertRectFromUIToScreen(this, new RectF(0.0f, 0.0f, getWidth(), getHeight()));
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            float rawX = motionEvent.getRawX() - convertRectFromUIToScreen.left;
            float rawY = motionEvent.getRawY() - convertRectFromUIToScreen.top;
            if (this.mAnimaXContainerView == null) {
                obtain.setLocation(rawX, rawY);
            } else {
                obtain.setLocation(rawX - r0.getPaddingLeft(), rawY - this.mAnimaXContainerView.getPaddingTop());
            }
            this.mAnimaXView.handleTouchEvent(obtain);
        }
        return super.dispatchTouch(motionEvent);
    }

    public void destroy() {
        super.destroy();
        AnimaXLog.m2541i(TAG, "UIAnimaX destroy");
        IAnimaXView iAnimaXView = this.mAnimaXView;
        if (iAnimaXView != null) {
            iAnimaXView.release();
        } else {
            AnimaXPlayer animaXPlayer = this.mAnimaXPlayer;
            if (animaXPlayer != null) {
                animaXPlayer.release();
            }
        }
        this.mAnimaXView = null;
        this.mAnimaXPlayer = null;
    }

    public void onNodeReload() {
        super.onNodeReload();
        AnimaXPlayer animaXPlayer = this.mAnimaXPlayer;
        if (animaXPlayer != null) {
            animaXPlayer.reload();
        }
    }

    private void createAnimaXPlayer() {
        if (this.mAbility == null) {
            return;
        }
        AnimaXContext build = new AnimaXContext.Builder(this.mAbility, this.mContext.getContext()).multiThreadAccelerate(this.mMultiThreadAccelerate).build();
        this.mAbility.registerService(IAnimaXMonitorService.class, new LynxAnimaXMonitorDefault(this.mContext));
        this.mAbility.registerService(IAnimaXResourceFactoryService.class, new IAnimaXResourceFactoryService() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda10
            @Override // com.lynx.animax.service.IAnimaXResourceFactoryService
            public final List createAnimaXLoaders() {
                return UIAnimaX.this.m2905lambda$createAnimaXPlayer$1$comlynxanimaxUIAnimaX();
            }
        });
        AnimaXPlayer animaXPlayer = new AnimaXPlayer(build);
        this.mAnimaXPlayer = animaXPlayer;
        this.mPropsSetter.init(animaXPlayer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$createAnimaXPlayer$1$com-lynx-animax-UIAnimaX, reason: not valid java name */
    public /* synthetic */ List m2905lambda$createAnimaXPlayer$1$comlynxanimaxUIAnimaX() {
        return Collections.singletonList(new LynxHttpAnimaXLoader(this.mAbility, this.mContext));
    }

    private void createAnimaXView() {
        LynxAbility lynxAbility = this.mAbility;
        if (lynxAbility == null || this.mContext == null) {
            LLog.m2577e(TAG, "LynxAbility or LynxContext is not created");
            postInitError();
            return;
        }
        if (this.mAnimaXContainerView == null) {
            LLog.m2577e(TAG, "AnimaXContainerView is not created");
            postInitError();
            return;
        }
        if (this.mAnimaXPlayer == null) {
            LLog.m2577e(TAG, "AnimaXPlayer is not created");
            postInitError();
            return;
        }
        if (!DeviceUtil.checkCapability(lynxAbility)) {
            LLog.m2577e(TAG, "Device is not support, create AnimaXView fail");
            postInitError();
            return;
        }
        if (this.mDisplayMode == DisplayMode.IMAGE || (this.mDisplayMode == DisplayMode.AUTO && DeviceUtil.shouldUseImageViewByTag(this.mAbility, this.mTag))) {
            AnimaXLog.m2541i(TAG, "create AnimaXImageView");
            this.mAbility.getMonitorDelegate().setDisplayMode(DisplayMode.IMAGE.value);
            AnimaXImageView animaXImageView = new AnimaXImageView(this.mAnimaXPlayer);
            this.mAnimaXView = animaXImageView;
            this.mAnimaXContainerView.addChildAnimaXView(animaXImageView, null);
        } else {
            AnimaXLog.m2541i(TAG, "create AnimaXView");
            this.mAbility.getMonitorDelegate().setDisplayMode(DisplayMode.SURFACE.value);
            AnimaXView animaXView = new AnimaXView(this.mAnimaXPlayer);
            this.mAnimaXView = animaXView;
            this.mAnimaXContainerView.addChildAnimaXView(animaXView, new AnimaXContainerView.IDispatchDrawHook() { // from class: com.lynx.animax.UIAnimaX.2
                @Override // com.lynx.animax.ui.AnimaXContainerView.IDispatchDrawHook
                public void beforeDispatchDraw(Canvas canvas) {
                    UIAnimaX.this.tryToAddClip(canvas);
                }

                @Override // com.lynx.animax.ui.AnimaXContainerView.IDispatchDrawHook
                public boolean useBitmapOnDraw() {
                    return UIAnimaX.this.mEnableScreenShot;
                }
            });
        }
        this.mAnimaXView.setEnableTapLayerEvent(false);
        this.mAnimaXView.setIgnoreAttachStatus(this.mIgnoreAttachStatus);
    }

    @LynxProp(name = "tag")
    public void setTag(String str) {
        this.mTag = str;
        this.mAbility.getMonitorDelegate().setTag(str);
    }

    @LynxProp(name = "display-mode")
    public void setDisplayMode(String str) {
        this.mDisplayMode = DisplayMode.fromString(str);
    }

    @LynxProp(defaultBoolean = com.example.memorycollector.BuildConfig.ONLINE, name = "multi-thread-accelerate")
    public void setMultiThreadAccelerate(boolean z) {
        this.mMultiThreadAccelerate = z;
    }

    @LynxProp(name = "android-enable-screenshot")
    public void setEnableScreenshot(boolean z) {
        this.mEnableScreenShot = z;
    }

    @LynxProp(defaultBoolean = com.example.memorycollector.BuildConfig.ONLINE, name = "autoplay")
    public void setAutoPlay(final boolean z) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda11
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                UIAnimaX.lambda$setAutoPlay$2(z, animaXPlayer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setAutoPlay$2(boolean z, AnimaXPlayer animaXPlayer) throws Exception {
        animaXPlayer.setAutoPlay(z);
        if (z) {
            animaXPlayer.play();
        }
    }

    @LynxProp(name = "speed")
    public void setSpeed(final float f) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda15
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setSpeed(f);
            }
        });
    }

    @LynxProp(name = "progress")
    public void setProgress(final float f) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda19
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setProgress(f);
            }
        });
    }

    @LynxProp(name = "objectfit")
    public void setObjectFit(final String str) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda8
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setObjectFit(UIPropertyUtil.convertStringToObjectFit(str));
            }
        });
    }

    @LynxProp(name = "object-position")
    public void setObjectPosition(final String str) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda1
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setObjectPosition(UIPropertyUtil.convertStringToObjectPosition(str));
            }
        });
    }

    @LynxProp(defaultBoolean = com.example.memorycollector.BuildConfig.ONLINE, name = "keeplastframe")
    public void setKeepLastFrame(final boolean z) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda2
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setKeepLastFrame(z);
            }
        });
    }

    @LynxProp(defaultBoolean = false, name = "ignore-attach-status")
    public void setIgnoreAttachStatus(boolean z) {
        IAnimaXView iAnimaXView = this.mAnimaXView;
        if (iAnimaXView != null) {
            iAnimaXView.setIgnoreAttachStatus(z);
        } else {
            this.mIgnoreAttachStatus = z;
        }
    }

    private void setViewTag(String str) {
        if (this.mSrc != null || this.mContext == null || this.mView == null) {
            return;
        }
        if (str == null) {
            str = SystemUtils.UNKNOWN;
        } else {
            this.mSrc = str;
        }
        this.mView.setTag("url: " + AnimaXMonitorUtil.clearUrlQuery(this.mContext.getTemplateUrl()) + ", src: " + str);
    }

    @LynxProp(name = "json")
    public void setJson(final String str) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda14
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                UIAnimaX.this.m2907lambda$setJson$8$comlynxanimaxUIAnimaX(str, animaXPlayer);
            }
        }, RESOURCE_LOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setJson$8$com-lynx-animax-UIAnimaX, reason: not valid java name */
    public /* synthetic */ void m2907lambda$setJson$8$comlynxanimaxUIAnimaX(String str, AnimaXPlayer animaXPlayer) throws Exception {
        animaXPlayer.setJson(str);
        setViewTag("json");
        reportMotionEvent("json");
    }

    @LynxProp(name = "src")
    public void setSrc(final String str) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda17
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                UIAnimaX.this.m2908lambda$setSrc$9$comlynxanimaxUIAnimaX(str, animaXPlayer);
            }
        }, RESOURCE_LOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setSrc$9$com-lynx-animax-UIAnimaX, reason: not valid java name */
    public /* synthetic */ void m2908lambda$setSrc$9$comlynxanimaxUIAnimaX(String str, AnimaXPlayer animaXPlayer) throws Exception {
        animaXPlayer.setSrc(str);
        setViewTag(str);
        reportMotionEvent(str);
    }

    @LynxProp(defaultBoolean = false, name = "loop")
    public void setLoop(final boolean z) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda6
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setLoop(z);
            }
        });
    }

    @LynxProp(defaultInt = 1, name = "loop-count")
    public void setLoopCount(final int i) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda9
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setLoopCount(i);
            }
        });
    }

    @LynxProp(name = "src-format")
    public void setSrcFormat(final String str) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda13
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                UIAnimaX.this.m2909lambda$setSrcFormat$12$comlynxanimaxUIAnimaX(str, animaXPlayer);
            }
        }, RESOURCE_LOAD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setSrcFormat$12$com-lynx-animax-UIAnimaX, reason: not valid java name */
    public /* synthetic */ void m2909lambda$setSrcFormat$12$comlynxanimaxUIAnimaX(String str, AnimaXPlayer animaXPlayer) throws Exception {
        animaXPlayer.setSrc(str);
        setViewTag(str);
        reportMotionEvent(str);
    }

    @LynxProp(name = "src-polyfill")
    public void setSrcPolyfill(final ReadableMap readableMap) {
        if (readableMap instanceof JavaOnlyMap) {
            this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda3
                @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
                public final void run(AnimaXPlayer animaXPlayer) {
                    UIAnimaX.this.m2910lambda$setSrcPolyfill$13$comlynxanimaxUIAnimaX(readableMap, animaXPlayer);
                }
            }, RESOURCE_SETUP);
        } else {
            AnimaXLog.m2540e(TAG, "setSrcPolyfill fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setSrcPolyfill$13$com-lynx-animax-UIAnimaX, reason: not valid java name */
    public /* synthetic */ void m2910lambda$setSrcPolyfill$13$comlynxanimaxUIAnimaX(ReadableMap readableMap, AnimaXPlayer animaXPlayer) throws Exception {
        animaXPlayer.setSrcPolyfill(adaptMap((JavaOnlyMap) readableMap));
    }

    private com.lynx.animax.base.bridge.JavaOnlyMap adaptMap(JavaOnlyMap javaOnlyMap) {
        com.lynx.animax.base.bridge.JavaOnlyMap javaOnlyMap2 = new com.lynx.animax.base.bridge.JavaOnlyMap();
        for (Map.Entry<String, Object> entry : javaOnlyMap.asHashMap().entrySet()) {
            if (entry.getValue() instanceof String) {
                javaOnlyMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return javaOnlyMap2;
    }

    @LynxProp(defaultInt = 0, name = "start-frame")
    public void setStartFrame(final int i) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda21
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setStartFrame(i);
            }
        });
    }

    @LynxProp(defaultInt = -1, name = "end-frame")
    public void setEndFrame(final int i) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda18
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setEndFrame(i);
            }
        });
    }

    @LynxProp(defaultBoolean = false, name = "auto-reverse")
    public void setReverseMode(final boolean z) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda16
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setAutoReverse(z);
            }
        });
    }

    @LynxProp(name = "anti-aliasing")
    public void setAntiAliasing(final String str) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda5
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                String str2 = str;
                animaXPlayer.setAntiAliasing(!"none".equals(str2));
            }
        });
    }

    @LynxProp(name = "fps-event-interval")
    public void setFpsEventInterval(final int i) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda20
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setFpsEventInterval(i);
            }
        });
    }

    @LynxProp(name = "max-frame-rate")
    public void setMaxFrameRate(final double d) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda0
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setMaxFrameRate(d);
            }
        });
    }

    @LynxProp(name = "dynamic-resource")
    public void setDynamicResource(final boolean z) {
        this.mPropsSetter.enqueueTask(new UIAnimaXPropsPrioritySetter.PlayerTask() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda7
            @Override // com.lynx.animax.setter.UIAnimaXPropsPrioritySetter.PlayerTask
            public final void run(AnimaXPlayer animaXPlayer) {
                animaXPlayer.setDynamicResource(z);
            }
        }, RESOURCE_SETUP);
    }

    @LynxProp(name = "video-frame-timeout")
    public void setVideoFrameTimeout(int i) {
        LynxAbility lynxAbility = this.mAbility;
        if (lynxAbility != null) {
            lynxAbility.getVideoPlayerConfig().setVideoFrameTimeout(i);
        }
    }

    @LynxProp(defaultBoolean = false, name = "ignore-lynx-lifecycle")
    public void setIgnoreLynxLifecycle(boolean z) {
        this.mIgnoreLynxLifecycle = z;
    }

    public void setEvents(Map<String, EventsListener> map) {
        super.setEvents(map);
        this.mEnableLynxTapLayerEvent = map != null && map.containsKey("taplayers");
    }

    public void updatePropertiesInterval(StylesDiffMap stylesDiffMap) {
        super.updatePropertiesInterval(stylesDiffMap);
        if (this.mAnimaXPlayer == null) {
            createAnimaXPlayer();
        }
        if (this.mAnimaXView == null) {
            createAnimaXView();
        }
        this.mPropsSetter.flush();
    }

    public void play(ReadableMap readableMap, Callback callback) {
        AnimaXPlayer animaXPlayer = this.mAnimaXPlayer;
        if (animaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        animaXPlayer.play();
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void pause(ReadableMap readableMap, Callback callback) {
        AnimaXPlayer animaXPlayer = this.mAnimaXPlayer;
        if (animaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        animaXPlayer.pause();
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void resume(ReadableMap readableMap, Callback callback) {
        AnimaXPlayer animaXPlayer = this.mAnimaXPlayer;
        if (animaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        animaXPlayer.resume();
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void stop(ReadableMap readableMap, Callback callback) {
        AnimaXPlayer animaXPlayer = this.mAnimaXPlayer;
        if (animaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        animaXPlayer.stop();
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void getDuration(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
        } else if (callback != null) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putDouble("data", this.mAnimaXPlayer.getDurationMs());
            callback.invoke(0, javaOnlyMap);
        }
    }

    public void isAnimating(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
        } else if (callback != null) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putBoolean("data", this.mAnimaXPlayer.isAnimating());
            callback.invoke(0, javaOnlyMap);
        }
    }

    public void listenAnimationUpdate(ReadableMap readableMap, Callback callback) {
        LynxAbility lynxAbility = this.mAbility;
        if (lynxAbility == null) {
            invokeErrorCallback(callback);
            return;
        }
        if (readableMap != null) {
            lynxAbility.setListenUpdate(readableMap.getBoolean("isListen"));
        }
        if (callback != null) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putBoolean("data", this.mAbility.getListenUpdate());
            callback.invoke(0, javaOnlyMap);
        }
    }

    public void seek(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        this.mAnimaXPlayer.seek(readableMap.getInt("frame"));
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void subscribeUpdateEvent(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        this.mAnimaXPlayer.subscribeUpdateEvent(readableMap.getInt("frame"));
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void unsubscribeUpdateEvent(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        this.mAnimaXPlayer.unsubscribeUpdateEvent(readableMap.getInt("frame"));
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void subscribeUpdateEvents(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        int[] framesFromParams = getFramesFromParams(readableMap);
        if (framesFromParams == null) {
            invokeErrorCallback(callback);
            return;
        }
        this.mAnimaXPlayer.subscribeUpdateEvents(framesFromParams, true);
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void unsubscribeUpdateEvents(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        int[] framesFromParams = getFramesFromParams(readableMap);
        if (framesFromParams == null) {
            invokeErrorCallback(callback);
            return;
        }
        this.mAnimaXPlayer.subscribeUpdateEvents(framesFromParams, false);
        if (callback != null) {
            callback.invoke(0);
        }
    }

    public void getCurrentFrame(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
        } else if (callback != null) {
            callback.invoke(0, Double.valueOf(this.mAnimaXPlayer.getCurrentFrame()));
        }
    }

    public void playSegment(ReadableMap readableMap, Callback callback) {
        if (this.mAnimaXPlayer == null) {
            invokeErrorCallback(callback);
            return;
        }
        int i = readableMap.getInt("startFrame");
        int i2 = readableMap.getInt("endFrame");
        if (i2 > 0 && i > i2) {
            invokeErrorCallback(callback, "startFrame and endFrame are not valid!");
            return;
        }
        this.mAnimaXPlayer.playSegment(i, i2);
        if (callback != null) {
            callback.invoke(0);
        }
    }

    private void invokeErrorCallback(Callback callback) {
        invokeErrorCallback(callback, "animax view is not inited.");
    }

    private void invokeErrorCallback(Callback callback, String str) {
        if (callback != null) {
            callback.invoke(1, str);
        }
    }

    private int[] getFramesFromParams(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray("frames");
        if (array == null) {
            return null;
        }
        int[] iArr = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            iArr[i] = array.getInt(i);
        }
        return iArr;
    }

    public void onLynxViewEnterForeground() {
        AnimaXPlayer animaXPlayer;
        if (this.mIgnoreLynxLifecycle || (animaXPlayer = this.mAnimaXPlayer) == null) {
            return;
        }
        animaXPlayer.enterForeground();
    }

    public void onLynxViewEnterBackground() {
        AnimaXPlayer animaXPlayer;
        if (this.mIgnoreLynxLifecycle || (animaXPlayer = this.mAnimaXPlayer) == null) {
            return;
        }
        animaXPlayer.enterBackground();
    }

    private void reportMotionEvent(final String str) {
        LynxContext lynxContext;
        if (str == null || str.isEmpty() || (lynxContext = this.mContext) == null || !lynxContext.enableEventReporter() || this.mHasReportMotionEvent || !enableMotionEventReport()) {
            return;
        }
        this.mHasReportMotionEvent = true;
        LynxEventReporter.onEvent("lynxsdk_motion_ui_event", this.mContext.getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.animax.UIAnimaX$$ExternalSyntheticLambda4
            public final Map build() {
                return UIAnimaX.lambda$reportMotionEvent$21(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$reportMotionEvent$21(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("component_name", "animax-view");
        hashMap.put("src", str);
        return hashMap;
    }

    private boolean enableMotionEventReport() {
        ILynxTrailService service = LynxServiceCenter.inst().getService(ILynxTrailService.class);
        if (service == null) {
            return false;
        }
        return "true".equals(service.stringValueForTrailKey("enable_motion_ui_report"));
    }

    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        if (this.mAnimaXContainerView == null || this.mAnimaXView == null) {
            return;
        }
        this.mAnimaXContainerView.setPadding(getBorderLeftWidth() + getPaddingLeft(), getBorderTopWidth() + getPaddingTop(), getBorderRightWidth() + getPaddingRight(), getBorderBottomWidth() + getPaddingBottom());
        this.mAnimaXView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToAddClip(Canvas canvas) {
        BackgroundDrawable drawable = getLynxBackground() != null ? getLynxBackground().getDrawable() : null;
        if (drawable == null) {
            return;
        }
        Path innerClipPathForBorderRadius = drawable.getInnerClipPathForBorderRadius();
        if (innerClipPathForBorderRadius != null) {
            canvas.clipPath(innerClipPathForBorderRadius);
        } else {
            if (getSkewX() == 0.0f && getSkewY() == 0.0f) {
                return;
            }
            canvas.clipRect(getClipBounds());
        }
    }
}
