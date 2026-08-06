package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.ies.uikit.util.SafeViewManager;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class SafeViewLayout extends FrameLayout {
    public SafeViewLayout(Context context) {
        super(context);
    }

    public SafeViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafeViewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!isMainThread()) {
            uploadError();
        }
        super.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if (!isMainThread()) {
            uploadError();
        }
        return super.invalidateChildInParent(iArr, rect);
    }

    void uploadError() {
        if (SafeViewManager.getCallBack() != null) {
            SafeViewManager.getCallBack().callBack(new HashMap());
        }
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
