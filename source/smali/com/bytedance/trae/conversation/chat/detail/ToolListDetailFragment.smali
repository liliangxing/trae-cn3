# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;
.super Landroidx/fragment/app/Fragment;
.source "ToolListDetailFragment.kt"

.field private static final ARG_BLOCK_KEY:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment$Companion;
.field private blockKey:Ljava/lang/String;
.field private toolListContainer:Landroid/widget/LinearLayout;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/fragment/app/Fragment;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->blockKey Ljava/lang/String;
    return-void 
.end method

.method private final buildPlanItemContext(java.lang.String)com.bytedance.trae.conversation.chat.toolcall.PlanItemContext
    .registers 15
    # ins_size=2
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v0
    const-string v1, "extra_conversation"
    invoke-virtual v0, v1, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/im/service/Conversation;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/im/service/Conversation;
    goto +2h
    move-object v0, v2
    if-eqz v0, +018h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +012h
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +003h
    goto +19h
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    if-nez v1, +010h
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v1
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getIntent()Landroid/content/Intent;
    move-result-object v1
    const-string v3, "extra_conversation_id"
    invoke-virtual v1, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object v7, v1
    new-instance v1, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    const/4 v5, 0
    const/4 v6, 0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v2
    move-object v8, v2
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 102
    const/4 v12, 0
    move-object v3, v1
    move-object v4, v14
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method private final buildPlanItemContextFromGroup(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)com.bytedance.trae.conversation.chat.toolcall.PlanItemContext
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v2, -00ch
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-nez v4, +004h
    const/4 v4, 0
    return-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->buildPlanItemContext(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v4
    return-object v4
.end method

.method private final renderBlock(com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->toolListContainer Landroid/widget/LinearLayout;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    instance-of v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-eqz v1, +010h
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v1
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->buildPlanItemContextFromGroup(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v3
    invoke-direct v2, v0, v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->renderToolcallList(Landroid/widget/LinearLayout; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    goto +ah
    instance-of v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v1, +007h
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->renderSingleTool(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;)V
    return-void 
.end method

.method private final renderSingleTool(android.widget.LinearLayout  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Toolcall)void
    .registers 14
    # ins_size=3
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getPlanItemId()Ljava/lang/String;
    move-result-object v0
    invoke-direct v11, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->buildPlanItemContext(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v7
    const/4 v8, 0
    const/16 v9, 95
    const/4 v10, 0
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->copy$default(Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v2
    const-string/jumbo v3, requireContext(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v13
    invoke-virtual v1, v2, v13, v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createDetailCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v13
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v13, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->bind(Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v12, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    return-void 
.end method

.method private final renderToolcallList(android.widget.LinearLayout  java.util.List  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 30
    # ins_size=4
    move-object/from16 v0, v26
    move-object/from16 v1, v27
    move-object/from16 v12, v29
    invoke-interface/range v28, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +0efh
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v2, v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    const-string/jumbo v15, requireContext(...)
    if-eqz v2, +062h
    if-eqz v12, +01ah
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    move-object v2, v14
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v8
    const/4 v9, 0
    const/16 v10, 95
    const/4 v11, 0
    move-object/from16 v2, v29
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->copy$default(Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    move-result-object v2
    if-nez v2, +020h
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    move-object v3, v14
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v22
    const/16 v23, 0
    const/16 v24, 95
    const/16 v25, 0
    move-object/from16 v16, v2
    invoke-direct/range v16 ... v25, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v5
    invoke-virtual v3, v4, v5, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createDetailCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->bind(Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -73h
    instance-of v2, v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v2, +05fh
    new-instance v2, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    check-cast v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getPlanItemId()Ljava/lang/String;
    move-result-object v17
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getReasoningContent()Ljava/lang/String;
    move-result-object v23
    const/16 v24, 62
    const/16 v25, 0
    move-object/from16 v16, v2
    invoke-direct/range v16 ... v25, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ConfirmInfo; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->INSTANCE Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v5
    if-nez v5, +017h
    new-instance v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 31
    const/16 v23, 0
    move-object/from16 v16, v5
    invoke-direct/range v16 ... v23, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedToolCallResult; Lcom/google/gson/JsonObject; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v3, v4, v5, v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCardFactory;->createThinkingCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;
    invoke-virtual/range v26, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->bind(Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto/16 -0d3h
    instance-of v2, v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-eqz v2, +00dh
    check-cast v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v2
    invoke-direct v0, v1, v2, v12, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->renderToolcallList(Landroid/widget/LinearLayout; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    goto/16 -0e2h
    instance-of v2, v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v2, -0e6h
    check-cast v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v2
    invoke-direct v0, v1, v2, v12, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->renderToolcallList(Landroid/widget/LinearLayout; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    goto/16 -0f1h
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_tool_list_detail I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/conversation/R$id;->ll_tool_list I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/LinearLayout;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->toolListContainer Landroid/widget/LinearLayout;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    if-eqz v2, +009h
    const-string v3, "block_key"
    invoke-virtual v2, v3, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, ""
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->blockKey Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->blockKey Ljava/lang/String;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;->get(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    move-result-object v2
    if-eqz v2, +005h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;->renderBlock(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method
