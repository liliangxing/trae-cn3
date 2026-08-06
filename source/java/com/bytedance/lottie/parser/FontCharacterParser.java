package com.bytedance.lottie.parser;

import android.util.JsonReader;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.FontCharacter;
import com.bytedance.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FontCharacterParser {
    private FontCharacterParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    public static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double d = 0.0d;
        String str = null;
        String str2 = null;
        char c = 0;
        double d2 = 0.0d;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3173:
                    if (nextName.equals("ch")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3076010:
                    if (nextName.equals("data")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 109780401:
                    if (nextName.equals("style")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str2 = jsonReader.nextString();
                    break;
                case 1:
                    d = jsonReader.nextDouble();
                    break;
                case 2:
                    c = jsonReader.nextString().charAt(0);
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((ShapeGroup) ContentModelParser.parse(jsonReader, lottieComposition));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    d2 = jsonReader.nextDouble();
                    break;
                case 5:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new FontCharacter(arrayList, c, d2, d, str, str2);
    }
}
