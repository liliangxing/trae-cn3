# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/ParsedChatMessage;
.super Ljava/lang/Object;
.source "ParsedChatMessage.kt"

.field public static final Companion:Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;
.field public static final NOTICE_CONTENT_FILTER_BLOCKED:Ljava/lang/String;
.field public static final NOTICE_CONTENT_FILTER_INPUT_DESENSITIZED:Ljava/lang/String;
.field public static final NOTICE_CONTENT_FILTER_OUTPUT_DESENSITIZED:Ljava/lang/String;
.field public static final ROLE_ASSISTANT:Ljava/lang/String;
.field public static final ROLE_USER:Ljava/lang/String;
.field private static final SECONDS_THRESHOLD:J
.field private agentAvatarId:Ljava/lang/String;
.field private agentId:Ljava/lang/String;
.field private agentName:Ljava/lang/String;
.field private agentProcessSupport:Ljava/lang/String;
.field private agentType:Ljava/lang/String;
.field private chatEndTime:Ljava/lang/Long;
.field private chatProcessVersion:Ljava/lang/String;
.field private chatStartTime:Ljava/lang/Long;
.field private content:Ljava/lang/Object;
.field private varargs contentSecurityRuleName:Ljava/lang/String;
.field private final contextMetadata:Lcom/google/gson/JsonObject;
.field private final contextUsage:Lcom/bytedance/trae/im/model/ParsedContextUsage;
.field private createdAt:J
.field private final docReferences:Lcom/bytedance/trae/im/model/DocReferencesData;
.field private error:Lcom/bytedance/trae/im/model/ParsedError;
.field private varargs fastRequestEvent:Lcom/bytedance/trae/im/service/FastRequestEvent;
.field private fastRequestSavings:Lcom/bytedance/trae/im/model/FastRequestSavings;
.field private final feeUsage:Lcom/google/gson/JsonObject;
.field private fromAppendMsg:Ljava/lang/Boolean;
.field private varargs hasMetaData:Ljava/lang/Boolean;
.field private varargs isAppendMessage:Z
.field private varargs isHistory:Z
.field private varargs isInterjected:Z
.field private isUserCanceled:Ljava/lang/Boolean;
.field private isWorktree:Ljava/lang/Boolean;
.field private final maxFeeUsage:Lcom/google/gson/JsonObject;
.field private messageId:Ljava/lang/String;
.field private messageIndex:I
.field private messageType:Ljava/lang/String;
.field private modelSmartSelectionMeta:Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
.field private varargs noticeMessage:Ljava/lang/String;
.field private varargs noticeTitle:Ljava/lang/String;
.field private varargs noticeType:Ljava/lang/String;
.field private final notifications:Ljava/util/List;
.field private final query:Ljava/util/List;
.field private varargs queueId:Ljava/lang/String;
.field private varargs queuingMessage:Ljava/lang/String;
.field private varargs queuingPosition:Ljava/lang/Integer;
.field private final references:Ljava/util/List;
.field private replyToMessageId:Ljava/lang/String;
.field private varargs requestUUID:Ljava/lang/String;
.field private final revertible:Ljava/lang/Boolean;
.field private final role:Ljava/lang/String;
.field private final searchReferenceData:Lcom/bytedance/trae/im/model/SearchReferenceData;
.field private sessionId:Ljava/lang/String;
.field private shallowMementoType:Ljava/lang/String;
.field private varargs sourcePhase:Lcom/bytedance/trae/im/model/MessageSourcePhase;
.field private status:Ljava/lang/String;
.field private varargs streamingChatModel:Ljava/lang/String;
.field private taskIdUser:Ljava/lang/String;
.field private final tokenUsage:Lcom/bytedance/trae/im/model/ParsedTokenUsage;
.field private traceId:Ljava/lang/String;
.field private turnId:Ljava/lang/String;
.field private final userMessageContext:Lcom/google/gson/JsonObject;
.field private versionCode:Ljava/lang/Long;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->Companion Lcom/bytedance/trae/im/model/ParsedChatMessage$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  com.google.gson.JsonObject  com.bytedance.trae.im.model.ParsedError  java.lang.Boolean  java.lang.Long  java.util.List  com.google.gson.JsonObject  com.bytedance.trae.im.model.SearchReferenceData  com.bytedance.trae.im.model.DocReferencesData  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  com.google.gson.JsonObject  com.google.gson.JsonObject  java.util.List  com.bytedance.trae.im.model.ModelSmartSelectionMeta  java.lang.Boolean  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedTokenUsage  com.bytedance.trae.im.model.ParsedContextUsage  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.Object  java.util.List  com.bytedance.trae.im.model.FastRequestSavings  boolean  boolean  boolean  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.FastRequestEvent  java.lang.Boolean  com.bytedance.trae.im.model.MessageSourcePhase)void
    .registers 62
    # ins_size=57
    move-object v0, v5
    move-object v1, v6
    move-object v2, v7
    move-object v3, v12
    const-string/jumbo v4, sessionId
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "messageId"
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v4, role
    invoke-static v12, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    move v1, v13
    iput v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->userMessageContext Lcom/google/gson/JsonObject;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->revertible Ljava/lang/Boolean;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->references Ljava/util/List;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextMetadata Lcom/google/gson/JsonObject;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->searchReferenceData Lcom/bytedance/trae/im/model/SearchReferenceData;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    move-wide/from16 v1, v28
    iput-wide v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    move-object/from16 v1, v30
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->feeUsage Lcom/google/gson/JsonObject;
    move-object/from16 v1, v31
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->maxFeeUsage Lcom/google/gson/JsonObject;
    move-object/from16 v1, v32
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->notifications Ljava/util/List;
    move-object/from16 v1, v33
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    move-object/from16 v1, v34
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    move-object/from16 v1, v35
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    move-object/from16 v1, v36
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    move-object/from16 v1, v37
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    move-object/from16 v1, v38
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextUsage Lcom/bytedance/trae/im/model/ParsedContextUsage;
    move-object/from16 v1, v39
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    move-object/from16 v1, v40
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    move-object/from16 v1, v41
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    move-object/from16 v1, v42
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    move-object/from16 v1, v43
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    move-object/from16 v1, v44
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    move-object/from16 v1, v45
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->query Ljava/util/List;
    move-object/from16 v1, v46
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    move/from16 v1, v47
    iput-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    move/from16 v1, v48
    iput-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    move/from16 v1, v49
    iput-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    move-object/from16 v1, v50
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    move-object/from16 v1, v51
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    move-object/from16 v1, v52
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    move-object/from16 v1, v53
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    move-object/from16 v1, v54
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    move-object/from16 v1, v55
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    move-object/from16 v1, v56
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    move-object/from16 v1, v57
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    move-object/from16 v1, v58
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    move-object/from16 v1, v59
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    move-object/from16 v1, v60
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    move-object/from16 v1, v61
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  com.google.gson.JsonObject  com.bytedance.trae.im.model.ParsedError  java.lang.Boolean  java.lang.Long  java.util.List  com.google.gson.JsonObject  com.bytedance.trae.im.model.SearchReferenceData  com.bytedance.trae.im.model.DocReferencesData  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  com.google.gson.JsonObject  com.google.gson.JsonObject  java.util.List  com.bytedance.trae.im.model.ModelSmartSelectionMeta  java.lang.Boolean  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedTokenUsage  com.bytedance.trae.im.model.ParsedContextUsage  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.Object  java.util.List  com.bytedance.trae.im.model.FastRequestSavings  boolean  boolean  boolean  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.FastRequestEvent  java.lang.Boolean  com.bytedance.trae.im.model.MessageSourcePhase  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 121
    # ins_size=60
    move/from16 v0, v118
    move/from16 v1, v119
    and-int/lit8 v2, v0, 4
    if-eqz v2, +004h
    const/4 v7, 0
    goto +3h
    move-object/from16 v7, v64
    and-int/lit8 v2, v0, 8
    if-eqz v2, +004h
    const/4 v8, 0
    goto +3h
    move-object/from16 v8, v65
    and-int/lit8 v2, v0, 16
    if-eqz v2, +004h
    const/4 v9, 0
    goto +3h
    move-object/from16 v9, v66
    and-int/lit8 v2, v0, 32
    if-eqz v2, +004h
    const/4 v10, 0
    goto +3h
    move-object/from16 v10, v67
    and-int/lit16 v2, v0, 128
    if-eqz v2, +004h
    const/4 v12, 0
    goto +3h
    move/from16 v12, v69
    and-int/lit16 v2, v0, 256
    if-eqz v2, +004h
    const/4 v13, 0
    goto +3h
    move-object/from16 v13, v70
    and-int/lit16 v2, v0, 512
    if-eqz v2, +004h
    const/4 v14, 0
    goto +3h
    move-object/from16 v14, v71
    and-int/lit16 v2, v0, 1024
    if-eqz v2, +004h
    const/4 v15, 0
    goto +3h
    move-object/from16 v15, v72
    and-int/lit16 v2, v0, 2048
    if-eqz v2, +005h
    const/16 v16, 0
    goto +3h
    move-object/from16 v16, v73
    and-int/lit16 v2, v0, 4096
    if-eqz v2, +005h
    const/16 v17, 0
    goto +3h
    move-object/from16 v17, v74
    and-int/lit16 v2, v0, 8192
    if-eqz v2, +005h
    const/16 v18, 0
    goto +3h
    move-object/from16 v18, v75
    and-int/lit16 v2, v0, 16384
    if-eqz v2, +005h
    const/16 v19, 0
    goto +3h
    move-object/from16 v19, v76
    const v2, 32768
    and-int v5, v0, v2
    if-eqz v5, +005h
    const/16 v20, 0
    goto +3h
    move-object/from16 v20, v77
    const/high16 v5, 65536
    and-int v6, v0, v5
    if-eqz v6, +005h
    const/16 v21, 0
    goto +3h
    move-object/from16 v21, v78
    const/high16 v6, 131072
    and-int v11, v0, v6
    if-eqz v11, +005h
    const/16 v22, 0
    goto +3h
    move-object/from16 v22, v79
    const/high16 v11, 262144
    and-int v23, v0, v11
    if-eqz v23, +005h
    const/16 v23, 0
    goto +3h
    move-object/from16 v23, v80
    const/high16 v24, 524288
    and-int v25, v0, v24
    if-eqz v25, +005h
    const/16 v25, 0
    goto +3h
    move-object/from16 v25, v81
    const/high16 v26, 1048576
    and-int v27, v0, v26
    if-eqz v27, +005h
    const/16 v27, 0
    goto +3h
    move-object/from16 v27, v82
    const/high16 v28, 2097152
    and-int v29, v0, v28
    if-eqz v29, +005h
    const/16 v29, 0
    goto +3h
    move-object/from16 v29, v83
    const/high16 v30, 4194304
    and-int v31, v0, v30
    if-eqz v31, +007h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v31
    goto +3h
    move-wide/from16 v31, v84
    const/high16 v33, 8388608
    and-int v33, v0, v33
    if-eqz v33, +005h
    const/16 v33, 0
    goto +3h
    move-object/from16 v33, v86
    const/high16 v34, 16777216
    and-int v34, v0, v34
    if-eqz v34, +005h
    const/16 v34, 0
    goto +3h
    move-object/from16 v34, v87
    const/high16 v35, 33554432
    and-int v35, v0, v35
    if-eqz v35, +005h
    const/16 v35, 0
    goto +3h
    move-object/from16 v35, v88
    const/high16 v36, 67108864
    and-int v36, v0, v36
    if-eqz v36, +005h
    const/16 v36, 0
    goto +3h
    move-object/from16 v36, v89
    const/high16 v37, 134217728
    and-int v37, v0, v37
    if-eqz v37, +005h
    const/16 v37, 0
    goto +3h
    move-object/from16 v37, v90
    const/high16 v38, 268435456
    and-int v38, v0, v38
    if-eqz v38, +005h
    const/16 v38, 0
    goto +3h
    move-object/from16 v38, v91
    const/high16 v39, 536870912
    and-int v39, v0, v39
    if-eqz v39, +005h
    const/16 v39, 0
    goto +3h
    move-object/from16 v39, v92
    const/high16 v40, 1073741824
    and-int v40, v0, v40
    if-eqz v40, +005h
    const/16 v40, 0
    goto +3h
    move-object/from16 v40, v93
    const/high16 v41, -2147483648
    and-int v0, v0, v41
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move-object/from16 v0, v94
    and-int/lit8 v41, v1, 1
    if-eqz v41, +005h
    const/16 v41, 0
    goto +3h
    move-object/from16 v41, v95
    and-int/lit8 v42, v1, 2
    if-eqz v42, +005h
    const/16 v42, 0
    goto +3h
    move-object/from16 v42, v96
    and-int/lit8 v43, v1, 4
    if-eqz v43, +005h
    const/16 v43, 0
    goto +3h
    move-object/from16 v43, v97
    and-int/lit8 v44, v1, 8
    if-eqz v44, +005h
    const/16 v44, 0
    goto +3h
    move-object/from16 v44, v98
    and-int/lit8 v45, v1, 16
    if-eqz v45, +005h
    const/16 v45, 0
    goto +3h
    move-object/from16 v45, v99
    and-int/lit8 v46, v1, 32
    if-eqz v46, +005h
    const/16 v46, 0
    goto +3h
    move-object/from16 v46, v100
    and-int/lit8 v47, v1, 64
    if-eqz v47, +005h
    const/16 v47, 0
    goto +3h
    move-object/from16 v47, v101
    and-int/lit16 v3, v1, 128
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move-object/from16 v3, v102
    and-int/lit16 v4, v1, 256
    if-eqz v4, +006h
    const/4 v4, 1
    move/from16 v48, v4
    goto +3h
    move/from16 v48, v103
    and-int/lit16 v4, v1, 512
    if-eqz v4, +005h
    const/16 v49, 0
    goto +3h
    move/from16 v49, v104
    and-int/lit16 v4, v1, 1024
    if-eqz v4, +005h
    const/16 v50, 0
    goto +3h
    move/from16 v50, v105
    and-int/lit16 v4, v1, 2048
    if-eqz v4, +005h
    const/16 v51, 0
    goto +3h
    move-object/from16 v51, v106
    and-int/lit16 v4, v1, 4096
    if-eqz v4, +005h
    const/16 v52, 0
    goto +3h
    move-object/from16 v52, v107
    and-int/lit16 v4, v1, 8192
    if-eqz v4, +005h
    const/16 v53, 0
    goto +3h
    move-object/from16 v53, v108
    and-int/lit16 v4, v1, 16384
    if-eqz v4, +005h
    const/16 v54, 0
    goto +3h
    move-object/from16 v54, v109
    and-int/2addr v2, v1
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    move-object/from16 v2, v110
    and-int v4, v1, v5
    if-eqz v4, +005h
    const/16 v55, 0
    goto +3h
    move-object/from16 v55, v111
    and-int v4, v1, v6
    if-eqz v4, +005h
    const/16 v56, 0
    goto +3h
    move-object/from16 v56, v112
    and-int v4, v1, v11
    if-eqz v4, +005h
    const/16 v57, 0
    goto +3h
    move-object/from16 v57, v113
    and-int v4, v1, v24
    if-eqz v4, +005h
    const/16 v58, 0
    goto +3h
    move-object/from16 v58, v114
    and-int v4, v1, v26
    if-eqz v4, +005h
    const/16 v59, 0
    goto +3h
    move-object/from16 v59, v115
    and-int v4, v1, v28
    if-eqz v4, +005h
    const/16 v60, 0
    goto +3h
    move-object/from16 v60, v116
    and-int v1, v1, v30
    if-eqz v1, +005h
    sget-object v1, Lcom/bytedance/trae/im/model/MessageSourcePhase;->FETCHED Lcom/bytedance/trae/im/model/MessageSourcePhase;
    goto +3h
    move-object/from16 v1, v117
    move-object/from16 v4, v61
    move-object/from16 v5, v62
    move-object/from16 v6, v63
    move-object/from16 v11, v68
    move-object/from16 v24, v25
    move-object/from16 v25, v27
    move-object/from16 v26, v29
    move-wide/from16 v27, v31
    move-object/from16 v29, v33
    move-object/from16 v30, v34
    move-object/from16 v31, v35
    move-object/from16 v32, v36
    move-object/from16 v33, v37
    move-object/from16 v34, v38
    move-object/from16 v35, v39
    move-object/from16 v36, v40
    move-object/from16 v37, v0
    move-object/from16 v38, v41
    move-object/from16 v39, v42
    move-object/from16 v40, v43
    move-object/from16 v41, v44
    move-object/from16 v42, v45
    move-object/from16 v43, v46
    move-object/from16 v44, v47
    move-object/from16 v45, v3
    move/from16 v46, v48
    move/from16 v47, v49
    move/from16 v48, v50
    move-object/from16 v49, v51
    move-object/from16 v50, v52
    move-object/from16 v51, v53
    move-object/from16 v52, v54
    move-object/from16 v53, v2
    move-object/from16 v54, v55
    move-object/from16 v55, v56
    move-object/from16 v56, v57
    move-object/from16 v57, v58
    move-object/from16 v58, v59
    move-object/from16 v59, v60
    move-object/from16 v60, v1
    invoke-direct/range v4 ... v60, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.model.ParsedChatMessage  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  com.google.gson.JsonObject  com.bytedance.trae.im.model.ParsedError  java.lang.Boolean  java.lang.Long  java.util.List  com.google.gson.JsonObject  com.bytedance.trae.im.model.SearchReferenceData  com.bytedance.trae.im.model.DocReferencesData  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  com.google.gson.JsonObject  com.google.gson.JsonObject  java.util.List  com.bytedance.trae.im.model.ModelSmartSelectionMeta  java.lang.Boolean  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedTokenUsage  com.bytedance.trae.im.model.ParsedContextUsage  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.Object  java.util.List  com.bytedance.trae.im.model.FastRequestSavings  boolean  boolean  boolean  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.FastRequestEvent  java.lang.Boolean  com.bytedance.trae.im.model.MessageSourcePhase  int  int  java.lang.Object)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 84
    # ins_size=60
    move-object/from16 v0, v24
    move/from16 v1, v81
    move/from16 v2, v82
    and-int/lit8 v3, v1, 1
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v25
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v26
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v27
    and-int/lit8 v6, v1, 8
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v28
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v29
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v30
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v31
    and-int/lit16 v10, v1, 128
    if-eqz v10, +005h
    iget v10, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    goto +3h
    move/from16 v10, v32
    and-int/lit16 v11, v1, 256
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    goto +3h
    move-object/from16 v11, v33
    and-int/lit16 v12, v1, 512
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->userMessageContext Lcom/google/gson/JsonObject;
    goto +3h
    move-object/from16 v12, v34
    and-int/lit16 v13, v1, 1024
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    goto +3h
    move-object/from16 v13, v35
    and-int/lit16 v14, v1, 2048
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->revertible Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v14, v36
    and-int/lit16 v15, v1, 4096
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    goto +3h
    move-object/from16 v15, v37
    move-object/from16 v37, v15
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->references Ljava/util/List;
    goto +3h
    move-object/from16 v15, v38
    move-object/from16 v38, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextMetadata Lcom/google/gson/JsonObject;
    goto +3h
    move-object/from16 v15, v39
    const v16, 32768
    and-int v17, v1, v16
    move-object/from16 v39, v15
    if-eqz v17, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->searchReferenceData Lcom/bytedance/trae/im/model/SearchReferenceData;
    goto +3h
    move-object/from16 v15, v40
    const/high16 v17, 65536
    and-int v18, v1, v17
    move-object/from16 v40, v15
    if-eqz v18, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    goto +3h
    move-object/from16 v15, v41
    const/high16 v18, 131072
    and-int v19, v1, v18
    move-object/from16 v41, v15
    if-eqz v19, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v42
    const/high16 v19, 262144
    and-int v20, v1, v19
    move-object/from16 v42, v15
    if-eqz v20, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v43
    const/high16 v20, 524288
    and-int v21, v1, v20
    move-object/from16 v43, v15
    if-eqz v21, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v44
    const/high16 v21, 1048576
    and-int v22, v1, v21
    move-object/from16 v44, v15
    if-eqz v22, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v45
    const/high16 v22, 2097152
    and-int v23, v1, v22
    move-object/from16 v45, v15
    if-eqz v23, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v46
    const/high16 v23, 4194304
    and-int v23, v1, v23
    move-object/from16 v36, v14
    move-object/from16 v46, v15
    if-eqz v23, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    goto +3h
    move-wide/from16 v14, v47
    const/high16 v23, 8388608
    and-int v23, v1, v23
    move-wide/from16 v47, v14
    if-eqz v23, +005h
    iget-object v14, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->feeUsage Lcom/google/gson/JsonObject;
    goto +3h
    move-object/from16 v14, v49
    const/high16 v15, 16777216
    and-int/2addr v15, v1
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->maxFeeUsage Lcom/google/gson/JsonObject;
    goto +3h
    move-object/from16 v15, v50
    const/high16 v23, 33554432
    and-int v23, v1, v23
    move-object/from16 v50, v15
    if-eqz v23, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->notifications Ljava/util/List;
    goto +3h
    move-object/from16 v15, v51
    const/high16 v23, 67108864
    and-int v23, v1, v23
    move-object/from16 v51, v15
    if-eqz v23, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    goto +3h
    move-object/from16 v15, v52
    const/high16 v23, 134217728
    and-int v23, v1, v23
    move-object/from16 v52, v15
    if-eqz v23, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v53
    const/high16 v23, 268435456
    and-int v23, v1, v23
    move-object/from16 v53, v15
    if-eqz v23, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v54
    const/high16 v23, 536870912
    and-int v23, v1, v23
    move-object/from16 v54, v15
    if-eqz v23, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    goto +3h
    move-object/from16 v15, v55
    const/high16 v23, 1073741824
    and-int v23, v1, v23
    move-object/from16 v55, v15
    if-eqz v23, +005h
    iget-object v15, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    goto +3h
    move-object/from16 v15, v56
    const/high16 v23, -2147483648
    and-int v1, v1, v23
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextUsage Lcom/bytedance/trae/im/model/ParsedContextUsage;
    goto +3h
    move-object/from16 v1, v57
    and-int/lit8 v23, v2, 1
    move-object/from16 v57, v1
    if-eqz v23, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v58
    and-int/lit8 v23, v2, 2
    move-object/from16 v58, v1
    if-eqz v23, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v1, v59
    and-int/lit8 v23, v2, 4
    move-object/from16 v59, v1
    if-eqz v23, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v1, v60
    and-int/lit8 v23, v2, 8
    move-object/from16 v60, v1
    if-eqz v23, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    goto +3h
    move-object/from16 v1, v61
    and-int/lit8 v23, v2, 16
    move-object/from16 v61, v1
    if-eqz v23, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    goto +3h
    move-object/from16 v1, v62
    and-int/lit8 v23, v2, 32
    move-object/from16 v62, v1
    if-eqz v23, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    goto +3h
    move-object/from16 v1, v63
    and-int/lit8 v23, v2, 64
    move-object/from16 v63, v1
    if-eqz v23, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->query Ljava/util/List;
    goto +3h
    move-object/from16 v1, v64
    move-object/from16 v64, v1
    and-int/lit16 v1, v2, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    goto +3h
    move-object/from16 v1, v65
    move-object/from16 v65, v1
    and-int/lit16 v1, v2, 256
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    goto +3h
    move/from16 v1, v66
    move/from16 v66, v1
    and-int/lit16 v1, v2, 512
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    goto +3h
    move/from16 v1, v67
    move/from16 v67, v1
    and-int/lit16 v1, v2, 1024
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    goto +3h
    move/from16 v1, v68
    move/from16 v68, v1
    and-int/lit16 v1, v2, 2048
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v69
    move-object/from16 v69, v1
    and-int/lit16 v1, v2, 4096
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    goto +3h
    move-object/from16 v1, v70
    move-object/from16 v70, v1
    and-int/lit16 v1, v2, 8192
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v71
    move-object/from16 v71, v1
    and-int/lit16 v1, v2, 16384
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v72
    and-int v16, v2, v16
    move-object/from16 v72, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v73
    and-int v16, v2, v17
    move-object/from16 v73, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v74
    and-int v16, v2, v18
    move-object/from16 v74, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v75
    and-int v16, v2, v19
    move-object/from16 v75, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v76
    and-int v16, v2, v20
    move-object/from16 v76, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v77
    and-int v16, v2, v21
    move-object/from16 v77, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    goto +3h
    move-object/from16 v1, v78
    and-int v16, v2, v22
    move-object/from16 v78, v1
    if-eqz v16, +005h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v1, v79
    const/high16 v16, 4194304
    and-int v2, v2, v16
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    goto +3h
    move-object/from16 v2, v80
    move-object/from16 v25, v3
    move-object/from16 v26, v4
    move-object/from16 v27, v5
    move-object/from16 v28, v6
    move-object/from16 v29, v7
    move-object/from16 v30, v8
    move-object/from16 v31, v9
    move/from16 v32, v10
    move-object/from16 v33, v11
    move-object/from16 v34, v12
    move-object/from16 v35, v13
    move-object/from16 v49, v14
    move-object/from16 v56, v15
    move-object/from16 v79, v1
    move-object/from16 v80, v2
    invoke-virtual/range v24 ... v80, Lcom/bytedance/trae/im/model/ParsedChatMessage;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->userMessageContext Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component11()com.bytedance.trae.im.model.ParsedError
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    return-object v0
.end method

