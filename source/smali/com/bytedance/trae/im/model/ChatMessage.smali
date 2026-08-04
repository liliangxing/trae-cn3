# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/ChatMessage;
.super Ljava/lang/Object;
.source "ChatMessage.kt"

.field private final agentAvatarId:Ljava/lang/String;
.field private final agentId:Ljava/lang/String;
.field private final agentName:Ljava/lang/String;
.field private final agentProcessSupport:Ljava/lang/String;
.field private final agentType:Ljava/lang/String;
.field private final chatEndTime:Ljava/lang/Long;
.field private final chatProcessVersion:Ljava/lang/String;
.field private final chatSessionId:Ljava/lang/String;
.field private final chatStartTime:Ljava/lang/Long;
.field private final content:Ljava/lang/String;
.field private final contextMetadata:Ljava/lang/String;
.field private final contextUsage:Ljava/lang/String;
.field private final createdAt:Ljava/lang/String;
.field private final createdAtMs:Ljava/lang/String;
.field private final docReferences:Ljava/lang/String;
.field private final error:Ljava/lang/String;
.field private final fastRequestSavings:Ljava/lang/String;
.field private final feeUsage:Ljava/lang/String;
.field private final fromAppendMsg:Ljava/lang/Boolean;
.field private final isArchived:Ljava/lang/Boolean;
.field private final isUserCanceled:Ljava/lang/Boolean;
.field private final isWorktree:Ljava/lang/Boolean;
.field private final maxFeeUsage:Ljava/lang/String;
.field private final messageId:Ljava/lang/String;
.field private final messageIndex:Ljava/lang/Long;
.field private final messageType:Ljava/lang/String;
.field private final modelSmartSelectionMeta:Ljava/lang/String;
.field private final notifications:Ljava/lang/String;
.field private final query:Ljava/lang/String;
.field private final references:Ljava/lang/String;
.field private final replyToMessageId:Ljava/lang/String;
.field private final revertible:Ljava/lang/Boolean;
.field private final role:Ljava/lang/String;
.field private final searchReferenceData:Ljava/lang/String;
.field private final shallowMementoType:Ljava/lang/String;
.field private final status:Ljava/lang/String;
.field private final tokenUsage:Ljava/lang/String;
.field private final traceId:Ljava/lang/String;
.field private final turnId:Ljava/lang/String;
.field private final userMessageContext:Ljava/lang/String;
.field private final versionCode:Ljava/lang/Long;


