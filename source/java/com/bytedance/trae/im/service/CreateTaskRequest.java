package com.bytedance.trae.im.service;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\t\u0010<\u001a\u00020\u0010HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J×\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010C\u001a\u00020\u00102\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001c¨\u0006H"}, d2 = {"Lcom/bytedance/trae/im/service/CreateTaskRequest;", "", "conversationId", "", "parentConversationId", "sessionType", "hiddenStatus", "cliId", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "mode", "projectId", "workspaceDir", "workspaceFolders", "", "autoCreateProject", "", "query", "Lcom/bytedance/trae/im/service/InitialMessage;", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/trae/im/service/Source;", "origin", "extra", "", "commonParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/CliType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLcom/bytedance/trae/im/service/InitialMessage;Lcom/bytedance/trae/im/service/Source;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getParentConversationId", "getSessionType", "getHiddenStatus", "getCliId", "getCliType", "()Lcom/bytedance/trae/im/service/CliType;", "getMode", "getProjectId", "getWorkspaceDir", "getWorkspaceFolders", "()Ljava/util/List;", "getAutoCreateProject", "()Z", "getQuery", "()Lcom/bytedance/trae/im/service/InitialMessage;", "getSource", "()Lcom/bytedance/trae/im/service/Source;", "getOrigin", "getExtra", "()Ljava/util/Map;", "getCommonParams", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class CreateTaskRequest {

    @SerializedName("auto_create_project")
    private final boolean autoCreateProject;

    @SerializedName("cli_id")
    private final String cliId;

    @SerializedName("cli_type")
    private final CliType cliType;

    @SerializedName("common_params")
    private final String commonParams;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("extra")
    private final Map<String, Object> extra;

    @SerializedName("hidden_status")
    private final String hiddenStatus;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("origin")
    private final String origin;

    @SerializedName("parent_conversation_id")
    private final String parentConversationId;

    @SerializedName("project_id")
    private final String projectId;

    @SerializedName("initial_message")
    private final InitialMessage query;

    @SerializedName("session_type")
    private final String sessionType;

    @SerializedName(TimonPipeline.KEY_SOURCE)
    private final Source source;

    @SerializedName("workspace_dir")
    private final String workspaceDir;

    @SerializedName("workspace_folders")
    private final List<String> workspaceFolders;

    /* renamed from: component1, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    public final List<String> component10() {
        return this.workspaceFolders;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getAutoCreateProject() {
        return this.autoCreateProject;
    }

    /* renamed from: component12, reason: from getter */
    public final InitialMessage getQuery() {
        return this.query;
    }

    /* renamed from: component13, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    /* renamed from: component14, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    public final Map<String, Object> component15() {
        return this.extra;
    }

    /* renamed from: component16, reason: from getter */
    public final String getCommonParams() {
        return this.commonParams;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionType() {
        return this.sessionType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHiddenStatus() {
        return this.hiddenStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component6, reason: from getter */
    public final CliType getCliType() {
        return this.cliType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component8, reason: from getter */
    public final String getProjectId() {
        return this.projectId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getWorkspaceDir() {
        return this.workspaceDir;
    }

    public final CreateTaskRequest copy(String conversationId, String parentConversationId, String sessionType, String hiddenStatus, String cliId, CliType cliType, String mode, String projectId, String workspaceDir, List<String> workspaceFolders, boolean autoCreateProject, InitialMessage query, Source source, String origin, Map<String, ? extends Object> extra, String commonParams) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        return new CreateTaskRequest(conversationId, parentConversationId, sessionType, hiddenStatus, cliId, cliType, mode, projectId, workspaceDir, workspaceFolders, autoCreateProject, query, source, origin, extra, commonParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateTaskRequest)) {
            return false;
        }
        CreateTaskRequest createTaskRequest = (CreateTaskRequest) other;
        return Intrinsics.areEqual(this.conversationId, createTaskRequest.conversationId) && Intrinsics.areEqual(this.parentConversationId, createTaskRequest.parentConversationId) && Intrinsics.areEqual(this.sessionType, createTaskRequest.sessionType) && Intrinsics.areEqual(this.hiddenStatus, createTaskRequest.hiddenStatus) && Intrinsics.areEqual(this.cliId, createTaskRequest.cliId) && this.cliType == createTaskRequest.cliType && Intrinsics.areEqual(this.mode, createTaskRequest.mode) && Intrinsics.areEqual(this.projectId, createTaskRequest.projectId) && Intrinsics.areEqual(this.workspaceDir, createTaskRequest.workspaceDir) && Intrinsics.areEqual(this.workspaceFolders, createTaskRequest.workspaceFolders) && this.autoCreateProject == createTaskRequest.autoCreateProject && Intrinsics.areEqual(this.query, createTaskRequest.query) && Intrinsics.areEqual(this.source, createTaskRequest.source) && Intrinsics.areEqual(this.origin, createTaskRequest.origin) && Intrinsics.areEqual(this.extra, createTaskRequest.extra) && Intrinsics.areEqual(this.commonParams, createTaskRequest.commonParams);
    }

    public int hashCode() {
        String str = this.conversationId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.parentConversationId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.hiddenStatus;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cliId;
        int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.cliType.hashCode()) * 31;
        String str6 = this.mode;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.projectId;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.workspaceDir;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<String> list = this.workspaceFolders;
        int hashCode9 = (((hashCode8 + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.autoCreateProject)) * 31;
        InitialMessage initialMessage = this.query;
        int hashCode10 = (hashCode9 + (initialMessage == null ? 0 : initialMessage.hashCode())) * 31;
        Source source = this.source;
        int hashCode11 = (hashCode10 + (source == null ? 0 : source.hashCode())) * 31;
        String str9 = this.origin;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Map<String, Object> map = this.extra;
        int hashCode13 = (hashCode12 + (map == null ? 0 : map.hashCode())) * 31;
        String str10 = this.commonParams;
        return hashCode13 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateTaskRequest(conversationId=");
        sb.append(this.conversationId).append(", parentConversationId=").append(this.parentConversationId).append(", sessionType=").append(this.sessionType).append(", hiddenStatus=").append(this.hiddenStatus).append(", cliId=").append(this.cliId).append(", cliType=").append(this.cliType).append(", mode=").append(this.mode).append(", projectId=").append(this.projectId).append(", workspaceDir=").append(this.workspaceDir).append(", workspaceFolders=").append(this.workspaceFolders).append(", autoCreateProject=").append(this.autoCreateProject).append(", query=");
        sb.append(this.query).append(", source=").append(this.source).append(", origin=").append(this.origin).append(", extra=").append(this.extra).append(", commonParams=").append(this.commonParams).append(')');
        return sb.toString();
    }

    public CreateTaskRequest(String str, String str2, String str3, String str4, String str5, CliType cliType, String str6, String str7, String str8, List<String> list, boolean z, InitialMessage initialMessage, Source source, String str9, Map<String, ? extends Object> map, String str10) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        this.conversationId = str;
        this.parentConversationId = str2;
        this.sessionType = str3;
        this.hiddenStatus = str4;
        this.cliId = str5;
        this.cliType = cliType;
        this.mode = str6;
        this.projectId = str7;
        this.workspaceDir = str8;
        this.workspaceFolders = list;
        this.autoCreateProject = z;
        this.query = initialMessage;
        this.source = source;
        this.origin = str9;
        this.extra = map;
        this.commonParams = str10;
    }

    public /* synthetic */ CreateTaskRequest(String str, String str2, String str3, String str4, String str5, CliType cliType, String str6, String str7, String str8, List list, boolean z, InitialMessage initialMessage, Source source, String str9, Map map, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, cliType, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, str8, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : list, (i & 1024) != 0 ? false : z, (i & 2048) != 0 ? null : initialMessage, (i & 4096) != 0 ? null : source, (i & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? null : str9, (i & 16384) != 0 ? null : map, (i & 32768) != 0 ? null : str10);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    public final String getSessionType() {
        return this.sessionType;
    }

    public final String getHiddenStatus() {
        return this.hiddenStatus;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final CliType getCliType() {
        return this.cliType;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getWorkspaceDir() {
        return this.workspaceDir;
    }

    public final List<String> getWorkspaceFolders() {
        return this.workspaceFolders;
    }

    public final boolean getAutoCreateProject() {
        return this.autoCreateProject;
    }

    public final InitialMessage getQuery() {
        return this.query;
    }

    public final Source getSource() {
        return this.source;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getCommonParams() {
        return this.commonParams;
    }
}
