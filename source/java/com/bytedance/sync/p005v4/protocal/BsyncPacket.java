package com.bytedance.sync.p005v4.protocal;

import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BsyncPacket extends Message<BsyncPacket, Builder> {
    public static final String DEFAULT_LOGID = "";
    public static final String DEFAULT_MSGID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.PacketCtrl#ADAPTER", tag = 5)
    public final PacketCtrl ctrl;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.BsyncCursor#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final BsyncCursor cursor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long expire_ts;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = StatusBarUtils.FLAG_NOTCH_SUPPORT)
    public final Map<String, String> extra;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String msgid;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.BsyncPayload#ADAPTER", tag = 2)
    public final BsyncPayload payload;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.PacketStatus#ADAPTER", tag = 3)
    public final PacketStatus status;

    /* renamed from: ts */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = ReducerConstants.REQUEST_CODE)
    public final Long f238ts;
    public static final ProtoAdapter<BsyncPacket> ADAPTER = new ProtoAdapter_BsyncPacket();
    public static final PacketStatus DEFAULT_STATUS = PacketStatus.Full;
    public static final Long DEFAULT_EXPIRE_TS = 0L;
    public static final PacketCtrl DEFAULT_CTRL = PacketCtrl.Noop;
    public static final Long DEFAULT_TS = 0L;

    public BsyncPacket(BsyncCursor bsyncCursor, BsyncPayload bsyncPayload, PacketStatus packetStatus, Long l, PacketCtrl packetCtrl, String str, String str2, Long l2, Map<String, String> map) {
        this(bsyncCursor, bsyncPayload, packetStatus, l, packetCtrl, str, str2, l2, map, ByteString.EMPTY);
    }

    public BsyncPacket(BsyncCursor bsyncCursor, BsyncPayload bsyncPayload, PacketStatus packetStatus, Long l, PacketCtrl packetCtrl, String str, String str2, Long l2, Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.cursor = bsyncCursor;
        this.payload = bsyncPayload;
        this.status = packetStatus;
        this.expire_ts = l;
        this.ctrl = packetCtrl;
        this.msgid = str;
        this.logid = str2;
        this.f238ts = l2;
        this.extra = Internal.immutableCopyOf("extra", map);
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m997newBuilder() {
        Builder builder = new Builder();
        builder.cursor = this.cursor;
        builder.payload = this.payload;
        builder.status = this.status;
        builder.expire_ts = this.expire_ts;
        builder.ctrl = this.ctrl;
        builder.msgid = this.msgid;
        builder.logid = this.logid;
        builder.f239ts = this.f238ts;
        builder.extra = Internal.copyOf("extra", this.extra);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BsyncPacket)) {
            return false;
        }
        BsyncPacket bsyncPacket = (BsyncPacket) obj;
        return unknownFields().equals(bsyncPacket.unknownFields()) && this.cursor.equals(bsyncPacket.cursor) && Internal.equals(this.payload, bsyncPacket.payload) && Internal.equals(this.status, bsyncPacket.status) && Internal.equals(this.expire_ts, bsyncPacket.expire_ts) && Internal.equals(this.ctrl, bsyncPacket.ctrl) && Internal.equals(this.msgid, bsyncPacket.msgid) && Internal.equals(this.logid, bsyncPacket.logid) && Internal.equals(this.f238ts, bsyncPacket.f238ts) && this.extra.equals(bsyncPacket.extra);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((unknownFields().hashCode() * 37) + this.cursor.hashCode()) * 37;
        BsyncPayload bsyncPayload = this.payload;
        int hashCode2 = (hashCode + (bsyncPayload != null ? bsyncPayload.hashCode() : 0)) * 37;
        PacketStatus packetStatus = this.status;
        int hashCode3 = (hashCode2 + (packetStatus != null ? packetStatus.hashCode() : 0)) * 37;
        Long l = this.expire_ts;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        PacketCtrl packetCtrl = this.ctrl;
        int hashCode5 = (hashCode4 + (packetCtrl != null ? packetCtrl.hashCode() : 0)) * 37;
        String str = this.msgid;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.logid;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.f238ts;
        int hashCode8 = ((hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37) + this.extra.hashCode();
        ((Message) this).hashCode = hashCode8;
        return hashCode8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", cursor=").append(this.cursor);
        if (this.payload != null) {
            sb.append(", payload=").append(this.payload);
        }
        if (this.status != null) {
            sb.append(", status=").append(this.status);
        }
        if (this.expire_ts != null) {
            sb.append(", expire_ts=").append(this.expire_ts);
        }
        if (this.ctrl != null) {
            sb.append(", ctrl=").append(this.ctrl);
        }
        if (this.msgid != null) {
            sb.append(", msgid=").append(this.msgid);
        }
        if (this.logid != null) {
            sb.append(", logid=").append(this.logid);
        }
        if (this.f238ts != null) {
            sb.append(", ts=").append(this.f238ts);
        }
        if (!this.extra.isEmpty()) {
            sb.append(", extra=").append(this.extra);
        }
        return sb.replace(0, 2, "BsyncPacket{").append('}').toString();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Builder extends Message.Builder<BsyncPacket, Builder> {
        public PacketCtrl ctrl;
        public BsyncCursor cursor;
        public Long expire_ts;
        public Map<String, String> extra = Internal.newMutableMap();
        public String logid;
        public String msgid;
        public BsyncPayload payload;
        public PacketStatus status;

        /* renamed from: ts */
        public Long f239ts;

        public Builder cursor(BsyncCursor bsyncCursor) {
            this.cursor = bsyncCursor;
            return this;
        }

        public Builder payload(BsyncPayload bsyncPayload) {
            this.payload = bsyncPayload;
            return this;
        }

        public Builder status(PacketStatus packetStatus) {
            this.status = packetStatus;
            return this;
        }

        public Builder expire_ts(Long l) {
            this.expire_ts = l;
            return this;
        }

        public Builder ctrl(PacketCtrl packetCtrl) {
            this.ctrl = packetCtrl;
            return this;
        }

        public Builder msgid(String str) {
            this.msgid = str;
            return this;
        }

        public Builder logid(String str) {
            this.logid = str;
            return this;
        }

        /* renamed from: ts */
        public Builder m190ts(Long l) {
            this.f239ts = l;
            return this;
        }

        public Builder extra(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.extra = map;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public BsyncPacket m998build() {
            BsyncCursor bsyncCursor = this.cursor;
            if (bsyncCursor == null) {
                throw Internal.missingRequiredFields(new Object[]{bsyncCursor, "cursor"});
            }
            return new BsyncPacket(this.cursor, this.payload, this.status, this.expire_ts, this.ctrl, this.msgid, this.logid, this.f239ts, this.extra, super.buildUnknownFields());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ProtoAdapter_BsyncPacket extends ProtoAdapter<BsyncPacket> {
        private final ProtoAdapter<Map<String, String>> extra;

        public ProtoAdapter_BsyncPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncPacket.class);
            this.extra = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int encodedSize(BsyncPacket bsyncPacket) {
            return BsyncCursor.ADAPTER.encodedSizeWithTag(1, bsyncPacket.cursor) + BsyncPayload.ADAPTER.encodedSizeWithTag(2, bsyncPacket.payload) + PacketStatus.ADAPTER.encodedSizeWithTag(3, bsyncPacket.status) + ProtoAdapter.INT64.encodedSizeWithTag(4, bsyncPacket.expire_ts) + PacketCtrl.ADAPTER.encodedSizeWithTag(5, bsyncPacket.ctrl) + ProtoAdapter.STRING.encodedSizeWithTag(6, bsyncPacket.msgid) + ProtoAdapter.STRING.encodedSizeWithTag(7, bsyncPacket.logid) + ProtoAdapter.INT64.encodedSizeWithTag(ReducerConstants.REQUEST_CODE, bsyncPacket.f238ts) + this.extra.encodedSizeWithTag(StatusBarUtils.FLAG_NOTCH_SUPPORT, bsyncPacket.extra) + bsyncPacket.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, BsyncPacket bsyncPacket) throws IOException {
            BsyncCursor.ADAPTER.encodeWithTag(protoWriter, 1, bsyncPacket.cursor);
            BsyncPayload.ADAPTER.encodeWithTag(protoWriter, 2, bsyncPacket.payload);
            PacketStatus.ADAPTER.encodeWithTag(protoWriter, 3, bsyncPacket.status);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, bsyncPacket.expire_ts);
            PacketCtrl.ADAPTER.encodeWithTag(protoWriter, 5, bsyncPacket.ctrl);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, bsyncPacket.msgid);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, bsyncPacket.logid);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, ReducerConstants.REQUEST_CODE, bsyncPacket.f238ts);
            this.extra.encodeWithTag(protoWriter, StatusBarUtils.FLAG_NOTCH_SUPPORT, bsyncPacket.extra);
            protoWriter.writeBytes(bsyncPacket.unknownFields());
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BsyncPacket m999decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m998build();
                }
                if (nextTag == 255) {
                    builder.m190ts((Long) ProtoAdapter.INT64.decode(protoReader));
                } else if (nextTag != 256) {
                    switch (nextTag) {
                        case 1:
                            builder.cursor((BsyncCursor) BsyncCursor.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.payload((BsyncPayload) BsyncPayload.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            try {
                                builder.status((PacketStatus) PacketStatus.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                                break;
                            }
                        case 4:
                            builder.expire_ts((Long) ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 5:
                            try {
                                builder.ctrl((PacketCtrl) PacketCtrl.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e2.value));
                                break;
                            }
                        case 6:
                            builder.msgid((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.logid((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    builder.extra.putAll((Map) this.extra.decode(protoReader));
                }
            }
        }

        public BsyncPacket redact(BsyncPacket bsyncPacket) {
            Builder m997newBuilder = bsyncPacket.m997newBuilder();
            m997newBuilder.cursor = (BsyncCursor) BsyncCursor.ADAPTER.redact(m997newBuilder.cursor);
            if (m997newBuilder.payload != null) {
                m997newBuilder.payload = (BsyncPayload) BsyncPayload.ADAPTER.redact(m997newBuilder.payload);
            }
            m997newBuilder.clearUnknownFields();
            return m997newBuilder.m998build();
        }
    }
}
