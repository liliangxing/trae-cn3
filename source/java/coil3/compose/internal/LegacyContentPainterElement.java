package coil3.compose.internal;

import androidx.compose.p001ui.node.DrawModifierNodeKt;
import androidx.compose.p001ui.node.LayoutModifierNodeKt;
import androidx.compose.p001ui.node.ModifierNodeElement;
import androidx.compose.p001ui.platform.InspectorInfo;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\f\u0010\u0013\u001a\u00020\u0011*\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0017\u001a\u00020\bHÂ\u0003J\t\u0010\u0018\u001a\u00020\nHÂ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\fHÂ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÇ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH×\u0003J\t\u0010\u001f\u001a\u00020 H×\u0001J\t\u0010!\u001a\u00020\"H×\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcoil3/compose/internal/LegacyContentPainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcoil3/compose/internal/LegacyContentPainterNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "create", SettingV2Monitor.REPORT_TYPE_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final /* data */ class LegacyContentPainterElement extends ModifierNodeElement<LegacyContentPainterNode> {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;

    /* renamed from: component1, reason: from getter */
    private final Painter getPainter() {
        return this.painter;
    }

    /* renamed from: component2, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: component3, reason: from getter */
    private final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* renamed from: component4, reason: from getter */
    private final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: component5, reason: from getter */
    private final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public static /* synthetic */ LegacyContentPainterElement copy$default(LegacyContentPainterElement legacyContentPainterElement, Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 1) != 0) {
            painter = legacyContentPainterElement.painter;
        }
        if ((i & 2) != 0) {
            alignment = legacyContentPainterElement.alignment;
        }
        Alignment alignment2 = alignment;
        if ((i & 4) != 0) {
            contentScale = legacyContentPainterElement.contentScale;
        }
        ContentScale contentScale2 = contentScale;
        if ((i & 8) != 0) {
            f = legacyContentPainterElement.alpha;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            colorFilter = legacyContentPainterElement.colorFilter;
        }
        return legacyContentPainterElement.copy(painter, alignment2, contentScale2, f2, colorFilter);
    }

    public final LegacyContentPainterElement copy(Painter painter, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        return new LegacyContentPainterElement(painter, alignment, contentScale, alpha, colorFilter);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyContentPainterElement)) {
            return false;
        }
        LegacyContentPainterElement legacyContentPainterElement = (LegacyContentPainterElement) other;
        return Intrinsics.areEqual(this.painter, legacyContentPainterElement.painter) && Intrinsics.areEqual(this.alignment, legacyContentPainterElement.alignment) && Intrinsics.areEqual(this.contentScale, legacyContentPainterElement.contentScale) && Float.compare(this.alpha, legacyContentPainterElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, legacyContentPainterElement.colorFilter);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public int hashCode() {
        int hashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return hashCode + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    public String toString() {
        return "LegacyContentPainterElement(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    public LegacyContentPainterElement(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    /* renamed from: create, reason: avoid collision after fix types in other method */
    public LegacyContentPainterNode getNode() {
        return new LegacyContentPainterNode(this.painter, this.alignment, this.contentScale, this.alpha, this.colorFilter);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void update(LegacyContentPainterNode node) {
        boolean z = !Size.equals-impl0(node.getPainter().getIntrinsicSize-NH-jbRc(), this.painter.getIntrinsicSize-NH-jbRc());
        node.setPainter(this.painter);
        node.setAlignment(this.alignment);
        node.setContentScale(this.contentScale);
        node.setAlpha(this.alpha);
        node.setColorFilter(this.colorFilter);
        if (z) {
            LayoutModifierNodeKt.invalidateMeasurement(node);
        }
        DrawModifierNodeKt.invalidateDraw(node);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName(StrategyConstants.CONTENT);
        inspectorInfo.getProperties().set("painter", this.painter);
        inspectorInfo.getProperties().set("alignment", this.alignment);
        inspectorInfo.getProperties().set("contentScale", this.contentScale);
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
    }
}
