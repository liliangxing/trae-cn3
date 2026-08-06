package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;", "", "conversationId", "", "cliConversationId", "sandboxName", "sandboxType", "status", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getConversationId", "()Ljava/lang/String;", "getCliConversationId", "getSandboxName", "getSandboxType", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "matches", "", "chatSessionId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RealtimeSandboxStatusUpdate {

    @SerializedName("cli_conversation_id")
    private final String cliConversationId;

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("sandbox_name")
    private final String sandboxName;

    @SerializedName("sandbox_type")
    private final String sandboxType;

    @SerializedName("status")
    private final Integer status;

    public RealtimeSandboxStatusUpdate() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ RealtimeSandboxStatusUpdate copy$default(RealtimeSandboxStatusUpdate realtimeSandboxStatusUpdate, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = realtimeSandboxStatusUpdate.conversationId;
        }
        if ((i & 2) != 0) {
            str2 = realtimeSandboxStatusUpdate.cliConversationId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = realtimeSandboxStatusUpdate.sandboxName;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = realtimeSandboxStatusUpdate.sandboxType;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            num = realtimeSandboxStatusUpdate.status;
        }
        return realtimeSandboxStatusUpdate.copy(str, str5, str6, str7, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSandboxName() {
        return this.sandboxName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSandboxType() {
        return this.sandboxType;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    public final RealtimeSandboxStatusUpdate copy(String conversationId, String cliConversationId, String sandboxName, String sandboxType, Integer status) {
        return new RealtimeSandboxStatusUpdate(conversationId, cliConversationId, sandboxName, sandboxType, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RealtimeSandboxStatusUpdate)) {
            return false;
        }
        RealtimeSandboxStatusUpdate realtimeSandboxStatusUpdate = (RealtimeSandboxStatusUpdate) other;
        return Intrinsics.areEqual(this.conversationId, realtimeSandboxStatusUpdate.conversationId) && Intrinsics.areEqual(this.cliConversationId, realtimeSandboxStatusUpdate.cliConversationId) && Intrinsics.areEqual(this.sandboxName, realtimeSandboxStatusUpdate.sandboxName) && Intrinsics.areEqual(this.sandboxType, realtimeSandboxStatusUpdate.sandboxType) && Intrinsics.areEqual(this.status, realtimeSandboxStatusUpdate.status);
    }

    public int hashCode() {
        String str = this.conversationId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cliConversationId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sandboxName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sandboxType;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.status;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "RealtimeSandboxStatusUpdate(conversationId=" + this.conversationId + ", cliConversationId=" + this.cliConversationId + ", sandboxName=" + this.sandboxName + ", sandboxType=" + this.sandboxType + ", status=" + this.status + ')';
    }

    public RealtimeSandboxStatusUpdate(String str, String str2, String str3, String str4, Integer num) {
        this.conversationId = str;
        this.cliConversationId = str2;
        this.sandboxName = str3;
        this.sandboxType = str4;
        this.status = num;
    }

    public /* synthetic */ RealtimeSandboxStatusUpdate(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    public final String getSandboxName() {
        return this.sandboxName;
    }

    public final String getSandboxType() {
        return this.sandboxType;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final boolean matches(String chatSessionId) {
        Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
        return Intrinsics.areEqual(this.conversationId, chatSessionId) || Intrinsics.areEqual(this.cliConversationId, chatSessionId);
    }
}
