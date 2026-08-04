# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
.super Ljava/lang/Object;
.source "HistorySubtitleAdapter.kt"

.field private final attachedSubTaskId:Ljava/lang/String;
.field private final attachment:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
.field private final attachments:Ljava/util/List;
.field private final content:Ljava/lang/String;
.field private final id:Ljava/lang/String;
.field private final isFooter:Z
.field private final isLive:Z
.field private final isThinkingPlaceholder:Z
.field private final role:Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
.field private final subTaskBadge:Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;


.method public constructor <init>(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.MessageRole  java.lang.String  boolean  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  java.util.List  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)void
    .registers 12
    # ins_size=11
    const-string v0, "id"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->id Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->content Ljava/lang/String;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isLive Z
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter Z
    iput-boolean v7, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder Z
    iput-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachments Ljava/util/List;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachedSubTaskId Ljava/lang/String;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->subTaskBadge Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.MessageRole  java.lang.String  boolean  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  java.util.List  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 27
    # ins_size=13
    move/from16 v0, v25
    and-int/lit8 v1, v0, 8
    const/4 v2, 0
    if-eqz v1, +004h
    move v7, v2
    goto +3h
    move/from16 v7, v18
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move v8, v2
    goto +3h
    move/from16 v8, v19
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move v9, v2
    goto +3h
    move/from16 v9, v20
    and-int/lit8 v1, v0, 64
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v23
    and-int/lit16 v0, v0, 512
    if-eqz v0, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v24
    move-object v3, v14
    move-object v4, v15
    move-object/from16 v5, v16
    move-object/from16 v6, v17
    invoke-direct/range v3 ... v13, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem  java.lang.String  com.bytedance.trae.conversation.brainstorm.model.MessageRole  java.lang.String  boolean  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  java.util.List  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem
    .registers 24
    # ins_size=13
    move-object v0, v11
    move/from16 v1, v22
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->id Ljava/lang/String;
    goto +2h
    move-object v2, v12
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    goto +2h
    move-object v3, v13
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->content Ljava/lang/String;
    goto +2h
    move-object v4, v14
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-boolean v5, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isLive Z
    goto +2h
    move v5, v15
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-boolean v6, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter Z
    goto +3h
    move/from16 v6, v16
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-boolean v7, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder Z
    goto +3h
    move/from16 v7, v17
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    goto +3h
    move-object/from16 v8, v18
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachments Ljava/util/List;
    goto +3h
    move-object/from16 v9, v19
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachedSubTaskId Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v1, v1, 512
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->subTaskBadge Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    goto +3h
    move-object/from16 v1, v21
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    move v15, v5
    move/from16 v16, v6
    move/from16 v17, v7
    move-object/from16 v18, v8
    move-object/from16 v19, v9
    move-object/from16 v20, v10
    move-object/from16 v21, v1
    invoke-virtual/range v11 ... v21, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->copy(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component10()com.bytedance.trae.conversation.voice.subtask.SubTaskUiState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->subTaskBadge Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.brainstorm.model.MessageRole
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isLive Z
    return v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter Z
    return v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder Z
    return v0
.end method

.method public final component7()com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    return-object v0
.end method

.method public final component8()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachments Ljava/util/List;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachedSubTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.conversation.brainstorm.model.MessageRole  java.lang.String  boolean  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  java.util.List  java.lang.String  com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem
    .registers 23
    # ins_size=11
    const-string v0, "id"
    move-object v2, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    move-object v3, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "content"
    move-object v4, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    move-object v1, v0
    move/from16 v5, v16
    move/from16 v6, v17
    move/from16 v7, v18
    move-object/from16 v8, v19
    move-object/from16 v9, v20
    move-object/from16 v10, v21
    move-object/from16 v11, v22
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole; Ljava/lang/String; Z Z Z Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment; Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->content Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isLive Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isLive Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachments Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachments Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachedSubTaskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachedSubTaskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->subTaskBadge Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->subTaskBadge Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAttachedSubTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachedSubTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final getAttachment()com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    return-object v0
.end method

.method public final getAttachments()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachments Ljava/util/List;
    return-object v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getRole()com.bytedance.trae.conversation.brainstorm.model.MessageRole
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    return-object v0
.end method

.method public final getSubTaskBadge()com.bytedance.trae.conversation.voice.subtask.SubTaskUiState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->subTaskBadge Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->content Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isLive Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachments Ljava/util/List;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachedSubTaskId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->subTaskBadge Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isFooter()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter Z
    return v0
.end method

.method public final isLive()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isLive Z
    return v0
.end method

.method public final isThinkingPlaceholder()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SubtitleItem(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", role="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->role Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", content="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->content Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isLive="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isLive Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isFooter="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isFooter Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isThinkingPlaceholder="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->isThinkingPlaceholder Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", attachment="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachment Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", attachments="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachments Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", attachedSubTaskId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->attachedSubTaskId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", subTaskBadge="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->subTaskBadge Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
