package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u000fHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006@"}, d2 = {"Lcom/bytedance/trae/im/service/ConversationInfo;", "", "id", "", "parentConversationId", "hiddenStatus", "userId", "cliId", "title", "status", "createdAt", "updatedAt", "latestTaskId", "cliConversationId", "cliConversationStatus", "", "ownerProjectId", "latestProjectId", "ownerProjectAbsolutePath", "ownerProjectWorkSpaceStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getParentConversationId", "getHiddenStatus", "getUserId", "getCliId", "getTitle", "getStatus", "getCreatedAt", "getUpdatedAt", "getLatestTaskId", "getCliConversationId", "getCliConversationStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOwnerProjectId", "getLatestProjectId", "getOwnerProjectAbsolutePath", "getOwnerProjectWorkSpaceStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ConversationInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConversationInfo {

    @SerializedName("cli_conversation_id")
    private final String cliConversationId;

    @SerializedName("cli_conversation_status")
    private final Integer cliConversationStatus;

    @SerializedName("cli_id")
    private final String cliId;

    @SerializedName("created_at")
    private final String createdAt;

    @SerializedName("hidden_status")
    private final String hiddenStatus;

    @SerializedName("id")
    private final String id;

    @SerializedName("latest_project_id")
    private final String latestProjectId;

    @SerializedName("latest_task_id")
    private final String latestTaskId;

    @SerializedName("owner_project_absolute_path")
    private final String ownerProjectAbsolutePath;

    @SerializedName("owner_project_id")
    private final String ownerProjectId;

    @SerializedName("owner_project_workspace_status")
    private final String ownerProjectWorkSpaceStatus;

    @SerializedName("parent_conversation_id")
    private final String parentConversationId;

    @SerializedName("status")
    private final String status;

    @SerializedName("title")
    private final String title;

    @SerializedName("updated_at")
    private final String updatedAt;

    @SerializedName("user_id")
    private final String userId;

    public ConversationInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getLatestTaskId() {
        return this.latestTaskId;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getCliConversationStatus() {
        return this.cliConversationStatus;
    }

    /* renamed from: component13, reason: from getter */
    public final String getOwnerProjectId() {
        return this.ownerProjectId;
    }

    /* renamed from: component14, reason: from getter */
    public final String getLatestProjectId() {
        return this.latestProjectId;
    }

    /* renamed from: component15, reason: from getter */
    public final String getOwnerProjectAbsolutePath() {
        return this.ownerProjectAbsolutePath;
    }

    /* renamed from: component16, reason: from getter */
    public final String getOwnerProjectWorkSpaceStatus() {
        return this.ownerProjectWorkSpaceStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHiddenStatus() {
        return this.hiddenStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component9, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final ConversationInfo copy(String id, String parentConversationId, String hiddenStatus, String userId, String cliId, String title, String status, String createdAt, String updatedAt, String latestTaskId, String cliConversationId, Integer cliConversationStatus, String ownerProjectId, String latestProjectId, String ownerProjectAbsolutePath, String ownerProjectWorkSpaceStatus) {
        return new ConversationInfo(id, parentConversationId, hiddenStatus, userId, cliId, title, status, createdAt, updatedAt, latestTaskId, cliConversationId, cliConversationStatus, ownerProjectId, latestProjectId, ownerProjectAbsolutePath, ownerProjectWorkSpaceStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationInfo)) {
            return false;
        }
        ConversationInfo conversationInfo = (ConversationInfo) other;
        return Intrinsics.areEqual(this.id, conversationInfo.id) && Intrinsics.areEqual(this.parentConversationId, conversationInfo.parentConversationId) && Intrinsics.areEqual(this.hiddenStatus, conversationInfo.hiddenStatus) && Intrinsics.areEqual(this.userId, conversationInfo.userId) && Intrinsics.areEqual(this.cliId, conversationInfo.cliId) && Intrinsics.areEqual(this.title, conversationInfo.title) && Intrinsics.areEqual(this.status, conversationInfo.status) && Intrinsics.areEqual(this.createdAt, conversationInfo.createdAt) && Intrinsics.areEqual(this.updatedAt, conversationInfo.updatedAt) && Intrinsics.areEqual(this.latestTaskId, conversationInfo.latestTaskId) && Intrinsics.areEqual(this.cliConversationId, conversationInfo.cliConversationId) && Intrinsics.areEqual(this.cliConversationStatus, conversationInfo.cliConversationStatus) && Intrinsics.areEqual(this.ownerProjectId, conversationInfo.ownerProjectId) && Intrinsics.areEqual(this.latestProjectId, conversationInfo.latestProjectId) && Intrinsics.areEqual(this.ownerProjectAbsolutePath, conversationInfo.ownerProjectAbsolutePath) && Intrinsics.areEqual(this.ownerProjectWorkSpaceStatus, conversationInfo.ownerProjectWorkSpaceStatus);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.parentConversationId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.hiddenStatus;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.userId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cliId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.title;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.status;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.createdAt;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.updatedAt;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.latestTaskId;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.cliConversationId;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Integer num = this.cliConversationStatus;
        int hashCode12 = (hashCode11 + (num == null ? 0 : num.hashCode())) * 31;
        String str12 = this.ownerProjectId;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.latestProjectId;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.ownerProjectAbsolutePath;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.ownerProjectWorkSpaceStatus;
        return hashCode15 + (str15 != null ? str15.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConversationInfo(id=");
        sb.append(this.id).append(", parentConversationId=").append(this.parentConversationId).append(", hiddenStatus=").append(this.hiddenStatus).append(", userId=").append(this.userId).append(", cliId=").append(this.cliId).append(", title=").append(this.title).append(", status=").append(this.status).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", latestTaskId=").append(this.latestTaskId).append(", cliConversationId=").append(this.cliConversationId).append(", cliConversationStatus=");
        sb.append(this.cliConversationStatus).append(", ownerProjectId=").append(this.ownerProjectId).append(", latestProjectId=").append(this.latestProjectId).append(", ownerProjectAbsolutePath=").append(this.ownerProjectAbsolutePath).append(", ownerProjectWorkSpaceStatus=").append(this.ownerProjectWorkSpaceStatus).append(')');
        return sb.toString();
    }

    public ConversationInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, String str12, String str13, String str14, String str15) {
        this.id = str;
        this.parentConversationId = str2;
        this.hiddenStatus = str3;
        this.userId = str4;
        this.cliId = str5;
        this.title = str6;
        this.status = str7;
        this.createdAt = str8;
        this.updatedAt = str9;
        this.latestTaskId = str10;
        this.cliConversationId = str11;
        this.cliConversationStatus = num;
        this.ownerProjectId = str12;
        this.latestProjectId = str13;
        this.ownerProjectAbsolutePath = str14;
        this.ownerProjectWorkSpaceStatus = str15;
    }

    public /* synthetic */ ConversationInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : num, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? null : str14, (i & 32768) != 0 ? null : str15);
    }

    public final String getId() {
        return this.id;
    }

    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    public final String getHiddenStatus() {
        return this.hiddenStatus;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getLatestTaskId() {
        return this.latestTaskId;
    }

    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    public final Integer getCliConversationStatus() {
        return this.cliConversationStatus;
    }

    public final String getOwnerProjectId() {
        return this.ownerProjectId;
    }

    public final String getLatestProjectId() {
        return this.latestProjectId;
    }

    public final String getOwnerProjectAbsolutePath() {
        return this.ownerProjectAbsolutePath;
    }

    public final String getOwnerProjectWorkSpaceStatus() {
        return this.ownerProjectWorkSpaceStatus;
    }
}
