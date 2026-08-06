package com.lynx.tasm.behavior;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.utils.LynxUIHelper;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LynxObserverManager {
    private final String TAG;
    private ViewTreeObserver.OnDrawListener mDrawListener;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private Handler mHandlerForLynxView;
    private Runnable mIntervalRunnableForLynxView;
    private ViewTreeObserver.OnScrollChangedListener mScrollChangedListener;
    private ViewTreeObserver mViewTreeObserver;
    private RectF mLynxViewOldRect = null;
    protected boolean mEnableExposureWhenLayout = false;
    protected boolean mDelayedTaskPosted = false;
    protected WeakReference<UIBody> mRootBodyRef = null;
    protected boolean mRootViewPainted = false;
    protected long mInterval = 50;
    private long mIntervalForLynxView = 50;
    protected long mLastCheckTime = 0;
    private Handler mHandler = null;
    private Runnable mIntervalRunnable = null;
    protected boolean mDelayedInInner = false;
    private final int[] mLocationOnScreen = new int[2];
    protected int[] mWindowSize = new int[2];
    protected boolean mEnableDisexposureWhenLynxHidden = true;

    protected void observerHandlerInner() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LynxViewIntervalRunnable implements Runnable {
        private final WeakReference<LynxObserverManager> mManagerRef;

        public LynxViewIntervalRunnable(LynxObserverManager lynxObserverManager) {
            this.mManagerRef = new WeakReference<>(lynxObserverManager);
        }

        @Override // java.lang.Runnable
        public void run() {
            LynxObserverManager lynxObserverManager = this.mManagerRef.get();
            if (lynxObserverManager != null) {
                lynxObserverManager.isLynxViewChanged();
            }
        }
    }

    public LynxObserverManager(String str) {
        this.TAG = str;
    }

    public void observerHandler() {
        if (!this.mRootViewPainted) {
            LLog.e(this.TAG, "Lynx observerHandler failed since rootView not draw");
        } else if (this.mDelayedInInner) {
            LLog.w(this.TAG, "Lynx observerHandler failed since inner function is delayed");
        } else {
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxObserverManager.1
                @Override // java.lang.Runnable
                public void run() {
                    TraceEvent.beginSection("ObserverManager.ObserverHandler");
                    try {
                        LynxObserverManager.this.observerHandlerInner();
                    } catch (Throwable th) {
                        LLog.e(LynxObserverManager.this.TAG, "observerManager.intersectionObserverHandler failed: " + th.toString());
                    }
                    TraceEvent.endSection("ObserverManager.ObserverHandler");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postHandlerCallBackDelay(Choreographer.FrameCallback frameCallback) {
        this.mDelayedInInner = true;
        Choreographer.getInstance().postFrameCallbackDelayed(frameCallback, this.mInterval);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void didObserveInner() {
        this.mDelayedInInner = false;
    }

    public void onAttachedToWindow() {
        ViewTreeObserver rootViewTreeObserver = getRootViewTreeObserver();
        if (rootViewTreeObserver == null) {
            LLog.e(this.TAG, "LynxObserverManager add listeners failed since observer is null");
            return;
        }
        if (this.mGlobalLayoutListener == null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.lynx.tasm.behavior.LynxObserverManager.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    LynxObserverManager.this.requestCheckUI();
                }
            };
        }
        if (this.mScrollChangedListener == null) {
            this.mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.lynx.tasm.behavior.LynxObserverManager.3
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    LynxObserverManager.this.requestCheckUI();
                }
            };
        }
        if (this.mDrawListener == null) {
            this.mDrawListener = new ViewTreeObserver.OnDrawListener() { // from class: com.lynx.tasm.behavior.LynxObserverManager.4
                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    LynxObserverManager.this.requestCheckUI();
                }
            };
        }
        if (rootViewTreeObserver != this.mViewTreeObserver) {
            this.mViewTreeObserver = rootViewTreeObserver;
            rootViewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.mViewTreeObserver.addOnScrollChangedListener(this.mScrollChangedListener);
            this.mViewTreeObserver.addOnDrawListener(this.mDrawListener);
        }
    }

    public void addToObserverTree() {
        LLog.i(this.TAG, "addToObserverTree");
        UIBody uIBody = this.mRootBodyRef.get();
        LynxContext lynxContext = uIBody != null ? uIBody.getLynxContext() : null;
        if (lynxContext != null) {
            if (lynxContext.getObserverFrameRate() > 0) {
                this.mInterval = Math.max(16, 1000 / r1);
            }
            this.mEnableDisexposureWhenLynxHidden = lynxContext.getEnableDisexposureWhenLynxHidden();
            this.mEnableExposureWhenLayout = lynxContext.getEnableExposureWhenLayout();
        }
        onAttachedToWindow();
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mIntervalRunnable == null) {
            this.mIntervalRunnable = new Runnable() { // from class: com.lynx.tasm.behavior.LynxObserverManager.5
                @Override // java.lang.Runnable
                public void run() {
                    LynxObserverManager.this.observerHandler();
                }
            };
        }
        this.mHandler.post(this.mIntervalRunnable);
        if (this.mHandlerForLynxView == null) {
            this.mHandlerForLynxView = new Handler(Looper.getMainLooper());
        }
        if (this.mIntervalRunnableForLynxView == null) {
            this.mIntervalRunnableForLynxView = new LynxViewIntervalRunnable(this);
        }
        this.mHandlerForLynxView.postDelayed(this.mIntervalRunnableForLynxView, this.mIntervalForLynxView);
    }

    public void isLynxViewChanged() {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        RectF boundsOnScreenOfLynxBaseUI = getBoundsOnScreenOfLynxBaseUI(this.mRootBodyRef.get());
        if (!boundsOnScreenOfLynxBaseUI.equals(this.mLynxViewOldRect) && (handler2 = this.mHandler) != null && (runnable2 = this.mIntervalRunnable) != null) {
            handler2.post(runnable2);
        }
        long j = this.mIntervalForLynxView;
        if (j != 0 && (handler = this.mHandlerForLynxView) != null && (runnable = this.mIntervalRunnableForLynxView) != null) {
            handler.postDelayed(runnable, j);
        }
        this.mLynxViewOldRect = boundsOnScreenOfLynxBaseUI;
    }

    private int getFrameRate(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getInt(str);
        }
        return -1;
    }

    public void setObserverFrameRate(ReadableMap readableMap) {
        Handler handler;
        Runnable runnable;
        if (readableMap == null) {
            return;
        }
        if (getFrameRate(readableMap, "forExposureCheck") > 0) {
            this.mInterval = Math.max(16, 1000 / r0);
        }
        int frameRate = getFrameRate(readableMap, "forPageRect");
        if (frameRate >= 0) {
            long max = frameRate != 0 ? Math.max(16, 1000 / frameRate) : 0L;
            this.mIntervalForLynxView = max;
            if (max == 0 || (handler = this.mHandlerForLynxView) == null || (runnable = this.mIntervalRunnableForLynxView) == null) {
                return;
            }
            handler.postDelayed(runnable, max);
        }
    }

    public void onRootViewDraw(Canvas canvas) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxObserverManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (LynxObserverManager.this.mRootViewPainted) {
                    return;
                }
                LynxObserverManager.this.mRootViewPainted = true;
                Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.lynx.tasm.behavior.LynxObserverManager.6.1
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long j) {
                        LLog.i(LynxObserverManager.this.TAG, "onRootViewDraw ObserverHandler");
                        LynxObserverManager.this.observerHandler();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UIBody.UIBodyView getRootView() {
        UIBody uIBody = this.mRootBodyRef.get();
        if (uIBody == null) {
            LLog.e(this.TAG, "LynxObserver getRootView failed since rootUI is null");
            return null;
        }
        return uIBody.getBodyView();
    }

    private ViewTreeObserver getRootViewTreeObserver() {
        UIBody.UIBodyView rootView = getRootView();
        if (rootView == null) {
            LLog.e(this.TAG, "LynxObserver getViewTreeObserver failed since rootView is null");
            return null;
        }
        return rootView.getViewTreeObserver();
    }

    public void requestCheckUI() {
        if (this.mHandler == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastCheckTime;
        long j = this.mInterval;
        if (currentTimeMillis > j) {
            this.mLastCheckTime = System.currentTimeMillis();
            this.mHandler.post(this.mIntervalRunnable);
            this.mDelayedTaskPosted = false;
        } else {
            if (this.mDelayedTaskPosted) {
                return;
            }
            this.mHandler.postDelayed(this.mIntervalRunnable, j);
            this.mDelayedTaskPosted = true;
        }
    }

    public void destroy() {
        LLog.i(this.TAG, "destroy");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        Handler handler2 = this.mHandlerForLynxView;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.mHandlerForLynxView = null;
        }
        ViewTreeObserver viewTreeObserver = this.mViewTreeObserver;
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            this.mViewTreeObserver = getRootViewTreeObserver();
        }
        ViewTreeObserver viewTreeObserver2 = this.mViewTreeObserver;
        if (viewTreeObserver2 == null) {
            LLog.e(this.TAG, "LynxObserverManager remove listeners failed since observer is null");
            return;
        }
        viewTreeObserver2.removeOnGlobalLayoutListener(this.mGlobalLayoutListener);
        this.mViewTreeObserver.removeOnScrollChangedListener(this.mScrollChangedListener);
        this.mViewTreeObserver.removeOnDrawListener(this.mDrawListener);
        this.mViewTreeObserver = null;
        this.mGlobalLayoutListener = null;
        this.mScrollChangedListener = null;
        this.mDrawListener = null;
    }

    private void getLeftAndTopOfBoundsInScreen(View view, RectF rectF) {
        if (view == null) {
            LLog.e(this.TAG, "LynxObserverManager getLeftAndTopOfBoundsInScreen failed since view is null");
            return;
        }
        view.getLocationOnScreen(this.mLocationOnScreen);
        int[] iArr = this.mLocationOnScreen;
        rectF.offset(iArr[0], iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF getBoundsOnScreenOfLynxBaseUI(LynxBaseUI lynxBaseUI) {
        RectF rectF = new RectF();
        if (lynxBaseUI == null) {
            LLog.e(this.TAG, "LynxObserverManager getBoundsOnScreenOfLynxBaseUI failed since ui is null");
            return rectF;
        }
        if (LynxEnv.inst().enableTransformForPositionCalculation()) {
            RectF convertRectFromUIToScreen = LynxUIHelper.convertRectFromUIToScreen(lynxBaseUI, new RectF(0.0f, 0.0f, lynxBaseUI.getWidth(), lynxBaseUI.getHeight()));
            rectF.set(convertRectFromUIToScreen.left, convertRectFromUIToScreen.top, convertRectFromUIToScreen.right, convertRectFromUIToScreen.bottom);
            return rectF;
        }
        if (lynxBaseUI instanceof LynxUI) {
            getLeftAndTopOfBoundsInScreen(((LynxUI) lynxBaseUI).getView(), rectF);
            rectF.set(rectF.left, rectF.top, rectF.left + lynxBaseUI.getWidth(), rectF.top + lynxBaseUI.getHeight());
        } else if (lynxBaseUI instanceof LynxFlattenUI) {
            LynxBaseUI parentBaseUI = lynxBaseUI.getParentBaseUI();
            while (parentBaseUI != null && !(parentBaseUI instanceof LynxUI)) {
                parentBaseUI = parentBaseUI.getParentBaseUI();
            }
            if (parentBaseUI != null) {
                getLeftAndTopOfBoundsInScreen(((LynxUI) parentBaseUI).getView(), rectF);
                rectF.offset(-r1.getScrollX(), -r1.getScrollY());
                rectF.offset(lynxBaseUI.getLeft(), lynxBaseUI.getTop());
                rectF.set(rectF.left, rectF.top, rectF.left + lynxBaseUI.getWidth(), rectF.top + lynxBaseUI.getHeight());
            }
        }
        return rectF;
    }

    public void updateWindowSize(LynxContext lynxContext) {
        DisplayMetrics realScreenDisplayMetrics = DisplayMetricsHolder.getRealScreenDisplayMetrics(lynxContext);
        this.mWindowSize[0] = realScreenDisplayMetrics.widthPixels;
        this.mWindowSize[1] = realScreenDisplayMetrics.heightPixels;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF getWindowRect(LynxContext lynxContext) {
        Window window;
        if (lynxContext != null) {
            Activity activity = lynxContext.getActivity();
            int[] iArr = new int[2];
            if (activity != null && (window = activity.getWindow()) != null) {
                window.getDecorView().getLocationOnScreen(iArr);
            }
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = this.mWindowSize;
            return new RectF(i, i2, i + iArr2[0], i2 + iArr2[1]);
        }
        LLog.e(this.TAG, "getWindowRect func failed since context is null");
        return new RectF();
    }
}
