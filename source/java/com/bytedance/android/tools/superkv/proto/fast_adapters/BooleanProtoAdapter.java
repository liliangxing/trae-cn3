package com.bytedance.android.tools.superkv.proto.fast_adapters;

import com.bytedance.android.tools.superkv.proto.FastProtoWriter;
import com.bytedance.android.tools.superkv.proto.ProtoReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class BooleanProtoAdapter {
    private static final int ENCODED_SIZE = 1;
    private static final int FIELD_ENCODING = 0;

    private BooleanProtoAdapter() {
    }

    public static boolean decode(ProtoReader protoReader) throws IOException {
        int readVarint32 = protoReader.readVarint32();
        if (readVarint32 == 0) {
            return false;
        }
        if (readVarint32 == 1) {
            return true;
        }
        throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(readVarint32)));
    }

    public static int encodedSizeWithTag(int i) {
        return FastProtoWriter.varint32Size((i << 3) | 0) + 1;
    }

    public static void encodeWithTag(FastProtoWriter fastProtoWriter, int i, boolean z) {
        fastProtoWriter.writeVarint32((i << 3) | 0);
        fastProtoWriter.writeVarint32(z ? 1 : 0);
    }
}
