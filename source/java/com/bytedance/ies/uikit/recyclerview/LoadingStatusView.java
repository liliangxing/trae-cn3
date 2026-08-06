package com.bytedance.ies.uikit.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.bytedance.ugc.uikit.R;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class LoadingStatusView extends FrameLayout {
    private static final int STATUS_EMPTY = 1;
    private static final int STATUS_ERROR = 2;
    private static final int STATUS_LOADING = 0;
    private static final int STATUS_NONE = -1;
    private final String TAG;
    private int mStatus;
    List<View> mStatusViews;

    public LoadingStatusView(Context context) {
        this(context, null);
    }

    public LoadingStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "LoadingStatusView";
        this.mStatusViews = new ArrayList(3);
        this.mStatus = -1;
        setBuilder(null);
    }

    public void setBuilder(Builder builder) {
        if (builder == null) {
            builder = Builder.createDefaultBuilder(getContext());
        }
        this.mStatusViews.clear();
        this.mStatusViews.add(builder.mLoadingView);
        this.mStatusViews.add(builder.mEmptyView);
        this.mStatusViews.add(builder.mErrorView);
        removeAllViews();
        for (int i = 0; i < this.mStatusViews.size(); i++) {
            View view = this.mStatusViews.get(i);
            if (view != null) {
                view.setVisibility(4);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                addView(view);
            }
        }
    }

    public void reset() {
        int i = this.mStatus;
        if (i == -1) {
            return;
        }
        this.mStatusViews.get(i).setVisibility(4);
        this.mStatus = -1;
    }

    public boolean isReset() {
        return this.mStatus == -1;
    }

    public void showLoading() {
        setStatus(0);
    }

    public void showEmpty() {
        setStatus(1);
    }

    public void showError() {
        setStatus(2);
    }

    private void setStatus(int i) {
        int i2 = this.mStatus;
        if (i2 == i) {
            return;
        }
        if (i2 >= 0) {
            this.mStatusViews.get(i2).setVisibility(4);
        }
        if (this.mStatusViews.get(i) == null) {
            return;
        }
        this.mStatusViews.get(i).setVisibility(0);
        this.mStatus = i;
        Logger.d(this.TAG, "setStatus    " + i);
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        Context mContext;
        View mEmptyView;
        View mErrorView;
        View mLoadingView;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("LoadingStatusView.Builder:Context can not be null");
            }
            this.mContext = context;
        }

        public Builder setLoadingView(View view) {
            this.mLoadingView = view;
            return this;
        }

        public Builder setLoadingText(int i) {
            return setLoadingView(createDefaultView(i));
        }

        public Builder setUseProgressBar(int i) {
            CircularProgressView createProgressView = createProgressView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.height = i;
            layoutParams.width = i;
            layoutParams.gravity = 17;
            createProgressView.setLayoutParams(layoutParams);
            return setLoadingView(createProgressView);
        }

        public Builder setEmptyView(View view) {
            this.mEmptyView = view;
            return this;
        }

        public Builder setEmptyText(int i) {
            TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.view_default_empty_list, (ViewGroup) null);
            textView.setText(i);
            return setEmptyView(textView);
        }

        public Builder setErrorView(View view) {
            this.mErrorView = view;
            return this;
        }

        public Builder setErrorText(int i, View.OnClickListener onClickListener) {
            View createDefaultView = createDefaultView(i);
            createDefaultView.setOnClickListener(onClickListener);
            return setErrorView(createDefaultView);
        }

        private View createDefaultView(int i) {
            TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.load_status_item_view, (ViewGroup) null);
            textView.setText(i);
            return textView;
        }

        private CircularProgressView createProgressView() {
            return (CircularProgressView) LayoutInflater.from(this.mContext).inflate(R.layout.load_status_item_progressbar, (ViewGroup) null);
        }

        public static Builder createDefaultBuilder(Context context) {
            return new Builder(context).setEmptyText(R.string.load_status_empty).setLoadingText(R.string.load_status_loading).setErrorText(R.string.load_status_error, null);
        }
    }
}
