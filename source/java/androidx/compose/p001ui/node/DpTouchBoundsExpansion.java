package androidx.compose.p001ui.node;

import androidx.compose.p001ui.unit.C0066Dp;
import androidx.compose.p001ui.unit.Density;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TouchBoundsExpansion.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001d\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001f\u0010\fJ\t\u0010 \u001a\u00020\bHÆ\u0003JB\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011¨\u0006+"}, d2 = {"Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "isLayoutDirectionAware", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", "F", "getTop-D9Ej5fM", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM", "()Z", "roundToTouchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "density", "Landroidx/compose/ui/unit/Density;", "roundToTouchBoundsExpansion-TW6G1oQ", "(Landroidx/compose/ui/unit/Density;)J", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "component5", "copy", "copy-lDy3nrA", "(FFFFZ)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final /* data */ class DpTouchBoundsExpansion {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float bottom;
    private final float end;
    private final boolean isLayoutDirectionAware;
    private final float start;
    private final float top;

    public /* synthetic */ DpTouchBoundsExpansion(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    /* renamed from: copy-lDy3nrA$default, reason: not valid java name */
    public static /* synthetic */ DpTouchBoundsExpansion m1367copylDy3nrA$default(DpTouchBoundsExpansion dpTouchBoundsExpansion, float f, float f2, float f3, float f4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpTouchBoundsExpansion.start;
        }
        if ((i & 2) != 0) {
            f2 = dpTouchBoundsExpansion.top;
        }
        float f5 = f2;
        if ((i & 4) != 0) {
            f3 = dpTouchBoundsExpansion.end;
        }
        float f6 = f3;
        if ((i & 8) != 0) {
            f4 = dpTouchBoundsExpansion.bottom;
        }
        float f7 = f4;
        if ((i & 16) != 0) {
            z = dpTouchBoundsExpansion.isLayoutDirectionAware;
        }
        return dpTouchBoundsExpansion.m1372copylDy3nrA(f, f5, f6, f7, z);
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

    /* renamed from: component5, reason: from getter */
    public final boolean getIsLayoutDirectionAware() {
        return this.isLayoutDirectionAware;
    }

    /* renamed from: copy-lDy3nrA, reason: not valid java name */
    public final DpTouchBoundsExpansion m1372copylDy3nrA(float start, float top, float end, float bottom, boolean isLayoutDirectionAware) {
        return new DpTouchBoundsExpansion(start, top, end, bottom, isLayoutDirectionAware, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DpTouchBoundsExpansion)) {
            return false;
        }
        DpTouchBoundsExpansion dpTouchBoundsExpansion = (DpTouchBoundsExpansion) other;
        return C0066Dp.m2685equalsimpl0(this.start, dpTouchBoundsExpansion.start) && C0066Dp.m2685equalsimpl0(this.top, dpTouchBoundsExpansion.top) && C0066Dp.m2685equalsimpl0(this.end, dpTouchBoundsExpansion.end) && C0066Dp.m2685equalsimpl0(this.bottom, dpTouchBoundsExpansion.bottom) && this.isLayoutDirectionAware == dpTouchBoundsExpansion.isLayoutDirectionAware;
    }

    public int hashCode() {
        return (((((((C0066Dp.m2686hashCodeimpl(this.start) * 31) + C0066Dp.m2686hashCodeimpl(this.top)) * 31) + C0066Dp.m2686hashCodeimpl(this.end)) * 31) + C0066Dp.m2686hashCodeimpl(this.bottom)) * 31) + Boolean.hashCode(this.isLayoutDirectionAware);
    }

    public String toString() {
        return "DpTouchBoundsExpansion(start=" + ((Object) C0066Dp.m2691toStringimpl(this.start)) + ", top=" + ((Object) C0066Dp.m2691toStringimpl(this.top)) + ", end=" + ((Object) C0066Dp.m2691toStringimpl(this.end)) + ", bottom=" + ((Object) C0066Dp.m2691toStringimpl(this.bottom)) + ", isLayoutDirectionAware=" + this.isLayoutDirectionAware + ')';
    }

    private DpTouchBoundsExpansion(float f, float f2, float f3, float f4, boolean z) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        this.isLayoutDirectionAware = z;
        if (!(f >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Left must be non-negative");
        }
        if (!(f2 >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Top must be non-negative");
        }
        if (!(f3 >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Right must be non-negative");
        }
        if (f4 >= 0.0f) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Bottom must be non-negative");
    }

    /* renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m1375getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m1376getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m1374getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m1373getBottomD9Ej5fM() {
        return this.bottom;
    }

    public final boolean isLayoutDirectionAware() {
        return this.isLayoutDirectionAware;
    }

    /* renamed from: roundToTouchBoundsExpansion-TW6G1oQ, reason: not valid java name */
    public final long m1377roundToTouchBoundsExpansionTW6G1oQ(Density density) {
        return TouchBoundsExpansion.m1651constructorimpl(TouchBoundsExpansion.INSTANCE.pack$ui_release(density.m2655roundToPx0680j_4(this.start), density.m2655roundToPx0680j_4(this.top), density.m2655roundToPx0680j_4(this.end), density.m2655roundToPx0680j_4(this.bottom), this.isLayoutDirectionAware));
    }

    /* compiled from: TouchBoundsExpansion.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/DpTouchBoundsExpansion$Companion;", "", "<init>", "()V", "Absolute", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "Absolute-a9UjIt4", "(FFFF)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Absolute-a9UjIt4, reason: not valid java name */
        public final DpTouchBoundsExpansion m1379Absolutea9UjIt4(float left, float top, float right, float bottom) {
            return new DpTouchBoundsExpansion(left, top, right, bottom, false, null);
        }

        /* renamed from: Absolute-a9UjIt4$default, reason: not valid java name */
        public static /* synthetic */ DpTouchBoundsExpansion m1378Absolutea9UjIt4$default(Companion companion, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = C0066Dp.m2680constructorimpl(0);
            }
            if ((i & 2) != 0) {
                f2 = C0066Dp.m2680constructorimpl(0);
            }
            if ((i & 4) != 0) {
                f3 = C0066Dp.m2680constructorimpl(0);
            }
            if ((i & 8) != 0) {
                f4 = C0066Dp.m2680constructorimpl(0);
            }
            return companion.m1379Absolutea9UjIt4(f, f2, f3, f4);
        }
    }
}
