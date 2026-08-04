# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
.super Ljava/lang/Object;
.source "ConversationMessageStateReducer.kt"

.field private static final APPEND_INPUT_TYPE:Ljava/lang/String;
.field private static final APPEND_USER_CONTEXT_KEY:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;


.method public static synthetic $r8$lambda$LlgUkNbwYflQjHEr9ydzfUqns90(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->mergeMessages$lambda$0(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final fixupUserMessageForAssistant(java.util.List  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.jvm.functions.Function2)void
    .registers 70
    # ins_size=4
    move-object/from16 v0, v67
    invoke-virtual/range v68, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +186h
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    const/4 v3, 1
    xor-int/2addr v2, v3
    const/4 v4, 0
    if-eqz v2, +003h
    goto +2h
    move-object v1, v4
    if-nez v1, +004h
    goto/16 +174h
    invoke-virtual/range v68, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v2
    if-eqz v2, +16bh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +165h
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v3
    if-eqz v5, +003h
    goto +2h
    move-object v2, v4
    if-nez v2, +004h
    goto/16 +155h
    invoke-interface/range v67, Ljava/util/List;->size()I
    move-result v5
    invoke-interface v0, v5, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v6
    const/4 v7, -1
    const/4 v8, 0
    if-eqz v6, +022h
    invoke-interface v5, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v9
    if-eqz v9, +00eh
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskIdUser()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    move v6, v3
    goto +2h
    move v6, v8
    if-eqz v6, -021h
    invoke-interface v5, Ljava/util/ListIterator;->nextIndex()I
    move-result v5
    goto +2h
    move v5, v7
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->intValue()I
    move-result v6
    if-ltz v6, +004h
    move v6, v3
    goto +2h
    move v6, v8
    if-eqz v6, +003h
    goto +2h
    move-object v5, v4
    if-eqz v5, +007h
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +2eh
    invoke-interface/range v67, Ljava/util/List;->size()I
    move-result v5
    invoke-interface v0, v5, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v6
    if-eqz v6, +021h
    invoke-interface v5, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v9
    if-eqz v9, +00eh
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    move v6, v3
    goto +2h
    move v6, v8
    if-eqz v6, -01fh
    invoke-interface v5, Ljava/util/ListIterator;->nextIndex()I
    move-result v7
    if-gez v7, +003h
    return-void 
    invoke-interface v0, v7, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    move-object/from16 v65, v5
    check-cast v65, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual/range v68, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->longValue()J
    move-result-wide v9
    const-wide/16 v11, 0
    cmp-long v6, v9, v11
    if-lez v6, +003h
    goto +2h
    move v3, v8
    if-eqz v3, +003h
    move-object v4, v5
    if-eqz v4, +00ch
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->longValue()J
    move-result-wide v3
    const-wide/16 v5, 1
    sub-long/2addr v3, v5
    goto +5h
    invoke-virtual/range v65, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v3
    move-wide/from16 v28, v3
    const/4 v6, 0
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
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 1
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, 0
    const/16 v60, 0
    const/16 v61, 0
    const v62, -4194307
    const v63, 8388351
    const/16 v64, 0
    move-object/from16 v5, v65
    move v3, v7
    move-object v7, v1
    invoke-static/range v5 ... v64, Lcom/bytedance/trae/im/model/ParsedChatMessage;->copy$default(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Ljava/lang/Object;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v4
    invoke-interface v0, v3, v4, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    move-object/from16 v5, v66
    invoke-direct v5, v0, v3, v2, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->removeDuplicateFixedUserMessages(Ljava/util/List; I Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v65, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +014h
    invoke-virtual/range v65, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v0
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v2
    cmp-long v0, v0, v2
    if-nez v0, +008h
    invoke-virtual/range v65, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v0
    if-nez v0, +00bh
    invoke-virtual/range v65, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v1, v69
    invoke-interface v1, v0, v4, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    move-object/from16 v5, v66
    return-void 
    move-object/from16 v5, v66
    return-void 
.end method

.method private final hasAppendInput(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 6
    # ins_size=2
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v5
    const/4 v0, 0
    if-eqz v5, +03ah
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +034h
    check-cast v5, Ljava/lang/Iterable;
    instance-of v1, v5, Ljava/util/Collection;
    const/4 v2, 1
    if-eqz v1, +00dh
    move-object v1, v5
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v5, v0
    goto +1eh
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getType()Ljava/lang/String;
    move-result-object v1
    const-string v3, "append_input"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -016h
    move v5, v2
    if-ne v5, v2, +003h
    move v0, v2
    return v0
.end method

.method private final hasAppendInterjectionSignal(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 4
    # ins_size=2
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->hasAppendInput(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v0
    const/4 v1, 1
    if-nez v0, +018h
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->isAppendUserMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v0
    if-nez v0, +012h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFromAppendMsg()Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private final isAppendUserMessage(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAppendMessage()Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +003h
    return v1
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getUserMessageContext()Lcom/google/gson/JsonObject;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +045h
    const-string v2, "is_append_msg"
    invoke-virtual v4, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-nez v4, +003h
    goto +3bh
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +00dh
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v4
    invoke-virtual v4, Lcom/google/gson/JsonPrimitive;->getAsBoolean()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move v1, v0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v4, v0
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    return v4
    return v0
    :try_start_0x18
.end method

.method private final isSameAssistantTurn(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 9
    # ins_size=3
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    const-string v1, "placeholder_"
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    const/4 v5, 1
    if-nez v0, +03ch
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +30h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +00dh
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v5
    if-eqz v0, +003h
    goto +2h
    move-object v7, v4
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +00dh
    move-object v0, v8
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v5
    if-eqz v0, +003h
    move-object v4, v8
    if-eqz v7, +00ah
    if-eqz v4, +008h
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    move v2, v5
    return v2
    return v5
.end method

.method private final isTerminalStatus(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "completed"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +015h
    const-string v0, "failed"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00dh
    const-string v0, "canceled"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method private final markAppendInterjections(java.util.List)java.util.List
    .registers 12
    # ins_size=2
    move-object v0, v11
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00dh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v0, v3
    goto +1ah
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    sget-object v4, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->hasAppendInterjectionSignal(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v1
    if-eqz v1, -012h
    move v0, v2
    if-eqz v0, +003h
    return-object v11
    check-cast v11, Ljava/util/Collection;
    invoke-static v11, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v11
    move-object v0, v11
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move v1, v2
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +098h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    add-int/lit8 v5, v1, 1
    if-gez v1, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v6
    if-eqz v6, +00fh
    sget-object v6, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->hasAppendInput(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v7
    if-eqz v7, +007h
    invoke-direct v6, v11, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->markInterjected(Ljava/util/List; I)V
    goto/16 +075h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v6
    if-eqz v6, +012h
    sget-object v6, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->isAppendUserMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v7
    if-eqz v7, +00ah
    invoke-direct v6, v11, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->previousAssistantIndexBefore(Ljava/util/List; I)I
    move-result v1
    invoke-direct v6, v11, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->markInterjected(Ljava/util/List; I)V
    goto +5eh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v6
    if-eqz v6, +059h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFromAppendMsg()Ljava/lang/Boolean;
    move-result-object v6
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +04bh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v4
    const/4 v6, 0
    if-eqz v4, +035h
    invoke-interface v11, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v7
    move v8, v2
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +016h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +003h
    goto +5h
    add-int/lit8 v8, v8, 1
    goto -19h
    const/4 v8, -1
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    move-object v7, v4
    check-cast v7, Ljava/lang/Number;
    invoke-virtual v7, Ljava/lang/Number;->intValue()I
    move-result v7
    if-ltz v7, +004h
    move v7, v3
    goto +2h
    move v7, v2
    if-eqz v7, +003h
    move-object v6, v4
    if-eqz v6, +006h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v1
    sget-object v4, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v4, v11, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->previousAssistantIndexBefore(Ljava/util/List; I)I
    move-result v1
    invoke-direct v4, v11, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->markInterjected(Ljava/util/List; I)V
    move v1, v5
    goto/16 -09ah
    return-object v11
.end method

.method private final markInterjected(java.util.List  int)void
    .registers 65
    # ins_size=3
    move/from16 v0, v64
    if-ltz v0, +086h
    invoke-interface/range v63 ... v64, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isInterjected()Z
    move-result v1
    if-nez v1, +07ah
    invoke-interface/range v63 ... v64, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
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
    const-wide/16 v25, 0
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
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 1
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, -1
    const v60, 8387583
    const/16 v61, 0
    invoke-static/range v2 ... v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->copy$default(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Ljava/lang/Object;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    move-object/from16 v2, v63
    invoke-interface v2, v0, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final mergeDuplicateMessage(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 63
    # ins_size=3
    if-nez v61, +003h
    return-object v62
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v0
    if-eqz v0, +0d9h
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0d1h
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-gtz v0, +009h
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v0
    move-wide/from16 v23, v0
    goto +1bh
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v0
    cmp-long v0, v0, v2
    if-gtz v0, +007h
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v0
    goto -fh
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v0
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v2
    invoke-static v0, v1, v2, v3, Ljava/lang/Math;->min(J J)J
    move-result-wide v0
    goto -1ch
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskIdUser()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskIdUser()Ljava/lang/String;
    move-result-object v0
    move-object v3, v0
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v0
    move-object/from16 v18, v0
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v39, v0
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v0
    move-object/from16 v40, v0
    invoke-virtual/range v61, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v0
    if-nez v0, +00bh
    invoke-virtual/range v62, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    move/from16 v42, v0
    const/4 v1, 0
    const/4 v2, 0
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
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
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
    const/16 v41, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const v57, -4325381
    const v58, 8388255
    const/16 v59, 0
    move-object/from16 v0, v62
    invoke-static/range v0 ... v59, Lcom/bytedance/trae/im/model/ParsedChatMessage;->copy$default(Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Ljava/lang/Object;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v0
    return-object v0
    return-object v62
.end method

.method private final mergeExistingNoticeIntoIncoming(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 4
    # ins_size=3
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    if-eqz v0, +044h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    if-nez v0, +003h
    goto +3ch
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v0
    if-eqz v0, +003h
    return-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeType()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeType()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setNoticeType(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeTitle()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeTitle()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setNoticeTitle(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeMessage()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setNoticeMessage(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContentSecurityRuleName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContentSecurityRuleName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setContentSecurityRuleName(Ljava/lang/String;)V
    return-object v3
.end method

.method public static synthetic mergeMessages$default(com.bytedance.trae.conversation.ConversationMessageStateReducer  java.util.List  java.util.List  kotlin.jvm.functions.Function2  int  java.lang.Object)java.util.List
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +007h
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$$ExternalSyntheticLambda0;
    invoke-direct v3, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->mergeMessages(Ljava/util/List; Ljava/util/List; Lkotlin/jvm/functions/Function2;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private static final mergeMessages$lambda$0(java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final mergeRuntimeNoticeIntoExisting(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)com.bytedance.trae.im.model.ParsedChatMessage
    .registers 4
    # ins_size=3
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    if-eqz v0, +034h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    if-nez v0, +003h
    goto +2ch
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v0
    if-eqz v0, +003h
    return-object v2
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeType()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v2, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setNoticeType(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeTitle()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v2, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setNoticeTitle(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNoticeMessage()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v2, v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setNoticeMessage(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContentSecurityRuleName()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +005h
    invoke-virtual v2, v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->setContentSecurityRuleName(Ljava/lang/String;)V
    return-object v2
.end method

.method private final previousAssistantIndexBefore(java.util.List  int)int
    .registers 5
    # ins_size=3
    const/4 v0, -1
    if-gtz v4, +003h
    return v0
    add-int/lit8 v4, v4, -1
    if-ge v0, v4, +012h
    invoke-interface v3, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v1
    if-eqz v1, +003h
    return v4
    add-int/lit8 v4, v4, -1
    goto -11h
    return v0
.end method

.method private final removeDuplicateFixedUserMessages(java.util.List  int  java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=5
    move-object v0, v5
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->size()I
    move-result v0
    add-int/lit8 v0, v0, -1
    if-ltz v0, +033h
    add-int/lit8 v1, v0, -1
    if-eq v0, v6, +02ah
    invoke-interface v5, v0, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v3
    if-eqz v3, +018h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +00ch
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskIdUser()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +005h
    invoke-interface v5, v0, Ljava/util/List;->remove(I)Ljava/lang/Object;
    if-gez v1, +003h
    goto +3h
    move v0, v1
    goto -30h
    return-void 
.end method

.method private final removeStalePlaceholders(java.util.List)java.util.List
    .registers 14
    # ins_size=2
    move-object v0, v13
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    const/4 v3, 0
    move v4, v3
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 1
    if-eqz v5, +033h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    add-int/lit8 v7, v4, 1
    if-gez v4, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    move-object v8, v5
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v9
    if-eqz v9, +017h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v8
    const/4 v9, 2
    const/4 v10, 0
    const-string v11, "placeholder_"
    invoke-static v8, v11, v3, v9, v10, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +009h
    invoke-static v13, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v8
    if-ge v4, v8, +003h
    goto +2h
    move v6, v3
    if-eqz v6, +005h
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move v4, v7
    goto -37h
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    return-object v13
    check-cast v1, Ljava/lang/Iterable;
    new-instance v13, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v13, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v13, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v13, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v13, Ljava/util/List;
    check-cast v13, Ljava/lang/Iterable;
    invoke-static v13, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v13
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +012h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, -010h
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v1
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-interface v13, v7, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +014h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v7
    if-eqz v7, +00ch
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-interface v1, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +004h
    move v5, v6
    goto +2h
    move v5, v3
    if-eqz v5, -02ah
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2fh
    check-cast v2, Ljava/util/List;
    return-object v2
.end method

.method private final shouldKeepExistingTerminalMessage(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 5
    # ins_size=3
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +039h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v0
    if-nez v0, +003h
    goto +31h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->isTerminalStatus(Ljava/lang/String;)Z
    move-result v3
    if-nez v3, +003h
    return v1
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v3
    if-eqz v3, +020h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +01ah
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    const-string v0, "in_progress"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +00eh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v3
    const-string v4, "queuing"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    const/4 v1, 1
    return v1
.end method

.method private final upsertMessage(java.util.List  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    move-object/from16 v2, v19
    invoke-interface/range v18, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v3
    const/4 v4, 0
    move v5, v4
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v8
    invoke-static v6, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +5h
    add-int/lit8 v5, v5, 1
    goto -1dh
    const/4 v5, -1
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v3
    if-nez v3, +016h
    if-ltz v5, +010h
    invoke-interface v1, v5, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v0, v3, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->mergeDuplicateMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v2
    invoke-interface v1, v5, v2, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    goto +4h
    invoke-interface/range v18 ... v19, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v3
    const/4 v6, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v6
    const/4 v8, 1
    if-eqz v3, +03ch
    invoke-interface/range v18, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v9
    move v10, v4
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +031h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v12
    if-eqz v12, +01eh
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v12
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v12
    goto +2h
    move-object v12, v6
    invoke-static v12, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +00ch
    sget-object v12, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v12, v11, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->isSameAssistantTurn(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v11
    if-eqz v11, +004h
    move v11, v8
    goto +2h
    move v11, v4
    if-eqz v11, +003h
    goto +5h
    add-int/lit8 v10, v10, 1
    goto -34h
    const/4 v10, -1
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v9
    const/4 v11, 2
    const-string v12, "placeholder_"
    if-eqz v9, +044h
    move-object v13, v9
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v13
    xor-int/2addr v13, v8
    if-eqz v13, +003h
    goto +2h
    move-object v9, v6
    if-eqz v9, +036h
    invoke-interface/range v18, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v13
    move v14, v4
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v15
    if-eqz v15, +02bh
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v16
    if-eqz v16, +018h
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v12, v4, v11, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +00eh
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +004h
    move v7, v8
    goto +2h
    move v7, v4
    if-eqz v7, +003h
    goto +5h
    add-int/lit8 v14, v14, 1
    goto -2eh
    const/4 v14, -1
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v12, v4, v11, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +06fh
    if-eqz v3, +057h
    move-object v7, v1
    check-cast v7, Ljava/lang/Iterable;
    instance-of v9, v7, Ljava/util/Collection;
    if-eqz v9, +00dh
    move-object v9, v7
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    if-eqz v9, +004h
    move v3, v4
    goto +41h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, -00ah
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v13
    if-eqz v13, +028h
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v13
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v6
    invoke-static v13, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +016h
    sget-object v13, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v13, v9, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->isSameAssistantTurn(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v13
    if-eqz v13, +00eh
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v12, v4, v11, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +004h
    move v9, v8
    goto +2h
    move v9, v4
    if-eqz v9, -039h
    move v3, v8
    if-eqz v3, +003h
    move v4, v8
    if-eqz v4, +003h
    return-void 
    if-ltz v5, +004h
    move v7, v5
    goto +6h
    if-ltz v10, +004h
    move v7, v10
    goto +2h
    const/4 v7, -1
    if-ltz v7, +006h
    invoke-interface v1, v7, v2, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    goto +4h
    invoke-interface/range v18 ... v19, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
    if-ltz v5, +004h
    move v7, v5
    goto +ah
    if-ltz v10, +004h
    move v7, v10
    goto +6h
    if-ltz v14, +004h
    move v7, v14
    goto +2h
    const/4 v7, -1
    if-ltz v7, +02ah
    invoke-interface v1, v7, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v0, v3, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->shouldKeepExistingTerminalMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v1, v7, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v0, v3, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->mergeRuntimeNoticeIntoExisting(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v2
    invoke-interface v1, v7, v2, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    invoke-interface v1, v7, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v0, v3, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->mergeExistingNoticeIntoIncoming(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v2
    invoke-interface v1, v7, v2, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    goto +4h
    invoke-interface/range v18 ... v19, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final mergeMessages(java.util.List  java.util.List  kotlin.jvm.functions.Function2)java.util.List
    .registers 7
    # ins_size=4
    const-string v0, "currentMessages"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newMessages"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onUserMessageFixup"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +007h
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->sortMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v4
    return-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v4
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +025h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-nez v2, -016h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v2
    if-eqz v2, +007h
    sget-object v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v2, v4, v1, v6, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->fixupUserMessageForAssistant(Ljava/util/List; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-direct v2, v4, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->upsertMessage(Ljava/util/List; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    goto -28h
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->sortMessages(Ljava/util/List;)Ljava/util/List;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->markAppendInterjections(Ljava/util/List;)Ljava/util/List;
    move-result-object v4
    instance-of v6, v5, Ljava/util/Collection;
    const/4 v0, 0
    if-eqz v6, +00ch
    move-object v6, v5
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +003h
    goto +24h
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +00ah
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isAssistantMessage()Z
    move-result v6
    if-eqz v6, +004h
    move v6, v2
    goto +2h
    move v6, v0
    if-eqz v6, -01ch
    move v0, v2
    if-eqz v0, +006h
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->removeStalePlaceholders(Ljava/util/List;)Ljava/util/List;
    move-result-object v4
    return-object v4
.end method

.method public final sortMessages(java.util.List)java.util.List
    .registers 11
    # ins_size=2
    const-string v0, "messages"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v10, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +01ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v3, v4
    if-eqz v3, -019h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1eh
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +023h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v2, v0
    check-cast v2, Ljava/util/Map;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->INSTANCE Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v5, v6, v1, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;->mergeDuplicateMessage(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-result-object v1
    invoke-interface v2, v4, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -26h
    new-instance v10, Ljava/util/ArrayList;
    invoke-direct v10, Ljava/util/ArrayList;-><init>()V
    check-cast v10, Ljava/util/List;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    invoke-virtual v0, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;
    move-result-object v0
    const-string v2, "<get-values>(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v4
    if-eqz v4, +009h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v10, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -18h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v10, Ljava/lang/Iterable;
    const/16 v0, 10
    invoke-static v10, v0, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v0
    const/16 v2, 16
    invoke-static v0, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v0
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, v0, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v2, Ljava/util/Map;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +011h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-interface v2, v5, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -14h
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 0
    if-eqz v5, +03dh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +00dh
    move-object v8, v7
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v3
    if-eqz v8, +003h
    goto +2h
    move-object v7, v6
    if-eqz v7, +009h
    invoke-interface v2, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    goto +2h
    move-object v7, v6
    if-eqz v7, +011h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-interface v0, v6, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-static v7, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-interface v4, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -39h
    invoke-static v6, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-interface v4, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -41h
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, -014h
    invoke-static v1, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    invoke-interface v4, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -1dh
    new-instance v10, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$sortMessages$$inlined$compareBy$1;
    invoke-direct v10, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$sortMessages$$inlined$compareBy$1;-><init>()V
    check-cast v10, Ljava/util/Comparator;
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$sortMessages$$inlined$thenBy$1;
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$sortMessages$$inlined$thenBy$1;-><init>(Ljava/util/Comparator;)V
    check-cast v0, Ljava/util/Comparator;
    check-cast v4, Ljava/lang/Iterable;
    invoke-static v4, v0, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +026h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/Pair;
    invoke-virtual v1, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v4, 2
    new-array v4, v4, [Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v5, 0
    aput-object v2, v4, v5
    aput-object v1, v4, v3
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    goto -29h
    check-cast v0, Ljava/util/List;
    return-object v0
.end method
