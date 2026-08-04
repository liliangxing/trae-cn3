# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
.super Ljava/lang/Object;
.source "TraeAITracker.kt"

.field private asrCount:I
.field private attachmentCount:I
.field private codeSelectionCount:I
.field private commandType:Ljava/lang/String;
.field private dataSheetCount:I
.field private dataSheetWithCommentCount:I
.field private dataTextCount:I
.field private dataTextWithCommentCount:I
.field private envDeployment:Ljava/lang/String;
.field private fileCount:I
.field private fileWithCommentCount:I
.field private folderCount:I
.field private gitType:Ljava/lang/String;
.field private hasGit:Z
.field private imageCount:I
.field private isPlanMode:Z
.field private isSpecMode:Z
.field private logItemCount:I
.field private markdownCount:I
.field private markdownWithComment:I
.field private mentionType:Ljava/lang/String;
.field private pluginCount:I
.field private remoteEnv:Ljava/lang/String;
.field private rulesCount:I
.field private skillCount:I
.field private webElementCount:I
.field private webUrlCount:I


.method public constructor <init>()void
    .registers 31
    # ins_size=1
    move-object/from16 v0, v30
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const v28, 134217727
    const/16 v29, 0
    invoke-direct/range v0 ... v29, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Z Z I I Ljava/lang/String; I I I I I I I I I I I I Ljava/lang/String; I I I I I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  boolean  java.lang.String  java.lang.String  boolean  boolean  int  int  java.lang.String  int  int  int  int  int  int  int  int  int  int  int  int  java.lang.String  int  int  int  int  int)void
    .registers 35
    # ins_size=28
    move-object v0, v7
    move-object v1, v8
    move-object v2, v10
    move-object v3, v11
    move-object/from16 v4, v16
    move-object/from16 v5, v29
    const-string v6, "envDeployment"
    invoke-static v8, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "gitType"
    invoke-static v10, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "remoteEnv"
    invoke-static v11, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "commandType"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "mentionType"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    move v1, v9
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    move v1, v12
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    move v1, v13
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    move v1, v14
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    move v1, v15
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    iput-object v4, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    move/from16 v1, v17
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    move/from16 v1, v18
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    move/from16 v1, v19
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    move/from16 v1, v20
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    move/from16 v1, v21
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    move/from16 v1, v22
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    move/from16 v1, v23
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    move/from16 v1, v24
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    move/from16 v1, v25
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    move/from16 v1, v26
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    move/from16 v1, v27
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    move/from16 v1, v28
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    iput-object v5, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    move/from16 v1, v30
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    move/from16 v1, v31
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    move/from16 v1, v32
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    move/from16 v1, v33
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    move/from16 v1, v34
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  boolean  java.lang.String  java.lang.String  boolean  boolean  int  int  java.lang.String  int  int  int  int  int  int  int  int  int  int  int  int  java.lang.String  int  int  int  int  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 58
    # ins_size=30
    move/from16 v0, v56
    and-int/lit8 v1, v0, 1
    const-string v2, ""
    if-eqz v1, +004h
    move-object v1, v2
    goto +3h
    move-object/from16 v1, v29
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move/from16 v3, v30
    and-int/lit8 v5, v0, 4
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v31
    and-int/lit8 v6, v0, 8
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v32
    and-int/lit8 v7, v0, 16
    if-eqz v7, +004h
    const/4 v7, 0
    goto +3h
    move/from16 v7, v33
    and-int/lit8 v8, v0, 32
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    move/from16 v8, v34
    and-int/lit8 v9, v0, 64
    if-eqz v9, +004h
    const/4 v9, 0
    goto +3h
    move/from16 v9, v35
    and-int/lit16 v10, v0, 128
    if-eqz v10, +004h
    const/4 v10, 0
    goto +3h
    move/from16 v10, v36
    and-int/lit16 v11, v0, 256
    if-eqz v11, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v37
    and-int/lit16 v12, v0, 512
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move/from16 v12, v38
    and-int/lit16 v13, v0, 1024
    if-eqz v13, +004h
    const/4 v13, 0
    goto +3h
    move/from16 v13, v39
    and-int/lit16 v14, v0, 2048
    if-eqz v14, +004h
    const/4 v14, 0
    goto +3h
    move/from16 v14, v40
    and-int/lit16 v15, v0, 4096
    if-eqz v15, +004h
    const/4 v15, 0
    goto +3h
    move/from16 v15, v41
    and-int/lit16 v4, v0, 8192
    if-eqz v4, +004h
    const/4 v4, 0
    goto +3h
    move/from16 v4, v42
    move-object/from16 v57, v2
    and-int/lit16 v2, v0, 16384
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    move/from16 v2, v43
    const v16, 32768
    and-int v16, v0, v16
    if-eqz v16, +005h
    const/16 v16, 0
    goto +3h
    move/from16 v16, v44
    const/high16 v17, 65536
    and-int v17, v0, v17
    if-eqz v17, +005h
    const/16 v17, 0
    goto +3h
    move/from16 v17, v45
    const/high16 v18, 131072
    and-int v18, v0, v18
    if-eqz v18, +005h
    const/16 v18, 0
    goto +3h
    move/from16 v18, v46
    const/high16 v19, 262144
    and-int v19, v0, v19
    if-eqz v19, +005h
    const/16 v19, 0
    goto +3h
    move/from16 v19, v47
    const/high16 v20, 524288
    and-int v20, v0, v20
    if-eqz v20, +005h
    const/16 v20, 0
    goto +3h
    move/from16 v20, v48
    const/high16 v21, 1048576
    and-int v21, v0, v21
    if-eqz v21, +005h
    const/16 v21, 0
    goto +3h
    move/from16 v21, v49
    const/high16 v22, 2097152
    and-int v22, v0, v22
    if-eqz v22, +005h
    move-object/from16 v22, v57
    goto +3h
    move-object/from16 v22, v50
    const/high16 v23, 4194304
    and-int v23, v0, v23
    if-eqz v23, +005h
    const/16 v23, 0
    goto +3h
    move/from16 v23, v51
    const/high16 v24, 8388608
    and-int v24, v0, v24
    if-eqz v24, +005h
    const/16 v24, 0
    goto +3h
    move/from16 v24, v52
    const/high16 v25, 16777216
    and-int v25, v0, v25
    if-eqz v25, +005h
    const/16 v25, 0
    goto +3h
    move/from16 v25, v53
    const/high16 v26, 33554432
    and-int v26, v0, v26
    if-eqz v26, +005h
    const/16 v26, 0
    goto +3h
    move/from16 v26, v54
    const/high16 v27, 67108864
    and-int v0, v0, v27
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move/from16 v0, v55
    move-object/from16 v29, v28
    move-object/from16 v30, v1
    move/from16 v31, v3
    move-object/from16 v32, v5
    move-object/from16 v33, v6
    move/from16 v34, v7
    move/from16 v35, v8
    move/from16 v36, v9
    move/from16 v37, v10
    move-object/from16 v38, v11
    move/from16 v39, v12
    move/from16 v40, v13
    move/from16 v41, v14
    move/from16 v42, v15
    move/from16 v43, v4
    move/from16 v44, v2
    move/from16 v45, v16
    move/from16 v46, v17
    move/from16 v47, v18
    move/from16 v48, v19
    move/from16 v49, v20
    move/from16 v50, v21
    move-object/from16 v51, v22
    move/from16 v52, v23
    move/from16 v53, v24
    move/from16 v54, v25
    move/from16 v55, v26
    move/from16 v56, v0
    invoke-direct/range v29 ... v56, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Z Z I I Ljava/lang/String; I I I I I I I I I I I I Ljava/lang/String; I I I I I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.tracker.AISendMessageContext  java.lang.String  boolean  java.lang.String  java.lang.String  boolean  boolean  int  int  java.lang.String  int  int  int  int  int  int  int  int  int  int  int  int  java.lang.String  int  int  int  int  int  int  java.lang.Object)com.bytedance.trae.conversation.tracker.AISendMessageContext
    .registers 47
    # ins_size=30
    move-object/from16 v0, v17
    move/from16 v1, v45
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    goto +3h
    move/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-boolean v6, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    goto +3h
    move/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-boolean v7, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    goto +3h
    move/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget v8, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    goto +3h
    move/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    goto +3h
    move/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget v11, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    goto +3h
    move/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget v12, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    goto +3h
    move/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget v13, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    goto +3h
    move/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    goto +3h
    move/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    goto +3h
    move/from16 v15, v31
    move/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    goto +3h
    move/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move/from16 v32, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    goto +3h
    move/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move/from16 v33, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    goto +3h
    move/from16 v15, v34
    const/high16 v16, 131072
    and-int v16, v1, v16
    move/from16 v34, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    goto +3h
    move/from16 v15, v35
    const/high16 v16, 262144
    and-int v16, v1, v16
    move/from16 v35, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    goto +3h
    move/from16 v15, v36
    const/high16 v16, 524288
    and-int v16, v1, v16
    move/from16 v36, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    goto +3h
    move/from16 v15, v37
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move/from16 v37, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    goto +3h
    move/from16 v15, v38
    const/high16 v16, 2097152
    and-int v16, v1, v16
    move/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 4194304
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    goto +3h
    move/from16 v15, v40
    const/high16 v16, 8388608
    and-int v16, v1, v16
    move/from16 v40, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    goto +3h
    move/from16 v15, v41
    const/high16 v16, 16777216
    and-int v16, v1, v16
    move/from16 v41, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    goto +3h
    move/from16 v15, v42
    const/high16 v16, 33554432
    and-int v16, v1, v16
    move/from16 v42, v15
    if-eqz v16, +005h
    iget v15, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    goto +3h
    move/from16 v15, v43
    const/high16 v16, 67108864
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    goto +3h
    move/from16 v1, v44
    move-object/from16 v18, v2
    move/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move/from16 v22, v6
    move/from16 v23, v7
    move/from16 v24, v8
    move/from16 v25, v9
    move-object/from16 v26, v10
    move/from16 v27, v11
    move/from16 v28, v12
    move/from16 v29, v13
    move/from16 v30, v14
    move/from16 v43, v15
    move/from16 v44, v1
    invoke-virtual/range v17 ... v44, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->copy(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Z Z I I Ljava/lang/String; I I I I I I I I I I I I Ljava/lang/String; I I I I I)Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    return-object v0
