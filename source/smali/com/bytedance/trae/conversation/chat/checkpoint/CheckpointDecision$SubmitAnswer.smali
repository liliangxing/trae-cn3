# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
.super Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
.source "CheckpointInteraction.kt"

.field private final answers:Ljava/util/List;
.field private final conversationId:Ljava/lang/String;
.field private final planItemId:Ljava/lang/String;
.field private final questionsJson:Ljava/lang/String;
.field private final supplementaryInfo:Ljava/lang/String;
.field private final taskId:Ljava/lang/String;
.field private final toolName:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  java.lang.String)void
    .registers 9
    # ins_size=8
    const-string v0, "planItemId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "questionsJson"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "answers"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->planItemId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->toolName Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->taskId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->conversationId Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->questionsJson Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->answers Ljava/util/List;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->supplementaryInfo Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 64
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v16
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    move-object v7, v15
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision$SubmitAnswer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision$SubmitAnswer
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->planItemId Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->toolName Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->taskId Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->conversationId Ljava/lang/String;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->questionsJson Ljava/lang/String;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->answers Ljava/util/List;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->supplementaryInfo Ljava/lang/String;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->planItemId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->questionsJson Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->answers Ljava/util/List;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->supplementaryInfo Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  java.lang.String)com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision$SubmitAnswer
    .registers 17
    # ins_size=8
    const-string v0, "planItemId"
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    move-object v4, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "questionsJson"
    move-object v6, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "answers"
    move-object v7, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    move-object v1, v0
    move-object v3, v11
    move-object v5, v13
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->planItemId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->planItemId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->toolName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->toolName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->taskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->taskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->conversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->questionsJson Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->questionsJson Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->answers Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->answers Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->supplementaryInfo Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->supplementaryInfo Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAnswers()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->answers Ljava/util/List;
    return-object v0
.end method

.method public getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public getPlanItemId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->planItemId Ljava/lang/String;
    return-object v0
.end method

.method public final getQuestionsJson()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->questionsJson Ljava/lang/String;
    return-object v0
.end method

.method public final getSupplementaryInfo()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->supplementaryInfo Ljava/lang/String;
    return-object v0
.end method

.method public getTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->taskId Ljava/lang/String;
    return-object v0
.end method

.method public getToolName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->planItemId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->toolName Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->taskId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->conversationId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->questionsJson Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->answers Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->supplementaryInfo Ljava/lang/String;
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
    const-string v1, "SubmitAnswer(planItemId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->planItemId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", toolName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->toolName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->taskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", questionsJson="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->questionsJson Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", answers="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->answers Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", supplementaryInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;->supplementaryInfo Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
