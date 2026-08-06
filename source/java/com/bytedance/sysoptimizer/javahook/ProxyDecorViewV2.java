package com.bytedance.sysoptimizer.javahook;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.android.internal.policy.DecorView;
import com.bytedance.sysoptimizer.proxyinstance.ProxyInstance;

/* loaded from: classes5.dex */
public class ProxyDecorViewV2 extends DecorView {
    private static final String TAG = "ProxyDecorViewV2";
    private static boolean sLog;

    public ProxyDecorViewV2(Context context) {
        super(context);
    }

    public ProxyDecorViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProxyDecorViewV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ProxyDecorViewV2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (sLog) {
            ProxyInstance.getCallback().e(TAG, "onAttachedToWindow() called", new Throwable());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "onDetachedFromWindow() called");
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "onWindowVisibilityChanged() called with: visibility = [" + i + "]");
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "onVisibilityChanged() called with: changedView = [" + view + "], visibility = [" + i + "]");
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "onViewAdded() called with: child = [" + view + "]");
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "onViewRemoved() called with: child = [" + view + "]");
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "onMeasure() called with: widthMeasureSpec = [" + i + "], heightMeasureSpec = [" + i2 + "]");
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "onLayout() called with: changed = [" + z + "], left = [" + i + "], top = [" + i2 + "], right = [" + i3 + "], bottom = [" + i4 + "]");
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "onDraw() called with: canvas = [" + canvas + "]");
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (sLog) {
            ProxyInstance.getCallback().d(TAG, "finalize() called");
        }
    }
}
