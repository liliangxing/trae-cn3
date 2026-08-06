package com.bytedance.trae.im.service;

import com.bytedance.keva.Keva;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.log.IMLog;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.FastRequestSavings;
import com.bytedance.trae.im.model.MessageSourcePhase;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedError;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.network.INetworkDepend;
import com.bytedance.trae.im.service.ChatEventPayload;
import com.bytedance.trae.im.track.AgentMonitor;
import com.bytedance.trae.im.track.ChatFirstTokenTracker;
import com.bytedance.trae.im.track.ChatFrontResponseTracker;
import com.bytedance.trae.im.track.ChatTokenUsageTracker;
import com.bytedance.trae.network.HubNetConnection;
import com.bytedance.trae.network.HubNetMessageListener;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: IMService.kt */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001:\u001fyz{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020AJ\u000e\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020-J\u000e\u0010E\u001a\u00020A2\u0006\u0010D\u001a\u00020-J\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001d0G2\u0006\u0010H\u001a\u00020\u0005J\u0010\u0010I\u001a\u0004\u0018\u00010\u001d2\u0006\u0010J\u001a\u00020\u0005J\u000e\u0010K\u001a\u00020A2\u0006\u0010D\u001a\u00020/J\u000e\u0010L\u001a\u00020A2\u0006\u0010D\u001a\u00020/J\u000e\u0010M\u001a\u00020A2\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u00020A2\u0006\u0010D\u001a\u000201J\u000e\u0010Q\u001a\u00020A2\u0006\u0010D\u001a\u000201J\u000e\u0010R\u001a\u00020A2\u0006\u0010D\u001a\u000203J\u000e\u0010S\u001a\u00020A2\u0006\u0010D\u001a\u000203J\u000e\u0010T\u001a\u00020A2\u0006\u0010D\u001a\u000205J\u000e\u0010U\u001a\u00020A2\u0006\u0010D\u001a\u000205J\u000e\u0010V\u001a\u00020A2\u0006\u0010D\u001a\u000207J\u000e\u0010W\u001a\u00020A2\u0006\u0010D\u001a\u000207J\u000e\u0010X\u001a\u00020A2\u0006\u0010D\u001a\u000209J\u000e\u0010Y\u001a\u00020A2\u0006\u0010D\u001a\u000209J\u000e\u0010Z\u001a\u00020A2\u0006\u0010D\u001a\u00020;J\u000e\u0010[\u001a\u00020A2\u0006\u0010D\u001a\u00020;J\u000e\u0010\\\u001a\u00020A2\u0006\u0010D\u001a\u00020=J\u000e\u0010]\u001a\u00020A2\u0006\u0010D\u001a\u00020=J \u0010e\u001a\u00020A2\u0006\u0010J\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010\u00052\u0006\u0010f\u001a\u00020gJ\u000e\u0010h\u001a\u00020A2\u0006\u0010H\u001a\u00020\u0005J\u0016\u0010i\u001a\u00020A2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u0005J\u0018\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020n2\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0018\u0010o\u001a\u00020A2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005H\u0002J\u001e\u0010p\u001a\u00020A2\u0006\u0010q\u001a\u00020\"2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005J0\u0010r\u001a\u00020A2\u0006\u0010q\u001a\u00020\"2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u0006\u0010s\u001a\u00020\u001d2\b\b\u0002\u0010t\u001a\u00020\u0005J \u0010u\u001a\u00020A2\u0006\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u00052\u0006\u0010x\u001a\u00020lH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050$j\b\u0012\u0004\u0012\u00020\u0005`%X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u0002030,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002070,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002090,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020=0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010^\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00050\u0005 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00050\u0005\u0018\u00010_0'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`R4\u0010a\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00050\u0005 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00050\u0005\u0018\u00010_0'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`R\u001a\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020c0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008c\u0001"}, d2 = {"Lcom/bytedance/trae/im/service/IMService;", "", "<init>", "()V", "TAG", "", "AGENT_FLOW_TAG", "POLLING_PAGE_SIZE", "", "MAX_PENDING_EVENTS", "MAX_PENDING_TASK_IDS", "STREAM_ACTIVE_THRESHOLD_MS", "", "WS_PROTO_PUSH_EVENT", "WS_PROTO_PUSH_CONVERSATION_CREATE", "WS_PROTO_PUSH_CONVERSATION_UPDATE", "WS_PROTO_PUSH_CONVERSATION_DELETE", "WS_PROTO_CLI_STATUS_CHANGE", "WS_PROTO_CLI_UNBIND", "WS_PROTO_PUSH_MESSAGE_DELETE", "WS_PROTO_CLI_REGISTER", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "thoughtMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "firstSeqNum", "httpTaskSeqNum", "pendingEventsMap", "", "Lcom/bytedance/trae/im/service/ChatEvent;", "pendingTaskIdOrder", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "seqNumbers", "", "lastStreamTimestamp", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "streamingMessageListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;", "conversationChangeListeners", "Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;", "doneListeners", "Lcom/bytedance/trae/im/service/IMService$DoneListener;", "remoteUserMessageListeners", "Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;", "metadataDoneListeners", "Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;", "cliStatusChangeListeners", "Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;", "cliUnbindListeners", "Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;", "cliRegisterListeners", "Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;", "remoteDeleteMessagePushListeners", "Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;", "payloadReceiver", "Lcom/bytedance/trae/network/HubNetMessageListener;", "init", "", "release", "addStreamingMessageListener", "listener", "removeStreamingMessageListener", "getStreamingMessages", "", "conversationId", "getStreamingMessage", "taskId", "addConversationChangeListener", "removeConversationChangeListener", "notifyConversationChanged", Fields.EVENT, "Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;", "addDoneListener", "removeDoneListener", "addRemoteUserMessageListener", "removeRemoteUserMessageListener", "addMetadataDoneListener", "removeMetadataDoneListener", "addCliStatusChangeListener", "removeCliStatusChangeListener", "addCliUnbindListener", "removeCliUnbindListener", "addCliRegisterListener", "removeCliRegisterListener", "addRemoteDeleteMessagePushListener", "removeRemoteDeleteMessagePushListener", "fetchedConversationDone", "", "Ljava/util/Set;", "fetchingTaskIds", "pollingJobs", "Lkotlinx/coroutines/Job;", "pollingScope", "fetchEventsIfNeeded", "keva", "Lcom/bytedance/keva/Keva;", "addFetchedConversation", "cancelThoughtByMessageId", "messageId", "parseEvent", "", "item", "Lcom/bytedance/trae/im/service/EventItem;", "triggerFetchEvents", "applyChatEvent", "chatEvent", "realChatEvent", "message", TimonPipeline.KEY_SOURCE, "parsePayload", "proto", "data", "isConsecutiveSeq", "Event", "ConversationChangeEvent", "StreamingMessageListener", "ConversationChangeListener", "ConfirmEvent", "ConfirmListener", "DoneListener", "RemoteUserMessageListener", "MetadataDoneListener", "CliStatusChangePayload", "CliStatusChangeListener", "QueuingListener", "TimingMeta", "CliUnbindPayload", "CliRegisterPayload", "CliUnbindListener", "CliRegisterListener", "DeleteMessagePushPayload", "RemoteDeleteMessagePushListener", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IMService {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow";
    private static final int MAX_PENDING_EVENTS = 500;
    private static final int MAX_PENDING_TASK_IDS = 10;
    private static final int POLLING_PAGE_SIZE = 500;
    private static final long STREAM_ACTIVE_THRESHOLD_MS = 120000;
    private static final String TAG = "ImService";
    private static final int WS_PROTO_CLI_REGISTER = 33;
    private static final int WS_PROTO_CLI_STATUS_CHANGE = 30;
    private static final int WS_PROTO_CLI_UNBIND = 31;
    private static final int WS_PROTO_PUSH_CONVERSATION_CREATE = 4;
    private static final int WS_PROTO_PUSH_CONVERSATION_DELETE = 6;
    private static final int WS_PROTO_PUSH_CONVERSATION_UPDATE = 5;
    private static final int WS_PROTO_PUSH_EVENT = 3;
    private static final int WS_PROTO_PUSH_MESSAGE_DELETE = 32;
    public static final IMService INSTANCE = new IMService();
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(ChatEvent.class, new ChatEventDeserializer()).create();
    private static final ConcurrentHashMap<String, ParsedChatMessage> thoughtMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Integer> firstSeqNum = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Integer> httpTaskSeqNum = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, List<ChatEvent>> pendingEventsMap = new ConcurrentHashMap<>();
    private static final LinkedHashSet<String> pendingTaskIdOrder = new LinkedHashSet<>();
    private static final ConcurrentHashMap<String, Set<Integer>> seqNumbers = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> lastStreamTimestamp = new ConcurrentHashMap<>();
    private static final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().limitedParallelism(1).plus((CoroutineExceptionHandler) new IMService$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
    private static final CopyOnWriteArraySet<StreamingMessageListener> streamingMessageListeners = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<ConversationChangeListener> conversationChangeListeners = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<DoneListener> doneListeners = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<RemoteUserMessageListener> remoteUserMessageListeners = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<MetadataDoneListener> metadataDoneListeners = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<CliStatusChangeListener> cliStatusChangeListeners = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<CliUnbindListener> cliUnbindListeners = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<CliRegisterListener> cliRegisterListeners = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<RemoteDeleteMessagePushListener> remoteDeleteMessagePushListeners = new CopyOnWriteArraySet<>();
    private static final HubNetMessageListener payloadReceiver = new HubNetMessageListener() { // from class: com.bytedance.trae.im.service.IMService$$ExternalSyntheticLambda0
        public final void onMessage(int i, String str, boolean z) {
            IMService.payloadReceiver$lambda$1(i, str, z);
        }
    };
    private static final Set<String> fetchedConversationDone = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final Set<String> fetchingTaskIds = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final ConcurrentHashMap<String, Job> pollingJobs = new ConcurrentHashMap<>();
    private static final CoroutineScope pollingScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus((CoroutineExceptionHandler) new IMService$special$$inlined$CoroutineExceptionHandler$2(CoroutineExceptionHandler.Key)));

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;", "", "onCliRegister", "", "payload", "Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface CliRegisterListener {
        void onCliRegister(CliRegisterPayload payload);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;", "", "onCliStatusChanged", "", "payload", "Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface CliStatusChangeListener {
        void onCliStatusChanged(CliStatusChangePayload payload);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;", "", "onCliUnbound", "", "payload", "Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface CliUnbindListener {
        void onCliUnbound(CliUnbindPayload payload);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$ConfirmListener;", "", "onConfirmRequired", "", Fields.EVENT, "Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface ConfirmListener {
        void onConfirmRequired(ConfirmEvent event);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;", "", "onConversationChanged", "", Fields.EVENT, "Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface ConversationChangeListener {
        void onConversationChanged(ConversationChangeEvent event);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$DoneListener;", "", "onDone", "", "taskId", "", "conversationId", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface DoneListener {
        void onDone(String taskId, String conversationId);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$MetadataDoneListener;", "", "onMetadataDone", "", "conversationId", "", "replyToMessageId", "userMessageContext", "Lcom/bytedance/trae/im/service/UserMessageContext;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface MetadataDoneListener {
        void onMetadataDone(String conversationId, String replyToMessageId, UserMessageContext userMessageContext);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$QueuingListener;", "", "onQueuing", "", "taskId", "", "conversationId", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface QueuingListener {
        void onQueuing(String taskId, String conversationId);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$RemoteDeleteMessagePushListener;", "", "onMessagesDeletedRemotely", "", "payload", "Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface RemoteDeleteMessagePushListener {
        void onMessagesDeletedRemotely(DeleteMessagePushPayload payload);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001JC\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$RemoteUserMessageListener;", "", "onRemoteUserMessage", "", "conversationId", "", "messageId", ReportConstant.COMMON_CONTENT, "Lcom/google/gson/JsonElement;", "messageIndex", "", "createdAt", "", "isAppendMessage", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/lang/Integer;Ljava/lang/Long;Z)V", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface RemoteUserMessageListener {
        void onRemoteUserMessage(String conversationId, String messageId, JsonElement content, Integer messageIndex, Long createdAt, boolean isAppendMessage);
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$StreamingMessageListener;", "", "onStreamingMessage", "", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "isDone", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface StreamingMessageListener {
        void onStreamingMessage(ParsedChatMessage message, boolean isDone);
    }

    private IMService() {
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$Event;", "", "taskId", "", "conversationId", OnekeyLoginConstants.CU_KEY_SEQ, "", DBData.FIELD_TYPE, "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getConversationId", "getSeq", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "getData", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/service/IMService$Event;", "equals", "", "other", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Event {

        @SerializedName("conversation_id")
        private final String conversationId;

        @SerializedName("data")
        private final String data;

        @SerializedName(OnekeyLoginConstants.CU_KEY_SEQ)
        private final Integer seq;

        @SerializedName(NewTaskTracker.Param.TASK_ID)
        private final String taskId;

        @SerializedName(DBData.FIELD_TYPE)
        private final String type;

        public Event() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ Event copy$default(Event event, String str, String str2, Integer num, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = event.taskId;
            }
            if ((i & 2) != 0) {
                str2 = event.conversationId;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                num = event.seq;
            }
            Integer num2 = num;
            if ((i & 8) != 0) {
                str3 = event.type;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                str4 = event.data;
            }
            return event.copy(str, str5, num2, str6, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getSeq() {
            return this.seq;
        }

        /* renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* renamed from: component5, reason: from getter */
        public final String getData() {
            return this.data;
        }

        public final Event copy(String taskId, String conversationId, Integer seq, String type, String data) {
            return new Event(taskId, conversationId, seq, type, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            return Intrinsics.areEqual(this.taskId, event.taskId) && Intrinsics.areEqual(this.conversationId, event.conversationId) && Intrinsics.areEqual(this.seq, event.seq) && Intrinsics.areEqual(this.type, event.type) && Intrinsics.areEqual(this.data, event.data);
        }

        public int hashCode() {
            String str = this.taskId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.conversationId;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.seq;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            String str3 = this.type;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.data;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Event(taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", seq=" + this.seq + ", type=" + this.type + ", data=" + this.data + ')';
        }

        public Event(String str, String str2, Integer num, String str3, String str4) {
            this.taskId = str;
            this.conversationId = str2;
            this.seq = num;
            this.type = str3;
            this.data = str4;
        }

        public /* synthetic */ Event(String str, String str2, Integer num, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Integer getSeq() {
            return this.seq;
        }

        public final String getType() {
            return this.type;
        }

        public final String getData() {
            return this.data;
        }
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;", "", "changeType", "", "conversationId", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/Conversation;)V", "getChangeType", "()Ljava/lang/String;", "getConversationId", "getConversation", "()Lcom/bytedance/trae/im/service/Conversation;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ConversationChangeEvent {
        private final String changeType;
        private final Conversation conversation;
        private final String conversationId;

        public ConversationChangeEvent() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ ConversationChangeEvent copy$default(ConversationChangeEvent conversationChangeEvent, String str, String str2, Conversation conversation, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conversationChangeEvent.changeType;
            }
            if ((i & 2) != 0) {
                str2 = conversationChangeEvent.conversationId;
            }
            if ((i & 4) != 0) {
                conversation = conversationChangeEvent.conversation;
            }
            return conversationChangeEvent.copy(str, str2, conversation);
        }

        /* renamed from: component1, reason: from getter */
        public final String getChangeType() {
            return this.changeType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        /* renamed from: component3, reason: from getter */
        public final Conversation getConversation() {
            return this.conversation;
        }

        public final ConversationChangeEvent copy(String changeType, String conversationId, Conversation conversation) {
            return new ConversationChangeEvent(changeType, conversationId, conversation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConversationChangeEvent)) {
                return false;
            }
            ConversationChangeEvent conversationChangeEvent = (ConversationChangeEvent) other;
            return Intrinsics.areEqual(this.changeType, conversationChangeEvent.changeType) && Intrinsics.areEqual(this.conversationId, conversationChangeEvent.conversationId) && Intrinsics.areEqual(this.conversation, conversationChangeEvent.conversation);
        }

        public int hashCode() {
            String str = this.changeType;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.conversationId;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Conversation conversation = this.conversation;
            return hashCode2 + (conversation != null ? conversation.hashCode() : 0);
        }

        public String toString() {
            return "ConversationChangeEvent(changeType=" + this.changeType + ", conversationId=" + this.conversationId + ", conversation=" + this.conversation + ')';
        }

        public ConversationChangeEvent(String str, String str2, Conversation conversation) {
            this.changeType = str;
            this.conversationId = str2;
            this.conversation = conversation;
        }

        public /* synthetic */ ConversationChangeEvent(String str, String str2, Conversation conversation, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : conversation);
        }

        public final String getChangeType() {
            return this.changeType;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Conversation getConversation() {
            return this.conversation;
        }
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$ConfirmEvent;", "", "planItem", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "taskId", "", "conversationId", "<init>", "(Lcom/bytedance/trae/im/model/ParsedPlanItem;Ljava/lang/String;Ljava/lang/String;)V", "getPlanItem", "()Lcom/bytedance/trae/im/model/ParsedPlanItem;", "getTaskId", "()Ljava/lang/String;", "getConversationId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ConfirmEvent {
        private final String conversationId;
        private final ParsedPlanItem planItem;
        private final String taskId;

        public static /* synthetic */ ConfirmEvent copy$default(ConfirmEvent confirmEvent, ParsedPlanItem parsedPlanItem, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                parsedPlanItem = confirmEvent.planItem;
            }
            if ((i & 2) != 0) {
                str = confirmEvent.taskId;
            }
            if ((i & 4) != 0) {
                str2 = confirmEvent.conversationId;
            }
            return confirmEvent.copy(parsedPlanItem, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final ParsedPlanItem getPlanItem() {
            return this.planItem;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final ConfirmEvent copy(ParsedPlanItem planItem, String taskId, String conversationId) {
            Intrinsics.checkNotNullParameter(planItem, "planItem");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            return new ConfirmEvent(planItem, taskId, conversationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfirmEvent)) {
                return false;
            }
            ConfirmEvent confirmEvent = (ConfirmEvent) other;
            return Intrinsics.areEqual(this.planItem, confirmEvent.planItem) && Intrinsics.areEqual(this.taskId, confirmEvent.taskId) && Intrinsics.areEqual(this.conversationId, confirmEvent.conversationId);
        }

        public int hashCode() {
            int hashCode = ((this.planItem.hashCode() * 31) + this.taskId.hashCode()) * 31;
            String str = this.conversationId;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ConfirmEvent(planItem=" + this.planItem + ", taskId=" + this.taskId + ", conversationId=" + this.conversationId + ')';
        }

        public ConfirmEvent(ParsedPlanItem parsedPlanItem, String str, String str2) {
            Intrinsics.checkNotNullParameter(parsedPlanItem, "planItem");
            Intrinsics.checkNotNullParameter(str, "taskId");
            this.planItem = parsedPlanItem;
            this.taskId = str;
            this.conversationId = str2;
        }

        public final ParsedPlanItem getPlanItem() {
            return this.planItem;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final String getConversationId() {
            return this.conversationId;
        }
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;", "", "cliId", "", "available", "", ReportConstant.COMMON_TIMESTAMP, "", "<init>", "(Ljava/lang/String;ZJ)V", "getCliId", "()Ljava/lang/String;", "getAvailable", "()Z", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CliStatusChangePayload {

        @SerializedName("available")
        private final boolean available;

        @SerializedName("cli_id")
        private final String cliId;

        @SerializedName(ReportConstant.COMMON_TIMESTAMP)
        private final long timestamp;

        public static /* synthetic */ CliStatusChangePayload copy$default(CliStatusChangePayload cliStatusChangePayload, String str, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cliStatusChangePayload.cliId;
            }
            if ((i & 2) != 0) {
                z = cliStatusChangePayload.available;
            }
            if ((i & 4) != 0) {
                j = cliStatusChangePayload.timestamp;
            }
            return cliStatusChangePayload.copy(str, z, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCliId() {
            return this.cliId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAvailable() {
            return this.available;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final CliStatusChangePayload copy(String cliId, boolean available, long timestamp) {
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            return new CliStatusChangePayload(cliId, available, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CliStatusChangePayload)) {
                return false;
            }
            CliStatusChangePayload cliStatusChangePayload = (CliStatusChangePayload) other;
            return Intrinsics.areEqual(this.cliId, cliStatusChangePayload.cliId) && this.available == cliStatusChangePayload.available && this.timestamp == cliStatusChangePayload.timestamp;
        }

        public int hashCode() {
            return (((this.cliId.hashCode() * 31) + Boolean.hashCode(this.available)) * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "CliStatusChangePayload(cliId=" + this.cliId + ", available=" + this.available + ", timestamp=" + this.timestamp + ')';
        }

        public CliStatusChangePayload(String str, boolean z, long j) {
            Intrinsics.checkNotNullParameter(str, "cliId");
            this.cliId = str;
            this.available = z;
            this.timestamp = j;
        }

        public /* synthetic */ CliStatusChangePayload(String str, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z, (i & 4) != 0 ? 0L : j);
        }

        public final String getCliId() {
            return this.cliId;
        }

        public final boolean getAvailable() {
            return this.available;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\t\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$TimingMeta;", "", "modelName", "", AccountMonitorConstants.CommonParameter.LOGID, "modelAccountName", "modelAccountType", "modelProviderName", "serverTimingInfo", "isServerRetried", "", "enableDbOpt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getModelName", "()Ljava/lang/String;", "getLogid", "getModelAccountName", "getModelAccountType", "getModelProviderName", "getServerTimingInfo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableDbOpt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/IMService$TimingMeta;", "equals", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TimingMeta {
        private final Boolean enableDbOpt;
        private final Boolean isServerRetried;
        private final String logid;
        private final String modelAccountName;
        private final String modelAccountType;
        private final String modelName;
        private final String modelProviderName;
        private final String serverTimingInfo;

        /* renamed from: component1, reason: from getter */
        public final String getModelName() {
            return this.modelName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLogid() {
            return this.logid;
        }

        /* renamed from: component3, reason: from getter */
        public final String getModelAccountName() {
            return this.modelAccountName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getModelAccountType() {
            return this.modelAccountType;
        }

        /* renamed from: component5, reason: from getter */
        public final String getModelProviderName() {
            return this.modelProviderName;
        }

        /* renamed from: component6, reason: from getter */
        public final String getServerTimingInfo() {
            return this.serverTimingInfo;
        }

        /* renamed from: component7, reason: from getter */
        public final Boolean getIsServerRetried() {
            return this.isServerRetried;
        }

        /* renamed from: component8, reason: from getter */
        public final Boolean getEnableDbOpt() {
            return this.enableDbOpt;
        }

        public final TimingMeta copy(String modelName, String logid, String modelAccountName, String modelAccountType, String modelProviderName, String serverTimingInfo, Boolean isServerRetried, Boolean enableDbOpt) {
            return new TimingMeta(modelName, logid, modelAccountName, modelAccountType, modelProviderName, serverTimingInfo, isServerRetried, enableDbOpt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TimingMeta)) {
                return false;
            }
            TimingMeta timingMeta = (TimingMeta) other;
            return Intrinsics.areEqual(this.modelName, timingMeta.modelName) && Intrinsics.areEqual(this.logid, timingMeta.logid) && Intrinsics.areEqual(this.modelAccountName, timingMeta.modelAccountName) && Intrinsics.areEqual(this.modelAccountType, timingMeta.modelAccountType) && Intrinsics.areEqual(this.modelProviderName, timingMeta.modelProviderName) && Intrinsics.areEqual(this.serverTimingInfo, timingMeta.serverTimingInfo) && Intrinsics.areEqual(this.isServerRetried, timingMeta.isServerRetried) && Intrinsics.areEqual(this.enableDbOpt, timingMeta.enableDbOpt);
        }

        public int hashCode() {
            String str = this.modelName;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.logid;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.modelAccountName;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.modelAccountType;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.modelProviderName;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.serverTimingInfo;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Boolean bool = this.isServerRetried;
            int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.enableDbOpt;
            return hashCode7 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "TimingMeta(modelName=" + this.modelName + ", logid=" + this.logid + ", modelAccountName=" + this.modelAccountName + ", modelAccountType=" + this.modelAccountType + ", modelProviderName=" + this.modelProviderName + ", serverTimingInfo=" + this.serverTimingInfo + ", isServerRetried=" + this.isServerRetried + ", enableDbOpt=" + this.enableDbOpt + ')';
        }

        public TimingMeta(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2) {
            this.modelName = str;
            this.logid = str2;
            this.modelAccountName = str3;
            this.modelAccountType = str4;
            this.modelProviderName = str5;
            this.serverTimingInfo = str6;
            this.isServerRetried = bool;
            this.enableDbOpt = bool2;
        }

        public final String getModelName() {
            return this.modelName;
        }

        public final String getLogid() {
            return this.logid;
        }

        public final String getModelAccountName() {
            return this.modelAccountName;
        }

        public final String getModelAccountType() {
            return this.modelAccountType;
        }

        public final String getModelProviderName() {
            return this.modelProviderName;
        }

        public final String getServerTimingInfo() {
            return this.serverTimingInfo;
        }

        public final Boolean isServerRetried() {
            return this.isServerRetried;
        }

        public final Boolean getEnableDbOpt() {
            return this.enableDbOpt;
        }
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;", "", "cliId", "", ReportConstant.COMMON_TIMESTAMP, "", "<init>", "(Ljava/lang/String;J)V", "getCliId", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CliUnbindPayload {

        @SerializedName("cli_id")
        private final String cliId;

        @SerializedName(ReportConstant.COMMON_TIMESTAMP)
        private final long timestamp;

        public static /* synthetic */ CliUnbindPayload copy$default(CliUnbindPayload cliUnbindPayload, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cliUnbindPayload.cliId;
            }
            if ((i & 2) != 0) {
                j = cliUnbindPayload.timestamp;
            }
            return cliUnbindPayload.copy(str, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCliId() {
            return this.cliId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final CliUnbindPayload copy(String cliId, long timestamp) {
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            return new CliUnbindPayload(cliId, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CliUnbindPayload)) {
                return false;
            }
            CliUnbindPayload cliUnbindPayload = (CliUnbindPayload) other;
            return Intrinsics.areEqual(this.cliId, cliUnbindPayload.cliId) && this.timestamp == cliUnbindPayload.timestamp;
        }

        public int hashCode() {
            return (this.cliId.hashCode() * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "CliUnbindPayload(cliId=" + this.cliId + ", timestamp=" + this.timestamp + ')';
        }

        public CliUnbindPayload(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "cliId");
            this.cliId = str;
            this.timestamp = j;
        }

        public /* synthetic */ CliUnbindPayload(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? 0L : j);
        }

        public final String getCliId() {
            return this.cliId;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload;", "", "cliId", "", "cliType", ReportConstant.COMMON_TIMESTAMP, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getCliId", "()Ljava/lang/String;", "getCliType", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CliRegisterPayload {

        @SerializedName("cli_id")
        private final String cliId;

        @SerializedName("cli_type")
        private final String cliType;

        @SerializedName(ReportConstant.COMMON_TIMESTAMP)
        private final long timestamp;

        public static /* synthetic */ CliRegisterPayload copy$default(CliRegisterPayload cliRegisterPayload, String str, String str2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cliRegisterPayload.cliId;
            }
            if ((i & 2) != 0) {
                str2 = cliRegisterPayload.cliType;
            }
            if ((i & 4) != 0) {
                j = cliRegisterPayload.timestamp;
            }
            return cliRegisterPayload.copy(str, str2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCliId() {
            return this.cliId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCliType() {
            return this.cliType;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final CliRegisterPayload copy(String cliId, String cliType, long timestamp) {
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            return new CliRegisterPayload(cliId, cliType, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CliRegisterPayload)) {
                return false;
            }
            CliRegisterPayload cliRegisterPayload = (CliRegisterPayload) other;
            return Intrinsics.areEqual(this.cliId, cliRegisterPayload.cliId) && Intrinsics.areEqual(this.cliType, cliRegisterPayload.cliType) && this.timestamp == cliRegisterPayload.timestamp;
        }

        public int hashCode() {
            return (((this.cliId.hashCode() * 31) + this.cliType.hashCode()) * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "CliRegisterPayload(cliId=" + this.cliId + ", cliType=" + this.cliType + ", timestamp=" + this.timestamp + ')';
        }

        public CliRegisterPayload(String str, String str2, long j) {
            Intrinsics.checkNotNullParameter(str, "cliId");
            Intrinsics.checkNotNullParameter(str2, "cliType");
            this.cliId = str;
            this.cliType = str2;
            this.timestamp = j;
        }

        public /* synthetic */ CliRegisterPayload(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? 0L : j);
        }

        public final String getCliId() {
            return this.cliId;
        }

        public final String getCliType() {
            return this.cliType;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/im/service/IMService$DeleteMessagePushPayload;", "", "conversationId", "", "messageIds", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getConversationId", "()Ljava/lang/String;", "getMessageIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class DeleteMessagePushPayload {

        @SerializedName("conversation_id")
        private final String conversationId;

        @SerializedName("message_ids")
        private final List<String> messageIds;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeleteMessagePushPayload copy$default(DeleteMessagePushPayload deleteMessagePushPayload, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deleteMessagePushPayload.conversationId;
            }
            if ((i & 2) != 0) {
                list = deleteMessagePushPayload.messageIds;
            }
            return deleteMessagePushPayload.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final List<String> component2() {
            return this.messageIds;
        }

        public final DeleteMessagePushPayload copy(String conversationId, List<String> messageIds) {
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            Intrinsics.checkNotNullParameter(messageIds, "messageIds");
            return new DeleteMessagePushPayload(conversationId, messageIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeleteMessagePushPayload)) {
                return false;
            }
            DeleteMessagePushPayload deleteMessagePushPayload = (DeleteMessagePushPayload) other;
            return Intrinsics.areEqual(this.conversationId, deleteMessagePushPayload.conversationId) && Intrinsics.areEqual(this.messageIds, deleteMessagePushPayload.messageIds);
        }

        public int hashCode() {
            return (this.conversationId.hashCode() * 31) + this.messageIds.hashCode();
        }

        public String toString() {
            return "DeleteMessagePushPayload(conversationId=" + this.conversationId + ", messageIds=" + this.messageIds + ')';
        }

        public DeleteMessagePushPayload(String str, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "conversationId");
            Intrinsics.checkNotNullParameter(list, "messageIds");
            this.conversationId = str;
            this.messageIds = list;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final List<String> getMessageIds() {
            return this.messageIds;
        }
    }

    public final Gson getGson() {
        return gson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void payloadReceiver$lambda$1(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "data");
        BuildersKt.launch$default(ioScope, (CoroutineContext) null, (CoroutineStart) null, new IMService$payloadReceiver$1$1(i, str, z, null), 3, (Object) null);
    }

    public final void init() {
        HubNetConnection hubNet = INetworkDepend.INSTANCE.getInstance().getHubNet();
        if (hubNet != null) {
            hubNet.registerMessageListener(payloadReceiver);
        }
    }

    public final void release() {
        HubNetConnection hubNet = INetworkDepend.INSTANCE.getInstance().getHubNet();
        if (hubNet != null) {
            hubNet.unregisterMessageListener(payloadReceiver);
        }
    }

    public final void addStreamingMessageListener(StreamingMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        streamingMessageListeners.add(listener);
        for (ParsedChatMessage parsedChatMessage : thoughtMap.values()) {
            Intrinsics.checkNotNullExpressionValue(parsedChatMessage, "next(...)");
            listener.onStreamingMessage(parsedChatMessage, false);
        }
    }

    public final void removeStreamingMessageListener(StreamingMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        streamingMessageListeners.remove(listener);
    }

    public final List<ParsedChatMessage> getStreamingMessages(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Collection<ParsedChatMessage> values = thoughtMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (Intrinsics.areEqual(((ParsedChatMessage) obj).getSessionId(), conversationId)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final ParsedChatMessage getStreamingMessage(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return thoughtMap.get(taskId);
    }

    public final void addConversationChangeListener(ConversationChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        conversationChangeListeners.add(listener);
    }

    public final void removeConversationChangeListener(ConversationChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        conversationChangeListeners.remove(listener);
    }

    public final void notifyConversationChanged(ConversationChangeEvent event) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        Iterator<T> it = conversationChangeListeners.iterator();
        while (it.hasNext()) {
            ((ConversationChangeListener) it.next()).onConversationChanged(event);
        }
    }

    public final void addDoneListener(DoneListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        doneListeners.add(listener);
    }

    public final void removeDoneListener(DoneListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        doneListeners.remove(listener);
    }

    public final void addRemoteUserMessageListener(RemoteUserMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        remoteUserMessageListeners.add(listener);
    }

    public final void removeRemoteUserMessageListener(RemoteUserMessageListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        remoteUserMessageListeners.remove(listener);
    }

    public final void addMetadataDoneListener(MetadataDoneListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        metadataDoneListeners.add(listener);
    }

    public final void removeMetadataDoneListener(MetadataDoneListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        metadataDoneListeners.remove(listener);
    }

    public final void addCliStatusChangeListener(CliStatusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        cliStatusChangeListeners.add(listener);
    }

    public final void removeCliStatusChangeListener(CliStatusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        cliStatusChangeListeners.remove(listener);
    }

    public final void addCliUnbindListener(CliUnbindListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        cliUnbindListeners.add(listener);
    }

    public final void removeCliUnbindListener(CliUnbindListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        cliUnbindListeners.remove(listener);
    }

    public final void addCliRegisterListener(CliRegisterListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        cliRegisterListeners.add(listener);
    }

    public final void removeCliRegisterListener(CliRegisterListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        cliRegisterListeners.remove(listener);
    }

    public final void addRemoteDeleteMessagePushListener(RemoteDeleteMessagePushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        remoteDeleteMessagePushListeners.add(listener);
    }

    public final void removeRemoteDeleteMessagePushListener(RemoteDeleteMessagePushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        remoteDeleteMessagePushListeners.remove(listener);
    }

    public final void fetchEventsIfNeeded(String taskId, String conversationId, Keva keva) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(keva, "keva");
        if (conversationId == null) {
            return;
        }
        ParsedChatMessage parsedChatMessage = thoughtMap.get(taskId);
        if (parsedChatMessage != null) {
            if ((parsedChatMessage.getMessageId().length() > 0) && parsedChatMessage.isHistory()) {
                return;
            }
        }
        Long l = lastStreamTimestamp.get(taskId);
        if (System.currentTimeMillis() - (l != null ? l.longValue() : 0L) < STREAM_ACTIVE_THRESHOLD_MS) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] fetchEventsIfNeeded: skip, socket stream active within 120000ms, taskId=" + taskId);
        } else {
            triggerFetchEvents(taskId, conversationId);
        }
    }

    public final void addFetchedConversation(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        fetchedConversationDone.add(conversationId);
    }

    public final void cancelThoughtByMessageId(String conversationId, String messageId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        try {
            Set<Map.Entry<String, ParsedChatMessage>> entrySet = thoughtMap.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : entrySet) {
                Map.Entry entry = (Map.Entry) obj;
                Intrinsics.checkNotNull(entry);
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "component2(...)");
                ParsedChatMessage parsedChatMessage = (ParsedChatMessage) value;
                if (Intrinsics.areEqual(parsedChatMessage.getSessionId(), conversationId) && Intrinsics.areEqual(parsedChatMessage.getMessageId(), messageId)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList<String> arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add((String) ((Map.Entry) it.next()).getKey());
            }
            for (String str : arrayList3) {
                thoughtMap.remove(str);
                seqNumbers.remove(str);
                pendingEventsMap.remove(str);
                LinkedHashSet<String> linkedHashSet = pendingTaskIdOrder;
                synchronized (linkedHashSet) {
                    linkedHashSet.remove(str);
                }
                firstSeqNum.remove(str);
                ChatFirstTokenTracker chatFirstTokenTracker = ChatFirstTokenTracker.INSTANCE;
                Intrinsics.checkNotNull(str);
                chatFirstTokenTracker.clear(str);
                ChatTokenUsageTracker.INSTANCE.clear(str);
                ChatFrontResponseTracker.INSTANCE.clear(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean parseEvent(EventItem item, String conversationId) {
        String taskId = item.getTaskId();
        if (taskId == null) {
            return true;
        }
        String type = item.getType();
        ChatEventPayload.UserMessage userMessage = null;
        if (type != null) {
            switch (type.hashCode()) {
                case -1814390893:
                    if (type.equals("user_message")) {
                        ChatEventPayload.UserMessage userMessage2 = (ChatEventPayload.UserMessage) gson.fromJson(item.getData(), ChatEventPayload.UserMessage.class);
                        if (userMessage2 == null) {
                            userMessage2 = new ChatEventPayload.UserMessage(null, null, null, null, null, null, null, null, null, null, 1023, null);
                        }
                        userMessage = userMessage2;
                        break;
                    }
                    break;
                case -450004177:
                    if (type.equals("metadata")) {
                        ChatEventPayload.Metadata metadata = (ChatEventPayload.Metadata) gson.fromJson(item.getData(), ChatEventPayload.Metadata.class);
                        if (metadata == null) {
                            metadata = new ChatEventPayload.Metadata(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 1, null);
                        }
                        userMessage = metadata;
                        break;
                    }
                    break;
                case 3089282:
                    if (type.equals("done")) {
                        ChatEventPayload.Done done = (ChatEventPayload.Done) gson.fromJson(item.getData(), ChatEventPayload.Done.class);
                        if (done == null) {
                            done = new ChatEventPayload.Done(null, null, null, null, 15, null);
                        }
                        userMessage = done;
                        break;
                    }
                    break;
                case 96784904:
                    if (type.equals("error")) {
                        ChatEventPayload.Error error = (ChatEventPayload.Error) gson.fromJson(item.getData(), ChatEventPayload.Error.class);
                        if (error == null) {
                            error = new ChatEventPayload.Error(null, null, null, null, 15, null);
                        }
                        userMessage = error;
                        break;
                    }
                    break;
                case 343279415:
                    if (type.equals("session_title_message")) {
                        ChatEventPayload.SessionTitle sessionTitle = (ChatEventPayload.SessionTitle) gson.fromJson(item.getData(), ChatEventPayload.SessionTitle.class);
                        if (sessionTitle == null) {
                            sessionTitle = new ChatEventPayload.SessionTitle(null, null, 3, null);
                        }
                        userMessage = sessionTitle;
                        break;
                    }
                    break;
                case 595233003:
                    if (type.equals("notification")) {
                        ChatEventPayload.Notification notification = (ChatEventPayload.Notification) gson.fromJson(item.getData(), ChatEventPayload.Notification.class);
                        if (notification == null) {
                            notification = new ChatEventPayload.Notification(null, null, null, null, null, null, null, null, null, 511, null);
                        }
                        userMessage = notification;
                        break;
                    }
                    break;
                case 655177102:
                    if (type.equals("queuing")) {
                        ChatEventPayload.Queuing queuing = (ChatEventPayload.Queuing) gson.fromJson(item.getData(), ChatEventPayload.Queuing.class);
                        if (queuing == null) {
                            queuing = new ChatEventPayload.Queuing(null, null, null, null, null, null, null, 127, null);
                        }
                        userMessage = queuing;
                        break;
                    }
                    break;
                case 1515617574:
                    if (type.equals("fast_request_savings")) {
                        ChatEventPayload.FastRequestSavings fastRequestSavings = (ChatEventPayload.FastRequestSavings) gson.fromJson(item.getData(), ChatEventPayload.FastRequestSavings.class);
                        if (fastRequestSavings == null) {
                            fastRequestSavings = new ChatEventPayload.FastRequestSavings(null, null, null, 7, null);
                        }
                        userMessage = fastRequestSavings;
                        break;
                    }
                    break;
                case 2102213225:
                    if (type.equals("plan_item")) {
                        ChatEventPayload.PlanItem planItem = (ChatEventPayload.PlanItem) gson.fromJson(item.getData(), ChatEventPayload.PlanItem.class);
                        if (planItem == null) {
                            planItem = new ChatEventPayload.PlanItem(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
                        }
                        userMessage = planItem;
                        break;
                    }
                    break;
            }
        }
        ChatEventPayload chatEventPayload = userMessage;
        if (chatEventPayload == null) {
            return false;
        }
        String type2 = item.getType();
        Integer seq = item.getSeq();
        ChatEvent chatEvent = new ChatEvent(type2, seq != null ? seq.intValue() : 0, chatEventPayload, item.getNewToolCall(), item.getCleanThought(), item.getThoughtFirstData(), item.getToolcallFirstData());
        ConcurrentHashMap<String, ParsedChatMessage> concurrentHashMap = thoughtMap;
        ParsedChatMessage parsedChatMessage = concurrentHashMap.get(taskId);
        if (parsedChatMessage == null) {
            parsedChatMessage = new ParsedChatMessage(conversationId, "", null, null, null, "task", ParsedChatMessage.ROLE_ASSISTANT, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ParsedTaskContent(taskId, null, null, 6, null), null, null, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, -100, 8388319, null);
            parsedChatMessage.setSourcePhase(MessageSourcePhase.STREAMING);
            ParsedChatMessage putIfAbsent = concurrentHashMap.putIfAbsent(taskId, parsedChatMessage);
            if (putIfAbsent != null) {
                parsedChatMessage = putIfAbsent;
            }
        }
        ParsedChatMessage parsedChatMessage2 = parsedChatMessage;
        Intrinsics.checkNotNull(parsedChatMessage2);
        realChatEvent(chatEvent, taskId, conversationId, parsedChatMessage2, "http");
        return Intrinsics.areEqual(item.getType(), "done") || Intrinsics.areEqual(item.getType(), "error");
    }

    private final void triggerFetchEvents(String taskId, String conversationId) {
        if (fetchingTaskIds.add(taskId)) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] triggerFetchEvents: stream not continuous, taskId=" + taskId + ", convId=" + conversationId);
            ConcurrentHashMap<String, Job> concurrentHashMap = pollingJobs;
            Job job = concurrentHashMap.get(taskId);
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            concurrentHashMap.put(taskId, BuildersKt.launch$default(pollingScope, (CoroutineContext) null, (CoroutineStart) null, new IMService$triggerFetchEvents$1(taskId, conversationId, null), 3, (Object) null));
        }
    }

    public final void applyChatEvent(ChatEvent chatEvent, String taskId, String conversationId) {
        Set<Integer> putIfAbsent;
        String str;
        Set<Integer> putIfAbsent2;
        Intrinsics.checkNotNullParameter(chatEvent, "chatEvent");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        int seq = chatEvent.getSeq();
        ConcurrentHashMap<String, Integer> concurrentHashMap = firstSeqNum;
        if (!concurrentHashMap.containsKey(taskId) && seq != 1 && !fetchedConversationDone.contains(conversationId)) {
            if (seq > 0) {
                ConcurrentHashMap<String, Set<Integer>> concurrentHashMap2 = seqNumbers;
                ConcurrentHashMap.KeySetView keySetView = concurrentHashMap2.get(taskId);
                if (keySetView == null && (putIfAbsent2 = concurrentHashMap2.putIfAbsent(taskId, (keySetView = ConcurrentHashMap.newKeySet()))) != null) {
                    keySetView = putIfAbsent2;
                }
                if (!keySetView.add(Integer.valueOf(seq))) {
                    TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] SKIP duplicate seq=" + seq + ", type=" + chatEvent.getType() + ", taskId=" + taskId);
                    return;
                }
            }
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] repair seq=" + seq + ", type=" + chatEvent.getType() + ", taskId=" + taskId + " chat=" + gson.toJson(chatEvent));
            ConcurrentHashMap<String, List<ChatEvent>> concurrentHashMap3 = pendingEventsMap;
            ConcurrentHashMap<String, List<ChatEvent>> concurrentHashMap4 = concurrentHashMap3;
            List<ChatEvent> list = concurrentHashMap4.get(taskId);
            if (list == null) {
                LinkedHashSet<String> linkedHashSet = pendingTaskIdOrder;
                synchronized (linkedHashSet) {
                    if (linkedHashSet.size() >= 10 && (str = (String) CollectionsKt.firstOrNull(linkedHashSet)) != null) {
                        linkedHashSet.remove(str);
                        concurrentHashMap3.remove(str);
                        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] pendingEventsMap evict oldest taskId=" + str + ", current size=" + concurrentHashMap3.size());
                    }
                    linkedHashSet.add(taskId);
                }
                List<ChatEvent> synchronizedList = Collections.synchronizedList(new ArrayList());
                List<ChatEvent> putIfAbsent3 = concurrentHashMap4.putIfAbsent(taskId, synchronizedList);
                list = putIfAbsent3 == null ? synchronizedList : putIfAbsent3;
            }
            List<ChatEvent> list2 = list;
            if (list2.size() >= 500) {
                list2.remove(0);
            }
            list2.add(chatEvent);
            triggerFetchEvents(taskId, conversationId);
            return;
        }
        concurrentHashMap.put(taskId, 1);
        lastStreamTimestamp.put(taskId, Long.valueOf(System.currentTimeMillis()));
        if (seq > 0) {
            Integer num = httpTaskSeqNum.get(taskId);
            int intValue = num != null ? num.intValue() : -1;
            if (seq <= intValue) {
                TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] SKIP seq=" + seq + " <= httpMaxSeq=" + intValue + ", type=" + chatEvent.getType() + ", taskId=" + taskId);
                return;
            }
            ConcurrentHashMap<String, Set<Integer>> concurrentHashMap5 = seqNumbers;
            ConcurrentHashMap.KeySetView keySetView2 = concurrentHashMap5.get(taskId);
            if (keySetView2 == null && (putIfAbsent = concurrentHashMap5.putIfAbsent(taskId, (keySetView2 = ConcurrentHashMap.newKeySet()))) != null) {
                keySetView2 = putIfAbsent;
            }
            if (!keySetView2.add(Integer.valueOf(seq))) {
                TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] SKIP duplicate seq=" + seq + ", type=" + chatEvent.getType() + ", taskId=" + taskId);
                return;
            }
        }
        ConcurrentHashMap<String, ParsedChatMessage> concurrentHashMap6 = thoughtMap;
        ParsedChatMessage parsedChatMessage = concurrentHashMap6.get(taskId);
        if (parsedChatMessage == null) {
            parsedChatMessage = new ParsedChatMessage(conversationId, "", null, null, null, "task", ParsedChatMessage.ROLE_ASSISTANT, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ParsedTaskContent(taskId, null, null, 6, null), null, null, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, -100, 8388319, null);
            parsedChatMessage.setSourcePhase(MessageSourcePhase.STREAMING);
            ParsedChatMessage putIfAbsent4 = concurrentHashMap6.putIfAbsent(taskId, parsedChatMessage);
            if (putIfAbsent4 != null) {
                parsedChatMessage = putIfAbsent4;
            }
        }
        ParsedChatMessage parsedChatMessage2 = parsedChatMessage;
        Intrinsics.checkNotNull(parsedChatMessage2);
        realChatEvent(chatEvent, taskId, conversationId, parsedChatMessage2, "socket");
    }

    public static /* synthetic */ void realChatEvent$default(IMService iMService, ChatEvent chatEvent, String str, String str2, ParsedChatMessage parsedChatMessage, String str3, int i, Object obj) {
        if ((i & 16) != 0) {
            str3 = "unknown";
        }
        iMService.realChatEvent(chatEvent, str, str2, parsedChatMessage, str3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0626, code lost:
    
        if (r3.equals(r12) == false) goto L322;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0302 A[LOOP:5: B:157:0x02fc->B:159:0x0302, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void realChatEvent(ChatEvent chatEvent, String taskId, String conversationId, ParsedChatMessage message, String source) {
        String str;
        Object obj;
        String str2;
        String str3;
        Object obj2;
        ArrayList arrayList;
        String status;
        ChatFrontResponseTracker.StopType stopType;
        List<ParsedPlanItemMessage> messages;
        List<ParsedPlanItemMessage> messages2;
        int i;
        String str4;
        Iterator<T> it;
        Integer queuePosition;
        int i2;
        List<ParsedPlanItemMessage> messages3;
        Intrinsics.checkNotNullParameter(chatEvent, "chatEvent");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        int seq = chatEvent.getSeq();
        String type = chatEvent.getType();
        if (type != null) {
            switch (type.hashCode()) {
                case -1814390893:
                    if (type.equals("user_message")) {
                        ChatEventPayload data = chatEvent.getData();
                        ChatEventPayload.UserMessage userMessage = data instanceof ChatEventPayload.UserMessage ? (ChatEventPayload.UserMessage) data : null;
                        String messageId = userMessage != null ? userMessage.getMessageId() : null;
                        if (userMessage != null) {
                            String str5 = messageId;
                            if (!(str5 == null || str5.length() == 0)) {
                                TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] user_message: msgId=" + messageId + ", convId=" + conversationId);
                                for (RemoteUserMessageListener remoteUserMessageListener : remoteUserMessageListeners) {
                                    JsonElement content = userMessage.getContent();
                                    Integer messageIndex = userMessage.getMessageIndex();
                                    Long createdAt = userMessage.getCreatedAt();
                                    UserMessageContext userMessageContext = userMessage.getUserMessageContext();
                                    remoteUserMessageListener.onRemoteUserMessage(conversationId, messageId, content, messageIndex, createdAt, userMessageContext != null ? Intrinsics.areEqual(userMessageContext.isAppendMsg(), true) : false);
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    break;
                case -1472993618:
                    if (type.equals("timing_events")) {
                        try {
                            ChatEventPayload data2 = chatEvent.getData();
                            ChatEventPayload.TimingEvents timingEvents = data2 instanceof ChatEventPayload.TimingEvents ? (ChatEventPayload.TimingEvents) data2 : null;
                            if (timingEvents != null) {
                                TimingMeta timingMeta = new TimingMeta(timingEvents.getModelName(), timingEvents.getLogid(), timingEvents.getModelAccountName(), timingEvents.getModelAccountType(), timingEvents.getModelProviderName(), timingEvents.getServerTimingInfo(), timingEvents.isServerRetried(), timingEvents.getEnableDbOpt());
                                Map<String, Double> data3 = timingEvents.getData();
                                if (data3 != null) {
                                    ChatFirstTokenTracker.INSTANCE.onTimingEvents(taskId, data3, timingMeta);
                                    Unit unit2 = Unit.INSTANCE;
                                    Unit unit3 = Unit.INSTANCE;
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        Unit unit4 = Unit.INSTANCE;
                        return;
                    }
                    break;
                case -1147503653:
                    if (type.equals("token_usage")) {
                        try {
                            ChatEventPayload data4 = chatEvent.getData();
                            ChatEventPayload.TokenUsage tokenUsage = data4 instanceof ChatEventPayload.TokenUsage ? (ChatEventPayload.TokenUsage) data4 : null;
                            if (tokenUsage != null) {
                                ChatTokenUsageTracker.INSTANCE.onTokenUsage(taskId, tokenUsage);
                            }
                        } catch (Throwable th) {
                            TraeLogUtil.INSTANCE.d(TAG, "token_usage handle error: taskId=" + taskId + ", e=" + th);
                        }
                        Unit unit5 = Unit.INSTANCE;
                        return;
                    }
                    break;
                case -450004177:
                    str = ", payload=";
                    obj = "metadata";
                    str2 = ", agentId=";
                    str3 = ", agentType=";
                    obj2 = "done";
                    break;
                case 3089282:
                    if (type.equals("done")) {
                        thoughtMap.remove(taskId);
                        seqNumbers.remove(taskId);
                        lastStreamTimestamp.remove(taskId);
                        IMMessageKt.applyEvent(message, chatEvent, source);
                        IMMessageKt.releaseAggregator(message);
                        message.setHistory(true);
                        message.setSourcePhase(MessageSourcePhase.STREAM_DONE);
                        ParsedTaskContent taskContent = message.getTaskContent();
                        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] DONE: taskId=" + taskId + ", planItemCount=" + ((taskContent == null || (messages2 = taskContent.getMessages()) == null) ? 0 : messages2.size()) + ", status=" + message.getStatus() + ", agentType=" + message.getAgentType() + ", agentId=" + message.getAgentId());
                        ParsedTaskContent taskContent2 = message.getTaskContent();
                        if (taskContent2 == null || (messages = taskContent2.getMessages()) == null) {
                            arrayList = null;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it2 = messages.iterator();
                            while (it2.hasNext()) {
                                ParsedPlanItem planItem = ((ParsedPlanItemMessage) it2.next()).getPlanItem();
                                if (planItem != null) {
                                    arrayList2.add(planItem);
                                }
                            }
                            arrayList = arrayList2;
                        }
                        if (arrayList != null) {
                            int i3 = 0;
                            for (Object obj3 : arrayList) {
                                int i4 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                ParsedPlanItem parsedPlanItem = (ParsedPlanItem) obj3;
                                TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                                StringBuilder append = new StringBuilder("[Node1] DONE planItem[").append(i3).append("]: id=").append(parsedPlanItem.getId()).append(", agentId=").append(parsedPlanItem.getAgentId()).append(", agentRunId=").append(parsedPlanItem.getAgentRunId()).append(", tool=");
                                ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
                                traeLogUtil.d(AGENT_FLOW_TAG, append.append(toolCallInfo != null ? toolCallInfo.getName() : null).append(", hasThought=").append(parsedPlanItem.getThought() != null).append(", hasReasoning=").append(parsedPlanItem.getReasoningContent() != null).toString());
                                i3 = i4;
                            }
                            Unit unit6 = Unit.INSTANCE;
                        }
                        TraeLogUtil.INSTANCE.d(TAG, "IMMessage_info_down: type=" + chatEvent.getType() + ", payload=" + gson.toJson(chatEvent));
                        IMLog.INSTANCE.logParsedChatMessage("IMMessage:Done", message);
                        Iterator<T> it3 = streamingMessageListeners.iterator();
                        while (it3.hasNext()) {
                            ((StreamingMessageListener) it3.next()).onStreamingMessage(message, true);
                        }
                        Iterator<T> it4 = doneListeners.iterator();
                        while (it4.hasNext()) {
                            ((DoneListener) it4.next()).onDone(taskId, conversationId);
                        }
                        try {
                            status = message.getStatus();
                        } catch (Throwable unused2) {
                        }
                        if (status != null) {
                            int hashCode = status.hashCode();
                            if (hashCode == -1281977283) {
                                if (!status.equals("failed")) {
                                }
                                stopType = ChatFrontResponseTracker.StopType.Failed;
                            } else if (hashCode != -123173735) {
                                if (hashCode == 96784904) {
                                    if (!status.equals("error")) {
                                    }
                                    stopType = ChatFrontResponseTracker.StopType.Failed;
                                }
                            } else if (status.equals(ConfirmInfo.STATUS_CANCELED)) {
                                stopType = ChatFrontResponseTracker.StopType.Canceled;
                            }
                            ChatFrontResponseTracker.onStreamStopped$default(ChatFrontResponseTracker.INSTANCE, taskId, stopType, null, null, null, 28, null);
                            AgentMonitor.INSTANCE.onAgentDone(taskId, conversationId, message);
                            ChatFirstTokenTracker.INSTANCE.clear(taskId);
                            ChatTokenUsageTracker.INSTANCE.clear(taskId);
                            ChatFrontResponseTracker.INSTANCE.clear(taskId);
                            AgentMonitor.INSTANCE.clear(taskId);
                            Unit unit7 = Unit.INSTANCE;
                            return;
                        }
                        stopType = ChatFrontResponseTracker.StopType.Success;
                        ChatFrontResponseTracker.onStreamStopped$default(ChatFrontResponseTracker.INSTANCE, taskId, stopType, null, null, null, 28, null);
                        AgentMonitor.INSTANCE.onAgentDone(taskId, conversationId, message);
                        ChatFirstTokenTracker.INSTANCE.clear(taskId);
                        ChatTokenUsageTracker.INSTANCE.clear(taskId);
                        ChatFrontResponseTracker.INSTANCE.clear(taskId);
                        AgentMonitor.INSTANCE.clear(taskId);
                        Unit unit72 = Unit.INSTANCE;
                        return;
                    }
                    break;
                case 96784904:
                    if (type.equals("error")) {
                        thoughtMap.remove(taskId);
                        seqNumbers.remove(taskId);
                        lastStreamTimestamp.remove(taskId);
                        IMMessageKt.applyEvent(message, chatEvent, source);
                        IMMessageKt.releaseAggregator(message);
                        message.setHistory(true);
                        message.setSourcePhase(MessageSourcePhase.STREAM_ERROR);
                        TraeLogUtil traeLogUtil2 = TraeLogUtil.INSTANCE;
                        StringBuilder append2 = new StringBuilder("[Node1] ERROR: taskId=").append(taskId).append(", status=").append(message.getStatus()).append(", errorCode=");
                        ParsedError error = message.getError();
                        StringBuilder append3 = append2.append(error != null ? error.getCode() : null).append(", errorMsg=");
                        ParsedError error2 = message.getError();
                        traeLogUtil2.d(AGENT_FLOW_TAG, append3.append(error2 != null ? error2.getMessage() : null).toString());
                        IMLog.INSTANCE.logParsedChatMessage("IMMessage:Error", message);
                        Iterator<T> it5 = streamingMessageListeners.iterator();
                        while (it5.hasNext()) {
                            ((StreamingMessageListener) it5.next()).onStreamingMessage(message, true);
                        }
                        Iterator<T> it6 = doneListeners.iterator();
                        while (it6.hasNext()) {
                            ((DoneListener) it6.next()).onDone(taskId, conversationId);
                        }
                        try {
                            ParsedError error3 = message.getError();
                            Integer code = error3 != null ? error3.getCode() : null;
                            if (code == null) {
                                code = -2;
                            }
                            Integer num = code;
                            ChatFrontResponseTracker chatFrontResponseTracker = ChatFrontResponseTracker.INSTANCE;
                            ChatFrontResponseTracker.StopType stopType2 = ChatFrontResponseTracker.StopType.Failed;
                            ParsedError error4 = message.getError();
                            ChatFrontResponseTracker.onStreamStopped$default(chatFrontResponseTracker, taskId, stopType2, error4 != null ? error4.getMessage() : null, num, null, 16, null);
                            AgentMonitor.INSTANCE.onAgentError(taskId, conversationId, message);
                            ChatFirstTokenTracker.INSTANCE.clear(taskId);
                            ChatTokenUsageTracker.INSTANCE.clear(taskId);
                            ChatFrontResponseTracker.INSTANCE.clear(taskId);
                            AgentMonitor.INSTANCE.clear(taskId);
                        } catch (Throwable unused3) {
                        }
                        Unit unit8 = Unit.INSTANCE;
                        return;
                    }
                    break;
                case 595233003:
                    if (type.equals("notification")) {
                        ChatEventPayload data5 = chatEvent.getData();
                        ChatEventPayload.Notification notification = data5 instanceof ChatEventPayload.Notification ? (ChatEventPayload.Notification) data5 : null;
                        String notificationType = notification != null ? notification.getNotificationType() : null;
                        if (Intrinsics.areEqual(notificationType, ChatEventPayload.Notification.TYPE_QUEUE)) {
                            Integer position = notification.getPosition();
                            int intValue = position != null ? position.intValue() : 0;
                            if (intValue > 0) {
                                message.setQueuingPosition(Integer.valueOf(intValue));
                            }
                            message.setRequestUUID(notification.getRequestUUId());
                            message.setFastRequestEvent(notification.getFastRequestEvent());
                            TraeLogUtil.INSTANCE.d("notification_33", "[Node1] notification(queue) event: taskId=" + taskId + ", convId=" + conversationId + ", position=" + intValue + ' ' + notification.getFastRequestEvent() + ' ' + message.getQueueId());
                            Iterator<T> it7 = streamingMessageListeners.iterator();
                            while (it7.hasNext()) {
                                ((StreamingMessageListener) it7.next()).onStreamingMessage(message, false);
                            }
                        } else if (Intrinsics.areEqual(notificationType, ChatEventPayload.Notification.TYPE_CONTENT_FILTER_WARNING)) {
                            Integer actionType = notification.getActionType();
                            if (actionType == null) {
                                i = 1;
                            } else {
                                i = 1;
                                if (actionType.intValue() == 1) {
                                    str4 = ParsedChatMessage.NOTICE_CONTENT_FILTER_BLOCKED;
                                    message.setNoticeType(str4);
                                    message.setNoticeMessage(null);
                                    message.setContentSecurityRuleName(notification.getHitRuleName());
                                    TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] notification(content_filter_warning): taskId=" + taskId + ", convId=" + conversationId + ", actionType=" + notification.getActionType() + ", executePoint=" + notification.getExecutePoint() + ", rule=" + notification.getHitRuleName());
                                    it = streamingMessageListeners.iterator();
                                    while (it.hasNext()) {
                                        ((StreamingMessageListener) it.next()).onStreamingMessage(message, false);
                                    }
                                }
                            }
                            Integer executePoint = notification.getExecutePoint();
                            if (executePoint != null && executePoint.intValue() == i) {
                                str4 = ParsedChatMessage.NOTICE_CONTENT_FILTER_INPUT_DESENSITIZED;
                            } else {
                                if (executePoint != null) {
                                    executePoint.intValue();
                                }
                                str4 = ParsedChatMessage.NOTICE_CONTENT_FILTER_OUTPUT_DESENSITIZED;
                            }
                            message.setNoticeType(str4);
                            message.setNoticeMessage(null);
                            message.setContentSecurityRuleName(notification.getHitRuleName());
                            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] notification(content_filter_warning): taskId=" + taskId + ", convId=" + conversationId + ", actionType=" + notification.getActionType() + ", executePoint=" + notification.getExecutePoint() + ", rule=" + notification.getHitRuleName());
                            it = streamingMessageListeners.iterator();
                            while (it.hasNext()) {
                            }
                        }
                        Unit unit9 = Unit.INSTANCE;
                        return;
                    }
                    break;
                case 655177102:
                    if (type.equals("queuing")) {
                        ChatEventPayload data6 = chatEvent.getData();
                        ChatEventPayload.Queuing queuing = data6 instanceof ChatEventPayload.Queuing ? (ChatEventPayload.Queuing) data6 : null;
                        ChatFirstTokenTracker.INSTANCE.onQueuing(taskId);
                        AgentMonitor.INSTANCE.onAgentQueuing(taskId, conversationId);
                        if (Intrinsics.areEqual(queuing != null ? queuing.getQueueStatus() : null, "end")) {
                            message.setQueuingPosition(null);
                            message.setQueuingMessage(null);
                            message.setQueueId(null);
                            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] queuing end: taskId=" + taskId + ", convId=" + conversationId);
                        } else {
                            if (queuing == null || (queuePosition = queuing.getPosition()) == null) {
                                queuePosition = queuing != null ? queuing.getQueuePosition() : null;
                                if (queuePosition == null) {
                                    i2 = 0;
                                    if (i2 > 0) {
                                        message.setQueuingPosition(Integer.valueOf(i2));
                                        message.setQueuingMessage(queuing != null ? queuing.getMessage() : null);
                                        message.setQueueId(queuing != null ? queuing.getQueueId() : null);
                                    }
                                    message.setRequestUUID(queuing == null ? queuing.getRequestUUId() : null);
                                    message.setFastRequestEvent(queuing != null ? queuing.getFastRequestEvent() : null);
                                    TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] queuing event: taskId=" + taskId + ", convId=" + conversationId + ", position=" + i2);
                                }
                            }
                            i2 = queuePosition.intValue();
                            if (i2 > 0) {
                            }
                            message.setRequestUUID(queuing == null ? queuing.getRequestUUId() : null);
                            message.setFastRequestEvent(queuing != null ? queuing.getFastRequestEvent() : null);
                            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] queuing event: taskId=" + taskId + ", convId=" + conversationId + ", position=" + i2);
                        }
                        Iterator<T> it8 = streamingMessageListeners.iterator();
                        while (it8.hasNext()) {
                            ((StreamingMessageListener) it8.next()).onStreamingMessage(message, false);
                        }
                        Unit unit10 = Unit.INSTANCE;
                        return;
                    }
                    break;
                case 1515617574:
                    if (type.equals("fast_request_savings")) {
                        try {
                            ChatEventPayload data7 = chatEvent.getData();
                            ChatEventPayload.FastRequestSavings fastRequestSavings = data7 instanceof ChatEventPayload.FastRequestSavings ? (ChatEventPayload.FastRequestSavings) data7 : null;
                            if (fastRequestSavings != null) {
                                FastRequestSavings fastRequestSavings2 = new FastRequestSavings(null, null, null, 7, null);
                                fastRequestSavings2.setSavedTimeSec(fastRequestSavings.getSavedTimeSec());
                                fastRequestSavings2.setSavePositions(fastRequestSavings.getSavePositions());
                                fastRequestSavings2.setTotalSaved(fastRequestSavings.getTotalSaved());
                                message.setFastRequestSavings(fastRequestSavings2);
                                Iterator<T> it9 = streamingMessageListeners.iterator();
                                while (it9.hasNext()) {
                                    ((StreamingMessageListener) it9.next()).onStreamingMessage(message, false);
                                }
                                break;
                            }
                        } catch (Throwable th2) {
                            TraeLogUtil.INSTANCE.d(TAG, "token_usage handle error: taskId=" + taskId + ", e=" + th2);
                            break;
                        }
                    }
                    break;
                case 2102213225:
                    if (type.equals("plan_item")) {
                        str = ", payload=";
                        obj = "metadata";
                        str2 = ", agentId=";
                        str3 = ", agentType=";
                        obj2 = "done";
                        break;
                    }
                    break;
            }
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] applyChatEvent: type=" + chatEvent.getType() + ", seq=" + seq + ", taskId=" + taskId + ", convId=" + conversationId);
            IMMessageKt.applyEvent(message, chatEvent, source);
            ParsedTaskContent taskContent3 = message.getTaskContent();
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node1] afterApply: planItemCount=" + ((taskContent3 == null || (messages3 = taskContent3.getMessages()) == null) ? 0 : messages3.size()) + ", status=" + message.getStatus() + str3 + message.getAgentType() + str2 + message.getAgentId() + ", isHistory=" + message.isHistory());
            if (Intrinsics.areEqual(chatEvent.getType(), obj)) {
                AgentMonitor.INSTANCE.onAgentStart(taskId, conversationId);
                ChatEventPayload data8 = chatEvent.getData();
                ChatEventPayload.Metadata metadata = data8 instanceof ChatEventPayload.Metadata ? (ChatEventPayload.Metadata) data8 : null;
                if (metadata != null) {
                    ChatFirstTokenTracker.INSTANCE.onMetadata(taskId, metadata, source);
                }
                if (Intrinsics.areEqual(metadata != null ? metadata.getMetadataStatus() : null, obj2) && metadata.getUserMessageContext() != null) {
                    Iterator<T> it10 = metadataDoneListeners.iterator();
                    while (it10.hasNext()) {
                        ((MetadataDoneListener) it10.next()).onMetadataDone(conversationId, metadata.getReplyToMessageId(), metadata.getUserMessageContext());
                    }
                }
            }
            Iterator<T> it11 = streamingMessageListeners.iterator();
            while (it11.hasNext()) {
                ((StreamingMessageListener) it11.next()).onStreamingMessage(message, false);
            }
            if (!Intrinsics.areEqual(chatEvent.getType(), obj)) {
                try {
                    ChatEventPayload data9 = chatEvent.getData();
                    ChatEventPayload.PlanItem planItem2 = data9 instanceof ChatEventPayload.PlanItem ? (ChatEventPayload.PlanItem) data9 : null;
                    if (planItem2 != null) {
                        ChatFirstTokenTracker chatFirstTokenTracker = ChatFirstTokenTracker.INSTANCE;
                        String thought = planItem2.getThought();
                        String reasoningContent = planItem2.getReasoningContent();
                        ToolCallInfo toolCallInfo2 = planItem2.getToolCallInfo();
                        chatFirstTokenTracker.checkAndFireFirstToken(taskId, conversationId, thought, reasoningContent, toolCallInfo2 != null ? toolCallInfo2.getName() : null);
                    }
                } catch (Throwable unused4) {
                }
                try {
                    if (ChatFirstTokenTracker.INSTANCE.hasFirstTokenFired(taskId)) {
                        ChatFrontResponseTracker.INSTANCE.onPlanItemToken(taskId);
                    }
                } catch (Throwable unused5) {
                }
            }
            TraeLogUtil traeLogUtil3 = TraeLogUtil.INSTANCE;
            StringBuilder append4 = new StringBuilder("IMMessage: type=").append(chatEvent.getType()).append(str);
            Gson gson2 = gson;
            traeLogUtil3.d(TAG, append4.append(gson2.toJson(message)).toString());
            TraeLogUtil.INSTANCE.d(TAG, "IMMessage_info: type=" + chatEvent.getType() + str + gson2.toJson(chatEvent));
            Unit unit11 = Unit.INSTANCE;
            return;
        }
        Unit unit12 = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parsePayload(int proto, String data, boolean isConsecutiveSeq) {
        String taskId;
        String conversationId;
        String str;
        try {
            TraeLogUtil.INSTANCE.d(TAG, "parsePayload: proto=" + proto + ", data=" + data + ", isConsecutiveSeq=" + isConsecutiveSeq);
            if (proto == 3) {
                Gson gson2 = gson;
                Event event = (Event) gson2.fromJson(data, Event.class);
                if (event == null || (taskId = event.getTaskId()) == null || (conversationId = event.getConversationId()) == null) {
                    return;
                }
                TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node0] WS_EVENT: type=" + event.getType() + ", taskId=" + taskId + ", convId=" + conversationId + ", seq=" + event.getSeq());
                TraeLogUtil.INSTANCE.d(TAG, "IMMessage_info_origin: taskId=" + event.getTaskId() + "，conversationId=" + event.getConversationId() + "，type=" + event.getType() + ", payload=" + gson2.toJson(event));
                ChatEvent chatEvent = (ChatEvent) gson2.fromJson(data, ChatEvent.class);
                if (chatEvent == null) {
                    return;
                }
                applyChatEvent(chatEvent, taskId, conversationId);
                return;
            }
            if (proto == 4 || proto == 5 || proto == 6) {
                Conversation conversation = (Conversation) gson.fromJson(data, Conversation.class);
                if (conversation == null) {
                    return;
                }
                if (proto == 4) {
                    str = "create";
                } else if (proto == 5) {
                    str = "update";
                } else if (proto != 6) {
                    return;
                } else {
                    str = "delete";
                }
                ConversationChangeEvent conversationChangeEvent = new ConversationChangeEvent(str, conversation.getId(), conversation);
                Iterator<T> it = conversationChangeListeners.iterator();
                while (it.hasNext()) {
                    ((ConversationChangeListener) it.next()).onConversationChanged(conversationChangeEvent);
                }
                return;
            }
            switch (proto) {
                case 30:
                    CliStatusChangePayload cliStatusChangePayload = (CliStatusChangePayload) gson.fromJson(data, CliStatusChangePayload.class);
                    if (cliStatusChangePayload == null) {
                        return;
                    }
                    TraeLogUtil.INSTANCE.d(TAG, "cli_status_change: cliId=" + cliStatusChangePayload.getCliId() + ", available=" + cliStatusChangePayload.getAvailable());
                    Iterator<T> it2 = cliStatusChangeListeners.iterator();
                    while (it2.hasNext()) {
                        ((CliStatusChangeListener) it2.next()).onCliStatusChanged(cliStatusChangePayload);
                    }
                    return;
                case 31:
                    CliUnbindPayload cliUnbindPayload = (CliUnbindPayload) gson.fromJson(data, CliUnbindPayload.class);
                    if (cliUnbindPayload == null) {
                        return;
                    }
                    TraeLogUtil.INSTANCE.d(TAG, "cli_unbind: cliId=" + cliUnbindPayload.getCliId() + ", timestamp=" + cliUnbindPayload.getTimestamp());
                    Iterator<T> it3 = cliUnbindListeners.iterator();
                    while (it3.hasNext()) {
                        ((CliUnbindListener) it3.next()).onCliUnbound(cliUnbindPayload);
                    }
                    return;
                case 32:
                    DeleteMessagePushPayload deleteMessagePushPayload = (DeleteMessagePushPayload) gson.fromJson(data, DeleteMessagePushPayload.class);
                    if (deleteMessagePushPayload == null) {
                        return;
                    }
                    TraeLogUtil.INSTANCE.d(TAG, "remote_message_delete: conversationId=" + deleteMessagePushPayload.getConversationId() + ", messageIds=" + deleteMessagePushPayload.getMessageIds());
                    Iterator<T> it4 = deleteMessagePushPayload.getMessageIds().iterator();
                    while (it4.hasNext()) {
                        INSTANCE.cancelThoughtByMessageId(deleteMessagePushPayload.getConversationId(), (String) it4.next());
                    }
                    Iterator<T> it5 = remoteDeleteMessagePushListeners.iterator();
                    while (it5.hasNext()) {
                        ((RemoteDeleteMessagePushListener) it5.next()).onMessagesDeletedRemotely(deleteMessagePushPayload);
                    }
                    return;
                case 33:
                    CliRegisterPayload cliRegisterPayload = (CliRegisterPayload) gson.fromJson(data, CliRegisterPayload.class);
                    if (cliRegisterPayload == null) {
                        return;
                    }
                    TraeLogUtil.INSTANCE.d(TAG, "cli_register: cliId=" + cliRegisterPayload.getCliId() + ", timestamp=" + cliRegisterPayload.getTimestamp());
                    Iterator<T> it6 = cliRegisterListeners.iterator();
                    while (it6.hasNext()) {
                        ((CliRegisterListener) it6.next()).onCliRegister(cliRegisterPayload);
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            TraeLogUtil.INSTANCE.e(TAG, "parsePayload error: " + th);
        }
    }
}
