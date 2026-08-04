# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;
.super Ljava/lang/Object;
.source "VoiceChatConfigWarmup.kt"

.field private static final EVENT_NAME:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;
.field private static final MIN_FETCH_INTERVAL_MS:J
.field private static final SCENE_ID_CUSTOM:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static appId:Ljava/lang/String;
.field private static bridge cachedData:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field private static bridge lastFetchTimeMs:J
.field private static pollingJob:Lkotlinx/coroutines/Job;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$fetchAndCache(com.bytedance.trae.conversation.voice.VoiceChatConfigWarmup  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->fetchAndCache(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final fetchAndCache(kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    instance-of v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;-><init>(Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup; Lkotlin/coroutines/Continuation;)V
    move-object v13, v2
    iget-object v1, v13, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v13, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;->label I
    const/4 v15, 0
    const/4 v14, 1
    if-eqz v3, +018h
    if-ne v3, v14, +00eh
    iget-object v2, v13, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v3, v1
    move/from16 v17, v14
    move v1, v15
    goto +5dh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v3, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +10ch
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v1
    if-eqz v1, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/login/api/AccountInfo;->isLogin()Z
    move-result v1
    if-ne v1, v14, +004h
    move v1, v14
    goto +2h
    move v1, v15
    if-nez v1, +004h
    goto/16 +0f9h
    sget-object v3, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v1
    invoke-virtual v1, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v1, toString(...)
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v5, "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8"
    const-string/jumbo v6, transcription
    const/4 v7, 1
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v1, 496
    const/16 v16, 0
    iput-object v0, v13, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;->L$0 Ljava/lang/Object;
    iput v14, v13, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$fetchAndCache$1;->label I
    move/from16 v17, v14
    move v14, v1
    move v1, v15
    move-object/from16 v15, v16
    invoke-static/range v3 ... v15, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->startVoiceChat$default(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v2, +003h
    return-object v2
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v2, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string/jumbo v4, rtc_voice_pre_create_engine
    const-string v5, "duration_ms"
    const-string/jumbo v6, status
    const/4 v7, 0
    if-eqz v2, +0a2h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    sput-wide v8, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->lastFetchTimeMs J
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v7
    sput-object v3, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->appId Ljava/lang/String;
    if-nez v3, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v8, Lorg/json/JSONObject;
    invoke-direct v8, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v9, success
    invoke-virtual v8, v6, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v9
    sget-object v11, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v11, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->preloadEngine(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v11
    sub-long/2addr v11, v9
    invoke-virtual v6, v5, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    invoke-virtual v3, v4, v8, v6, v7, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    if-eqz v2, +074h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v15, v1
    goto +3h
    move/from16 v15, v17
    if-nez v15, +05fh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v15, v1
    goto +3h
    move/from16 v15, v17
    if-nez v15, +04ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getUserId()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v15, v1
    goto +3h
    move/from16 v15, v17
    if-nez v15, +035h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getToken()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v15, v1
    goto +3h
    move/from16 v15, v17
    if-nez v15, +020h
    sput-object v2, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->cachedData Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    goto +1ch
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "failed"
    invoke-virtual v2, v6, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v5, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    invoke-virtual v1, v4, v2, v3, v7, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    goto +4h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    :try_start_0x30
    :try_start_0x43
    :try_start_0xa3
    :try_start_0xc9
    :try_start_0xcf
    :try_start_0xdd
    :try_start_0xec
.end method

.method private final startPolling()void
    .registers 7
    # ins_size=1
    invoke-direct v6, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->stopPolling()V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$startPolling$1;
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$startPolling$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final stopPolling()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    sput-object v1, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getAppId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->appId Ljava/lang/String;
    return-object v0
.end method

.method public final getCachedData()com.bytedance.trae.conversation.voice.network.StartVoiceChatData
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->cachedData Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    return-object v0
.end method

.method public final getOrFetchCachedData(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;-><init>(Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->cachedData Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v5, +003h
    return-object v5
    iput v3, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup$getOrFetchCachedData$1;->label I
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->fetchAndCache(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    sget-object v5, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->cachedData Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    return-object v5
.end method

.method public final setCachedData(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->cachedData Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    return-void 
.end method

.method public final warmup()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-eqz v1, +003h
    return-void 
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sget-wide v2, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->lastFetchTimeMs J
    sub-long/2addr v0, v2
    const-wide/32 v2, 3600000
    cmp-long v0, v0, v2
    if-gez v0, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->cachedData Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v0, +003h
    return-void 
    invoke-direct v4, Lcom/bytedance/trae/conversation/voice/VoiceChatConfigWarmup;->startPolling()V
    return-void 
.end method
