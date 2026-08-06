package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: CursorAnchorInfoBuilder.android.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u001au\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a,\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u001c"}, d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "build-vxqZcH0", "(Landroid/view/inputmethod/CursorAnchorInfo$Builder;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Landroidx/compose/ui/text/TextLayoutResult;Landroid/graphics/Matrix;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ZZZZ)Landroid/view/inputmethod/CursorAnchorInfo;", "setInsertionMarker", "selectionStart", "", "addCharacterBounds", "startOffset", "endOffset", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class CursorAnchorInfoBuilder_androidKt {
    /* renamed from: build-vxqZcH0, reason: not valid java name */
    public static final CursorAnchorInfo m1787buildvxqZcH0(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4) {
        builder.reset();
        builder.setMatrix(matrix);
        int i = TextRange.getMin-impl(j);
        builder.setSelectionRange(i, TextRange.getMax-impl(j));
        if (z) {
            setInsertionMarker(builder, i, textLayoutResult, rect);
        }
        if (z2) {
            int i2 = textRange != null ? TextRange.getMin-impl(textRange.unbox-impl()) : -1;
            int i3 = textRange != null ? TextRange.getMax-impl(textRange.unbox-impl()) : -1;
            boolean z5 = false;
            if (i2 >= 0 && i2 < i3) {
                z5 = true;
            }
            if (z5) {
                builder.setComposingText(i2, charSequence.subSequence(i2, i3));
                addCharacterBounds(builder, i2, i3, textLayoutResult, rect);
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

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult, Rect rect) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        float coerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0.0f, (int) (textLayoutResult.getSize-YbymL2g() >> 32));
        boolean containsInclusive = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, coerceIn, cursorRect.getTop());
        boolean containsInclusive2 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, coerceIn, cursorRect.getBottom());
        int i2 = 1;
        boolean z = textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl;
        if (!containsInclusive && !containsInclusive2) {
            i2 = 0;
        }
        if (!containsInclusive || !containsInclusive2) {
            i2 |= 2;
        }
        builder.setInsertionMarkerLocation(coerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), z ? i2 | 4 : i2);
        return builder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x004e, code lost:
    
        if (androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r18, r5.getRight(), r5.getBottom()) == false) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder builder, int i, int i2, TextLayoutResult textLayoutResult, Rect rect) {
        int i3;
        float[] fArr = new float[(i2 - i) * 4];
        textLayoutResult.getMultiParagraph().fillBoundingBoxes-8ffj60Q(TextRangeKt.TextRange(i, i2), fArr, 0);
        for (int i4 = i; i4 < i2; i4++) {
            int i5 = (i4 - i) * 4;
            Rect rect2 = new Rect(fArr[i5], fArr[i5 + 1], fArr[i5 + 2], fArr[i5 + 3]);
            boolean overlaps = rect.overlaps(rect2);
            if (LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, rect2.getLeft(), rect2.getTop())) {
                i3 = overlaps;
            }
            i3 = (overlaps ? 1 : 0) | 2;
            if (textLayoutResult.getBidiRunDirection(i4) == ResolvedTextDirection.Rtl) {
                i3 = (i3 == true ? 1 : 0) | 4;
            }
            int i6 = i4;
            builder.addCharacterBounds(i6, rect2.getLeft(), rect2.getTop(), rect2.getRight(), rect2.getBottom(), i3);
        }
        return builder;
    }
}
