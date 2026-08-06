package com.bytedance.trae.conversation.tracker;

import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.conversation.settings.ReportAlogSettingsService;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CancelTaskMonitor.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jk\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/CancelTaskMonitor;", "", "<init>", "()V", "EVENT", "", "ALOG_SCENE", "ALOG_UPLOAD_WINDOW_SECONDS", "", "MAX_UPLOADED_TASK_IDS", "", "alogUploadedTaskIds", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "report", "", "result", TimonPipeline.KEY_SOURCE, "taskId", "conversationId", "messageId", "latencyMs", "bizCode", "isTaskRunning", "", "messageStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;ZLjava/lang/String;)V", "uploadALog", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CancelTaskMonitor {
    private static final String ALOG_SCENE = "cancel_task";
    private static final long ALOG_UPLOAD_WINDOW_SECONDS = 300;
    private static final String EVENT = "cancel_task_monitor";
    private static final int MAX_UPLOADED_TASK_IDS = 100;
    public static final CancelTaskMonitor INSTANCE = new CancelTaskMonitor();
    private static final LinkedHashSet<String> alogUploadedTaskIds = new LinkedHashSet<>();

    private CancelTaskMonitor() {
    }

    public final void report(String result, String source, String taskId, String conversationId, String messageId, long latencyMs, Long bizCode, boolean isTaskRunning, String messageStatus) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        boolean z = bizCode != null && ReportAlogSettingsService.INSTANCE.shouldUploadAlog(ALOG_SCENE, bizCode.longValue());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", result);
            jSONObject.put(TimonPipeline.KEY_SOURCE, source);
            String str = "";
            jSONObject.put("message_status", messageStatus == null ? "" : messageStatus);
            jSONObject.put("biz_code", (bizCode == null ? "" : bizCode).toString());
            jSONObject.put("upload_alog", z);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("latency_ms", latencyMs);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NewTaskTracker.Param.TASK_ID, taskId == null ? "" : taskId);
            jSONObject3.put("conversation_id", conversationId == null ? "" : conversationId);
            if (messageId != null) {
                str = messageId;
            }
            jSONObject3.put("message_id", str);
            jSONObject3.put("is_task_running", isTaskRunning);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT, jSONObject, jSONObject2, jSONObject3);
        } catch (Throwable unused) {
        }
        if (z && bizCode != null && taskId != null) {
            LinkedHashSet<String> linkedHashSet = alogUploadedTaskIds;
            if (linkedHashSet.add(taskId)) {
                if (linkedHashSet.size() > 100) {
                    linkedHashSet.remove(CollectionsKt.first(linkedHashSet));
                }
                uploadALog(bizCode.longValue());
            }
        }
    }

    private final void uploadALog(long bizCode) {
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            FLogger.INSTANCE.uploadALog("cancel_task_" + bizCode, currentTimeMillis - ALOG_UPLOAD_WINDOW_SECONDS, currentTimeMillis, (Function1) null);
        } catch (Throwable unused) {
        }
    }
}
