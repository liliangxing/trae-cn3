package com.bytedance.android.tools.superkv.proto.fast_adapters;

import com.bytedance.android.tools.superkv.proto.FastProtoWriter;
import com.bytedance.android.tools.superkv.proto.ProtoReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class StringProtoAdapter {
    private static final int FIELD_ENCODING = 2;

    private StringProtoAdapter() {
    }

    public static String decode(ProtoReader protoReader) throws IOException {
        return protoReader.readString();
    }

    public static int encodedSizeWithTag(int i, String str) {
        int utf8Length = FastProtoWriter.utf8Length(str);
        return utf8Length + FastProtoWriter.varint32Size(utf8Length) + FastProtoWriter.varint32Size((i << 3) | 0);
    }

    public static void encodeWithTag(FastProtoWriter fastProtoWriter, int i, String str) {
        fastProtoWriter.writeVarint32((i << 3) | 2);
        fastProtoWriter.writeVarint32(FastProtoWriter.utf8Length(str));
        fastProtoWriter.writeString(str);
    }

    public static int encodedSizeWithTag(int i, List<String> list) {
        Iterator<String> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += encodedSizeWithTag(i, it.next());
        }
        return i2;
    }

    public static void encodeWithTag(FastProtoWriter fastProtoWriter, int i, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            encodeWithTag(fastProtoWriter, i, it.next());
        }
    }
}
