package com.bytedance.sync.p005v4.protocal;

import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
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
public final class BsyncTopic extends Message<BsyncTopic, Builder> {
    public static final String DEFAULT_REQ_ID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.Bucket#ADAPTER", tag = 2)
    public final Bucket bucket;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 9)
    public final Long expire_time;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.Flag#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final Flag flag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    public final Long new_cursor;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.BsyncPacket#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<BsyncPacket> packets;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long ref_cursor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = ReducerConstants.REQUEST_CODE)
    public final String req_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long sync_id;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.TopicStatus#ADAPTER", tag = 8)
    public final TopicStatus topic_status;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.TopicType#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final TopicType topic_type;
    public static final ProtoAdapter<BsyncTopic> ADAPTER = new ProtoAdapter_BsyncTopic();
    public static final Flag DEFAULT_FLAG = Flag.None;
    public static final Bucket DEFAULT_BUCKET = Bucket.Device;
    public static final TopicType DEFAULT_TOPIC_TYPE = TopicType.SpecTopic;
    public static final Long DEFAULT_SYNC_ID = 0L;
    public static final Long DEFAULT_REF_CURSOR = 0L;
    public static final Long DEFAULT_NEW_CURSOR = 0L;
    public static final TopicStatus DEFAULT_TOPIC_STATUS = TopicStatus.NotExist;
    public static final Long DEFAULT_EXPIRE_TIME = 0L;

    public BsyncTopic(Flag flag, Bucket bucket, TopicType topicType, Long l, Long l2, Long l3, List<BsyncPacket> list, TopicStatus topicStatus, Long l4, String str) {
        this(flag, bucket, topicType, l, l2, l3, list, topicStatus, l4, str, ByteString.EMPTY);
    }

    public BsyncTopic(Flag flag, Bucket bucket, TopicType topicType, Long l, Long l2, Long l3, List<BsyncPacket> list, TopicStatus topicStatus, Long l4, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.flag = flag;
        this.bucket = bucket;
        this.topic_type = topicType;
        this.sync_id = l;
        this.ref_cursor = l2;
        this.new_cursor = l3;
        this.packets = Internal.immutableCopyOf("packets", list);
        this.topic_status = topicStatus;
        this.expire_time = l4;
        this.req_id = str;
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m1006newBuilder() {
        Builder builder = new Builder();
        builder.flag = this.flag;
        builder.bucket = this.bucket;
        builder.topic_type = this.topic_type;
        builder.sync_id = this.sync_id;
        builder.ref_cursor = this.ref_cursor;
        builder.new_cursor = this.new_cursor;
        builder.packets = Internal.copyOf("packets", this.packets);
        builder.topic_status = this.topic_status;
        builder.expire_time = this.expire_time;
        builder.req_id = this.req_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BsyncTopic)) {
            return false;
        }
        BsyncTopic bsyncTopic = (BsyncTopic) obj;
        return unknownFields().equals(bsyncTopic.unknownFields()) && this.flag.equals(bsyncTopic.flag) && Internal.equals(this.bucket, bsyncTopic.bucket) && this.topic_type.equals(bsyncTopic.topic_type) && Internal.equals(this.sync_id, bsyncTopic.sync_id) && Internal.equals(this.ref_cursor, bsyncTopic.ref_cursor) && Internal.equals(this.new_cursor, bsyncTopic.new_cursor) && this.packets.equals(bsyncTopic.packets) && Internal.equals(this.topic_status, bsyncTopic.topic_status) && Internal.equals(this.expire_time, bsyncTopic.expire_time) && Internal.equals(this.req_id, bsyncTopic.req_id);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((unknownFields().hashCode() * 37) + this.flag.hashCode()) * 37;
        Bucket bucket = this.bucket;
        int hashCode2 = (((hashCode + (bucket != null ? bucket.hashCode() : 0)) * 37) + this.topic_type.hashCode()) * 37;
        Long l = this.sync_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.ref_cursor;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.new_cursor;
        int hashCode5 = (((hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37) + this.packets.hashCode()) * 37;
        TopicStatus topicStatus = this.topic_status;
        int hashCode6 = (hashCode5 + (topicStatus != null ? topicStatus.hashCode() : 0)) * 37;
        Long l4 = this.expire_time;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str = this.req_id;
        int hashCode8 = hashCode7 + (str != null ? str.hashCode() : 0);
        ((Message) this).hashCode = hashCode8;
        return hashCode8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", flag=").append(this.flag);
        if (this.bucket != null) {
            sb.append(", bucket=").append(this.bucket);
        }
        sb.append(", topic_type=").append(this.topic_type);
        if (this.sync_id != null) {
            sb.append(", sync_id=").append(this.sync_id);
        }
        if (this.ref_cursor != null) {
            sb.append(", ref_cursor=").append(this.ref_cursor);
        }
        if (this.new_cursor != null) {
            sb.append(", new_cursor=").append(this.new_cursor);
        }
        if (!this.packets.isEmpty()) {
            sb.append(", packets=").append(this.packets);
        }
        if (this.topic_status != null) {
            sb.append(", topic_status=").append(this.topic_status);
        }
        if (this.expire_time != null) {
            sb.append(", expire_time=").append(this.expire_time);
        }
        if (this.req_id != null) {
            sb.append(", req_id=").append(this.req_id);
        }
        return sb.replace(0, 2, "BsyncTopic{").append('}').toString();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Builder extends Message.Builder<BsyncTopic, Builder> {
        public Bucket bucket;
        public Long expire_time;
        public Flag flag;
        public Long new_cursor;
        public List<BsyncPacket> packets = Internal.newMutableList();
        public Long ref_cursor;
        public String req_id;
        public Long sync_id;
        public TopicStatus topic_status;
        public TopicType topic_type;

        public Builder flag(Flag flag) {
            this.flag = flag;
            return this;
        }

        public Builder bucket(Bucket bucket) {
            this.bucket = bucket;
            return this;
        }

        public Builder topic_type(TopicType topicType) {
            this.topic_type = topicType;
            return this;
        }

        public Builder sync_id(Long l) {
            this.sync_id = l;
            return this;
        }

        public Builder ref_cursor(Long l) {
            this.ref_cursor = l;
            return this;
        }

        public Builder new_cursor(Long l) {
            this.new_cursor = l;
            return this;
        }

        public Builder packets(List<BsyncPacket> list) {
            Internal.checkElementsNotNull(list);
            this.packets = list;
            return this;
        }

        public Builder topic_status(TopicStatus topicStatus) {
            this.topic_status = topicStatus;
            return this;
        }

        public Builder expire_time(Long l) {
            this.expire_time = l;
            return this;
        }

        public Builder req_id(String str) {
            this.req_id = str;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public BsyncTopic m1007build() {
            Flag flag = this.flag;
            if (flag == null || this.topic_type == null) {
                throw Internal.missingRequiredFields(new Object[]{flag, "flag", this.topic_type, "topic_type"});
            }
            return new BsyncTopic(this.flag, this.bucket, this.topic_type, this.sync_id, this.ref_cursor, this.new_cursor, this.packets, this.topic_status, this.expire_time, this.req_id, super.buildUnknownFields());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ProtoAdapter_BsyncTopic extends ProtoAdapter<BsyncTopic> {
        public ProtoAdapter_BsyncTopic() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncTopic.class);
        }

        public int encodedSize(BsyncTopic bsyncTopic) {
            return Flag.ADAPTER.encodedSizeWithTag(1, bsyncTopic.flag) + Bucket.ADAPTER.encodedSizeWithTag(2, bsyncTopic.bucket) + TopicType.ADAPTER.encodedSizeWithTag(3, bsyncTopic.topic_type) + ProtoAdapter.INT64.encodedSizeWithTag(4, bsyncTopic.sync_id) + ProtoAdapter.INT64.encodedSizeWithTag(5, bsyncTopic.ref_cursor) + ProtoAdapter.INT64.encodedSizeWithTag(6, bsyncTopic.new_cursor) + BsyncPacket.ADAPTER.asRepeated().encodedSizeWithTag(7, bsyncTopic.packets) + TopicStatus.ADAPTER.encodedSizeWithTag(8, bsyncTopic.topic_status) + ProtoAdapter.INT64.encodedSizeWithTag(9, bsyncTopic.expire_time) + ProtoAdapter.STRING.encodedSizeWithTag(ReducerConstants.REQUEST_CODE, bsyncTopic.req_id) + bsyncTopic.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, BsyncTopic bsyncTopic) throws IOException {
            Flag.ADAPTER.encodeWithTag(protoWriter, 1, bsyncTopic.flag);
            Bucket.ADAPTER.encodeWithTag(protoWriter, 2, bsyncTopic.bucket);
            TopicType.ADAPTER.encodeWithTag(protoWriter, 3, bsyncTopic.topic_type);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, bsyncTopic.sync_id);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, bsyncTopic.ref_cursor);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 6, bsyncTopic.new_cursor);
            BsyncPacket.ADAPTER.asRepeated().encodeWithTag(protoWriter, 7, bsyncTopic.packets);
            TopicStatus.ADAPTER.encodeWithTag(protoWriter, 8, bsyncTopic.topic_status);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 9, bsyncTopic.expire_time);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, ReducerConstants.REQUEST_CODE, bsyncTopic.req_id);
            protoWriter.writeBytes(bsyncTopic.unknownFields());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BsyncTopic m1008decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m1007build();
                }
                if (nextTag != 255) {
                    switch (nextTag) {
                        case 1:
                            try {
                                builder.flag((Flag) Flag.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                                break;
                            }
                        case 2:
                            try {
                                builder.bucket((Bucket) Bucket.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e2.value));
                                break;
                            }
                        case 3:
                            try {
                                builder.topic_type((TopicType) TopicType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e3.value));
                                break;
                            }
                        case 4:
                            builder.sync_id((Long) ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 5:
                            builder.ref_cursor((Long) ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 6:
                            builder.new_cursor((Long) ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 7:
                            builder.packets.add(BsyncPacket.ADAPTER.decode(protoReader));
                            break;
                        case 8:
                            try {
                                builder.topic_status((TopicStatus) TopicStatus.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e4.value));
                                break;
                            }
                        case 9:
                            builder.expire_time((Long) ProtoAdapter.INT64.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    builder.req_id((String) ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public BsyncTopic redact(BsyncTopic bsyncTopic) {
            Builder m1006newBuilder = bsyncTopic.m1006newBuilder();
            Internal.redactElements(m1006newBuilder.packets, BsyncPacket.ADAPTER);
            m1006newBuilder.clearUnknownFields();
            return m1006newBuilder.m1007build();
        }
    }
}
