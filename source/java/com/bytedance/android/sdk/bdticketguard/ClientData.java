package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApiConsumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/ClientData;", "", "requestContent", "", "timestamp", "", "tsSign", "tsSignRee", "requestSign", "requestSignRee", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestContent", "()Ljava/lang/String;", "getRequestSign", "setRequestSign", "(Ljava/lang/String;)V", "getRequestSignRee", "setRequestSignRee", "getTimestamp", "()J", "getTsSign", "setTsSign", "getTsSignRee", "setTsSignRee", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class ClientData {

    @SerializedName(TicketGuardApiKt.CLIENT_DATA_REQ_CONTENT)
    private final String requestContent;

    @SerializedName(TicketGuardApiKt.CLIENT_DATA_REQ_SIGN)
    private String requestSign;

    @SerializedName(TicketGuardApiKt.CLIENT_DATA_REQ_SIGN_REE)
    private String requestSignRee;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("ts_sign")
    private String tsSign;

    @SerializedName("ts_sign_ree")
    private String tsSignRee;

    public ClientData(String requestContent, long j, String tsSign, String tsSignRee, String requestSign, String requestSignRee) {
        Intrinsics.checkParameterIsNotNull(requestContent, "requestContent");
        Intrinsics.checkParameterIsNotNull(tsSign, "tsSign");
        Intrinsics.checkParameterIsNotNull(tsSignRee, "tsSignRee");
        Intrinsics.checkParameterIsNotNull(requestSign, "requestSign");
        Intrinsics.checkParameterIsNotNull(requestSignRee, "requestSignRee");
        this.requestContent = requestContent;
        this.timestamp = j;
        this.tsSign = tsSign;
        this.tsSignRee = tsSignRee;
        this.requestSign = requestSign;
        this.requestSignRee = requestSignRee;
    }

    public final String getRequestContent() {
        return this.requestContent;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTsSign() {
        return this.tsSign;
    }

    public final void setTsSign(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.tsSign = str;
    }

    public final String getTsSignRee() {
        return this.tsSignRee;
    }

    public final void setTsSignRee(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.tsSignRee = str;
    }

    public final String getRequestSign() {
        return this.requestSign;
    }

    public final void setRequestSign(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.requestSign = str;
    }

    public /* synthetic */ ClientData(String str, long j, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5);
    }

    public final String getRequestSignRee() {
        return this.requestSignRee;
    }

    public final void setRequestSignRee(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.requestSignRee = str;
    }
}
