package com.lynx.canvas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.canvas.SurfaceHolder;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UICanvasView extends TextureView implements TextureView.SurfaceTextureListener, SurfaceHolder.FirstFrameListener {
    private static final String TAG = "KryptonCanvasView";
    private float mAlphaSet;
    private BroadcastReceiver mBoardCastReceiver;
    private int mLastVisibility;
    private boolean mNeedAlphaWorkaround;
    private boolean mNeedProcessGesture;
    private boolean mNeedVisibilityWorkaround;
    private PlatformCanvasView mPlatformCanvasView;
    private float mRatio;
    private boolean mScreenLockWorkaroundInited;
    private SurfaceHolder mSurfaceHolder;
    private long mSurfaceNativePtr;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public UICanvasView(Context context) {
        super(context.getApplicationContext());
        this.mSurfaceNativePtr = 0L;
        this.mNeedProcessGesture = false;
        KryptonLLog.m2561i(TAG, "UICanvasView created");
        setSurfaceTextureListener(this);
        this.mAlphaSet = 1.0f;
        setOpaque(false);
        setNeedAlphaWorkaround(true);
        this.mRatio = context.getResources().getDisplayMetrics().density;
        SurfaceHolder surfaceHolder = new SurfaceHolder(this);
        this.mSurfaceHolder = surfaceHolder;
        surfaceHolder.initTextureView(this);
        this.mSurfaceNativePtr = this.mSurfaceHolder.releaseSurfacePtr();
        this.mPlatformCanvasView = new PlatformCanvasView();
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        this.mAlphaSet = f;
        if (this.mNeedAlphaWorkaround) {
            return;
        }
        super.setAlpha(f);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        super.setSurfaceTexture(surfaceTexture);
    }

    private void setNeedAlphaWorkaround(boolean z) {
        KryptonLLog.m2561i(TAG, "setNeedAlphaWorkaround with " + z + " Build.VERSION.SDK_INT " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        this.mNeedAlphaWorkaround = z;
        if (z) {
            super.setAlpha(0.0f);
        } else {
            super.setAlpha(this.mAlphaSet);
        }
    }

    @Override // com.lynx.canvas.SurfaceHolder.FirstFrameListener
    public void onFirstFrame() {
        setNeedAlphaWorkaround(false);
    }

    public void setup(String str, KryptonApp kryptonApp) {
        PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
        if (platformCanvasView == null || !platformCanvasView.setup(str, kryptonApp, this.mRatio, getWidth(), getHeight())) {
            return;
        }
        boolean needProcessGesture = kryptonApp.getFeatureFlag().needProcessGesture();
        this.mNeedProcessGesture = needProcessGesture;
        if (needProcessGesture) {
            setOnTouchListener(new View.OnTouchListener() { // from class: com.lynx.canvas.UICanvasView.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    UICanvasView.this.dispatchTouch(motionEvent, new Rect(0, 0, UICanvasView.this.getWidth(), UICanvasView.this.getHeight()), new Rect(0, 0, UICanvasView.this.getWidth(), UICanvasView.this.getHeight()));
                    return true;
                }
            });
        }
        this.mSurfaceHolder.onSurfaceTextureSizeChanged(getWidth(), getHeight());
        this.mPlatformCanvasView.notifySurfaceChanged(this.mSurfaceNativePtr, getWidth(), getHeight());
    }

    public void notifyLayout(Rect rect) {
        PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
        if (platformCanvasView == null) {
            return;
        }
        platformCanvasView.notifyLayoutUpdate(rect, getWidth(), getHeight());
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        KryptonLLog.m2561i(TAG, WebViewContainer.EVENT_onAttachedToWindow);
        super.onAttachedToWindow();
        initScreenLockWorkaround();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        deInitScreenLockWorkaround();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        try {
            super.onSizeChanged(i, i2, i3, i4);
        } catch (NullPointerException e) {
            e.printStackTrace();
            KryptonLLog.m2560e(TAG, "onSizeChanged before added to view tree, may produce npe on some devices");
        }
    }

    private void initScreenLockWorkaround() {
        if (this.mScreenLockWorkaroundInited) {
            KryptonLLog.m2563w(TAG, "initScreenLockWorkaround multiple times.");
            return;
        }
        KryptonLLog.m2561i(TAG, "initScreenLockWorkaround " + this);
        if (this.mBoardCastReceiver == null) {
            this.mBoardCastReceiver = new BroadcastReceiver() { // from class: com.lynx.canvas.UICanvasView.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    KryptonLLog.m2561i(UICanvasView.TAG, "detect screen unlock, force redraw " + this);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.lynx.canvas.UICanvasView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            KryptonLLog.m2561i(UICanvasView.TAG, "detect screen unlock, force redraw " + this + " run");
                            if (UICanvasView.this.getVisibility() == 0) {
                                UICanvasView.this.setVisibility(4);
                                UICanvasView.this.setVisibility(0);
                            }
                        }
                    });
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        try {
            m2564x532c1426(getContext(), this.mBoardCastReceiver, intentFilter);
        } catch (Exception e) {
            KryptonLLog.m2560e(TAG, e.getMessage());
            KryptonLLog.m2560e(TAG, "register BoardCastReceiver: " + this.mBoardCastReceiver);
        }
        this.mScreenLockWorkaroundInited = true;
    }

    private void deInitScreenLockWorkaround() {
        if (!this.mScreenLockWorkaroundInited) {
            KryptonLLog.m2563w(TAG, "deInitScreenLockWorkaround multiple times.");
            return;
        }
        KryptonLLog.m2561i(TAG, "deInitScreenLockWorkaround " + this);
        this.mScreenLockWorkaroundInited = false;
        try {
            m2565x1d4503bf(getContext(), this.mBoardCastReceiver);
        } catch (Exception e) {
            KryptonLLog.m2560e(TAG, e.getMessage());
            KryptonLLog.m2560e(TAG, "unregister BoardCastReceiver: " + this.mBoardCastReceiver);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        KryptonLLog.m2563w(TAG, "onSurfaceTextureAvailable " + surfaceTexture + " wh " + i + " / " + i2);
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.initTextureView(this);
            this.mSurfaceHolder.onSurfaceTextureSizeChanged(i, i2);
            PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
            if (platformCanvasView != null) {
                platformCanvasView.notifySurfaceChanged(this.mSurfaceNativePtr, i, i2);
                return;
            }
            return;
        }
        KryptonLLog.m2560e(TAG, "onSurfaceTextureAvailable but sh is " + this.mSurfaceHolder);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        KryptonLLog.m2561i(TAG, "onSurfaceTextureSizeChanged " + surfaceTexture + " wh " + i + " / " + i2);
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.onSurfaceTextureSizeChanged(i, i2);
            PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
            if (platformCanvasView != null) {
                platformCanvasView.notifySurfaceChanged(this.mSurfaceNativePtr, i, i2);
                return;
            }
            return;
        }
        KryptonLLog.m2560e(TAG, "onSurfaceTextureSizeChanged but sh is " + this.mSurfaceHolder);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        KryptonLLog.m2561i(TAG, "onSurfaceTextureDestroyed " + surfaceTexture);
        if (!DeviceUtil.needTextureDestroyWorkaround()) {
            return false;
        }
        KryptonLLog.m2561i(TAG, "needTextureDestroyWorkaround, try to postAtFrontOnUI.");
        this.mLastVisibility = getVisibility();
        this.mNeedVisibilityWorkaround = true;
        setVisibility(4);
        postAtFrontOnUI(new Runnable() { // from class: com.lynx.canvas.UICanvasView.3
            @Override // java.lang.Runnable
            public void run() {
                KryptonLLog.m2561i(UICanvasView.TAG, "Try to updateSurfaceTexture");
                UICanvasView.this.mNeedVisibilityWorkaround = false;
                UICanvasView uICanvasView = UICanvasView.this;
                uICanvasView.setVisibility(uICanvasView.mLastVisibility);
                if (UICanvasView.this.mSurfaceHolder != null) {
                    UICanvasView.this.mSurfaceHolder.initTextureView(UICanvasView.this);
                }
            }
        });
        return false;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.mNeedVisibilityWorkaround) {
            this.mLastVisibility = i;
            if (i == 0) {
                KryptonLLog.m2561i(TAG, "Force visiblity to INVISIBLE due to workaround.");
                i = 4;
            }
        }
        super.setVisibility(i);
    }

    public boolean dispatchTouch(MotionEvent motionEvent, Rect rect, Rect rect2) {
        PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
        if (platformCanvasView == null) {
            return false;
        }
        platformCanvasView.dispatchTouchEvent(motionEvent, rect, rect2);
        return false;
    }

    public void destroy() {
        KryptonLLog.m2561i(TAG, "UICanvasView destroy");
        if (this.mSurfaceHolder != null) {
            KryptonLLog.m2563w(TAG, "Destroy surface during UICanvasView destroyed.");
            this.mSurfaceHolder.dispose();
            this.mSurfaceHolder = null;
        }
        PlatformCanvasView platformCanvasView = this.mPlatformCanvasView;
        if (platformCanvasView != null) {
            platformCanvasView.onSurfaceDestroyed();
            this.mPlatformCanvasView.dispose();
            this.mPlatformCanvasView = null;
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable drawable) {
        try {
            super.setForeground(drawable);
        } catch (UnsupportedOperationException e) {
            KryptonLLog.m2560e(TAG, "setForeground fail, message: " + e.getMessage());
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        try {
            super.setBackgroundDrawable(drawable);
        } catch (UnsupportedOperationException e) {
            KryptonLLog.m2560e(TAG, "setBackgroundDrawable fail, message: " + e.getMessage());
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        try {
            super.setBackground(drawable);
        } catch (UnsupportedOperationException e) {
            KryptonLLog.m2560e(TAG, "setBackground fail, message: " + e.getMessage());
        }
    }

    private void postAtFrontOnUI(Runnable runnable) {
        Handler handler = new Handler(Looper.getMainLooper());
        Message obtain = Message.obtain(handler, runnable);
        obtain.setAsynchronous(true);
        handler.sendMessageAtFrontOfQueue(obtain);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_lynx_canvas_UICanvasView_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m2564x532c1426(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_lynx_canvas_UICanvasView_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m2565x1d4503bf(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
