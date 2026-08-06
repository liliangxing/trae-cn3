package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class UnPressableRelativeLayout extends RelativeLayout {
    @Override // android.view.View
    public void setPressed(boolean z) {
    }

    public UnPressableRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public UnPressableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UnPressableRelativeLayout(Context context) {
        super(context);
    }
}
