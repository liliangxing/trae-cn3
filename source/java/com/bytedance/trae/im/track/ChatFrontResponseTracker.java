package com.bytedance.trae.im.track;

import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.service.ModelSelectionConstants;
import com.bytedance.trae.im.track.ChatFirstTokenTracker;
import com.bytedance.trae.platform.service.ApmService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ChatFrontResponseTracker.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J?\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/track/ChatFrontResponseTracker;", "", "<init>", "()V", "TAG", "", "EVENT_NAME", "tokenOutputContexts", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;", "onPlanItemToken", "", "taskId", "onStreamStopped", "stopType", "Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;", "errorMsg", "errCode", "", "serverError", "(Ljava/lang/String;Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "clear", "StopType", "TokenOutputContext", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatFrontResponseTracker {
    private static final String EVENT_NAME = "icube_ai_front_response";
    private static final String TAG = "ChatFrontResponseTracker";
    public static final ChatFrontResponseTracker INSTANCE = new ChatFrontResponseTracker();
    private static final ConcurrentHashMap<String, TokenOutputContext> tokenOutputContexts = new ConcurrentHashMap<>();

    /* compiled from: ChatFrontResponseTracker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StopType.values().length];
            try {
                iArr[StopType.Success.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StopType.Failed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StopType.Canceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ChatFrontResponseTracker() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ChatFrontResponseTracker.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$StopType;", "", "<init>", "(Ljava/lang/String;I)V", "Success", "Failed", "Canceled", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class StopType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StopType[] $VALUES;
        public static final StopType Success = new StopType("Success", 0);
        public static final StopType Failed = new StopType("Failed", 1);
        public static final StopType Canceled = new StopType("Canceled", 2);

        private static final /* synthetic */ StopType[] $values() {
            return new StopType[]{Success, Failed, Canceled};
        }

        public static EnumEntries<StopType> getEntries() {
            return $ENTRIES;
        }

        private StopType(String str, int i) {
        }

        static {
            StopType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static StopType valueOf(String str) {
            return (StopType) Enum.valueOf(StopType.class, str);
        }

        public static StopType[] values() {
            return (StopType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChatFrontResponseTracker.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/track/ChatFrontResponseTracker$TokenOutputContext;", "", "lastOutputTime", "", "durations", "", "<init>", "(JLjava/util/List;)V", "getLastOutputTime", "()J", "setLastOutputTime", "(J)V", "getDurations", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TokenOutputContext {
        private final List<Long> durations;
        private long lastOutputTime;

        public TokenOutputContext() {
            this(0L, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TokenOutputContext copy$default(TokenOutputContext tokenOutputContext, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = tokenOutputContext.lastOutputTime;
            }
            if ((i & 2) != 0) {
                list = tokenOutputContext.durations;
            }
            return tokenOutputContext.copy(j, list);
        }

        /* renamed from: component1, reason: from getter */
        public final long getLastOutputTime() {
            return this.lastOutputTime;
        }

        public final List<Long> component2() {
            return this.durations;
        }

        public final TokenOutputContext copy(long lastOutputTime, List<Long> durations) {
            Intrinsics.checkNotNullParameter(durations, "durations");
            return new TokenOutputContext(lastOutputTime, durations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TokenOutputContext)) {
                return false;
            }
            TokenOutputContext tokenOutputContext = (TokenOutputContext) other;
            return this.lastOutputTime == tokenOutputContext.lastOutputTime && Intrinsics.areEqual(this.durations, tokenOutputContext.durations);
        }

        public int hashCode() {
            return (Long.hashCode(this.lastOutputTime) * 31) + this.durations.hashCode();
        }

        public String toString() {
            return "TokenOutputContext(lastOutputTime=" + this.lastOutputTime + ", durations=" + this.durations + ')';
        }

        public TokenOutputContext(long j, List<Long> list) {
            Intrinsics.checkNotNullParameter(list, "durations");
            this.lastOutputTime = j;
            this.durations = list;
        }

        public final long getLastOutputTime() {
            return this.lastOutputTime;
        }

        public final void setLastOutputTime(long j) {
            this.lastOutputTime = j;
        }

        public /* synthetic */ TokenOutputContext(long j, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? new ArrayList() : arrayList);
        }

        public final List<Long> getDurations() {
            return this.durations;
        }
    }

    public final void onPlanItemToken(String taskId) {
        TokenOutputContext putIfAbsent;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        try {
            ConcurrentHashMap<String, TokenOutputContext> concurrentHashMap = tokenOutputContexts;
            TokenOutputContext tokenOutputContext = concurrentHashMap.get(taskId);
            if (tokenOutputContext == null && (putIfAbsent = concurrentHashMap.putIfAbsent(taskId, (tokenOutputContext = new TokenOutputContext(0L, null, 3, null)))) != null) {
                tokenOutputContext = putIfAbsent;
            }
            TokenOutputContext tokenOutputContext2 = tokenOutputContext;
            long currentTimeMillis = System.currentTimeMillis();
            if (tokenOutputContext2.getLastOutputTime() > 0) {
                tokenOutputContext2.getDurations().add(Long.valueOf(currentTimeMillis - tokenOutputContext2.getLastOutputTime()));
            }
            tokenOutputContext2.setLastOutputTime(currentTimeMillis);
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void onStreamStopped$default(ChatFrontResponseTracker chatFrontResponseTracker, String str, StopType stopType, String str2, Integer num, String str3, int i, Object obj) {
        chatFrontResponseTracker.onStreamStopped(str, stopType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0167 A[Catch: all -> 0x01ed, TryCatch #1 {all -> 0x01ed, blocks: (B:3:0x0017, B:7:0x0020, B:9:0x0030, B:10:0x0036, B:12:0x0042, B:14:0x004f, B:15:0x006a, B:26:0x00a5, B:29:0x00bc, B:32:0x00d8, B:35:0x00f8, B:38:0x0105, B:41:0x0113, B:44:0x011c, B:46:0x0123, B:48:0x0132, B:49:0x0138, B:52:0x0143, B:55:0x0151, B:58:0x015e, B:60:0x0167, B:61:0x016d, B:64:0x017b, B:67:0x0191, B:70:0x019e, B:73:0x01ab, B:76:0x01b8, B:79:0x01c7, B:81:0x01d9, B:82:0x01e5, B:94:0x007e, B:95:0x0083), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d9 A[Catch: all -> 0x01ed, TryCatch #1 {all -> 0x01ed, blocks: (B:3:0x0017, B:7:0x0020, B:9:0x0030, B:10:0x0036, B:12:0x0042, B:14:0x004f, B:15:0x006a, B:26:0x00a5, B:29:0x00bc, B:32:0x00d8, B:35:0x00f8, B:38:0x0105, B:41:0x0113, B:44:0x011c, B:46:0x0123, B:48:0x0132, B:49:0x0138, B:52:0x0143, B:55:0x0151, B:58:0x015e, B:60:0x0167, B:61:0x016d, B:64:0x017b, B:67:0x0191, B:70:0x019e, B:73:0x01ab, B:76:0x01b8, B:79:0x01c7, B:81:0x01d9, B:82:0x01e5, B:94:0x007e, B:95:0x0083), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onStreamStopped(String taskId, StopType stopType, String errorMsg, Integer errCode, String serverError) {
        String str;
        String optString;
        String agentProcessSupport;
        String chatProcessVersion;
        String traceId;
        String ttnetABTest;
        String requestClient;
        String agentProcessSupport2;
        String source;
        String agentTaskServiceStrategy;
        String chatProcessVersion2;
        String modelStrategy;
        String configSource;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(stopType, "stopType");
        try {
            ChatFirstTokenTracker.TrackingContext trackingContext = ChatFirstTokenTracker.INSTANCE.getTrackingContext(taskId);
            if (trackingContext == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ChatFirstTokenTracker.FirstTokenReportedContext reportedContext = ChatFirstTokenTracker.INSTANCE.getReportedContext(taskId);
            long startTime = trackingContext.getStartTime();
            JSONObject categories = reportedContext != null ? reportedContext.getCategories() : null;
            long j = currentTimeMillis - startTime;
            TokenOutputContext remove = tokenOutputContexts.remove(taskId);
            Double valueOf = (remove == null || !(remove.getDurations().isEmpty() ^ true)) ? null : Double.valueOf(CollectionsKt.sumOfLong(remove.getDurations()) / remove.getDurations().size());
            int i = WhenMappings.$EnumSwitchMapping$0[stopType.ordinal()];
            if (i == 1) {
                str = "Success";
            } else if (i == 2) {
                str = "Failed";
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "Canceled";
            }
            if (categories != null) {
                try {
                } catch (Throwable unused) {
                    optString = "";
                }
                if (categories.has("model")) {
                    optString = categories.optString("model");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(PageDataManager.EXTRA_STATUS, str);
                    jSONObject.put("startTime", startTime);
                    agentProcessSupport = trackingContext.getAgentProcessSupport();
                    if (agentProcessSupport == null) {
                        agentProcessSupport = "";
                    }
                    jSONObject.put("agent_process_support", agentProcessSupport);
                    jSONObject.put("isPreset", !Intrinsics.areEqual(trackingContext.isPreset(), true) ? 1 : 0);
                    jSONObject.put("model", optString);
                    jSONObject.put(Constant.KEY_APP_VERSION2, optString);
                    jSONObject.put("agentType", trackingContext.getAgentType());
                    jSONObject.put("queued", !trackingContext.getQueued() ? 1 : 0);
                    chatProcessVersion = trackingContext.getChatProcessVersion();
                    if (chatProcessVersion == null) {
                        chatProcessVersion = "";
                    }
                    jSONObject.put("chat_process_version", chatProcessVersion);
                    traceId = trackingContext.getTraceId();
                    if (traceId == null) {
                        traceId = "";
                    }
                    jSONObject.put("traceId", traceId);
                    if (stopType != StopType.Success) {
                        if (errorMsg != null) {
                            jSONObject.put("errorMsg", errorMsg);
                        }
                        if (errCode != null) {
                            jSONObject.put("errCode", errCode.intValue());
                        }
                        if (serverError != null) {
                            jSONObject.put("serverError", serverError);
                        }
                    }
                    ttnetABTest = trackingContext.getTtnetABTest();
                    if (ttnetABTest == null) {
                        ttnetABTest = "";
                    }
                    jSONObject.put("ttnetABTest", ttnetABTest);
                    requestClient = trackingContext.getRequestClient();
                    if (requestClient == null) {
                        requestClient = "";
                    }
                    jSONObject.put("requestClient", requestClient);
                    agentProcessSupport2 = trackingContext.getAgentProcessSupport();
                    if (agentProcessSupport2 == null) {
                        agentProcessSupport2 = "";
                    }
                    jSONObject.put("agentProcessSupport", agentProcessSupport2);
                    source = trackingContext.getSource();
                    if (source != null) {
                        jSONObject.put(TimonPipeline.KEY_SOURCE, source);
                    }
                    jSONObject.put("hasText", !trackingContext.getHasText() ? "true" : "false");
                    jSONObject.put("imageCount", trackingContext.getImageCount());
                    agentTaskServiceStrategy = trackingContext.getAgentTaskServiceStrategy();
                    if (agentTaskServiceStrategy == null) {
                        agentTaskServiceStrategy = "";
                    }
                    jSONObject.put("agentTaskServiceStrategy", agentTaskServiceStrategy);
                    chatProcessVersion2 = trackingContext.getChatProcessVersion();
                    if (chatProcessVersion2 == null) {
                        chatProcessVersion2 = "";
                    }
                    jSONObject.put("chatProcessVersion", chatProcessVersion2);
                    modelStrategy = trackingContext.getModelStrategy();
                    if (modelStrategy == null) {
                        modelStrategy = ModelSelectionConstants.AUTO;
                    }
                    jSONObject.put("modelStrategy", modelStrategy);
                    configSource = trackingContext.getConfigSource();
                    if (configSource == null) {
                        configSource = "";
                    }
                    jSONObject.put("configSource", configSource);
                    String provider = trackingContext.getProvider();
                    jSONObject.put("provider", provider != null ? "" : provider);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("costTime", j);
                    jSONObject2.put("startTime", startTime);
                    if (valueOf != null) {
                        jSONObject2.put("tokenOutputInterval", valueOf.doubleValue());
                    }
                    ApmService.INSTANCE.monitorEventForSlardar(EVENT_NAME, jSONObject, jSONObject2, (JSONObject) null);
                }
            }
            optString = trackingContext.getModel();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(PageDataManager.EXTRA_STATUS, str);
            jSONObject3.put("startTime", startTime);
            agentProcessSupport = trackingContext.getAgentProcessSupport();
            if (agentProcessSupport == null) {
            }
            jSONObject3.put("agent_process_support", agentProcessSupport);
            jSONObject3.put("isPreset", !Intrinsics.areEqual(trackingContext.isPreset(), true) ? 1 : 0);
            jSONObject3.put("model", optString);
            jSONObject3.put(Constant.KEY_APP_VERSION2, optString);
            jSONObject3.put("agentType", trackingContext.getAgentType());
            jSONObject3.put("queued", !trackingContext.getQueued() ? 1 : 0);
            chatProcessVersion = trackingContext.getChatProcessVersion();
            if (chatProcessVersion == null) {
            }
            jSONObject3.put("chat_process_version", chatProcessVersion);
            traceId = trackingContext.getTraceId();
            if (traceId == null) {
            }
            jSONObject3.put("traceId", traceId);
            if (stopType != StopType.Success) {
            }
            ttnetABTest = trackingContext.getTtnetABTest();
            if (ttnetABTest == null) {
            }
            jSONObject3.put("ttnetABTest", ttnetABTest);
            requestClient = trackingContext.getRequestClient();
            if (requestClient == null) {
            }
            jSONObject3.put("requestClient", requestClient);
            agentProcessSupport2 = trackingContext.getAgentProcessSupport();
            if (agentProcessSupport2 == null) {
            }
            jSONObject3.put("agentProcessSupport", agentProcessSupport2);
            source = trackingContext.getSource();
            if (source != null) {
            }
            jSONObject3.put("hasText", !trackingContext.getHasText() ? "true" : "false");
            jSONObject3.put("imageCount", trackingContext.getImageCount());
            agentTaskServiceStrategy = trackingContext.getAgentTaskServiceStrategy();
            if (agentTaskServiceStrategy == null) {
            }
            jSONObject3.put("agentTaskServiceStrategy", agentTaskServiceStrategy);
            chatProcessVersion2 = trackingContext.getChatProcessVersion();
            if (chatProcessVersion2 == null) {
            }
            jSONObject3.put("chatProcessVersion", chatProcessVersion2);
            modelStrategy = trackingContext.getModelStrategy();
            if (modelStrategy == null) {
            }
            jSONObject3.put("modelStrategy", modelStrategy);
            configSource = trackingContext.getConfigSource();
            if (configSource == null) {
            }
            jSONObject3.put("configSource", configSource);
            String provider2 = trackingContext.getProvider();
            jSONObject3.put("provider", provider2 != null ? "" : provider2);
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("costTime", j);
            jSONObject22.put("startTime", startTime);
            if (valueOf != null) {
            }
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_NAME, jSONObject3, jSONObject22, (JSONObject) null);
        } catch (Throwable unused2) {
        }
    }

    public final void clear(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        tokenOutputContexts.remove(taskId);
    }
}