.method public constructor <init>()void
    .registers 46
    # ins_size=1
    move-object/from16 v0, v45
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
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, -1
    const/16 v43, 511
    const/16 v44, 0
    invoke-direct/range v0 ... v44, Lcom/bytedance/trae/im/model/ChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long)void
    .registers 44
    # ins_size=42
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->chatSessionId Ljava/lang/String;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->messageId Ljava/lang/String;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->turnId Ljava/lang/String;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->status Ljava/lang/String;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->messageType Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->role Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->messageIndex Ljava/lang/Long;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->content Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->replyToMessageId Ljava/lang/String;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->userMessageContext Ljava/lang/String;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->error Ljava/lang/String;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->revertible Ljava/lang/Boolean;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->versionCode Ljava/lang/Long;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->references Ljava/lang/String;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->contextMetadata Ljava/lang/String;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->searchReferenceData Ljava/lang/String;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->docReferences Ljava/lang/String;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentType Ljava/lang/String;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentId Ljava/lang/String;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentName Ljava/lang/String;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentAvatarId Ljava/lang/String;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->traceId Ljava/lang/String;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->createdAt Ljava/lang/String;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->createdAtMs Ljava/lang/String;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->feeUsage Ljava/lang/String;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->maxFeeUsage Ljava/lang/String;
    move-object/from16 v1, v29
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->notifications Ljava/lang/String;
    move-object/from16 v1, v30
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->modelSmartSelectionMeta Ljava/lang/String;
    move-object/from16 v1, v31
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    move-object/from16 v1, v32
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->shallowMementoType Ljava/lang/String;
    move-object/from16 v1, v33
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->chatProcessVersion Ljava/lang/String;
    move-object/from16 v1, v34
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->tokenUsage Ljava/lang/String;
    move-object/from16 v1, v35
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->contextUsage Ljava/lang/String;
    move-object/from16 v1, v36
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentProcessSupport Ljava/lang/String;
    move-object/from16 v1, v37
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->fastRequestSavings Ljava/lang/String;
    move-object/from16 v1, v38
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree Ljava/lang/Boolean;
    move-object/from16 v1, v39
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->query Ljava/lang/String;
    move-object/from16 v1, v40
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->isArchived Ljava/lang/Boolean;
    move-object/from16 v1, v41
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled Ljava/lang/Boolean;
    move-object/from16 v1, v42
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->chatStartTime Ljava/lang/Long;
    move-object/from16 v1, v43
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->chatEndTime Ljava/lang/Long;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 85
    # ins_size=45
    move/from16 v0, v82
    move/from16 v1, v83
    and-int/lit8 v2, v0, 1
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    move-object/from16 v2, v41
    and-int/lit8 v4, v0, 2
    if-eqz v4, +004h
    const/4 v4, 0
    goto +3h
    move-object/from16 v4, v42
    and-int/lit8 v5, v0, 4
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move-object/from16 v5, v43
    and-int/lit8 v6, v0, 8
    if-eqz v6, +004h
    const/4 v6, 0
    goto +3h
    move-object/from16 v6, v44
    and-int/lit8 v7, v0, 16
    if-eqz v7, +004h
    const/4 v7, 0
    goto +3h
    move-object/from16 v7, v45
    and-int/lit8 v8, v0, 32
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    move-object/from16 v8, v46
    and-int/lit8 v9, v0, 64
    if-eqz v9, +004h
    const/4 v9, 0
    goto +3h
    move-object/from16 v9, v47
    and-int/lit16 v10, v0, 128
    if-eqz v10, +004h
    const/4 v10, 0
    goto +3h
    move-object/from16 v10, v48
    and-int/lit16 v11, v0, 256
    if-eqz v11, +004h
    const/4 v11, 0
    goto +3h
    move-object/from16 v11, v49
    and-int/lit16 v12, v0, 512
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move-object/from16 v12, v50
    and-int/lit16 v13, v0, 1024
    if-eqz v13, +004h
    const/4 v13, 0
    goto +3h
    move-object/from16 v13, v51
    and-int/lit16 v14, v0, 2048
    if-eqz v14, +004h
    const/4 v14, 0
    goto +3h
    move-object/from16 v14, v52
    and-int/lit16 v15, v0, 4096
    if-eqz v15, +004h
    const/4 v15, 0
    goto +3h
    move-object/from16 v15, v53
    and-int/lit16 v3, v0, 8192
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move-object/from16 v3, v54
    move-object/from16 v16, v3
    and-int/lit16 v3, v0, 16384
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move-object/from16 v3, v55
    const v17, 32768
    and-int v17, v0, v17
    if-eqz v17, +005h
    const/16 v17, 0
    goto +3h
    move-object/from16 v17, v56
    const/high16 v18, 65536
    and-int v18, v0, v18
    if-eqz v18, +005h
    const/16 v18, 0
    goto +3h
    move-object/from16 v18, v57
    const/high16 v19, 131072
    and-int v19, v0, v19
    if-eqz v19, +005h
    const/16 v19, 0
    goto +3h
    move-object/from16 v19, v58
    const/high16 v20, 262144
    and-int v20, v0, v20
    if-eqz v20, +005h
    const/16 v20, 0
    goto +3h
    move-object/from16 v20, v59
    const/high16 v21, 524288
    and-int v21, v0, v21
    if-eqz v21, +005h
    const/16 v21, 0
    goto +3h
    move-object/from16 v21, v60
    const/high16 v22, 1048576
    and-int v22, v0, v22
    if-eqz v22, +005h
    const/16 v22, 0
    goto +3h
    move-object/from16 v22, v61
    const/high16 v23, 2097152
    and-int v23, v0, v23
    if-eqz v23, +005h
    const/16 v23, 0
    goto +3h
    move-object/from16 v23, v62
    const/high16 v24, 4194304
    and-int v24, v0, v24
    if-eqz v24, +005h
    const/16 v24, 0
    goto +3h
    move-object/from16 v24, v63
    const/high16 v25, 8388608
    and-int v25, v0, v25
    if-eqz v25, +005h
    const/16 v25, 0
    goto +3h
    move-object/from16 v25, v64
    const/high16 v26, 16777216
    and-int v26, v0, v26
    if-eqz v26, +005h
    const/16 v26, 0
    goto +3h
    move-object/from16 v26, v65
    const/high16 v27, 33554432
    and-int v27, v0, v27
    if-eqz v27, +005h
    const/16 v27, 0
    goto +3h
    move-object/from16 v27, v66
    const/high16 v28, 67108864
    and-int v28, v0, v28
    if-eqz v28, +005h
    const/16 v28, 0
    goto +3h
    move-object/from16 v28, v67
    const/high16 v29, 134217728
    and-int v29, v0, v29
    if-eqz v29, +005h
    const/16 v29, 0
    goto +3h
    move-object/from16 v29, v68
    const/high16 v30, 268435456
    and-int v30, v0, v30
    if-eqz v30, +005h
    const/16 v30, 0
    goto +3h
    move-object/from16 v30, v69
    const/high16 v31, 536870912
    and-int v31, v0, v31
    if-eqz v31, +005h
    const/16 v31, 0
    goto +3h
    move-object/from16 v31, v70
    const/high16 v32, 1073741824
    and-int v32, v0, v32
    if-eqz v32, +005h
    const/16 v32, 0
    goto +3h
    move-object/from16 v32, v71
    const/high16 v33, -2147483648
    and-int v0, v0, v33
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move-object/from16 v0, v72
    and-int/lit8 v33, v1, 1
    if-eqz v33, +005h
    const/16 v33, 0
    goto +3h
    move-object/from16 v33, v73
    and-int/lit8 v34, v1, 2
    if-eqz v34, +005h
    const/16 v34, 0
    goto +3h
    move-object/from16 v34, v74
    and-int/lit8 v35, v1, 4
    if-eqz v35, +005h
    const/16 v35, 0
    goto +3h
    move-object/from16 v35, v75
    and-int/lit8 v36, v1, 8
    if-eqz v36, +005h
    const/16 v36, 0
    goto +3h
    move-object/from16 v36, v76
    and-int/lit8 v37, v1, 16
    if-eqz v37, +005h
    const/16 v37, 0
    goto +3h
    move-object/from16 v37, v77
    and-int/lit8 v38, v1, 32
    if-eqz v38, +005h
    const/16 v38, 0
    goto +3h
    move-object/from16 v38, v78
    and-int/lit8 v39, v1, 64
    if-eqz v39, +005h
    const/16 v39, 0
    goto +3h
    move-object/from16 v39, v79
    move-object/from16 v82, v0
    and-int/lit16 v0, v1, 128
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move-object/from16 v0, v80
    and-int/lit16 v1, v1, 256
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    move-object/from16 v1, v81
    move-object/from16 v41, v40
    move-object/from16 v42, v2
    move-object/from16 v43, v4
    move-object/from16 v44, v5
    move-object/from16 v45, v6
    move-object/from16 v46, v7
    move-object/from16 v47, v8
    move-object/from16 v48, v9
    move-object/from16 v49, v10
    move-object/from16 v50, v11
    move-object/from16 v51, v12
    move-object/from16 v52, v13
    move-object/from16 v53, v14
    move-object/from16 v54, v15
    move-object/from16 v55, v16
    move-object/from16 v56, v3
    move-object/from16 v57, v17
    move-object/from16 v58, v18
    move-object/from16 v59, v19
    move-object/from16 v60, v20
    move-object/from16 v61, v21
    move-object/from16 v62, v22
    move-object/from16 v63, v23
    move-object/from16 v64, v24
    move-object/from16 v65, v25
    move-object/from16 v66, v26
    move-object/from16 v67, v27
    move-object/from16 v68, v28
    move-object/from16 v69, v29
    move-object/from16 v70, v30
    move-object/from16 v71, v31
    move-object/from16 v72, v32
    move-object/from16 v73, v82
    move-object/from16 v74, v33
    move-object/from16 v75, v34
    move-object/from16 v76, v35
    move-object/from16 v77, v36
    move-object/from16 v78, v37
    move-object/from16 v79, v38
    move-object/from16 v80, v39
    move-object/from16 v81, v0
    move-object/from16 v82, v1
    invoke-direct/range v41 ... v82, Lcom/bytedance/trae/im/model/ChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.model.ChatMessage  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  int  int  java.lang.Object)com.bytedance.trae.im.model.ChatMessage
    .registers 62
    # ins_size=45
    move-object/from16 v0, v17
    move/from16 v1, v59
    move/from16 v2, v60
    and-int/lit8 v3, v1, 1
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/model/ChatMessage;->chatSessionId Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v18
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/model/ChatMessage;->messageId Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v19
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/model/ChatMessage;->turnId Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v20
    and-int/lit8 v6, v1, 8
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/model/ChatMessage;->status Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v21
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/model/ChatMessage;->messageType Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v22
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/model/ChatMessage;->role Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v23
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/model/ChatMessage;->messageIndex Ljava/lang/Long;
    goto +3h
    move-object/from16 v9, v24
    and-int/lit16 v10, v1, 128
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/model/ChatMessage;->content Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v25
    and-int/lit16 v11, v1, 256
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/model/ChatMessage;->replyToMessageId Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v26
    and-int/lit16 v12, v1, 512
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/model/ChatMessage;->userMessageContext Ljava/lang/String;
    goto +3h
    move-object/from16 v12, v27
    and-int/lit16 v13, v1, 1024
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/im/model/ChatMessage;->error Ljava/lang/String;
    goto +3h
    move-object/from16 v13, v28
    and-int/lit16 v14, v1, 2048
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/im/model/ChatMessage;->revertible Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v14, v29
    and-int/lit16 v15, v1, 4096
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->versionCode Ljava/lang/Long;
    goto +3h
    move-object/from16 v15, v30
    move-object/from16 v30, v15
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->references Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->contextMetadata Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move-object/from16 v32, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->searchReferenceData Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v33, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->docReferences Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v34
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-object/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v36
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentName Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move-object/from16 v37, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentAvatarId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v38
    const/high16 v16, 2097152
    and-int v16, v1, v16
    move-object/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->traceId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 4194304
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->createdAt Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v40
    const/high16 v16, 8388608
    and-int v16, v1, v16
    move-object/from16 v40, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->createdAtMs Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v41
    const/high16 v16, 16777216
    and-int v16, v1, v16
    move-object/from16 v41, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->feeUsage Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v42
    const/high16 v16, 33554432
    and-int v16, v1, v16
    move-object/from16 v42, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->maxFeeUsage Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v43
    const/high16 v16, 67108864
    and-int v16, v1, v16
    move-object/from16 v43, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->notifications Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v44
    const/high16 v16, 134217728
    and-int v16, v1, v16
    move-object/from16 v44, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->modelSmartSelectionMeta Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v45
    const/high16 v16, 268435456
    and-int v16, v1, v16
    move-object/from16 v45, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v46
    const/high16 v16, 536870912
    and-int v16, v1, v16
    move-object/from16 v46, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->shallowMementoType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v47
    const/high16 v16, 1073741824
    and-int v16, v1, v16
    move-object/from16 v47, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ChatMessage;->chatProcessVersion Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v48
    const/high16 v16, -2147483648
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->tokenUsage Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v49
    and-int/lit8 v16, v2, 1
    move-object/from16 v49, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->contextUsage Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v50
    and-int/lit8 v16, v2, 2
    move-object/from16 v50, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->agentProcessSupport Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v51
    and-int/lit8 v16, v2, 4
    move-object/from16 v51, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->fastRequestSavings Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v52
    and-int/lit8 v16, v2, 8
    move-object/from16 v52, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v1, v53
    and-int/lit8 v16, v2, 16
    move-object/from16 v53, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->query Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v54
    and-int/lit8 v16, v2, 32
    move-object/from16 v54, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->isArchived Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v1, v55
    and-int/lit8 v16, v2, 64
    move-object/from16 v55, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v1, v56
    move-object/from16 v56, v1
    and-int/lit16 v1, v2, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessage;->chatStartTime Ljava/lang/Long;
    goto +3h
    move-object/from16 v1, v57
    and-int/lit16 v2, v2, 256
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/model/ChatMessage;->chatEndTime Ljava/lang/Long;
    goto +3h
    move-object/from16 v2, v58
    move-object/from16 v18, v3
    move-object/from16 v19, v4
    move-object/from16 v20, v5
    move-object/from16 v21, v6
    move-object/from16 v22, v7
    move-object/from16 v23, v8
    move-object/from16 v24, v9
    move-object/from16 v25, v10
    move-object/from16 v26, v11
    move-object/from16 v27, v12
    move-object/from16 v28, v13
    move-object/from16 v29, v14
    move-object/from16 v48, v15
    move-object/from16 v57, v1
    move-object/from16 v58, v2
    invoke-virtual/range v17 ... v58, Lcom/bytedance/trae/im/model/ChatMessage;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long;)Lcom/bytedance/trae/im/model/ChatMessage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->userMessageContext Ljava/lang/String;
    return-object v0
