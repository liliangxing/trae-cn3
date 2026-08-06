package com.bytedance.android.tools.superkv.proto.fast_adapters;

import com.bytedance.android.tools.superkv.proto.FastProtoWriter;
import com.bytedance.android.tools.superkv.proto.ProtoReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class Int64ProtoAdapter {
    private static final int FIELD_ENCODING = 0;

    private Int64ProtoAdapter() {
    }

    public static long decode(ProtoReader protoReader) throws IOException {
        return protoReader.readVarint64();
    }

    public static int encodedSizeWithTag(int i, long j) {
        return FastProtoWriter.varint64Size(j) + FastProtoWriter.varint32Size((i << 3) | 0);
    }

    public static void encodeWithTag(FastProtoWriter fastProtoWriter, int i, long j) {
        fastProtoWriter.writeVarint32((i << 3) | 0);
        fastProtoWriter.writeVarint64(j);
    }
}
