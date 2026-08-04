# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
.super Lcom/bytedance/trae/im/service/ChatEventPayload;
.source "IMEvent.kt"

.field private final agentAvatarId:Ljava/lang/String;
.field private final agentId:Ljava/lang/String;
.field private final agentName:Ljava/lang/String;
.field private final agentProcessSupport:Ljava/lang/String;
.field private final agentTaskServiceStrategy:Ljava/lang/String;
.field private final agentType:Ljava/lang/String;
.field private final chatProcessVersion:Ljava/lang/String;
.field private final chatStartTime:Ljava/lang/Long;
.field private final contextMetadata:Ljava/lang/Object;
.field private final createdAt:Ljava/lang/Long;
.field private final docReferences:Lcom/bytedance/trae/im/service/DocReferences;
.field private final feeUsage:Ljava/lang/Object;
.field private final fromAppend:Ljava/lang/Boolean;
.field private final isWorktree:Ljava/lang/Boolean;
.field private final maxFeeUsage:Ljava/lang/Object;
.field private final messageId:Ljava/lang/String;
.field private final messageIndex:Ljava/lang/Integer;
.field private final messageType:Ljava/lang/String;
.field private final metadataStatus:Ljava/lang/String;
.field private final modelSmartSelectionMeta:Lcom/google/gson/JsonObject;
.field private final references:Ljava/util/List;
.field private final replyToMessageId:Ljava/lang/String;
.field private final requestClient:Ljava/lang/String;
.field private final searchReferenceData:Ljava/lang/Object;
.field private final sessionId:Ljava/lang/String;
.field private final shallowMementoType:Ljava/lang/String;
.field private final status:Ljava/lang/String;
.field private final thought:Ljava/lang/String;
.field private final traceId:Ljava/lang/String;
.field private final ttnetAbtest:Ljava/lang/Object;
.field private final turnId:Ljava/lang/String;
.field private final userMessageContext:Lcom/bytedance/trae/im/service/UserMessageContext;
.field private final versionCode:Ljava/lang/Long;


