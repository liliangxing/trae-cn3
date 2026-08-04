# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskModel;
.super Ljava/lang/Object;
.source "TaskModel.kt"

.field public static final $stable:I
.field private final cliId:Ljava/lang/String;
.field private final cliType:Ljava/lang/String;
.field private final iconType:Lcom/bytedance/trae/home/solo/task/TaskIconType;
.field private final id:Ljava/lang/String;
.field private final initial:Ljava/lang/String;
.field private final isDeviceOnline:Z
.field private final isLocal:Z
.field private final isPinned:Z
.field private final isUnread:Z
.field private final location:Ljava/lang/String;
.field private final mode:Ljava/lang/String;
.field private final pinnedAt:Ljava/lang/String;
.field private final searchAnchorCreatedAtMs:Ljava/lang/String;
.field private final searchHighlightKeywords:Ljava/util/List;
.field private final searchQuery:Ljava/lang/String;
.field private final searchSnippet:Ljava/lang/String;
.field private final status:Lcom/bytedance/trae/home/solo/task/TaskStatus;
.field private final supportsPin:Z
.field private final tag:Ljava/lang/String;
.field private final time:Ljava/lang/String;
.field private final title:Ljava/lang/String;
.field private final updatedAt:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.task.TaskStatus  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  boolean  java.lang.String  boolean  boolean  boolean  java.lang.String  com.bytedance.trae.home.solo.task.TaskIconType  java.lang.String  java.lang.String  java.util.List  java.lang.String)void
    .registers 39
    # ins_size=23
    move-object/from16 v0, v16
    move-object/from16 v1, v17
    move-object/from16 v2, v18
    move-object/from16 v3, v19
    move-object/from16 v4, v20
    move-object/from16 v5, v21
    move-object/from16 v6, v22
    move-object/from16 v7, v23
    move-object/from16 v8, v24
    move-object/from16 v9, v25
    move-object/from16 v10, v26
    move-object/from16 v11, v29
    move-object/from16 v12, v34
    move-object/from16 v13, v35
    move-object/from16 v14, v36
    const-string v15, "id"
    invoke-static v1, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v15, "initial"
    invoke-static v2, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v15, title
    invoke-static v3, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v15, status
    invoke-static v4, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v15, tag
    invoke-static v5, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v15, "location"
    invoke-static v6, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v15, time
    invoke-static v7, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v15, updatedAt
    invoke-static v8, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v15, "cliId"
    invoke-static v9, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v15, "mode"
    invoke-static v10, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v15, "pinnedAt"
    invoke-static v11, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v15, "iconType"
    invoke-static v12, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v15, searchSnippet
    invoke-static v13, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v15, searchQuery
    invoke-static v14, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v16, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->initial Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->title Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->status Lcom/bytedance/trae/home/solo/task/TaskStatus;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->tag Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->location Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->time Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->updatedAt Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliId Ljava/lang/String;
    iput-object v10, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->mode Ljava/lang/String;
    move/from16 v1, v27
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isUnread Z
    move/from16 v1, v28
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned Z
    iput-object v11, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->pinnedAt Ljava/lang/String;
    move/from16 v1, v30
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->supportsPin Z
    move/from16 v1, v31
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal Z
    move/from16 v1, v32
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline Z
    move-object/from16 v1, v33
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliType Ljava/lang/String;
    iput-object v12, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->iconType Lcom/bytedance/trae/home/solo/task/TaskIconType;
    iput-object v13, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchSnippet Ljava/lang/String;
    iput-object v14, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchQuery Ljava/lang/String;
    move-object/from16 v1, v37
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchHighlightKeywords Ljava/util/List;
    move-object/from16 v1, v38
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchAnchorCreatedAtMs Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.task.TaskStatus  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  boolean  java.lang.String  boolean  boolean  boolean  java.lang.String  com.bytedance.trae.home.solo.task.TaskIconType  java.lang.String  java.lang.String  java.util.List  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 50
    # ins_size=25
    move/from16 v0, v48
    and-int/lit8 v1, v0, 16
    if-eqz v1, +006h
    const-string v1, "Cloud"
    move-object v7, v1
    goto +3h
    move-object/from16 v7, v30
    and-int/lit16 v1, v0, 128
    const-string v2, ""
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v33
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v34
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v35
    and-int/lit16 v1, v0, 1024
    const/4 v3, 0
    if-eqz v1, +004h
    move v13, v3
    goto +3h
    move/from16 v13, v36
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +004h
    move v14, v3
    goto +3h
    move/from16 v14, v37
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +004h
    move-object v15, v2
    goto +3h
    move-object/from16 v15, v38
    and-int/lit16 v1, v0, 8192
    if-eqz v1, +005h
    move/from16 v16, v3
    goto +3h
    move/from16 v16, v39
    and-int/lit16 v1, v0, 16384
    if-eqz v1, +005h
    move/from16 v17, v3
    goto +3h
    move/from16 v17, v40
    const v1, 32768
    and-int/2addr v1, v0
    if-eqz v1, +006h
    const/4 v1, 1
    move/from16 v18, v1
    goto +3h
    move/from16 v18, v41
    const/high16 v1, 65536
    and-int/2addr v1, v0
    const/4 v3, 0
    if-eqz v1, +005h
    move-object/from16 v19, v3
    goto +3h
    move-object/from16 v19, v42
    const/high16 v1, 131072
    and-int/2addr v1, v0
    if-eqz v1, +007h
    sget-object v1, Lcom/bytedance/trae/home/solo/task/TaskIconType;->CHAT Lcom/bytedance/trae/home/solo/task/TaskIconType;
    move-object/from16 v20, v1
    goto +3h
    move-object/from16 v20, v43
    const/high16 v1, 262144
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move-object/from16 v21, v2
    goto +3h
    move-object/from16 v21, v44
    const/high16 v1, 524288
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move-object/from16 v22, v2
    goto +3h
    move-object/from16 v22, v45
    const/high16 v1, 1048576
    and-int/2addr v1, v0
    if-eqz v1, +005h
    move-object/from16 v23, v3
    goto +3h
    move-object/from16 v23, v46
    const/high16 v1, 2097152
    and-int/2addr v0, v1
    if-eqz v0, +005h
    move-object/from16 v24, v3
    goto +3h
    move-object/from16 v24, v47
    move-object/from16 v2, v25
    move-object/from16 v3, v26
    move-object/from16 v4, v27
    move-object/from16 v5, v28
    move-object/from16 v6, v29
    move-object/from16 v8, v31
    move-object/from16 v9, v32
    invoke-direct/range v2 ... v24, Lcom/bytedance/trae/home/solo/task/TaskModel;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.task.TaskModel  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.task.TaskStatus  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  boolean  java.lang.String  boolean  boolean  boolean  java.lang.String  com.bytedance.trae.home.solo.task.TaskIconType  java.lang.String  java.lang.String  java.util.List  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.task.TaskModel
    .registers 42
    # ins_size=25
    move-object/from16 v0, v17
    move/from16 v1, v40
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->id Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->initial Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->title Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->status Lcom/bytedance/trae/home/solo/task/TaskStatus;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->tag Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->location Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->time Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->updatedAt Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliId Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->mode Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-boolean v12, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isUnread Z
    goto +3h
    move/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-boolean v13, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned Z
    goto +3h
    move/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->pinnedAt Ljava/lang/String;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->supportsPin Z
    goto +3h
    move/from16 v15, v31
    move/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal Z
    goto +3h
    move/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move/from16 v32, v15
    if-eqz v16, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline Z
    goto +3h
    move/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move/from16 v33, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v34
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-object/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->iconType Lcom/bytedance/trae/home/solo/task/TaskIconType;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchSnippet Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v36
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchQuery Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move-object/from16 v37, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchHighlightKeywords Ljava/util/List;
    goto +3h
    move-object/from16 v15, v38
    const/high16 v16, 2097152
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchAnchorCreatedAtMs Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v39
    move-object/from16 v18, v2
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v11
    move/from16 v28, v12
    move/from16 v29, v13
    move-object/from16 v30, v14
    move-object/from16 v38, v15
    move-object/from16 v39, v1
    invoke-virtual/range v17 ... v39, Lcom/bytedance/trae/home/solo/task/TaskModel;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->mode Ljava/lang/String;
    return-object v0
