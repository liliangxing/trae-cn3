# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
.super Ljava/lang/Object;
.source "PlanItemGrouper.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field private static final BROWSER_PREFIX:Ljava/lang/String;
.field private static final EXPLORE_TOOLS:Ljava/util/Set;
.field private static final FINISH_TOOLS:Ljava/util/Set;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
.field private static final PURE_SHOW_WIDGET_TOOL:Ljava/lang/String;
.field private static final TODO_TOOLS:Ljava/util/Set;


.method public static synthetic $r8$lambda$ErEnWGygpnLZNirKXk-VUJg49qY(com.bytedance.trae.conversation.chat.grouping.PlanItemGrouper$TodoItem)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->applyTodoGrouping$lambda$21(Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 12
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    const-string v1, "Read"
    const-string/jumbo v2, view_file
    const-string/jumbo v3, view_files
    const-string/jumbo v4, view_folder
    const-string v5, "LS"
    const-string v6, "SearchCodebase"
    const-string v7, "Grep"
    const-string v8, "Glob"
    const-string v9, "file_search"
    const-string/jumbo v10, search_codebase
    const-string/jumbo v11, search_by_regex
    filled-new-array/range v1 ... v11, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->EXPLORE_TOOLS Ljava/util/Set;
    const-string v1, "finish"
    const-string v2, "Finish"
    const-string v3, "agent_finish"
    const-string v4, "AgentFinish"
    const-string/jumbo v5, response_to_user
    const-string v6, "ResponseToUser"
    const-string v7, "Task"
    filled-new-array/range v1 ... v7, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->FINISH_TOOLS Ljava/util/Set;
    const-string/jumbo v0, todo_write
    const-string v1, "TodoWrite"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->TODO_TOOLS Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final aggregateAllTools(java.util.List  android.content.res.Resources  com.bytedance.trae.conversation.chat.grouping.GroupingContext)java.util.List
    .registers 22
    # ins_size=4
    move-object/from16 v0, v18
    move-object/from16 v1, v20
    move-object/from16 v2, v21
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/List;
    invoke-interface/range v19, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +08dh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v7, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    if-eqz v7, +009h
    invoke-static v4, v2, v1, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools$flushBuffer(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Landroid/content/res/Resources; Ljava/util/List;)V
    invoke-interface v3, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -16h
    instance-of v7, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v7, +01fh
    invoke-static v4, v2, v1, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools$flushBuffer(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Landroid/content/res/Resources; Ljava/util/List;)V
    move-object v8, v6
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v6
    invoke-direct v0, v6, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateContainerChildren(Ljava/util/List; Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v12
    const/4 v13, 0
    const/16 v14, 23
    const/4 v15, 0
    invoke-static/range v8 ... v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->copy$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    move-result-object v6
    invoke-interface v3, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -37h
    instance-of v7, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v7, +022h
    invoke-static v4, v2, v1, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools$flushBuffer(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Landroid/content/res/Resources; Ljava/util/List;)V
    move-object v8, v6
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getChildren()Ljava/util/List;
    move-result-object v6
    invoke-direct v0, v6, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateContainerChildren(Ljava/util/List; Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 111
    const/16 v17, 0
    invoke-static/range v8 ... v17, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->copy$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    move-result-object v6
    invoke-interface v3, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -5bh
    instance-of v7, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v7, +006h
    invoke-interface v4, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -63h
    instance-of v7, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v7, +023h
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isPureShowWidgetTool(Ljava/lang/String;)Z
    move-result v7
    if-eqz v7, +00dh
    invoke-static v4, v2, v1, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools$flushBuffer(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Landroid/content/res/Resources; Ljava/util/List;)V
    invoke-interface v4, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v4, v2, v1, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools$flushBuffer(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Landroid/content/res/Resources; Ljava/util/List;)V
    goto/16 -082h
    invoke-interface v4, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto/16 -087h
    invoke-static v4, v2, v1, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools$flushBuffer(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Landroid/content/res/Resources; Ljava/util/List;)V
    invoke-interface v3, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto/16 -08fh
    invoke-static v4, v2, v1, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools$flushBuffer(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Landroid/content/res/Resources; Ljava/util/List;)V
    return-object v3
.end method

.method private static final aggregateAllTools$flushBuffer(java.util.List  com.bytedance.trae.conversation.chat.grouping.GroupingContext  android.content.res.Resources  java.util.List)void
    .registers 15
    # ins_size=4
    invoke-interface v11, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    move-object v0, v11
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +00eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v4, -00ch
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    move-object v7, v2
    check-cast v7, Ljava/util/List;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +16h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +00dh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v3, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v3, -00eh
    const/4 v2, 1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-direct v1, v7, v2, v11, v12, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->computeGroupFinished(Ljava/util/List; Z Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Z
    move-result v10
    invoke-direct v1, v11, v13, v10, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->buildGroupTitle(Ljava/util/List; Landroid/content/res/Resources; Z)Ljava/lang/String;
    move-result-object v6
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v8
    invoke-static v8, Lkotlin/collections/CollectionsKt;->singleOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v12
    instance-of v13, v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v13, +005h
    check-cast v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    goto +2h
    const/4 v12, 0
    if-eqz v12, +020h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v12
    invoke-direct v1, v12, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isPureShowWidgetTool(Ljava/lang/String;)Z
    move-result v12
    if-eqz v12, +012h
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    const/4 v13, 1
    move-object v4, v12
    move-object v5, v6
    move-object v6, v7
    move-object v7, v8
    move v8, v13
    move v9, v10
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/util/List; Z Z)V
    invoke-interface v14, v12, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +fh
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->determineGroupType(Ljava/util/List;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    move-result-object v5
    const/4 v9, 1
    move-object v4, v12
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType; Ljava/lang/String; Ljava/util/List; Ljava/util/List; Z Z)V
    invoke-interface v14, v12, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v11, Ljava/util/List;->clear()V
    return-void 
.end method

.method private final aggregateContainerChildren(java.util.List  android.content.res.Resources  com.bytedance.trae.conversation.chat.grouping.GroupingContext)java.util.List
    .registers 10
    # ins_size=4
    move-object v0, v7
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +00eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v4, -00ch
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01dh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isPureShowWidgetTool(Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, -01bh
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -20h
    check-cast v2, Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +007h
    invoke-direct v6, v7, v8, v9, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools(Ljava/util/List; Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v7
    return-object v7
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +028h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v4, +016h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isPureShowWidgetTool(Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-nez v3, -026h
    invoke-interface v7, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2bh
    check-cast v7, Ljava/util/List;
    invoke-direct v6, v7, v8, v9, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools(Ljava/util/List; Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/util/Collection;
    invoke-direct v6, v2, v8, v9, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools(Ljava/util/List; Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    invoke-static v7, v8, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v7
    return-object v7
.end method

.method private final aggregateGroupStatus(java.util.List)com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 8
    # ins_size=2
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +005h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v7
    check-cast v7, Ljava/lang/Iterable;
    instance-of v0, v7, Ljava/util/Collection;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00dh
    move-object v3, v7
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v3, v2
    goto +20h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-eq v4, v5, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->WAITING_CONFIRM_REDLIST Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-ne v4, v5, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v1
    if-eqz v4, -018h
    move v3, v1
    if-eqz v3, +005h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v7
    if-eqz v0, +00dh
    move-object v3, v7
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v3, v2
    goto +1bh
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-ne v4, v5, +004h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, -013h
    move v3, v1
    if-eqz v3, +005h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v7
    if-eqz v0, +00dh
    move-object v3, v7
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v3, v2
    goto +1bh
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-ne v4, v5, +004h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, -013h
    move v3, v1
    if-eqz v3, +005h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->FAILED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v7
    if-eqz v0, +00dh
    move-object v3, v7
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v3, v1
    goto +20h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-eq v4, v5, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-ne v4, v5, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v1
    if-nez v4, -018h
    move v3, v2
    if-eqz v3, +005h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v7
    if-eqz v0, +00ch
    move-object v0, v7
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +24h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01bh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    sget-object v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-eq v0, v3, +00dh
    sget-object v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-eq v0, v3, +009h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    if-ne v0, v3, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    if-nez v0, -01ch
    move v1, v2
    if-eqz v1, +005h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v7
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v7
.end method

.method private final applySubAgentGrouping(java.util.List  java.util.Map  com.bytedance.trae.conversation.chat.grouping.GroupingContext)java.util.List
    .registers 28
    # ins_size=4
    move-object/from16 v0, v24
    move-object/from16 v1, v26
    move-object/from16 v2, v27
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-direct v3, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v3, Ljava/util/Map;
    new-instance v4, Ljava/util/LinkedHashMap;
    invoke-direct v4, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v4, Ljava/util/Map;
    invoke-interface/range v25, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    const-string v7, ""
    const/4 v8, 0
    const/4 v9, 1
    if-eqz v6, +05ch
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v10, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-nez v10, -012h
    invoke-direct v0, v6, v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->getAgentRunId(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock; Ljava/util/Map;)Ljava/lang/String;
    move-result-object v10
    if-nez v10, +003h
    goto +2h
    move-object v7, v10
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMainAgentRunId()Ljava/lang/String;
    move-result-object v10
    invoke-static v7, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +010h
    move-object v10, v7
    check-cast v10, Ljava/lang/CharSequence;
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +004h
    move v10, v9
    goto +2h
    move v10, v8
    if-eqz v10, +003h
    move v8, v9
    if-nez v8, -035h
    invoke-interface v3, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    if-nez v8, +00ch
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/List;
    invoke-interface v3, v7, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v8, Ljava/util/List;
    invoke-interface v8, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v4, v7, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, -050h
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->getPlanItemId(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v6
    if-eqz v6, -056h
    invoke-interface v1, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v6, -05eh
    invoke-interface v4, v7, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -63h
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/List;
    new-instance v6, Ljava/util/LinkedHashMap;
    invoke-direct v6, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v6, Ljava/util/Map;
    new-instance v10, Ljava/util/LinkedHashSet;
    invoke-direct v10, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v10, Ljava/util/Set;
    invoke-interface/range v25, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +0b0h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v13, v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v13, +020h
    move-object v14, v12
    check-cast v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v12
    invoke-direct v0, v12, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->applySubAgentGrouping(Ljava/util/List; Ljava/util/Map; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v18
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v19, 0
    const/16 v20, 23
    const/16 v21, 0
    invoke-static/range v14 ... v21, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->copy$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    move-result-object v12
    invoke-interface v5, v12, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2dh
    invoke-direct v0, v12, v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->getAgentRunId(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock; Ljava/util/Map;)Ljava/lang/String;
    move-result-object v13
    if-nez v13, +003h
    move-object v13, v7
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMainAgentRunId()Ljava/lang/String;
    move-result-object v14
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-nez v14, +013h
    move-object v14, v13
    check-cast v14, Ljava/lang/CharSequence;
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v14
    if-nez v14, +004h
    move v14, v9
    goto +2h
    move v14, v8
    if-eqz v14, +003h
    goto +3h
    move v14, v8
    goto +2h
    move v14, v9
    if-eqz v14, +010h
    invoke-interface v6, Ljava/util/Map;->isEmpty()Z
    move-result v13
    xor-int/2addr v13, v9
    if-eqz v13, +005h
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->markRunningSubAgentsCompleted(Ljava/util/List; Ljava/util/Map;)V
    invoke-interface v5, v12, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -60h
    invoke-interface v10, v13, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v12
    if-nez v12, -065h
    invoke-interface v10, v13, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-interface v3, v13, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Ljava/util/List;
    if-nez v12, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v12
    move-object/from16 v19, v12
    invoke-interface v4, v13, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    new-instance v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    const/4 v14, 0
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentId()Ljava/lang/String;
    move-result-object v16
    goto +3h
    move-object/from16 v16, v14
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v17
    goto +3h
    move-object/from16 v17, v14
    if-eqz v12, +009h
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getSubAgentCallDescription()Ljava/lang/String;
    move-result-object v12
    move-object/from16 v18, v12
    goto +3h
    move-object/from16 v18, v14
    sget-object v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    const/16 v21, 0
    const/16 v22, 64
    const/16 v23, 0
    move-object v14, v15
    move-object v12, v15
    move-object v15, v13
    invoke-direct/range v14 ... v23, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v6, v13, v12, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v5, v12, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto/16 -0b2h
    invoke-direct v0, v5, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->correctSubAgentStatuses(Ljava/util/List; Ljava/util/Map; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)V
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->markLastRunningSubAgent(Ljava/util/List;)V
    return-object v5
.end method

.method private final applyTodoGrouping(java.util.List  java.util.Map  com.bytedance.trae.conversation.chat.grouping.GroupingContext)java.util.List
    .registers 34
    # ins_size=4
    move-object/from16 v0, v30
    move-object/from16 v10, v32
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    move-object v11, v1
    check-cast v11, Ljava/util/List;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    move-object v12, v1
    check-cast v12, Ljava/util/List;
    new-instance v1, Ljava/util/LinkedHashSet;
    invoke-direct v1, Ljava/util/LinkedHashSet;-><init>()V
    move-object v13, v1
    check-cast v13, Ljava/util/Set;
    invoke-interface/range v31, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v14
    const/16 v16, 0
    move-object/from16 v3, v16
    move-object v4, v3
    move-object v5, v4
    const/4 v1, 0
    const/4 v2, 0
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    const-string/jumbo v7, summary
    if-eqz v6, +1e9h
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->getPlanItemId(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +009h
    invoke-interface v10, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    goto +3h
    move-object/from16 v8, v16
    instance-of v15, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v15, +015h
    move-object v15, v6
    check-cast v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v15
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v15
    invoke-direct v0, v15, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isTodoTool(Ljava/lang/String;)Z
    move-result v15
    if-eqz v15, +004h
    const/4 v15, 1
    goto +2h
    const/4 v15, 0
    if-eqz v15, +041h
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v15
    goto +3h
    move-object/from16 v15, v16
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMainAgentRunId()Ljava/lang/String;
    move-result-object v9
    invoke-static v15, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +02ch
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v8
    goto +3h
    move-object/from16 v8, v16
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +3h
    const/4 v8, 0
    goto +2h
    const/4 v8, 1
    if-eqz v8, +015h
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMainAgentRunId()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    if-eqz v8, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    if-eqz v8, +171h
    if-nez v1, +013h
    move-object v1, v12
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    const/4 v8, 1
    xor-int/2addr v3, v8
    if-eqz v3, +008h
    invoke-interface v11, v1, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-interface v12, Ljava/util/List;->clear()V
    const-string v1, "null cannot be cast to non-null type com.bytedance.trae.conversation.chat.block.AgentContentBlock.Toolcall"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v15, v6
    check-cast v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->parseTodosFromParams(Lcom/google/gson/JsonObject;)Ljava/util/List;
    move-result-object v8
    if-eqz v1, +01ah
    invoke-virtual v1, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +014h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    move-object/from16 v1, v16
    if-eqz v1, +009h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    move-object/from16 v18, v1
    goto +3h
    move-object/from16 v18, v16
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->parseTodosFromResult(Lcom/bytedance/trae/im/model/ParsedToolCallResult;)Ljava/util/List;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v8, v1
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v1
    goto +3h
    move-object/from16 v1, v16
    const-string/jumbo v3, success
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +0fdh
    if-eqz v8, +0fbh
    check-cast v8, Ljava/lang/Iterable;
    instance-of v1, v8, Ljava/util/Collection;
    const-string v2, "completed"
    if-eqz v1, +00eh
    move-object v1, v8
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +005h
    const/16 v19, 1
    goto +1dh
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, -00bh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, -014h
    const/16 v19, 0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v20
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +026h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v7, v4
    check-cast v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;->getStatus()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +00eh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-interface v13, v7, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +004h
    const/4 v8, 1
    goto +2h
    const/4 v8, 0
    if-eqz v8, -024h
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -29h
    check-cast v1, Ljava/util/List;
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    const/4 v9, 1
    xor-int/2addr v2, v9
    if-eqz v2, +07dh
    invoke-interface v12, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v13, v2, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z
    const-string v2, " & "
    move-object/from16 v22, v2
    check-cast v22, Ljava/lang/CharSequence;
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    new-instance v27, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$$ExternalSyntheticLambda0;
    invoke-direct/range v27, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$$ExternalSyntheticLambda0;-><init>()V
    const/16 v28, 30
    const/16 v29, 0
    move-object/from16 v21, v1
    invoke-static/range v21 ... v29, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v4
    move-object v1, v12
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v5
    const/4 v8, 0
    move-object/from16 v1, v32
    move-object/from16 v2, v33
    move-object v3, v11
    move-object/from16 v7, v18
    move-object/from16 v17, v13
    move v13, v9
    move/from16 v9, v19
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->applyTodoGrouping$flushTodoSection(Ljava/util/Map; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Ljava/util/List; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Z Z)V
    invoke-interface v12, Ljava/util/List;->clear()V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v3
    move v1, v13
    move-object/from16 v13, v17
    move-object/from16 v5, v18
    move/from16 v2, v19
    move-object/from16 v4, v20
    goto/16 -1cch
    move-object/from16 v17, v13
    move v13, v9
    move/from16 v2, v19
    move-object/from16 v4, v20
    goto +4h
    move-object/from16 v17, v13
    const/4 v13, 1
    invoke-interface v12, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v3
    move v1, v13
    move-object/from16 v13, v17
    if-eqz v18, -1e3h
    move-object/from16 v5, v18
    goto/16 -1e7h
    move-object/from16 v17, v13
    invoke-interface v12, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto/16 -1eeh
    const/4 v13, 1
    move-object v6, v12
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    xor-int/2addr v8, v13
    if-eqz v8, +0d1h
    invoke-virtual/range v33, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMainAgentRunId()Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v12, v10, v8, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->filterFinishElements(Ljava/util/List; Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;
    move-result-object v8
    move-object/from16 v9, v33
    const/4 v12, 0
    invoke-direct v0, v9, v13, v12, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->computeTodoStatus(Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Z Z)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v9
    if-eqz v1, +019h
    if-eqz v3, +017h
    if-nez v2, +015h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;->getFilteredBlocks()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/2addr v1, v13
    if-eqz v1, +008h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-eq v9, v1, +004h
    move v15, v13
    goto +2h
    move v15, v12
    if-eqz v15, +0a3h
    if-eqz v4, +087h
    invoke-interface v10, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    goto +3h
    move-object/from16 v2, v16
    if-eqz v2, +018h
    invoke-virtual v2, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +012h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move-object/from16 v4, v16
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +3h
    move-object/from16 v4, v16
    if-eqz v4, +003h
    move-object v5, v4
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v1
    goto +3h
    move-object/from16 v1, v16
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->parseTodosFromResult(Lcom/bytedance/trae/im/model/ParsedToolCallResult;)Ljava/util/List;
    move-result-object v1
    if-nez v1, +006h
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->parseTodosFromParams(Lcom/google/gson/JsonObject;)Ljava/util/List;
    move-result-object v1
    if-eqz v1, +03ah
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;->getStatus()Ljava/lang/String;
    move-result-object v4
    const-string v6, "in_progress"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -017h
    goto +3h
    move-object/from16 v2, v16
    check-cast v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;->getContent()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v13
    if-eqz v2, +004h
    move-object/from16 v16, v1
    move-object/from16 v4, v16
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;->getFilteredBlocks()Ljava/util/List;
    move-result-object v6
    move-object v2, v1
    move-object v7, v9
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    invoke-interface v11, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;->getFinishBlocks()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v11, v1, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    goto +4h
    invoke-interface v11, v6, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    return-object v11
.end method

.method private static final applyTodoGrouping$flushTodoSection(java.util.Map  com.bytedance.trae.conversation.chat.grouping.GroupingContext  java.util.List  java.lang.String  java.util.List  java.lang.String  java.lang.String  boolean  boolean)void
    .registers 16
    # ins_size=9
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMainAgentRunId()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v11, v7, v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->filterFinishElements(Ljava/util/List; Ljava/util/Map; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;
    move-result-object v7
    invoke-direct v0, v8, v14, v15, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->computeTodoStatus(Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Z Z)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v6
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;->getFilteredBlocks()Ljava/util/List;
    move-result-object v5
    move-object v1, v8
    move-object v2, v10
    move-object v3, v12
    move-object v4, v13
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    invoke-interface v9, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;->getFinishBlocks()Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/util/Collection;
    invoke-interface v9, v7, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    return-void 
.end method

.method private static final applyTodoGrouping$lambda$21(com.bytedance.trae.conversation.chat.grouping.PlanItemGrouper$TodoItem)java.lang.CharSequence
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;->getContent()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    return-object v1
.end method

.method private final applyToolAggregation(java.util.List  android.content.res.Resources  com.bytedance.trae.conversation.chat.grouping.GroupingContext)java.util.List
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateAllTools(Ljava/util/List; Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v1
    return-object v1
.end method

.method private final buildGroupTitle(java.util.List  android.content.res.Resources  boolean)java.lang.String
    .registers 14
    # ins_size=4
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v3, -00ch
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    move-object v5, v1
    check-cast v5, Ljava/util/List;
    instance-of v1, v11, Ljava/util/Collection;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +00dh
    move-object v1, v11
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v6, v3
    goto +16h
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v1, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v1, -00eh
    move v6, v2
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v4
    if-eqz v4, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v4
    if-ne v4, v2, +004h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v4, -01ch
    invoke-interface v11, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -21h
    check-cast v11, Ljava/util/List;
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +016h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, -014h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v9
    sget-object v4, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->Companion Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;
    move-object v7, v12
    move v8, v13
    invoke-virtual/range v4 ... v9, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;->buildDynamicGroupTitle(Ljava/util/List; Z Landroid/content/res/Resources; Z Ljava/util/Set;)Ljava/lang/String;
    move-result-object v11
    return-object v11
.end method

.method static synthetic buildGroupTitle$default(com.bytedance.trae.conversation.chat.grouping.PlanItemGrouper  java.util.List  android.content.res.Resources  boolean  int  java.lang.Object)java.lang.String
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->buildGroupTitle(Ljava/util/List; Landroid/content/res/Resources; Z)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final computeGroupFinished(java.util.List  boolean  java.util.List  com.bytedance.trae.conversation.chat.grouping.GroupingContext)boolean
    .registers 8
    # ins_size=5
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isHistory()Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +003h
    return v1
    invoke-interface v4, Ljava/util/List;->isEmpty()Z
    move-result v0
    const/4 v2, 0
    if-eqz v0, +037h
    if-nez v5, +003h
    return v2
    check-cast v6, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +00eh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    instance-of v7, v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v7, -00ch
    invoke-interface v4, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v4, Ljava/util/List;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v4, +009h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->isThinking()Z
    move-result v4
    if-nez v4, +003h
    goto +2h
    move v1, v2
    return v1
    check-cast v4, Ljava/lang/Iterable;
    instance-of v5, v4, Ljava/util/Collection;
    if-eqz v5, +00ch
    move-object v5, v4
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    goto +1ah
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +011h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-direct v0, v5, v6, v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isToolcallFinished(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Z
    move-result v5
    if-nez v5, -012h
    move v1, v2
    return v1
.end method

.method private final computePlanItemExecutionStatus(com.bytedance.trae.im.model.ParsedPlanItem)com.bytedance.trae.conversation.chat.grouping.PlanItemExecutionStatus
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ConfirmInfo;->isEnterpriseCommandBlacklist()Z
    move-result v3
    if-ne v3, v1, +004h
    move v3, v1
    goto +2h
    move v3, v2
    if-eqz v3, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    return-object v6
    const/4 v3, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ConfirmInfo;->getConfirmStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v6
    if-eqz v6, +00ch
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v6
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v3
    if-eqz v0, +035h
    const-string/jumbo v6, unconfirmed
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +02ch
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ConfirmInfo;->getBlockLevel()Ljava/lang/String;
    move-result-object v6
    const-string v3, "redlist"
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +018h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ConfirmInfo;->getHitRedList()Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/util/Collection;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move v6, v2
    goto +2h
    move v6, v1
    if-nez v6, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->WAITING_CONFIRM_REDLIST Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    goto +3h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    return-object v6
    const-string v6, "canceled"
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    return-object v6
    const-string/jumbo v6, skipped
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +049h
    const-string/jumbo v0, skippedRun
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3eh
    if-eqz v3, +03ah
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +000003ah
    goto +31h
    invoke-virtual v3, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +2ah
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    goto +29h
    const-string/jumbo v6, running
    invoke-virtual v3, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +1dh
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    goto +1ch
    const-string v6, "failed"
    invoke-virtual v3, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +11h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    goto +10h
    const-string/jumbo v6, success
    invoke-virtual v3, v6, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v6
    if-nez v6, +003h
    goto +4h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    goto +3h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    return-object v6
    sget-object v6, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    return-object v6
    sparse-switch-payload -6f4abffd -4c696bc3 5c6f15bf 7fff6730
.end method

.method private final computeSubAgentStatus(com.bytedance.trae.conversation.chat.block.AgentContentBlock$SubAgentGroup  java.util.Map  com.bytedance.trae.conversation.chat.grouping.GroupingContext  boolean)com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 8
    # ins_size=5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->getPlanItemId(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, -012h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v5, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v1, -012h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v0, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +012h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->computePlanItemExecutionStatus(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;
    move-result-object v0
    invoke-interface v4, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v4, Ljava/util/List;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->aggregateGroupStatus(Ljava/util/List;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->FAILED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v4, v5, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->FAILED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v4, v5, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v5
    const-string v0, "in_progress"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isHistory()Z
    move-result v0
    if-nez v0, +010h
    if-nez v5, +003h
    goto +ch
    if-eqz v7, +00ah
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isLatestTurn()Z
    move-result v5
    if-eqz v5, +004h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v4, v5, +004h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v4
.end method

.method private final computeTodoStatus(com.bytedance.trae.conversation.chat.grouping.GroupingContext  boolean  boolean)com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 6
    # ins_size=4
    if-eqz v5, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
    if-nez v4, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isHistory()Z
    move-result v4
    const-string v5, "in_progress"
    if-eqz v4, +00eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v0
    const-string v1, "canceled"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +05fh
    if-eqz v4, +003h
    goto +5bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v4
    const-string v0, "paused"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->WAITING_CONFIRM Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v4
    const-string v0, "failed"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->FAILED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v4
    const-string v0, "completed"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isHistory()Z
    move-result v4
    if-nez v4, +026h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isLatestTurn()Z
    move-result v4
    if-nez v4, +003h
    goto +1eh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +012h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v3
    const-string v4, "queuing"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +4h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v3
.end method

.method private final correctSubAgentStatuses(java.util.List  java.util.Map  com.bytedance.trae.conversation.chat.grouping.GroupingContext)void
    .registers 21
    # ins_size=4
    move-object/from16 v0, v18
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v1
    const-string v2, "in_progress"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isHistory()Z
    move-result v2
    if-nez v2, +008h
    if-nez v1, +003h
    goto +4h
    move-object/from16 v4, v17
    goto +4eh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->size()I
    move-result v1
    const/4 v2, 0
    move v3, v2
    if-ge v3, v1, -00ch
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v5, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v5, +033h
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v4, v5, +028h
    move-object/from16 v4, v17
    move-object/from16 v5, v19
    move-object/from16 v15, v20
    invoke-direct v4, v6, v5, v15, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->computeSubAgentStatus(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup; Ljava/util/Map; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Z)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v7
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-eq v7, v8, +003h
    goto +3h
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-object v12, v7
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v13, 0
    const/16 v14, 95
    const/16 v16, 0
    move-object/from16 v15, v16
    invoke-static/range v6 ... v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->copy$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    move-result-object v6
    invoke-interface v0, v3, v6, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    goto +5h
    move-object/from16 v4, v17
    move-object/from16 v5, v19
    add-int/lit8 v3, v3, 1
    goto -43h
    return-void 
.end method

.method private final determineGroupType(java.util.List)com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupType
    .registers 5
    # ins_size=2
    check-cast v4, Ljava/lang/Iterable;
    instance-of v0, v4, Ljava/util/Collection;
    const/4 v1, 0
    if-eqz v0, +00ch
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +1eh
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +015h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isBrowserTool(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, -016h
    const/4 v1, 1
    if-eqz v1, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;->BROWSER Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    return-object v4
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;->EXPLORE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    return-object v4
.end method

.method private final expandPlanItem(com.bytedance.trae.im.model.ParsedPlanItem  com.bytedance.trae.conversation.chat.grouping.GroupingContext  boolean)java.util.List
    .registers 11
    # ins_size=4
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getHide()Ljava/lang/Boolean;
    move-result-object v0
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    return-object v8
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    if-eqz v3, +062h
    move-object v6, v3
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v1
    goto +2h
    move v6, v5
    if-eqz v6, +003h
    goto +2h
    move-object v3, v4
    if-eqz v3, +050h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +3h
    move v6, v5
    goto +2h
    move v6, v1
    if-eqz v6, +019h
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move v6, v5
    goto +2h
    move v6, v1
    if-nez v6, +003h
    goto +3h
    move v6, v5
    goto +2h
    move v6, v1
    xor-int/2addr v10, v1
    if-nez v6, +00ch
    if-nez v10, +00ah
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isStreaming()Z
    move-result v9
    if-eqz v9, +004h
    move v9, v1
    goto +2h
    move v9, v5
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v6
    invoke-direct v10, v2, v3, v6, v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Z)V
    invoke-interface v0, v10, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v9
    if-eqz v9, +02eh
    move-object v10, v9
    check-cast v10, Ljava/lang/CharSequence;
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-lez v10, +004h
    move v10, v1
    goto +2h
    move v10, v5
    if-eqz v10, +003h
    goto +2h
    move-object v9, v4
    if-eqz v9, +01ch
    sget-object v10, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-direct v10, v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isFinishTool(Ljava/lang/String;)Z
    move-result v10
    if-nez v10, +00ah
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    invoke-direct v10, v2, v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v10, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v9
    if-eqz v9, +032h
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    if-eqz v10, +00ah
    invoke-interface v10, Ljava/lang/CharSequence;->length()I
    move-result v10
    if-nez v10, +003h
    goto +2h
    move v1, v5
    if-nez v1, +020h
    sget-object v10, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isFinishTool(Ljava/lang/String;)Z
    move-result v1
    if-nez v1, +014h
    invoke-direct v10, v8, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->shouldSkipEmptyFinishToolcall(Lcom/bytedance/trae/im/model/ParsedPlanItem;)Z
    move-result v10
    if-nez v10, +00eh
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v8
    invoke-direct v10, v2, v9, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)V
    invoke-interface v0, v10, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-object v0
.end method

.method static synthetic expandPlanItem$default(com.bytedance.trae.conversation.chat.grouping.PlanItemGrouper  com.bytedance.trae.im.model.ParsedPlanItem  com.bytedance.trae.conversation.chat.grouping.GroupingContext  boolean  int  java.lang.Object)java.util.List
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 1
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->expandPlanItem(Lcom/bytedance/trae/im/model/ParsedPlanItem; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Z)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private final filterFinishElements(java.util.List  java.util.Map  java.lang.String)com.bytedance.trae.conversation.chat.grouping.PlanItemGrouper$FilterFinishResult
    .registers 8
    # ins_size=4
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +016h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v4, v2, v6, v7, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isMainAgentFinish(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock; Ljava/util/Map; Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +006h
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -15h
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -19h
    new-instance v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;
    invoke-direct v5, v0, v1, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;-><init>(Ljava/util/List; Ljava/util/List;)V
    return-object v5
.end method

.method private final getAgentRunId(com.bytedance.trae.conversation.chat.block.AgentContentBlock  java.util.Map)java.lang.String
    .registers 4
    # ins_size=3
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->getPlanItemId(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Ljava/lang/String;
    move-result-object v2
    const/4 v0, 0
    if-nez v2, +003h
    return-object v0
    invoke-interface v3, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final getPlanItemId(com.bytedance.trae.conversation.chat.block.AgentContentBlock)java.lang.String
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getPlanItemId()Ljava/lang/String;
    move-result-object v2
    goto +18h
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;->getPlanItemId()Ljava/lang/String;
    move-result-object v2
    goto +dh
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v0, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method private final isBrowserTool(java.lang.String)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 0
    if-eqz v5, +00eh
    const/4 v1, 2
    const/4 v2, 0
    const-string v3, "browser_"
    invoke-static v5, v3, v0, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    const/4 v1, 1
    if-ne v5, v1, +003h
    move v0, v1
    return v0
.end method

.method private final isExploreTool(java.lang.String)boolean
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->EXPLORE_TOOLS Ljava/util/Set;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method private final isFinishTool(java.lang.String)boolean
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->FINISH_TOOLS Ljava/util/Set;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method private final isMainAgentFinish(com.bytedance.trae.conversation.chat.block.AgentContentBlock  java.util.Map  java.lang.String)boolean
    .registers 6
    # ins_size=4
    instance-of v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isFinishTool(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +003h
    return v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v4, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getAgentRunId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    const/4 v5, 1
    if-nez v4, +00fh
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +004h
    move v3, v5
    goto +2h
    move v3, v1
    if-eqz v3, +003h
    move v1, v5
    return v1
.end method

.method private final isPureShowWidgetTool(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "PureShowWidget"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method private final isSearchTool(java.lang.String)boolean
    .registers 8
    # ins_size=2
    const-string v0, "SearchCodebase"
    const-string v1, "Grep"
    const-string v2, "Glob"
    const-string v3, "file_search"
    const-string/jumbo v4, search_codebase
    const-string/jumbo v5, search_by_regex
    filled-new-array/range v0 ... v5, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, v7, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v7
    return v7
.end method

.method private final isTodoTool(java.lang.String)boolean
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->TODO_TOOLS Ljava/util/Set;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->contains(Ljava/lang/Iterable; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method private final isToolcallFinished(com.bytedance.trae.im.model.ParsedToolCallInfo  java.util.List  com.bytedance.trae.conversation.chat.grouping.GroupingContext)boolean
    .registers 8
    # ins_size=4
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isHistory()Z
    move-result v7
    const/4 v0, 1
    if-eqz v7, +003h
    return v0
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v2, -00ch
    invoke-interface v7, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    const/4 v1, 0
    if-eqz v7, +01ch
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -01eh
    goto +2h
    move-object v7, v1
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v6
    goto +2h
    move-object v6, v1
    const/4 v7, 0
    if-eqz v6, +00ah
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ConfirmInfo;->isEnterpriseCommandBlacklist()Z
    move-result v2
    if-ne v2, v0, +004h
    move v2, v0
    goto +2h
    move v2, v7
    if-eqz v2, +003h
    return v0
    if-eqz v6, +00ah
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ConfirmInfo;->isWaitingConfirm()Z
    move-result v2
    if-ne v2, v0, +004h
    move v2, v0
    goto +2h
    move v2, v7
    if-eqz v2, +003h
    return v7
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    goto +2h
    move-object v2, v1
    if-nez v2, +07fh
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getErrorMessage()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    if-eqz v2, +004h
    goto/16 +073h
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getStatus()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v1
    const-string/jumbo v2, skipped
    if-eqz v5, +02eh
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v3
    sparse-switch v3, +0000061h
    goto +25h
    invoke-virtual v5, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +020h
    goto +1dh
    const-string v3, "error"
    invoke-virtual v5, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +016h
    goto +15h
    const-string v3, "failed"
    invoke-virtual v5, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00dh
    goto +ch
    const-string/jumbo v3, success
    invoke-virtual v5, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +2h
    return v0
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ConfirmInfo;->getConfirmStatus()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +031h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v5
    const v6, -123173735
    if-eq v5, v6, +01eh
    const v6, 982142267
    if-eq v5, v6, +00fh
    const v6, 2147444528
    if-eq v5, v6, +003h
    goto +1ch
    invoke-virtual v1, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +017h
    goto +14h
    const-string/jumbo v5, skippedRun
    invoke-virtual v1, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00ch
    goto +bh
    const-string v5, "canceled"
    invoke-virtual v1, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +2h
    return v0
    return v7
    return v0
    sparse-switch-payload -6f4abffd -4c696bc3 5c4d208 7fff6730
.end method

.method private final markLastRunningSubAgent(java.util.List)void
    .registers 19
    # ins_size=2
    move-object/from16 v0, v18
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->size()I
    move-result v2
    const/4 v3, -1
    add-int/2addr v2, v3
    if-ltz v2, +026h
    add-int/lit8 v4, v2, -1
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    instance-of v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v5, +017h
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    const-string v6, "null cannot be cast to non-null type com.bytedance.trae.conversation.chat.block.AgentContentBlock.SubAgentGroup"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v5, v6, +004h
    move v3, v2
    goto +6h
    if-gez v4, +003h
    goto +3h
    move v2, v4
    goto -23h
    invoke-interface v1, Ljava/util/Collection;->size()I
    move-result v1
    const/4 v2, 0
    move v4, v2
    if-ge v4, v1, +029h
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v6, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v6, +01ch
    move-object v7, v5
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    if-ne v4, v3, +005h
    const/4 v5, 1
    move v14, v5
    goto +2h
    move v14, v2
    const/16 v15, 63
    const/16 v16, 0
    invoke-static/range v7 ... v16, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->copy$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    move-result-object v5
    invoke-interface v0, v4, v5, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    add-int/lit8 v4, v4, 1
    goto -28h
    return-void 
.end method

.method private final markRunningSubAgentsCompleted(java.util.List  java.util.Map)void
    .registers 18
    # ins_size=3
    move-object/from16 v0, v16
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->size()I
    move-result v1
    const/4 v2, 0
    if-ge v2, v1, +038h
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v4, +029h
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getStatus()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-ne v4, v5, +01fh
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    sget-object v11, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    const/4 v12, 0
    const/16 v13, 95
    const/4 v14, 0
    move-object v5, v3
    invoke-static/range v5 ... v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->copy$default(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    move-result-object v4
    invoke-interface v0, v2, v4, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentRunId()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v5, v17
    invoke-interface v5, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +3h
    move-object/from16 v5, v17
    add-int/lit8 v2, v2, 1
    goto -37h
    return-void 
.end method

.method private final parseTodosFromParams(com.google.gson.JsonObject)java.util.List
    .registers 9
    # ins_size=2
    const/4 v0, 0
    if-eqz v8, +00ah
    const-string/jumbo v1, todos
    invoke-virtual v8, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    goto +2h
    move-object v8, v0
    if-eqz v8, +0adh
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v8, v0
    if-eqz v8, +0a3h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v8
    if-nez v8, +004h
    goto/16 +09bh
    check-cast v8, Ljava/lang/Iterable;
    invoke-static v8, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +07fh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/google/gson/JsonElement;
    if-eqz v2, +06fh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +065h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-nez v2, +004h
    goto/16 +05dh
    const-string v3, "id"
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    const-string v4, ""
    if-nez v3, +003h
    move-object v3, v4
    const-string v5, "content"
    invoke-virtual v2, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +011h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v0
    if-nez v5, +003h
    move-object v5, v4
    const-string/jumbo v6, status
    invoke-virtual v2, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v0
    if-nez v2, +003h
    goto +2h
    move-object v4, v2
    new-instance v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;
    invoke-direct v2, v3, v5, v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    if-eqz v2, -07ch
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -081h
    check-cast v1, Ljava/util/List;
    move-object v0, v1
    return-object v0
    :try_start_0x3
    :try_start_0x70
.end method

.method private final parseTodosFromResult(com.bytedance.trae.im.model.ParsedToolCallResult)java.util.List
    .registers 9
    # ins_size=2
    const/4 v0, 0
    if-eqz v8, +0dah
    invoke-virtual v8, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v8
    if-nez v8, +004h
    goto/16 +0d2h
    const-string/jumbo v1, todo_list
    invoke-virtual v8, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +0c9h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v8, v0
    if-eqz v8, +0bfh
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v8
    if-nez v8, +004h
    goto/16 +0b7h
    const-string/jumbo v1, todos
    invoke-virtual v8, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +0aeh
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v8, v0
    if-eqz v8, +0a4h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v8
    if-nez v8, +004h
    goto/16 +09ch
    check-cast v8, Ljava/lang/Iterable;
    invoke-static v8, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +07fh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/google/gson/JsonElement;
    if-eqz v2, +06fh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +065h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-nez v2, +004h
    goto/16 +05dh
    const-string v3, "id"
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    const-string v4, ""
    if-nez v3, +003h
    move-object v3, v4
    const-string v5, "content"
    invoke-virtual v2, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +011h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v0
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v0
    if-nez v5, +003h
    move-object v5, v4
    const-string/jumbo v6, status
    invoke-virtual v2, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v0
    if-nez v2, +003h
    goto +2h
    move-object v4, v2
    new-instance v2, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;
    invoke-direct v2, v3, v5, v4, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    if-eqz v2, -07ch
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -081h
    check-cast v1, Ljava/util/List;
    move-object v0, v1
    nop 
    return-object v0
    :try_start_0x3
    :try_start_0x91
.end method

.method private final shouldSkipEmptyFinishToolcall(com.bytedance.trae.im.model.ParsedPlanItem)boolean
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +070h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +068h
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->isFinishTool(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +003h
    return v1
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getThought()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    xor-int/2addr v0, v2
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getReasoningContent()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v3, v1
    goto +2h
    move v3, v2
    xor-int/2addr v3, v2
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v6
    if-eqz v6, +02ch
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v6, +026h
    const-string/jumbo v4, summary
    invoke-virtual v6, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +01dh
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    const/4 v6, 0
    if-eqz v6, +013h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +00dh
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v2
    if-ne v6, v2, +004h
    move v6, v2
    goto +2h
    move v6, v1
    if-nez v0, +007h
    if-nez v3, +005h
    if-nez v6, +003h
    move v1, v2
    return v1
.end method

.method public final group(java.util.List  android.content.res.Resources  com.bytedance.trae.conversation.chat.grouping.GroupingContext)java.util.List
    .registers 14
    # ins_size=4
    const-string v0, "planItems"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resources
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "context"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[Node7] Grouper.group: input planItems="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", mainAgentRunId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMainAgentRunId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", messageStatus="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->getMessageStatus()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isHistory="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;->isHistory()Z
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentDataFlow"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v0, v11
    check-cast v0, Ljava/lang/Iterable;
    const/16 v1, 10
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-static v1, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v1
    const/16 v3, 16
    invoke-static v1, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v1
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-direct v3, v1, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v3, Ljava/util/Map;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +015h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, ""
    invoke-interface v3, v5, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -18h
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v4, 0
    move v5, v4
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +025h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    add-int/lit8 v7, v5, 1
    if-gez v5, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    sget-object v8, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->INSTANCE Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;
    invoke-static v11, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v9
    if-ne v5, v9, +004h
    const/4 v5, 1
    goto +2h
    move v5, v4
    invoke-direct v8, v6, v13, v5, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->expandPlanItem(Lcom/bytedance/trae/im/model/ParsedPlanItem; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext; Z)Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-static v1, v5, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    move v5, v7
    goto -28h
    check-cast v1, Ljava/util/List;
    sget-object v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v4, "[Node7] afterExpand: elements="
    invoke-direct v0, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v4, ", types="
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/LinkedHashMap;
    invoke-direct v6, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v6, Ljava/util/Map;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +02bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v8, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v8
    invoke-interface v8, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v8
    invoke-interface v6, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    if-nez v9, +00ch
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/List;
    invoke-interface v6, v8, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v9, Ljava/util/List;
    invoke-interface v9, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2eh
    new-instance v5, Ljava/util/LinkedHashMap;
    invoke-interface v6, Ljava/util/Map;->size()I
    move-result v7
    invoke-static v7, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v7
    invoke-direct v5, v7, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v5, Ljava/util/Map;
    invoke-interface v6, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +01eh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/util/Map$Entry;
    invoke-interface v7, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v8
    invoke-interface v7, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/util/List;
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v7
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v5, v8, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -21h
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v11, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v10, v1, v3, v13, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->applyTodoGrouping(Ljava/util/List; Ljava/util/Map; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v11
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v5, "[Node7] afterTodoGrouping: blocks="
    invoke-direct v1, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object v5, v11
    check-cast v5, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/LinkedHashMap;
    invoke-direct v6, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v6, Ljava/util/Map;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +02bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v8, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v8
    invoke-interface v8, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v8
    invoke-interface v6, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    if-nez v9, +00ch
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/List;
    invoke-interface v6, v8, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v9, Ljava/util/List;
    invoke-interface v9, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2eh
    new-instance v5, Ljava/util/LinkedHashMap;
    invoke-interface v6, Ljava/util/Map;->size()I
    move-result v7
    invoke-static v7, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v7
    invoke-direct v5, v7, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v5, Ljava/util/Map;
    invoke-interface v6, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +01eh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/util/Map$Entry;
    invoke-interface v7, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v8
    invoke-interface v7, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/util/List;
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v7
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v5, v8, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -21h
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v10, v11, v3, v13, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->applySubAgentGrouping(Ljava/util/List; Ljava/util/Map; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v11
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "[Node7] afterSubAgentGrouping: blocks="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object v3, v11
    check-cast v3, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/LinkedHashMap;
    invoke-direct v5, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v5, Ljava/util/Map;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +02bh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v7, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v7
    invoke-interface v7, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v7
    invoke-interface v5, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    if-nez v8, +00ch
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/List;
    invoke-interface v5, v7, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v8, Ljava/util/List;
    invoke-interface v8, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2eh
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-interface v5, Ljava/util/Map;->size()I
    move-result v6
    invoke-static v6, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v6
    invoke-direct v3, v6, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v3, Ljava/util/Map;
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01eh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/Map$Entry;
    invoke-interface v6, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v7
    invoke-interface v6, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/List;
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v6
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v3, v7, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -21h
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v10, v11, v12, v13, Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;->applyToolAggregation(Ljava/util/List; Landroid/content/res/Resources; Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;)Ljava/util/List;
    move-result-object v11
    sget-object v12, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v13, Ljava/lang/StringBuilder;
    const-string v0, "[Node7] afterToolAggregation (FINAL): blocks="
    invoke-direct v13, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v0
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    move-object v0, v11
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-virtual v4, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-static v4, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v4
    invoke-interface v4, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v4
    invoke-interface v1, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    if-nez v5, +00ch
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/List;
    invoke-interface v1, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v5, Ljava/util/List;
    invoke-interface v5, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2eh
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-interface v1, Ljava/util/Map;->size()I
    move-result v3
    invoke-static v3, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v3
    invoke-direct v0, v3, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v0, Ljava/util/Map;
    invoke-interface v1, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map$Entry;
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -21h
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v2, v13, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v11
.end method
