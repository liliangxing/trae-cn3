# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final fastRequestEvent:Lcom/bytedance/trae/im/service/FastRequestEvent;
.field private final message:Ljava/lang/String;
.field private final noticeTitle:Ljava/lang/String;
.field private final originMessage:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field private final position:I
.field private final queueId:Ljava/lang/String;
.field private final requestUUid:Ljava/lang/String;


.method public constructor <init>(int  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.service.FastRequestEvent  java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=8
    const-string v0, "originMessage"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->position I
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->noticeTitle Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->message Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->queueId Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->requestUUid Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.service.FastRequestEvent  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 2
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v4, v1
    goto +2h
    move-object v4, v12
    and-int/lit8 v0, v18, 4
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v18, 16
    if-eqz v0, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v15
    and-int/lit8 v0, v18, 32
    if-eqz v0, +004h
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v16
    and-int/lit8 v0, v18, 64
    if-eqz v0, +004h
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v17
    move-object v2, v10
    move v3, v11
    move-object v6, v14
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing  int  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.service.FastRequestEvent  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget v6, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->position I
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->noticeTitle Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->message Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->queueId Ljava/lang/String;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->requestUUid Ljava/lang/String;
    move-object v4, v12
    move-object v7, v5
    move v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->copy(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    move-result-object v5
    return-object v5
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->position I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->noticeTitle Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.im.model.ParsedChatMessage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.im.service.FastRequestEvent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->queueId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->requestUUid Ljava/lang/String;
    return-object v0
.end method

.method public final copy(int  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.service.FastRequestEvent  java.lang.String  java.lang.String)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Queuing
    .registers 17
    # ins_size=8
    const-string v0, "originMessage"
    move-object v5, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    move-object v1, v0
    move v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v6, v14
    move-object v7, v15
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;-><init>(I Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->position I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->position I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->noticeTitle Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->noticeTitle Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->queueId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->queueId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->requestUUid Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->requestUUid Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getFastRequestEvent()com.bytedance.trae.im.service.FastRequestEvent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->message Ljava/lang/String;
    return-object v0
.end method

.method public final getNoticeTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->noticeTitle Ljava/lang/String;
    return-object v0
.end method

.method public final getOriginMessage()com.bytedance.trae.im.model.ParsedChatMessage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    return-object v0
.end method

.method public final getPosition()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->position I
    return v0
.end method

.method public final getQueueId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->queueId Ljava/lang/String;
    return-object v0
.end method

.method public final getRequestUUid()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->requestUUid Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->position I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->noticeTitle Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->message Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/FastRequestEvent;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->queueId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->requestUUid Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Queuing(position="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->position I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", noticeTitle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->noticeTitle Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", originMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->originMessage Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fastRequestEvent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", queueId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->queueId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", requestUUid="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;->requestUUid Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
