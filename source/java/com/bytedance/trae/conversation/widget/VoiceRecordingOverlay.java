package com.bytedance.trae.conversation.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.widget.blur.BlurCircleWithAmplitude;
import com.bytedance.trae.multilanguage.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceRecordingOverlay.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u00011B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\"\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00152\b\b\u0002\u0010&\u001a\u00020 2\b\b\u0002\u0010'\u001a\u00020 J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020 J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020 J\u0018\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020\"H\u0002J\b\u00100\u001a\u00020\"H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tipTextView", "Landroid/widget/TextView;", "visualizerContainer", "Landroid/widget/FrameLayout;", "blurCircle", "Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;", "getBlurCircle", "()Lcom/bytedance/trae/conversation/widget/blur/BlurCircleWithAmplitude;", "audioVisualizer", "Lcom/bytedance/trae/conversation/widget/AudioVisualizerView;", "currentState", "Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;", "needVibrate", "", "normalCenterColor", "normalEdgeColor", "normalTextColor", "normalWaveColor", "cancelCenterColor", "cancelEdgeColor", "cancelForegroundColor", "dp", "", "show", "", "hide", "updateState", "state", "globalTouchX", "globalTouchY", "updateVolume", "volume", "shouldCancel", "touchY", "updateHighlight", "globalX", "globalY", "updateUI", "vibrate", "RecordingState", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceRecordingOverlay extends LinearLayout {
    private final AudioVisualizerView audioVisualizer;
    private final BlurCircleWithAmplitude blurCircle;
    private final int cancelCenterColor;
    private final int cancelEdgeColor;
    private final int cancelForegroundColor;
    private RecordingState currentState;
    private final float dp;
    private boolean needVibrate;
    private final int normalCenterColor;
    private final int normalEdgeColor;
    private final int normalTextColor;
    private final int normalWaveColor;
    private final TextView tipTextView;
    private final FrameLayout visualizerContainer;

    /* compiled from: VoiceRecordingOverlay.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordingState.values().length];
            try {
                iArr[RecordingState.SPEAKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordingState.CANCELING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceRecordingOverlay(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceRecordingOverlay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VoiceRecordingOverlay(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceRecordingOverlay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentState = RecordingState.SPEAKING;
        this.needVibrate = true;
        int color = ContextCompat.getColor(context, C0591R.color.trae_bg_bg_brand);
        this.normalCenterColor = color;
        int color2 = ContextCompat.getColor(context, C0591R.color.trae_brand_brand_300);
        this.normalEdgeColor = color2;
        int color3 = ContextCompat.getColor(context, C0591R.color.trae_text_text_onaccent);
        this.normalTextColor = color3;
        this.normalWaveColor = ContextCompat.getColor(context, C0591R.color.trae_icon_icon_onaccent);
        this.cancelCenterColor = ContextCompat.getColor(context, C0591R.color.trae_brand_red_300);
        this.cancelEdgeColor = ContextCompat.getColor(context, C0591R.color.trae_brand_red_100);
        this.cancelForegroundColor = ContextCompat.getColor(context, C0591R.color.trae_status_error_default);
        float f = getResources().getDisplayMetrics().density;
        this.dp = f;
        setOrientation(1);
        setGravity(1);
        setClipChildren(false);
        setClipToPadding(false);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, -1, Color.argb(0, Color.red(-1), Color.green(-1), Color.blue(-1))}));
        View view = new View(context);
        setGravity(17);
        addView(view, new LinearLayout.LayoutParams(-1, (int) (100 * f)));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        this.visualizerContainer = frameLayout;
        BlurCircleWithAmplitude blurCircleWithAmplitude = new BlurCircleWithAmplitude(context, null, 0, 6, null);
        blurCircleWithAmplitude.setCircleColorWithoutCover(color, color2);
        this.blurCircle = blurCircleWithAmplitude;
        boolean z = Build.VERSION.SDK_INT >= 31;
        int i2 = getResources().getDisplayMetrics().widthPixels;
        i2 = z ? Math.max((int) (559 * f), i2) : i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 81;
        frameLayout.addView(blurCircleWithAmplitude, layoutParams);
        AudioVisualizerView audioVisualizerView = new AudioVisualizerView(context, null, 0, 6, null);
        this.audioVisualizer = audioVisualizerView;
        TextView textView = new TextView(context);
        textView.setTextSize(13.0f);
        textView.setGravity(17);
        textView.setTextColor(color3);
        this.tipTextView = textView;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) (80 * f));
        layoutParams2.topMargin = (int) (24 * f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(audioVisualizerView, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 80;
        layoutParams3.bottomMargin = (int) (34 * f);
        frameLayout.addView(linearLayout, layoutParams3);
        addView(frameLayout, new LinearLayout.LayoutParams(-1, (int) (280 * f)));
        setAlpha(0.0f);
        setVisibility(8);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: VoiceRecordingOverlay.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay$RecordingState;", "", "<init>", "(Ljava/lang/String;I)V", "SPEAKING", "CANCELING", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class RecordingState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RecordingState[] $VALUES;
        public static final RecordingState SPEAKING = new RecordingState("SPEAKING", 0);
        public static final RecordingState CANCELING = new RecordingState("CANCELING", 1);

        private static final /* synthetic */ RecordingState[] $values() {
            return new RecordingState[]{SPEAKING, CANCELING};
        }

        public static EnumEntries<RecordingState> getEntries() {
            return $ENTRIES;
        }

        private RecordingState(String str, int i) {
        }

        static {
            RecordingState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static RecordingState valueOf(String str) {
            return (RecordingState) Enum.valueOf(RecordingState.class, str);
        }

        public static RecordingState[] values() {
            return (RecordingState[]) $VALUES.clone();
        }
    }

    public final BlurCircleWithAmplitude getBlurCircle() {
        return this.blurCircle;
    }

    public final void show() {
        setVisibility(0);
        this.currentState = RecordingState.SPEAKING;
        this.needVibrate = true;
        updateUI();
        this.audioVisualizer.startAnimation();
        this.blurCircle.startWaveAnim();
        SpeakerInterpolator speakerInterpolator = new SpeakerInterpolator();
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<VoiceRecordingOverlay, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(120L);
        SpeakerInterpolator speakerInterpolator2 = speakerInterpolator;
        ofFloat.setInterpolator(speakerInterpolator2);
        Unit unit = Unit.INSTANCE;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.blurCircle, "circleScale", 0.6f, 1.0f);
        ofFloat2.setDuration(120L);
        ofFloat2.setInterpolator(speakerInterpolator2);
        Unit unit2 = Unit.INSTANCE;
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        vibrate();
    }

    public final void hide() {
        this.blurCircle.stopWaveAnim();
        SpeakerInterpolator speakerInterpolator = new SpeakerInterpolator();
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<VoiceRecordingOverlay, Float>) View.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(240L);
        SpeakerInterpolator speakerInterpolator2 = speakerInterpolator;
        ofFloat.setInterpolator(speakerInterpolator2);
        Unit unit = Unit.INSTANCE;
        BlurCircleWithAmplitude blurCircleWithAmplitude = this.blurCircle;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(blurCircleWithAmplitude, "circleScale", blurCircleWithAmplitude.getCircleScale(), 0.6f);
        ofFloat2.setDuration(240L);
        ofFloat2.setInterpolator(speakerInterpolator2);
        Unit unit2 = Unit.INSTANCE;
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.trae.conversation.widget.VoiceRecordingOverlay$hide$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AudioVisualizerView audioVisualizerView;
                Intrinsics.checkNotNullParameter(animation, "animation");
                VoiceRecordingOverlay.this.setVisibility(8);
                audioVisualizerView = VoiceRecordingOverlay.this.audioVisualizer;
                audioVisualizerView.stopAnimation();
                VoiceRecordingOverlay.this.getBlurCircle().setCircleScale(1.0f);
            }
        });
        animatorSet.start();
    }

    public static /* synthetic */ void updateState$default(VoiceRecordingOverlay voiceRecordingOverlay, RecordingState recordingState, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        voiceRecordingOverlay.updateState(recordingState, f, f2);
    }

    public final void updateState(RecordingState state, float globalTouchX, float globalTouchY) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.currentState == state) {
            if (state == RecordingState.SPEAKING) {
                if (globalTouchX == 0.0f) {
                    return;
                }
                updateHighlight(globalTouchX, globalTouchY);
                return;
            }
            return;
        }
        this.currentState = state;
        updateUI();
        if (state == RecordingState.SPEAKING) {
            if (!(globalTouchX == 0.0f)) {
                updateHighlight(globalTouchX, globalTouchY);
            }
        }
        if (state == RecordingState.CANCELING && this.needVibrate) {
            vibrate();
            this.needVibrate = false;
        } else {
            if (state != RecordingState.SPEAKING || this.needVibrate) {
                return;
            }
            vibrate();
            this.needVibrate = true;
        }
    }

    public final void updateVolume(float volume) {
        this.audioVisualizer.setAmplitude(AudioVisualizerView.INSTANCE.optAmplitude(volume));
        this.blurCircle.updateVolumeData(volume);
    }

    public final boolean shouldCancel(float touchY) {
        Rect rect = new Rect();
        this.blurCircle.getGlobalVisibleRect(rect);
        return !rect.isEmpty() && touchY < ((float) (rect.bottom - this.blurCircle.getCircleRectHeight()));
    }

    private final void updateHighlight(float globalX, float globalY) {
        this.blurCircle.getLocationOnScreen(new int[2]);
        this.blurCircle.showHighlight(globalX - r0[0], globalY - r0[1]);
    }

    private final void updateUI() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentState.ordinal()];
        if (i == 1) {
            this.tipTextView.setText(R.string.trae_recording_release_to_send);
            this.tipTextView.setTextColor(this.normalTextColor);
            this.blurCircle.setCircleColorWithoutCover(this.normalCenterColor, this.normalEdgeColor);
            this.blurCircle.dismissHighlight();
            this.audioVisualizer.setBarColor(this.normalWaveColor);
            return;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        this.tipTextView.setText(R.string.trae_recording_release_to_cancel);
        this.tipTextView.setTextColor(this.cancelForegroundColor);
        this.blurCircle.setCircleColor(this.cancelCenterColor, this.cancelEdgeColor);
        this.blurCircle.dismissHighlight();
        this.audioVisualizer.setBarColor(this.cancelForegroundColor);
    }

    private final void vibrate() {
        Vibrator defaultVibrator;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                Object systemService = getContext().getSystemService("vibrator_manager");
                VibratorManager vibratorManager = systemService instanceof VibratorManager ? (VibratorManager) systemService : null;
                if (vibratorManager == null || (defaultVibrator = vibratorManager.getDefaultVibrator()) == null) {
                    return;
                }
                defaultVibrator.vibrate(VibrationEffect.createOneShot(20L, -1));
                return;
            }
            Object systemService2 = getContext().getSystemService("vibrator");
            Vibrator vibrator = systemService2 instanceof Vibrator ? (Vibrator) systemService2 : null;
            if (Build.VERSION.SDK_INT >= 26) {
                if (vibrator != null) {
                    vibrator.vibrate(VibrationEffect.createOneShot(20L, -1));
                }
            } else if (vibrator != null) {
                vibrator.vibrate(20L);
            }
        } catch (Exception unused) {
        }
    }
}
