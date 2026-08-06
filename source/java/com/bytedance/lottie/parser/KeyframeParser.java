package com.bytedance.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.utils.MiscUtils;
import com.bytedance.lottie.utils.Utils;
import com.bytedance.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class KeyframeParser {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final float MAX_CP_VALUE = 100.0f;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static WeakReference<Interpolator> getInterpolator(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = (WeakReference) pathInterpolatorCache().get(i);
        }
        return weakReference;
    }

    private static void putInterpolator(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i, weakReference);
        }
    }

    public static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        return parseStaticValue(jsonReader, f, valueParser);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0091. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0028. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        jsonReader.beginObject();
        PointF pointF = null;
        PointF pointF2 = null;
        T t = null;
        T t2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        float f2 = 0.0f;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case 101:
                        if (nextName.equals("e")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 105:
                        if (nextName.equals("i")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3701:
                        if (nextName.equals("ti")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 3707:
                        if (nextName.equals("to")) {
                            c = 7;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        t2 = valueParser.parse(jsonReader, f);
                    case 1:
                        if (jsonReader.nextInt() == 1) {
                            z = true;
                        }
                        break;
                    case 2:
                        pointF2 = JsonUtils.jsonToPoint(jsonReader, f);
                    case 3:
                        pointF = JsonUtils.jsonToPoint(jsonReader, f);
                    case 4:
                        t = valueParser.parse(jsonReader, f);
                    case 5:
                        f2 = (float) jsonReader.nextDouble();
                    case 6:
                        pointF4 = JsonUtils.jsonToPoint(jsonReader, f);
                    case 7:
                        pointF3 = JsonUtils.jsonToPoint(jsonReader, f);
                    default:
                        jsonReader.skipValue();
                }
                while (jsonReader.hasNext()) {
                }
            }
            jsonReader.endObject();
            if (z) {
                interpolator = LINEAR_INTERPOLATOR;
                t2 = t;
            } else if (pointF != null && pointF2 != null) {
                float f3 = -f;
                pointF.x = MiscUtils.clamp(pointF.x, f3, f);
                pointF.y = MiscUtils.clamp(pointF.y, -100.0f, MAX_CP_VALUE);
                pointF2.x = MiscUtils.clamp(pointF2.x, f3, f);
                pointF2.y = MiscUtils.clamp(pointF2.y, -100.0f, MAX_CP_VALUE);
                int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, pointF2.y);
                WeakReference<Interpolator> interpolator2 = getInterpolator(hashFor);
                Interpolator interpolator3 = interpolator2 != null ? interpolator2.get() : null;
                if (interpolator2 == null || interpolator3 == null) {
                    interpolator3 = PathInterpolatorCompat.create(pointF.x / f, pointF.y / f, pointF2.x / f, pointF2.y / f);
                    try {
                        putInterpolator(hashFor, new WeakReference(interpolator3));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator3;
            } else {
                interpolator = LINEAR_INTERPOLATOR;
            }
            Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t, t2, interpolator, f2, null);
            keyframe.pathCp1 = pointF3;
            keyframe.pathCp2 = pointF4;
            return keyframe;
        }
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f));
    }
}
