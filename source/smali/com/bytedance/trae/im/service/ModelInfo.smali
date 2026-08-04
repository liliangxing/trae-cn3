# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ModelInfo;
.super Ljava/lang/Object;
.source "IMEvent.kt"

.field private final abVersions:Ljava/lang/Object;
.field private final ak:Ljava/lang/String;
.field private final applicationConfig:Ljava/lang/Object;
.field private final authType:Ljava/lang/String;
.field private final baseUrl:Ljava/lang/String;
.field private final configName:Ljava/lang/String;
.field private final configSource:Ljava/lang/Integer;
.field private final contextWindowSizes:Ljava/lang/Object;
.field private final displayModelName:Ljava/lang/String;
.field private final displayOptions:Ljava/lang/Object;
.field private final extraConfig:Ljava/lang/Object;
.field private final isPreset:Ljava/lang/Boolean;
.field private final maxTokens:Ljava/lang/Integer;
.field private final maxTurn:Ljava/lang/Integer;
.field private final modelName:Ljava/lang/String;
.field private final multimodal:Ljava/lang/Boolean;
.field private final persistMeta:Ljava/lang/Object;
.field private final promptMaxTokens:Ljava/lang/Integer;
.field private final promptSet:Ljava/lang/Object;
.field private final provider:Ljava/lang/String;
.field private final rawChatFunction:Ljava/lang/Integer;
.field private final region:Ljava/lang/String;
.field private final sessionToken:Ljava/lang/String;
.field private final sk:Ljava/lang/String;
.field private final toolcallHistoryMaxTokens:Ljava/lang/Integer;
.field private final useRemoteService:Ljava/lang/Boolean;


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
    invoke-direct/range v0 ... v28, Lcom/bytedance/trae/im/service/ModelInfo;-><init>(Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.Boolean  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.Integer  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 29
    # ins_size=27
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->provider Ljava/lang/String;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset Ljava/lang/Boolean;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->configName Ljava/lang/String;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->configSource Ljava/lang/Integer;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->modelName Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->displayModelName Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->ak Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->baseUrl Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->useRemoteService Ljava/lang/Boolean;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->multimodal Ljava/lang/Boolean;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->promptMaxTokens Ljava/lang/Integer;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->toolcallHistoryMaxTokens Ljava/lang/Integer;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->extraConfig Ljava/lang/Object;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->abVersions Ljava/lang/Object;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->persistMeta Ljava/lang/Object;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->rawChatFunction Ljava/lang/Integer;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->promptSet Ljava/lang/Object;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->contextWindowSizes Ljava/lang/Object;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->maxTurn Ljava/lang/Integer;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->displayOptions Ljava/lang/Object;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->maxTokens Ljava/lang/Integer;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->applicationConfig Ljava/lang/Object;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->sk Ljava/lang/String;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->authType Ljava/lang/String;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->region Ljava/lang/String;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->sessionToken Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.Boolean  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.Integer  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
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
    invoke-direct/range v28 ... v54, Lcom/bytedance/trae/im/service/ModelInfo;-><init>(Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ModelInfo  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.Integer  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.ModelInfo
    .registers 46
    # ins_size=29
    move-object/from16 v0, v17
    move/from16 v1, v44
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/ModelInfo;->provider Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/ModelInfo;->configName Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/ModelInfo;->configSource Ljava/lang/Integer;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/ModelInfo;->modelName Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/ModelInfo;->displayModelName Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/ModelInfo;->ak Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/ModelInfo;->baseUrl Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/service/ModelInfo;->useRemoteService Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/service/ModelInfo;->multimodal Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/service/ModelInfo;->promptMaxTokens Ljava/lang/Integer;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/im/service/ModelInfo;->toolcallHistoryMaxTokens Ljava/lang/Integer;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/im/service/ModelInfo;->extraConfig Ljava/lang/Object;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->abVersions Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->persistMeta Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move-object/from16 v32, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->rawChatFunction Ljava/lang/Integer;
    goto +3h
    move-object/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v33, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->promptSet Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v34
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-object/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->contextWindowSizes Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->maxTurn Ljava/lang/Integer;
    goto +3h
    move-object/from16 v15, v36
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->displayOptions Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move-object/from16 v37, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->maxTokens Ljava/lang/Integer;
    goto +3h
    move-object/from16 v15, v38
    const/high16 v16, 2097152
    and-int v16, v1, v16
    move-object/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->applicationConfig Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 4194304
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->sk Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v40
    const/high16 v16, 8388608
    and-int v16, v1, v16
    move-object/from16 v40, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->authType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v41
    const/high16 v16, 16777216
    and-int v16, v1, v16
    move-object/from16 v41, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ModelInfo;->region Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v42
    const/high16 v16, 33554432
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/ModelInfo;->sessionToken Ljava/lang/String;
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
    invoke-virtual/range v17 ... v43, Lcom/bytedance/trae/im/service/ModelInfo;->copy(Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/im/service/ModelInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->provider Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->multimodal Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component11()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->promptMaxTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component12()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->toolcallHistoryMaxTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component13()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->extraConfig Ljava/lang/Object;
    return-object v0
.end method

.method public final component14()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->abVersions Ljava/lang/Object;
    return-object v0
.end method

.method public final component15()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->persistMeta Ljava/lang/Object;
    return-object v0
.end method

.method public final component16()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->rawChatFunction Ljava/lang/Integer;
    return-object v0
.end method

.method public final component17()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->promptSet Ljava/lang/Object;
    return-object v0
.end method

.method public final component18()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->contextWindowSizes Ljava/lang/Object;
    return-object v0
.end method

.method public final component19()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->maxTurn Ljava/lang/Integer;
    return-object v0
.end method

.method public final component2()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component20()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->displayOptions Ljava/lang/Object;
    return-object v0
.end method

.method public final component21()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->maxTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final component22()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->applicationConfig Ljava/lang/Object;
    return-object v0
.end method

.method public final component23()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->sk Ljava/lang/String;
    return-object v0
.end method

.method public final component24()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->authType Ljava/lang/String;
    return-object v0
.end method

.method public final component25()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->region Ljava/lang/String;
    return-object v0
.end method

.method public final component26()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->sessionToken Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->configName Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->configSource Ljava/lang/Integer;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->modelName Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->displayModelName Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->ak Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->baseUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->useRemoteService Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.Boolean  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.Integer  java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.Integer  java.lang.Object  java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.im.service.ModelInfo
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
    new-instance v27, Lcom/bytedance/trae/im/service/ModelInfo;
    move-object/from16 v0, v27
    invoke-direct/range v0 ... v26, Lcom/bytedance/trae/im/service/ModelInfo;-><init>(Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/Integer; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v27
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ModelInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ModelInfo;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->provider Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->provider Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->configName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->configName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->configSource Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->configSource Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->modelName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->modelName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->displayModelName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->displayModelName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->ak Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->ak Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->baseUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->baseUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->useRemoteService Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->useRemoteService Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->multimodal Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->multimodal Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->promptMaxTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->promptMaxTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->toolcallHistoryMaxTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->toolcallHistoryMaxTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->extraConfig Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->extraConfig Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->abVersions Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->abVersions Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->persistMeta Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->persistMeta Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->rawChatFunction Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->rawChatFunction Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->promptSet Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->promptSet Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->contextWindowSizes Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->contextWindowSizes Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->maxTurn Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->maxTurn Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->displayOptions Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->displayOptions Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->maxTokens Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->maxTokens Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->applicationConfig Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->applicationConfig Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->sk Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->sk Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->authType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->authType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->region Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ModelInfo;->region Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ModelInfo;->sessionToken Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ModelInfo;->sessionToken Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAbVersions()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->abVersions Ljava/lang/Object;
    return-object v0
.end method

.method public final getAk()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->ak Ljava/lang/String;
    return-object v0
.end method

.method public final getApplicationConfig()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->applicationConfig Ljava/lang/Object;
    return-object v0
.end method

.method public final getAuthType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->authType Ljava/lang/String;
    return-object v0
.end method

.method public final getBaseUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->baseUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getConfigName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->configName Ljava/lang/String;
    return-object v0
.end method

.method public final getConfigSource()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->configSource Ljava/lang/Integer;
    return-object v0
.end method

.method public final getContextWindowSizes()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->contextWindowSizes Ljava/lang/Object;
    return-object v0
.end method

.method public final getDisplayModelName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->displayModelName Ljava/lang/String;
    return-object v0
.end method

.method public final getDisplayOptions()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->displayOptions Ljava/lang/Object;
    return-object v0
.end method

.method public final getExtraConfig()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->extraConfig Ljava/lang/Object;
    return-object v0
.end method

.method public final getMaxTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->maxTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getMaxTurn()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->maxTurn Ljava/lang/Integer;
    return-object v0
.end method

.method public final getModelName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->modelName Ljava/lang/String;
    return-object v0
.end method

.method public final getMultimodal()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->multimodal Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getPersistMeta()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->persistMeta Ljava/lang/Object;
    return-object v0
.end method

.method public final getPromptMaxTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->promptMaxTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getPromptSet()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->promptSet Ljava/lang/Object;
    return-object v0
.end method

.method public final getProvider()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->provider Ljava/lang/String;
    return-object v0
.end method

.method public final getRawChatFunction()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->rawChatFunction Ljava/lang/Integer;
    return-object v0
.end method

.method public final getRegion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->region Ljava/lang/String;
    return-object v0
.end method

.method public final getSessionToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->sessionToken Ljava/lang/String;
    return-object v0
.end method

.method public final getSk()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->sk Ljava/lang/String;
    return-object v0
.end method

.method public final getToolcallHistoryMaxTokens()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->toolcallHistoryMaxTokens Ljava/lang/Integer;
    return-object v0
.end method

.method public final getUseRemoteService()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->useRemoteService Ljava/lang/Boolean;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/ModelInfo;->provider Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->configName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->configSource Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->modelName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->displayModelName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->ak Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->baseUrl Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->useRemoteService Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->multimodal Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->promptMaxTokens Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->toolcallHistoryMaxTokens Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->extraConfig Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->abVersions Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->persistMeta Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->rawChatFunction Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->promptSet Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->contextWindowSizes Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->maxTurn Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->displayOptions Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->maxTokens Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->applicationConfig Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->sk Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->authType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->region Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->sessionToken Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isPreset()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ModelInfo(provider="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/service/ModelInfo;->provider Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isPreset="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", configName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->configName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", configSource="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->configSource Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", modelName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->modelName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", displayModelName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->displayModelName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", ak="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->ak Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", baseUrl="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->baseUrl Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", useRemoteService="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->useRemoteService Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", multimodal="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->multimodal Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", promptMaxTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->promptMaxTokens Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", toolcallHistoryMaxTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/ModelInfo;->toolcallHistoryMaxTokens Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", extraConfig="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->extraConfig Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", abVersions="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->abVersions Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", persistMeta="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->persistMeta Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", rawChatFunction="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->rawChatFunction Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", promptSet="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->promptSet Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextWindowSizes="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->contextWindowSizes Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", maxTurn="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->maxTurn Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", displayOptions="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->displayOptions Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", maxTokens="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->maxTokens Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", applicationConfig="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->applicationConfig Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sk="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->sk Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v1, ", authType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->authType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", region="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->region Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionToken="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ModelInfo;->sessionToken Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
