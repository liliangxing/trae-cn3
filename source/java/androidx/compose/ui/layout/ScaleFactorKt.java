package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* compiled from: ScaleFactor.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0015H\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u0018\u001a\u001c\u0010\u001b\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u001c\u0010\u0018\u001a'\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0003H\u0007¢\u0006\u0004\b!\u0010\"\"\u001f\u0010\u0006\u001a\u00020\u0007*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001f\u0010\f\u001a\u00020\u0007*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006#"}, d2 = {"ScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "scaleX", "", "scaleY", "(FF)J", "isSpecified", "", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified-FK8aYYs", "(J)Z", "isUnspecified", "isUnspecified-FK8aYYs$annotations", "isUnspecified-FK8aYYs", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-oyDd2qo", "(JLkotlin/jvm/functions/Function0;)J", "times", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "times-UQTWf7w", "(JJ)J", "size", "times-m-w2e94", "div", "div-UQTWf7w", "lerp", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaleFactorKt {
    /* renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m5860isSpecifiedFK8aYYs$annotations(long j) {
    }

    /* renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m5862isUnspecifiedFK8aYYs$annotations(long j) {
    }

    /* renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m5859isSpecifiedFK8aYYs(long j) {
        return j != ScaleFactor.INSTANCE.m5857getUnspecified_hLwfpc();
    }

    /* renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m5861isUnspecifiedFK8aYYs(long j) {
        return j == ScaleFactor.INSTANCE.m5857getUnspecified_hLwfpc();
    }

    /* renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m5866timesmw2e94(long j, long j2) {
        return m5865timesUQTWf7w(j2, j);
    }

    public static final long ScaleFactor(float f, float f2) {
        return ScaleFactor.m5844constructorimpl((Float.floatToRawIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: takeOrElse-oyDd2qo, reason: not valid java name */
    public static final long m5864takeOrElseoyDd2qo(long j, Function0<ScaleFactor> function0) {
        return (j > ScaleFactor.INSTANCE.m5857getUnspecified_hLwfpc() ? 1 : (j == ScaleFactor.INSTANCE.m5857getUnspecified_hLwfpc() ? 0 : -1)) != 0 ? j : function0.invoke().m5855unboximpl();
    }

    /* renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m5865timesUQTWf7w(long j, long j2) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * Float.intBitsToFloat((int) (j2 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax)) * Float.intBitsToFloat((int) (j2 & BodyPartID.bodyIdMax));
        return Size.m4161constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & BodyPartID.bodyIdMax));
    }

    /* renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m5858divUQTWf7w(long j, long j2) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / Float.intBitsToFloat((int) (j2 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax)) / Float.intBitsToFloat((int) (j2 & BodyPartID.bodyIdMax));
        return Size.m4161constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & BodyPartID.bodyIdMax));
    }

    /* renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m5863lerpbDIf60(long j, long j2, float f) {
        float lerp = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)), f);
        float lerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax)), Float.intBitsToFloat((int) (j2 & BodyPartID.bodyIdMax)), f);
        return ScaleFactor.m5844constructorimpl((Float.floatToRawIntBits(lerp) << 32) | (Float.floatToRawIntBits(lerp2) & BodyPartID.bodyIdMax));
    }
}