.method public constructor <init>()void
    .registers 38
    # ins_size=1
    move-object/from16 v0, v37
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
    const/16 v34, -1
    const/16 v35, 1
    const/16 v36, 0
    invoke-direct/range v0 ... v36, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/Object; Ljava/lang/Object; Lcom/bytedance/trae/im/service/DocReferences; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Object; Ljava/lang/Object; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  java.lang.Object  java.lang.Object  com.bytedance.trae.im.service.DocReferences  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.UserMessageContext  java.lang.String  java.lang.Long  java.lang.Object  java.lang.Object  com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.Object  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.String  java.lang.String)void
    .registers 36
    # ins_size=34
    move-object v0, v2
    const/4 v1, 0
    invoke-direct v2, v1, Lcom/bytedance/trae/im/service/ChatEventPayload;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageId Ljava/lang/String;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->turnId Ljava/lang/String;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->sessionId Ljava/lang/String;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageType Ljava/lang/String;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageIndex Ljava/lang/Integer;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->status Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatProcessVersion Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentProcessSupport Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->replyToMessageId Ljava/lang/String;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->references Ljava/util/List;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->contextMetadata Ljava/lang/Object;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->searchReferenceData Ljava/lang/Object;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->docReferences Lcom/bytedance/trae/im/service/DocReferences;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentType Ljava/lang/String;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentId Ljava/lang/String;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentName Ljava/lang/String;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentAvatarId Ljava/lang/String;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->userMessageContext Lcom/bytedance/trae/im/service/UserMessageContext;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->traceId Ljava/lang/String;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->createdAt Ljava/lang/Long;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->feeUsage Ljava/lang/Object;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->maxFeeUsage Ljava/lang/Object;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->modelSmartSelectionMeta Lcom/google/gson/JsonObject;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->shallowMementoType Ljava/lang/String;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->requestClient Ljava/lang/String;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->ttnetAbtest Ljava/lang/Object;
    move-object/from16 v1, v29
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentTaskServiceStrategy Ljava/lang/String;
    move-object/from16 v1, v30
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->fromAppend Ljava/lang/Boolean;
    move-object/from16 v1, v31
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree Ljava/lang/Boolean;
    move-object/from16 v1, v32
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatStartTime Ljava/lang/Long;
    move-object/from16 v1, v33
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->versionCode Ljava/lang/Long;
    move-object/from16 v1, v34
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->metadataStatus Ljava/lang/String;
    move-object/from16 v1, v35
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->thought Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  java.lang.Object  java.lang.Object  com.bytedance.trae.im.service.DocReferences  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.UserMessageContext  java.lang.String  java.lang.Long  java.lang.Object  java.lang.Object  com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.Object  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.String  java.lang.String  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 70
    # ins_size=37
    move/from16 v0, v67
    and-int/lit8 v1, v0, 1
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    move-object/from16 v1, v34
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move-object/from16 v3, v35
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    const/4 v4, 0
    goto +3h
    move-object/from16 v4, v36
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move-object/from16 v5, v37
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    const/4 v6, 0
    goto +3h
    move-object/from16 v6, v38
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    const/4 v7, 0
    goto +3h
    move-object/from16 v7, v39
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    move-object/from16 v8, v40
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    const/4 v9, 0
    goto +3h
    move-object/from16 v9, v41
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    const/4 v10, 0
    goto +3h
    move-object/from16 v10, v42
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    const/4 v11, 0
    goto +3h
    move-object/from16 v11, v43
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move-object/from16 v12, v44
    and-int/lit16 v13, v0, 2048
    if-eqz v13, +004h
    const/4 v13, 0
    goto +3h
    move-object/from16 v13, v45
    and-int/lit16 v14, v0, 4096
    if-eqz v14, +004h
    const/4 v14, 0
    goto +3h
    move-object/from16 v14, v46
    and-int/lit16 v15, v0, 8192
    if-eqz v15, +004h
    const/4 v15, 0
    goto +3h
    move-object/from16 v15, v47
    and-int/lit16 v2, v0, 16384
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    move-object/from16 v2, v48
    const v16, 32768
    and-int v16, v0, v16
    if-eqz v16, +005h
    const/16 v16, 0
    goto +3h
    move-object/from16 v16, v49
    const/high16 v17, 65536
    and-int v17, v0, v17
    if-eqz v17, +005h
    const/16 v17, 0
    goto +3h
    move-object/from16 v17, v50
    const/high16 v18, 131072
    and-int v18, v0, v18
    if-eqz v18, +005h
    const/16 v18, 0
    goto +3h
    move-object/from16 v18, v51
    const/high16 v19, 262144
    and-int v19, v0, v19
    if-eqz v19, +005h
    const/16 v19, 0
    goto +3h
    move-object/from16 v19, v52
    const/high16 v20, 524288
    and-int v20, v0, v20
    if-eqz v20, +005h
    const/16 v20, 0
    goto +3h
    move-object/from16 v20, v53
    const/high16 v21, 1048576
    and-int v21, v0, v21
    if-eqz v21, +005h
    const/16 v21, 0
    goto +3h
    move-object/from16 v21, v54
    const/high16 v22, 2097152
    and-int v22, v0, v22
    if-eqz v22, +005h
    const/16 v22, 0
    goto +3h
    move-object/from16 v22, v55
    const/high16 v23, 4194304
    and-int v23, v0, v23
    if-eqz v23, +005h
    const/16 v23, 0
    goto +3h
    move-object/from16 v23, v56
    const/high16 v24, 8388608
    and-int v24, v0, v24
    if-eqz v24, +005h
    const/16 v24, 0
    goto +3h
    move-object/from16 v24, v57
    const/high16 v25, 16777216
    and-int v25, v0, v25
    if-eqz v25, +005h
    const/16 v25, 0
    goto +3h
    move-object/from16 v25, v58
    const/high16 v26, 33554432
    and-int v26, v0, v26
    if-eqz v26, +005h
    const/16 v26, 0
    goto +3h
    move-object/from16 v26, v59
    const/high16 v27, 67108864
    and-int v27, v0, v27
    if-eqz v27, +005h
    const/16 v27, 0
    goto +3h
    move-object/from16 v27, v60
    const/high16 v28, 134217728
    and-int v28, v0, v28
    if-eqz v28, +005h
    const/16 v28, 0
    goto +3h
    move-object/from16 v28, v61
    const/high16 v29, 268435456
    and-int v29, v0, v29
    if-eqz v29, +005h
    const/16 v29, 0
    goto +3h
    move-object/from16 v29, v62
    const/high16 v30, 536870912
    and-int v30, v0, v30
    if-eqz v30, +005h
    const/16 v30, 0
    goto +3h
    move-object/from16 v30, v63
    const/high16 v31, 1073741824
    and-int v31, v0, v31
    if-eqz v31, +005h
    const/16 v31, 0
    goto +3h
    move-object/from16 v31, v64
    const/high16 v32, -2147483648
    and-int v0, v0, v32
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move-object/from16 v0, v65
    and-int/lit8 v32, v68, 1
    if-eqz v32, +005h
    const/16 v32, 0
    goto +3h
    move-object/from16 v32, v66
    move-object/from16 v34, v33
    move-object/from16 v35, v1
    move-object/from16 v36, v3
    move-object/from16 v37, v4
    move-object/from16 v38, v5
    move-object/from16 v39, v6
    move-object/from16 v40, v7
    move-object/from16 v41, v8
    move-object/from16 v42, v9
    move-object/from16 v43, v10
    move-object/from16 v44, v11
    move-object/from16 v45, v12
    move-object/from16 v46, v13
    move-object/from16 v47, v14
    move-object/from16 v48, v15
    move-object/from16 v49, v2
    move-object/from16 v50, v16
    move-object/from16 v51, v17
    move-object/from16 v52, v18
    move-object/from16 v53, v19
    move-object/from16 v54, v20
    move-object/from16 v55, v21
    move-object/from16 v56, v22
    move-object/from16 v57, v23
    move-object/from16 v58, v24
    move-object/from16 v59, v25
    move-object/from16 v60, v26
    move-object/from16 v61, v27
    move-object/from16 v62, v28
    move-object/from16 v63, v29
    move-object/from16 v64, v30
    move-object/from16 v65, v31
    move-object/from16 v66, v0
    move-object/from16 v67, v32
    invoke-direct/range v34 ... v67, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/Object; Ljava/lang/Object; Lcom/bytedance/trae/im/service/DocReferences; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Object; Ljava/lang/Object; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ChatEventPayload$Metadata  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  java.lang.Object  java.lang.Object  com.bytedance.trae.im.service.DocReferences  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.UserMessageContext  java.lang.String  java.lang.Long  java.lang.Object  java.lang.Object  com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.Object  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.String  java.lang.String  int  int  java.lang.Object)com.bytedance.trae.im.service.ChatEventPayload$Metadata
    .registers 54
    # ins_size=37
    move-object/from16 v0, v17
    move/from16 v1, v51
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageId Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->turnId Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->sessionId Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageType Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageIndex Ljava/lang/Integer;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->status Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatProcessVersion Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentProcessSupport Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->replyToMessageId Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->references Ljava/util/List;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->contextMetadata Ljava/lang/Object;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->searchReferenceData Ljava/lang/Object;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->docReferences Lcom/bytedance/trae/im/service/DocReferences;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move-object/from16 v32, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentName Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v33, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentAvatarId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v34
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-object/from16 v34, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->userMessageContext Lcom/bytedance/trae/im/service/UserMessageContext;
    goto +3h
    move-object/from16 v15, v35
    const/high16 v16, 262144
    and-int v16, v1, v16
    move-object/from16 v35, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->traceId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v36
    const/high16 v16, 524288
    and-int v16, v1, v16
    move-object/from16 v36, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->createdAt Ljava/lang/Long;
    goto +3h
    move-object/from16 v15, v37
    const/high16 v16, 1048576
    and-int v16, v1, v16
    move-object/from16 v37, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->feeUsage Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v38
    const/high16 v16, 2097152
    and-int v16, v1, v16
    move-object/from16 v38, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->maxFeeUsage Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v39
    const/high16 v16, 4194304
    and-int v16, v1, v16
    move-object/from16 v39, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->modelSmartSelectionMeta Lcom/google/gson/JsonObject;
    goto +3h
    move-object/from16 v15, v40
    const/high16 v16, 8388608
    and-int v16, v1, v16
    move-object/from16 v40, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->shallowMementoType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v41
    const/high16 v16, 16777216
    and-int v16, v1, v16
    move-object/from16 v41, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->requestClient Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v42
    const/high16 v16, 33554432
    and-int v16, v1, v16
    move-object/from16 v42, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->ttnetAbtest Ljava/lang/Object;
    goto +3h
    move-object/from16 v15, v43
    const/high16 v16, 67108864
    and-int v16, v1, v16
    move-object/from16 v43, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentTaskServiceStrategy Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v44
    const/high16 v16, 134217728
    and-int v16, v1, v16
    move-object/from16 v44, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->fromAppend Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v45
    const/high16 v16, 268435456
    and-int v16, v1, v16
    move-object/from16 v45, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v46
    const/high16 v16, 536870912
    and-int v16, v1, v16
    move-object/from16 v46, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatStartTime Ljava/lang/Long;
    goto +3h
    move-object/from16 v15, v47
    const/high16 v16, 1073741824
    and-int v16, v1, v16
    move-object/from16 v47, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->versionCode Ljava/lang/Long;
    goto +3h
    move-object/from16 v15, v48
    const/high16 v16, -2147483648
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->metadataStatus Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v49
    and-int/lit8 v16, v52, 1
    move-object/from16 v49, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->thought Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v50
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
    move-object/from16 v48, v15
    move-object/from16 v50, v1
    invoke-virtual/range v17 ... v50, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/Object; Ljava/lang/Object; Lcom/bytedance/trae/im/service/DocReferences; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Object; Ljava/lang/Object; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->references Ljava/util/List;
    return-object v0