.end method

.method public final component11()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->error Ljava/lang/String;
    return-object v0
.end method

.method public final component12()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->revertible Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component13()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->versionCode Ljava/lang/Long;
    return-object v0
.end method

.method public final component14()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->references Ljava/lang/String;
    return-object v0
.end method

.method public final component15()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->contextMetadata Ljava/lang/String;
    return-object v0
.end method

.method public final component16()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->searchReferenceData Ljava/lang/String;
    return-object v0
.end method

.method public final component17()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->docReferences Ljava/lang/String;
    return-object v0
.end method

.method public final component18()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final component19()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component20()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentName Ljava/lang/String;
    return-object v0
.end method

.method public final component21()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentAvatarId Ljava/lang/String;
    return-object v0
.end method

.method public final component22()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->traceId Ljava/lang/String;
    return-object v0
.end method

.method public final component23()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->createdAt Ljava/lang/String;
    return-object v0
.end method

.method public final component24()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->createdAtMs Ljava/lang/String;
    return-object v0
.end method

.method public final component25()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->feeUsage Ljava/lang/String;
    return-object v0
.end method

.method public final component26()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->maxFeeUsage Ljava/lang/String;
    return-object v0
.end method

.method public final component27()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->notifications Ljava/lang/String;
    return-object v0
.end method

