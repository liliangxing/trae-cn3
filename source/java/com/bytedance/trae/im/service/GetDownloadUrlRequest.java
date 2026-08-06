package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IGetDownloadUrlApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JB\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;", "", "targets", "", "", "conversationId", "messageId", "checkExist", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getTargets", "()Ljava/util/List;", "getConversationId", "()Ljava/lang/String;", "getMessageId", "getCheckExist", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetDownloadUrlRequest {

    @SerializedName("check_exist")
    private final Boolean checkExist;

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID)
    private final String messageId;

    @SerializedName("targets")
    private final List<String> targets;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetDownloadUrlRequest copy$default(GetDownloadUrlRequest getDownloadUrlRequest, List list, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            list = getDownloadUrlRequest.targets;
        }
        if ((i & 2) != 0) {
            str = getDownloadUrlRequest.conversationId;
        }
        if ((i & 4) != 0) {
            str2 = getDownloadUrlRequest.messageId;
        }
        if ((i & 8) != 0) {
            bool = getDownloadUrlRequest.checkExist;
        }
        return getDownloadUrlRequest.copy(list, str, str2, bool);
    }

    public final List<String> component1() {
        return this.targets;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getCheckExist() {
        return this.checkExist;
    }

    public final GetDownloadUrlRequest copy(List<String> targets, String conversationId, String messageId, Boolean checkExist) {
        Intrinsics.checkNotNullParameter(targets, "targets");
        return new GetDownloadUrlRequest(targets, conversationId, messageId, checkExist);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetDownloadUrlRequest)) {
            return false;
        }
        GetDownloadUrlRequest getDownloadUrlRequest = (GetDownloadUrlRequest) other;
        return Intrinsics.areEqual(this.targets, getDownloadUrlRequest.targets) && Intrinsics.areEqual(this.conversationId, getDownloadUrlRequest.conversationId) && Intrinsics.areEqual(this.messageId, getDownloadUrlRequest.messageId) && Intrinsics.areEqual(this.checkExist, getDownloadUrlRequest.checkExist);
    }

    public int hashCode() {
        int hashCode = this.targets.hashCode() * 31;
        String str = this.conversationId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.messageId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.checkExist;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "GetDownloadUrlRequest(targets=" + this.targets + ", conversationId=" + this.conversationId + ", messageId=" + this.messageId + ", checkExist=" + this.checkExist + ')';
    }

    public GetDownloadUrlRequest(List<String> targets, String str, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(targets, "targets");
        this.targets = targets;
        this.conversationId = str;
        this.messageId = str2;
        this.checkExist = bool;
    }

    public final List<String> getTargets() {
        return this.targets;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public /* synthetic */ GetDownloadUrlRequest(List list, String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : bool);
    }

    public final Boolean getCheckExist() {
        return this.checkExist;
    }
}
