package androidx.compose.p001ui.unit;

import androidx.constraintlayout.widget.Constraints;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

/* compiled from: Constraints.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0013\u001a\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0000\u001a-\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0000\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0082\b\u001a5\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010 \u001a\u0019\u0010$\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'\u001a\u001b\u0010$\u001a\u00020(*\u00020\u001b2\u0006\u0010\u0019\u001a\u00020(H\u0007¢\u0006\u0004\b)\u0010'\u001a\u001b\u0010*\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010+\u001a\u00020\u0001H\u0007¢\u0006\u0004\b,\u0010-\u001a\u001b\u0010.\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010/\u001a\u00020\u0001H\u0007¢\u0006\u0004\b0\u0010-\u001a\u001b\u00101\u001a\u000202*\u00020\u001b2\u0006\u0010\u0019\u001a\u00020(H\u0007¢\u0006\u0004\b3\u00104\u001a'\u00105\u001a\u00020\u001b*\u00020\u001b2\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u00020\u0001H\u0007¢\u0006\u0004\b8\u00109\u001a\u0019\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010C\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0082\b\u001a\u0011\u0010D\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\u00038\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012¨\u0006E"}, d2 = {"Infinity", "", "FocusMask", "", "MinFocusBits", "MaxAllowedForMinFocusBits", "MinFocusMask", "MinNonFocusBits", "MaxAllowedForMinNonFocusBits", "MinNonFocusMask", "MaxFocusBits", "MaxAllowedForMaxFocusBits", "MaxFocusMask", "MaxNonFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxNonFocusMask", "MaxDimensionsAndFocusMask", "getMaxDimensionsAndFocusMask$annotations", "()V", "throwInvalidConstraintException", "", "widthVal", "heightVal", "throwInvalidConstraintsSizeException", "", "size", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "bitsNeedForSizeUnchecked", "maxAllowedForSize", Constraints.TAG, "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "constrainWidth", "width", "constrainWidth-K40F9xA", "(JI)I", "constrainHeight", "height", "constrainHeight-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "addMaxWithMinimum", "max", StrategyConstants.VALUE, "indexToBitOffset", "index", "bitOffsetToIndex", "bits", "minHeightOffsets", "bitOffset", "widthMask", "heightMask", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ConstraintsKt {
    private static final long FocusMask = 3;
    private static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxAllowedForMaxFocusBits = 8190;
    private static final int MaxAllowedForMaxNonFocusBits = 262142;
    private static final int MaxAllowedForMinFocusBits = 32766;
    private static final int MaxAllowedForMinNonFocusBits = 65534;
    public static final long MaxDimensionsAndFocusMask = -8589934589L;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusMask = 262143;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final int MinFocusMask = 65535;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;

    private static final int addMaxWithMinimum(int i, int i2) {
        if (i == Integer.MAX_VALUE) {
            return i;
        }
        int i3 = i + i2;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    private static final int bitOffsetToIndex(int i) {
        return (i >> 1) + (i & 1);
    }

    public static final int bitsNeedForSizeUnchecked(int i) {
        if (i < MaxNonFocusMask) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < MaxFocusMask ? 18 : 255;
    }

    public static /* synthetic */ void getMaxDimensionsAndFocusMask$annotations() {
    }

    private static final int heightMask(int i) {
        return (1 << (18 - i)) - 1;
    }

    private static final int indexToBitOffset(int i) {
        return ((i & 1) << 1) + (((i & 2) >> 1) * 3);
    }

    private static final int minHeightOffsets(int i) {
        return i + 15;
    }

    private static final int widthMask(int i) {
        return (1 << (i + 13)) - 1;
    }

    public static final void throwInvalidConstraintException(int i, int i2) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i2 + " in Constraints");
    }

    public static final Void throwInvalidConstraintsSizeException(int i) {
        throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
    }

    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int bitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i5);
        int i6 = i2 == Integer.MAX_VALUE ? i : i2;
        int bitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i6);
        if (bitsNeedForSizeUnchecked + bitsNeedForSizeUnchecked2 > 31) {
            throwInvalidConstraintException(i6, i5);
        }
        int i7 = i2 + 1;
        int i8 = i4 + 1;
        int i9 = bitsNeedForSizeUnchecked2 - 13;
        int i10 = (i9 >> 1) + (i9 & 1);
        int i11 = i9 + 15;
        return Constraints.m2609constructorimpl(((i7 & (~(i7 >> 31))) << 33) | i10 | (i << 2) | (i3 << i11) | ((i8 & (~(i8 >> 31))) << (i11 + 31)));
    }

    private static final int maxAllowedForSize(int i) {
        if (i < MaxNonFocusMask) {
            return MaxAllowedForMaxNonFocusBits;
        }
        if (i < 32767) {
            return MaxAllowedForMinNonFocusBits;
        }
        if (i < 65535) {
            return MaxAllowedForMinFocusBits;
        }
        if (i < MaxFocusMask) {
            return MaxAllowedForMaxFocusBits;
        }
        throwInvalidConstraintsSizeException(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m2636constrainN9IONVI(long j, long j2) {
        int m2623getMinWidthimpl = Constraints.m2623getMinWidthimpl(j);
        int m2621getMaxWidthimpl = Constraints.m2621getMaxWidthimpl(j);
        int m2622getMinHeightimpl = Constraints.m2622getMinHeightimpl(j);
        int m2620getMaxHeightimpl = Constraints.m2620getMaxHeightimpl(j);
        int m2623getMinWidthimpl2 = Constraints.m2623getMinWidthimpl(j2);
        if (m2623getMinWidthimpl2 < m2623getMinWidthimpl) {
            m2623getMinWidthimpl2 = m2623getMinWidthimpl;
        }
        if (m2623getMinWidthimpl2 > m2621getMaxWidthimpl) {
            m2623getMinWidthimpl2 = m2621getMaxWidthimpl;
        }
        int m2621getMaxWidthimpl2 = Constraints.m2621getMaxWidthimpl(j2);
        if (m2621getMaxWidthimpl2 >= m2623getMinWidthimpl) {
            m2623getMinWidthimpl = m2621getMaxWidthimpl2;
        }
        if (m2623getMinWidthimpl <= m2621getMaxWidthimpl) {
            m2621getMaxWidthimpl = m2623getMinWidthimpl;
        }
        int m2622getMinHeightimpl2 = Constraints.m2622getMinHeightimpl(j2);
        if (m2622getMinHeightimpl2 < m2622getMinHeightimpl) {
            m2622getMinHeightimpl2 = m2622getMinHeightimpl;
        }
        if (m2622getMinHeightimpl2 > m2620getMaxHeightimpl) {
            m2622getMinHeightimpl2 = m2620getMaxHeightimpl;
        }
        int m2620getMaxHeightimpl2 = Constraints.m2620getMaxHeightimpl(j2);
        if (m2620getMaxHeightimpl2 >= m2622getMinHeightimpl) {
            m2622getMinHeightimpl = m2620getMaxHeightimpl2;
        }
        if (m2622getMinHeightimpl <= m2620getMaxHeightimpl) {
            m2620getMaxHeightimpl = m2622getMinHeightimpl;
        }
        return Constraints(m2623getMinWidthimpl2, m2621getMaxWidthimpl, m2622getMinHeightimpl2, m2620getMaxHeightimpl);
    }

    /* renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m2635constrain4WqzIAM(long j, long j2) {
        int i = (int) (j2 >> 32);
        int m2623getMinWidthimpl = Constraints.m2623getMinWidthimpl(j);
        int m2621getMaxWidthimpl = Constraints.m2621getMaxWidthimpl(j);
        if (i < m2623getMinWidthimpl) {
            i = m2623getMinWidthimpl;
        }
        if (i <= m2621getMaxWidthimpl) {
            m2621getMaxWidthimpl = i;
        }
        int i2 = (int) (j2 & 4294967295L);
        int m2622getMinHeightimpl = Constraints.m2622getMinHeightimpl(j);
        int m2620getMaxHeightimpl = Constraints.m2620getMaxHeightimpl(j);
        if (i2 < m2622getMinHeightimpl) {
            i2 = m2622getMinHeightimpl;
        }
        if (i2 <= m2620getMaxHeightimpl) {
            m2620getMaxHeightimpl = i2;
        }
        return IntSize.m2846constructorimpl((m2621getMaxWidthimpl << 32) | (m2620getMaxHeightimpl & 4294967295L));
    }

    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m2638constrainWidthK40F9xA(long j, int i) {
        int m2623getMinWidthimpl = Constraints.m2623getMinWidthimpl(j);
        int m2621getMaxWidthimpl = Constraints.m2621getMaxWidthimpl(j);
        if (i < m2623getMinWidthimpl) {
            i = m2623getMinWidthimpl;
        }
        return i > m2621getMaxWidthimpl ? m2621getMaxWidthimpl : i;
    }

    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m2637constrainHeightK40F9xA(long j, int i) {
        int m2622getMinHeightimpl = Constraints.m2622getMinHeightimpl(j);
        int m2620getMaxHeightimpl = Constraints.m2620getMaxHeightimpl(j);
        if (i < m2622getMinHeightimpl) {
            i = m2622getMinHeightimpl;
        }
        return i > m2620getMaxHeightimpl ? m2620getMaxHeightimpl : i;
    }

    /* renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m2639isSatisfiedBy4WqzIAM(long j, long j2) {
        int i = (int) (j2 >> 32);
        if (Constraints.m2623getMinWidthimpl(j) <= i && i <= Constraints.m2621getMaxWidthimpl(j)) {
            int i2 = (int) (j2 & 4294967295L);
            if (Constraints.m2622getMinHeightimpl(j) <= i2 && i2 <= Constraints.m2620getMaxHeightimpl(j)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m2641offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m2640offsetNN6EwU(j, i, i2);
    }

    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m2640offsetNN6EwU(long j, int i, int i2) {
        int m2623getMinWidthimpl = Constraints.m2623getMinWidthimpl(j) + i;
        if (m2623getMinWidthimpl < 0) {
            m2623getMinWidthimpl = 0;
        }
        int m2621getMaxWidthimpl = Constraints.m2621getMaxWidthimpl(j);
        if (m2621getMaxWidthimpl != Integer.MAX_VALUE && (m2621getMaxWidthimpl = m2621getMaxWidthimpl + i) < 0) {
            m2621getMaxWidthimpl = 0;
        }
        int m2622getMinHeightimpl = Constraints.m2622getMinHeightimpl(j) + i2;
        if (m2622getMinHeightimpl < 0) {
            m2622getMinHeightimpl = 0;
        }
        int m2620getMaxHeightimpl = Constraints.m2620getMaxHeightimpl(j);
        return Constraints(m2623getMinWidthimpl, m2621getMaxWidthimpl, m2622getMinHeightimpl, (m2620getMaxHeightimpl == Integer.MAX_VALUE || (m2620getMaxHeightimpl = m2620getMaxHeightimpl + i2) >= 0) ? m2620getMaxHeightimpl : 0);
    }

    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (!((i3 >= 0) & (i2 >= i) & (i4 >= i3) & (i >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }
}
