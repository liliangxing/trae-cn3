package com.bytedance.sync.v4.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.ByteString;

/* loaded from: classes5.dex */
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
        this.topics = Internal.immutableCopyOf(Constants.EXTRA_KEY_TOPICS, list);
    }

    @Override // com.squareup.wire.Message
    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Message.Builder<BsyncProtocol, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.header = this.header;
        builder.topics = Internal.copyOf(Constants.EXTRA_KEY_TOPICS, this.topics);
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
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.topics.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", header=").append(this.header);
        if (!this.topics.isEmpty()) {
            sb.append(", topics=").append(this.topics);
        }
        return sb.replace(0, 2, "BsyncProtocol{").append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    /* loaded from: classes5.dex */
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

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public BsyncProtocol build() {
            BsyncHeader bsyncHeader = this.header;
            if (bsyncHeader == null) {
                throw Internal.missingRequiredFields(bsyncHeader, "header");
            }
            return new BsyncProtocol(this.header, this.topics, super.buildUnknownFields());
        }
    }

    /* loaded from: classes5.dex */
    private static final class ProtoAdapter_BsyncProtocol extends ProtoAdapter<BsyncProtocol> {
        public ProtoAdapter_BsyncProtocol() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncProtocol.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public int encodedSize(BsyncProtocol bsyncProtocol) {
            return BsyncHeader.ADAPTER.encodedSizeWithTag(1, bsyncProtocol.header) + BsyncTopic.ADAPTER.asRepeated().encodedSizeWithTag(2, bsyncProtocol.topics) + bsyncProtocol.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, BsyncProtocol bsyncProtocol) throws IOException {
            BsyncHeader.ADAPTER.encodeWithTag(protoWriter, 1, bsyncProtocol.header);
            BsyncTopic.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, bsyncProtocol.topics);
            protoWriter.writeBytes(bsyncProtocol.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BsyncProtocol decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.header(BsyncHeader.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.topics.add(BsyncTopic.ADAPTER.decode(protoReader));
                } else {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                }
            }
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.sync.v4.protocal.BsyncProtocol$Builder] */
        @Override // com.squareup.wire.ProtoAdapter
        public BsyncProtocol redact(BsyncProtocol bsyncProtocol) {
            ?? newBuilder2 = bsyncProtocol.newBuilder2();
            newBuilder2.header = BsyncHeader.ADAPTER.redact(newBuilder2.header);
            Internal.redactElements(newBuilder2.topics, BsyncTopic.ADAPTER);
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