.end method

.method public final component11()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->isUnread Z
    return v0
.end method

.method public final component12()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned Z
    return v0
.end method

.method public final component13()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->pinnedAt Ljava/lang/String;
    return-object v0
.end method

.method public final component14()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->supportsPin Z
    return v0
.end method

.method public final component15()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal Z
    return v0
.end method

.method public final component16()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline Z
    return v0
.end method

.method public final component17()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public final component18()com.bytedance.trae.home.solo.task.TaskIconType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->iconType Lcom/bytedance/trae/home/solo/task/TaskIconType;
    return-object v0
.end method

.method public final component19()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchSnippet Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->initial Ljava/lang/String;
    return-object v0
.end method

.method public final component20()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchQuery Ljava/lang/String;
    return-object v0
.end method

.method public final component21()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchHighlightKeywords Ljava/util/List;
    return-object v0
.end method

.method public final component22()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchAnchorCreatedAtMs Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.home.solo.task.TaskStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->status Lcom/bytedance/trae/home/solo/task/TaskStatus;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->tag Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->location Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->time Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->updatedAt Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.home.solo.task.TaskStatus  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  boolean  java.lang.String  boolean  boolean  boolean  java.lang.String  com.bytedance.trae.home.solo.task.TaskIconType  java.lang.String  java.lang.String  java.util.List  java.lang.String)com.bytedance.trae.home.solo.task.TaskModel
    .registers 48
    # ins_size=23
    move-object/from16 v1, v26
    move-object/from16 v2, v27
    move-object/from16 v3, v28
    move-object/from16 v4, v29
    move-object/from16 v5, v30
    move-object/from16 v6, v31
    move-object/from16 v7, v32
    move-object/from16 v8, v33
    move-object/from16 v9, v34
    move-object/from16 v10, v35
    move/from16 v11, v36
    move/from16 v12, v37
    move-object/from16 v13, v38
    move/from16 v14, v39
    move/from16 v15, v40
    move/from16 v16, v41
    move-object/from16 v17, v42
    move-object/from16 v18, v43
    move-object/from16 v19, v44
    move-object/from16 v20, v45
    move-object/from16 v21, v46
    move-object/from16 v22, v47
    const-string v0, "id"
    move-object/from16 v23, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "initial"
    move-object/from16 v1, v27
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    move-object/from16 v1, v28
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    move-object/from16 v1, v29
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tag
    move-object/from16 v1, v30
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "location"
    move-object/from16 v1, v31
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, time
    move-object/from16 v1, v32
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, updatedAt
    move-object/from16 v1, v33
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliId"
    move-object/from16 v1, v34
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    move-object/from16 v1, v35
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pinnedAt"
    move-object/from16 v1, v38
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "iconType"
    move-object/from16 v1, v43
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, searchSnippet
    move-object/from16 v1, v44
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, searchQuery
    move-object/from16 v1, v45
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v24, Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-object/from16 v0, v24
    move-object/from16 v1, v23
    invoke-direct/range v0 ... v22, Lcom/bytedance/trae/home/solo/task/TaskModel;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String;)V
    return-object v24
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/task/TaskModel;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->initial Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->initial Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->status Lcom/bytedance/trae/home/solo/task/TaskStatus;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->status Lcom/bytedance/trae/home/solo/task/TaskStatus;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->tag Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->tag Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->location Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->location Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->time Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->time Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->updatedAt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->updatedAt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->mode Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->mode Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->isUnread Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->isUnread Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->pinnedAt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->pinnedAt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->supportsPin Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->supportsPin Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->iconType Lcom/bytedance/trae/home/solo/task/TaskIconType;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->iconType Lcom/bytedance/trae/home/solo/task/TaskIconType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchSnippet Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchSnippet Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchQuery Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchQuery Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchHighlightKeywords Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchHighlightKeywords Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchAnchorCreatedAtMs Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchAnchorCreatedAtMs Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getCliType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public final getIconType()com.bytedance.trae.home.solo.task.TaskIconType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->iconType Lcom/bytedance/trae/home/solo/task/TaskIconType;
    return-object v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getInitial()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->initial Ljava/lang/String;
    return-object v0
