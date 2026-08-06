package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrixKt;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoderKt;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorBallShape.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "AsDarkPixels", "AsPixelShape", "Circle", "Default", "Rhombus", "RoundCorners", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorBallShape extends QrVectorShapeModifier {

    /* compiled from: QrVectorBallShape.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Default implements QrVectorBallShape, QrVectorShapeModifier {
        public static final Default INSTANCE = new Default();
        private final /* synthetic */ DefaultVectorShape $$delegate_0 = DefaultVectorShape.INSTANCE;

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.createPath(size, neighbors);
        }

        private Default() {
        }
    }

    /* compiled from: QrVectorBallShape.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape$AsDarkPixels;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class AsDarkPixels implements QrVectorBallShape {
        public static final AsDarkPixels INSTANCE = new AsDarkPixels();

        private AsDarkPixels() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return new Path();
        }
    }

    /* compiled from: QrVectorBallShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape$AsPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "pixelShape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;)V", "getPixelShape", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "component1", "copy", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class AsPixelShape implements QrVectorBallShape {
        private final QrVectorPixelShape pixelShape;

        public static /* synthetic */ AsPixelShape copy$default(AsPixelShape asPixelShape, QrVectorPixelShape qrVectorPixelShape, int i, Object obj) {
            if ((i & 1) != 0) {
                qrVectorPixelShape = asPixelShape.pixelShape;
            }
            return asPixelShape.copy(qrVectorPixelShape);
        }

        /* renamed from: component1, reason: from getter */
        public final QrVectorPixelShape getPixelShape() {
            return this.pixelShape;
        }

        public final AsPixelShape copy(QrVectorPixelShape pixelShape) {
            Intrinsics.checkNotNullParameter(pixelShape, "pixelShape");
            return new AsPixelShape(pixelShape);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AsPixelShape) && Intrinsics.areEqual(this.pixelShape, ((AsPixelShape) other).pixelShape);
        }

        public int hashCode() {
            return this.pixelShape.hashCode();
        }

        public String toString() {
            return "AsPixelShape(pixelShape=" + this.pixelShape + ')';
        }

        public AsPixelShape(QrVectorPixelShape qrVectorPixelShape) {
            Intrinsics.checkNotNullParameter(qrVectorPixelShape, "pixelShape");
            this.pixelShape = qrVectorPixelShape;
        }

        public final QrVectorPixelShape getPixelShape() {
            return this.pixelShape;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            Path path = new Path();
            ByteMatrix byteMatrix = new ByteMatrix(3, 3);
            byteMatrix.clear((byte) 1);
            QrCodeMatrix qrMatrix = QrEncoderKt.toQrMatrix(byteMatrix);
            for (int i = 0; i < 3; i++) {
                for (int i2 = 0; i2 < 3; i2++) {
                    float f = size / 3;
                    path.addPath(this.pixelShape.createPath(f, QrCodeMatrixKt.neighbors(qrMatrix, i, i2)), i * f, f * i2);
                }
            }
            return path;
        }
    }

    /* compiled from: QrVectorBallShape.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape$Circle;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "size", "", "(F)V", "getSize", "()F", "component1", "copy", "createPath", "Landroid/graphics/Path;", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Circle implements QrVectorBallShape, QrVectorShapeModifier {
        private final /* synthetic */ CircleVectorShape $$delegate_0;
        private final float size;

        public static /* synthetic */ Circle copy$default(Circle circle, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = circle.size;
            }
            return circle.copy(f);
        }

        /* renamed from: component1, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        public final Circle copy(float size) {
            return new Circle(size);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.createPath(size, neighbors);
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

        public String toString() {
            return "Circle(size=" + this.size + ')';
        }

        public Circle(float f) {
            this.size = f;
            this.$$delegate_0 = new CircleVectorShape(f);
        }

        public final float getSize() {
            return this.size;
        }
    }

    /* compiled from: QrVectorBallShape.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006$"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape$RoundCorners;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "radius", "", "topLeft", "", "bottomLeft", "topRight", "bottomRight", "(FZZZZ)V", "getBottomLeft", "()Z", "getBottomRight", "getRadius", "()F", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "component5", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCorners implements QrVectorBallShape, QrVectorShapeModifier {
        private final /* synthetic */ RoundCornersVectorShape $$delegate_0;
        private final boolean bottomLeft;
        private final boolean bottomRight;
        private final float radius;
        private final boolean topLeft;
        private final boolean topRight;

        public static /* synthetic */ RoundCorners copy$default(RoundCorners roundCorners, float f, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = roundCorners.radius;
            }
            if ((i & 2) != 0) {
                z = roundCorners.topLeft;
            }
            boolean z5 = z;
            if ((i & 4) != 0) {
                z2 = roundCorners.bottomLeft;
            }
            boolean z6 = z2;
            if ((i & 8) != 0) {
                z3 = roundCorners.topRight;
            }
            boolean z7 = z3;
            if ((i & 16) != 0) {
                z4 = roundCorners.bottomRight;
            }
            return roundCorners.copy(f, z5, z6, z7, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getTopLeft() {
            return this.topLeft;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getBottomLeft() {
            return this.bottomLeft;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getTopRight() {
            return this.topRight;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getBottomRight() {
            return this.bottomRight;
        }

        public final RoundCorners copy(float radius, boolean topLeft, boolean bottomLeft, boolean topRight, boolean bottomRight) {
            return new RoundCorners(radius, topLeft, bottomLeft, topRight, bottomRight);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.createPath(size, neighbors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoundCorners)) {
                return false;
            }
            RoundCorners roundCorners = (RoundCorners) other;
            return Intrinsics.areEqual(Float.valueOf(this.radius), Float.valueOf(roundCorners.radius)) && this.topLeft == roundCorners.topLeft && this.bottomLeft == roundCorners.bottomLeft && this.topRight == roundCorners.topRight && this.bottomRight == roundCorners.bottomRight;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Float.hashCode(this.radius) * 31;
            boolean z = this.topLeft;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.bottomLeft;
            int i3 = z2;
            if (z2 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z3 = this.topRight;
            int i5 = z3;
            if (z3 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z4 = this.bottomRight;
            return i6 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public String toString() {
            return "RoundCorners(radius=" + this.radius + ", topLeft=" + this.topLeft + ", bottomLeft=" + this.bottomLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ')';
        }

        public RoundCorners(float f, boolean z, boolean z2, boolean z3, boolean z4) {
            this.radius = f;
            this.topLeft = z;
            this.bottomLeft = z2;
            this.topRight = z3;
            this.bottomRight = z4;
            this.$$delegate_0 = new RoundCornersVectorShape(f, false, z, z2, z3, z4);
        }

        public /* synthetic */ RoundCorners(float f, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4);
        }

        public final float getRadius() {
            return this.radius;
        }

        public final boolean getTopLeft() {
            return this.topLeft;
        }

        public final boolean getBottomLeft() {
            return this.bottomLeft;
        }

        public final boolean getTopRight() {
            return this.topRight;
        }

        public final boolean getBottomRight() {
            return this.bottomRight;
        }
    }

    /* compiled from: QrVectorBallShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape$Rhombus;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "scale", "", "(F)V", "component1", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Rhombus implements QrVectorBallShape, QrVectorShapeModifier {
        private final /* synthetic */ RhombusVectorShape $$delegate_0;
        private final float scale;

        public Rhombus() {
            this(0.0f, 1, null);
        }

        /* renamed from: component1, reason: from getter */
        private final float getScale() {
            return this.scale;
        }

        public static /* synthetic */ Rhombus copy$default(Rhombus rhombus, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = rhombus.scale;
            }
            return rhombus.copy(f);
        }

        public final Rhombus copy(float scale) {
            return new Rhombus(scale);
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.createPath(size, neighbors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Rhombus) && Intrinsics.areEqual(Float.valueOf(this.scale), Float.valueOf(((Rhombus) other).scale));
        }

        public int hashCode() {
            return Float.hashCode(this.scale);
        }

        public String toString() {
            return "Rhombus(scale=" + this.scale + ')';
        }

        public Rhombus(float f) {
            this.scale = f;
            this.$$delegate_0 = new RhombusVectorShape(f);
        }

        public /* synthetic */ Rhombus(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f);
        }
    }
}
