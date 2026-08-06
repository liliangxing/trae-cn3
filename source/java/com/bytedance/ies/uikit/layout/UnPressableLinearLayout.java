package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes4.dex */
public class UnPressableLinearLayout extends LinearLayout {
    @Override // android.view.View
    public void setPressed(boolean z) {
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
    }

    public UnPressableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UnPressableLinearLayout(Context context) {
        super(context);
    }
}