.method public final component12()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->revertible Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component13()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    return-object v0
.end method

.method public final component14()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->references Ljava/util/List;
    return-object v0
.end method

.method public final component15()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextMetadata Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component16()com.bytedance.trae.im.model.SearchReferenceData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->searchReferenceData Lcom/bytedance/trae/im/model/SearchReferenceData;
    return-object v0
.end method

.method public final component17()com.bytedance.trae.im.model.DocReferencesData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    return-object v0
.end method

.method public final component18()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final component19()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component20()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    return-object v0
.end method

.method public final component21()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    return-object v0
.end method

.method public final component22()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    return-object v0
.end method

.method public final component23()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    return-wide v0
.end method

.method public final component24()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->feeUsage Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component25()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->maxFeeUsage Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component26()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->notifications Ljava/util/List;
    return-object v0
.end method

.method public final component27()com.bytedance.trae.im.model.ModelSmartSelectionMeta
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    return-object v0
.end method

.method public final component28()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component29()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    return-object v0
.end method

.method public final component30()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    return-object v0
.end method

.method public final component31()com.bytedance.trae.im.model.ParsedTokenUsage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    return-object v0
.end method

.method public final component32()com.bytedance.trae.im.model.ParsedContextUsage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextUsage Lcom/bytedance/trae/im/model/ParsedContextUsage;
    return-object v0