.method public final component28()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->modelSmartSelectionMeta Ljava/lang/String;
    return-object v0
.end method

.method public final component29()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public final component30()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->shallowMementoType Ljava/lang/String;
    return-object v0
.end method

.method public final component31()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->chatProcessVersion Ljava/lang/String;
    return-object v0
.end method

.method public final component32()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->tokenUsage Ljava/lang/String;
    return-object v0
.end method

.method public final component33()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->contextUsage Ljava/lang/String;
    return-object v0
.end method

.method public final component34()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentProcessSupport Ljava/lang/String;
    return-object v0
.end method

.method public final component35()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->fastRequestSavings Ljava/lang/String;
    return-object v0
.end method

.method public final component36()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component37()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->query Ljava/lang/String;
    return-object v0
.end method

.method public final component38()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->isArchived Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component39()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component40()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->chatStartTime Ljava/lang/Long;
    return-object v0
.end method

.method public final component41()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->chatEndTime Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->messageType Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->role Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->messageIndex Ljava/lang/Long;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long)com.bytedance.trae.im.model.ChatMessage
    .registers 85
    # ins_size=42
    move-object/from16 v1, v44
    move-object/from16 v2, v45
    move-object/from16 v3, v46
    move-object/from16 v4, v47
    move-object/from16 v5, v48
    move-object/from16 v6, v49
    move-object/from16 v7, v50
    move-object/from16 v8, v51
    move-object/from16 v9, v52
    move-object/from16 v10, v53
    move-object/from16 v11, v54
    move-object/from16 v12, v55
    move-object/from16 v13, v56
    move-object/from16 v14, v57
    move-object/from16 v15, v58
    move-object/from16 v16, v59
    move-object/from16 v17, v60
    move-object/from16 v18, v61
    move-object/from16 v19, v62
    move-object/from16 v20, v63
    move-object/from16 v21, v64
    move-object/from16 v22, v65
    move-object/from16 v23, v66
    move-object/from16 v24, v67
    move-object/from16 v25, v68
    move-object/from16 v26, v69
    move-object/from16 v27, v70
    move-object/from16 v28, v71
    move-object/from16 v29, v72
    move-object/from16 v30, v73
    move-object/from16 v31, v74
    move-object/from16 v32, v75
    move-object/from16 v33, v76
    move-object/from16 v34, v77
    move-object/from16 v35, v78
    move-object/from16 v36, v79
    move-object/from16 v37, v80
    move-object/from16 v38, v81
    move-object/from16 v39, v82
    move-object/from16 v40, v83
    move-object/from16 v41, v84
    new-instance v42, Lcom/bytedance/trae/im/model/ChatMessage;
    move-object/from16 v0, v42
    invoke-direct/range v0 ... v41, Lcom/bytedance/trae/im/model/ChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long;)V
    return-object v42
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/model/ChatMessage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/model/ChatMessage;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->chatSessionId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->chatSessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->messageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->turnId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->turnId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->messageType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->messageType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->role Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->role Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->messageIndex Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->messageIndex Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->content Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->replyToMessageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->replyToMessageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->userMessageContext Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->userMessageContext Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->error Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->error Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->revertible Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->revertible Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->versionCode Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->versionCode Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->references Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->references Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->contextMetadata Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->contextMetadata Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->searchReferenceData Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->searchReferenceData Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->docReferences Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->docReferences Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->agentType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->agentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->agentId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->agentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->agentName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->agentName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->agentAvatarId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->agentAvatarId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->traceId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->traceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->createdAt Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->createdAt Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->createdAtMs Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->createdAtMs Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->feeUsage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->feeUsage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->maxFeeUsage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->maxFeeUsage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->notifications Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->notifications Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->modelSmartSelectionMeta Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->modelSmartSelectionMeta Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->shallowMementoType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->shallowMementoType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->chatProcessVersion Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->chatProcessVersion Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->tokenUsage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->tokenUsage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->contextUsage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->contextUsage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->agentProcessSupport Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->agentProcessSupport Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->fastRequestSavings Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->fastRequestSavings Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->query Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->query Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->isArchived Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->isArchived Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->chatStartTime Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ChatMessage;->chatStartTime Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ChatMessage;->chatEndTime Ljava/lang/Long;
    iget-object v5, v5, Lcom/bytedance/trae/im/model/ChatMessage;->chatEndTime Ljava/lang/Long;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAgentAvatarId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentAvatarId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentName Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentProcessSupport()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentProcessSupport Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getChatEndTime()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->chatEndTime Ljava/lang/Long;
    return-object v0
