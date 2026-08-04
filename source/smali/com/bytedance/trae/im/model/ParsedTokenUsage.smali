# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/ParsedTokenUsage;
.super Ljava/lang/Object;
.source "ParsedChatMessage.kt"

.field private final cacheCreationInputTokens:Ljava/lang/Long;
.field private final cacheReadInputTokens:Ljava/lang/Long;
.field private final completionTokens:Ljava/lang/Long;
.field private final completionTokensTotal:Ljava/lang/Long;
.field private final input:Ljava/lang/String;
.field private final lastTurnTotalTokens:Ljava/lang/Long;
.field private final maxTokens:Ljava/lang/Long;
.field private final output:Ljava/lang/String;
.field private final promptTokens:Ljava/lang/Long;
.field private final promptTokensTotal:Ljava/lang/Long;
.field private final reasoningTokens:Ljava/lang/Long;
.field private final totalTokens:Ljava/lang/Long;


.method public constructor <init>()void
    .registers 16
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 4095
    const/4 v14, 0
    move-object v0, v15
    invoke-direct/range v0 ... v14, Lcom/bytedance/trae/im/model/ParsedTokenUsage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->input Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->output Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->lastTurnTotalTokens Ljava/lang/Long;
    iput-object v4, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->maxTokens Ljava/lang/Long;
    iput-object v5, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokens Ljava/lang/Long;
    iput-object v6, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokens Ljava/lang/Long;
    iput-object v7, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->reasoningTokens Ljava/lang/Long;
    iput-object v8, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->totalTokens Ljava/lang/Long;
    iput-object v9, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheCreationInputTokens Ljava/lang/Long;
    iput-object v10, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheReadInputTokens Ljava/lang/Long;
    iput-object v11, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokensTotal Ljava/lang/Long;
    iput-object v12, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokensTotal Ljava/lang/Long;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 28
    # ins_size=15
    move/from16 v0, v26
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v14
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v15
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +3h
    move-object/from16 v4, v16
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v20
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v21
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v23
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v0, v0, 2048
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v25
    move-object v14, v13
    move-object v15, v1
    move-object/from16 v16, v3
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    move-object/from16 v19, v6
    move-object/from16 v20, v7
    move-object/from16 v21, v8
    move-object/from16 v22, v9
    move-object/from16 v23, v10
    move-object/from16 v24, v11
    move-object/from16 v25, v12
    move-object/from16 v26, v2
    invoke-direct/range v14 ... v26, Lcom/bytedance/trae/im/model/ParsedTokenUsage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.model.ParsedTokenUsage  java.lang.String  java.lang.String  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  int  java.lang.Object)com.bytedance.trae.im.model.ParsedTokenUsage
    .registers 28
    # ins_size=15
    move-object v0, v13
    move/from16 v1, v26
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->input Ljava/lang/String;
    goto +2h
    move-object v2, v14
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->output Ljava/lang/String;
    goto +2h
    move-object v3, v15
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->lastTurnTotalTokens Ljava/lang/Long;
    goto +3h
    move-object/from16 v4, v16
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->maxTokens Ljava/lang/Long;
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokens Ljava/lang/Long;
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokens Ljava/lang/Long;
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->reasoningTokens Ljava/lang/Long;
    goto +3h
    move-object/from16 v8, v20
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->totalTokens Ljava/lang/Long;
    goto +3h
    move-object/from16 v9, v21
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheCreationInputTokens Ljava/lang/Long;
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheReadInputTokens Ljava/lang/Long;
    goto +3h
    move-object/from16 v11, v23
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokensTotal Ljava/lang/Long;
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v1, v1, 2048
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokensTotal Ljava/lang/Long;
    goto +3h
    move-object/from16 v1, v25
    move-object v14, v2
    move-object v15, v3
    move-object/from16 v16, v4
    move-object/from16 v17, v5
    move-object/from16 v18, v6
    move-object/from16 v19, v7
    move-object/from16 v20, v8
    move-object/from16 v21, v9
    move-object/from16 v22, v10
    move-object/from16 v23, v11
    move-object/from16 v24, v12
    move-object/from16 v25, v1
    invoke-virtual/range v13 ... v25, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long;)Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->input Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheReadInputTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final component11()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokensTotal Ljava/lang/Long;
    return-object v0
.end method

.method public final component12()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokensTotal Ljava/lang/Long;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->output Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->lastTurnTotalTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final component4()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->maxTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final component6()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final component7()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->reasoningTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final component8()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->totalTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final component9()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheCreationInputTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long)com.bytedance.trae.im.model.ParsedTokenUsage
    .registers 27
    # ins_size=13
    new-instance v13, Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    move-object v0, v13
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v7, v21
    move-object/from16 v8, v22
    move-object/from16 v9, v23
    move-object/from16 v10, v24
    move-object/from16 v11, v25
    move-object/from16 v12, v26
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/im/model/ParsedTokenUsage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long;)V
    return-object v13
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->input Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->input Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->output Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->output Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->lastTurnTotalTokens Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->lastTurnTotalTokens Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->maxTokens Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->maxTokens Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokens Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokens Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokens Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokens Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->reasoningTokens Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->reasoningTokens Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->totalTokens Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->totalTokens Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheCreationInputTokens Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheCreationInputTokens Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheReadInputTokens Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheReadInputTokens Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokensTotal Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokensTotal Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokensTotal Ljava/lang/Long;
    iget-object v5, v5, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokensTotal Ljava/lang/Long;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCacheCreationInputTokens()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheCreationInputTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final getCacheReadInputTokens()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheReadInputTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final getCompletionTokens()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final getCompletionTokensTotal()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokensTotal Ljava/lang/Long;
    return-object v0
.end method

.method public final getInput()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->input Ljava/lang/String;
    return-object v0
.end method

.method public final getLastTurnTotalTokens()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->lastTurnTotalTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final getMaxTokens()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->maxTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final getOutput()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->output Ljava/lang/String;
    return-object v0
.end method

.method public final getPromptTokens()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final getPromptTokensTotal()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokensTotal Ljava/lang/Long;
    return-object v0
.end method

.method public final getReasoningTokens()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->reasoningTokens Ljava/lang/Long;
    return-object v0
.end method

.method public final getTotalTokens()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->totalTokens Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->input Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->output Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->lastTurnTotalTokens Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->maxTokens Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokens Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokens Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->reasoningTokens Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->totalTokens Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheCreationInputTokens Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheReadInputTokens Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokensTotal Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokensTotal Ljava/lang/Long;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ParsedTokenUsage(input="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->input Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", output="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->output Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", lastTurnTotalTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->lastTurnTotalTokens Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", maxTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->maxTokens Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", completionTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokens Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", promptTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokens Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", reasoningTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->reasoningTokens Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", totalTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->totalTokens Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cacheCreationInputTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheCreationInputTokens Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cacheReadInputTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->cacheReadInputTokens Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", promptTokensTotal="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->promptTokensTotal Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", completionTokensTotal="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->completionTokensTotal Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