.end method

.method public final component33()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    return-object v0
.end method

.method public final component34()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component35()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component36()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    return-object v0
.end method

.method public final component37()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    return-object v0
.end method

.method public final component38()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    return-object v0
.end method

.method public final component39()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->query Ljava/util/List;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public final component40()com.bytedance.trae.im.model.FastRequestSavings
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    return-object v0
.end method

.method public final component41()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    return v0
.end method

.method public final component42()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    return v0
.end method

.method public final component43()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    return v0
.end method

.method public final component44()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    return-object v0
.end method

.method public final component45()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    return-object v0
.end method

.method public final component46()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component47()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    return-object v0
.end method

.method public final component48()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component49()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component50()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    return-object v0
.end method

.method public final component51()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    return-object v0
.end method

.method public final component52()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    return-object v0
.end method

.method public final component53()com.bytedance.trae.im.service.FastRequestEvent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-object v0
.end method

.method public final component54()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component55()com.bytedance.trae.im.model.MessageSourcePhase
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    return-object v0
.end method

.method public final component8()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    return v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  com.google.gson.JsonObject  com.bytedance.trae.im.model.ParsedError  java.lang.Boolean  java.lang.Long  java.util.List  com.google.gson.JsonObject  com.bytedance.trae.im.model.SearchReferenceData  com.bytedance.trae.im.model.DocReferencesData  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  com.google.gson.JsonObject  com.google.gson.JsonObject  java.util.List  com.bytedance.trae.im.model.ModelSmartSelectionMeta  java.lang.Boolean  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedTokenUsage  com.bytedance.trae.im.model.ParsedContextUsage  java.lang.String  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.Object  java.util.List  com.bytedance.trae.im.model.FastRequestSavings  boolean  boolean  boolean  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.im.service.FastRequestEvent  java.lang.Boolean  com.bytedance.trae.im.model.MessageSourcePhase)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 116
    # ins_size=57
    move-object/from16 v1, v60
    move-object/from16 v2, v61
    move-object/from16 v3, v62
    move-object/from16 v4, v63
    move-object/from16 v5, v64
    move-object/from16 v6, v65
    move-object/from16 v7, v66
    move/from16 v8, v67
    move-object/from16 v9, v68
    move-object/from16 v10, v69
    move-object/from16 v11, v70
    move-object/from16 v12, v71
    move-object/from16 v13, v72
    move-object/from16 v14, v73
    move-object/from16 v15, v74
    move-object/from16 v16, v75
    move-object/from16 v17, v76
    move-object/from16 v18, v77
    move-object/from16 v19, v78
    move-object/from16 v20, v79
    move-object/from16 v21, v80
    move-object/from16 v22, v81
    move-wide/from16 v23, v82
    move-object/from16 v25, v84
    move-object/from16 v26, v85
    move-object/from16 v27, v86
    move-object/from16 v28, v87
    move-object/from16 v29, v88
    move-object/from16 v30, v89
    move-object/from16 v31, v90
    move-object/from16 v32, v91
    move-object/from16 v33, v92
    move-object/from16 v34, v93
    move-object/from16 v35, v94
    move-object/from16 v36, v95
    move-object/from16 v37, v96
    move-object/from16 v38, v97
    move-object/from16 v39, v98
    move-object/from16 v40, v99
    move-object/from16 v41, v100
    move/from16 v42, v101
    move/from16 v43, v102
    move/from16 v44, v103
    move-object/from16 v45, v104
    move-object/from16 v46, v105
    move-object/from16 v47, v106
    move-object/from16 v48, v107
    move-object/from16 v49, v108
    move-object/from16 v50, v109
    move-object/from16 v51, v110
    move-object/from16 v52, v111
    move-object/from16 v53, v112
    move-object/from16 v54, v113
    move-object/from16 v55, v114
    move-object/from16 v56, v115
    const-string/jumbo v0, sessionId
    move-object/from16 v57, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "messageId"
    move-object/from16 v1, v61
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    move-object/from16 v1, v66
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v58, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object/from16 v0, v58
    move-object/from16 v1, v57
    invoke-direct/range v0 ... v56, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase;)V
    return-object v58
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    iget v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->userMessageContext Lcom/google/gson/JsonObject;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->userMessageContext Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->revertible Ljava/lang/Boolean;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->revertible Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->references Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->references Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextMetadata Lcom/google/gson/JsonObject;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextMetadata Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->searchReferenceData Lcom/bytedance/trae/im/model/SearchReferenceData;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->searchReferenceData Lcom/bytedance/trae/im/model/SearchReferenceData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    iget-wide v5, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->feeUsage Lcom/google/gson/JsonObject;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->feeUsage Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->maxFeeUsage Lcom/google/gson/JsonObject;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->maxFeeUsage Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->notifications Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->notifications Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextUsage Lcom/bytedance/trae/im/model/ParsedContextUsage;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextUsage Lcom/bytedance/trae/im/model/ParsedContextUsage;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->query Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->query Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    iget-boolean v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    iget-boolean v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    iget-boolean v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    iget-object v3, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    iget-object v8, v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getAgentAvatarId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentProcessSupport()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    return-object v0
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getChatEndTime()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    return-object v0
.end method

