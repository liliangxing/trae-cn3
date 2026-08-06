package com.bytedance.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.animatable.AnimatablePointValue;
import com.bytedance.lottie.model.animatable.AnimatableValue;
import com.bytedance.lottie.model.content.CircleShape;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CircleShapeParser {
    private CircleShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x001d. Please report as an issue. */
    public static CircleShape parse(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        c = 0;
                        break;
                    }
                    break;
                case 112:
                    if (nextName.equals("p")) {
                        c = 1;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 1:
                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    break;
                case 2:
                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new CircleShape(str, animatableValue, animatablePointValue, z);
    }
}