.end method

.method public final component10()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    return v0
.end method

.method public final component11()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    return v0
.end method

.method public final component12()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    return v0
.end method

.method public final component13()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    return v0
.end method

.method public final component14()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    return v0
.end method

.method public final component15()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    return v0
.end method

.method public final component16()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    return v0
.end method

.method public final component17()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    return v0
.end method

.method public final component18()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    return v0
.end method

.method public final component19()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    return v0
.end method

.method public final component20()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    return v0
.end method

.method public final component21()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    return v0
.end method

.method public final component22()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    return-object v0
.end method

.method public final component23()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    return v0
.end method

.method public final component24()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    return v0
.end method

.method public final component25()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    return v0
.end method

.method public final component26()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    return v0
.end method

.method public final component27()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    return-object v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    return v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    return v0
.end method

.method public final component7()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    return v0
.end method

.method public final component8()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    return v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  boolean  java.lang.String  java.lang.String  boolean  boolean  int  int  java.lang.String  int  int  int  int  int  int  int  int  int  int  int  int  java.lang.String  int  int  int  int  int)com.bytedance.trae.conversation.tracker.AISendMessageContext
    .registers 58
    # ins_size=28
    move-object/from16 v1, v31
    move/from16 v2, v32
    move-object/from16 v3, v33
    move-object/from16 v4, v34
    move/from16 v5, v35
    move/from16 v6, v36
    move/from16 v7, v37
    move/from16 v8, v38
    move-object/from16 v9, v39
    move/from16 v10, v40
    move/from16 v11, v41
    move/from16 v12, v42
    move/from16 v13, v43
    move/from16 v14, v44
    move/from16 v15, v45
    move/from16 v16, v46
    move/from16 v17, v47
    move/from16 v18, v48
    move/from16 v19, v49
    move/from16 v20, v50
    move/from16 v21, v51
    move-object/from16 v22, v52
    move/from16 v23, v53
    move/from16 v24, v54
    move/from16 v25, v55
    move/from16 v26, v56
    move/from16 v27, v57
    const-string v0, "envDeployment"
    move-object/from16 v28, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "gitType"
    move-object/from16 v1, v33
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "remoteEnv"
    move-object/from16 v1, v34
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "commandType"
    move-object/from16 v1, v39
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mentionType"
    move-object/from16 v1, v52
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v29, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    move-object/from16 v0, v29
    move-object/from16 v1, v28
    invoke-direct/range v0 ... v27, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Z Z I I Ljava/lang/String; I I I I I I I I I I I I Ljava/lang/String; I I I I I)V
    return-object v29
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    iget v3, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    iget v5, v5, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getAsrCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    return v0
.end method

