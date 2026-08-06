package androidx.compose.foundation.layout;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.layout.AlignmentLine;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AlignmentLine.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetTextUnitNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/TextUnit;", "after", "<init>", "(Landroidx/compose/ui/layout/AlignmentLine;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "setAlignmentLine", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getBefore-XSAIIZE", "()J", "setBefore--R2X_6o", "(J)V", "J", "getAfter-XSAIIZE", "setAfter--R2X_6o", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class AlignmentLineOffsetTextUnitNode extends Modifier.Node implements LayoutModifierNode {
    private long after;
    private AlignmentLine alignmentLine;
    private long before;

    public /* synthetic */ AlignmentLineOffsetTextUnitNode(AlignmentLine alignmentLine, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine, j, j2);
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    public final void setAlignmentLine(AlignmentLine alignmentLine) {
        this.alignmentLine = alignmentLine;
    }

    /* renamed from: getBefore-XSAIIZE, reason: not valid java name and from getter */
    public final long getBefore() {
        return this.before;
    }

    /* renamed from: setBefore--R2X_6o, reason: not valid java name */
    public final void m895setBeforeR2X_6o(long j) {
        this.before = j;
    }

    /* renamed from: getAfter-XSAIIZE, reason: not valid java name and from getter */
    public final long getAfter() {
        return this.after;
    }

    /* renamed from: setAfter--R2X_6o, reason: not valid java name */
    public final void m894setAfterR2X_6o(long j) {
        this.after = j;
    }

    private AlignmentLineOffsetTextUnitNode(AlignmentLine alignmentLine, long j, long j2) {
        this.alignmentLine = alignmentLine;
        this.before = j;
        this.after = j2;
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m893measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        MeasureResult m871alignmentLineOffsetMeasuretjqqzMA;
        m871alignmentLineOffsetMeasuretjqqzMA = AlignmentLineKt.m871alignmentLineOffsetMeasuretjqqzMA(measureScope, this.alignmentLine, !((TextUnit.getRawType-impl(this.before) > 0L ? 1 : (TextUnit.getRawType-impl(this.before) == 0L ? 0 : -1)) == 0) ? measureScope.toDp-GaN1DYA(this.before) : Dp.Companion.getUnspecified-D9Ej5fM(), !(TextUnit.getRawType-impl(this.after) == 0) ? measureScope.toDp-GaN1DYA(this.after) : Dp.Companion.getUnspecified-D9Ej5fM(), measurable, j);
        return m871alignmentLineOffsetMeasuretjqqzMA;
    }
}
