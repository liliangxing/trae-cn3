# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
.super Ljava/lang/Object;
.source "BrainstormAttachment.kt"

.field private final attachmentId:Ljava/lang/String;
.field private final createdAtMs:J
.field private final displayName:Ljava/lang/String;
.field private final errorMessage:Ljava/lang/String;
.field private final groupId:Ljava/lang/String;
.field private final isImage:Z
.field private final localUri:Ljava/lang/String;
.field private final mimeType:Ljava/lang/String;
.field private final notifiedToBot:Z
.field private final progress:I
.field private final sizeBytes:J
.field private final state:Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
.field private final uploadedRef:Ljava/lang/String;
.field private final useImageUpload:Z


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.AttachmentState  int  java.lang.String  java.lang.String  boolean  long  java.lang.String)void
    .registers 24
    # ins_size=17
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v13
    move-object/from16 v5, v16
    const-string v6, "attachmentId"
    invoke-static v8, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "displayName"
    invoke-static v9, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "mimeType"
    invoke-static v10, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "localUri"
    invoke-static v13, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v6, state
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->attachmentId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->displayName Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->mimeType Ljava/lang/String;
    move-wide v1, v11
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->sizeBytes J
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->localUri Ljava/lang/String;
    move v1, v14
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage Z
    move v1, v15
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->useImageUpload Z
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->state Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move/from16 v1, v17
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->progress I
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->uploadedRef Ljava/lang/String;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->errorMessage Ljava/lang/String;
    move/from16 v1, v20
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->notifiedToBot Z
    move-wide/from16 v1, v21
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->createdAtMs J
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->groupId Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.AttachmentState  int  java.lang.String  java.lang.String  boolean  long  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 39
    # ins_size=19
    move/from16 v0, v37
    and-int/lit16 v1, v0, 256
    const/4 v2, 0
    if-eqz v1, +004h
    move v13, v2
    goto +3h
    move/from16 v13, v30
    and-int/lit16 v1, v0, 512
    const/4 v3, 0
    if-eqz v1, +004h
    move-object v14, v3
    goto +3h
    move-object/from16 v14, v31
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +004h
    move-object v15, v3
    goto +3h
    move-object/from16 v15, v32
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +005h
    move/from16 v16, v2
    goto +3h
    move/from16 v16, v33
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +007h
    const-wide/16 v1, 0
    move-wide/from16 v17, v1
    goto +3h
    move-wide/from16 v17, v34
    and-int/lit16 v0, v0, 8192
    if-eqz v0, +005h
    move-object/from16 v19, v3
    goto +3h
    move-object/from16 v19, v36
    move-object/from16 v3, v20
    move-object/from16 v4, v21
    move-object/from16 v5, v22
    move-object/from16 v6, v23
    move-wide/from16 v7, v24
    move-object/from16 v9, v26
    move/from16 v10, v27
    move/from16 v11, v28
    move-object/from16 v12, v29
    invoke-direct/range v3 ... v19, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.AttachmentState  int  java.lang.String  java.lang.String  boolean  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 35
    # ins_size=19
    move-object/from16 v0, v16
    move/from16 v1, v33
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->attachmentId Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v17
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->displayName Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v18
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->mimeType Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v19
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->sizeBytes J
    goto +3h
    move-wide/from16 v5, v20
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->localUri Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v22
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage Z
    goto +3h
    move/from16 v8, v23
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget-boolean v9, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->useImageUpload Z
    goto +3h
    move/from16 v9, v24
    and-int/lit16 v10, v1, 128
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->state Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    goto +3h
    move-object/from16 v10, v25
    and-int/lit16 v11, v1, 256
    if-eqz v11, +005h
    iget v11, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->progress I
    goto +3h
    move/from16 v11, v26
    and-int/lit16 v12, v1, 512
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->uploadedRef Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v27
    and-int/lit16 v13, v1, 1024
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->errorMessage Ljava/lang/String;
    goto +3h
    move-object/from16 v13, v28
    and-int/lit16 v14, v1, 2048
    if-eqz v14, +005h
    iget-boolean v14, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->notifiedToBot Z
    goto +3h
    move/from16 v14, v29
    and-int/lit16 v15, v1, 4096
    move/from16 v29, v14
    if-eqz v15, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->createdAtMs J
    goto +3h
    move-wide/from16 v14, v30
    and-int/lit16 v1, v1, 8192
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->groupId Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v32
    move-object/from16 v17, v2
    move-object/from16 v18, v3
    move-object/from16 v19, v4
    move-wide/from16 v20, v5
    move-object/from16 v22, v7
    move/from16 v23, v8
    move/from16 v24, v9
    move-object/from16 v25, v10
    move/from16 v26, v11
    move-object/from16 v27, v12
    move-object/from16 v28, v13
    move-wide/from16 v30, v14
    move-object/from16 v32, v1
    invoke-virtual/range v16 ... v32, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->attachmentId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->uploadedRef Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->errorMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component12()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->notifiedToBot Z
    return v0
