# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/InitialMessage;
.super Ljava/lang/Object;
.source "ICreateAgentTask.kt"

.field private final agentType:Ljava/lang/String;
.field private final chatSessionId:Ljava/lang/String;
.field private final commonParams:Ljava/lang/String;
.field private final content:Ljava/util/List;
.field private final customModel:Lcom/google/gson/JsonObject;
.field private final modelName:Ljava/lang/String;
.field private final modelSelectionStrategy:Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
.field private final query:Ljava/lang/String;
.field private final useFastRequest:Ljava/lang/Boolean;


.method public constructor <init>(java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ModelSelectionStrategy  com.google.gson.JsonObject  java.lang.String  java.lang.Boolean)void
    .registers 11
    # ins_size=10
    const-string v0, "content"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/InitialMessage;->content Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/InitialMessage;->chatSessionId Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/im/service/InitialMessage;->modelName Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/im/service/InitialMessage;->agentType Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/im/service/InitialMessage;->query Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/im/service/InitialMessage;->modelSelectionStrategy Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    iput-object v8, v1, Lcom/bytedance/trae/im/service/InitialMessage;->customModel Lcom/google/gson/JsonObject;
    iput-object v9, v1, Lcom/bytedance/trae/im/service/InitialMessage;->commonParams Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/im/service/InitialMessage;->useFastRequest Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ModelSelectionStrategy  com.google.gson.JsonObject  java.lang.String  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 21
    # ins_size=12
    move/from16 v0, v19
    and-int/lit8 v1, v0, 2
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v11
    and-int/lit8 v3, v0, 4
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v0, 8
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v0, 16
    if-eqz v5, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v0, 32
    if-eqz v6, +004h
    move-object v6, v2
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v0, 64
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v16
    and-int/lit16 v8, v0, 128
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v0, v0, 256
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v18
    move-object v11, v9
    move-object v12, v10
    move-object v13, v1
    move-object v14, v3
    move-object v15, v4
    move-object/from16 v16, v5
    move-object/from16 v17, v6
    move-object/from16 v18, v7
    move-object/from16 v19, v8
    move-object/from16 v20, v2
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/im/service/InitialMessage;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ModelSelectionStrategy; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.InitialMessage  java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ModelSelectionStrategy  com.google.gson.JsonObject  java.lang.String  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.im.service.InitialMessage
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/InitialMessage;->content Ljava/util/List;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/InitialMessage;->chatSessionId Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/InitialMessage;->modelName Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/InitialMessage;->agentType Ljava/lang/String;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/InitialMessage;->query Ljava/lang/String;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/InitialMessage;->modelSelectionStrategy Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/InitialMessage;->customModel Lcom/google/gson/JsonObject;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/InitialMessage;->commonParams Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/InitialMessage;->useFastRequest Ljava/lang/Boolean;
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
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/im/service/InitialMessage;->copy(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ModelSelectionStrategy; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/InitialMessage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->content Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->modelName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->query Ljava/lang/String;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.im.service.ModelSelectionStrategy
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->modelSelectionStrategy Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    return-object v0
.end method

.method public final component7()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->customModel Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->commonParams Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->useFastRequest Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ModelSelectionStrategy  com.google.gson.JsonObject  java.lang.String  java.lang.Boolean)com.bytedance.trae.im.service.InitialMessage
    .registers 21
    # ins_size=10
    const-string v0, "content"
    move-object v2, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/InitialMessage;
    move-object v1, v0
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    move-object/from16 v9, v19
    move-object/from16 v10, v20
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/im/service/InitialMessage;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ModelSelectionStrategy; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/Boolean;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/InitialMessage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/InitialMessage;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->content Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/InitialMessage;->content Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->chatSessionId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/InitialMessage;->chatSessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->modelName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/InitialMessage;->modelName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->agentType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/InitialMessage;->agentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->query Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/InitialMessage;->query Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->modelSelectionStrategy Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/InitialMessage;->modelSelectionStrategy Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->customModel Lcom/google/gson/JsonObject;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/InitialMessage;->customModel Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->commonParams Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/InitialMessage;->commonParams Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/InitialMessage;->useFastRequest Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/InitialMessage;->useFastRequest Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getCommonParams()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->commonParams Ljava/lang/String;
    return-object v0
.end method

.method public final getContent()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->content Ljava/util/List;
    return-object v0
.end method

.method public final getCustomModel()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->customModel Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getModelName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->modelName Ljava/lang/String;
    return-object v0
.end method

.method public final getModelSelectionStrategy()com.bytedance.trae.im.service.ModelSelectionStrategy
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->modelSelectionStrategy Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    return-object v0
.end method

.method public final getQuery()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->query Ljava/lang/String;
    return-object v0
.end method

.method public final getUseFastRequest()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/InitialMessage;->useFastRequest Ljava/lang/Boolean;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/InitialMessage;->content Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/InitialMessage;->chatSessionId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/InitialMessage;->modelName Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/InitialMessage;->agentType Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/InitialMessage;->query Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/InitialMessage;->modelSelectionStrategy Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ModelSelectionStrategy;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/InitialMessage;->customModel Lcom/google/gson/JsonObject;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/InitialMessage;->commonParams Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/InitialMessage;->useFastRequest Ljava/lang/Boolean;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "InitialMessage(content="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->content Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", chatSessionId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->chatSessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", modelName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->modelName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", agentType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->agentType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", query="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->query Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", modelSelectionStrategy="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->modelSelectionStrategy Lcom/bytedance/trae/im/service/ModelSelectionStrategy;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", customModel="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->customModel Lcom/google/gson/JsonObject;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", commonParams="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->commonParams Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", useFastRequest="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/InitialMessage;->useFastRequest Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
