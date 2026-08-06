package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.open.aweme.R;

/* loaded from: classes5.dex */
public class CommonLoadingLayout extends FrameLayout {
    private int mIgnoreHeight;
    private View mProgress;
    private FrameLayout mProgressBarLayout;
    private boolean mUseScreenHeight;

    public CommonLoadingLayout(Context context) {
        this(context, null);
    }

    public CommonLoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonLoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void adjustTopMargin() {
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.aweme_open_loading_layout, (ViewGroup) this, true);
        this.mProgress = inflate.findViewById(R.id.double_loading_view);
        this.mProgressBarLayout = (FrameLayout) inflate.findViewById(R.id.progressBarLayout);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        adjustTopMargin();
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mProgress.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            this.mProgress.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.mProgress;
        if (view == null) {
            return;
        }
        view.setVisibility(i);
    }
}
