package com.bytedance.lottie.parser;

import android.util.JsonReader;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.content.ContentModel;
import com.bytedance.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShapeGroupParser {
    private ShapeGroupParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("it")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                    if (parse != null) {
                        arrayList.add(parse);
                    }
                }
                jsonReader.endArray();
            } else if (nextName.equals("nm")) {
                str = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new ShapeGroup(str, arrayList);
    }
}
