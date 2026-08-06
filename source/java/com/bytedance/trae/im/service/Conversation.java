package com.bytedance.trae.im.service;

import androidx.compose.ui.spatial.RectListKt;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.model.MessagePart;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import com.ss.ttm.utils.AVLogger;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListConversationsService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bM\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b \u0010!J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010;J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÆ\u0002\u0010h\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020\u001e2\b\u0010k\u001a\u0004\u0018\u00010lHÖ\u0003J\t\u0010m\u001a\u00020\u0018HÖ\u0001J\t\u0010n\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010.R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010.R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010#R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010#R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010#R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010B\u001a\u0004\b\u001d\u0010AR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010#R\u0013\u0010D\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bE\u0010#R\u0011\u0010F\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bI\u0010#R\u0013\u0010J\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bK\u0010#R\u0013\u0010L\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bM\u0010#¨\u0006o"}, d2 = {"Lcom/bytedance/trae/im/service/Conversation;", "Ljava/io/Serializable;", "id", "", "parentConversationId", "hiddenStatus", "cliConversationId", "userId", "cliId", "title", MessagePart.TYPE_WORKSPACE, "gitUri", "mode", "status", "environment", "latestTaskId", "latestTaskStatus", "latestTaskUpdateTime", "createdAt", "updatedAt", "source", "Lcom/bytedance/trae/im/service/ConversationSource;", "iconType", "cliConversationStatus", "", "ownerProjectId", "latestProjectId", "ownerProjectAbsolutePath", "ownerProjectWorkSpaceStatus", "isPinned", "", "pinnedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ConversationSource;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getParentConversationId", "getHiddenStatus", "getCliConversationId", "getUserId", "getCliId", "getTitle", "getWorkspace", "getGitUri", "getMode", "setMode", "(Ljava/lang/String;)V", "getStatus", "getEnvironment", "setEnvironment", "getLatestTaskId", "getLatestTaskStatus", "getLatestTaskUpdateTime", "getCreatedAt", "getUpdatedAt", "getSource", "()Lcom/bytedance/trae/im/service/ConversationSource;", "getIconType", "getCliConversationStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOwnerProjectId", "getLatestProjectId", "getOwnerProjectAbsolutePath", "getOwnerProjectWorkSpaceStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPinnedAt", "displayEnvironment", "getDisplayEnvironment", "isLocal", "()Z", "displayWorkspace", "getDisplayWorkspace", "displayGitUri", "getDisplayGitUri", "displayRepoName", "getDisplayRepoName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ConversationSource;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/trae/im/service/Conversation;", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Conversation implements Serializable {

    @SerializedName("cli_conversation_id")
    private final String cliConversationId;

    @SerializedName("cli_conversation_status")
    private final Integer cliConversationStatus;

    @SerializedName("cli_id")
    private final String cliId;

    @SerializedName("created_at")
    private final String createdAt;

    @SerializedName("cli_type")
    private String environment;

    @SerializedName("git_uri")
    private final String gitUri;

    @SerializedName("hidden_status")
    private final String hiddenStatus;

    @SerializedName("icon_type")
    private final String iconType;

    @SerializedName(alternate = {"chat_session_id"}, value = "id")
    private final String id;

    @SerializedName("is_pinned")
    private final Boolean isPinned;

    @SerializedName("latest_project_id")
    private final String latestProjectId;

    @SerializedName("latest_task_id")
    private final String latestTaskId;

    @SerializedName("latest_task_status")
    private final String latestTaskStatus;

    @SerializedName("latest_task_update_time")
    private final String latestTaskUpdateTime;

    @SerializedName("mode")
    private String mode;

    @SerializedName("owner_project_absolute_path")
    private final String ownerProjectAbsolutePath;

    @SerializedName("owner_project_id")
    private final String ownerProjectId;

    @SerializedName("owner_project_workspace_status")
    private final String ownerProjectWorkSpaceStatus;

    @SerializedName("parent_conversation_id")
    private final String parentConversationId;

    @SerializedName("pinned_at")
    private final String pinnedAt;

    @SerializedName("source")
    private final ConversationSource source;

    @SerializedName("status")
    private final String status;

    @SerializedName("title")
    private final String title;

    @SerializedName("updated_at")
    private final String updatedAt;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName(MessagePart.TYPE_WORKSPACE)
    private final String workspace;

    public Conversation() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, RectListKt.Lower26Bits, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component11, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component12, reason: from getter */
    public final String getEnvironment() {
        return this.environment;
    }

    /* renamed from: component13, reason: from getter */
    public final String getLatestTaskId() {
        return this.latestTaskId;
    }

    /* renamed from: component14, reason: from getter */
    public final String getLatestTaskStatus() {
        return this.latestTaskStatus;
    }

    /* renamed from: component15, reason: from getter */
    public final String getLatestTaskUpdateTime() {
        return this.latestTaskUpdateTime;
    }

    /* renamed from: component16, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component17, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component18, reason: from getter */
    public final ConversationSource getSource() {
        return this.source;
    }

    /* renamed from: component19, reason: from getter */
    public final String getIconType() {
        return this.iconType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    /* renamed from: component20, reason: from getter */
    public final Integer getCliConversationStatus() {
        return this.cliConversationStatus;
    }

    /* renamed from: component21, reason: from getter */
    public final String getOwnerProjectId() {
        return this.ownerProjectId;
    }

    /* renamed from: component22, reason: from getter */
    public final String getLatestProjectId() {
        return this.latestProjectId;
    }

    /* renamed from: component23, reason: from getter */
    public final String getOwnerProjectAbsolutePath() {
        return this.ownerProjectAbsolutePath;
    }

    /* renamed from: component24, reason: from getter */
    public final String getOwnerProjectWorkSpaceStatus() {
        return this.ownerProjectWorkSpaceStatus;
    }

    /* renamed from: component25, reason: from getter */
    public final Boolean getIsPinned() {
        return this.isPinned;
    }

    /* renamed from: component26, reason: from getter */
    public final String getPinnedAt() {
        return this.pinnedAt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHiddenStatus() {
        return this.hiddenStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component8, reason: from getter */
    public final String getWorkspace() {
        return this.workspace;
    }

    /* renamed from: component9, reason: from getter */
    public final String getGitUri() {
        return this.gitUri;
    }

    public final Conversation copy(String id, String parentConversationId, String hiddenStatus, String cliConversationId, String userId, String cliId, String title, String workspace, String gitUri, String mode, String status, String environment, String latestTaskId, String latestTaskStatus, String latestTaskUpdateTime, String createdAt, String updatedAt, ConversationSource source, String iconType, Integer cliConversationStatus, String ownerProjectId, String latestProjectId, String ownerProjectAbsolutePath, String ownerProjectWorkSpaceStatus, Boolean isPinned, String pinnedAt) {
        return new Conversation(id, parentConversationId, hiddenStatus, cliConversationId, userId, cliId, title, workspace, gitUri, mode, status, environment, latestTaskId, latestTaskStatus, latestTaskUpdateTime, createdAt, updatedAt, source, iconType, cliConversationStatus, ownerProjectId, latestProjectId, ownerProjectAbsolutePath, ownerProjectWorkSpaceStatus, isPinned, pinnedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Conversation)) {
            return false;
        }
        Conversation conversation = (Conversation) other;
        return Intrinsics.areEqual(this.id, conversation.id) && Intrinsics.areEqual(this.parentConversationId, conversation.parentConversationId) && Intrinsics.areEqual(this.hiddenStatus, conversation.hiddenStatus) && Intrinsics.areEqual(this.cliConversationId, conversation.cliConversationId) && Intrinsics.areEqual(this.userId, conversation.userId) && Intrinsics.areEqual(this.cliId, conversation.cliId) && Intrinsics.areEqual(this.title, conversation.title) && Intrinsics.areEqual(this.workspace, conversation.workspace) && Intrinsics.areEqual(this.gitUri, conversation.gitUri) && Intrinsics.areEqual(this.mode, conversation.mode) && Intrinsics.areEqual(this.status, conversation.status) && Intrinsics.areEqual(this.environment, conversation.environment) && Intrinsics.areEqual(this.latestTaskId, conversation.latestTaskId) && Intrinsics.areEqual(this.latestTaskStatus, conversation.latestTaskStatus) && Intrinsics.areEqual(this.latestTaskUpdateTime, conversation.latestTaskUpdateTime) && Intrinsics.areEqual(this.createdAt, conversation.createdAt) && Intrinsics.areEqual(this.updatedAt, conversation.updatedAt) && Intrinsics.areEqual(this.source, conversation.source) && Intrinsics.areEqual(this.iconType, conversation.iconType) && Intrinsics.areEqual(this.cliConversationStatus, conversation.cliConversationStatus) && Intrinsics.areEqual(this.ownerProjectId, conversation.ownerProjectId) && Intrinsics.areEqual(this.latestProjectId, conversation.latestProjectId) && Intrinsics.areEqual(this.ownerProjectAbsolutePath, conversation.ownerProjectAbsolutePath) && Intrinsics.areEqual(this.ownerProjectWorkSpaceStatus, conversation.ownerProjectWorkSpaceStatus) && Intrinsics.areEqual(this.isPinned, conversation.isPinned) && Intrinsics.areEqual(this.pinnedAt, conversation.pinnedAt);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.parentConversationId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.hiddenStatus;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cliConversationId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.userId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.cliId;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.title;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.workspace;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.gitUri;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.mode;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.status;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.environment;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.latestTaskId;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.latestTaskStatus;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.latestTaskUpdateTime;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.createdAt;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.updatedAt;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        ConversationSource conversationSource = this.source;
        int hashCode18 = (hashCode17 + (conversationSource == null ? 0 : conversationSource.hashCode())) * 31;
        String str18 = this.iconType;
        int hashCode19 = (hashCode18 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Integer num = this.cliConversationStatus;
        int hashCode20 = (hashCode19 + (num == null ? 0 : num.hashCode())) * 31;
        String str19 = this.ownerProjectId;
        int hashCode21 = (hashCode20 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.latestProjectId;
        int hashCode22 = (hashCode21 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.ownerProjectAbsolutePath;
        int hashCode23 = (hashCode22 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.ownerProjectWorkSpaceStatus;
        int hashCode24 = (hashCode23 + (str22 == null ? 0 : str22.hashCode())) * 31;
        Boolean bool = this.isPinned;
        int hashCode25 = (hashCode24 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str23 = this.pinnedAt;
        return hashCode25 + (str23 != null ? str23.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Conversation(id=");
        sb.append(this.id).append(", parentConversationId=").append(this.parentConversationId).append(", hiddenStatus=").append(this.hiddenStatus).append(", cliConversationId=").append(this.cliConversationId).append(", userId=").append(this.userId).append(", cliId=").append(this.cliId).append(", title=").append(this.title).append(", workspace=").append(this.workspace).append(", gitUri=").append(this.gitUri).append(", mode=").append(this.mode).append(", status=").append(this.status).append(", environment=");
        sb.append(this.environment).append(", latestTaskId=").append(this.latestTaskId).append(", latestTaskStatus=").append(this.latestTaskStatus).append(", latestTaskUpdateTime=").append(this.latestTaskUpdateTime).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", source=").append(this.source).append(", iconType=").append(this.iconType).append(", cliConversationStatus=").append(this.cliConversationStatus).append(", ownerProjectId=").append(this.ownerProjectId).append(", latestProjectId=").append(this.latestProjectId).append(", ownerProjectAbsolutePath=").append(this.ownerProjectAbsolutePath);
        sb.append(", ownerProjectWorkSpaceStatus=").append(this.ownerProjectWorkSpaceStatus).append(", isPinned=").append(this.isPinned).append(", pinnedAt=").append(this.pinnedAt).append(')');
        return sb.toString();
    }

    public Conversation(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ConversationSource conversationSource, String str18, Integer num, String str19, String str20, String str21, String str22, Boolean bool, String str23) {
        this.id = str;
        this.parentConversationId = str2;
        this.hiddenStatus = str3;
        this.cliConversationId = str4;
        this.userId = str5;
        this.cliId = str6;
        this.title = str7;
        this.workspace = str8;
        this.gitUri = str9;
        this.mode = str10;
        this.status = str11;
        this.environment = str12;
        this.latestTaskId = str13;
        this.latestTaskStatus = str14;
        this.latestTaskUpdateTime = str15;
        this.createdAt = str16;
        this.updatedAt = str17;
        this.source = conversationSource;
        this.iconType = str18;
        this.cliConversationStatus = num;
        this.ownerProjectId = str19;
        this.latestProjectId = str20;
        this.ownerProjectAbsolutePath = str21;
        this.ownerProjectWorkSpaceStatus = str22;
        this.isPinned = bool;
        this.pinnedAt = str23;
    }

    public /* synthetic */ Conversation(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ConversationSource conversationSource, String str18, Integer num, String str19, String str20, String str21, String str22, Boolean bool, String str23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : str17, (i & 131072) != 0 ? null : conversationSource, (i & 262144) != 0 ? null : str18, (i & 524288) != 0 ? null : num, (i & 1048576) != 0 ? null : str19, (i & 2097152) != 0 ? null : str20, (i & 4194304) != 0 ? null : str21, (i & 8388608) != 0 ? null : str22, (i & 16777216) != 0 ? null : bool, (i & AVLogger.LEVEL_LOG_INFO) != 0 ? null : str23);
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

    public final String getCliConversationId() {
        return this.cliConversationId;
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

    public final String getWorkspace() {
        return this.workspace;
    }

    public final String getGitUri() {
        return this.gitUri;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getEnvironment() {
        return this.environment;
    }

    public final void setEnvironment(String str) {
        this.environment = str;
    }

    public final String getLatestTaskId() {
        return this.latestTaskId;
    }

    public final String getLatestTaskStatus() {
        return this.latestTaskStatus;
    }

    public final String getLatestTaskUpdateTime() {
        return this.latestTaskUpdateTime;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final ConversationSource getSource() {
        return this.source;
    }

    public final String getIconType() {
        return this.iconType;
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

    public final Boolean isPinned() {
        return this.isPinned;
    }

    public final String getPinnedAt() {
        return this.pinnedAt;
    }

    public final String getDisplayEnvironment() {
        String str = this.environment;
        return str == null ? "remote" : str;
    }

    public final boolean isLocal() {
        return Intrinsics.areEqual(this.environment, ImagesContract.LOCAL) || Intrinsics.areEqual(this.environment, "local_ide");
    }

    public final String getDisplayWorkspace() {
        String str = this.workspace;
        if (str != null) {
            return str;
        }
        ConversationSource conversationSource = this.source;
        String remoteFolder = conversationSource != null ? conversationSource.getRemoteFolder() : null;
        if (remoteFolder != null) {
            return remoteFolder;
        }
        ConversationSource conversationSource2 = this.source;
        if (conversationSource2 != null) {
            return conversationSource2.getLocalFolder();
        }
        return null;
    }

    public final String getDisplayGitUri() {
        String str = this.gitUri;
        if (str != null) {
            return str;
        }
        ConversationSource conversationSource = this.source;
        if (conversationSource != null) {
            return conversationSource.getRepoUrl();
        }
        return null;
    }

    public final String getDisplayRepoName() {
        ConversationSource conversationSource = this.source;
        if (conversationSource != null) {
            return conversationSource.getRepoName();
        }
        return null;
    }
}
