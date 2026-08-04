# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "TodoChildAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$Companion;
.field private static final TYPE_PURE_SHOW_WIDGET:I
.field private static final TYPE_SUB_AGENT:I
.field private static final TYPE_SUB_AGENT_WITH_WIDGET:I
.field private static final TYPE_THOUGHT:I
.field private static final TYPE_TOOL:I
.field private final items:Ljava/util/List;
.field private final pureShowWidgetRenderer:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
.field private final subAgentGroupRenderer:Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;


.method public static synthetic $r8$lambda$U9eJIjEyb-nrZAYNW417-g5l18A(com.bytedance.trae.conversation.chat.block.AgentContentBlock  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->onBindViewHolder$lambda$2(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_llcsufHHL1x9Hxcl3adt8fWids(com.bytedance.trae.conversation.chat.block.AgentContentBlock  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->onBindViewHolder$lambda$6(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$spzPqeHfv5be3hzDBtGykLa-ouk(android.view.View)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->onBindViewHolder$lambda$3(Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->items Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->subAgentGroupRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;
    return-void 
.end method

.method private final createArrowRow(android.content.Context  float)android.view.View
    .registers 8
    # ins_size=3
    const/4 v0, 3
    int-to-float v0, v0
    mul-float/2addr v0, v7
    float-to-int v0, v0
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 16
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-virtual v1, v2, v0, v2, v0, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v0, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v0, v3, v4, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v6, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v6, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v0, v6, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v6, 2
    const/high16 v3, 1097859072
    invoke-virtual v0, v6, v3, Landroid/widget/TextView;->setTextSize(I F)V
    const/16 v6, 22
    int-to-float v6, v6
    mul-float/2addr v6, v7
    float-to-int v6, v6
    invoke-static v0, v6, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const v6, -1130650141
    invoke-virtual v0, v6, Landroid/widget/TextView;->setLetterSpacing(F)V
    const/4 v6, 1
    invoke-virtual v0, v6, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v6, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v0, v6, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    const/4 v6, 4
    int-to-float v6, v6
    mul-float/2addr v6, v7
    float-to-int v6, v6
    invoke-virtual v0, v6, Landroid/widget/TextView;->setCompoundDrawablePadding(I)V
    sget v6, Lcom/bytedance/trae/conversation/R$drawable;->chevron_right I
    invoke-virtual v0, v2, v2, v6, v2, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    check-cast v0, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final createSubAgentRow(android.content.Context  float)android.view.View
    .registers 10
    # ins_size=3
    const/4 v0, 3
    int-to-float v0, v0
    mul-float/2addr v0, v9
    float-to-int v0, v0
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v8, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 16
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-virtual v1, v2, v0, v2, v0, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v0, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v0, v4, v5, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v0, v3
    mul-float/2addr v0, v9
    float-to-int v0, v0
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v8, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->agent I
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v0, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v0, 4
    int-to-float v0, v0
    mul-float/2addr v0, v9
    float-to-int v0, v0
    invoke-virtual v4, v0, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v8, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v8, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v3, v8, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v8, 2
    const/high16 v4, 1097859072
    invoke-virtual v3, v8, v4, Landroid/widget/TextView;->setTextSize(I F)V
    const/16 v8, 22
    int-to-float v8, v8
    mul-float/2addr v8, v9
    float-to-int v8, v8
    invoke-static v3, v8, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const v8, -1130650141
    invoke-virtual v3, v8, Landroid/widget/TextView;->setLetterSpacing(F)V
    const/4 v8, 1
    invoke-virtual v3, v8, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v8, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v3, v8, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v3, v0, Landroid/widget/TextView;->setCompoundDrawablePadding(I)V
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->chevron_right I
    invoke-virtual v3, v2, v2, v8, v2, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(I I I I)V
    check-cast v3, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final createThoughtView(android.content.Context  float)android.view.View
    .registers 12
    # ins_size=3
    const/4 v0, 2
    int-to-float v1, v0
    mul-float/2addr v1, v11
    float-to-int v1, v1
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    move-object v2, v8
    move-object v3, v10
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v10, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextColor(I)V
    const/high16 v10, 1097859072
    invoke-virtual v8, v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextSize(I F)V
    move-object v10, v8
    check-cast v10, Landroid/widget/TextView;
    const/16 v0, 22
    int-to-float v0, v0
    mul-float/2addr v0, v11
    float-to-int v11, v0
    invoke-static v10, v11, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const/4 v10, 0
    invoke-virtual v8, v10, v1, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setPadding(I I I I)V
    new-instance v10, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;
    const/4 v11, -1
    const/4 v0, -2
    invoke-direct v10, v11, v0, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(I I)V
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v8, Landroid/view/View;
    return-object v8
.end method

.method private static final onBindViewHolder$lambda$2(com.bytedance.trae.conversation.chat.block.AgentContentBlock  android.view.View)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    instance-of v0, v2, Landroidx/fragment/app/FragmentActivity;
    if-eqz v0, +005h
    check-cast v2, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +010h
    invoke-virtual v2, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    if-nez v2, +003h
    goto +8h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;->showAgentDetail(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    return-void 
.end method

.method private static final onBindViewHolder$lambda$3(android.view.View)void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method private static final onBindViewHolder$lambda$6(com.bytedance.trae.conversation.chat.block.AgentContentBlock  android.view.View)void
    .registers 6
    # ins_size=2
    invoke-virtual v5, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v5
    instance-of v0, v5, Landroidx/fragment/app/FragmentActivity;
    if-eqz v0, +005h
    check-cast v5, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v5, 0
    if-eqz v5, +06fh
    invoke-virtual v5, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v5
    if-nez v5, +003h
    goto +67h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;->showToolList(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getToolcalls()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    instance-of v5, v4, Ljava/util/Collection;
    const/4 v0, 0
    if-eqz v5, +00ch
    move-object v5, v4
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    goto +32h
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +029h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    const-string v2, "TodoWrite"
    const/4 v3, 1
    invoke-static v1, v2, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v1
    if-nez v1, +012h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v1, todo_write
    invoke-static v5, v1, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v0
    goto +2h
    move v5, v3
    if-eqz v5, -02ah
    move v0, v3
    if-eqz v0, +019h
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v0, type
    const-string/jumbo v1, todo
    invoke-virtual v5, v0, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v0, "icube_tab_click"
    invoke-virtual v4, v0, v5, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private final releasePureShowWidgetInlineViews(android.view.View)void
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    if-eqz v0, +008h
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->release()V
    return-void 
    instance-of v0, v5, Landroid/view/ViewGroup;
    if-eqz v0, +01ah
    check-cast v5, Landroid/view/ViewGroup;
    invoke-virtual v5, Landroid/view/ViewGroup;->getChildCount()I
    move-result v0
    const/4 v1, 0
    if-ge v1, v0, +011h
    invoke-virtual v5, v1, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    const-string v3, "getChildAt(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    add-int/lit8 v1, v1, 1
    goto -10h
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public getItemViewType(int)int
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->items Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    if-eqz v0, +004h
    const/4 v2, 0
    goto +1eh
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v0, +014h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getChildren()Ljava/util/List;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->containsPureShowWidget(Ljava/util/List;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 4
    goto +ah
    const/4 v2, 2
    goto +8h
    instance-of v2, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    if-eqz v2, +004h
    const/4 v2, 3
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.chat.block.renderer.TodoChildAdapter$ChildViewHolder  int)void
    .registers 13
    # ins_size=3
    const-string v0, "holder"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->items Ljava/util/List;
    invoke-interface v0, v12, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v0, v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    const/4 v1, 0
    if-eqz v0, +036h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    instance-of v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v2, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    goto +2h
    move-object v0, v1
    if-eqz v0, +00eh
    move-object v2, v12
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;->getThought()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setText(Ljava/lang/CharSequence;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    iget-object v11, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    instance-of v0, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v0, +005h
    move-object v1, v11
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    move-object v4, v1
    check-cast v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;->getThought()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 12
    const/4 v9, 0
    invoke-static/range v3 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    goto/16 +124h
    instance-of v0, v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    const/4 v2, 0
    const-string v3, "null cannot be cast to non-null type android.widget.LinearLayout"
    if-eqz v0, +08bh
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->getItemViewType()I
    move-result v0
    const/4 v4, 4
    if-ne v0, v4, +035h
    iget-object v11, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    invoke-static v11, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/widget/LinearLayout;
    invoke-virtual v11, v2, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v0
    if-nez v0, +020h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->subAgentGroupRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;
    invoke-virtual v11, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v2, "getContext(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v0, v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)Landroid/view/View;
    move-result-object v12
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v12, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    goto +8h
    iget-object v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->subAgentGroupRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;
    check-cast v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v11, v0, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    return-void 
    iget-object v11, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    invoke-static v11, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/widget/LinearLayout;
    const/4 v0, 1
    invoke-virtual v11, v0, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v0
    instance-of v2, v0, Landroid/widget/TextView;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroid/widget/TextView;
    if-eqz v1, +02dh
    move-object v0, v12
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getDescription()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +005h
    check-cast v2, Ljava/lang/CharSequence;
    goto +1dh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getAgentDisplayName()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +006h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    goto +13h
    invoke-virtual v11, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_sub_agent_default I
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v2, "getString(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$$ExternalSyntheticLambda0;
    invoke-direct v0, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    invoke-virtual v11, v0, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    if-eqz v1, +099h
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto/16 +094h
    instance-of v0, v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    const-string v4, ""
    if-eqz v0, +039h
    iget-object v11, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    invoke-static v11, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/widget/LinearLayout;
    invoke-virtual v11, v2, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v0
    instance-of v2, v0, Landroid/widget/TextView;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroid/widget/TextView;
    if-eqz v1, +017h
    check-cast v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v12
    if-eqz v12, +005h
    check-cast v12, Ljava/lang/CharSequence;
    goto +4h
    move-object v12, v4
    check-cast v12, Ljava/lang/CharSequence;
    invoke-virtual v1, v12, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$$ExternalSyntheticLambda1;
    invoke-direct v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$$ExternalSyntheticLambda1;-><init>()V
    invoke-virtual v11, v12, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    if-eqz v1, +05bh
    invoke-virtual v1, v12, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +56h
    instance-of v0, v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-eqz v0, +030h
    iget-object v11, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    invoke-static v11, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/widget/LinearLayout;
    invoke-virtual v11, v2, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v0
    instance-of v2, v0, Landroid/widget/TextView;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroid/widget/TextView;
    if-eqz v1, +00eh
    move-object v0, v12
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getTitle()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$$ExternalSyntheticLambda2;
    invoke-direct v0, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    invoke-virtual v11, v0, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    if-eqz v1, +029h
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +24h
    instance-of v0, v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    if-eqz v0, +011h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    iget-object v11, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    const-string v1, "itemView"
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    invoke-virtual v0, v11, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)V
    goto +11h
    iget-object v11, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    instance-of v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v12, +005h
    move-object v1, v11
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v1, +007h
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.chat.block.renderer.TodoChildAdapter$ChildViewHolder
    .registers 7
    # ins_size=3
    const-string v0, "parent"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-virtual v5, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    if-eqz v6, +05eh
    const/4 v1, 2
    if-eq v6, v1, +04eh
    const/4 v1, 3
    const/4 v2, -2
    const/4 v3, -1
    if-eq v6, v1, +02eh
    const/4 v1, 4
    if-eq v6, v1, +00fh
    new-instance v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->createArrowRow(Landroid/content/Context; F)Landroid/view/View;
    move-result-object v5
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;-><init>(Landroid/view/View;)V
    goto +51h
    new-instance v6, Landroid/widget/LinearLayout;
    invoke-direct v6, v5, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v5, 1
    invoke-virtual v6, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v5, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;
    invoke-direct v5, v3, v2, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v5, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v6, Landroid/view/View;
    new-instance v5, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;-><init>(Landroid/view/View;)V
    move-object v6, v5
    goto +35h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->createContainer$conversation_mainlandRelease(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v5
    new-instance v6, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;
    invoke-direct v6, v3, v2, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v6, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v5, Landroid/view/View;
    new-instance v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;-><init>(Landroid/view/View;)V
    goto +1ah
    new-instance v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->createSubAgentRow(Landroid/content/Context; F)Landroid/view/View;
    move-result-object v5
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;-><init>(Landroid/view/View;)V
    goto +dh
    new-instance v6, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->createThoughtView(Landroid/content/Context; F)Landroid/view/View;
    move-result-object v5
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;-><init>(Landroid/view/View;)V
    return-object v6
.end method

.method public bridge synthetic onViewRecycled(androidx.recyclerview.widget.RecyclerView$ViewHolder)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->onViewRecycled(Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;)V
    return-void 
.end method

.method public onViewRecycled(com.bytedance.trae.conversation.chat.block.renderer.TodoChildAdapter$ChildViewHolder)void
    .registers 5
    # ins_size=2
    const-string v0, "holder"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->getItemViewType()I
    move-result v0
    const/4 v1, 3
    const-string v2, "itemView"
    if-eq v0, v1, +01eh
    const/4 v1, 4
    if-eq v0, v1, +003h
    goto +23h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->releasePureShowWidgetInlineViews(Landroid/view/View;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    instance-of v1, v0, Landroid/view/ViewGroup;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +010h
    invoke-virtual v0, Landroid/view/ViewGroup;->removeAllViews()V
    goto +bh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->pureShowWidgetRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;->itemView Landroid/view/View;
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;->release$conversation_mainlandRelease(Landroid/view/View;)V
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    invoke-super v3, v4, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onViewRecycled(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V
    return-void 
.end method

.method public final submitList(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "list"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->items Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;->notifyDataSetChanged()V
    return-void 
.end method
