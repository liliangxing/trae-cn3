# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/logger/LogKey;
.super Ljava/lang/Object;
.source "FormatLogBuilder.kt"

.field public static final Companion:Lcom/bytedance/trae/utils/logger/LogKey$Companion;
.field private static final TTSSubtitleData:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final action:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final audioScene:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final botId:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final botName:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final callID:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final callTtsTaskId:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final contentType:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final conversationId:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final enterMethod:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final errorMsg:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final isInterrupt:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final logID:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final messageId:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final queryRound:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final result:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final sectionId:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final sessionCategory:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final sessionID:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final sessionMode:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final sessionOptions:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final styleID:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final taskID:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final text:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final type:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final updateKey:Lcom/bytedance/trae/utils/logger/LogKey;
.field private static final voiceId:Lcom/bytedance/trae/utils/logger/LogKey;
.field private final rawValue:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->Companion Lcom/bytedance/trae/utils/logger/LogKey$Companion;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "call_id"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->callID Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, task_id
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->taskID Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, session_id
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sessionID Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "log_id"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->logID Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, style_id
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->styleID Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "audio_scene"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->audioScene Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, session_category
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sessionCategory Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, session_mode
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sessionMode Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, session_options
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sessionOptions Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, result
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->result Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "bot_id"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->botId Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "bot_name"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->botName Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "content_type"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->contentType Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "conversation_id"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->conversationId Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "message_id"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->messageId Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, voice_id
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->voiceId Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, text
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->text Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "error_msg"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->errorMsg Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "last_call_tts_task_id"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->callTtsTaskId Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "is_interrupt"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->isInterrupt Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, tts_subtitle_data
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->TTSSubtitleData Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, sectionId
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sectionId Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, queryRound
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->queryRound Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, type
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->type Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string/jumbo v1, updateKey
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->updateKey Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "action"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->action Lcom/bytedance/trae/utils/logger/LogKey;
    new-instance v0, Lcom/bytedance/trae/utils/logger/LogKey;
    const-string v1, "enter_method"
    invoke-direct v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->enterMethod Lcom/bytedance/trae/utils/logger/LogKey;
    return-void 
.end method

.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, rawValue
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/utils/logger/LogKey;->rawValue Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$getAction$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->action Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getAudioScene$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->audioScene Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getBotId$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->botId Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getBotName$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->botName Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getCallID$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->callID Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getCallTtsTaskId$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->callTtsTaskId Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getContentType$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->contentType Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getConversationId$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->conversationId Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getEnterMethod$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->enterMethod Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getErrorMsg$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->errorMsg Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getLogID$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->logID Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getMessageId$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->messageId Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getQueryRound$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->queryRound Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getResult$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->result Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getSectionId$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sectionId Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getSessionCategory$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sessionCategory Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getSessionID$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sessionID Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getSessionMode$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sessionMode Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getSessionOptions$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->sessionOptions Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getStyleID$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->styleID Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getTTSSubtitleData$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->TTSSubtitleData Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getTaskID$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->taskID Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getText$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->text Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getType$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->type Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getUpdateKey$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->updateKey Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$getVoiceId$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->voiceId Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public static final synthetic access$isInterrupt$cp()com.bytedance.trae.utils.logger.LogKey
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/LogKey;->isInterrupt Lcom/bytedance/trae/utils/logger/LogKey;
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 4
    # ins_size=2
    instance-of v0, v3, Lcom/bytedance/trae/utils/logger/LogKey;
    const/4 v1, 0
    if-eqz v0, +005h
    check-cast v3, Lcom/bytedance/trae/utils/logger/LogKey;
    goto +2h
    move-object v3, v1
    if-eqz v3, +004h
    iget-object v1, v3, Lcom/bytedance/trae/utils/logger/LogKey;->rawValue Ljava/lang/String;
    iget-object v3, v2, Lcom/bytedance/trae/utils/logger/LogKey;->rawValue Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    return v3
.end method

.method public final getRawValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;->rawValue Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/LogKey;->rawValue Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    return v0
.end method
