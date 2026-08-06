package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/login/traeauth/DeviceProof;", "", "signature", "", "timestamp", "", "nonce", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getSignature", "()Ljava/lang/String;", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNonce", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/DeviceProof;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DeviceProof {

    @SerializedName("Nonce")
    private final String nonce;

    @SerializedName("Signature")
    private final String signature;

    @SerializedName("Timestamp")
    private final Long timestamp;

    public DeviceProof() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DeviceProof copy$default(DeviceProof deviceProof, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceProof.signature;
        }
        if ((i & 2) != 0) {
            l = deviceProof.timestamp;
        }
        if ((i & 4) != 0) {
            str2 = deviceProof.nonce;
        }
        return deviceProof.copy(str, l, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public final DeviceProof copy(String signature, Long timestamp, String nonce) {
        return new DeviceProof(signature, timestamp, nonce);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceProof)) {
            return false;
        }
        DeviceProof deviceProof = (DeviceProof) other;
        return Intrinsics.areEqual(this.signature, deviceProof.signature) && Intrinsics.areEqual(this.timestamp, deviceProof.timestamp) && Intrinsics.areEqual(this.nonce, deviceProof.nonce);
    }

    public int hashCode() {
        String str = this.signature;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.timestamp;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.nonce;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DeviceProof(signature=" + this.signature + ", timestamp=" + this.timestamp + ", nonce=" + this.nonce + ')';
    }

    public DeviceProof(String str, Long l, String str2) {
        this.signature = str;
        this.timestamp = l;
        this.nonce = str2;
    }

    public /* synthetic */ DeviceProof(String str, Long l, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2);
    }

    public final String getSignature() {
        return this.signature;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final String getNonce() {
        return this.nonce;
    }
}
