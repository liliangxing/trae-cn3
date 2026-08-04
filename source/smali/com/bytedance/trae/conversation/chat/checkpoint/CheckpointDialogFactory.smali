# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;
.super Ljava/lang/Object;
.source "CheckpointDialogFactory.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;
.field private static final exactMatch:Ljava/util/Map;
.field private static fallbackCreator:Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
.field private static final matcherList:Ljava/util/List;


.method public static synthetic $r8$lambda$IbY4ljXV5xgNy7YgQrO8G0YRVwY(java.lang.String)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->_init_$lambda$0(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->exactMatch Ljava/util/Map;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->matcherList Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/FallbackDialogCreator;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/FallbackDialogCreator;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->fallbackCreator Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    const-string v1, "Shell"
    const-string v2, "exec_command"
    const-string/jumbo v3, run_command
    const-string v4, "RunCommand"
    filled-new-array v3, v4, v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
    const-string v1, "AskUserQuestion"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/AskUserQuestionDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/AskUserQuestionDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
    const-string v1, "NotifyUser"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/NotifyUserDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
    const-string v1, "delete_file"
    const-string v2, "DeleteFile"
    filled-new-array v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/DeleteFileDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/DeleteFileDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
    const-string/jumbo v1, run_mcp
    const-string v2, "RunMcp"
    filled-new-array v1, v2, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/MCPCallDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/MCPCallDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
    const-string v1, "ExitPlanMode"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/ExitPlanModeDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/ExitPlanModeDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
    const-string v1, "CommandTimeout"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/CommandTimeoutDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/CommandTimeoutDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
    const-string v1, "RequestAuthorization"
    filled-new-array v1, [Ljava/lang/String;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->register([Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory$$ExternalSyntheticLambda0;-><init>()V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/BrowserActionDialogCreator;-><init>()V
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->registerMatcher(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;)V
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

.method public static synthetic createContentView$default(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialogFactory  android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo  int  java.lang.Object)android.view.View
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->createContentView(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method private final register(java.lang.String[]  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)void
    .registers 7
    # ins_size=3
    array-length v0, v5
    const/4 v1, 0
    if-ge v1, v0, +00ch
    aget-object v2, v5, v1
    sget-object v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->exactMatch Ljava/util/Map;
    invoke-interface v3, v2, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    add-int/lit8 v1, v1, 1
    goto -bh
    return-void 
.end method

.method private final registerMatcher(kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator)void
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->matcherList Ljava/util/List;
    invoke-static v2, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final createContentView(android.content.Context  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)android.view.View
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->getCreator(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    move-result-object v0
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;->createContentView(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public final getCreator(com.bytedance.trae.im.model.ParsedToolCallInfo)com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    .registers 5
    # ins_size=2
    const-string/jumbo v0, toolCallInfo
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->fallbackCreator Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    return-object v4
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->exactMatch Ljava/util/Map;
    invoke-interface v0, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    if-eqz v0, +003h
    return-object v0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->matcherList Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lkotlin/Pair;
    invoke-virtual v2, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlin/jvm/functions/Function1;
    invoke-interface v2, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    if-eqz v2, -01dh
    goto +2h
    const/4 v1, 0
    check-cast v1, Lkotlin/Pair;
    if-eqz v1, +009h
    invoke-virtual v1, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    return-object v4
    sget-object v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogFactory;->fallbackCreator Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;
    return-object v4
.end method
