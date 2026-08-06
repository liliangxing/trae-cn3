package com.bytedance.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import com.bytedance.lottie.C0225L;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.animatable.AnimatableFloatValue;
import com.bytedance.lottie.model.animatable.AnimatableIntegerValue;
import com.bytedance.lottie.model.animatable.AnimatablePathValue;
import com.bytedance.lottie.model.animatable.AnimatableScaleValue;
import com.bytedance.lottie.model.animatable.AnimatableTransform;
import com.bytedance.lottie.model.animatable.AnimatableValue;
import com.bytedance.lottie.value.ScaleXY;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AnimatableTransformParser {
    private AnimatableTransformParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        AnimatablePathValue animatablePathValue = null;
        AnimatableScaleValue animatableScaleValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 97:
                    if (nextName.equals("a")) {
                        c = 0;
                    }
                    switch (c) {
                        case 0:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if (jsonReader.nextName().equals("k")) {
                                    animatablePathValue = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 1:
                            animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 2:
                            animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 3:
                            break;
                        case 4:
                            animatableScaleValue = AnimatableValueParser.parseScale(jsonReader, lottieComposition);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 5:
                            animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 6:
                            lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                            break;
                        case 7:
                            animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        default:
                            jsonReader.skipValue();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                case 111:
                    if (nextName.equals("o")) {
                        c = 1;
                    }
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 112:
                    if (nextName.equals("p")) {
                        c = 2;
                    }
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 3;
                    }
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 4;
                    }
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 3242:
                    if (nextName.equals("eo")) {
                        c = 5;
                    }
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 3656:
                    if (nextName.equals("rz")) {
                        c = 6;
                    }
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 3676:
                    if (nextName.equals("so")) {
                        c = 7;
                    }
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                default:
                    switch (c) {
                    }
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
            }
        }
        if (z) {
            jsonReader.endObject();
        }
        if (animatablePathValue == null) {
            Log.w(C0225L.TAG, "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            animatablePathValue = new AnimatablePathValue();
        }
        AnimatablePathValue animatablePathValue2 = animatablePathValue;
        if (animatableScaleValue == null) {
            animatableScaleValue = new AnimatableScaleValue(new ScaleXY(1.0f, 1.0f));
        }
        AnimatableScaleValue animatableScaleValue2 = animatableScaleValue;
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue();
        }
        return new AnimatableTransform(animatablePathValue2, animatableValue, animatableScaleValue2, animatableFloatValue, animatableIntegerValue, animatableFloatValue2, animatableFloatValue3);
    }
}