.method public final getChatProcessVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    return-object v0
.end method

.method public final getChatStartTime()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    return-object v0
.end method

.method public final getContent()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    return-object v0
.end method

.method public final getContentSecurityRuleName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    return-object v0
.end method

.method public final getContextMetadata()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextMetadata Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getContextUsage()com.bytedance.trae.im.model.ParsedContextUsage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextUsage Lcom/bytedance/trae/im/model/ParsedContextUsage;
    return-object v0
.end method

.method public final getCreatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    return-wide v0
.end method

.method public final getDocReferences()com.bytedance.trae.im.model.DocReferencesData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    return-object v0
.end method

.method public final getError()com.bytedance.trae.im.model.ParsedError
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    return-object v0
.end method

.method public final getFastRequestEvent()com.bytedance.trae.im.service.FastRequestEvent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-object v0
.end method

.method public final getFastRequestSavings()com.bytedance.trae.im.model.FastRequestSavings
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    return-object v0
.end method

.method public final getFeeUsage()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->feeUsage Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getFromAppendMsg()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getHasMetaData()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getMaxFeeUsage()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->maxFeeUsage Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    return v0
.end method

.method public final getMessageType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    return-object v0
.end method

.method public final getModelSmartSelectionMeta()com.bytedance.trae.im.model.ModelSmartSelectionMeta
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    return-object v0
.end method

