# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/CreateTaskRequest;
.super Ljava/lang/Object;
.source "ICreateAgentTask.kt"

.field private final autoCreateProject:Z
.field private final cliId:Ljava/lang/String;
.field private final cliType:Lcom/bytedance/trae/im/service/CliType;
.field private final commonParams:Ljava/lang/String;
.field private final conversationId:Ljava/lang/String;
.field private final extra:Ljava/util/Map;
.field private final hiddenStatus:Ljava/lang/String;
.field private final mode:Ljava/lang/String;
.field private final origin:Ljava/lang/String;
.field private final parentConversationId:Ljava/lang/String;
.field private final projectId:Ljava/lang/String;
.field private final query:Lcom/bytedance/trae/im/service/InitialMessage;
.field private final sessionType:Ljava/lang/String;
.field private final source:Lcom/bytedance/trae/im/service/Source;
.field private final workspaceDir:Ljava/lang/String;
.field private final workspaceFolders:Ljava/util/List;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  java.lang.String  java.lang.String  java.lang.String  java.util.List  boolean  com.bytedance.trae.im.service.InitialMessage  com.bytedance.trae.im.service.Source  java.lang.String  java.util.Map  java.lang.String)void
    .registers 20
    # ins_size=17
    move-object v0, v3
    move-object v1, v9
    const-string v2, "cliType"
    invoke-static v9, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    move-object v2, v4
    iput-object v2, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->conversationId Ljava/lang/String;
    move-object v2, v5
    iput-object v2, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->parentConversationId Ljava/lang/String;
    move-object v2, v6
    iput-object v2, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->sessionType Ljava/lang/String;
    move-object v2, v7
    iput-object v2, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->hiddenStatus Ljava/lang/String;
    move-object v2, v8
    iput-object v2, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliId Ljava/lang/String;
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliType Lcom/bytedance/trae/im/service/CliType;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->mode Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->projectId Ljava/lang/String;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceDir Ljava/lang/String;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceFolders Ljava/util/List;
    move v1, v14
    iput-boolean v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->autoCreateProject Z
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->query Lcom/bytedance/trae/im/service/InitialMessage;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->source Lcom/bytedance/trae/im/service/Source;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->origin Ljava/lang/String;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->extra Ljava/util/Map;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->commonParams Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  java.lang.String  java.lang.String  java.lang.String  java.util.List  boolean  com.bytedance.trae.im.service.InitialMessage  com.bytedance.trae.im.service.Source  java.lang.String  java.util.Map  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 39
    # ins_size=19
    move/from16 v0, v37
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v4, v2
    goto +3h
    move-object/from16 v4, v21
    and-int/lit8 v1, v0, 2
    if-eqz v1, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v22
    and-int/lit8 v1, v0, 4
    if-eqz v1, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v23
    and-int/lit8 v1, v0, 8
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v24
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v25
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v27
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v28
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v30
    and-int/lit16 v1, v0, 1024
    if-eqz v1, +005h
    const/4 v1, 0
    move v14, v1
    goto +3h
    move/from16 v14, v31
    and-int/lit16 v1, v0, 2048
    if-eqz v1, +004h
    move-object v15, v2
    goto +3h
    move-object/from16 v15, v32
    and-int/lit16 v1, v0, 4096
    if-eqz v1, +005h
    move-object/from16 v16, v2
    goto +3h
    move-object/from16 v16, v33
    and-int/lit16 v1, v0, 8192
    if-eqz v1, +005h
    move-object/from16 v17, v2
    goto +3h
    move-object/from16 v17, v34
    and-int/lit16 v1, v0, 16384
    if-eqz v1, +005h
    move-object/from16 v18, v2
    goto +3h
    move-object/from16 v18, v35
    const v1, 32768
    and-int/2addr v0, v1
    if-eqz v0, +005h
    move-object/from16 v19, v2
    goto +3h
    move-object/from16 v19, v36
    move-object/from16 v3, v20
    move-object/from16 v9, v26
    move-object/from16 v12, v29
    invoke-direct/range v3 ... v19, Lcom/bytedance/trae/im/service/CreateTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Z Lcom/bytedance/trae/im/service/InitialMessage; Lcom/bytedance/trae/im/service/Source; Ljava/lang/String; Ljava/util/Map; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.CreateTaskRequest  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  java.lang.String  java.lang.String  java.lang.String  java.util.List  boolean  com.bytedance.trae.im.service.InitialMessage  com.bytedance.trae.im.service.Source  java.lang.String  java.util.Map  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.CreateTaskRequest
    .registers 36
    # ins_size=19
    move-object/from16 v0, v17
    move/from16 v1, v34
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->conversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->parentConversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->sessionType Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->hiddenStatus Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliId Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliType Lcom/bytedance/trae/im/service/CliType;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->mode Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->projectId Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceDir Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceFolders Ljava/util/List;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-boolean v12, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->autoCreateProject Z
    goto +3h
    move/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->query Lcom/bytedance/trae/im/service/InitialMessage;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->source Lcom/bytedance/trae/im/service/Source;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->origin Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->extra Ljava/util/Map;
    goto +3h
    move-object/from16 v15, v32
    const v16, 32768
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRequest;->commonParams Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v33
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
    move-object/from16 v29, v13
    move-object/from16 v30, v14
    move-object/from16 v32, v15
    move-object/from16 v33, v1
    invoke-virtual/range v17 ... v33, Lcom/bytedance/trae/im/service/CreateTaskRequest;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Z Lcom/bytedance/trae/im/service/InitialMessage; Lcom/bytedance/trae/im/service/Source; Ljava/lang/String; Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/im/service/CreateTaskRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceFolders Ljava/util/List;
    return-object v0
