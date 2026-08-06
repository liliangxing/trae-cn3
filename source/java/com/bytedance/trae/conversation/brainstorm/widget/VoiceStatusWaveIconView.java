package com.bytedance.trae.conversation.brainstorm.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: VoiceStatusWaveIconView.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u000245B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000bJ\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0006\u0010,\u001a\u00020$J\u0006\u0010-\u001a\u00020$J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0014J\b\u00103\u001a\u00020$H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "paint", "Landroid/graphics/Paint;", "barRect", "Landroid/graphics/RectF;", "baseHeightsDp", "", "phases", "barHeights", "barWidth", "barGap", "cornerRadius", "floorHeight", "minHeight", "maxHeight", "speed", "amplitude", "targetSpeed", "targetAmplitude", "waveTime", "animator", "Landroid/animation/ValueAnimator;", "volumeWindow", "Lkotlin/collections/ArrayDeque;", "setWaveColor", "", "color", "setState", "state", "Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;", "updateVolume", "volume", "normalizeVolume", "startAnimating", "stopAnimating", "updateFrame", "resetBarsToMin", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "State", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceStatusWaveIconView extends View {
    private static final int BAR_COUNT = 5;
    private static final float FAST_AMPLITUDE = 2.8f;
    private static final float FAST_SPEED = 0.12f;
    private static final float LERP = 0.04f;
    private static final float NOISE_GATE = 0.05f;
    private static final float SLOW_AMPLITUDE = 0.5f;
    private static final float SLOW_SPEED = 0.03f;
    private static final float SPEECH_REFERENCE = 0.35f;
    private static final int VOLUME_WINDOW_SIZE = 8;
    private float amplitude;
    private ValueAnimator animator;
    private final float barGap;
    private final float[] barHeights;
    private final RectF barRect;
    private final float barWidth;
    private final float[] baseHeightsDp;
    private final float cornerRadius;
    private final float density;
    private final float floorHeight;
    private final float maxHeight;
    private final float minHeight;
    private final Paint paint;
    private final float[] phases;
    private float speed;
    private float targetAmplitude;
    private float targetSpeed;
    private final ArrayDeque<Float> volumeWindow;
    private float waveTime;

    /* compiled from: VoiceStatusWaveIconView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.Slow.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.Fast.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceStatusWaveIconView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceStatusWaveIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VoiceStatusWaveIconView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceStatusWaveIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = getResources().getDisplayMetrics().density;
        this.density = f;
        Paint paint = new Paint(1);
        paint.setColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        this.paint = paint;
        this.barRect = new RectF();
        this.baseHeightsDp = new float[]{8.0f, 14.0f, 20.0f, 14.0f, 8.0f};
        this.phases = new float[]{0.0f, 1.2f, 2.4f, 1.2f, 0.0f};
        this.barHeights = new float[5];
        this.barWidth = f * 2.0f;
        this.barGap = 2.5f * f;
        this.cornerRadius = 1.0f * f;
        this.floorHeight = 3.0f * f;
        this.minHeight = 2.0f * f;
        this.maxHeight = f * 22.0f;
        this.speed = SLOW_SPEED;
        this.amplitude = SLOW_AMPLITUDE;
        this.targetSpeed = SLOW_SPEED;
        this.targetAmplitude = SLOW_AMPLITUDE;
        this.volumeWindow = new ArrayDeque<>();
        resetBarsToMin();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: VoiceStatusWaveIconView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView$State;", "", "<init>", "(Ljava/lang/String;I)V", "Slow", "Fast", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State Slow = new State("Slow", 0);
        public static final State Fast = new State("Fast", 1);

        private static final /* synthetic */ State[] $values() {
            return new State[]{Slow, Fast};
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private State(String str, int i) {
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public final void setWaveColor(int color) {
        this.paint.setColor(color);
        invalidate();
    }

    public final void setState(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            this.targetSpeed = SLOW_SPEED;
            this.targetAmplitude = SLOW_AMPLITUDE;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.targetSpeed = FAST_SPEED;
            this.targetAmplitude = FAST_AMPLITUDE;
        }
    }

    public final void updateVolume(float volume) {
        float normalizeVolume = normalizeVolume(volume);
        if (this.volumeWindow.size() >= 8) {
            this.volumeWindow.removeFirst();
        }
        this.volumeWindow.addLast(Float.valueOf(normalizeVolume));
        Float maxOrNull = CollectionsKt.maxOrNull(this.volumeWindow);
        float floatValue = maxOrNull != null ? maxOrNull.floatValue() : 0.0f;
        this.targetSpeed = (0.089999996f * floatValue) + SLOW_SPEED;
        this.targetAmplitude = (floatValue * 2.3f) + SLOW_AMPLITUDE;
    }

    private final float normalizeVolume(float volume) {
        if (volume <= NOISE_GATE) {
            return 0.0f;
        }
        return RangesKt.coerceIn((volume - NOISE_GATE) / 0.29999998f, 0.0f, 1.0f);
    }

    public final void startAnimating() {
        if (this.animator != null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VoiceStatusWaveIconView.startAnimating$lambda$2$lambda$1(VoiceStatusWaveIconView.this, valueAnimator);
            }
        });
        ofFloat.start();
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimating$lambda$2$lambda$1(VoiceStatusWaveIconView voiceStatusWaveIconView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        voiceStatusWaveIconView.updateFrame();
        voiceStatusWaveIconView.invalidate();
    }

    public final void stopAnimating() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        this.speed = SLOW_SPEED;
        this.amplitude = SLOW_AMPLITUDE;
        this.targetSpeed = SLOW_SPEED;
        this.targetAmplitude = SLOW_AMPLITUDE;
        this.waveTime = 0.0f;
        this.volumeWindow.clear();
        resetBarsToMin();
        invalidate();
    }

    private final void updateFrame() {
        float f = this.speed;
        float f2 = f + ((this.targetSpeed - f) * LERP);
        this.speed = f2;
        float f3 = this.amplitude;
        this.amplitude = f3 + ((this.targetAmplitude - f3) * LERP);
        this.waveTime += f2;
        for (int i = 0; i < 5; i++) {
            float f4 = this.phases[i];
            float f5 = this.baseHeightsDp[i] * this.density;
            float sin = (((float) (Math.sin(this.waveTime + f4) * Math.cos((this.waveTime * 0.7f) + (f4 * 1.3f)))) + 1.0f) / 2.0f;
            float f6 = this.floorHeight;
            this.barHeights[i] = RangesKt.coerceIn(f6 + ((f5 - f6) * sin * this.amplitude), this.minHeight, this.maxHeight);
        }
    }

    private final void resetBarsToMin() {
        for (int i = 0; i < 5; i++) {
            this.barHeights[i] = this.minHeight;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float width = (getWidth() - ((5 * this.barWidth) + (4 * this.barGap))) / 2.0f;
        float height = getHeight() / 2.0f;
        for (int i = 0; i < 5; i++) {
            float f = this.barWidth;
            float f2 = (i * (this.barGap + f)) + width;
            float f3 = this.barHeights[i] / 2.0f;
            this.barRect.set(f2, height - f3, f + f2, f3 + height);
            RectF rectF = this.barRect;
            float f4 = this.cornerRadius;
            canvas.drawRoundRect(rectF, f4, f4, this.paint);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimating();
    }
}