.end method

.method public final component13()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->createdAtMs J
    return-wide v0
.end method

.method public final component14()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->groupId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->mimeType Ljava/lang/String;
    return-object v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->sizeBytes J
    return-wide v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->localUri Ljava/lang/String;
    return-object v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage Z
    return v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->useImageUpload Z
    return v0
.end method

.method public final component8()com.bytedance.trae.conversation.brainstorm.model.AttachmentState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->state Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    return-object v0
.end method

.method public final component9()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->progress I
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  boolean  boolean  com.bytedance.trae.conversation.brainstorm.model.AttachmentState  int  java.lang.String  java.lang.String  boolean  long  java.lang.String)com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment
    .registers 36
    # ins_size=17
    move-object/from16 v1, v20
    move-object/from16 v2, v21
    move-object/from16 v3, v22
    move-wide/from16 v4, v23
    move-object/from16 v6, v25
    move/from16 v7, v26
    move/from16 v8, v27
    move-object/from16 v9, v28
    move/from16 v10, v29
    move-object/from16 v11, v30
    move-object/from16 v12, v31
    move/from16 v13, v32
    move-wide/from16 v14, v33
    move-object/from16 v16, v35
    const-string v0, "attachmentId"
    move-object/from16 v17, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "displayName"
    move-object/from16 v1, v21
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mimeType"
    move-object/from16 v1, v22
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "localUri"
    move-object/from16 v1, v25
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    move-object/from16 v1, v28
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v18, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    move-object/from16 v0, v18
    move-object/from16 v1, v17
    invoke-direct/range v0 ... v16, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Z Z Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState; I Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String;)V
    return-object v18
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->attachmentId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->attachmentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->displayName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->displayName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->mimeType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->mimeType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->sizeBytes J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->sizeBytes J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->localUri Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->localUri Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->useImageUpload Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->useImageUpload Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->state Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->state Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->progress I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->progress I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->uploadedRef Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->uploadedRef Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->errorMessage Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->errorMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->notifiedToBot Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->notifiedToBot Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->createdAtMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->createdAtMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->groupId Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->groupId Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAttachmentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->attachmentId Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAtMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->createdAtMs J
    return-wide v0
.end method

.method public final getDisplayName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->displayName Ljava/lang/String;
    return-object v0
.end method

.method public final getErrorMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->errorMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getGroupId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->groupId Ljava/lang/String;
    return-object v0
.end method

.method public final getLocalUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->localUri Ljava/lang/String;
    return-object v0
.end method

.method public final getMimeType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->mimeType Ljava/lang/String;
    return-object v0
.end method

.method public final getNotifiedToBot()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->notifiedToBot Z
    return v0
.end method

.method public final getProgress()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->progress I
    return v0
.end method

.method public final getSizeBytes()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->sizeBytes J
    return-wide v0
.end method

.method public final getState()com.bytedance.trae.conversation.brainstorm.model.AttachmentState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->state Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    return-object v0
.end method

.method public final getUploadedRef()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->uploadedRef Ljava/lang/String;
    return-object v0
.end method

.method public final getUseImageUpload()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->useImageUpload Z
    return v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->attachmentId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->displayName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->mimeType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->sizeBytes J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->localUri Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->useImageUpload Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->state Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->progress I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->uploadedRef Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->errorMessage Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->notifiedToBot Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->createdAtMs J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->groupId Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isImage()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "BrainstormAttachment(attachmentId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->attachmentId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", displayName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->displayName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mimeType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->mimeType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sizeBytes="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->sizeBytes J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", localUri="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->localUri Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isImage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", useImageUpload="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->useImageUpload Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", state="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->state Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", progress="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->progress I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", uploadedRef="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->uploadedRef Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", errorMessage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->errorMessage Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", notifiedToBot="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->notifiedToBot Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", createdAtMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->createdAtMs J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", groupId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->groupId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
