package com.bytedance.ies.uikit.toast;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ugc.uikit.R;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes4.dex */
public class CustomToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2500;
    private float mActionCurrentY;
    private float mActionDownY;
    private View mContentView;
    private Context mContext;
    private int mDefaultLayoutId;
    private AnimatorSet mHideAnimatorSet;
    private int mIcon;
    private ImageView mImageView;
    private boolean mIsShowing;
    private int mLastLayoutId;
    private View mLastToast;
    private WindowManager.LayoutParams mLayoutParams;
    private int[] mMargin;
    private boolean mOnPause;
    private boolean mScalable;
    private AnimatorSet mScaleLargeAnimatorSet;
    private AnimatorSet mScaleSmallAnimatorSet;
    private AnimatorSet mShowAnimatorSet;
    private int mStartAnimHeight;
    private String mText;
    private TextView mTextView;
    private ViewGroup mViewGroup;
    private WindowManager mWindowManager;
    private int mGravity = 49;
    private long mDuration = 2500;
    private boolean mIsDismissing = false;
    private boolean mSwipeToDismiss = false;
    private boolean mIsLightMode = false;

    public CustomToast(Context context, int i) {
        this.mDefaultLayoutId = i;
        init(context, null);
    }

    public CustomToast(Context context) {
        init(context, null);
    }

    public CustomToast(Context context, View view) {
        init(context, view);
    }

    private void init(Context context, View view) {
        this.mContext = context;
        this.mMargin = new int[4];
        if (isToastRelease()) {
            return;
        }
        this.mViewGroup = new FrameLayout(this.mContext);
        this.mStartAnimHeight = (int) context.getResources().getDimension(R.dimen.toast_start_anim_height);
        this.mViewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.ies.uikit.toast.CustomToast.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    CustomToast.this.mActionDownY = motionEvent.getY();
                    CustomToast customToast = CustomToast.this;
                    customToast.startScaleAnimation(customToast.mScaleLargeAnimatorSet, 1.0f, 0.98f);
                    return false;
                }
                if (action == 1) {
                    CustomToast customToast2 = CustomToast.this;
                    customToast2.startScaleAnimation(customToast2.mScaleSmallAnimatorSet, 0.98f, 1.0f);
                    if (!CustomToast.this.mSwipeToDismiss || CustomToast.this.mActionCurrentY - CustomToast.this.mActionDownY >= 0.0f || Math.abs(CustomToast.this.mActionCurrentY - CustomToast.this.mActionDownY) <= 20.0f) {
                        return false;
                    }
                    CustomToastHandler.getInstance().hideToast(CustomToast.this);
                    return false;
                }
                if (action == 2) {
                    CustomToast.this.mActionCurrentY = motionEvent.getY();
                    return false;
                }
                if (action != 3) {
                    return false;
                }
                CustomToast customToast3 = CustomToast.this;
                customToast3.startScaleAnimation(customToast3.mScaleSmallAnimatorSet, 0.98f, 1.0f);
                return false;
            }
        });
        if (view != null) {
            this.mContentView = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScaleAnimation(AnimatorSet animatorSet, float f, float f2) {
        if (this.mScalable) {
            if (animatorSet == null && this.mContentView != null) {
                animatorSet = new AnimatorSet();
                animatorSet.play(ObjectAnimator.ofFloat(this.mViewGroup, "scaleX", f, f2)).with(ObjectAnimator.ofFloat(this.mViewGroup, "scaleY", f, f2));
                animatorSet.setDuration(80L);
            }
            if (animatorSet != null) {
                animatorSet.start();
            }
        }
    }

    private View inflateContentView(int i) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (i == this.mLastLayoutId) {
            return this.mLastToast;
        }
        if (i == -1 && (i = this.mDefaultLayoutId) <= 0) {
            if (this.mIsLightMode) {
                i = R.layout.custom_default_toast_light;
            } else {
                i = R.layout.custom_default_toast_deep;
            }
        }
        try {
            View inflate = from.inflate(i, this.mViewGroup, false);
            this.mLastToast = inflate;
            this.mLastLayoutId = i;
            return inflate;
        } catch (InflateException unused) {
            if (this.mLastToast == null) {
                this.mLastToast = from.inflate(R.layout.custom_default_toast_deep, this.mViewGroup, false);
            }
            this.mLastLayoutId = R.layout.custom_default_toast_deep;
            return this.mLastToast;
        }
    }

    private void initView(String str, int i) {
        if (isToastRelease()) {
            return;
        }
        this.mText = str;
        View view = this.mContentView;
        if (view != null) {
            this.mTextView = (TextView) view.findViewById(R.id.text);
            this.mImageView = (ImageView) this.mContentView.findViewById(R.id.icon);
        }
        ImageView imageView = this.mImageView;
        if (imageView != null && i == -1) {
            imageView.setVisibility(8);
        }
        this.mContentView.measure(View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE));
    }

    public CustomToast setMargin(int i, int i2, int i3, int i4) {
        int[] iArr = this.mMargin;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        return this;
    }

    public CustomToast setMarginTop(int i) {
        this.mMargin[0] = i;
        return this;
    }

    public CustomToast setMarginBottom(int i) {
        this.mMargin[1] = i;
        return this;
    }

    public CustomToast setMarginRight(int i) {
        this.mMargin[2] = i;
        return this;
    }

    public CustomToast setMarginLeft(int i) {
        this.mMargin[3] = i;
        return this;
    }

    public CustomToast setScalable(boolean z) {
        this.mScalable = z;
        return this;
    }

    public CustomToast setGravity(int i) {
        this.mGravity = i;
        return this;
    }

    public CustomToast setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public CustomToast setLightMode(boolean z) {
        this.mIsLightMode = z;
        return this;
    }

    public CustomToast setSwipeToDismiss(boolean z) {
        this.mSwipeToDismiss = z;
        return this;
    }

    public void showToast(String str) {
        this.mContentView = inflateContentView(-1);
        initView(str, -1);
        CustomToastHandler.getInstance().add(this);
    }

    public void showToast(String str, int i) {
        this.mContentView = inflateContentView(-1);
        initView(str, i);
        CustomToastHandler.getInstance().add(this);
    }

    public void showToast(int i, IViewInflatedListener iViewInflatedListener) {
        View inflateContentView = inflateContentView(i);
        this.mContentView = inflateContentView;
        if (iViewInflatedListener != null) {
            iViewInflatedListener.onViewInflated(inflateContentView);
        }
        initView("", -1);
        CustomToastHandler.getInstance().add(this);
    }

    public void setShowAndHideAnimatorSet(AnimatorSet animatorSet, AnimatorSet animatorSet2) {
        this.mShowAnimatorSet = animatorSet;
        this.mHideAnimatorSet = animatorSet2;
    }

    public AnimatorSet getShowAnimatorSet() {
        if (this.mShowAnimatorSet == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.mShowAnimatorSet = animatorSet;
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.mViewGroup, "translationY", -this.mStartAnimHeight, 0.0f), ObjectAnimator.ofFloat(this.mViewGroup, "alpha", 0.0f, 1.0f));
            this.mShowAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mShowAnimatorSet.setDuration(320L);
        }
        return this.mShowAnimatorSet;
    }

    public AnimatorSet getHideAnimatorSet() {
        if (this.mHideAnimatorSet == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.mHideAnimatorSet = animatorSet;
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.mViewGroup, "translationY", 0.0f, -this.mStartAnimHeight), ObjectAnimator.ofFloat(this.mViewGroup, "alpha", 1.0f, 0.0f));
            this.mHideAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mHideAnimatorSet.setDuration(320L);
        }
        return this.mHideAnimatorSet;
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getContentView() {
        View view = this.mContentView;
        return view == null ? this.mViewGroup : view;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean isShowing() {
        View view = this.mContentView;
        return view != null && view.isShown();
    }

    public String getToastMessage() {
        return this.mText;
    }

    public boolean isDismissing() {
        return this.mIsDismissing;
    }

    public void setDismissing(boolean z) {
        this.mIsDismissing = z;
    }

    public void dismiss() {
        if (this.mIsShowing) {
            ViewGroup viewGroup = this.mViewGroup;
            if (viewGroup != null && viewGroup.getParent() != null) {
                this.mWindowManager.removeView(this.mViewGroup);
                this.mViewGroup.removeView(this.mContentView);
            }
            this.mIsShowing = false;
        }
    }

    public void onStop() {
        onDestroyed();
    }

    public void onDestroyed() {
        dismiss();
        this.mContentView.clearAnimation();
        this.mContext = null;
        CustomToastHandler.getInstance().remove(this);
    }

    public void onPause() {
        this.mOnPause = true;
    }

    public void onResume() {
        this.mOnPause = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void show() {
        if (isToastRelease()) {
            return;
        }
        if (this.mTextView != null && !StringUtils.isEmpty(this.mText)) {
            this.mTextView.setText(this.mText);
        }
        this.mIsShowing = true;
        this.mViewGroup.removeAllViews();
        if (this.mContentView.getParent() == null) {
            this.mViewGroup.addView(this.mContentView);
        } else {
            ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
            this.mViewGroup.addView(this.mContentView);
        }
        if (this.mLayoutParams == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 2, 262280, -2);
            layoutParams.flags = 262280;
            layoutParams.gravity = this.mGravity;
            if (layoutParams.gravity == 48) {
                layoutParams.y = this.mMargin[0];
            }
            this.mLayoutParams = layoutParams;
        }
        this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        if (this.mViewGroup.getParent() != null) {
            this.mWindowManager.removeView(this.mViewGroup);
        }
        try {
            this.mWindowManager.addView(this.mViewGroup, this.mLayoutParams);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isToastRelease() {
        return this.mContext == null || this.mOnPause;
    }
}
