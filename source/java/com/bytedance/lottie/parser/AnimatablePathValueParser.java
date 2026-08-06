package com.bytedance.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.animatable.AnimatableFloatValue;
import com.bytedance.lottie.model.animatable.AnimatablePathValue;
import com.bytedance.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.bytedance.lottie.model.animatable.AnimatableValue;
import com.bytedance.lottie.utils.Utils;
import com.bytedance.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AnimatablePathValueParser {
    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.parse(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.jsonToPoint(jsonReader, Utils.dpScale())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0046 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 107:
                    if (nextName.equals("k")) {
                        c = 0;
                    }
                    switch (c) {
                        case 0:
                            animatablePathValue = parse(jsonReader, lottieComposition);
                            continue;
                            continue;
                            continue;
                            continue;
                        case 1:
                            if (jsonReader.peek() == JsonToken.STRING) {
                                jsonReader.skipValue();
                                break;
                            } else {
                                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                break;
                            }
                        case 2:
                            if (jsonReader.peek() == JsonToken.STRING) {
                                jsonReader.skipValue();
                                break;
                            } else {
                                animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                break;
                            }
                        default:
                            jsonReader.skipValue();
                            continue;
                            continue;
                            continue;
                            continue;
                    }
                    z = true;
                case 120:
                    if (nextName.equals("x")) {
                        c = 1;
                    }
                    switch (c) {
                    }
                    z = true;
                    break;
                case 121:
                    if (nextName.equals("y")) {
                        c = 2;
                    }
                    switch (c) {
                    }
                    z = true;
                    break;
                default:
                    switch (c) {
                    }
                    z = true;
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        return animatablePathValue != null ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}
