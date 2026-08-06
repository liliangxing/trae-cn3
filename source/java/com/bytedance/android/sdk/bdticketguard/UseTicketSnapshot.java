package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0016\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0016\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/UseTicketSnapshot;", "Lcom/bytedance/android/sdk/bdticketguard/CommonSnapshot;", "consumerResponseContent", "Lcom/bytedance/android/sdk/bdticketguard/ConsumerResponseContent;", "(Lcom/bytedance/android/sdk/bdticketguard/ConsumerResponseContent;)V", "local_error", "", "getLocal_error", "()Ljava/lang/String;", "remote_error", "getRemote_error", "request_client_data", "getRequest_client_data", "request_client_data_req_content", "getRequest_client_data_req_content", "request_client_data_req_sign", "getRequest_client_data_req_sign", "request_client_data_req_sign_ree", "getRequest_client_data_req_sign_ree", "request_client_data_timestamp", "getRequest_client_data_timestamp", "request_client_data_ts_sign", "getRequest_client_data_ts_sign", "request_client_data_ts_sign_ree", "getRequest_client_data_ts_sign_ree", "ticket", "getTicket", "ticket_name", "getTicket_name", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UseTicketSnapshot extends CommonSnapshot {

    @SerializedName("local_error")
    private final String local_error;

    @SerializedName("remote_error")
    private final String remote_error;

    @SerializedName("request_client_data")
    private final String request_client_data;

    @SerializedName("request_client_data_req_content")
    private final String request_client_data_req_content;

    @SerializedName("request_client_data_req_sign")
    private final String request_client_data_req_sign;

    @SerializedName("request_client_data_req_sign_ree")
    private final String request_client_data_req_sign_ree;

    @SerializedName("request_client_data_timestamp")
    private final String request_client_data_timestamp;

    @SerializedName("request_client_data_ts_sign")
    private final String request_client_data_ts_sign;

    @SerializedName("request_client_data_ts_sign_ree")
    private final String request_client_data_ts_sign_ree;

    @SerializedName("ticket")
    private final String ticket;

    @SerializedName("ticket_name")
    private final String ticket_name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseTicketSnapshot(ConsumerResponseContent consumerResponseContent) {
        super(consumerResponseContent);
        String tsSignRee;
        String mask;
        String tsSign;
        String mask2;
        String requestSignRee;
        String mask3;
        String requestSign;
        String mask4;
        String requestContent;
        String mask5;
        String ticketName;
        String target;
        String mask6;
        String errorDesc;
        Intrinsics.checkParameterIsNotNull(consumerResponseContent, "consumerResponseContent");
        this.remote_error = consumerResponseContent.getRemoteError();
        HandleConsumerResponseParam responseParam = consumerResponseContent.getResponseParam();
        ConsumerRequestContent requestContent2 = responseParam != null ? responseParam.getRequestContent() : null;
        String str = "";
        this.local_error = (requestContent2 == null || (errorDesc = requestContent2.getErrorDesc()) == null) ? "" : errorDesc;
        ConsumerRequestParam requestParam = requestContent2 != null ? requestContent2.getRequestParam() : null;
        this.ticket = (requestParam == null || (target = requestParam.getTarget()) == null || (mask6 = SnapshotKt.mask(target)) == null) ? "" : mask6;
        this.ticket_name = (requestParam == null || (ticketName = requestParam.getTicketName()) == null) ? "" : ticketName;
        this.request_client_data = SnapshotKt.mask(requestContent2.getClientDataBase64());
        ClientData clientData = requestContent2 != null ? requestContent2.getClientData() : null;
        this.request_client_data_req_content = (clientData == null || (requestContent = clientData.getRequestContent()) == null || (mask5 = SnapshotKt.mask(requestContent)) == null) ? "" : mask5;
        this.request_client_data_req_sign = (clientData == null || (requestSign = clientData.getRequestSign()) == null || (mask4 = SnapshotKt.mask(requestSign)) == null) ? "" : mask4;
        this.request_client_data_req_sign_ree = (clientData == null || (requestSignRee = clientData.getRequestSignRee()) == null || (mask3 = SnapshotKt.mask(requestSignRee)) == null) ? "" : mask3;
        String valueOf = String.valueOf((clientData != null ? Long.valueOf(clientData.getTimestamp()) : null).longValue());
        this.request_client_data_timestamp = valueOf == null ? "" : valueOf;
        this.request_client_data_ts_sign = (clientData == null || (tsSign = clientData.getTsSign()) == null || (mask2 = SnapshotKt.mask(tsSign)) == null) ? "" : mask2;
        if (clientData != null && (tsSignRee = clientData.getTsSignRee()) != null && (mask = SnapshotKt.mask(tsSignRee)) != null) {
            str = mask;
        }
        this.request_client_data_ts_sign_ree = str;
    }

    public final String getLocal_error() {
        return this.local_error;
    }

    public final String getRemote_error() {
        return this.remote_error;
    }

    public final String getTicket_name() {
        return this.ticket_name;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final String getRequest_client_data() {
        return this.request_client_data;
    }

    public final String getRequest_client_data_req_content() {
        return this.request_client_data_req_content;
    }

    public final String getRequest_client_data_req_sign() {
        return this.request_client_data_req_sign;
    }

    public final String getRequest_client_data_req_sign_ree() {
        return this.request_client_data_req_sign_ree;
    }

    public final String getRequest_client_data_timestamp() {
        return this.request_client_data_timestamp;
    }

    public final String getRequest_client_data_ts_sign() {
        return this.request_client_data_ts_sign;
    }

    public final String getRequest_client_data_ts_sign_ree() {
        return this.request_client_data_ts_sign_ree;
    }
}
