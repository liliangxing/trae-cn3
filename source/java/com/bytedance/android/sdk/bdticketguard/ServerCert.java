package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ServerCert;", "", "certString", "", "serialNumber", "publicKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCertString", "()Ljava/lang/String;", "setCertString", "(Ljava/lang/String;)V", "getPublicKey", "setPublicKey", "getSerialNumber", "setSerialNumber", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final /* data */ class ServerCert {

    @SerializedName("cert_string")
    private String certString;

    @SerializedName(TicketGuardProviderKt.COL_PUBLIC_KEY)
    private String publicKey;

    @SerializedName("serial_number")
    private String serialNumber;

    public static /* synthetic */ ServerCert copy$default(ServerCert serverCert, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serverCert.certString;
        }
        if ((i & 2) != 0) {
            str2 = serverCert.serialNumber;
        }
        if ((i & 4) != 0) {
            str3 = serverCert.publicKey;
        }
        return serverCert.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCertString() {
        return this.certString;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSerialNumber() {
        return this.serialNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPublicKey() {
        return this.publicKey;
    }

    public final ServerCert copy(String certString, String serialNumber, String publicKey) {
        Intrinsics.checkParameterIsNotNull(certString, "certString");
        Intrinsics.checkParameterIsNotNull(serialNumber, "serialNumber");
        Intrinsics.checkParameterIsNotNull(publicKey, "publicKey");
        return new ServerCert(certString, serialNumber, publicKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerCert)) {
            return false;
        }
        ServerCert serverCert = (ServerCert) other;
        return Intrinsics.areEqual(this.certString, serverCert.certString) && Intrinsics.areEqual(this.serialNumber, serverCert.serialNumber) && Intrinsics.areEqual(this.publicKey, serverCert.publicKey);
    }

    public int hashCode() {
        String str = this.certString;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.serialNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.publicKey;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ServerCert(certString=" + this.certString + ", serialNumber=" + this.serialNumber + ", publicKey=" + this.publicKey + ")";
    }

    public ServerCert(String certString, String serialNumber, String publicKey) {
        Intrinsics.checkParameterIsNotNull(certString, "certString");
        Intrinsics.checkParameterIsNotNull(serialNumber, "serialNumber");
        Intrinsics.checkParameterIsNotNull(publicKey, "publicKey");
        this.certString = certString;
        this.serialNumber = serialNumber;
        this.publicKey = publicKey;
    }

    public final String getCertString() {
        return this.certString;
    }

    public final void setCertString(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.certString = str;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final void setSerialNumber(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.serialNumber = str;
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    public final void setPublicKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.publicKey = str;
    }
}
