package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: LegacyCursorAnchorInfoBuilder.android.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u001ad\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0000\u001a,\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a4\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¨\u0006\u001d"}, d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "setInsertionMarker", "selectionStart", "", "addCharacterBounds", "startOffset", "endOffset", "containsInclusive", "x", "", "y", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LegacyCursorAnchorInfoBuilder_androidKt {
    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4) {
        builder.reset();
        builder.setMatrix(matrix);
        int i = TextRange.getMin-impl(textFieldValue.getSelection-d9O1mEE());
        builder.setSelectionRange(i, TextRange.getMax-impl(textFieldValue.getSelection-d9O1mEE()));
        if (z) {
            setInsertionMarker(builder, i, offsetMapping, textLayoutResult, rect);
        }
        if (z2) {
            TextRange textRange = textFieldValue.getComposition-MzsxiRA();
            int i2 = textRange != null ? TextRange.getMin-impl(textRange.unbox-impl()) : -1;
            TextRange textRange2 = textFieldValue.getComposition-MzsxiRA();
            int i3 = textRange2 != null ? TextRange.getMax-impl(textRange2.unbox-impl()) : -1;
            boolean z5 = false;
            if (i2 >= 0 && i2 < i3) {
                z5 = true;
            }
            if (z5) {
                builder.setComposingText(i2, textFieldValue.getText().subSequence(i2, i3));
                addCharacterBounds(builder, i2, i3, offsetMapping, textLayoutResult, rect);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && z3) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(builder, rect2);
        }
        if (Build.VERSION.SDK_INT >= 34 && z4) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        if (i < 0) {
            return builder;
        }
        int originalToTransformed = offsetMapping.originalToTransformed(i);
        Rect cursorRect = textLayoutResult.getCursorRect(originalToTransformed);
        float coerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0.0f, (int) (textLayoutResult.getSize-YbymL2g() >> 32));
        boolean containsInclusive = containsInclusive(rect, coerceIn, cursorRect.getTop());
        boolean containsInclusive2 = containsInclusive(rect, coerceIn, cursorRect.getBottom());
        int i2 = 1;
        boolean z = textLayoutResult.getBidiRunDirection(originalToTransformed) == ResolvedTextDirection.Rtl;
        if (!containsInclusive && !containsInclusive2) {
            i2 = 0;
        }
        if (!containsInclusive || !containsInclusive2) {
            i2 |= 2;
        }
        builder.setInsertionMarkerLocation(coerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), z ? i2 | 4 : i2);
        return builder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x005d, code lost:
    
        if (containsInclusive(r22, r8.getRight(), r8.getBottom()) == false) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder builder, int i, int i2, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        int i3;
        int i4 = i;
        int originalToTransformed = offsetMapping.originalToTransformed(i4);
        int originalToTransformed2 = offsetMapping.originalToTransformed(i2);
        float[] fArr = new float[(originalToTransformed2 - originalToTransformed) * 4];
        textLayoutResult.getMultiParagraph().fillBoundingBoxes-8ffj60Q(TextRangeKt.TextRange(originalToTransformed, originalToTransformed2), fArr, 0);
        while (i4 < i2) {
            int originalToTransformed3 = offsetMapping.originalToTransformed(i4);
            int i5 = (originalToTransformed3 - originalToTransformed) * 4;
            Rect rect2 = new Rect(fArr[i5], fArr[i5 + 1], fArr[i5 + 2], fArr[i5 + 3]);
            boolean overlaps = rect.overlaps(rect2);
            if (containsInclusive(rect, rect2.getLeft(), rect2.getTop())) {
                i3 = overlaps;
            }
            i3 = (overlaps ? 1 : 0) | 2;
            builder.addCharacterBounds(i4, rect2.getLeft(), rect2.getTop(), rect2.getRight(), rect2.getBottom(), textLayoutResult.getBidiRunDirection(originalToTransformed3) == ResolvedTextDirection.Rtl ? i3 | 4 : i3);
            i4++;
        }
        return builder;
    }

    public static final boolean containsInclusive(Rect rect, float f, float f2) {
        if (f <= rect.getRight() && rect.getLeft() <= f) {
            if (f2 <= rect.getBottom() && rect.getTop() <= f2) {
                return true;
            }
        }
        return false;
    }
}