.end method

.method public final getChatProcessVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->chatProcessVersion Ljava/lang/String;
    return-object v0
.end method

.method public final getChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getChatStartTime()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->chatStartTime Ljava/lang/Long;
    return-object v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getContextMetadata()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->contextMetadata Ljava/lang/String;
    return-object v0
.end method

.method public final getContextUsage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->contextUsage Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->createdAt Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAtMs()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->createdAtMs Ljava/lang/String;
    return-object v0
.end method

.method public final getDocReferences()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->docReferences Ljava/lang/String;
    return-object v0
.end method

.method public final getError()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->error Ljava/lang/String;
    return-object v0
.end method

.method public final getFastRequestSavings()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->fastRequestSavings Ljava/lang/String;
    return-object v0
.end method

.method public final getFeeUsage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->feeUsage Ljava/lang/String;
    return-object v0
.end method

.method public final getFromAppendMsg()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getMaxFeeUsage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->maxFeeUsage Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageIndex()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->messageIndex Ljava/lang/Long;
    return-object v0
.end method

.method public final getMessageType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->messageType Ljava/lang/String;
    return-object v0
.end method

.method public final getModelSmartSelectionMeta()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->modelSmartSelectionMeta Ljava/lang/String;
    return-object v0
.end method

.method public final getNotifications()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->notifications Ljava/lang/String;
    return-object v0
