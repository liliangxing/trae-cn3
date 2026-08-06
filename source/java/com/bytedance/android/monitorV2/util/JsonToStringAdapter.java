package com.bytedance.android.monitorV2.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonToStringAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/monitorV2/util/JsonToStringAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", "readIn", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class JsonToStringAdapter extends TypeAdapter<String> {

    /* compiled from: JsonToStringAdapter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JsonToken.values().length];
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void write(JsonWriter out, String value) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        if (value == null) {
            out.nullValue();
        } else {
            TypeAdapters.JSON_ELEMENT.write(out, new JsonParser().parse(value));
        }
    }

    public String read(JsonReader readIn) throws IOException {
        Intrinsics.checkNotNullParameter(readIn, "readIn");
        JsonToken peek = readIn.peek();
        int i = peek == null ? -1 : WhenMappings.$EnumSwitchMapping$0[peek.ordinal()];
        if (i == 1) {
            readIn.nextNull();
            return null;
        }
        if (i == 2) {
            return readIn.nextString();
        }
        JsonElement parse = Streams.parse(readIn);
        if (parse != null) {
            return parse.toString();
        }
        return null;
    }
}
