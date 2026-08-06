package com.bytedance.android.tools.superkv.proto.fast_adapters;

import com.bytedance.android.tools.superkv.proto.FastProtoWriter;
import com.bytedance.android.tools.superkv.proto.ProtoReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FloatProtoAdapter {
    private static final int FIELD_ENCODING = 5;

    private FloatProtoAdapter() {
    }

    public static float decode(ProtoReader protoReader) throws IOException {
        return Float.intBitsToFloat(protoReader.readFixed32());
    }

    public static int encodedSizeWithTag(int i) {
        return FastProtoWriter.varint32Size((i << 3) | 0) + 4;
    }

    public static void encodeWithTag(FastProtoWriter fastProtoWriter, int i, float f) {
        fastProtoWriter.writeVarint32((i << 3) | 5);
        fastProtoWriter.writeFixed32(Float.floatToIntBits(f));
    }
}
