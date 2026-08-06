package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateTaskCheck.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;", "", "conversationId", "", "<init>", "(Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateTaskCheckRequest {

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    public static /* synthetic */ CreateTaskCheckRequest copy$default(CreateTaskCheckRequest createTaskCheckRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createTaskCheckRequest.conversationId;
        }
        return createTaskCheckRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    public final CreateTaskCheckRequest copy(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        return new CreateTaskCheckRequest(conversationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CreateTaskCheckRequest) && Intrinsics.areEqual(this.conversationId, ((CreateTaskCheckRequest) other).conversationId);
    }

    public int hashCode() {
        return this.conversationId.hashCode();
    }

    public String toString() {
        return "CreateTaskCheckRequest(conversationId=" + this.conversationId + ')';
    }

    public CreateTaskCheckRequest(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        this.conversationId = conversationId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }
}
