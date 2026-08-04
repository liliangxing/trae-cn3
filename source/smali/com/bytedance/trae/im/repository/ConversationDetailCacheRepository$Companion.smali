# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;
.super Ljava/lang/Object;
.source "ConversationDetailCacheRepository.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$dumpParsedMessageFields(com.bytedance.trae.im.repository.ConversationDetailCacheRepository$Companion  java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->dumpParsedMessageFields(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    return-void 
.end method

.method public static final synthetic access$dumpRawJsonFields(com.bytedance.trae.im.repository.ConversationDetailCacheRepository$Companion  java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->dumpRawJsonFields(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final dumpParsedMessageFields(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 47
    # ins_size=4
    move-object/from16 v0, v43
    const-string v1, " | query="
    const-string v2, " | content="
    const-string v3, " | chat_end_time="
    const-string v4, " | chat_start_time="
    const-string v5, " | is_user_canceled="
    const-string v6, " | is_worktree="
    const-string v7, " | agent_process_support="
    const-string v8, " | context_usage="
    const-string v9, " | token_usage="
    const-string v10, " | chat_process_version="
    const-string v11, " | shallow_memento_type="
    const-string v12, " | from_append_msg="
    const-string v13, " | model_smart_selection_meta="
    const-string v14, " | notifications="
    const-string v15, " | max_fee_usage="
    move-object/from16 v16, v1
    const-string v1, " | fee_usage="
    move-object/from16 v17, v2
    const-string v2, " | created_at="
    move-object/from16 v18, v3
    const-string v3, " | trace_id="
    move-object/from16 v19, v4
    const-string v4, " | agent_avatar_id="
    move-object/from16 v20, v5
    const-string v5, " | agent_name="
    move-object/from16 v21, v6
    const-string v6, " | agent_id="
    move-object/from16 v22, v7
    const-string v7, " | agent_type="
    move-object/from16 v23, v8
    const-string v8, " | doc_references="
    move-object/from16 v24, v9
    const-string v9, " | search_reference_data="
    move-object/from16 v25, v10
    const-string v10, " | context_metadata="
    move-object/from16 v26, v11
    const-string v11, " | references="
    move-object/from16 v27, v12
    const-string v12, " | revertible="
    move-object/from16 v28, v13
    const-string v13, " | error="
    move-object/from16 v29, v14
    const-string v14, " | user_message_context="
    move-object/from16 v30, v15
    const-string v15, " | reply_to_message_id="
    move-object/from16 v31, v1
    const-string v1, " | message_index="
    move-object/from16 v32, v2
    const-string v2, " | role="
    move-object/from16 v33, v3
    const-string v3, " | message_type="
    move-object/from16 v34, v4
    const-string v4, " | status="
    move-object/from16 v35, v5
    const-string v5, " | turn_id="
    move-object/from16 v36, v6
    const-string v6, " | message_id="
    move-object/from16 v37, v7
    const-string v7, " | session_id="
    move-object/from16 v38, v8
    const-string v8, "["
    move-object/from16 v39, v9
    new-instance v9, Ljava/lang/StringBuilder;
    invoke-direct v9, Ljava/lang/StringBuilder;-><init>()V
    move-object/from16 v40, v10
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v8, v44
    invoke-virtual v10, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v10, "] msgId="
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    move-object/from16 v10, v45
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v9, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSessionId()Ljava/lang/String;
    move-result-object v7
    const/4 v10, 2
    move-object/from16 v41, v11
    const/4 v11, 0
    move-object/from16 v42, v12
    const/4 v12, 0
    invoke-static v0, v7, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v9, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-static v0, v6, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v7, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v9, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTurnId()Ljava/lang/String;
    move-result-object v5
    invoke-static v0, v5, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v9, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getStatus()Ljava/lang/String;
    move-result-object v4
    invoke-static v0, v4, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageType()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v9, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRole()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v9, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageIndex()I
    move-result v1
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v14, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getUserMessageContext()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getError()Lcom/bytedance/trae/im/model/ParsedError;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedError;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v42
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getRevertible()Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v41
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReferences()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v40
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContextMetadata()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v39
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getSearchReferenceData()Lcom/bytedance/trae/im/model/SearchReferenceData;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/SearchReferenceData;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v38
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getDocReferences()Lcom/bytedance/trae/im/model/DocReferencesData;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/DocReferencesData;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v37
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v36
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentId()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v35
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentName()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v34
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentAvatarId()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v33
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTraceId()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v32
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v2
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v31
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFeeUsage()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v30
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMaxFeeUsage()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonObject;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v29
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getNotifications()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v28
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getModelSmartSelectionMeta()Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v27
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getFromAppendMsg()Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v26
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getShallowMementoType()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v25
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatProcessVersion()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v24
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTokenUsage()Lcom/bytedance/trae/im/model/ParsedTokenUsage;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedTokenUsage;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v23
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContextUsage()Lcom/bytedance/trae/im/model/ParsedContextUsage;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedContextUsage;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v22
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentProcessSupport()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v21
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isWorktree()Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v20
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserCanceled()Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v19
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatStartTime()Ljava/lang/Long;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v18
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getChatEndTime()Ljava/lang/Long;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v17
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getContent()Ljava/lang/Object;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v2, v16
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v46, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v12
    invoke-static v0, v2, v11, v10, v12, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "CacheFieldDiff"
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x7e
.end method

.method private final dumpRawJsonFields(java.lang.String  java.lang.String  java.lang.String)void
    .registers 13
    # ins_size=4
    const-string v0, "CacheFieldDiff"
    const-string v1, "["
    new-instance v2, Lcom/google/gson/Gson;
    invoke-direct v2, Lcom/google/gson/Gson;-><init>()V
    const-class v3, Lcom/google/gson/JsonObject;
    invoke-virtual v2, v12, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/google/gson/JsonObject;
    if-nez v12, +003h
    return-void 
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "] msgId="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v12, Lcom/google/gson/JsonObject;->keySet()Ljava/util/Set;
    move-result-object v3
    const-string v4, "keySet(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->sorted(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +03eh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v12, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +008h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->toString()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, "null"
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    const-string v7, " | "
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v6, 61
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    const/4 v6, 2
    const/4 v7, 0
    const/4 v8, 0
    invoke-static v9, v5, v8, v6, v7, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate$default(Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion; Ljava/lang/String; I I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto -41h
    sget-object v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v12, v0, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto +20h
    move-exception v12
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v1, "] dumpRawJsonFields error: msgId="
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    check-cast v12, Ljava/lang/Throwable;
    invoke-virtual v2, v0, v10, v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x4
.end method

.method private final truncate(java.lang.String  int)java.lang.String
    .registers 4
    # ins_size=3
    if-nez v2, +005h
    const-string v2, "null"
    return-object v2
    invoke-virtual v2, Ljava/lang/String;->length()I
    move-result v0
    if-gt v0, v3, +003h
    goto +18h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v2, v3, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 8230
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method static synthetic truncate$default(com.bytedance.trae.im.repository.ConversationDetailCacheRepository$Companion  java.lang.String  int  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const/16 v2, 30
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;->truncate(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
