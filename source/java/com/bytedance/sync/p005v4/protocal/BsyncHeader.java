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
import java.util.Map;
import okio.ByteString;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BsyncHeader extends Message<BsyncHeader, Builder> {
    public static final String DEFAULT_DID = "";
    public static final String DEFAULT_SDK_VERSION = "";
    public static final String DEFAULT_UID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.Ctrl#ADAPTER", tag = 5)
    public final Ctrl ctrl;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String did;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", keyAdapter = "com.squareup.wire.ProtoAdapter#INT32", tag = ReducerConstants.REQUEST_CODE)
    public final Map<Integer, ByteString> infos;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.Platform#ADAPTER", tag = 8)
    public final Platform platform;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.Reason#ADAPTER", tag = 7)
    public final Reason reason;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String sdk_version;

    /* renamed from: ts */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f236ts;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String uid;

    @WireField(adapter = "com.bytedance.sync.v4.protocal.Version#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final Version version;
    public static final ProtoAdapter<BsyncHeader> ADAPTER = new ProtoAdapter_BsyncHeader();
    public static final Version DEFAULT_VERSION = Version.Unknown;
    public static final Long DEFAULT_TS = 0L;
    public static final Ctrl DEFAULT_CTRL = Ctrl.Default;
    public static final Reason DEFAULT_REASON = Reason.Def;
    public static final Platform DEFAULT_PLATFORM = Platform.unknown;

    public BsyncHeader(Version version, String str, String str2, Long l, Ctrl ctrl, String str3, Reason reason, Platform platform, Map<Integer, ByteString> map) {
        this(version, str, str2, l, ctrl, str3, reason, platform, map, ByteString.EMPTY);
    }

    public BsyncHeader(Version version, String str, String str2, Long l, Ctrl ctrl, String str3, Reason reason, Platform platform, Map<Integer, ByteString> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.version = version;
        this.uid = str;
        this.did = str2;
        this.f236ts = l;
        this.ctrl = ctrl;
        this.sdk_version = str3;
        this.reason = reason;
        this.platform = platform;
        this.infos = Internal.immutableCopyOf("infos", map);
    }

    /* renamed from: newBuilder, reason: merged with bridge method [inline-methods] */
    public Builder m994newBuilder() {
        Builder builder = new Builder();
        builder.version = this.version;
        builder.uid = this.uid;
        builder.did = this.did;
        builder.f237ts = this.f236ts;
        builder.ctrl = this.ctrl;
        builder.sdk_version = this.sdk_version;
        builder.reason = this.reason;
        builder.platform = this.platform;
        builder.infos = Internal.copyOf("infos", this.infos);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BsyncHeader)) {
            return false;
        }
        BsyncHeader bsyncHeader = (BsyncHeader) obj;
        return unknownFields().equals(bsyncHeader.unknownFields()) && this.version.equals(bsyncHeader.version) && Internal.equals(this.uid, bsyncHeader.uid) && Internal.equals(this.did, bsyncHeader.did) && Internal.equals(this.f236ts, bsyncHeader.f236ts) && Internal.equals(this.ctrl, bsyncHeader.ctrl) && Internal.equals(this.sdk_version, bsyncHeader.sdk_version) && Internal.equals(this.reason, bsyncHeader.reason) && Internal.equals(this.platform, bsyncHeader.platform) && this.infos.equals(bsyncHeader.infos);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((unknownFields().hashCode() * 37) + this.version.hashCode()) * 37;
        String str = this.uid;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.did;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.f236ts;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Ctrl ctrl = this.ctrl;
        int hashCode5 = (hashCode4 + (ctrl != null ? ctrl.hashCode() : 0)) * 37;
        String str3 = this.sdk_version;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Reason reason = this.reason;
        int hashCode7 = (hashCode6 + (reason != null ? reason.hashCode() : 0)) * 37;
        Platform platform = this.platform;
        int hashCode8 = ((hashCode7 + (platform != null ? platform.hashCode() : 0)) * 37) + this.infos.hashCode();
        ((Message) this).hashCode = hashCode8;
        return hashCode8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", version=").append(this.version);
        if (this.uid != null) {
            sb.append(", uid=").append(this.uid);
        }
        if (this.did != null) {
            sb.append(", did=").append(this.did);
        }
        if (this.f236ts != null) {
            sb.append(", ts=").append(this.f236ts);
        }
        if (this.ctrl != null) {
            sb.append(", ctrl=").append(this.ctrl);
        }
        if (this.sdk_version != null) {
            sb.append(", sdk_version=").append(this.sdk_version);
        }
        if (this.reason != null) {
            sb.append(", reason=").append(this.reason);
        }
        if (this.platform != null) {
            sb.append(", platform=").append(this.platform);
        }
        if (!this.infos.isEmpty()) {
            sb.append(", infos=").append(this.infos);
        }
        return sb.replace(0, 2, "BsyncHeader{").append('}').toString();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Builder extends Message.Builder<BsyncHeader, Builder> {
        public Ctrl ctrl;
        public String did;
        public Map<Integer, ByteString> infos = Internal.newMutableMap();
        public Platform platform;
        public Reason reason;
        public String sdk_version;

        /* renamed from: ts */
        public Long f237ts;
        public String uid;
        public Version version;

        public Builder version(Version version) {
            this.version = version;
            return this;
        }

        public Builder uid(String str) {
            this.uid = str;
            return this;
        }

        public Builder did(String str) {
            this.did = str;
            return this;
        }

        /* renamed from: ts */
        public Builder m189ts(Long l) {
            this.f237ts = l;
            return this;
        }

        public Builder ctrl(Ctrl ctrl) {
            this.ctrl = ctrl;
            return this;
        }

        public Builder sdk_version(String str) {
            this.sdk_version = str;
            return this;
        }

        public Builder reason(Reason reason) {
            this.reason = reason;
            return this;
        }

        public Builder platform(Platform platform) {
            this.platform = platform;
            return this;
        }

        public Builder infos(Map<Integer, ByteString> map) {
            Internal.checkElementsNotNull(map);
            this.infos = map;
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public BsyncHeader m995build() {
            Version version = this.version;
            if (version == null) {
                throw Internal.missingRequiredFields(new Object[]{version, "version"});
            }
            return new BsyncHeader(this.version, this.uid, this.did, this.f237ts, this.ctrl, this.sdk_version, this.reason, this.platform, this.infos, super.buildUnknownFields());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class ProtoAdapter_BsyncHeader extends ProtoAdapter<BsyncHeader> {
        private final ProtoAdapter<Map<Integer, ByteString>> infos;

        public ProtoAdapter_BsyncHeader() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncHeader.class);
            this.infos = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BYTES);
        }

        public int encodedSize(BsyncHeader bsyncHeader) {
            return Version.ADAPTER.encodedSizeWithTag(1, bsyncHeader.version) + ProtoAdapter.STRING.encodedSizeWithTag(2, bsyncHeader.uid) + ProtoAdapter.STRING.encodedSizeWithTag(3, bsyncHeader.did) + ProtoAdapter.INT64.encodedSizeWithTag(4, bsyncHeader.f236ts) + Ctrl.ADAPTER.encodedSizeWithTag(5, bsyncHeader.ctrl) + ProtoAdapter.STRING.encodedSizeWithTag(6, bsyncHeader.sdk_version) + Reason.ADAPTER.encodedSizeWithTag(7, bsyncHeader.reason) + Platform.ADAPTER.encodedSizeWithTag(8, bsyncHeader.platform) + this.infos.encodedSizeWithTag(ReducerConstants.REQUEST_CODE, bsyncHeader.infos) + bsyncHeader.unknownFields().size();
        }

        public void encode(ProtoWriter protoWriter, BsyncHeader bsyncHeader) throws IOException {
            Version.ADAPTER.encodeWithTag(protoWriter, 1, bsyncHeader.version);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, bsyncHeader.uid);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, bsyncHeader.did);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, bsyncHeader.f236ts);
            Ctrl.ADAPTER.encodeWithTag(protoWriter, 5, bsyncHeader.ctrl);
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, bsyncHeader.sdk_version);
            Reason.ADAPTER.encodeWithTag(protoWriter, 7, bsyncHeader.reason);
            Platform.ADAPTER.encodeWithTag(protoWriter, 8, bsyncHeader.platform);
            this.infos.encodeWithTag(protoWriter, ReducerConstants.REQUEST_CODE, bsyncHeader.infos);
            protoWriter.writeBytes(bsyncHeader.unknownFields());
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BsyncHeader m996decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.m995build();
                }
                if (nextTag != 255) {
                    switch (nextTag) {
                        case 1:
                            try {
                                builder.version((Version) Version.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                                break;
                            }
                        case 2:
                            builder.uid((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.did((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.m189ts((Long) ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 5:
                            try {
                                builder.ctrl((Ctrl) Ctrl.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e2.value));
                                break;
                            }
                        case 6:
                            builder.sdk_version((String) ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            try {
                                builder.reason((Reason) Reason.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e3.value));
                                break;
                            }
                        case 8:
                            try {
                                builder.platform((Platform) Platform.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e4.value));
                                break;
                            }
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    builder.infos.putAll((Map) this.infos.decode(protoReader));
                }
            }
        }

        public BsyncHeader redact(BsyncHeader bsyncHeader) {
            Builder m994newBuilder = bsyncHeader.m994newBuilder();
            m994newBuilder.clearUnknownFields();
            return m994newBuilder.m995build();
        }
    }
}