.end method

.method public final component11()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->contextMetadata Ljava/lang/Object;
    return-object v0
.end method

.method public final component12()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->searchReferenceData Ljava/lang/Object;
    return-object v0
.end method

.method public final component13()com.bytedance.trae.im.service.DocReferences
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->docReferences Lcom/bytedance/trae/im/service/DocReferences;
    return-object v0
.end method

.method public final component14()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final component15()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final component16()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentName Ljava/lang/String;
    return-object v0
.end method

.method public final component17()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentAvatarId Ljava/lang/String;
    return-object v0
.end method

.method public final component18()com.bytedance.trae.im.service.UserMessageContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->userMessageContext Lcom/bytedance/trae/im/service/UserMessageContext;
    return-object v0
.end method

.method public final component19()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->traceId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public final component20()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->createdAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component21()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->feeUsage Ljava/lang/Object;
    return-object v0
.end method

.method public final component22()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->maxFeeUsage Ljava/lang/Object;
    return-object v0
.end method

.method public final component23()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->modelSmartSelectionMeta Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component24()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->shallowMementoType Ljava/lang/String;
    return-object v0
.end method

.method public final component25()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->requestClient Ljava/lang/String;
    return-object v0
.end method

.method public final component26()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->ttnetAbtest Ljava/lang/Object;
    return-object v0
