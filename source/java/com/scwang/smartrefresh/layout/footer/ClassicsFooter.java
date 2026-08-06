package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.C0277R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ArrowDrawable;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.SmartUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements RefreshFooter {
    public static String REFRESH_FOOTER_FAILED;
    public static String REFRESH_FOOTER_FINISH;
    public static String REFRESH_FOOTER_LOADING;
    public static String REFRESH_FOOTER_NOTHING;
    public static String REFRESH_FOOTER_PULLING;
    public static String REFRESH_FOOTER_REFRESHING;
    public static String REFRESH_FOOTER_RELEASE;
    protected boolean mNoMoreData;
    protected String mTextFailed;
    protected String mTextFinish;
    protected String mTextLoading;
    protected String mTextNothing;
    protected String mTextPulling;
    protected String mTextRefreshing;
    protected String mTextRelease;

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mNoMoreData = false;
        View.inflate(context, C0277R.layout.srl_classics_footer, this);
        ImageView imageView = (ImageView) findViewById(C0277R.id.srl_classics_arrow);
        this.mArrowView = imageView;
        ImageView imageView2 = (ImageView) findViewById(C0277R.id.srl_classics_progress);
        this.mProgressView = imageView2;
        this.mTitleText = (TextView) findViewById(C0277R.id.srl_classics_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0277R.styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        layoutParams2.rightMargin = obtainStyledAttributes.getDimensionPixelSize(C0277R.styleable.ClassicsFooter_srlDrawableMarginRight, SmartUtil.dp2px(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(C0277R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(C0277R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(C0277R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(C0277R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(C0277R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(C0277R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(C0277R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(C0277R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.height);
        this.mFinishDuration = obtainStyledAttributes.getInt(C0277R.styleable.ClassicsFooter_srlFinishDuration, this.mFinishDuration);
        this.mSpinnerStyle = SpinnerStyle.values[obtainStyledAttributes.getInt(C0277R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.mSpinnerStyle.ordinal)];
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlDrawableArrow)) {
            this.mArrowView.setImageDrawable(obtainStyledAttributes.getDrawable(C0277R.styleable.ClassicsFooter_srlDrawableArrow));
        } else if (this.mArrowView.getDrawable() == null) {
            this.mArrowDrawable = new ArrowDrawable();
            this.mArrowDrawable.setColor(-10066330);
            this.mArrowView.setImageDrawable(this.mArrowDrawable);
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlDrawableProgress)) {
            this.mProgressView.setImageDrawable(obtainStyledAttributes.getDrawable(C0277R.styleable.ClassicsFooter_srlDrawableProgress));
        } else if (this.mProgressView.getDrawable() == null) {
            this.mProgressDrawable = new ProgressDrawable();
            this.mProgressDrawable.setColor(-10066330);
            this.mProgressView.setImageDrawable(this.mProgressDrawable);
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.mTitleText.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(C0277R.styleable.ClassicsFooter_srlTextSizeTitle, SmartUtil.dp2px(16.0f)));
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlPrimaryColor)) {
            super.setPrimaryColor(obtainStyledAttributes.getColor(C0277R.styleable.ClassicsFooter_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlAccentColor)) {
            super.setAccentColor(obtainStyledAttributes.getColor(C0277R.styleable.ClassicsFooter_srlAccentColor, 0));
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlTextPulling)) {
            this.mTextPulling = obtainStyledAttributes.getString(C0277R.styleable.ClassicsFooter_srlTextPulling);
        } else {
            String str = REFRESH_FOOTER_PULLING;
            if (str != null) {
                this.mTextPulling = str;
            } else {
                this.mTextPulling = context.getString(C0277R.string.srl_footer_pulling);
            }
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlTextRelease)) {
            this.mTextRelease = obtainStyledAttributes.getString(C0277R.styleable.ClassicsFooter_srlTextRelease);
        } else {
            String str2 = REFRESH_FOOTER_RELEASE;
            if (str2 != null) {
                this.mTextRelease = str2;
            } else {
                this.mTextRelease = context.getString(C0277R.string.srl_footer_release);
            }
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlTextLoading)) {
            this.mTextLoading = obtainStyledAttributes.getString(C0277R.styleable.ClassicsFooter_srlTextLoading);
        } else {
            String str3 = REFRESH_FOOTER_LOADING;
            if (str3 != null) {
                this.mTextLoading = str3;
            } else {
                this.mTextLoading = context.getString(C0277R.string.srl_footer_loading);
            }
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlTextRefreshing)) {
            this.mTextRefreshing = obtainStyledAttributes.getString(C0277R.styleable.ClassicsFooter_srlTextRefreshing);
        } else {
            String str4 = REFRESH_FOOTER_REFRESHING;
            if (str4 != null) {
                this.mTextRefreshing = str4;
            } else {
                this.mTextRefreshing = context.getString(C0277R.string.srl_footer_refreshing);
            }
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlTextFinish)) {
            this.mTextFinish = obtainStyledAttributes.getString(C0277R.styleable.ClassicsFooter_srlTextFinish);
        } else {
            String str5 = REFRESH_FOOTER_FINISH;
            if (str5 != null) {
                this.mTextFinish = str5;
            } else {
                this.mTextFinish = context.getString(C0277R.string.srl_footer_finish);
            }
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlTextFailed)) {
            this.mTextFailed = obtainStyledAttributes.getString(C0277R.styleable.ClassicsFooter_srlTextFailed);
        } else {
            String str6 = REFRESH_FOOTER_FAILED;
            if (str6 != null) {
                this.mTextFailed = str6;
            } else {
                this.mTextFailed = context.getString(C0277R.string.srl_footer_failed);
            }
        }
        if (obtainStyledAttributes.hasValue(C0277R.styleable.ClassicsFooter_srlTextNothing)) {
            this.mTextNothing = obtainStyledAttributes.getString(C0277R.styleable.ClassicsFooter_srlTextNothing);
        } else {
            String str7 = REFRESH_FOOTER_NOTHING;
            if (str7 != null) {
                this.mTextNothing = str7;
            } else {
                this.mTextNothing = context.getString(C0277R.string.srl_footer_nothing);
            }
        }
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        this.mTitleText.setText(isInEditMode() ? this.mTextLoading : this.mTextPulling);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(RefreshLayout refreshLayout, int i, int i2) {
        if (this.mNoMoreData) {
            return;
        }
        super.onStartAnimator(refreshLayout, i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        if (this.mNoMoreData) {
            return 0;
        }
        this.mTitleText.setText(z ? this.mTextFinish : this.mTextFailed);
        return super.onFinish(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.mSpinnerStyle == SpinnerStyle.FixedBehind) {
            super.setPrimaryColors(iArr);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean setNoMoreData(boolean z) {
        if (this.mNoMoreData == z) {
            return true;
        }
        this.mNoMoreData = z;
        ImageView imageView = this.mArrowView;
        if (z) {
            this.mTitleText.setText(this.mTextNothing);
            imageView.setVisibility(8);
            return true;
        }
        this.mTitleText.setText(this.mTextPulling);
        imageView.setVisibility(0);
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0010. Please report as an issue. */
    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.mArrowView;
        if (this.mNoMoreData) {
            return;
        }
        switch (C02891.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()]) {
            case 1:
                imageView.setVisibility(0);
            case 2:
                this.mTitleText.setText(this.mTextPulling);
                imageView.animate().rotation(180.0f);
                return;
            case 3:
            case 4:
                imageView.setVisibility(8);
                this.mTitleText.setText(this.mTextLoading);
                return;
            case 5:
                this.mTitleText.setText(this.mTextRelease);
                imageView.animate().rotation(0.0f);
                return;
            case 6:
                this.mTitleText.setText(this.mTextRefreshing);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.footer.ClassicsFooter$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C02891 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