.end method

.method public final component11()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->autoCreateProject Z
    return v0
.end method

.method public final component12()com.bytedance.trae.im.service.InitialMessage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->query Lcom/bytedance/trae/im/service/InitialMessage;
    return-object v0
.end method

.method public final component13()com.bytedance.trae.im.service.Source
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->source Lcom/bytedance/trae/im/service/Source;
    return-object v0
.end method

.method public final component14()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->origin Ljava/lang/String;
    return-object v0
.end method

.method public final component15()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->extra Ljava/util/Map;
    return-object v0
.end method

.method public final component16()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->commonParams Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->parentConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->sessionType Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->hiddenStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->mode Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->projectId Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceDir Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  java.lang.String  java.lang.String  java.lang.String  java.util.List  boolean  com.bytedance.trae.im.service.InitialMessage  com.bytedance.trae.im.service.Source  java.lang.String  java.util.Map  java.lang.String)com.bytedance.trae.im.service.CreateTaskRequest
    .registers 35
    # ins_size=17
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    move-object/from16 v3, v21
    move-object/from16 v4, v22
    move-object/from16 v5, v23
    move-object/from16 v6, v24
    move-object/from16 v7, v25
    move-object/from16 v8, v26
    move-object/from16 v9, v27
    move-object/from16 v10, v28
    move/from16 v11, v29
    move-object/from16 v12, v30
    move-object/from16 v13, v31
    move-object/from16 v14, v32
    move-object/from16 v15, v33
    move-object/from16 v16, v34
    const-string v0, "cliType"
    move-object/from16 v1, v24
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v17, Lcom/bytedance/trae/im/service/CreateTaskRequest;
    move-object/from16 v0, v17
    move-object/from16 v1, v19
    invoke-direct/range v0 ... v16, Lcom/bytedance/trae/im/service/CreateTaskRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Z Lcom/bytedance/trae/im/service/InitialMessage; Lcom/bytedance/trae/im/service/Source; Ljava/lang/String; Ljava/util/Map; Ljava/lang/String;)V
    return-object v17
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->conversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->parentConversationId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->parentConversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->sessionType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->sessionType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->hiddenStatus Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->hiddenStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliType Lcom/bytedance/trae/im/service/CliType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->mode Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->mode Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->projectId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->projectId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceDir Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceDir Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceFolders Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceFolders Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->autoCreateProject Z
    iget-boolean v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->autoCreateProject Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->query Lcom/bytedance/trae/im/service/InitialMessage;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->query Lcom/bytedance/trae/im/service/InitialMessage;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->source Lcom/bytedance/trae/im/service/Source;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->source Lcom/bytedance/trae/im/service/Source;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->origin Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->origin Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->extra Ljava/util/Map;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->extra Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRequest;->commonParams Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/CreateTaskRequest;->commonParams Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAutoCreateProject()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->autoCreateProject Z
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getCliType()com.bytedance.trae.im.service.CliType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public final getCommonParams()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->commonParams Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getExtra()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->extra Ljava/util/Map;
    return-object v0
.end method

.method public final getHiddenStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->hiddenStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getMode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->mode Ljava/lang/String;
    return-object v0
.end method

.method public final getOrigin()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->origin Ljava/lang/String;
    return-object v0
.end method

.method public final getParentConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->parentConversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getProjectId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->projectId Ljava/lang/String;
    return-object v0
.end method

.method public final getQuery()com.bytedance.trae.im.service.InitialMessage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->query Lcom/bytedance/trae/im/service/InitialMessage;
    return-object v0
.end method

.method public final getSessionType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->sessionType Ljava/lang/String;
    return-object v0
.end method

.method public final getSource()com.bytedance.trae.im.service.Source
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->source Lcom/bytedance/trae/im/service/Source;
    return-object v0
.end method

.method public final getWorkspaceDir()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceDir Ljava/lang/String;
    return-object v0
.end method

.method public final getWorkspaceFolders()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceFolders Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->conversationId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->parentConversationId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->sessionType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->hiddenStatus Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->mode Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->projectId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceDir Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceFolders Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->autoCreateProject Z
    invoke-static v2, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->query Lcom/bytedance/trae/im/service/InitialMessage;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/InitialMessage;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->source Lcom/bytedance/trae/im/service/Source;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Source;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->origin Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->extra Ljava/util/Map;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->commonParams Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CreateTaskRequest(conversationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", parentConversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->parentConversationId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->sessionType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hiddenStatus="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->hiddenStatus Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->mode Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", projectId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->projectId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", workspaceDir="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceDir Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", workspaceFolders="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->workspaceFolders Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", autoCreateProject="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->autoCreateProject Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", query="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->query Lcom/bytedance/trae/im/service/InitialMessage;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", source="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->source Lcom/bytedance/trae/im/service/Source;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", origin="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->origin Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", extra="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->extra Ljava/util/Map;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", commonParams="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRequest;->commonParams Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
