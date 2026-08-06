package androidx.compose.p002ui.graphics.vector;

import androidx.compose.p002ui.graphics.AndroidPath_androidKt;
import androidx.compose.p002ui.graphics.Path;
import androidx.compose.p002ui.graphics.vector.PathNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: PathParser.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0005\u001aX\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u001aX\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a\r\u0010\u001e\u001a\u00020\r*\u00020\rH\u0082\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "toPath", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "target", "drawArc", "", "p", "x0", "", "y0", "x1", "y1", "a", "b", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcToBezier", "cx", "cy", "e1x", "e1y", "start", "sweep", "toRadians", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    private static final double toRadians(double d) {
        return (d / 180) * 3.141592653589793d;
    }

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    public static final Path toPath(List<? extends PathNode> list, Path path) {
        PathNode pathNode;
        float f;
        int i;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        float dy;
        float x2;
        float y2;
        float dy2;
        float f6;
        float f7;
        float y1;
        float x22;
        float y22;
        float f8;
        float f9;
        List<? extends PathNode> list2 = list;
        Path path2 = path;
        int mo4726getFillTypeRgk1Os = path.mo4726getFillTypeRgk1Os();
        path.rewind();
        path2.mo4728setFillTypeoQ8Xj4U(mo4726getFillTypeRgk1Os);
        PathNode pathNode2 = list.isEmpty() ? PathNode.Close.INSTANCE : list2.get(0);
        int size = list2.size();
        float f10 = 0.0f;
        int i3 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        while (i3 < size) {
            PathNode pathNode3 = list2.get(i3);
            if (pathNode3 instanceof PathNode.Close) {
                path.close();
                pathNode = pathNode3;
                f = f10;
                i = i3;
                i2 = size;
                f11 = f15;
                f13 = f11;
                f12 = f16;
                f14 = f12;
            } else {
                if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                    f13 += relativeMoveTo.getDx();
                    f14 += relativeMoveTo.getDy();
                    path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                    f15 = f13;
                } else if (pathNode3 instanceof PathNode.MoveTo) {
                    PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                    float x = moveTo.getX();
                    float y = moveTo.getY();
                    path2.moveTo(moveTo.getX(), moveTo.getY());
                    f13 = x;
                    f15 = f13;
                    f14 = y;
                } else {
                    if (pathNode3 instanceof PathNode.RelativeLineTo) {
                        PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                        path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                        f13 += relativeLineTo.getDx();
                        dy2 = relativeLineTo.getDy();
                    } else {
                        if (pathNode3 instanceof PathNode.LineTo) {
                            PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                            path2.lineTo(lineTo.getX(), lineTo.getY());
                            x2 = lineTo.getX();
                            y2 = lineTo.getY();
                        } else {
                            if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                                PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                                path2.relativeLineTo(relativeHorizontalTo.getDx(), f10);
                                f13 += relativeHorizontalTo.getDx();
                            } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                                PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                                path2.lineTo(horizontalTo.getX(), f14);
                                f13 = horizontalTo.getX();
                            } else if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                                PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                                path2.relativeLineTo(f10, relativeVerticalTo.getDy());
                                dy2 = relativeVerticalTo.getDy();
                            } else if (pathNode3 instanceof PathNode.VerticalTo) {
                                PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                                path2.lineTo(f13, verticalTo.getY());
                                f14 = verticalTo.getY();
                            } else {
                                if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                                    PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                                    path.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                                    f4 = relativeCurveTo.getDx2() + f13;
                                    f5 = relativeCurveTo.getDy2() + f14;
                                    f13 += relativeCurveTo.getDx3();
                                    dy = relativeCurveTo.getDy3();
                                } else {
                                    if (pathNode3 instanceof PathNode.CurveTo) {
                                        PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode3;
                                        path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                        f4 = curveTo.getX2();
                                        y1 = curveTo.getY2();
                                        x22 = curveTo.getX3();
                                        y22 = curveTo.getY3();
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveCurveTo) {
                                        if (pathNode2.getIsCurve()) {
                                            f9 = f14 - f12;
                                            f8 = f13 - f11;
                                        } else {
                                            f8 = f10;
                                            f9 = f8;
                                        }
                                        PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode3;
                                        path.relativeCubicTo(f8, f9, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                        f4 = relativeReflectiveCurveTo.getDx1() + f13;
                                        f5 = relativeReflectiveCurveTo.getDy1() + f14;
                                        f13 += relativeReflectiveCurveTo.getDx2();
                                        dy = relativeReflectiveCurveTo.getDy2();
                                    } else if (pathNode3 instanceof PathNode.ReflectiveCurveTo) {
                                        if (pathNode2.getIsCurve()) {
                                            float f17 = 2;
                                            f7 = (f17 * f14) - f12;
                                            f6 = (f13 * f17) - f11;
                                        } else {
                                            f6 = f13;
                                            f7 = f14;
                                        }
                                        PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode3;
                                        path.cubicTo(f6, f7, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                        f4 = reflectiveCurveTo.getX1();
                                        y1 = reflectiveCurveTo.getY1();
                                        x22 = reflectiveCurveTo.getX2();
                                        y22 = reflectiveCurveTo.getY2();
                                    } else if (pathNode3 instanceof PathNode.RelativeQuadTo) {
                                        PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode3;
                                        path2.relativeQuadraticTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                        f11 = relativeQuadTo.getDx1() + f13;
                                        f12 = relativeQuadTo.getDy1() + f14;
                                        f13 += relativeQuadTo.getDx2();
                                        dy2 = relativeQuadTo.getDy2();
                                    } else if (pathNode3 instanceof PathNode.QuadTo) {
                                        PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode3;
                                        path2.quadraticTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                        f11 = quadTo.getX1();
                                        f12 = quadTo.getY1();
                                        x2 = quadTo.getX2();
                                        y2 = quadTo.getY2();
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveQuadTo) {
                                        if (pathNode2.getIsQuad()) {
                                            f2 = f13 - f11;
                                            f3 = f14 - f12;
                                        } else {
                                            f2 = f10;
                                            f3 = f2;
                                        }
                                        PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode3;
                                        path2.relativeQuadraticTo(f2, f3, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                        f4 = f2 + f13;
                                        f5 = f3 + f14;
                                        f13 += relativeReflectiveQuadTo.getDx();
                                        dy = relativeReflectiveQuadTo.getDy();
                                    } else if (pathNode3 instanceof PathNode.ReflectiveQuadTo) {
                                        if (pathNode2.getIsQuad()) {
                                            float f18 = 2;
                                            f13 = (f13 * f18) - f11;
                                            f14 = (f18 * f14) - f12;
                                        }
                                        PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode3;
                                        path2.quadraticTo(f13, f14, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                        float x3 = reflectiveQuadTo.getX();
                                        f12 = f14;
                                        pathNode = pathNode3;
                                        f = f10;
                                        i = i3;
                                        i2 = size;
                                        f14 = reflectiveQuadTo.getY();
                                        float f19 = f13;
                                        f13 = x3;
                                        f11 = f19;
                                    } else if (pathNode3 instanceof PathNode.RelativeArcTo) {
                                        PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode3;
                                        float arcStartDx = relativeArcTo.getArcStartDx() + f13;
                                        float arcStartDy = relativeArcTo.getArcStartDy() + f14;
                                        pathNode = pathNode3;
                                        i = i3;
                                        f = 0.0f;
                                        i2 = size;
                                        drawArc(path, f13, f14, arcStartDx, arcStartDy, relativeArcTo.getHorizontalEllipseRadius(), relativeArcTo.getVerticalEllipseRadius(), relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
                                        f12 = arcStartDy;
                                        f14 = f12;
                                        f11 = arcStartDx;
                                        f13 = f11;
                                    } else {
                                        pathNode = pathNode3;
                                        f = f10;
                                        i = i3;
                                        i2 = size;
                                        if (!(pathNode instanceof PathNode.ArcTo)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
                                        drawArc(path, f13, f14, arcTo.getArcStartX(), arcTo.getArcStartY(), arcTo.getHorizontalEllipseRadius(), arcTo.getVerticalEllipseRadius(), arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                        f13 = arcTo.getArcStartX();
                                        f12 = arcTo.getArcStartY();
                                        f14 = f12;
                                        f11 = f13;
                                    }
                                    f13 = x22;
                                    f14 = y22;
                                    pathNode = pathNode3;
                                    f = f10;
                                    i = i3;
                                    i2 = size;
                                    f12 = y1;
                                    f11 = f4;
                                }
                                f14 += dy;
                                f12 = f5;
                                pathNode = pathNode3;
                                f = f10;
                                i = i3;
                                i2 = size;
                                f11 = f4;
                            }
                            pathNode = pathNode3;
                            f = f10;
                            i = i3;
                            i2 = size;
                        }
                        f14 = y2;
                        f13 = x2;
                        pathNode = pathNode3;
                        f = f10;
                        i = i3;
                        i2 = size;
                    }
                    f14 += dy2;
                    pathNode = pathNode3;
                    f = f10;
                    i = i3;
                    i2 = size;
                }
                f16 = f14;
                pathNode = pathNode3;
                f = f10;
                i = i3;
                i2 = size;
            }
            i3 = i + 1;
            path2 = path;
            pathNode2 = pathNode;
            f10 = f;
            size = i2;
            list2 = list;
        }
        return path;
    }

    private static final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = (d7 / 180) * 3.141592653589793d;
        double cos = Math.cos(d10);
        double sin = Math.sin(d10);
        double d11 = ((d * cos) + (d2 * sin)) / d5;
        double d12 = (((-d) * sin) + (d2 * cos)) / d6;
        double d13 = ((d3 * cos) + (d4 * sin)) / d5;
        double d14 = (((-d3) * sin) + (d4 * cos)) / d6;
        double d15 = d11 - d13;
        double d16 = d12 - d14;
        double d17 = 2;
        double d18 = (d11 + d13) / d17;
        double d19 = (d12 + d14) / d17;
        double d20 = (d15 * d15) + (d16 * d16);
        if (d20 == 0.0d) {
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            double sqrt = (float) (Math.sqrt(d20) / 1.99999d);
            drawArc(path, d, d2, d3, d4, d5 * sqrt, d6 * sqrt, d7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d21);
        double d22 = d15 * sqrt2;
        double d23 = sqrt2 * d16;
        if (z == z2) {
            d8 = d18 - d23;
            d9 = d19 + d22;
        } else {
            d8 = d18 + d23;
            d9 = d19 - d22;
        }
        double atan2 = Math.atan2(d12 - d9, d11 - d8);
        double atan22 = Math.atan2(d14 - d9, d13 - d8) - atan2;
        if (z2 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d24 = d8 * d5;
        double d25 = d9 * d6;
        arcToBezier(path, (d24 * cos) - (d25 * sin), (d24 * sin) + (d25 * cos), d5, d6, d, d2, d10, atan2, atan22);
    }

    private static final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        double d11 = 4;
        int ceil = (int) Math.ceil(Math.abs((d9 * d11) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d12 = -d10;
        double d13 = d12 * cos;
        double d14 = d4 * sin;
        double d15 = (d13 * sin2) - (d14 * cos2);
        double d16 = d12 * sin;
        double d17 = d4 * cos;
        double d18 = (sin2 * d16) + (cos2 * d17);
        double d19 = d9 / ceil;
        double d20 = d5;
        double d21 = d18;
        double d22 = d15;
        int i = 0;
        double d23 = d6;
        double d24 = d8;
        while (i < ceil) {
            double d25 = d24 + d19;
            double sin3 = Math.sin(d25);
            double cos3 = Math.cos(d25);
            int i2 = ceil;
            double d26 = (d + ((d10 * cos) * cos3)) - (d14 * sin3);
            double d27 = d2 + (d10 * sin * cos3) + (d17 * sin3);
            double d28 = (d13 * sin3) - (d14 * cos3);
            double d29 = (sin3 * d16) + (cos3 * d17);
            double d30 = d25 - d24;
            double tan = Math.tan(d30 / 2);
            double sin4 = (Math.sin(d30) * (Math.sqrt(d11 + ((3.0d * tan) * tan)) - 1)) / 3;
            path.cubicTo((float) (d20 + (d22 * sin4)), (float) (d23 + (d21 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
            i++;
            d19 = d19;
            sin = sin;
            d20 = d26;
            d16 = d16;
            d24 = d25;
            d21 = d29;
            d11 = d11;
            d22 = d28;
            cos = cos;
            ceil = i2;
            d23 = d27;
            d10 = d3;
        }
    }
}
