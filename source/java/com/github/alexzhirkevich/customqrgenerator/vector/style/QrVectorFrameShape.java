package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import android.graphics.RectF;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrixKt;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrEncoderKt;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: QrVectorFrameShape.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "AsDarkPixels", "AsPixelShape", "Circle", "Default", "RoundCorners", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorFrameShape extends QrVectorShapeModifier {

    /* compiled from: QrVectorFrameShape.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Default implements QrVectorFrameShape {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            Path path = new Path();
            float f = size / 7.0f;
            path.addRect(0.0f, 0.0f, size, f, Path.Direction.CW);
            path.addRect(0.0f, 0.0f, f, size, Path.Direction.CW);
            float f2 = size - f;
            path.addRect(f2, 0.0f, size, size, Path.Direction.CW);
            path.addRect(0.0f, f2, size, size, Path.Direction.CW);
            return path;
        }
    }

    /* compiled from: QrVectorFrameShape.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape$AsDarkPixels;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class AsDarkPixels implements QrVectorFrameShape {
        public static final AsDarkPixels INSTANCE = new AsDarkPixels();

        private AsDarkPixels() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return new Path();
        }
    }

    /* compiled from: QrVectorFrameShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape$AsPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "pixelShape", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;)V", "getPixelShape", "()Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "component1", "copy", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class AsPixelShape implements QrVectorFrameShape {
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
            QrCodeMatrix qrMatrix = QrEncoderKt.toQrMatrix(new ByteMatrix(7, 7));
            int i = 0;
            while (i < 7) {
                int i2 = 0;
                while (i2 < 7) {
                    qrMatrix.set(i, i2, (i == 0 || i2 == 0 || i == 6 || i2 == 6) ? QrCodeMatrix.PixelType.DarkPixel : QrCodeMatrix.PixelType.Background);
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < 7; i3++) {
                for (int i4 = 0; i4 < 7; i4++) {
                    if (qrMatrix.get(i3, i4) == QrCodeMatrix.PixelType.DarkPixel) {
                        float f = size / 7;
                        path.addPath(this.pixelShape.createPath(f, QrCodeMatrixKt.neighbors(qrMatrix, i3, i4)), i3 * f, f * i4);
                    }
                }
            }
            return path;
        }
    }

    /* compiled from: QrVectorFrameShape.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape$Circle;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", AnimationConstant.PROP_STR_WIDTH, "", "radius", "(FF)V", "getRadius", "()F", "getWidth", "component1", "component2", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Circle implements QrVectorFrameShape {
        private final float radius;
        private final float width;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Circle() {
            this(r2, r2, 3, null);
            float f = 0.0f;
        }

        public static /* synthetic */ Circle copy$default(Circle circle, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = circle.width;
            }
            if ((i & 2) != 0) {
                f2 = circle.radius;
            }
            return circle.copy(f, f2);
        }

        /* renamed from: component1, reason: from getter */
        public final float getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        public final Circle copy(float width, float radius) {
            return new Circle(width, radius);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Circle)) {
                return false;
            }
            Circle circle = (Circle) other;
            return Intrinsics.areEqual(Float.valueOf(this.width), Float.valueOf(circle.width)) && Intrinsics.areEqual(Float.valueOf(this.radius), Float.valueOf(circle.radius));
        }

        public int hashCode() {
            return (Float.hashCode(this.width) * 31) + Float.hashCode(this.radius);
        }

        public String toString() {
            return "Circle(width=" + this.width + ", radius=" + this.radius + ')';
        }

        public Circle(float f, float f2) {
            this.width = f;
            this.radius = f2;
        }

        public /* synthetic */ Circle(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1.0f : f2);
        }

        public final float getWidth() {
            return this.width;
        }

        public final float getRadius() {
            return this.radius;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            Path path = new Path();
            float f = (size / 7.0f) * this.width;
            float coerceAtLeast = RangesKt.coerceAtLeast(this.radius, 0.0f);
            float f2 = size / 2.0f;
            path.addCircle(f2, f2, f2 * coerceAtLeast, Path.Direction.CW);
            path.addCircle(f2, f2, (f2 - f) * coerceAtLeast, Path.Direction.CCW);
            return path;
        }
    }

    /* compiled from: QrVectorFrameShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006&"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape$RoundCorners;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;", "corner", "", AnimationConstant.PROP_STR_WIDTH, "topLeft", "", "bottomLeft", "topRight", "bottomRight", "(FFZZZZ)V", "getBottomLeft", "()Z", "getBottomRight", "getCorner", "()F", "getTopLeft", "getTopRight", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCorners implements QrVectorFrameShape {
        private final boolean bottomLeft;
        private final boolean bottomRight;
        private final float corner;
        private final boolean topLeft;
        private final boolean topRight;
        private final float width;

        public static /* synthetic */ RoundCorners copy$default(RoundCorners roundCorners, float f, float f2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = roundCorners.corner;
            }
            if ((i & 2) != 0) {
                f2 = roundCorners.width;
            }
            float f3 = f2;
            if ((i & 4) != 0) {
                z = roundCorners.topLeft;
            }
            boolean z5 = z;
            if ((i & 8) != 0) {
                z2 = roundCorners.bottomLeft;
            }
            boolean z6 = z2;
            if ((i & 16) != 0) {
                z3 = roundCorners.topRight;
            }
            boolean z7 = z3;
            if ((i & 32) != 0) {
                z4 = roundCorners.bottomRight;
            }
            return roundCorners.copy(f, f3, z5, z6, z7, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final float getCorner() {
            return this.corner;
        }

        /* renamed from: component2, reason: from getter */
        public final float getWidth() {
            return this.width;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getTopLeft() {
            return this.topLeft;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getBottomLeft() {
            return this.bottomLeft;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getTopRight() {
            return this.topRight;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getBottomRight() {
            return this.bottomRight;
        }

        public final RoundCorners copy(float corner, float width, boolean topLeft, boolean bottomLeft, boolean topRight, boolean bottomRight) {
            return new RoundCorners(corner, width, topLeft, bottomLeft, topRight, bottomRight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoundCorners)) {
                return false;
            }
            RoundCorners roundCorners = (RoundCorners) other;
            return Intrinsics.areEqual(Float.valueOf(this.corner), Float.valueOf(roundCorners.corner)) && Intrinsics.areEqual(Float.valueOf(this.width), Float.valueOf(roundCorners.width)) && this.topLeft == roundCorners.topLeft && this.bottomLeft == roundCorners.bottomLeft && this.topRight == roundCorners.topRight && this.bottomRight == roundCorners.bottomRight;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((Float.hashCode(this.corner) * 31) + Float.hashCode(this.width)) * 31;
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
            return "RoundCorners(corner=" + this.corner + ", width=" + this.width + ", topLeft=" + this.topLeft + ", bottomLeft=" + this.bottomLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ')';
        }

        public RoundCorners(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
            this.corner = f;
            this.width = f2;
            this.topLeft = z;
            this.bottomLeft = z2;
            this.topRight = z3;
            this.bottomRight = z4;
        }

        public /* synthetic */ RoundCorners(float f, float f2, boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, (i & 2) != 0 ? 1.0f : f2, (i & 4) != 0 ? true : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? true : z3, (i & 32) != 0 ? true : z4);
        }

        public final float getCorner() {
            return this.corner;
        }

        public final float getWidth() {
            return this.width;
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

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            float coerceAtLeast = (size / 7.0f) * RangesKt.coerceAtLeast(this.width, 0.0f);
            float f = this.corner;
            float f2 = f * size;
            float f3 = f * (size - (4 * coerceAtLeast));
            Path path = new Path();
            RectF rectF = new RectF(0.0f, 0.0f, size, size);
            float[] fArr = new float[8];
            boolean z = this.topLeft;
            fArr[0] = z ? f2 : 0.0f;
            fArr[1] = z ? f2 : 0.0f;
            boolean z2 = this.topRight;
            fArr[2] = z2 ? f2 : 0.0f;
            fArr[3] = z2 ? f2 : 0.0f;
            boolean z3 = this.bottomRight;
            fArr[4] = z3 ? f2 : 0.0f;
            fArr[5] = z3 ? f2 : 0.0f;
            boolean z4 = this.bottomLeft;
            fArr[6] = z4 ? f2 : 0.0f;
            if (!z4) {
                f2 = 0.0f;
            }
            fArr[7] = f2;
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            Path path2 = new Path();
            float f4 = size - coerceAtLeast;
            RectF rectF2 = new RectF(coerceAtLeast, coerceAtLeast, f4, f4);
            float[] fArr2 = new float[8];
            boolean z5 = this.topLeft;
            fArr2[0] = z5 ? f3 : 0.0f;
            fArr2[1] = z5 ? f3 : 0.0f;
            boolean z6 = this.topRight;
            fArr2[2] = z6 ? f3 : 0.0f;
            fArr2[3] = z6 ? f3 : 0.0f;
            boolean z7 = this.bottomRight;
            fArr2[4] = z7 ? f3 : 0.0f;
            fArr2[5] = z7 ? f3 : 0.0f;
            boolean z8 = this.bottomLeft;
            fArr2[6] = z8 ? f3 : 0.0f;
            fArr2[7] = z8 ? f3 : 0.0f;
            path2.addRoundRect(rectF2, fArr2, Path.Direction.CCW);
            Path path3 = new Path(path);
            path3.op(path2, Path.Op.DIFFERENCE);
            return path3;
        }
    }
}
