# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/Conversation;
.super Ljava/lang/Object;
.source "IListConversationsService.kt"

.implements Ljava/io/Serializable;

.field private final cliConversationId:Ljava/lang/String;
.field private final cliConversationStatus:Ljava/lang/Integer;
.field private final cliId:Ljava/lang/String;
.field private final createdAt:Ljava/lang/String;
.field private environment:Ljava/lang/String;
.field private final gitUri:Ljava/lang/String;
.field private final hiddenStatus:Ljava/lang/String;
.field private final iconType:Ljava/lang/String;
.field private final id:Ljava/lang/String;
.field private final isPinned:Ljava/lang/Boolean;
.field private final latestProjectId:Ljava/lang/String;
.field private final latestTaskId:Ljava/lang/String;
.field private final latestTaskStatus:Ljava/lang/String;
.field private final latestTaskUpdateTime:Ljava/lang/String;
.field private mode:Ljava/lang/String;
.field private final ownerProjectAbsolutePath:Ljava/lang/String;
.field private final ownerProjectId:Ljava/lang/String;
.field private final ownerProjectWorkSpaceStatus:Ljava/lang/String;
.field private final parentConversationId:Ljava/lang/String;
.field private final pinnedAt:Ljava/lang/String;
.field private final source:Lcom/bytedance/trae/im/service/ConversationSource;
.field private final status:Ljava/lang/String;
.field private final title:Ljava/lang/String;
.field private final updatedAt:Ljava/lang/String;
.field private final userId:Ljava/lang/String;
.field private final workspace:Ljava/lang/String;


.method public constructor <init>()void
    .registers 30
    # ins_size=1
    move-object/from16 v0, v29
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
    const v27, 67108863
    const/16 v28, 0
    invoke-direct/range v0 ... v28, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ConversationSource  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String)void
    .registers 29
    # ins_size=27
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->id Ljava/lang/String;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->parentConversationId Ljava/lang/String;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->hiddenStatus Ljava/lang/String;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->cliConversationId Ljava/lang/String;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->userId Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->cliId Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->title Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->status Ljava/lang/String;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->latestTaskId Ljava/lang/String;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->latestTaskStatus Ljava/lang/String;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->latestTaskUpdateTime Ljava/lang/String;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->createdAt Ljava/lang/String;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->updatedAt Ljava/lang/String;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->iconType Ljava/lang/String;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->cliConversationStatus Ljava/lang/Integer;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectId Ljava/lang/String;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->latestProjectId Ljava/lang/String;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectAbsolutePath Ljava/lang/String;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectWorkSpaceStatus Ljava/lang/String;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->isPinned Ljava/lang/Boolean;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->pinnedAt Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ConversationSource  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 56
    # ins_size=29
    move/from16 v0, v54
    and-int/lit8 v1, v0, 1
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    move-object/from16 v1, v28
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move-object/from16 v3, v29
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    const/4 v4, 0
    goto +3h
    move-object/from16 v4, v30
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move-object/from16 v5, v31
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    const/4 v6, 0
    goto +3h
    move-object/from16 v6, v32
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    const/4 v7, 0
    goto +3h
    move-object/from16 v7, v33
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    move-object/from16 v8, v34
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    const/4 v9, 0
    goto +3h
    move-object/from16 v9, v35
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    const/4 v10, 0
    goto +3h
    move-object/from16 v10, v36
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    const/4 v11, 0
    goto +3h
    move-object/from16 v11, v37
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move-object/from16 v12, v38
    and-int/lit16 v13, v0, 2048
    if-eqz v13, +004h
    const/4 v13, 0
    goto +3h
    move-object/from16 v13, v39
    and-int/lit16 v14, v0, 4096
    if-eqz v14, +004h
    const/4 v14, 0
    goto +3h
    move-object/from16 v14, v40
    and-int/lit16 v15, v0, 8192
    if-eqz v15, +004h
    const/4 v15, 0
    goto +3h
    move-object/from16 v15, v41
    and-int/lit16 v2, v0, 16384
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    move-object/from16 v2, v42
    const v16, 32768
    and-int v16, v0, v16
    if-eqz v16, +005h
    const/16 v16, 0
    goto +3h
    move-object/from16 v16, v43
    const/high16 v17, 65536
    and-int v17, v0, v17
    if-eqz v17, +005h
    const/16 v17, 0
    goto +3h
    move-object/from16 v17, v44
    const/high16 v18, 131072
    and-int v18, v0, v18
    if-eqz v18, +005h
    const/16 v18, 0
    goto +3h
    move-object/from16 v18, v45
    const/high16 v19, 262144
    and-int v19, v0, v19
    if-eqz v19, +005h
    const/16 v19, 0
    goto +3h
    move-object/from16 v19, v46
    const/high16 v20, 524288
    and-int v20, v0, v20
    if-eqz v20, +005h
    const/16 v20, 0
    goto +3h
    move-object/from16 v20, v47
    const/high16 v21, 1048576
    and-int v21, v0, v21
    if-eqz v21, +005h
    const/16 v21, 0
    goto +3h
    move-object/from16 v21, v48
    const/high16 v22, 2097152
    and-int v22, v0, v22
    if-eqz v22, +005h
    const/16 v22, 0
    goto +3h
    move-object/from16 v22, v49
    const/high16 v23, 4194304
    and-int v23, v0, v23
    if-eqz v23, +005h
    const/16 v23, 0
    goto +3h
    move-object/from16 v23, v50
    const/high16 v24, 8388608
    and-int v24, v0, v24
    if-eqz v24, +005h
    const/16 v24, 0
    goto +3h
    move-object/from16 v24, v51
    const/high16 v25, 16777216
    and-int v25, v0, v25
    if-eqz v25, +005h
    const/16 v25, 0
    goto +3h
    move-object/from16 v25, v52
    const/high16 v26, 33554432
    and-int v0, v0, v26
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move-object/from16 v0, v53
    move-object/from16 v28, v27
    move-object/from16 v29, v1
    move-object/from16 v30, v3
    move-object/from16 v31, v4
    move-object/from16 v32, v5
    move-object/from16 v33, v6
    move-object/from16 v34, v7
    move-object/from16 v35, v8
    move-object/from16 v36, v9
    move-object/from16 v37, v10
    move-object/from16 v38, v11
    move-object/from16 v39, v12
    move-object/from16 v40, v13
    move-object/from16 v41, v14
    move-object/from16 v42, v15
    move-object/from16 v43, v2
    move-object/from16 v44, v16
    move-object/from16 v45, v17
    move-object/from16 v46, v18
    move-object/from16 v47, v19
    move-object/from16 v48, v20
    move-object/from16 v49, v21
    move-object/from16 v50, v22
    move-object/from16 v51, v23
    move-object/from16 v52, v24
    move-object/from16 v53, v25
    move-object/from16 v54, v0
    invoke-direct/range v28 ... v54, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.Conversation  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ConversationSource  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.Conversation
    .registers 46
    # ins_size=29
    move-object/from16 v0, v17
    move/from16 v1, v44
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/Conversation;->id Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/Conversation;->parentConversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/Conversation;->hiddenStatus Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/Conversation;->cliConversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/Conversation;->userId Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/Conversation;->cliId Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/Conversation;->title Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/service/Conversation;->status Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/im/service/Conversation;->latestTaskId Ljava/lang/String;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->latestTaskStatus Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->latestTaskUpdateTime Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move-object/from16 v32, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->createdAt Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v33, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->updatedAt Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v34
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-object/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->iconType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v36
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->cliConversationStatus Ljava/lang/Integer;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move-object/from16 v37, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v38
    const/high16 v16, 2097152
    and-int v16, v1, v16
    move-object/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->latestProjectId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 4194304
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectAbsolutePath Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v40
    const/high16 v16, 8388608
    and-int v16, v1, v16
    move-object/from16 v40, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectWorkSpaceStatus Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v41
    const/high16 v16, 16777216
    and-int v16, v1, v16
    move-object/from16 v41, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/Conversation;->isPinned Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v42
    const/high16 v16, 33554432
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->pinnedAt Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v43
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
    move-object/from16 v28, v12
    move-object/from16 v29, v13
    move-object/from16 v30, v14
    move-object/from16 v42, v15
    move-object/from16 v43, v1
    invoke-virtual/range v17 ... v43, Lcom/bytedance/trae/im/service/Conversation;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component12()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    return-object v0