.method public final getNoticeMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getNoticeTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    return-object v0
.end method

.method public final getNoticeType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    return-object v0
.end method

.method public final getNotifications()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->notifications Ljava/util/List;
    return-object v0
.end method

.method public final getQuery()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->query Ljava/util/List;
    return-object v0
.end method

.method public final getQueueId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    return-object v0
.end method

.method public final getQueuingMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getQueuingPosition()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    return-object v0
.end method

.method public final getReferences()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->references Ljava/util/List;
    return-object v0
.end method

.method public final getReplyToMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final getRequestUUID()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    return-object v0
.end method

.method public final getRevertible()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->revertible Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getRole()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    return-object v0
.end method

.method public final getSearchReferenceData()com.bytedance.trae.im.model.SearchReferenceData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->searchReferenceData Lcom/bytedance/trae/im/model/SearchReferenceData;
    return-object v0
.end method

.method public final getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getShallowMementoType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    return-object v0
.end method

.method public final getSourcePhase()com.bytedance.trae.im.model.MessageSourcePhase
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    return-object v0
.end method

.method public final getStreamingChatModel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    return-object v0
.end method

.method public final getTaskContent()com.bytedance.trae.im.model.ParsedTaskContent
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +00bh
    iget-object v0, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    instance-of v2, v0, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    return-object v1
