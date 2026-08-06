package com.github.alexzhirkevich.customqrgenerator.style;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrBallShape.kt */
@Deprecated(message = "Use QrCodeDrawable with QrVectorBallShape instead")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bç\u0080\u0001\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "AsDarkPixels", "AsPixelShape", "Circle", "Default", "Rhombus", "RoundCorners", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrBallShape extends QrShapeModifier {

    /* compiled from: QrBallShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorBallShape instead")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0096\u0003¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "()V", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Default implements QrBallShape {
        public static final Default INSTANCE = new Default();
        private final /* synthetic */ QrBallShape $$delegate_0 = QrBallShapeKt.asBallShape(DefaultShapeModifier.INSTANCE);

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        private Default() {
        }
    }

    /* compiled from: QrBallShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorBallShape instead")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0096\u0002¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape$AsDarkPixels;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "()V", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class AsDarkPixels implements QrBallShape {
        public static final AsDarkPixels INSTANCE = new AsDarkPixels();

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return false;
        }

        private AsDarkPixels() {
        }
    }

    /* compiled from: QrBallShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorBallShape instead")
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J)\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape$AsPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "shape", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;)V", "getShape", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrPixelShape;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "invoke", "i", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class AsPixelShape implements QrBallShape {
        private final /* synthetic */ QrBallShape $$delegate_0;
        private final QrPixelShape shape;

        public static /* synthetic */ AsPixelShape copy$default(AsPixelShape asPixelShape, QrPixelShape qrPixelShape, int i, Object obj) {
            if ((i & 1) != 0) {
                qrPixelShape = asPixelShape.shape;
            }
            return asPixelShape.copy(qrPixelShape);
        }

        /* renamed from: component1, reason: from getter */
        public final QrPixelShape getShape() {
            return this.shape;
        }

        public final AsPixelShape copy(QrPixelShape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            return new AsPixelShape(shape);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AsPixelShape) && Intrinsics.areEqual(this.shape, ((AsPixelShape) other).shape);
        }

        public int hashCode() {
            return this.shape.hashCode();
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        public String toString() {
            return "AsPixelShape(shape=" + this.shape + ')';
        }

        public AsPixelShape(QrPixelShape qrPixelShape) {
            Intrinsics.checkNotNullParameter(qrPixelShape, "shape");
            this.shape = qrPixelShape;
            this.$$delegate_0 = QrBallShapeKt.asBallShape(QrShapeModifierExKt.and(Default.INSTANCE, QrShapeModifierExKt.rem(qrPixelShape, new Function2<Integer, Neighbors, Integer>() { // from class: com.github.alexzhirkevich.customqrgenerator.style.QrBallShape.AsPixelShape.1
                public final Integer invoke(int i, Neighbors neighbors) {
                    Intrinsics.checkNotNullParameter(neighbors, "<anonymous parameter 1>");
                    return Integer.valueOf(i / 3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke(((Number) obj).intValue(), (Neighbors) obj2);
                }
            })));
        }

        public final QrPixelShape getShape() {
            return this.shape;
        }
    }

    /* compiled from: QrBallShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorBallShape instead")
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J)\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape$Circle;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "size", "", "(F)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "invoke", "i", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Circle implements QrBallShape {
        private final /* synthetic */ QrBallShape $$delegate_0;
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
            this.$$delegate_0 = QrBallShapeKt.asBallShape(new CircleShapeModifier(f));
        }

        public /* synthetic */ Circle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f);
        }
    }

    /* compiled from: QrBallShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorBallShape instead")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0096\u0003¨\u0006\u000b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape$Rhombus;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "()V", "invoke", "", "i", "", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Rhombus implements QrBallShape {
        public static final Rhombus INSTANCE = new Rhombus();
        private final /* synthetic */ QrBallShape $$delegate_0 = QrBallShapeKt.asBallShape(RhombusShapeModifier.INSTANCE);

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        private Rhombus() {
        }
    }

    /* compiled from: QrBallShape.kt */
    @Deprecated(message = "Use QrCodeDrawable with QrVectorBallShape instead")
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J)\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0096\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006$"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape$RoundCorners;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrBallShape;", "corner", "", "outer", "", "horizontalOuter", "verticalOuter", "inner", "(FZZZZ)V", "getCorner", "()F", "getHorizontalOuter", "()Z", "getInner", "getOuter", "getVerticalOuter", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "invoke", "i", "j", "elementSize", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCorners implements QrBallShape {
        private final /* synthetic */ QrBallShape $$delegate_0;
        private final float corner;
        private final boolean horizontalOuter;
        private final boolean inner;
        private final boolean outer;
        private final boolean verticalOuter;

        public static /* synthetic */ RoundCorners copy$default(RoundCorners roundCorners, float f, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = roundCorners.corner;
            }
            if ((i & 2) != 0) {
                z = roundCorners.outer;
            }
            boolean z5 = z;
            if ((i & 4) != 0) {
                z2 = roundCorners.horizontalOuter;
            }
            boolean z6 = z2;
            if ((i & 8) != 0) {
                z3 = roundCorners.verticalOuter;
            }
            boolean z7 = z3;
            if ((i & 16) != 0) {
                z4 = roundCorners.inner;
            }
            return roundCorners.copy(f, z5, z6, z7, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final float getCorner() {
            return this.corner;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getOuter() {
            return this.outer;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getHorizontalOuter() {
            return this.horizontalOuter;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getVerticalOuter() {
            return this.verticalOuter;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getInner() {
            return this.inner;
        }

        public final RoundCorners copy(float corner, boolean outer, boolean horizontalOuter, boolean verticalOuter, boolean inner) {
            return new RoundCorners(corner, outer, horizontalOuter, verticalOuter, inner);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoundCorners)) {
                return false;
            }
            RoundCorners roundCorners = (RoundCorners) other;
            return Intrinsics.areEqual(Float.valueOf(this.corner), Float.valueOf(roundCorners.corner)) && this.outer == roundCorners.outer && this.horizontalOuter == roundCorners.horizontalOuter && this.verticalOuter == roundCorners.verticalOuter && this.inner == roundCorners.inner;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Float.hashCode(this.corner) * 31;
            boolean z = this.outer;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.horizontalOuter;
            int i3 = z2;
            if (z2 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z3 = this.verticalOuter;
            int i5 = z3;
            if (z3 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z4 = this.inner;
            return i6 + (z4 ? 1 : z4 ? 1 : 0);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier
        public boolean invoke(int i, int j, int elementSize, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.invoke(i, j, elementSize, neighbors);
        }

        public String toString() {
            return "RoundCorners(corner=" + this.corner + ", outer=" + this.outer + ", horizontalOuter=" + this.horizontalOuter + ", verticalOuter=" + this.verticalOuter + ", inner=" + this.inner + ')';
        }

        public RoundCorners(float f, boolean z, boolean z2, boolean z3, boolean z4) {
            this.corner = f;
            this.outer = z;
            this.horizontalOuter = z2;
            this.verticalOuter = z3;
            this.inner = z4;
            this.$$delegate_0 = QrBallShapeKt.asBallShape(new RoundCornersShapeModifier(f, false, z, z2, z3, z4));
        }

        public /* synthetic */ RoundCorners(float f, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4);
        }

        public final float getCorner() {
            return this.corner;
        }

        public final boolean getOuter() {
            return this.outer;
        }

        public final boolean getHorizontalOuter() {
            return this.horizontalOuter;
        }

        public final boolean getVerticalOuter() {
            return this.verticalOuter;
        }

        public final boolean getInner() {
            return this.inner;
        }
    }
}