.end method

.method public final component13()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->latestTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final component14()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->latestTaskStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component15()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->latestTaskUpdateTime Ljava/lang/String;
    return-object v0
.end method

.method public final component16()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->createdAt Ljava/lang/String;
    return-object v0
.end method

.method public final component17()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->updatedAt Ljava/lang/String;
    return-object v0
.end method

.method public final component18()com.bytedance.trae.im.service.ConversationSource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    return-object v0
.end method

.method public final component19()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->iconType Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->parentConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component20()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->cliConversationStatus Ljava/lang/Integer;
    return-object v0
.end method

.method public final component21()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectId Ljava/lang/String;
    return-object v0
.end method

.method public final component22()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->latestProjectId Ljava/lang/String;
    return-object v0
.end method

.method public final component23()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectAbsolutePath Ljava/lang/String;
    return-object v0
.end method

.method public final component24()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectWorkSpaceStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component25()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->isPinned Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component26()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->pinnedAt Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->hiddenStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.ConversationSource  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String)com.bytedance.trae.im.service.Conversation
    .registers 55
    # ins_size=27
    move-object/from16 v1, v29
    move-object/from16 v2, v30
    move-object/from16 v3, v31
    move-object/from16 v4, v32
    move-object/from16 v5, v33
    move-object/from16 v6, v34
    move-object/from16 v7, v35
    move-object/from16 v8, v36
    move-object/from16 v9, v37
    move-object/from16 v10, v38
    move-object/from16 v11, v39
    move-object/from16 v12, v40
    move-object/from16 v13, v41
    move-object/from16 v14, v42
    move-object/from16 v15, v43
    move-object/from16 v16, v44
    move-object/from16 v17, v45
    move-object/from16 v18, v46
    move-object/from16 v19, v47
    move-object/from16 v20, v48
    move-object/from16 v21, v49
    move-object/from16 v22, v50
    move-object/from16 v23, v51
    move-object/from16 v24, v52
    move-object/from16 v25, v53
    move-object/from16 v26, v54
    new-instance v27, Lcom/bytedance/trae/im/service/Conversation;
    move-object/from16 v0, v27
    invoke-direct/range v0 ... v26, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String;)V
    return-object v27
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/Conversation;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/Conversation;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->parentConversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->parentConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->hiddenStatus Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->hiddenStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->cliConversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->cliConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->userId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->cliId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->latestTaskId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->latestTaskId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->latestTaskStatus Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->latestTaskStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->latestTaskUpdateTime Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->latestTaskUpdateTime Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->createdAt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->createdAt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->updatedAt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->updatedAt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->iconType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->iconType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->cliConversationStatus Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->cliConversationStatus Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->latestProjectId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->latestProjectId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectAbsolutePath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectAbsolutePath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectWorkSpaceStatus Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectWorkSpaceStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->isPinned Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/Conversation;->isPinned Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/Conversation;->pinnedAt Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/Conversation;->pinnedAt Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCliConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->cliConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getCliConversationStatus()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->cliConversationStatus Ljava/lang/Integer;
    return-object v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->createdAt Ljava/lang/String;
    return-object v0
