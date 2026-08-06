package com.lynx.tasm.behavior.ui.list.container;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: classes7.dex */
public class ListCustomScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE = 0;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    public ListCustomScroller(Context context) {
        this(context, null);
    }

    public ListCustomScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public ListCustomScroller(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.mFlywheel = z;
        this.mScrollerX = new SplineOverScroller(context);
        this.mScrollerY = new SplineOverScroller(context);
    }

    public final void setFriction(float f) {
        this.mScrollerX.setFriction(f);
        this.mScrollerY.setFriction(f);
    }

    public final boolean isFinished() {
        return this.mScrollerX.mFinished && this.mScrollerY.mFinished;
    }

    public final int getCurrX() {
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getPreviousX() {
        return this.mScrollerX.mPreviousPosition;
    }

    public final int getCurrY() {
        return this.mScrollerY.mCurrentPosition;
    }

    public final int getPreviousY() {
        return this.mScrollerY.mPreviousPosition;
    }

    public final int getStartX() {
        return this.mScrollerX.mStart;
    }

    public final int getStartY() {
        return this.mScrollerY.mStart;
    }

    public final int getDuration() {
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public boolean computeScrollOffset() {
        if (isFinished()) {
            return false;
        }
        int i = this.mMode;
        if (i == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
            int i2 = this.mScrollerX.mDuration;
            if (currentAnimationTimeMillis < i2) {
                float interpolation = this.mInterpolator.getInterpolation(((float) currentAnimationTimeMillis) / i2);
                this.mScrollerX.updateScroll(interpolation);
                this.mScrollerY.updateScroll(interpolation);
            } else {
                abortAnimation();
            }
        } else if (i == 1) {
            if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinished()) {
                this.mScrollerX.finish();
            }
            if (!this.mScrollerY.mFinished && !this.mScrollerY.update() && !this.mScrollerY.continueWhenFinished()) {
                this.mScrollerY.finish();
            }
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.mScrollerX.startScroll(i, i3, i5);
        this.mScrollerY.startScroll(i2, i4, i5);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        if (!this.mFlywheel || isFinished()) {
            i13 = i3;
        } else {
            float f = this.mScrollerX.mCurrVelocity;
            float f2 = this.mScrollerY.mCurrVelocity;
            i13 = i3;
            float f3 = i13;
            if (Math.signum(f3) == Math.signum(f)) {
                i14 = i4;
                float f4 = i14;
                if (Math.signum(f4) == Math.signum(f2)) {
                    i15 = (int) (f4 + f2);
                    i16 = (int) (f3 + f);
                    this.mMode = 1;
                    this.mScrollerX.fling(i, i16, i5, i6, i9, ((float) i16) >= 0.0f ? i11 : i12);
                    this.mScrollerY.fling(i2, i15, i7, i8, i10, ((float) i15) >= 0.0f ? i11 : i12);
                }
                i15 = i14;
                i16 = i13;
                this.mMode = 1;
                this.mScrollerX.fling(i, i16, i5, i6, i9, ((float) i16) >= 0.0f ? i11 : i12);
                this.mScrollerY.fling(i2, i15, i7, i8, i10, ((float) i15) >= 0.0f ? i11 : i12);
            }
        }
        i14 = i4;
        i15 = i14;
        i16 = i13;
        this.mMode = 1;
        this.mScrollerX.fling(i, i16, i5, i6, i9, ((float) i16) >= 0.0f ? i11 : i12);
        this.mScrollerY.fling(i2, i15, i7, i8, i10, ((float) i15) >= 0.0f ? i11 : i12);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.mScrollerX.notifyEdgeReached(i, i2, i3);
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public boolean isScrollingInDirection(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.mScrollerX.mFinal - this.mScrollerX.mStart)) && Math.signum(f2) == Math.signum((float) (this.mScrollerY.mFinal - this.mScrollerY.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class SplineOverScroller {
        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static final int SPLINE = 0;
        private static final float START_TENSION = 0.5f;
        private float mCurrVelocity;
        private int mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private int mFinal;
        private int mOver;
        private float mPhysicalCoeff;
        private int mPreviousPosition;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mStart;
        private long mStartTime;
        private int mVelocity;
        private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] SPLINE_POSITION = new float[101];
        private static final float[] SPLINE_TIME = new float[101];
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean mFinished = true;

        private float adjustDurationFromLimitedDistance(float f, float f2, int i) {
            return (float) (((i * 1.0d) * f) / f2);
        }

        private static float getDeceleration(int i) {
            if (i > 0) {
                return -2000.0f;
            }
            return GRAVITY;
        }

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i = 0; i < 100; i++) {
                float f13 = i / 100.0f;
                float f14 = 1.0f;
                while (true) {
                    f = 2.0f;
                    f2 = ((f14 - f11) / 2.0f) + f11;
                    f3 = 3.0f;
                    f4 = 1.0f - f2;
                    f5 = f2 * 3.0f * f4;
                    f6 = f2 * f2 * f2;
                    float f15 = (((f4 * P1) + (f2 * P2)) * f5) + f6;
                    if (Math.abs(f15 - f13) < 1.0E-5d) {
                        break;
                    } else if (f15 > f13) {
                        f14 = f2;
                    } else {
                        f11 = f2;
                    }
                }
                SPLINE_POSITION[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
                float f16 = 1.0f;
                while (true) {
                    f7 = ((f16 - f12) / f) + f12;
                    f8 = 1.0f - f7;
                    f9 = f7 * f3 * f8;
                    f10 = f7 * f7 * f7;
                    float f17 = (((f8 * 0.5f) + f7) * f9) + f10;
                    if (Math.abs(f17 - f13) < 1.0E-5d) {
                        break;
                    }
                    if (f17 > f13) {
                        f16 = f7;
                    } else {
                        f12 = f7;
                    }
                    f = 2.0f;
                    f3 = 3.0f;
                }
                SPLINE_TIME[i] = (f9 * ((f8 * P1) + (f7 * P2))) + f10;
            }
            float[] fArr = SPLINE_POSITION;
            SPLINE_TIME[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.mFlingFriction = f;
        }

        SplineOverScroller(Context context) {
            this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void updateScroll(float f) {
            this.mPreviousPosition = this.mCurrentPosition;
            this.mCurrentPosition = this.mStart + Math.round(f * (this.mFinal - r0));
        }

        private void adjustDuration(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (abs * 100.0f);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                int i5 = i4 + 1;
                float[] fArr = SPLINE_TIME;
                float f2 = fArr[i4];
                this.mDuration = (int) (this.mDuration * (f2 + (((abs - f) / ((i5 / 100.0f) - f)) * (fArr[i5] - f2))));
            }
        }

        void startScroll(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.mPreviousPosition = i;
            this.mCurrentPosition = i;
            this.mFinal = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
        }

        void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        void setFinalPosition(int i) {
            this.mFinal = i;
            this.mSplineDistance = i - this.mStart;
            this.mFinished = false;
        }

        void extendDuration(int i) {
            int currentAnimationTimeMillis = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) + i;
            this.mSplineDuration = currentAnimationTimeMillis;
            this.mDuration = currentAnimationTimeMillis;
            this.mFinished = false;
        }

        boolean springback(int i, int i2, int i3) {
            this.mFinished = true;
            this.mPreviousPosition = this.mCurrentPosition;
            this.mFinal = i;
            this.mStart = i;
            this.mCurrentPosition = i;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                startSpringback(i, i2, 0);
            } else if (i > i3) {
                startSpringback(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void startSpringback(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mPreviousPosition = this.mCurrentPosition;
            this.mStart = i;
            this.mCurrentPosition = i;
            this.mFinal = i2;
            int i4 = i - i2;
            this.mDeceleration = getDeceleration(i4);
            this.mVelocity = -i4;
            this.mOver = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.mDeceleration) * 1000.0d);
        }

        void fling(int i, int i2, int i3, int i4, int i5, int i6) {
            double d;
            this.mOver = i5;
            this.mFinished = false;
            this.mVelocity = i2;
            float f = i2;
            this.mCurrVelocity = f;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mPreviousPosition = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                startAfterEdge(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            if (i2 != 0) {
                int splineFlingDuration = getSplineFlingDuration(i2);
                this.mSplineDuration = splineFlingDuration;
                this.mDuration = splineFlingDuration;
                d = getSplineFlingDistance(i2);
            } else {
                d = 0.0d;
            }
            if (i2 != 0 && i6 < d) {
                int splineDurationFromDistance = (int) ((getSplineDurationFromDistance(r7) + adjustDurationFromLimitedDistance(r7, (float) d, this.mDuration)) / 2.0d);
                this.mSplineDuration = splineDurationFromDistance;
                this.mDuration = splineDurationFromDistance;
                this.mSplineDistance = (int) (i6 * Math.signum(f));
            } else {
                this.mSplineDistance = (int) (d * Math.signum(f));
            }
            int i7 = i + this.mSplineDistance;
            this.mFinal = i7;
            if (i7 < i3) {
                adjustDuration(this.mStart, i7, i3);
                this.mFinal = i3;
            }
            int i8 = this.mFinal;
            if (i8 > i4) {
                adjustDuration(this.mStart, i8, i4);
                this.mFinal = i4;
            }
        }

        private double getSplineDeceleration(int i) {
            return Math.log((Math.abs(i) * INFLEXION) / (this.mFlingFriction * this.mPhysicalCoeff));
        }

        private double getSplineFlingDistance(int i) {
            double splineDeceleration = getSplineDeceleration(i);
            float f = DECELERATION_RATE;
            return this.mFlingFriction * this.mPhysicalCoeff * Math.exp((f / (f - 1.0d)) * splineDeceleration);
        }

        private float getSplineDurationFromDistance(float f) {
            double d = DECELERATION_RATE - 1.0d;
            return (float) (Math.exp((Math.log(f / (this.mFlingFriction * this.mPhysicalCoeff)) / (DECELERATION_RATE / d)) / d) * 1000.0d);
        }

        private int getSplineFlingDuration(int i) {
            return (int) (Math.exp(getSplineDeceleration(i) / (DECELERATION_RATE - 1.0d)) * 1000.0d);
        }

        private void fitOnBounceCurve(int i, int i2, int i3) {
            float f = (-i3) / this.mDeceleration;
            float f2 = i3;
            float sqrt = (float) Math.sqrt((((((f2 * f2) / 2.0f) / Math.abs(r1)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.mDeceleration));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mPreviousPosition = this.mCurrentPosition;
            this.mStart = i2;
            this.mCurrentPosition = i2;
            this.mVelocity = (int) ((-this.mDeceleration) * sqrt);
        }

        private void startBounceAfterEdge(int i, int i2, int i3) {
            this.mDeceleration = getDeceleration(i3 == 0 ? i - i2 : i3);
            fitOnBounceCurve(i, i2, i3);
            onEdgeReached();
        }

        private void startAfterEdge(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            if ((i - i5) * i4 >= 0) {
                startBounceAfterEdge(i, i5, i4);
            } else if (getSplineFlingDistance(i4) > Math.abs(r4)) {
                fling(i, i4, z ? i2 : i, z ? i : i3, this.mOver, Integer.MAX_VALUE);
            } else {
                startSpringback(i, i5, i4);
            }
        }

        void notifyEdgeReached(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.mOver = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i, i2, i2, (int) this.mCurrVelocity);
            }
        }

        private void onEdgeReached() {
            int i = this.mVelocity;
            float f = i * i;
            float abs = f / (Math.abs(this.mDeceleration) * 2.0f);
            float signum = Math.signum(this.mVelocity);
            int i2 = this.mOver;
            if (abs > i2) {
                this.mDeceleration = ((-signum) * f) / (i2 * 2.0f);
                abs = i2;
            }
            this.mOver = (int) abs;
            this.mState = 2;
            int i3 = this.mStart;
            int i4 = this.mVelocity;
            if (i4 <= 0) {
                abs = -abs;
            }
            this.mFinal = i3 + ((int) abs);
            this.mDuration = -((int) ((i4 * 1000.0f) / this.mDeceleration));
        }

        boolean continueWhenFinished() {
            int i = this.mState;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                if (i == 2) {
                    this.mStartTime += this.mDuration;
                    startSpringback(this.mFinal, this.mStart, 0);
                }
            } else {
                if (this.mDuration >= this.mSplineDuration) {
                    return false;
                }
                this.mPreviousPosition = this.mCurrentPosition;
                int i2 = this.mFinal;
                this.mStart = i2;
                this.mCurrentPosition = i2;
                int i3 = (int) this.mCurrVelocity;
                this.mVelocity = i3;
                this.mDeceleration = getDeceleration(i3);
                this.mStartTime += this.mDuration;
                onEdgeReached();
            }
            update();
            return true;
        }

        boolean update() {
            float f;
            float f2;
            double d;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis == 0) {
                return this.mDuration > 0;
            }
            int i = this.mDuration;
            if (currentAnimationTimeMillis > i) {
                return false;
            }
            int i2 = this.mState;
            if (i2 == 0) {
                int i3 = this.mSplineDuration;
                float f3 = ((float) currentAnimationTimeMillis) / i3;
                int i4 = (int) (f3 * 100.0f);
                if (i4 >= 0) {
                    if (i4 < 100) {
                        float f4 = i4 / 100.0f;
                        int i5 = i4 + 1;
                        float[] fArr = SPLINE_POSITION;
                        float f5 = fArr[i4];
                        f2 = (fArr[i5] - f5) / ((i5 / 100.0f) - f4);
                        f = f5 + ((f3 - f4) * f2);
                    } else {
                        f = 1.0f;
                        f2 = 0.0f;
                    }
                    int i6 = this.mSplineDistance;
                    this.mCurrVelocity = ((f2 * i6) / i3) * 1000.0f;
                    d = f * i6;
                }
                d = 0.0d;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    float f6 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    int i7 = this.mVelocity;
                    float f7 = this.mDeceleration;
                    this.mCurrVelocity = i7 + (f7 * f6);
                    d = (i7 * f6) + (((f7 * f6) * f6) / 2.0f);
                }
                d = 0.0d;
            } else {
                float f8 = ((float) currentAnimationTimeMillis) / i;
                float f9 = f8 * f8;
                float signum = Math.signum(this.mVelocity);
                int i8 = this.mOver;
                this.mCurrVelocity = signum * i8 * 6.0f * ((-f8) + f9);
                d = i8 * signum * ((3.0f * f9) - ((2.0f * f8) * f9));
            }
            this.mPreviousPosition = this.mCurrentPosition;
            this.mCurrentPosition = this.mStart + ((int) Math.round(d));
            return true;
        }
    }
}
