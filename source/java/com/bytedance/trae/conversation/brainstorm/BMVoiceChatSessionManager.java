package com.bytedance.trae.conversation.brainstorm;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.brainstorm.BrainstormVoiceForegroundService;
import com.bytedance.trae.conversation.voice.ConversationStateMessage;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: BMVoiceChatSessionManager.kt */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r*\u0001 \b\u0000\u0018\u0000 g2\u00020\u0001:\u0005cdefgB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0010\u0010&\u001a\u00020'2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020'J\u001e\u0010*\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0012H\u0002J\u0012\u0010/\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u00101\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u00010\u0015H\u0002J\u0006\u00102\u001a\u00020'J\u0006\u00103\u001a\u00020'J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0002J\u0018\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010;\u001a\u00020'2\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u000205H\u0002J\u0018\u0010B\u001a\u00020'2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u000205H\u0002J\u0018\u0010C\u001a\u00020'2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u000205H\u0002J\u0010\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020LH\u0002J\u001e\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020O2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020O0QH\u0002J \u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020I2\u0006\u0010E\u001a\u00020IH\u0002J\u0018\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020'2\u0006\u0010T\u001a\u00020[H\u0002J\u0016\u0010\\\u001a\u00020'2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0005J\u000e\u0010_\u001a\u00020Y2\u0006\u00109\u001a\u00020\u0005J\u0016\u0010`\u001a\u00020\u0005*\u00020:2\b\b\u0002\u0010a\u001a\u00020IH\u0002J\u0010\u0010b\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u0006h"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;", "", "context", "Landroid/content/Context;", "xAppId", "", "ppeEnv", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "appContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "uiScope", "listener", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;", "hasStartedVoiceChat", "", "conversationId", "voiceChat", "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "currentSceneId", "micMutedRequested", "userDefiniteText", "currentUserRecognizedText", "botDefiniteText", "botRecognizedText", "lastUserNonDefiniteText", "lastBotNonDefiniteText", "isStopped", "rtcListener", "com/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;", "isRunning", "getRoomId", "getTaskId", "getBotName", "setListener", "", "muteMic", "unmuteMic", "start", "sceneId", "clicnvId", "stopInternal", "forceCleanup", "handleJoinRefused", "current", "stopVoiceChatBestEffort", "release", "releaseFinally", "resolveRole", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;", "userId", "handleBinaryMessage", "uid", "message", "", "handleSubvMessage", "emitStatus", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;", "emitRecognizedText", "text", "role", "emitSubtitleText", "emitFinalText", "emitError", "error", "", "emitLocalAudioVolume", "volume", "", "emitRtcAudioProperties", "properties", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;", "emitRtcNetworkQuality", "local", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;", "remotes", "", "emitRtcAudioInputDeviceStateChanged", "deviceId", "state", "emitPerfTimestamp", Fields.EVENT, "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;", "timestampMs", "", "emitConversationState", "Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;", "setServerParams", "signature", IWeixinService.ResponseConstants.URL, "sendServerMessage", "headHex", "maxBytes", "rtcDiag", "Status", "MessageRole", "Listener", "PerfEvent", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BMVoiceChatSessionManager {
    public static final String SCENE_ID_CHAT = "chat";
    private static final String TAG = "BMVoiceChatSession";
    private final Context appContext;
    private String botDefiniteText;
    private String botRecognizedText;
    private String conversationId;
    private String currentSceneId;
    private String currentUserRecognizedText;
    private boolean hasStartedVoiceChat;
    private volatile boolean isStopped;
    private String lastBotNonDefiniteText;
    private String lastUserNonDefiniteText;
    private Listener listener;
    private volatile boolean micMutedRequested;
    private final String ppeEnv;
    private final BMVoiceChatSessionManager$rtcListener$1 rtcListener;
    private final CoroutineScope scope;
    private final CoroutineScope uiScope;
    private String userDefiniteText;
    private StartVoiceChatData voiceChat;
    private final String xAppId;

    /* compiled from: BMVoiceChatSessionManager.kt */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 H\u0016J \u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020#2\u0006\u0010\r\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0016¨\u0006,"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;", "", "onStatus", "", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;", "onRecognizedText", "text", "", "role", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;", "onFinalText", "onError", "error", "", "onVoiceChatDataReady", "data", "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "onSubtitleText", "onConversationStateChanged", "state", "Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;", "onLocalAudioVolume", "volume", "", "onRtcAudioProperties", "properties", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;", "onRtcNetworkQuality", "local", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;", "remotes", "", "onRtcAudioInputDeviceStateChanged", "deviceId", "", "onPerfTimestamp", Fields.EVENT, "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;", "timestampMs", "", "onRtcTextMessage", "uid", "message", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface Listener {

        /* compiled from: BMVoiceChatSessionManager.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class DefaultImpls {
            public static void onConversationStateChanged(Listener listener, ConversationStateMessage conversationStateMessage) {
                Intrinsics.checkNotNullParameter(conversationStateMessage, "state");
            }

            public static void onLocalAudioVolume(Listener listener, float f) {
            }

            public static void onPerfTimestamp(Listener listener, PerfEvent perfEvent, long j) {
                Intrinsics.checkNotNullParameter(perfEvent, Fields.EVENT);
            }

            public static void onRtcAudioInputDeviceStateChanged(Listener listener, String str, int i, int i2) {
                Intrinsics.checkNotNullParameter(str, "deviceId");
            }

            public static void onRtcAudioProperties(Listener listener, VolcRtcClient.RtcLocalAudioProperties rtcLocalAudioProperties) {
                Intrinsics.checkNotNullParameter(rtcLocalAudioProperties, "properties");
            }

            public static void onRtcNetworkQuality(Listener listener, VolcRtcClient.RtcNetworkQuality rtcNetworkQuality, List<VolcRtcClient.RtcNetworkQuality> list) {
                Intrinsics.checkNotNullParameter(rtcNetworkQuality, "local");
                Intrinsics.checkNotNullParameter(list, "remotes");
            }

            public static void onRtcTextMessage(Listener listener, String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "uid");
                Intrinsics.checkNotNullParameter(str2, "message");
            }

            public static void onSubtitleText(Listener listener, String str, MessageRole messageRole) {
                Intrinsics.checkNotNullParameter(str, "text");
                Intrinsics.checkNotNullParameter(messageRole, "role");
            }

            public static void onVoiceChatDataReady(Listener listener, StartVoiceChatData startVoiceChatData) {
                Intrinsics.checkNotNullParameter(startVoiceChatData, "data");
            }
        }

        void onConversationStateChanged(ConversationStateMessage state);

        void onError(Throwable error);

        void onFinalText(String text, MessageRole role);

        void onLocalAudioVolume(float volume);

        void onPerfTimestamp(PerfEvent event, long timestampMs);

        void onRecognizedText(String text, MessageRole role);

        void onRtcAudioInputDeviceStateChanged(String deviceId, int state, int error);

        void onRtcAudioProperties(VolcRtcClient.RtcLocalAudioProperties properties);

        void onRtcNetworkQuality(VolcRtcClient.RtcNetworkQuality local, List<VolcRtcClient.RtcNetworkQuality> remotes);

        void onRtcTextMessage(String uid, String message);

        void onStatus(Status status);

        void onSubtitleText(String text, MessageRole role);

        void onVoiceChatDataReady(StartVoiceChatData data);
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$rtcListener$1] */
    public BMVoiceChatSessionManager(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "xAppId");
        Intrinsics.checkNotNullParameter(str2, "ppeEnv");
        this.xAppId = str;
        this.ppeEnv = str2;
        this.appContext = context.getApplicationContext();
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO().limitedParallelism(1)));
        this.uiScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.conversationId = "";
        this.currentSceneId = "";
        this.userDefiniteText = "";
        this.currentUserRecognizedText = "";
        this.botDefiniteText = "";
        this.botRecognizedText = "";
        this.lastUserNonDefiniteText = "";
        this.lastBotNonDefiniteText = "";
        this.rtcListener = new VolcRtcClient.Listener() { // from class: com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$rtcListener$1
            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onJoinedRoom(String roomId) {
                boolean z;
                String str3;
                StartVoiceChatData startVoiceChatData;
                String rtcDiag;
                Intrinsics.checkNotNullParameter(roomId, "roomId");
                FLogger fLogger = FLogger.INSTANCE;
                BMVoiceChatSessionManager bMVoiceChatSessionManager = BMVoiceChatSessionManager.this;
                StringBuilder append = new StringBuilder("onJoinedRoom: roomId=").append(roomId).append(", micMutedRequested=");
                z = BMVoiceChatSessionManager.this.micMutedRequested;
                StringBuilder append2 = append.append(z).append(", scene=");
                str3 = BMVoiceChatSessionManager.this.currentSceneId;
                StringBuilder append3 = append2.append(str3).append(", task=");
                startVoiceChatData = BMVoiceChatSessionManager.this.voiceChat;
                rtcDiag = bMVoiceChatSessionManager.rtcDiag(append3.append(startVoiceChatData != null ? startVoiceChatData.getTaskId() : null).toString());
                fLogger.d("BMVoiceChatSession", rtcDiag);
                BMVoiceChatSessionManager.this.emitPerfTimestamp(BMVoiceChatSessionManager.PerfEvent.JOIN_ROOM_SUCCESS, System.currentTimeMillis());
                BMVoiceChatSessionManager.this.emitStatus(BMVoiceChatSessionManager.Status.JoinedRoom);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onRoomBinaryMessage(String uid, byte[] message) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(message, "message");
                BMVoiceChatSessionManager.this.handleBinaryMessage(uid, message);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onUserMessage(String uid, String message) {
                CoroutineScope coroutineScope;
                Intrinsics.checkNotNullParameter(uid, "uid");
                Intrinsics.checkNotNullParameter(message, "message");
                coroutineScope = BMVoiceChatSessionManager.this.uiScope;
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$rtcListener$1$onUserMessage$1(BMVoiceChatSessionManager.this, uid, message, null), 3, (Object) null);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onError(Throwable error) {
                String str3;
                StartVoiceChatData startVoiceChatData;
                String rtcDiag;
                Intrinsics.checkNotNullParameter(error, "error");
                FLogger fLogger = FLogger.INSTANCE;
                BMVoiceChatSessionManager bMVoiceChatSessionManager = BMVoiceChatSessionManager.this;
                StringBuilder sb = new StringBuilder("rtcListener.onError: scene=");
                str3 = BMVoiceChatSessionManager.this.currentSceneId;
                StringBuilder append = sb.append(str3).append(", task=");
                startVoiceChatData = BMVoiceChatSessionManager.this.voiceChat;
                rtcDiag = bMVoiceChatSessionManager.rtcDiag(append.append(startVoiceChatData != null ? startVoiceChatData.getTaskId() : null).append(", message=").append(error.getMessage()).toString());
                fLogger.w("BMVoiceChatSession", rtcDiag, error);
                BMVoiceChatSessionManager.this.emitError(error);
                BMVoiceChatSessionManager.this.stopInternal(true);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onServerParamsSetResult(int error) {
                String str3;
                StartVoiceChatData startVoiceChatData;
                String rtcDiag;
                if (error != 0) {
                    FLogger fLogger = FLogger.INSTANCE;
                    BMVoiceChatSessionManager bMVoiceChatSessionManager = BMVoiceChatSessionManager.this;
                    StringBuilder append = new StringBuilder("onServerParamsSetResult: error=").append(error).append(", scene=");
                    str3 = BMVoiceChatSessionManager.this.currentSceneId;
                    StringBuilder append2 = append.append(str3).append(", task=");
                    startVoiceChatData = BMVoiceChatSessionManager.this.voiceChat;
                    rtcDiag = bMVoiceChatSessionManager.rtcDiag(append2.append(startVoiceChatData != null ? startVoiceChatData.getTaskId() : null).toString());
                    fLogger.w("BMVoiceChatSession", rtcDiag);
                }
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onLocalAudioLevel(int volume) {
                BMVoiceChatSessionManager.this.emitLocalAudioVolume(volume);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onLocalAudioProperties(VolcRtcClient.RtcLocalAudioProperties properties) {
                Intrinsics.checkNotNullParameter(properties, "properties");
                BMVoiceChatSessionManager.this.emitRtcAudioProperties(properties);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onNetworkQuality(VolcRtcClient.RtcNetworkQuality local, List<VolcRtcClient.RtcNetworkQuality> remotes) {
                Intrinsics.checkNotNullParameter(local, "local");
                Intrinsics.checkNotNullParameter(remotes, "remotes");
                BMVoiceChatSessionManager.this.emitRtcNetworkQuality(local, remotes);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onAudioInputDeviceStateChanged(String deviceId, int state, int error) {
                Intrinsics.checkNotNullParameter(deviceId, "deviceId");
                BMVoiceChatSessionManager.this.emitRtcAudioInputDeviceStateChanged(deviceId, state, error);
            }

            @Override // com.bytedance.trae.conversation.voice.rtc.VolcRtcClient.Listener
            public void onRemoteUserJoined(String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                BMVoiceChatSessionManager.this.emitPerfTimestamp(BMVoiceChatSessionManager.PerfEvent.BOT_JOINED, System.currentTimeMillis());
            }
        };
    }

    public /* synthetic */ BMVoiceChatSessionManager(Context context, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? VoiceChatApiPaths.HeaderValue.DEFAULT_X_APP_ID : str, (i & 4) != 0 ? "" : str2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BMVoiceChatSessionManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;", "", "<init>", "(Ljava/lang/String;I)V", "Starting", "JoiningRoom", "JoinedRoom", "Stopped", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status Starting = new Status("Starting", 0);
        public static final Status JoiningRoom = new Status("JoiningRoom", 1);
        public static final Status JoinedRoom = new Status("JoinedRoom", 2);
        public static final Status Stopped = new Status("Stopped", 3);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Starting, JoiningRoom, JoinedRoom, Stopped};
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String str, int i) {
        }

        static {
            Status[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BMVoiceChatSessionManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "BOT", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class MessageRole {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MessageRole[] $VALUES;
        public static final MessageRole USER = new MessageRole("USER", 0);
        public static final MessageRole BOT = new MessageRole("BOT", 1);

        private static final /* synthetic */ MessageRole[] $values() {
            return new MessageRole[]{USER, BOT};
        }

        public static EnumEntries<MessageRole> getEntries() {
            return $ENTRIES;
        }

        private MessageRole(String str, int i) {
        }

        static {
            MessageRole[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static MessageRole valueOf(String str) {
            return (MessageRole) Enum.valueOf(MessageRole.class, str);
        }

        public static MessageRole[] values() {
            return (MessageRole[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BMVoiceChatSessionManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;", "", "<init>", "(Ljava/lang/String;I)V", "API_REQUEST_START", "API_REQUEST_END_JOIN_ROOM_START", "JOIN_ROOM_SUCCESS", "BOT_JOINED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class PerfEvent {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PerfEvent[] $VALUES;
        public static final PerfEvent API_REQUEST_START = new PerfEvent("API_REQUEST_START", 0);
        public static final PerfEvent API_REQUEST_END_JOIN_ROOM_START = new PerfEvent("API_REQUEST_END_JOIN_ROOM_START", 1);
        public static final PerfEvent JOIN_ROOM_SUCCESS = new PerfEvent("JOIN_ROOM_SUCCESS", 2);
        public static final PerfEvent BOT_JOINED = new PerfEvent("BOT_JOINED", 3);

        private static final /* synthetic */ PerfEvent[] $values() {
            return new PerfEvent[]{API_REQUEST_START, API_REQUEST_END_JOIN_ROOM_START, JOIN_ROOM_SUCCESS, BOT_JOINED};
        }

        public static EnumEntries<PerfEvent> getEntries() {
            return $ENTRIES;
        }

        private PerfEvent(String str, int i) {
        }

        static {
            PerfEvent[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static PerfEvent valueOf(String str) {
            return (PerfEvent) Enum.valueOf(PerfEvent.class, str);
        }

        public static PerfEvent[] values() {
            return (PerfEvent[]) $VALUES.clone();
        }
    }

    /* renamed from: isRunning, reason: from getter */
    public final boolean getHasStartedVoiceChat() {
        return this.hasStartedVoiceChat;
    }

    public final String getRoomId() {
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        String roomId = startVoiceChatData != null ? startVoiceChatData.getRoomId() : null;
        return roomId == null ? "" : roomId;
    }

    public final String getTaskId() {
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        String taskId = startVoiceChatData != null ? startVoiceChatData.getTaskId() : null;
        return taskId == null ? "" : taskId;
    }

    public final String getBotName() {
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        String botName = startVoiceChatData != null ? startVoiceChatData.getBotName() : null;
        return botName == null ? "" : botName;
    }

    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    public final void muteMic() {
        this.micMutedRequested = true;
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("muteMic: stopAudioCapture, scene=").append(this.currentSceneId).append(", room=");
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        StringBuilder append2 = append.append(startVoiceChatData != null ? startVoiceChatData.getRoomId() : null).append(", task=");
        StartVoiceChatData startVoiceChatData2 = this.voiceChat;
        fLogger.d(TAG, append2.append(startVoiceChatData2 != null ? startVoiceChatData2.getTaskId() : null).append(", hasStarted=").append(this.hasStartedVoiceChat).append(", hasVoiceChat=").append(this.voiceChat != null).toString());
        VolcRtcClient.INSTANCE.stopAudioCapture();
        BrainstormVoiceForegroundService.Companion companion = BrainstormVoiceForegroundService.INSTANCE;
        Context context = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        companion.update(context, true);
    }

    public final void unmuteMic() {
        this.micMutedRequested = false;
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("unmuteMic: startAudioCapture, scene=").append(this.currentSceneId).append(", room=");
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        StringBuilder append2 = append.append(startVoiceChatData != null ? startVoiceChatData.getRoomId() : null).append(", task=");
        StartVoiceChatData startVoiceChatData2 = this.voiceChat;
        fLogger.d(TAG, append2.append(startVoiceChatData2 != null ? startVoiceChatData2.getTaskId() : null).append(", hasStarted=").append(this.hasStartedVoiceChat).append(", hasVoiceChat=").append(this.voiceChat != null).toString());
        BrainstormVoiceForegroundService.Companion companion = BrainstormVoiceForegroundService.INSTANCE;
        Context context = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        companion.update(context, false);
        VolcRtcClient.INSTANCE.startAudioCapture();
    }

    public final void start(Listener listener, String sceneId, String clicnvId) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(clicnvId, "clicnvId");
        if (this.hasStartedVoiceChat) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("start ignored: session already running, scene=").append(this.currentSceneId).append(", room=");
            StartVoiceChatData startVoiceChatData = this.voiceChat;
            fLogger.w(TAG, append.append(startVoiceChatData != null ? startVoiceChatData.getRoomId() : null).toString());
            return;
        }
        this.listener = listener;
        this.hasStartedVoiceChat = true;
        this.isStopped = false;
        this.micMutedRequested = false;
        this.currentSceneId = sceneId;
        this.userDefiniteText = "";
        this.currentUserRecognizedText = "";
        this.botDefiniteText = "";
        this.botRecognizedText = "";
        this.conversationId = clicnvId;
        emitStatus(Status.Starting);
        FLogger.INSTANCE.d(TAG, "start: scene=" + sceneId + ", conversationId=" + this.conversationId + ", micMutedRequested=" + this.micMutedRequested);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$start$1(this, sceneId, listener, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopInternal(boolean forceCleanup) {
        if (!this.hasStartedVoiceChat && !forceCleanup) {
            FLogger.INSTANCE.d(TAG, "stopInternal ignored: not running, forceCleanup=false");
            return;
        }
        String str = this.currentSceneId;
        this.hasStartedVoiceChat = false;
        this.isStopped = false;
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        this.voiceChat = null;
        FLogger.INSTANCE.d(TAG, "stopInternal: forceCleanup=" + forceCleanup + ", scene=" + str + ", room=" + (startVoiceChatData != null ? startVoiceChatData.getRoomId() : null) + ", task=" + (startVoiceChatData != null ? startVoiceChatData.getTaskId() : null) + ", hasVoiceChat=" + (startVoiceChatData != null));
        VolcRtcClient.INSTANCE.stopAudioCapture();
        BrainstormVoiceForegroundService.Companion companion = BrainstormVoiceForegroundService.INSTANCE;
        Context context = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        companion.update(context, true);
        VolcRtcClient.INSTANCE.removeListener(this.rtcListener);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$stopInternal$1(startVoiceChatData, forceCleanup, str, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleJoinRefused(StartVoiceChatData current) {
        this.hasStartedVoiceChat = false;
        this.isStopped = false;
        this.voiceChat = null;
        VolcRtcClient.INSTANCE.removeListener(this.rtcListener);
        BrainstormVoiceForegroundService.Companion companion = BrainstormVoiceForegroundService.INSTANCE;
        Context context = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        companion.stop(context);
        stopVoiceChatBestEffort(current);
        emitStatus(Status.Stopped);
    }

    private final void stopVoiceChatBestEffort(StartVoiceChatData current) {
        String str = this.currentSceneId;
        String str2 = this.conversationId;
        if ((current != null ? current.getAppId() : null) == null || current.getRoomId() == null || current.getTaskId() == null) {
            return;
        }
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$stopVoiceChatBestEffort$1(str2, this, str, current, null), 3, (Object) null);
    }

    public final void release() {
        boolean z = this.hasStartedVoiceChat;
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        String str = this.currentSceneId;
        FLogger.INSTANCE.d(TAG, "release: wasRunning=" + z + ", scene=" + str + ", room=" + (startVoiceChatData != null ? startVoiceChatData.getRoomId() : null) + ", task=" + (startVoiceChatData != null ? startVoiceChatData.getTaskId() : null));
        this.hasStartedVoiceChat = false;
        this.isStopped = false;
        this.voiceChat = null;
        this.listener = null;
        VolcRtcClient.INSTANCE.stopAudioCapture();
        BrainstormVoiceForegroundService.Companion companion = BrainstormVoiceForegroundService.INSTANCE;
        Context context = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        companion.update(context, true);
        VolcRtcClient.INSTANCE.removeListener(this.rtcListener);
        if (z && startVoiceChatData != null) {
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$release$1(startVoiceChatData, str, this, null), 3, (Object) null);
        } else {
            releaseFinally();
        }
    }

    public final void releaseFinally() {
        FLogger.INSTANCE.d(TAG, "releaseFinally: leaveRoom and cancel scopes");
        VolcRtcClient.INSTANCE.leaveRoom();
        BrainstormVoiceForegroundService.Companion companion = BrainstormVoiceForegroundService.INSTANCE;
        Context context = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        companion.stop(context);
        Job job = this.scope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.uiScope.getCoroutineContext().get(Job.Key);
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageRole resolveRole(String userId) {
        StartVoiceChatData startVoiceChatData = this.voiceChat;
        String botName = startVoiceChatData != null ? startVoiceChatData.getBotName() : null;
        if (botName == null) {
            botName = "";
        }
        return ((botName.length() > 0) && Intrinsics.areEqual(userId, botName)) ? MessageRole.BOT : MessageRole.USER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0076, code lost:
    
        if (r3 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleBinaryMessage(String uid, byte[] message) {
        String str;
        try {
            Integer readMagic = SubtitleBinaryProtocol.INSTANCE.readMagic(message);
            if (readMagic != null && readMagic.intValue() == 1937072758) {
                handleSubvMessage(uid, message);
                return;
            }
            if (readMagic.intValue() == 1668247158) {
                ConversationStateMessage unpackConvMessage = SubtitleBinaryProtocol.INSTANCE.unpackConvMessage(message);
                if (unpackConvMessage != null) {
                    emitConversationState(unpackConvMessage);
                    return;
                } else {
                    FLogger.INSTANCE.w(TAG, rtcDiag("handleBinaryMessage conv unpack returned null: uid=" + uid + ", size=" + message.length));
                    return;
                }
            }
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("unknown binary message magic: 0x");
            if (readMagic != null) {
                str = Integer.toString(readMagic.intValue(), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            }
            str = "null";
            fLogger.w(TAG, rtcDiag(sb.append(str).append(", size=").append(message.length).toString()));
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, rtcDiag("handleBinaryMessage error: uid=" + uid + ", size=" + message.length), th);
        }
    }

    private final void handleSubvMessage(String uid, byte[] message) {
        try {
            if (this.isStopped) {
                return;
            }
            SubtitleBinaryProtocol.SubtitlePayload unpackSubvMessage = SubtitleBinaryProtocol.INSTANCE.unpackSubvMessage(message);
            if (unpackSubvMessage == null) {
                FLogger.INSTANCE.w(TAG, rtcDiag("subtitle unpack failed: uid=" + uid + ", size=" + message.length + ", head=" + headHex$default(this, message, 0, 1, null)));
            } else {
                BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$handleSubvMessage$1(unpackSubvMessage, this, null), 3, (Object) null);
            }
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, rtcDiag("handleSubvMessage error: uid=" + uid + ", size=" + message.length), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitStatus(Status status) {
        if (!this.isStopped || status == Status.Stopped) {
            Listener listener = this.listener;
            if (listener == null) {
                FLogger.INSTANCE.w(TAG, rtcDiag("emitStatus dropped: listener is null, status=" + status));
            } else {
                BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitStatus$1(listener, status, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitRecognizedText(String text, MessageRole role) {
        Listener listener;
        if (!this.isStopped && (listener = this.listener) != null) {
            BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitRecognizedText$1(listener, text, role, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitSubtitleText(String text, MessageRole role) {
        Listener listener;
        if (this.isStopped) {
            return;
        }
        if (!(text.length() == 0) && (listener = this.listener) != null) {
            BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitSubtitleText$1(listener, text, role, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitFinalText(String text, MessageRole role) {
        Listener listener = this.listener;
        if (listener == null) {
            FLogger.INSTANCE.w(TAG, rtcDiag("emitFinalText dropped: listener is null, role=" + role + ", length=" + text.length()));
        } else {
            BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitFinalText$1(listener, text, role, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitError(Throwable error) {
        Listener listener = this.listener;
        if (listener == null) {
            FLogger.INSTANCE.w(TAG, rtcDiag("emitError dropped: listener is null, message=" + error.getMessage()), error);
        } else {
            FLogger.INSTANCE.w(TAG, rtcDiag("emitError: message=" + error.getMessage()), error);
            BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitError$1(listener, error, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitLocalAudioVolume(int volume) {
        Listener listener;
        if (this.isStopped || (listener = this.listener) == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitLocalAudioVolume$1(listener, RangesKt.coerceIn(volume / 255.0f, 0.0f, 1.0f), null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitRtcAudioProperties(VolcRtcClient.RtcLocalAudioProperties properties) {
        Listener listener;
        if (this.isStopped || (listener = this.listener) == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitRtcAudioProperties$1(listener, properties, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitRtcNetworkQuality(VolcRtcClient.RtcNetworkQuality local, List<VolcRtcClient.RtcNetworkQuality> remotes) {
        Listener listener;
        if (this.isStopped || (listener = this.listener) == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitRtcNetworkQuality$1(listener, local, remotes, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitRtcAudioInputDeviceStateChanged(String deviceId, int state, int error) {
        Listener listener;
        if (this.isStopped || (listener = this.listener) == null) {
            return;
        }
        BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1(listener, deviceId, state, error, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitPerfTimestamp(PerfEvent event, long timestampMs) {
        try {
            Listener listener = this.listener;
            if (listener == null) {
                BMVoiceChatSessionManager bMVoiceChatSessionManager = this;
                FLogger.INSTANCE.w(TAG, rtcDiag("emitPerfTimestamp dropped: listener is null, event=" + event + ", timestampMs=" + timestampMs));
            } else {
                BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitPerfTimestamp$1(listener, event, timestampMs, null), 3, (Object) null);
            }
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, rtcDiag("emitPerfTimestamp failed: event=" + event + ", timestampMs=" + timestampMs), th);
        }
    }

    private final void emitConversationState(ConversationStateMessage state) {
        Listener listener = this.listener;
        if (listener == null) {
            FLogger.INSTANCE.w(TAG, rtcDiag("emitConversationState dropped: listener is null, stage=" + state.getStage().getCode() + '-' + state.getStage().getDescription()));
        } else {
            BuildersKt.launch$default(this.uiScope, (CoroutineContext) null, (CoroutineStart) null, new BMVoiceChatSessionManager$emitConversationState$1(listener, state, null), 3, (Object) null);
        }
    }

    public final void setServerParams(String signature, String url) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        VolcRtcClient.INSTANCE.setServerParams(signature, url);
    }

    public final long sendServerMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return VolcRtcClient.INSTANCE.sendServerMessage(message);
    }

    static /* synthetic */ String headHex$default(BMVoiceChatSessionManager bMVoiceChatSessionManager, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 16;
        }
        return bMVoiceChatSessionManager.headHex(bArr, i);
    }

    private final String headHex(byte[] bArr, int i) {
        return CollectionsKt.joinToString$default(ArraysKt.take(bArr, i), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence headHex$lambda$7;
                headHex$lambda$7 = BMVoiceChatSessionManager.headHex$lambda$7(((Byte) obj).byteValue());
                return headHex$lambda$7;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence headHex$lambda$7(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String rtcDiag(String message) {
        return "RTC_DIAG " + message;
    }
}
