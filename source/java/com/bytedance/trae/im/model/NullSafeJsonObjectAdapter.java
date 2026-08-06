package com.bytedance.trae.im.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/im/model/NullSafeJsonObjectAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/google/gson/JsonObject;", "<init>", "()V", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NullSafeJsonObjectAdapter extends TypeAdapter<JsonObject> {
    public void write(JsonWriter out, JsonObject value) {
        Intrinsics.checkNotNullParameter(out, "out");
        if (value == null) {
            out.nullValue();
        } else {
            Streams.write((JsonElement) value, out);
        }
    }

    /* renamed from: read, reason: merged with bridge method [inline-methods] */
    public JsonObject m2582read(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        JsonObject parse = Streams.parse(reader);
        if (parse instanceof JsonObject) {
            return parse;
        }
        return null;
    }
}
