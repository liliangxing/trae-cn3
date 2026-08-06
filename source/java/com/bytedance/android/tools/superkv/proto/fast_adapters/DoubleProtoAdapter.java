package com.bytedance.android.tools.superkv.proto.fast_adapters;

import com.bytedance.android.tools.superkv.proto.FastProtoWriter;
import com.bytedance.android.tools.superkv.proto.ProtoReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DoubleProtoAdapter {
    private static final int FIELD_ENCODING = 1;

    private DoubleProtoAdapter() {
    }

    public static double decode(ProtoReader protoReader) throws IOException {
        return Double.longBitsToDouble(protoReader.readFixed64());
    }

    public static int encodedSizeWithTag(int i) {
        return FastProtoWriter.varint32Size((i << 3) | 0) + 8;
    }

    public static void encodeWithTag(FastProtoWriter fastProtoWriter, int i, double d) {
        fastProtoWriter.writeVarint32((i << 3) | 1);
        fastProtoWriter.writeFixed64(Double.doubleToLongBits(d));
    }
}
