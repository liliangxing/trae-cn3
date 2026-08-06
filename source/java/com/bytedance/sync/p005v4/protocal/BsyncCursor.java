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
public final class BsyncCursor extends Message<BsyncCursor, Builder> {
    public static final ProtoAdapter<BsyncCursor> ADAPTER = new ProtoAdapter_BsyncCursor();
    public static final Long DEFAULT_CURSOR = 0L;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long cursor;

    public BsyncCursor(Long l) {
        this(l, ByteString.EMPTY);
    }

    public BsyncCursor(Long l, ByteString byteString) {
        super(ADAPTER, byteString);
        this.cursor = l;
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m991newBuilder() {
        Builder builder = new Builder();
        builder.cursor = this.cursor;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BsyncCursor)) {
            return false;
        }
        BsyncCursor bsyncCursor = (BsyncCursor) obj;
        return unknownFields().equals(bsyncCursor.unknownFields()) && this.cursor.equals(bsyncCursor.cursor);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = (unknownFields().hashCode() * 37) + this.cursor.hashCode();
        ((Message) this).hashCode = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", cursor=").append(this.cursor);
        return sb.replace(0, 2, "BsyncCursor{").append('}').toString();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Builder extends Message.Builder<BsyncCursor, Builder> {
        public Long cursor;

        public Builder cursor(Long l) {
            this.cursor = l;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public BsyncCursor m992build() {
            Long l = this.cursor;
            if (l == null) {
                throw Internal.missingRequiredFields(new Object[]{l, "cursor"});
            }
            return new BsyncCursor(this.cursor, super.buildUnknownFields());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ProtoAdapter_BsyncCursor extends ProtoAdapter<BsyncCursor> {
        public ProtoAdapter_BsyncCursor() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncCursor.class);
        }

        public int encodedSize(BsyncCursor bsyncCursor) {
            return ProtoAdapter.INT64.encodedSizeWithTag(1, bsyncCursor.cursor) + bsyncCursor.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, BsyncCursor bsyncCursor) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, bsyncCursor.cursor);
            protoWriter.writeBytes(bsyncCursor.unknownFields());
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BsyncCursor m993decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m992build();
                }
                if (nextTag == 1) {
                    builder.cursor((Long) ProtoAdapter.INT64.decode(protoReader));
                } else {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                }
            }
        }

        public BsyncCursor redact(BsyncCursor bsyncCursor) {
            Builder m991newBuilder = bsyncCursor.m991newBuilder();
            m991newBuilder.clearUnknownFields();
            return m991newBuilder.m992build();
        }
    }
}
