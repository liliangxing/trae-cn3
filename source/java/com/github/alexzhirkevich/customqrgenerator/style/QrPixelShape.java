package com.github.alexzhirkevich.customqrgenerator.style;

import com.github.alexzhirkevich.customqrgenerator.style.RoundCornersShapeModifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: QrPixelShape.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorPixelShape instead")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bç\u0080\u0001\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "Circle", "Default", "Rhombus", "RoundCorners", "RoundCornersHorizontal", "RoundCornersVertical", "Star", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrPixelShape extends QrShapeModifier {

    /* compiled from: QrPixelShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorPixelShape instead")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0096\u0003¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "()V", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Default implements QrPixelShape {
        public static final Default INSTANCE = new Default();
        private final /* synthetic */ QrPixelShape $$delegate_0 = QrPixelShapeKt.asPixelShape(DefaultShapeModifier.INSTANCE);

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        private Default() {
        }
    }

    /* compiled from: QrPixelShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorPixelShape instead")
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J)\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape$Circle;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "size", "", "(F)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "invoke", "i", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Circle implements QrPixelShape {
        private final /* synthetic */ QrPixelShape $$delegate_0;
        private final float size;

        public Circle() {
            this(0.0f, 1, null);
        }

        /* renamed from: component1, reason: from getter */
        private final float getSize() {
            return this.size;
        }

        public static /* synthetic */ Circle copy$default(Circle circle, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = circle.size;
            }
            return circle.copy(f);
        }

        public final Circle copy(float size) {
            return new Circle(size);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Circle) && Intrinsics.areEqual(Float.valueOf(this.size), Float.valueOf(((Circle) other).size));
        }

        public int hashCode() {
            return Float.hashCode(this.size);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        public String toString() {
            return "Circle(size=" + this.size + ')';
        }

        public Circle(float f) {
            this.size = f;
            this.$$delegate_0 = QrPixelShapeKt.asPixelShape(new CircleShapeModifier(f));
        }

        public /* synthetic */ Circle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f);
        }
    }

    /* compiled from: QrPixelShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorPixelShape instead")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0096\u0003¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape$Rhombus;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "()V", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Rhombus implements QrPixelShape {
        public static final Rhombus INSTANCE = new Rhombus();
        private final /* synthetic */ QrPixelShape $$delegate_0 = QrPixelShapeKt.asPixelShape(RhombusShapeModifier.INSTANCE);

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        private Rhombus() {
        }
    }

    /* compiled from: QrPixelShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorPixelShape instead")
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J)\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0096\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006$"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape$RoundCorners;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "corner", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FZZZZ)V", "getBottomLeft", "()Z", "getBottomRight", "getCorner", "()F", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "invoke", "i", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCorners implements QrPixelShape {
        private final /* synthetic */ QrPixelShape $$delegate_0;
        private final boolean bottomLeft;
        private final boolean bottomRight;
        private final float corner;
        private final boolean topLeft;
        private final boolean topRight;

        public RoundCorners() {
            this(0.0f, false, false, false, false, 31, null);
        }

        public static /* synthetic */ RoundCorners copy$default(RoundCorners roundCorners, float f, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = roundCorners.corner;
            }
            if ((i & 2) != 0) {
                z = roundCorners.topLeft;
            }
            boolean z5 = z;
            if ((i & 4) != 0) {
                z2 = roundCorners.topRight;
            }
            boolean z6 = z2;
            if ((i & 8) != 0) {
                z3 = roundCorners.bottomLeft;
            }
            boolean z7 = z3;
            if ((i & 16) != 0) {
                z4 = roundCorners.bottomRight;
            }
            return roundCorners.copy(f, z5, z6, z7, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final float getCorner() {
            return this.corner;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getTopLeft() {
            return this.topLeft;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getTopRight() {
            return this.topRight;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getBottomLeft() {
            return this.bottomLeft;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getBottomRight() {
            return this.bottomRight;
        }

        public final RoundCorners copy(float corner, boolean topLeft, boolean topRight, boolean bottomLeft, boolean bottomRight) {
            return new RoundCorners(corner, topLeft, topRight, bottomLeft, bottomRight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoundCorners)) {
                return false;
            }
            RoundCorners roundCorners = (RoundCorners) other;
            return Intrinsics.areEqual(Float.valueOf(this.corner), Float.valueOf(roundCorners.corner)) && this.topLeft == roundCorners.topLeft && this.topRight == roundCorners.topRight && this.bottomLeft == roundCorners.bottomLeft && this.bottomRight == roundCorners.bottomRight;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Float.hashCode(this.corner) * 31;
            boolean z = this.topLeft;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.topRight;
            int i3 = z2;
            if (z2 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z3 = this.bottomLeft;
            int i5 = z3;
            if (z3 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z4 = this.bottomRight;
            return i6 + (z4 ? 1 : z4 ? 1 : 0);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        public String toString() {
            return "RoundCorners(corner=" + this.corner + ", topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ')';
        }

        public RoundCorners(float f, boolean z, boolean z2, boolean z3, boolean z4) {
            this.corner = f;
            this.topLeft = z;
            this.topRight = z2;
            this.bottomLeft = z3;
            this.bottomRight = z4;
            this.$$delegate_0 = QrPixelShapeKt.asPixelShape(new RoundCornersShapeModifier(f, true, z, z2, z3, z4));
        }

        public /* synthetic */ RoundCorners(float f, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.5f : f, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? true : z3, (i & 16) == 0 ? z4 : true);
        }

        public final float getCorner() {
            return this.corner;
        }

        public final boolean getTopLeft() {
            return this.topLeft;
        }

        public final boolean getTopRight() {
            return this.topRight;
        }

        public final boolean getBottomLeft() {
            return this.bottomLeft;
        }

        public final boolean getBottomRight() {
            return this.bottomRight;
        }
    }

    /* compiled from: QrPixelShape.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape$RoundCornersHorizontal;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "sidePadding", "", "(F)V", "getSidePadding", "()F", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Deprecated(message = "Use QrCodeDrawable with QrVectorPixelShape instead")
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class RoundCornersHorizontal implements QrPixelShape {
        private final float sidePadding;

        public RoundCornersHorizontal() {
            this(0.0f, 1, null);
        }

        public RoundCornersHorizontal(float f) {
            this.sidePadding = f;
        }

        public /* synthetic */ RoundCornersHorizontal(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f);
        }

        public final float getSidePadding() {
            return this.sidePadding;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            int roundToInt = MathKt.roundToInt(elementSize * this.sidePadding);
            if (!(roundToInt <= j && j < elementSize - roundToInt)) {
                return false;
            }
            RoundCornersShapeModifier.Companion companion = RoundCornersShapeModifier.INSTANCE;
            int i2 = j - roundToInt;
            int i3 = elementSize - (roundToInt * 2);
            if (i3 % 2 != 1) {
                i3--;
            }
            return companion.isRoundDark(i, i2, i3, neighbors, 0.5f, true, neighbors.getTop() ^ true, neighbors.getTop() ^ true, neighbors.getBottom() ^ true, neighbors.getBottom() ^ true);
        }
    }

    /* compiled from: QrPixelShape.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J)\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape$RoundCornersVertical;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "sidePadding", "", "(F)V", "getSidePadding", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "invoke", "i", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Deprecated(message = "Use QrCodeDrawable with QrVectorPixelShape instead")
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCornersVertical implements QrPixelShape {
        private final float sidePadding;

        public RoundCornersVertical() {
            this(0.0f, 1, null);
        }

        public static /* synthetic */ RoundCornersVertical copy$default(RoundCornersVertical roundCornersVertical, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = roundCornersVertical.sidePadding;
            }
            return roundCornersVertical.copy(f);
        }

        /* renamed from: component1, reason: from getter */
        public final float getSidePadding() {
            return this.sidePadding;
        }

        public final RoundCornersVertical copy(float sidePadding) {
            return new RoundCornersVertical(sidePadding);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RoundCornersVertical) && Intrinsics.areEqual(Float.valueOf(this.sidePadding), Float.valueOf(((RoundCornersVertical) other).sidePadding));
        }

        public int hashCode() {
            return Float.hashCode(this.sidePadding);
        }

        public String toString() {
            return "RoundCornersVertical(sidePadding=" + this.sidePadding + ')';
        }

        public RoundCornersVertical(float f) {
            this.sidePadding = f;
        }

        public /* synthetic */ RoundCornersVertical(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f);
        }

        public final float getSidePadding() {
            return this.sidePadding;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            int roundToInt = MathKt.roundToInt(elementSize * this.sidePadding);
            if (!(roundToInt <= i && i < elementSize - roundToInt)) {
                return false;
            }
            RoundCornersShapeModifier.Companion companion = RoundCornersShapeModifier.INSTANCE;
            int i2 = i - roundToInt;
            int i3 = elementSize - (roundToInt * 2);
            if (i3 % 2 != 1) {
                i3--;
            }
            return companion.isRoundDark(i2, j, i3, neighbors, 0.5f, true, neighbors.getLeft() ^ true, neighbors.getRight() ^ true, neighbors.getLeft() ^ true, neighbors.getRight() ^ true);
        }
    }

    /* compiled from: QrPixelShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorPixelShape instead")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0096\u0003¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape$Star;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "()V", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Star implements QrPixelShape {
        public static final Star INSTANCE = new Star();
        private final /* synthetic */ StarShapeModifier $$delegate_0 = StarShapeModifier.INSTANCE;

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        private Star() {
        }
    }
}
