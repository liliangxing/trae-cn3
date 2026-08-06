package com.bytedance.trae.im.track;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.sync.SyncConstants;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.service.ChatEventPayload;
import com.bytedance.trae.im.service.IMService;
import com.bytedance.trae.im.service.ModelInfo;
import com.bytedance.trae.im.service.ModelSelectionConstants;
import com.bytedance.trae.im.service.UserMessageContext;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ChatFirstTokenTracker.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002^_B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u0016\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005J\u000e\u00100\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J¯\u0001\u00101\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u00010(2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010;\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010?J\"\u0010@\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010A\u001a\u00020B2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0005J*\u0010C\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010E\u001a\u00020\u001fJ4\u0010F\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010\u00052\b\u0010J\u001a\u0004\u0018\u00010\u0005J\u0010\u0010K\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010L\u001a\u00020(2\u0006\u0010$\u001a\u00020\u0005JX\u0010M\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020(2\b\u0010J\u001a\u0004\u0018\u00010\u00052\u0014\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\b\u0010S\u001a\u0004\u0018\u00010\u001fJ<\u0010T\u001a\u00020#2\u0006\u0010U\u001a\u00020V2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010X\u001a\u00020O2\u0006\u0010Y\u001a\u00020O2\u0006\u0010Z\u001a\u00020OH\u0002J\u0010\u0010[\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010\\\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010]\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0016\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00110\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R4\u0010\u001a\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00110\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R2\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0004\u0012\u00020\u001f0\u001c0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;", "", "<init>", "()V", "TAG", "", "AGENT_FLOW_TAG", "EVENT_NAME", "FE_SEND", "FE_API_RESPONSE", "FE_FRONT_END_RECEIVE", "NET_PROCESS", "LLM_RESPONSE_FIRST_TOKEN", "GET_CUSTOM_MODEL", "SVR_PLATFORM_FIRST_TOKEN_TIMING", "SVR_PROCESSING_TIME", "REGISTERED_TOOLS", "", "EMPTY_TOOLS", "trackingContexts", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;", "metadataReadyTaskIds", "", "kotlin.jvm.PlatformType", "Ljava/util/Set;", "firstTokenFiredTaskIds", "timingEventsStore", "Lkotlin/Pair;", "", "", "Lcom/bytedance/trae/im/service/IMService$TimingMeta;", "reportedContexts", "Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;", "onSendMessage", "", "taskId", "sessionId", "model", "hasText", "", "imageCount", "", "onSendResponse", "removeTaskId", "migrateTo", "oldKey", "newTaskId", "onQueuing", "updateMetadata", "agentType", "traceId", "modelStrategy", "configSource", "provider", "isPreset", "chatProcessVersion", "agentTaskServiceStrategy", "ttnetABTest", "sessionMessageCount", "requestClient", "agentProcessSupport", TimonPipeline.KEY_SOURCE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onMetadata", "metadataPayload", "Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;", "onTimingEvents", "data", "meta", "checkAndFireFirstToken", "conversationId", "thought", "reasoningContent", "toolName", "getTrackingContext", "hasFirstTokenFired", "onFirstToken", ReportConstant.COMMON_TIMESTAMP, "", "hasThought", "hasReasoning", "timingEvents", "timingMeta", "calculateAndPutStepDurations", "metrics", "Lorg/json/JSONObject;", "serverTimingEvents", "startTime", "sendResponseTime", "firstTokenTime", "getReportedContext", "clearReported", "clear", "TrackingContext", "FirstTokenReportedContext", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatFirstTokenTracker {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow";
    private static final String EVENT_NAME = "icube_ai_chat_first_token";
    private static final String FE_API_RESPONSE = "fe_01_send_response";
    private static final String FE_FRONT_END_RECEIVE = "fe_02_receive";
    private static final String FE_SEND = "fe_00_send";
    private static final String GET_CUSTOM_MODEL = "rs_06_get_custom_model";
    private static final String LLM_RESPONSE_FIRST_TOKEN = "rs_18_llm_response_first_token";
    private static final String NET_PROCESS = "net_01_process";
    private static final String SVR_PLATFORM_FIRST_TOKEN_TIMING = "svr_06_platform_first_token_timing";
    private static final String SVR_PROCESSING_TIME = "svr_11_server_processing_time";
    private static final String TAG = "ChatFirstTokenTracker";
    public static final ChatFirstTokenTracker INSTANCE = new ChatFirstTokenTracker();
    private static final Set<String> REGISTERED_TOOLS = SetsKt.setOf(new String[]{"create_file", "CreateFile", "write_to_file", "Write", "WriteToFile", "edit_file_search_replace", "edit_file_update", "Edit", "MultiEdit", "SearchReplace", "EditFile", "WriteToProductDocument", "EditProductDocumentFastApply", "EditProductDocumentUpdate", "write_to_product_document", "edit_product_document_fast_apply", "edit_product_document_update", "edit_product_document_update_fc", "show_diff", "show_diff_fc", "delete_file", "DeleteFile", "view_file", "ViewFile", "Read", "view_files", "ViewFiles", "view_folder", "ViewFolder", "LS", "open_folder", "file_search", "FileSearch", "search_by_regex", "Grep", "Glob", "search_codebase", "SearchCodebase", "web_search", "WebSearch", "WebFetch", "run_command", "RunCommand", "exec_command", "Shell", "check_command_status", "CheckCommandStatus", "browser_action", "BrowserAction", "browser_use", "BrowserUse", "browser_navigate", "browser_navigate_back", "browser_navigate_forward", "browser_click", "browser_type", "browser_press_key", "browser_scroll", "browser_select_option", "browser_snapshot", "browser_take_screenshot", "browser_fill", "browser_wait_for", "browser_hover", "browser_get_attribute", "browser_lock", "browser_unlock", "browser_console_messages", "browser_drag", "browser_evaluate", "browser_fill_form", "browser_get_bounding_box", "browser_get_input_value", "browser_handle_dialog", "browser_highlight", "browser_is_checked", "browser_is_enabled", "browser_is_visible", "browser_network_requests", "browser_reload", "browser_resize", "browser_search", "browser_tabs", "browser_waiting_for_user_interaction", "browser_hand_over", "todo_write", "TodoWrite", "AskUserQuestion", "NotifyUser", "ExitPlanMode", "Schedule", "finish", "Finish", "response_to_user", "ResponseToUser", "agent_finish", "Task", "run_mcp", "mcp_call", "MCPCall", "Skill", "open_preview", "OpenPreview", "open_preview_and_wait_for_error", "environment_setup", "EnvironmentSetup", "init_env", "image_ocr", "CompactFake", "GenerateImage", "manage_core_memory", "ManageCoreMemory", "get_preview_console_logs", "deploy_to_remote", "update_shallow_memento", "update_shallow_memento_fc", "condense_shallow_memento", "get_llm_config", "supabase_get_project", "supabase_apply_migration", "stripe_get_config", "create_requirement"});
    private static final Set<String> EMPTY_TOOLS = SetsKt.setOf(new String[]{"check_command_status", "CheckCommandStatus"});
    private static final ConcurrentHashMap<String, TrackingContext> trackingContexts = new ConcurrentHashMap<>();
    private static final Set<String> metadataReadyTaskIds = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final Set<String> firstTokenFiredTaskIds = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final ConcurrentHashMap<String, Pair<Map<String, Double>, IMService.TimingMeta>> timingEventsStore = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, FirstTokenReportedContext> reportedContexts = new ConcurrentHashMap<>();

    private ChatFirstTokenTracker() {
    }

    /* compiled from: ChatFirstTokenTracker.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\bY\b\u0086\b\u0018\u00002\u00020\u0001Bï\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\nHÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010CJ\t\u0010c\u001a\u00020\nHÆ\u0003J\t\u0010d\u001a\u00020\u0015HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jø\u0001\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020\n2\b\u0010k\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010l\u001a\u00020\u0015HÖ\u0001J\t\u0010m\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001e\"\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010!R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b\u0010\u00108\"\u0004\b9\u0010:R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010#\"\u0004\b=\u0010%R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010+\"\u0004\bH\u0010-R\u001a\u0010\u0017\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010#\"\u0004\bN\u0010%R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010#\"\u0004\bR\u0010%¨\u0006n"}, d2 = {"Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;", "", "startTime", "", "sendResponseTime", "sessionId", "", "model", "agentType", "queued", "", "queueStartTime", "traceId", "modelStrategy", "configSource", "provider", "isPreset", "chatProcessVersion", "agentTaskServiceStrategy", "ttnetABTest", "sessionMessageCount", "", "hasText", "imageCount", "requestClient", "agentProcessSupport", TimonPipeline.KEY_SOURCE, "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStartTime", "()J", "getSendResponseTime", "setSendResponseTime", "(J)V", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getModel", "setModel", "getAgentType", "setAgentType", "getQueued", "()Z", "setQueued", "(Z)V", "getQueueStartTime", "setQueueStartTime", "getTraceId", "setTraceId", "getModelStrategy", "setModelStrategy", "getConfigSource", "setConfigSource", "getProvider", "setProvider", "()Ljava/lang/Boolean;", "setPreset", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getChatProcessVersion", "setChatProcessVersion", "getAgentTaskServiceStrategy", "setAgentTaskServiceStrategy", "getTtnetABTest", "setTtnetABTest", "getSessionMessageCount", "()Ljava/lang/Integer;", "setSessionMessageCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasText", "setHasText", "getImageCount", "()I", "setImageCount", "(I)V", "getRequestClient", "setRequestClient", "getAgentProcessSupport", "setAgentProcessSupport", "getSource", "setSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;", "equals", "other", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TrackingContext {
        private String agentProcessSupport;
        private String agentTaskServiceStrategy;
        private String agentType;
        private String chatProcessVersion;
        private String configSource;
        private boolean hasText;
        private int imageCount;
        private Boolean isPreset;
        private String model;
        private String modelStrategy;
        private String provider;
        private long queueStartTime;
        private boolean queued;
        private String requestClient;
        private long sendResponseTime;
        private String sessionId;
        private Integer sessionMessageCount;
        private String source;
        private final long startTime;
        private String traceId;
        private String ttnetABTest;

        /* renamed from: component1, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        /* renamed from: component10, reason: from getter */
        public final String getConfigSource() {
            return this.configSource;
        }

        /* renamed from: component11, reason: from getter */
        public final String getProvider() {
            return this.provider;
        }

        /* renamed from: component12, reason: from getter */
        public final Boolean getIsPreset() {
            return this.isPreset;
        }

        /* renamed from: component13, reason: from getter */
        public final String getChatProcessVersion() {
            return this.chatProcessVersion;
        }

        /* renamed from: component14, reason: from getter */
        public final String getAgentTaskServiceStrategy() {
            return this.agentTaskServiceStrategy;
        }

        /* renamed from: component15, reason: from getter */
        public final String getTtnetABTest() {
            return this.ttnetABTest;
        }

        /* renamed from: component16, reason: from getter */
        public final Integer getSessionMessageCount() {
            return this.sessionMessageCount;
        }

        /* renamed from: component17, reason: from getter */
        public final boolean getHasText() {
            return this.hasText;
        }

        /* renamed from: component18, reason: from getter */
        public final int getImageCount() {
            return this.imageCount;
        }

        /* renamed from: component19, reason: from getter */
        public final String getRequestClient() {
            return this.requestClient;
        }

        /* renamed from: component2, reason: from getter */
        public final long getSendResponseTime() {
            return this.sendResponseTime;
        }

        /* renamed from: component20, reason: from getter */
        public final String getAgentProcessSupport() {
            return this.agentProcessSupport;
        }

        /* renamed from: component21, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        /* renamed from: component5, reason: from getter */
        public final String getAgentType() {
            return this.agentType;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getQueued() {
            return this.queued;
        }

        /* renamed from: component7, reason: from getter */
        public final long getQueueStartTime() {
            return this.queueStartTime;
        }

        /* renamed from: component8, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        /* renamed from: component9, reason: from getter */
        public final String getModelStrategy() {
            return this.modelStrategy;
        }

        public final TrackingContext copy(long startTime, long sendResponseTime, String sessionId, String model, String agentType, boolean queued, long queueStartTime, String traceId, String modelStrategy, String configSource, String provider, Boolean isPreset, String chatProcessVersion, String agentTaskServiceStrategy, String ttnetABTest, Integer sessionMessageCount, boolean hasText, int imageCount, String requestClient, String agentProcessSupport, String source) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(agentType, "agentType");
            return new TrackingContext(startTime, sendResponseTime, sessionId, model, agentType, queued, queueStartTime, traceId, modelStrategy, configSource, provider, isPreset, chatProcessVersion, agentTaskServiceStrategy, ttnetABTest, sessionMessageCount, hasText, imageCount, requestClient, agentProcessSupport, source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrackingContext)) {
                return false;
            }
            TrackingContext trackingContext = (TrackingContext) other;
            return this.startTime == trackingContext.startTime && this.sendResponseTime == trackingContext.sendResponseTime && Intrinsics.areEqual(this.sessionId, trackingContext.sessionId) && Intrinsics.areEqual(this.model, trackingContext.model) && Intrinsics.areEqual(this.agentType, trackingContext.agentType) && this.queued == trackingContext.queued && this.queueStartTime == trackingContext.queueStartTime && Intrinsics.areEqual(this.traceId, trackingContext.traceId) && Intrinsics.areEqual(this.modelStrategy, trackingContext.modelStrategy) && Intrinsics.areEqual(this.configSource, trackingContext.configSource) && Intrinsics.areEqual(this.provider, trackingContext.provider) && Intrinsics.areEqual(this.isPreset, trackingContext.isPreset) && Intrinsics.areEqual(this.chatProcessVersion, trackingContext.chatProcessVersion) && Intrinsics.areEqual(this.agentTaskServiceStrategy, trackingContext.agentTaskServiceStrategy) && Intrinsics.areEqual(this.ttnetABTest, trackingContext.ttnetABTest) && Intrinsics.areEqual(this.sessionMessageCount, trackingContext.sessionMessageCount) && this.hasText == trackingContext.hasText && this.imageCount == trackingContext.imageCount && Intrinsics.areEqual(this.requestClient, trackingContext.requestClient) && Intrinsics.areEqual(this.agentProcessSupport, trackingContext.agentProcessSupport) && Intrinsics.areEqual(this.source, trackingContext.source);
        }

        public int hashCode() {
            int hashCode = ((((((((((((Long.hashCode(this.startTime) * 31) + Long.hashCode(this.sendResponseTime)) * 31) + this.sessionId.hashCode()) * 31) + this.model.hashCode()) * 31) + this.agentType.hashCode()) * 31) + Boolean.hashCode(this.queued)) * 31) + Long.hashCode(this.queueStartTime)) * 31;
            String str = this.traceId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.modelStrategy;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.configSource;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.provider;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Boolean bool = this.isPreset;
            int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str5 = this.chatProcessVersion;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.agentTaskServiceStrategy;
            int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.ttnetABTest;
            int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Integer num = this.sessionMessageCount;
            int hashCode10 = (((((hashCode9 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.hasText)) * 31) + Integer.hashCode(this.imageCount)) * 31;
            String str8 = this.requestClient;
            int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.agentProcessSupport;
            int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.source;
            return hashCode12 + (str10 != null ? str10.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("TrackingContext(startTime=");
            sb.append(this.startTime).append(", sendResponseTime=").append(this.sendResponseTime).append(", sessionId=").append(this.sessionId).append(", model=").append(this.model).append(", agentType=").append(this.agentType).append(", queued=").append(this.queued).append(", queueStartTime=").append(this.queueStartTime).append(", traceId=").append(this.traceId).append(", modelStrategy=").append(this.modelStrategy).append(", configSource=").append(this.configSource).append(", provider=").append(this.provider).append(", isPreset=");
            sb.append(this.isPreset).append(", chatProcessVersion=").append(this.chatProcessVersion).append(", agentTaskServiceStrategy=").append(this.agentTaskServiceStrategy).append(", ttnetABTest=").append(this.ttnetABTest).append(", sessionMessageCount=").append(this.sessionMessageCount).append(", hasText=").append(this.hasText).append(", imageCount=").append(this.imageCount).append(", requestClient=").append(this.requestClient).append(", agentProcessSupport=").append(this.agentProcessSupport).append(", source=").append(this.source).append(')');
            return sb.toString();
        }

        public TrackingContext(long j, long j2, String str, String str2, String str3, boolean z, long j3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, Integer num, boolean z2, int i, String str11, String str12, String str13) {
            Intrinsics.checkNotNullParameter(str, "sessionId");
            Intrinsics.checkNotNullParameter(str2, "model");
            Intrinsics.checkNotNullParameter(str3, "agentType");
            this.startTime = j;
            this.sendResponseTime = j2;
            this.sessionId = str;
            this.model = str2;
            this.agentType = str3;
            this.queued = z;
            this.queueStartTime = j3;
            this.traceId = str4;
            this.modelStrategy = str5;
            this.configSource = str6;
            this.provider = str7;
            this.isPreset = bool;
            this.chatProcessVersion = str8;
            this.agentTaskServiceStrategy = str9;
            this.ttnetABTest = str10;
            this.sessionMessageCount = num;
            this.hasText = z2;
            this.imageCount = i;
            this.requestClient = str11;
            this.agentProcessSupport = str12;
            this.source = str13;
        }

        public /* synthetic */ TrackingContext(long j, long j2, String str, String str2, String str3, boolean z, long j3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, Integer num, boolean z2, int i, String str11, String str12, String str13, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? 0L : j3, (i2 & 128) != 0 ? null : str4, (i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str5, (i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : str6, (i2 & 1024) != 0 ? null : str7, (i2 & 2048) != 0 ? null : bool, (i2 & 4096) != 0 ? null : str8, (i2 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? null : str9, (i2 & 16384) != 0 ? null : str10, (32768 & i2) != 0 ? null : num, (65536 & i2) != 0 ? true : z2, (131072 & i2) != 0 ? 0 : i, (262144 & i2) != 0 ? null : str11, (524288 & i2) != 0 ? null : str12, (i2 & 1048576) != 0 ? null : str13);
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final long getSendResponseTime() {
            return this.sendResponseTime;
        }

        public final void setSendResponseTime(long j) {
            this.sendResponseTime = j;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final void setSessionId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sessionId = str;
        }

        public final String getModel() {
            return this.model;
        }

        public final void setModel(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.model = str;
        }

        public final String getAgentType() {
            return this.agentType;
        }

        public final void setAgentType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.agentType = str;
        }

        public final boolean getQueued() {
            return this.queued;
        }

        public final void setQueued(boolean z) {
            this.queued = z;
        }

        public final long getQueueStartTime() {
            return this.queueStartTime;
        }

        public final void setQueueStartTime(long j) {
            this.queueStartTime = j;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public final void setTraceId(String str) {
            this.traceId = str;
        }

        public final String getModelStrategy() {
            return this.modelStrategy;
        }

        public final void setModelStrategy(String str) {
            this.modelStrategy = str;
        }

        public final String getConfigSource() {
            return this.configSource;
        }

        public final void setConfigSource(String str) {
            this.configSource = str;
        }

        public final String getProvider() {
            return this.provider;
        }

        public final void setProvider(String str) {
            this.provider = str;
        }

        public final Boolean isPreset() {
            return this.isPreset;
        }

        public final void setPreset(Boolean bool) {
            this.isPreset = bool;
        }

        public final String getChatProcessVersion() {
            return this.chatProcessVersion;
        }

        public final void setChatProcessVersion(String str) {
            this.chatProcessVersion = str;
        }

        public final String getAgentTaskServiceStrategy() {
            return this.agentTaskServiceStrategy;
        }

        public final void setAgentTaskServiceStrategy(String str) {
            this.agentTaskServiceStrategy = str;
        }

        public final String getTtnetABTest() {
            return this.ttnetABTest;
        }

        public final void setTtnetABTest(String str) {
            this.ttnetABTest = str;
        }

        public final Integer getSessionMessageCount() {
            return this.sessionMessageCount;
        }

        public final void setSessionMessageCount(Integer num) {
            this.sessionMessageCount = num;
        }

        public final boolean getHasText() {
            return this.hasText;
        }

        public final void setHasText(boolean z) {
            this.hasText = z;
        }

        public final int getImageCount() {
            return this.imageCount;
        }

        public final void setImageCount(int i) {
            this.imageCount = i;
        }

        public final String getRequestClient() {
            return this.requestClient;
        }

        public final void setRequestClient(String str) {
            this.requestClient = str;
        }

        public final String getAgentProcessSupport() {
            return this.agentProcessSupport;
        }

        public final void setAgentProcessSupport(String str) {
            this.agentProcessSupport = str;
        }

        public final String getSource() {
            return this.source;
        }

        public final void setSource(String str) {
            this.source = str;
        }
    }

    /* compiled from: ChatFirstTokenTracker.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;", "", "categories", "Lorg/json/JSONObject;", "metrics", "firstTokenTime", "", "serverTimingInfo", "", "<init>", "(Lorg/json/JSONObject;Lorg/json/JSONObject;JLjava/lang/String;)V", "getCategories", "()Lorg/json/JSONObject;", "getMetrics", "getFirstTokenTime", "()J", "getServerTimingInfo", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class FirstTokenReportedContext {
        private final JSONObject categories;
        private final long firstTokenTime;
        private final JSONObject metrics;
        private final String serverTimingInfo;

        public static /* synthetic */ FirstTokenReportedContext copy$default(FirstTokenReportedContext firstTokenReportedContext, JSONObject jSONObject, JSONObject jSONObject2, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONObject = firstTokenReportedContext.categories;
            }
            if ((i & 2) != 0) {
                jSONObject2 = firstTokenReportedContext.metrics;
            }
            JSONObject jSONObject3 = jSONObject2;
            if ((i & 4) != 0) {
                j = firstTokenReportedContext.firstTokenTime;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                str = firstTokenReportedContext.serverTimingInfo;
            }
            return firstTokenReportedContext.copy(jSONObject, jSONObject3, j2, str);
        }

        /* renamed from: component1, reason: from getter */
        public final JSONObject getCategories() {
            return this.categories;
        }

        /* renamed from: component2, reason: from getter */
        public final JSONObject getMetrics() {
            return this.metrics;
        }

        /* renamed from: component3, reason: from getter */
        public final long getFirstTokenTime() {
            return this.firstTokenTime;
        }

        /* renamed from: component4, reason: from getter */
        public final String getServerTimingInfo() {
            return this.serverTimingInfo;
        }

        public final FirstTokenReportedContext copy(JSONObject categories, JSONObject metrics, long firstTokenTime, String serverTimingInfo) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(metrics, "metrics");
            return new FirstTokenReportedContext(categories, metrics, firstTokenTime, serverTimingInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FirstTokenReportedContext)) {
                return false;
            }
            FirstTokenReportedContext firstTokenReportedContext = (FirstTokenReportedContext) other;
            return Intrinsics.areEqual(this.categories, firstTokenReportedContext.categories) && Intrinsics.areEqual(this.metrics, firstTokenReportedContext.metrics) && this.firstTokenTime == firstTokenReportedContext.firstTokenTime && Intrinsics.areEqual(this.serverTimingInfo, firstTokenReportedContext.serverTimingInfo);
        }

        public int hashCode() {
            int hashCode = ((((this.categories.hashCode() * 31) + this.metrics.hashCode()) * 31) + Long.hashCode(this.firstTokenTime)) * 31;
            String str = this.serverTimingInfo;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "FirstTokenReportedContext(categories=" + this.categories + ", metrics=" + this.metrics + ", firstTokenTime=" + this.firstTokenTime + ", serverTimingInfo=" + this.serverTimingInfo + ')';
        }

        public FirstTokenReportedContext(JSONObject jSONObject, JSONObject jSONObject2, long j, String str) {
            Intrinsics.checkNotNullParameter(jSONObject, "categories");
            Intrinsics.checkNotNullParameter(jSONObject2, "metrics");
            this.categories = jSONObject;
            this.metrics = jSONObject2;
            this.firstTokenTime = j;
            this.serverTimingInfo = str;
        }

        public final JSONObject getCategories() {
            return this.categories;
        }

        public final JSONObject getMetrics() {
            return this.metrics;
        }

        public final long getFirstTokenTime() {
            return this.firstTokenTime;
        }

        public final String getServerTimingInfo() {
            return this.serverTimingInfo;
        }
    }

    public static /* synthetic */ void onSendMessage$default(ChatFirstTokenTracker chatFirstTokenTracker, String str, String str2, String str3, boolean z, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = "";
        }
        chatFirstTokenTracker.onSendMessage(str, str2, str3, z, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSendMessage(String taskId, String sessionId, String model, boolean hasText, int imageCount) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(model, "model");
        trackingContexts.put(taskId, new TrackingContext(System.currentTimeMillis(), 0L, sessionId, model, null, false, 0L, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, hasText, imageCount, null, null, null, 1900530, null));
    }

    public final void onSendResponse(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        TrackingContext trackingContext = trackingContexts.get(taskId);
        if (trackingContext == null) {
            return;
        }
        trackingContext.setSendResponseTime(System.currentTimeMillis());
    }

    public final void removeTaskId(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        trackingContexts.remove(taskId);
    }

    public final void migrateTo(String oldKey, String newTaskId) {
        Intrinsics.checkNotNullParameter(oldKey, "oldKey");
        Intrinsics.checkNotNullParameter(newTaskId, "newTaskId");
        ConcurrentHashMap<String, TrackingContext> concurrentHashMap = trackingContexts;
        TrackingContext remove = concurrentHashMap.remove(oldKey);
        if (remove == null) {
            return;
        }
        concurrentHashMap.put(newTaskId, remove);
    }

    public final void onQueuing(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        try {
            TrackingContext trackingContext = trackingContexts.get(taskId);
            if (trackingContext == null || trackingContext.getQueued()) {
                return;
            }
            trackingContext.setQueued(true);
            trackingContext.setQueueStartTime(System.currentTimeMillis());
        } catch (Throwable unused) {
        }
    }

    public final void updateMetadata(String taskId, String agentType, String traceId, String modelStrategy, String configSource, String provider, Boolean isPreset, String chatProcessVersion, String agentTaskServiceStrategy, String ttnetABTest, Integer sessionMessageCount, String requestClient, String agentProcessSupport, String source) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        TrackingContext trackingContext = trackingContexts.get(taskId);
        if (trackingContext == null) {
            return;
        }
        if (agentType != null) {
            trackingContext.setAgentType(agentType);
        }
        if (traceId != null) {
            trackingContext.setTraceId(traceId);
        }
        if (modelStrategy != null) {
            trackingContext.setModelStrategy(modelStrategy);
        }
        if (configSource != null) {
            trackingContext.setConfigSource(configSource);
        }
        if (provider != null) {
            trackingContext.setProvider(provider);
        }
        if (isPreset != null) {
            trackingContext.setPreset(Boolean.valueOf(isPreset.booleanValue()));
        }
        if (chatProcessVersion != null) {
            trackingContext.setChatProcessVersion(chatProcessVersion);
        }
        if (agentTaskServiceStrategy != null) {
            trackingContext.setAgentTaskServiceStrategy(agentTaskServiceStrategy);
        }
        if (ttnetABTest != null) {
            trackingContext.setTtnetABTest(ttnetABTest);
        }
        if (sessionMessageCount != null) {
            trackingContext.setSessionMessageCount(Integer.valueOf(sessionMessageCount.intValue()));
        }
        if (requestClient != null) {
            trackingContext.setRequestClient(requestClient);
        }
        if (agentProcessSupport != null) {
            trackingContext.setAgentProcessSupport(agentProcessSupport);
        }
        if (source != null) {
            trackingContext.setSource(source);
        }
    }

    public static /* synthetic */ void onMetadata$default(ChatFirstTokenTracker chatFirstTokenTracker, String str, ChatEventPayload.Metadata metadata, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        chatFirstTokenTracker.onMetadata(str, metadata, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[Catch: all -> 0x00c6, TryCatch #0 {all -> 0x00c6, blocks: (B:3:0x000f, B:7:0x0018, B:9:0x001f, B:11:0x0027, B:13:0x002d, B:19:0x003c, B:20:0x0043, B:22:0x004f, B:23:0x0054, B:25:0x006a, B:26:0x0071, B:28:0x007b, B:30:0x0081, B:32:0x0087, B:33:0x008e, B:35:0x0094, B:37:0x009a, B:38:0x00a1, B:40:0x00a7, B:42:0x00ad, B:43:0x00b4), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[Catch: all -> 0x00c6, TryCatch #0 {all -> 0x00c6, blocks: (B:3:0x000f, B:7:0x0018, B:9:0x001f, B:11:0x0027, B:13:0x002d, B:19:0x003c, B:20:0x0043, B:22:0x004f, B:23:0x0054, B:25:0x006a, B:26:0x0071, B:28:0x007b, B:30:0x0081, B:32:0x0087, B:33:0x008e, B:35:0x0094, B:37:0x009a, B:38:0x00a1, B:40:0x00a7, B:42:0x00ad, B:43:0x00b4), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMetadata(String taskId, ChatEventPayload.Metadata metadataPayload, String source) {
        String str;
        ModelInfo modelInfo;
        ModelInfo modelInfo2;
        ModelInfo modelInfo3;
        Integer configSource;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(metadataPayload, "metadataPayload");
        try {
            if (trackingContexts.containsKey(taskId)) {
                JsonObject modelSmartSelectionMeta = metadataPayload.getModelSmartSelectionMeta();
                if (modelSmartSelectionMeta != null && (jsonElement = modelSmartSelectionMeta.get("mode")) != null) {
                    if (!(!jsonElement.isJsonNull() && jsonElement.isJsonPrimitive())) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        str = jsonElement.getAsString();
                        if (Intrinsics.areEqual(metadataPayload.getMetadataStatus(), "done")) {
                            metadataReadyTaskIds.add(taskId);
                        }
                        String agentType = metadataPayload.getAgentType();
                        String traceId = metadataPayload.getTraceId();
                        String chatProcessVersion = metadataPayload.getChatProcessVersion();
                        String agentTaskServiceStrategy = metadataPayload.getAgentTaskServiceStrategy();
                        Object ttnetAbtest = metadataPayload.getTtnetAbtest();
                        String obj = ttnetAbtest == null ? ttnetAbtest.toString() : null;
                        Integer messageIndex = metadataPayload.getMessageIndex();
                        UserMessageContext userMessageContext = metadataPayload.getUserMessageContext();
                        String num = (userMessageContext != null || (modelInfo3 = userMessageContext.getModelInfo()) == null || (configSource = modelInfo3.getConfigSource()) == null) ? null : configSource.toString();
                        UserMessageContext userMessageContext2 = metadataPayload.getUserMessageContext();
                        String provider = (userMessageContext2 != null || (modelInfo2 = userMessageContext2.getModelInfo()) == null) ? null : modelInfo2.getProvider();
                        UserMessageContext userMessageContext3 = metadataPayload.getUserMessageContext();
                        updateMetadata(taskId, agentType, traceId, str, num, provider, (userMessageContext3 != null || (modelInfo = userMessageContext3.getModelInfo()) == null) ? null : modelInfo.isPreset(), chatProcessVersion, agentTaskServiceStrategy, obj, messageIndex, metadataPayload.getRequestClient(), metadataPayload.getAgentProcessSupport(), source);
                    }
                }
                str = null;
                if (Intrinsics.areEqual(metadataPayload.getMetadataStatus(), "done")) {
                }
                String agentType2 = metadataPayload.getAgentType();
                String traceId2 = metadataPayload.getTraceId();
                String chatProcessVersion2 = metadataPayload.getChatProcessVersion();
                String agentTaskServiceStrategy2 = metadataPayload.getAgentTaskServiceStrategy();
                Object ttnetAbtest2 = metadataPayload.getTtnetAbtest();
                if (ttnetAbtest2 == null) {
                }
                Integer messageIndex2 = metadataPayload.getMessageIndex();
                UserMessageContext userMessageContext4 = metadataPayload.getUserMessageContext();
                if (userMessageContext4 != null) {
                }
                UserMessageContext userMessageContext22 = metadataPayload.getUserMessageContext();
                if (userMessageContext22 != null) {
                }
                UserMessageContext userMessageContext32 = metadataPayload.getUserMessageContext();
                updateMetadata(taskId, agentType2, traceId2, str, num, provider, (userMessageContext32 != null || (modelInfo = userMessageContext32.getModelInfo()) == null) ? null : modelInfo.isPreset(), chatProcessVersion2, agentTaskServiceStrategy2, obj, messageIndex2, metadataPayload.getRequestClient(), metadataPayload.getAgentProcessSupport(), source);
            }
        } catch (Throwable th) {
            TraeLogUtil.INSTANCE.d(TAG, "onMetadata: taskId=" + taskId, th);
        }
    }

    public final void onTimingEvents(String taskId, Map<String, Double> data, IMService.TimingMeta meta) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(meta, "meta");
        if (trackingContexts.containsKey(taskId)) {
            timingEventsStore.put(taskId, new Pair<>(data, meta));
        }
    }

    public final boolean checkAndFireFirstToken(String taskId, String conversationId, String thought, String reasoningContent, String toolName) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        if (!metadataReadyTaskIds.contains(taskId) || !trackingContexts.containsKey(taskId)) {
            return false;
        }
        Set<String> set = firstTokenFiredTaskIds;
        if (!set.add(taskId)) {
            return false;
        }
        String str = thought;
        boolean z = !(str == null || StringsKt.isBlank(str));
        String str2 = reasoningContent;
        boolean z2 = !(str2 == null || StringsKt.isBlank(str2));
        boolean z3 = (toolName == null || !REGISTERED_TOOLS.contains(toolName) || EMPTY_TOOLS.contains(toolName)) ? false : true;
        if (!z && !z2 && !z3) {
            set.remove(taskId);
            return false;
        }
        ConcurrentHashMap<String, Pair<Map<String, Double>, IMService.TimingMeta>> concurrentHashMap = timingEventsStore;
        Pair<Map<String, Double>, IMService.TimingMeta> pair = concurrentHashMap.get(taskId);
        if (pair == null) {
            set.remove(taskId);
            return false;
        }
        concurrentHashMap.remove(taskId);
        onFirstToken(taskId, conversationId, System.currentTimeMillis(), z, z2, toolName, (Map) pair.getFirst(), (IMService.TimingMeta) pair.getSecond());
        return true;
    }

    public final TrackingContext getTrackingContext(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return trackingContexts.get(taskId);
    }

    public final boolean hasFirstTokenFired(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return firstTokenFiredTaskIds.contains(taskId);
    }

    public final void onFirstToken(String taskId, String conversationId, long timestamp, boolean hasThought, boolean hasReasoning, String toolName, Map<String, Double> timingEvents, IMService.TimingMeta timingMeta) {
        String model;
        String str;
        String str2;
        String str3;
        Boolean enableDbOpt;
        Boolean isServerRetried;
        String modelProviderName;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        TrackingContext trackingContext = trackingContexts.get(taskId);
        if (trackingContext == null) {
            TraeLogUtil.INSTANCE.d(TAG, "onFirstToken: no tracking context for taskId=" + taskId + ", skip report");
            return;
        }
        long startTime = timestamp - trackingContext.getStartTime();
        if (timingMeta == null || (model = timingMeta.getModelName()) == null) {
            model = trackingContext.getModel();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", trackingContext.getStartTime());
        jSONObject.put(PageDataManager.EXTRA_STATUS, "Success");
        jSONObject.put("sessionId", trackingContext.getSessionId());
        jSONObject.put("model", model);
        jSONObject.put("agentType", trackingContext.getAgentType());
        jSONObject.put("hasThought", hasThought ? "true" : "false");
        jSONObject.put("hasReasoning", hasReasoning ? "true" : "false");
        jSONObject.put("hasText", trackingContext.getHasText() ? "true" : "false");
        jSONObject.put("imageCount", trackingContext.getImageCount());
        String str4 = "";
        jSONObject.put("planItemName", toolName == null ? "" : toolName);
        jSONObject.put("queued", trackingContext.getQueued() ? 1 : 0);
        if (trackingContext.getQueued() && trackingContext.getQueueStartTime() > 0) {
            jSONObject.put("queueStartTime", trackingContext.getQueueStartTime());
            jSONObject.put("queueCostTime", timestamp - trackingContext.getQueueStartTime());
        }
        String traceId = trackingContext.getTraceId();
        if (traceId == null) {
            traceId = "";
        }
        jSONObject.put("traceId", traceId);
        String modelStrategy = trackingContext.getModelStrategy();
        if (modelStrategy == null) {
            modelStrategy = ModelSelectionConstants.AUTO;
        }
        jSONObject.put("modelStrategy", modelStrategy);
        String configSource = trackingContext.getConfigSource();
        if (configSource == null) {
            configSource = "";
        }
        jSONObject.put("configSource", configSource);
        String provider = trackingContext.getProvider();
        if (provider == null) {
            provider = "";
        }
        jSONObject.put("provider", provider);
        String chatProcessVersion = trackingContext.getChatProcessVersion();
        if (chatProcessVersion == null) {
            chatProcessVersion = "";
        }
        jSONObject.put("chatProcessVersion", chatProcessVersion);
        String agentTaskServiceStrategy = trackingContext.getAgentTaskServiceStrategy();
        if (agentTaskServiceStrategy == null) {
            agentTaskServiceStrategy = "";
        }
        jSONObject.put("agentTaskServiceStrategy", agentTaskServiceStrategy);
        String ttnetABTest = trackingContext.getTtnetABTest();
        if (ttnetABTest == null) {
            ttnetABTest = "";
        }
        jSONObject.put("ttnetABTest", ttnetABTest);
        String requestClient = trackingContext.getRequestClient();
        if (requestClient == null) {
            requestClient = "";
        }
        jSONObject.put("requestClient", requestClient);
        String agentProcessSupport = trackingContext.getAgentProcessSupport();
        if (agentProcessSupport == null) {
            agentProcessSupport = "";
        }
        jSONObject.put("agentProcessSupport", agentProcessSupport);
        String source = trackingContext.getSource();
        if (source != null) {
            jSONObject.put(TimonPipeline.KEY_SOURCE, source);
        }
        if (timingMeta == null || (str = timingMeta.getLogid()) == null) {
            str = "";
        }
        jSONObject.put(AccountMonitorConstants.CommonParameter.LOGID, str);
        if (timingMeta == null || (str2 = timingMeta.getModelAccountName()) == null) {
            str2 = "";
        }
        jSONObject.put("modelAccountName", str2);
        if (timingMeta == null || (str3 = timingMeta.getModelAccountType()) == null) {
            str3 = "";
        }
        jSONObject.put("modelAccountType", str3);
        if (timingMeta != null && (modelProviderName = timingMeta.getModelProviderName()) != null) {
            str4 = modelProviderName;
        }
        jSONObject.put("modelProviderName", str4);
        jSONObject.put("isServerRetried", String.valueOf((timingMeta == null || (isServerRetried = timingMeta.isServerRetried()) == null) ? false : isServerRetried.booleanValue()));
        jSONObject.put("enableDbOpt", String.valueOf((timingMeta == null || (enableDbOpt = timingMeta.getEnableDbOpt()) == null) ? false : enableDbOpt.booleanValue()));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("costTime", startTime);
        jSONObject2.put("startTime", trackingContext.getStartTime());
        Integer sessionMessageCount = trackingContext.getSessionMessageCount();
        if (sessionMessageCount != null) {
            jSONObject2.put("sessionMessageCount", sessionMessageCount.intValue());
        }
        if (trackingContext.getSendResponseTime() > 0) {
            jSONObject2.put(FE_SEND, 0);
            jSONObject2.put(FE_API_RESPONSE, trackingContext.getSendResponseTime() - trackingContext.getStartTime());
        }
        if (timingEvents != null) {
            INSTANCE.calculateAndPutStepDurations(jSONObject2, timingEvents, trackingContext.getStartTime(), trackingContext.getSendResponseTime(), timestamp);
        }
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> keys = jSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNull(next);
            if (!StringsKt.startsWith$default(next, "svr__", false, 2, (Object) null)) {
                jSONObject3.put(next, jSONObject2.get(next));
            }
        }
        ApmService.INSTANCE.monitorEventForSlardar(EVENT_NAME, jSONObject, jSONObject3, (JSONObject) null);
        reportedContexts.put(taskId, new FirstTokenReportedContext(jSONObject, jSONObject2, timestamp, timingMeta != null ? timingMeta.getServerTimingInfo() : null));
    }

    private final void calculateAndPutStepDurations(JSONObject metrics, Map<String, Double> serverTimingEvents, long startTime, long sendResponseTime, long firstTokenTime) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(serverTimingEvents);
        linkedHashMap.put(FE_SEND, Double.valueOf(startTime));
        if (sendResponseTime > 0) {
            linkedHashMap.put(FE_API_RESPONSE, Double.valueOf(sendResponseTime));
        }
        linkedHashMap.put(FE_FRONT_END_RECEIVE, Double.valueOf(firstTokenTime));
        long j = firstTokenTime - startTime;
        Set keySet = linkedHashMap.keySet();
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : keySet) {
            if (StringsKt.startsWith$default((String) obj, "rs_06_resolver_", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        String str = "";
        double d = 0.0d;
        for (String str2 : arrayList) {
            Double d2 = (Double) linkedHashMap.get(str2);
            if (d2 != null) {
                double doubleValue = d2.doubleValue();
                if (doubleValue > d) {
                    str = str2;
                    d = doubleValue;
                }
                linkedHashMap.remove(str2);
            }
        }
        Double d3 = (Double) linkedHashMap.get(SVR_PROCESSING_TIME);
        double doubleValue2 = d3 != null ? d3.doubleValue() : 0.0d;
        Double d4 = (Double) linkedHashMap.get(SVR_PLATFORM_FIRST_TOKEN_TIMING);
        double doubleValue3 = d4 != null ? d4.doubleValue() : 0.0d;
        double d5 = doubleValue2 - doubleValue3;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            double d6 = doubleValue3;
            if (StringsKt.startsWith$default((String) entry.getKey(), "svr_", false, 2, (Object) null)) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
            doubleValue3 = d6;
        }
        double d7 = doubleValue3;
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            metrics.put((String) entry2.getKey(), (long) ((Number) entry2.getValue()).doubleValue());
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it.next();
            String str3 = (String) entry3.getKey();
            double doubleValue4 = ((Number) entry3.getValue()).doubleValue();
            Iterator it2 = it;
            if (!StringsKt.startsWith$default(str3, "svr_", false, 2, (Object) null)) {
                String str4 = (String) StringsKt.split$default(str3, new String[]{SyncConstants.SEPARATOR}, false, 0, 6, (Object) null).get(0);
                Object obj2 = linkedHashMap3.get(str4);
                if (obj2 == null) {
                    ArrayList arrayList2 = new ArrayList();
                    linkedHashMap3.put(str4, arrayList2);
                    obj2 = arrayList2;
                }
                ((List) obj2).add(new Pair(str3, Double.valueOf(doubleValue4)));
            }
            it = it2;
        }
        Double d8 = (Double) linkedHashMap.get(LLM_RESPONSE_FIRST_TOKEN);
        Iterator it3 = linkedHashMap3.entrySet().iterator();
        Double d9 = null;
        while (it3.hasNext()) {
            List list = (List) ((Map.Entry) it3.next()).getValue();
            Iterator it4 = it3;
            if (list.size() >= 2) {
                if (list.size() > 1) {
                    CollectionsKt.sortWith(list, new Comparator() { // from class: com.bytedance.trae.im.track.ChatFirstTokenTracker$calculateAndPutStepDurations$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues((Double) ((Pair) t).getSecond(), (Double) ((Pair) t2).getSecond());
                        }
                    });
                }
                int size = list.size();
                int i = 1;
                while (i < size) {
                    int i2 = size;
                    int i3 = i - 1;
                    long j2 = j;
                    LinkedHashMap linkedHashMap4 = linkedHashMap3;
                    metrics.put((String) ((Pair) list.get(i)).getFirst(), (long) (((Number) ((Pair) list.get(i)).getSecond()).doubleValue() - ((Number) ((Pair) list.get(i3)).getSecond()).doubleValue()));
                    if (Intrinsics.areEqual(((Pair) list.get(i)).getFirst(), LLM_RESPONSE_FIRST_TOKEN)) {
                        d9 = (Double) ((Pair) list.get(i3)).getSecond();
                    }
                    i++;
                    linkedHashMap3 = linkedHashMap4;
                    size = i2;
                    j = j2;
                }
            }
            it3 = it4;
        }
        long j3 = j;
        LinkedHashMap linkedHashMap5 = linkedHashMap3;
        if (d9 != null && d8 != null) {
            metrics.put(NET_PROCESS, (long) ((d8.doubleValue() - d9.doubleValue()) - doubleValue2));
        }
        if (str.length() > 0) {
            Double d10 = (Double) linkedHashMap.get(GET_CUSTOM_MODEL);
            metrics.put(str, (long) (d - (d10 != null ? d10.doubleValue() : 0.0d)));
        }
        long j4 = metrics.has(NET_PROCESS) ? metrics.getLong(NET_PROCESS) : 0L;
        long j5 = (long) d5;
        long j6 = (long) d7;
        metrics.put("svr_cost", j5);
        metrics.put("llm_cost", j6);
        metrics.put("client_cost", ((j3 - j5) - j6) - j4);
        LinkedHashMap linkedHashMap6 = new LinkedHashMap();
        for (Map.Entry entry4 : linkedHashMap5.entrySet()) {
            if (!Intrinsics.areEqual(entry4.getKey(), "fe")) {
                linkedHashMap6.put(entry4.getKey(), entry4.getValue());
            }
        }
        long j7 = 0;
        for (List list2 : linkedHashMap6.values()) {
            j7 += list2.size() >= 2 ? (long) (((Number) ((Pair) CollectionsKt.last(list2)).getSecond()).doubleValue() - ((Number) ((Pair) CollectionsKt.first(list2)).getSecond()).doubleValue()) : 0L;
        }
        metrics.put("hop", j3 - j7);
    }

    public final FirstTokenReportedContext getReportedContext(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return reportedContexts.get(taskId);
    }

    public final void clearReported(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        reportedContexts.remove(taskId);
    }

    public final void clear(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        trackingContexts.remove(taskId);
        reportedContexts.remove(taskId);
        metadataReadyTaskIds.remove(taskId);
        firstTokenFiredTaskIds.remove(taskId);
        timingEventsStore.remove(taskId);
    }
}
