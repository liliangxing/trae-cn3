# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/database/ConversationDetailEntity;
.super Ljava/lang/Object;
.source "ConversationDetailEntity.kt"

.field private final content:Ljava/lang/String;
.field private final contentType:Ljava/lang/String;
.field private final conversationId:Ljava/lang/String;
.field private final createdAt:J
.field private final messageId:Ljava/lang/String;
.field private final messageIndex:I
.field private final role:Ljava/lang/String;
.field private final status:Ljava/lang/String;
.field private final updatedAt:J


.method public constructor <init>(java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  long)void
    .registers 13
    # ins_size=12
    const-string v0, "conversationId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "contentType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->conversationId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageId Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageIndex I
    iput-object v5, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->role Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->contentType Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->content Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->status Ljava/lang/String;
    iput-wide v9, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->createdAt J
    iput-wide v11, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->updatedAt J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.database.ConversationDetailEntity  java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  long  int  java.lang.Object)com.bytedance.trae.im.database.ConversationDetailEntity
    .registers 27
    # ins_size=14
    move-object v0, v13
    move/from16 v1, v25
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->conversationId Ljava/lang/String;
    goto +2h
    move-object v2, v14
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageId Ljava/lang/String;
    goto +2h
    move-object v3, v15
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageIndex I
    goto +3h
    move/from16 v4, v16
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->role Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->contentType Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->content Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->status Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v20
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-wide v9, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->createdAt J
    goto +3h
    move-wide/from16 v9, v21
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget-wide v11, v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->updatedAt J
    goto +3h
    move-wide/from16 v11, v23
    move-object v14, v2
    move-object v15, v3
    move/from16 v16, v4
    move-object/from16 v17, v5
    move-object/from16 v18, v6
    move-object/from16 v19, v7
    move-object/from16 v20, v8
    move-wide/from16 v21, v9
    move-wide/from16 v23, v11
    invoke-virtual/range v13 ... v24, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->copy(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J J)Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageIndex I
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->role Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->contentType Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component8()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->createdAt J
    return-wide v0
.end method

.method public final component9()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->updatedAt J
    return-wide v0
.end method

.method public final copy(java.lang.String  java.lang.String  int  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  long)com.bytedance.trae.im.database.ConversationDetailEntity
    .registers 25
    # ins_size=12
    const-string v0, "conversationId"
    move-object v2, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    move-object v3, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    move-object/from16 v5, v17
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "contentType"
    move-object/from16 v6, v18
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    move-object/from16 v7, v19
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    move-object v1, v0
    move/from16 v4, v16
    move-object/from16 v8, v20
    move-wide/from16 v9, v21
    move-wide/from16 v11, v23
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/im/database/ConversationDetailEntity;-><init>(Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->conversationId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageIndex I
    iget v3, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageIndex I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->role Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->role Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->contentType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->contentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->content Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->status Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->createdAt J
    iget-wide v5, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->createdAt J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->updatedAt J
    iget-wide v5, v8, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->updatedAt J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getContentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->contentType Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->createdAt J
    return-wide v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageIndex I
    return v0
.end method

.method public final getRole()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->role Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getUpdatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->updatedAt J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->conversationId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageIndex I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->role Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->contentType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->content Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->status Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->createdAt J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->updatedAt J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ConversationDetailEntity(conversationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageIndex="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->messageIndex I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", role="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->role Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", contentType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->contentType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", content="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->content Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", createdAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->createdAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", updatedAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/im/database/ConversationDetailEntity;->updatedAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