.end method

.method public final component27()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentTaskServiceStrategy Ljava/lang/String;
    return-object v0
.end method

.method public final component28()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->fromAppend Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component29()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component30()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatStartTime Ljava/lang/Long;
    return-object v0
.end method

.method public final component31()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->versionCode Ljava/lang/Long;
    return-object v0
.end method

.method public final component32()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->metadataStatus Ljava/lang/String;
    return-object v0
.end method

.method public final component33()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->thought Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageType Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageIndex Ljava/lang/Integer;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatProcessVersion Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentProcessSupport Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.util.List  java.lang.Object  java.lang.Object  com.bytedance.trae.im.service.DocReferences  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.UserMessageContext  java.lang.String  java.lang.Long  java.lang.Object  java.lang.Object  com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.Object  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.String  java.lang.String)com.bytedance.trae.im.service.ChatEventPayload$Metadata
    .registers 69
    # ins_size=34
    move-object/from16 v1, v36
    move-object/from16 v2, v37
    move-object/from16 v3, v38
    move-object/from16 v4, v39
    move-object/from16 v5, v40
    move-object/from16 v6, v41
    move-object/from16 v7, v42
    move-object/from16 v8, v43
    move-object/from16 v9, v44
    move-object/from16 v10, v45
    move-object/from16 v11, v46
    move-object/from16 v12, v47
    move-object/from16 v13, v48
    move-object/from16 v14, v49
    move-object/from16 v15, v50
    move-object/from16 v16, v51
    move-object/from16 v17, v52
    move-object/from16 v18, v53
    move-object/from16 v19, v54
    move-object/from16 v20, v55
    move-object/from16 v21, v56
    move-object/from16 v22, v57
    move-object/from16 v23, v58
    move-object/from16 v24, v59
    move-object/from16 v25, v60
    move-object/from16 v26, v61
    move-object/from16 v27, v62
    move-object/from16 v28, v63
    move-object/from16 v29, v64
    move-object/from16 v30, v65
    move-object/from16 v31, v66
    move-object/from16 v32, v67
    move-object/from16 v33, v68
    new-instance v34, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    move-object/from16 v0, v34
    invoke-direct/range v0 ... v33, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/Object; Ljava/lang/Object; Lcom/bytedance/trae/im/service/DocReferences; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Object; Ljava/lang/Object; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String;)V
    return-object v34
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->turnId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->turnId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->sessionId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->sessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageIndex Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageIndex Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatProcessVersion Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatProcessVersion Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentProcessSupport Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentProcessSupport Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->replyToMessageId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->replyToMessageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->references Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->references Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->contextMetadata Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->contextMetadata Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->searchReferenceData Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->searchReferenceData Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->docReferences Lcom/bytedance/trae/im/service/DocReferences;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->docReferences Lcom/bytedance/trae/im/service/DocReferences;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentAvatarId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentAvatarId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->userMessageContext Lcom/bytedance/trae/im/service/UserMessageContext;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->userMessageContext Lcom/bytedance/trae/im/service/UserMessageContext;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->traceId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->traceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->createdAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->createdAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->feeUsage Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->feeUsage Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->maxFeeUsage Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->maxFeeUsage Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->modelSmartSelectionMeta Lcom/google/gson/JsonObject;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->modelSmartSelectionMeta Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->shallowMementoType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->shallowMementoType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->requestClient Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->requestClient Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->ttnetAbtest Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->ttnetAbtest Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentTaskServiceStrategy Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentTaskServiceStrategy Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->fromAppend Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->fromAppend Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatStartTime Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatStartTime Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->versionCode Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->versionCode Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->metadataStatus Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->metadataStatus Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->thought Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->thought Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAgentAvatarId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentAvatarId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentName Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentProcessSupport()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentProcessSupport Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentTaskServiceStrategy()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentTaskServiceStrategy Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getChatProcessVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatProcessVersion Ljava/lang/String;
    return-object v0
