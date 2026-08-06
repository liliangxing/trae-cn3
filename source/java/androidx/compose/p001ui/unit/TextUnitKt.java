package androidx.compose.p001ui.unit;

import androidx.compose.p001ui.util.MathHelpersKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TextUnit.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000f\u001a\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0016\u001a\u00020\u0006*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020\b2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010\f\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020#2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020&2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010-\u001a\u001d\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\bH\u0001¢\u0006\u0002\u00101\u001a\u0017\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0006H\u0001¢\u0006\u0004\b5\u0010\u0010\u001a\u001f\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0001¢\u0006\u0004\b7\u00108\u001a'\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H\u0001¢\u0006\u0004\b:\u0010;\u001a'\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\bH\u0007¢\u0006\u0004\b@\u0010A\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001f\u0010\r\u001a\u00020\u000e*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u001e\u0010 \u001a\u00020\u0006*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010$\u001a\u0004\b\u001e\u0010%\"\u001e\u0010 \u001a\u00020\u0006*\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010$\u001a\u0004\b\"\u0010%\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020&8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010'\u001a\u0004\b\u001e\u0010(\"\u001e\u0010 \u001a\u00020\u0006*\u00020&8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010'\u001a\u0004\b\"\u0010(¨\u0006B"}, d2 = {"UNIT_MASK", "", "UNIT_TYPE_UNSPECIFIED", "UNIT_TYPE_SP", "UNIT_TYPE_EM", "TextUnit", "Landroidx/compose/ui/unit/TextUnit;", StrategyConstants.VALUE, "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "sp", "getSp$annotations", "(F)V", "getSp", "(F)J", "em", "getEm$annotations", "getEm", "", "(D)V", "(D)J", "", "(I)V", "(I)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "pack", "unitType", "v", "(JF)J", "checkArithmetic", "", "a", "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", AirActionConstant.ActionId.ACTION_ID_CALL, "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    public static /* synthetic */ void getEm$annotations(double d) {
    }

    public static /* synthetic */ void getEm$annotations(float f) {
    }

    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static /* synthetic */ void getSp$annotations(double d) {
    }

    public static /* synthetic */ void getSp$annotations(float f) {
    }

    public static /* synthetic */ void getSp$annotations(int i) {
    }

    /* renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m2891isSpecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m2893isUnspecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m2886TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    /* renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m2892isUnspecifiedR2X_6o(long j) {
        return TextUnit.m2872getRawTypeimpl(j) == 0;
    }

    public static final long getSp(float f) {
        return pack(UNIT_TYPE_SP, f);
    }

    public static final long getEm(float f) {
        return pack(UNIT_TYPE_EM, f);
    }

    public static final long getSp(double d) {
        return pack(UNIT_TYPE_SP, (float) d);
    }

    public static final long getEm(double d) {
        return pack(UNIT_TYPE_EM, (float) d);
    }

    public static final long getSp(int i) {
        return pack(UNIT_TYPE_SP, i);
    }

    public static final long getEm(int i) {
        return pack(UNIT_TYPE_EM, i);
    }

    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m2897timesmpE4wyQ(float f, long j) {
        m2887checkArithmeticR2X_6o(j);
        return pack(TextUnit.m2872getRawTypeimpl(j), f * TextUnit.m2874getValueimpl(j));
    }

    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m2896timesmpE4wyQ(double d, long j) {
        m2887checkArithmeticR2X_6o(j);
        return pack(TextUnit.m2872getRawTypeimpl(j), ((float) d) * TextUnit.m2874getValueimpl(j));
    }

    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m2898timesmpE4wyQ(int i, long j) {
        m2887checkArithmeticR2X_6o(j);
        return pack(TextUnit.m2872getRawTypeimpl(j), i * TextUnit.m2874getValueimpl(j));
    }

    public static final long pack(long j, float f) {
        return TextUnit.m2866constructorimpl(j | (Float.floatToRawIntBits(f) & 4294967295L));
    }

    /* renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m2894lerpC3pnCVY(long j, long j2, float f) {
        m2888checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m2872getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m2874getValueimpl(j), TextUnit.m2874getValueimpl(j2), f));
    }

    /* renamed from: isSpecified--R2X_6o, reason: not valid java name */
    public static final boolean m2890isSpecifiedR2X_6o(long j) {
        return !(TextUnit.m2872getRawTypeimpl(j) == 0);
    }

    /* renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m2895takeOrElseeAf_CNQ(long j, Function0<TextUnit> function0) {
        return ((TextUnit.m2872getRawTypeimpl(j) > 0L ? 1 : (TextUnit.m2872getRawTypeimpl(j) == 0L ? 0 : -1)) == 0) ^ true ? j : ((TextUnit) function0.invoke()).getPackedValue();
    }

    /* renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m2887checkArithmeticR2X_6o(long j) {
        if (!(TextUnit.m2872getRawTypeimpl(j) == 0)) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if ((androidx.compose.p001ui.unit.TextUnit.m2872getRawTypeimpl(r9) == 0) == false) goto L14;
     */
    /* renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2888checkArithmeticNB67dxo(long j, long j2) {
        boolean z = true;
        if (!(TextUnit.m2872getRawTypeimpl(j) == 0)) {
        }
        z = false;
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m2902equalsimpl0(TextUnit.m2873getTypeUIouoOA(j), TextUnit.m2873getTypeUIouoOA(j2))) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m2904toStringimpl(TextUnit.m2873getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m2904toStringimpl(TextUnit.m2873getTypeUIouoOA(j2))));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2889checkArithmeticvU0ePk(long j, long j2, long j3) {
        boolean z;
        if (!(TextUnit.m2872getRawTypeimpl(j) == 0)) {
            if (!(TextUnit.m2872getRawTypeimpl(j2) == 0)) {
                if (!(TextUnit.m2872getRawTypeimpl(j3) == 0)) {
                    z = true;
                    if (!z) {
                        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
                    }
                    if (!TextUnitType.m2902equalsimpl0(TextUnit.m2873getTypeUIouoOA(j), TextUnit.m2873getTypeUIouoOA(j2)) && TextUnitType.m2902equalsimpl0(TextUnit.m2873getTypeUIouoOA(j2), TextUnit.m2873getTypeUIouoOA(j3))) {
                        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m2904toStringimpl(TextUnit.m2873getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m2904toStringimpl(TextUnit.m2873getTypeUIouoOA(j2))));
                        return;
                    }
                    return;
                }
            }
        }
        z = false;
        if (!z) {
        }
        if (!TextUnitType.m2902equalsimpl0(TextUnit.m2873getTypeUIouoOA(j), TextUnit.m2873getTypeUIouoOA(j2)) && TextUnitType.m2902equalsimpl0(TextUnit.m2873getTypeUIouoOA(j2), TextUnit.m2873getTypeUIouoOA(j3))) {
        }
    }
}
