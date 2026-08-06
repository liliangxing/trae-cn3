package coil3.compose.internal;

import androidx.compose.p001ui.node.DrawModifierNodeKt;
import androidx.compose.p001ui.node.LayoutModifierNodeKt;
import androidx.compose.p001ui.node.ModifierNodeElement;
import androidx.compose.p001ui.node.SemanticsModifierNodeKt;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\u0015*\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÂ\u0003J\t\u0010\u001b\u001a\u00020\bHÂ\u0003J\t\u0010\u001c\u001a\u00020\nHÂ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÂ\u0003J\t\u0010\u001e\u001a\u00020\u000eHÂ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0010HÂ\u0003JS\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÇ\u0001J\u0013\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H×\u0003J\t\u0010$\u001a\u00020%H×\u0001J\t\u0010&\u001a\u00020\u0010H×\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcoil3/compose/internal/OptimizedSubcomposeContentPainterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcoil3/compose/internal/OptimizedSubcomposeContentPainterNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "contentDescription", "", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLjava/lang/String;)V", "create", SettingV2Monitor.REPORT_TYPE_UPDATE, "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final /* data */ class OptimizedSubcomposeContentPainterElement extends ModifierNodeElement<OptimizedSubcomposeContentPainterNode> {
    public static final int $stable = 0;
    private final Alignment alignment;
    private final float alpha;
    private final boolean clipToBounds;
    private final ColorFilter colorFilter;
    private final String contentDescription;
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

    /* renamed from: component6, reason: from getter */
    private final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    /* renamed from: component7, reason: from getter */
    private final String getContentDescription() {
        return this.contentDescription;
    }

    public static /* synthetic */ OptimizedSubcomposeContentPainterElement copy$default(OptimizedSubcomposeContentPainterElement optimizedSubcomposeContentPainterElement, Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            painter = optimizedSubcomposeContentPainterElement.painter;
        }
        if ((i & 2) != 0) {
            alignment = optimizedSubcomposeContentPainterElement.alignment;
        }
        Alignment alignment2 = alignment;
        if ((i & 4) != 0) {
            contentScale = optimizedSubcomposeContentPainterElement.contentScale;
        }
        ContentScale contentScale2 = contentScale;
        if ((i & 8) != 0) {
            f = optimizedSubcomposeContentPainterElement.alpha;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            colorFilter = optimizedSubcomposeContentPainterElement.colorFilter;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i & 32) != 0) {
            z = optimizedSubcomposeContentPainterElement.clipToBounds;
        }
        boolean z2 = z;
        if ((i & 64) != 0) {
            str = optimizedSubcomposeContentPainterElement.contentDescription;
        }
        return optimizedSubcomposeContentPainterElement.copy(painter, alignment2, contentScale2, f2, colorFilter2, z2, str);
    }

    public final OptimizedSubcomposeContentPainterElement copy(Painter painter, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter, boolean clipToBounds, String contentDescription) {
        return new OptimizedSubcomposeContentPainterElement(painter, alignment, contentScale, alpha, colorFilter, clipToBounds, contentDescription);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptimizedSubcomposeContentPainterElement)) {
            return false;
        }
        OptimizedSubcomposeContentPainterElement optimizedSubcomposeContentPainterElement = (OptimizedSubcomposeContentPainterElement) other;
        return Intrinsics.areEqual(this.painter, optimizedSubcomposeContentPainterElement.painter) && Intrinsics.areEqual(this.alignment, optimizedSubcomposeContentPainterElement.alignment) && Intrinsics.areEqual(this.contentScale, optimizedSubcomposeContentPainterElement.contentScale) && Float.compare(this.alpha, optimizedSubcomposeContentPainterElement.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, optimizedSubcomposeContentPainterElement.colorFilter) && this.clipToBounds == optimizedSubcomposeContentPainterElement.clipToBounds && Intrinsics.areEqual(this.contentDescription, optimizedSubcomposeContentPainterElement.contentDescription);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public int hashCode() {
        int hashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        int hashCode2 = (((hashCode + (colorFilter == null ? 0 : colorFilter.hashCode())) * 31) + Boolean.hashCode(this.clipToBounds)) * 31;
        String str = this.contentDescription;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "OptimizedSubcomposeContentPainterElement(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ", clipToBounds=" + this.clipToBounds + ", contentDescription=" + this.contentDescription + ')';
    }

    public OptimizedSubcomposeContentPainterElement(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str) {
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.clipToBounds = z;
        this.contentDescription = str;
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    /* renamed from: create, reason: avoid collision after fix types in other method */
    public OptimizedSubcomposeContentPainterNode getNode() {
        return new OptimizedSubcomposeContentPainterNode(this.painter, this.alignment, this.contentScale, this.alpha, this.colorFilter, this.clipToBounds, this.contentDescription);
    }

    @Override // androidx.compose.p001ui.node.ModifierNodeElement
    public void update(OptimizedSubcomposeContentPainterNode node) {
        boolean z = !Size.equals-impl0(node.getPainter().getIntrinsicSize-NH-jbRc(), this.painter.getIntrinsicSize-NH-jbRc());
        node.setPainter(this.painter);
        node.setAlignment(this.alignment);
        node.setContentScale(this.contentScale);
        node.setAlpha(this.alpha);
        node.setColorFilter(this.colorFilter);
        node.setClipToBounds(this.clipToBounds);
        if (!Intrinsics.areEqual(node.getContentDescription(), this.contentDescription)) {
            node.setContentDescription(this.contentDescription);
            SemanticsModifierNodeKt.invalidateSemantics(node);
        }
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
        inspectorInfo.getProperties().set("clipToBounds", Boolean.valueOf(this.clipToBounds));
        inspectorInfo.getProperties().set("contentDescription", this.contentDescription);
    }
}
