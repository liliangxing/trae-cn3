# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
.super Ljava/lang/Object;
.source "IVoiceChatApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic getVoiceChatHistory$default(com.bytedance.trae.conversation.voice.network.IVoiceChatApi$Companion  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 8
    if-eqz v15, +004h
    const-string v11, "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8"
    move-object v4, v11
    and-int/lit8 v11, v14, 16
    if-eqz v11, +004h
    const-string v12, ""
    move-object v5, v12
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v6, v13
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->getVoiceChatHistory(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method public static synthetic startVoiceChat$default(com.bytedance.trae.conversation.voice.network.IVoiceChatApi$Companion  java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 26
    # ins_size=13
    move/from16 v0, v24
    and-int/lit8 v1, v0, 8
    if-eqz v1, +005h
    const/4 v1, 0
    move v6, v1
    goto +3h
    move/from16 v6, v17
    and-int/lit8 v1, v0, 16
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v19
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v0, v0, 256
    if-eqz v0, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v22
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v12, v23
    invoke-virtual/range v2 ... v12, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->startVoiceChat(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic stopVoiceChat$default(com.bytedance.trae.conversation.voice.network.IVoiceChatApi$Companion  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=11
    and-int/lit8 v0, v19, 64
    if-eqz v0, +006h
    const-string v0, ""
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v17
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    move-object/from16 v9, v18
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->stopVoiceChat(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final getVoiceChatHistory(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=7
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    instance-of v2, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;
    if-eqz v2, +014h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v1, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;->label I
    move-object/from16 v3, v16
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;
    move-object/from16 v3, v16
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;->label I
    const/4 v6, 1
    if-eqz v5, +017h
    if-ne v5, v6, +00dh
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +51h
    move-exception v0
    move-object v7, v0
    goto/16 +069h
    move-exception v0
    goto/16 +077h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    move-object/from16 v5, v18
    move-object/from16 v7, v19
    move-object/from16 v8, v20
    invoke-virtual v1, v5, v7, v8, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->buildHeaders(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/util/Map;
    move-result-object v12
    sget-object v7, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v8, voice_chat
    const-class v9, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;
    const/4 v10, 0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->getHOST()Ljava/lang/String;
    move-result-object v11
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v6
    goto +2h
    move v0, v1
    if-nez v0, +004h
    move v13, v6
    goto +2h
    move v13, v1
    const/4 v14, 4
    const/4 v15, 0
    invoke-static/range v7 ... v15, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;
    iput v6, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$getVoiceChatHistory$1;->label I
    move-object/from16 v1, v17
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->getVoiceChatHistory(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v4, +003h
    return-object v4
    move-object v10, v1
    check-cast v10, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v1, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v11, 0
    const/16 v12, 46
    const/4 v13, 0
    move-object v4, v1
    invoke-direct/range v4 ... v13, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +26h
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1000
    const-string v6, ""
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +15h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1001
    const-string v6, ""
    move-object v7, v0
    check-cast v7, Ljava/lang/Throwable;
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v1
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    :try_start_0x2e
    :try_start_0x50
.end method

.method public final startVoiceChat(java.lang.String  java.lang.String  java.lang.String  boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 33
    # ins_size=11
    move-object/from16 v0, v32
    instance-of v1, v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->label I
    move-object/from16 v2, v22
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;
    move-object/from16 v2, v22
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->label I
    const/4 v5, 1
    if-eqz v4, +015h
    if-ne v4, v5, +00bh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +60h
    move-exception v0
    goto +69h
    move-exception v0
    goto/16 +085h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 12
    const/4 v12, 0
    move-object/from16 v7, v23
    move-object/from16 v8, v25
    invoke-static/range v6 ... v12, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->buildHeaders$default(Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v18
    sget-object v13, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v14, voice_chat
    const-class v15, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;
    const/16 v16, 0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->getHOST()Ljava/lang/String;
    move-result-object v17
    const/16 v19, 0
    const/16 v20, 36
    const/16 v21, 0
    invoke-static/range v13 ... v21, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;
    new-instance v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;
    if-eqz v26, +004h
    move v8, v5
    goto +3h
    const/4 v6, 0
    move v8, v6
    const/4 v9, 0
    const/4 v15, 4
    const/16 v16, 0
    move-object v6, v4
    move-object/from16 v7, v25
    move-object/from16 v10, v27
    move-object/from16 v11, v28
    move-object/from16 v12, v29
    move-object/from16 v13, v30
    move-object/from16 v14, v31
    invoke-direct/range v6 ... v16, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;-><init>(Ljava/lang/String; Z Lcom/bytedance/trae/conversation/voice/network/AgentConfig; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput v5, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->label I
    invoke-interface v0, v4, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->startVoiceChat(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v3, 0
    invoke-direct v1, v0, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +3eh
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v3, -1000
    const-string v4, ""
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object/from16 v23, v1
    move/from16 v24, v3
    move-object/from16 v25, v4
    move-object/from16 v26, v0
    move-object/from16 v27, v5
    move/from16 v28, v6
    move-object/from16 v29, v7
    invoke-direct/range v23 ... v29, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +20h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v3, -1001
    const-string v4, ""
    check-cast v0, Ljava/lang/Throwable;
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object/from16 v23, v1
    move/from16 v24, v3
    move-object/from16 v25, v4
    move-object/from16 v26, v0
    move-object/from16 v27, v5
    move/from16 v28, v6
    move-object/from16 v29, v7
    invoke-direct/range v23 ... v29, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v1
    :try_start_0x2c
    :try_start_0x4f
.end method

.method public final stopVoiceChat(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 25
    # ins_size=9
    move-object/from16 v0, v23
    move-object/from16 v1, v24
    instance-of v2, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;
    if-eqz v2, +014h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v1, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;->label I
    move-object/from16 v3, v16
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;
    move-object/from16 v3, v16
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;->label I
    const/4 v6, 1
    if-eqz v5, +015h
    if-ne v5, v6, +00bh
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    move-exception v0
    goto +61h
    move-exception v0
    goto/16 +07eh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    move-object/from16 v5, v17
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    invoke-virtual v1, v5, v8, v7, v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->buildHeaders(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/util/Map;
    move-result-object v12
    sget-object v7, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v8, voice_chat
    const-class v9, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;
    const/4 v10, 0
    sget-object v1, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->getHOST()Ljava/lang/String;
    move-result-object v11
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v6
    goto +2h
    move v0, v1
    if-nez v0, +004h
    move v13, v6
    goto +2h
    move v13, v1
    const/4 v14, 4
    const/4 v15, 0
    invoke-static/range v7 ... v15, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;
    new-instance v1, Lcom/bytedance/trae/conversation/voice/network/StopVoiceChatRequest;
    move-object/from16 v5, v20
    move-object/from16 v7, v21
    move-object/from16 v8, v22
    invoke-direct v1, v5, v7, v8, Lcom/bytedance/trae/conversation/voice/network/StopVoiceChatRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iput v6, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$stopVoiceChat$1;->label I
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->stopVoiceChat(Lcom/bytedance/trae/conversation/voice/network/StopVoiceChatRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v4, +003h
    return-object v4
    check-cast v1, Lcom/bytedance/trae/network/response/BizResponse;
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +40h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v2, -1000
    const-string v4, ""
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object/from16 v17, v1
    move/from16 v18, v2
    move-object/from16 v19, v4
    move-object/from16 v20, v0
    move-object/from16 v21, v5
    move/from16 v22, v6
    move-object/from16 v23, v7
    invoke-direct/range v17 ... v23, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +21h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v2, -1001
    const-string v4, ""
    check-cast v0, Ljava/lang/Throwable;
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object/from16 v17, v1
    move/from16 v18, v2
    move-object/from16 v19, v4
    move-object/from16 v20, v0
    move-object/from16 v21, v5
    move/from16 v22, v6
    move-object/from16 v23, v7
    invoke-direct/range v17 ... v23, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    :try_start_0x2e
    :try_start_0x4e
.end method