.end method

.method public final getTaskIdUser()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    return-object v0
.end method

.method public final getTokenUsage()com.bytedance.trae.im.model.ParsedTokenUsage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    return-object v0
.end method

.method public final getTraceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    return-object v0
.end method

.method public final getTurnId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    return-object v0
.end method

.method public final getUserContent()java.lang.String
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +00bh
    iget-object v0, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    instance-of v2, v0, Ljava/lang/String;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    return-object v1
.end method

.method public final getUserMessageContext()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->userMessageContext Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getVersionCode()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->userMessageContext Lcom/google/gson/JsonObject;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedError;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->revertible Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->references Ljava/util/List;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextMetadata Lcom/google/gson/JsonObject;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->searchReferenceData Lcom/bytedance/trae/im/model/SearchReferenceData;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/SearchReferenceData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/DocReferencesData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v3, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->feeUsage Lcom/google/gson/JsonObject;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->maxFeeUsage Lcom/google/gson/JsonObject;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->notifications Ljava/util/List;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextUsage Lcom/bytedance/trae/im/model/ParsedContextUsage;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedContextUsage;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->query Ljava/util/List;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/FastRequestSavings;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/FastRequestEvent;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/MessageSourcePhase;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isAppendMessage()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    return v0
.end method

.method public final isAssistantMessage()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    const-string v1, "assistant"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public final isHistory()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    return v0
.end method

