package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldMagnifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldMagnifierKt {

    /* compiled from: TextFieldMagnifier.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-hUlJWOE, reason: not valid java name */
    public static final long m1933calculateSelectionMagnifierCenterAndroidhUlJWOE(TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, long j) {
        int i;
        long m1958getHandleDragPositionF1C5BW0 = textFieldSelectionState.m1958getHandleDragPositionF1C5BW0();
        if (!((9223372034707292159L & m1958getHandleDragPositionF1C5BW0) == InlineClassHelperKt.UnspecifiedPackedFloats)) {
            if (!(transformedTextFieldState.getVisualText().length() == 0)) {
                long selection = transformedTextFieldState.getVisualText().getSelection();
                Handle draggingHandle = textFieldSelectionState.getDraggingHandle();
                int i2 = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
                if (i2 == -1) {
                    return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                }
                if (i2 == 1 || i2 == 2) {
                    i = TextRange.getStart-impl(selection);
                } else {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = TextRange.getEnd-impl(selection);
                }
                TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
                if (layoutResult == null) {
                    return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                }
                float intBitsToFloat = Float.intBitsToFloat((int) (m1958getHandleDragPositionF1C5BW0 >> 32));
                int lineForOffset = layoutResult.getLineForOffset(i);
                float lineLeft = layoutResult.getLineLeft(lineForOffset);
                float lineRight = layoutResult.getLineRight(lineForOffset);
                float coerceIn = RangesKt.coerceIn(intBitsToFloat, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
                if (!IntSize.equals-impl0(j, IntSize.Companion.getZero-YbymL2g()) && Math.abs(intBitsToFloat - coerceIn) > ((int) (j >> 32)) / 2) {
                    return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                }
                float lineTop = layoutResult.getLineTop(lineForOffset);
                long m4585constructorimpl = Offset.m4585constructorimpl((Float.floatToRawIntBits(((layoutResult.getLineBottom(lineForOffset) - lineTop) / 2) + lineTop) & 4294967295L) | (Float.floatToRawIntBits(coerceIn) << 32));
                LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
                if (textLayoutNodeCoordinates != null) {
                    if (!textLayoutNodeCoordinates.isAttached()) {
                        textLayoutNodeCoordinates = null;
                    }
                    if (textLayoutNodeCoordinates != null) {
                        m4585constructorimpl = TextLayoutStateKt.m1890coerceIn3MmeM6k(m4585constructorimpl, SelectionManagerKt.visibleBounds(textLayoutNodeCoordinates));
                    }
                }
                return TextLayoutStateKt.m1892fromTextLayoutToCoreUv8p0NA(textLayoutState, m4585constructorimpl);
            }
        }
        return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
    }
}