.method public final getAttachmentCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    return v0
.end method

.method public final getCodeSelectionCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    return v0
.end method

.method public final getCommandType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    return-object v0
.end method

.method public final getDataSheetCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    return v0
.end method

.method public final getDataSheetWithCommentCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    return v0
.end method

.method public final getDataTextCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    return v0
.end method

.method public final getDataTextWithCommentCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    return v0
.end method

.method public final getEnvDeployment()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    return-object v0
.end method

.method public final getFileCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    return v0
.end method

.method public final getFileWithCommentCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    return v0
.end method

.method public final getFolderCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    return v0
.end method

.method public final getGitType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    return-object v0
.end method

.method public final getHasGit()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    return v0
.end method

.method public final getImageCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    return v0
.end method

.method public final getLogItemCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    return v0
.end method

.method public final getMarkdownCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    return v0
.end method

.method public final getMarkdownWithComment()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    return v0
.end method

.method public final getMentionType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    return-object v0
.end method

.method public final getPluginCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    return v0
.end method

.method public final getRemoteEnv()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    return-object v0
.end method

.method public final getRulesCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    return v0
.end method

.method public final getSkillCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    return v0
.end method

.method public final getWebElementCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    return v0
.end method

.method public final getWebUrlCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isPlanMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    return v0
.end method

