# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
.super Lcom/bytedance/trae/im/service/ChatEventPayload;
.source "IMEvent.kt"

.field private final fastRequestEvent:Lcom/bytedance/trae/im/service/FastRequestEvent;
.field private final message:Ljava/lang/String;
.field private final position:Ljava/lang/Integer;
.field private final queueId:Ljava/lang/String;
.field private final queuePosition:Ljava/lang/Integer;
.field private final queueStatus:Ljava/lang/String;
.field private final requestUUId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 11
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 127
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Integer  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.FastRequestEvent)void
    .registers 9
    # ins_size=8
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->position Ljava/lang/Integer;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queuePosition Ljava/lang/Integer;
    iput-object v4, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->message Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueStatus Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueId Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->requestUUId Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Integer  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.FastRequestEvent  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=10
    and-int/lit8 v15, v14, 1
    const/4 v0, 0
    if-eqz v15, +004h
    move-object v15, v0
    goto +2h
    move-object v15, v7
    and-int/lit8 v7, v14, 2
    if-eqz v7, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v8
    and-int/lit8 v7, v14, 4
    if-eqz v7, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v9
    and-int/lit8 v7, v14, 8
    if-eqz v7, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v10
    and-int/lit8 v7, v14, 16
    if-eqz v7, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v11
    and-int/lit8 v7, v14, 32
    if-eqz v7, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v12
    and-int/lit8 v7, v14, 64
    if-eqz v7, +004h
    move-object v14, v0
    goto +2h
    move-object v14, v13
    move-object v7, v6
    move-object v8, v15
    move-object v9, v1
    move-object v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    invoke-direct/range v7 ... v14, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ChatEventPayload$Queuing  java.lang.Integer  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.FastRequestEvent  int  java.lang.Object)com.bytedance.trae.im.service.ChatEventPayload$Queuing
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->position Ljava/lang/Integer;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queuePosition Ljava/lang/Integer;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->message Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueStatus Ljava/lang/String;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueId Ljava/lang/String;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->requestUUId Ljava/lang/String;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->copy(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent;)Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->position Ljava/lang/Integer;
    return-object v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queuePosition Ljava/lang/Integer;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->requestUUId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()com.bytedance.trae.im.service.FastRequestEvent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-object v0
.end method

.method public final copy(java.lang.Integer  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.FastRequestEvent)com.bytedance.trae.im.service.ChatEventPayload$Queuing
    .registers 17
    # ins_size=8
    new-instance v8, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    move-object v0, v8
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent;)V
    return-object v8
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->position Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->position Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queuePosition Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queuePosition Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueStatus Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->requestUUId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->requestUUId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getFastRequestEvent()com.bytedance.trae.im.service.FastRequestEvent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getPosition()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->position Ljava/lang/Integer;
    return-object v0
.end method

.method public final getQueueId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueId Ljava/lang/String;
    return-object v0
.end method

.method public final getQueuePosition()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queuePosition Ljava/lang/Integer;
    return-object v0
.end method

.method public final getQueueStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getRequestUUId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->requestUUId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->position Ljava/lang/Integer;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queuePosition Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->message Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueStatus Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->requestUUId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/FastRequestEvent;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Queuing(position="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->position Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", queuePosition="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queuePosition Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", queueStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueStatus Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", queueId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->queueId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", requestUUId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->requestUUId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fastRequestEvent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
