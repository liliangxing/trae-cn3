# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
.super Lcom/bytedance/trae/im/service/ChatEventPayload;
.source "IMEvent.kt"

.field private final agentDisplayName:Ljava/lang/String;
.field private final agentId:Ljava/lang/String;
.field private final agentRunId:Ljava/lang/String;
.field private final confirmInfo:Lcom/google/gson/JsonObject;
.field private final hide:Ljava/lang/Boolean;
.field private final id:Ljava/lang/String;
.field private final planType:Ljava/lang/String;
.field private final reasoningContent:Ljava/lang/String;
.field private final replyToMessageId:Ljava/lang/String;
.field private final subAgentCallDescription:Ljava/lang/String;
.field private final taskId:Ljava/lang/String;
.field private final thought:Ljava/lang/String;
.field private final toolCallInfo:Lcom/bytedance/trae/im/service/ToolCallInfo;


.method public constructor <init>()void
    .registers 17
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
    const/4 v13, 0
    const/16 v14, 8191
    const/4 v15, 0
    move-object/from16 v0, v16
    invoke-direct/range v0 ... v15, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ToolCallInfo; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ToolCallInfo  com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String)void
    .registers 15
    # ins_size=14
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->id Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->taskId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->thought Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->reasoningContent Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->toolCallInfo Lcom/bytedance/trae/im/service/ToolCallInfo;
    iput-object v7, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->confirmInfo Lcom/google/gson/JsonObject;
    iput-object v8, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentId Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentDisplayName Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentRunId Ljava/lang/String;
    iput-object v11, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->subAgentCallDescription Ljava/lang/String;
    iput-object v12, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->planType Ljava/lang/String;
    iput-object v13, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->hide Ljava/lang/Boolean;
    iput-object v14, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->replyToMessageId Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ToolCallInfo  com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 30
    # ins_size=16
    move/from16 v0, v28
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v15
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +3h
    move-object/from16 v3, v16
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +3h
    move-object/from16 v4, v17
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v19
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v20
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v21
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v22
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v23
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v24
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v25
    and-int/lit16 v13, v0, 2048
    if-eqz v13, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v26
    and-int/lit16 v0, v0, 4096
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v27
    move-object v15, v14
    move-object/from16 v16, v1
    move-object/from16 v17, v3
    move-object/from16 v18, v4
    move-object/from16 v19, v5
    move-object/from16 v20, v6
    move-object/from16 v21, v7
    move-object/from16 v22, v8
    move-object/from16 v23, v9
    move-object/from16 v24, v10
    move-object/from16 v25, v11
    move-object/from16 v26, v12
    move-object/from16 v27, v13
    move-object/from16 v28, v2
    invoke-direct/range v15 ... v28, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ToolCallInfo; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ChatEventPayload$PlanItem  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ToolCallInfo  com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.ChatEventPayload$PlanItem
    .registers 30
    # ins_size=16
    move-object v0, v14
    move/from16 v1, v28
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->id Ljava/lang/String;
    goto +2h
    move-object v2, v15
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->taskId Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v16
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->thought Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v17
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->reasoningContent Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->toolCallInfo Lcom/bytedance/trae/im/service/ToolCallInfo;
    goto +3h
    move-object/from16 v6, v19
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->confirmInfo Lcom/google/gson/JsonObject;
    goto +3h
    move-object/from16 v7, v20
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v21
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentDisplayName Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v22
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentRunId Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v23
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->subAgentCallDescription Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v24
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->planType Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v25
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->hide Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v13, v26
    and-int/lit16 v1, v1, 4096
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->replyToMessageId Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v27
    move-object v15, v2
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
    move-object/from16 v26, v13
    move-object/from16 v27, v1
    invoke-virtual/range v14 ... v27, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ToolCallInfo; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->subAgentCallDescription Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->planType Ljava/lang/String;
    return-object v0
.end method

.method public final component12()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->hide Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component13()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->thought Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->reasoningContent Ljava/lang/String;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.im.service.ToolCallInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->toolCallInfo Lcom/bytedance/trae/im/service/ToolCallInfo;
    return-object v0
.end method

.method public final component6()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->confirmInfo Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentRunId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ToolCallInfo  com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String)com.bytedance.trae.im.service.ChatEventPayload$PlanItem
    .registers 29
    # ins_size=14
    new-instance v14, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    move-object v0, v14
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    move-object/from16 v3, v18
    move-object/from16 v4, v19
    move-object/from16 v5, v20
    move-object/from16 v6, v21
    move-object/from16 v7, v22
    move-object/from16 v8, v23
    move-object/from16 v9, v24
    move-object/from16 v10, v25
    move-object/from16 v11, v26
    move-object/from16 v12, v27
    move-object/from16 v13, v28
    invoke-direct/range v0 ... v13, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ToolCallInfo; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String;)V
    return-object v14
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->taskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->thought Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->thought Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->reasoningContent Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->reasoningContent Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->toolCallInfo Lcom/bytedance/trae/im/service/ToolCallInfo;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->toolCallInfo Lcom/bytedance/trae/im/service/ToolCallInfo;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->confirmInfo Lcom/google/gson/JsonObject;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->confirmInfo Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentDisplayName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentDisplayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentRunId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentRunId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->subAgentCallDescription Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->subAgentCallDescription Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->planType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->planType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->hide Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->hide Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->replyToMessageId Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->replyToMessageId Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAgentDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentDisplayName Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentRunId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentRunId Ljava/lang/String;
    return-object v0
.end method

.method public final getConfirmInfo()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->confirmInfo Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getHide()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->hide Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getPlanType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->planType Ljava/lang/String;
    return-object v0
.end method

.method public final getReasoningContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->reasoningContent Ljava/lang/String;
    return-object v0
.end method

.method public final getReplyToMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final getSubAgentCallDescription()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->subAgentCallDescription Ljava/lang/String;
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final getThought()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->thought Ljava/lang/String;
    return-object v0
.end method

.method public final getToolCallInfo()com.bytedance.trae.im.service.ToolCallInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->toolCallInfo Lcom/bytedance/trae/im/service/ToolCallInfo;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->id Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->taskId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->thought Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->reasoningContent Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->toolCallInfo Lcom/bytedance/trae/im/service/ToolCallInfo;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->confirmInfo Lcom/google/gson/JsonObject;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentDisplayName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentRunId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->subAgentCallDescription Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->planType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->hide Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->replyToMessageId Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PlanItem(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", taskId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->taskId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", thought="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->thought Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", reasoningContent="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->reasoningContent Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", toolCallInfo="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->toolCallInfo Lcom/bytedance/trae/im/service/ToolCallInfo;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", confirmInfo="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->confirmInfo Lcom/google/gson/JsonObject;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentDisplayName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentDisplayName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentRunId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->agentRunId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", subAgentCallDescription="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->subAgentCallDescription Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", planType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->planType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hide="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->hide Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", replyToMessageId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;->replyToMessageId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
