package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedTaskContent;", "", DBDefinition.TASK_ID, "", "userMessageId", "messages", "", "Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTaskId", "()Ljava/lang/String;", "getUserMessageId", "getMessages", "()Ljava/util/List;", "setMessages", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParsedTaskContent {

    @SerializedName("messages")
    private List<ParsedPlanItemMessage> messages;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("user_message_id")
    private final String userMessageId;

    public ParsedTaskContent() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParsedTaskContent copy$default(ParsedTaskContent parsedTaskContent, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parsedTaskContent.taskId;
        }
        if ((i & 2) != 0) {
            str2 = parsedTaskContent.userMessageId;
        }
        if ((i & 4) != 0) {
            list = parsedTaskContent.messages;
        }
        return parsedTaskContent.copy(str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserMessageId() {
        return this.userMessageId;
    }

    public final List<ParsedPlanItemMessage> component3() {
        return this.messages;
    }

    public final ParsedTaskContent copy(String taskId, String userMessageId, List<ParsedPlanItemMessage> messages) {
        return new ParsedTaskContent(taskId, userMessageId, messages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedTaskContent)) {
            return false;
        }
        ParsedTaskContent parsedTaskContent = (ParsedTaskContent) other;
        return Intrinsics.areEqual(this.taskId, parsedTaskContent.taskId) && Intrinsics.areEqual(this.userMessageId, parsedTaskContent.userMessageId) && Intrinsics.areEqual(this.messages, parsedTaskContent.messages);
    }

    public int hashCode() {
        String str = this.taskId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userMessageId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ParsedPlanItemMessage> list = this.messages;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ParsedTaskContent(taskId=" + this.taskId + ", userMessageId=" + this.userMessageId + ", messages=" + this.messages + ')';
    }

    public ParsedTaskContent(String str, String str2, List<ParsedPlanItemMessage> list) {
        this.taskId = str;
        this.userMessageId = str2;
        this.messages = list;
    }

    public /* synthetic */ ParsedTaskContent(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getUserMessageId() {
        return this.userMessageId;
    }

    public final List<ParsedPlanItemMessage> getMessages() {
        return this.messages;
    }

    public final void setMessages(List<ParsedPlanItemMessage> list) {
        this.messages = list;
    }
}
