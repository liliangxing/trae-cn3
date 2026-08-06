package com.bytedance.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.lottie.model.CubicCurveData;
import com.bytedance.lottie.model.content.ShapeData;
import com.bytedance.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();

    private ShapeDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0049, code lost:
    
        if (r5.equals("i") == false) goto L10;
     */
    @Override // com.bytedance.lottie.parser.ValueParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShapeData parse(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (true) {
            char c = 1;
            if (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName.hashCode()) {
                    case 99:
                        if (nextName.equals("c")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 105:
                        break;
                    case 111:
                        if (nextName.equals("o")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 118:
                        if (nextName.equals("v")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                c = 65535;
                switch (c) {
                    case 0:
                        z = jsonReader.nextBoolean();
                        break;
                    case 1:
                        list2 = JsonUtils.jsonToPoints(jsonReader, f);
                        break;
                    case 2:
                        list3 = JsonUtils.jsonToPoints(jsonReader, f);
                        break;
                    case 3:
                        list = JsonUtils.jsonToPoints(jsonReader, f);
                        break;
                }
            } else {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (list == null || list2 == null || list3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (list.isEmpty()) {
                    return new ShapeData(new PointF(), false, Collections.emptyList());
                }
                int size = list.size();
                PointF pointF = list.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = list.get(i);
                    int i2 = i - 1;
                    arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i2), list3.get(i2)), MiscUtils.addPoints(pointF2, list2.get(i)), pointF2));
                }
                if (z) {
                    PointF pointF3 = list.get(0);
                    int i3 = size - 1;
                    arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i3), list3.get(i3)), MiscUtils.addPoints(pointF3, list2.get(0)), pointF3));
                }
                return new ShapeData(pointF, z, arrayList);
            }
        }
    }
}
