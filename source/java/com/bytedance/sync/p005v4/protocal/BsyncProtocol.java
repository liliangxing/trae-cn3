package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BsyncProtocol extends Message<BsyncProtocol, Builder> {
    public static final ProtoAdapter<BsyncProtocol> ADAPTER = new ProtoAdapter_BsyncProtocol();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.BsyncHeader#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final BsyncHeader header;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.BsyncTopic#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<BsyncTopic> topics;

    public BsyncProtocol(BsyncHeader bsyncHeader, List<BsyncTopic> list) {
        this(bsyncHeader, list, ByteString.EMPTY);
    }

    public BsyncProtocol(BsyncHeader bsyncHeader, List<BsyncTopic> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.header = bsyncHeader;
        this.topics = Internal.immutableCopyOf("topics", list);
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m1003newBuilder() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.topics = Internal.copyOf("topics", this.topics);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BsyncProtocol)) {
            return false;
        }
        BsyncProtocol bsyncProtocol = (BsyncProtocol) obj;
        return unknownFields().equals(bsyncProtocol.unknownFields()) && this.header.equals(bsyncProtocol.header) && this.topics.equals(bsyncProtocol.topics);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.topics.hashCode();
        ((Message) this).hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=").append(this.header);
        if (!this.topics.isEmpty()) {
            sb.append(", topics=").append(this.topics);
        }
        return sb.replace(0, 2, "BsyncProtocol{").append('}').toString();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Builder extends Message.Builder<BsyncProtocol, Builder> {
        public BsyncHeader header;
        public List<BsyncTopic> topics = Internal.newMutableList();

        public Builder header(BsyncHeader bsyncHeader) {
            this.header = bsyncHeader;
            return this;
        }

        public Builder topics(List<BsyncTopic> list) {
            Internal.checkElementsNotNull(list);
            this.topics = list;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public BsyncProtocol m1004build() {
            BsyncHeader bsyncHeader = this.header;
            if (bsyncHeader == null) {
                throw Internal.missingRequiredFields(new Object[]{bsyncHeader, "header"});
            }
            return new BsyncProtocol(this.header, this.topics, super.buildUnknownFields());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ProtoAdapter_BsyncProtocol extends ProtoAdapter<BsyncProtocol> {
        public ProtoAdapter_BsyncProtocol() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncProtocol.class);
        }

        public int encodedSize(BsyncProtocol bsyncProtocol) {
            return BsyncHeader.ADAPTER.encodedSizeWithTag(1, bsyncProtocol.header) + BsyncTopic.ADAPTER.asRepeated().encodedSizeWithTag(2, bsyncProtocol.topics) + bsyncProtocol.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, BsyncProtocol bsyncProtocol) throws IOException {
            BsyncHeader.ADAPTER.encodeWithTag(protoWriter, 1, bsyncProtocol.header);
            BsyncTopic.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, bsyncProtocol.topics);
            protoWriter.writeBytes(bsyncProtocol.unknownFields());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BsyncProtocol m1005decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m1004build();
                }
                if (nextTag == 1) {
                    builder.header((BsyncHeader) BsyncHeader.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.topics.add(BsyncTopic.ADAPTER.decode(protoReader));
                } else {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                }
            }
        }

        public BsyncProtocol redact(BsyncProtocol bsyncProtocol) {
            Builder m1003newBuilder = bsyncProtocol.m1003newBuilder();
            m1003newBuilder.header = (BsyncHeader) BsyncHeader.ADAPTER.redact(m1003newBuilder.header);
            Internal.redactElements(m1003newBuilder.topics, BsyncTopic.ADAPTER);
            m1003newBuilder.clearUnknownFields();
            return m1003newBuilder.m1004build();
        }
    }
}
