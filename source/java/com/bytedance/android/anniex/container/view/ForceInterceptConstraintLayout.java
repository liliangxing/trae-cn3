package com.bytedance.android.anniex.container.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public class ForceInterceptConstraintLayout extends ConstraintLayout {
    private boolean mForceIntercept;
    private Function1<KeyEvent, Boolean> onDispatchKeyEvent;

    public ForceInterceptConstraintLayout(Context context) {
        super(context);
        this.mForceIntercept = false;
    }

    public ForceInterceptConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mForceIntercept = false;
    }

    public ForceInterceptConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mForceIntercept = false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mForceIntercept || motionEvent.getAction() == 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setForceInterceptTouchEvent(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterceptTouchEvent(boolean z) {
        this.mForceIntercept = z;
    }

    public void setOnDispatchKeyEvent(Function1<KeyEvent, Boolean> function1) {
        this.onDispatchKeyEvent = function1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Function1<KeyEvent, Boolean> function1 = this.onDispatchKeyEvent;
        if (function1 == null || !function1.invoke(keyEvent).booleanValue()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }
}