.end method

.method public final getQuery()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->query Ljava/lang/String;
    return-object v0
.end method

.method public final getReferences()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->references Ljava/lang/String;
    return-object v0
.end method

.method public final getReplyToMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final getRevertible()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->revertible Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getRole()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->role Ljava/lang/String;
    return-object v0
.end method

.method public final getSearchReferenceData()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->searchReferenceData Ljava/lang/String;
    return-object v0
.end method

.method public final getShallowMementoType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->shallowMementoType Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getTokenUsage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->tokenUsage Ljava/lang/String;
    return-object v0
.end method

.method public final getTraceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->traceId Ljava/lang/String;
    return-object v0
.end method

.method public final getTurnId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public final getUserMessageContext()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->userMessageContext Ljava/lang/String;
    return-object v0
.end method

.method public final getVersionCode()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->versionCode Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/model/ChatMessage;->chatSessionId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->messageId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->turnId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->status Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->messageType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->role Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->messageIndex Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->content Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->replyToMessageId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->userMessageContext Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->error Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->revertible Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->versionCode Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->references Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->contextMetadata Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->searchReferenceData Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->docReferences Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentAvatarId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->traceId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->createdAt Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->createdAtMs Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->feeUsage Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->maxFeeUsage Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->notifications Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->modelSmartSelectionMeta Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->shallowMementoType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->chatProcessVersion Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->tokenUsage Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->contextUsage Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentProcessSupport Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->fastRequestSavings Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->query Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->isArchived Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->chatStartTime Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->chatEndTime Ljava/lang/Long;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isArchived()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->isArchived Ljava/lang/Boolean;
    return-object v0
