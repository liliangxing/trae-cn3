package com.bytedance.common.wschannel.model;

import com.bytedance.applog.server.Api;
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

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Frame extends Message<Frame, Builder> {
    public static final String DEFAULT_LOGIDNEW = "";
    public static final String DEFAULT_MSGID = "";
    public static final String DEFAULT_PAYLOAD_ENCODING = "";
    public static final String DEFAULT_PAYLOAD_TYPE = "";
    public static final String DEFAULT_SERVERTIMING = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.article.wschannel.model.Frame$ExtendedEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ExtendedEntry> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String logidnew;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String msgId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payload_encoding;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payload_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long seqid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String serverTiming;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    public final Integer service;
    public static final ProtoAdapter<Frame> ADAPTER = new ProtoAdapter_Frame();
    public static final Long DEFAULT_SEQID = 0L;
    public static final Long DEFAULT_LOGID = 0L;
    public static final Integer DEFAULT_SERVICE = 0;
    public static final Integer DEFAULT_METHOD = 0;
    public static final ByteString DEFAULT_PAYLOAD = ByteString.EMPTY;

    public Frame(Long l, Long l2, Integer num, Integer num2, List<ExtendedEntry> list, String str, String str2, ByteString byteString, String str3, String str4, String str5) {
        this(l, l2, num, num2, list, str, str2, byteString, str3, str4, str5, ByteString.EMPTY);
    }

    public Frame(Long l, Long l2, Integer num, Integer num2, List<ExtendedEntry> list, String str, String str2, ByteString byteString, String str3, String str4, String str5, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.seqid = l;
        this.logid = l2;
        this.service = num;
        this.method = num2;
        this.headers = Internal.immutableCopyOf("headers", list);
        this.payload_encoding = str;
        this.payload_type = str2;
        this.payload = byteString;
        this.logidnew = str3;
        this.serverTiming = str4;
        this.msgId = str5;
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m443newBuilder() {
        Builder builder = new Builder();
        builder.seqid = this.seqid;
        builder.logid = this.logid;
        builder.service = this.service;
        builder.method = this.method;
        builder.headers = Internal.copyOf("headers", this.headers);
        builder.payload_encoding = this.payload_encoding;
        builder.payload_type = this.payload_type;
        builder.payload = this.payload;
        builder.logidnew = this.logidnew;
        builder.serverTiming = this.serverTiming;
        builder.msgId = this.msgId;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Frame)) {
            return false;
        }
        Frame frame = (Frame) obj;
        return Internal.equals(unknownFields(), frame.unknownFields()) && Internal.equals(this.seqid, frame.seqid) && Internal.equals(this.logid, frame.logid) && Internal.equals(this.service, frame.service) && Internal.equals(this.method, frame.method) && Internal.equals(this.headers, frame.headers) && Internal.equals(this.payload_encoding, frame.payload_encoding) && Internal.equals(this.payload_type, frame.payload_type) && Internal.equals(this.payload, frame.payload) && Internal.equals(this.logidnew, frame.logidnew) && Internal.equals(this.serverTiming, frame.serverTiming) && Internal.equals(this.msgId, frame.msgId);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Long l = this.seqid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.logid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.service;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.method;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<ExtendedEntry> list = this.headers;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.payload_encoding;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.payload_type;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        ByteString byteString = this.payload;
        int hashCode9 = (hashCode8 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str3 = this.logidnew;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.serverTiming;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.msgId;
        int hashCode12 = hashCode11 + (str5 != null ? str5.hashCode() : 0);
        ((Message) this).hashCode = hashCode12;
        return hashCode12;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.seqid != null) {
            sb.append(", seqid=").append(this.seqid);
        }
        if (this.logid != null) {
            sb.append(", logid=").append(this.logid);
        }
        if (this.service != null) {
            sb.append(", service=").append(this.service);
        }
        if (this.method != null) {
            sb.append(", method=").append(this.method);
        }
        if (this.headers != null) {
            sb.append(", headers=").append(this.headers);
        }
        if (this.payload_encoding != null) {
            sb.append(", payload_encoding=").append(this.payload_encoding);
        }
        if (this.payload_type != null) {
            sb.append(", payload_type=").append(this.payload_type);
        }
        if (this.payload != null) {
            sb.append(", payload=").append(this.payload);
        }
        if (this.logidnew != null) {
            sb.append(", logidnew=").append(this.logidnew);
        }
        if (this.serverTiming != null) {
            sb.append(", serverTiming=").append(this.serverTiming);
        }
        if (this.msgId != null) {
            sb.append(", msgId=").append(this.msgId);
        }
        return sb.replace(0, 2, "Frame{").append('}').toString();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Builder extends Message.Builder<Frame, Builder> {
        public List<ExtendedEntry> headers = Internal.newMutableList();
        public Long logid;
        public String logidnew;
        public Integer method;
        public String msgId;
        public ByteString payload;
        public String payload_encoding;
        public String payload_type;
        public Long seqid;
        public String serverTiming;
        public Integer service;

        public Builder seqid(Long l) {
            this.seqid = l;
            return this;
        }

        public Builder logid(Long l) {
            this.logid = l;
            return this;
        }

        public Builder service(Integer num) {
            this.service = num;
            return this;
        }

        public Builder method(Integer num) {
            this.method = num;
            return this;
        }

        public Builder headers(List<ExtendedEntry> list) {
            Internal.checkElementsNotNull(list);
            this.headers = list;
            return this;
        }

        public Builder payload_encoding(String str) {
            this.payload_encoding = str;
            return this;
        }

        public Builder payload_type(String str) {
            this.payload_type = str;
            return this;
        }

        public Builder payload(ByteString byteString) {
            this.payload = byteString;
            return this;
        }

        public Builder logidnew(String str) {
            this.logidnew = str;
            return this;
        }

        public Builder serverTiming(String str) {
            this.serverTiming = str;
            return this;
        }

        public Builder msgId(String str) {
            this.msgId = str;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public Frame m444build() {
            Long l = this.seqid;
            if (l == null || this.logid == null || this.service == null || this.method == null) {
                throw Internal.missingRequiredFields(new Object[]{l, "seqid", this.logid, "logid", this.service, "service", this.method, "method"});
            }
            return new Frame(this.seqid, this.logid, this.service, this.method, this.headers, this.payload_encoding, this.payload_type, this.payload, this.logidnew, this.serverTiming, this.msgId, buildUnknownFields());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class ExtendedEntry extends Message<ExtendedEntry, Builder> {
        public static final ProtoAdapter<ExtendedEntry> ADAPTER = new ProtoAdapter_ExtendedEntry();
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String key;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
        public final String value;

        public ExtendedEntry(String str, String str2) {
            this(str, str2, ByteString.EMPTY);
        }

        public ExtendedEntry(String str, String str2, ByteString byteString) {
            super(ADAPTER, byteString);
            this.key = str;
            this.value = str2;
        }

        /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
        public Builder m445newBuilder() {
            Builder builder = new Builder();
            builder.key = this.key;
            builder.value = this.value;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ExtendedEntry)) {
                return false;
            }
            ExtendedEntry extendedEntry = (ExtendedEntry) obj;
            return Internal.equals(unknownFields(), extendedEntry.unknownFields()) && Internal.equals(this.key, extendedEntry.key) && Internal.equals(this.value, extendedEntry.value);
        }

        public int hashCode() {
            int i = ((Message) this).hashCode;
            if (i != 0) {
                return i;
            }
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.key;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.value;
            int hashCode3 = hashCode2 + (str2 != null ? str2.hashCode() : 0);
            ((Message) this).hashCode = hashCode3;
            return hashCode3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.key != null) {
                sb.append(", key=").append(this.key);
            }
            if (this.value != null) {
                sb.append(", value=").append(this.value);
            }
            return sb.replace(0, 2, "ExtendedEntry{").append('}').toString();
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final class Builder extends Message.Builder<ExtendedEntry, Builder> {
            public String key;
            public String value;

            public Builder key(String str) {
                this.key = str;
                return this;
            }

            public Builder value(String str) {
                this.value = str;
                return this;
            }

            /* renamed from: build, reason: merged with bridge method [inline-methods] */
            public ExtendedEntry m446build() {
                String str = this.key;
                if (str == null || this.value == null) {
                    throw Internal.missingRequiredFields(new Object[]{str, Api.KEY_ENCRYPT_RESP_KEY, this.value, "value"});
                }
                return new ExtendedEntry(this.key, this.value, buildUnknownFields());
            }
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        private static final class ProtoAdapter_ExtendedEntry extends ProtoAdapter<ExtendedEntry> {
            ProtoAdapter_ExtendedEntry() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtendedEntry.class);
            }

            public int encodedSize(ExtendedEntry extendedEntry) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, extendedEntry.key) + ProtoAdapter.STRING.encodedSizeWithTag(2, extendedEntry.value) + extendedEntry.unknownFields().size();
            }

            public void encode(ProtoWriter protoWriter, ExtendedEntry extendedEntry) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, extendedEntry.key);
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, extendedEntry.value);
                protoWriter.writeBytes(extendedEntry.unknownFields());
            }

            /* renamed from: decode, reason: merged with bridge method [inline-methods] */
            public ExtendedEntry m447decode(ProtoReader protoReader) throws IOException {
                Builder builder = new Builder();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return builder.m446build();
                    }
                    if (nextTag == 1) {
                        builder.key((String) ProtoAdapter.STRING.decode(protoReader));
                    } else if (nextTag == 2) {
                        builder.value((String) ProtoAdapter.STRING.decode(protoReader));
                    } else {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    }
                }
            }

            public ExtendedEntry redact(ExtendedEntry extendedEntry) {
                Builder m445newBuilder = extendedEntry.m445newBuilder();
                m445newBuilder.clearUnknownFields();
                return m445newBuilder.m446build();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class ProtoAdapter_Frame extends ProtoAdapter<Frame> {
        ProtoAdapter_Frame() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }

        public int encodedSize(Frame frame) {
            return ProtoAdapter.UINT64.encodedSizeWithTag(1, frame.seqid) + ProtoAdapter.UINT64.encodedSizeWithTag(2, frame.logid) + ProtoAdapter.INT32.encodedSizeWithTag(3, frame.service) + ProtoAdapter.INT32.encodedSizeWithTag(4, frame.method) + ExtendedEntry.ADAPTER.asRepeated().encodedSizeWithTag(5, frame.headers) + (frame.payload_encoding != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, frame.payload_encoding) : 0) + (frame.payload_type != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, frame.payload_type) : 0) + (frame.payload != null ? ProtoAdapter.BYTES.encodedSizeWithTag(8, frame.payload) : 0) + (frame.logidnew != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, frame.logidnew) : 0) + (frame.serverTiming != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, frame.serverTiming) : 0) + (frame.msgId != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, frame.msgId) : 0) + frame.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, Frame frame) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 1, frame.seqid);
            ProtoAdapter.UINT64.encodeWithTag(protoWriter, 2, frame.logid);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, frame.service);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, frame.method);
            if (frame.headers != null) {
                ExtendedEntry.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, frame.headers);
            }
            if (frame.payload_encoding != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, frame.payload_encoding);
            }
            if (frame.payload_type != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, frame.payload_type);
            }
            if (frame.payload != null) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 8, frame.payload);
            }
            if (frame.logidnew != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, frame.logidnew);
            }
            if (frame.serverTiming != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, frame.serverTiming);
            }
            if (frame.msgId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, frame.msgId);
            }
            protoWriter.writeBytes(frame.unknownFields());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Frame m448decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.seqid((Long) ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 2:
                            builder.logid((Long) ProtoAdapter.UINT64.decode(protoReader));
                            break;
                        case 3:
                            builder.service((Integer) ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 4:
                            builder.method((Integer) ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 5:
                            builder.headers.add(ExtendedEntry.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            builder.payload_encoding((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.payload_type((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            builder.payload((ByteString) ProtoAdapter.BYTES.decode(protoReader));
                            break;
                        case 9:
                            builder.logidnew((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.serverTiming((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.msgId((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.m444build();
                }
            }
        }

        public Frame redact(Frame frame) {
            Builder m443newBuilder = frame.m443newBuilder();
            Internal.redactElements(m443newBuilder.headers, ExtendedEntry.ADAPTER);
            m443newBuilder.clearUnknownFields();
            return m443newBuilder.m444build();
        }
    }
}
