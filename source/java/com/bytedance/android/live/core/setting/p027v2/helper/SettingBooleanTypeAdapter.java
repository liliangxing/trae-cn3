package com.bytedance.android.live.core.setting.p027v2.helper;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SettingBooleanTypeAdapter extends TypeAdapter<Boolean> {
    public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
        if (bool == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.android.live.core.setting.v2.helper.SettingBooleanTypeAdapter$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C08881 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: read, reason: merged with bridge method [inline-methods] */
    public Boolean m3472read(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        int i = C08881.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()];
        if (i == 1) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (i == 2) {
            jsonReader.nextNull();
            return null;
        }
        if (i == 3) {
            return Boolean.valueOf(jsonReader.nextInt() != 0);
        }
        throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + peek);
    }
}
