package com.bytedance.trae.design.compose;

import androidx.compose.ui.unit.Dp;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TraeContextMenuPopup.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;", "", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", "F", "getTop-D9Ej5fM", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "copy", "copy-a9UjIt4", "(FFFF)Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "design-system-compose_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TraeContextMenuShadowPadding {
    public static final int $stable = 0;
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ TraeContextMenuShadowPadding(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    /* renamed from: copy-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ TraeContextMenuShadowPadding m8509copya9UjIt4$default(TraeContextMenuShadowPadding traeContextMenuShadowPadding, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = traeContextMenuShadowPadding.start;
        }
        if ((i & 2) != 0) {
            f2 = traeContextMenuShadowPadding.top;
        }
        if ((i & 4) != 0) {
            f3 = traeContextMenuShadowPadding.end;
        }
        if ((i & 8) != 0) {
            f4 = traeContextMenuShadowPadding.bottom;
        }
        return traeContextMenuShadowPadding.m8514copya9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    /* renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getEnd() {
        return this.end;
    }

    /* renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: copy-a9UjIt4, reason: not valid java name */
    public final TraeContextMenuShadowPadding m8514copya9UjIt4(float start, float top, float end, float bottom) {
        return new TraeContextMenuShadowPadding(start, top, end, bottom, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeContextMenuShadowPadding)) {
            return false;
        }
        TraeContextMenuShadowPadding traeContextMenuShadowPadding = (TraeContextMenuShadowPadding) other;
        return Dp.m7068equalsimpl0(this.start, traeContextMenuShadowPadding.start) && Dp.m7068equalsimpl0(this.top, traeContextMenuShadowPadding.top) && Dp.m7068equalsimpl0(this.end, traeContextMenuShadowPadding.end) && Dp.m7068equalsimpl0(this.bottom, traeContextMenuShadowPadding.bottom);
    }

    public int hashCode() {
        return (((((Dp.m7069hashCodeimpl(this.start) * 31) + Dp.m7069hashCodeimpl(this.top)) * 31) + Dp.m7069hashCodeimpl(this.end)) * 31) + Dp.m7069hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "TraeContextMenuShadowPadding(start=" + ((Object) Dp.m7074toStringimpl(this.start)) + ", top=" + ((Object) Dp.m7074toStringimpl(this.top)) + ", end=" + ((Object) Dp.m7074toStringimpl(this.end)) + ", bottom=" + ((Object) Dp.m7074toStringimpl(this.bottom)) + ')';
    }

    private TraeContextMenuShadowPadding(float f, float f2, float f3, float f4) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
    }

    /* renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m8517getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m8518getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m8516getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m8515getBottomD9Ej5fM() {
        return this.bottom;
    }

    public /* synthetic */ TraeContextMenuShadowPadding(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.m7063constructorimpl(0) : f, (i & 2) != 0 ? Dp.m7063constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m7063constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m7063constructorimpl(0) : f4, null);
    }
}
