package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IShareLinkApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;", "", "conversationId", "", "target", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getTarget", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LocalShareLinkRequest {

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("target")
    private final String target;

    public static /* synthetic */ LocalShareLinkRequest copy$default(LocalShareLinkRequest localShareLinkRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localShareLinkRequest.conversationId;
        }
        if ((i & 2) != 0) {
            str2 = localShareLinkRequest.target;
        }
        return localShareLinkRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTarget() {
        return this.target;
    }

    public final LocalShareLinkRequest copy(String conversationId, String target) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(target, "target");
        return new LocalShareLinkRequest(conversationId, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalShareLinkRequest)) {
            return false;
        }
        LocalShareLinkRequest localShareLinkRequest = (LocalShareLinkRequest) other;
        return Intrinsics.areEqual(this.conversationId, localShareLinkRequest.conversationId) && Intrinsics.areEqual(this.target, localShareLinkRequest.target);
    }

    public int hashCode() {
        return (this.conversationId.hashCode() * 31) + this.target.hashCode();
    }

    public String toString() {
        return "LocalShareLinkRequest(conversationId=" + this.conversationId + ", target=" + this.target + ')';
    }

    public LocalShareLinkRequest(String conversationId, String target) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(target, "target");
        this.conversationId = conversationId;
        this.target = target;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getTarget() {
        return this.target;
    }
}
