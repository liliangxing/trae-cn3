package com.bytedance.geckox.gson;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BooleanTypeAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/geckox/gson/BooleanTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Boolean;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Boolean;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BooleanTypeAdapter extends TypeAdapter<Boolean> {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[JsonToken.BOOLEAN.ordinal()] = 1;
            iArr[JsonToken.NULL.ordinal()] = 2;
            iArr[JsonToken.NUMBER.ordinal()] = 3;
        }
    }

    public void write(JsonWriter out, Boolean value) throws IOException {
        Intrinsics.checkParameterIsNotNull(out, "out");
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.booleanValue());
        }
    }

    /* renamed from: read, reason: merged with bridge method [inline-methods] */
    public Boolean m544read(JsonReader reader) throws IOException {
        Intrinsics.checkParameterIsNotNull(reader, "reader");
        JsonToken peek = reader.peek();
        if (peek != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[peek.ordinal()];
            if (i == 1) {
                return Boolean.valueOf(reader.nextBoolean());
            }
            if (i == 2) {
                reader.nextNull();
                return null;
            }
            if (i == 3) {
                return Boolean.valueOf(reader.nextInt() != 0);
            }
        }
        throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + peek);
    }
}