.method public final isInterjected()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    return v0
.end method

.method public final isUserCanceled()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    return-object v0
.end method

.method public final isUserMessage()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    const-string/jumbo v1, user
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public final isWorktree()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    return-object v0
.end method

.method public final setAgentAvatarId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    return-void 
.end method

.method public final setAgentId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    return-void 
.end method

.method public final setAgentName(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    return-void 
.end method

.method public final setAgentProcessSupport(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    return-void 
.end method

.method public final setAgentType(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    return-void 
.end method

.method public final setAppendMessage(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    return-void 
.end method

.method public final setChatEndTime(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    return-void 
.end method

.method public final setChatProcessVersion(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    return-void 
.end method

.method public final setChatStartTime(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    return-void 
.end method

.method public final setContent(java.lang.Object)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    return-void 
.end method

.method public final setContentSecurityRuleName(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    return-void 
.end method

.method public final setCreatedAt(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    return-void 
.end method

.method public final setError(com.bytedance.trae.im.model.ParsedError)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    return-void 
.end method

.method public final setFastRequestEvent(com.bytedance.trae.im.service.FastRequestEvent)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    return-void 
.end method

.method public final setFastRequestSavings(com.bytedance.trae.im.model.FastRequestSavings)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    return-void 
.end method

.method public final setFromAppendMsg(java.lang.Boolean)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    return-void 
.end method

.method public final setHasMetaData(java.lang.Boolean)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    return-void 
.end method

.method public final setHistory(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    return-void 
.end method

.method public final setInterjected(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    return-void 
.end method

.method public final setMessageId(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    return-void 
.end method

.method public final setMessageIndex(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    return-void 
.end method

.method public final setMessageType(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    return-void 
.end method

.method public final setModelSmartSelectionMeta(com.bytedance.trae.im.model.ModelSmartSelectionMeta)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    return-void 
.end method

.method public final setNoticeMessage(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    return-void 
.end method

.method public final setNoticeTitle(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    return-void 
.end method

.method public final setNoticeType(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    return-void 
.end method

.method public final setQueueId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    return-void 
.end method

.method public final setQueuingMessage(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    return-void 
.end method

.method public final setQueuingPosition(java.lang.Integer)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    return-void 
.end method

.method public final setReplyToMessageId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    return-void 
.end method

.method public final setRequestUUID(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    return-void 
.end method

.method public final setSessionId(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    return-void 
.end method

.method public final setShallowMementoType(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    return-void 
.end method

.method public final setSourcePhase(com.bytedance.trae.im.model.MessageSourcePhase)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    return-void 
.end method

.method public final setStatus(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    return-void 
.end method

.method public final setStreamingChatModel(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    return-void 
.end method

.method public final setTaskIdUser(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    return-void 
.end method

.method public final setTraceId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    return-void 
.end method

.method public final setTurnId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    return-void 
.end method

.method public final setUserCanceled(java.lang.Boolean)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    return-void 
.end method

.method public final setVersionCode(java.lang.Long)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    return-void 
.end method

.method public final setWorktree(java.lang.Boolean)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    return-void 
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ParsedChatMessage(sessionId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", taskIdUser="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->taskIdUser Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", turnId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->turnId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->status Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", role="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->role Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageIndex="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->messageIndex I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", replyToMessageId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->replyToMessageId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userMessageContext="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->userMessageContext Lcom/google/gson/JsonObject;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", error="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->error Lcom/bytedance/trae/im/model/ParsedError;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", revertible="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->revertible Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", versionCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->versionCode Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", references="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->references Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextMetadata="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextMetadata Lcom/google/gson/JsonObject;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", searchReferenceData="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->searchReferenceData Lcom/bytedance/trae/im/model/SearchReferenceData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", docReferences="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->docReferences Lcom/bytedance/trae/im/model/DocReferencesData;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentAvatarId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentAvatarId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", traceId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->traceId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", createdAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->createdAt J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    const-string v1, ", feeUsage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->feeUsage Lcom/google/gson/JsonObject;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", maxFeeUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->maxFeeUsage Lcom/google/gson/JsonObject;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", notifications="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->notifications Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", modelSmartSelectionMeta="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->modelSmartSelectionMeta Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fromAppendMsg="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fromAppendMsg Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", shallowMementoType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->shallowMementoType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatProcessVersion="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatProcessVersion Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", tokenUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->tokenUsage Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contextUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contextUsage Lcom/bytedance/trae/im/model/ParsedContextUsage;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentProcessSupport="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->agentProcessSupport Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isWorktree="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isUserCanceled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatStartTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatStartTime Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatEndTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->chatEndTime Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", content="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->content Ljava/lang/Object;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", query="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->query Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fastRequestSavings="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestSavings Lcom/bytedance/trae/im/model/FastRequestSavings;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isHistory="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isAppendMessage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isInterjected="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", streamingChatModel="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->streamingChatModel Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", queuingPosition="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingPosition Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", queuingMessage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queuingMessage Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v1, ", noticeTitle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeTitle Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", noticeMessage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeMessage Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", contentSecurityRuleName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->contentSecurityRuleName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", noticeType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->noticeType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", queueId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->queueId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", requestUUID="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->requestUUID Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", fastRequestEvent="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->fastRequestEvent Lcom/bytedance/trae/im/service/FastRequestEvent;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasMetaData="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->hasMetaData Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", sourcePhase="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->sourcePhase Lcom/bytedance/trae/im/model/MessageSourcePhase;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
