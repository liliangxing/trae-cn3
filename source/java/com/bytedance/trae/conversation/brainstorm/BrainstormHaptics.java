package com.bytedance.trae.conversation.brainstorm;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormHaptics.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormHaptics;", "", "<init>", "()V", "TAG", "", "playKnock", "", "context", "Landroid/content/Context;", "playSoftImpact", "playSoftImpactApi31", "vibrator", "Landroid/os/Vibrator;", "playSoftImpactApi26", "playSoftImpactLegacy", "playKnockApi31", "playKnockApi26", "playKnockLegacy", "playEndDismiss", "playEndDismissApi31", "playEndDismissApi26", "playEndDismissLegacy", "obtainVibrator", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormHaptics {
    public static final BrainstormHaptics INSTANCE = new BrainstormHaptics();
    private static final String TAG = "BrainstormHaptics";

    private BrainstormHaptics() {
    }

    public final void playKnock(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Vibrator obtainVibrator = obtainVibrator(context);
        if (obtainVibrator != null && obtainVibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 31) {
                playKnockApi31(obtainVibrator);
            } else if (Build.VERSION.SDK_INT >= 26) {
                playKnockApi26(obtainVibrator);
            } else {
                playKnockLegacy(obtainVibrator);
            }
        }
    }

    public final void playSoftImpact(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Vibrator obtainVibrator = obtainVibrator(context);
        if (obtainVibrator != null && obtainVibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 31) {
                playSoftImpactApi31(obtainVibrator);
            } else if (Build.VERSION.SDK_INT >= 26) {
                playSoftImpactApi26(obtainVibrator);
            } else {
                playSoftImpactLegacy(obtainVibrator);
            }
        }
    }

    private final void playSoftImpactApi31(Vibrator vibrator) {
        Object obj;
        if (!vibrator.areAllPrimitivesSupported(8)) {
            FLogger.INSTANCE.d(TAG, "playSoftImpactApi31: PRIMITIVE_LOW_TICK unsupported, fallback to waveform");
            playSoftImpactApi26(vibrator);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            vibrator.vibrate(VibrationEffect.startComposition().addPrimitive(8, 0.45f, 0).compose());
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playSoftImpactApi31: vibrate failed", th2);
        }
    }

    private final void playSoftImpactApi26(Vibrator vibrator) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            vibrator.vibrate(VibrationEffect.createOneShot(18L, 90));
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playSoftImpactApi26: vibrate failed", th2);
        }
    }

    private final void playSoftImpactLegacy(Vibrator vibrator) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            vibrator.vibrate(18L);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playSoftImpactLegacy: vibrate failed", th2);
        }
    }

    private final void playKnockApi31(Vibrator vibrator) {
        Object obj;
        if (!vibrator.areAllPrimitivesSupported(2)) {
            FLogger.INSTANCE.d(TAG, "playKnockApi31: PRIMITIVE_THUD unsupported, fallback to waveform");
            playKnockApi26(vibrator);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            VibrationEffect compose = VibrationEffect.startComposition().addPrimitive(2, 0.94f, 0).addPrimitive(2, 0.9f, 180).addPrimitive(2, 0.92f, 180).compose();
            Intrinsics.checkNotNullExpressionValue(compose, "compose(...)");
            vibrator.vibrate(compose);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playKnockApi31: vibrate failed", th2);
        }
    }

    private final void playKnockApi26(Vibrator vibrator) {
        Object obj;
        long[] jArr = {0, 30, 150, 30, 150, 30};
        int[] iArr = {0, 240, 0, 230, 0, 235};
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            vibrator.vibrate(VibrationEffect.createWaveform(jArr, iArr, -1));
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playKnockApi26: vibrate failed", th2);
        }
    }

    private final void playKnockLegacy(Vibrator vibrator) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            vibrator.vibrate(new long[]{0, 30, 150, 30, 150, 30}, -1);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playKnockLegacy: vibrate failed", th2);
        }
    }

    public final void playEndDismiss(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Vibrator obtainVibrator = obtainVibrator(context);
        if (obtainVibrator != null && obtainVibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 31) {
                playEndDismissApi31(obtainVibrator);
            } else if (Build.VERSION.SDK_INT >= 26) {
                playEndDismissApi26(obtainVibrator);
            } else {
                playEndDismissLegacy(obtainVibrator);
            }
        }
    }

    private final void playEndDismissApi31(Vibrator vibrator) {
        Object obj;
        if (!vibrator.areAllPrimitivesSupported(7)) {
            FLogger.INSTANCE.d(TAG, "playEndDismissApi31: PRIMITIVE_TICK unsupported, fallback to waveform");
            playEndDismissApi26(vibrator);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            VibrationEffect compose = VibrationEffect.startComposition().addPrimitive(7, 0.9f, 0).addPrimitive(7, 0.85f, 100).addPrimitive(7, 0.9f, 100).compose();
            Intrinsics.checkNotNullExpressionValue(compose, "compose(...)");
            vibrator.vibrate(compose);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playEndDismissApi31: vibrate failed", th2);
        }
    }

    private final void playEndDismissApi26(Vibrator vibrator) {
        Object obj;
        long[] jArr = {0, 15, 85, 15, 85, 15};
        int[] iArr = {0, 200, 0, 190, 0, 200};
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            vibrator.vibrate(VibrationEffect.createWaveform(jArr, iArr, -1));
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playEndDismissApi26: vibrate failed", th2);
        }
    }

    private final void playEndDismissLegacy(Vibrator vibrator) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            BrainstormHaptics brainstormHaptics = this;
            vibrator.vibrate(new long[]{0, 15, 85, 15, 85, 15}, -1);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.w(TAG, "playEndDismissLegacy: vibrate failed", th2);
        }
    }

    private final Vibrator obtainVibrator(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = context.getSystemService("vibrator_manager");
            VibratorManager vibratorManager = systemService instanceof VibratorManager ? (VibratorManager) systemService : null;
            if (vibratorManager != null) {
                return vibratorManager.getDefaultVibrator();
            }
            return null;
        }
        Object systemService2 = context.getSystemService("vibrator");
        if (systemService2 instanceof Vibrator) {
            return (Vibrator) systemService2;
        }
        return null;
    }
}
