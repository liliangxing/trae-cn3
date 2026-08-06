package com.github.alexzhirkevich.customqrgenerator.style;

import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.RangesKt;

/* compiled from: QrShape.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "", "shapeSizeIncrease", "", "getShapeSizeIncrease", "()F", "apply", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "matrix", "pixelInShape", "", "i", "", "j", "modifiedByteMatrix", "Circle", "Default", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrShape {
    QrCodeMatrix apply(QrCodeMatrix matrix);

    float getShapeSizeIncrease();

    boolean pixelInShape(int i, int j, QrCodeMatrix modifiedByteMatrix);

    /* compiled from: QrShape.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "()V", "shapeSizeIncrease", "", "getShapeSizeIncrease", "()F", "apply", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "matrix", "pixelInShape", "", "i", "", "j", "modifiedByteMatrix", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Default implements QrShape {
        public static final Default INSTANCE = new Default();
        private static final float shapeSizeIncrease = 1.0f;

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShape
        public QrCodeMatrix apply(QrCodeMatrix matrix) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            return matrix;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShape
        public boolean pixelInShape(int i, int j, QrCodeMatrix modifiedByteMatrix) {
            Intrinsics.checkNotNullParameter(modifiedByteMatrix, "modifiedByteMatrix");
            return true;
        }

        private Default() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShape
        public float getShapeSizeIncrease() {
            return shapeSizeIncrease;
        }
    }

    /* compiled from: QrShape.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006 "}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape$Circle;", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShape;", "Lcom/github/alexzhirkevich/customqrgenerator/style/RandomBased;", "padding", "", "seed", "", "(FJ)V", "getPadding", "()F", "getSeed", "()J", "shapeSizeIncrease", "getShapeSizeIncrease", "apply", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "matrix", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "pixelInShape", "i", "j", "modifiedByteMatrix", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Circle implements QrShape, RandomBased {
        private final float padding;
        private final long seed;
        private final float shapeSizeIncrease;

        public Circle() {
            this(0.0f, 0L, 3, null);
        }

        public static /* synthetic */ Circle copy$default(Circle circle, float f, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                f = circle.padding;
            }
            if ((i & 2) != 0) {
                j = circle.getSeed();
            }
            return circle.copy(f, j);
        }

        /* renamed from: component1, reason: from getter */
        public final float getPadding() {
            return this.padding;
        }

        public final long component2() {
            return getSeed();
        }

        public final Circle copy(float padding, long seed) {
            return new Circle(padding, seed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Circle)) {
                return false;
            }
            Circle circle = (Circle) other;
            return Intrinsics.areEqual(Float.valueOf(this.padding), Float.valueOf(circle.padding)) && getSeed() == circle.getSeed();
        }

        public int hashCode() {
            return (Float.hashCode(this.padding) * 31) + Long.hashCode(getSeed());
        }

        public String toString() {
            return "Circle(padding=" + this.padding + ", seed=" + getSeed() + ')';
        }

        public Circle(float f, long j) {
            this.padding = f;
            this.seed = j;
            this.shapeSizeIncrease = 1 + ((float) ((f * Math.sqrt(2.0d)) - 1));
        }

        public /* synthetic */ Circle(float f, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.1f : f, (i & 2) != 0 ? 233L : j);
        }

        public final float getPadding() {
            return this.padding;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.RandomBased
        public long getSeed() {
            return this.seed;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShape
        public boolean pixelInShape(int i, int j, QrCodeMatrix modifiedByteMatrix) {
            Intrinsics.checkNotNullParameter(modifiedByteMatrix, "modifiedByteMatrix");
            float size = modifiedByteMatrix.getSize() / 2.0f;
            double d = 2;
            return ((float) Math.sqrt((double) (((float) Math.pow((double) (size - ((float) i)), d)) + ((float) Math.pow((double) (size - ((float) j)), d))))) <= size;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShape
        public float getShapeSizeIncrease() {
            return this.shapeSizeIncrease;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.style.QrShape
        public QrCodeMatrix apply(QrCodeMatrix matrix) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            int roundToInt = MathKt.roundToInt((((matrix.getSize() * RangesKt.coerceIn(this.padding, 1.0f, 2.0f)) * Math.sqrt(2.0d)) - matrix.getSize()) / 2);
            int size = matrix.getSize() + (roundToInt * 2);
            QrCodeMatrix qrCodeMatrix = new QrCodeMatrix(size);
            float f = size / 2.0f;
            Random Random = RandomKt.Random(getSeed());
            for (int i = 0; i < size; i++) {
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = roundToInt - 1;
                    if (i <= i3 || i2 <= i3 || i >= matrix.getSize() + roundToInt || i2 >= matrix.getSize() + roundToInt) {
                        float f2 = f - i;
                        float f3 = f - i2;
                        if (((float) Math.sqrt((f2 * f2) + (f3 * f3))) <= f) {
                            qrCodeMatrix.set(i, i2, Random.nextBoolean() ? QrCodeMatrix.PixelType.DarkPixel : QrCodeMatrix.PixelType.LightPixel);
                        }
                    }
                }
            }
            int size2 = matrix.getSize();
            for (int i4 = 0; i4 < size2; i4++) {
                int size3 = matrix.getSize();
                for (int i5 = 0; i5 < size3; i5++) {
                    qrCodeMatrix.set(roundToInt + i4, roundToInt + i5, matrix.get(i4, i5));
                }
            }
            return qrCodeMatrix;
        }
    }
}