.end method

.method public final getDisplayEnvironment()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    if-nez v0, +004h
    const-string v0, "remote"
    return-object v0
.end method

.method public final getDisplayGitUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    if-nez v0, +00ch
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ConversationSource;->getRepoUrl()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getDisplayRepoName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ConversationSource;->getRepoName()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getDisplayWorkspace()java.lang.String
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    if-nez v0, +019h
    iget-object v0, v2, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ConversationSource;->getRemoteFolder()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +00ch
    iget-object v0, v2, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ConversationSource;->getLocalFolder()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    return-object v0
.end method

.method public final getEnvironment()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    return-object v0
.end method

.method public final getGitUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    return-object v0
.end method

.method public final getHiddenStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->hiddenStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getIconType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->iconType Ljava/lang/String;
    return-object v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getLatestProjectId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->latestProjectId Ljava/lang/String;
    return-object v0
.end method

.method public final getLatestTaskId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->latestTaskId Ljava/lang/String;
    return-object v0
.end method

.method public final getLatestTaskStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->latestTaskStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getLatestTaskUpdateTime()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->latestTaskUpdateTime Ljava/lang/String;
    return-object v0
.end method

.method public final getMode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    return-object v0
.end method

.method public final getOwnerProjectAbsolutePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectAbsolutePath Ljava/lang/String;
    return-object v0
.end method

.method public final getOwnerProjectId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectId Ljava/lang/String;
    return-object v0
.end method

.method public final getOwnerProjectWorkSpaceStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectWorkSpaceStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getParentConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->parentConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getPinnedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->pinnedAt Ljava/lang/String;
    return-object v0
.end method

.method public final getSource()com.bytedance.trae.im.service.ConversationSource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->title Ljava/lang/String;
    return-object v0
.end method

.method public final getUpdatedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->updatedAt Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final getWorkspace()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/Conversation;->id Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->parentConversationId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->hiddenStatus Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->cliConversationId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->userId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->cliId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->title Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->status Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->latestTaskId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->latestTaskStatus Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->latestTaskUpdateTime Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->createdAt Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->updatedAt Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/ConversationSource;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->iconType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->cliConversationStatus Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->latestProjectId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectAbsolutePath Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectWorkSpaceStatus Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->isPinned Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->pinnedAt Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isLocal()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    const-string v1, "local"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00fh
    iget-object v0, v2, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    const-string v1, "local_ide"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    return v0
.end method

.method public final isPinned()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/Conversation;->isPinned Ljava/lang/Boolean;
    return-object v0
.end method

.method public final setEnvironment(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    return-void 
.end method

.method public final setMode(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    return-void 
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Conversation(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/service/Conversation;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", parentConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->parentConversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hiddenStatus="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->hiddenStatus Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->cliConversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->userId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->cliId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", title="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->title Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", workspace="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->workspace Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", gitUri="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->gitUri Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->mode Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->status Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", environment="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/Conversation;->environment Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", latestTaskId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->latestTaskId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", latestTaskStatus="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->latestTaskStatus Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", latestTaskUpdateTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->latestTaskUpdateTime Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", createdAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->createdAt Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", updatedAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->updatedAt Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", source="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->source Lcom/bytedance/trae/im/service/ConversationSource;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->iconType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliConversationStatus="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->cliConversationStatus Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", ownerProjectId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", latestProjectId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->latestProjectId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", ownerProjectAbsolutePath="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectAbsolutePath Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v1, ", ownerProjectWorkSpaceStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->ownerProjectWorkSpaceStatus Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isPinned="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->isPinned Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", pinnedAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/Conversation;->pinnedAt Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
