package com.bytedance.lottie.parser;

import android.util.JsonReader;
import com.bytedance.geckox.utils.GeckoSDK;
import com.bytedance.lottie.model.DocumentData;
import java.io.IOException;

/* loaded from: classes4.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();

    private DocumentDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0029. Please report as an issue. */
    @Override // com.bytedance.lottie.parser.ValueParser
    public DocumentData parse(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 102:
                    if (nextName.equals("f")) {
                        c = 0;
                        break;
                    }
                    break;
                case 106:
                    if (nextName.equals("j")) {
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
                case 116:
                    if (nextName.equals("t")) {
                        c = 3;
                        break;
                    }
                    break;
                case GeckoSDK.GECKO_SDK_AID_OVERSEA /* 3261 */:
                    if (nextName.equals("fc")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3452:
                    if (nextName.equals("lh")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3463:
                    if (nextName.equals("ls")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3543:
                    if (nextName.equals("of")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str2 = jsonReader.nextString();
                    break;
                case 1:
                    i = jsonReader.nextInt();
                    break;
                case 2:
                    d = jsonReader.nextDouble();
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    i3 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 5:
                    d2 = jsonReader.nextDouble();
                    break;
                case 6:
                    d3 = jsonReader.nextDouble();
                    break;
                case 7:
                    z = jsonReader.nextBoolean();
                    break;
                case '\b':
                    i4 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case '\t':
                    d4 = jsonReader.nextDouble();
                    break;
                case '\n':
                    i2 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new DocumentData(str, str2, d, i, i2, d2, d3, i3, i4, d4, z);
    }
}
