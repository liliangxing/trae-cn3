package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: MultiWidgetSelectionDelegate.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a4\u0010\f\u001a\u00020\r*\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0010j\b\u0012\u0004\u0012\u00020\t`\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0002\u001a\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001f\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001a\u001a\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002\u001a\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001a\u001f\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"appendSelectableInfo", "", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "localPosition", "Landroidx/compose/ui/geometry/Offset;", "previousHandlePosition", "selectableId", "", "appendSelectableInfo-Parwq6A", "(Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;Landroidx/compose/ui/text/TextLayoutResult;JJJ)V", "getPreviousAdjustedOffset", "", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "currentSelectableId", "currentTextLength", "getXDirection", "Landroidx/compose/foundation/text/selection/Direction;", "position", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getXDirection-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/foundation/text/selection/Direction;", "getYDirection", "getYDirection-3MmeM6k", "getDirectionById", "anchorSelectableId", "isSelected", "", "currentDirection", "otherDirection", "getOffsetForPosition", "getOffsetForPosition-3MmeM6k", "(JLandroidx/compose/ui/text/TextLayoutResult;)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class MultiWidgetSelectionDelegateKt {
    /* renamed from: appendSelectableInfo-Parwq6A, reason: not valid java name */
    public static final void m2056appendSelectableInfoParwq6A(SelectionLayoutBuilder selectionLayoutBuilder, TextLayoutResult textLayoutResult, long j, long j2, long j3) {
        Direction appendSelectableInfo_Parwq6A$otherDirection;
        Direction direction;
        Direction direction2;
        Direction direction3;
        Direction direction4;
        int i;
        int previousAdjustedOffset;
        Selection.AnchorInfo start;
        Selection.AnchorInfo end;
        Rect rect = new Rect(0.0f, 0.0f, (int) (textLayoutResult.getSize-YbymL2g() >> 32), (int) (textLayoutResult.getSize-YbymL2g() & 4294967295L));
        Direction m2058getXDirection3MmeM6k = m2058getXDirection3MmeM6k(j, rect);
        Direction m2059getYDirection3MmeM6k = m2059getYDirection3MmeM6k(j, rect);
        if (selectionLayoutBuilder.getIsStartHandle()) {
            Selection previousSelection = selectionLayoutBuilder.getPreviousSelection();
            appendSelectableInfo_Parwq6A$otherDirection = appendSelectableInfo_Parwq6A$otherDirection(m2058getXDirection3MmeM6k, m2059getYDirection3MmeM6k, selectionLayoutBuilder, j3, previousSelection != null ? previousSelection.getEnd() : null);
            direction3 = appendSelectableInfo_Parwq6A$otherDirection;
            direction4 = direction3;
            direction = m2058getXDirection3MmeM6k;
            direction2 = m2059getYDirection3MmeM6k;
        } else {
            Selection previousSelection2 = selectionLayoutBuilder.getPreviousSelection();
            appendSelectableInfo_Parwq6A$otherDirection = appendSelectableInfo_Parwq6A$otherDirection(m2058getXDirection3MmeM6k, m2059getYDirection3MmeM6k, selectionLayoutBuilder, j3, previousSelection2 != null ? previousSelection2.getStart() : null);
            direction = appendSelectableInfo_Parwq6A$otherDirection;
            direction2 = direction;
            direction3 = m2058getXDirection3MmeM6k;
            direction4 = m2059getYDirection3MmeM6k;
        }
        if (isSelected(SelectionLayoutKt.resolve2dDirection(m2058getXDirection3MmeM6k, m2059getYDirection3MmeM6k), appendSelectableInfo_Parwq6A$otherDirection)) {
            int length = textLayoutResult.getLayoutInput().getText().length();
            if (selectionLayoutBuilder.getIsStartHandle()) {
                int m2057getOffsetForPosition3MmeM6k = m2057getOffsetForPosition3MmeM6k(j, textLayoutResult);
                Selection previousSelection3 = selectionLayoutBuilder.getPreviousSelection();
                int previousAdjustedOffset2 = (previousSelection3 == null || (end = previousSelection3.getEnd()) == null) ? m2057getOffsetForPosition3MmeM6k : getPreviousAdjustedOffset(end, selectionLayoutBuilder.getSelectableIdOrderingComparator(), j3, length);
                previousAdjustedOffset = m2057getOffsetForPosition3MmeM6k;
                i = previousAdjustedOffset2;
            } else {
                int m2057getOffsetForPosition3MmeM6k2 = m2057getOffsetForPosition3MmeM6k(j, textLayoutResult);
                Selection previousSelection4 = selectionLayoutBuilder.getPreviousSelection();
                i = m2057getOffsetForPosition3MmeM6k2;
                previousAdjustedOffset = (previousSelection4 == null || (start = previousSelection4.getStart()) == null) ? m2057getOffsetForPosition3MmeM6k2 : getPreviousAdjustedOffset(start, selectionLayoutBuilder.getSelectableIdOrderingComparator(), j3, length);
            }
            selectionLayoutBuilder.appendInfo(j3, previousAdjustedOffset, direction, direction2, i, direction3, direction4, ((9223372034707292159L & j2) > InlineClassHelperKt.UnspecifiedPackedFloats ? 1 : ((9223372034707292159L & j2) == InlineClassHelperKt.UnspecifiedPackedFloats ? 0 : -1)) == 0 ? -1 : m2057getOffsetForPosition3MmeM6k(j2, textLayoutResult), textLayoutResult);
        }
    }

    private static final Direction appendSelectableInfo_Parwq6A$otherDirection(Direction direction, Direction direction2, SelectionLayoutBuilder selectionLayoutBuilder, long j, Selection.AnchorInfo anchorInfo) {
        Direction directionById;
        return (anchorInfo == null || (directionById = getDirectionById(selectionLayoutBuilder, anchorInfo.getSelectableId(), j)) == null) ? SelectionLayoutKt.resolve2dDirection(direction, direction2) : directionById;
    }

    private static final int getPreviousAdjustedOffset(Selection.AnchorInfo anchorInfo, Comparator<Long> comparator, long j, int i) {
        int compare = comparator.compare(Long.valueOf(anchorInfo.getSelectableId()), Long.valueOf(j));
        if (compare < 0) {
            return 0;
        }
        return compare > 0 ? i : anchorInfo.getOffset();
    }

    private static final Direction getDirectionById(SelectionLayoutBuilder selectionLayoutBuilder, long j, long j2) {
        int compare = selectionLayoutBuilder.getSelectableIdOrderingComparator().compare(Long.valueOf(j), Long.valueOf(j2));
        if (compare < 0) {
            return Direction.BEFORE;
        }
        if (compare > 0) {
            return Direction.AFTER;
        }
        return Direction.f60ON;
    }

    private static final boolean isSelected(Direction direction, Direction direction2) {
        return direction == Direction.f60ON || direction != direction2;
    }

    /* renamed from: getXDirection-3MmeM6k, reason: not valid java name */
    private static final Direction m2058getXDirection3MmeM6k(long j, Rect rect) {
        int i = (int) (j >> 32);
        return Float.intBitsToFloat(i) < rect.getLeft() ? Direction.BEFORE : Float.intBitsToFloat(i) > rect.getRight() ? Direction.AFTER : Direction.f60ON;
    }

    /* renamed from: getYDirection-3MmeM6k, reason: not valid java name */
    private static final Direction m2059getYDirection3MmeM6k(long j, Rect rect) {
        int i = (int) (j & 4294967295L);
        return Float.intBitsToFloat(i) < rect.getTop() ? Direction.BEFORE : Float.intBitsToFloat(i) > rect.getBottom() ? Direction.AFTER : Direction.f60ON;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    private static final int m2057getOffsetForPosition3MmeM6k(long j, TextLayoutResult textLayoutResult) {
        int i = (int) (4294967295L & j);
        if (Float.intBitsToFloat(i) <= 0.0f) {
            return 0;
        }
        if (Float.intBitsToFloat(i) >= textLayoutResult.getMultiParagraph().getHeight()) {
            return textLayoutResult.getLayoutInput().getText().length();
        }
        return textLayoutResult.getOffsetForPosition-k-4lQ0M(j);
    }
}
