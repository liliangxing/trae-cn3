# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;
.super Ljava/lang/Object;
.source "BrainstormSessionHolder.kt"

.implements Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;


.method public static synthetic $r8$lambda$32g5DOCuSXUMoIvKJT6OBMX3NnY(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;->onError$lambda$3(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$MOzDFnv-9PPnScqM2dHR7HPw8eM(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;->onConversationStateChanged$lambda$4(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$YL4LHBRJG7A69fKrFAbYqdko8iY(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;->onStatus$lambda$0(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$lyMhUvI-_4IQ08TvErUCQxB8Ti0(float  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;->onLocalAudioVolume$lambda$6(F Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pAxFouyDVlNU-DNkbnZN2ZtAu7U(com.bytedance.trae.conversation.voice.ConversationStateMessage  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;->onConversationStateChanged$lambda$5(Lcom/bytedance/trae/conversation/voice/ConversationStateMessage; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$zWymvnXxydRbBV1_Sx6NWR8AiVM(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1;->onFinalText$lambda$1(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onConversationStateChanged$lambda$4(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string/jumbo v0, tracker
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->THINKING_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onConversationStateChanged$lambda$5(com.bytedance.trae.conversation.voice.ConversationStateMessage  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 5
    # ins_size=2
    const-string/jumbo v0, tracker
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->CONVERSATION_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "conversation_error_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getErrorInfo()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->getErrorCode()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getErrorInfo()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->getErrorCode()I
    move-result v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v4, v0, v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordSignal(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I)Z
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final onError$lambda$3(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 8
    # ins_size=1
    const-string/jumbo v0, tracker
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;->RTC_ERROR Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal;
    const-string/jumbo v3, rtc_runtime_error_minimized
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordSignal$default(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker; Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptSignal; Ljava/lang/String; I I Ljava/lang/Object;)Z
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method private static final onFinalText$lambda$1(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string/jumbo v0, tracker
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->USER_FINAL_RECEIVED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onLocalAudioVolume$lambda$6(float  com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string/jumbo v0, tracker
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->onLocalAudioVolume(F)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onStatus$lambda$0(com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string/jumbo v0, tracker
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->RTC_JOINED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->recordStage(Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public onConversationStateChanged(com.bytedance.trae.conversation.voice.ConversationStateMessage)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, state
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getCode()I
    move-result v0
    if-eqz v0, +011h
    const/4 v1, 2
    if-eq v0, v1, +003h
    goto +16h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$withVoiceDiscussionAttempt(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lkotlin/jvm/functions/Function1;)V
    goto +bh
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda3;
    invoke-direct v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$withVoiceDiscussionAttempt(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "internalListener.onConversationStateChanged: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->getStage()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->getCode()I
    move-result v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "BrainstormHolder"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onError(java.lang.Throwable)void
    .registers 5
    # ins_size=2
    const-string v0, "error"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$withVoiceDiscussionAttempt(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BrainstormHolder"
    const-string v2, "internalListener.onError"
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public onFinalText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 36
    # ins_size=3
    move-object/from16 v0, v34
    move-object/from16 v1, v35
    const-string/jumbo v2, text
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, role
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    if-ne v1, v2, +00ch
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda4;
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda4;-><init>()V
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$withVoiceDiscussionAttempt(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lkotlin/jvm/functions/Function1;)V
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$getCurrentSnapshot$p()Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v3
    if-eqz v3, +071h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/Collection;
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-static v4, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$buildBrainstormMessage(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    move-object v6, v0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$get_subtitleHistorySize$p()Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getUiState()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 4194301
    const/16 v30, 0
    invoke-static/range v4 ... v30, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Ljava/util/List; Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState; Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary; J J Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState; I Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/util/List; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;
    move-result-object v4
    const/4 v6, 0
    const/4 v10, 0
    const-wide/16 v11, 0
    const-wide/16 v13, 0
    const-wide/16 v15, 0
    const-wide/16 v17, 0
    const-wide/16 v19, 0
    const-wide/16 v21, 0
    const/16 v24, 0
    const/16 v26, 0
    const/16 v29, 0
    const v31, 2097150
    const/16 v32, 0
    invoke-static/range v3 ... v32, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lcom/bytedance/trae/im/service/Mode; Z J J J J J J Z Z I I Ljava/util/List; Ljava/util/List; Z Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$setCurrentSnapshot$p(Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;)V
    return-void 
.end method

.method public onLocalAudioVolume(float)void
    .registers 4
    # ins_size=2
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$getCurrentSnapshot$p()Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;->getVoiceDiscussionAttemptState()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker;->Companion Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptTracker$Companion;->isVoiceDetected(F)Z
    move-result v1
    if-eqz v1, +01eh
    if-eqz v0, +01ch
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;->getStageElapsedMs()Ljava/util/Map;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->FIRST_VOICE_DETECTED Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptStage;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ch
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda5;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda5;-><init>(F)V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$withVoiceDiscussionAttempt(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lkotlin/jvm/functions/Function1;)V
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$get_localAudioVolume$p()Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    invoke-static v3, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v3
    invoke-interface v0, v3, Lkotlinx/coroutines/flow/MutableSharedFlow;->tryEmit(Ljava/lang/Object;)Z
    return-void 
.end method

.method public onPerfTimestamp(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$PerfEvent  long)void
    .registers 4
    # ins_size=4
    const-string v2, "event"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onRecognizedText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, role
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onRtcAudioInputDeviceStateChanged(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener$DefaultImpls;->onRtcAudioInputDeviceStateChanged(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Ljava/lang/String; I I)V
    return-void 
.end method

.method public onRtcAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener$DefaultImpls;->onRtcAudioProperties(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;)V
    return-void 
.end method

.method public onRtcNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener$DefaultImpls;->onRtcNetworkQuality(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality; Ljava/util/List;)V
    return-void 
.end method

.method public onRtcTextMessage(java.lang.String  java.lang.String)void
    .registers 20
    # ins_size=3
    move-object/from16 v1, v18
    move-object/from16 v2, v19
    const-string/jumbo v0, uid
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->peekSubTaskMessageType(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const-string v3, "internalListener.onRtcTextMessage: forward task_update, taskId="
    const-string v4, "internalListener.onRtcTextMessage: forward sub_task_request, taskId="
    const-string v5, ", status="
    const-string v6, ", tool="
    const-string v7, ", currentRoom="
    const-string v8, ", room="
    const/4 v10, 0
    const-string v11, ""
    const-string v12, ", taskId="
    const-string v13, "internalListener.onRtcTextMessage: forward "
    const-string v14, "BrainstormHolder"
    const/4 v15, 0
    if-eqz v0, +207h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v16
    sparse-switch v16, +00003adh
    goto/16 +1feh
    const-string/jumbo v9, task_update
    invoke-virtual v0, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +1f3h
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskUpdate(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    const-string v3, "invalid task_update"
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->getVoiceChatSession$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v15
    if-nez v1, +003h
    goto +2h
    move-object v11, v1
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v9, 1
    goto +2h
    move v9, v10
    if-eqz v9, +003h
    move-object v15, v11
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleSubTaskUpdate(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Ljava/lang/String;)Z
    return-void 
    const-string/jumbo v9, task_result
    invoke-virtual v0, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +189h
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseToolResult(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    move-result-object v0
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    const-string v3, "invalid task_result"
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleToolResult(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Z
    move-result v1
    if-eqz v1, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$reportServerToolEnd(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V
    return-void 
    const-string/jumbo v9, task_start
    invoke-virtual v0, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +128h
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseTaskStart(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;
    move-result-object v0
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    const-string v3, "invalid task_start"
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->recordServerToolStart(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleTaskStart(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    return-void 
    const-string/jumbo v9, task_stop
    invoke-virtual v0, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0d6h
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseTaskStop(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    move-result-object v0
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    const-string v3, "invalid task_stop"
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->getVoiceChatSession$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v15
    if-nez v1, +003h
    goto +2h
    move-object v11, v1
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v9, 1
    goto +2h
    move v9, v10
    if-eqz v9, +003h
    move-object v15, v11
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleTaskStop(Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage; Ljava/lang/String;)V
    return-void 
    const-string/jumbo v9, sub_task_request
    invoke-virtual v0, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +60h
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskRequest(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    const-string v3, "invalid sub_task_request"
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$logUnrecognizedRtcFrame(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->getVoiceChatSession$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v15
    if-nez v1, +003h
    goto +2h
    move-object v11, v1
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v9, 1
    goto +2h
    move v9, v10
    if-eqz v9, +003h
    move-object v15, v11
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleSubTaskRequest(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Ljava/lang/String;)Z
    return-void 
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskRequest(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    if-eqz v0, +053h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->getVoiceChatSession$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v15
    if-nez v1, +003h
    goto +2h
    move-object v11, v1
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v9, 1
    goto +2h
    move v9, v10
    if-eqz v9, +003h
    move-object v15, v11
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleSubTaskRequest(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Ljava/lang/String;)Z
    return-void 
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseSubTaskUpdate(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;
    move-result-object v0
    if-eqz v0, +053h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->getVoiceChatSession$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v15
    if-nez v1, +003h
    goto +2h
    move-object v11, v1
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v9, 1
    goto +2h
    move v9, v10
    if-eqz v9, +003h
    move-object v15, v11
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleSubTaskUpdate(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRequestMessage; Ljava/lang/String;)Z
    return-void 
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseTaskStart(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;
    move-result-object v0
    if-eqz v0, +03bh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;->getToolName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics;->recordServerToolStart(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleTaskStart(Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;)V
    return-void 
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseTaskStop(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;
    move-result-object v0
    if-eqz v0, +05fh
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->getVoiceChatSession$conversation_mainlandRelease()Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->getRoomId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v15
    if-nez v1, +003h
    goto +2h
    move-object v11, v1
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v9, 1
    goto +2h
    move v9, v10
    if-eqz v9, +003h
    move-object v15, v11
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, v15, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleTaskStop(Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage; Ljava/lang/String;)V
    return-void 
    invoke-static/range v19, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->parseToolResult(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;
    move-result-object v0
    if-eqz v0, +04ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getToolName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v14, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->handleToolResult(Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)Z
    move-result v1
    if-eqz v1, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$reportServerToolEnd(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object/from16 v1, v18
    move-object/from16 v2, v19
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->logUnrecognizedRtcFrame$default(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
    nop 
    sparse-switch-payload -360db28c ac8367c 4e3e6528 770e4017 7cc0b0c3
.end method

.method public onStatus(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Status)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, status
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->JoinedRoom Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    if-ne v4, v0, +00ch
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$withVoiceDiscussionAttempt(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lkotlin/jvm/functions/Function1;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "internalListener.onStatus: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "BrainstormHolder"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onSubtitleText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, role
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onVoiceChatDataReady(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 3
    # ins_size=2
    const-string v0, "data"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getSubTaskConfig()Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->updateSubTaskConfig(Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;)V
    return-void 
.end method
