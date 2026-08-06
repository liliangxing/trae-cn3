package com.lynx.tasm.animation;

import android.util.SparseArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.lynx.tasm.base.LLog;

/* loaded from: classes6.dex */
public class InterpolatorFactory {
    private static final SparseArray<BaseInterpolator> INTERPOLATOR = new SparseArray<BaseInterpolator>() { // from class: com.lynx.tasm.animation.InterpolatorFactory.1
        {
            put(0, new LinearInterpolator());
            put(1, new AccelerateInterpolator());
            put(2, new DecelerateInterpolator());
            put(3, new AccelerateDecelerateInterpolator());
        }
    };
    private static final int LynxAnimationStepsJumpBoth = 4;
    private static final int LynxAnimationStepsJumpEnd = 2;
    private static final int LynxAnimationStepsJumpNone = 3;
    private static final int LynxAnimationStepsJumpStart = 1;

    public static Interpolator getInterpolator(AnimationInfo animationInfo) {
        int timingType = animationInfo.getTimingType();
        switch (timingType) {
            case 0:
            case 1:
            case 2:
            case 3:
                return INTERPOLATOR.get(timingType);
            case 4:
                return PathInterpolatorCompat.create(animationInfo.getX1(), animationInfo.getY1());
            case 5:
                return PathInterpolatorCompat.create(animationInfo.getX1(), animationInfo.getY1(), animationInfo.getX2(), animationInfo.getY2());
            case 6:
                return new StepsInterpolation(animationInfo.getCount(), animationInfo.getStepsType());
            default:
                LLog.DTHROW(new RuntimeException("layout animation don't support interpolator:" + timingType));
                return INTERPOLATOR.get(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class StepsInterpolation implements Interpolator {
        private int mCount;
        private int mJump;

        StepsInterpolation(int i, int i2) {
            this.mCount = i;
            this.mJump = i2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i;
            int i2;
            float f2;
            int i3 = this.mJump;
            if (i3 == 1) {
                i = this.mCount;
                i2 = ((int) (f * i)) + 1;
                if (i2 > i) {
                    i2 = i;
                }
            } else {
                if (i3 != 2) {
                    if (i3 == 3) {
                        int i4 = this.mCount;
                        int i5 = (int) (f * i4);
                        if (i5 == i4) {
                            i5--;
                        }
                        f2 = i5;
                        i = i4 - 1;
                    } else {
                        if (i3 != 4) {
                            return 0.0f;
                        }
                        int i6 = this.mCount;
                        int i7 = ((int) (f * i6)) + 1;
                        if (i7 > i6) {
                            i7 = i6;
                        }
                        f2 = i7;
                        i = i6 + 1;
                    }
                    return f2 / i;
                }
                i = this.mCount;
                i2 = (int) (f * i);
                if (i2 == i) {
                    i2--;
                }
            }
            f2 = i2;
            return f2 / i;
        }
    }
}
