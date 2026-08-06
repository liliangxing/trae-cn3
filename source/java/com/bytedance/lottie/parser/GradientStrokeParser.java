package com.bytedance.lottie.parser;

import android.util.JsonReader;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.animatable.AnimatableFloatValue;
import com.bytedance.lottie.model.animatable.AnimatableGradientColorValue;
import com.bytedance.lottie.model.animatable.AnimatableIntegerValue;
import com.bytedance.lottie.model.animatable.AnimatablePointValue;
import com.bytedance.lottie.model.content.GradientStroke;
import com.bytedance.lottie.model.content.GradientType;
import com.bytedance.lottie.model.content.ShapeStroke;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GradientStrokeParser {
    private GradientStrokeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x00b6. Please report as an issue. */
    public static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        ArrayList arrayList = new ArrayList();
        float f = 0.0f;
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            AnimatableFloatValue animatableFloatValue3 = animatableFloatValue2;
            float f2 = f;
            ShapeStroke.LineJoinType lineJoinType2 = lineJoinType;
            int i = 1;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        c = 0;
                        break;
                    }
                    break;
                case 101:
                    if (nextName.equals("e")) {
                        c = 1;
                        break;
                    }
                    break;
                case 103:
                    if (nextName.equals("g")) {
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
                case 119:
                    if (nextName.equals("w")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        AnimatableFloatValue animatableFloatValue4 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else if (nextName2.equals("v")) {
                                animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        if (str2.equals("o")) {
                            animatableFloatValue3 = animatableFloatValue4;
                        } else if (str2.equals("d") || str2.equals("g")) {
                            i = 1;
                            lottieComposition.setHasDashPattern(true);
                            arrayList.add(animatableFloatValue4);
                        }
                        i = 1;
                    }
                    jsonReader.endArray();
                    if (arrayList.size() == i) {
                        arrayList.add(arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                case 1:
                    animatablePointValue2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                case 2:
                    jsonReader.beginObject();
                    int i2 = -1;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.hashCode();
                        if (nextName3.equals("k")) {
                            animatableGradientColorValue = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, i2);
                        } else if (nextName3.equals("p")) {
                            i2 = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                case 3:
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                case 4:
                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                case 5:
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.Linear : GradientType.Radial;
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                case 6:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                case '\b':
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    break;
                case '\t':
                    f = (float) jsonReader.nextDouble();
                    animatableFloatValue2 = animatableFloatValue3;
                    lineJoinType = lineJoinType2;
                    break;
                case '\n':
                    str = jsonReader.nextString();
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
                default:
                    jsonReader.skipValue();
                    animatableFloatValue2 = animatableFloatValue3;
                    f = f2;
                    lineJoinType = lineJoinType2;
                    break;
            }
        }
        return new GradientStroke(str, gradientType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f, arrayList, animatableFloatValue2);
    }
}
