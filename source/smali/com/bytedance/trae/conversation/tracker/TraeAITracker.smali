# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
.super Ljava/lang/Object;
.source "TraeAITracker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-direct v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildBaseParams(com.bytedance.trae.conversation.tracker.AIEventContext  java.util.Map)org.json.JSONObject
    .registers 8
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getProjectId()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-lez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +00bh
    const-string v1, "project_id"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getProjectId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getSessionId()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +00ch
    const-string/jumbo v1, session_id
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getSessionId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getMessageId()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +00bh
    const-string v1, "message_id"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getChatModel()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +003h
    goto +2h
    move v2, v3
    if-eqz v2, +00bh
    const-string v1, "chat_model"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getChatModel()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v1, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-interface v7, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    invoke-interface v6, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +016h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/util/Map$Entry;
    invoke-interface v7, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v7, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v7
    invoke-virtual v0, v1, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -19h
    return-object v0
.end method

.method static synthetic buildBaseParams$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  java.util.Map  int  java.lang.Object)org.json.JSONObject
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map;)Lorg/json/JSONObject;
    move-result-object v0
    return-object v0
.end method

.method private final mergeSendContext(org.json.JSONObject  com.bytedance.trae.conversation.tracker.AISendMessageContext)void
    .registers 7
    # ins_size=3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getEnvDeployment()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00bh
    const-string v0, "env_deployment"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getEnvDeployment()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getHasGit()Z
    move-result v0
    const-string v3, "has_git"
    invoke-virtual v5, v3, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getGitType()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00bh
    const-string v0, "git_type"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getGitType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getRemoteEnv()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00bh
    const-string v0, "remote_env"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getRemoteEnv()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isSpecMode()Z
    move-result v0
    const-string v3, "is_spec_mode"
    invoke-virtual v5, v3, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->isPlanMode()Z
    move-result v0
    const-string v3, "is_plan_mode"
    invoke-virtual v5, v3, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v0, skill_count
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getSkillCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v0, rules_count
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getRulesCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getCommandType()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00bh
    const-string v0, "command_type"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getCommandType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "file_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getFileCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "folder_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getFolderCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "file_with_comment_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getFileWithCommentCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "data_text_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getDataTextCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "data_text_with_comment_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getDataTextWithCommentCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "data_sheet_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getDataSheetCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "data_sheet_with_comment_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getDataSheetWithCommentCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "markdown_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getMarkdownCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "markdown_with_comment"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getMarkdownWithComment()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "code_selection_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getCodeSelectionCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v0, web_url_count
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getWebUrlCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v0, web_element_count
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getWebElementCount()I
    move-result v3
    invoke-virtual v5, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getMentionType()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +00bh
    const-string v0, "mention_type"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getMentionType()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v0, "log_item_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getLogItemCount()I
    move-result v1
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "image_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getImageCount()I
    move-result v1
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "asr_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getAsrCount()I
    move-result v1
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "attachment_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getAttachmentCount()I
    move-result v1
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v0, "plugin_count"
    invoke-virtual v6, Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;->getPluginCount()I
    move-result v6
    invoke-virtual v5, v0, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    return-void 
.end method

