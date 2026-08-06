package com.lynx.animax.p034ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.C1335R;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.ability.NativeAbility;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture;
import com.lynx.animax.p034ui.AnimaXContext;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.DeviceUtil;
import com.lynx.animax.util.UIPropertyUtil;
import com.lynx.animax.util.UIThreadUtils;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXView extends TextureView implements TextureView.SurfaceTextureListener, FirstFrameAwareSurfaceTexture.FirstFrameAvailableListener, IAnimaXView, IAnimaXPlayerDelegate {
    private static final String TAG = "AnimaXView";
    private float mAlphaSet;
    private BroadcastReceiver mBoardCastReceiver;
    private boolean mEnableNativeTapLayerEvent;
    private boolean mEnableTextureUpdateWorkaround;
    private boolean mIgnoreAttachStatus;
    private int mLastVisibility;
    private boolean mNeedAlphaWorkaround;
    private boolean mNeedVisibilityWorkaround;
    private final IAnimaXPlayer mPlayer;
    private boolean mScreenLockWorkaroundInited;
    private boolean mSelfIsDestroyed;
    private Surface mSurface;
    private AnimaXSurfaceDrawable mSurfaceDrawable;
    private FirstFrameAwareSurfaceTexture mSurfaceTexture;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public AnimaXView(Context context) {
        super(context);
        this.mSelfIsDestroyed = false;
        this.mIgnoreAttachStatus = false;
        this.mAlphaSet = 1.0f;
        this.mNeedVisibilityWorkaround = false;
        this.mLastVisibility = 0;
        this.mEnableNativeTapLayerEvent = false;
        this.mEnableTextureUpdateWorkaround = false;
        this.mPlayer = new AnimaXPlayer(new AnimaXContext.Builder(new NativeAbility(), context).build());
        initView(null);
    }

    public AnimaXView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelfIsDestroyed = false;
        this.mIgnoreAttachStatus = false;
        this.mAlphaSet = 1.0f;
        this.mNeedVisibilityWorkaround = false;
        this.mLastVisibility = 0;
        this.mEnableNativeTapLayerEvent = false;
        this.mEnableTextureUpdateWorkaround = false;
        this.mPlayer = new AnimaXPlayer(new AnimaXContext.Builder(new NativeAbility(), context).build());
        initView(attributeSet);
    }

    public AnimaXView(AnimaXContext animaXContext) {
        super(animaXContext.getContext());
        this.mSelfIsDestroyed = false;
        this.mIgnoreAttachStatus = false;
        this.mAlphaSet = 1.0f;
        this.mNeedVisibilityWorkaround = false;
        this.mLastVisibility = 0;
        this.mEnableNativeTapLayerEvent = false;
        this.mEnableTextureUpdateWorkaround = false;
        this.mPlayer = new AnimaXPlayer(animaXContext);
        initView(null);
    }

    public AnimaXView(AnimaXPlayer animaXPlayer) {
        super(animaXPlayer.getAnimaXContext().getContext());
        this.mSelfIsDestroyed = false;
        this.mIgnoreAttachStatus = false;
        this.mAlphaSet = 1.0f;
        this.mNeedVisibilityWorkaround = false;
        this.mLastVisibility = 0;
        this.mEnableNativeTapLayerEvent = false;
        this.mEnableTextureUpdateWorkaround = false;
        this.mPlayer = animaXPlayer;
        initView(null);
    }

    private void initView(AttributeSet attributeSet) {
        AnimaXContext animaXContext = this.mPlayer.getAnimaXContext();
        if (animaXContext == null || animaXContext.getAbility() == null) {
            AnimaXLog.m2540e(TAG, "initView fail, missing AnimaXContext or Ability.");
            return;
        }
        BaseAbility ability = animaXContext.getAbility();
        ability.setCompositionReadyListener(this);
        this.mEnableTextureUpdateWorkaround = DeviceUtil.updateTextureWhenVisible(ability);
        try {
            initAttributes(animaXContext.getContext(), attributeSet);
        } catch (NullPointerException unused) {
            AnimaXLog.m2540e(TAG, "initAttributes fail, context's theme is null.");
        }
        initTexture();
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (context.getTheme() == null) {
            AnimaXLog.m2540e(TAG, "initAttributes fail, context's theme is null.");
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1335R.styleable.AnimaXView);
        String string = obtainStyledAttributes.getString(C1335R.styleable.AnimaXView_animax_animationUrl);
        if (string != null) {
            this.mPlayer.setSrc(string);
        }
        this.mPlayer.setAutoPlay(obtainStyledAttributes.getBoolean(C1335R.styleable.AnimaXView_animax_autoPlay, true));
        this.mPlayer.setLoop(obtainStyledAttributes.getBoolean(C1335R.styleable.AnimaXView_animax_loop, false));
        String string2 = obtainStyledAttributes.getString(C1335R.styleable.AnimaXView_animax_objectFit);
        if (string2 != null) {
            this.mPlayer.setObjectFit(UIPropertyUtil.convertStringToObjectFit(string2));
        }
        obtainStyledAttributes.recycle();
    }

    private void initTexture() {
        setOpaque(false);
        setNeedAlphaWorkaround(true);
        initSurfaceTexture();
        updateSurfaceTexture();
    }

    private void initSurfaceTexture() {
        setSurfaceTextureListener(this);
        this.mSurfaceTexture = new FirstFrameAwareSurfaceTexture();
        this.mSurface = new Surface(this.mSurfaceTexture);
        AnimaXLog.m2541i(TAG, "create Surface: " + this.mSurface);
        this.mSurfaceTexture.setSurface(this.mSurface);
        this.mSurfaceTexture.detachFromGLContext();
        this.mSurfaceTexture.setFirstFrameListener(this);
        this.mSurfaceTexture.setTextureView(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSurfaceTexture() {
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        FirstFrameAwareSurfaceTexture firstFrameAwareSurfaceTexture = this.mSurfaceTexture;
        if (firstFrameAwareSurfaceTexture == null || firstFrameAwareSurfaceTexture.equals(surfaceTexture)) {
            return;
        }
        if (surfaceTexture != null) {
            AnimaXLog.m2541i(TAG, "Init TextureView but it has already another st.");
        }
        setSurfaceTexture(this.mSurfaceTexture);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        initScreenLockWorkaround();
        if (this.mIgnoreAttachStatus) {
            return;
        }
        super.onAttachedToWindow();
        this.mPlayer.updateVisibilityState(true, VisibilityState.ATTACH);
    }

    private void initScreenLockWorkaround() {
        if (DeviceUtil.needScreenLockWorkaround() && !this.mScreenLockWorkaroundInited) {
            if (this.mBoardCastReceiver == null) {
                this.mBoardCastReceiver = new BroadcastReceiver() { // from class: com.lynx.animax.ui.AnimaXView.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        AnimaXLog.m2541i(AnimaXView.TAG, "detect screen unlock, force redraw " + this);
                        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.animax.ui.AnimaXView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnimaXLog.m2541i(AnimaXView.TAG, "detect screen unlock, force redraw " + this + " run");
                                if (AnimaXView.this.getVisibility() == 0) {
                                    AnimaXView.this.setVisibility(4);
                                    AnimaXView.this.setVisibility(0);
                                }
                            }
                        });
                    }
                };
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            try {
                m2537x3a8daa01(getContext(), this.mBoardCastReceiver, intentFilter);
            } catch (Exception e) {
                AnimaXLog.m2540e(TAG, e.getMessage());
                AnimaXLog.m2540e(TAG, "register BoardCastReceiver: " + this.mBoardCastReceiver);
            }
            this.mScreenLockWorkaroundInited = true;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        deInitScreenLockWorkaround();
        if (this.mIgnoreAttachStatus) {
            return;
        }
        super.onDetachedFromWindow();
        this.mPlayer.updateVisibilityState(false, VisibilityState.ATTACH);
    }

    private void deInitScreenLockWorkaround() {
        if (DeviceUtil.needScreenLockWorkaround() && this.mScreenLockWorkaroundInited) {
            this.mScreenLockWorkaroundInited = false;
            try {
                m2538xb2988eda(getContext(), this.mBoardCastReceiver);
            } catch (Exception e) {
                AnimaXLog.m2540e(TAG, e.getMessage());
                AnimaXLog.m2540e(TAG, "unregister BoardCastReceiver: " + this.mBoardCastReceiver);
            }
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXView, com.lynx.animax.p034ui.IAnimaXPlayerDelegate
    public IAnimaXPlayer getPlayer() {
        return this.mPlayer;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXView
    public void setIgnoreAttachStatus(boolean z) {
        this.mIgnoreAttachStatus = z;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AnimaXLog.m2541i(TAG, "onSurfaceTextureAvailable: " + surfaceTexture + ", width: " + i + ", height: " + i2 + ", this: " + this);
        if (this.mSelfIsDestroyed) {
            AnimaXLog.m2541i(TAG, "onSurfaceTextureAvailable failed as view is destroyed.");
        } else {
            updateSurfaceTexture();
            onSurfaceChanged(i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AnimaXLog.m2541i(TAG, "onSurfaceTextureSizeChanged: " + surfaceTexture + ", width: " + i + ", height: " + i2 + ", this: " + this);
        if (this.mSelfIsDestroyed) {
            AnimaXLog.m2541i(TAG, "onSurfaceTextureSizeChanged failed as view is destroyed.");
        } else {
            onSurfaceChanged(i, i2);
        }
    }

    private void setNeedAlphaWorkaround(boolean z) {
        if (DeviceUtil.needAlphaWorkaround()) {
            this.mNeedAlphaWorkaround = z;
            if (z) {
                super.setAlpha(0.0f);
            } else {
                super.setAlpha(this.mAlphaSet);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mEnableNativeTapLayerEvent) {
            handleTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void onSurfaceChanged(int i, int i2) {
        this.mPlayer.updateVisibilityState(i > 0 && i2 > 0, VisibilityState.SIZE);
        if (i <= 0 || i2 <= 0) {
            AnimaXLog.m2541i(TAG, "Skip invalid size: " + i + " / " + i2);
            return;
        }
        AnimaXSurfaceDrawable animaXSurfaceDrawable = this.mSurfaceDrawable;
        if (animaXSurfaceDrawable == null) {
            AnimaXSurfaceDrawable createFromFirstFrameAwareSurfaceTexture = AnimaXSurfaceDrawable.createFromFirstFrameAwareSurfaceTexture(this.mSurfaceTexture, i, i2);
            this.mSurfaceDrawable = createFromFirstFrameAwareSurfaceTexture;
            this.mPlayer.createAnimaXSurface(createFromFirstFrameAwareSurfaceTexture);
        } else if (animaXSurfaceDrawable.updateSize(i, i2)) {
            this.mPlayer.updateAnimaXSurface(this.mSurfaceDrawable);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AnimaXLog.m2541i(TAG, "onSurfaceTextureDestroyed: " + surfaceTexture + ", mHasDestroyed: " + this.mSelfIsDestroyed + ", this: " + this);
        if (!DeviceUtil.needTextureDestroyWorkaround() || this.mSelfIsDestroyed) {
            return false;
        }
        AnimaXLog.m2541i(TAG, "needTextureDestroyWorkaround, try to postAtFrontOnUI.");
        this.mLastVisibility = getVisibility();
        this.mNeedVisibilityWorkaround = true;
        setVisibility(4);
        UIThreadUtils.postAsynchronousAtFrontOfQueueOnUiThread(new Runnable() { // from class: com.lynx.animax.ui.AnimaXView.2
            @Override // java.lang.Runnable
            public void run() {
                AnimaXLog.m2541i(AnimaXView.TAG, "Try to updateSurfaceTexture, mHasDestroyed: " + AnimaXView.this.mSelfIsDestroyed);
                if (AnimaXView.this.mSelfIsDestroyed) {
                    return;
                }
                AnimaXView.this.mNeedVisibilityWorkaround = false;
                AnimaXView animaXView = AnimaXView.this;
                animaXView.setVisibility(animaXView.mLastVisibility);
                AnimaXView.this.updateSurfaceTexture();
            }
        });
        return false;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXView, com.lynx.animax.p034ui.IAnimaXPlayer
    public void release() {
        if (this.mSelfIsDestroyed) {
            return;
        }
        AnimaXLog.m2541i(TAG, "release: " + this);
        this.mSelfIsDestroyed = true;
        this.mPlayer.release();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        try {
            super.onSizeChanged(i, i2, i3, i4);
        } catch (NullPointerException e) {
            e.printStackTrace();
            AnimaXLog.m2540e(TAG, "onSizeChanged before added to view tree, may produce npe on some devices");
        }
    }

    @Override // com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture.FirstFrameAvailableListener
    public void onFirstFrameAvailable() {
        setNeedAlphaWorkaround(false);
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable drawable) {
        try {
            super.setForeground(drawable);
        } catch (UnsupportedOperationException e) {
            AnimaXLog.m2540e(TAG, "setForeground fail, message: " + e.getMessage());
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        try {
            super.setBackgroundDrawable(drawable);
        } catch (UnsupportedOperationException e) {
            AnimaXLog.m2540e(TAG, "setBackgroundDrawable fail, message: " + e.getMessage());
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        try {
            super.setBackground(drawable);
        } catch (UnsupportedOperationException e) {
            AnimaXLog.m2540e(TAG, "setBackground fail, message: " + e.getMessage());
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.mNeedVisibilityWorkaround) {
            this.mLastVisibility = i;
            if (i == 0) {
                AnimaXLog.m2541i(TAG, "Force visiblity to INVISIBLE due to workaround.");
                i = 4;
            }
        }
        super.setVisibility(i);
        this.mPlayer.updateVisibilityState(i == 0, VisibilityState.VISIBLE);
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        float alpha = getAlpha();
        this.mAlphaSet = f;
        if (!this.mNeedAlphaWorkaround) {
            super.setAlpha(f);
        }
        boolean z = alpha > 0.0f;
        boolean z2 = f > 0.0f;
        if (z != z2) {
            this.mPlayer.updateVisibilityState(z2, VisibilityState.OPACITY);
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (this.mIgnoreAttachStatus) {
            return;
        }
        this.mPlayer.updateVisibilityState(z, VisibilityState.AGGREGATED);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.mEnableTextureUpdateWorkaround && view == this && i == 0) {
            updateSurfaceTexture();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.mEnableTextureUpdateWorkaround && getVisibility() == 0 && i == 0) {
            updateSurfaceTexture();
        }
    }

    @Override // com.lynx.animax.base.IAnimaXCompositionReadyListener
    public void onCompositionReady() {
        if (this.mSurfaceDrawable == null && this.mIgnoreAttachStatus) {
            this.mPlayer.markPlatformSurfaceAsInvalid(true);
            AnimaXLog.m2541i(TAG, "The Surface has not been created yet; Creating a temporary one.");
            onSurfaceTextureAvailable(null, 1, 1);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXView
    public void setEnableTapLayerEvent(boolean z) {
        this.mEnableNativeTapLayerEvent = z;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_lynx_animax_ui_AnimaXView_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m2537x3a8daa01(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_lynx_animax_ui_AnimaXView_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m2538xb2988eda(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
