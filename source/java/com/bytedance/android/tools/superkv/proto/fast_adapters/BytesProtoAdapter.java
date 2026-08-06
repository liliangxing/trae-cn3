package com.bytedance.android.tools.superkv.proto.fast_adapters;

import com.bytedance.android.tools.superkv.proto.FastProtoWriter;
import com.bytedance.android.tools.superkv.proto.ProtoReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class BytesProtoAdapter {
    private static final int FIELD_ENCODING = 2;

    private BytesProtoAdapter() {
    }

    public static byte[] decode(ProtoReader protoReader) throws IOException {
        return protoReader.readByteArray();
    }

    public static int encodedSizeWithTag(int i, byte[] bArr) {
        int length = bArr.length;
        return length + FastProtoWriter.varint32Size(length) + FastProtoWriter.varint32Size((i << 3) | 0);
    }

    public static void encodeWithTag(FastProtoWriter fastProtoWriter, int i, byte[] bArr) {
        fastProtoWriter.writeVarint32((i << 3) | 2);
        fastProtoWriter.writeVarint32(bArr.length);
        fastProtoWriter.writeByteArray(bArr);
    }
}
