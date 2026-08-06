package com.bytedance.trae.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WsMessage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/network/WsMessage;", "", "proto", "", "upSeqId", "", "downSeqId", "data", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getProto", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUpSeqId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDownSeqId", "getData", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/network/WsMessage;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class WsMessage {

    @SerializedName("data")
    private final String data;

    @SerializedName("down_seq_id")
    private final Long downSeqId;

    @SerializedName("proto")
    private final Integer proto;

    @SerializedName("up_seq_id")
    private final Long upSeqId;

    public WsMessage() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ WsMessage copy$default(WsMessage wsMessage, Integer num, Long l, Long l2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = wsMessage.proto;
        }
        if ((i & 2) != 0) {
            l = wsMessage.upSeqId;
        }
        if ((i & 4) != 0) {
            l2 = wsMessage.downSeqId;
        }
        if ((i & 8) != 0) {
            str = wsMessage.data;
        }
        return wsMessage.copy(num, l, l2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getProto() {
        return this.proto;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getUpSeqId() {
        return this.upSeqId;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getDownSeqId() {
        return this.downSeqId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getData() {
        return this.data;
    }

    public final WsMessage copy(Integer proto, Long upSeqId, Long downSeqId, String data) {
        return new WsMessage(proto, upSeqId, downSeqId, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WsMessage)) {
            return false;
        }
        WsMessage wsMessage = (WsMessage) other;
        return Intrinsics.areEqual(this.proto, wsMessage.proto) && Intrinsics.areEqual(this.upSeqId, wsMessage.upSeqId) && Intrinsics.areEqual(this.downSeqId, wsMessage.downSeqId) && Intrinsics.areEqual(this.data, wsMessage.data);
    }

    public int hashCode() {
        Integer num = this.proto;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.upSeqId;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.downSeqId;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.data;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "WsMessage(proto=" + this.proto + ", upSeqId=" + this.upSeqId + ", downSeqId=" + this.downSeqId + ", data=" + this.data + ')';
    }

    public WsMessage(Integer num, Long l, Long l2, String str) {
        this.proto = num;
        this.upSeqId = l;
        this.downSeqId = l2;
        this.data = str;
    }

    public /* synthetic */ WsMessage(Integer num, Long l, Long l2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str);
    }

    public final Integer getProto() {
        return this.proto;
    }

    public final Long getUpSeqId() {
        return this.upSeqId;
    }

    public final Long getDownSeqId() {
        return this.downSeqId;
    }

    public final String getData() {
        return this.data;
    }
}