.end method

.method public final getLocation()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->location Ljava/lang/String;
    return-object v0
.end method

.method public final getMode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->mode Ljava/lang/String;
    return-object v0
.end method

.method public final getPinnedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->pinnedAt Ljava/lang/String;
    return-object v0
.end method

.method public final getSearchAnchorCreatedAtMs()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchAnchorCreatedAtMs Ljava/lang/String;
    return-object v0
.end method

.method public final getSearchHighlightKeywords()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchHighlightKeywords Ljava/util/List;
    return-object v0
.end method

.method public final getSearchQuery()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchQuery Ljava/lang/String;
    return-object v0
.end method

.method public final getSearchSnippet()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchSnippet Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()com.bytedance.trae.home.solo.task.TaskStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->status Lcom/bytedance/trae/home/solo/task/TaskStatus;
    return-object v0
.end method

.method public final getSupportsPin()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->supportsPin Z
    return v0
.end method

.method public final getTag()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->tag Ljava/lang/String;
    return-object v0
.end method

.method public final getTime()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->time Ljava/lang/String;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->title Ljava/lang/String;
    return-object v0
.end method

.method public final getUpdatedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->updatedAt Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->initial Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->title Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->status Lcom/bytedance/trae/home/solo/task/TaskStatus;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskStatus;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->tag Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->location Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->time Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->updatedAt Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->mode Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isUnread Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->pinnedAt Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->supportsPin Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliType Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->iconType Lcom/bytedance/trae/home/solo/task/TaskIconType;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskIconType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchSnippet Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchQuery Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchHighlightKeywords Ljava/util/List;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchAnchorCreatedAtMs Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isDeviceOnline()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline Z
    return v0
.end method

.method public final isLocal()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal Z
    return v0
.end method

.method public final isPinned()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned Z
    return v0
.end method

.method public final isUnread()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskModel;->isUnread Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TaskModel(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", initial="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->initial Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", title="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->title Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->status Lcom/bytedance/trae/home/solo/task/TaskStatus;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", tag="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->tag Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", location="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->location Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", time="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->time Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", updatedAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->updatedAt Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->mode Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isUnread="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isUnread Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isPinned="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", pinnedAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->pinnedAt Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", supportsPin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->supportsPin Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isLocal="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isLocal Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isDeviceOnline="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->isDeviceOnline Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->cliType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->iconType Lcom/bytedance/trae/home/solo/task/TaskIconType;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", searchSnippet="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchSnippet Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", searchQuery="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchQuery Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", searchHighlightKeywords="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchHighlightKeywords Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", searchAnchorCreatedAtMs="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->searchAnchorCreatedAtMs Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
