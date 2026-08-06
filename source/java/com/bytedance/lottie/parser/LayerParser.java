package com.bytedance.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.animatable.AnimatableFloatValue;
import com.bytedance.lottie.model.animatable.AnimatableTextFrame;
import com.bytedance.lottie.model.animatable.AnimatableTextProperties;
import com.bytedance.lottie.model.animatable.AnimatableTransform;
import com.bytedance.lottie.model.content.ContentModel;
import com.bytedance.lottie.model.layer.Layer;
import com.bytedance.lottie.utils.Utils;
import com.bytedance.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LayerParser {
    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        return new Layer(Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PreComp, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), Layer.MatteType.None, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x024f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x030c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0337 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x019e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x01ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0203 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x020e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x023f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0247 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f;
        Layer.MatteType matteType = Layer.MatteType.None;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 1.0f;
        long j2 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        String str2 = "UNSET";
        String str3 = null;
        float f5 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        c = 0;
                    }
                    switch (c) {
                        case 0:
                            j2 = jsonReader.nextInt();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
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
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                                if (parse != null) {
                                    arrayList4.add(parse);
                                }
                            }
                            jsonReader.endArray();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
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
                            i5 = (int) (jsonReader.nextInt() * Utils.dpScale());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
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
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String nextName2 = jsonReader.nextName();
                                nextName2.hashCode();
                                if (nextName2.equals("a")) {
                                    jsonReader.beginArray();
                                    if (jsonReader.hasNext()) {
                                        animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                                    }
                                    while (jsonReader.hasNext()) {
                                        jsonReader.skipValue();
                                    }
                                    jsonReader.endArray();
                                } else if (nextName2.equals("d")) {
                                    animatableTextFrame = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
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
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 4:
                            i4 = (int) (jsonReader.nextInt() * Utils.dpScale());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
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
                            str3 = jsonReader.nextString();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
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
                            jsonReader.beginArray();
                            ArrayList arrayList5 = new ArrayList();
                            while (jsonReader.hasNext()) {
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName3 = jsonReader.nextName();
                                    nextName3.hashCode();
                                    if (nextName3.equals("nm")) {
                                        arrayList5.add(jsonReader.nextString());
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                            }
                            jsonReader.endArray();
                            lottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 7:
                            f3 = (float) jsonReader.nextDouble();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\b':
                            animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\t':
                            str2 = jsonReader.nextString();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\n':
                            f5 = (float) jsonReader.nextDouble();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 11:
                            i3 = Color.parseColor(jsonReader.nextString());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\f':
                            i2 = (int) (jsonReader.nextInt() * Utils.dpScale());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case '\r':
                            f2 = (float) jsonReader.nextDouble();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 14:
                            f4 = (float) jsonReader.nextDouble();
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 15:
                            i = (int) (jsonReader.nextInt() * Utils.dpScale());
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 16:
                            animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                            continue;
                        case 17:
                            matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                            lottieComposition.incrementMatteOrMaskCount(1);
                            break;
                        case 18:
                            int nextInt = jsonReader.nextInt();
                            if (nextInt < Layer.LayerType.Unknown.ordinal()) {
                                layerType = Layer.LayerType.values()[nextInt];
                                break;
                            } else {
                                layerType = Layer.LayerType.Unknown;
                                break;
                            }
                        case 19:
                            j = jsonReader.nextInt();
                            break;
                        case 20:
                            str = jsonReader.nextString();
                            break;
                        case 21:
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList3.add(MaskParser.parse(jsonReader, lottieComposition));
                            }
                            lottieComposition.incrementMatteOrMaskCount(arrayList3.size());
                            jsonReader.endArray();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                case -903568142:
                    if (nextName.equals("shapes")) {
                        c = 1;
                    }
                    switch (c) {
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c = 2;
                    }
                    switch (c) {
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 3;
                    }
                    switch (c) {
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c = 4;
                    }
                    switch (c) {
                    }
                    break;
                case 3177:
                    if (nextName.equals("cl")) {
                        c = 5;
                    }
                    switch (c) {
                    }
                    break;
                case 3233:
                    if (nextName.equals("ef")) {
                        c = 6;
                    }
                    switch (c) {
                    }
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c = 7;
                    }
                    switch (c) {
                    }
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
                        c = '\b';
                    }
                    switch (c) {
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = '\t';
                    }
                    switch (c) {
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c = '\n';
                    }
                    switch (c) {
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c = 11;
                    }
                    switch (c) {
                    }
                    break;
                case 3669:
                    if (nextName.equals("sh")) {
                        c = '\f';
                    }
                    switch (c) {
                    }
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        c = '\r';
                    }
                    switch (c) {
                    }
                    break;
                case 3681:
                    if (nextName.equals("st")) {
                        c = 14;
                    }
                    switch (c) {
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c = 15;
                    }
                    switch (c) {
                    }
                    break;
                case 3705:
                    if (nextName.equals("tm")) {
                        c = 16;
                    }
                    switch (c) {
                    }
                    break;
                case 3712:
                    if (nextName.equals("tt")) {
                        c = 17;
                    }
                    switch (c) {
                    }
                    break;
                case 3717:
                    if (nextName.equals("ty")) {
                        c = 18;
                    }
                    switch (c) {
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c = 19;
                    }
                    switch (c) {
                    }
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        c = 20;
                    }
                    switch (c) {
                    }
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        c = 21;
                    }
                    switch (c) {
                    }
                    break;
                default:
                    switch (c) {
                    }
                    break;
            }
        }
        jsonReader.endObject();
        float f6 = f3 / f2;
        float f7 = f5 / f2;
        ArrayList arrayList6 = new ArrayList();
        if (f6 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new Keyframe(lottieComposition, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f6)));
            f = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f = 0.0f;
        }
        if (f7 <= f) {
            f7 = lottieComposition.getEndFrame();
        }
        arrayList2.add(new Keyframe(lottieComposition, valueOf, valueOf, null, f6, Float.valueOf(f7)));
        arrayList2.add(new Keyframe(lottieComposition, valueOf2, valueOf2, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str3)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, lottieComposition, str2, j, layerType, j2, str, arrayList, animatableTransform, i, i2, i3, f2, f4, i4, i5, animatableTextFrame, animatableTextProperties, arrayList2, matteType2, animatableFloatValue);
    }
}
