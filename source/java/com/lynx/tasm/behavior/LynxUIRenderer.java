package com.lynx.tasm.behavior;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.devtoolwrapper.DevToolOverlayDelegate;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.PageConfig;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxPageLoadListener;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.behavior.render.NativePaintingContext;
import com.lynx.tasm.behavior.shadow.LayoutTick;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.performance.longtasktiming.LynxLongTaskMonitor;
import com.lynx.tasm.utils.UnitUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIRenderer implements ILynxUIRenderer {
    protected static final String TAG = "LynxUIRenderer";
    private static HandlerThread mPixelCopyHandlerThread;
    private static final Object mSyncObject = new Object();
    private boolean mEnableFiberArc;
    private boolean mEnableMultiTouch;
    private boolean mEnableNewGesture;
    private TouchEventDispatcher mEventDispatcher;
    private boolean mHasInited;
    private boolean mIsUpdatedConfig;
    private LynxBooleanOption mLongTaskMonitorEnabled;
    private WeakReference<LynxContext> mLynxContext;
    private LynxUIOwner mLynxUIOwner;
    private IPaintingContext mPaintingContext;
    private ShadowNodeOwner mShadowNodeOwner;
    private long mNativeUIDelegatePtr = 0;
    private String mScreenshotMode = "fullscreen";
    private String mTapSlop = TouchEventDispatcher.mTapSlopDefault;

    private static native long nativeCreateUIDelegate(long j, long j2);

    private static native void nativeDestroyUIDelegate(long j);

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean disableBindDrawChildHook() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean enableTimingCollector() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public ThreadStrategyForRendering getSupportedThreadStrategy(ThreadStrategyForRendering threadStrategyForRendering) {
        return threadStrategyForRendering;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean isAccessibilityDisabled() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean needHandleDispatchKeyEvent() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onEnterBackground() {
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onEnterForeground() {
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onInitBodyView(UIBody.UIBodyView uIBodyView, Context context, LynxGroup lynxGroup) {
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onReloadAndInitUIThreadPart() {
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean shouldInvokeNativeViewMethod() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean useInvokeUIMethod() {
        return false;
    }

    private int getInstanceId() {
        LynxContext lynxContext = this.mLynxContext.get();
        if (lynxContext != null) {
            return lynxContext.getInstanceId();
        }
        return -1;
    }

    public static synchronized void startPixelCopyHandlerThreadIfNecessary() {
        synchronized (LynxUIRenderer.class) {
            if (mPixelCopyHandlerThread == null && LynxEnv.inst().isLynxDebugEnabled()) {
                HandlerThread handlerThread = new HandlerThread("PixelCopier");
                mPixelCopyHandlerThread = handlerThread;
                handlerThread.start();
            }
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onInitLynxTemplateRender(LynxContext lynxContext, BehaviorRegistry behaviorRegistry, UIBody.UIBodyView uIBodyView, LynxBooleanOption lynxBooleanOption) {
        if (!this.mHasInited) {
            this.mLynxUIOwner = new LynxUIOwner(lynxContext, behaviorRegistry, uIBodyView);
        } else {
            this.mLynxUIOwner.attachLynxContext(lynxContext);
            this.mLynxUIOwner.attachUIBodyView(uIBodyView);
        }
        if (uIBodyView == null) {
            this.mLynxUIOwner.setContextFree(true);
        }
        lynxContext.setLynxUIOwner(this.mLynxUIOwner);
        lynxContext.setUIBody(this.mLynxUIOwner.getRootUI());
        lynxContext.setUIBodyView(uIBodyView);
        this.mLynxContext = new WeakReference<>(lynxContext);
        this.mLongTaskMonitorEnabled = lynxBooleanOption;
        startPixelCopyHandlerThreadIfNecessary();
        this.mHasInited = true;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void attachBodyView(UIBody.UIBodyView uIBodyView, LynxContext lynxContext, Context context) {
        if (lynxContext != null) {
            this.mLynxContext = new WeakReference<>(lynxContext);
            lynxContext.setLynxUIOwner(this.mLynxUIOwner);
            lynxContext.setUIBody(this.mLynxUIOwner.getRootUI());
            lynxContext.setBaseContext(context);
            lynxContext.setUIBodyView(uIBodyView);
            TouchEventDispatcher touchEventDispatcher = this.mEventDispatcher;
            if (touchEventDispatcher != null) {
                touchEventDispatcher.attachContext(context);
                lynxContext.setTouchEventDispatcher(this.mEventDispatcher);
            }
        }
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.attachLynxContext(lynxContext);
            this.mLynxUIOwner.attachUIBodyView(uIBodyView);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void attachNativeFacade(NativeFacade nativeFacade) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.attachNativeFacade(nativeFacade);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onCreateTemplateRenderer(LynxContext lynxContext, LynxPageLoadListener lynxPageLoadListener, ThreadStrategyForRendering threadStrategyForRendering, BehaviorRegistry behaviorRegistry, LayoutTick layoutTick) {
        IPaintingContext paintingContext;
        if (this.mLynxUIOwner == null) {
            return;
        }
        if (this.mPaintingContext == null) {
            if (lynxContext.isFragmentLayerRenderOn()) {
                paintingContext = new NativePaintingContext(this.mLynxUIOwner.getRootUI().getBodyView(), lynxContext);
            } else {
                paintingContext = new PaintingContext(this.mLynxUIOwner, threadStrategyForRendering.id());
            }
            this.mPaintingContext = paintingContext;
        }
        if (this.mShadowNodeOwner == null) {
            this.mShadowNodeOwner = new ShadowNodeOwner(lynxContext, behaviorRegistry, layoutTick);
        }
        lynxContext.setShadowNodeOwner(this.mShadowNodeOwner);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public long getUIDelegatePtr() {
        if (this.mNativeUIDelegatePtr == 0) {
            IPaintingContext iPaintingContext = this.mPaintingContext;
            long nativePaintingContextPtr = iPaintingContext != null ? iPaintingContext.getNativePaintingContextPtr() : 0L;
            ShadowNodeOwner shadowNodeOwner = this.mShadowNodeOwner;
            long nativeLayoutContextPtr = shadowNodeOwner != null ? shadowNodeOwner.getNativeLayoutContextPtr() : 0L;
            if (nativePaintingContextPtr != 0 && nativeLayoutContextPtr != 0) {
                this.mNativeUIDelegatePtr = nativeCreateUIDelegate(nativePaintingContextPtr, nativeLayoutContextPtr);
            }
        }
        return this.mNativeUIDelegatePtr;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public DisplayMetrics getScreenMetrics() {
        ShadowNodeOwner shadowNodeOwner = this.mShadowNodeOwner;
        if (shadowNodeOwner != null) {
            return shadowNodeOwner.getScreenMetrics();
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onReloadAndInitAnyThreadPart() {
        TouchEventDispatcher touchEventDispatcher = this.mEventDispatcher;
        if (touchEventDispatcher != null) {
            touchEventDispatcher.destroy();
        }
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.reset();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onPageConfigDecoded(PageConfig pageConfig) {
        LynxView lynxView;
        LynxViewBuilder lynxViewBuilder;
        this.mIsUpdatedConfig = true;
        if (!TouchEventDispatcher.mTapSlopDefault.equals(pageConfig.getTapSlop())) {
            this.mTapSlop = pageConfig.getTapSlop();
        } else {
            WeakReference<LynxContext> weakReference = this.mLynxContext;
            LynxContext lynxContext = weakReference != null ? weakReference.get() : null;
            if (lynxContext != null && (lynxView = lynxContext.getLynxView()) != null && (lynxViewBuilder = lynxView.getLynxViewBuilder()) != null) {
                this.mTapSlop = lynxViewBuilder.getTapSlop();
            }
        }
        this.mEnableMultiTouch = pageConfig.getEnableMultiTouch();
        this.mEnableFiberArc = pageConfig.getEnableFiberArc();
        boolean isEnableNewGesture = pageConfig.isEnableNewGesture();
        this.mEnableNewGesture = isEnableNewGesture;
        if (isEnableNewGesture && LynxLiteConfigs.enableNewGesture()) {
            WeakReference<LynxContext> weakReference2 = this.mLynxContext;
            this.mLynxUIOwner.initGestureArenaManager(weakReference2 != null ? weakReference2.get() : null);
        }
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner == null || lynxUIOwner.getRootUI() == null) {
            return;
        }
        this.mLynxUIOwner.getRootUI().onPageConfigDecoded(pageConfig);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onDestroyTemplateRenderer() {
        ShadowNodeOwner shadowNodeOwner = this.mShadowNodeOwner;
        if (shadowNodeOwner != null) {
            shadowNodeOwner.destroy();
            this.mShadowNodeOwner = null;
        }
        IPaintingContext iPaintingContext = this.mPaintingContext;
        if (iPaintingContext != null) {
            iPaintingContext.destroy();
            this.mPaintingContext = null;
        }
        long j = this.mNativeUIDelegatePtr;
        if (j != 0) {
            nativeDestroyUIDelegate(j);
            this.mNativeUIDelegatePtr = 0L;
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onDestroy() {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.destroy();
        }
        TouchEventDispatcher touchEventDispatcher = this.mEventDispatcher;
        if (touchEventDispatcher != null) {
            touchEventDispatcher.destroy();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public LynxUIOwner lynxUIOwner() {
        return this.mLynxUIOwner;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public UIGroup<UIBody.UIBodyView> getLynxRootUI() {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            return lynxUIOwner.getRootUI();
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void pauseRootLayoutAnimation() {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.pauseRootLayoutAnimation();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void resumeRootLayoutAnimation() {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.resumeRootLayoutAnimation();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onAttach() {
        UIBody rootUI;
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner == null || (rootUI = lynxUIOwner.getRootUI()) == null) {
            return;
        }
        rootUI.onAttach();
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onDetach() {
        UIBody rootUI;
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner == null || (rootUI = lynxUIOwner.getRootUI()) == null) {
            return;
        }
        rootUI.onDetach();
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onEnterForegroundInternal() {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.onEnterForeground();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onEnterBackgroundInternal() {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.onEnterBackground();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void setContextFree(boolean z) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.setContextFree(z);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void setFirstLayout() {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            lynxUIOwner.setFirstLayout();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public LynxBaseUI findLynxUIByName(String str) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            return lynxUIOwner.findLynxUIByName(str);
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public LynxBaseUI findLynxUIByIdSelector(String str) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            return lynxUIOwner.findLynxUIByIdSelector(str);
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public LynxBaseUI findLynxUIByIndex(int i) {
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            return lynxUIOwner.findLynxUIByIndex(i);
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean onTouchEvent(MotionEvent motionEvent, UIGroup uIGroup) {
        EnsureEventDispatcher();
        TouchEventDispatcher touchEventDispatcher = this.mEventDispatcher;
        if (touchEventDispatcher != null) {
            return touchEventDispatcher.onTouchEvent(motionEvent, uIGroup);
        }
        return false;
    }

    public void EnsureEventDispatcher() {
        if (this.mLynxUIOwner == null || this.mEventDispatcher != null) {
            return;
        }
        TouchEventDispatcher touchEventDispatcher = new TouchEventDispatcher(this.mLynxUIOwner);
        this.mEventDispatcher = touchEventDispatcher;
        touchEventDispatcher.setHasTouchPseudo(this.mLynxUIOwner.getHasTouchPseudo());
        if (this.mIsUpdatedConfig) {
            this.mIsUpdatedConfig = false;
            updateEventDispatcherConfig();
        }
    }

    private void updateEventDispatcherConfig() {
        if (this.mLynxUIOwner.getContext() != null) {
            LynxContext context = this.mLynxUIOwner.getContext();
            context.setTouchEventDispatcher(this.mEventDispatcher);
            String str = this.mTapSlop;
            if (str != null && !str.equals(TouchEventDispatcher.mTapSlopDefault)) {
                this.mEventDispatcher.setTapSlop(UnitUtils.toPxWithDisplayMetrics(str, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, context.getScreenMetrics()));
            }
            this.mEventDispatcher.setHasTouchPseudo(this.mEnableFiberArc);
            this.mEventDispatcher.setEnableMultiTouch(this.mEnableMultiTouch);
            if (this.mEnableNewGesture && LynxLiteConfigs.enableNewGesture()) {
                this.mEventDispatcher.setGestureArenaManager(this.mLynxUIOwner.getGestureArenaManager());
            }
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean consumeSlideEvent(MotionEvent motionEvent) {
        TouchEventDispatcher touchEventDispatcher = this.mEventDispatcher;
        if (touchEventDispatcher != null) {
            return touchEventDispatcher.consumeSlideEvent(motionEvent);
        }
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean blockNativeEvent(MotionEvent motionEvent) {
        TouchEventDispatcher touchEventDispatcher = this.mEventDispatcher;
        if (touchEventDispatcher != null) {
            return touchEventDispatcher.blockNativeEvent(motionEvent);
        }
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void performInnerMeasure(int i, int i2) {
        int rootWidth;
        int rootHeight;
        WeakReference<LynxContext> weakReference = this.mLynxContext;
        LynxContext lynxContext = weakReference != null ? weakReference.get() : null;
        UIBody.UIBodyView uIBodyView = lynxContext != null ? lynxContext.getUIBodyView() : null;
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner == null || uIBodyView == null) {
            LLog.e(TAG, "performInnerMeasure failed, mLynxUIOwner:" + this.mLynxUIOwner + ", bodyView:" + uIBodyView);
            return;
        }
        lynxUIOwner.performMeasure();
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            rootWidth = this.mLynxUIOwner.getRootWidth();
        } else {
            rootWidth = View.MeasureSpec.getSize(i);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            rootHeight = this.mLynxUIOwner.getRootHeight();
        } else {
            rootHeight = View.MeasureSpec.getSize(i2);
        }
        uIBodyView.innerSetMeasuredDimension(rootWidth, rootHeight);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mLynxUIOwner == null) {
            LLog.e(TAG, "onLayout failed, mLynxUIOwner is null");
            return;
        }
        WeakReference<LynxContext> weakReference = this.mLynxContext;
        LynxContext lynxContext = weakReference != null ? weakReference.get() : null;
        if (lynxContext != null) {
            boolean willProcessTask = LynxLongTaskMonitor.willProcessTask("LynxTemplateRender.Layout", lynxContext.getInstanceId(), this.mLongTaskMonitorEnabled);
            this.mLynxUIOwner.performLayout();
            if (willProcessTask) {
                LynxLongTaskMonitor.didProcessTask();
                return;
            }
            return;
        }
        this.mLynxUIOwner.performLayout();
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void scrollIntoViewFromUI(int i) {
        LynxBaseUI node;
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner == null || lynxUIOwner.getRootSign() == -1 || (node = this.mLynxUIOwner.getNode(i)) == null) {
            return;
        }
        node.scrollIntoView(false, "center", "center", null);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public String getActualScreenshotMode() {
        return this.mScreenshotMode;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void takeScreenshot(ScreenshotBitmapHandler screenshotBitmapHandler, String str) {
        Bitmap bitmapOfScreen;
        this.mScreenshotMode = str;
        if (str != null && str.equals("lynxview")) {
            bitmapOfScreen = getBitmapOfView();
        } else {
            bitmapOfScreen = getBitmapOfScreen();
        }
        screenshotBitmapHandler.sendBitmap(bitmapOfScreen);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getParentBackgroundColor(View view) {
        int color;
        if (view == null) {
            return -1;
        }
        try {
            ViewParent viewParent = view.getParent();
            while (viewParent instanceof View) {
                ViewParent parent = viewParent.getParent();
                Drawable background = ((View) viewParent).getBackground();
                if ((background instanceof ColorDrawable) && (color = ((ColorDrawable) background).getColor()) != 0) {
                    return color;
                }
                viewParent = parent;
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void drawViewToBitmap(View view, Bitmap bitmap, Canvas canvas) {
        try {
            if (LynxEnv.inst().isPixelCopyEnabled() && Build.VERSION.SDK_INT >= 26) {
                int[] iArr = new int[2];
                if (Build.VERSION.SDK_INT >= 29) {
                    view.getLocationInSurface(iArr);
                } else {
                    view.getLocationInWindow(iArr);
                }
                Field declaredField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mSurface");
                if (view.getRootView().getParent() == null) {
                    view.draw(canvas);
                    return;
                }
                Surface surface = (Surface) declaredField.get(view.getRootView().getParent());
                Object obj = mSyncObject;
                synchronized (obj) {
                    int i = iArr[0];
                    PixelCopy.request(surface, new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight()), bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.lynx.tasm.behavior.LynxUIRenderer.1
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public void onPixelCopyFinished(int i2) {
                            synchronized (LynxUIRenderer.mSyncObject) {
                                LynxUIRenderer.mSyncObject.notify();
                            }
                        }
                    }, new Handler(mPixelCopyHandlerThread.getLooper()));
                    try {
                        obj.wait(10000L);
                    } catch (InterruptedException e) {
                        LLog.e("DevTool Screenshot", e.toString());
                    }
                }
                return;
            }
            view.draw(canvas);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Bitmap createScreenBitmap(View view) {
        WindowManager windowManager;
        if (view == null || view.getContext() == null || (windowManager = (WindowManager) view.getContext().getSystemService("window")) == null) {
            return null;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return Bitmap.createBitmap(displayMetrics.widthPixels, displayMetrics.heightPixels, Bitmap.Config.ARGB_8888);
    }

    private void drawOverlayViewToScreenCanvas(Canvas canvas, ArrayList<View> arrayList) {
        if (canvas == null || arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            drawViewToBitmap(view, createBitmap, new Canvas(createBitmap));
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            canvas.drawBitmap(createBitmap, (Rect) null, new Rect(i2, iArr[1], view.getWidth() + i2, iArr[1] + view.getHeight()), (Paint) null);
            createBitmap.recycle();
        }
    }

    private Bitmap getBitmapOfScreen() {
        LynxView lynxView = this.mLynxContext.get().getLynxView();
        if (lynxView == null || lynxView.getWidth() <= 0 || lynxView.getHeight() <= 0) {
            if (LynxEnv.inst().isLynxDebugEnabled()) {
                LynxEventReporter.onEvent("lynxsdk_getBitmapOfScreen_lynxView_failed", getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.behavior.LynxUIRenderer$$ExternalSyntheticLambda1
                    @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
                    public final Map build() {
                        return LynxUIRenderer.lambda$getBitmapOfScreen$0();
                    }
                });
            }
            return null;
        }
        Bitmap createScreenBitmap = createScreenBitmap(lynxView);
        if (createScreenBitmap == null) {
            if (LynxEnv.inst().isLynxDebugEnabled()) {
                LynxEventReporter.onEvent("lynxsdk_createScreenBitmap_failed", getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.behavior.LynxUIRenderer$$ExternalSyntheticLambda2
                    @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
                    public final Map build() {
                        return LynxUIRenderer.lambda$getBitmapOfScreen$1();
                    }
                });
            }
            LLog.i(TAG, "getBitmapOfScreen: get null from createScreenBitmap");
            return null;
        }
        View rootView = lynxView.getRootView();
        if (rootView == null) {
            if (LynxEnv.inst().isLynxDebugEnabled()) {
                LynxEventReporter.onEvent("lynxsdk_getBitmapOfScreen_decoderView_failed", getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.behavior.LynxUIRenderer$$ExternalSyntheticLambda3
                    @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
                    public final Map build() {
                        return LynxUIRenderer.lambda$getBitmapOfScreen$2();
                    }
                });
            }
            LLog.e(TAG, "getBitmapOfScreen: lynxDecoderView is null");
            return null;
        }
        Canvas canvas = new Canvas(createScreenBitmap);
        canvas.drawColor(getParentBackgroundColor(rootView));
        ArrayList globalOverlayNGView = DevToolOverlayDelegate.getInstance().getGlobalOverlayNGView();
        ArrayList<View> arrayList = new ArrayList<>();
        if (globalOverlayNGView != null) {
            for (int size = globalOverlayNGView.size() - 1; size >= 0; size--) {
                arrayList.add(((Dialog) globalOverlayNGView.get(size)).getWindow().getDecorView());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
        drawViewToBitmap(rootView, createBitmap, new Canvas(createBitmap));
        int[] iArr = new int[2];
        rootView.getLocationOnScreen(iArr);
        int i = iArr[0];
        canvas.drawBitmap(createBitmap, (Rect) null, new Rect(i, iArr[1], rootView.getWidth() + i, iArr[1] + rootView.getHeight()), (Paint) null);
        createBitmap.recycle();
        drawOverlayViewToScreenCanvas(canvas, arrayList);
        return createScreenBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getBitmapOfScreen$0() {
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.DownloadManager.COLUMN_REASON, "lynxView is invalid");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getBitmapOfScreen$1() {
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.DownloadManager.COLUMN_REASON, "get null from createScreenBitmap");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getBitmapOfScreen$2() {
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.DownloadManager.COLUMN_REASON, "lynxDecoderView is null");
        return hashMap;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public Bitmap getBitmapOfView() {
        LynxView lynxView = this.mLynxContext.get().getLynxView();
        if (lynxView == null || lynxView.getWidth() <= 0 || lynxView.getHeight() <= 0) {
            if (!LynxEnv.inst().isLynxDebugEnabled()) {
                return null;
            }
            LynxEventReporter.onEvent("lynxsdk_getBitmapOfView_lynxView_failed", getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.behavior.LynxUIRenderer$$ExternalSyntheticLambda0
                @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
                public final Map build() {
                    return LynxUIRenderer.lambda$getBitmapOfView$3();
                }
            });
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(lynxView.getWidth(), lynxView.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(getParentBackgroundColor(lynxView));
        drawViewToBitmap(lynxView, createBitmap, canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getBitmapOfView$3() {
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.DownloadManager.COLUMN_REASON, "lynxView is invalid");
        return hashMap;
    }

    public float[] convertPointFromScreenToGivenUI(float f, float f2, LynxBaseUI lynxBaseUI) {
        float[] fArr = {f, f2};
        float[] locationOnScreen = lynxBaseUI.getLocationOnScreen(new float[2]);
        fArr[0] = fArr[0] - locationOnScreen[0];
        fArr[1] = fArr[1] - locationOnScreen[1];
        return fArr;
    }

    public int findNodeIdForLocationFromUI(float f, float f2, int i, String str) {
        LynxBaseUI node;
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null) {
            if (i == 0) {
                node = lynxUIOwner.getRootUI();
            } else {
                node = lynxUIOwner.getNode(i);
                if (node != null) {
                    node = ((LynxUI) node).getTransitionUI();
                }
            }
            if (node != null) {
                float[] fArr = {f, f2};
                if (str != null && str.equals("fullscreen")) {
                    fArr = convertPointFromScreenToGivenUI(f, f2, node);
                }
                EventTarget hitTest = node.hitTest(fArr[0], fArr[1], true);
                if (hitTest != null) {
                    return hitTest.getSign();
                }
            }
        }
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public int getNodeForLocation(float f, float f2, String str) {
        if (str == null) {
            return 0;
        }
        if (str.equals("fullscreen")) {
            ArrayList allVisibleOverlaySign = DevToolOverlayDelegate.getInstance().getAllVisibleOverlaySign();
            if (allVisibleOverlaySign != null) {
                int size = allVisibleOverlaySign.size();
                for (int i = 0; i < size; i++) {
                    int findNodeIdForLocationFromUI = findNodeIdForLocationFromUI(f, f2, ((Integer) allVisibleOverlaySign.get(i)).intValue(), str);
                    if (findNodeIdForLocationFromUI != 0 && findNodeIdForLocationFromUI != ((Integer) allVisibleOverlaySign.get(i)).intValue()) {
                        return findNodeIdForLocationFromUI;
                    }
                }
            }
            return findNodeIdForLocationFromUI(f, f2, 0, str);
        }
        return findNodeIdForLocationFromUI(f, f2, 0, str);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public float[] getTransformValue(int i, float[] fArr) {
        LynxBaseUI node;
        LynxBaseUI.TransOffset transformValue;
        float[] fArr2 = new float[32];
        LynxUIOwner lynxUIOwner = this.mLynxUIOwner;
        if (lynxUIOwner != null && (node = lynxUIOwner.getNode(i)) != null) {
            for (int i2 = 0; i2 < 4; i2++) {
                if (i2 == 0) {
                    transformValue = node.getTransformValue(fArr[BoxModelOffset.PAD_LEFT.ordinal()] + fArr[BoxModelOffset.BORDER_LEFT.ordinal()] + fArr[BoxModelOffset.LAYOUT_LEFT.ordinal()], ((-fArr[BoxModelOffset.PAD_RIGHT.ordinal()]) - fArr[BoxModelOffset.BORDER_RIGHT.ordinal()]) - fArr[BoxModelOffset.LAYOUT_RIGHT.ordinal()], fArr[BoxModelOffset.PAD_TOP.ordinal()] + fArr[BoxModelOffset.BORDER_TOP.ordinal()] + fArr[BoxModelOffset.LAYOUT_TOP.ordinal()], ((-fArr[BoxModelOffset.PAD_BOTTOM.ordinal()]) - fArr[BoxModelOffset.BORDER_BOTTOM.ordinal()]) - fArr[BoxModelOffset.LAYOUT_BOTTOM.ordinal()]);
                } else if (i2 == 1) {
                    transformValue = node.getTransformValue(fArr[BoxModelOffset.BORDER_LEFT.ordinal()] + fArr[BoxModelOffset.LAYOUT_LEFT.ordinal()], (-fArr[BoxModelOffset.BORDER_RIGHT.ordinal()]) - fArr[BoxModelOffset.LAYOUT_RIGHT.ordinal()], fArr[BoxModelOffset.BORDER_TOP.ordinal()] + fArr[BoxModelOffset.LAYOUT_TOP.ordinal()], (-fArr[BoxModelOffset.BORDER_BOTTOM.ordinal()]) - fArr[BoxModelOffset.LAYOUT_BOTTOM.ordinal()]);
                } else if (i2 == 2) {
                    transformValue = node.getTransformValue(fArr[BoxModelOffset.LAYOUT_LEFT.ordinal()], -fArr[BoxModelOffset.LAYOUT_RIGHT.ordinal()], fArr[BoxModelOffset.LAYOUT_TOP.ordinal()], -fArr[BoxModelOffset.LAYOUT_BOTTOM.ordinal()]);
                } else {
                    transformValue = node.getTransformValue((-fArr[BoxModelOffset.MARGIN_LEFT.ordinal()]) + fArr[BoxModelOffset.LAYOUT_LEFT.ordinal()], fArr[BoxModelOffset.MARGIN_RIGHT.ordinal()] - fArr[BoxModelOffset.LAYOUT_RIGHT.ordinal()], (-fArr[BoxModelOffset.MARGIN_TOP.ordinal()]) + fArr[BoxModelOffset.LAYOUT_TOP.ordinal()], fArr[BoxModelOffset.MARGIN_BOTTOM.ordinal()] - fArr[BoxModelOffset.LAYOUT_BOTTOM.ordinal()]);
                }
                if (transformValue != null) {
                    int i3 = i2 * 8;
                    fArr2[i3] = transformValue.left_top[0];
                    fArr2[i3 + 1] = transformValue.left_top[1];
                    fArr2[i3 + 2] = transformValue.right_top[0];
                    fArr2[i3 + 3] = transformValue.right_top[1];
                    fArr2[i3 + 4] = transformValue.right_bottom[0];
                    fArr2[i3 + 5] = transformValue.right_bottom[1];
                    fArr2[i3 + 6] = transformValue.left_bottom[0];
                    fArr2[i3 + 7] = transformValue.left_bottom[1];
                }
            }
        }
        return fArr2;
    }
}
