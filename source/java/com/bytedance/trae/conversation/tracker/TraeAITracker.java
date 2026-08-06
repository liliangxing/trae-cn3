package com.bytedance.trae.conversation.tracker;

import android.util.Log;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: TraeAITracker.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rJ:\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rJ~\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rJ0\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000bJ>\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\"\u0010\"\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0010\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u000eJ\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0018\u0010'\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0018\u0010(\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0018\u0010)\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000eJ\u001a\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000e2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010.\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000eJ2\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u000e2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000eJ&\u00107\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rH\u0002J\u0018\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020\tH\u0002J \u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010;\u001a\u0002082\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010=\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/TraeAITracker;", "", "<init>", "()V", "trackTrigger", "", "context", "Lcom/bytedance/trae/conversation/tracker/AIEventContext;", "sendContext", "Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;", "chatMode", "Lcom/bytedance/trae/conversation/tracker/SoloChatMode;", "extraParams", "", "", "trackShow", "trackCompleteShow", "resultType", ReportConstant.COMMON_INIT_DURATION, "", "diffFileCount", "", "diffInsertLineCount", "diffDeleteLineCount", "filenameExtension", "toolCount", "trackFeedbackClick", "agentMessageId", "userMessageId", "trackCopyClick", "trackCanceled", "cancelReason", "cancelPhase", "toolType", "trackRetryClick", "taskId", "trackReportClick", "enterFrom", "trackRevertClick", "trackRevertSuccess", "trackDeleteClick", "trackDeleteSuccess", "trackAsrRecog", "action", "trackAsrRewrite", "reason", "trackAsrDiscuss", "attemptId", "trackTaskCreateResult", "deviceType", "useFastRequest", "", "isSuccess", "mode", "failReason", "buildBaseParams", "Lorg/json/JSONObject;", "extra", "mergeSendContext", "params", "ctx", "TAG", "reportEvent", Fields.EVENT, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeAITracker {
    public static final TraeAITracker INSTANCE = new TraeAITracker();
    private static final String TAG = "TraeAITracker";

    private TraeAITracker() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackTrigger$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, AISendMessageContext aISendMessageContext, SoloChatMode soloChatMode, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            aISendMessageContext = null;
        }
        if ((i & 4) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        traeAITracker.trackTrigger(aIEventContext, aISendMessageContext, soloChatMode, map);
    }

    public final void trackTrigger(AIEventContext context, AISendMessageContext sendContext, SoloChatMode chatMode, Map<String, ? extends Object> extraParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        JSONObject buildBaseParams = buildBaseParams(context, extraParams);
        if (sendContext != null) {
            INSTANCE.mergeSendContext(buildBaseParams, sendContext);
        }
        reportEvent(AIEvent.TRIGGER, buildBaseParams, chatMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackShow$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, AISendMessageContext aISendMessageContext, SoloChatMode soloChatMode, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            aISendMessageContext = null;
        }
        if ((i & 4) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        traeAITracker.trackShow(aIEventContext, aISendMessageContext, soloChatMode, map);
    }

    public final void trackShow(AIEventContext context, AISendMessageContext sendContext, SoloChatMode chatMode, Map<String, ? extends Object> extraParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        JSONObject buildBaseParams = buildBaseParams(context, extraParams);
        if (sendContext != null) {
            INSTANCE.mergeSendContext(buildBaseParams, sendContext);
        }
        reportEvent(AIEvent.SHOW, buildBaseParams, chatMode);
    }

    public final void trackCompleteShow(AIEventContext context, AISendMessageContext sendContext, String resultType, double duration, int diffFileCount, int diffInsertLineCount, int diffDeleteLineCount, String filenameExtension, int toolCount, SoloChatMode chatMode, Map<String, ? extends Object> extraParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resultType, "resultType");
        Intrinsics.checkNotNullParameter(filenameExtension, "filenameExtension");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        JSONObject buildBaseParams = buildBaseParams(context, extraParams);
        buildBaseParams.put("result_type", resultType);
        buildBaseParams.put(ReportConstant.COMMON_INIT_DURATION, duration);
        buildBaseParams.put("diff_file_count", diffFileCount);
        buildBaseParams.put("diff_insert_line_count", diffInsertLineCount);
        buildBaseParams.put("diff_delete_line_count", diffDeleteLineCount);
        if (filenameExtension.length() > 0) {
            buildBaseParams.put("filename_extension", filenameExtension);
        }
        buildBaseParams.put("tool_count", toolCount);
        if (sendContext != null) {
            INSTANCE.mergeSendContext(buildBaseParams, sendContext);
        }
        reportEvent(AIEvent.COMPLETE_SHOW, buildBaseParams, chatMode);
    }

    public static /* synthetic */ void trackFeedbackClick$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, String str, String str2, String str3, SoloChatMode soloChatMode, int i, Object obj) {
        if ((i & 16) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        traeAITracker.trackFeedbackClick(aIEventContext, str, str2, str3, soloChatMode);
    }

    public final void trackFeedbackClick(AIEventContext context, String resultType, String agentMessageId, String userMessageId, SoloChatMode chatMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resultType, "resultType");
        Intrinsics.checkNotNullParameter(agentMessageId, "agentMessageId");
        Intrinsics.checkNotNullParameter(userMessageId, "userMessageId");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        JSONObject buildBaseParams$default = buildBaseParams$default(this, context, null, 2, null);
        buildBaseParams$default.put(DBData.FIELD_TYPE, resultType);
        buildBaseParams$default.put("result_type", resultType);
        buildBaseParams$default.put("agent_message_id", agentMessageId);
        buildBaseParams$default.put("user_message_id", userMessageId);
        reportEvent(AIEvent.FEEDBACK_CLICK, buildBaseParams$default, chatMode);
    }

    public static /* synthetic */ void trackCopyClick$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, String str, SoloChatMode soloChatMode, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "text";
        }
        if ((i & 4) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        traeAITracker.trackCopyClick(aIEventContext, str, soloChatMode);
    }

    public final void trackCopyClick(AIEventContext context, String resultType, SoloChatMode chatMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resultType, "resultType");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        JSONObject buildBaseParams$default = buildBaseParams$default(this, context, null, 2, null);
        buildBaseParams$default.put(DBData.FIELD_TYPE, resultType);
        buildBaseParams$default.put("result_type", resultType);
        reportEvent(AIEvent.COPY_CLICK, buildBaseParams$default, chatMode);
    }

    public final void trackCanceled(AIEventContext context, String cancelReason, String cancelPhase, double duration, String toolType, SoloChatMode chatMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cancelReason, "cancelReason");
        Intrinsics.checkNotNullParameter(cancelPhase, "cancelPhase");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        JSONObject buildBaseParams$default = buildBaseParams$default(this, context, null, 2, null);
        buildBaseParams$default.put("cancel_reason", cancelReason);
        buildBaseParams$default.put("cancel_phase", cancelPhase);
        buildBaseParams$default.put(ReportConstant.COMMON_INIT_DURATION, duration);
        if (toolType != null) {
            buildBaseParams$default.put("tool_type", toolType);
        }
        reportEvent(AIEvent.CANCELED, buildBaseParams$default, chatMode);
    }

    public static /* synthetic */ void trackRetryClick$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, String str, SoloChatMode soloChatMode, int i, Object obj) {
        if ((i & 2) != 0) {
            str = aIEventContext.getMessageId();
        }
        if ((i & 4) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        traeAITracker.trackRetryClick(aIEventContext, str, soloChatMode);
    }

    public final void trackRetryClick(AIEventContext context, String taskId, SoloChatMode chatMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        JSONObject buildBaseParams$default = buildBaseParams$default(this, context, null, 2, null);
        if (taskId.length() > 0) {
            buildBaseParams$default.put(NewTaskTracker.Param.TASK_ID, taskId);
        }
        reportEvent(AIEvent.RETRY_CLICK, buildBaseParams$default, chatMode);
    }

    public static /* synthetic */ void trackReportClick$default(TraeAITracker traeAITracker, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "task_detail";
        }
        traeAITracker.trackReportClick(str);
    }

    public final void trackReportClick(String enterFrom) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enter_from", enterFrom);
        reportEvent(AIEvent.REPORT_CLICK, jSONObject, SoloChatMode.DEFAULT);
    }

    public static /* synthetic */ void trackRevertClick$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, SoloChatMode soloChatMode, int i, Object obj) {
        if ((i & 2) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        traeAITracker.trackRevertClick(aIEventContext, soloChatMode);
    }

    public final void trackRevertClick(AIEventContext context, SoloChatMode chatMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        reportEvent(AIEvent.REVERT_CLICK, buildBaseParams$default(this, context, null, 2, null), chatMode);
    }

    public static /* synthetic */ void trackRevertSuccess$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, SoloChatMode soloChatMode, int i, Object obj) {
        if ((i & 2) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        traeAITracker.trackRevertSuccess(aIEventContext, soloChatMode);
    }

    public final void trackRevertSuccess(AIEventContext context, SoloChatMode chatMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        reportEvent(AIEvent.REVERT_SUCCESS, buildBaseParams$default(this, context, null, 2, null), chatMode);
    }

    public static /* synthetic */ void trackDeleteClick$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, SoloChatMode soloChatMode, int i, Object obj) {
        if ((i & 2) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        traeAITracker.trackDeleteClick(aIEventContext, soloChatMode);
    }

    public final void trackDeleteClick(AIEventContext context, SoloChatMode chatMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        reportEvent(AIEvent.DELETE_CLICK, buildBaseParams$default(this, context, null, 2, null), chatMode);
    }

    public static /* synthetic */ void trackDeleteSuccess$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, SoloChatMode soloChatMode, int i, Object obj) {
        if ((i & 2) != 0) {
            soloChatMode = SoloChatMode.DEFAULT;
        }
        traeAITracker.trackDeleteSuccess(aIEventContext, soloChatMode);
    }

    public final void trackDeleteSuccess(AIEventContext context, SoloChatMode chatMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chatMode, "chatMode");
        reportEvent(AIEvent.DELETE_SUCCESS, buildBaseParams$default(this, context, null, 2, null), chatMode);
    }

    public final void trackAsrRecog(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", action);
        reportEvent(AIEvent.ASR_RECOG, jSONObject, SoloChatMode.DEFAULT);
    }

    public static /* synthetic */ void trackAsrRewrite$default(TraeAITracker traeAITracker, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        traeAITracker.trackAsrRewrite(str, str2);
    }

    public final void trackAsrRewrite(String action, String reason) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", action);
        if (reason != null) {
            jSONObject.put("reason", reason);
        }
        reportEvent(AIEvent.ASR_REWRITE, jSONObject, SoloChatMode.DEFAULT);
    }

    public static /* synthetic */ void trackAsrDiscuss$default(TraeAITracker traeAITracker, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        traeAITracker.trackAsrDiscuss(str, str2);
    }

    public final void trackAsrDiscuss(String action, String attemptId) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action", action);
        if (attemptId != null) {
            if (!(!StringsKt.isBlank(attemptId))) {
                attemptId = null;
            }
            if (attemptId != null) {
                jSONObject.put("attempt_id", attemptId);
            }
        }
        reportEvent(AIEvent.ASR_DISCUSS, jSONObject, SoloChatMode.DEFAULT);
    }

    public static /* synthetic */ void trackTaskCreateResult$default(TraeAITracker traeAITracker, String str, boolean z, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str3 = null;
        }
        traeAITracker.trackTaskCreateResult(str, z, i, str2, str3);
    }

    public final void trackTaskCreateResult(String deviceType, boolean useFastRequest, int isSuccess, String mode, String failReason) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constant.KEY_DEVICE_TYPE, deviceType);
            jSONObject.put("is_success", isSuccess);
            jSONObject.put("mode", mode);
            jSONObject.put("use_fast_request", useFastRequest);
            if (failReason != null) {
                jSONObject.put("fail_reason", failReason);
            }
            IApplog.INSTANCE.reportEvent(AIEvent.TASK_CREATE_RESULT, jSONObject);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ JSONObject buildBaseParams$default(TraeAITracker traeAITracker, AIEventContext aIEventContext, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return traeAITracker.buildBaseParams(aIEventContext, map);
    }

    private final JSONObject buildBaseParams(AIEventContext context, Map<String, ? extends Object> extra) {
        JSONObject jSONObject = new JSONObject();
        if (context.getProjectId().length() > 0) {
            jSONObject.put("project_id", context.getProjectId());
        }
        if (context.getSessionId().length() > 0) {
            jSONObject.put("session_id", context.getSessionId());
        }
        if (context.getMessageId().length() > 0) {
            jSONObject.put("message_id", context.getMessageId());
        }
        if (context.getChatModel().length() > 0) {
            jSONObject.put("chat_model", context.getChatModel());
        }
        for (Map.Entry<String, ? extends Object> entry : extra.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private final void mergeSendContext(JSONObject params, AISendMessageContext ctx) {
        if ((ctx.getEnvDeployment().length() > 0) != false) {
            params.put("env_deployment", ctx.getEnvDeployment());
        }
        params.put("has_git", ctx.getHasGit() ? 1 : 0);
        if ((ctx.getGitType().length() > 0) != false) {
            params.put("git_type", ctx.getGitType());
        }
        if ((ctx.getRemoteEnv().length() > 0) != false) {
            params.put("remote_env", ctx.getRemoteEnv());
        }
        params.put("is_spec_mode", ctx.isSpecMode() ? 1 : 0);
        params.put("is_plan_mode", ctx.isPlanMode() ? 1 : 0);
        params.put("skill_count", ctx.getSkillCount());
        params.put("rules_count", ctx.getRulesCount());
        if ((ctx.getCommandType().length() > 0) != false) {
            params.put("command_type", ctx.getCommandType());
        }
        params.put("file_count", ctx.getFileCount());
        params.put("folder_count", ctx.getFolderCount());
        params.put("file_with_comment_count", ctx.getFileWithCommentCount());
        params.put("data_text_count", ctx.getDataTextCount());
        params.put("data_text_with_comment_count", ctx.getDataTextWithCommentCount());
        params.put("data_sheet_count", ctx.getDataSheetCount());
        params.put("data_sheet_with_comment_count", ctx.getDataSheetWithCommentCount());
        params.put("markdown_count", ctx.getMarkdownCount());
        params.put("markdown_with_comment", ctx.getMarkdownWithComment());
        params.put("code_selection_count", ctx.getCodeSelectionCount());
        params.put("web_url_count", ctx.getWebUrlCount());
        params.put("web_element_count", ctx.getWebElementCount());
        if (ctx.getMentionType().length() > 0) {
            params.put("mention_type", ctx.getMentionType());
        }
        params.put("log_item_count", ctx.getLogItemCount());
        params.put("image_count", ctx.getImageCount());
        params.put("asr_count", ctx.getAsrCount());
        params.put("attachment_count", ctx.getAttachmentCount());
        params.put("plugin_count", ctx.getPluginCount());
    }

    private final void reportEvent(String event, JSONObject params, SoloChatMode chatMode) {
        params.put("solo_chat_mode", chatMode.getValue());
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: " + event + ", params: " + params);
        }
        IApplog.INSTANCE.reportEvent(event, params);
    }
}
