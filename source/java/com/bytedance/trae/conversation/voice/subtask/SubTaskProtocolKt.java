package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.conversation.model.QueryItem;
import com.bytedance.trae.network.TraeHttpConnection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003\u001a\"\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u0003¨\u0006\u0013"}, d2 = {"mapHeadStatusToTerminal", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", PageDataManager.EXTRA_STATUS, "", "parseSubTaskRequest", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;", "json", "parseSubTaskUpdate", "peekSubTaskMessageType", "parseSubTaskEnvelope", "expectedType", "allowEmptyClientPayload", "", "parseTaskStart", "Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;", "parseTaskStop", "Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;", "parseToolResult", "Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SubTaskProtocolKt {
    public static final SubTaskRenderState mapHeadStatusToTerminal(String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        return StringsKt.equals(str, "success", true) ? SubTaskRenderState.Done : SubTaskRenderState.Failed;
    }

    public static final SubTaskRequestMessage parseSubTaskRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        return parseSubTaskEnvelope(str, SubTaskRequestMessage.TYPE, false);
    }

    public static final SubTaskRequestMessage parseSubTaskUpdate(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        return parseSubTaskEnvelope(str, SubTaskRequestMessage.TYPE_UPDATE, true);
    }

    public static final String peekSubTaskMessageType(String str) {
        String type;
        Intrinsics.checkNotNullParameter(str, "json");
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            SubTaskTypeEnvelope subTaskTypeEnvelope = (SubTaskTypeEnvelope) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, SubTaskTypeEnvelope.class);
            if (subTaskTypeEnvelope == null || (type = subTaskTypeEnvelope.getType()) == null) {
                return null;
            }
            if (!StringsKt.isBlank(type)) {
                return type;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00ab A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final SubTaskRequestMessage parseSubTaskEnvelope(String str, String str2, boolean z) {
        boolean z2;
        String message;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            SubTaskRequestMessage subTaskRequestMessage = (SubTaskRequestMessage) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, SubTaskRequestMessage.class);
            String type = subTaskRequestMessage != null ? subTaskRequestMessage.getType() : null;
            String str3 = type == null ? "" : type;
            if (!Intrinsics.areEqual(str3, str2)) {
                return null;
            }
            String taskId = subTaskRequestMessage.getTaskId();
            String str4 = taskId == null ? "" : taskId;
            String roomId = subTaskRequestMessage.getRoomId();
            String str5 = roomId == null ? "" : roomId;
            if (!StringsKt.isBlank(str4) && !StringsKt.isBlank(str5)) {
                SubTaskExecutor fromProtocol = SubTaskExecutor.INSTANCE.fromProtocol(subTaskRequestMessage.getExecutor());
                String taskDescription = subTaskRequestMessage.getTaskDescription();
                if (taskDescription == null) {
                    taskDescription = "";
                }
                String str6 = taskDescription;
                if (StringsKt.isBlank(str6)) {
                    if (Intrinsics.areEqual(str2, SubTaskRequestMessage.TYPE_UPDATE) && (message = subTaskRequestMessage.getMessage()) != null) {
                        str6 = message;
                    }
                    str6 = "";
                }
                String str7 = str6;
                if (!z && fromProtocol == SubTaskExecutor.ClientProxy && StringsKt.isBlank(str7)) {
                    List<QueryItem> files = subTaskRequestMessage.getFiles();
                    if (files != null && !files.isEmpty()) {
                        z2 = false;
                        if (z2) {
                            return null;
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
                long timeoutMs = subTaskRequestMessage.getTimeoutMs() > 0 ? subTaskRequestMessage.getTimeoutMs() : 600000L;
                String userId = subTaskRequestMessage.getUserId();
                return new SubTaskRequestMessage(str3, str4, str5, userId == null ? "" : userId, str7, subTaskRequestMessage.getMessage(), subTaskRequestMessage.getFiles(), timeoutMs, subTaskRequestMessage.getExecutor());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final TaskStartMessage parseTaskStart(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            TaskStartMessage taskStartMessage = (TaskStartMessage) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, TaskStartMessage.class);
            if (!Intrinsics.areEqual(taskStartMessage != null ? taskStartMessage.getType() : null, TaskStartMessage.TYPE)) {
                return null;
            }
            if (StringsKt.isBlank(taskStartMessage.getTaskId())) {
                return null;
            }
            return taskStartMessage;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final TaskStopMessage parseTaskStop(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            TaskStopMessage taskStopMessage = (TaskStopMessage) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, TaskStopMessage.class);
            if (Intrinsics.areEqual(taskStopMessage != null ? taskStopMessage.getType() : null, TaskStopMessage.TYPE) && !StringsKt.isBlank(taskStopMessage.getTaskId()) && !StringsKt.isBlank(taskStopMessage.getRoomId())) {
                return TaskStopMessage.copy$default(taskStopMessage, null, null, null, null, taskStopMessage.getTimeoutMs() > 0 ? taskStopMessage.getTimeoutMs() : 600000L, 15, null);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final ToolResultMessage parseToolResult(String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            ToolResultMessage toolResultMessage = (ToolResultMessage) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str, ToolResultMessage.class);
            if (!Intrinsics.areEqual(toolResultMessage != null ? toolResultMessage.getType() : null, ToolResultMessage.TYPE)) {
                return null;
            }
            if (StringsKt.isBlank(toolResultMessage.getTaskId())) {
                return null;
            }
            return toolResultMessage;
        } catch (Throwable unused) {
            return null;
        }
    }
}