.method public final isSpecMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    return v0
.end method

.method public final setAsrCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    return-void 
.end method

.method public final setAttachmentCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    return-void 
.end method

.method public final setCodeSelectionCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    return-void 
.end method

.method public final setCommandType(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    return-void 
.end method

.method public final setDataSheetCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    return-void 
.end method

.method public final setDataSheetWithCommentCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    return-void 
.end method

.method public final setDataTextCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    return-void 
.end method

.method public final setDataTextWithCommentCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    return-void 
.end method

.method public final setEnvDeployment(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    return-void 
.end method

.method public final setFileCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    return-void 
.end method

.method public final setFileWithCommentCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    return-void 
.end method

.method public final setFolderCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    return-void 
.end method

.method public final setGitType(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    return-void 
.end method

.method public final setHasGit(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    return-void 
.end method

.method public final setImageCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    return-void 
.end method

.method public final setLogItemCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    return-void 
.end method

.method public final setMarkdownCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    return-void 
.end method

.method public final setMarkdownWithComment(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    return-void 
.end method

.method public final setMentionType(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    return-void 
.end method

.method public final setPlanMode(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    return-void 
.end method

.method public final setPluginCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    return-void 
.end method

.method public final setRemoteEnv(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    return-void 
.end method

.method public final setRulesCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    return-void 
.end method

.method public final setSkillCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    return-void 
.end method

.method public final setSpecMode(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    return-void 
.end method

.method public final setWebElementCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    return-void 
.end method

.method public final setWebUrlCount(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    return-void 
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "AISendMessageContext(envDeployment="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->envDeployment Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasGit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->hasGit Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", gitType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->gitType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", remoteEnv="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->remoteEnv Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isSpecMode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isPlanMode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", skillCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->skillCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", rulesCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->rulesCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", commandType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->commandType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fileCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", folderCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->folderCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fileWithCommentCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget v1, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->fileWithCommentCount I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", dataTextCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", dataTextWithCommentCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataTextWithCommentCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", dataSheetCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", dataSheetWithCommentCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->dataSheetWithCommentCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", markdownCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", markdownWithComment="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->markdownWithComment I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", codeSelectionCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->codeSelectionCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", webUrlCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webUrlCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", webElementCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->webElementCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mentionType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->mentionType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", logItemCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->logItemCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    const-string v1, ", imageCount="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->imageCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", asrCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->asrCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", attachmentCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->attachmentCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", pluginCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->pluginCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
