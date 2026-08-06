package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.open.aweme.R;

/* loaded from: classes5.dex */
public class CommonErrorLayout extends FrameLayout {
    private TextView errTipsTV;
    private TextView retryTV;

    public CommonErrorLayout(Context context) {
        this(context, null, 0);
    }

    public CommonErrorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonErrorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_aweme_open_common_error, (ViewGroup) this, true);
        this.errTipsTV = (TextView) inflate.findViewById(R.id.error_tips);
        this.retryTV = (TextView) inflate.findViewById(R.id.error_retry_click);
    }

    public void setErrTip(String str) {
        this.errTipsTV.setText(str);
    }

    public void setErrTipsTextColor(int i) {
        this.errTipsTV.setTextColor(i);
    }

    public void setRetryClick(View.OnClickListener onClickListener) {
        this.retryTV.setOnClickListener(onClickListener);
    }

    public void setRetryText(String str) {
        this.retryTV.setText(str);
    }

    public void setRetryVisible(int i) {
        this.retryTV.setVisibility(i);
    }
}
