package com.bytedance.lottie.utils;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.bytedance.lottie.C0225L;
import com.bytedance.lottie.animation.content.TrimPathContent;
import java.io.Closeable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Utils {
    public static final int SECOND_IN_NANOS = 1000000000;
    private static final PathMeasure pathMeasure = new PathMeasure();
    private static final Path tempPath = new Path();
    private static final Path tempPath2 = new Path();
    private static final float[] points = new float[4];
    private static final float SQRT_2 = (float) Math.sqrt(2.0d);
    private static float dpScale = -1.0f;

    public static int hashFor(float f, float f2, float f3, float f4) {
        return (int) ((((int) ((((int) ((((int) ((527 * (f + 1.0f)) + 1.0f)) * 31 * (f2 + 2.0f)) + 1.0f)) * 31 * (f3 + 3.0f)) + 1.0f)) * 31 * (f4 + 4.0f)) + 1.0f);
    }

    public static boolean isAtLeastVersion(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    private Utils() {
    }

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float getScale(Matrix matrix) {
        float[] fArr = points;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = SQRT_2;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return ((float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1])) / 2.0f;
    }

    public static void applyTrimPathIfNeeded(Path path, TrimPathContent trimPathContent) {
        if (trimPathContent == null) {
            return;
        }
        applyTrimPathIfNeeded(path, trimPathContent.getStart().getValue().floatValue() / 100.0f, trimPathContent.getEnd().getValue().floatValue() / 100.0f, trimPathContent.getOffset().getValue().floatValue() / 360.0f);
    }

    public static void applyTrimPathIfNeeded(Path path, float f, float f2, float f3) {
        C0225L.beginSection("applyTrimPathIfNeeded");
        PathMeasure pathMeasure2 = pathMeasure;
        pathMeasure2.setPath(path, false);
        float length = pathMeasure2.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            C0225L.endSection("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            C0225L.endSection("applyTrimPathIfNeeded");
            return;
        }
        float f4 = f * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float min = Math.min(f4, f5) + f6;
        float max = Math.max(f4, f5) + f6;
        if (min >= length && max >= length) {
            min = MiscUtils.floorMod(min, length);
            max = MiscUtils.floorMod(max, length);
        }
        if (min < 0.0f) {
            min = MiscUtils.floorMod(min, length);
        }
        if (max < 0.0f) {
            max = MiscUtils.floorMod(max, length);
        }
        if (min == max) {
            path.reset();
            C0225L.endSection("applyTrimPathIfNeeded");
            return;
        }
        if (min >= max) {
            min -= length;
        }
        Path path2 = tempPath;
        path2.reset();
        pathMeasure2.getSegment(min, max, path2, true);
        if (max > length) {
            Path path3 = tempPath2;
            path3.reset();
            pathMeasure2.getSegment(0.0f, max % length, path3, true);
            path2.addPath(path3);
        } else if (min < 0.0f) {
            Path path4 = tempPath2;
            path4.reset();
            pathMeasure2.getSegment(min + length, length, path4, true);
            path2.addPath(path4);
        }
        path.set(path2);
        C0225L.endSection("applyTrimPathIfNeeded");
    }

    public static float dpScale() {
        if (dpScale == -1.0f) {
            dpScale = Resources.getSystem().getDisplayMetrics().density;
        }
        return dpScale;
    }
}
