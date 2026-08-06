package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorLogoShape.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "Circle", "Default", "Rhombus", "RoundCorners", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorLogoShape extends QrVectorShapeModifier {

    /* compiled from: QrVectorLogoShape.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Default implements QrVectorLogoShape, QrVectorShapeModifier {
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

    /* compiled from: QrVectorLogoShape.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape$Circle;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Circle implements QrVectorLogoShape, QrVectorShapeModifier {
        public static final Circle INSTANCE = new Circle();
        private final /* synthetic */ CircleVectorShape $$delegate_0 = new CircleVectorShape(1.0f);

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.createPath(size, neighbors);
        }

        private Circle() {
        }
    }

    /* compiled from: QrVectorLogoShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape$RoundCorners;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "radius", "", "(F)V", "getRadius", "()F", "component1", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCorners implements QrVectorLogoShape, QrVectorShapeModifier {
        private final /* synthetic */ RoundCornersVectorShape $$delegate_0;
        private final float radius;

        public static /* synthetic */ RoundCorners copy$default(RoundCorners roundCorners, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = roundCorners.radius;
            }
            return roundCorners.copy(f);
        }

        /* renamed from: component1, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        public final RoundCorners copy(float radius) {
            return new RoundCorners(radius);
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
            return (other instanceof RoundCorners) && Intrinsics.areEqual(Float.valueOf(this.radius), Float.valueOf(((RoundCorners) other).radius));
        }

        public int hashCode() {
            return Float.hashCode(this.radius);
        }

        public String toString() {
            return "RoundCorners(radius=" + this.radius + ')';
        }

        public RoundCorners(float f) {
            this.radius = f;
            this.$$delegate_0 = new RoundCornersVectorShape(f, false, false, false, false, false, 60, null);
        }

        public final float getRadius() {
            return this.radius;
        }
    }

    /* compiled from: QrVectorLogoShape.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape$Rhombus;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorLogoShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Rhombus implements QrVectorLogoShape, QrVectorShapeModifier {
        public static final Rhombus INSTANCE = new Rhombus();
        private final /* synthetic */ RhombusVectorShape $$delegate_0 = new RhombusVectorShape(1.0f);

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.createPath(size, neighbors);
        }

        private Rhombus() {
        }
    }
}
