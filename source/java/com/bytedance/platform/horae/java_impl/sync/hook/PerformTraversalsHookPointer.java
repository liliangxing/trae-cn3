package com.bytedance.platform.horae.java_impl.sync.hook;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.platform.horae.common.DoubleReflectHelper;
import com.bytedance.platform.horae.common.Logger;
import com.bytedance.webx.core.webview.WebViewContainer;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class PerformTraversalsHookPointer extends OnHookItem implements Application.ActivityLifecycleCallbacks, ViewTreeObserver.OnDrawListener, ViewTreeObserver.OnGlobalFocusChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnPreDrawListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnTouchModeChangeListener, View.OnAttachStateChangeListener, View.OnLayoutChangeListener {
    private static final long CHECK_INTERVALS = 1000;
    private static final String TAG = "PerformTraversalsHook";
    private Field mAttachInfoField;
    private Application mContext;
    private long mLastTimeStamp;

    public PerformTraversalsHookPointer(Application application, OnHookPointTrigger onHookPointTrigger) {
        super(TAG, onHookPointTrigger);
        this.mContext = application;
    }

    @Override // com.bytedance.platform.horae.java_impl.sync.hook.OnHookItem
    public void onHook() {
        try {
            Field field = DoubleReflectHelper.getField(View.class, "mAttachInfo");
            this.mAttachInfoField = field;
            if (field != null) {
                field.setAccessible(true);
                this.mContext.registerActivityLifecycleCallbacks(this);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        notifyCallback("onActivityCreated");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.mAttachInfoField == null) {
            return;
        }
        try {
            View decorView = activity.getWindow().getDecorView();
            ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
            viewTreeObserver.addOnDrawListener(this);
            viewTreeObserver.addOnGlobalFocusChangeListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
            viewTreeObserver.addOnPreDrawListener(this);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnTouchModeChangeListener(this);
            decorView.addOnAttachStateChangeListener(this);
            decorView.addOnLayoutChangeListener(this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        notifyCallback("onActivityResumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        notifyCallback("onActivityPaused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        notifyCallback("onActivityStopped");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        notifyCallback("onActivitySaveInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        notifyCallback("onActivityDestroyed");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        notifyCallback("onViewAttachedToWindow");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        notifyCallback("onViewDetachedFromWindow");
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        notifyCallback("onLayoutChange");
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        notifyCallback(WebViewContainer.EVENT_onDraw);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
        notifyCallback("onGlobalFocusChanged");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        notifyCallback("onGlobalLayout");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        notifyCallback("onPreDraw");
        return true;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        notifyCallback(WebViewContainer.EVENT_onScrollChanged);
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        notifyCallback("onTouchModeChanged");
    }

    private void notifyCallback(String str) {
        if (this.mOnHookPointTrigger == null || System.currentTimeMillis() - this.mLastTimeStamp <= 1000) {
            return;
        }
        this.mOnHookPointTrigger.onHookPointTrigger(this.mChanel);
        this.mLastTimeStamp = System.currentTimeMillis();
        Logger.e(TAG, "notifyCallback form method = " + str);
    }
}
