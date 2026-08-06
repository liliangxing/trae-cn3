package com.bytedance.trae.conversation.voice;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.network.ModelSelectionRepository;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage;
import com.bytedance.trae.conversation.voice.subtask.TaskStartMessage;
import com.bytedance.trae.conversation.voice.subtask.ToolResultMessage;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: VoiceDiscussionMetrics.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001IB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001b\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020%JK\u0010)\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\u00152\u0006\u0010&\u001a\u00020/¢\u0006\u0002\u00100JB\u00101\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020-J\\\u00105\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u00020\u00152\u0006\u00104\u001a\u00020-2\u0006\u00109\u001a\u00020\u001aJ}\u0010:\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\u00152\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010?J:\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005J\u0018\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u001cH\u0002J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010&\u001a\u00020/H\u0002J\u0018\u0010H\u001a\u00020\u00052\u0006\u0010&\u001a\u00020/2\u0006\u00106\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;", "", "<init>", "()V", "TAG", "", "EVENT_SUBTASK_START", "EVENT_SUBTASK_END", "EVENT_FILE_UPLOAD_END", "EVENT_SERVER_TOOL_END", "EVENT_WINDOW_STATE_CLICK", "STATUS_SUCCESS", "STATUS_FAILED", "TOOL_NAME_WEB_SEARCH", "WINDOW_ACTION_MINIMIZE", "WINDOW_ACTION_RESTORE", "WINDOW_STATE_NORMAL", "WINDOW_STATE_MINIMIZED", "TOOL_DURATION_SOURCE_CLIENT", "TOOL_DURATION_SOURCE_MISSING_START", "MISSING_DURATION_MS", "", "serverToolStarts", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;", "serverToolReportedTaskIds", "", "putVoiceCommonParams", "Lorg/json/JSONObject;", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "mode", "Lcom/bytedance/trae/im/service/Mode;", "commonCategory", "boolValue", "value", "recordServerToolStart", "", "msg", "Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;", "clearServerToolTracking", "reportServerToolEnd", "conversationId", "roomId", "roundIndex", "", "convRoundId", "Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;", "(Lcom/bytedance/trae/im/service/CliType;Lcom/bytedance/trae/im/service/Mode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V", "reportSubtaskStart", "sourceTaskId", "taskDescription", "fileCount", "reportSubtaskEnd", PageDataManager.EXTRA_STATUS, "failureReason", "durationMs", "isCancelled", "reportFileUploadEnd", "fileType", "mimeType", "fileSizeBytes", "uploadMethod", "(Lcom/bytedance/trae/im/service/CliType;Lcom/bytedance/trae/im/service/Mode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "reportWindowStateClick", "action", "windowStateBeforeClick", "reportTea", "eventName", "params", "chatMode", "resolveToolStatus", "resolveFailureReason", "ServerToolStart", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceDiscussionMetrics {
    public static final String EVENT_FILE_UPLOAD_END = "voice_discussion_file_upload_end";
    public static final String EVENT_SERVER_TOOL_END = "voice_discussion_server_tool_end";
    public static final String EVENT_SUBTASK_END = "voice_discussion_subtask_end";
    public static final String EVENT_SUBTASK_START = "voice_discussion_subtask_start";
    public static final String EVENT_WINDOW_STATE_CLICK = "voice_discussion_window_state_click";
    private static final long MISSING_DURATION_MS = -1;
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_SUCCESS = "success";
    private static final String TAG = "VoiceDiscussionMetrics";
    private static final String TOOL_DURATION_SOURCE_CLIENT = "client_observed";
    private static final String TOOL_DURATION_SOURCE_MISSING_START = "missing_task_start";
    public static final String TOOL_NAME_WEB_SEARCH = "web_search";
    public static final String WINDOW_ACTION_MINIMIZE = "minimize_click";
    public static final String WINDOW_ACTION_RESTORE = "restore_click";
    public static final String WINDOW_STATE_MINIMIZED = "minimized";
    public static final String WINDOW_STATE_NORMAL = "normal";
    public static final VoiceDiscussionMetrics INSTANCE = new VoiceDiscussionMetrics();
    private static final ConcurrentHashMap<String, ServerToolStart> serverToolStarts = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Boolean> serverToolReportedTaskIds = new ConcurrentHashMap<>();

    public final String boolValue(boolean value) {
        return value ? "1" : "0";
    }

    private VoiceDiscussionMetrics() {
    }

    /* compiled from: VoiceDiscussionMetrics.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;", "", "startMs", "", "toolName", "", "<init>", "(JLjava/lang/String;)V", "getStartMs", "()J", "getToolName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final /* data */ class ServerToolStart {
        private final long startMs;
        private final String toolName;

        public static /* synthetic */ ServerToolStart copy$default(ServerToolStart serverToolStart, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = serverToolStart.startMs;
            }
            if ((i & 2) != 0) {
                str = serverToolStart.toolName;
            }
            return serverToolStart.copy(j, str);
        }

        /* renamed from: component1, reason: from getter */
        public final long getStartMs() {
            return this.startMs;
        }

        /* renamed from: component2, reason: from getter */
        public final String getToolName() {
            return this.toolName;
        }

        public final ServerToolStart copy(long startMs, String toolName) {
            Intrinsics.checkNotNullParameter(toolName, "toolName");
            return new ServerToolStart(startMs, toolName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerToolStart)) {
                return false;
            }
            ServerToolStart serverToolStart = (ServerToolStart) other;
            return this.startMs == serverToolStart.startMs && Intrinsics.areEqual(this.toolName, serverToolStart.toolName);
        }

        public int hashCode() {
            return (Long.hashCode(this.startMs) * 31) + this.toolName.hashCode();
        }

        public String toString() {
            return "ServerToolStart(startMs=" + this.startMs + ", toolName=" + this.toolName + ')';
        }

        public ServerToolStart(long j, String str) {
            Intrinsics.checkNotNullParameter(str, "toolName");
            this.startMs = j;
            this.toolName = str;
        }

        public final long getStartMs() {
            return this.startMs;
        }

        public final String getToolName() {
            return this.toolName;
        }
    }

    public final JSONObject putVoiceCommonParams(JSONObject jSONObject, CliType cliType, Mode mode) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        String chatMode = chatMode(mode);
        jSONObject.put("cli_type", cliType.getValue());
        jSONObject.put("mode", mode.getValue());
        jSONObject.put("chat_mode", chatMode);
        jSONObject.put("env_mode", cliType.getValue() + '_' + chatMode);
        return jSONObject;
    }

    public final JSONObject commonCategory(CliType cliType, Mode mode) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return putVoiceCommonParams(new JSONObject(), cliType, mode);
    }

    public final void recordServerToolStart(TaskStartMessage msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        String taskId = msg.getTaskId();
        if (!(!StringsKt.isBlank(taskId))) {
            taskId = null;
        }
        if (taskId == null) {
            return;
        }
        ConcurrentHashMap<String, ServerToolStart> concurrentHashMap = serverToolStarts;
        long currentTimeMillis = System.currentTimeMillis();
        String toolName = msg.getToolName();
        if (toolName == null) {
            toolName = "";
        }
        concurrentHashMap.put(taskId, new ServerToolStart(currentTimeMillis, toolName));
    }

    public final void clearServerToolTracking() {
        serverToolStarts.clear();
        serverToolReportedTaskIds.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
    
        if (r13 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reportServerToolEnd(CliType cliType, Mode mode, String conversationId, String roomId, Integer roundIndex, Long convRoundId, ToolResultMessage msg) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(msg, "msg");
        String taskId = msg.getTaskId();
        if (!(!StringsKt.isBlank(taskId))) {
            taskId = null;
        }
        if (taskId != null && serverToolReportedTaskIds.putIfAbsent(taskId, true) == null) {
            ServerToolStart remove = serverToolStarts.remove(taskId);
            long coerceAtLeast = remove != null ? RangesKt.coerceAtLeast(System.currentTimeMillis() - remove.getStartMs(), 0L) : -1L;
            String str = remove != null ? TOOL_DURATION_SOURCE_CLIENT : TOOL_DURATION_SOURCE_MISSING_START;
            String toolName = msg.getToolName();
            if (toolName != null) {
                if (!(true ^ StringsKt.isBlank(toolName))) {
                    toolName = null;
                }
            }
            String toolName2 = remove != null ? remove.getToolName() : null;
            toolName = toolName2 == null ? "" : toolName2;
            String resolveToolStatus = resolveToolStatus(msg);
            String resolveFailureReason = resolveFailureReason(msg, resolveToolStatus);
            JSONObject jSONObject = new JSONObject();
            VoiceDiscussionMetrics voiceDiscussionMetrics = INSTANCE;
            voiceDiscussionMetrics.putVoiceCommonParams(jSONObject, cliType, mode);
            jSONObject.put("conversation_id", conversationId == null ? "" : conversationId);
            jSONObject.put("room_id", roomId != null ? roomId : "");
            jSONObject.put("round_index", roundIndex != null ? roundIndex.intValue() : -1);
            jSONObject.put("conv_round_id", convRoundId != null ? convRoundId.longValue() : -1L);
            jSONObject.put(NewTaskTracker.Param.TASK_ID, taskId);
            jSONObject.put("tool_name", toolName);
            jSONObject.put("tool_status", resolveToolStatus);
            jSONObject.put("failure_reason", resolveFailureReason);
            jSONObject.put("tool_observed_duration_ms", coerceAtLeast);
            jSONObject.put("tool_duration_source", str);
            jSONObject.put("has_search", voiceDiscussionMetrics.boolValue(Intrinsics.areEqual(toolName, "web_search")));
            reportTea(EVENT_SERVER_TOOL_END, jSONObject);
        }
    }

    public final void reportSubtaskStart(CliType cliType, Mode mode, String conversationId, String roomId, String sourceTaskId, String taskDescription, int fileCount) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(sourceTaskId, "sourceTaskId");
        Intrinsics.checkNotNullParameter(taskDescription, "taskDescription");
        JSONObject jSONObject = new JSONObject();
        INSTANCE.putVoiceCommonParams(jSONObject, cliType, mode);
        if (conversationId == null) {
            conversationId = "";
        }
        jSONObject.put("conversation_id", conversationId);
        if (roomId == null) {
            roomId = "";
        }
        jSONObject.put("room_id", roomId);
        jSONObject.put(DBData.FIELD_TYPE, SubTaskRequestMessage.TYPE);
        jSONObject.put("executor", SubTaskRequestMessage.EXECUTOR_CLIENT);
        jSONObject.put("source_task_id", sourceTaskId);
        jSONObject.put("task_description_length", taskDescription.length());
        jSONObject.put("file_count", fileCount);
        reportTea(EVENT_SUBTASK_START, jSONObject);
    }

    public final void reportSubtaskEnd(CliType cliType, Mode mode, String conversationId, String roomId, String sourceTaskId, String status, String failureReason, long durationMs, int fileCount, boolean isCancelled) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(sourceTaskId, "sourceTaskId");
        Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
        JSONObject jSONObject = new JSONObject();
        VoiceDiscussionMetrics voiceDiscussionMetrics = INSTANCE;
        voiceDiscussionMetrics.putVoiceCommonParams(jSONObject, cliType, mode);
        if (conversationId == null) {
            conversationId = "";
        }
        jSONObject.put("conversation_id", conversationId);
        if (roomId == null) {
            roomId = "";
        }
        jSONObject.put("room_id", roomId);
        jSONObject.put(DBData.FIELD_TYPE, SubTaskRequestMessage.TYPE);
        jSONObject.put("executor", SubTaskRequestMessage.EXECUTOR_CLIENT);
        jSONObject.put("source_task_id", sourceTaskId);
        jSONObject.put(PageDataManager.EXTRA_STATUS, status);
        if (failureReason == null) {
            failureReason = "";
        }
        jSONObject.put("failure_reason", failureReason);
        jSONObject.put("duration_ms", RangesKt.coerceAtLeast(durationMs, 0L));
        jSONObject.put("file_count", fileCount);
        jSONObject.put("is_cancelled", voiceDiscussionMetrics.boolValue(isCancelled));
        reportTea(EVENT_SUBTASK_END, jSONObject);
    }

    public final void reportFileUploadEnd(CliType cliType, Mode mode, String conversationId, String roomId, Integer roundIndex, Long convRoundId, String fileType, String mimeType, long fileSizeBytes, String uploadMethod, long durationMs, String status, String failureReason) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(uploadMethod, "uploadMethod");
        Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
        JSONObject jSONObject = new JSONObject();
        INSTANCE.putVoiceCommonParams(jSONObject, cliType, mode);
        jSONObject.put("conversation_id", conversationId == null ? "" : conversationId);
        jSONObject.put("room_id", roomId == null ? "" : roomId);
        jSONObject.put("round_index", roundIndex != null ? roundIndex.intValue() : -1);
        jSONObject.put("conv_round_id", convRoundId != null ? convRoundId.longValue() : -1L);
        jSONObject.put("file_type", fileType);
        jSONObject.put("mime_type", mimeType);
        jSONObject.put("file_size_bytes", RangesKt.coerceAtLeast(fileSizeBytes, 0L));
        jSONObject.put("upload_method", uploadMethod);
        jSONObject.put("duration_ms", RangesKt.coerceAtLeast(durationMs, 0L));
        jSONObject.put(PageDataManager.EXTRA_STATUS, status);
        jSONObject.put("failure_reason", failureReason != null ? failureReason : "");
        reportTea(EVENT_FILE_UPLOAD_END, jSONObject);
    }

    public final void reportWindowStateClick(CliType cliType, Mode mode, String conversationId, String roomId, String action, String windowStateBeforeClick) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(windowStateBeforeClick, "windowStateBeforeClick");
        JSONObject jSONObject = new JSONObject();
        INSTANCE.putVoiceCommonParams(jSONObject, cliType, mode);
        if (conversationId == null) {
            conversationId = "";
        }
        jSONObject.put("conversation_id", conversationId);
        if (roomId == null) {
            roomId = "";
        }
        jSONObject.put("room_id", roomId);
        jSONObject.put("action", action);
        jSONObject.put("window_state_before_click", windowStateBeforeClick);
        reportTea(EVENT_WINDOW_STATE_CLICK, jSONObject);
    }

    private final void reportTea(String eventName, JSONObject params) {
        try {
            IApplog.INSTANCE.reportEvent(eventName, params);
            FLogger.INSTANCE.d(TAG, eventName + ": " + params);
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, "reportTea failed: event=" + eventName, th);
        }
    }

    private final String chatMode(Mode mode) {
        return mode == Mode.CODE ? "code" : ModelSelectionRepository.MODE_MTC;
    }

    private final String resolveToolStatus(ToolResultMessage msg) {
        String status = msg.getStatus();
        boolean z = true;
        if (status == null || !(!StringsKt.isBlank(status))) {
            status = null;
        }
        String str = status;
        if (!(str == null || StringsKt.isBlank(str))) {
            return status;
        }
        String error = msg.getError();
        if (error != null && !StringsKt.isBlank(error)) {
            z = false;
        }
        return z ? "success" : "failed";
    }

    private final String resolveFailureReason(ToolResultMessage msg, String status) {
        String error = msg.getError();
        if (error == null || !(!StringsKt.isBlank(error))) {
            error = null;
        }
        return error != null ? error : !StringsKt.equals(status, "success", true) ? status : "";
    }
}
