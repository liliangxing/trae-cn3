package com.bytedance.android.tools.superkv.proto.fast_adapters;

import com.bytedance.android.tools.superkv.proto.FastProtoWriter;

/* loaded from: classes3.dex */
public class Int32ProtoAdapter {
    private static final int FIELD_ENCODING = 0;

    private Int32ProtoAdapter() {
    }

    public static int encodedSizeWithTag(int i, int i2) {
        return FastProtoWriter.int32Size(i2) + FastProtoWriter.varint32Size((i << 3) | 0);
    }

    public static void encodeWithTag(FastProtoWriter fastProtoWriter, int i, int i2) {
        fastProtoWriter.writeVarint32((i << 3) | 0);
        fastProtoWriter.writeSignedVarint32(i2);
    }
}
