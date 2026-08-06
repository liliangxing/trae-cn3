package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 82\u00020\u0001:\u00018B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\t\u00100\u001a\u00020\u0011HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008b\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00103\u001a\u00020\u000f2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u00069"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "", "sourceTaskId", "", "taskDescription", "localTaskId", "proxyConversationId", "proxyChatSessionId", "state", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", ReportConstant.COMMON_CONTENT, "failureReason", "createStartedAtMs", "", "longRunning", "", "executor", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;", "toolName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;Ljava/lang/String;Ljava/lang/String;JZLcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;Ljava/lang/String;)V", "getSourceTaskId", "()Ljava/lang/String;", "getTaskDescription", "getLocalTaskId", "getProxyConversationId", "getProxyChatSessionId", "getState", "()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", "getContent", "getFailureReason", "getCreateStartedAtMs", "()J", "getLongRunning", "()Z", "getExecutor", "()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;", "getToolName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class SubTaskUiState {
    public static final long LONG_RUNNING_THRESHOLD_MS = 10000;
    private final String content;
    private final long createStartedAtMs;
    private final SubTaskExecutor executor;
    private final String failureReason;
    private final String localTaskId;
    private final boolean longRunning;
    private final String proxyChatSessionId;
    private final String proxyConversationId;
    private final String sourceTaskId;
    private final SubTaskRenderState state;
    private final String taskDescription;
    private final String toolName;

    /* renamed from: component1, reason: from getter */
    public final String getSourceTaskId() {
        return this.sourceTaskId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getLongRunning() {
        return this.longRunning;
    }

    /* renamed from: component11, reason: from getter */
    public final SubTaskExecutor getExecutor() {
        return this.executor;
    }

    /* renamed from: component12, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskDescription() {
        return this.taskDescription;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLocalTaskId() {
        return this.localTaskId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getProxyConversationId() {
        return this.proxyConversationId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getProxyChatSessionId() {
        return this.proxyChatSessionId;
    }

    /* renamed from: component6, reason: from getter */
    public final SubTaskRenderState getState() {
        return this.state;
    }

    /* renamed from: component7, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFailureReason() {
        return this.failureReason;
    }

    /* renamed from: component9, reason: from getter */
    public final long getCreateStartedAtMs() {
        return this.createStartedAtMs;
    }

    public final SubTaskUiState copy(String sourceTaskId, String taskDescription, String localTaskId, String proxyConversationId, String proxyChatSessionId, SubTaskRenderState state, String content, String failureReason, long createStartedAtMs, boolean longRunning, SubTaskExecutor executor, String toolName) {
        Intrinsics.checkNotNullParameter(sourceTaskId, "sourceTaskId");
        Intrinsics.checkNotNullParameter(taskDescription, "taskDescription");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        Intrinsics.checkNotNullParameter(executor, "executor");
        return new SubTaskUiState(sourceTaskId, taskDescription, localTaskId, proxyConversationId, proxyChatSessionId, state, content, failureReason, createStartedAtMs, longRunning, executor, toolName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubTaskUiState)) {
            return false;
        }
        SubTaskUiState subTaskUiState = (SubTaskUiState) other;
        return Intrinsics.areEqual(this.sourceTaskId, subTaskUiState.sourceTaskId) && Intrinsics.areEqual(this.taskDescription, subTaskUiState.taskDescription) && Intrinsics.areEqual(this.localTaskId, subTaskUiState.localTaskId) && Intrinsics.areEqual(this.proxyConversationId, subTaskUiState.proxyConversationId) && Intrinsics.areEqual(this.proxyChatSessionId, subTaskUiState.proxyChatSessionId) && this.state == subTaskUiState.state && Intrinsics.areEqual(this.content, subTaskUiState.content) && Intrinsics.areEqual(this.failureReason, subTaskUiState.failureReason) && this.createStartedAtMs == subTaskUiState.createStartedAtMs && this.longRunning == subTaskUiState.longRunning && this.executor == subTaskUiState.executor && Intrinsics.areEqual(this.toolName, subTaskUiState.toolName);
    }

    public int hashCode() {
        int hashCode = ((this.sourceTaskId.hashCode() * 31) + this.taskDescription.hashCode()) * 31;
        String str = this.localTaskId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.proxyConversationId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.proxyChatSessionId;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.state.hashCode()) * 31) + this.content.hashCode()) * 31;
        String str4 = this.failureReason;
        int hashCode5 = (((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Long.hashCode(this.createStartedAtMs)) * 31) + Boolean.hashCode(this.longRunning)) * 31) + this.executor.hashCode()) * 31;
        String str5 = this.toolName;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SubTaskUiState(sourceTaskId=");
        sb.append(this.sourceTaskId).append(", taskDescription=").append(this.taskDescription).append(", localTaskId=").append(this.localTaskId).append(", proxyConversationId=").append(this.proxyConversationId).append(", proxyChatSessionId=").append(this.proxyChatSessionId).append(", state=").append(this.state).append(", content=").append(this.content).append(", failureReason=").append(this.failureReason).append(", createStartedAtMs=").append(this.createStartedAtMs).append(", longRunning=").append(this.longRunning).append(", executor=").append(this.executor).append(", toolName=");
        sb.append(this.toolName).append(')');
        return sb.toString();
    }

    public SubTaskUiState(String str, String str2, String str3, String str4, String str5, SubTaskRenderState subTaskRenderState, String str6, String str7, long j, boolean z, SubTaskExecutor subTaskExecutor, String str8) {
        Intrinsics.checkNotNullParameter(str, "sourceTaskId");
        Intrinsics.checkNotNullParameter(str2, "taskDescription");
        Intrinsics.checkNotNullParameter(subTaskRenderState, "state");
        Intrinsics.checkNotNullParameter(str6, ReportConstant.COMMON_CONTENT);
        Intrinsics.checkNotNullParameter(subTaskExecutor, "executor");
        this.sourceTaskId = str;
        this.taskDescription = str2;
        this.localTaskId = str3;
        this.proxyConversationId = str4;
        this.proxyChatSessionId = str5;
        this.state = subTaskRenderState;
        this.content = str6;
        this.failureReason = str7;
        this.createStartedAtMs = j;
        this.longRunning = z;
        this.executor = subTaskExecutor;
        this.toolName = str8;
    }

    public final String getSourceTaskId() {
        return this.sourceTaskId;
    }

    public final String getTaskDescription() {
        return this.taskDescription;
    }

    public final String getLocalTaskId() {
        return this.localTaskId;
    }

    public final String getProxyConversationId() {
        return this.proxyConversationId;
    }

    public final String getProxyChatSessionId() {
        return this.proxyChatSessionId;
    }

    public final SubTaskRenderState getState() {
        return this.state;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getFailureReason() {
        return this.failureReason;
    }

    public final long getCreateStartedAtMs() {
        return this.createStartedAtMs;
    }

    public final boolean getLongRunning() {
        return this.longRunning;
    }

    public /* synthetic */ SubTaskUiState(String str, String str2, String str3, String str4, String str5, SubTaskRenderState subTaskRenderState, String str6, String str7, long j, boolean z, SubTaskExecutor subTaskExecutor, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, subTaskRenderState, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? null : str7, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0L : j, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? false : z, (i & 1024) != 0 ? SubTaskExecutor.ClientProxy : subTaskExecutor, (i & 2048) != 0 ? null : str8);
    }

    public final SubTaskExecutor getExecutor() {
        return this.executor;
    }

    public final String getToolName() {
        return this.toolName;
    }
}
