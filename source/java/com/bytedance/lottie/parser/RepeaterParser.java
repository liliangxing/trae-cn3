package com.bytedance.lottie.parser;

import android.util.JsonReader;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.animatable.AnimatableFloatValue;
import com.bytedance.lottie.model.animatable.AnimatableTransform;
import com.bytedance.lottie.model.content.Repeater;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RepeaterParser {
    private RepeaterParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0017. Please report as an issue. */
    public static Repeater parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c = 0;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 1:
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new Repeater(str, animatableFloatValue, animatableFloatValue2, animatableTransform);
    }
}