.end method

.method public final getChatStartTime()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatStartTime Ljava/lang/Long;
    return-object v0
.end method

.method public final getContextMetadata()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->contextMetadata Ljava/lang/Object;
    return-object v0
.end method

.method public final getCreatedAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->createdAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getDocReferences()com.bytedance.trae.im.service.DocReferences
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->docReferences Lcom/bytedance/trae/im/service/DocReferences;
    return-object v0
.end method

.method public final getFeeUsage()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->feeUsage Ljava/lang/Object;
    return-object v0
.end method

.method public final getFromAppend()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->fromAppend Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getMaxFeeUsage()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->maxFeeUsage Ljava/lang/Object;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageIndex()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageIndex Ljava/lang/Integer;
    return-object v0
.end method

.method public final getMessageType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageType Ljava/lang/String;
    return-object v0
.end method

.method public final getMetadataStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->metadataStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getModelSmartSelectionMeta()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->modelSmartSelectionMeta Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getReferences()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->references Ljava/util/List;
    return-object v0
.end method

.method public final getReplyToMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final getRequestClient()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->requestClient Ljava/lang/String;
    return-object v0
.end method

.method public final getSearchReferenceData()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->searchReferenceData Ljava/lang/Object;
    return-object v0
.end method

.method public final getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getShallowMementoType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->shallowMementoType Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getThought()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->thought Ljava/lang/String;
    return-object v0
