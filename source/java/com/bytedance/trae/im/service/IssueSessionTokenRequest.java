package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IChatSessionAuthApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/im/service/IssueSessionTokenRequest;", "", "chatSessionId", "", "chatSessionIdSnake", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getChatSessionId", "()Ljava/lang/String;", "getChatSessionIdSnake", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class IssueSessionTokenRequest {

    @SerializedName("chatSessionId")
    private final String chatSessionId;

    @SerializedName("chat_session_id")
    private final String chatSessionIdSnake;

    public static /* synthetic */ IssueSessionTokenRequest copy$default(IssueSessionTokenRequest issueSessionTokenRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = issueSessionTokenRequest.chatSessionId;
        }
        if ((i & 2) != 0) {
            str2 = issueSessionTokenRequest.chatSessionIdSnake;
        }
        return issueSessionTokenRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChatSessionIdSnake() {
        return this.chatSessionIdSnake;
    }

    public final IssueSessionTokenRequest copy(String chatSessionId, String chatSessionIdSnake) {
        Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
        Intrinsics.checkNotNullParameter(chatSessionIdSnake, "chatSessionIdSnake");
        return new IssueSessionTokenRequest(chatSessionId, chatSessionIdSnake);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IssueSessionTokenRequest)) {
            return false;
        }
        IssueSessionTokenRequest issueSessionTokenRequest = (IssueSessionTokenRequest) other;
        return Intrinsics.areEqual(this.chatSessionId, issueSessionTokenRequest.chatSessionId) && Intrinsics.areEqual(this.chatSessionIdSnake, issueSessionTokenRequest.chatSessionIdSnake);
    }

    public int hashCode() {
        return (this.chatSessionId.hashCode() * 31) + this.chatSessionIdSnake.hashCode();
    }

    public String toString() {
        return "IssueSessionTokenRequest(chatSessionId=" + this.chatSessionId + ", chatSessionIdSnake=" + this.chatSessionIdSnake + ')';
    }

    public IssueSessionTokenRequest(String chatSessionId, String chatSessionIdSnake) {
        Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
        Intrinsics.checkNotNullParameter(chatSessionIdSnake, "chatSessionIdSnake");
        this.chatSessionId = chatSessionId;
        this.chatSessionIdSnake = chatSessionIdSnake;
    }

    public /* synthetic */ IssueSessionTokenRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? str : str2);
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getChatSessionIdSnake() {
        return this.chatSessionIdSnake;
    }
}
