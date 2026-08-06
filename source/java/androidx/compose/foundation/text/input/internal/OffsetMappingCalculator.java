package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* compiled from: OffsetMappingCalculator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "", "<init>", "()V", "ops", "Landroidx/compose/foundation/text/input/internal/OpArray;", "[I", "opsSize", "", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "mapFromSource", "Landroidx/compose/ui/text/TextRange;", "offset", "mapFromSource--jx7JFs", "(I)J", "mapFromDest", "mapFromDest--jx7JFs", "map", "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops = OpArray.m1545constructorimpl(10);
    private int opsSize;

    public final void recordEditOperation(int sourceStart, int sourceEnd, int newLength) {
        if (!(newLength >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected newLen to be ≥ 0, was " + newLength);
        }
        int min = Math.min(sourceStart, sourceEnd);
        int max = Math.max(min, sourceEnd) - min;
        if (max >= 2 || max != newLength) {
            int i = this.opsSize + 1;
            if (i > OpArray.m1552getSizeimpl(this.ops)) {
                this.ops = OpArray.m1547copyOfpSmdads(this.ops, Math.max(i * 2, OpArray.m1552getSizeimpl(this.ops) * 2));
            }
            OpArray.m1554setimpl(this.ops, this.opsSize, min, max, newLength);
            this.opsSize = i;
        }
    }

    /* renamed from: mapFromSource--jx7JFs, reason: not valid java name */
    public final long m1543mapFromSourcejx7JFs(int offset) {
        return m1540mapfzxv0v0(offset, true);
    }

    /* renamed from: mapFromDest--jx7JFs, reason: not valid java name */
    public final long m1542mapFromDestjx7JFs(int offset) {
        return m1540mapfzxv0v0(offset, false);
    }

    /* renamed from: map-fzxv0v0, reason: not valid java name */
    private final long m1540mapfzxv0v0(int offset, boolean fromSource) {
        int i;
        int[] iArr = this.ops;
        int i2 = this.opsSize;
        boolean z = !fromSource;
        if (i2 < 0) {
            i = offset;
        } else if (z) {
            int i3 = i2 - 1;
            int i4 = offset;
            while (-1 < i3) {
                int i5 = i3 * 3;
                int i6 = iArr[i5];
                int i7 = iArr[i5 + 1];
                int i8 = iArr[i5 + 2];
                long m1541mapStepC6uMEY = m1541mapStepC6uMEY(i4, i6, i7, i8, fromSource);
                long m1541mapStepC6uMEY2 = m1541mapStepC6uMEY(offset, i6, i7, i8, fromSource);
                i3--;
                i4 = Math.min(TextRange.m6520getStartimpl(m1541mapStepC6uMEY), TextRange.m6520getStartimpl(m1541mapStepC6uMEY2));
                offset = Math.max(TextRange.m6515getEndimpl(m1541mapStepC6uMEY), TextRange.m6515getEndimpl(m1541mapStepC6uMEY2));
            }
            i = offset;
            offset = i4;
        } else {
            int i9 = 0;
            int i10 = offset;
            while (i9 < i2) {
                int i11 = i9 * 3;
                int i12 = iArr[i11];
                int i13 = iArr[i11 + 1];
                int i14 = iArr[i11 + 2];
                long m1541mapStepC6uMEY3 = m1541mapStepC6uMEY(i10, i12, i13, i14, fromSource);
                long m1541mapStepC6uMEY4 = m1541mapStepC6uMEY(offset, i12, i13, i14, fromSource);
                i9++;
                i10 = Math.min(TextRange.m6520getStartimpl(m1541mapStepC6uMEY3), TextRange.m6520getStartimpl(m1541mapStepC6uMEY4));
                offset = Math.max(TextRange.m6515getEndimpl(m1541mapStepC6uMEY3), TextRange.m6515getEndimpl(m1541mapStepC6uMEY4));
            }
            i = offset;
            offset = i10;
        }
        return TextRangeKt.TextRange(offset, i);
    }

    /* renamed from: mapStep-C6u-MEY, reason: not valid java name */
    private final long m1541mapStepC6uMEY(int offset, int opOffset, int untransformedLen, int transformedLen, boolean fromSource) {
        int i = fromSource ? untransformedLen : transformedLen;
        if (fromSource) {
            untransformedLen = transformedLen;
        }
        if (offset < opOffset) {
            return TextRangeKt.TextRange(offset);
        }
        if (offset == opOffset) {
            if (i == 0) {
                return TextRangeKt.TextRange(opOffset, untransformedLen + opOffset);
            }
            return TextRangeKt.TextRange(opOffset);
        }
        if (offset >= opOffset + i) {
            return TextRangeKt.TextRange((offset - i) + untransformedLen);
        }
        if (untransformedLen == 0) {
            return TextRangeKt.TextRange(opOffset);
        }
        return TextRangeKt.TextRange(opOffset, untransformedLen + opOffset);
    }
}
