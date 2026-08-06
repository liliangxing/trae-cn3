package com.bytedance.ies.uikit.refresh;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.common.utility.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class I18nSwipeRefreshLayout extends ViewGroup {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {R.attr.enabled};
    private static final String LOG_TAG = "I18nSwipeRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private int mCircleHeight;
    private CircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCircleWidth;
    private int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNotify;
    private boolean mOriginalOffsetCalculated;
    protected int mOriginalOffsetTop;
    private MaterialProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    private boolean mRefreshing;
    private boolean mReturningToStart;
    private boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    private LeanRefreshListener mSmartListener;
    private float mSpinnerFinalOffset;
    private float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private int mTouchSlop;
    private boolean mUsingCustomStart;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface LeanRefreshListener {
        void onCancelRefresh();

        void onGoingRefresh();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    private boolean isAlphaUsedForScale() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        this.mProgress.setAlpha(i);
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.mScale = z;
        this.mCircleView.setVisibility(8);
        this.mCurrentTargetOffsetTop = i;
        this.mOriginalOffsetTop = i;
        this.mSpinnerFinalOffset = i2;
        this.mUsingCustomStart = true;
        this.mCircleView.invalidate();
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.mSpinnerFinalOffset = i;
        this.mScale = z;
        this.mCircleView.invalidate();
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                int i2 = (int) (displayMetrics.density * 56.0f);
                this.mCircleWidth = i2;
                this.mCircleHeight = i2;
            } else {
                int i3 = (int) (displayMetrics.density * 40.0f);
                this.mCircleWidth = i3;
                this.mCircleHeight = i3;
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.updateSizes(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public I18nSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public I18nSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mOriginalOffsetCalculated = false;
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new Animation.AnimationListener() { // from class: com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (I18nSwipeRefreshLayout.this.mRefreshing) {
                    I18nSwipeRefreshLayout.this.mProgress.setAlpha(255);
                    I18nSwipeRefreshLayout.this.mProgress.start();
                    if (I18nSwipeRefreshLayout.this.mNotify && I18nSwipeRefreshLayout.this.mListener != null) {
                        I18nSwipeRefreshLayout.this.mListener.onRefresh();
                    }
                } else {
                    I18nSwipeRefreshLayout.this.mProgress.stop();
                    I18nSwipeRefreshLayout.this.mCircleView.setVisibility(8);
                    I18nSwipeRefreshLayout.this.setColorViewAlpha(255);
                    if (I18nSwipeRefreshLayout.this.mScale) {
                        I18nSwipeRefreshLayout.this.setAnimationProgress(0.0f);
                    } else {
                        I18nSwipeRefreshLayout i18nSwipeRefreshLayout = I18nSwipeRefreshLayout.this;
                        i18nSwipeRefreshLayout.setTargetOffsetTopAndBottom(i18nSwipeRefreshLayout.mOriginalOffsetTop - I18nSwipeRefreshLayout.this.mCurrentTargetOffsetTop, true);
                    }
                }
                I18nSwipeRefreshLayout i18nSwipeRefreshLayout2 = I18nSwipeRefreshLayout.this;
                i18nSwipeRefreshLayout2.mCurrentTargetOffsetTop = i18nSwipeRefreshLayout2.mCircleView.getTop();
            }
        };
        this.mAnimateToCorrectPosition = new Animation() { // from class: com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                I18nSwipeRefreshLayout.this.setTargetOffsetTopAndBottom((I18nSwipeRefreshLayout.this.mFrom + ((int) ((((int) (!I18nSwipeRefreshLayout.this.mUsingCustomStart ? I18nSwipeRefreshLayout.this.mSpinnerFinalOffset - Math.abs(I18nSwipeRefreshLayout.this.mOriginalOffsetTop) : I18nSwipeRefreshLayout.this.mSpinnerFinalOffset)) - I18nSwipeRefreshLayout.this.mFrom) * f))) - I18nSwipeRefreshLayout.this.mCircleView.getTop(), false);
            }
        };
        this.mAnimateToStartPosition = new Animation() { // from class: com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                I18nSwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleWidth = (int) (displayMetrics.density * 40.0f);
        this.mCircleHeight = (int) (displayMetrics.density * 40.0f);
        createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        float f = displayMetrics.density * 64.0f;
        this.mSpinnerFinalOffset = f;
        this.mTotalDragDistance = f;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mCircleViewIndex;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext(), CIRCLE_BG_LIGHT, 20.0f);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(getContext(), this);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.setBackgroundColor(CIRCLE_BG_LIGHT);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    public void setStartEndRefreshListener(LeanRefreshListener leanRefreshListener) {
        this.mSmartListener = leanRefreshListener;
    }

    public void setRefreshing(boolean z) {
        float f;
        if (z && this.mRefreshing != z) {
            this.mRefreshing = z;
            if (!this.mUsingCustomStart) {
                f = this.mSpinnerFinalOffset + this.mOriginalOffsetTop;
            } else {
                f = this.mSpinnerFinalOffset;
            }
            setTargetOffsetTopAndBottom(((int) f) - this.mCurrentTargetOffsetTop, true);
            this.mNotify = false;
            startScaleUpAnimation(this.mRefreshListener);
            return;
        }
        setRefreshing(z, false);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        Animation animation = new Animation() { // from class: com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                I18nSwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.mScaleAnimation = animation;
        animation.setDuration(this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationProgress(float f) {
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (f * 255.0f));
        } else {
            ViewCompat.setScaleX(this.mCircleView, f);
            ViewCompat.setScaleY(this.mCircleView, f);
        }
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (z) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        Animation animation = new Animation() { // from class: com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                I18nSwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation = animation;
        animation.setDuration(150L);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private Animation startAlphaAnimation(final int i, final int i2) {
        if (this.mScale && isAlphaUsedForScale()) {
            return null;
        }
        Animation animation = new Animation() { // from class: com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                I18nSwipeRefreshLayout.this.mProgress.setAlpha((int) (i + ((i2 - r0) * f)));
            }
        };
        animation.setDuration(300L);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(animation);
        return animation;
    }

    public void setProgressBackgroundColor(int i) {
        this.mCircleView.setBackgroundColor(i);
        this.mProgress.setBackgroundColor(getResources().getColor(i));
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(iArr);
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        int measuredHeight2 = this.mCircleView.getMeasuredHeight();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
        if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
            this.mOriginalOffsetCalculated = true;
            int i3 = -this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = i3;
            this.mCurrentTargetOffsetTop = i3;
        }
        this.mCircleViewIndex = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.mCircleView) {
                this.mCircleViewIndex = i4;
                return;
            }
        }
    }

    public boolean canChildScrollUp() {
        return ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            float motionEventY = getMotionEventY(motionEvent, pointerId);
            if (motionEventY == -1.0f) {
                return false;
            }
            this.mInitialMotionY = motionEventY;
        } else {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                        return this.mIsBeingDragged;
                    }
                }
            }
            this.mIsBeingDragged = false;
            Logger.d(LOG_TAG, "intercept cancel refresh");
            LeanRefreshListener leanRefreshListener = this.mSmartListener;
            if (leanRefreshListener != null) {
                leanRefreshListener.onCancelRefresh();
            }
            this.mActivePointerId = -1;
            return this.mIsBeingDragged;
        }
        int i = this.mActivePointerId;
        if (i == -1) {
            Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
        }
        float motionEventY2 = getMotionEventY(motionEvent, i);
        if (motionEventY2 == -1.0f) {
            return false;
        }
        if (motionEventY2 - this.mInitialMotionY > this.mTouchSlop && !this.mIsBeingDragged) {
            this.mIsBeingDragged = true;
            Logger.d(LOG_TAG, "intercept going refresh");
            LeanRefreshListener leanRefreshListener2 = this.mSmartListener;
            if (leanRefreshListener2 != null) {
                leanRefreshListener2.onGoingRefresh();
            }
            this.mProgress.setAlpha(76);
        }
        return this.mIsBeingDragged;
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private boolean isAnimationRunning(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp()) {
            return false;
        }
        if (actionMasked == 0) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mIsBeingDragged = false;
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    if (findPointerIndex < 0) {
                        Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    try {
                        float y = (MotionEventCompat.getY(motionEvent, findPointerIndex) - this.mInitialMotionY) * DRAG_RATE;
                        if (this.mIsBeingDragged) {
                            this.mProgress.showArrow(true);
                            float f = y / this.mTotalDragDistance;
                            if (f < 0.0f) {
                                return false;
                            }
                            float min = Math.min(1.0f, Math.abs(f));
                            float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                            float abs = Math.abs(y) - this.mTotalDragDistance;
                            float f2 = this.mUsingCustomStart ? this.mSpinnerFinalOffset - this.mOriginalOffsetTop : this.mSpinnerFinalOffset;
                            double max2 = Math.max(0.0f, Math.min(abs, f2 * DECELERATE_INTERPOLATION_FACTOR) / f2) / 4.0f;
                            float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
                            int i = this.mOriginalOffsetTop + ((int) ((f2 * min) + (f2 * pow * DECELERATE_INTERPOLATION_FACTOR)));
                            if (this.mCircleView.getVisibility() != 0) {
                                this.mCircleView.setVisibility(0);
                            }
                            if (!this.mScale) {
                                ViewCompat.setScaleX(this.mCircleView, 1.0f);
                                ViewCompat.setScaleY(this.mCircleView, 1.0f);
                            }
                            float f3 = this.mTotalDragDistance;
                            if (y < f3) {
                                if (this.mScale) {
                                    setAnimationProgress(y / f3);
                                }
                                if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                                    startProgressAlphaStartAnimation();
                                }
                                this.mProgress.setStartEndTrim(0.0f, Math.min(MAX_PROGRESS_ANGLE, max * MAX_PROGRESS_ANGLE));
                                this.mProgress.setArrowScale(Math.min(1.0f, max));
                            } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
                                startProgressAlphaMaxAnimation();
                            }
                            this.mProgress.setProgressRotation((((max * 0.4f) - 0.25f) + (pow * DECELERATE_INTERPOLATION_FACTOR)) * DRAG_RATE);
                            setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop, true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                    } else if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            int i2 = this.mActivePointerId;
            if (i2 == -1) {
                if (actionMasked == 1) {
                    Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                }
                return false;
            }
            try {
                float y2 = (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i2)) - this.mInitialMotionY) * DRAG_RATE;
                this.mIsBeingDragged = false;
                if (y2 > this.mTotalDragDistance) {
                    setRefreshing(true, true);
                } else {
                    this.mRefreshing = false;
                    this.mProgress.setStartEndTrim(0.0f, 0.0f);
                    animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, !this.mScale ? new Animation.AnimationListener() { // from class: com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout.5
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (I18nSwipeRefreshLayout.this.mScale) {
                                return;
                            }
                            I18nSwipeRefreshLayout.this.startScaleDownAnimation(null);
                        }
                    } : null);
                    this.mProgress.showArrow(false);
                    Logger.d(LOG_TAG, "on touch cancel refresh");
                    LeanRefreshListener leanRefreshListener = this.mSmartListener;
                    if (leanRefreshListener != null) {
                        leanRefreshListener.onCancelRefresh();
                    }
                }
                this.mActivePointerId = -1;
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
        return true;
    }

    private void animateOffsetToCorrectPosition(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToStart(float f) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) ((this.mOriginalOffsetTop - r0) * f))) - this.mCircleView.getTop(), false);
    }

    private void startScaleDownReturnToStartAnimation(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        if (isAlphaUsedForScale()) {
            this.mStartingScale = this.mProgress.getAlpha();
        } else {
            this.mStartingScale = ViewCompat.getScaleX(this.mCircleView);
        }
        Animation animation = new Animation() { // from class: com.bytedance.ies.uikit.refresh.I18nSwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                I18nSwipeRefreshLayout.this.setAnimationProgress(I18nSwipeRefreshLayout.this.mStartingScale + ((-I18nSwipeRefreshLayout.this.mStartingScale) * f));
                I18nSwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.mScaleDownToStartAnimation = animation;
        animation.setDuration(150L);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int i, boolean z) {
        this.mCircleView.bringToFront();
        this.mCircleView.offsetTopAndBottom(i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
    }
}
