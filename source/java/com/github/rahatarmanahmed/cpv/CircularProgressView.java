package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class CircularProgressView extends View {
    private static final float INDETERMINANT_MIN_SWEEP = 15.0f;
    private float actualProgress;
    private int animDuration;
    private int animSteps;
    private int animSwoopDuration;
    private int animSyncDuration;
    private boolean autostartAnimation;
    private RectF bounds;
    private int color;
    private float currentProgress;
    private AnimatorSet indeterminateAnimator;
    private float indeterminateRotateOffset;
    private float indeterminateSweep;
    private float initialStartAngle;
    private boolean isIndeterminate;
    private List<CircularProgressViewListener> listeners;
    private float maxProgress;
    private Paint paint;
    private ValueAnimator progressAnimator;
    private int size;
    private float startAngle;
    private ValueAnimator startAngleRotate;
    private int thickness;

    public CircularProgressView(Context context) {
        super(context);
        this.size = 0;
        init(null, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.size = 0;
        init(attributeSet, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.size = 0;
        init(attributeSet, i);
    }

    protected void init(AttributeSet attributeSet, int i) {
        this.listeners = new ArrayList();
        initAttributes(attributeSet, i);
        this.paint = new Paint(1);
        updatePaint();
        this.bounds = new RectF();
    }

    private void initAttributes(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CircularProgressView, i, 0);
        Resources resources = getResources();
        this.currentProgress = obtainStyledAttributes.getFloat(R.styleable.CircularProgressView_cpv_progress, resources.getInteger(R.integer.cpv_default_progress));
        this.maxProgress = obtainStyledAttributes.getFloat(R.styleable.CircularProgressView_cpv_maxProgress, resources.getInteger(R.integer.cpv_default_max_progress));
        this.thickness = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircularProgressView_cpv_thickness, resources.getDimensionPixelSize(R.dimen.cpv_default_thickness));
        this.isIndeterminate = obtainStyledAttributes.getBoolean(R.styleable.CircularProgressView_cpv_indeterminate, resources.getBoolean(R.bool.cpv_default_is_indeterminate));
        this.autostartAnimation = obtainStyledAttributes.getBoolean(R.styleable.CircularProgressView_cpv_animAutostart, resources.getBoolean(R.bool.cpv_default_anim_autostart));
        float f = obtainStyledAttributes.getFloat(R.styleable.CircularProgressView_cpv_startAngle, resources.getInteger(R.integer.cpv_default_start_angle));
        this.initialStartAngle = f;
        this.startAngle = f;
        int identifier = getContext().getResources().getIdentifier("colorAccent", "attr", getContext().getPackageName());
        if (obtainStyledAttributes.hasValue(R.styleable.CircularProgressView_cpv_color)) {
            this.color = obtainStyledAttributes.getColor(R.styleable.CircularProgressView_cpv_color, resources.getColor(R.color.cpv_default_color));
        } else if (identifier != 0) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(identifier, typedValue, true);
            this.color = typedValue.data;
        } else {
            this.color = getContext().obtainStyledAttributes(new int[]{android.R.attr.colorAccent}).getColor(0, resources.getColor(R.color.cpv_default_color));
        }
        this.animDuration = obtainStyledAttributes.getInteger(R.styleable.CircularProgressView_cpv_animDuration, resources.getInteger(R.integer.cpv_default_anim_duration));
        this.animSwoopDuration = obtainStyledAttributes.getInteger(R.styleable.CircularProgressView_cpv_animSwoopDuration, resources.getInteger(R.integer.cpv_default_anim_swoop_duration));
        this.animSyncDuration = obtainStyledAttributes.getInteger(R.styleable.CircularProgressView_cpv_animSyncDuration, resources.getInteger(R.integer.cpv_default_anim_sync_duration));
        this.animSteps = obtainStyledAttributes.getInteger(R.styleable.CircularProgressView_cpv_animSteps, resources.getInteger(R.integer.cpv_default_anim_steps));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int measuredWidth = getMeasuredWidth() - paddingLeft;
        int measuredHeight = getMeasuredHeight() - paddingTop;
        if (measuredWidth >= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        this.size = measuredWidth;
        setMeasuredDimension(paddingLeft + measuredWidth, measuredWidth + paddingTop);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i >= i2) {
            i = i2;
        }
        this.size = i;
        updateBounds();
    }

    private void updateBounds() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        RectF rectF = this.bounds;
        int i = this.thickness;
        int i2 = this.size;
        rectF.set(paddingLeft + i, paddingTop + i, (i2 - paddingLeft) - i, (i2 - paddingTop) - i);
    }

    private void updatePaint() {
        this.paint.setColor(this.color);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.thickness);
        this.paint.setStrokeCap(Paint.Cap.BUTT);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = ((isInEditMode() ? this.currentProgress : this.actualProgress) / this.maxProgress) * 360.0f;
        if (!this.isIndeterminate) {
            canvas.drawArc(this.bounds, this.startAngle, f, false, this.paint);
        } else {
            canvas.drawArc(this.bounds, this.startAngle + this.indeterminateRotateOffset, this.indeterminateSweep, false, this.paint);
        }
    }

    public boolean isIndeterminate() {
        return this.isIndeterminate;
    }

    public void setIndeterminate(boolean z) {
        boolean z2 = this.isIndeterminate;
        boolean z3 = z2 == z;
        this.isIndeterminate = z;
        if (z3) {
            resetAnimation();
        }
        if (z2 != z) {
            Iterator<CircularProgressViewListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onModeChanged(z);
            }
        }
    }

    public int getThickness() {
        return this.thickness;
    }

    public void setThickness(int i) {
        this.thickness = i;
        updatePaint();
        updateBounds();
        invalidate();
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
        updatePaint();
        invalidate();
    }

    public float getMaxProgress() {
        return this.maxProgress;
    }

    public void setMaxProgress(float f) {
        this.maxProgress = f;
        invalidate();
    }

    public float getProgress() {
        return this.currentProgress;
    }

    public void setProgress(final float f) {
        this.currentProgress = f;
        if (!this.isIndeterminate) {
            ValueAnimator valueAnimator = this.progressAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.progressAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.actualProgress, f);
            this.progressAnimator = ofFloat;
            ofFloat.setDuration(this.animSyncDuration);
            this.progressAnimator.setInterpolator(new LinearInterpolator());
            this.progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CircularProgressView.this.actualProgress = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.progressAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Iterator it = CircularProgressView.this.listeners.iterator();
                    while (it.hasNext()) {
                        ((CircularProgressViewListener) it.next()).onProgressUpdateEnd(f);
                    }
                }
            });
            this.progressAnimator.start();
        }
        invalidate();
        Iterator<CircularProgressViewListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onProgressUpdate(f);
        }
    }

    public void addListener(CircularProgressViewListener circularProgressViewListener) {
        if (circularProgressViewListener != null) {
            this.listeners.add(circularProgressViewListener);
        }
    }

    public void removeListener(CircularProgressViewListener circularProgressViewListener) {
        this.listeners.remove(circularProgressViewListener);
    }

    public void startAnimation() {
        resetAnimation();
    }

    public void resetAnimation() {
        ValueAnimator valueAnimator = this.startAngleRotate;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.startAngleRotate.cancel();
        }
        ValueAnimator valueAnimator2 = this.progressAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.progressAnimator.cancel();
        }
        AnimatorSet animatorSet = this.indeterminateAnimator;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.indeterminateAnimator.cancel();
        }
        int i = 0;
        if (!this.isIndeterminate) {
            float f = this.initialStartAngle;
            this.startAngle = f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f + 360.0f);
            this.startAngleRotate = ofFloat;
            ofFloat.setDuration(this.animSwoopDuration);
            this.startAngleRotate.setInterpolator(new DecelerateInterpolator(2.0f));
            this.startAngleRotate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    CircularProgressView.this.startAngle = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.startAngleRotate.start();
            this.actualProgress = 0.0f;
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, this.currentProgress);
            this.progressAnimator = ofFloat2;
            ofFloat2.setDuration(this.animSyncDuration);
            this.progressAnimator.setInterpolator(new LinearInterpolator());
            this.progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    CircularProgressView.this.actualProgress = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.progressAnimator.start();
            return;
        }
        this.indeterminateSweep = INDETERMINANT_MIN_SWEEP;
        this.indeterminateAnimator = new AnimatorSet();
        AnimatorSet animatorSet2 = null;
        while (i < this.animSteps) {
            AnimatorSet createIndeterminateAnimator = createIndeterminateAnimator(i);
            AnimatorSet.Builder play = this.indeterminateAnimator.play(createIndeterminateAnimator);
            if (animatorSet2 != null) {
                play.after(animatorSet2);
            }
            i++;
            animatorSet2 = createIndeterminateAnimator;
        }
        this.indeterminateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.5
            boolean wasCancelled = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.wasCancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.wasCancelled) {
                    return;
                }
                CircularProgressView.this.resetAnimation();
            }
        });
        this.indeterminateAnimator.start();
        Iterator<CircularProgressViewListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAnimationReset();
        }
    }

    public void stopAnimation() {
        ValueAnimator valueAnimator = this.startAngleRotate;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.startAngleRotate = null;
        }
        ValueAnimator valueAnimator2 = this.progressAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.progressAnimator = null;
        }
        AnimatorSet animatorSet = this.indeterminateAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.indeterminateAnimator = null;
        }
    }

    private AnimatorSet createIndeterminateAnimator(float f) {
        final float f2 = (((r0 - 1) * 360.0f) / this.animSteps) + INDETERMINANT_MIN_SWEEP;
        final float f3 = ((f2 - INDETERMINANT_MIN_SWEEP) * f) - 90.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(INDETERMINANT_MIN_SWEEP, f2);
        ofFloat.setDuration((this.animDuration / this.animSteps) / 2);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.indeterminateSweep = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressView.this.invalidate();
            }
        });
        int i = this.animSteps;
        float f4 = (0.5f + f) * 720.0f;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat((f * 720.0f) / i, f4 / i);
        ofFloat2.setDuration((this.animDuration / this.animSteps) / 2);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.indeterminateRotateOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(f3, (f3 + f2) - INDETERMINANT_MIN_SWEEP);
        ofFloat3.setDuration((this.animDuration / this.animSteps) / 2);
        ofFloat3.setInterpolator(new DecelerateInterpolator(1.0f));
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.startAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressView circularProgressView = CircularProgressView.this;
                circularProgressView.indeterminateSweep = (f2 - circularProgressView.startAngle) + f3;
                CircularProgressView.this.invalidate();
            }
        });
        int i2 = this.animSteps;
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(f4 / i2, ((f + 1.0f) * 720.0f) / i2);
        ofFloat4.setDuration((this.animDuration / this.animSteps) / 2);
        ofFloat4.setInterpolator(new LinearInterpolator());
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.indeterminateRotateOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat3).with(ofFloat4).after(ofFloat2);
        return animatorSet;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autostartAnimation) {
            startAnimation();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if (i != visibility) {
            if (i == 0) {
                resetAnimation();
            } else if (i == 8 || i == 4) {
                stopAnimation();
            }
        }
    }
}
