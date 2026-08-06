package com.edu.onetex.latex.graphic;

import android.graphics.PathMeasure;
import android.util.Log;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.OneTexConfiguration;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Path.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J&\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/edu/onetex/latex/graphic/Path;", "", "()V", "opList", "Ljava/util/ArrayList;", "Lcom/edu/onetex/latex/graphic/Path$Op;", "Lkotlin/collections/ArrayList;", "getOpList", "()Ljava/util/ArrayList;", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "segments", "", "startX", "", "startY", "cubicTo", "", "x1", "y1", "x2", "y2", "x3", "y3", "lineTo", "x", "y", "moveTo", "quadTo", "Op", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class Path {
    private double startX;
    private double startY;
    private android.graphics.Path path = new android.graphics.Path();
    private final int segments = 10;
    private final ArrayList<C0155Op> opList = new ArrayList<>();

    public final android.graphics.Path getPath() {
        return this.path;
    }

    public final void setPath(android.graphics.Path path) {
        Intrinsics.checkNotNullParameter(path, "<set-?>");
        this.path = path;
    }

    /* compiled from: Path.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/edu/onetex/latex/graphic/Path$Op;", "", "startX", "", "startY", "endX", "endY", "(DDDD)V", "getEndX", "()D", "getEndY", "getStartX", "getStartY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.edu.onetex.latex.graphic.Path$Op */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class C0155Op {
        private final double endX;
        private final double endY;
        private final double startX;
        private final double startY;

        /* renamed from: component1, reason: from getter */
        public final double getStartX() {
            return this.startX;
        }

        /* renamed from: component2, reason: from getter */
        public final double getStartY() {
            return this.startY;
        }

        /* renamed from: component3, reason: from getter */
        public final double getEndX() {
            return this.endX;
        }

        /* renamed from: component4, reason: from getter */
        public final double getEndY() {
            return this.endY;
        }

        public final C0155Op copy(double startX, double startY, double endX, double endY) {
            return new C0155Op(startX, startY, endX, endY);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof C0155Op)) {
                return false;
            }
            C0155Op c0155Op = (C0155Op) other;
            return Double.compare(this.startX, c0155Op.startX) == 0 && Double.compare(this.startY, c0155Op.startY) == 0 && Double.compare(this.endX, c0155Op.endX) == 0 && Double.compare(this.endY, c0155Op.endY) == 0;
        }

        public int hashCode() {
            long doubleToLongBits = Double.doubleToLongBits(this.startX);
            long doubleToLongBits2 = Double.doubleToLongBits(this.startY);
            int i = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
            long doubleToLongBits3 = Double.doubleToLongBits(this.endX);
            int i2 = (i + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31;
            long doubleToLongBits4 = Double.doubleToLongBits(this.endY);
            return i2 + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
        }

        public String toString() {
            return "Op(startX=" + this.startX + ", startY=" + this.startY + ", endX=" + this.endX + ", endY=" + this.endY + ")";
        }

        public C0155Op(double d, double d2, double d3, double d4) {
            this.startX = d;
            this.startY = d2;
            this.endX = d3;
            this.endY = d4;
        }

        public final double getEndX() {
            return this.endX;
        }

        public final double getEndY() {
            return this.endY;
        }

        public final double getStartX() {
            return this.startX;
        }

        public final double getStartY() {
            return this.startY;
        }
    }

    public final ArrayList<C0155Op> getOpList() {
        return this.opList;
    }

    public final void lineTo(double x, double y) {
        this.path.lineTo((float) x, (float) y);
        Log.d("SampleView", "lineTo x = " + x + ", y = " + y);
        OneTexConfiguration configuration = LaTeXEngine.INSTANCE.getConfiguration();
        if (configuration == null || !configuration.getLowVersionCompat()) {
            return;
        }
        this.opList.add(new C0155Op(this.startX, this.startY, x, y));
        Log.d("SampleView", "lineTo opList.add x1 = " + this.startX + ", y1 = " + this.startY + " x2 = " + x + ", y2 = " + y);
        this.startX = x;
        this.startY = y;
    }

    public final void quadTo(double x1, double y1, double x2, double y2) {
        PathMeasure pathMeasure;
        boolean z;
        int i;
        int i2;
        Path path = this;
        float f = (float) x1;
        float f2 = (float) y1;
        float f3 = (float) x2;
        float f4 = (float) y2;
        path.path.quadTo(f, f2, f3, f4);
        Log.d("SampleView", "quadTo x1 = " + x1 + ", y1 = " + y1 + " x2 = " + x2 + ", y2 = " + y2);
        OneTexConfiguration configuration = LaTeXEngine.INSTANCE.getConfiguration();
        if (configuration == null || !configuration.getLowVersionCompat()) {
            return;
        }
        android.graphics.Path path2 = new android.graphics.Path();
        path2.moveTo((float) path.startX, (float) path.startY);
        path2.quadTo(f, f2, f3, f4);
        PathMeasure pathMeasure2 = new PathMeasure(path2, false);
        float[] fArr = new float[2];
        double d = path.startX;
        double d2 = path.startY;
        int i3 = path.segments;
        if (1 <= i3) {
            int i4 = 1;
            while (true) {
                float length = i4 * (pathMeasure2.getLength() / path.segments);
                if (length < pathMeasure2.getLength()) {
                    pathMeasure2.getPosTan(length, fArr, null);
                    pathMeasure = pathMeasure2;
                    path.opList.add(new C0155Op(d, d2, fArr[0], fArr[1]));
                    z = false;
                    Log.d("SampleView", "quadTo opList.add x1 = " + d + ", y1 = " + d2 + " x2 = " + fArr[0] + ", y2 = " + fArr[1]);
                    double d3 = fArr[0];
                    i = i3;
                    d2 = fArr[1];
                    d = d3;
                    i2 = i4;
                } else {
                    pathMeasure = pathMeasure2;
                    z = false;
                    i = i3;
                    i2 = i4;
                }
                if (i2 == i) {
                    break;
                }
                i4 = i2 + 1;
                pathMeasure2 = pathMeasure;
                i3 = i;
                path = this;
            }
        }
        this.startX = x2;
        this.startY = y2;
    }

    public final void cubicTo(double x1, double y1, double x2, double y2, double x3, double y3) {
        PathMeasure pathMeasure;
        String str;
        int i;
        int i2;
        float f = (float) x1;
        float f2 = (float) y1;
        float f3 = (float) x2;
        float f4 = (float) y2;
        float f5 = (float) x3;
        float f6 = (float) y3;
        this.path.cubicTo(f, f2, f3, f4, f5, f6);
        String str2 = "SampleView";
        Log.d("SampleView", "cubicTo x1 = " + x1 + ", y1 = " + y1 + " x2 = " + x2 + ", y2 = " + y2 + " x3 = " + x3 + ", y3 = " + y3);
        OneTexConfiguration configuration = LaTeXEngine.INSTANCE.getConfiguration();
        if (configuration == null || !configuration.getLowVersionCompat()) {
            return;
        }
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo((float) this.startX, (float) this.startY);
        path.cubicTo(f, f2, f3, f4, f5, f6);
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        float[] fArr = new float[2];
        double d = this.startX;
        double d2 = this.startY;
        int i3 = this.segments;
        if (1 <= i3) {
            int i4 = 1;
            while (true) {
                float length = i4 * (pathMeasure2.getLength() / this.segments);
                if (length < pathMeasure2.getLength()) {
                    pathMeasure2.getPosTan(length, fArr, null);
                    pathMeasure = pathMeasure2;
                    this.opList.add(new C0155Op(d, d2, fArr[0], fArr[1]));
                    str = str2;
                    Log.d(str, "cubicTo opList.add x1 = " + d + ", y1 = " + d2 + " x2 = " + fArr[0] + ", y2 = " + fArr[1]);
                    double d3 = fArr[0];
                    i = i3;
                    d2 = fArr[1];
                    d = d3;
                    i2 = i4;
                } else {
                    pathMeasure = pathMeasure2;
                    str = str2;
                    i = i3;
                    i2 = i4;
                }
                if (i2 == i) {
                    break;
                }
                i4 = i2 + 1;
                i3 = i;
                str2 = str;
                pathMeasure2 = pathMeasure;
            }
        }
        this.startX = x3;
        this.startY = y3;
    }

    public final void moveTo(double x, double y) {
        this.path.moveTo((float) x, (float) y);
        Log.d("SampleView", "moveTo x = " + x + ", y = " + y);
        OneTexConfiguration configuration = LaTeXEngine.INSTANCE.getConfiguration();
        if (configuration == null || !configuration.getLowVersionCompat()) {
            return;
        }
        this.startX = x;
        this.startY = y;
    }
}
