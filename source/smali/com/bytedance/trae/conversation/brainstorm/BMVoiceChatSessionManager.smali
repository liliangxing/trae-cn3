# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
.super Ljava/lang/Object;
.source "BMVoiceChatSessionManager.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Companion;
.field public static final SCENE_ID_CHAT:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private final appContext:Landroid/content/Context;
.field private botDefiniteText:Ljava/lang/String;
.field private botRecognizedText:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private currentSceneId:Ljava/lang/String;
.field private currentUserRecognizedText:Ljava/lang/String;
.field private hasStartedVoiceChat:Z
.field private bridge isStopped:Z
.field private lastBotNonDefiniteText:Ljava/lang/String;
.field private lastUserNonDefiniteText:Ljava/lang/String;
.field private listener:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
.field private bridge micMutedRequested:Z
.field private final ppeEnv:Ljava/lang/String;
.field private final rtcListener:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
.field private final scope:Lkotlinx/coroutines/CoroutineScope;
.field private final uiScope:Lkotlinx/coroutines/CoroutineScope;
.field private userDefiniteText:Ljava/lang/String;
.field private voiceChat:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field private final xAppId:Ljava/lang/String;


.method public static synthetic $r8$lambda$-BUTQsm32rxdb2tIyOgSKHzt-94(byte)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->headHex$lambda$7(B)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->Companion Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, xAppId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ppeEnv"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->xAppId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->ppeEnv Ljava/lang/String;
    invoke-virtual v2, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->appContext Landroid/content/Context;
    const/4 v2, 0
    const/4 v3, 1
    invoke-static v2, v3, v2, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v4
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    invoke-virtual v0, v3, Lkotlinx/coroutines/CoroutineDispatcher;->limitedParallelism(I)Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v4, v0, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v4
    invoke-static v4, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v4
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    invoke-static v2, v3, v2, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v2
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v3
    invoke-virtual v3, Lkotlinx/coroutines/MainCoroutineDispatcher;->getImmediate()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v2, v3, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const-string v2, ""
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->conversationId Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->userDefiniteText Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentUserRecognizedText Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->botDefiniteText Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->botRecognizedText Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->lastUserNonDefiniteText Ljava/lang/String;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->lastBotNonDefiniteText Ljava/lang/String;
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcListener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    const-string v2, "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8"
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    const-string v3, ""
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;-><init>(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$emitError(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.Throwable)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitError(Ljava/lang/Throwable;)V
    return-void 
.end method

.method public static final synthetic access$emitFinalText(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitFinalText(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    return-void 
.end method

.method public static final synthetic access$emitLocalAudioVolume(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitLocalAudioVolume(I)V
    return-void 
.end method

.method public static final synthetic access$emitPerfTimestamp(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$PerfEvent  long)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitPerfTimestamp(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent; J)V
    return-void 
.end method

.method public static final synthetic access$emitRecognizedText(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitRecognizedText(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    return-void 
.end method

.method public static final synthetic access$emitRtcAudioInputDeviceStateChanged(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitRtcAudioInputDeviceStateChanged(Ljava/lang/String; I I)V
    return-void 
.end method

.method public static final synthetic access$emitRtcAudioProperties(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitRtcAudioProperties(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;)V
    return-void 
.end method

.method public static final synthetic access$emitRtcNetworkQuality(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitRtcNetworkQuality(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality; Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$emitStatus(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Status)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitStatus(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;)V
    return-void 
.end method

.method public static final synthetic access$emitSubtitleText(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitSubtitleText(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    return-void 
.end method

.method public static final synthetic access$getAppContext$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)android.content.Context
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->appContext Landroid/content/Context;
    return-object v0
.end method

.method public static final synthetic access$getBotDefiniteText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->botDefiniteText Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getBotRecognizedText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->botRecognizedText Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getConversationId$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCurrentSceneId$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCurrentUserRecognizedText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentUserRecognizedText Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getLastBotNonDefiniteText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->lastBotNonDefiniteText Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getListener$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    return-object v0
.end method

.method public static final synthetic access$getMicMutedRequested$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->micMutedRequested Z
    return v0
.end method

.method public static final synthetic access$getPpeEnv$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->ppeEnv Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getRtcListener$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$rtcListener$1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcListener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
    return-object v0
.end method

.method public static final synthetic access$getUiScope$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)kotlinx.coroutines.CoroutineScope
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    return-object v0
.end method

.method public static final synthetic access$getUserDefiniteText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->userDefiniteText Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getVoiceChat$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)com.bytedance.trae.conversation.voice.network.StartVoiceChatData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    return-object v0
.end method

.method public static final synthetic access$getXAppId$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->xAppId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$handleBinaryMessage(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String  byte[])void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->handleBinaryMessage(Ljava/lang/String; [B)V
    return-void 
.end method

.method public static final synthetic access$handleJoinRefused(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->handleJoinRefused(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    return-void 
.end method

.method public static final synthetic access$resolveRole(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->resolveRole(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$rtcDiag(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setBotDefiniteText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->botDefiniteText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setBotRecognizedText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->botRecognizedText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setCurrentUserRecognizedText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentUserRecognizedText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setLastBotNonDefiniteText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->lastBotNonDefiniteText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setLastUserNonDefiniteText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->lastUserNonDefiniteText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setUserDefiniteText$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->userDefiniteText Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setVoiceChat$p(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    return-void 
.end method

.method public static final synthetic access$stopInternal(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->stopInternal(Z)V
    return-void 
.end method

.method private final emitConversationState(com.bytedance.trae.conversation.voice.ConversationStateMessage)void
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v0, +03ah
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "emitConversationState dropped: listener is null, stage="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getCode()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 45
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getDescription()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const-string v1, "BMVoiceChatSession"
    invoke-virtual v0, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v2, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitConversationState$1;
    const/4 v5, 0
    invoke-direct v1, v0, v9, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitConversationState$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/voice/ConversationStateMessage; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitError(java.lang.Throwable)void
    .registers 12
    # ins_size=2
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    const-string v1, "BMVoiceChatSession"
    if-nez v0, +022h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "emitError dropped: listener is null, message="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v10, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, v11, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "emitError: message="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v10, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v1, v3, v11, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v4, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitError$1;
    const/4 v2, 0
    invoke-direct v1, v0, v11, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitError$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Ljava/lang/Throwable; Lkotlin/coroutines/Continuation;)V
    move-object v7, v1
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitFinalText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v0, +02eh
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "emitFinalText dropped: listener is null, role="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v1, ", length="
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v8
    invoke-virtual v9, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    const-string v9, "BMVoiceChatSession"
    invoke-virtual v0, v9, v8, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitFinalText$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v9, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitFinalText$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitLocalAudioVolume(int)void
    .registers 9
    # ins_size=2
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v0, +003h
    return-void 
    int-to-float v8, v8
    const/high16 v1, 1132396544
    div-float/2addr v8, v1
    const/4 v1, 0
    const/high16 v2, 1065353216
    invoke-static v8, v1, v2, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v8
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; F Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitPerfTimestamp(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$PerfEvent  long)void
    .registers 16
    # ins_size=4
    const-string v0, ", timestampMs="
    const-string v1, "BMVoiceChatSession"
    const-string v2, "emitPerfTimestamp dropped: listener is null, event="
    iget-object v4, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v4, +024h
    move-object v3, v12
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v12, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v2, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v9, 0
    const/4 v10, 0
    new-instance v11, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitPerfTimestamp$1;
    const/4 v8, 0
    move-object v3, v11
    move-object v5, v13
    move-wide v6, v14
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitPerfTimestamp$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent; J Lkotlin/coroutines/Continuation;)V
    move-object v6, v11
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    move-object v3, v2
    move-object v4, v9
    move-object v5, v10
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +22h
    move-exception v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "emitPerfTimestamp failed: event="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v14, v15, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-direct v12, v13, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    invoke-virtual v3, v1, v13, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x6
.end method

.method private final emitRecognizedText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 9
    # ins_size=3
    iget-boolean v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v0, +006h
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    return-void 
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRecognizedText$1;
    const/4 v5, 0
    invoke-direct v4, v0, v7, v8, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRecognizedText$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole; Lkotlin/coroutines/Continuation;)V
    move-object v7, v4
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    move-object v0, v1
    move-object v1, v2
    move-object v2, v3
    move-object v3, v7
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitRtcAudioInputDeviceStateChanged(java.lang.String  int  int)void
    .registers 14
    # ins_size=4
    iget-boolean v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    if-eqz v0, +003h
    return-void 
    iget-object v2, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v2, +003h
    return-void 
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;
    const/4 v6, 0
    move-object v1, v9
    move-object v3, v11
    move v4, v12
    move v5, v13
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Ljava/lang/String; I I Lkotlin/coroutines/Continuation;)V
    move-object v6, v9
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    move-object v3, v0
    move-object v4, v7
    move-object v5, v8
    move v7, v11
    move-object v8, v12
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitRtcAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    .registers 9
    # ins_size=2
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v0, +003h
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioProperties$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioProperties$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitRtcNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    .registers 10
    # ins_size=3
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v0, +003h
    return-void 
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcNetworkQuality$1;
    const/4 v5, 0
    invoke-direct v4, v0, v8, v9, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcNetworkQuality$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitStatus(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Status)void
    .registers 10
    # ins_size=2
    iget-boolean v0, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->Stopped Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    if-eq v9, v0, +003h
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v0, +020h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "emitStatus dropped: listener is null, status="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    const-string v1, "BMVoiceChatSession"
    invoke-virtual v0, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v2, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitStatus$1;
    const/4 v5, 0
    invoke-direct v1, v0, v9, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitStatus$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final emitSubtitleText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 9
    # ins_size=3
    iget-boolean v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    if-nez v0, +02eh
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    goto +1eh
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-nez v0, +006h
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    return-void 
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitSubtitleText$1;
    const/4 v5, 0
    invoke-direct v4, v0, v7, v8, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitSubtitleText$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole; Lkotlin/coroutines/Continuation;)V
    move-object v7, v4
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    move-object v0, v1
    move-object v1, v2
    move-object v2, v3
    move-object v3, v7
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final handleBinaryMessage(java.lang.String  byte[])void
    .registers 10
    # ins_size=3
    const-string v0, ", size="
    const-string v1, "BMVoiceChatSession"
    const-string v2, "handleBinaryMessage conv unpack returned null: uid="
    const-string/jumbo v3, unknown binary message magic: 0x
    sget-object v4, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    invoke-virtual v4, v9, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->readMagic([B)Ljava/lang/Integer;
    move-result-object v4
    if-nez v4, +003h
    goto +fh
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v5
    const v6, 1937072758
    if-ne v5, v6, +007h
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->handleSubvMessage(Ljava/lang/String; [B)V
    goto/16 +097h
    if-nez v4, +003h
    goto +37h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v5
    const v6, 1668247158
    if-ne v5, v6, +02fh
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    invoke-virtual v3, v9, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->unpackConvMessage([B)Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    move-result-object v3
    if-eqz v3, +007h
    invoke-direct v7, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitConversationState(Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;)V
    goto/16 +07eh
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    array-length v4, v9
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v7, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +5dh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v4, +018h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v3
    const/16 v4, 16
    invoke-static v4, Lkotlin/text/CharsKt;->checkRadix(I)I
    move-result v4
    invoke-static v3, v4, Ljava/lang/Integer;->toString(I I)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, toString(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +004h
    const-string v3, "null"
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    array-length v4, v9
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v7, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +23h
    move-exception v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "handleBinaryMessage error: uid="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    array-length v9, v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v3, v1, v8, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x9
.end method

.method private final handleJoinRefused(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 5
    # ins_size=2
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcListener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
    check-cast v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->appContext Landroid/content/Context;
    const-string v2, "appContext"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->stop(Landroid/content/Context;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->stopVoiceChatBestEffort(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->Stopped Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitStatus(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;)V
    return-void 
.end method

.method private final handleSubvMessage(java.lang.String  byte[])void
    .registers 13
    # ins_size=3
    const-string v0, ", size="
    const-string v1, "BMVoiceChatSession"
    const-string/jumbo v2, subtitle unpack failed: uid=
    iget-boolean v3, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    if-eqz v3, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;
    invoke-virtual v3, v12, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol;->unpackSubvMessage([B)Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    move-result-object v3
    const/4 v4, 0
    if-nez v3, +032h
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    array-length v5, v12
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", head="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/4 v5, 0
    const/4 v6, 1
    invoke-static v10, v12, v5, v6, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->headHex$default(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; [B I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v10, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v2, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;
    invoke-direct v7, v3, v10, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    move-object v3, v2
    move-object v4, v5
    move-object v5, v6
    move-object v6, v7
    move v7, v8
    move-object v8, v9
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +23h
    move-exception v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "handleSubvMessage error: uid="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    array-length v12, v12
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v11, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcDiag(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v3, v1, v11, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x7
.end method

.method private final headHex(byte[]  int)java.lang.String
    .registers 12
    # ins_size=3
    invoke-static v10, v11, Lkotlin/collections/ArraysKt;->take([B I)Ljava/util/List;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, ""
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    new-instance v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$$ExternalSyntheticLambda0;
    invoke-direct v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$$ExternalSyntheticLambda0;-><init>()V
    const/16 v7, 30
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method static synthetic headHex$default(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  byte[]  int  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +004h
    const/16 v2, 16
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->headHex([B I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final headHex$lambda$7(byte)java.lang.CharSequence
    .registers 4
    # ins_size=1
    const/4 v0, 1
    new-array v1, v0, [Ljava/lang/Object;
    const/4 v2, 0
    invoke-static v3, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;
    move-result-object v3
    aput-object v3, v1, v2
    invoke-static v1, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v3
    const-string v0, "%02x"
    invoke-static v0, v3, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v0, "format(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    return-object v3
.end method

.method private final resolveRole(java.lang.String)com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getBotName()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00bh
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->BOT Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    return-object v3
.end method

.method private final rtcDiag(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RTC_DIAG "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final stopInternal(boolean)void
    .registers 14
    # ins_size=2
    iget-boolean v0, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    const-string v1, "BMVoiceChatSession"
    if-nez v0, +00dh
    if-nez v13, +00bh
    sget-object v13, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, stopInternal ignored: not running, forceCleanup=false
    invoke-virtual v13, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-object v5, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    const/4 v0, 0
    iput-boolean v0, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    iput-boolean v0, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    iget-object v3, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    const/4 v2, 0
    iput-object v2, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string/jumbo v7, stopInternal: forceCleanup=
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v13, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", scene="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", room="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v2
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", task="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v6, ", hasVoiceChat="
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/4 v6, 1
    if-eqz v3, +003h
    move v0, v6
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->stopAudioCapture()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->appContext Landroid/content/Context;
    const-string v2, "appContext"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcListener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
    check-cast v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;
    const/4 v7, 0
    move-object v2, v9
    move v4, v13
    move-object v6, v12
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Z Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    const/4 v10, 3
    const/4 v11, 0
    move-object v6, v0
    move-object v7, v1
    invoke-static/range v6 ... v11, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final stopVoiceChatBestEffort(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 12
    # ins_size=2
    iget-object v3, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->conversationId Ljava/lang/String;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +029h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +023h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +1bh
    iget-object v6, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;
    const/4 v5, 0
    move-object v0, v9
    move-object v2, v10
    move-object v4, v11
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lkotlin/coroutines/Continuation;)V
    move-object v11, v9
    check-cast v11, Lkotlin/jvm/functions/Function2;
    const/4 v0, 3
    const/4 v9, 0
    move-object v4, v6
    move-object v5, v7
    move-object v6, v8
    move-object v7, v11
    move v8, v0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getBotName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getBotName()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final getRoomId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final isRunning()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    return v0
.end method

.method public final muteMic()void
    .registers 6
    # ins_size=1
    const/4 v0, 1
    iput-boolean v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->micMutedRequested Z
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "muteMic: stopAudioCapture, scene="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", room="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", task="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", hasStarted="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", hasVoiceChat="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v3, +004h
    move v3, v0
    goto +2h
    const/4 v3, 0
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "BMVoiceChatSession"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->stopAudioCapture()V
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->appContext Landroid/content/Context;
    const-string v3, "appContext"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    return-void 
.end method

.method public final release()void
    .registers 13
    # ins_size=1
    iget-boolean v0, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    iget-object v1, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iget-object v2, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "release: wasRunning="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", scene="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", room="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/4 v5, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v5
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v6, ", task="
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v5
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v6, "BMVoiceChatSession"
    invoke-virtual v3, v6, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v3, 0
    iput-boolean v3, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    iput-boolean v3, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    iput-object v5, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iput-object v5, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    sget-object v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->stopAudioCapture()V
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v4, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->appContext Landroid/content/Context;
    const-string v6, "appContext"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 1
    invoke-virtual v3, v4, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    sget-object v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v4, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->rtcListener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
    check-cast v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->removeListener(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)V
    if-eqz v0, +016h
    if-eqz v1, +014h
    iget-object v6, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v7, 0
    const/4 v8, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;
    invoke-direct v0, v1, v2, v12, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    move-object v9, v0
    check-cast v9, Lkotlin/jvm/functions/Function2;
    const/4 v10, 3
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +4h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->releaseFinally()V
    return-void 
.end method

.method public final releaseFinally()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BMVoiceChatSession"
    const-string v2, "releaseFinally: leaveRoom and cancel scopes"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->appContext Landroid/content/Context;
    const-string v2, "appContext"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->stop(Landroid/content/Context;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v1, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v1, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v1, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->uiScope Lkotlinx/coroutines/CoroutineScope;
    invoke-interface v0, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    sget-object v3, Lkotlinx/coroutines/Job;->Key Lkotlinx/coroutines/Job$Key;
    check-cast v3, Lkotlin/coroutines/CoroutineContext$Key;
    invoke-interface v0, v3, Lkotlin/coroutines/CoroutineContext;->get(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;
    move-result-object v0
    check-cast v0, Lkotlinx/coroutines/Job;
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final sendServerMessage(java.lang.String)long
    .registers 4
    # ins_size=2
    const-string v0, "message"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->sendServerMessage(Ljava/lang/String;)J
    move-result-wide v0
    return-wide v0
.end method

.method public final setListener(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    return-void 
.end method

.method public final setServerParams(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, signature
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->setServerParams(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final start(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  java.lang.String  java.lang.String)void
    .registers 13
    # ins_size=4
    const-string v0, "listener"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sceneId
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "clicnvId"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    const/4 v1, 0
    const-string v2, "BMVoiceChatSession"
    if-eqz v0, +02ch
    sget-object v10, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string/jumbo v12, start ignored: session already running, scene=
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v12, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", room="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    iget-object v12, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v12, +006h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v11, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v2, v11, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iput-object v10, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    const/4 v0, 1
    iput-boolean v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    const/4 v0, 0
    iput-boolean v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->isStopped Z
    iput-boolean v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->micMutedRequested Z
    iput-object v11, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    const-string v0, ""
    iput-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->userDefiniteText Ljava/lang/String;
    iput-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentUserRecognizedText Ljava/lang/String;
    iput-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->botDefiniteText Ljava/lang/String;
    iput-object v0, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->botRecognizedText Ljava/lang/String;
    iput-object v12, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->conversationId Ljava/lang/String;
    sget-object v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->Starting Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-direct v9, v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->emitStatus(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;)V
    sget-object v12, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v3, start: scene=
    invoke-direct v0, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", conversationId="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v3, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->conversationId Ljava/lang/String;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", micMutedRequested="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v3, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->micMutedRequested Z
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v12, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v3, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;
    invoke-direct v12, v9, v11, v10, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lkotlin/coroutines/Continuation;)V
    move-object v6, v12
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final unmuteMic()void
    .registers 6
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->micMutedRequested Z
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, unmuteMic: startAudioCapture, scene=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->currentSceneId Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", room="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    const/4 v4, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v4
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", task="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", hasStarted="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->hasStartedVoiceChat Z
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", hasVoiceChat="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->voiceChat Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    move v3, v0
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "BMVoiceChatSession"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->appContext Landroid/content/Context;
    const-string v3, "appContext"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->update(Landroid/content/Context; Z)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->startAudioCapture()V
    return-void 
.end method