.end method

.method public final getTraceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->traceId Ljava/lang/String;
    return-object v0
.end method

.method public final getTtnetAbtest()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->ttnetAbtest Ljava/lang/Object;
    return-object v0
.end method

.method public final getTurnId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public final getUserMessageContext()com.bytedance.trae.im.service.UserMessageContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->userMessageContext Lcom/bytedance/trae/im/service/UserMessageContext;
    return-object v0
.end method

.method public final getVersionCode()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->versionCode Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->turnId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->sessionId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageIndex Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->status Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatProcessVersion Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentProcessSupport Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->replyToMessageId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->references Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->contextMetadata Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->searchReferenceData Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->docReferences Lcom/bytedance/trae/im/service/DocReferences;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/DocReferences;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentAvatarId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->userMessageContext Lcom/bytedance/trae/im/service/UserMessageContext;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/UserMessageContext;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->traceId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->createdAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->feeUsage Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->maxFeeUsage Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->modelSmartSelectionMeta Lcom/google/gson/JsonObject;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->shallowMementoType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->requestClient Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->ttnetAbtest Ljava/lang/Object;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentTaskServiceStrategy Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->fromAppend Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatStartTime Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->versionCode Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->metadataStatus Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->thought Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isWorktree()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Metadata(messageId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", turnId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->turnId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sessionId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->sessionId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageIndex="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->messageIndex Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->status Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatProcessVersion="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatProcessVersion Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentProcessSupport="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentProcessSupport Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", replyToMessageId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->replyToMessageId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", references="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->references Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMetadata="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->contextMetadata Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", searchReferenceData="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->searchReferenceData Ljava/lang/Object;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", docReferences="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->docReferences Lcom/bytedance/trae/im/service/DocReferences;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentAvatarId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentAvatarId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userMessageContext="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->userMessageContext Lcom/bytedance/trae/im/service/UserMessageContext;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", traceId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->traceId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", createdAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->createdAt Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", feeUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->feeUsage Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", maxFeeUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->maxFeeUsage Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", modelSmartSelectionMeta="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->modelSmartSelectionMeta Lcom/google/gson/JsonObject;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    const-string v1, ", shallowMementoType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->shallowMementoType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", requestClient="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->requestClient Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", ttnetAbtest="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->ttnetAbtest Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentTaskServiceStrategy="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->agentTaskServiceStrategy Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fromAppend="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->fromAppend Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isWorktree="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->isWorktree Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatStartTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->chatStartTime Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", versionCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->versionCode Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", metadataStatus="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->metadataStatus Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", thought="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->thought Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