.method private final reportEvent(java.lang.String  org.json.JSONObject  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, solo_chat_mode
    invoke-virtual v4, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v4
    if-eqz v4, +021h
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v0, reportEvent: 
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v0, ", params: "
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v0, "TraeAITracker"
    invoke-static v0, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v4, v2, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static synthetic trackAsrDiscuss$default(com.bytedance.trae.conversation.tracker.TraeAITracker  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrDiscuss(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic trackAsrRewrite$default(com.bytedance.trae.conversation.tracker.TraeAITracker  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrRewrite(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic trackCanceled$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  java.lang.String  java.lang.String  double  java.lang.String  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)void
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 8
    if-eqz v0, +006h
    const-wide/16 v0, 0
    move-wide v6, v0
    goto +2h
    move-wide v6, v14
    and-int/lit8 v0, v18, 16
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v8, v0
    goto +3h
    move-object/from16 v8, v16
    and-int/lit8 v0, v18, 32
    if-eqz v0, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-object v9, v0
    goto +3h
    move-object/from16 v9, v17
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    invoke-virtual/range v2 ... v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackCanceled(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Ljava/lang/String; D Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public static synthetic trackCompleteShow$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  java.lang.String  double  int  int  int  java.lang.String  int  com.bytedance.trae.conversation.tracker.SoloChatMode  java.util.Map  int  java.lang.Object)void
    .registers 30
    # ins_size=15
    move/from16 v0, v28
    and-int/lit8 v1, v0, 2
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v4, v1
    goto +3h
    move-object/from16 v4, v17
    and-int/lit8 v1, v0, 8
    if-eqz v1, +006h
    const-wide/16 v1, 0
    move-wide v6, v1
    goto +3h
    move-wide/from16 v6, v19
    and-int/lit8 v1, v0, 16
    const/4 v2, 0
    if-eqz v1, +004h
    move v8, v2
    goto +3h
    move/from16 v8, v21
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move v9, v2
    goto +3h
    move/from16 v9, v22
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move v10, v2
    goto +3h
    move/from16 v10, v23
    and-int/lit16 v1, v0, 128
    if-eqz v1, +006h
    const-string v1, ""
    move-object v11, v1
    goto +3h
    move-object/from16 v11, v24
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move v12, v2
    goto +3h
    move/from16 v12, v25
    and-int/lit16 v1, v0, 512
    if-eqz v1, +006h
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-object v13, v1
    goto +3h
    move-object/from16 v13, v26
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +008h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    move-object v14, v0
    goto +3h
    move-object/from16 v14, v27
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v5, v18
    invoke-virtual/range v2 ... v14, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackCompleteShow(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Ljava/lang/String; D I I I Ljava/lang/String; I Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Ljava/util/Map;)V
    return-void 
.end method

.method public static synthetic trackCopyClick$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  java.lang.String  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +005h
    const-string/jumbo v2, text
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackCopyClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public static synthetic trackDeleteClick$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackDeleteClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public static synthetic trackDeleteSuccess$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackDeleteSuccess(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public static synthetic trackFeedbackClick$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 16
    if-eqz v12, +004h
    sget-object v11, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackFeedbackClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public static synthetic trackReportClick$default(com.bytedance.trae.conversation.tracker.TraeAITracker  java.lang.String  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +005h
    const-string/jumbo v1, task_detail
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackReportClick(Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic trackRetryClick$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  java.lang.String  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +006h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/tracker/AIEventContext;->getMessageId()Ljava/lang/String;
    move-result-object v2
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackRetryClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/lang/String; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public static synthetic trackRevertClick$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackRevertClick(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public static synthetic trackRevertSuccess$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.SoloChatMode  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackRevertSuccess(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public static synthetic trackShow$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  com.bytedance.trae.conversation.tracker.SoloChatMode  java.util.Map  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    const/4 v2, 0
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v4
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackShow(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Ljava/util/Map;)V
    return-void 
.end method

.method public static synthetic trackTaskCreateResult$default(com.bytedance.trae.conversation.tracker.TraeAITracker  java.lang.String  boolean  int  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 16
    if-eqz v12, +003h
    const/4 v11, 0
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move v2, v8
    move v3, v9
    move-object v4, v10
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTaskCreateResult(Ljava/lang/String; Z I Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic trackTrigger$default(com.bytedance.trae.conversation.tracker.TraeAITracker  com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  com.bytedance.trae.conversation.tracker.SoloChatMode  java.util.Map  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    const/4 v2, 0
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v4
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackTrigger(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext; Lcom/bytedance/trae/conversation/tracker/SoloChatMode; Ljava/util/Map;)V
    return-void 
.end method

.method public final trackAsrDiscuss(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "action"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v4, +016h
    move-object v3, v4
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    goto +2h
    const/4 v4, 0
    if-eqz v4, +007h
    const-string v3, "attempt_id"
    invoke-virtual v1, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "asr_discuss_event"
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-direct v2, v3, v1, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackAsrRecog(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "action"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "asr_recog_event"
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-direct v2, v3, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackAsrRewrite(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "action"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v4, +007h
    const-string v3, "reason"
    invoke-virtual v1, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "asr_rewrite_event"
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-direct v2, v3, v1, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackCanceled(com.bytedance.trae.conversation.tracker.AIEventContext  java.lang.String  java.lang.String  double  java.lang.String  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 10
    # ins_size=8
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cancelReason"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cancelPhase"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map; I Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string v0, "cancel_reason"
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "cancel_phase"
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "duration"
    invoke-virtual v3, v4, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    if-eqz v8, +008h
    const-string/jumbo v4, tool_type
    invoke-virtual v3, v4, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "code_comp_canceled"
    invoke-direct v2, v4, v3, v9, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackCompleteShow(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  java.lang.String  double  int  int  int  java.lang.String  int  com.bytedance.trae.conversation.tracker.SoloChatMode  java.util.Map)void
    .registers 14
    # ins_size=13
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resultType
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "filenameExtension"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraParams"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v13, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map;)Lorg/json/JSONObject;
    move-result-object v2
    const-string/jumbo v13, result_type
    invoke-virtual v2, v13, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "duration"
    invoke-virtual v2, v4, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    const-string v4, "diff_file_count"
    invoke-virtual v2, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v4, "diff_insert_line_count"
    invoke-virtual v2, v4, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v4, "diff_delete_line_count"
    invoke-virtual v2, v4, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    move-object v4, v10
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, +007h
    const-string v4, "filename_extension"
    invoke-virtual v2, v4, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, tool_count
    invoke-virtual v2, v4, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    if-eqz v3, +007h
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->mergeSendContext(Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;)V
    const-string v3, "code_comp_complete_show"
    invoke-direct v1, v3, v2, v12, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackCopyClick(com.bytedance.trae.conversation.tracker.AIEventContext  java.lang.String  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resultType
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map; I Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string/jumbo v0, type
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, result_type
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "code_comp_copy_click"
    invoke-direct v2, v4, v3, v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackDeleteClick(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map; I Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string v0, "code_comp_delete_click"
    invoke-direct v2, v0, v3, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackDeleteSuccess(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map; I Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string v0, "code_comp_delete_success"
    invoke-direct v2, v0, v3, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackFeedbackClick(com.bytedance.trae.conversation.tracker.AIEventContext  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 8
    # ins_size=6
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resultType
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "agentMessageId"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userMessageId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map; I Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string/jumbo v0, type
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v0, result_type
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "agent_message_id"
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, user_message_id
    invoke-virtual v3, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "code_comp_feedback_click"
    invoke-direct v2, v4, v3, v7, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackReportClick(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "enterFrom"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "enter_from"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "icube_report_click"
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/SoloChatMode;->DEFAULT Lcom/bytedance/trae/conversation/tracker/SoloChatMode;
    invoke-direct v2, v3, v0, v1, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackRetryClick(com.bytedance.trae.conversation.tracker.AIEventContext  java.lang.String  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map; I Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +008h
    const-string/jumbo v0, task_id
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "code_comp_retry_click"
    invoke-direct v2, v4, v3, v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackRevertClick(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map; I Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string v0, "code_comp_revert_click"
    invoke-direct v2, v0, v3, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackRevertSuccess(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.SoloChatMode)void
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 2
    invoke-static v2, v3, v0, v1, v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams$default(Lcom/bytedance/trae/conversation/tracker/TraeAITracker; Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map; I Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string v0, "code_comp_revert_success"
    invoke-direct v2, v0, v3, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackShow(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  com.bytedance.trae.conversation.tracker.SoloChatMode  java.util.Map)void
    .registers 6
    # ins_size=5
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraParams"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map;)Lorg/json/JSONObject;
    move-result-object v2
    if-eqz v3, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-direct v5, v2, v3, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->mergeSendContext(Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;)V
    const-string v3, "code_comp_show"
    invoke-direct v1, v3, v2, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method

.method public final trackTaskCreateResult(java.lang.String  boolean  int  java.lang.String  java.lang.String)void
    .registers 9
    # ins_size=6
    const-string v0, "deviceType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string v2, "device_type"
    invoke-virtual v1, v2, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "is_success"
    invoke-virtual v1, v4, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v1, v0, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, use_fast_request
    invoke-virtual v1, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Z)Lorg/json/JSONObject;
    if-eqz v8, +007h
    const-string v4, "fail_reason"
    invoke-virtual v1, v4, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v5, "icube_task_create_result"
    invoke-virtual v4, v5, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0xa
.end method

.method public final trackTrigger(com.bytedance.trae.conversation.tracker.AIEventContext  com.bytedance.trae.conversation.tracker.AISendMessageContext  com.bytedance.trae.conversation.tracker.SoloChatMode  java.util.Map)void
    .registers 6
    # ins_size=5
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "chatMode"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extraParams"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->buildBaseParams(Lcom/bytedance/trae/conversation/tracker/AIEventContext; Ljava/util/Map;)Lorg/json/JSONObject;
    move-result-object v2
    if-eqz v3, +007h
    sget-object v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    invoke-direct v5, v2, v3, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->mergeSendContext(Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;)V
    const-string v3, "code_comp_trigger"
    invoke-direct v1, v3, v2, v4, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject; Lcom/bytedance/trae/conversation/tracker/SoloChatMode;)V
    return-void 
.end method
