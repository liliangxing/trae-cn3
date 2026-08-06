package com.bytedance.ies.uikit.switchview;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes4.dex */
public class SwitchButton extends SwitchBase {
    private OnCheckStateChangeListener mOnCheckStateChangeListener;

    /* loaded from: classes4.dex */
    public interface OnCheckStateChangeListener {
        boolean beforeChange(SwitchButton switchButton, boolean z);
    }

    public SwitchButton(Context context) {
        super(context);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnCheckStateChangeListener(OnCheckStateChangeListener onCheckStateChangeListener) {
        this.mOnCheckStateChangeListener = onCheckStateChangeListener;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setCheckedWithListener(!isChecked());
    }

    @Override // com.bytedance.ies.uikit.switchview.SwitchBase
    protected void animateThumbToCheckedState(boolean z) {
        setCheckedWithListener(z);
    }

    public void setCheckedWithListener(boolean z) {
        if (z == isChecked()) {
            return;
        }
        OnCheckStateChangeListener onCheckStateChangeListener = this.mOnCheckStateChangeListener;
        if (onCheckStateChangeListener == null || onCheckStateChangeListener.beforeChange(this, z)) {
            setChecked(z);
        } else {
            setChecked(!z);
        }
    }
}
