package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IReportMessageApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/service/ReportMessageRequest;", "", "conversationId", "", "messageId", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getMessageId", "getContent", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ReportMessageRequest {

    @SerializedName("content")
    private final String content;

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID)
    private final String messageId;

    public static /* synthetic */ ReportMessageRequest copy$default(ReportMessageRequest reportMessageRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reportMessageRequest.conversationId;
        }
        if ((i & 2) != 0) {
            str2 = reportMessageRequest.messageId;
        }
        if ((i & 4) != 0) {
            str3 = reportMessageRequest.content;
        }
        return reportMessageRequest.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final ReportMessageRequest copy(String conversationId, String messageId, String content) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(content, "content");
        return new ReportMessageRequest(conversationId, messageId, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportMessageRequest)) {
            return false;
        }
        ReportMessageRequest reportMessageRequest = (ReportMessageRequest) other;
        return Intrinsics.areEqual(this.conversationId, reportMessageRequest.conversationId) && Intrinsics.areEqual(this.messageId, reportMessageRequest.messageId) && Intrinsics.areEqual(this.content, reportMessageRequest.content);
    }

    public int hashCode() {
        return (((this.conversationId.hashCode() * 31) + this.messageId.hashCode()) * 31) + this.content.hashCode();
    }

    public String toString() {
        return "ReportMessageRequest(conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", content=" + this.content + ')';
    }

    public ReportMessageRequest(String conversationId, String messageId, String content) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(content, "content");
        this.conversationId = conversationId;
        this.messageId = messageId;
        this.content = content;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getContent() {
        return this.content;
    }
}
