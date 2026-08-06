package com.bytedance.lottie.parser;

import android.graphics.Rect;
import android.util.JsonReader;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceUriHelperKt;
import com.bytedance.lottie.C0225L;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.LottieImageAsset;
import com.bytedance.lottie.model.Font;
import com.bytedance.lottie.model.FontCharacter;
import com.bytedance.lottie.model.layer.Layer;
import com.bytedance.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LottieCompositionParser {
    private LottieCompositionParser() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0049. Please report as an issue. */
    public static LottieComposition parse(JsonReader jsonReader) throws IOException {
        SparseArrayCompat<FontCharacter> sparseArrayCompat;
        HashMap hashMap;
        float dpScale = Utils.dpScale();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        SparseArrayCompat<FontCharacter> sparseArrayCompat2 = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = 0;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1408207997:
                    if (nextName.equals(ResourceUriHelperKt.SCHEME_ASSETS)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1109732030:
                    if (nextName.equals("layers")) {
                        c = 1;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
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
                case 119:
                    if (nextName.equals("w")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3276:
                    if (nextName.equals("fr")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c = 7;
                        break;
                    }
                    break;
                case 94623709:
                    if (nextName.equals("chars")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 97615364:
                    if (nextName.equals("fonts")) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    parseAssets(jsonReader, lottieComposition, hashMap2, hashMap3);
                    continue;
                case 1:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    parseLayers(jsonReader, lottieComposition, arrayList, longSparseArray);
                    continue;
                case 2:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    i2 = jsonReader.nextInt();
                    continue;
                case 3:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!Utils.isAtLeastVersion(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    i = jsonReader.nextInt();
                    continue;
                case 5:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    f3 = (float) jsonReader.nextDouble();
                    continue;
                case 6:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    f = (float) jsonReader.nextDouble();
                    continue;
                case 7:
                    sparseArrayCompat = sparseArrayCompat2;
                    hashMap = hashMap4;
                    f2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    continue;
                case '\b':
                    parseChars(jsonReader, lottieComposition, sparseArrayCompat2);
                    break;
                case '\t':
                    parseFonts(jsonReader, hashMap4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            sparseArrayCompat = sparseArrayCompat2;
            hashMap = hashMap4;
            hashMap4 = hashMap;
            sparseArrayCompat2 = sparseArrayCompat;
        }
        jsonReader.endObject();
        lottieComposition.init(new Rect(0, 0, (int) (i * dpScale), (int) (i2 * dpScale)), f, f2, f3, arrayList, longSparseArray, hashMap2, hashMap3, sparseArrayCompat2, hashMap4);
        return lottieComposition;
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer parse = LayerParser.parse(jsonReader, lottieComposition);
            if (parse.getLayerType() == Layer.LayerType.Image) {
                i++;
            }
            list.add(parse);
            longSparseArray.put(parse.getId(), parse);
            if (i > 4) {
                C0225L.warn("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        switch(r12) {
            case 0: goto L70;
            case 1: goto L69;
            case 2: goto L68;
            case 3: goto L67;
            case 4: goto L66;
            case 5: goto L65;
            case 6: goto L64;
            default: goto L72;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
    
        r11 = r14.nextBoolean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        r8 = r14.nextString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
    
        r6 = r14.nextInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
    
        r10 = r14.nextString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a2, code lost:
    
        r9 = r14.nextString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a9, code lost:
    
        r7 = r14.nextInt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
    
        r14.beginArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
    
        if (r14.hasNext() == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b8, code lost:
    
        r4 = com.bytedance.lottie.parser.LayerParser.parse(r14, r15);
        r1.put(r4.getId(), r4);
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
    
        r14.endArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0087, code lost:
    
        r14.skipValue();
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            boolean z = true;
            int i = 0;
            int i2 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1109732030:
                        if (nextName.equals("layers")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 112:
                        if (nextName.equals("p")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 117:
                        if (nextName.equals("u")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 119:
                        if (nextName.equals("w")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 3355:
                        if (nextName.equals("id")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 92909918:
                        if (nextName.equals("alpha")) {
                            c = 6;
                            break;
                        }
                        break;
                }
                while (jsonReader.hasNext()) {
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(i, i2, str, str2, str3, z);
                map2.put(lottieImageAsset.getId(), lottieImageAsset);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font parse = FontParser.parse(jsonReader);
                    map.put(parse.getName(), parse);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter parse = FontCharacterParser.parse(jsonReader, lottieComposition);
            sparseArrayCompat.put(parse.hashCode(), parse);
        }
        jsonReader.endArray();
    }
}
