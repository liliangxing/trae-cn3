package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ServerDataV1;", "Lcom/bytedance/android/sdk/bdticketguard/ServerData;", "ticket", "", "tsSign", "clientCert", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientCert", "()Ljava/lang/String;", "getTicket", "getTsSign", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final /* data */ class ServerDataV1 implements ServerData {

    @SerializedName("client_cert")
    private final String clientCert;

    @SerializedName("ticket")
    private final String ticket;

    @SerializedName("ts_sign")
    private final String tsSign;

    public static /* synthetic */ ServerDataV1 copy$default(ServerDataV1 serverDataV1, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serverDataV1.ticket;
        }
        if ((i & 2) != 0) {
            str2 = serverDataV1.tsSign;
        }
        if ((i & 4) != 0) {
            str3 = serverDataV1.clientCert;
        }
        return serverDataV1.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTicket() {
        return this.ticket;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTsSign() {
        return this.tsSign;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClientCert() {
        return this.clientCert;
    }

    public final ServerDataV1 copy(String ticket, String tsSign, String clientCert) {
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        Intrinsics.checkParameterIsNotNull(tsSign, "tsSign");
        Intrinsics.checkParameterIsNotNull(clientCert, "clientCert");
        return new ServerDataV1(ticket, tsSign, clientCert);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerDataV1)) {
            return false;
        }
        ServerDataV1 serverDataV1 = (ServerDataV1) other;
        return Intrinsics.areEqual(this.ticket, serverDataV1.ticket) && Intrinsics.areEqual(this.tsSign, serverDataV1.tsSign) && Intrinsics.areEqual(this.clientCert, serverDataV1.clientCert);
    }

    public int hashCode() {
        String str = this.ticket;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tsSign;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.clientCert;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ServerDataV1(ticket=" + this.ticket + ", tsSign=" + this.tsSign + ", clientCert=" + this.clientCert + ")";
    }

    public ServerDataV1(String ticket, String tsSign, String clientCert) {
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        Intrinsics.checkParameterIsNotNull(tsSign, "tsSign");
        Intrinsics.checkParameterIsNotNull(clientCert, "clientCert");
        this.ticket = ticket;
        this.tsSign = tsSign;
        this.clientCert = clientCert;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getTsSign() {
        return this.tsSign;
    }

    public final String getClientCert() {
        return this.clientCert;
    }
}
