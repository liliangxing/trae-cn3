package com.bytedance.trae.im.track;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedError;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.platform.service.ApplogService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AgentMonitor.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u001e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u0010\u0010!\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\b\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0018\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0002J \u0010*\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/trae/im/track/AgentMonitor;", "", "<init>", "()V", "EVENT_AGENT_START", "", "EVENT_AGENT_DONE", "EVENT_AGENT_ERROR", "EVENT_AGENT_QUEUING", "EVENT_USER_MESSAGE_START", "EVENT_USER_MESSAGE_SUCCESS", "EVENT_AGENT_NOT_END", "AGENT_NOT_END_TIMEOUT_MS", "", "reportedEvents", "Ljava/util/concurrent/ConcurrentHashMap;", "", "userMessageSuccessTimestamps", "pendingTaskConversations", "pendingTaskSources", "pendingTimeoutRunnables", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "onAgentStart", "", "taskId", "conversationId", "onAgentDone", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "onAgentError", "onAgentQueuing", "onUserMessageStart", "onUserMessageSuccess", "clear", "getScope", "calculateAgentTime", "hasReported", "", Fields.EVENT, "markReported", "scheduleNotEndTimeout", TimonPipeline.KEY_SOURCE, "cancelNotEndTimeout", "reportAgentNotEnd", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AgentMonitor {
    private static final long AGENT_NOT_END_TIMEOUT_MS = 3600000;
    private static final String EVENT_AGENT_DONE = "agent_done";
    private static final String EVENT_AGENT_ERROR = "agent_error";
    private static final String EVENT_AGENT_NOT_END = "agent_not_end";
    private static final String EVENT_AGENT_QUEUING = "agent_queuing";
    private static final String EVENT_AGENT_START = "agent_start";
    private static final String EVENT_USER_MESSAGE_START = "user_message_start";
    private static final String EVENT_USER_MESSAGE_SUCCESS = "user_message_success";
    public static final AgentMonitor INSTANCE = new AgentMonitor();
    private static final ConcurrentHashMap<String, Set<String>> reportedEvents = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> userMessageSuccessTimestamps = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> pendingTaskConversations = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> pendingTaskSources = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Runnable> pendingTimeoutRunnables = new ConcurrentHashMap<>();
    private static final Handler handler = new Handler(Looper.getMainLooper());

    private AgentMonitor() {
    }

    public final void onAgentStart(String taskId, String conversationId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        try {
            if (hasReported(taskId, EVENT_AGENT_START)) {
                return;
            }
            markReported(taskId, EVENT_AGENT_START);
            ConcurrentHashMap<String, Long> concurrentHashMap = userMessageSuccessTimestamps;
            boolean containsKey = concurrentHashMap.containsKey(taskId);
            JSONObject jSONObject = new JSONObject();
            String str = "local";
            jSONObject.put(TimonPipeline.KEY_SOURCE, containsKey ? "local" : "remote");
            jSONObject.put("scope", INSTANCE.getScope());
            JSONObject jSONObject2 = new JSONObject();
            Long l = concurrentHashMap.get(taskId);
            if (l != null) {
                long currentTimeMillis = System.currentTimeMillis() - l.longValue();
                if (currentTimeMillis < 0) {
                    currentTimeMillis = 0;
                }
                jSONObject2.put("agent_first_token_time", currentTimeMillis);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NewTaskTracker.Param.TASK_ID, taskId);
            jSONObject3.put("conversation_id", conversationId);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_AGENT_START, jSONObject, jSONObject2, jSONObject3);
            if (!containsKey) {
                str = "remote";
            }
            scheduleNotEndTimeout(taskId, conversationId, str);
        } catch (Throwable unused) {
        }
    }

    public final void onAgentDone(String taskId, String conversationId, ParsedChatMessage message) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            if (hasReported(taskId, EVENT_AGENT_DONE)) {
                return;
            }
            markReported(taskId, EVENT_AGENT_DONE);
            ConcurrentHashMap<String, Long> concurrentHashMap = userMessageSuccessTimestamps;
            boolean containsKey = concurrentHashMap.containsKey(taskId);
            JSONObject jSONObject = new JSONObject();
            String status = message.getStatus();
            if (status == null) {
                status = "";
            }
            jSONObject.put(PageDataManager.EXTRA_STATUS, status);
            jSONObject.put(TimonPipeline.KEY_SOURCE, containsKey ? "local" : "remote");
            jSONObject.put("scope", INSTANCE.getScope());
            long calculateAgentTime = calculateAgentTime(message);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("agent_time", calculateAgentTime);
            Long l = concurrentHashMap.get(taskId);
            if (l != null) {
                long currentTimeMillis = System.currentTimeMillis() - l.longValue();
                if (currentTimeMillis < 0) {
                    currentTimeMillis = 0;
                }
                jSONObject2.put("local_agent_time", currentTimeMillis);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NewTaskTracker.Param.TASK_ID, taskId);
            jSONObject3.put("conversation_id", conversationId);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_AGENT_DONE, jSONObject, jSONObject2, jSONObject3);
            cancelNotEndTimeout(taskId);
        } catch (Throwable unused) {
        }
    }

    public final void onAgentError(String taskId, String conversationId, ParsedChatMessage message) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            if (hasReported(taskId, EVENT_AGENT_ERROR)) {
                return;
            }
            markReported(taskId, EVENT_AGENT_ERROR);
            ParsedError error = message.getError();
            Object code = error != null ? error.getCode() : null;
            ParsedError error2 = message.getError();
            String message2 = error2 != null ? error2.getMessage() : null;
            ConcurrentHashMap<String, Long> concurrentHashMap = userMessageSuccessTimestamps;
            boolean containsKey = concurrentHashMap.containsKey(taskId);
            JSONObject jSONObject = new JSONObject();
            String status = message.getStatus();
            if (status == null) {
                status = "";
            }
            jSONObject.put(PageDataManager.EXTRA_STATUS, status);
            jSONObject.put("error_code", code == null ? "" : code);
            jSONObject.put(TimonPipeline.KEY_SOURCE, containsKey ? "local" : "remote");
            jSONObject.put("scope", INSTANCE.getScope());
            long calculateAgentTime = calculateAgentTime(message);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("agent_time", calculateAgentTime);
            Long l = concurrentHashMap.get(taskId);
            if (l != null) {
                long currentTimeMillis = System.currentTimeMillis() - l.longValue();
                if (currentTimeMillis < 0) {
                    currentTimeMillis = 0;
                }
                jSONObject2.put("local_agent_time", currentTimeMillis);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NewTaskTracker.Param.TASK_ID, taskId);
            jSONObject3.put("conversation_id", conversationId);
            if (code == null) {
                code = "";
            }
            jSONObject3.put("error_code", code);
            if (message2 == null) {
                message2 = "";
            }
            jSONObject3.put("error_message", message2);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_AGENT_ERROR, jSONObject, jSONObject2, jSONObject3);
            cancelNotEndTimeout(taskId);
        } catch (Throwable unused) {
        }
    }

    public final void onAgentQueuing(String taskId, String conversationId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        try {
            if (hasReported(taskId, EVENT_AGENT_QUEUING)) {
                return;
            }
            markReported(taskId, EVENT_AGENT_QUEUING);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scope", INSTANCE.getScope());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NewTaskTracker.Param.TASK_ID, taskId);
            jSONObject3.put("conversation_id", conversationId);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_AGENT_QUEUING, jSONObject, jSONObject2, jSONObject3);
        } catch (Throwable unused) {
        }
    }

    public final void onUserMessageStart(String conversationId) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scope", INSTANCE.getScope());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            if (conversationId == null) {
                conversationId = "";
            }
            jSONObject3.put("conversation_id", conversationId);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_USER_MESSAGE_START, jSONObject, jSONObject2, jSONObject3);
        } catch (Throwable unused) {
        }
    }

    public final void onUserMessageSuccess(String taskId, String conversationId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        try {
            if (taskId.length() > 0) {
                if (hasReported(taskId, EVENT_USER_MESSAGE_SUCCESS)) {
                    return;
                }
                markReported(taskId, EVENT_USER_MESSAGE_SUCCESS);
                userMessageSuccessTimestamps.put(taskId, Long.valueOf(System.currentTimeMillis()));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scope", INSTANCE.getScope());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NewTaskTracker.Param.TASK_ID, taskId);
            jSONObject3.put("conversation_id", conversationId);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_USER_MESSAGE_SUCCESS, jSONObject, jSONObject2, jSONObject3);
        } catch (Throwable unused) {
        }
    }

    public final void clear(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        try {
            cancelNotEndTimeout(taskId);
            reportedEvents.remove(taskId);
            userMessageSuccessTimestamps.remove(taskId);
            pendingTaskConversations.remove(taskId);
            pendingTaskSources.remove(taskId);
        } catch (Throwable unused) {
        }
    }

    private final long calculateAgentTime(ParsedChatMessage message) {
        Long chatStartTime = message.getChatStartTime();
        if (chatStartTime == null) {
            return 0L;
        }
        long longValue = chatStartTime.longValue();
        Long chatEndTime = message.getChatEndTime();
        if (chatEndTime == null) {
            return 0L;
        }
        long longValue2 = chatEndTime.longValue() - longValue;
        if (longValue2 >= 0) {
            return longValue2;
        }
        return 0L;
    }

    private final boolean hasReported(String taskId, String event) {
        Set<String> set = reportedEvents.get(taskId);
        return set != null && set.contains(event);
    }

    private final void markReported(String taskId, String event) {
        Set<String> putIfAbsent;
        ConcurrentHashMap<String, Set<String>> concurrentHashMap = reportedEvents;
        Set<String> set = concurrentHashMap.get(taskId);
        if (set == null && (putIfAbsent = concurrentHashMap.putIfAbsent(taskId, (set = Collections.newSetFromMap(new ConcurrentHashMap())))) != null) {
            set = putIfAbsent;
        }
        set.add(event);
    }

    private final void scheduleNotEndTimeout(final String taskId, String conversationId, String source) {
        pendingTaskConversations.put(taskId, conversationId);
        pendingTaskSources.put(taskId, source);
        Runnable runnable = new Runnable() { // from class: com.bytedance.trae.im.track.AgentMonitor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AgentMonitor.scheduleNotEndTimeout$lambda$15(taskId);
            }
        };
        pendingTimeoutRunnables.put(taskId, runnable);
        handler.postDelayed(runnable, AGENT_NOT_END_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleNotEndTimeout$lambda$15(String str) {
        INSTANCE.reportAgentNotEnd(str);
    }

    private final void cancelNotEndTimeout(String taskId) {
        Runnable remove = pendingTimeoutRunnables.remove(taskId);
        if (remove != null) {
            handler.removeCallbacks(remove);
        }
    }

    private final void reportAgentNotEnd(String taskId) {
        try {
            pendingTimeoutRunnables.remove(taskId);
            String remove = pendingTaskConversations.remove(taskId);
            String str = "";
            if (remove == null) {
                remove = "";
            }
            String remove2 = pendingTaskSources.remove(taskId);
            if (remove2 != null) {
                str = remove2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TimonPipeline.KEY_SOURCE, str);
            jSONObject.put("scope", INSTANCE.getScope());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NewTaskTracker.Param.TASK_ID, taskId);
            jSONObject3.put("conversation_id", remove);
            jSONObject3.put("device_id", ApplogService.INSTANCE.getDeviceId());
            jSONObject3.put("user_id", ApplogService.INSTANCE.getUserID());
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_AGENT_NOT_END, jSONObject, jSONObject2, jSONObject3);
        } catch (Throwable unused) {
        }
    }

    private final String getScope() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        boolean z = false;
        if (iLoginService != null && iLoginService.isTraeLoggedIn()) {
            z = true;
        }
        if (!z) {
            return "unknown";
        }
        if (Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, "enterprise")) {
            return "saas";
        }
        return Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, ThirdPartyTokenRepository.TYPE_BYTECLOUD) ? "bytedance" : AppHost.INSTANCE.isOversea() ? "marscode-us" : "marscode";
    }
}
