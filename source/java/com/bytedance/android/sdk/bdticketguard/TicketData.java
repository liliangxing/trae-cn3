package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketData;", "", "type", "", "ticket", "ts_sign", "cert", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCert", "()Ljava/lang/String;", "getTicket", "getTs_sign", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final /* data */ class TicketData {

    @SerializedName("cert")
    private final String cert;

    @SerializedName("ticket")
    private final String ticket;

    @SerializedName("ts_sign")
    private final String ts_sign;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ TicketData copy$default(TicketData ticketData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ticketData.type;
        }
        if ((i & 2) != 0) {
            str2 = ticketData.ticket;
        }
        if ((i & 4) != 0) {
            str3 = ticketData.ts_sign;
        }
        if ((i & 8) != 0) {
            str4 = ticketData.cert;
        }
        return ticketData.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTicket() {
        return this.ticket;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTs_sign() {
        return this.ts_sign;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCert() {
        return this.cert;
    }

    public final TicketData copy(String type, String ticket, String ts_sign, String cert) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        return new TicketData(type, ticket, ts_sign, cert);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketData)) {
            return false;
        }
        TicketData ticketData = (TicketData) other;
        return Intrinsics.areEqual(this.type, ticketData.type) && Intrinsics.areEqual(this.ticket, ticketData.ticket) && Intrinsics.areEqual(this.ts_sign, ticketData.ts_sign) && Intrinsics.areEqual(this.cert, ticketData.cert);
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ticket;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ts_sign;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.cert;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "TicketData(type=" + this.type + ", ticket=" + this.ticket + ", ts_sign=" + this.ts_sign + ", cert=" + this.cert + ")";
    }

    public TicketData(String type, String ticket, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        this.type = type;
        this.ticket = ticket;
        this.ts_sign = str;
        this.cert = str2;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getTs_sign() {
        return this.ts_sign;
    }

    public final String getCert() {
        return this.cert;
    }
}
