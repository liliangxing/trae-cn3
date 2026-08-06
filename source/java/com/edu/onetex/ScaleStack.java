package com.edu.onetex;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScaleStack.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\""}, d2 = {"Lcom/edu/onetex/ScaleStack;", "", "()V", "mScaleStackX", "", "", "mScaleStackY", "scaleStackXTopIndex", "", "getScaleStackXTopIndex", "()I", "scaleStackYTopIndex", "getScaleStackYTopIndex", "scaleX", "getScaleX", "()F", "scaleY", "getScaleY", "appendScale", "", "sx", "sy", "popScaleValues", "pushScaleValues", "scaleFontSize", "size", "scalePath", "Landroid/graphics/Path;", "path", "scaleRectF", "Landroid/graphics/RectF;", "rect", "x", "y", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ScaleStack {
    private final List<Float> mScaleStackX;
    private final List<Float> mScaleStackY;

    public ScaleStack() {
        ArrayList arrayList = new ArrayList();
        this.mScaleStackX = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.mScaleStackY = arrayList2;
        Float valueOf = Float.valueOf(1.0f);
        arrayList.add(valueOf);
        arrayList2.add(valueOf);
    }

    public final float getScaleX() {
        return this.mScaleStackX.get(getScaleStackXTopIndex()).floatValue();
    }

    public final float getScaleY() {
        return this.mScaleStackY.get(getScaleStackYTopIndex()).floatValue();
    }

    private final int getScaleStackXTopIndex() {
        return this.mScaleStackX.size() - 1;
    }

    private final int getScaleStackYTopIndex() {
        return this.mScaleStackY.size() - 1;
    }

    public final void appendScale(float sx, float sy) {
        float scaleX = scaleX(sx);
        float scaleY = scaleY(sy);
        this.mScaleStackX.set(getScaleStackXTopIndex(), Float.valueOf(scaleX));
        this.mScaleStackY.set(getScaleStackYTopIndex(), Float.valueOf(scaleY));
    }

    public final void pushScaleValues() {
        this.mScaleStackX.add(Float.valueOf(getScaleX()));
        this.mScaleStackY.add(Float.valueOf(getScaleY()));
    }

    public final void popScaleValues() {
        this.mScaleStackX.remove(getScaleStackXTopIndex());
        this.mScaleStackY.remove(getScaleStackYTopIndex());
    }

    public final float scaleX(float x) {
        return x * getScaleX();
    }

    public final float scaleY(float y) {
        return y * getScaleY();
    }

    public final float scaleFontSize(float size) {
        return Math.min(getScaleX(), getScaleY()) * size;
    }

    public final Path scalePath(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Matrix matrix = new Matrix();
        matrix.setScale(getScaleX(), getScaleY());
        path.transform(matrix);
        return path;
    }

    public final RectF scaleRectF(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        rect.bottom *= getScaleY();
        rect.top *= getScaleY();
        rect.left *= getScaleX();
        rect.right *= getScaleX();
        return rect;
    }
}
