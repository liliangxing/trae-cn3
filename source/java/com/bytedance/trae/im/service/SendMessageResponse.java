package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISendMessageService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/im/service/SendMessageResponse;", "", "messageId", "", "accepted", "", "fromAppendMsg", "status", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getAccepted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFromAppendMsg", "getStatus", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/trae/im/service/SendMessageResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SendMessageResponse {

    @SerializedName("accepted")
    private final Boolean accepted;

    @SerializedName("from_append_msg")
    private final Boolean fromAppendMsg;

    @SerializedName(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID)
    private final String messageId;

    @SerializedName("status")
    private final String status;

    public SendMessageResponse() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SendMessageResponse copy$default(SendMessageResponse sendMessageResponse, String str, Boolean bool, Boolean bool2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sendMessageResponse.messageId;
        }
        if ((i & 2) != 0) {
            bool = sendMessageResponse.accepted;
        }
        if ((i & 4) != 0) {
            bool2 = sendMessageResponse.fromAppendMsg;
        }
        if ((i & 8) != 0) {
            str2 = sendMessageResponse.status;
        }
        return sendMessageResponse.copy(str, bool, bool2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getAccepted() {
        return this.accepted;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getFromAppendMsg() {
        return this.fromAppendMsg;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final SendMessageResponse copy(String messageId, Boolean accepted, Boolean fromAppendMsg, String status) {
        return new SendMessageResponse(messageId, accepted, fromAppendMsg, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendMessageResponse)) {
            return false;
        }
        SendMessageResponse sendMessageResponse = (SendMessageResponse) other;
        return Intrinsics.areEqual(this.messageId, sendMessageResponse.messageId) && Intrinsics.areEqual(this.accepted, sendMessageResponse.accepted) && Intrinsics.areEqual(this.fromAppendMsg, sendMessageResponse.fromAppendMsg) && Intrinsics.areEqual(this.status, sendMessageResponse.status);
    }

    public int hashCode() {
        String str = this.messageId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.accepted;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.fromAppendMsg;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.status;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SendMessageResponse(messageId=" + this.messageId + ", accepted=" + this.accepted + ", fromAppendMsg=" + this.fromAppendMsg + ", status=" + this.status + ')';
    }

    public SendMessageResponse(String str, Boolean bool, Boolean bool2, String str2) {
        this.messageId = str;
        this.accepted = bool;
        this.fromAppendMsg = bool2;
        this.status = str2;
    }

    public /* synthetic */ SendMessageResponse(String str, Boolean bool, Boolean bool2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : str2);
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final Boolean getAccepted() {
        return this.accepted;
    }

    public final Boolean getFromAppendMsg() {
        return this.fromAppendMsg;
    }

    public final String getStatus() {
        return this.status;
    }
}
