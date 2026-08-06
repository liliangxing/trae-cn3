package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: SelectionAdjustment.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a4\u0010\u000b\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a,\u0010\u0015\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0002¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"updateSelectionBoundary", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "info", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "previousSelectionAnchor", "isExpanding", "", "currentRawOffset", "", "isStart", "snapToWordBoundary", "currentLine", "currentOffset", "otherOffset", "crossed", "adjustToBoundaries", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "boundaryFunction", "Landroidx/compose/foundation/text/selection/BoundaryFunction;", "anchorOnBoundary", "slot", "ensureAtLeastOneChar", "expandOneChar", "changeOffset", "newOffset", "foundation_release", "currentRawLine", "anchorSnappedToWordBoundary"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SelectionAdjustmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection.AnchorInfo updateSelectionBoundary(final SelectionLayout selectionLayout, final SelectableInfo selectableInfo, Selection.AnchorInfo anchorInfo) {
        final int rawStartHandleOffset = selectionLayout.getIsStartHandle() ? selectableInfo.getRawStartHandleOffset() : selectableInfo.getRawEndHandleOffset();
        if ((selectionLayout.getIsStartHandle() ? selectionLayout.getStartSlot() : selectionLayout.getEndSlot()) != selectableInfo.getSlot()) {
            return selectableInfo.anchorForOffset(rawStartHandleOffset);
        }
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                int updateSelectionBoundary$lambda$0;
                updateSelectionBoundary$lambda$0 = SelectionAdjustmentKt.updateSelectionBoundary$lambda$0(SelectableInfo.this, rawStartHandleOffset);
                return Integer.valueOf(updateSelectionBoundary$lambda$0);
            }
        });
        final int rawEndHandleOffset = selectionLayout.getIsStartHandle() ? selectableInfo.getRawEndHandleOffset() : selectableInfo.getRawStartHandleOffset();
        final int i = rawStartHandleOffset;
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                Selection.AnchorInfo updateSelectionBoundary$lambda$2;
                updateSelectionBoundary$lambda$2 = SelectionAdjustmentKt.updateSelectionBoundary$lambda$2(SelectableInfo.this, i, rawEndHandleOffset, selectionLayout, lazy);
                return updateSelectionBoundary$lambda$2;
            }
        });
        if (selectableInfo.getSelectableId() != anchorInfo.getSelectableId()) {
            return updateSelectionBoundary$lambda$3(lazy2);
        }
        int rawPreviousHandleOffset = selectableInfo.getRawPreviousHandleOffset();
        if (rawStartHandleOffset == rawPreviousHandleOffset) {
            return anchorInfo;
        }
        if (updateSelectionBoundary$lambda$1(lazy) != selectableInfo.getTextLayoutResult().getLineForOffset(rawPreviousHandleOffset)) {
            return updateSelectionBoundary$lambda$3(lazy2);
        }
        int offset = anchorInfo.getOffset();
        long j = selectableInfo.getTextLayoutResult().getWordBoundary--jx7JFs(offset);
        if (!isExpanding(selectableInfo, rawStartHandleOffset, selectionLayout.getIsStartHandle())) {
            return selectableInfo.anchorForOffset(rawStartHandleOffset);
        }
        if (offset == TextRange.getStart-impl(j) || offset == TextRange.getEnd-impl(j)) {
            return updateSelectionBoundary$lambda$3(lazy2);
        }
        return selectableInfo.anchorForOffset(rawStartHandleOffset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int updateSelectionBoundary$lambda$0(SelectableInfo selectableInfo, int i) {
        return selectableInfo.getTextLayoutResult().getLineForOffset(i);
    }

    private static final int updateSelectionBoundary$lambda$1(Lazy<Integer> lazy) {
        return ((Number) lazy.getValue()).intValue();
    }

    private static final Selection.AnchorInfo updateSelectionBoundary$lambda$3(Lazy<Selection.AnchorInfo> lazy) {
        return (Selection.AnchorInfo) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection.AnchorInfo updateSelectionBoundary$lambda$2(SelectableInfo selectableInfo, int i, int i2, SelectionLayout selectionLayout, Lazy lazy) {
        return snapToWordBoundary(selectableInfo, updateSelectionBoundary$lambda$1(lazy), i, i2, selectionLayout.getIsStartHandle(), selectionLayout.getCrossStatus() == CrossStatus.CROSSED);
    }

    private static final boolean isExpanding(SelectableInfo selectableInfo, int i, boolean z) {
        if (selectableInfo.getRawPreviousHandleOffset() == -1) {
            return true;
        }
        if (i == selectableInfo.getRawPreviousHandleOffset()) {
            return false;
        }
        if (z ^ (selectableInfo.getRawCrossStatus() == CrossStatus.CROSSED)) {
            if (i < selectableInfo.getRawPreviousHandleOffset()) {
                return true;
            }
        } else if (i > selectableInfo.getRawPreviousHandleOffset()) {
            return true;
        }
        return false;
    }

    private static final Selection.AnchorInfo snapToWordBoundary(SelectableInfo selectableInfo, int i, int i2, int i3, boolean z, boolean z2) {
        int lineStart;
        int lineEnd$default;
        long j = selectableInfo.getTextLayoutResult().getWordBoundary--jx7JFs(i2);
        if (selectableInfo.getTextLayoutResult().getLineForOffset(TextRange.getStart-impl(j)) == i) {
            lineStart = TextRange.getStart-impl(j);
        } else if (i >= selectableInfo.getTextLayoutResult().getLineCount()) {
            lineStart = selectableInfo.getTextLayoutResult().getLineStart(selectableInfo.getTextLayoutResult().getLineCount() - 1);
        } else {
            lineStart = selectableInfo.getTextLayoutResult().getLineStart(i);
        }
        if (selectableInfo.getTextLayoutResult().getLineForOffset(TextRange.getEnd-impl(j)) == i) {
            lineEnd$default = TextRange.getEnd-impl(j);
        } else if (i >= selectableInfo.getTextLayoutResult().getLineCount()) {
            lineEnd$default = TextLayoutResult.getLineEnd$default(selectableInfo.getTextLayoutResult(), selectableInfo.getTextLayoutResult().getLineCount() - 1, false, 2, (Object) null);
        } else {
            lineEnd$default = TextLayoutResult.getLineEnd$default(selectableInfo.getTextLayoutResult(), i, false, 2, (Object) null);
        }
        if (lineStart == i3) {
            return selectableInfo.anchorForOffset(lineEnd$default);
        }
        if (lineEnd$default == i3) {
            return selectableInfo.anchorForOffset(lineStart);
        }
        if (!(z ^ z2) ? i2 >= lineStart : i2 > lineEnd$default) {
            lineStart = lineEnd$default;
        }
        return selectableInfo.anchorForOffset(lineStart);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Selection adjustToBoundaries(SelectionLayout selectionLayout, BoundaryFunction boundaryFunction) {
        boolean z = selectionLayout.getCrossStatus() == CrossStatus.CROSSED;
        return new Selection(anchorOnBoundary(selectionLayout.getStartInfo(), z, true, selectionLayout.getStartSlot(), boundaryFunction), anchorOnBoundary(selectionLayout.getEndInfo(), z, false, selectionLayout.getEndSlot(), boundaryFunction), z);
    }

    private static final Selection.AnchorInfo anchorOnBoundary(SelectableInfo selectableInfo, boolean z, boolean z2, int i, BoundaryFunction boundaryFunction) {
        int rawStartHandleOffset = z2 ? selectableInfo.getRawStartHandleOffset() : selectableInfo.getRawEndHandleOffset();
        if (i != selectableInfo.getSlot()) {
            return selectableInfo.anchorForOffset(rawStartHandleOffset);
        }
        long mo2052getBoundaryfzxv0v0 = boundaryFunction.mo2052getBoundaryfzxv0v0(selectableInfo, rawStartHandleOffset);
        return selectableInfo.anchorForOffset(z ^ z2 ? TextRange.getStart-impl(mo2052getBoundaryfzxv0v0) : TextRange.getEnd-impl(mo2052getBoundaryfzxv0v0));
    }

    public static final Selection ensureAtLeastOneChar(Selection selection, SelectionLayout selectionLayout) {
        if (!SelectionLayoutKt.isCollapsed(selection, selectionLayout)) {
            return selection;
        }
        String inputText = selectionLayout.getInfo().getInputText();
        if (selectionLayout.getSize() > 1 || selectionLayout.getPreviousSelection() == null) {
            return selection;
        }
        return inputText.length() == 0 ? selection : expandOneChar(selection, selectionLayout);
    }

    private static final Selection expandOneChar(Selection selection, SelectionLayout selectionLayout) {
        int findFollowingBreak;
        SelectableInfo info = selectionLayout.getInfo();
        String inputText = info.getInputText();
        int rawStartHandleOffset = info.getRawStartHandleOffset();
        int length = inputText.length();
        if (rawStartHandleOffset == 0) {
            int findFollowingBreak2 = StringHelpers_androidKt.findFollowingBreak(inputText, 0);
            if (selectionLayout.getIsStartHandle()) {
                return Selection.copy$default(selection, changeOffset(selection.getStart(), info, findFollowingBreak2), null, true, 2, null);
            }
            return Selection.copy$default(selection, null, changeOffset(selection.getEnd(), info, findFollowingBreak2), false, 1, null);
        }
        if (rawStartHandleOffset == length) {
            int findPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(inputText, length);
            if (selectionLayout.getIsStartHandle()) {
                return Selection.copy$default(selection, changeOffset(selection.getStart(), info, findPrecedingBreak), null, false, 2, null);
            }
            return Selection.copy$default(selection, null, changeOffset(selection.getEnd(), info, findPrecedingBreak), true, 1, null);
        }
        Selection previousSelection = selectionLayout.getPreviousSelection();
        boolean z = previousSelection != null && previousSelection.getHandlesCrossed();
        if (selectionLayout.getIsStartHandle() ^ z) {
            findFollowingBreak = StringHelpers_androidKt.findPrecedingBreak(inputText, rawStartHandleOffset);
        } else {
            findFollowingBreak = StringHelpers_androidKt.findFollowingBreak(inputText, rawStartHandleOffset);
        }
        if (selectionLayout.getIsStartHandle()) {
            return Selection.copy$default(selection, changeOffset(selection.getStart(), info, findFollowingBreak), null, z, 2, null);
        }
        return Selection.copy$default(selection, null, changeOffset(selection.getEnd(), info, findFollowingBreak), z, 1, null);
    }

    private static final Selection.AnchorInfo changeOffset(Selection.AnchorInfo anchorInfo, SelectableInfo selectableInfo, int i) {
        return Selection.AnchorInfo.copy$default(anchorInfo, selectableInfo.getTextLayoutResult().getBidiRunDirection(i), i, 0L, 4, null);
    }
}
