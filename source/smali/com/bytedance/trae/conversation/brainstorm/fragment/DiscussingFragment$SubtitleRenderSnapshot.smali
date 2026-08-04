# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
.super Ljava/lang/Object;
.source "DiscussingFragment.kt"

.field private final aiParticipantState:Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
.field private final attachments:Ljava/util/List;
.field private final botTranscript:Ljava/lang/String;
.field private final currentTranscript:Ljava/lang/String;
.field private final finishedSubTasks:Ljava/util/Map;
.field private final isSubtitleMode:Z
.field private final subTask:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
.field private final subtitleHistory:Ljava/util/List;


.method public constructor <init>(java.util.List  java.util.List  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.util.Map  java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  boolean)void
    .registers 10
    # ins_size=9
    const-string/jumbo v0, subtitleHistory
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "attachments"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "finishedSubTasks"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "botTranscript"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentTranscript"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "aiParticipantState"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subtitleHistory Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->attachments Ljava/util/List;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->finishedSubTasks Ljava/util/Map;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->botTranscript Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->currentTranscript Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    iput-boolean v9, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->isSubtitleMode Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$SubtitleRenderSnapshot  java.util.List  java.util.List  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.util.Map  java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  boolean  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$SubtitleRenderSnapshot
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subtitleHistory Ljava/util/List;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->attachments Ljava/util/List;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->finishedSubTasks Ljava/util/Map;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->botTranscript Ljava/lang/String;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->currentTranscript Ljava/lang/String;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->isSubtitleMode Z
    goto +3h
    move/from16 v1, v17
    move-object v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    move-object v14, v6
    move-object v15, v7
    move-object/from16 v16, v8
    move/from16 v17, v1
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->copy(Ljava/util/List; Ljava/util/List; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Z)Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subtitleHistory Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->attachments Ljava/util/List;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.voice.subtask.SubTaskUiState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    return-object v0
.end method

.method public final component4()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->finishedSubTasks Ljava/util/Map;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->botTranscript Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->currentTranscript Ljava/lang/String;
    return-object v0
.end method

.method public final component7()com.bytedance.trae.conversation.brainstorm.model.ParticipantState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    return-object v0
.end method

.method public final component8()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->isSubtitleMode Z
    return v0
.end method

.method public final copy(java.util.List  java.util.List  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.util.Map  java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.ParticipantState  boolean)com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$SubtitleRenderSnapshot
    .registers 19
    # ins_size=9
    const-string/jumbo v0, subtitleHistory
    move-object v2, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "attachments"
    move-object v3, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "finishedSubTasks"
    move-object v5, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "botTranscript"
    move-object v6, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentTranscript"
    move-object/from16 v7, v16
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "aiParticipantState"
    move-object/from16 v8, v17
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
    move-object v1, v0
    move-object v4, v13
    move/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;-><init>(Ljava/util/List; Ljava/util/List; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subtitleHistory Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subtitleHistory Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->attachments Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->attachments Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->finishedSubTasks Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->finishedSubTasks Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->botTranscript Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->botTranscript Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->currentTranscript Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->currentTranscript Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->isSubtitleMode Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->isSubtitleMode Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAiParticipantState()com.bytedance.trae.conversation.brainstorm.model.ParticipantState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    return-object v0
.end method

.method public final getAttachments()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->attachments Ljava/util/List;
    return-object v0
.end method

.method public final getBotTranscript()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->botTranscript Ljava/lang/String;
    return-object v0
.end method

.method public final getCurrentTranscript()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->currentTranscript Ljava/lang/String;
    return-object v0
.end method

.method public final getFinishedSubTasks()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->finishedSubTasks Ljava/util/Map;
    return-object v0
.end method

.method public final getSubTask()com.bytedance.trae.conversation.voice.subtask.SubTaskUiState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    return-object v0
.end method

.method public final getSubtitleHistory()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subtitleHistory Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subtitleHistory Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->attachments Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->finishedSubTasks Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->botTranscript Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->currentTranscript Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->isSubtitleMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSubtitleMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->isSubtitleMode Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SubtitleRenderSnapshot(subtitleHistory="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subtitleHistory Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", attachments="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->attachments Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", subTask="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->subTask Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", finishedSubTasks="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->finishedSubTasks Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", botTranscript="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->botTranscript Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", currentTranscript="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->currentTranscript Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", aiParticipantState="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->aiParticipantState Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSubtitleMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$SubtitleRenderSnapshot;->isSubtitleMode Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
