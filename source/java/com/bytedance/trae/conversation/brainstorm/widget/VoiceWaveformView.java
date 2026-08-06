package com.bytedance.trae.conversation.brainstorm.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: VoiceWaveformView.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\fJ\u000e\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\u0007J\u001e\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fJ\u0016\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fJ\u000e\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020\u0012J\u000e\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\fJ\u000e\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002012\u0006\u0010?\u001a\u00020\fJ\u000e\u0010C\u001a\u0002012\u0006\u0010D\u001a\u00020\fJ\u000e\u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020\fJ\u0016\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007J\u000e\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020\fJ\u0006\u0010L\u001a\u000201J\u0006\u0010M\u001a\u000201J\b\u0010N\u001a\u00020&H\u0002J\b\u0010O\u001a\u000201H\u0002J(\u0010P\u001a\u0002012\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007H\u0014J\b\u0010U\u001a\u000201H\u0002J\u0010\u0010V\u001a\u0002012\u0006\u0010W\u001a\u00020XH\u0014J\b\u0010Y\u001a\u000201H\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceWaveformView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barCount", "barWidthDp", "", "barGapDp", "barCornerRadiusDp", "maxBarHeightDp", "minBarHeightDp", "animationDurationMs", "", "volumeSmoothFactor", "volumeSensitivityPow", "barLerpFactor", "jitterStrength", "envelopeMin", "idleWaveRatio", "density", "barWidthPx", "barGapPx", "barCornerRadius", "maxBarHeight", "minBarHeight", "paint", "Landroid/graphics/Paint;", "barRect", "Landroid/graphics/RectF;", "gradientTopColor", "gradientBottomColor", "barHeights", "", "targetHeights", "currentVolume", "smoothedVolume", "animator", "Landroid/animation/ValueAnimator;", "isAnimating", "", "phaseOffsets", "envelopeWeights", "setIdleWaveRatio", "", "ratio", "setBarCount", "count", "setBarDimensions", "widthDp", "gapDp", "cornerRadiusDp", "setBarHeightRange", "minDp", "maxDp", "setAnimationDuration", "durationMs", "setVolumeSmoothFactor", "factor", "setVolumeSensitivityPow", "pow", "setBarLerpFactor", "setJitterStrength", "strength", "setEnvelopeMin", "min", "setWaveColors", "topColor", "bottomColor", "updateVolume", "volume", "startAnimating", "stopAnimating", "buildEnvelopeWeights", "rebuildBarArrays", WebViewContainer.EVENT_onSizeChanged, "w", RXScreenCaptureService.KEY_HEIGHT, "oldw", "oldh", "updateGradient", WebViewContainer.EVENT_onDraw, "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoiceWaveformView extends View {
    private long animationDurationMs;
    private ValueAnimator animator;
    private float barCornerRadius;
    private float barCornerRadiusDp;
    private int barCount;
    private float barGapDp;
    private float barGapPx;
    private float[] barHeights;
    private float barLerpFactor;
    private final RectF barRect;
    private float barWidthDp;
    private float barWidthPx;
    private float currentVolume;
    private final float density;
    private float envelopeMin;
    private float[] envelopeWeights;
    private int gradientBottomColor;
    private int gradientTopColor;
    private float idleWaveRatio;
    private boolean isAnimating;
    private float jitterStrength;
    private float maxBarHeight;
    private float maxBarHeightDp;
    private float minBarHeight;
    private float minBarHeightDp;
    private final Paint paint;
    private float[] phaseOffsets;
    private float smoothedVolume;
    private float[] targetHeights;
    private float volumeSensitivityPow;
    private float volumeSmoothFactor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceWaveformView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceWaveformView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VoiceWaveformView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceWaveformView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.barCount = 30;
        this.barWidthDp = 2.0f;
        this.barGapDp = 2.0f;
        this.barCornerRadiusDp = 1.0f;
        this.maxBarHeightDp = 55.0f;
        this.minBarHeightDp = 5.0f;
        this.animationDurationMs = 600L;
        this.volumeSmoothFactor = 0.4f;
        this.volumeSensitivityPow = 0.5f;
        this.barLerpFactor = 0.35f;
        this.jitterStrength = 0.8f;
        this.envelopeMin = 0.25f;
        this.idleWaveRatio = 0.03f;
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        this.barWidthPx = this.barWidthDp * f;
        this.barGapPx = this.barGapDp * f;
        this.barCornerRadius = this.barCornerRadiusDp * f;
        this.maxBarHeight = this.maxBarHeightDp * f;
        this.minBarHeight = this.minBarHeightDp * f;
        this.paint = new Paint(1);
        this.barRect = new RectF();
        this.gradientTopColor = -15066339;
        this.gradientBottomColor = -9078141;
        int i2 = this.barCount;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = this.minBarHeight;
        }
        this.barHeights = fArr;
        int i4 = this.barCount;
        float[] fArr2 = new float[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            fArr2[i5] = this.minBarHeight;
        }
        this.targetHeights = fArr2;
        int i6 = this.barCount;
        float[] fArr3 = new float[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            fArr3[i7] = (float) (Math.random() * 3.141592653589793d * 2);
        }
        this.phaseOffsets = fArr3;
        this.envelopeWeights = buildEnvelopeWeights();
        updateGradient();
    }

    public final void setIdleWaveRatio(float ratio) {
        this.idleWaveRatio = RangesKt.coerceIn(ratio, 0.0f, 1.0f);
    }

    public final void setBarCount(int count) {
        this.barCount = RangesKt.coerceAtLeast(count, 2);
        rebuildBarArrays();
    }

    public final void setBarDimensions(float widthDp, float gapDp, float cornerRadiusDp) {
        this.barWidthDp = widthDp;
        this.barGapDp = gapDp;
        this.barCornerRadiusDp = cornerRadiusDp;
        float f = this.density;
        this.barWidthPx = widthDp * f;
        this.barGapPx = gapDp * f;
        this.barCornerRadius = cornerRadiusDp * f;
        invalidate();
    }

    public final void setBarHeightRange(float minDp, float maxDp) {
        this.minBarHeightDp = minDp;
        this.maxBarHeightDp = maxDp;
        float f = this.density;
        this.minBarHeight = minDp * f;
        this.maxBarHeight = maxDp * f;
        rebuildBarArrays();
    }

    public final void setAnimationDuration(long durationMs) {
        this.animationDurationMs = RangesKt.coerceAtLeast(durationMs, 100L);
    }

    public final void setVolumeSmoothFactor(float factor) {
        this.volumeSmoothFactor = RangesKt.coerceIn(factor, 0.01f, 1.0f);
    }

    public final void setVolumeSensitivityPow(float pow) {
        this.volumeSensitivityPow = RangesKt.coerceIn(pow, 0.1f, 1.0f);
    }

    public final void setBarLerpFactor(float factor) {
        this.barLerpFactor = RangesKt.coerceIn(factor, 0.01f, 1.0f);
    }

    public final void setJitterStrength(float strength) {
        this.jitterStrength = RangesKt.coerceIn(strength, 0.0f, 1.0f);
    }

    public final void setEnvelopeMin(float min) {
        this.envelopeMin = RangesKt.coerceIn(min, 0.0f, 1.0f);
        this.envelopeWeights = buildEnvelopeWeights();
    }

    public final void setWaveColors(int topColor, int bottomColor) {
        this.gradientTopColor = topColor;
        this.gradientBottomColor = bottomColor;
        updateGradient();
        invalidate();
    }

    public final void updateVolume(float volume) {
        this.currentVolume = RangesKt.coerceIn(volume, 0.0f, 1.0f);
    }

    public final void startAnimating() {
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(this.animationDurationMs);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.VoiceWaveformView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VoiceWaveformView.startAnimating$lambda$1$lambda$0(VoiceWaveformView.this, valueAnimator);
            }
        });
        ofFloat.start();
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimating$lambda$1$lambda$0(VoiceWaveformView voiceWaveformView, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        Object animatedValue = anim.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        float f = voiceWaveformView.smoothedVolume;
        float f2 = f + ((voiceWaveformView.currentVolume - f) * voiceWaveformView.volumeSmoothFactor);
        voiceWaveformView.smoothedVolume = f2;
        float f3 = voiceWaveformView.idleWaveRatio;
        float coerceIn = (voiceWaveformView.maxBarHeight - voiceWaveformView.minBarHeight) * RangesKt.coerceIn(f3 + ((1.0f - f3) * ((float) Math.pow(f2, voiceWaveformView.volumeSensitivityPow))), 0.0f, 1.0f);
        int i = voiceWaveformView.barCount;
        for (int i2 = 0; i2 < i; i2++) {
            float sin = (float) ((Math.sin((floatValue * 3.141592653589793d * 2) + voiceWaveformView.phaseOffsets[i2]) * 0.5d) + 0.5d);
            float random = ((float) Math.random()) - 0.5f;
            float f4 = voiceWaveformView.jitterStrength;
            float f5 = (random * f4) + (1.0f - (f4 * 0.25f));
            float[] fArr = voiceWaveformView.targetHeights;
            float f6 = voiceWaveformView.minBarHeight + (sin * coerceIn * f5 * voiceWaveformView.envelopeWeights[i2]);
            fArr[i2] = f6;
            float[] fArr2 = voiceWaveformView.barHeights;
            float f7 = fArr2[i2];
            fArr2[i2] = f7 + ((f6 - f7) * voiceWaveformView.barLerpFactor);
        }
        voiceWaveformView.invalidate();
    }

    public final void stopAnimating() {
        this.isAnimating = false;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        this.currentVolume = 0.0f;
        this.smoothedVolume = 0.0f;
        int i = this.barCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.barHeights[i2] = this.minBarHeight;
        }
        invalidate();
    }

    private final float[] buildEnvelopeWeights() {
        int i = this.barCount;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            float cos = (((float) Math.cos((((i2 / (this.barCount - 1)) * 2.0f) - 1.0f) * 3.141592653589793d)) + 1.0f) / 2.0f;
            float f = this.envelopeMin;
            fArr[i2] = f + ((1.0f - f) * cos);
        }
        return fArr;
    }

    private final void rebuildBarArrays() {
        int i = this.barCount;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = this.minBarHeight;
        }
        this.barHeights = fArr;
        int i3 = this.barCount;
        float[] fArr2 = new float[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            fArr2[i4] = this.minBarHeight;
        }
        this.targetHeights = fArr2;
        int i5 = this.barCount;
        float[] fArr3 = new float[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            fArr3[i6] = (float) (Math.random() * 3.141592653589793d * 2);
        }
        this.phaseOffsets = fArr3;
        this.envelopeWeights = buildEnvelopeWeights();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateGradient();
    }

    private final void updateGradient() {
        if (getHeight() > 0) {
            this.paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), this.gradientTopColor, this.gradientBottomColor, Shader.TileMode.CLAMP));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.paint.getShader() == null) {
            updateGradient();
        }
        float width = (getWidth() - ((this.barCount * this.barWidthPx) + ((r0 - 1) * this.barGapPx))) / 2.0f;
        float height = getHeight() / 2.0f;
        int i = this.barCount;
        for (int i2 = 0; i2 < i; i2++) {
            float f = this.barWidthPx;
            float f2 = (i2 * (this.barGapPx + f)) + width;
            float f3 = this.barHeights[i2] / 2.0f;
            this.barRect.set(f2, height - f3, f + f2, f3 + height);
            RectF rectF = this.barRect;
            float f4 = this.barCornerRadius;
            canvas.drawRoundRect(rectF, f4, f4, this.paint);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimating();
    }
}
