package com.bytedance.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.animation.keyframe.PathKeyframe;
import com.bytedance.lottie.utils.Utils;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    public static PathKeyframe parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new PathKeyframe(lottieComposition, KeyframeParser.parse(jsonReader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
