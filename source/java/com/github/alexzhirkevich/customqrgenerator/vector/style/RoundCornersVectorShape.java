package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import android.graphics.RectF;
import com.github.alexzhirkevich.customqrgenerator.style.Neighbors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DefaultVectorShapes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/vector/style/RoundCornersVectorShape;", "Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapeModifier;", "cornerRadius", "", "withNeighbors", "", "topLeft", "bottomLeft", "topRight", "bottomRight", "(FZZZZZ)V", "getBottomLeft", "()Z", "getBottomRight", "getCornerRadius", "()F", "getTopLeft", "getTopRight", "getWithNeighbors", "createPath", "Landroid/graphics/Path;", "size", "neighbors", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class RoundCornersVectorShape implements QrVectorShapeModifier {
    private final boolean bottomLeft;
    private final boolean bottomRight;
    private final float cornerRadius;
    private final boolean topLeft;
    private final boolean topRight;
    private final boolean withNeighbors;

    public RoundCornersVectorShape(float f, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.cornerRadius = f;
        this.withNeighbors = z;
        this.topLeft = z2;
        this.bottomLeft = z3;
        this.topRight = z4;
        this.bottomRight = z5;
    }

    public /* synthetic */ RoundCornersVectorShape(float f, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, z, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4, (i & 32) != 0 ? true : z5);
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final boolean getWithNeighbors() {
        return this.withNeighbors;
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
        Path path = new Path();
        float f = 0.0f;
        float coerceIn = RangesKt.coerceIn(this.cornerRadius, 0.0f, 0.5f) * size;
        RectF rectF = new RectF(0.0f, 0.0f, size, size);
        float[] fArr = new float[8];
        fArr[0] = (!this.topLeft || (this.withNeighbors && (neighbors.getTop() || neighbors.getLeft()))) ? 0.0f : coerceIn;
        fArr[1] = (!this.topLeft || (this.withNeighbors && (neighbors.getTop() || neighbors.getLeft()))) ? 0.0f : coerceIn;
        fArr[2] = (!this.topRight || (this.withNeighbors && (neighbors.getTop() || neighbors.getRight()))) ? 0.0f : coerceIn;
        fArr[3] = (!this.topRight || (this.withNeighbors && (neighbors.getTop() || neighbors.getRight()))) ? 0.0f : coerceIn;
        fArr[4] = (!this.bottomRight || (this.withNeighbors && (neighbors.getBottom() || neighbors.getRight()))) ? 0.0f : coerceIn;
        fArr[5] = (!this.bottomRight || (this.withNeighbors && (neighbors.getBottom() || neighbors.getRight()))) ? 0.0f : coerceIn;
        fArr[6] = (!this.bottomLeft || (this.withNeighbors && (neighbors.getBottom() || neighbors.getLeft()))) ? 0.0f : coerceIn;
        if (this.bottomLeft && (!this.withNeighbors || (!neighbors.getBottom() && !neighbors.getLeft()))) {
            f = coerceIn;
        }
        fArr[7] = f;
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        return path;
    }
}
