package com.bytedance.trae.design.compose;

import androidx.compose.ui.unit.Dp;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TraeContextMenuPopup.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;", "", "Fixed", "Anchored", "Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Anchored;", "Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;", "design-system-compose_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface TraeContextMenuPosition {

    /* compiled from: TraeContextMenuPopup.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0019H×\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;", "Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getX-D9Ej5fM", "()F", "F", "getY-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-YgX7TsA", "(FF)Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "design-system-compose_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Fixed implements TraeContextMenuPosition {
        public static final int $stable = 0;
        private final float x;
        private final float y;

        public /* synthetic */ Fixed(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2);
        }

        /* renamed from: copy-YgX7TsA$default, reason: not valid java name */
        public static /* synthetic */ Fixed m8503copyYgX7TsA$default(Fixed fixed, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = fixed.x;
            }
            if ((i & 2) != 0) {
                f2 = fixed.y;
            }
            return fixed.m8506copyYgX7TsA(f, f2);
        }

        /* renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
        public final float getY() {
            return this.y;
        }

        /* renamed from: copy-YgX7TsA, reason: not valid java name */
        public final Fixed m8506copyYgX7TsA(float x, float y) {
            return new Fixed(x, y, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Fixed)) {
                return false;
            }
            Fixed fixed = (Fixed) other;
            return Dp.m7068equalsimpl0(this.x, fixed.x) && Dp.m7068equalsimpl0(this.y, fixed.y);
        }

        public int hashCode() {
            return (Dp.m7069hashCodeimpl(this.x) * 31) + Dp.m7069hashCodeimpl(this.y);
        }

        public String toString() {
            return "Fixed(x=" + ((Object) Dp.m7074toStringimpl(this.x)) + ", y=" + ((Object) Dp.m7074toStringimpl(this.y)) + ')';
        }

        private Fixed(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        /* renamed from: getX-D9Ej5fM, reason: not valid java name */
        public final float m8507getXD9Ej5fM() {
            return this.x;
        }

        /* renamed from: getY-D9Ej5fM, reason: not valid java name */
        public final float m8508getYD9Ej5fM() {
            return this.y;
        }
    }

    /* compiled from: TraeContextMenuPopup.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H×\u0003J\t\u0010\u0011\u001a\u00020\u0012H×\u0001J\t\u0010\u0013\u001a\u00020\u0014H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Anchored;", "Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;", "anchorX", "", "anchorY", "<init>", "(FF)V", "getAnchorX", "()F", "getAnchorY", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "design-system-compose_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Anchored implements TraeContextMenuPosition {
        public static final int $stable = 0;
        private final float anchorX;
        private final float anchorY;

        public static /* synthetic */ Anchored copy$default(Anchored anchored, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = anchored.anchorX;
            }
            if ((i & 2) != 0) {
                f2 = anchored.anchorY;
            }
            return anchored.copy(f, f2);
        }

        /* renamed from: component1, reason: from getter */
        public final float getAnchorX() {
            return this.anchorX;
        }

        /* renamed from: component2, reason: from getter */
        public final float getAnchorY() {
            return this.anchorY;
        }

        public final Anchored copy(float anchorX, float anchorY) {
            return new Anchored(anchorX, anchorY);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Anchored)) {
                return false;
            }
            Anchored anchored = (Anchored) other;
            return Float.compare(this.anchorX, anchored.anchorX) == 0 && Float.compare(this.anchorY, anchored.anchorY) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.anchorX) * 31) + Float.hashCode(this.anchorY);
        }

        public String toString() {
            return "Anchored(anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ')';
        }

        public Anchored(float f, float f2) {
            this.anchorX = f;
            this.anchorY = f2;
        }

        public final float getAnchorX() {
            return this.anchorX;
        }

        public final float getAnchorY() {
            return this.anchorY;
        }
    }
}
