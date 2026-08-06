package com.bytedance.trae.im.service;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IChatSessionApi.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0006HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a¨\u0006F"}, d2 = {"Lcom/bytedance/trae/im/service/ChatSessionResponse;", "", "chatSessionId", "", "userId", PageDataManager.EXTRA_STATUS, "", "mode", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/trae/im/service/ChatSessionSource;", "target", "Lcom/bytedance/trae/im/service/ChatSessionTarget;", "title", "createdAt", "updatedAt", "sandbox", "Lcom/bytedance/trae/im/service/ChatSessionSandbox;", "explorerUrl", "vncTemplateUrl", "previewUrl", "workspacePath", "remoteProjectId", "uploadsPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/trae/im/service/ChatSessionSource;Lcom/bytedance/trae/im/service/ChatSessionTarget;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ChatSessionSandbox;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChatSessionId", "()Ljava/lang/String;", "getUserId", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMode", "getSource", "()Lcom/bytedance/trae/im/service/ChatSessionSource;", "getTarget", "()Lcom/bytedance/trae/im/service/ChatSessionTarget;", "getTitle", "getCreatedAt", "getUpdatedAt", "getSandbox", "()Lcom/bytedance/trae/im/service/ChatSessionSandbox;", "getExplorerUrl", "getVncTemplateUrl", "getPreviewUrl", "getWorkspacePath", "getRemoteProjectId", "getUploadsPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/trae/im/service/ChatSessionSource;Lcom/bytedance/trae/im/service/ChatSessionTarget;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ChatSessionSandbox;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatSessionResponse;", "equals", "", "other", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ChatSessionResponse {

    @SerializedName("chat_session_id")
    private final String chatSessionId;

    @SerializedName("created_at")
    private final String createdAt;

    @SerializedName("explorer_url")
    private final String explorerUrl;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("preview_url")
    private final String previewUrl;

    @SerializedName("remote_project_id")
    private final String remoteProjectId;

    @SerializedName("sandbox")
    private final ChatSessionSandbox sandbox;

    @SerializedName(TimonPipeline.KEY_SOURCE)
    private final ChatSessionSource source;

    @SerializedName(PageDataManager.EXTRA_STATUS)
    private final Integer status;

    @SerializedName("target")
    private final ChatSessionTarget target;

    @SerializedName("title")
    private final String title;

    @SerializedName("updated_at")
    private final String updatedAt;

    @SerializedName("uploads_path")
    private final String uploadsPath;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("vnc_template_url")
    private final String vncTemplateUrl;

    @SerializedName("workspace_path")
    private final String workspacePath;

    public ChatSessionResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component10, reason: from getter */
    public final ChatSessionSandbox getSandbox() {
        return this.sandbox;
    }

    /* renamed from: component11, reason: from getter */
    public final String getExplorerUrl() {
        return this.explorerUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final String getVncTemplateUrl() {
        return this.vncTemplateUrl;
    }

    /* renamed from: component13, reason: from getter */
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    /* renamed from: component14, reason: from getter */
    public final String getWorkspacePath() {
        return this.workspacePath;
    }

    /* renamed from: component15, reason: from getter */
    public final String getRemoteProjectId() {
        return this.remoteProjectId;
    }

    /* renamed from: component16, reason: from getter */
    public final String getUploadsPath() {
        return this.uploadsPath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component5, reason: from getter */
    public final ChatSessionSource getSource() {
        return this.source;
    }

    /* renamed from: component6, reason: from getter */
    public final ChatSessionTarget getTarget() {
        return this.target;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component9, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final ChatSessionResponse copy(String chatSessionId, String userId, Integer status, String mode, ChatSessionSource source, ChatSessionTarget target, String title, String createdAt, String updatedAt, ChatSessionSandbox sandbox, String explorerUrl, String vncTemplateUrl, String previewUrl, String workspacePath, String remoteProjectId, String uploadsPath) {
        return new ChatSessionResponse(chatSessionId, userId, status, mode, source, target, title, createdAt, updatedAt, sandbox, explorerUrl, vncTemplateUrl, previewUrl, workspacePath, remoteProjectId, uploadsPath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatSessionResponse)) {
            return false;
        }
        ChatSessionResponse chatSessionResponse = (ChatSessionResponse) other;
        return Intrinsics.areEqual(this.chatSessionId, chatSessionResponse.chatSessionId) && Intrinsics.areEqual(this.userId, chatSessionResponse.userId) && Intrinsics.areEqual(this.status, chatSessionResponse.status) && Intrinsics.areEqual(this.mode, chatSessionResponse.mode) && Intrinsics.areEqual(this.source, chatSessionResponse.source) && Intrinsics.areEqual(this.target, chatSessionResponse.target) && Intrinsics.areEqual(this.title, chatSessionResponse.title) && Intrinsics.areEqual(this.createdAt, chatSessionResponse.createdAt) && Intrinsics.areEqual(this.updatedAt, chatSessionResponse.updatedAt) && Intrinsics.areEqual(this.sandbox, chatSessionResponse.sandbox) && Intrinsics.areEqual(this.explorerUrl, chatSessionResponse.explorerUrl) && Intrinsics.areEqual(this.vncTemplateUrl, chatSessionResponse.vncTemplateUrl) && Intrinsics.areEqual(this.previewUrl, chatSessionResponse.previewUrl) && Intrinsics.areEqual(this.workspacePath, chatSessionResponse.workspacePath) && Intrinsics.areEqual(this.remoteProjectId, chatSessionResponse.remoteProjectId) && Intrinsics.areEqual(this.uploadsPath, chatSessionResponse.uploadsPath);
    }

    public int hashCode() {
        String str = this.chatSessionId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.status;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.mode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ChatSessionSource chatSessionSource = this.source;
        int hashCode5 = (hashCode4 + (chatSessionSource == null ? 0 : chatSessionSource.hashCode())) * 31;
        ChatSessionTarget chatSessionTarget = this.target;
        int hashCode6 = (hashCode5 + (chatSessionTarget == null ? 0 : chatSessionTarget.hashCode())) * 31;
        String str4 = this.title;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.createdAt;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.updatedAt;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ChatSessionSandbox chatSessionSandbox = this.sandbox;
        int hashCode10 = (hashCode9 + (chatSessionSandbox == null ? 0 : chatSessionSandbox.hashCode())) * 31;
        String str7 = this.explorerUrl;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.vncTemplateUrl;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.previewUrl;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.workspacePath;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.remoteProjectId;
        int hashCode15 = (hashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.uploadsPath;
        return hashCode15 + (str12 != null ? str12.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChatSessionResponse(chatSessionId=");
        sb.append(this.chatSessionId).append(", userId=").append(this.userId).append(", status=").append(this.status).append(", mode=").append(this.mode).append(", source=").append(this.source).append(", target=").append(this.target).append(", title=").append(this.title).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", sandbox=").append(this.sandbox).append(", explorerUrl=").append(this.explorerUrl).append(", vncTemplateUrl=");
        sb.append(this.vncTemplateUrl).append(", previewUrl=").append(this.previewUrl).append(", workspacePath=").append(this.workspacePath).append(", remoteProjectId=").append(this.remoteProjectId).append(", uploadsPath=").append(this.uploadsPath).append(')');
        return sb.toString();
    }

    public ChatSessionResponse(String str, String str2, Integer num, String str3, ChatSessionSource chatSessionSource, ChatSessionTarget chatSessionTarget, String str4, String str5, String str6, ChatSessionSandbox chatSessionSandbox, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.chatSessionId = str;
        this.userId = str2;
        this.status = num;
        this.mode = str3;
        this.source = chatSessionSource;
        this.target = chatSessionTarget;
        this.title = str4;
        this.createdAt = str5;
        this.updatedAt = str6;
        this.sandbox = chatSessionSandbox;
        this.explorerUrl = str7;
        this.vncTemplateUrl = str8;
        this.previewUrl = str9;
        this.workspacePath = str10;
        this.remoteProjectId = str11;
        this.uploadsPath = str12;
    }

    public /* synthetic */ ChatSessionResponse(String str, String str2, Integer num, String str3, ChatSessionSource chatSessionSource, ChatSessionTarget chatSessionTarget, String str4, String str5, String str6, ChatSessionSandbox chatSessionSandbox, String str7, String str8, String str9, String str10, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : chatSessionSource, (i & 32) != 0 ? null : chatSessionTarget, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str6, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : chatSessionSandbox, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12);
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getMode() {
        return this.mode;
    }

    public final ChatSessionSource getSource() {
        return this.source;
    }

    public final ChatSessionTarget getTarget() {
        return this.target;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final ChatSessionSandbox getSandbox() {
        return this.sandbox;
    }

    public final String getExplorerUrl() {
        return this.explorerUrl;
    }

    public final String getVncTemplateUrl() {
        return this.vncTemplateUrl;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getWorkspacePath() {
        return this.workspacePath;
    }

    public final String getRemoteProjectId() {
        return this.remoteProjectId;
    }

    public final String getUploadsPath() {
        return this.uploadsPath;
    }
}