.end method

.method public final isUserCanceled()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled Ljava/lang/Boolean;
    return-object v0
.end method

.method public final isWorktree()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ChatMessage(chatSessionId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/model/ChatMessage;->chatSessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->messageId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", turnId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->turnId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->status Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->messageType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", role="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->role Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageIndex="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->messageIndex Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", content="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->content Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", replyToMessageId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->replyToMessageId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userMessageContext="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->userMessageContext Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", error="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->error Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", revertible="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/im/model/ChatMessage;->revertible Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", versionCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->versionCode Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", references="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->references Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMetadata="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->contextMetadata Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", searchReferenceData="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->searchReferenceData Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", docReferences="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->docReferences Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentAvatarId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentAvatarId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", traceId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->traceId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", createdAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->createdAt Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v1, ", createdAtMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->createdAtMs Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", feeUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->feeUsage Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", maxFeeUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->maxFeeUsage Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", notifications="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->notifications Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", modelSmartSelectionMeta="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->modelSmartSelectionMeta Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fromAppendMsg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", shallowMementoType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->shallowMementoType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatProcessVersion="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->chatProcessVersion Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", tokenUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->tokenUsage Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->contextUsage Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentProcessSupport="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->agentProcessSupport Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fastRequestSavings="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/im/model/ChatMessage;->fastRequestSavings Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isWorktree="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->isWorktree Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", query="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->query Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isArchived="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->isArchived Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isUserCanceled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->isUserCanceled Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatStartTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->chatStartTime Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatEndTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ChatMessage;->chatEndTime Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
