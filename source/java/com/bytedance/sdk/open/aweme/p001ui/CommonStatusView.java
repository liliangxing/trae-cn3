package com.bytedance.sdk.open.aweme.p001ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonStatusView extends FrameLayout {
    public static final int STATUS_EMPTY = 1;
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_LOADING = 0;
    public static final int STATUS_NONE = -1;
    private boolean mHasLoadSuccess;
    private int mStatus;
    List<View> mStatusViews;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Builder {
        Context mContext;
        View mEmptyView;
        View mErrorView;
        View mLoadingView;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("CommonStatusView.Builder:Context can not be null");
            }
            this.mContext = context;
        }

        public static Builder createDefaultBuilder(Context context) {
            return new Builder(context).useDefaultLoadingView();
        }

        private View createDefaultLoadingView() {
            CommonLoadingLayout commonLoadingLayout = new CommonLoadingLayout(this.mContext);
            commonLoadingLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return commonLoadingLayout;
        }

        public Builder setEmptyView(View view) {
            this.mEmptyView = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this;
        }

        public Builder setErrorView(View view) {
            this.mErrorView = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this;
        }

        public Builder setLoadingView(View view) {
            this.mLoadingView = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this;
        }

        public Builder useDefaultLoadingView() {
            setLoadingView(createDefaultLoadingView());
            return this;
        }
    }

    public CommonStatusView(Context context) {
        this(context, null, 0);
    }

    public CommonStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatus = -1;
        this.mStatusViews = new ArrayList(3);
        this.mHasLoadSuccess = false;
    }

    public View getStatusView(int i) {
        if (i < 0 || i >= this.mStatusViews.size()) {
            return null;
        }
        return this.mStatusViews.get(i);
    }

    public boolean isLoading() {
        return this.mStatus == 0;
    }

    public boolean isShowingEmpty() {
        return this.mStatus == 1;
    }

    public boolean isShowingError() {
        return this.mStatus == 2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void reset() {
        int i = this.mStatus;
        if (i == -1) {
            return;
        }
        View statusView = getStatusView(i);
        if (statusView != null) {
            statusView.setVisibility(4);
        }
        setVisibility(4);
        this.mStatus = -1;
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
                addView(view);
            }
        }
    }

    public void setLoadSucceed() {
        this.mHasLoadSuccess = true;
    }

    public void setStatus(int i) {
        View statusView;
        int i2 = this.mStatus;
        if (i2 == i) {
            return;
        }
        if (i2 >= 0 && (statusView = getStatusView(i2)) != null) {
            statusView.setVisibility(4);
        }
        if (i >= 0) {
            setVisibility(0);
            View statusView2 = getStatusView(i);
            if (statusView2 != null) {
                statusView2.setVisibility(0);
            }
        } else {
            setVisibility(4);
        }
        this.mStatus = i;
    }

    public void showEmpty() {
        setVisibility(0);
        setStatus(1);
    }

    public void showEmpty(boolean z) {
        if (z && this.mHasLoadSuccess) {
            return;
        }
        showEmpty();
    }

    public void showError() {
        setVisibility(0);
        setStatus(2);
    }

    public void showError(boolean z) {
        if (this.mHasLoadSuccess) {
            reset();
        } else {
            showError();
        }
    }

    public void showLoading() {
        setVisibility(0);
        setStatus(0);
    }
}
