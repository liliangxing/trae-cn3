package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.content.ContextCompat;
import com.scwang.smartrefresh.layout.C0277R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.SmartUtil;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BezierRadarHeader extends InternalAbstract implements RefreshHeader {
    protected static final byte PROPERTY_DOT_ALPHA = 2;
    protected static final byte PROPERTY_RADAR_ANGLE = 4;
    protected static final byte PROPERTY_RADAR_SCALE = 0;
    protected static final byte PROPERTY_RIPPLE_RADIUS = 3;
    protected static final byte PROPERTY_WAVE_HEIGHT = 1;
    protected int mAccentColor;
    protected Animator mAnimatorSet;
    protected float mDotAlpha;
    protected float mDotFraction;
    protected float mDotRadius;
    protected boolean mEnableHorizontalDrag;
    protected boolean mManualAccentColor;
    protected boolean mManualPrimaryColor;
    protected Paint mPaint;
    protected Path mPath;
    protected int mPrimaryColor;
    protected int mRadarAngle;
    protected float mRadarCircle;
    protected float mRadarRadius;
    protected RectF mRadarRect;
    protected float mRadarScale;
    protected float mRippleRadius;
    protected int mWaveHeight;
    protected int mWaveOffsetX;
    protected int mWaveOffsetY;
    protected boolean mWavePulling;
    protected int mWaveTop;

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mEnableHorizontalDrag = false;
        this.mWaveOffsetX = -1;
        this.mWaveOffsetY = 0;
        this.mRadarAngle = 0;
        this.mRadarRadius = 0.0f;
        this.mRadarCircle = 0.0f;
        this.mRadarScale = 0.0f;
        this.mRadarRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mSpinnerStyle = SpinnerStyle.FixedBehind;
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mDotRadius = SmartUtil.dp2px(7.0f);
        this.mRadarRadius = SmartUtil.dp2px(20.0f);
        this.mRadarCircle = SmartUtil.dp2px(7.0f);
        this.mPaint.setStrokeWidth(SmartUtil.dp2px(3.0f));
        setMinimumHeight(SmartUtil.dp2px(100.0f));
        if (isInEditMode()) {
            this.mWaveTop = 1000;
            this.mRadarScale = 1.0f;
            this.mRadarAngle = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        } else {
            this.mRadarScale = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0277R.styleable.BezierRadarHeader);
        this.mEnableHorizontalDrag = obtainStyledAttributes.getBoolean(C0277R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.mEnableHorizontalDrag);
        setAccentColor(obtainStyledAttributes.getColor(C0277R.styleable.BezierRadarHeader_srlAccentColor, -1));
        setPrimaryColor(obtainStyledAttributes.getColor(C0277R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
        this.mManualAccentColor = obtainStyledAttributes.hasValue(C0277R.styleable.BezierRadarHeader_srlAccentColor);
        this.mManualPrimaryColor = obtainStyledAttributes.hasValue(C0277R.styleable.BezierRadarHeader_srlPrimaryColor);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mAnimatorSet;
        if (animator != null) {
            animator.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = isInEditMode() ? getHeight() : this.mWaveOffsetY;
        drawWave(canvas, width);
        drawDot(canvas, width, height);
        drawRadar(canvas, width, height);
        drawRipple(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    protected void drawWave(Canvas canvas, int i) {
        this.mPath.reset();
        this.mPath.lineTo(0.0f, this.mWaveTop);
        Path path = this.mPath;
        int i2 = this.mWaveOffsetX;
        float f = i2 >= 0 ? i2 : i / 2.0f;
        float f2 = i;
        path.quadTo(f, this.mWaveHeight + r3, f2, this.mWaveTop);
        this.mPath.lineTo(f2, 0.0f);
        this.mPaint.setColor(this.mPrimaryColor);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    protected void drawDot(Canvas canvas, int i, int i2) {
        if (this.mDotAlpha > 0.0f) {
            this.mPaint.setColor(this.mAccentColor);
            float px2dp = SmartUtil.px2dp(i2);
            float f = i;
            float f2 = 7.0f;
            float f3 = (f * 1.0f) / 7.0f;
            float f4 = this.mDotFraction;
            float f5 = (f3 * f4) - (f4 > 1.0f ? ((f4 - 1.0f) * f3) / f4 : 0.0f);
            float f6 = i2;
            float f7 = f6 - (f4 > 1.0f ? (((f4 - 1.0f) * f6) / 2.0f) / f4 : 0.0f);
            int i3 = 0;
            while (i3 < 7) {
                this.mPaint.setAlpha((int) (this.mDotAlpha * (1.0f - ((Math.abs(r7) / f2) * 2.0f)) * 255.0f * (1.0d - (1.0d / Math.pow((px2dp / 800.0d) + 1.0d, 15.0d)))));
                float f8 = this.mDotRadius * (1.0f - (1.0f / ((px2dp / 10.0f) + 1.0f)));
                canvas.drawCircle(((f / 2.0f) - (f8 / 2.0f)) + (f5 * ((i3 + 1.0f) - 4.0f)), f7 / 2.0f, f8, this.mPaint);
                i3++;
                f2 = 7.0f;
            }
            this.mPaint.setAlpha(255);
        }
    }

    protected void drawRadar(Canvas canvas, int i, int i2) {
        if (this.mAnimatorSet != null || isInEditMode()) {
            float f = this.mRadarRadius;
            float f2 = this.mRadarScale;
            float f3 = f * f2;
            float f4 = this.mRadarCircle * f2;
            this.mPaint.setColor(this.mAccentColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            float f5 = i / 2.0f;
            float f6 = i2 / 2.0f;
            canvas.drawCircle(f5, f6, f3, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            float f7 = f4 + f3;
            canvas.drawCircle(f5, f6, f7, this.mPaint);
            this.mPaint.setColor((this.mPrimaryColor & TypedValue.COMPLEX_MANTISSA_MASK) | 1426063360);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mRadarRect.set(f5 - f3, f6 - f3, f5 + f3, f3 + f6);
            canvas.drawArc(this.mRadarRect, 270.0f, this.mRadarAngle, true, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mRadarRect.set(f5 - f7, f6 - f7, f5 + f7, f6 + f7);
            canvas.drawArc(this.mRadarRect, 270.0f, this.mRadarAngle, false, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
        }
    }

    protected void drawRipple(Canvas canvas, int i, int i2) {
        if (this.mRippleRadius > 0.0f) {
            this.mPaint.setColor(this.mAccentColor);
            canvas.drawCircle(i / 2.0f, i2 / 2.0f, this.mRippleRadius, this.mPaint);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        this.mWaveOffsetY = i;
        if (z || this.mWavePulling) {
            this.mWavePulling = true;
            this.mWaveTop = Math.min(i2, i);
            this.mWaveHeight = (int) (Math.max(0, i - i2) * 1.9f);
            this.mDotFraction = f;
            invalidate();
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(RefreshLayout refreshLayout, int i, int i2) {
        this.mWaveTop = i - 1;
        this.mWavePulling = false;
        SmartUtil smartUtil = new SmartUtil(SmartUtil.INTERPOLATOR_DECELERATE);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(smartUtil);
        ofFloat.addUpdateListener(new AnimatorUpdater(PROPERTY_DOT_ALPHA));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(smartUtil);
        ofFloat2.addUpdateListener(new AnimatorUpdater((byte) 0));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
        ofInt.setDuration(720L);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new AnimatorUpdater(PROPERTY_RADAR_ANGLE));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofInt);
        animatorSet.start();
        int i3 = this.mWaveHeight;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i3, 0, -((int) (i3 * 0.8f)), 0, -((int) (i3 * 0.4f)), 0);
        ofInt2.addUpdateListener(new AnimatorUpdater(PROPERTY_WAVE_HEIGHT));
        ofInt2.setInterpolator(new SmartUtil(SmartUtil.INTERPOLATOR_DECELERATE));
        ofInt2.setDuration(800L);
        ofInt2.start();
        this.mAnimatorSet = animatorSet;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        Animator animator = this.mAnimatorSet;
        if (animator != null) {
            animator.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet = null;
        }
        int width = getWidth();
        int i = this.mWaveOffsetY;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mRadarRadius, (float) Math.sqrt((width * width) + (i * i)));
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new AnimatorUpdater(PROPERTY_RIPPLE_RADIUS));
        ofFloat.start();
        return 400;
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C02901 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = C02901.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.mDotAlpha = 1.0f;
            this.mRadarScale = 0.0f;
            this.mRippleRadius = 0.0f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.mManualPrimaryColor) {
            setPrimaryColor(iArr[0]);
            this.mManualPrimaryColor = false;
        }
        if (iArr.length <= 1 || this.mManualAccentColor) {
            return;
        }
        setAccentColor(iArr[1]);
        this.mManualAccentColor = false;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public boolean isSupportHorizontalDrag() {
        return this.mEnableHorizontalDrag;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onHorizontalDrag(float f, int i, int i2) {
        this.mWaveOffsetX = i;
        invalidate();
    }

    public BezierRadarHeader setPrimaryColor(int i) {
        this.mPrimaryColor = i;
        this.mManualPrimaryColor = true;
        return this;
    }

    public BezierRadarHeader setAccentColor(int i) {
        this.mAccentColor = i;
        this.mManualAccentColor = true;
        return this;
    }

    public BezierRadarHeader setPrimaryColorId(int i) {
        setPrimaryColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public BezierRadarHeader setAccentColorId(int i) {
        setAccentColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public BezierRadarHeader setEnableHorizontalDrag(boolean z) {
        this.mEnableHorizontalDrag = z;
        if (!z) {
            this.mWaveOffsetX = -1;
        }
        return this;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    protected class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        byte propertyName;

        AnimatorUpdater(byte b) {
            this.propertyName = b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b = this.propertyName;
            if (b == 0) {
                BezierRadarHeader.this.mRadarScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b) {
                if (BezierRadarHeader.this.mWavePulling) {
                    valueAnimator.cancel();
                    return;
                } else {
                    BezierRadarHeader.this.mWaveHeight = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
                }
            } else if (2 == b) {
                BezierRadarHeader.this.mDotAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b) {
                BezierRadarHeader.this.mRippleRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b) {
                BezierRadarHeader.this.mRadarAngle = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }
}
