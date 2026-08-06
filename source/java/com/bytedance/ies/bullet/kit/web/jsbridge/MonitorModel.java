package com.bytedance.ies.bullet.kit.web.jsbridge;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSB4Support.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001HB·\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0017J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00108\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJä\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u0005HÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b)\u0010\u001cR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b*\u0010 R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b+\u0010 R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019¨\u0006I"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/MonitorModel;", "", "method", "", "code", "", b.u, "channel", "containerType", SchemaConstants.INNER_PARAM_PROTOCOL_VERSION, "duration", "", "url", "request_data_length", "request_send_timestamp", "request_receive_timestamp", "request_decode_duration", "request_duration", "response_data_length", "response_encode_duration", "response_send_timestamp", "response_receive_timestamp", "response_duration", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getAppID", "()Ljava/lang/String;", "getChannel", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContainerType", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMethod", "getProtocolVersion", "getRequest_data_length", "getRequest_decode_duration", "getRequest_duration", "getRequest_receive_timestamp", "getRequest_send_timestamp", "getResponse_data_length", "getResponse_duration", "getResponse_encode_duration", "getResponse_receive_timestamp", "getResponse_send_timestamp", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/ies/bullet/kit/web/jsbridge/MonitorModel;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MonitorModel {
    private final String appID;
    private final String channel;
    private final Integer code;
    private final String containerType;
    private final Long duration;
    private final String method;
    private final String protocolVersion;
    private final Integer request_data_length;
    private final Long request_decode_duration;
    private final Long request_duration;
    private final Long request_receive_timestamp;
    private final Long request_send_timestamp;
    private final Integer response_data_length;
    private final Long response_duration;
    private final Long response_encode_duration;
    private final Long response_receive_timestamp;
    private final Long response_send_timestamp;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getRequest_send_timestamp() {
        return this.request_send_timestamp;
    }

    /* renamed from: component11, reason: from getter */
    public final Long getRequest_receive_timestamp() {
        return this.request_receive_timestamp;
    }

    /* renamed from: component12, reason: from getter */
    public final Long getRequest_decode_duration() {
        return this.request_decode_duration;
    }

    /* renamed from: component13, reason: from getter */
    public final Long getRequest_duration() {
        return this.request_duration;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getResponse_data_length() {
        return this.response_data_length;
    }

    /* renamed from: component15, reason: from getter */
    public final Long getResponse_encode_duration() {
        return this.response_encode_duration;
    }

    /* renamed from: component16, reason: from getter */
    public final Long getResponse_send_timestamp() {
        return this.response_send_timestamp;
    }

    /* renamed from: component17, reason: from getter */
    public final Long getResponse_receive_timestamp() {
        return this.response_receive_timestamp;
    }

    /* renamed from: component18, reason: from getter */
    public final Long getResponse_duration() {
        return this.response_duration;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppID() {
        return this.appID;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContainerType() {
        return this.containerType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getRequest_data_length() {
        return this.request_data_length;
    }

    public final MonitorModel copy(String method, Integer code, String appID, String channel, String containerType, String protocolVersion, Long duration, String url, Integer request_data_length, Long request_send_timestamp, Long request_receive_timestamp, Long request_decode_duration, Long request_duration, Integer response_data_length, Long response_encode_duration, Long response_send_timestamp, Long response_receive_timestamp, Long response_duration) {
        Intrinsics.checkNotNullParameter(protocolVersion, "protocolVersion");
        return new MonitorModel(method, code, appID, channel, containerType, protocolVersion, duration, url, request_data_length, request_send_timestamp, request_receive_timestamp, request_decode_duration, request_duration, response_data_length, response_encode_duration, response_send_timestamp, response_receive_timestamp, response_duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MonitorModel)) {
            return false;
        }
        MonitorModel monitorModel = (MonitorModel) other;
        return Intrinsics.areEqual(this.method, monitorModel.method) && Intrinsics.areEqual(this.code, monitorModel.code) && Intrinsics.areEqual(this.appID, monitorModel.appID) && Intrinsics.areEqual(this.channel, monitorModel.channel) && Intrinsics.areEqual(this.containerType, monitorModel.containerType) && Intrinsics.areEqual(this.protocolVersion, monitorModel.protocolVersion) && Intrinsics.areEqual(this.duration, monitorModel.duration) && Intrinsics.areEqual(this.url, monitorModel.url) && Intrinsics.areEqual(this.request_data_length, monitorModel.request_data_length) && Intrinsics.areEqual(this.request_send_timestamp, monitorModel.request_send_timestamp) && Intrinsics.areEqual(this.request_receive_timestamp, monitorModel.request_receive_timestamp) && Intrinsics.areEqual(this.request_decode_duration, monitorModel.request_decode_duration) && Intrinsics.areEqual(this.request_duration, monitorModel.request_duration) && Intrinsics.areEqual(this.response_data_length, monitorModel.response_data_length) && Intrinsics.areEqual(this.response_encode_duration, monitorModel.response_encode_duration) && Intrinsics.areEqual(this.response_send_timestamp, monitorModel.response_send_timestamp) && Intrinsics.areEqual(this.response_receive_timestamp, monitorModel.response_receive_timestamp) && Intrinsics.areEqual(this.response_duration, monitorModel.response_duration);
    }

    public int hashCode() {
        String str = this.method;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.code;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.appID;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.channel;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.containerType;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.protocolVersion.hashCode()) * 31;
        Long l = this.duration;
        int hashCode6 = (hashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        String str5 = this.url;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.request_data_length;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l2 = this.request_send_timestamp;
        int hashCode9 = (hashCode8 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.request_receive_timestamp;
        int hashCode10 = (hashCode9 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.request_decode_duration;
        int hashCode11 = (hashCode10 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.request_duration;
        int hashCode12 = (hashCode11 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Integer num3 = this.response_data_length;
        int hashCode13 = (hashCode12 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l6 = this.response_encode_duration;
        int hashCode14 = (hashCode13 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.response_send_timestamp;
        int hashCode15 = (hashCode14 + (l7 == null ? 0 : l7.hashCode())) * 31;
        Long l8 = this.response_receive_timestamp;
        int hashCode16 = (hashCode15 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Long l9 = this.response_duration;
        return hashCode16 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MonitorModel(method=");
        sb.append(this.method).append(", code=").append(this.code).append(", appID=").append(this.appID).append(", channel=").append(this.channel).append(", containerType=").append(this.containerType).append(", protocolVersion=").append(this.protocolVersion).append(", duration=").append(this.duration).append(", url=").append(this.url).append(", request_data_length=").append(this.request_data_length).append(", request_send_timestamp=").append(this.request_send_timestamp).append(", request_receive_timestamp=").append(this.request_receive_timestamp).append(", request_decode_duration=");
        sb.append(this.request_decode_duration).append(", request_duration=").append(this.request_duration).append(", response_data_length=").append(this.response_data_length).append(", response_encode_duration=").append(this.response_encode_duration).append(", response_send_timestamp=").append(this.response_send_timestamp).append(", response_receive_timestamp=").append(this.response_receive_timestamp).append(", response_duration=").append(this.response_duration).append(')');
        return sb.toString();
    }

    public MonitorModel(String str, Integer num, String str2, String str3, String str4, String protocolVersion, Long l, String str5, Integer num2, Long l2, Long l3, Long l4, Long l5, Integer num3, Long l6, Long l7, Long l8, Long l9) {
        Intrinsics.checkNotNullParameter(protocolVersion, "protocolVersion");
        this.method = str;
        this.code = num;
        this.appID = str2;
        this.channel = str3;
        this.containerType = str4;
        this.protocolVersion = protocolVersion;
        this.duration = l;
        this.url = str5;
        this.request_data_length = num2;
        this.request_send_timestamp = l2;
        this.request_receive_timestamp = l3;
        this.request_decode_duration = l4;
        this.request_duration = l5;
        this.response_data_length = num3;
        this.response_encode_duration = l6;
        this.response_send_timestamp = l7;
        this.response_receive_timestamp = l8;
        this.response_duration = l9;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getAppID() {
        return this.appID;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getContainerType() {
        return this.containerType;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getRequest_data_length() {
        return this.request_data_length;
    }

    public final Long getRequest_send_timestamp() {
        return this.request_send_timestamp;
    }

    public final Long getRequest_receive_timestamp() {
        return this.request_receive_timestamp;
    }

    public final Long getRequest_decode_duration() {
        return this.request_decode_duration;
    }

    public final Long getRequest_duration() {
        return this.request_duration;
    }

    public final Integer getResponse_data_length() {
        return this.response_data_length;
    }

    public final Long getResponse_encode_duration() {
        return this.response_encode_duration;
    }

    public final Long getResponse_send_timestamp() {
        return this.response_send_timestamp;
    }

    public final Long getResponse_receive_timestamp() {
        return this.response_receive_timestamp;
    }

    public final Long getResponse_duration() {
        return this.response_duration;
    }

    /* compiled from: JSB4Support.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0000J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0003J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010(\u001a\u00020\u0000J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\fJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\u0000J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\fJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\fJ\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/MonitorModel$Builder;", "", SchemaConstants.INNER_PARAM_PROTOCOL_VERSION, "", "(Ljava/lang/String;)V", b.u, "channel", "code", "", "Ljava/lang/Integer;", "containerType", "duration", "", "Ljava/lang/Long;", "method", "request_data_length", "request_decode_duration", "request_duration", "request_receive_timestamp", "request_send_timestamp", "response_data_length", "response_duration", "response_encode_duration", "response_receive_timestamp", "response_send_timestamp", "url", "build", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/MonitorModel;", "setAppID", "id", "setChannel", "setCode", "setContainerType", "type", "setDuration", "setMethod", "str", "setRequestDataLength", "length", "setRequestDecodeDuration", "setRequestDuration", "setRequestReceiveTimestamp", "ts", "setRequestSendTimestamp", "setResponseDataLength", "setResponseDuration", "setResponseEncodeDuration", "setResponseReceiveTimestamp", "setResponseSendTimestamp", "setURL", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private String appID;
        private String channel;
        private Integer code;
        private String containerType;
        private Long duration;
        private String method;
        private String protocolVersion;
        private Integer request_data_length;
        private Long request_decode_duration;
        private Long request_duration;
        private Long request_receive_timestamp;
        private Long request_send_timestamp;
        private Integer response_data_length;
        private Long response_duration;
        private Long response_encode_duration;
        private Long response_receive_timestamp;
        private Long response_send_timestamp;
        private String url;

        public Builder(String protocolVersion) {
            Intrinsics.checkNotNullParameter(protocolVersion, "protocolVersion");
            this.protocolVersion = protocolVersion;
        }

        public final Builder setMethod(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.method = str;
            return this;
        }

        public final Builder setURL(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            return this;
        }

        public final Builder setCode(int code) {
            this.code = Integer.valueOf(code);
            return this;
        }

        public final Builder setAppID(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.appID = id;
            return this;
        }

        public final Builder setChannel(String channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            return this;
        }

        public final Builder setContainerType(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.containerType = type;
            return this;
        }

        public final Builder setDuration() {
            Long l = this.response_receive_timestamp;
            if (l != null && this.request_send_timestamp != null) {
                Intrinsics.checkNotNull(l);
                long longValue = l.longValue();
                Long l2 = this.request_send_timestamp;
                Intrinsics.checkNotNull(l2);
                this.duration = Long.valueOf(longValue - l2.longValue());
            }
            return this;
        }

        public final Builder setRequestDataLength(int length) {
            this.request_data_length = Integer.valueOf(length);
            return this;
        }

        public final Builder setRequestSendTimestamp(long ts) {
            this.request_send_timestamp = Long.valueOf(ts);
            return this;
        }

        public final Builder setRequestReceiveTimestamp(long ts) {
            this.request_receive_timestamp = Long.valueOf(ts);
            return this;
        }

        public final Builder setRequestDuration() {
            Long l = this.request_receive_timestamp;
            if (l != null && this.request_send_timestamp != null) {
                Intrinsics.checkNotNull(l);
                long longValue = l.longValue();
                Long l2 = this.request_send_timestamp;
                Intrinsics.checkNotNull(l2);
                this.request_duration = Long.valueOf(longValue - l2.longValue());
            }
            return this;
        }

        public final Builder setRequestDecodeDuration(long duration) {
            this.request_decode_duration = Long.valueOf(duration);
            return this;
        }

        public final Builder setResponseDataLength(int length) {
            this.response_data_length = Integer.valueOf(length);
            return this;
        }

        public final Builder setResponseSendTimestamp(long ts) {
            this.response_send_timestamp = Long.valueOf(ts);
            return this;
        }

        public final Builder setResponseReceiveTimestamp(long ts) {
            this.response_receive_timestamp = Long.valueOf(ts);
            return this;
        }

        public final Builder setResponseDuration() {
            Long l = this.response_receive_timestamp;
            if (l != null && this.response_send_timestamp != null) {
                Intrinsics.checkNotNull(l);
                long longValue = l.longValue();
                Long l2 = this.response_send_timestamp;
                Intrinsics.checkNotNull(l2);
                this.response_duration = Long.valueOf(longValue - l2.longValue());
            }
            return this;
        }

        public final Builder setResponseEncodeDuration(long duration) {
            this.response_encode_duration = Long.valueOf(duration);
            return this;
        }

        public final MonitorModel build() {
            return new MonitorModel(this.method, this.code, this.appID, this.channel, this.containerType, this.protocolVersion, this.duration, this.url, this.request_data_length, this.request_send_timestamp, this.request_receive_timestamp, this.request_decode_duration, this.request_duration, this.response_data_length, this.response_encode_duration, this.response_send_timestamp, this.response_receive_timestamp, this.response_duration);
        }
    }
}
