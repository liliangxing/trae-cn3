# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
.super Ljava/lang/Object;
.source "ToolDetailCardFactory.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
.field private static final TOOL_TAG:Ljava/lang/String;
.field private static final exactCreators:Ljava/util/Map;
.field private static fallbackCreator:Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
.field private static final matcherCreators:Ljava/util/List;
.field private static final thinkingCreator:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;


.method public static synthetic $r8$lambda$G5Z-fqwBwjyUAVNOcd_jQMWvJOA(java.lang.String)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->_init_$lambda$0(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 11
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->exactCreators Ljava/util/Map;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->matcherCreators Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->fallbackCreator Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;-><init>()V
    sput-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->thinkingCreator Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;
    const-string v2, "edit_file"
    const-string v3, "edit_file_search_replace"
    const-string v4, "edit_file_update"
    const-string v5, "create_file"
    const-string/jumbo v6, write_to_file
    const-string v7, "Write"
    const-string v8, "Edit"
    const-string v9, "MultiEdit"
    const-string v10, "SearchReplace"
    filled-new-array/range v2 ... v10, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EditFileDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string/jumbo v1, view_folder
    const-string v2, "LS"
    const-string v3, "Read"
    const-string/jumbo v4, view_file
    const-string/jumbo v5, view_files
    filled-new-array v3, v4, v5, v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ViewFileDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "delete_file"
    const-string v2, "DeleteFile"
    filled-new-array v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/DeleteFileDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v3, "SearchCodebase"
    const-string v4, "Grep"
    const-string v5, "Glob"
    const-string v6, "file_search"
    const-string/jumbo v7, search_codebase
    const-string/jumbo v8, search_by_regex
    filled-new-array/range v3 ... v8, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SearchDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "Shell"
    const-string v2, "exec_command"
    const-string/jumbo v3, run_command
    const-string v4, "RunCommand"
    filled-new-array v3, v4, v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "mcp_call"
    const-string v2, "MCPCall"
    const-string/jumbo v3, run_mcp
    filled-new-array v3, v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string/jumbo v1, web_search
    const-string v2, "WebSearch"
    filled-new-array v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/WebSearchDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string/jumbo v1, todo_write
    const-string v2, "TodoWrite"
    filled-new-array v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "AskUserQuestion"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory$$ExternalSyntheticLambda0;-><init>()V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->registerMatcher(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "Skill"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "OpenPreview"
    const-string v2, "open_preview_and_wait_for_error"
    const-string v3, "open_preview"
    filled-new-array v3, v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "environment_setup"
    const-string v2, "EnvironmentSetup"
    filled-new-array v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "image_ocr"
    const-string v2, "GenerateImage"
    filled-new-array v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ImageGenerateDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ImageGenerateDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    const-string v1, "RequestAuthorization"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final _init_$lambda$0(java.lang.String)boolean
    .registers 5
    # ins_size=1
    const-string v0, "it"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 2
    const/4 v1, 0
    const-string v2, "browser_"
    const/4 v3, 0
    invoke-static v4, v2, v3, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +012h
    const-string v0, "BrowserHandOver"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ah
    const-string v0, "BrowserWaitingForUserInteraction"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    const/4 v3, 1
    return v3
.end method

.method public static synthetic createDetailCard$default(com.bytedance.trae.conversation.chat.toolcall.ToolDetailCardFactory  android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createDetailCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic createThinkingCard$default(com.bytedance.trae.conversation.chat.toolcall.ToolDetailCardFactory  android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createThinkingCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    return-object v0
.end method

.method private final register(java.lang.String[]  com.bytedance.trae.conversation.chat.toolcall.IToolDetailCardCreator)void
    .registers 7
    # ins_size=3
    array-length v0, v5
    const/4 v1, 0
    if-ge v1, v0, +00ch
    aget-object v2, v5, v1
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->exactCreators Ljava/util/Map;
    invoke-interface v3, v2, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    add-int/lit8 v1, v1, 1
    goto -bh
    return-void 
.end method

.method private final registerMatcher(kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.toolcall.IToolDetailCardCreator)void
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->matcherCreators Ljava/util/List;
    invoke-static v2, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public static synthetic updateDetailCard$default(com.bytedance.trae.conversation.chat.toolcall.ToolDetailCardFactory  android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->updateDetailCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic updateThinkingCard$default(com.bytedance.trae.conversation.chat.toolcall.ToolDetailCardFactory  android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->updateThinkingCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v0
    return-object v0
.end method

.method public final createDetailCard(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 11
    # ins_size=4
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "AgentTool"
    if-nez v0, +024h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[Factory] createDetailCard: name=null, using fallback, id="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->fallbackCreator Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-interface v0, v8, v9, v10, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;->createDetail(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v8
    return-object v8
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->exactCreators Ljava/util/Map;
    invoke-interface v2, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    const-string v3, ", creator="
    if-eqz v2, +02fh
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[Factory] createDetailCard: exact match name="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v2, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v3
    invoke-interface v3, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v2, v8, v9, v10, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;->createDetail(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v8
    return-object v8
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->matcherCreators Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ch
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lkotlin/Pair;
    invoke-virtual v5, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lkotlin/jvm/functions/Function1;
    invoke-interface v5, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    if-eqz v5, -01dh
    goto +2h
    const/4 v4, 0
    check-cast v4, Lkotlin/Pair;
    if-eqz v4, +039h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[Factory] createDetailCard: matcher match name="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v4, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v3
    invoke-interface v3, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-interface v0, v8, v9, v10, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;->createDetail(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v8
    return-object v8
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Factory] createDetailCard: no match, fallback for name="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->fallbackCreator Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    invoke-interface v0, v8, v9, v10, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;->createDetail(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v8
    return-object v8
.end method

.method public final createThinkingCard(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->thinkingCreator Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;->createDetail(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v2
    return-object v2
.end method

.method public final registerExternal(java.lang.String[]  com.bytedance.trae.conversation.chat.toolcall.IToolDetailCardCreator)void
    .registers 4
    # ins_size=3
    const-string v0, "names"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "creator"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v2
    invoke-static v2, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v2
    check-cast v2, [Ljava/lang/String;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    return-void 
.end method

.method public final registerExternalMatcher(kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.toolcall.IToolDetailCardCreator)void
    .registers 4
    # ins_size=3
    const-string v0, "matcher"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "creator"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->registerMatcher(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;)V
    return-void 
.end method

.method public final updateDetailCard(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 10
    # ins_size=4
    const-string v0, "context"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +013h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->fallbackCreator Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
    if-eqz v3, +005h
    check-cast v2, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
    goto +2h
    move-object v2, v1
    if-eqz v2, +006h
    invoke-virtual v2, v7, v0, v8, v9, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->updateCard(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v1
    return-object v1
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->exactCreators Ljava/util/Map;
    invoke-interface v3, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    if-nez v3, +03bh
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->matcherCreators Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ch
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lkotlin/Pair;
    invoke-virtual v5, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lkotlin/jvm/functions/Function1;
    invoke-interface v5, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    if-eqz v5, -01dh
    goto +2h
    move-object v4, v1
    check-cast v4, Lkotlin/Pair;
    if-eqz v4, +009h
    invoke-virtual v4, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    goto +2h
    move-object v3, v1
    if-nez v3, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->fallbackCreator Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
    if-eqz v4, +005h
    check-cast v3, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;
    goto +2h
    move-object v3, v1
    if-eqz v3, +006h
    invoke-virtual v3, v7, v0, v8, v9, Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;->updateCard(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v1
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "[Factory] updateDetailCard: name="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v9, ", id="
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v9, "AgentTool"
    invoke-virtual v7, v9, v8, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
.end method

.method public final updateThinkingCard(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00fh
    const/4 v0, 0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->getPlanItemId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    if-nez v1, +003h
    return-object v0
    move-object v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->thinkingCreator Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;
    invoke-virtual v1, v3, v0, v4, v5, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;->updateCard(Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v3
    return-object v3
.end method
