# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
.super Ljava/lang/Object;
.source "ConversationStateMessage.kt"

.field private final errorInfo:Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
.field private final eventTime:J
.field private final roundID:J
.field private final stage:Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
.field private final taskId:Ljava/lang/String;
.field private final userID:Ljava/lang/String;


.method public constructor <init>()void
    .registers 12
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const-wide/16 v3, 0
    const-wide/16 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 63
    const/4 v10, 0
    move-object v0, v11
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;-><init>(Ljava/lang/String; Ljava/lang/String; J J Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage; Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  long  long  com.bytedance.trae.conversation.voice.ConversationStateMessage$Stage  com.bytedance.trae.conversation.voice.ConversationStateMessage$ErrorDetail)void
    .registers 10
    # ins_size=9
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userID
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, stage
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->taskId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->userID Ljava/lang/String;
    iput-wide v4, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->roundID J
    iput-wide v6, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->eventTime J
    iput-object v8, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->stage Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->errorInfo Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  long  long  com.bytedance.trae.conversation.voice.ConversationStateMessage$Stage  com.bytedance.trae.conversation.voice.ConversationStateMessage$ErrorDetail  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 21
    # ins_size=11
    and-int/lit8 v0, v19, 1
    const-string v1, ""
    if-eqz v0, +004h
    move-object v0, v1
    goto +2h
    move-object v0, v11
    and-int/lit8 v2, v19, 2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v12
    and-int/lit8 v2, v19, 4
    const-wide/16 v3, 0
    if-eqz v2, +004h
    move-wide v5, v3
    goto +2h
    move-wide v5, v13
    and-int/lit8 v2, v19, 8
    if-eqz v2, +003h
    goto +2h
    move-wide v3, v15
    and-int/lit8 v2, v19, 16
    const/4 v7, 0
    if-eqz v2, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    const/4 v8, 0
    const/4 v9, 3
    invoke-direct v2, v8, v7, v9, v7, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;-><init>(I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +3h
    move-object/from16 v2, v17
    and-int/lit8 v8, v19, 32
    if-eqz v8, +003h
    goto +3h
    move-object/from16 v7, v18
    move-object v11, v10
    move-object v12, v0
    move-object v13, v1
    move-wide v14, v5
    move-wide/from16 v16, v3
    move-object/from16 v18, v2
    move-object/from16 v19, v7
    invoke-direct/range v11 ... v19, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;-><init>(Ljava/lang/String; Ljava/lang/String; J J Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage; Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.ConversationStateMessage  java.lang.String  java.lang.String  long  long  com.bytedance.trae.conversation.voice.ConversationStateMessage$Stage  com.bytedance.trae.conversation.voice.ConversationStateMessage$ErrorDetail  int  java.lang.Object)com.bytedance.trae.conversation.voice.ConversationStateMessage
    .registers 20
    # ins_size=11
    move-object v0, v9
    and-int/lit8 v1, v18, 1
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->taskId Ljava/lang/String;
    goto +2h
    move-object v1, v10
    and-int/lit8 v2, v18, 2
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->userID Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v18, 4
    if-eqz v3, +005h
    iget-wide v3, v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->roundID J
    goto +2h
    move-wide v3, v12
    and-int/lit8 v5, v18, 8
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->eventTime J
    goto +2h
    move-wide v5, v14
    and-int/lit8 v7, v18, 16
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->stage Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v18, 32
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->errorInfo Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    goto +3h
    move-object/from16 v8, v17
    move-object v10, v1
    move-object v11, v2
    move-wide v12, v3
    move-wide v14, v5
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->copy(Ljava/lang/String; Ljava/lang/String; J J Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage; Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;)Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->userID Ljava/lang/String;
    return-object v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->roundID J
    return-wide v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->eventTime J
    return-wide v0
.end method

.method public final component5()com.bytedance.trae.conversation.voice.ConversationStateMessage$Stage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->stage Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.conversation.voice.ConversationStateMessage$ErrorDetail
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->errorInfo Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  long  long  com.bytedance.trae.conversation.voice.ConversationStateMessage$Stage  com.bytedance.trae.conversation.voice.ConversationStateMessage$ErrorDetail)com.bytedance.trae.conversation.voice.ConversationStateMessage
    .registers 19
    # ins_size=9
    const-string/jumbo v0, taskId
    move-object v2, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userID
    move-object v3, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, stage
    move-object/from16 v8, v17
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    move-object v1, v0
    move-wide v4, v13
    move-wide v6, v15
    move-object/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;-><init>(Ljava/lang/String; Ljava/lang/String; J J Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage; Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->taskId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->userID Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->userID Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->roundID J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->roundID J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->eventTime J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->eventTime J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->stage Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->stage Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->errorInfo Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->errorInfo Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getErrorInfo()com.bytedance.trae.conversation.voice.ConversationStateMessage$ErrorDetail
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->errorInfo Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    return-object v0
.end method

.method public final getEventTime()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->eventTime J
    return-wide v0
.end method

.method public final getRoundID()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->roundID J
    return-wide v0
.end method

.method public final getStage()com.bytedance.trae.conversation.voice.ConversationStateMessage$Stage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->stage Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    return-object v0
.end method

.method public final getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final getUserID()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->userID Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->taskId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->userID Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->roundID J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->eventTime J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->stage Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->errorInfo Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ConversationStateMessage(taskId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userID="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->userID Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", roundID="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->roundID J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", eventTime="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->eventTime J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", stage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->stage Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;->errorInfo Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
