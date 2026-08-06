package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrVectorPixelShape.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "Circle", "Default", "Rhombus", "RoundCorners", "RoundCornersHorizontal", "RoundCornersVertical", "Star", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrVectorPixelShape extends QrVectorShapeModifier {

    /* compiled from: QrVectorPixelShape.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape$Default;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Default implements QrVectorPixelShape, QrVectorShapeModifier {
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

    /* compiled from: QrVectorPixelShape.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape$Circle;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "size", "", "(F)V", "getSize", "()F", "component1", "copy", "createPath", "Landroid/graphics/Path;", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Circle implements QrVectorPixelShape, QrVectorShapeModifier {
        private final /* synthetic */ CircleVectorShape $$delegate_0;
        private final float size;

        public Circle() {
            this(0.0f, 1, null);
        }

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

        public /* synthetic */ Circle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f);
        }

        public final float getSize() {
            return this.size;
        }
    }

    /* compiled from: QrVectorPixelShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape$RoundCorners;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "radius", "", "(F)V", "getRadius", "()F", "component1", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCorners implements QrVectorPixelShape, QrVectorShapeModifier {
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
            this.$$delegate_0 = new RoundCornersVectorShape(f, true, false, false, false, false, 60, null);
        }

        public final float getRadius() {
            return this.radius;
        }
    }

    /* compiled from: QrVectorPixelShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape$Rhombus;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "scale", "", "(F)V", "component1", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Rhombus implements QrVectorPixelShape, QrVectorShapeModifier {
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

    /* compiled from: QrVectorPixelShape.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape$Star;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "()V", "createPath", "Landroid/graphics/Path;", "size", "", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Star implements QrVectorPixelShape, QrVectorShapeModifier {
        public static final Star INSTANCE = new Star();
        private final /* synthetic */ StarVectorShape $$delegate_0 = StarVectorShape.INSTANCE;

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.QrVectorShapeModifier
        public Path createPath(float size, Neighbors neighbors) {
            Intrinsics.checkNotNullParameter(neighbors, "neighbors");
            return this.$$delegate_0.createPath(size, neighbors);
        }

        private Star() {
        }
    }

    /* compiled from: QrVectorPixelShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape$RoundCornersVertical;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "radius", "", "(F)V", "component1", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCornersVertical implements QrVectorPixelShape, QrVectorShapeModifier {
        private final /* synthetic */ RoundCornersVerticalVectorShape $$delegate_0;
        private final float radius;

        public RoundCornersVertical() {
            this(0.0f, 1, null);
        }

        /* renamed from: component1, reason: from getter */
        private final float getRadius() {
            return this.radius;
        }

        public static /* synthetic */ RoundCornersVertical copy$default(RoundCornersVertical roundCornersVertical, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = roundCornersVertical.radius;
            }
            return roundCornersVertical.copy(f);
        }

        public final RoundCornersVertical copy(float radius) {
            return new RoundCornersVertical(radius);
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
            return (other instanceof RoundCornersVertical) && Intrinsics.areEqual(Float.valueOf(this.radius), Float.valueOf(((RoundCornersVertical) other).radius));
        }

        public int hashCode() {
            return Float.hashCode(this.radius);
        }

        public String toString() {
            return "RoundCornersVertical(radius=" + this.radius + ')';
        }

        public RoundCornersVertical(float f) {
            this.radius = f;
            this.$$delegate_0 = new RoundCornersVerticalVectorShape(f);
        }

        public /* synthetic */ RoundCornersVertical(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f);
        }
    }

    /* compiled from: QrVectorPixelShape.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape$RoundCornersHorizontal;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "radius", "", "(F)V", "component1", "copy", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "equals", "", "other", "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class RoundCornersHorizontal implements QrVectorPixelShape, QrVectorShapeModifier {
        private final /* synthetic */ RoundCornersHorizontalVectorShape $$delegate_0;
        private final float radius;

        public RoundCornersHorizontal() {
            this(0.0f, 1, null);
        }

        /* renamed from: component1, reason: from getter */
        private final float getRadius() {
            return this.radius;
        }

        public static /* synthetic */ RoundCornersHorizontal copy$default(RoundCornersHorizontal roundCornersHorizontal, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = roundCornersHorizontal.radius;
            }
            return roundCornersHorizontal.copy(f);
        }

        public final RoundCornersHorizontal copy(float radius) {
            return new RoundCornersHorizontal(radius);
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
            return (other instanceof RoundCornersHorizontal) && Intrinsics.areEqual(Float.valueOf(this.radius), Float.valueOf(((RoundCornersHorizontal) other).radius));
        }

        public int hashCode() {
            return Float.hashCode(this.radius);
        }

        public String toString() {
            return "RoundCornersHorizontal(radius=" + this.radius + ')';
        }

        public RoundCornersHorizontal(float f) {
            this.radius = f;
            this.$$delegate_0 = new RoundCornersHorizontalVectorShape(f);
        }

        public /* synthetic */ RoundCornersHorizontal(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0f : f);
        }
    }
}
