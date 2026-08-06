package com.bytedance.android.jsonopt;

import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes2.dex */
public class JsonOptUtil {
    public static String[] optJSONDataWithKeyAry(String[] strArr, String str) throws IOException {
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        jsonReader.setLenient(true);
        return jsonReader.moveAnchorHorizontal(strArr, str);
    }

    public static String optJSONData(String str, String str2) throws IOException {
        return optJSONData(new String[]{str}, str2);
    }

    public static String optJSONData(String[] strArr, String str) throws IOException {
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        jsonReader.setLenient(true);
        jsonReader.moveAnchor(strArr, 0);
        return (jsonReader.startIndex == -1 || jsonReader.endIndex == -1 || jsonReader.endIndex < jsonReader.startIndex || jsonReader.endIndex >= str.length()) ? "" : str.substring(jsonReader.startIndex, jsonReader.endIndex);
    }
}
