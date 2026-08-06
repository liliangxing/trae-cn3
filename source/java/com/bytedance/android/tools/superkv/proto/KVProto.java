package com.bytedance.android.tools.superkv.proto;

import com.bytedance.android.tools.superkv.FastBufferedSource;
import com.bytedance.android.tools.superkv.proto.fast_adapters.BooleanProtoAdapter;
import com.bytedance.android.tools.superkv.proto.fast_adapters.BytesProtoAdapter;
import com.bytedance.android.tools.superkv.proto.fast_adapters.DoubleProtoAdapter;
import com.bytedance.android.tools.superkv.proto.fast_adapters.FloatProtoAdapter;
import com.bytedance.android.tools.superkv.proto.fast_adapters.Int32ProtoAdapter;
import com.bytedance.android.tools.superkv.proto.fast_adapters.Int64ProtoAdapter;
import com.bytedance.android.tools.superkv.proto.fast_adapters.StringProtoAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final class KVProto {
    public static final int TAG_BOOLEAN = 3;
    public static final int TAG_BYTES = 9;
    public static final int TAG_DOUBLE = 7;
    public static final int TAG_FLOAT = 6;
    public static final int TAG_INTEGER = 4;
    private static final int TAG_KEY = 1;
    public static final int TAG_LONG = 5;
    public static final int TAG_STRING = 8;
    public static final int TAG_STRING_LIST = 10;
    private static final int TAG_TYPE = 2;
    public static final int TYPE_NOTHING = 0;
    public boolean booleanValue;
    public byte[] bytesValue;
    public double doubleValue;
    public float floatValue;
    public int intValue;
    public String key;
    public long longValue;
    public String stringValue;
    public int type;
    private transient int hashCode = 0;
    public volatile transient int size = 0;
    public List<String> stringListValue = new ArrayList();

    public void resetValues() {
        this.booleanValue = false;
        this.intValue = 0;
        this.longValue = 0L;
        this.floatValue = 0.0f;
        this.doubleValue = 0.0d;
        this.stringValue = null;
        this.bytesValue = null;
        this.stringListValue.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KVProto)) {
            return false;
        }
        KVProto kVProto = (KVProto) obj;
        return equals(this.key, kVProto.key) && equals(Integer.valueOf(this.type), Integer.valueOf(kVProto.type)) && equals(Boolean.valueOf(this.booleanValue), Boolean.valueOf(kVProto.booleanValue)) && equals(Integer.valueOf(this.intValue), Integer.valueOf(kVProto.intValue)) && equals(Long.valueOf(this.longValue), Long.valueOf(kVProto.longValue)) && equals(Float.valueOf(this.floatValue), Float.valueOf(kVProto.floatValue)) && equals(Double.valueOf(this.doubleValue), Double.valueOf(kVProto.doubleValue)) && equals(this.stringValue, kVProto.stringValue) && Arrays.equals(this.bytesValue, kVProto.bytesValue) && this.stringListValue.equals(kVProto.stringListValue);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((this.key.hashCode() * 37) + this.type) * 37) + (this.booleanValue ? 1231 : 1237)) * 37) + this.intValue) * 37;
        long j = this.longValue;
        int floatToIntBits = ((hashCode + ((int) (j ^ (j >>> 32)))) * 37) + Float.floatToIntBits(this.floatValue);
        long doubleToLongBits = Double.doubleToLongBits(this.doubleValue);
        int i2 = ((floatToIntBits * 37) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 37;
        String str = this.stringValue;
        int hashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 37;
        byte[] bArr = this.bytesValue;
        int hashCode3 = ((hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 37) + this.stringListValue.hashCode();
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public String toString() {
        return "KVProto{ key=" + this.key + ", type=" + this.type + ", booleanValue=" + this.booleanValue + ", intValue=" + this.intValue + ", longValue=" + this.longValue + ", floatValue=" + this.floatValue + ", doubleValue=" + this.doubleValue + ", stringValue=" + this.stringValue + ", bytesValue=" + Arrays.toString(this.bytesValue) + ", stringListValue=" + this.stringListValue + " }";
    }

    /* loaded from: classes3.dex */
    public static final class Adapter {
        private Adapter() {
        }

        public static int encodedSize(KVProto kVProto) {
            int encodedSizeWithTag;
            int encodedSizeWithTag2 = Int32ProtoAdapter.encodedSizeWithTag(2, kVProto.type) + StringProtoAdapter.encodedSizeWithTag(1, kVProto.key);
            if (kVProto.type == 0) {
                return encodedSizeWithTag2;
            }
            switch (kVProto.type) {
                case 2:
                    encodedSizeWithTag = Int32ProtoAdapter.encodedSizeWithTag(2, kVProto.type);
                    break;
                case 3:
                    encodedSizeWithTag = BooleanProtoAdapter.encodedSizeWithTag(3);
                    break;
                case 4:
                    encodedSizeWithTag = Int32ProtoAdapter.encodedSizeWithTag(4, kVProto.intValue);
                    break;
                case 5:
                    encodedSizeWithTag = Int64ProtoAdapter.encodedSizeWithTag(5, kVProto.longValue);
                    break;
                case 6:
                    encodedSizeWithTag = FloatProtoAdapter.encodedSizeWithTag(6);
                    break;
                case 7:
                    encodedSizeWithTag = DoubleProtoAdapter.encodedSizeWithTag(7);
                    break;
                case 8:
                    encodedSizeWithTag = StringProtoAdapter.encodedSizeWithTag(8, kVProto.stringValue);
                    break;
                case 9:
                    encodedSizeWithTag = BytesProtoAdapter.encodedSizeWithTag(9, kVProto.bytesValue);
                    break;
                case 10:
                    encodedSizeWithTag = StringProtoAdapter.encodedSizeWithTag(10, kVProto.stringListValue);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown type!");
            }
            return encodedSizeWithTag2 + encodedSizeWithTag;
        }

        public static String fastGetKey(FastBufferedSource fastBufferedSource) throws IOException {
            int nextTag;
            ProtoReader protoReader = new ProtoReader(fastBufferedSource);
            protoReader.beginMessage();
            do {
                nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    throw new IllegalArgumentException("No key found in proto");
                }
            } while (nextTag != 1);
            return protoReader.readString();
        }

        public static void fastEncode(FastProtoWriter fastProtoWriter, KVProto kVProto) {
            StringProtoAdapter.encodeWithTag(fastProtoWriter, 1, kVProto.key);
            if (kVProto.type == 0) {
                return;
            }
            Int32ProtoAdapter.encodeWithTag(fastProtoWriter, 2, kVProto.type);
            switch (kVProto.type) {
                case 3:
                    BooleanProtoAdapter.encodeWithTag(fastProtoWriter, 3, kVProto.booleanValue);
                    return;
                case 4:
                    Int32ProtoAdapter.encodeWithTag(fastProtoWriter, 4, kVProto.intValue);
                    return;
                case 5:
                    Int64ProtoAdapter.encodeWithTag(fastProtoWriter, 5, kVProto.longValue);
                    return;
                case 6:
                    FloatProtoAdapter.encodeWithTag(fastProtoWriter, 6, kVProto.floatValue);
                    return;
                case 7:
                    DoubleProtoAdapter.encodeWithTag(fastProtoWriter, 7, kVProto.doubleValue);
                    return;
                case 8:
                    StringProtoAdapter.encodeWithTag(fastProtoWriter, 8, kVProto.stringValue);
                    return;
                case 9:
                    BytesProtoAdapter.encodeWithTag(fastProtoWriter, 9, kVProto.bytesValue);
                    return;
                case 10:
                    StringProtoAdapter.encodeWithTag(fastProtoWriter, 10, kVProto.stringListValue);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type!");
            }
        }

        public static KVProto fastDecode(ProtoReader protoReader, KVProto kVProto) throws IOException {
            protoReader.beginMessage();
            kVProto.stringListValue.clear();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    return kVProto;
                }
                switch (nextTag) {
                    case 1:
                        kVProto.key = protoReader.readString();
                        break;
                    case 2:
                        kVProto.type = protoReader.readVarint32();
                        if (kVProto.type != 0) {
                            break;
                        } else {
                            return kVProto;
                        }
                    case 3:
                        kVProto.booleanValue = protoReader.readVarint32() == 1;
                        return kVProto;
                    case 4:
                        kVProto.intValue = protoReader.readVarint32();
                        return kVProto;
                    case 5:
                        kVProto.longValue = protoReader.readVarint64();
                        return kVProto;
                    case 6:
                        kVProto.floatValue = Float.intBitsToFloat(protoReader.readFixed32());
                        return kVProto;
                    case 7:
                        kVProto.doubleValue = Double.longBitsToDouble(protoReader.readFixed64());
                        return kVProto;
                    case 8:
                        kVProto.stringValue = protoReader.readString();
                        return kVProto;
                    case 9:
                        kVProto.bytesValue = protoReader.readByteArray();
                        return kVProto;
                    case 10:
                        kVProto.stringListValue.add(protoReader.readString());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected tag: " + nextTag);
                }
            }
        }
    }

    public static String getTypeString(Integer num) {
        if (num == null) {
            return null;
        }
        switch (num.intValue()) {
            case 2:
                return "TYPE";
            case 3:
                return "Boolean";
            case 4:
                return "Integer";
            case 5:
                return "Long";
            case 6:
                return "Float";
            case 7:
                return "Double";
            case 8:
                return "String";
            case 9:
                return "Bytes";
            case 10:
                return "StringList";
            default:
                return "UNKNOWN";
        }
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
