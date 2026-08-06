package com.lynx.tasm.behavior.ui.shapes;

import android.graphics.Path;
import android.graphics.PathMeasure;
import com.lynx.tasm.utils.LRUHashMap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class LynxOffsetCalculator {
    private static final int MAX_CACHE_SIZE = 10;
    private static final LRUHashMap<Path, PathLengthCache> lruPathCache = new LRUHashMap<>(10);

    /* loaded from: classes7.dex */
    private static class PathLengthCache {
        List<Float> segmentLengths = new ArrayList();
        float totalLength;

        PathLengthCache() {
        }
    }

    public static float[] pointAtProgress(Path path, float f) {
        if (path == null) {
            return new float[]{0.0f, 0.0f, 0.0f};
        }
        float f2 = 0.0f;
        float max = Math.max(0.0f, Math.min(1.0f, f));
        PathLengthCache pathLengthCache = lruPathCache.get(path);
        if (pathLengthCache == null) {
            PathLengthCache pathLengthCache2 = new PathLengthCache();
            PathMeasure pathMeasure = new PathMeasure(path, false);
            do {
                float length = pathMeasure.getLength();
                pathLengthCache2.segmentLengths.add(Float.valueOf(length));
                pathLengthCache2.totalLength += length;
            } while (pathMeasure.nextContour());
            lruPathCache.put(path, pathLengthCache2);
            pathLengthCache = pathLengthCache2;
        }
        float f3 = pathLengthCache.totalLength * max;
        int i = 0;
        while (true) {
            if (i >= pathLengthCache.segmentLengths.size()) {
                i = 0;
                break;
            }
            float floatValue = pathLengthCache.segmentLengths.get(i).floatValue() + f2;
            if (f3 <= floatValue) {
                break;
            }
            i++;
            f2 = floatValue;
        }
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure2.nextContour();
        }
        float[] fArr = new float[2];
        pathMeasure2.getPosTan(f3 - f2, fArr, new float[2]);
        return new float[]{fArr[0], fArr[1], (float) ((Math.toDegrees(Math.atan2(r1[0], r1[1])) + 360.0d) % 180.0d)};
    }
}
