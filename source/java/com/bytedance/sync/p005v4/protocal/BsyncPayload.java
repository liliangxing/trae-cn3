package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BsyncPayload extends Message<BsyncPayload, Builder> {
    public static final ProtoAdapter<BsyncPayload> ADAPTER = new ProtoAdapter_BsyncPayload();
    public static final Integer DEFAULT_BUSINESS = 0;
    public static final ConsumeType DEFAULT_CONSUME_TYPE = ConsumeType.OneByOne;
    public static final ByteString DEFAULT_DATA = ByteString.EMPTY;
    public static final String DEFAULT_MD5 = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 1)
    public final Integer business;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.ConsumeType#ADAPTER", tag = 2)
    public final ConsumeType consume_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 4)
    public final ByteString data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String md5;

    public BsyncPayload(Integer num, ConsumeType consumeType, String str, ByteString byteString) {
        this(num, consumeType, str, byteString, ByteString.EMPTY);
    }

    public BsyncPayload(Integer num, ConsumeType consumeType, String str, ByteString byteString, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.business = num;
        this.consume_type = consumeType;
        this.md5 = str;
        this.data = byteString;
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m1000newBuilder() {
        Builder builder = new Builder();
        builder.business = this.business;
        builder.consume_type = this.consume_type;
        builder.md5 = this.md5;
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BsyncPayload)) {
            return false;
        }
        BsyncPayload bsyncPayload = (BsyncPayload) obj;
        return unknownFields().equals(bsyncPayload.unknownFields()) && this.business.equals(bsyncPayload.business) && Internal.equals(this.consume_type, bsyncPayload.consume_type) && Internal.equals(this.md5, bsyncPayload.md5) && Internal.equals(this.data, bsyncPayload.data);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((unknownFields().hashCode() * 37) + this.business.hashCode()) * 37;
        ConsumeType consumeType = this.consume_type;
        int hashCode2 = (hashCode + (consumeType != null ? consumeType.hashCode() : 0)) * 37;
        String str = this.md5;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        ByteString byteString = this.data;
        int hashCode4 = hashCode3 + (byteString != null ? byteString.hashCode() : 0);
        ((Message) this).hashCode = hashCode4;
        return hashCode4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", business=").append(this.business);
        if (this.consume_type != null) {
            sb.append(", consume_type=").append(this.consume_type);
        }
        if (this.md5 != null) {
            sb.append(", md5=").append(this.md5);
        }
        if (this.data != null) {
            sb.append(", data=").append(this.data);
        }
        return sb.replace(0, 2, "BsyncPayload{").append('}').toString();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Builder extends Message.Builder<BsyncPayload, Builder> {
        public Integer business;
        public ConsumeType consume_type;
        public ByteString data;
        public String md5;

        public Builder business(Integer num) {
            this.business = num;
            return this;
        }

        public Builder consume_type(ConsumeType consumeType) {
            this.consume_type = consumeType;
            return this;
        }

        public Builder md5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder data(ByteString byteString) {
            this.data = byteString;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public BsyncPayload m1001build() {
            Integer num = this.business;
            if (num == null) {
                throw Internal.missingRequiredFields(new Object[]{num, "business"});
            }
            return new BsyncPayload(this.business, this.consume_type, this.md5, this.data, super.buildUnknownFields());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ProtoAdapter_BsyncPayload extends ProtoAdapter<BsyncPayload> {
        public ProtoAdapter_BsyncPayload() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncPayload.class);
        }

        public int encodedSize(BsyncPayload bsyncPayload) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, bsyncPayload.business) + ConsumeType.ADAPTER.encodedSizeWithTag(2, bsyncPayload.consume_type) + ProtoAdapter.STRING.encodedSizeWithTag(3, bsyncPayload.md5) + ProtoAdapter.BYTES.encodedSizeWithTag(4, bsyncPayload.data) + bsyncPayload.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, BsyncPayload bsyncPayload) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, bsyncPayload.business);
            ConsumeType.ADAPTER.encodeWithTag(protoWriter, 2, bsyncPayload.consume_type);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, bsyncPayload.md5);
            ProtoAdapter.BYTES.encodeWithTag(protoWriter, 4, bsyncPayload.data);
            protoWriter.writeBytes(bsyncPayload.unknownFields());
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BsyncPayload m1002decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m1001build();
                }
                if (nextTag == 1) {
                    builder.business((Integer) ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    try {
                        builder.consume_type((ConsumeType) ConsumeType.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                        builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                    }
                } else if (nextTag == 3) {
                    builder.md5((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.data((ByteString) ProtoAdapter.BYTES.decode(protoReader));
                } else {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                }
            }
        }

        public BsyncPayload redact(BsyncPayload bsyncPayload) {
            Builder m1000newBuilder = bsyncPayload.m1000newBuilder();
            m1000newBuilder.clearUnknownFields();
            return m1000newBuilder.m1001build();
        }
    }
}
