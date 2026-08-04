# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/database/ChatMessageEntity;
.super Ljava/lang/Object;
.source "ChatMessageDao.kt"

.field private final content:Ljava/lang/String;
.field private final createdAt:J
.field private final id:J
.field private final messageId:Ljava/lang/String;
.field private final messageIndex:I
.field private final messageType:Ljava/lang/String;
.field private final status:I
.field private final taskId:Ljava/lang/String;
.field private final updatedAt:J


.method public constructor <init>(long  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  int  long  long)void
    .registers 14
    # ins_size=13
    const-string/jumbo v0, taskId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->id J
    iput-object v4, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->taskId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageId Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageType Ljava/lang/String;
    iput v7, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageIndex I
    iput-object v8, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->content Ljava/lang/String;
    iput v9, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->status I
    iput-wide v10, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->createdAt J
    iput-wide v12, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->updatedAt J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.database.ChatMessageEntity  long  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  int  long  long  int  java.lang.Object)com.bytedance.trae.im.database.ChatMessageEntity
    .registers 29
    # ins_size=15
    move-object v0, v14
    move/from16 v1, v27
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->id J
    goto +2h
    move-wide v2, v15
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->taskId Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v17
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageId Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v6, v1, 8
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageType Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v19
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget v7, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageIndex I
    goto +3h
    move/from16 v7, v20
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->content Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v21
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->status I
    goto +3h
    move/from16 v9, v22
    and-int/lit16 v10, v1, 128
    if-eqz v10, +005h
    iget-wide v10, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->createdAt J
    goto +3h
    move-wide/from16 v10, v23
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-wide v12, v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;->updatedAt J
    goto +3h
    move-wide/from16 v12, v25
    move-wide v15, v2
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    move-object/from16 v19, v6
    move/from16 v20, v7
    move-object/from16 v21, v8
    move/from16 v22, v9
    move-wide/from16 v23, v10
    move-wide/from16 v25, v12
    invoke-virtual/range v14 ... v26, Lcom/bytedance/trae/im/database/ChatMessageEntity;->copy(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I J J)Lcom/bytedance/trae/im/database/ChatMessageEntity;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ChatMessageEntity;->id J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageType Ljava/lang/String;
    return-object v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageIndex I
    return v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component7()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->status I
    return v0
.end method

.method public final component8()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ChatMessageEntity;->createdAt J
    return-wide v0
.end method

.method public final component9()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ChatMessageEntity;->updatedAt J
    return-wide v0
.end method

.method public final copy(long  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  int  long  long)com.bytedance.trae.im.database.ChatMessageEntity
    .registers 27
    # ins_size=13
    const-string/jumbo v0, taskId
    move-object/from16 v4, v17
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    move-object/from16 v5, v18
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageType"
    move-object/from16 v6, v19
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    move-object/from16 v8, v21
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/database/ChatMessageEntity;
    move-object v1, v0
    move-wide v2, v15
    move/from16 v7, v20
    move/from16 v9, v22
    move-wide/from16 v10, v23
    move-wide/from16 v12, v25
    invoke-direct/range v1 ... v13, Lcom/bytedance/trae/im/database/ChatMessageEntity;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; I J J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;
    iget-wide v3, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->id J
    iget-wide v5, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->id J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->taskId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageIndex I
    iget v3, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageIndex I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->content Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->status I
    iget v3, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->status I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->createdAt J
    iget-wide v5, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->createdAt J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/database/ChatMessageEntity;->updatedAt J
    iget-wide v5, v8, Lcom/bytedance/trae/im/database/ChatMessageEntity;->updatedAt J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ChatMessageEntity;->createdAt J
    return-wide v0
.end method

.method public final getId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ChatMessageEntity;->id J
    return-wide v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageIndex I
    return v0
.end method

.method public final getMessageType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageType Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->status I
    return v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ChatMessageEntity;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final getUpdatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ChatMessageEntity;->updatedAt J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->id J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->taskId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageIndex I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->content Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->status I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->createdAt J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->updatedAt J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ChatMessageEntity(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->id J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageIndex="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->messageIndex I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", content="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->content Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->status I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", createdAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->createdAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", updatedAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ChatMessageEntity;->updatedAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
