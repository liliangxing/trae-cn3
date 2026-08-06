package com.bytedance.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class KeyframesParser {
    private KeyframesParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("k")) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, false));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, true));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f, valueParser, false));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        setEndFrames(arrayList);
        return arrayList;
    }

    public static void setEndFrames(List<? extends Keyframe<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            Keyframe<?> keyframe = list.get(i2);
            i2++;
            keyframe.endFrame = Float.valueOf(list.get(i2).startFrame);
        }
        Keyframe<?> keyframe2 = list.get(i);
        if (keyframe2.startValue == 0) {
            list.remove(keyframe2);
        }
    }
}
