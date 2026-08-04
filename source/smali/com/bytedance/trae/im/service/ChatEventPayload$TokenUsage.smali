# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
.super Lcom/bytedance/trae/im/service/ChatEventPayload;
.source "IMEvent.kt"

.field private final cacheCreationInputTokens:Ljava/lang/Integer;
.field private final cacheReadInputTokens:Ljava/lang/Integer;
.field private final completionTokens:Ljava/lang/Integer;
.field private final completionTokensTotal:Ljava/lang/Integer;
.field private final lastTurnTotalTokens:Ljava/lang/Integer;
.field private final promptTokens:Ljava/lang/Integer;
.field private final promptTokensTotal:Ljava/lang/Integer;
.field private final reasoningTokens:Ljava/lang/Integer;
.field private final totalTokens:Ljava/lang/Integer;


.method public constructor <init>()void
    .registers 13
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
    const/16 v10, 511
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer)void
    .registers 11
    # ins_size=10
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokens Ljava/lang/Integer;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokens Ljava/lang/Integer;
    iput-object v4, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->reasoningTokens Ljava/lang/Integer;
    iput-object v5, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->totalTokens Ljava/lang/Integer;
    iput-object v6, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheCreationInputTokens Ljava/lang/Integer;
    iput-object v7, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheReadInputTokens Ljava/lang/Integer;
    iput-object v8, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokensTotal Ljava/lang/Integer;
    iput-object v9, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokensTotal Ljava/lang/Integer;
    iput-object v10, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->lastTurnTotalTokens Ljava/lang/Integer;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=12
    move/from16 v0, v20
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v11
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v0, v0, 256
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v19
    move-object v11, v10
    move-object v12, v1
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-object/from16 v16, v6
    move-object/from16 v17, v7
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v20, v2
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ChatEventPayload$TokenUsage  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.im.service.ChatEventPayload$TokenUsage
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokens Ljava/lang/Integer;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokens Ljava/lang/Integer;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->reasoningTokens Ljava/lang/Integer;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->totalTokens Ljava/lang/Integer;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheCreationInputTokens Ljava/lang/Integer;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheReadInputTokens Ljava/lang/Integer;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokensTotal Ljava/lang/Integer;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokensTotal Ljava/lang/Integer;
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->lastTurnTotalTokens Ljava/lang/Integer;
    goto +3h
    move-object/from16 v1, v19
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v9
    move-object/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->copy(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer;)Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component3()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->reasoningTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component4()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->totalTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component5()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheCreationInputTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component6()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheReadInputTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component7()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokensTotal Ljava/lang/Integer;
    return-object v0
.end method

.method public final component8()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokensTotal Ljava/lang/Integer;
    return-object v0
.end method

.method public final component9()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->lastTurnTotalTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer  java.lang.Integer)com.bytedance.trae.im.service.ChatEventPayload$TokenUsage
    .registers 21
    # ins_size=10
    new-instance v10, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    move-object v0, v10
    move-object v1, v12
    move-object v2, v13
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    move-object/from16 v7, v18
    move-object/from16 v8, v19
    move-object/from16 v9, v20
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer;)V
    return-object v10
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->reasoningTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->reasoningTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->totalTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->totalTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheCreationInputTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheCreationInputTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheReadInputTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheReadInputTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokensTotal Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokensTotal Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokensTotal Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokensTotal Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->lastTurnTotalTokens Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->lastTurnTotalTokens Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCacheCreationInputTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheCreationInputTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getCacheReadInputTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheReadInputTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getCompletionTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getCompletionTokensTotal()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokensTotal Ljava/lang/Integer;
    return-object v0
.end method

.method public final getLastTurnTotalTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->lastTurnTotalTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getPromptTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getPromptTokensTotal()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokensTotal Ljava/lang/Integer;
    return-object v0
.end method

.method public final getReasoningTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->reasoningTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getTotalTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->totalTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokens Ljava/lang/Integer;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokens Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->reasoningTokens Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->totalTokens Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheCreationInputTokens Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheReadInputTokens Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokensTotal Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokensTotal Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->lastTurnTotalTokens Ljava/lang/Integer;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TokenUsage(completionTokens="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokens Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", promptTokens="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokens Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", reasoningTokens="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->reasoningTokens Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", totalTokens="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->totalTokens Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cacheCreationInputTokens="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheCreationInputTokens Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cacheReadInputTokens="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->cacheReadInputTokens Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", promptTokensTotal="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->promptTokensTotal Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", completionTokensTotal="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->completionTokensTotal Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lastTurnTotalTokens="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;->lastTurnTotalTokens Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
